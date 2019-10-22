package com.lingjun.colliery_android.module.dealwith.hiddendanger.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.blankj.utilcode.util.LogUtils;
import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lingjun.colliery_android.R;
import com.lingjun.colliery_android.base.BaseActivity;
import com.lingjun.colliery_android.base.BaseLinkList;
import com.lingjun.colliery_android.base.OnGlobalListener;
import com.lingjun.colliery_android.bean.CooperativeSwitchBean;
import com.lingjun.colliery_android.bean.HiddenDangerDetailsBean;
import com.lingjun.colliery_android.bean.InputAcceptInfoBean;
import com.lingjun.colliery_android.module.dealwith.DealWithFragment;
import com.lingjun.colliery_android.module.dealwith.fragment.DealWithTaskFragment;
import com.lingjun.colliery_android.module.dealwith.fragment.TaskTrackingFragment;
import com.lingjun.colliery_android.module.dealwith.hiddendanger.fragment.HiddenDangerFourFragment;
import com.lingjun.colliery_android.module.dealwith.hiddendanger.fragment.HiddenDangerOneFragment;
import com.lingjun.colliery_android.module.dealwith.hiddendanger.fragment.HiddenDangerThreeFragment;
import com.lingjun.colliery_android.module.dealwith.hiddendanger.fragment.HiddenDangerTwoFragment;
import com.lingjun.colliery_android.module.main.rectifyingviolations.RectifyingViolationsActivity;
import com.lingjun.colliery_android.utils.FastJsonTools;
import com.lingjun.colliery_android.utils.PhotoPopupManager;
import com.lingjun.colliery_android.utils.RecyclerViewUtils;
import com.lingjun.colliery_android.utils.retrofit.BaseSubscriber;
import com.lingjun.colliery_android.utils.retrofit.ExceptionHandle;
import com.lingjun.colliery_android.view.NoScrollViewpager;
import com.lingjun.colliery_android.view.tablayout.TabLayout;

import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import cc.shinichi.library.ImagePreview;

/**
 * 处理方案
 */
public class ProcessingSchemeActivity extends BaseActivity {
    public static String[] tabTitle = new String[4];
    private NoScrollViewpager vp_content;
    private TabLayout tb_title;

    @Override
    protected int getResourcesId() {
        return R.layout.activity_processing_scheme;
    }


    @Override
    protected void init(Bundle savedInstanceState) {
        vp_content = findViewById(R.id.vp_content);
        tb_title = findViewById(R.id.tb_title);

        tabTitle[0] = "现场治理";
        tabTitle[1] = "限时整改";
        tabTitle[2] = "挂牌督办";
//        tabTitle[3] = "隐患升级";
        pick_up_information();//获取隐患详情信息
    }

    private void pick_up_information() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(BaseLinkList.apiurl, BaseLinkList.coal_mine + BaseLinkList.getInputAcceptInfo);

        mRetrofit.JsonToColliery(BaseLinkList.Base_Url, hashMap, new BaseSubscriber() {
            @Override
            public void onError(ExceptionHandle.ResponeThrowable e) {
                if (null != refreshLayout) {
                    refreshLayout.finishRefresh();
                    refreshLayout.finishLoadMore();
                }
            }

            @Override
            public void onSuccess(JSONObject jsonObject) {
                LogUtils.e("隐患审核人，验收人，验收单位->>" + jsonObject.toString());
                final InputAcceptInfoBean cooperativeSwitchBean = FastJsonTools.getBean(jsonObject.toString(), InputAcceptInfoBean.class);
                ArrayList<Fragment> mList = new ArrayList<>();
                HiddenDangerOneFragment hiddenDangerOneFragment = HiddenDangerOneFragment.newInstance(cooperativeSwitchBean);
                HiddenDangerTwoFragment hiddenDangerTwoFragment = HiddenDangerTwoFragment.newInstance(cooperativeSwitchBean);
                HiddenDangerThreeFragment hiddenDangerThreeFragment = HiddenDangerThreeFragment.newInstance(cooperativeSwitchBean);
//        HiddenDangerFourFragment hiddenDangerFourFragment = new HiddenDangerFourFragment();
                mList.add(hiddenDangerOneFragment);
                mList.add(hiddenDangerTwoFragment);
                mList.add(hiddenDangerThreeFragment);
//        mList.add(hiddenDangerFourFragment);

                CourseDetailsAdapter adapter = new CourseDetailsAdapter(getSupportFragmentManager(), mList);
                vp_content.setAdapter(adapter);
                tb_title.setupWithViewPager(vp_content);
                tb_title.setTabMode(TabLayout.MODE_FIXED);
                vp_content.setScroll(false);
            }
        });


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
            return ProcessingSchemeActivity.tabTitle[position];
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        PhotoPopupManager.getInstance().onActivityResulted(ProcessingSchemeActivity.this, requestCode, resultCode, data);

    }
}
