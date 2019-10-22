package com.lingjun.colliery_android.module.main.rectifyingviolations;

import android.content.Intent;
import android.os.Bundle;

import com.lingjun.colliery_android.view.tablayout.TabLayout;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.lingjun.colliery_android.R;
import com.lingjun.colliery_android.base.BaseActivity;
import com.lingjun.colliery_android.module.main.rectifyingviolations.fragment.RectifyingViolationsFragment;
import com.lingjun.colliery_android.utils.PhotoPopupManager;

import java.util.ArrayList;
import java.util.List;

/**
 * 三违录入
 * Created by nefa on 2018/11/14.
 */

public class RectifyingViolationsActivity extends BaseActivity {

    private TabLayout tb_title;
    private ViewPager vp_content;
    private ArrayList<String> strArray = new ArrayList<>();

    @Override
    protected int getResourcesId() {
        return R.layout.activity_rectifying_violations;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        tb_title = findViewById(R.id.tb_title);
        vp_content = findViewById(R.id.vp_content);
        tb_title.setVisibility(View.GONE);
        refreshView();
    }

    @Override
    protected BaseRefreshLoadMoreInterface setRefreshLoadMoreListener() {
        return null;
    }

    //刷新
    private void refreshView() {
        ArrayList<Fragment> mList = new ArrayList<>();

        strArray.add("三违信息");
        mList.add(new RectifyingViolationsFragment());

        CourseDetailsAdapter adapter = new CourseDetailsAdapter(getSupportFragmentManager(), mList, strArray);
        vp_content.setAdapter(adapter);
        vp_content.setOffscreenPageLimit(3);
        tb_title.setupWithViewPager(vp_content);
        tb_title.setTabMode(TabLayout.MODE_FIXED);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        PhotoPopupManager.getInstance().onActivityResulted(RectifyingViolationsActivity.this, requestCode, resultCode, data);
    }

    class CourseDetailsAdapter extends FragmentStatePagerAdapter {
        private List<Fragment> fragments;
        private ArrayList<String> strArray;

        public CourseDetailsAdapter(FragmentManager fm, List<Fragment> fragments, ArrayList<String> strArray) {
            super(fm);
            this.fragments = fragments;
            this.strArray = strArray;
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
            return strArray.get(position);
        }

    }
}
