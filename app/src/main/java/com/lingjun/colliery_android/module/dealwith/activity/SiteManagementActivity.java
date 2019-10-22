package com.lingjun.colliery_android.module.dealwith.activity;

import android.content.Intent;
import android.os.Bundle;

import com.lingjun.colliery_android.view.tablayout.TabLayout;

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
import com.lingjun.colliery_android.module.dealwith.fragment.GovernanceShemeFragment;
import com.lingjun.colliery_android.module.dealwith.fragment.PunishmentSchemeFragment;
import com.lingjun.colliery_android.utils.FastJsonTools;
import com.lingjun.colliery_android.utils.retrofit.BaseSubscriber;
import com.lingjun.colliery_android.utils.retrofit.ExceptionHandle;
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
 * 时间: 2018/11/17 13:19
 * 说明: 现场治理（待审核）
 */
public class SiteManagementActivity extends BaseActivity {

    public static String[] tabTitle = new String[3];
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tb_title)
    TabLayout tb_layout;
    @BindView(R.id.vp_content)
    NoScrollViewpager vp_content;
    @BindView(R.id.btn_reject)
    Button btnReject;
    @BindView(R.id.btn_pass)
    Button btnPass;

    private String taskId = "";

    @Override
    protected int getResourcesId() {
        return R.layout.activity_site_management;
    }

    @Override
    protected void init(Bundle savedInstanceState) {

        tabTitle[0] = "现场情况";
        tabTitle[1] = "处罚方案";
        tabTitle[2] = "治理方案";

        taskId = getIntent().getStringExtra("taskId");
        String mainTaskId = getIntent().getStringExtra("mainTaskId");

        showLoadDialog();
        getHiddenDanagerDetailsById(taskId, mainTaskId);

    }

    /**
     * 根据id获得某条隐患信息
     */
    private void getHiddenDanagerDetailsById(String id, String mainId) {
        HashMap<String, String> hashMap = new HashMap<>();

        hashMap.put("id", id);
        hashMap.put("mainid", mainId);
        hashMap.put(BaseLinkList.apiurl, BaseLinkList.coal_mine + BaseLinkList.troubleinfo);
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
                dismissDialog();
                LogUtils.e("隐患信息现场治理->>" + jsonObject.toString());
                final HiddenDangerDetailsBean dangerDetailsBean = FastJsonTools.getBean(jsonObject.toString(), HiddenDangerDetailsBean.class);
                ArrayList<Fragment> mList = new ArrayList<>();
                FieldSituationFragment fieldSituationFragment = FieldSituationFragment.newInstance(dangerDetailsBean);
                PunishmentSchemeFragment punishmentSchemeFragment = PunishmentSchemeFragment.newInstance(dangerDetailsBean);
                GovernanceShemeFragment governanceShemeFragment = GovernanceShemeFragment.newInstance(dangerDetailsBean);
                mList.add(fieldSituationFragment);
                mList.add(punishmentSchemeFragment);
                mList.add(governanceShemeFragment);

                CourseDetailsAdapter adapter = new CourseDetailsAdapter(getSupportFragmentManager(), mList);
                vp_content.setAdapter(adapter);
                tb_layout.setupWithViewPager(vp_content);
                tb_layout.setTabMode(TabLayout.MODE_FIXED);
                vp_content.setScroll(false);
            }
        });
    }

    @Override
    protected BaseRefreshLoadMoreInterface setRefreshLoadMoreListener() {
        return null;
    }

    @OnClick(R.id.iv_back)
    public void onIvBackClicked() {
        finish();
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
        showLoadDialog();
        getTODOCurrButton(taskId);
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
     * 待办现场治理待审核通过
     */
    private void getTODOCurrButton(String taskId) {
        HashMap<String, String> hashMap = new HashMap<>();

        hashMap.put("taskId", taskId);
        hashMap.put("approveState", "2");
        hashMap.put(BaseLinkList.apiurl, BaseLinkList.coal_mine + BaseLinkList.getTODOCurrButton);
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
                dismissDialog();
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
