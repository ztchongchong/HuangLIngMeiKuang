package com.lingjun.colliery_android.module.dealwith.hiddendanger.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;

import com.lingjun.colliery_android.R;
import com.lingjun.colliery_android.base.BaseActivity;
import com.lingjun.colliery_android.module.dealwith.hiddendanger.fragment.AcceptanceConditionFragment;
import com.lingjun.colliery_android.module.dealwith.hiddendanger.fragment.FieldSituationFragmentSH;
import com.lingjun.colliery_android.module.dealwith.hiddendanger.fragment.RectifyAndRectifyFragment;
import com.lingjun.colliery_android.module.dealwith.hiddendanger.fragment.RectifyAndRectifyTimeFragment;
import com.lingjun.colliery_android.view.NoScrollViewpager;
import com.lingjun.colliery_android.view.tablayout.TabLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * 限时整改
 */
public class RectifyTimeLimitActivity extends BaseActivity {
    public static String[] tabTitle;
    private NoScrollViewpager vp_content;
    private TabLayout tb_title;

    @Override
    protected int getResourcesId() {
        return R.layout.activity_auditing;
    }

    @Override
    protected void init(Bundle savedInstanceState) {

        Intent getIntent = getIntent();
        String type = getIntent.getStringExtra("限时整改");
        String type1 = getIntent.getStringExtra("挂牌督办");

        ArrayList<Fragment> mList = new ArrayList<>();
        FieldSituationFragmentSH fieldSituationFragmentSH = new FieldSituationFragmentSH();//现场情况
        RectifyAndRectifyTimeFragment rectifyAndRectifyTimeFragment = new RectifyAndRectifyTimeFragment();//限时整改
        RectifyAndRectifyFragment rectifyAndRectifyFragment = new RectifyAndRectifyFragment();//整改情况
        AcceptanceConditionFragment acceptanceConditionFragment = new AcceptanceConditionFragment();//验收情况


        if (type.equals("2")) {//审核中
            tabTitle = new String[2];
            tabTitle[0] = "限时整改";
            tabTitle[1] = "现场情况";
            mList.add(rectifyAndRectifyTimeFragment);
            mList.add(fieldSituationFragmentSH);
        } else if (type.equals("3")) {//被驳回
            tabTitle = new String[2];
            tabTitle[0] = "限时整改";
            tabTitle[1] = "现场情况";
            mList.add(rectifyAndRectifyTimeFragment);
            mList.add(fieldSituationFragmentSH);
        } else if (type.equals("4") || type.equals("5")) {//确认中
            tabTitle = new String[2];
            tabTitle[0] = "限时整改";
            tabTitle[1] = "现场情况";
            mList.add(rectifyAndRectifyTimeFragment);
            mList.add(fieldSituationFragmentSH);
        } else if (type.equals("5")) {//待整改
            tabTitle = new String[2];
            tabTitle[0] = "限时整改";
            tabTitle[1] = "现场情况";
            mList.add(rectifyAndRectifyTimeFragment);
            mList.add(fieldSituationFragmentSH);
        } else if (type.equals("6")) {//待验收
            tabTitle = new String[3];
            tabTitle[0] = "整改情况";
            tabTitle[1] = "限时整改";
            tabTitle[2] = "现场情况";
            mList.add(rectifyAndRectifyFragment);
            mList.add(rectifyAndRectifyTimeFragment);
            mList.add(fieldSituationFragmentSH);
        } else if (type.equals("8")) {//待储存
            tabTitle = new String[4];
            tabTitle[0] = "验收情况";
            tabTitle[1] = "整改通知书";
            tabTitle[2] = "限时整改";
            tabTitle[3] = "现场情况";
            mList.add(acceptanceConditionFragment);
            mList.add(rectifyAndRectifyFragment);
            mList.add(rectifyAndRectifyTimeFragment);
            mList.add(fieldSituationFragmentSH);
        }

        if (type1.equals("2")) {//审核中
            tabTitle = new String[2];
            tabTitle[0] = "限时整改";
            tabTitle[1] = "现场情况";
            mList.add(rectifyAndRectifyTimeFragment);
            mList.add(fieldSituationFragmentSH);
        } else if (type1.equals("3")) {//被驳回
            tabTitle = new String[2];
            tabTitle[0] = "限时整改";
            tabTitle[1] = "现场情况";
            mList.add(rectifyAndRectifyTimeFragment);
            mList.add(fieldSituationFragmentSH);
        } else if (type1.equals("4") || type1.equals("5")) {//确认中
            tabTitle = new String[2];
            tabTitle[0] = "限时整改";
            tabTitle[1] = "现场情况";
            mList.add(rectifyAndRectifyTimeFragment);
            mList.add(fieldSituationFragmentSH);
        } else if (type1.equals("5")) {//待整改
            tabTitle = new String[2];
            tabTitle[0] = "限时整改";
            tabTitle[1] = "现场情况";
            mList.add(rectifyAndRectifyTimeFragment);
            mList.add(fieldSituationFragmentSH);
        } else if (type1.equals("6")) {//待验收
            tabTitle = new String[3];
            tabTitle[0] = "整改情况";
            tabTitle[1] = "限时整改";
            tabTitle[2] = "现场情况";
            mList.add(rectifyAndRectifyFragment);
            mList.add(rectifyAndRectifyTimeFragment);
            mList.add(fieldSituationFragmentSH);
        } else if (type1.equals("8")) {//待储存
            tabTitle = new String[4];
            tabTitle[0] = "验收情况";
            tabTitle[1] = "整改情况";
            tabTitle[2] = "整改通知书";
            tabTitle[3] = "现场情况";
            mList.add(acceptanceConditionFragment);
            mList.add(rectifyAndRectifyFragment);
            mList.add(rectifyAndRectifyTimeFragment);
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
            return RectifyTimeLimitActivity.tabTitle[position];
        }
    }
}
