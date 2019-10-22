package com.lingjun.colliery_android.module.dealwith.standardized.review.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lingjun.colliery_android.R;
import com.lingjun.colliery_android.base.BaseFragment;
import com.lingjun.colliery_android.base.OnGlobalListener;
import com.lingjun.colliery_android.bean.ToReviewBean;
import com.lingjun.colliery_android.module.dealwith.adapter.ToReviewAdapter;
import com.lingjun.colliery_android.module.dealwith.fragment.ZeroTaskFragment;
import com.lingjun.colliery_android.module.dealwith.myinterface.ListviewInterface;
import com.lingjun.colliery_android.module.dealwith.standardized.review.ScoreInfoDetailsActivity;
import com.lingjun.colliery_android.utils.RecyclerViewUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 分值详情
 * Created by nefa on 2018/11/7.
 */

public class ScoreDetailsFragment extends BaseFragment {

    private RecyclerView rv_list;
    private static final String KEY = "title";
    private ToReviewBean.DataBean bean;
    private ToReviewAdapter adapter;
    private List<ToReviewBean.DataBean.CategoryarrayBean> list = new ArrayList<>();
    private ListviewInterface listviewInterface;
    private String taskid;

    @Override
    protected int setLayout(LayoutInflater inflater) {
        return R.layout.fragment_score_details;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        Bundle bundle = getArguments();
        bean = (ToReviewBean.DataBean) bundle.getSerializable("bean");
        taskid = bundle.getString("taskid");
        rv_list = mRootView.findViewById(R.id.rv_list);
//        refreshView();
        Log.d("taskid11111",taskid);
        listviewInterface = new ListviewInterface() {
            @Override
            public void btnClick(View v, int pos, boolean type) {

            }

            @Override
            public void btnsClick(View v, int pos, int state, boolean type) {

            }

            @Override
            public void btnsClicks(View v, int pos, boolean state, int type) {

            }
        };
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

    public static ScoreDetailsFragment newInstance(String str, int pos, ToReviewBean.DataBean bean, String taskid) {
        ScoreDetailsFragment fragment = new ScoreDetailsFragment();
        Bundle bundle = new Bundle();
        bundle.putString(KEY, str);
        bundle.putInt("pos", pos);
        bundle.putString("taskid", taskid);
        bundle.putSerializable("bean", bean);
        fragment.setArguments(bundle);
        return fragment;
    }

    //刷新
    private void refreshView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setAutoMeasureEnabled(true);
        adapter = new ToReviewAdapter(R.layout.item_score_details,taskid);
        rv_list.setLayoutManager(linearLayoutManager);
        rv_list.setAdapter(adapter);
        if (bean.getCategoryarray().size() != 0) {
            list = bean.getCategoryarray();
            adapter.setNewData(list);
        }
//        ArrayList<String> mlist = new ArrayList<>();
//
//        for (int i = 0; i < 20; i++) {
//            mlist.add("1");
//        }
//
//        RecyclerViewUtils.initLinerNoSc(getActivity(), rv_list, R.layout.item_score_details, mlist, new OnGlobalListener() {
//            @Override
//            public <T> void logic(BaseViewHolder helper, List<T> mData, T item, BaseQuickAdapter mAdapter) {
//                TextView tv_name = helper.getView(R.id.tv_name);
//            }
//        }, new BaseQuickAdapter.OnItemClickListener() {
//            @Override
//            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
//                startActivity(new Intent(getActivity(), ScoreInfoDetailsActivity.class));
//            }
//        }, null);
//
        if (null != refreshLayout) {
            refreshLayout.finishLoadMore();
            refreshLayout.finishRefresh();
        }
    }

}
