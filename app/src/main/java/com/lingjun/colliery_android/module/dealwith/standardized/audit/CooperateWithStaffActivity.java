package com.lingjun.colliery_android.module.dealwith.standardized.audit;

import android.os.Bundle;

import com.lingjun.colliery_android.base.BaseLinkList;
import com.lingjun.colliery_android.bean.PeiHeBean;
import com.lingjun.colliery_android.bean.TeYaoBean;
import com.lingjun.colliery_android.module.dealwith.adapter.TeYaoAdapter;
import com.lingjun.colliery_android.module.dealwith.fragment.PeiHeTaskFragment;
import com.lingjun.colliery_android.module.dealwith.fragment.TeYaoTaskFragment;
import com.lingjun.colliery_android.module.dealwith.myinterface.ListviewInterface;
import com.lingjun.colliery_android.utils.FastJsonTools;
import com.lingjun.colliery_android.utils.retrofit.BaseSubscriber;
import com.lingjun.colliery_android.utils.retrofit.ExceptionHandle;
import com.lingjun.colliery_android.view.tablayout.TabLayout;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;

import com.lingjun.colliery_android.R;
import com.lingjun.colliery_android.base.BaseActivity;
import com.lingjun.colliery_android.module.dealwith.standardized.fragment.CooperateWithStaffFragment;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;

/**
 * 配合人员
 * Created by nefa on 2018/10/31.
 */

public class CooperateWithStaffActivity extends BaseActivity implements ListviewInterface {

    private TabLayout tb_title;
    private String taskid;
    @BindView(R.id.recy)
    RecyclerView recy;
    private List<PeiHeBean.DataBean.MapBean> fragmentlist = new ArrayList<>();
    TeYaoAdapter adapter;

    @Override
    protected int getResourcesId() {
        return R.layout.activity_cooperate_with_staff;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        taskid = getIntent().getStringExtra("taskid");
//        tb_title.setTabMode(TabLayout.MODE_FIXED);
        initAdapter();
    }

    @Override
    protected BaseRefreshLoadMoreInterface setRefreshLoadMoreListener() {
        return new BaseRefreshLoadMoreInterface() {
            @Override
            public void onLoadMore() {
                refreshView();
            }

            @Override
            public void onRefresh() {
                refreshView();
            }
        };
    }


    private void initAdapter() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(CooperateWithStaffActivity.this);
        linearLayoutManager.setAutoMeasureEnabled(true);
        adapter = new TeYaoAdapter(R.layout.item_responsible, 1,this);
        recy.setLayoutManager(linearLayoutManager);
        recy.setAdapter(adapter);
//        adapter.setNewData(bean.getMap());
    }

    private void refreshView() {
        HashMap<String, String> hashMap = new HashMap<>();
        if (TextUtils.isEmpty(taskid)) {
            return;
        }
        hashMap.put("taskid", taskid);
        hashMap.put("apiurl",BaseLinkList.coal_mine+ BaseLinkList.MOBILE_GETSTADCHKCOOPERATORLIST);
        mRetrofit.JsonToColliery(BaseLinkList.Base_Url , hashMap, new BaseSubscriber() {
            @Override
            public void onError(ExceptionHandle.ResponeThrowable e) {
                if (null != refreshLayout) {
                    refreshLayout.finishRefresh();
                    refreshLayout.finishLoadMore();
                }
            }

            @Override
            public void onSuccess(JSONObject jsonObject) throws JSONException {
                Log.d("json", jsonObject.toString());
                PeiHeBean bean = FastJsonTools.getBean(jsonObject.toString(), PeiHeBean.class);
                if (null != bean) {
                    if (bean.getData().getMap().size() != 0) {
                        fragmentlist = bean.getData().getMap();
//                        initView();
                        adapter.setNewData(fragmentlist);
                    }
                }
            }
        });
        if (null != refreshLayout) {
            refreshLayout.finishRefresh();
            refreshLayout.finishLoadMore();
        }
    }

    @Override
    public void btnClick(View v, int pos, boolean type) {
        fragmentlist.get(pos).setState(!type);
        adapter.notifyItemChanged(pos);
    }

    @Override
    public void btnsClick(View v, int pos, int state, boolean type) {

    }

    @Override
    public void btnsClicks(View v, int pos, boolean state, int type) {

    }


//    class CourseDetailsAdapter extends FragmentStatePagerAdapter {
//        private List<Fragment> fragments;
//
//        public CourseDetailsAdapter(FragmentManager fm, List<Fragment> fragments) {
//            super(fm);
//            this.fragments = fragments;
//        }
//
//        @Override
//        public Fragment getItem(int position) {
//            return fragments.get(position);
//        }
//
//        @Override
//        public int getCount() {
//            return fragments.size();
//        }
//
//        @Override
//        public CharSequence getPageTitle(int position) {
//            return CooperateWithStaffActivity.tabTitle[position];
//        }
//    }
}
