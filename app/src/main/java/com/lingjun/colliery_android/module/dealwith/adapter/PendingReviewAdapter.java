package com.lingjun.colliery_android.module.dealwith.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * Created by shurrikann on 2018/12/4.
 */

public class PendingReviewAdapter<T> extends BaseQuickAdapter<T, BaseViewHolder> {
    private int type;

    public PendingReviewAdapter(int layoutResId, @Nullable List<T> data) {
        super(layoutResId, data);
    }

    public PendingReviewAdapter(@Nullable List<T> data) {
        super(data);
    }

    public PendingReviewAdapter(int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void convert(BaseViewHolder helper, T item) {

    }

    public void setTpye(int type) {
        this.type = type;
    }
}
