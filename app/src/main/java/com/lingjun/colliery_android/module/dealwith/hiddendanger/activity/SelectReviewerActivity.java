package com.lingjun.colliery_android.module.dealwith.hiddendanger.activity;

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
import com.lingjun.colliery_android.bean.ReviewerBean;
import com.lingjun.colliery_android.bean.SelectReviewerBean;
import com.lingjun.colliery_android.utils.FastJsonTools;
import com.lingjun.colliery_android.utils.RecyclerViewUtils;
import com.lingjun.colliery_android.utils.retrofit.BaseSubscriber;
import com.lingjun.colliery_android.utils.retrofit.ExceptionHandle;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;

/**
 * 作者: zengtao
 * 时间: 2019/3/29  10:21.
 * 注释:隐患审核人
 */
public class SelectReviewerActivity extends BaseActivity {
    private SmartRefreshLayout refreshLayout;
    private LinearLayout ll_beijing;

    public static final int HiddenDangerCode = 303;
    private RecyclerView rv_list;

    @Override
    protected int getResourcesId() {
        return R.layout.activity_select_reviewer;
    }

    @Override
    protected void init(Bundle savedInstanceState) throws PackageManager.NameNotFoundException {
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
        hashMap.put(BaseLinkList.apiurl, BaseLinkList.coal_mine + BaseLinkList.getleaderBydepartMent);
        mRetrofit.JsonToColliery(BaseLinkList.Base_Url, hashMap, new BaseSubscriber() {
            @Override
            public void onError(ExceptionHandle.ResponeThrowable e) {
                refreshLayout.setVisibility(View.GONE);
                ll_beijing.setVisibility(View.VISIBLE);
                if (null != refreshLayout) {
                    refreshLayout.finishLoadMore();
                    refreshLayout.finishRefresh();
                }
            }

            @Override
            public void onSuccess(JSONObject jsonObject) {
                LogUtils.e("审核人列表->>" + jsonObject.toString());
                SelectReviewerBean selectReviewerBean = FastJsonTools.getBean(jsonObject.toString(), SelectReviewerBean.class);
                if (null != selectReviewerBean) {
                    refreshLayout.setVisibility(View.VISIBLE);
                    ll_beijing.setVisibility(View.GONE);

                    RecyclerViewUtils.initLiner(SelectReviewerActivity.this, rv_list, R.layout.item_text, selectReviewerBean.getData().getListUserDepartMent(), new OnGlobalListener() {
                        @Override
                        public <T> void logic(BaseViewHolder helper, List<T> mData, T item, BaseQuickAdapter mAdapter) {
                            SelectReviewerBean.DataBean.ListUserDepartMentBean leadlistBean = (SelectReviewerBean.DataBean.ListUserDepartMentBean) item;
                            TextView tv_name = helper.getView(R.id.tv_name);
                            tv_name.setText(leadlistBean.getUserName() + "(" + leadlistBean.getDePartMentName() + ")");
                        }
                    }, new BaseQuickAdapter.OnItemClickListener() {
                        @Override
                        public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                            SelectReviewerBean.DataBean.ListUserDepartMentBean leadlistBean = (SelectReviewerBean.DataBean.ListUserDepartMentBean) adapter.getData().get(position);
                            Intent intent = new Intent();
                            intent.putExtra("userId", "" + leadlistBean.getUserId());
                            intent.putExtra("userName", leadlistBean.getUserName());
                            intent.putExtra("dePartMentName", leadlistBean.getDePartMentName());
                            setResult(HiddenDangerCode, intent);
                            finish();
                        }
                    }, null);
                } else {
                    refreshLayout.setVisibility(View.GONE);
                    ll_beijing.setVisibility(View.VISIBLE);
                }

                if (null != refreshLayout) {
                    refreshLayout.finishLoadMore();
                    refreshLayout.finishRefresh();
                }
            }
        });
    }
}
