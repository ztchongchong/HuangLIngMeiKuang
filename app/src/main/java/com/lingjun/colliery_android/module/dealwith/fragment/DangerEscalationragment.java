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
 * 时间: 2018/11/17 17:09
 * 说明: 危险升级
 */
public class DangerEscalationragment extends BaseFragment {

    @BindView(R.id.tv_dispose_person)
    TextView tvDisposePerson;
    @BindView(R.id.tv_judgment_basis)
    TextView tvJudgmentBasis;

    private HiddenDangerDetailsBean mParam;

    public DangerEscalationragment() {
    }

    public static DangerEscalationragment newInstance(HiddenDangerDetailsBean dangerDetailsBean) {
        DangerEscalationragment fragment = new DangerEscalationragment();
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
        return R.layout.fragment_danger_escalationragment;
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
            tvDisposePerson.setText(data.getSubTaskList().getFatalApproverName());
            tvJudgmentBasis.setText(data.getSubTaskList().getFatalReason());
            tvJudgmentBasis.setMovementMethod(ScrollingMovementMethod.getInstance());
        }
    }

}
