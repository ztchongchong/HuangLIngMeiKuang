package com.lingjun.colliery_android.module.dealwith.fragment;


import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.widget.TextView;

import com.lingjun.colliery_android.R;
import com.lingjun.colliery_android.base.BaseFragment;
import com.lingjun.colliery_android.bean.HiddenDangerDetailsBean;

import butterknife.BindView;

/**
 * 作者: lihuan
 * 时间: 2018/11/20 14:22
 * 说明: 方案简述
 */
public class SchemeDescriptionFragment extends BaseFragment {
    @BindView(R.id.tv_all_responsible_person)
    TextView tvAllResponsiblePerson; //总负责人
    @BindView(R.id.tv_time_limit)
    TextView tvTimeLimit; //时限
    @BindView(R.id.tv_governance_description)
    TextView tvGovernanceDescription; //治理简述

    private HiddenDangerDetailsBean mParam;

    public SchemeDescriptionFragment() {
    }

    public static SchemeDescriptionFragment newInstance(HiddenDangerDetailsBean dangerDetailsBean) {
        SchemeDescriptionFragment fragment = new SchemeDescriptionFragment();
        fragment.mParam = dangerDetailsBean;
//        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int setLayout(LayoutInflater inflater) {
        return R.layout.fragment_scheme_description;
    }

    @Override
    protected BaseRefreshLoadMoreInterface setRefreshLoadMoreListener() {
        return null;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        if (mParam != null && mParam.getData() != null) {
            dataDisplay(mParam.getData());
        }
    }

    /**
     * 界面数据填充
     *
     * @param data
     */
    private void dataDisplay(HiddenDangerDetailsBean.DataBean data) {
        if (data.getSubTaskList() != null) {
            tvAllResponsiblePerson.setText(data.getSubTaskList().getSolutionChiefName());
            tvTimeLimit.setText(data.getSubTaskList().getSolutionTimeLimit() + " 天");
            tvGovernanceDescription.setText(data.getSubTaskList().getSolutionGoal());
            tvGovernanceDescription.setMovementMethod(ScrollingMovementMethod.getInstance());
        }
    }

}
