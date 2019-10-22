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
import com.lingjun.colliery_android.bean.HiddenDangersHandleBean;
import com.lingjun.colliery_android.bean.SurveyRecordBean;
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
 * 排查记录
 */
public class SurveyRecordActivity extends BaseActivity {
    private SmartRefreshLayout refreshLayout;
    private LinearLayout ll_beijing;
    private RecyclerView rv_list;
    private ArrayList<SurveyRecordBean.ResultMapsBean> results = new ArrayList<>();

    @Override
    protected int getResourcesId() {
        return R.layout.activity_survey_record;
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

        hashMap.put(BaseLinkList.apiurl, BaseLinkList.coal_mine + BaseLinkList.getclauselist);
        hashMap.put("pageNum", "" + pageIndex);
        hashMap.put("pageSize", "20");

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

                final SurveyRecordBean surveyRecordBean = FastJsonTools.getBean(jsonObject.toString(), SurveyRecordBean.class);
                if (null != surveyRecordBean && null != surveyRecordBean.getData() && null != surveyRecordBean.getData() && null != surveyRecordBean.getResultMaps()) {
                    refreshLayout.setVisibility(View.VISIBLE);
                    ll_beijing.setVisibility(View.GONE);
                    if (pageIndex > 1) {
                        if (null != surveyRecordBean.getResultMaps() && surveyRecordBean.getResultMaps().size() != 0) {
                            BaseQuickAdapter adapter = (BaseQuickAdapter) rv_list.getAdapter();
//                            ArrayList<SurveyRecordBean.ResultMapsBean> data = (ArrayList<SurveyRecordBean.ResultMapsBean>) adapter.getData();
//                            for (int i = 0; i < results.size(); i++) {
//                                data.add(results.get(i));
//                                adapter.notifyItemChanged(data.size() + (i + 1), results.get(i));
//                            }
                            results.addAll(surveyRecordBean.getResultMaps());
                            adapter.notifyDataSetChanged();
                        } else {
                            com.blankj.utilcode.util.ToastUtils.showShort("没有更多数据了!");
                        }
                    } else {
                        if (results.size() != 0) {
                            results.clear();
                        }
                        if (surveyRecordBean.getResultMaps().size() != 0) {
                            results.addAll(surveyRecordBean.getResultMaps());
                            RecyclerViewUtils.initLiner(SurveyRecordActivity.this, rv_list, R.layout.item_troubleshooting, results, new OnGlobalListener() {
                                @Override
                                public <T> void logic(BaseViewHolder helper, List<T> mData, T item, BaseQuickAdapter mAdapter) {
                                    SurveyRecordBean.ResultMapsBean resultsBean = (SurveyRecordBean.ResultMapsBean) item;
                                    TextView tv_handle_name = helper.getView(R.id.tv_handle_name);//标题
                                    ImageView iv_handle_state = helper.getView(R.id.tv_handle_state);//状态
                                    TextView tv_handle_content = helper.getView(R.id.tv_handle_content);//内容
                                    TextView tv_handle_time = helper.getView(R.id.tv_handle_time);//时间

                                    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                                    Date d1 = new Date(resultsBean.getCreate_time());
                                    String t1 = format.format(d1);

                                    tv_handle_time.setText(t1);
                                    tv_handle_content.setText(resultsBean.getClause_description());//内容

                                    taskType(resultsBean, tv_handle_name, iv_handle_state);
                                }
                            }, new BaseQuickAdapter.OnItemClickListener() {
                                @SuppressLint("ResourceType")
                                @Override
                                public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                                    SurveyRecordBean.ResultMapsBean resultMapsBean = (SurveyRecordBean.ResultMapsBean) adapter.getData().get(position);
                                    Intent intent = new Intent(SurveyRecordActivity.this, HiddenDangersDetailsActivity.class);
                                    intent.putExtra("task_id", "" + resultMapsBean.getId());
                                    intent.putExtra("mainId", "" + resultMapsBean.getMainId());
                                    intent.putExtra("jilu", "0");
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

    private void taskType(SurveyRecordBean.ResultMapsBean resultsBean, TextView tv_handle_name, ImageView iv_handle_state) {
        switch (resultsBean.getTaskType()) {
            case "6":
                tv_handle_name.setText("");
                switch (resultsBean.getState()) {
                    case "2":
                        iv_handle_state.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.troubleshooting_clz));
                        break;
                    case "3":
                        iv_handle_state.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.troubleshooting_ycl));
                        break;
                    case "4":
                        iv_handle_state.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.troubleshooting_cg));
                        break;
                    case "5":
                        iv_handle_state.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.troubleshooting_clz));
                        break;
                    case "6":
                        iv_handle_state.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.troubleshooting_dtb));
                        break;
                    default:
                }
                break;
            case "7":
                break;
            case "8":
                break;
            case "9":
                break;
            default:
        }
    }
}

