package com.lingjun.colliery_android.module.dealwith.fragment;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lingjun.colliery_android.R;
import com.lingjun.colliery_android.base.BaseFragment;
import com.lingjun.colliery_android.base.OnGlobalListener;
import com.lingjun.colliery_android.utils.RecyclerViewUtils;
import com.scwang.smartrefresh.layout.api.RefreshLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * 任务追踪
 * Created by nefa on 2018/10/18.
 */

public class TaskTrackingFragment extends BaseFragment {

    private RecyclerView rv_list;

    @Override
    protected int setLayout(LayoutInflater inflater) {
        return R.layout.fragment_dealwith_task;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        rv_list = mRootView.findViewById(R.id.rv_list);

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
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            arrayList.add("123");
        }

        RecyclerViewUtils.initLiner(getActivity(), rv_list, R.layout.item_deal_with_task, arrayList, new OnGlobalListener() {
            @Override
            public <T> void logic(BaseViewHolder helper, List<T> mData, T item, BaseQuickAdapter mAdapter) {

            }
        }, null, null);

        if (null != refreshLayout) {
            refreshLayout.finishLoadMore();
            refreshLayout.finishRefresh();
        }
    }
}
