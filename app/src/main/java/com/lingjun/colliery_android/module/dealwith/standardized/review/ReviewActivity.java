package com.lingjun.colliery_android.module.dealwith.standardized.review;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.lingjun.colliery_android.base.BaseLinkList;
import com.lingjun.colliery_android.bean.ResultBean;
import com.lingjun.colliery_android.bean.ToReviewBean;
import com.lingjun.colliery_android.module.dealwith.myinterface.ListviewInterface;
import com.lingjun.colliery_android.module.dealwith.standardized.audit.AuditActivity;
import com.lingjun.colliery_android.utils.DateUtil;
import com.lingjun.colliery_android.utils.FastJsonTools;
import com.lingjun.colliery_android.utils.ToastUtils;
import com.lingjun.colliery_android.utils.retrofit.BaseSubscriber;
import com.lingjun.colliery_android.utils.retrofit.ExceptionHandle;
import com.lingjun.colliery_android.view.tablayout.TabLayout;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.lingjun.colliery_android.R;
import com.lingjun.colliery_android.base.BaseActivity;
import com.lingjun.colliery_android.module.dealwith.standardized.review.fragment.PersonnelDetailsFragment;
import com.lingjun.colliery_android.module.dealwith.standardized.review.fragment.ResultsSummaryFragment;
import com.lingjun.colliery_android.module.dealwith.standardized.review.fragment.ScoreDetailsFragment;
import com.lingjun.colliery_android.view.NoScrollViewpager;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 待审阅
 * Created by nefa on 2018/11/7.
 */

public class ReviewActivity extends BaseActivity implements ListviewInterface {


    private TabLayout tb_title;
    private NoScrollViewpager vp_content;
    private RelativeLayout rl_history;
    private String taskid;

    private TextView tv_task_name;
    private TextView chuangjian;
    private TextView date;
    private TextView qixian;
    private TextView yaoqiu;
    private ToReviewBean bean;
    private String remark;
    private Button comm_btn;

