package com.lingjun.colliery_android.module.dealwith.hiddendanger.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.blankj.utilcode.util.LogUtils;
import com.lingjun.colliery_android.R;
import com.lingjun.colliery_android.base.BaseActivity;
import com.lingjun.colliery_android.base.BaseLinkList;
import com.lingjun.colliery_android.bean.HiddenDangerDetailsBean;
import com.lingjun.colliery_android.module.dealwith.fragment.FieldSituationFragment;
import com.lingjun.colliery_android.module.dealwith.hiddendanger.general_hidden_danger.HiddenDangerNtryActivity;
import com.lingjun.colliery_android.module.main.rectifyingviolations.fragment.HiddenTroubleSceneFragment;
import com.lingjun.colliery_android.utils.FastJsonTools;
import com.lingjun.colliery_android.utils.ToastUtils;
import com.lingjun.colliery_android.utils.retrofit.BaseSubscriber;
import com.lingjun.colliery_android.utils.retrofit.ExceptionHandle;
import com.lingjun.colliery_android.view.NoScrollViewpager;
import com.lingjun.colliery_android.view.tablayout.TabLayout;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 隐患详情
 * Created by nefa on 2018/11/20.
 */

public class HiddenTroubleDetailsActivity extends BaseActivity {
    private TabLayout tb_title;
    private NoScrollViewpager vp_content;
    private ArrayList<String> tabTitle;
    private TextView tv_name;
    private Button btn_complete;

    private String taskMainId = "0";//主隐患
    private String taskId = "0";//子隐患
    private String state = "0";
    private String yinhuanlishi;
    private String details_acceptor;
    private String sourceDescription;
    private String clauseMeasures;
    private String collaborativeUnitsSwitch;
    private String deletes;

