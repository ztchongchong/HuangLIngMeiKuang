package com.lingjun.colliery_android.module.dealwith.hiddendanger.activity;

import android.content.Intent;
import android.os.Bundle;

import com.lingjun.colliery_android.view.tablayout.TabLayout;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;

import com.lingjun.colliery_android.R;
import com.lingjun.colliery_android.base.BaseActivity;
import com.lingjun.colliery_android.module.dealwith.hiddendanger.fragment.ApplicationForPostponementFragment;
import com.lingjun.colliery_android.module.dealwith.hiddendanger.fragment.FieldSituationFragmentSH;
import com.lingjun.colliery_android.module.dealwith.hiddendanger.fragment.MajorHiddenDangerFragmentBH;
import com.lingjun.colliery_android.module.dealwith.hiddendanger.fragment.MajorHiddenDangerFragmentSH;
import com.lingjun.colliery_android.module.dealwith.hiddendanger.fragment.NoticeOfRectificationFragment;
import com.lingjun.colliery_android.view.NoScrollViewpager;

import java.util.ArrayList;
import java.util.List;

/**
 * 重大隐患
 */
public class MajorHiddenDangersActivity extends BaseActivity {

    public static String[] tabTitle;
    private NoScrollViewpager vp_content;
    private TabLayout tb_title;

    private String type;
    private String taskMainId;
    private String taskId;
    private String state;

    @Override
    protected int getResourcesId() {
        return R.layout.activity_major_hidden_danger;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        Intent getIntent = getIntent();
        type = getIntent.getStringExtra("重大隐患");
        taskMainId = getIntent.getStringExtra("taskMainId");
        taskId = getIntent.getStringExtra("taskId");
        state = getIntent.getStringExtra("state");
        Log.e("黄泉买骨人", "taskId====" + taskId + "taskMainId====" + taskMainId + "state====" + state);
        ArrayList<Fragment> mList = new ArrayList<>();
        MajorHiddenDangerFragmentSH majorHiddenDangerFragmentSH = new MajorHiddenDangerFragmentSH();//重大隐患(审核中)
        MajorHiddenDangerFragmentBH majorHiddenDangerFragmentBH = new MajorHiddenDangerFragmentBH();//重大隐患（被驳回）
        FieldSituationFragmentSH fieldSituationFragmentSH = new FieldSituationFragmentSH();//现场情况
        NoticeOfRectificationFragment noticeOfRectificationFragment = new NoticeOfRectificationFragment();//整改通知书
        ApplicationForPostponementFragment applicationForPostponementFragment = new ApplicationForPostponementFragment();//延期申请


        if (state.equals("1")) {//待处理
            tabTitle = new String[2];
            tabTitle[0] = "重大隐患";
            tabTitle[1] = "现场情况";
            mList.add(majorHiddenDangerFragmentSH);
            mList.add(fieldSituationFragmentSH);

        } else if (state.equals("2")) {//审核中
            tabTitle = new String[2];
            tabTitle[0] = "重大隐患";
            tabTitle[1] = "现场情况";
            mList.add(majorHiddenDangerFragmentSH);
            mList.add(fieldSituationFragmentSH);
        } else if (type.equals("3")) {//被驳回
            tabTitle = new String[2];
            tabTitle[0] = "重大隐患";
            tabTitle[1] = "现场情况";
            mList.add(majorHiddenDangerFragmentBH);
            mList.add(fieldSituationFragmentSH);
        } else if (type.equals("12")) {//延期申请
            tabTitle = new String[3];
            tabTitle[0] = "延期申请";
            tabTitle[1] = "整改通知书";
            tabTitle[2] = "现场情况";
            mList.add(applicationForPostponementFragment);
            mList.add(noticeOfRectificationFragment);
            mList.add(fieldSituationFragmentSH);
        } else if (type.equals("13")) {//延期中
            tabTitle = new String[3];
            tabTitle[0] = "延期申请";
            tabTitle[1] = "整改通知书";
            tabTitle[2] = "现场情况";
            mList.add(applicationForPostponementFragment);
            mList.add(noticeOfRectificationFragment);
            mList.add(fieldSituationFragmentSH);
        }

        vp_content = findViewById(R.id.vp_content);
        tb_title = findViewById(R.id.tb_title);

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
            return MajorHiddenDangersActivity.tabTitle[position];
        }
    }
}
