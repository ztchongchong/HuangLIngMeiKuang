package com.lingjun.colliery_android.module.dealwith.hiddendanger.activity;

import android.content.Intent;
import android.os.Bundle;

import com.lingjun.colliery_android.module.dealwith.fragment.FieldSituationFragment;
import com.lingjun.colliery_android.module.main.rectifyingviolations.fragment.HiddenTroubleSceneFragment;
import com.lingjun.colliery_android.view.tablayout.TabLayout;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.lingjun.colliery_android.R;
import com.lingjun.colliery_android.base.BaseActivity;
import com.lingjun.colliery_android.module.dealwith.hiddendanger.fragment.FieldManagementFragmentBH;
import com.lingjun.colliery_android.module.dealwith.hiddendanger.fragment.FieldManagementFragmentCC;
import com.lingjun.colliery_android.module.dealwith.hiddendanger.fragment.FieldManagementFragmentSH;
import com.lingjun.colliery_android.module.dealwith.hiddendanger.fragment.FieldSituationFragmentBH;
import com.lingjun.colliery_android.module.dealwith.hiddendanger.fragment.FieldSituationFragmentCC;
import com.lingjun.colliery_android.module.dealwith.hiddendanger.fragment.FieldSituationFragmentSH;
import com.lingjun.colliery_android.view.NoScrollViewpager;

import java.util.ArrayList;
import java.util.List;

/**
 * 现场治理
 */
public class FieldManagementActivity extends BaseActivity {
    public static String[] tabTitle = new String[2];
    private NoScrollViewpager vp_content;
    private TabLayout tb_title;
    private String fragment;

    @Override
    protected int getResourcesId() {
        return R.layout.activity_auditing;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        vp_content = findViewById(R.id.vp_content);
        tb_title = findViewById(R.id.tb_title);

        //隐患计划
        Intent getIntent = getIntent();
        String type = getIntent.getStringExtra("现场治理");


        tabTitle[0] = "现场治理";
        tabTitle[1] = "现场情况";

        ArrayList<Fragment> mList = new ArrayList<>();
//        HiddenTroubleSceneFragment hiddenTroubleSceneFragment=new HiddenTroubleSceneFragment();
//        FieldSituationFragment fieldSituationFragment=new FieldSituationFragment();
        FieldManagementFragmentSH fieldManagementFragmentSH = new FieldManagementFragmentSH();
        FieldManagementFragmentBH fieldManagementFragmentBH = new FieldManagementFragmentBH();
        FieldManagementFragmentCC fieldManagementFragmentCC = new FieldManagementFragmentCC();
        FieldSituationFragmentSH fieldSituationFragmentSH = new FieldSituationFragmentSH();
        FieldSituationFragmentBH fieldSituationFragmentBH = new FieldSituationFragmentBH();
        FieldSituationFragmentCC fieldSituationFragmentCC = new FieldSituationFragmentCC();
        if (type.equals("2")) {
            mList.add(fieldManagementFragmentSH);
            mList.add(fieldSituationFragmentSH);
        } else if (type.equals("3")) {
            mList.add(fieldManagementFragmentBH);
            mList.add(fieldSituationFragmentBH);
        } else if (type.equals("8")) {
            mList.add(fieldManagementFragmentCC);
            mList.add(fieldSituationFragmentCC);
        }


        CourseDetailsAdapter adapter = new CourseDetailsAdapter(getSupportFragmentManager(), mList);
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
            return FieldManagementActivity.tabTitle[position];
        }
    }
}
