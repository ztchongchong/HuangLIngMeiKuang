package com.lingjun.colliery_android.module.main.rectifyingviolations;

import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;

import com.lingjun.colliery_android.bean.DisobeysaveBean;
import com.lingjun.colliery_android.module.main.rectifyingviolations.fragment.ImplementationHistoryFragment;
import com.lingjun.colliery_android.utils.FastJsonTools;
import com.lingjun.colliery_android.view.tablayout.TabLayout;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v7.app.AlertDialog;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.lingjun.colliery_android.R;
import com.lingjun.colliery_android.base.BaseActivity;
import com.lingjun.colliery_android.base.BaseLinkList;
import com.lingjun.colliery_android.module.main.rectifyingviolations.fragment.ImplementationFragment;
import com.lingjun.colliery_android.module.main.rectifyingviolations.fragment.PreviewPunishmentFragment;
import com.lingjun.colliery_android.utils.retrofit.BaseSubscriber;
import com.lingjun.colliery_android.utils.retrofit.ExceptionHandle;
import com.lingjun.colliery_android.view.NoScrollViewpager;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 待销号
 * Created by nefa on 2018/11/18.
 */

public class ToBeStoredActivity extends BaseActivity {

    private TabLayout tb_title;
    private NoScrollViewpager vp_content;
    private ArrayList<String> tabTitle = new ArrayList<>();
    private TextView tv_name;
    private Button btn_complete;
    private Button btn_file;
    private String taskId;
    private String extraType;
    private String jiuwei;
    private String deleted;
    private ArrayList<Fragment> mList = new ArrayList<>();

    private View dialogview;
    private AlertDialog dialog;

