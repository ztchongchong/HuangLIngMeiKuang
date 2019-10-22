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

/**
 * 作者: lihuan
 * 时间: 2018/11/17 17:38
 * 说明: 延后理由
 */
public class PostponedReasonFragment extends BaseFragment {

    /**
     * 处理人
     */
    @BindView(R.id.tv_dispose_person)
    TextView tvDisposePerson;
    /**
     * 恢复时间
     */
    @BindView(R.id.tv_recovery_time)
    TextView tvRecoveryTime;
    /**
     * 延后理由
     */
    @BindView(R.id.tv_reasons_postpone)
    TextView tvReasonsPostpone;

    private HiddenDangerDetailsBean mParam;

    public PostponedReasonFragment() {
    }

    public static PostponedReasonFragment newInstance(HiddenDangerDetailsBean dangerDetailsBean) {
        PostponedReasonFragment fragment = new PostponedReasonFragment();
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
        return R.layout.fragment_postponed_reason;
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
            tvDisposePerson.setText(data.getSubTaskList().getSolutionResponsibleUserName()+"");
            tvRecoveryTime.setText(DateUtil.getStringByFormat(data.getSubTaskList().getDelayTime(), "yyyy-MM-dd"));
            tvReasonsPostpone.setText(data.getSubTaskList().getDelayReason());
            tvReasonsPostpone.setMovementMethod(ScrollingMovementMethod.getInstance());
        }

    }
}
