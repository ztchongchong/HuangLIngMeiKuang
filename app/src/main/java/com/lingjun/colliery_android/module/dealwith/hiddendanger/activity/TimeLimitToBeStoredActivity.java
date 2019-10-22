package com.lingjun.colliery_android.module.dealwith.hiddendanger.activity;

import android.content.Intent;
import android.os.Bundle;

import com.lingjun.colliery_android.view.tablayout.TabLayout;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.lingjun.colliery_android.R;
import com.lingjun.colliery_android.base.BaseActivity;
import com.lingjun.colliery_android.base.BaseLinkList;
import com.lingjun.colliery_android.bean.HiddenDangerDetailsBean;
import com.lingjun.colliery_android.module.dealwith.fragment.DealWithTaskFragment;
import com.lingjun.colliery_android.module.dealwith.fragment.FieldSituationFragment;
import com.lingjun.colliery_android.module.dealwith.fragment.GovernanceShemeFragment;
import com.lingjun.colliery_android.module.dealwith.fragment.NoticeRectificationFragment;
import com.lingjun.colliery_android.module.dealwith.fragment.PunishmentSchemeFragment;
import com.lingjun.colliery_android.module.dealwith.fragment.RectificationSituationFragment;
import com.lingjun.colliery_android.module.dealwith.fragment.TaskTrackingFragment;
import com.lingjun.colliery_android.module.dealwith.hiddendanger.fragment.AcceptanceSituationFragment;
import com.lingjun.colliery_android.module.main.rectifyingviolations.RectifyingViolationsActivity;
import com.lingjun.colliery_android.utils.FastJsonTools;
import com.lingjun.colliery_android.utils.PhotoPopupManager;
import com.lingjun.colliery_android.utils.retrofit.BaseSubscriber;
import com.lingjun.colliery_android.utils.retrofit.ExceptionHandle;
import com.lingjun.colliery_android.view.NoScrollViewpager;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 待存储
 * Created by nefa on 2018/10/18.
 */

public class TimeLimitToBeStoredActivity extends BaseActivity {


    public static String[] tabTitle = new String[4];
    private NoScrollViewpager vp_content;
    private TabLayout tb_title;
    private Button btn_complete;
    String taskMainId;
    String taskId;
    String state;
    private String yinhuanlishi;
    private TextView tv_name;
    private String deletes;


    @Override
    protected int getResourcesId() {
        return R.layout.activity_time_limit_to_be_stored;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        vp_content = findViewById(R.id.vp_content);
        tv_name = findViewById(R.id.tv_name);
        tb_title = findViewById(R.id.tb_title);
        btn_complete = findViewById(R.id.btn_complete);
        vp_content.setScroll(true);

        tabTitle[0] = "验收情况";
        tabTitle[1] = "整改情况";
        tabTitle[2] = "限时整改";
        tabTitle[3] = "现场情况";

        taskMainId = getIntent().getStringExtra("taskMainId");
        taskId = getIntent().getStringExtra("taskId");
        state = getIntent().getStringExtra("state");
        yinhuanlishi = getIntent().getStringExtra("yinhuanlishi");
        deletes = getIntent().getStringExtra("deletes");

        Log.e("黄泉买骨人", "yinhuanlishi" + yinhuanlishi + "state" + state);
        if (deletes != null) {
            if (!deletes.equals("4")) {
                if (yinhuanlishi.equals("1")) {
                    btn_complete.setText("归入隐患历史");
                } else if (yinhuanlishi.equals("0") && state.equals("9")) {
                    btn_complete.setText("归档");
                    tv_name.setText("待归档");
                } else if (yinhuanlishi.equals("0") && state.equals("10")) {
                    tv_name.setText("已归档");
                    btn_complete.setVisibility(View.GONE);
                }
            } else {
                tv_name.setText("已关闭");
                btn_complete.setVisibility(View.GONE);
            }
        } else {
            if (yinhuanlishi.equals("1")) {
                btn_complete.setText("归入隐患历史");
            } else if (yinhuanlishi.equals("0") && state.equals("9")) {
                btn_complete.setText("归档");
                tv_name.setText("待归档");
            } else if (yinhuanlishi.equals("0") && state.equals("10")) {
                tv_name.setText("已归档");
                btn_complete.setVisibility(View.GONE);
            }
        }

        refreshView();
    }

