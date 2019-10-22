package com.lingjun.colliery_android.module.dealwith.hiddendanger.general_hidden_danger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lingjun.colliery_android.R;
import com.lingjun.colliery_android.base.BaseActivity;
import com.lingjun.colliery_android.base.BaseLinkList;
import com.lingjun.colliery_android.base.OnGlobalListener;
import com.lingjun.colliery_android.bean.HiddenDangerPlanBean;
import com.lingjun.colliery_android.utils.FastJsonTools;
import com.lingjun.colliery_android.utils.RecyclerViewUtils;
import com.lingjun.colliery_android.utils.retrofit.BaseSubscriber;
import com.lingjun.colliery_android.utils.retrofit.ExceptionHandle;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 隐患计划
 */
public class HiddenDangerPlanActivity extends BaseActivity {
    public static final int HiddenDangerCode = 1;

    private RecyclerView rv_list;
    private SmartRefreshLayout refreshLayout;
    private LinearLayout ll_beijing;

    @Override
    protected int getResourcesId() {
        return R.layout.activity_hidden_danger_paln;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        rv_list = findViewById(R.id.rv_list);
        refreshLayout = findViewById(R.id.refreshLayout);
        ll_beijing = findViewById(R.id.ll_beijing);
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

    private void refreshView() {

        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(BaseLinkList.apiurl, BaseLinkList.coal_mine + BaseLinkList.hidden_plan);

        mRetrofit.JsonToColliery(BaseLinkList.Base_Url, hashMap, new BaseSubscriber() {
            @Override
            public void onError(ExceptionHandle.ResponeThrowable e) {
                refreshLayout.setVisibility(View.GONE);
                ll_beijing.setVisibility(View.VISIBLE);
                if (null != refreshLayout) {
                    refreshLayout.finishRefresh();
                    refreshLayout.finishLoadMore();
                }
            }

            @Override
            public void onSuccess(JSONObject jsonObject) {
                LogUtils.e("列表->>" + jsonObject.toString());

                final HiddenDangerPlanBean hiddenDangerPlanBean = FastJsonTools.getBean(jsonObject.toString(), HiddenDangerPlanBean.class);
                if (null != hiddenDangerPlanBean && null != hiddenDangerPlanBean.getMsg() && null != hiddenDangerPlanBean.getCode() && null != hiddenDangerPlanBean.getResultMaps()) {
                    refreshLayout.setVisibility(View.VISIBLE);
                    ll_beijing.setVisibility(View.GONE);
                    final ArrayList<HiddenDangerPlanBean.ResultMapsBean.PlanlistBean> results = (ArrayList<HiddenDangerPlanBean.ResultMapsBean.PlanlistBean>) hiddenDangerPlanBean.getResultMaps().get(0).getPlanlist();
                    if (results.size() != 0) {
                        RecyclerViewUtils.initLiner(HiddenDangerPlanActivity.this, rv_list, R.layout.item_hidden_danger_paln, results, new OnGlobalListener() {
                            @Override
                            public <T> void logic(BaseViewHolder helper, List<T> mData, T item, BaseQuickAdapter mAdapter) {
                                HiddenDangerPlanBean.ResultMapsBean.PlanlistBean resultsBean = (HiddenDangerPlanBean.ResultMapsBean.PlanlistBean) item;
                                TextView ll_plan = helper.getView(R.id.ll_plan);
                                ll_plan.setText(resultsBean.getPlanName());
                            }
                        }, new BaseQuickAdapter.OnItemClickListener() {
                            @Override
                            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                                HiddenDangerPlanBean.ResultMapsBean.PlanlistBean resultsBean = (HiddenDangerPlanBean.ResultMapsBean.PlanlistBean) adapter.getData().get(position);
                                Intent intent = new Intent();
                                intent.putExtra("隐患计划", "" + resultsBean.getPlanName());
                                intent.putExtra("隐患计划ID", "" + resultsBean.getId());
                                setResult(HiddenDangerCode, intent);
                                finish();
                            }
                        }, null);
                    } else {
                        refreshLayout.setVisibility(View.GONE);
                        ll_beijing.setVisibility(View.VISIBLE);
                    }
                }
                if (null != refreshLayout) {
                    refreshLayout.finishRefresh();
                    refreshLayout.finishLoadMore();
                }
            }
        });

    }
}
