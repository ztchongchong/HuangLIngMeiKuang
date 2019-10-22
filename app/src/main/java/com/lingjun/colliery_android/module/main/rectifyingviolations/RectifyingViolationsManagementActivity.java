package com.lingjun.colliery_android.module.main.rectifyingviolations;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import com.lingjun.colliery_android.R;
import com.lingjun.colliery_android.base.BaseActivity;
import com.lingjun.colliery_android.module.main.rectifyingviolations.fragment.CorrectingSalesNumbersFragment;
import com.lingjun.colliery_android.module.main.rectifyingviolations.fragment.RectificationAndHandlingFragment;
import com.lingjun.colliery_android.view.NoScrollViewpager;
import com.lingjun.colliery_android.view.tablayout.TabLayout;
import java.util.ArrayList;
import java.util.List;
import butterknife.BindView;

/**
 * 三违管理
 * Created by nefa on 2018/11/17.
 */

public class RectifyingViolationsManagementActivity extends BaseActivity {


    @BindView(R.id.tb_title)
    TabLayout tb_title;
    @BindView(R.id.vp_content)
    NoScrollViewpager vp_content;

    public static String[] tabTitle = new String[2];

    @Override
    protected int getResourcesId() {
        return R.layout.activity_rectifying_manager;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        tabTitle[0] = "三违处理";
        tabTitle[1] = "三违销号";

        ArrayList<Fragment> mList = new ArrayList<>();
        RectificationAndHandlingFragment rectificationAndHandlingFragment = new RectificationAndHandlingFragment();
        CorrectingSalesNumbersFragment correctingSalesNumbersFragment = new CorrectingSalesNumbersFragment();
        mList.add(rectificationAndHandlingFragment);
        mList.add(correctingSalesNumbersFragment);

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
            return RectifyingViolationsManagementActivity.tabTitle[position];
        }
    }
}
