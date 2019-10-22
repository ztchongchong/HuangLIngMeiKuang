package com.lingjun.colliery_android.module.dealwith.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.lingjun.colliery_android.R;
import com.lingjun.colliery_android.base.BaseActivity;
import com.lingjun.colliery_android.module.dealwith.adapter.ResponsibleAdapter;
import com.lingjun.colliery_android.module.dealwith.myinterface.ListviewInterface;

import butterknife.BindView;
import butterknife.OnClick;


/**
 * Created by shurrikann on 2018/12/5.
 */

public class ResponsRenActivity extends BaseActivity implements ListviewInterface {
    @OnClick(R.id.iv_back)
    void back() {
        finish();
    }

    @BindView(R.id.respor_recy)
    RecyclerView respor_recy;
    private ResponsibleAdapter adapter;

    @Override
    protected int getResourcesId() {
        return R.layout.activity_responsren;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        initAdapter();
    }

    private void initAdapter() {
        adapter = new ResponsibleAdapter(R.layout.item_responsible);
        adapter.setListviewInterface(ResponsRenActivity.this);
        respor_recy.setLayoutManager(new LinearLayoutManager(ResponsRenActivity.this));
        respor_recy.setAdapter(adapter);
        respor_recy.setNestedScrollingEnabled(false);
    }

    @Override
    protected BaseRefreshLoadMoreInterface setRefreshLoadMoreListener() {
        return null;
    }

    @Override
    public void btnClick(View v, int pos, boolean type) {

    }

    @Override
    public void btnsClick(View v, int pos, int state, boolean type) {

    }

    @Override
    public void btnsClicks(View v, int pos, boolean state, int type) {

    }
}
