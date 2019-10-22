package com.lingjun.colliery_android.module.dealwith.hiddendanger.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
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

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 作者: zengtao
 * 时间: 2019/8/15  10:06.
 * 注释:问题清单
 */
public class QuestionsListActivity extends BaseActivity {
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.ll_beijing)
    LinearLayout llBeijing;
    @BindView(R.id.rv_list)
    RecyclerView rvList;
    private ArrayList<HiddenDangersHandleBean.ResultMapsBean> results = new ArrayList<>();

    @Override
    protected int getResourcesId() {
        return R.layout.activity_hidden_dangers_handle;
    }

    @Override
    protected void init(Bundle savedInstanceState) throws PackageManager.NameNotFoundException {
        tvName.setText("问题清单");
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
        hashMap.put("taskSource", "1");

        mRetrofit.JsonToColliery(BaseLinkList.Base_Url, hashMap, new BaseSubscriber() {
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
                final HiddenDangersHandleBean hiddenDangersHandleBean = FastJsonTools.getBean(jsonObject.toString(), HiddenDangersHandleBean.class);
                if (null != hiddenDangersHandleBean && null != hiddenDangersHandleBean.getData() && null != hiddenDangersHandleBean.getData() && null != hiddenDangersHandleBean.getResultMaps()) {
                    llBeijing.setVisibility(View.GONE);
                    refreshLayout.setVisibility(View.VISIBLE);
                    if (pageIndex > 1) {
                        if (null != hiddenDangersHandleBean.getResultMaps() && hiddenDangersHandleBean.getResultMaps().size() != 0) {
                            BaseQuickAdapter adapter = (BaseQuickAdapter) rvList.getAdapter();
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
                            RecyclerViewUtils.initLiner(QuestionsListActivity.this, rvList, R.layout.item_hidden_dangers_handle, results, new OnGlobalListener() {
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
                                    if (resultsBean.getTaskType().equals("9")){
                                        tv_handle_name.setText("限时整改");
                                    }else {
                                        tv_handle_name.setText("挂牌督办");
                                    }
                                    tv_handle_state.setText(resultsBean.getStateFlag());
                                    tv_handle_content.setText(resultsBean.getTrouble_content());
                                    tv_handle_time.setText(DateUtil.getStringByFormat(resultsBean.getCreateTime(), "yyyy-MM-dd"));
//                                    //状态初始化
//                                    checkTaskTypeToView(resultsBean, tv_handle_name, tv_handle_content, tv_handle_time);


                                }
                            }, new BaseQuickAdapter.OnItemClickListener() {
                                @SuppressLint("ResourceType")
                                @Override
                                public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                                    HiddenDangersHandleBean.ResultMapsBean resultsBean = (HiddenDangersHandleBean.ResultMapsBean) adapter.getData().get(position);
//                                    checkTaskType(resultsBean);
                                    Intent intent = new Intent(QuestionsListActivity.this, DetailedlistActivity.class);
                                    intent.putExtra("taskId", resultsBean.getTask_id()+"");
                                    intent.putExtra("mainTaskId", resultsBean.getMainId()+"");
                                    intent.putExtra("exhibition", 1);
                                    intent.putExtra("status", String.valueOf(resultsBean.getState()));
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

    private void checkTaskType(HiddenDangersHandleBean.ResultMapsBean resultsBean) {

    }

    @Override
    protected void onResume() {
        super.onResume();
        refreshView();
    }
}
