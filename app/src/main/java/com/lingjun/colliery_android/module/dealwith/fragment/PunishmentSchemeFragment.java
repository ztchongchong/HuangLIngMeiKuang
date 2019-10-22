package com.lingjun.colliery_android.module.dealwith.fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.lingjun.colliery_android.R;
import com.lingjun.colliery_android.base.BaseFragment;
import com.lingjun.colliery_android.bean.HiddenDangerDetailsBean;
import com.lingjun.colliery_android.utils.DateUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * 作者: lihuan
 * 时间: 2018/11/17 15:27
 * 说明: 处罚方案
 */
public class PunishmentSchemeFragment extends BaseFragment {
    @BindView(R.id.tv_company_deduct_score)
    TextView tvCompanyDeductScore;
    @BindView(R.id.tv_fines)
    TextView tvFines;
    @BindView(R.id.tv_danger_level)
    TextView tvDangerLevel;
    @BindView(R.id.tv_auditor)
    TextView tvAuditor;
    @BindView(R.id.tv_accountability_unit)
    TextView tvAccountabilityUnit;
    @BindView(R.id.tv_person_liable)
    TextView tvPersonLiable;
    @BindView(R.id.tv_acceptor)
    TextView tvAcceptor;
    private TextView tv_auditor1;
    private TextView tv_cooperation;
    private TextView tv_acceptor_people;
    private TextView tv_jishuren;

    private HiddenDangerDetailsBean mParam;

    public PunishmentSchemeFragment() {
    }

    public static PunishmentSchemeFragment newInstance(HiddenDangerDetailsBean dangerDetailsBean) {
        PunishmentSchemeFragment fragment = new PunishmentSchemeFragment();
        fragment.mParam = dangerDetailsBean;
//        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected BaseRefreshLoadMoreInterface setRefreshLoadMoreListener() {
        return null;
    }

    @Override
    protected int setLayout(LayoutInflater inflater) {
        return R.layout.fragment_punishment_scheme;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        tv_auditor1 = mRootView.findViewById(R.id.tv_auditor1);
        tv_cooperation = mRootView.findViewById(R.id.tv_cooperation);
        tv_acceptor_people=mRootView.findViewById(R.id.tv_acceptor_people);
        tv_jishuren=mRootView.findViewById(R.id.tv_jishuren);
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
            tvCompanyDeductScore.setText(data.getSubTaskList().getResponsibleScore() + "分");
            tvFines.setText(data.getSubTaskList().getResponsibleMoney() + "元");
            tvDangerLevel.setText(data.getSubTaskList().getTroubleLevel());
            tvAuditor.setText(data.getSubTaskList().getResponsibleLeaderName());
            tvAccountabilityUnit.setText(data.getSubTaskList().getResponsibleDepartmentName());
            tvPersonLiable.setText(data.getSubTaskList().getResponsibleUserName());
            tvAcceptor.setText(data.getSubTaskList().getAcceptanceDepartmentsName());
            tv_acceptor_people.setText(data.getSubTaskList().getAcceptorName());
            tv_auditor1.setText(data.getSubTaskList().getApproverName());
            tv_jishuren.setText(data.getSubTaskList().getTechnicianName());
        }
    }
}
