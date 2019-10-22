package com.lingjun.colliery_android.module.dealwith.standardized.fragment;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

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
 * 配合人员fragment
 * Created by nefa on 2018/11/1.
 */

public class CooperateWithStaffFragment extends BaseFragment {

    private RecyclerView rv_list;

    @Override
    protected int setLayout(LayoutInflater inflater) {
        return R.layout.fragment_cooperate_with_staff;
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
        ArrayList<TaskBean> mList = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            TaskBean taskBean = new TaskBean();
            taskBean.isShow = false;
            taskBean.num = i;
            taskBean.name = "配合: 张三,李四";
            mList.add(taskBean);
        }

        RecyclerViewUtils.initLinerNoSc(getActivity(), rv_list, R.layout.item_cooperate_with_staff_entry, mList, new OnGlobalListener() {
            @Override
            public <T> void logic(BaseViewHolder helper, List<T> mData, T item, BaseQuickAdapter mAdapter) {
                TaskBean taskBean = (TaskBean) item;
                TextView tv_task_name = helper.getView(R.id.tv_task_name);
                TextView tv_teyao = helper.getView(R.id.tv_teyao);
                tv_teyao.setText(taskBean.name);
                tv_task_name.setText("1.1." + taskBean.num + "    专业技能及作业规范");
            }
        }, new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                TaskBean taskBean = (TaskBean) adapter.getData().get(position);
                taskBean.isShow = !taskBean.isShow;
                adapter.notifyItemChanged(position);
            }
        }, null);

        if (null != refreshLayout) {
            refreshLayout.finishRefresh();
            refreshLayout.finishLoadMore();
        }

    }


    class TaskBean {
        public boolean isShow;
        public String name;
        public int num;
    }
}
