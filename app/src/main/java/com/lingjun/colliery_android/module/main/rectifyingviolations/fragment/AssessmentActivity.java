package com.lingjun.colliery_android.module.main.rectifyingviolations.fragment;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.widget.TextView;

import com.lingjun.colliery_android.R;
import com.lingjun.colliery_android.base.BaseActivity;
import com.lingjun.colliery_android.module.dealwith.hiddendanger.activity.ProcessingSchemeActivity;
import com.lingjun.colliery_android.module.dealwith.hiddendanger.fragment.HiddenDangerOneFragment;
import com.lingjun.colliery_android.module.dealwith.hiddendanger.fragment.HiddenDangerThreeFragment;
import com.lingjun.colliery_android.module.dealwith.hiddendanger.fragment.HiddenDangerTwoFragment;
import com.lingjun.colliery_android.view.NoScrollViewpager;
import com.lingjun.colliery_android.view.tablayout.TabLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author:ztcc
 * @Data：2019/9/4 18:19
 * Describe:行为考核
 */
public class AssessmentActivity extends BaseActivity {
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.tb_title)
    TabLayout tbTitle;
    @BindView(R.id.vp_content)
    NoScrollViewpager vpContent;
    public static String[] tabTitle = new String[3];
    @Override
    protected int getResourcesId() {
        return R.layout.activity_processing_scheme;
    }

    @Override
    protected void init(Bundle savedInstanceState) throws PackageManager.NameNotFoundException {
        tvName.setText("行为考核");

        tabTitle[0] = "岗位描述考核";
        tabTitle[1] = "手指口述考核";
        tabTitle[2] = "良好行为考核";

        ArrayList<Fragment> mList = new ArrayList<>();
        OneAssessmentFragment oneAssessment = new OneAssessmentFragment();
        TwoAssessmentFragment twoAssessment = new TwoAssessmentFragment();
        ThreeAssessmentFragment threeAssessment = new ThreeAssessmentFragment();

        mList.add(oneAssessment);
        mList.add(twoAssessment);
        mList.add(threeAssessment);


        CourseDetailsAdapter adapter = new CourseDetailsAdapter(getSupportFragmentManager(), mList);
        vpContent.setAdapter(adapter);
        tbTitle.setupWithViewPager(vpContent);
        tbTitle.setTabMode(TabLayout.MODE_FIXED);
        vpContent.setScroll(false);
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
            return AssessmentActivity.tabTitle[position];
        }
    }
}
