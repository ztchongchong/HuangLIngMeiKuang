package com.lingjun.colliery_android.module.main.rectifyingviolations;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.View;
import android.widget.TextView;

import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lingjun.colliery_android.R;
import com.lingjun.colliery_android.base.BaseActivity;
import com.lingjun.colliery_android.base.BaseLinkList;
import com.lingjun.colliery_android.base.OnGlobalListener;
import com.lingjun.colliery_android.bean.HiddenDangerDetailsBean;
import com.lingjun.colliery_android.bean.RiskTrackingBean;
import com.lingjun.colliery_android.bean.RiskTrackingsBean;
import com.lingjun.colliery_android.module.dealwith.fragment.FieldSituationFragment;
import com.lingjun.colliery_android.module.main.rectifyingviolations.fragment.CorrectingSalesNumbersFragment;
import com.lingjun.colliery_android.module.main.rectifyingviolations.fragment.RectificationAndHandlingFragment;
import com.lingjun.colliery_android.module.main.rectifyingviolations.fragment.RiskSceneFragment;
import com.lingjun.colliery_android.module.main.rectifyingviolations.fragment.RiskTrackingFragment;
import com.lingjun.colliery_android.utils.FastJsonTools;
import com.lingjun.colliery_android.utils.RecyclerViewUtils;
import com.lingjun.colliery_android.utils.retrofit.BaseSubscriber;
import com.lingjun.colliery_android.utils.retrofit.ExceptionHandle;
import com.lingjun.colliery_android.view.NoScrollViewpager;
import com.lingjun.colliery_android.view.tablayout.TabLayout;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;

/**
 * 作者: zengtao
 * 时间: 2019/5/5  11:17.
 * 注释:  风险跟踪Tab
 */
public class RiskTrackingsActivity extends BaseActivity {

    @BindView(R.id.tb_title)
    TabLayout tb_title;
    @BindView(R.id.vp_content)
    NoScrollViewpager vp_content;

    public static String[] tabTitle = new String[2];

    private String id;

    @Override
    protected int getResourcesId() {
        return R.layout.activity_risktrackings;
    }

    @Override
    protected void init(Bundle savedInstanceState) throws PackageManager.NameNotFoundException {
        id = getIntent().getStringExtra("id");


        refreshView();
    }

    private void refreshView() {
        LogUtils.e("当前第" + pageIndex + "页");

        HashMap<String, String> hashMap = new HashMap<>();

        hashMap.put("RiskTroubleId", id);
        hashMap.put(BaseLinkList.apiurl, BaseLinkList.coal_mine + BaseLinkList.getTroubleRisk);

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
                LogUtils.e("列表->>" + jsonObject.toString());

                final RiskTrackingsBean riskTrackingsBean = FastJsonTools.getBean(jsonObject.toString(), RiskTrackingsBean.class);
                if (null != riskTrackingsBean && null != riskTrackingsBean.getMsg() && null != riskTrackingsBean.getCode()) {
                    tabTitle[0] = "管控落实";
                    tabTitle[1] = "现场情况";
                    ArrayList<Fragment> mList = new ArrayList<>();
                    RiskTrackingFragment riskTrackingFragment = RiskTrackingFragment.newInstance(riskTrackingsBean);
                    RiskSceneFragment riskSceneFragment = RiskSceneFragment.newInstance(riskTrackingsBean);
                    mList.add(riskTrackingFragment);
                    mList.add(riskSceneFragment);

                    CourseDetailsAdapter adapter = new CourseDetailsAdapter(getSupportFragmentManager(), mList);
                    vp_content.setAdapter(adapter);
                    tb_title.setupWithViewPager(vp_content);
                    tb_title.setTabMode(TabLayout.MODE_FIXED);
                    vp_content.setScroll(false);
                }
            }
        });
    }

    @Override
    protected BaseRefreshLoadMoreInterface setRefreshLoadMoreListener() {
        return null;
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
            return RiskTrackingsActivity.tabTitle[position];
        }
    }
}
