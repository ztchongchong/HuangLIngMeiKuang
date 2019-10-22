package com.lingjun.colliery_android.module.dealwith.hiddendanger.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.blankj.utilcode.util.LogUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lingjun.colliery_android.R;
import com.lingjun.colliery_android.base.BaseActivity;
import com.lingjun.colliery_android.base.BaseLinkList;
import com.lingjun.colliery_android.base.OnGlobalListener;
import com.lingjun.colliery_android.bean.HiddenDangersHandleBean;
import com.lingjun.colliery_android.bean.StandardizationListBean;
import com.lingjun.colliery_android.module.dealwith.activity.StandardizationDetailsActivity;
import com.lingjun.colliery_android.utils.DateUtil;
import com.lingjun.colliery_android.utils.FastJsonTools;
import com.lingjun.colliery_android.utils.RecyclerViewUtils;
import com.lingjun.colliery_android.utils.retrofit.BaseSubscriber;
import com.lingjun.colliery_android.utils.retrofit.ExceptionHandle;
import com.ruffian.library.widget.RTextView;
import com.ruffian.library.widget.helper.RTextViewHelper;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 作者: zengtao
 * 时间: 2019/8/15  10:05.
 * 注释:整改清单（标准化清单）
 *
 * @author ztchongchong
 */
