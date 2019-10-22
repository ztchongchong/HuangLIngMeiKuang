package com.lingjun.colliery_android.module.dealwith.hiddendanger.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.blankj.utilcode.util.LogUtils;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lingjun.colliery_android.R;
import com.lingjun.colliery_android.base.BaseActivity;
import com.lingjun.colliery_android.base.BaseLinkList;
import com.lingjun.colliery_android.base.OnGlobalListener;
import com.lingjun.colliery_android.bean.ResponsibilityBean;
import com.lingjun.colliery_android.module.dealwith.hiddendanger.general_hidden_danger.HiddenDangerPlanActivity;
import com.lingjun.colliery_android.utils.FastJsonTools;
import com.lingjun.colliery_android.utils.RecyclerViewUtils;
import com.lingjun.colliery_android.utils.retrofit.BaseSubscriber;
import com.lingjun.colliery_android.utils.retrofit.ExceptionHandle;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 责任单位
 */
public class ResponsibilityActivity extends BaseActivity {
    public static final int RectifyingCode = 10;
    private RecyclerView rv_list;

    @Override
    protected int getResourcesId() {
        return R.layout.activity_responsibility;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        rv_list = findViewById(R.id.rv_list);
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
        LogUtils.e("当前第" + pageIndex + "页");

        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(BaseLinkList.apiurl, BaseLinkList.coal_mine + BaseLinkList.hidden_responsibility);
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
                LogUtils.e("列表->>" + jsonObject.toString());

                final ResponsibilityBean responsibilityBean = FastJsonTools.getBean(jsonObject.toString(), ResponsibilityBean.class);
                if (null != responsibilityBean && null != responsibilityBean.getMsg() && null != responsibilityBean.getResultMaps()) {
                    final ArrayList<ResponsibilityBean.ResultMapsBean> results = (ArrayList<ResponsibilityBean.ResultMapsBean>) responsibilityBean.getResultMaps();
                    final ResponsibilityBean.DataBean dataBean = responsibilityBean.getData();
                    if (pageIndex > 1) {
                        if (null != results && results.size() != 0) {
                            BaseQuickAdapter adapter = (BaseQuickAdapter) rv_list.getAdapter();
                            ArrayList<ResponsibilityBean.ResultMapsBean> data = (ArrayList<ResponsibilityBean.ResultMapsBean>) adapter.getData();
                            for (int i = 0; i < results.size(); i++) {
                                data.add(results.get(i));
                                adapter.notifyItemChanged(data.size() + (i + 1), results.get(i));
                            }
                        } else {
                            com.blankj.utilcode.util.ToastUtils.showShort("没有更多数据了!");
                        }
                    } else {
                        RecyclerViewUtils.initLiner(ResponsibilityActivity.this, rv_list, R.layout.item_hidden_danger_paln, results, new OnGlobalListener() {
                            @Override
                            public <T> void logic(BaseViewHolder helper, List<T> mData, T item, BaseQuickAdapter mAdapter) {
                                ResponsibilityBean.ResultMapsBean resultsBean = (ResponsibilityBean.ResultMapsBean) item;

                                TextView ll_plan = helper.getView(R.id.ll_plan);
                                ll_plan.setText(resultsBean.getName());

                            }
                        }, new BaseQuickAdapter.OnItemClickListener() {
                            @SuppressLint("ResourceType")
                            @Override
                            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                                ResponsibilityBean.ResultMapsBean resultsBean = (ResponsibilityBean.ResultMapsBean) adapter.getData().get(position);
                                Intent intent = new Intent();
                                intent.putExtra("technicianInfo", "" + resultsBean.getTechnicianInfo().getName());//技术人员
                                intent.putExtra("technician_id", "" + resultsBean.getTechnician_id());//技术人员ID
                                intent.putExtra("processorInfo", "" + resultsBean.getProcessorInfo().getName());//处理人
                                intent.putExtra("department_id", "" + resultsBean.getDepartment_id());//部门ID
                                intent.putExtra("processor_id", "" + resultsBean.getProcessor_id());//处理人ID
                                Log.e("责任人id", "" + resultsBean.getProcessor_id());
                                intent.putExtra("leader_id", "" + resultsBean.getLeader_id());//部门领导ID
                                intent.putExtra("name", "" + resultsBean.getName());//责任单位
                                intent.putExtra("leaderInfo", "" + resultsBean.getLeaderInfo().getName());//领导
                                intent.putExtra("rectificationPersonnelFlag", "" + dataBean.getRectificationPersonnelFlag());//整改人单选or多选
                                intent.putExtra("ResponsibleLeaderId", resultsBean.getResponsibleLeaderId() + "");
                                intent.putExtra("ResponsibleLeaderinfo", resultsBean.getResponsibleLeaderinfo().getName() + "");
                                setResult(RectifyingCode, intent);
                                finish();
                            }
                        }, null);
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
