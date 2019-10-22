package com.lingjun.colliery_android.base;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * Created by nefa on 2017/12/25.
 */

public interface OnGlobalListener {
    <T> void logic(BaseViewHolder helper, List<T> mData, T item, BaseQuickAdapter mAdapter);
}
