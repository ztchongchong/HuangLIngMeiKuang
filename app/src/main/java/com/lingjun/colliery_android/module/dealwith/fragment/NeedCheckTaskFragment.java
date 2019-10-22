package com.lingjun.colliery_android.module.dealwith.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;

import com.lingjun.colliery_android.R;
import com.lingjun.colliery_android.base.BaseFragment;
import com.lingjun.colliery_android.utils.ToastUtils;

/**
 * Created by shurrikann on 2018/12/5.
 */

public class NeedCheckTaskFragment extends BaseFragment {
    private static final String KEY = "title";
    private int pos;

    @Override
    protected int setLayout(LayoutInflater inflater) {
        return R.layout.fragment_task_db;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        Bundle bundle = getArguments();
        pos = bundle.getInt("pos");
        ToastUtils.showLongToast(getActivity(), pos + "");
    }

    @Override
    protected BaseRefreshLoadMoreInterface setRefreshLoadMoreListener() {
        return null;
    }

    /**
     * 37      * fragment静态传值
     * 38
     */
    public static NeedCheckTaskFragment newInstance(String str, int pos) {
        NeedCheckTaskFragment fragment = new NeedCheckTaskFragment();
        Bundle bundle = new Bundle();
        bundle.putString(KEY, str);
        bundle.putInt("pos", pos);
        fragment.setArguments(bundle);
        return fragment;
    }
}
