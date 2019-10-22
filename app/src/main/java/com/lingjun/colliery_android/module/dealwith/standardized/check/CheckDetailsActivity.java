package com.lingjun.colliery_android.module.dealwith.standardized.check;

import android.os.Bundle;

import com.lingjun.colliery_android.view.tablayout.TabLayout;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;

import com.lingjun.colliery_android.R;
import com.lingjun.colliery_android.base.BaseActivity;
import com.lingjun.colliery_android.module.dealwith.standardized.check.fragment.CheckRequirementsFragment;
import com.lingjun.colliery_android.module.dealwith.standardized.check.fragment.StandardizedDataFragment;
import com.lingjun.colliery_android.module.dealwith.standardized.review.fragment.PersonnelDetailsFragment;
import com.lingjun.colliery_android.view.NoScrollViewpager;

import java.util.ArrayList;
import java.util.List;

/**
 * 职责分工
 * Created by nefa on 2018/11/13.
 */

public class CheckDetailsActivity extends BaseActivity {

    private TabLayout tb_title;
    private NoScrollViewpager vp_content;

    @Override
    protected int getResourcesId() {
        return R.layout.activity_check_details;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        tb_title = findViewById(R.id.tb_title);
        vp_content = findViewById(R.id.vp_content);
        vp_content.setScroll(true);
        refreshView();
    }

    @Override
    protected BaseRefreshLoadMoreInterface setRefreshLoadMoreListener() {
        return null;
    }

    //刷新View
    private void refreshView() {
        ArrayList<Fragment> mFragments = new ArrayList<>();
        mFragments.add(new CheckRequirementsFragment());
        mFragments.add(new StandardizedDataFragment());
        //mFragments.add(new PersonnelDetailsFragment());

        ArrayList<String> mTitle = new ArrayList<>();
        mTitle.add("检查要求");
        mTitle.add("标化资料");
        mTitle.add("项目评分");

        CourseDetailsAdapter mAdapter = new CourseDetailsAdapter(getSupportFragmentManager(), mFragments, mTitle);
        vp_content.setAdapter(mAdapter);
        tb_title.setupWithViewPager(vp_content);
        tb_title.setTabMode(TabLayout.MODE_FIXED);

        if (null != refreshLayout) {
            refreshLayout.finishLoadMore();
            refreshLayout.finishRefresh();
        }

    }

    class CourseDetailsAdapter extends FragmentStatePagerAdapter {
        private List<Fragment> fragments;
        private ArrayList<String> mTitles;

        public CourseDetailsAdapter(FragmentManager fm, List<Fragment> fragments, ArrayList<String> mTitles) {
            super(fm);
            this.fragments = fragments;
            this.mTitles = mTitles;
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
            return mTitles.get(position);
        }
    }
}
