package com.lingjun.colliery_android.module.dealwith.standardized.review;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lingjun.colliery_android.R;
import com.lingjun.colliery_android.base.BaseActivity;
import com.lingjun.colliery_android.base.OnGlobalListener;
import com.lingjun.colliery_android.utils.RecyclerViewUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 历史记录
 * Created by nefa on 2018/11/13.
 */

public class HistoryActivity extends BaseActivity {

    private RecyclerView rv_list;

    @Override
    protected int getResourcesId() {
        return R.layout.activity_history;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        rv_list = findViewById(R.id.rv_list);
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

    //刷新view
    private void refreshView() {
        ArrayList<TestBean> mList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            TestBean testBean = new TestBean();
            testBean.name = "哈哈哈";
            mList.add(testBean);
        }

        RecyclerViewUtils.initLinerNoSc(HistoryActivity.this, rv_list, R.layout.item_history, mList, new OnGlobalListener() {
            @Override
            public <T> void logic(BaseViewHolder helper, List<T> mData, T item, BaseQuickAdapter mAdapter) {
                TestBean testBean = (TestBean) item;

            }
        }, new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {

            }
        }, null);

        if (null != refreshLayout) {
            refreshLayout.finishRefresh();
            refreshLayout.finishLoadMore();
        }
    }

    class TestBean {
        public String name;
    }
}