public class RectificationListActivity extends BaseActivity {
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.ll_beijing)
    LinearLayout llBeijing;
    @BindView(R.id.rv_list)
    RecyclerView rvList;
    private ArrayList<StandardizationListBean.PageBean.ResultsBean> results = new ArrayList<>();

    @Override
    protected int getResourcesId() {
        return R.layout.activity_hidden_dangers_handle;
    }

    @Override
    protected void init(Bundle savedInstanceState) throws PackageManager.NameNotFoundException {
        tvName.setText("标准化清单");
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
        hashMap.put(BaseLinkList.apiurl, BaseLinkList.coal_mine + BaseLinkList.getStadchkList);
        hashMap.put("pageSize", "10");
        hashMap.put("page", "" + pageIndex);

        mRetrofit.get(BaseLinkList.Base_Url, hashMap, new BaseSubscriber() {
            @Override
            public void onError(ExceptionHandle.ResponeThrowable e) {
                refreshLayout.setVisibility(View.GONE);
                llBeijing.setVisibility(View.VISIBLE);
                if (null != refreshLayout) {
                    refreshLayout.finishRefresh();
                    refreshLayout.finishLoadMore();
                }
            }

            @Override
            public void onSuccess(JSONObject jsonObject) {
                LogUtils.e("列表->>" + jsonObject.toString());
                final StandardizationListBean standardizationListBean = FastJsonTools.getBean(jsonObject.toString(), StandardizationListBean.class);
                if (null != standardizationListBean && null != standardizationListBean.getPage()) {
                    llBeijing.setVisibility(View.GONE);
                    refreshLayout.setVisibility(View.VISIBLE);
                    if (pageIndex > 1) {
                        if (null != standardizationListBean.getPage().getResults() && standardizationListBean.getPage().getResults().size() != 0) {
                            BaseQuickAdapter adapter = (BaseQuickAdapter) rvList.getAdapter();
//                            ArrayList<HiddenDangersHandleBean.ResultMapsBean> data = (ArrayList<HiddenDangersHandleBean.ResultMapsBean>) adapter.getData();
//                            for (int i = 0; i < hiddenDangersHandleBean.getResultMaps().size(); i++) {
                            results.addAll(standardizationListBean.getPage().getResults());
//                                adapter.notifyItemChanged(results.size() + (i + 1),  hiddenDangersHandleBean.getResultMaps().get(i));
//                            }
                            adapter.notifyDataSetChanged();
                        }
                    } else {
                        if (results.size() != 0) {
                            results.clear();
                        }
                        if (standardizationListBean.getPage().getResults().size() != 0) {
                            results.addAll(standardizationListBean.getPage().getResults());
                            RecyclerViewUtils.initLiner(RectificationListActivity.this, rvList, R.layout.item_standardizationlist, results, new OnGlobalListener() {
                                @SuppressLint("ResourceAsColor")
                                @Override
                                public <T> void logic(BaseViewHolder helper, List<T> mData, T item, BaseQuickAdapter mAdapter) {
                                    StandardizationListBean.PageBean.ResultsBean resultsBean = (StandardizationListBean.PageBean.ResultsBean) item;

                                    TextView tv_handle_name = helper.getView(R.id.tv_handle_name);//标题
                                    RTextView tv_handle_state = helper.getView(R.id.tv_handle_state);//状态
                                    TextView tv_handle_content = helper.getView(R.id.tv_handle_content);//内容
                                    TextView tv_handle_time = helper.getView(R.id.tv_handle_time);//时间
                                    TextView tv_progress = helper.getView(R.id.tv_progress);//进度


                                    tv_handle_name.setText(resultsBean.getTitle());//标题
                                    tv_handle_content.setText(resultsBean.getDescription());//内容
                                    tv_handle_time.setText(new SimpleDateFormat("yyyy-MM-dd").format(new Date(resultsBean.getStarttime())));
                                    exhibitionview(resultsBean, tv_handle_state, tv_progress);


                                }
                            }, new BaseQuickAdapter.OnItemClickListener() {
                                @SuppressLint("ResourceType")
                                @Override
                                public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                                    StandardizationListBean.PageBean.ResultsBean resultsBean = (StandardizationListBean.PageBean.ResultsBean) adapter.getData().get(position);
                                    Intent intent = new Intent(RectificationListActivity.this, StandardizationDetailsActivity.class);
                                    intent.putExtra("taskId", resultsBean.getProject().getTaskId() + "");
                                    intent.putExtra("jindu", resultsBean.getCores() + "");
                                    intent.putExtra("defen", resultsBean.getProject().getAutoscore() + "");
                                    startActivity(intent);
                                }
                            }, null);
                        } else {
                            refreshLayout.setVisibility(View.GONE);
                            llBeijing.setVisibility(View.VISIBLE);
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


    @SuppressLint("ResourceType")
    private void exhibitionview(StandardizationListBean.PageBean.ResultsBean resultsBean, RTextView tv_handle_state, TextView tv_progress) {
        if (resultsBean != null) {
            RTextViewHelper rTextViewHelper = tv_handle_state.getHelper();
            switch (resultsBean.getState()) {
                case "1":
                    tv_handle_state.setText("草稿");
                    tv_handle_state.setTextColor(Color.parseColor("#9B22D4"));
                    rTextViewHelper.setCornerRadius(40);
                    rTextViewHelper.setBorderWidthNormal(2);
                    rTextViewHelper.setBorderColorNormal(Color.parseColor("#9B22D4"));
                    tv_progress.setText("进度：" + resultsBean.getCores());
                    break;
                case "2":
                    tv_handle_state.setText("待审核");
                    tv_handle_state.setTextColor(Color.parseColor("#03C1BE"));
                    rTextViewHelper.setCornerRadius(40);
                    rTextViewHelper.setBorderWidthNormal(2);
                    rTextViewHelper.setBorderColorNormal(Color.parseColor("#03C1BE"));
                    tv_progress.setText("进度：" + resultsBean.getCores());
                    break;
                case "3":
                    tv_handle_state.setText("审核通过");
                    tv_handle_state.setTextColor(Color.parseColor("#0533FF"));
                    rTextViewHelper.setCornerRadius(40);
                    rTextViewHelper.setBorderWidthNormal(2);
                    rTextViewHelper.setBorderColorNormal(Color.parseColor("#0533FF"));
                    tv_progress.setText("进度：" + resultsBean.getCores());
                    break;
                case "4":
                    tv_handle_state.setText("审核驳回");
                    tv_handle_state.setTextColor(Color.parseColor("#FA4104"));
                    rTextViewHelper.setCornerRadius(40);
                    rTextViewHelper.setBorderWidthNormal(2);
                    rTextViewHelper.setBorderColorNormal(Color.parseColor("#FA4104"));
                    tv_progress.setText("进度：" + resultsBean.getCores());
                    break;
                case "5":
                    tv_handle_state.setText("分配中");
                    tv_handle_state.setTextColor(Color.parseColor("#D01C7F"));
                    rTextViewHelper.setCornerRadius(40);
                    rTextViewHelper.setBorderWidthNormal(2);
                    rTextViewHelper.setBorderColorNormal(Color.parseColor("#D01C7F"));
                    tv_progress.setText("进度：" + resultsBean.getCores());
                    break;
                case "6":
                    tv_handle_state.setText("待检查");
                    tv_handle_state.setTextColor(Color.parseColor("#FCB419"));
                    rTextViewHelper.setCornerRadius(40);
                    rTextViewHelper.setBorderWidthNormal(2);
                    rTextViewHelper.setBorderColorNormal(Color.parseColor("#FCB419"));
                    tv_progress.setText("进度：" + resultsBean.getCores());
                    break;
                case "7":
                    tv_handle_state.setText("检查中");
                    tv_handle_state.setTextColor(Color.parseColor("#FD7305"));
                    rTextViewHelper.setCornerRadius(40);
                    rTextViewHelper.setBorderWidthNormal(2);
                    rTextViewHelper.setBorderColorNormal(Color.parseColor("#FD7305"));
                    tv_progress.setText("进度：" + resultsBean.getCores());
                    break;
                case "8":
                    tv_handle_state.setText("已评分");
                    tv_handle_state.setTextColor(Color.parseColor("#10A8D6"));
                    rTextViewHelper.setCornerRadius(40);
                    rTextViewHelper.setBorderWidthNormal(2);
                    rTextViewHelper.setBorderColorNormal(Color.parseColor("#10A8D6"));
                    tv_progress.setText("得分：" + resultsBean.getProject().getAutoscore() + "分");
                    break;
                case "9":
                    tv_handle_state.setText("审阅中");
                    tv_handle_state.setTextColor(Color.parseColor("#EF34F0"));
                    rTextViewHelper.setCornerRadius(40);
                    rTextViewHelper.setBorderWidthNormal(2);
                    rTextViewHelper.setBorderColorNormal(Color.parseColor("#EF34F0"));
                    tv_progress.setText("得分：" + resultsBean.getProject().getAutoscore() + "分");
                    break;
                case "10":
                    tv_handle_state.setText("待存储");
                    tv_handle_state.setTextColor(Color.parseColor("#20B64C"));
                    rTextViewHelper.setCornerRadius(40);
                    rTextViewHelper.setBorderWidthNormal(2);
                    rTextViewHelper.setBorderColorNormal(Color.parseColor("#20B64C"));
                    tv_progress.setText("得分：" + resultsBean.getProject().getAutoscore() + "分");
                    break;
                case "11":
                    tv_handle_state.setText("已存储");
                    tv_handle_state.setTextColor(Color.parseColor("#117604"));
                    rTextViewHelper.setCornerRadius(40);
                    rTextViewHelper.setBorderWidthNormal(2);
                    rTextViewHelper.setBorderColorNormal(Color.parseColor("#117604"));
                    tv_progress.setText("得分：" + resultsBean.getProject().getAutoscore() + "分");
                    break;
                case "12":
                    tv_handle_state.setText("已归档");
                    tv_handle_state.setTextColor(Color.parseColor("#0331B1"));
                    rTextViewHelper.setCornerRadius(40);
                    rTextViewHelper.setBorderWidthNormal(2);
                    rTextViewHelper.setBorderColorNormal(Color.parseColor("#0331B1"));
                    tv_progress.setText("得分：" + resultsBean.getProject().getAutoscore() + "分");
                    break;
                default:
            }
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        refreshView();
    }

}
