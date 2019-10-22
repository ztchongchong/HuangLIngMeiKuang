package com.lingjun.colliery_android.module.dealwith.activity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.lingjun.colliery_android.R;
import com.lingjun.colliery_android.base.BaseActivity;
import com.lingjun.colliery_android.base.BaseLinkList;
import com.lingjun.colliery_android.bean.LeadBean;
import com.lingjun.colliery_android.module.dealwith.adapter.InviteLeadAdapter;
import com.lingjun.colliery_android.module.dealwith.adapter.InviteLeadAdapter1;
import com.lingjun.colliery_android.module.dealwith.standardized.audit.LeadershipActivity;
import com.lingjun.colliery_android.utils.FastJsonTools;
import com.lingjun.colliery_android.utils.retrofit.BaseSubscriber;
import com.lingjun.colliery_android.utils.retrofit.ExceptionHandle;
import com.lingjun.colliery_android.view.CircleImageView;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;


/**
 * Created by shurrikann on 2018/3/20.
 */

public class InviteLeadActivity extends BaseActivity {
    @OnClick(R.id.iv_back)
    void back() {
        finish();
    }

    @BindView(R.id.lead1)
     RecyclerView lead1;
    @BindView(R.id.lead2)
     RecyclerView lead2;

    @BindView(R.id.apove_img)
     CircleImageView apove_img;
    @BindView(R.id.apove_name)
     TextView apove_name;
    @BindView(R.id.apove_zhiwei)
     TextView apove_zhiwei;
    private String taskid;
    private List<LeadBean.DataBean.InuserBean> list1 = new ArrayList<>();
    private List<LeadBean.DataBean.OutuserBean> list2 = new ArrayList<>();
    private InviteLeadAdapter adapter;
    private InviteLeadAdapter1 adapter1;

    @Override
    protected int getResourcesId() {
        return R.layout.activity_invite_leader;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        taskid = getIntent().getStringExtra("taskid");
        initAdapter();
    }

    private void initAdapter() {
        GridLayoutManager layoutManager = new GridLayoutManager(InviteLeadActivity.this, 4);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        adapter = new InviteLeadAdapter(R.layout.item_grid_leader_button);
        lead1.setLayoutManager(layoutManager);
        lead1.setAdapter(adapter);
        lead1.setNestedScrollingEnabled(false);
        GridLayoutManager layoutManager1 = new GridLayoutManager(InviteLeadActivity.this, 4);
        layoutManager1.setOrientation(LinearLayoutManager.VERTICAL);
        adapter1 = new InviteLeadAdapter1(R.layout.item_grid_leader_button);
        lead2.setLayoutManager(layoutManager1);
        lead2.setAdapter(adapter1);
        lead2.setNestedScrollingEnabled(false);
    }

    @Override
    protected BaseRefreshLoadMoreInterface setRefreshLoadMoreListener() {
        return new BaseRefreshLoadMoreInterface() {
            @Override
            public void onLoadMore() {
                refreshView();
            }

            @Override
            public void onRefresh() {
                refreshView();
            }
        };
    }

    private void refreshView() {
        HashMap<String, String> hashMap = new HashMap<>();
        if (TextUtils.isEmpty(taskid)) {
            return;
        }
        hashMap.put("taskid", taskid);
        hashMap.put("apiurl",BaseLinkList.coal_mine+ BaseLinkList.MOBILE_GETSTADCHKLEADERLIST);
        mRetrofit.JsonToColliery(BaseLinkList.Base_Url, hashMap, new BaseSubscriber() {
            @Override
            public void onError(ExceptionHandle.ResponeThrowable e) {
                if (null != refreshLayout) {
                    refreshLayout.finishLoadMore();
                    refreshLayout.finishRefresh();
                }
            }

            @Override
            public void onSuccess(JSONObject jsonObject) throws JSONException {
                LeadBean bean = FastJsonTools.getBean(jsonObject.toString(), LeadBean.class);
                if (null != bean) {
                    if (bean.getData().getInuser().size() != 0) {
                        list1 = bean.getData().getInuser();
                        adapter.setNewData(list1);
                    }
                    if (bean.getData().getOutuser().size() != 0) {
                        list2 = bean.getData().getOutuser();
                        adapter1.setNewData(list2);
                    }
                    apove_name.setText(bean.getData().getApprover().getName());
                    if (!TextUtils.isEmpty(bean.getData().getApprover().getPictureurl() + "")) {
                        Glide.with(InviteLeadActivity.this).load(BaseLinkList.Base_Url + bean.getData().getApprover().getPictureurl() + "").into(apove_img);
                        apove_img.setVisibility(View.VISIBLE);
                    }

                }
            }
        });
        if (null != refreshLayout) {
            refreshLayout.finishLoadMore();
            refreshLayout.finishRefresh();
        }
    }
}
