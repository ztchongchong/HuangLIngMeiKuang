package com.lingjun.colliery_android.module.dealwith;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.LayoutInflater;

import com.lingjun.colliery_android.R;
import com.lingjun.colliery_android.base.BaseFragment;
import com.lingjun.colliery_android.module.dealwith.fragment.DealWithTaskFragment;
import com.lingjun.colliery_android.module.dealwith.fragment.TaskTrackingFragment;
import com.lingjun.colliery_android.view.NoScrollViewpager;
import com.lingjun.colliery_android.view.tablayout.TabLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * 待办
 * Created by nefa on 2018/10/18.
 */

public class DealWithFragment extends BaseFragment {


    public static String[] tabTitle = new String[1];
    private NoScrollViewpager vp_content;
    private TabLayout tb_title;

    @Override
    protected int setLayout(LayoutInflater inflater) {
        return R.layout.fragment_deal_with;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        vp_content = mRootView.findViewById(R.id.vp_content);
        tb_title = mRootView.findViewById(R.id.tb_title);

        tabTitle[0] = "待办任务";
//        tabTitle[1] = "任务跟踪";

        ArrayList<Fragment> mList = new ArrayList<>();
        DealWithTaskFragment dealWithTaskFragment = new DealWithTaskFragment();
        TaskTrackingFragment taskTrackingFragment = new TaskTrackingFragment();
        mList.add(dealWithTaskFragment);
//        mList.add(taskTrackingFragment);

        CourseDetailsAdapter adapter = new CourseDetailsAdapter(getChildFragmentManager(), mList);
        vp_content.setAdapter(adapter);
        tb_title.setupWithViewPager(vp_content);
        tb_title.setTabMode(TabLayout.MODE_FIXED);
        vp_content.setScroll(false);

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
            return DealWithFragment.tabTitle[position];
        }
    }
}
