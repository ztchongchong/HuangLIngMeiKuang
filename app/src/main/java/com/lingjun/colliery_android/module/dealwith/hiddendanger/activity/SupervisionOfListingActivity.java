package com.lingjun.colliery_android.module.dealwith.hiddendanger.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.blankj.utilcode.util.LogUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lingjun.colliery_android.R;
import com.lingjun.colliery_android.base.BaseActivity;
import com.lingjun.colliery_android.base.BaseLinkList;
import com.lingjun.colliery_android.base.OnGlobalListener;
import com.lingjun.colliery_android.bean.HiddenDangersHandleBean;
import com.lingjun.colliery_android.bean.SupervisionOfListingBean;
import com.lingjun.colliery_android.module.dealwith.hiddendanger.upervise.AcceptanceActivity;
import com.lingjun.colliery_android.module.dealwith.hiddendanger.upervise.PendingStorageActivity;
import com.lingjun.colliery_android.utils.DateUtil;
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
 * 挂牌督办
 */
public class SupervisionOfListingActivity extends BaseActivity {

    private SmartRefreshLayout refreshLayout;
    private LinearLayout ll_beijing;
    private RecyclerView rv_list;
    private String supervision;
    private ArrayList<HiddenDangersHandleBean.ResultMapsBean> results = new ArrayList<>();


