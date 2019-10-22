package com.lingjun.colliery_android.module.document.activity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
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
import com.lingjun.colliery_android.bean.HiddenDangerPlanBean;
import com.lingjun.colliery_android.bean.TaskTrackingBean;
import com.lingjun.colliery_android.module.dealwith.hiddendanger.general_hidden_danger.HiddenDangerPlanActivity;
import com.lingjun.colliery_android.utils.DateUtil;
import com.lingjun.colliery_android.utils.FastJsonTools;
import com.lingjun.colliery_android.utils.RecyclerViewUtils;
import com.lingjun.colliery_android.utils.retrofit.BaseSubscriber;
import com.lingjun.colliery_android.utils.retrofit.ExceptionHandle;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 作者: zengtao
 * 时间: 2019/2/15  16:43.
 * 注释: 任务跟踪
 */
public class TaskTrackingActivity extends BaseActivity {

    private RecyclerView rv_list;
    private SmartRefreshLayout refreshLayout;
    private LinearLayout ll_beijing;
    private ArrayList<TaskTrackingBean.ResultMapsBean> results = new ArrayList<>();

    @Override
    protected int getResourcesId() {
        return R.layout.activity_tasktracking;
    }

    @Override
    protected void init(Bundle savedInstanceState) throws PackageManager.NameNotFoundException {
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
        hashMap.put("pageNum", pageIndex + "");
        hashMap.put("pageSize", "10");
        hashMap.put(BaseLinkList.apiurl, BaseLinkList.coal_mine + BaseLinkList.getTaskfollowList);

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

                final TaskTrackingBean taskTrackingBean = FastJsonTools.getBean(jsonObject.toString(), TaskTrackingBean.class);
                if (null != taskTrackingBean && null != taskTrackingBean.getMsg() && null != taskTrackingBean.getCode() && null != taskTrackingBean.getResultMaps()) {
                    results = (ArrayList<TaskTrackingBean.ResultMapsBean>) taskTrackingBean.getResultMaps();
                    refreshLayout.setVisibility(View.VISIBLE);
                    ll_beijing.setVisibility(View.GONE);
                    if (pageIndex > 1) {
                        if (null != taskTrackingBean.getResultMaps() && taskTrackingBean.getResultMaps().size() != 0) {
                            BaseQuickAdapter adapter = (BaseQuickAdapter) rv_list.getAdapter();
//                            ArrayList<TaskTrackingBean.ResultMapsBean> data = (ArrayList<TaskTrackingBean.ResultMapsBean>) adapter.getData();
//                            for (int i = 0; i < results.size(); i++) {
//                                data.add(results.get(i));
//                                adapter.notifyItemChanged(data.size() + (i + 1), results.get(i));
//                            }
                            results.addAll(taskTrackingBean.getResultMaps());
                            adapter.notifyDataSetChanged();
                        } else {
                            ToastUtils.showShort("没有更多数据了!");
                        }
                    } else {
                        if (results.size() != 0) {
                            results.clear();
                        }
                        if (taskTrackingBean.getResultMaps().size() != 0) {
                            results.addAll(taskTrackingBean.getResultMaps());
                            RecyclerViewUtils.initLiner(TaskTrackingActivity.this, rv_list, R.layout.item_task_tracking, results, new OnGlobalListener() {
                                @Override
                                public <T> void logic(BaseViewHolder helper, List<T> mData, T item, BaseQuickAdapter mAdapter) {
                                    TaskTrackingBean.ResultMapsBean resultsBean = (TaskTrackingBean.ResultMapsBean) item;
                                    TextView tv_name = helper.getView(R.id.tv_name);
                                    tv_name.setText(resultsBean.getTitle());
                                    TextView tv_content = helper.getView(R.id.tv_content);
                                    tv_content.setText(resultsBean.getDescription());
                                    TextView tv_founder = helper.getView(R.id.tv_founder);
                                    TextView tv_time = helper.getView(R.id.tv_time);
//                                    tv_time.setText(DateUtil.getStringByFormat(resultsBean, "yyyy-MM-dd"));
                                    ImageView iv_state = helper.getView(R.id.iv_state);
                                    if (resultsBean.getState().equals("1")) {
                                        iv_state.setImageResource(R.drawable.delete1);
                                    } else if (resultsBean.getState().equals("2")) {

                                    }
                                }
                            }, new BaseQuickAdapter.OnItemClickListener() {
                                @Override
                                public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                                    TaskTrackingBean.ResultMapsBean resultsBean = (TaskTrackingBean.ResultMapsBean) adapter.getData().get(position);
                                    Intent intent = new Intent(TaskTrackingActivity.this, TaskTrackingLIstActivity.class);
                                    intent.putExtra("taskId", resultsBean.getId() + "");
                                    startActivity(intent);
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

}
