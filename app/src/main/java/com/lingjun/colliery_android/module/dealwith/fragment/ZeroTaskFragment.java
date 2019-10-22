package com.lingjun.colliery_android.module.dealwith.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.TextView;

import com.lingjun.colliery_android.R;
import com.lingjun.colliery_android.base.BaseFragment;
import com.lingjun.colliery_android.bean.TaskBean;
import com.lingjun.colliery_android.bean.TeYaoBean;
import com.lingjun.colliery_android.module.dealwith.adapter.TeYaoAdapter;
import com.lingjun.colliery_android.utils.ToastUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by shurrikann on 2018/12/5.
 */

public class ZeroTaskFragment extends BaseFragment {
    private static final String KEY = "title";
    private int pos;
    @BindView(R.id.recy)
    RecyclerView recy;
    @BindView(R.id.title)
    TextView title;
    private TaskBean.DataBean.ItemmapBean bean;
    private TeYaoAdapter adapter;
    private String types;

    @Override
    protected int setLayout(LayoutInflater inflater) {
        return R.layout.fragment_task_db;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        Bundle bundle = getArguments();
        types = getActivity().getIntent().getStringExtra("type");
        pos = bundle.getInt("pos");
        bean = (TaskBean.DataBean.ItemmapBean) bundle.getSerializable("bean");
        title.setText(bean.getName());
        initAdapter();
//        if (bean.getList().size() != 0) {
//            adapter.setNewData(bean.getList());
//        }
    }

    private void initAdapter() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setAutoMeasureEnabled(true);
        adapter = new TeYaoAdapter(R.layout.item_audit_task_entry, 3);
        adapter.setTypes(types);
        recy.setLayoutManager(linearLayoutManager);
        recy.setAdapter(adapter);
        adapter.setNewData(bean.getList());
    }

    @Override
    protected BaseRefreshLoadMoreInterface setRefreshLoadMoreListener() {
        return null;
    }

    /**
     * 37      * fragment静态传值
     * 38
     */
    public static ZeroTaskFragment newInstance(String str, int pos, TaskBean.DataBean.ItemmapBean bean) {
        ZeroTaskFragment fragment = new ZeroTaskFragment();
        Bundle bundle = new Bundle();
        bundle.putString(KEY, str);
        bundle.putInt("pos", pos);
        bundle.putSerializable("bean", bean);
        fragment.setArguments(bundle);
        return fragment;
    }
}
