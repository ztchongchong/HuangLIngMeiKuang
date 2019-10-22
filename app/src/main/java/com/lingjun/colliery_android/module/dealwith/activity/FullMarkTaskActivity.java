package com.lingjun.colliery_android.module.dealwith.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.lingjun.colliery_android.R;
import com.lingjun.colliery_android.base.BaseActivity;
import com.lingjun.colliery_android.module.dealwith.fragment.FullMarkTaskFragment;
import com.lingjun.colliery_android.module.dealwith.fragment.ZeroTaskFragment;
import com.lingjun.colliery_android.view.tablayout.TabLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shurrikann on 2018/12/5.
 */

public class FullMarkTaskActivity extends BaseActivity {
    private List<Fragment> fragmentList = new ArrayList<>();
    private TabLayout tabLayout;
    private ViewPager vp_content;
    private List<String> titlelist = new ArrayList<>();

    @Override
    protected int getResourcesId() {
        return R.layout.activity_all_task;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        tabLayout = findViewById(R.id.tb_title);
        vp_content = findViewById(R.id.vp_content);
        initView();
    }

    private void initView() {
        for (int i = 0; i < 10; i++) {
            titlelist.add(i + 1 + "部分");
        }
        for (int i = 0; i < titlelist.size(); i++) {
            FullMarkTaskFragment taskFragment = FullMarkTaskFragment.newInstance(titlelist.get(i), i);
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
}
