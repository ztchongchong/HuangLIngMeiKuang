package com.lingjun.colliery_android.module.dealwith.hiddendanger.upervise;

import android.content.Intent;
import android.os.Bundle;

import com.lingjun.colliery_android.view.tablayout.TabLayout;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.blankj.utilcode.util.LogUtils;
import com.lingjun.colliery_android.R;
import com.lingjun.colliery_android.base.BaseActivity;
import com.lingjun.colliery_android.base.BaseLinkList;
import com.lingjun.colliery_android.bean.HiddenDangerDetailsBean;
import com.lingjun.colliery_android.eventbus.MsgEvent;
import com.lingjun.colliery_android.module.dealwith.activity.ReGovernanceActivity;
import com.lingjun.colliery_android.module.dealwith.fragment.AcceptanceFragment;
import com.lingjun.colliery_android.module.dealwith.fragment.FieldSituationFragment;
import com.lingjun.colliery_android.module.dealwith.fragment.NoticeRectificationFragment;
import com.lingjun.colliery_android.module.dealwith.fragment.RectificationSituationFragment;
import com.lingjun.colliery_android.utils.FastJsonTools;
import com.lingjun.colliery_android.utils.retrofit.BaseSubscriber;
import com.lingjun.colliery_android.utils.retrofit.ExceptionHandle;
import com.lingjun.colliery_android.view.NoScrollViewpager;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 作者: lihuan
 * 时间: 2018/11/22 19:55
 * 说明: 督办验收中
 */
public class AcceptanceActivity extends BaseActivity {

    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tb_title)
    TabLayout tb_layout;
    @BindView(R.id.vp_content)
    NoScrollViewpager vp_content;
    @BindView(R.id.btn_inspection_instruction)
    Button btnInspectionInstruction; //重新治理

    private String[] tabTitle;
    private List<String> tab = new ArrayList<>();
    private String taskId = "";
    private String status = "";

    @Override
    protected int getResourcesId() {
        return R.layout.activity_acceptance;
    }

    @Override
    protected BaseRefreshLoadMoreInterface setRefreshLoadMoreListener() {
        return null;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        taskId = getIntent().getStringExtra("taskId");
        String mainTaskId = getIntent().getStringExtra("taskMainId");
        String title = getIntent().getStringExtra("title");
        String taskType = getIntent().getStringExtra("taskType"); //暂未使用 后期需要判断处理
        status = getIntent().getStringExtra("state");

        tvName.setText(title);

        getHiddenDanagerDetailsById(taskId, mainTaskId, status);
    }

    @OnClick(R.id.iv_back)
    public void onIvBackClicked() {
        finish();
    }

    @OnClick(R.id.btn_inspection_instruction)
    public void onBtnInspectionInstructionClicked() {//重新治理
        Intent intent = new Intent(this, ReGovernanceActivity.class);
        intent.putExtra("taskId", taskId);
        startActivity(intent);
    }

    /**
     * 根据id获得某条隐患信息
     */
    private void getHiddenDanagerDetailsById(String taskId, String mainTaskId, final String status) {
        HashMap<String, String> hashMap = new HashMap<>();

        hashMap.put("id", taskId);
        hashMap.put("mainid", mainTaskId);
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
                LogUtils.e("隐患信息限时整改->>" + jsonObject.toString());
                final HiddenDangerDetailsBean dangerDetailsBean = FastJsonTools.getBean(jsonObject.toString(), HiddenDangerDetailsBean.class);

                ArrayList<Fragment> mList = new ArrayList<>();
                tab.clear();
                FieldSituationFragment fieldSituationFragment = FieldSituationFragment.newInstance(dangerDetailsBean);
                NoticeRectificationFragment noticeRectificationFragment = NoticeRectificationFragment.newInstance(dangerDetailsBean);
                RectificationSituationFragment rectificationSituationFragment = RectificationSituationFragment.newInstance(dangerDetailsBean);

                if ("6".equals(status)) { //验收中
                    mList.add(noticeRectificationFragment);
                    mList.add(fieldSituationFragment);
                    mList.add(rectificationSituationFragment);
                    tab.add("整改通知书");
                    tab.add("现场情况");
                    tab.add("整改情况");
                } else if ("8".equals(status)) { //待销号
                    AcceptanceFragment acceptanceFragment = AcceptanceFragment.newInstance(dangerDetailsBean);
                    mList.add(noticeRectificationFragment);
                    mList.add(fieldSituationFragment);
                    mList.add(rectificationSituationFragment);
                    mList.add(acceptanceFragment);
                    tab.add("整改通知书");
                    tab.add("现场情况");
                    tab.add("整改情况");
                    tab.add("验收情况");
                }

                tabTitle = new String[tab.size()];
                tab.toArray(tabTitle);

                CourseDetailsAdapter adapter = new CourseDetailsAdapter(getSupportFragmentManager(), mList);
                vp_content.setAdapter(adapter);
                tb_layout.setupWithViewPager(vp_content);
                tb_layout.setTabMode(TabLayout.MODE_FIXED);
                vp_content.setScroll(false);
            }
        });
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

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void rejectSuccess(MsgEvent.RejectCommitSuccess messageEvent) {
        finish();
    }

}
