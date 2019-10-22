package com.lingjun.colliery_android.module.main.rectifyingviolations.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.lingjun.colliery_android.R;
import com.lingjun.colliery_android.base.BaseFragment;

import butterknife.BindView;


/**
 * 作者: zengtao
 * 时间: 2019/1/4  8:54.
 * 注释:
 */
public class ImplementationHistoryFragment extends BaseFragment {
    @BindView(R.id.ll_1)
    LinearLayout ll1;
    @BindView(R.id.ll_2)
    LinearLayout ll2;
    @BindView(R.id.ll_3)
    LinearLayout ll3;

    private String extraType;

    @Override
    protected int setLayout(LayoutInflater inflater) {
        return R.layout.fragment_implementation_history;
    }

    @Override
    protected void init(Bundle savedInstanceState) {

        extraType = getActivity().getIntent().getStringExtra("extraType");

        if (extraType.equals("1")) {
            ll1.setVisibility(View.VISIBLE);
            ll2.setVisibility(View.GONE);
            ll3.setVisibility(View.GONE);
        } else if (extraType.equals("2")) {
            ll1.setVisibility(View.GONE);
            ll2.setVisibility(View.VISIBLE);
            ll3.setVisibility(View.GONE);
        } else if (extraType.equals("3")) {
            ll1.setVisibility(View.GONE);
            ll2.setVisibility(View.GONE);
            ll3.setVisibility(View.VISIBLE);
        } else if (extraType.equals("1,2")) {
            ll1.setVisibility(View.VISIBLE);
            ll2.setVisibility(View.VISIBLE);
            ll3.setVisibility(View.GONE);
        } else if (extraType.equals("1,3")) {
            ll1.setVisibility(View.VISIBLE);
            ll2.setVisibility(View.GONE);
            ll3.setVisibility(View.VISIBLE);
        }else if (extraType.equals("2,3")) {
            ll1.setVisibility(View.GONE);
            ll2.setVisibility(View.VISIBLE);
            ll3.setVisibility(View.VISIBLE);
        }else if (extraType.equals("1,2,3")) {
            ll1.setVisibility(View.VISIBLE);
            ll2.setVisibility(View.VISIBLE);
            ll3.setVisibility(View.VISIBLE);
        }

    }

    @Override
    protected BaseRefreshLoadMoreInterface setRefreshLoadMoreListener() {
        return null;
    }


}
