package com.lingjun.colliery_android.module.dealwith.hiddendanger.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.lingjun.colliery_android.R;
import com.lingjun.colliery_android.base.BaseFragment;

/**
 * 方案简述（待审核）
 */
public class ToBeAuditedFragmentFA extends BaseFragment{


    @Override
    protected int setLayout(LayoutInflater inflater) {
        return R.layout.fragment_tobeaudited_fa;
    }

    @Override
    protected void init(Bundle savedInstanceState) {



    }

    @Override
    protected BaseRefreshLoadMoreInterface setRefreshLoadMoreListener() {
        return null;
    }

}
