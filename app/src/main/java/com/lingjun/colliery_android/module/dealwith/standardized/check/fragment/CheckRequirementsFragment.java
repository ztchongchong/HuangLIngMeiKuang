package com.lingjun.colliery_android.module.dealwith.standardized.check.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;

import com.lingjun.colliery_android.R;
import com.lingjun.colliery_android.base.BaseFragment;

/**
 * 检查要求
 * Created by nefa on 2018/11/13.
 */

public class CheckRequirementsFragment extends BaseFragment {



    @Override
    protected int setLayout(LayoutInflater inflater) {
        return R.layout.fragment_check_requirements;
    }

    @Override
    protected void init(Bundle savedInstanceState) {

    }

    @Override
    protected BaseRefreshLoadMoreInterface setRefreshLoadMoreListener() {
        return null;
    }
}
