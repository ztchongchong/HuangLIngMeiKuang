package com.lingjun.colliery_android.module.dealwith.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.widget.Button;
import android.widget.ImageView;

import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.lingjun.colliery_android.R;
import com.lingjun.colliery_android.base.BaseActivity;
import com.lingjun.colliery_android.base.BaseLinkList;
import com.lingjun.colliery_android.bean.HiddenDangerDetailsBean;
import com.lingjun.colliery_android.bean.Result;
import com.lingjun.colliery_android.eventbus.MsgEvent;
import com.lingjun.colliery_android.module.dealwith.fragment.FieldSituationFragment;
import com.lingjun.colliery_android.module.dealwith.fragment.PrePlanMeasuresFragment;
import com.lingjun.colliery_android.module.dealwith.fragment.ResponsibilityContentFragment;
import com.lingjun.colliery_android.module.dealwith.fragment.SchemeDescriptionFragment;
import com.lingjun.colliery_android.utils.FastJsonTools;
import com.lingjun.colliery_android.utils.retrofit.BaseSubscriber;
import com.lingjun.colliery_android.utils.retrofit.ExceptionHandle;
import com.lingjun.colliery_android.view.MyRadioGroup;
import com.lingjun.colliery_android.view.NoScrollViewpager;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 作者: lihuan
 * 时间: 2018/11/20 11:37
 * 说明: 重大隐患
 */
public class MajorHiddenDangerActivity extends BaseActivity implements MyRadioGroup.OnCheckedChangeListener {

    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.mrg_category)
    MyRadioGroup mrgCategory;
    @BindView(R.id.vp_content)
    NoScrollViewpager vp_content;
    @BindView(R.id.btn_reject)
    Button btnReject;
    @BindView(R.id.btn_pass)
    Button btnPass;

    private String taskId = "";

    private String[] tabTitle = {"方案简述", "现场情况", "责任内容", "治理方案", "预案措施", "资金方案"};

    @Override
    protected int getResourcesId() {
        return R.layout.activity_major_hidden_danger_s;
    }

    @Override
    protected BaseRefreshLoadMoreInterface setRefreshLoadMoreListener() {
        return null;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        taskId = getIntent().getStringExtra("taskId");
        String mainTaskId = getIntent().getStringExtra("mainTaskId");

        mrgCategory.setOnCheckedChangeListener(this);
        showLoadDialog();
        getHiddenDanagerDetailsById(taskId, mainTaskId);
    }

    @OnClick(R.id.iv_back)
    public void onViewClicked() {
        finish();
    }

    /**
     * 根据id获得某条隐患信息
     */
    private void getHiddenDanagerDetailsById(String taskId, String mainTaskId) {
        HashMap<String, String> hashMap = new HashMap<>();

        hashMap.put("id", taskId);
        hashMap.put("mainid", mainTaskId);
        hashMap.put(BaseLinkList.apiurl, BaseLinkList.coal_mine + BaseLinkList.risktodotask);
        mRetrofit.JsonToColliery(BaseLinkList.Base_Url, hashMap, new BaseSubscriber() {
            @Override
            public void onError(ExceptionHandle.ResponeThrowable e) {
                if (null != refreshLayout) {
                    refreshLayout.finishRefresh();
                    refreshLayout.finishLoadMore();
                }
                dismissDialog();
            }

            @Override
            public void onSuccess(JSONObject jsonObject) {
                LogUtils.e("隐患信息限时整改->>" + jsonObject.toString());
                dismissDialog();
                final HiddenDangerDetailsBean dangerDetailsBean = FastJsonTools.getBean(jsonObject.toString(), HiddenDangerDetailsBean.class);

                ArrayList<Fragment> mList = new ArrayList<>();
                SchemeDescriptionFragment schemeDescriptionFragment = SchemeDescriptionFragment.newInstance(dangerDetailsBean);
                FieldSituationFragment fieldSituationFragment = FieldSituationFragment.newInstance(dangerDetailsBean);
                ResponsibilityContentFragment responsibilityContentFragment = ResponsibilityContentFragment.newInstance(dangerDetailsBean);
                PrePlanMeasuresFragment prePlanMeasuresFragment = PrePlanMeasuresFragment.newInstance(dangerDetailsBean, 0);
                PrePlanMeasuresFragment prePlanMeasuresFragment2 = PrePlanMeasuresFragment.newInstance(dangerDetailsBean, 1);
                PrePlanMeasuresFragment prePlanMeasuresFragment3 = PrePlanMeasuresFragment.newInstance(dangerDetailsBean, 2);

                mList.add(schemeDescriptionFragment);
                mList.add(fieldSituationFragment);
                mList.add(responsibilityContentFragment);
                mList.add(prePlanMeasuresFragment);
                mList.add(prePlanMeasuresFragment2);
                mList.add(prePlanMeasuresFragment3);

                CourseDetailsAdapter adapter = new CourseDetailsAdapter(getSupportFragmentManager(), mList);
                vp_content.setAdapter(adapter);
                vp_content.setScroll(false);
            }
        });
    }

    @Override
    public void onCheckedChanged(MyRadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.rb_1:
                vp_content.setCurrentItem(0);
                break;
            case R.id.rb_2:
                vp_content.setCurrentItem(1);
                break;
            case R.id.rb_3:
                vp_content.setCurrentItem(2);
                break;
            case R.id.rb_4:
                vp_content.setCurrentItem(3);
                break;
            case R.id.rb_5:
                vp_content.setCurrentItem(4);
                break;
            case R.id.rb_6:
                vp_content.setCurrentItem(5);
                break;
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void rejectSuccess(MsgEvent.RejectCommitSuccess messageEvent) {
        finish();
    }

    @OnClick(R.id.btn_reject)
    public void onBtnRejectClicked() { //驳回
        Intent intent = new Intent(this, RejectCommitActivity.class);
        intent.putExtra("taskId", taskId);
        startActivity(intent);
    }

    @OnClick(R.id.btn_pass)
    public void onBtnPassClicked() { //通过
        getFatalInfoButton(taskId);
    }

    class CourseDetailsAdapter extends FragmentStatePagerAdapter {
        private List<Fragment> fragments;

        public CourseDetailsAdapter(FragmentManager fm, List<Fragment> fragments) {
            super(fm);
            this.fragments = fragments;
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return tabTitle[position];
        }
    }


    /**
     * 重大隐患通过接口
     */
    private void getFatalInfoButton(String taskId) {
        HashMap<String, String> hashMap = new HashMap<>();

        hashMap.put("taskId", taskId);
        hashMap.put("approveState", "2");
        hashMap.put(BaseLinkList.apiurl, BaseLinkList.coal_mine + BaseLinkList.getFatalInfoButton);
        mRetrofit.JsonToColliery(BaseLinkList.Base_Url, hashMap, new BaseSubscriber() {
            @Override
            public void onError(ExceptionHandle.ResponeThrowable e) {
                if (null != refreshLayout) {
                    refreshLayout.finishRefresh();
                    refreshLayout.finishLoadMore();
                }
            }

            @Override
            public void onSuccess(JSONObject jsonObject) {
                LogUtils.e("重大隐患通过->>" + jsonObject.toString());
                Result result = FastJsonTools.getBean(jsonObject.toString(), Result.class);
                ToastUtils.showShort(result.getMsg());
                if ("200".equals(result.getCode())) {
                    EventBus.getDefault().post(new MsgEvent.RejectCommitSuccess());
                }
            }
        });
    }
}
