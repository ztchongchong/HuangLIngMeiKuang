package com.lingjun.colliery_android.module.dealwith.standardized.fragment;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
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
 * 零分任务Fragment
 * Created by nefa on 2018/11/1.
 */

public class AZeroTaskFragment extends BaseFragment {

    private RecyclerView rv_list;

    @Override
    protected int setLayout(LayoutInflater inflater) {
        return R.layout.fragment_azero_task;
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
            mList.add(taskBean);
        }

        RecyclerViewUtils.initLinerNoSc(getActivity(), rv_list, R.layout.item_azero_task_entry, mList, new OnGlobalListener() {
            @Override
            public <T> void logic(BaseViewHolder helper, List<T> mData, T item, BaseQuickAdapter mAdapter) {
                TaskBean taskBean = (TaskBean) item;
                ImageView iv_icon = helper.getView(R.id.iv_icon);
                LinearLayout ll_content = helper.getView(R.id.ll_content);
                TextView tv_task_name = helper.getView(R.id.tv_task_name);

                //helper.addOnClickListener(R.id.rl_is_show);

                if (taskBean.isShow) {
                    ll_content.setVisibility(View.VISIBLE);
                    iv_icon.setImageResource(R.drawable.jiantou_top);
                } else {
                    ll_content.setVisibility(View.GONE);
                    iv_icon.setImageResource(R.drawable.jiantou_bottom);
                }

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
        public int num;
    }
}
