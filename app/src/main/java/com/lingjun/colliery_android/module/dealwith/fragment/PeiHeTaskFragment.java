package com.lingjun.colliery_android.module.dealwith.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.lingjun.colliery_android.R;
import com.lingjun.colliery_android.base.BaseFragment;
import com.lingjun.colliery_android.bean.PeiHeBean;
import com.lingjun.colliery_android.bean.TeYaoBean;
import com.lingjun.colliery_android.module.dealwith.adapter.TeYaoAdapter;
import com.lingjun.colliery_android.module.dealwith.myinterface.ListviewInterface;
import com.lingjun.colliery_android.utils.ToastUtils;

import butterknife.BindView;

/**
 * Created by shurrikann on 2018/12/5.
 */

public class PeiHeTaskFragment extends BaseFragment implements ListviewInterface {
    private static final String KEY = "title";
    private int pos;
    private PeiHeBean.DataBean bean;
    @BindView(R.id.recy)
    RecyclerView recy;
    @BindView(R.id.title)
    TextView title;
    TeYaoAdapter adapter;

    @Override
    protected int setLayout(LayoutInflater inflater) {
        return R.layout.fragment_task_db;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        Bundle bundle = getArguments();
        pos = bundle.getInt("pos");
        bean = (PeiHeBean.DataBean) bundle.getSerializable("bean");
//        ToastUtils.showLongToast(getActivity(), pos + "," + bean.getList().size());
        initAdapter();
//        title.setText(bean.getName());
//        adapter.setNewData(bean.getList());
    }

    private void initAdapter() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setAutoMeasureEnabled(true);
        adapter = new TeYaoAdapter(R.layout.item_responsible, 1);
        recy.setLayoutManager(linearLayoutManager);
        recy.setAdapter(adapter);
        adapter.setNewData(bean.getMap());
    }

    @Override
    protected BaseRefreshLoadMoreInterface setRefreshLoadMoreListener() {
        return null;
    }

    /**
     * 37      * fragment静态传值
     * 38
     */
    public static PeiHeTaskFragment newInstance(String str, int pos, PeiHeBean.DataBean bean) {
        PeiHeTaskFragment fragment = new PeiHeTaskFragment();
        Bundle bundle = new Bundle();
        bundle.putString(KEY, str);
        bundle.putInt("pos", pos);
        bundle.putSerializable("bean", bean);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void btnClick(View v, int pos, boolean type) {
        bean.getMap().get(pos).setState(!type);
        adapter.notifyItemChanged(pos);
    }

    @Override
    public void btnsClick(View v, int pos, int state, boolean type) {

    }

    @Override
    public void btnsClicks(View v, int pos, boolean state, int type) {

    }
}
