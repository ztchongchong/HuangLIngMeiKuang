package com.lingjun.colliery_android.module.message;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.widget.TextView;

import com.lingjun.colliery_android.R;
import com.lingjun.colliery_android.base.BaseActivity;
import com.lingjun.colliery_android.view.NoScrollViewpager;
import com.lingjun.colliery_android.view.tablayout.TabLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者: 黄泉买骨人(zengtao)
 * 时间: 2018/11/24  11:01.
 * 注释: 消息界面
 */
public class MessageActivity extends BaseActivity {
    private TextView tv_title;//标题头

    public static String[] tabTitle;
    private NoScrollViewpager vp_content;
    private TabLayout tb_title;

    private ArrayList<Fragment> mList = new ArrayList<>();
    private NotificationContentFragment notificationContentFragment = new NotificationContentFragment();//通知内容
    private PenaltySheetFragment penaltySheetFragment = new PenaltySheetFragment();//处罚单
    private NoticeOfRectificationFragment noticeOfRectificationFragment = new NoticeOfRectificationFragment();//整改通知书

    private String message_type;

    @Override
    protected int getResourcesId() {
        return R.layout.activity_message;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        Intent getIntent = getIntent();
        message_type = getIntent.getStringExtra("message_type");
        tv_title = findViewById(R.id.tv_title);
        vp_content = findViewById(R.id.vp_content);
        tb_title = findViewById(R.id.tb_title);
        tabTitle = new String[2];
//        if (message_type.equals("1")){
//            tabTitle[0] = "";
//            mList.add(penaltySheetFragment);
//            tv_title.setText("责任人通知");
//        }else if (message_type.equals("2")){
//            tabTitle[0] = "";
//            mList.add(penaltySheetFragment);
//            tv_title.setText("领导通知");
//        }else
        if (message_type.equals("3")) {
            tabTitle[0] = "通知内容";
            tabTitle[1] = "处罚单";
            mList.add(notificationContentFragment);
            mList.add(penaltySheetFragment);
            tv_title.setText("超时通知");
        } else if (message_type.equals("4")) {
            tabTitle[0] = "通知内容";
            tabTitle[1] = "处罚单";
            mList.add(notificationContentFragment);
            mList.add(penaltySheetFragment);
            tv_title.setText("销号通知");
        } else if (message_type.equals("6")) {
            tabTitle[0] = "通知内容";
            tabTitle[1] = "整改通知书";
            tv_title.setText("整改通知");
            mList.add(notificationContentFragment);
            mList.add(noticeOfRectificationFragment);
        } else if (message_type.equals("7")) {
            tabTitle[0] = "通知内容";
            tabTitle[1] = "整改通知书";
            tv_title.setText("整改通知");
            mList.add(notificationContentFragment);
            mList.add(noticeOfRectificationFragment);

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
            return MessageActivity.tabTitle[position];
        }
    }
}
