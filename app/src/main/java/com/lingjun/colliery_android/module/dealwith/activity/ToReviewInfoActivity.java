package com.lingjun.colliery_android.module.dealwith.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.lingjun.colliery_android.R;
import com.lingjun.colliery_android.base.BaseActivity;
import com.lingjun.colliery_android.base.BaseLinkList;
import com.lingjun.colliery_android.bean.ReviewInfoBean;
import com.lingjun.colliery_android.module.dealwith.adapter.ToReviewInfoAdapter;
import com.lingjun.colliery_android.module.dealwith.myinterface.ListviewInterface;
import com.lingjun.colliery_android.utils.FastJsonTools;
import com.lingjun.colliery_android.utils.retrofit.BaseSubscriber;
import com.lingjun.colliery_android.utils.retrofit.ExceptionHandle;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by shurrikann on 2018/12/7.
 */

public class ToReviewInfoActivity extends BaseActivity implements ListviewInterface {
    @OnClick(R.id.iv_back)
    void back() {
        finish();
    }

    @BindView(R.id.refreshLayout)
    SmartRefreshLayout refreshLayout;
    @BindView(R.id.rv_list)
    RecyclerView rv_list;
    @BindView(R.id.tv_name)
    TextView tv_name;
    private int typeid;
    private String taskid;
    private String title;
    private List<ReviewInfoBean.DataBean.ItemlistBean> list = new ArrayList<>();
    private ToReviewInfoAdapter adapter;

    @Override
    protected int getResourcesId() {
        return R.layout.activity_to_review_info;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        taskid = getIntent().getStringExtra("taskid");
        typeid = getIntent().getIntExtra("typeid", -1);
        title = getIntent().getStringExtra("title");
        Log.d("str", taskid + "," + typeid + "," + title);
        tv_name.setText(title);
        initAdapter();
    }

    private void initAdapter() {
        adapter = new ToReviewInfoAdapter(R.layout.item_risk_managment, ToReviewInfoActivity.this);
        rv_list.setLayoutManager(new LinearLayoutManager(ToReviewInfoActivity.this));
        rv_list.setAdapter(adapter);
//        rv_list.setNestedScrollingEnabled(false);
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
        hashMap.put("taskid", taskid);
        hashMap.put("categoryid", typeid + "");
        hashMap.put("apiurl", BaseLinkList.coal_mine + BaseLinkList.MOBLIE_GETSTADCHKITEMTASKLIST);
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
                ReviewInfoBean bean = FastJsonTools.getBean(jsonObject.toString(), ReviewInfoBean.class);
                if (null != bean) {
                    if (bean.getData().getItemlist().size() != 0) {
                        list = bean.getData().getItemlist();
                        adapter.setNewData(list);
                    }
                }
                if (null != refreshLayout) {
                    refreshLayout.finishLoadMore();
                    refreshLayout.finishRefresh();
                }
                Log.d("json", jsonObject.toString());
            }
        });

    }

    @Override
    public void btnClick(View v, int pos, boolean type) {
        list.get(pos).setStates(!type);
        adapter.notifyItemChanged(pos);
    }

    @Override
    public void btnsClick(View v, int pos, int state, boolean type) {

    }

    @Override
    public void btnsClicks(View v, int pos, boolean state, int type) {

    }
}
