package com.lingjun.colliery_android.base;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

/**
 * Created by nefa on 2018/7/24.
 */

public class BaseMyFragmentStatePagerAdapter extends FragmentStatePagerAdapter {

    private List<Fragment> fragments;
    private String[] tabTitle;

    public BaseMyFragmentStatePagerAdapter(FragmentManager fm, List<Fragment> fragments,String[] tabTitle) {
        super(fm);
        this.fragments = fragments;
        this.tabTitle = tabTitle;
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
