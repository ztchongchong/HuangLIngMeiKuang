package com.lingjun.colliery_android.module.dealwith.hiddendanger.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;

import com.lingjun.colliery_android.R;
import com.lingjun.colliery_android.base.BaseFragment;

/**
 * 现场治理（待储存）
 */
public class FieldManagementFragmentCC extends BaseFragment {
    @Override
    protected int setLayout(LayoutInflater inflater) {
        return R.layout.fragment_field_management_cc;
    }

    @Override
    protected void init(Bundle savedInstanceState) {

    }

    @Override
    protected BaseRefreshLoadMoreInterface setRefreshLoadMoreListener() {
        return null;
    }
}
