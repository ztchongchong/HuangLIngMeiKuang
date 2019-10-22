package com.lingjun.colliery_android.module.dealwith.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.util.Log;

import com.lingjun.colliery_android.R;
import com.lingjun.colliery_android.base.BaseActivity;
import com.lingjun.colliery_android.base.BaseLinkList;
import com.lingjun.colliery_android.bean.PendTaskBean;
import com.lingjun.colliery_android.bean.TaskBean;
import com.lingjun.colliery_android.module.dealwith.fragment.AllTaskFragment;
import com.lingjun.colliery_android.utils.FastJsonTools;
import com.lingjun.colliery_android.utils.retrofit.BaseSubscriber;
import com.lingjun.colliery_android.utils.retrofit.ExceptionHandle;
import com.lingjun.colliery_android.view.tablayout.TabLayout;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * Created by shurrikann on 2018/12/5.
 */

public class AllTaskActivity extends BaseActivity {
    private List<Fragment> fragmentList = new ArrayList<>();
    private TabLayout tabLayout;
    private ViewPager vp_content;
    private List<String> titlelist = new ArrayList<>();
    private String taskid;
    private List<TaskBean.DataBean.ItemmapBean> list = new ArrayList<>();

    @Override
    protected int getResourcesId() {
        return R.layout.activity_all_task;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        taskid = getIntent().getStringExtra("taskid");
        tabLayout = findViewById(R.id.tb_title);
        vp_content = findViewById(R.id.vp_content);

        refreshView();
    }

    private void initView() {

        for (int i = 0; i < list.size(); i++) {
            titlelist.add(i + 1 + "部分");
        }
        for (int i = 0; i < list.size(); i++) {
            AllTaskFragment taskFragment = AllTaskFragment.newInstance(titlelist.get(i), i, list.get(i));
            fragmentList.add(taskFragment);
        }
        for (int i = 0; i < titlelist.size(); i++) {
            tabLayout.addTab(tabLayout.newTab().setText(titlelist.get(i)));
        }
        FragmentPagerAdapter mAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragmentList.get(position);
            }

            @Override
            public int getCount() {
                return fragmentList.size();
            }

            //ViewPager与TabLayout绑定后，这里获取到PageTitle就是Tab的Text
            @Override
            public CharSequence getPageTitle(int position) {
                return titlelist.get(position);
            }
        };
        vp_content.setAdapter(mAdapter);
        tabLayout.setupWithViewPager(vp_content);
        tabLayout.setTabsFromPagerAdapter(mAdapter);
    }

    @Override
    protected BaseRefreshLoadMoreInterface setRefreshLoadMoreListener() {
        return null;
    }

    private void refreshView() {
        HashMap<String, String> hashMap = new HashMap<>();
        if (TextUtils.isEmpty(taskid)) {
            return;
        }
        hashMap.put("taskid", taskid);
        hashMap.put("type", "6");
        hashMap.put("apiurl", BaseLinkList.coal_mine + BaseLinkList.MOBILE_GETSTADCHKNOCHECKITEMLIST);
        mRetrofit.JsonToColliery(BaseLinkList.Base_Url, hashMap, new BaseSubscriber() {
            @Override
            public void onError(ExceptionHandle.ResponeThrowable e) {
                if (null != refreshLayout) {
                    refreshLayout.finishRefresh();
                    refreshLayout.finishLoadMore();
                }
            }

            @Override
            public void onSuccess(JSONObject jsonObject) throws JSONException {
                Log.e("json", jsonObject.toString());
                TaskBean bean = FastJsonTools.getBean(jsonObject.toString(), TaskBean.class);
                if (null != bean) {
                    if (bean.getData().getItemmap().size() != 0) {
                        list = bean.getData().getItemmap();
                        initView();
                    }
                }
            }
        });
        if (null != refreshLayout) {
            refreshLayout.finishLoadMore();
            refreshLayout.finishRefresh();
        }
    }
}
