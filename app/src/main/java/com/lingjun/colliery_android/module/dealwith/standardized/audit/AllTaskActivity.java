package com.lingjun.colliery_android.module.dealwith.standardized.audit;

import android.os.Bundle;

import com.lingjun.colliery_android.view.tablayout.TabLayout;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;

import com.lingjun.colliery_android.R;
import com.lingjun.colliery_android.base.BaseActivity;
import com.lingjun.colliery_android.module.dealwith.standardized.fragment.TaskFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * 全部任务
 * Created by nefa on 2018/10/31.
 */

public class AllTaskActivity extends BaseActivity {

    private TabLayout tb_title;
    private ViewPager vp_content;
    private static final String[] tabTitle = {"1部分", "2部分", "3部分", "4部分", "5部分"};

    @Override
    protected int getResourcesId() {
        return R.layout.activity_all_task;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        tb_title = findViewById(R.id.tb_title);
        vp_content = findViewById(R.id.vp_content);

        ArrayList<Fragment> mList = new ArrayList<>();

        for (int i = 0; i < tabTitle.length; i++) {
            mList.add(new TaskFragment());
        }

        CourseDetailsAdapter adapter = new CourseDetailsAdapter(getSupportFragmentManager(), mList);
        vp_content.setAdapter(adapter);
        tb_title.setupWithViewPager(vp_content);
        tb_title.setTabMode(TabLayout.MODE_FIXED);


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
            return AllTaskActivity.tabTitle[position];
        }
    }
}
