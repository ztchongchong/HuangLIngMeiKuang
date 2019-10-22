package com.lingjun.colliery_android.module.dealwith.fragment;


import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.TextView;

import com.lingjun.colliery_android.R;
import com.lingjun.colliery_android.base.BaseFragment;
import com.lingjun.colliery_android.bean.HiddenDangerDetailsBean;
import com.lingjun.colliery_android.utils.DateUtil;

import butterknife.BindView;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * 作者: lihuan
 * 时间: 2018/11/17 17:29
 * 说明: 驳回意见
 */
public class RejectOpinionFragment extends BaseFragment {

    @BindView(R.id.tv_acceptor)
    TextView tvAcceptor;
    @BindView(R.id.tv_reject_time)
    TextView tvRejectTime;
    @BindView(R.id.tv_reject_opinion)
    TextView tvRejectOpinion;

    private HiddenDangerDetailsBean mParam;

    public RejectOpinionFragment() {
    }

    public static RejectOpinionFragment newInstance(HiddenDangerDetailsBean dangerDetailsBean) {
        RejectOpinionFragment fragment = new RejectOpinionFragment();
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
        return R.layout.fragment_reject_opinion;
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
            tvAcceptor.setText(data.getSubTaskList().getAcceptorName());
            tvRejectOpinion.setText(data.getSubTaskList().getAcceptanceDismiss());
            tvRejectOpinion.setMovementMethod(ScrollingMovementMethod.getInstance());
        }
        if (data.getSysTask() != null) {
            tvRejectTime.setText(DateUtil.getStringByFormat(data.getSysTask().getModifytime(), "yyyy-MM-dd"));
        }
    }
}