    @Override
    protected BaseRefreshLoadMoreInterface setRefreshLoadMoreListener() {
        return null;
    }

    private void refreshView() {
        showLoadDialog();
        HashMap<String, String> hashMap = new HashMap<>();

        hashMap.put("id", taskId);
        hashMap.put("mainid", taskMainId);
        hashMap.put(BaseLinkList.apiurl, BaseLinkList.coal_mine + BaseLinkList.troubleinfo);
        mRetrofit.JsonToColliery(BaseLinkList.Base_Url, hashMap, new BaseSubscriber() {
            @Override
            public void onError(ExceptionHandle.ResponeThrowable e) {
                dismissDialog();
                if (null != refreshLayout) {
                    refreshLayout.finishRefresh();
                    refreshLayout.finishLoadMore();
                }
            }

            @Override
            public void onSuccess(JSONObject jsonObject) {
                LogUtils.e("隐患信息现场治理->>" + jsonObject.toString());
                final HiddenDangerDetailsBean dangerDetailsBean = FastJsonTools.getBean(jsonObject.toString(), HiddenDangerDetailsBean.class);
                ArrayList<Fragment> mList = new ArrayList<>();

                mList.add(AcceptanceSituationFragment.newInstance(dangerDetailsBean));//验收情况
                mList.add(RectificationSituationFragment.newInstance(dangerDetailsBean));//整改情况
                mList.add(NoticeRectificationFragment.newInstance(dangerDetailsBean));//限时整改
                mList.add(FieldSituationFragment.newInstance(dangerDetailsBean));//现场情况

                CourseDetailsAdapter adapter = new CourseDetailsAdapter(getSupportFragmentManager(), mList);
                vp_content.setAdapter(adapter);
                tb_title.setupWithViewPager(vp_content);
                tb_title.setTabMode(TabLayout.MODE_FIXED);
                vp_content.setScroll(false);

                btn_complete.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (yinhuanlishi.equals("1")) {
                            showLoadDialog();
                            HashMap<String, String> params = new HashMap<>();
                            params.put("taskId", taskId);
                            params.put("saveType", "1");
                            params.put(BaseLinkList.apiurl, BaseLinkList.coal_mine + BaseLinkList.getSaveTypeButton);
                            mRetrofit.JsonToColliery(BaseLinkList.Base_Url, params, new BaseSubscriber() {
                                @Override
                                public void onError(ExceptionHandle.ResponeThrowable e) {
                                    dismissDialog();
                                }

                                @Override
                                public void onSuccess(JSONObject jsonObject) throws JSONException {
                                    if (jsonObject.getString("code").equals("200")) {
                                        finish();
                                        ToastUtils.showShort("存储成功!");
                                    }
                                    dismissDialog();
                                }
                            });
                        } else if (yinhuanlishi.equals("0")) {
                            if (state.equals("9")) {
                                showLoadDialog();
                                HashMap<String, String> params = new HashMap<>();
                                params.put("taskId", taskId);
                                params.put("saveType", "2");
                                params.put(BaseLinkList.apiurl, BaseLinkList.coal_mine + BaseLinkList.getSaveTypeButton_guidang);
                                mRetrofit.JsonToColliery(BaseLinkList.Base_Url, params, new BaseSubscriber() {
                                    @Override
                                    public void onError(ExceptionHandle.ResponeThrowable e) {
                                        dismissDialog();
                                    }

                                    @Override
                                    public void onSuccess(JSONObject jsonObject) throws JSONException {
                                        if (jsonObject.getString("code").equals("200")) {
                                            finish();
                                            ToastUtils.showShort("归档成功!");
                                        }
                                        dismissDialog();
                                    }
                                });
                            }
                        }
                    }
                });
                dismissDialog();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        PhotoPopupManager.getInstance().onActivityResulted(TimeLimitToBeStoredActivity.this, requestCode, resultCode, data);
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
            return TimeLimitToBeStoredActivity.tabTitle[position];
        }
    }
}