    @Override
    protected int getResourcesId() {
        return R.layout.activity_review;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        taskid = getIntent().getStringExtra("taskid");
        tb_title = findViewById(R.id.tb_title);
        vp_content = findViewById(R.id.vp_content);
        rl_history = findViewById(R.id.rl_history);
        comm_btn = findViewById(R.id.comm_btn);
        tv_task_name = findViewById(R.id.tv_task_name);
        chuangjian = findViewById(R.id.chuangjian);
        date = findViewById(R.id.date);
        qixian = findViewById(R.id.qixian);
        yaoqiu = findViewById(R.id.yaoqiu);
        rl_history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                startActivity(new Intent(ReviewActivity.this, HistoryActivity.class));
            }
        });
        comm_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showdeldialog(ReviewActivity.this, 1);
            }
        });
        refreshView();
    }

    @Override
    protected BaseRefreshLoadMoreInterface setRefreshLoadMoreListener() {
//        return new BaseRefreshLoadMoreInterface() {
//            @Override
//            public void onLoadMore() {
//                refreshView();
//            }
//
//            @Override
//            public void onRefresh() {
//                refreshView();
//            }
//        };
        return null;
    }

    //刷新
    private void refreshView() {
        showLoadDialog();
        HashMap<String, String> hashMap = new HashMap<>();
        if (TextUtils.isEmpty(taskid)) {
            return;
        }
        hashMap.put("page", "1");
        hashMap.put("pageSize", "10");
        hashMap.put("taskid", taskid);
        hashMap.put("apiurl", BaseLinkList.coal_mine + BaseLinkList.MOBILE_GETSTADCHK);
        mRetrofit.JsonToColliery(BaseLinkList.Base_Url, hashMap, new BaseSubscriber() {
            @Override
            public void onError(ExceptionHandle.ResponeThrowable e) {
                dismissDialog();
            }

            @Override
            public void onSuccess(JSONObject jsonObject) throws JSONException {
                Log.d("json", jsonObject.toString());
                bean = FastJsonTools.getBean(jsonObject.toString(), ToReviewBean.class);
                if (null != bean) {
                    tv_task_name.setText(bean.getData().getTitle());
                    chuangjian.setText("创建人:" + bean.getData().getCreator());
                    date.setText(DateUtil.getData(bean.getData().getCreatetime()));
                    qixian.setText("期限:" + (DateUtil.getData(bean.getData().getFinishtime())));
                    yaoqiu.setText(bean.getData().getDescription());
                    ArrayList<Fragment> mFragments = new ArrayList<>();
                    mFragments.add(ResultsSummaryFragment.newInstance("结果汇总", 0, bean.getData()));
                    mFragments.add(ScoreDetailsFragment.newInstance("分值详情", 1, bean.getData(), taskid));
                    mFragments.add(PersonnelDetailsFragment.newInstance("人员详情", 2, bean.getData(), taskid));

                    ArrayList<String> mTitle = new ArrayList<>();
                    mTitle.add("结果汇总");
                    mTitle.add("分值详情");
                    mTitle.add("人员详情");

                    CourseDetailsAdapter mAdapter = new CourseDetailsAdapter(getSupportFragmentManager(), mFragments, mTitle);
                    vp_content.setAdapter(mAdapter);
                    tb_title.setupWithViewPager(vp_content);
                    tb_title.setTabMode(TabLayout.MODE_FIXED);
                }
                dismissDialog();
            }
        });
    }

    @Override
    public void btnClick(View v, int pos, boolean type) {

    }

    @Override
    public void btnsClick(View v, int pos, int state, boolean type) {

    }

    @Override
    public void btnsClicks(View v, int pos, boolean state, int type) {

    }


    class CourseDetailsAdapter extends FragmentStatePagerAdapter {
        private List<Fragment> fragments;
        private ArrayList<String> mTitles;

        public CourseDetailsAdapter(FragmentManager fm, List<Fragment> fragments, ArrayList<String> mTitles) {
            super(fm);
            this.fragments = fragments;
            this.mTitles = mTitles;
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
            return mTitles.get(position);
        }

    }

    private void showdeldialog(Context context, final int type) {
        final Dialog dialog = new Dialog(context, R.style.dialog);//
        dialog.getWindow().setContentView(R.layout.dialog_refuse);
        TextView title = dialog.findViewById(R.id.title);
        final EditText sake_info = dialog.findViewById(R.id.sake_info);
        TextView confirm = dialog.findViewById(R.id.confirm);
        TextView cancel = dialog.findViewById(R.id.cancel);
//        if (type == 1) {
        title.setText("审阅意见");
        sake_info.setHint("输入审阅意见");
//        } else {
//            title.setText("驳回意见");
//            sake_info.setHint("输入驳回意见");
//        }
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(sake_info.getText().toString().trim())) {
                    ToastUtils.showToast(ReviewActivity.this, "请填写您的意见");
                    return;
                }
                remark = sake_info.getText().toString().trim();
                CommTask(remark, type + "");
                dialog.dismiss();
                forceHideIM();
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                forceHideIM();
            }
        });
        dialog.show();
    }

    private void CommTask(String remark, String type) {
        showLoadDialog();
        HashMap<String, String> map = new HashMap<>();
        if (TextUtils.isEmpty(remark)) {
            ToastUtils.showToast(ReviewActivity.this, "请填写您的意见");
            return;
        }
        map.put("taskid", taskid + "");
        map.put("status", type + "");
        map.put("remark", remark);
        map.put(BaseLinkList.apiurl,BaseLinkList.coal_mine+BaseLinkList.MOBILE_STDCHKAPPROVE);
        mRetrofit.JsonToColliery(BaseLinkList.Base_Url, map, new BaseSubscriber() {
            @Override
            public void onError(ExceptionHandle.ResponeThrowable e) {
                dismissDialog();
            }

            @Override
            public void onSuccess(JSONObject jsonObject) throws JSONException {
                ResultBean bean = FastJsonTools.getBean(jsonObject.toString(), ResultBean.class);
                if (null != bean) {
                    forceHideIM();
                    ToastUtils.showToast(ReviewActivity.this, "提交成功");
                    finish();
                }
            }
        });
        dismissDialog();
    }
}
