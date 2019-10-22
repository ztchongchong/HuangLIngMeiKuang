package com.lingjun.colliery_android.module.dealwith.hiddendanger.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lingjun.colliery_android.R;
import com.lingjun.colliery_android.base.BaseActivity;
import com.lingjun.colliery_android.base.BaseLinkList;
import com.lingjun.colliery_android.base.OnGlobalListener;
import com.lingjun.colliery_android.bean.HiddenDangersHandleBean;
import com.lingjun.colliery_android.module.dealwith.hiddendanger.upervise.PendingStorageActivity;
import com.lingjun.colliery_android.module.main.rectifyingviolations.ToBeStoredActivity;
import com.lingjun.colliery_android.utils.DateUtil;
import com.lingjun.colliery_android.utils.FastJsonTools;
import com.lingjun.colliery_android.utils.RecyclerViewUtils;
import com.lingjun.colliery_android.utils.retrofit.BaseSubscriber;
import com.lingjun.colliery_android.utils.retrofit.ExceptionHandle;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import org.json.JSONObject;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * 隐患处理
 */
public class HiddenDangersHandleActivity extends BaseActivity {
    private RecyclerView rv_list;
    private SmartRefreshLayout refreshLayout;
    private LinearLayout ll_beijing;
    private ArrayList<HiddenDangersHandleBean.ResultMapsBean> results = new ArrayList<>();

