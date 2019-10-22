package com.lingjun.colliery_android.module.dealwith.adapter;

import android.support.annotation.Nullable;
import android.util.Log;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lingjun.colliery_android.R;
import com.lingjun.colliery_android.bean.CheckMlBean;

import java.util.List;

/**
 * Created by shurrikann on 2018/12/20.
 */

public class CheckQxAdapter<T> extends BaseQuickAdapter<T, BaseViewHolder> {

    public CheckQxAdapter(int layoutResId, @Nullable List<T> data) {
        super(layoutResId, data);
    }

    public CheckQxAdapter(@Nullable List<T> data) {
        super(data);
    }

    public CheckQxAdapter(int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void convert(BaseViewHolder helper, T item) {
        final CheckMlBean.DataBean.CatalogListBean bean = (CheckMlBean.DataBean.CatalogListBean) item;
        Log.d("adapter", bean.getName());
        helper.setText(R.id.name, bean.getName());
    }
}
