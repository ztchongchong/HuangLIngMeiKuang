package com.lingjun.colliery_android.module.dealwith.hiddendanger.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.blankj.utilcode.util.LogUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lingjun.colliery_android.R;
import com.lingjun.colliery_android.base.BaseActivity;
import com.lingjun.colliery_android.base.BaseLinkList;
import com.lingjun.colliery_android.base.OnGlobalListener;
import com.lingjun.colliery_android.bean.HiddenDangerPlanBean;
import com.lingjun.colliery_android.bean.HiddenDangersHandleBean;
import com.lingjun.colliery_android.bean.ResponsibilityBean;
import com.lingjun.colliery_android.bean.TroublehistoryBean;
import com.lingjun.colliery_android.utils.DateUtil;
import com.lingjun.colliery_android.utils.FastJsonTools;
import com.lingjun.colliery_android.utils.RecyclerViewUtils;
import com.lingjun.colliery_android.utils.ToastUtils;
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
 * 隐患历史
 */
public class HiddenDangersHistoryActivity extends BaseActivity {
    private RecyclerView rv_list;
    private SmartRefreshLayout refreshLayout;
    private LinearLayout ll_beijing;
    private ArrayList<TroublehistoryBean.ResultMapsBean.PageBean.ResultsBean> results = new ArrayList<>();


