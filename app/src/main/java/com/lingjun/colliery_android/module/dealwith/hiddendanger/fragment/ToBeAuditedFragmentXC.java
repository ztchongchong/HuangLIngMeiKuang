package com.lingjun.colliery_android.module.dealwith.hiddendanger.fragment;

import android.os.Bundle;

import com.lingjun.colliery_android.view.tablayout.TabLayout;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.lingjun.colliery_android.R;
import com.lingjun.colliery_android.base.BaseFragment;
import com.lingjun.colliery_android.view.NoScrollViewpager;

import java.util.ArrayList;
import java.util.List;

/**
 * 现场情况（待审核）
 */
public class ToBeAuditedFragmentXC extends BaseFragment{

    @Override
    protected int setLayout(LayoutInflater inflater) {
        return R.layout.fragment_tobeaudited_xc;
    }

    @Override
    protected void init(Bundle savedInstanceState) {

    }

    @Override
    protected BaseRefreshLoadMoreInterface setRefreshLoadMoreListener() {
        return null;
    }
}
