package com.lingjun.colliery_android.module.dealwith.standardized.audit;

import android.os.Bundle;

import com.lingjun.colliery_android.base.BaseLinkList;
import com.lingjun.colliery_android.bean.TeYaoBean;
import com.lingjun.colliery_android.module.dealwith.fragment.TeYaoTaskFragment;
import com.lingjun.colliery_android.module.dealwith.fragment.ZeroTaskFragment;
import com.lingjun.colliery_android.utils.FastJsonTools;
import com.lingjun.colliery_android.utils.retrofit.BaseSubscriber;
import com.lingjun.colliery_android.utils.retrofit.ExceptionHandle;
import com.lingjun.colliery_android.view.tablayout.TabLayout;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.util.Log;

import com.lingjun.colliery_android.R;
import com.lingjun.colliery_android.base.BaseActivity;
import com.lingjun.colliery_android.module.dealwith.standardized.fragment.SpecialPersonnelFragment;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 特邀人员
 * Created by nefa on 2018/10/31.
 */


public class SpecialPersonnelActivity extends BaseActivity {

    private TabLayout tb_title;
    private ViewPager vp_content;
    private String taskid;
    private List<TeYaoBean.DataBean.ItemmapBean> fragmentlist = new ArrayList<>();
    private List<String> titlelist = new ArrayList<>();
    private List<Fragment> fragmentList1 = new ArrayList<>();

    @Override
    protected int getResourcesId() {
        return R.layout.activity_special_personnel;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        taskid = getIntent().getStringExtra("taskid");
        tb_title = findViewById(R.id.tb_title);
        vp_content = findViewById(R.id.vp_content);
        tb_title.setupWithViewPager(vp_content);
        tb_title.setTabMode(TabLayout.MODE_FIXED);
        refreshView();
    }

    private void refreshView() {
        HashMap<String, String> hashMap = new HashMap<>();
        if (TextUtils.isEmpty(taskid)) {
            return;
        }
        hashMap.put("taskid", taskid);
        hashMap.put("apiurl",BaseLinkList.coal_mine+ BaseLinkList.MOBLIE_GETSTADCHKINVITEDLIST);
        mRetrofit.JsonToColliery(BaseLinkList.Base_Url , hashMap, new BaseSubscriber() {
            @Override
            public void onError(ExceptionHandle.ResponeThrowable e) {
                if (null != refreshLayout) {
                    refreshLayout.finishRefresh();
                    refreshLayout.finishLoadMore();
                }
            }

            @Override
            public void onSuccess(JSONObject jsonObject) throws JSONException {
                Log.d("json", jsonObject.toString());
                TeYaoBean bean = FastJsonTools.getBean(jsonObject.toString(), TeYaoBean.class);
                if (null != bean) {
                    if (bean.getData().getItemmap().size() != 0) {
                        fragmentlist = bean.getData().getItemmap();
                        initView();
                    }
                }
            }
        });
        if (null != refreshLayout) {
            refreshLayout.finishRefresh();
            refreshLayout.finishLoadMore();
        }
    }

    private void initView() {
        for (int i = 0; i < fragmentlist.size(); i++) {
            titlelist.add(i + 1 + "部分");
        }
        for (int i = 0; i < fragmentlist.size(); i++) {
            TeYaoTaskFragment taskFragment = TeYaoTaskFragment.newInstance(titlelist.get(i), i, fragmentlist.get(i));
            fragmentList1.add(taskFragment);
        }
        for (int i = 0; i < titlelist.size(); i++) {
            tb_title.addTab(tb_title.newTab().setText(titlelist.get(i)));
        }
        FragmentPagerAdapter mAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragmentList1.get(position);
            }

            @Override
            public int getCount() {
                return fragmentList1.size();
            }

            //ViewPager与TabLayout绑定后，这里获取到PageTitle就是Tab的Text
            @Override
            public CharSequence getPageTitle(int position) {
                return titlelist.get(position);
            }
        };
        vp_content.setAdapter(mAdapter);
        tb_title.setupWithViewPager(vp_content);
        tb_title.setTabsFromPagerAdapter(mAdapter);
    }

    @Override
    protected BaseRefreshLoadMoreInterface setRefreshLoadMoreListener() {
        return null;
    }
}