    @Override
    protected int getResourcesId() {
        return R.layout.activity_hidden_dangers_handle;
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

    private void refreshView() {
        LogUtils.e("当前第" + pageIndex + "页");
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(BaseLinkList.apiurl, BaseLinkList.coal_mine + BaseLinkList.hidden_handle);
        hashMap.put("pageNum", "" + pageIndex);
        hashMap.put("pageSize", "6");
        hashMap.put("taskSource", "0");

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
                    ll_beijing.setVisibility(View.GONE);
                    refreshLayout.setVisibility(View.VISIBLE);
                    if (pageIndex > 1) {
                        if (null != hiddenDangersHandleBean.getResultMaps() && hiddenDangersHandleBean.getResultMaps().size() != 0) {
                            BaseQuickAdapter adapter = (BaseQuickAdapter) rv_list.getAdapter();
//                            ArrayList<HiddenDangersHandleBean.ResultMapsBean> data = (ArrayList<HiddenDangersHandleBean.ResultMapsBean>) adapter.getData();
//                            for (int i = 0; i < hiddenDangersHandleBean.getResultMaps().size(); i++) {
                            results.addAll(hiddenDangersHandleBean.getResultMaps());
//                                adapter.notifyItemChanged(results.size() + (i + 1),  hiddenDangersHandleBean.getResultMaps().get(i));
//                            }
                            adapter.notifyDataSetChanged();
                        }
                    } else {
                        if (results.size() != 0) {
                            results.clear();
                        }
                        if (hiddenDangersHandleBean.getResultMaps().size() != 0) {
                            results.addAll(hiddenDangersHandleBean.getResultMaps());
                            RecyclerViewUtils.initLiner(HiddenDangersHandleActivity.this, rv_list, R.layout.item_hidden_dangers_handle, results, new OnGlobalListener() {
                                @SuppressLint("ResourceAsColor")
                                @Override
                                public <T> void logic(BaseViewHolder helper, List<T> mData, T item, BaseQuickAdapter mAdapter) {
                                    HiddenDangersHandleBean.ResultMapsBean resultsBean = (HiddenDangersHandleBean.ResultMapsBean) item;

                                    TextView tv_handle_name = helper.getView(R.id.tv_handle_name);//标题
                                    TextView tv_handle_state = helper.getView(R.id.tv_handle_state);//状态
                                    TextView tv_handle_content = helper.getView(R.id.tv_handle_content);//内容
                                    TextView tv_handle_time = helper.getView(R.id.tv_handle_time);//时间

                                    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                                    Date d1 = new Date(resultsBean.getCreateTime());
                                    String t1 = format.format(d1);
                                    tv_handle_time.setText(t1);

                                    tv_handle_state.setText(resultsBean.getStateFlag());
                                    tv_handle_content.setText(resultsBean.getSource_description());
                                    tv_handle_time.setText(DateUtil.getStringByFormat(resultsBean.getCreateTime(), "yyyy-MM-dd"));
                                    //状态初始化
                                    checkTaskTypeToView(resultsBean, tv_handle_name, tv_handle_content, tv_handle_time);


                                }
                            }, new BaseQuickAdapter.OnItemClickListener() {
                                @SuppressLint("ResourceType")
                                @Override
                                public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                                    HiddenDangersHandleBean.ResultMapsBean resultsBean = (HiddenDangersHandleBean.ResultMapsBean) adapter.getData().get(position);
                                    checkTaskType(resultsBean);
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

    private void checkTaskTypeToView(HiddenDangersHandleBean.ResultMapsBean resultsBean, TextView tv_handle_name, TextView tv_handle_content, TextView tv_handle_time) {
        switch (resultsBean.getTaskType()) {
            case "7":
                tv_handle_name.setText("一般隐患");
                tv_handle_name.setTextColor(Color.BLACK);
                tv_handle_content.setTextColor(Color.BLACK);
                tv_handle_time.setTextColor(Color.BLACK);
                break;
            case "8":
                tv_handle_name.setText("现场治理");
                tv_handle_name.setTextColor(Color.BLACK);
                tv_handle_content.setTextColor(Color.BLACK);
                tv_handle_time.setTextColor(Color.BLACK);
                break;
            case "9":
                tv_handle_name.setText("限时整改");
                tv_handle_name.setTextColor(Color.BLACK);
                tv_handle_content.setTextColor(Color.BLACK);
                tv_handle_time.setTextColor(Color.BLACK);
                break;
            case "10":
                tv_handle_name.setText("挂牌督办");
                if (resultsBean.getIsupgrad() == 1) {
                    tv_handle_name.setTextColor(Color.RED);
                    tv_handle_content.setTextColor(Color.RED);
                    tv_handle_time.setTextColor(Color.RED);
                } else {
                    tv_handle_name.setTextColor(Color.BLACK);
                    tv_handle_content.setTextColor(Color.BLACK);
                    tv_handle_time.setTextColor(Color.BLACK);
                }
                break;
            case "11":
                tv_handle_name.setText("隐患升级");
                tv_handle_name.setTextColor(Color.BLACK);
                tv_handle_content.setTextColor(Color.BLACK);
                tv_handle_time.setTextColor(Color.BLACK);
                break;
            case "12":
                tv_handle_name.setText("重大隐患");
                tv_handle_name.setTextColor(Color.BLACK);
                tv_handle_content.setTextColor(Color.BLACK);
                tv_handle_time.setTextColor(Color.BLACK);
                break;
            default:
        }
    }

    private void checkTaskType(HiddenDangersHandleBean.ResultMapsBean resultsBean) {
        switch (resultsBean.getTaskType()) {
            case "7"://一般隐患
                if (resultsBean.getState().equals("1")) {//待处理
                    Intent intent = new Intent(HiddenDangersHandleActivity.this, HiddenDangersDetailsActivity.class);
                    intent.putExtra("task_id", "" + resultsBean.getTask_id());
                    intent.putExtra("mainId", "" + resultsBean.getMainId());
                    intent.putExtra("jilu", "1");
                    startActivity(intent);
                }
                break;
            case "8"://现场治理
                switch (resultsBean.getState()) {
                    case "2"://审核中
                        Intent intent = new Intent(HiddenDangersHandleActivity.this, FieldManagementActivity.class);
                        intent.putExtra("现场治理", "2");
                        intent.putExtra("taskMainId", "" + resultsBean.getMainId());
                        intent.putExtra("taskId", "" + resultsBean.getTask_id());
                        startActivity(intent);
                        break;
                    case "3"://被驳回
                        Intent intent_1 = new Intent(HiddenDangersHandleActivity.this, HiddenTroubleDetailsActivity.class);
                        intent_1.putExtra("taskMainId", "" + resultsBean.getMainId());
                        intent_1.putExtra("taskId", "" + resultsBean.getTask_id());
                        intent_1.putExtra("state", "" + resultsBean.getState());
                        startActivity(intent_1);
                        break;
                    case "4"://带销号
                        Intent intent_2 = new Intent(HiddenDangersHandleActivity.this, HiddenTroubleDetailsActivity.class);
                        intent_2.putExtra("taskMainId", "" + resultsBean.getMainId());
                        intent_2.putExtra("taskId", "" + resultsBean.getTask_id());
                        intent_2.putExtra("state", "" + resultsBean.getState());
                        intent_2.putExtra("yinhuanlishi", "1");
                        startActivity(intent_2);
                        break;
                    default:
                }
                break;
            case "9"://限时整改
                switch (resultsBean.getState()) {
                    case "3"://被驳回
                        Intent intent_2 = new Intent(HiddenDangersHandleActivity.this, HiddenTroubleDetailsActivity.class);
                        intent_2.putExtra("taskMainId", "" + resultsBean.getMainId());
                        intent_2.putExtra("taskId", "" + resultsBean.getTask_id());
                        intent_2.putExtra("state", "" + resultsBean.getState());
                        startActivity(intent_2);
                        break;
                    case "2"://审核中
                    case "4"://确认中
                    case "5": //整改中
                    case "6": //验收中
                    case "7": //验收驳回
                    case "11": //延期领导待审核
                    case "12": //延期处理人待审核
                    case "13": //延期中
                        Intent intent_5 = new Intent(HiddenDangersHandleActivity.this, PendingStorageActivity.class);
                        intent_5.putExtra("taskMainId", "" + resultsBean.getMainId());
                        intent_5.putExtra("taskId", "" + resultsBean.getTask_id());
                        intent_5.putExtra("state", "" + resultsBean.getState());
                        intent_5.putExtra("taskType", "" + resultsBean.getTaskType());
                        intent_5.putExtra("title", "" + resultsBean.getStateFlag());
                        startActivity(intent_5);
                        break;
                    case "8"://带销号
                        Intent intent_3 = new Intent(HiddenDangersHandleActivity.this, TimeLimitToBeStoredActivity.class);
                        intent_3.putExtra("taskMainId", "" + resultsBean.getMainId());
                        intent_3.putExtra("taskId", "" + resultsBean.getTask_id());
                        intent_3.putExtra("state", "" + resultsBean.getState());
                        intent_3.putExtra("yinhuanlishi", "1");
                        startActivity(intent_3);
                        break;
                    default:
                }
                break;
            case "10"://挂牌督办
                switch (resultsBean.getState()) {
                    case "3": //被驳回
                        Intent intent_3 = new Intent(HiddenDangersHandleActivity.this, HiddenTroubleDetailsActivity.class);
                        intent_3.putExtra("taskMainId", "" + resultsBean.getMainId());
                        intent_3.putExtra("taskId", "" + resultsBean.getTask_id());
                        intent_3.putExtra("state", "" + resultsBean.getState());
                        startActivity(intent_3);
                        break;
                    case "2"://审核中
                    case "4"://确认中
                    case "5": //整改中
                    case "6": //验收中
                    case "7": //验收驳回
                    case "11": //延期领导待审核
                    case "12": //延期处理人待审核
                    case "13": //延期中
                        Intent intent_5 = new Intent(HiddenDangersHandleActivity.this, PendingStorageActivity.class);
                        intent_5.putExtra("taskMainId", "" + resultsBean.getMainId());
                        intent_5.putExtra("taskId", "" + resultsBean.getTask_id());
                        intent_5.putExtra("state", "" + resultsBean.getState());
                        intent_5.putExtra("taskType", "" + resultsBean.getTaskType());
                        intent_5.putExtra("title", "" + resultsBean.getStateFlag());
                        startActivity(intent_5);
                        break;
                    case "8": //带销号
                        Intent intent_4 = new Intent(HiddenDangersHandleActivity.this, TimeLimitToBeStoredActivity.class);
                        intent_4.putExtra("taskMainId", "" + resultsBean.getMainId());
                        intent_4.putExtra("taskId", "" + resultsBean.getTask_id());
                        intent_4.putExtra("state", "" + resultsBean.getState());
                        intent_4.putExtra("yinhuanlishi", "1");
                        startActivity(intent_4);
                        break;
                    default:
                }

                break;
            case "11"://隐患升级
                switch (resultsBean.getState()) {
                    case "2": //待审核
                        Intent intent_5 = new Intent(HiddenDangersHandleActivity.this, PendingStorageActivity.class);
                        intent_5.putExtra("taskMainId", "" + resultsBean.getMainId());
                        intent_5.putExtra("taskId", "" + resultsBean.getTask_id());
                        intent_5.putExtra("state", "" + resultsBean.getState());
                        intent_5.putExtra("taskType", "" + resultsBean.getTaskType());
                        intent_5.putExtra("title", "" + resultsBean.getStateFlag());
                        startActivity(intent_5);
                        break;
                    case "3": //被驳回
                        Intent intent_3 = new Intent(HiddenDangersHandleActivity.this, HiddenTroubleDetailsActivity.class);
                        intent_3.putExtra("taskMainId", "" + resultsBean.getMainId());
                        intent_3.putExtra("taskId", "" + resultsBean.getTask_id());
                        intent_3.putExtra("state", "" + resultsBean.getState());
                        intent_3.putExtra("taskType", "" + resultsBean.getTaskType());
                        intent_3.putExtra("title", "" + resultsBean.getStateFlag());
                        startActivity(intent_3);
                        break;
                    default:
                }
                break;
            case "12"://重大隐患
                switch (resultsBean.getState()) {
                    case "1"://待处理
                    case "2"://审核中
                    case "3"://被驳回
                    case "4"://带销号
                    case "12"://延期申请
                    case "13"://延期中
                        ToastUtils.showShort("更新中");
                        break;
                    default:
                }
                break;
            default:
        }
    }

    @Override
    protected void onResume() {
        refreshLayout.autoRefresh();
        super.onResume();
    }
}
