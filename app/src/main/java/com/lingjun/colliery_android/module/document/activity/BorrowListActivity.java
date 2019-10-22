package com.lingjun.colliery_android.module.document.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.lingjun.colliery_android.R;
import com.lingjun.colliery_android.base.BaseActivity;
import com.lingjun.colliery_android.module.document.fragment.BorrowListFragment;
import com.lingjun.colliery_android.view.NoScrollViewpager;
import com.lingjun.colliery_android.view.tablayout.TabLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
/**
 *作者: lihuan
 *时间: 2018/12/17 17:04
 *说明: 借阅清单
 */
public class BorrowListActivity extends BaseActivity {

    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tb_title)
    TabLayout tb_layout;
    @BindView(R.id.vp_content)
    NoScrollViewpager vp_content;

    public static String[] tabTitle = new String[3];

    @Override
    protected int getResourcesId() {
        return R.layout.activity_borrow_list;
    }

    @Override
    protected BaseRefreshLoadMoreInterface setRefreshLoadMoreListener() {
        return null;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        tabTitle[0] = "已通过";
        tabTitle[1] = "审核中";
        tabTitle[2] = "已结束";

        String mainTaskId = getIntent().getStringExtra("mainTaskId");

        ArrayList<Fragment> mList = new ArrayList<>();
        BorrowListFragment borrowListFragment = BorrowListFragment.newInstance(2);
        BorrowListFragment borrowListFragment1 = BorrowListFragment.newInstance(1);
        BorrowListFragment borrowListFragment2 = BorrowListFragment.newInstance(0);
        mList.add(borrowListFragment);
        mList.add(borrowListFragment1);
        mList.add(borrowListFragment2);

        BorrowListAdapter adapter = new BorrowListAdapter(getSupportFragmentManager(), mList);
        vp_content.setAdapter(adapter);
        tb_layout.setupWithViewPager(vp_content);
        tb_layout.setTabMode(TabLayout.MODE_FIXED);
        vp_content.setScroll(false);
    }

    @OnClick(R.id.iv_back)
    public void onViewClicked() {
        finish();
    }

    class BorrowListAdapter extends FragmentStatePagerAdapter {
        private List<Fragment> fragments;

        public BorrowListAdapter(FragmentManager fm, List<Fragment> fragments) {
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
            return tabTitle[position];
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
        }
    }
}
