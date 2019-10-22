package com.lingjun.colliery_android.module.dealwith.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lingjun.colliery_android.R;
import com.lingjun.colliery_android.bean.PeiHeBean;
import com.lingjun.colliery_android.bean.ZeRenBean;

import java.util.List;

/**
 * Created by shurrikann on 2018/3/20.
 */

public class ResponsibleInfoAdapter<T> extends BaseQuickAdapter<T, BaseViewHolder> {
    public ResponsibleInfoAdapter(int layoutResId, @Nullable List<T> data) {
        super(layoutResId, data);
    }

    public ResponsibleInfoAdapter(@Nullable List<T> data) {
        super(data);
    }

    public ResponsibleInfoAdapter(int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void convert(BaseViewHolder helper, T item) {
        PeiHeBean.DataBean.MapBean.ListBean bean = (PeiHeBean.DataBean.MapBean.ListBean) item;
        helper.setText(R.id.respons_name, bean.getSerialno());
        helper.setText(R.id.info, bean.getCategoryname());
    }
}
