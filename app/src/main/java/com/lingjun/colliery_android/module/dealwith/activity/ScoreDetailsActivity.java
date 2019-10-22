package com.lingjun.colliery_android.module.dealwith.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
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
import com.lingjun.colliery_android.bean.ScoreDetailsBean;
import com.lingjun.colliery_android.bean.StandardizationListBean;
import com.lingjun.colliery_android.module.dealwith.hiddendanger.activity.RectificationListActivity;
import com.lingjun.colliery_android.utils.FastJsonTools;
import com.lingjun.colliery_android.utils.RecyclerViewUtils;
import com.lingjun.colliery_android.utils.retrofit.BaseSubscriber;
import com.lingjun.colliery_android.utils.retrofit.ExceptionHandle;
import com.ruffian.library.widget.RTextView;
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
 * 时间: 2019/8/23  15:32.
 * 注释:
 *
 * @author ztchongchong
 */
public class ScoreDetailsActivity extends BaseActivity {
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.ll_beijing)
    LinearLayout llBeijing;
    @BindView(R.id.rv_list)
    RecyclerView rvList;
    @BindView(R.id.refreshLayout)
    SmartRefreshLayout refreshLayout;
    private String taskid;
    private ArrayList<ScoreDetailsBean.DataBean> list = new ArrayList<>();

    @Override
    protected int getResourcesId() {
        return R.layout.activity_hidden_dangers_handle;
    }

    @Override
    protected void init(Bundle savedInstanceState) throws PackageManager.NameNotFoundException {
        tvName.setText("标准化检查得分详情");
        taskid = getIntent().getStringExtra("taskid");
        refreshView();
    }

    private void refreshView() {
        showLoadDialog();
        LogUtils.e("当前第" + pageIndex + "页");
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(BaseLinkList.apiurl, BaseLinkList.coal_mine + BaseLinkList.getStadchkProjectSocketInfo);
        hashMap.put("taskid", taskid);

        mRetrofit.get(BaseLinkList.Base_Url, hashMap, new BaseSubscriber() {
            @Override
            public void onError(ExceptionHandle.ResponeThrowable e) {
                dismissDialog();
                refreshLayout.setVisibility(View.GONE);
                llBeijing.setVisibility(View.VISIBLE);
                if (null != refreshLayout) {
                    refreshLayout.finishRefresh();
                    refreshLayout.finishLoadMore();
                }
            }

            @Override
            public void onSuccess(JSONObject jsonObject) {
                dismissDialog();
                LogUtils.e("列表->>" + jsonObject.toString());
                final ScoreDetailsBean bean = FastJsonTools.getBean(jsonObject.toString(), ScoreDetailsBean.class);
                if (null != bean && null != bean.getData()) {
                    llBeijing.setVisibility(View.GONE);
                    refreshLayout.setVisibility(View.VISIBLE);
                    if (pageIndex > 1) {
                        if (null != bean.getData() && bean.getData().size() != 0) {
                            BaseQuickAdapter adapter = (BaseQuickAdapter) rvList.getAdapter();
//                            ArrayList<HiddenDangersHandleBean.ResultMapsBean> data = (ArrayList<HiddenDangersHandleBean.ResultMapsBean>) adapter.getData();
//                            for (int i = 0; i < hiddenDangersHandleBean.getResultMaps().size(); i++) {
                            list.addAll(bean.getData());
//                                adapter.notifyItemChanged(results.size() + (i + 1),  hiddenDangersHandleBean.getResultMaps().get(i));
//                            }
                            adapter.notifyDataSetChanged();
                        }
                    } else {
                        if (list.size() != 0) {
                            list.clear();
                        }
                        if (bean.getData().size() != 0) {
                            list.addAll(bean.getData());
                            RecyclerViewUtils.initLiner(ScoreDetailsActivity.this, rvList, R.layout.item_scoredetails, list, new OnGlobalListener() {
                                @SuppressLint("ResourceAsColor")
                                @Override
                                public <T> void logic(BaseViewHolder helper, List<T> mData, T item, BaseQuickAdapter mAdapter) {
                                    ScoreDetailsBean.DataBean resultsBean = (ScoreDetailsBean.DataBean) item;

                                    TextView tv_title = helper.getView(R.id.tv_title);//标题
                                    TextView tv_content = helper.getView(R.id.tv_content);//内容
                                    TextView tv_defen = helper.getView(R.id.tv_defen);//得分


                                    tv_title.setText(resultsBean.getCatname());//标题
                                    tv_content.setText(resultsBean.getState() + "(" + resultsBean.getCompRate() + ")");//内容
                                    tv_defen.setText(resultsBean.getResScore() + "分");


                                }
                            }, new BaseQuickAdapter.OnItemClickListener() {
                                @SuppressLint("ResourceType")
                                @Override
                                public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                                    ScoreDetailsBean.DataBean dataBean = (ScoreDetailsBean.DataBean) adapter.getData().get(position);
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

    @Override
    protected BaseRefreshLoadMoreInterface setRefreshLoadMoreListener() {
        return null;
    }

}