    @Override
    protected int getResourcesId() {
        return R.layout.activity_hidden_trouble_details;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        tb_title = findViewById(R.id.tb_title);
        vp_content = findViewById(R.id.vp_content);
        tv_name = findViewById(R.id.tv_name);
        btn_complete = findViewById(R.id.btn_complete);
        vp_content.setScroll(true);

        taskMainId = getIntent().getStringExtra("taskMainId");
        taskId = getIntent().getStringExtra("taskId");
        state = getIntent().getStringExtra("state");
        yinhuanlishi = getIntent().getStringExtra("yinhuanlishi");
        deletes = getIntent().getStringExtra("deletes");
        if (deletes != null) {
            if (!deletes.equals("4")) {
                if (state.equals("3")) {
                    tabTitle = new ArrayList<>();
                    tabTitle.add("现场情况");
                    btn_complete.setText("重新治理");
                } else if (state.equals("4") && yinhuanlishi.equals("1")) {
                    tabTitle = new ArrayList<>();
                    tabTitle.add("现场治理");
                    tabTitle.add("现场情况");
                    btn_complete.setText("存入隐患历史");
                } else if (state.equals("5") && yinhuanlishi.equals("0")) {
                    tabTitle = new ArrayList<>();
                    tabTitle.add("现场治理");
                    tabTitle.add("现场情况");
                    btn_complete.setText("归档");
                } else if (state.equals("6") && yinhuanlishi.equals("0")) {
                    tabTitle = new ArrayList<>();
                    tabTitle.add("现场治理");
                    tabTitle.add("现场情况");
                    btn_complete.setVisibility(View.GONE);
                }
            } else {
                if (state.equals("4") && yinhuanlishi.equals("0")) {
                    tabTitle = new ArrayList<>();
                    tabTitle.add("现场治理");
                    tabTitle.add("现场情况");
                    btn_complete.setVisibility(View.GONE);
                } else if (state.equals("5") && yinhuanlishi.equals("0")) {
                    tabTitle = new ArrayList<>();
                    tabTitle.add("现场治理");
                    tabTitle.add("现场情况");
                    btn_complete.setVisibility(View.GONE);
                } else if (state.equals("6") && yinhuanlishi.equals("0")) {
                    tabTitle = new ArrayList<>();
                    tabTitle.add("现场治理");
                    tabTitle.add("现场情况");
                    btn_complete.setVisibility(View.GONE);
                }
            }
        } else {
            if (state.equals("3")) {
                tabTitle = new ArrayList<>();
                tabTitle.add("现场情况");
                btn_complete.setText("重新治理");
            } else if (state.equals("4") && yinhuanlishi.equals("1")) {
                tabTitle = new ArrayList<>();
                tabTitle.add("现场治理");
                tabTitle.add("现场情况");
                btn_complete.setText("存入隐患历史");
            } else if (state.equals("5") && yinhuanlishi.equals("0")) {
                tabTitle = new ArrayList<>();
                tabTitle.add("现场治理");
                tabTitle.add("现场情况");
                btn_complete.setText("归档");
            } else if (state.equals("6") && yinhuanlishi.equals("0")) {
                tabTitle = new ArrayList<>();
                tabTitle.add("现场治理");
                tabTitle.add("现场情况");
                btn_complete.setVisibility(View.GONE);
            }
        }


        btn_complete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (state.equals("3")) {
                    //被驳回
                    Intent intent = new Intent(HiddenTroubleDetailsActivity.this, HiddenDangerNtryActivity.class);
                    intent.putExtra("type", 2);
                    intent.putExtra("bohuitaskId", taskId);
                    LogUtils.e("隐患详情bohuitaskId"+taskId);
                    intent.putExtra("details_acceptor_2", details_acceptor);
                    intent.putExtra("sourceDescription", sourceDescription);
                    intent.putExtra("clauseMeasures", clauseMeasures);
                    intent.putExtra("collaborativeUnitsSwitch", collaborativeUnitsSwitch);
                    startActivity(intent);
                    finish();
                } else if (state.equals("4")) {
                    //待存储
                    showLoadDialog();
                    HashMap<String, String> hashMap = new HashMap<>();
                    hashMap.put("taskId", taskId);
                    hashMap.put("saveType", "1");
                    hashMap.put(BaseLinkList.apiurl, BaseLinkList.coal_mine + BaseLinkList.saveTypeButton);
                    mRetrofit.JsonToColliery(BaseLinkList.Base_Url, hashMap, new BaseSubscriber() {
                        @Override
                        public void onError(ExceptionHandle.ResponeThrowable e) {
                            dismissDialog();
                        }

                        @Override
                        public void onSuccess(JSONObject jsonObject) {
                            LogUtils.e("待销号提交->>" + jsonObject.toString());
                            finish();
                            dismissDialog();
                        }
                    });
                } else if (state.equals("5")) {
                    showLoadDialog();
                    HashMap<String, String> hashMap = new HashMap<>();
                    hashMap.put("taskId", taskId);
                    hashMap.put("saveType", "2");
                    hashMap.put(BaseLinkList.apiurl, BaseLinkList.coal_mine + BaseLinkList.saveTypeButton_guidang);
                    mRetrofit.JsonToColliery(BaseLinkList.Base_Url, hashMap, new BaseSubscriber() {
                        @Override
                        public void onError(ExceptionHandle.ResponeThrowable e) {
                            dismissDialog();
                        }

                        @Override
                        public void onSuccess(JSONObject jsonObject) {
                            LogUtils.e("待销号归档->>" + jsonObject.toString());
                            finish();
                            dismissDialog();
                        }
                    });
                }
            }
        });

        initData();
    }

    private void initData() {
        showLoadDialog();
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("id", taskId);
        hashMap.put("mainid", taskMainId);
        hashMap.put(BaseLinkList.apiurl, BaseLinkList.coal_mine + BaseLinkList.troubleinfo);
        mRetrofit.JsonToColliery(BaseLinkList.Base_Url, hashMap, new BaseSubscriber() {
            @Override
            public void onError(ExceptionHandle.ResponeThrowable e) {
                if (null != refreshLayout) {
                    refreshLayout.finishRefresh();
                    refreshLayout.finishLoadMore();
                }
                dismissDialog();
            }

            @Override
            public void onSuccess(JSONObject jsonObject) {
                dismissDialog();
                LogUtils.e("隐患信息限时整改->>" + jsonObject.toString());
                ArrayList<Fragment> mList = new ArrayList<>();
                final HiddenDangerDetailsBean dangerDetailsBean = FastJsonTools.getBean(jsonObject.toString(), HiddenDangerDetailsBean.class);
                if (null != dangerDetailsBean && null != dangerDetailsBean.getData()) {
                    details_acceptor = dangerDetailsBean.getData().getSubTaskList().getAcceptorName();//验收人
                    sourceDescription = dangerDetailsBean.getData().getSubTaskList().getSourceDescription();//
                    clauseMeasures = dangerDetailsBean.getData().getMaintask().getClauseMeasures();//
                    collaborativeUnitsSwitch = dangerDetailsBean.getData().getCollaborativeUnitsSwitch();
                    if (state.equals("3")) {
                        mList.add(FieldSituationFragment.newInstance(dangerDetailsBean));
                        CourseDetailsAdapter adapter = new CourseDetailsAdapter(getSupportFragmentManager(), mList, tabTitle);
                        vp_content.setAdapter(adapter);
                        tb_title.setupWithViewPager(vp_content);
                        tb_title.setTabMode(TabLayout.MODE_FIXED);
                    } else {
                        HiddenTroubleSceneFragment hiddenTroubleSceneFragment = new HiddenTroubleSceneFragment();
                        Bundle bundle = new Bundle();
                        bundle.putString("taskMainId", taskMainId);
                        bundle.putString("taskId", taskId);
                        bundle.putString("state", state);
                        hiddenTroubleSceneFragment.setArguments(bundle);
                        mList.add(hiddenTroubleSceneFragment);
                        mList.add(FieldSituationFragment.newInstance(dangerDetailsBean));
                        CourseDetailsAdapter adapter = new CourseDetailsAdapter(getSupportFragmentManager(), mList, tabTitle);
                        vp_content.setAdapter(adapter);
                        tb_title.setupWithViewPager(vp_content);
                        tb_title.setTabMode(TabLayout.MODE_FIXED);
                    }
                }
            }
        });
    }

    @Override
    protected BaseRefreshLoadMoreInterface setRefreshLoadMoreListener() {
        return null;
    }

    class CourseDetailsAdapter extends FragmentStatePagerAdapter {
        private List<Fragment> fragments;
        private ArrayList<String> tabName;

        public CourseDetailsAdapter(FragmentManager fm, List<Fragment> fragments, ArrayList<String> tab) {
            super(fm);
            this.fragments = fragments;
            this.tabName = tab;
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
            return tabName.get(position);
        }
    }
}