    @Override
    protected int getResourcesId() {
        return R.layout.activity_tobe_stored;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        tb_title = findViewById(R.id.tb_title);
        vp_content = findViewById(R.id.vp_content);
        tv_name = findViewById(R.id.tv_name);
        btn_complete = findViewById(R.id.btn_complete);
        btn_file = findViewById(R.id.btn_file);

        taskId = getIntent().getStringExtra("taskId");
        extraType = getIntent().getStringExtra("extraType");
        jiuwei = getIntent().getStringExtra("jiuwei");
        deleted = getIntent().getStringExtra("deleted");
        LogUtils.e("deleted->>" + deleted);
        String state = getIntent().getStringExtra("state");
        if (deleted == null) {
            if (state.equals("2")) {//审核中
                tv_name.setText("审核中");
            } else if (state.equals("3")) {//被驳回
                tv_name.setText("被驳回");
            } else if (state.equals("4")) {//确认中
                tv_name.setText("确认中");
            } else if (state.equals("8") && jiuwei.equals("0")) {//待销号
                tv_name.setText("待销号");
                btn_complete.setVisibility(View.VISIBLE);
                btn_file.setVisibility(View.GONE);
            } else if (state.equals("9") && jiuwei.equals("1")) {
                tv_name.setText("已销号");
                btn_complete.setVisibility(View.GONE);
                btn_file.setVisibility(View.VISIBLE);
            } else if (state.equals("10") && jiuwei.equals("1")) {//已归档
                tv_name.setText("三违历史");
                btn_complete.setVisibility(View.GONE);
                btn_file.setVisibility(View.GONE);
            }
        } else if (deleted.equals("2")) {
            tv_name.setText("已关闭");
            btn_complete.setVisibility(View.GONE);
            btn_file.setVisibility(View.GONE);
        } else if (deleted.equals("0")) {
            if (state.equals("9")) {
                tv_name.setText("已销号");
                btn_complete.setVisibility(View.GONE);
                btn_file.setVisibility(View.VISIBLE);
            }
        }


        Bundle bundle = new Bundle();
        bundle.putString("taskId", taskId);
        bundle.putString("state", state);

        ImplementationFragment implementationFragment = new ImplementationFragment();
        PreviewPunishmentFragment previewPunishmentFragment = new PreviewPunishmentFragment();
        ImplementationHistoryFragment implementationHistoryFragment = new ImplementationHistoryFragment();
        implementationFragment.setArguments(bundle);
        previewPunishmentFragment.setArguments(bundle);
        implementationHistoryFragment.setArguments(bundle);

        if (!extraType.equals("0") && jiuwei.equals("0")) {
            tabTitle.add("执行情况");
            tabTitle.add("处罚单");
            mList.add(implementationFragment);
            mList.add(previewPunishmentFragment);
        } else if (!extraType.equals("0") && jiuwei.equals("1")) {
            tabTitle.add("执行情况");
            tabTitle.add("处罚单");
            mList.add(implementationHistoryFragment);
            mList.add(previewPunishmentFragment);
        } else {
            tabTitle.add("处罚单");
            mList.add(previewPunishmentFragment);
        }

        CourseDetailsAdapter adapter = new CourseDetailsAdapter(getSupportFragmentManager(), mList, tabTitle);
        vp_content.setAdapter(adapter);
        tb_title.setupWithViewPager(vp_content);
        tb_title.setTabMode(TabLayout.MODE_FIXED);
        vp_content.setScroll(false);

        btn_complete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!extraType.equals("0")) {
                    ImplementationFragment mFragment = (ImplementationFragment) vp_content.getAdapter().instantiateItem(vp_content, 0);
                    if (null != mFragment) {
                        if (mFragment.checkState()) {
                            commitServer();
                        } else {
                            ToastUtils.showShort("所有学习项目必须全部完成!");
                        }
                    }
                } else {
                    commitServer();
                }
            }
        });

        //三违归档
        btn_file.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HashMap<String, String> params = new HashMap<>();
                params.put("taskId", taskId);
                params.put(BaseLinkList.apiurl, BaseLinkList.coal_mine + BaseLinkList.rectifyingViolation);
                mRetrofit.JsonToColliery(BaseLinkList.Base_Url, params, new BaseSubscriber() {
                    @Override
                    public void onError(ExceptionHandle.ResponeThrowable e) {
                        dismissDialog();
                    }

                    @Override
                    public void onSuccess(JSONObject jsonObject) throws JSONException {
                        LogUtils.e("三违归档->>" + jsonObject.toString());
                        if (jsonObject.getString("code").equals("200")) {
                            finish();
                        }
                    }
                });
            }
        });

    }

    //三违销号
    private void commitServer() {

        HashMap<String, String> params = new HashMap<>();
        params.put("id", taskId);
        params.put(BaseLinkList.apiurl, BaseLinkList.coal_mine + BaseLinkList.disobeysave);
        mRetrofit.JsonToColliery(BaseLinkList.Base_Url, params, new BaseSubscriber() {
            @Override
            public void onError(ExceptionHandle.ResponeThrowable e) {
                dismissDialog();
            }

            @Override
            public void onSuccess(JSONObject jsonObject) throws JSONException {
                LogUtils.e("三违销号->>" + jsonObject.toString());
                final DisobeysaveBean disobeysaveBean = FastJsonTools.getBean(jsonObject.toString(), DisobeysaveBean.class);
                if (disobeysaveBean != null) {
                    if (disobeysaveBean.getData().isIsSave() == true) {
                        ToastUtils.showShort("销号成功!");
                        finish();
                    } else if (disobeysaveBean.getData().isIsSave() == false) {
                        AlertDialog.Builder builder1 = new AlertDialog.Builder(ToBeStoredActivity.this);
                        dialogview = View.inflate(ToBeStoredActivity.this, R.layout.alertdialog_jurisdiction, null);
                        builder1.setView(dialogview);
                        builder1.setCancelable(true);
                        dialog = builder1.create();
                        dialog.getWindow().setBackgroundDrawable(new BitmapDrawable());
                        dialog.show();
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
