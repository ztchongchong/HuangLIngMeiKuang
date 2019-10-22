package com.lingjun.colliery_android.module.dealwith.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.widget.TextView;

import com.lingjun.colliery_android.R;
import com.lingjun.colliery_android.base.BaseFragment;
import com.lingjun.colliery_android.bean.TaskBean;
import com.lingjun.colliery_android.module.dealwith.adapter.TeYaoAdapter;
import com.lingjun.colliery_android.utils.ToastUtils;

import butterknife.BindView;

/**
 * Created by shurrikann on 2018/12/5.
 */

public class AllTaskFragment extends BaseFragment {
    private static final String KEY = "title";
    private int pos;
    private TaskBean.DataBean.ItemmapBean bean;
    private TeYaoAdapter adapter;
    @BindView(R.id.recy)
    RecyclerView recy;
    @BindView(R.id.title)
    TextView title;

    @Override
    protected int setLayout(LayoutInflater inflater) {
        return R.layout.fragment_task_db;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        Bundle bundle = getArguments();
        pos = bundle.getInt("pos");
        bean = (TaskBean.DataBean.ItemmapBean) bundle.getSerializable("bean");
//        ToastUtils.showLongToast(getActivity(), pos + "");
        title.setText(bean.getName());
        initAdapter();

//        ToastUtils.showLongToast(getActivity(), pos + "");
    }

    @Override
    protected BaseRefreshLoadMoreInterface setRefreshLoadMoreListener() {
        return null;
    }

    /**
     * 37      * fragment静态传值
     * 38
     */
    public static AllTaskFragment newInstance(String str, int pos, TaskBean.DataBean.ItemmapBean bean) {
        AllTaskFragment fragment = new AllTaskFragment();
        Bundle bundle = new Bundle();
        bundle.putString(KEY, str);
        bundle.putInt("pos", pos);
        bundle.putSerializable("bean", bean);
        fragment.setArguments(bundle);
        return fragment;
    }

    private void initAdapter() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setAutoMeasureEnabled(true);
        adapter = new TeYaoAdapter(R.layout.item_audit_task_entry, 3);
        recy.setLayoutManager(linearLayoutManager);
        recy.setAdapter(adapter);
        adapter.setNewData(bean.getList());
    }
}