    @Override
    protected int getResourcesId() {
        return R.layout.activity_supervision_of_listing;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        rv_list = findViewById(R.id.rv_list);
        refreshLayout = findViewById(R.id.refreshLayout);
        ll_beijing = findViewById(R.id.ll_beijing);

        ll_beijing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                refreshLayout.autoRefresh();
                refreshLayout.setVisibility(View.VISIBLE);
                ll_beijing.setVisibility(View.GONE);
            }
        });
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

    @Override
    protected void onResume() {
        super.onResume();
        if (refreshLayout != null) {
            refreshLayout.autoRefresh();
        }
    }

    private void refreshView() {
        LogUtils.e("当前第" + pageIndex + "页");

        HashMap<String, String> hashMap = new HashMap<>();

        hashMap.put("pageNum", "" + pageIndex);
        hashMap.put("pageSize", "10");
        hashMap.put("taskType", "10");
        hashMap.put(BaseLinkList.apiurl, BaseLinkList.coal_mine + BaseLinkList.hidden_handle);

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

                final HiddenDangersHandleBean hiddenDangersHandleBean = FastJsonTools.getBean(jsonObject.toString(), HiddenDangersHandleBean.class);
                if (null != hiddenDangersHandleBean && null != hiddenDangersHandleBean.getData() && null != hiddenDangersHandleBean.getData() && null != hiddenDangersHandleBean.getResultMaps()) {
                    refreshLayout.setVisibility(View.VISIBLE);
                    ll_beijing.setVisibility(View.GONE);
                    if (pageIndex > 1) {
                        if (null != hiddenDangersHandleBean.getResultMaps() && hiddenDangersHandleBean.getResultMaps().size() != 0) {
                            BaseQuickAdapter adapter = (BaseQuickAdapter) rv_list.getAdapter();
//                            ArrayList<HiddenDangersHandleBean.ResultMapsBean> data = (ArrayList<HiddenDangersHandleBean.ResultMapsBean>) adapter.getData();
//                            for (int i = 0; i < results.size(); i++) {
//                                data.add(results.get(i));
//                                adapter.notifyItemChanged(data.size() + (i + 1), results.get(i));
//                            }
                            results.addAll( hiddenDangersHandleBean.getResultMaps());
                            adapter.notifyDataSetChanged();
                        } else {
                            com.blankj.utilcode.util.ToastUtils.showShort("没有更多数据了!");
                        }
                    } else {
                        if (results.size() != 0) {
                            results.clear();
                        }
                        if (hiddenDangersHandleBean.getResultMaps().size() != 0) {
                            results.addAll(hiddenDangersHandleBean.getResultMaps());
                            RecyclerViewUtils.initLiner(SupervisionOfListingActivity.this, rv_list, R.layout.item_hidden_dangers_handle, results, new OnGlobalListener() {
                                @Override
                                public <T> void logic(BaseViewHolder helper, List<T> mData, T item, BaseQuickAdapter mAdapter) {
                                    HiddenDangersHandleBean.ResultMapsBean resultsBean = (HiddenDangersHandleBean.ResultMapsBean) item;
//
                                    TextView tv_handle_name = helper.getView(R.id.tv_handle_name);
                                    TextView tv_handle_state = helper.getView(R.id.tv_handle_state);
                                    TextView tv_handle_content = helper.getView(R.id.tv_handle_content);
                                    TextView tv_handle_time = helper.getView(R.id.tv_handle_time);
                                    tv_handle_state.setText(resultsBean.getStateFlag());
                                    tv_handle_content.setText(resultsBean.getTrouble_content());
                                    //状态初始化
                                    checkTaskTypeToView(resultsBean, tv_handle_name);
                                    tv_handle_time.setText(DateUtil.getStringByFormat(resultsBean.getCreateTime(), "yyyy-MM-dd"));

                                }
                            }, new BaseQuickAdapter.OnItemClickListener() {
                                @SuppressLint("ResourceType")
                                @Override
                                public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                                    HiddenDangersHandleBean.ResultMapsBean resultsBean = (HiddenDangersHandleBean.ResultMapsBean) adapter.getData().get(position);
                                    if ("6".equals(resultsBean.getState()) && "10".equals(resultsBean.getTaskType())) { //验收中
                                        Intent intent = new Intent(SupervisionOfListingActivity.this, AcceptanceActivity.class);
                                        intent.putExtra("taskMainId", "" + resultsBean.getMainId());
                                        intent.putExtra("taskId", "" + resultsBean.getTask_id());
                                        intent.putExtra("state", "" + resultsBean.getState());
                                        intent.putExtra("taskType", "" + resultsBean.getTaskType());
                                        intent.putExtra("title", "" + resultsBean.getStateFlag());
                                        startActivity(intent);
                                    } else if ("8".equals(resultsBean.getState()) && "10".equals(resultsBean.getTaskType())) { //待销号
                                        Intent intent = new Intent(SupervisionOfListingActivity.this, AcceptanceActivity.class);
                                        intent.putExtra("taskMainId", "" + resultsBean.getMainId());
                                        intent.putExtra("taskId", "" + resultsBean.getTask_id());
                                        intent.putExtra("state", "" + resultsBean.getState());
                                        intent.putExtra("taskType", "" + resultsBean.getTaskType());
                                        intent.putExtra("title", "" + resultsBean.getStateFlag());
                                        startActivity(intent);
                                    } else if ("5".equals(resultsBean.getState()) && "10".equals(resultsBean.getTaskType())) { //整改中
                                        Intent intent_5 = new Intent(SupervisionOfListingActivity.this, PendingStorageActivity.class);
                                        intent_5.putExtra("taskMainId", "" + resultsBean.getMainId());
                                        intent_5.putExtra("taskId", "" + resultsBean.getTask_id());
                                        intent_5.putExtra("state", "" + resultsBean.getState());
                                        intent_5.putExtra("taskType", "" + resultsBean.getTaskType());
                                        intent_5.putExtra("title", "" + resultsBean.getStateFlag());
                                        startActivity(intent_5);
                                    }
                                }
                            }, null);
                        } else {
                            refreshLayout.setVisibility(View.GONE);
                            ll_beijing.setVisibility(View.VISIBLE);
                        }
                    }
                }
                if (null != refreshLayout) {
                    refreshLayout.finishRefresh();
                    refreshLayout.finishLoadMore();
                }
            }
        });
    }

    private void checkTaskTypeToView(HiddenDangersHandleBean.ResultMapsBean resultsBean, TextView tv_handle_name) {
        switch (resultsBean.getTaskType()) {
            case "7":
                tv_handle_name.setText("一般隐患");
                break;
            case "8":
                tv_handle_name.setText("现场治理");
                break;
            case "9":
                tv_handle_name.setText("限时整改");
                break;
            case "10":
                tv_handle_name.setText("挂牌督办");
                break;
            case "11":
                tv_handle_name.setText("隐患升级");
                break;
            case "12":
                tv_handle_name.setText("重大隐患");
                break;
            default:
        }
    }

}
