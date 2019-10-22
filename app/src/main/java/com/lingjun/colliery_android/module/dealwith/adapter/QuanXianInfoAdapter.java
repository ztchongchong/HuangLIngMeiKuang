package com.lingjun.colliery_android.module.dealwith.adapter;

import android.support.annotation.Nullable;
import android.widget.CheckBox;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lingjun.colliery_android.R;

import java.util.List;

/**
 * Created by shurrikann on 2018/4/3.
 */

public class QuanXianInfoAdapter extends BaseQuickAdapter<String, BaseViewHolder> {
    public QuanXianInfoAdapter(int layoutResId, @Nullable List<String> data) {
        super(layoutResId, data);
    }

    public QuanXianInfoAdapter(@Nullable List<String> data) {
        super(data);
    }

    public QuanXianInfoAdapter(int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        helper.setText(R.id.str, item);
        CheckBox checkbox = helper.getView(R.id.checkbox);
    }
}
