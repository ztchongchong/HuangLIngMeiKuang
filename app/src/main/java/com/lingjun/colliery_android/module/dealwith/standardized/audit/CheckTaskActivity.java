package com.lingjun.colliery_android.module.dealwith.standardized.audit;

import android.os.Bundle;

import com.lingjun.colliery_android.base.BaseLinkList;
import com.lingjun.colliery_android.bean.TaskBean;
import com.lingjun.colliery_android.module.dealwith.fragment.ZeroTaskFragment;
import com.lingjun.colliery_android.utils.FastJsonTools;
import com.lingjun.colliery_android.utils.retrofit.BaseSubscriber;
import com.lingjun.colliery_android.utils.retrofit.ExceptionHandle;
import com.lingjun.colliery_android.view.tablayout.TabLayout;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;

import com.lingjun.colliery_android.R;
import com.lingjun.colliery_android.base.BaseActivity;
import com.lingjun.colliery_android.module.dealwith.standardized.fragment.CheckTaskFragment;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 需检查任务
 * Created by nefa on 2018/10/31.
 */

public class CheckTaskActivity extends BaseActivity {

    private TabLayout tb_title;
    private ViewPager vp_content;
    private String type;
    private String taskid;
    private List<TaskBean.DataBean.ItemmapBean> fragmentlist = new ArrayList<>();
    private List<String> titlelist = new ArrayList<>();
    private List<Fragment> fragmentList = new ArrayList<>();
    @Override
    protected int getResourcesId() {
        return R.layout.activity_check_task;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        type = getIntent().getStringExtra("type");
        taskid = getIntent().getStringExtra("taskid");
        tb_title = findViewById(R.id.tb_title);
        vp_content = findViewById(R.id.vp_content);
        GetTaskList();
//        ArrayList<Fragment> mList = new ArrayList<>();
//
//        for (int i = 0; i < tabTitle.length; i++) {
//            mList.add(new CheckTaskFragment());
//        }
//
//        CourseDetailsAdapter adapter = new CourseDetailsAdapter(getSupportFragmentManager(), mList);
//        vp_content.setAdapter(adapter);
//        tb_title.setupWithViewPager(vp_content);
//        tb_title.setTabMode(TabLayout.MODE_FIXED);

    }

    private void GetTaskList() {
        showLoadDialog();
        HashMap<String, String> hashMap = new HashMap<>();
        if (TextUtils.isEmpty(taskid)) {
            return;
        }
        hashMap.put("taskid", taskid);
        hashMap.put("type", type);
        hashMap.put("apiurl", BaseLinkList.coal_mine + BaseLinkList.MOBILE_GETSTADCHKNOCHECKITEMLIST);
        mRetrofit.JsonToColliery(BaseLinkList.Base_Url, hashMap, new BaseSubscriber() {
            @Override
            public void onError(ExceptionHandle.ResponeThrowable e) {
                dismissDialog();
            }

            @Override
            public void onSuccess(JSONObject jsonObject) throws JSONException {
                dismissDialog();
                TaskBean bean = FastJsonTools.getBean(jsonObject.toString(), TaskBean.class);
                if (null != bean) {
                    if (bean.getData().getItemmap().size() != 0) {
                        fragmentlist = bean.getData().getItemmap();
                        initView();
                    }
                }
            }
        });
    }

    @Override
    protected BaseRefreshLoadMoreInterface setRefreshLoadMoreListener() {
        return null;
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
//            return CheckTaskActivity.tabTitle[position];
//        }
//    }

    private void initView() {
        for (int i = 0; i < fragmentlist.size(); i++) {
            titlelist.add(i + 1 + "部分");
        }
        for (int i = 0; i < fragmentlist.size(); i++) {
            ZeroTaskFragment taskFragment = ZeroTaskFragment.newInstance(titlelist.get(i), i,fragmentlist.get(i));
            fragmentList.add(taskFragment);
        }
        for (int i = 0; i < titlelist.size(); i++) {
            tb_title.addTab(tb_title.newTab().setText(titlelist.get(i)));
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
        tb_title.setupWithViewPager(vp_content);
        tb_title.setTabsFromPagerAdapter(mAdapter);
    }
}