    @Override
    protected int getResourcesId() {
        return R.layout.activity_hidden_dangers_history;
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

        hashMap.put(BaseLinkList.apiurl, BaseLinkList.coal_mine + BaseLinkList.getTroublehistory);
        hashMap.put("page", "" + pageIndex);
        hashMap.put("pageSize", "10");

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
                final TroublehistoryBean troublehistoryBean = FastJsonTools.getBean(jsonObject.toString(), TroublehistoryBean.class);
                if (null != troublehistoryBean) {
                    refreshLayout.setVisibility(View.VISIBLE);
                    ll_beijing.setVisibility(View.GONE);
                    if (pageIndex > 1) {
                        if (null != troublehistoryBean.getResultMaps().get(0).getPage().getResults() && troublehistoryBean.getResultMaps().get(0).getPage().getResults().size() != 0) {
                            BaseQuickAdapter adapter = (BaseQuickAdapter) rv_list.getAdapter();
//                            ArrayList<TroublehistoryBean.ResultMapsBean.PageBean.ResultsBean> data = (ArrayList<TroublehistoryBean.ResultMapsBean.PageBean.ResultsBean>) adapter.getData();
//                            for (int i = 0; i < results.size(); i++) {
//                                data.add(results.get(i));
//                                adapter.notifyItemChanged(data.size() + (i + 1), results.get(i));
//                            }
                            results.addAll(troublehistoryBean.getResultMaps().get(0).getPage().getResults());
                            adapter.notifyDataSetChanged();
                        } else {
                            com.blankj.utilcode.util.ToastUtils.showShort("没有更多数据了!");
                        }
                    } else {
                        if (results.size() != 0) {
                            results.clear();
                        }
                        if (troublehistoryBean.getResultMaps().get(0).getPage().getResults().size() != 0) {
                            results.addAll(troublehistoryBean.getResultMaps().get(0).getPage().getResults());
                            RecyclerViewUtils.initLiner(HiddenDangersHistoryActivity.this, rv_list, R.layout.item_hidden_dangers_history, results, new OnGlobalListener() {
                                @Override
                                public <T> void logic(BaseViewHolder helper, List<T> mData, T item, BaseQuickAdapter mAdapter) {
                                    TroublehistoryBean.ResultMapsBean.PageBean.ResultsBean resultsBean = (TroublehistoryBean.ResultMapsBean.PageBean.ResultsBean) item;

                                    TextView tv_history_name = helper.getView(R.id.tv_history_name);//标题
                                    ImageView iv_history_state = helper.getView(R.id.iv_history_state);//状态
                                    TextView tv_handle_content = helper.getView(R.id.tv_history_content);//内容

                                    tv_handle_content.setText(resultsBean.getSourceDescription());

                                    history_stata(resultsBean, iv_history_state, tv_history_name);
                                }
                            }, new BaseQuickAdapter.OnItemClickListener() {
                                @SuppressLint("ResourceType")
                                @Override
                                public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                                    TroublehistoryBean.ResultMapsBean.PageBean.ResultsBean resultsBean = (TroublehistoryBean.ResultMapsBean.PageBean.ResultsBean) adapter.getData().get(position);

                                    history_tasktype(resultsBean);
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

    private void history_tasktype(TroublehistoryBean.ResultMapsBean.PageBean.ResultsBean resultsBean) {
        switch (resultsBean.getTaskType()) {
            case "8"://现场治理
                Intent intent = new Intent(HiddenDangersHistoryActivity.this, HiddenTroubleDetailsActivity.class);
                intent.putExtra("taskId", "" + resultsBean.getTaskId());
                intent.putExtra("mainId", "0" + resultsBean.getMainId());
                intent.putExtra("state", "" + resultsBean.getState());
                intent.putExtra("deletes", "" + resultsBean.getDeletes());
                intent.putExtra("yinhuanlishi", "0");
                startActivity(intent);
                break;
            case "9"://限时整改
                Intent intent1 = new Intent(HiddenDangersHistoryActivity.this, TimeLimitToBeStoredActivity.class);
                intent1.putExtra("taskId", "" + resultsBean.getTaskId());
                intent1.putExtra("mainId", "0" + resultsBean.getMainId());
                intent1.putExtra("state", "" + resultsBean.getState());
                intent1.putExtra("deletes", "" + resultsBean.getDeletes());
                intent1.putExtra("yinhuanlishi", "0");
                startActivity(intent1);
                break;
            case "10"://挂牌督办
                Intent intent2 = new Intent(HiddenDangersHistoryActivity.this, TimeLimitToBeStoredActivity.class);
                intent2.putExtra("taskId", "" + resultsBean.getTaskId());
                intent2.putExtra("mainId", "0" + resultsBean.getMainId());
                intent2.putExtra("state", "" + resultsBean.getState());
                intent2.putExtra("deletes", "" + resultsBean.getDeletes());
                intent2.putExtra("yinhuanlishi", "0");
                startActivity(intent2);
                break;
            case "11"://隐患升级
                ToastUtils.showToast(this, "未开发");
                break;
            case "12"://重大隐患
                ToastUtils.showToast(this, "未开发");
                break;
            case "7"://隐患任务
                ToastUtils.showToast(this, "未开发");
                break;
            default:
        }
    }

    private void history_stata(TroublehistoryBean.ResultMapsBean.PageBean.ResultsBean resultsBean, ImageView iv_history_state, TextView tv_history_name) {
        switch (resultsBean.getTaskType()) {
            case "7":
                tv_history_name.setText("隐患任务");
                if (resultsBean.getDeletes().equals("0")) {
                    if (resultsBean.getState().equals("5")) {
                        iv_history_state.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.yhls_yxh));
                    } else if (resultsBean.getState().equals("6")) {
                        iv_history_state.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.history_file));
                    }
                } else if (resultsBean.getDeletes().equals("4")) {
                    iv_history_state.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.history_close));
                }
                break;
            case "8":
                tv_history_name.setText("现场治理");
                if (resultsBean.getDeletes().equals("0")) {
                    if (resultsBean.getState().equals("5")) {
                        iv_history_state.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.yhls_yxh));
                    } else if (resultsBean.getState().equals("6")) {
                        iv_history_state.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.history_file));
                    }
                } else if (resultsBean.getDeletes().equals("4")) {
                    iv_history_state.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.history_close));
                }
                break;
            case "9":
                tv_history_name.setText("限时整改");
                if (resultsBean.getDeletes().equals("0")) {
                    if (resultsBean.getState().equals("9")) {
                        iv_history_state.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.yhls_yxh));
                    } else if (resultsBean.getState().equals("10")) {
                        iv_history_state.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.history_file));
                    }
                } else if (resultsBean.getDeletes().equals("4")) {
                    iv_history_state.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.history_close));
                }
                break;
            case "10":
                tv_history_name.setText("挂牌督办");
                if (resultsBean.getDeletes().equals("0")) {
                    if (resultsBean.getState().equals("9")) {
                        iv_history_state.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.yhls_yxh));
                    } else if (resultsBean.getState().equals("10")) {
                        iv_history_state.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.history_file));
                    }
                } else if (resultsBean.getDeletes().equals("4")) {
                    iv_history_state.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.history_close));
                }
                break;
            case "11":
                tv_history_name.setText("隐患升级");
                if (resultsBean.getDeletes().equals("0")) {
                    if (resultsBean.getState().equals("5")) {
                        iv_history_state.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.yhls_yxh));
                    } else if (resultsBean.getState().equals("6")) {
                        iv_history_state.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.history_file));
                    }
                } else if (resultsBean.getDeletes().equals("4")) {
                    iv_history_state.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.history_close));
                }
                break;
            case "12":
                tv_history_name.setText("重大隐患");
                if (resultsBean.getDeletes().equals("0")) {
                    if (resultsBean.getState().equals("5")) {
                        iv_history_state.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.yhls_yxh));
                    } else if (resultsBean.getState().equals("6")) {
                        iv_history_state.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.history_file));
                    }
                } else if (resultsBean.getDeletes().equals("4")) {
                    iv_history_state.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.history_close));
                }
                break;
            default:
        }
    }


    @Override
    protected void onResume() {
        refreshView();
        super.onResume();
    }
}