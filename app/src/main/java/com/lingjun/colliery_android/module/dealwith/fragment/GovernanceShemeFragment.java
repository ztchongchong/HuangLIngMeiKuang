package com.lingjun.colliery_android.module.dealwith.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.TextView;

import com.blankj.utilcode.util.StringUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.lingjun.colliery_android.R;
import com.lingjun.colliery_android.base.BaseFragment;
import com.lingjun.colliery_android.bean.HiddenDangerDetailsBean;
import com.lingjun.colliery_android.module.dealwith.activity.AttachmentsListActivity;
import com.lingjun.colliery_android.module.dealwith.activity.SolutionActivity;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 作者: lihuan
 * 时间: 2018/11/17 15:41
 * 说明: 治理方案
 */
public class GovernanceShemeFragment extends BaseFragment {
    @BindView(R.id.tv_solution)
    TextView tvSolution;
    @BindView(R.id.tv_person_liable)
    TextView tvPersonLiable;
    @BindView(R.id.tv_content_liable)
    TextView tvContentLiable;
    @BindView(R.id.tv_see_attachment)
    TextView tvSeeAttachment;
    @BindView(R.id.tv_inspection_instruction)
    TextView tvInspectionInstruction;
    @BindView(R.id.tv_acceptor)
    TextView tvAcceptor;
    @BindView(R.id.tv_inspected_content)
    TextView tvInspectedContent;
    @BindView(R.id.tv_see_attachment1)
    TextView tvSeeAttachment1;

    private HiddenDangerDetailsBean mParam;

    public GovernanceShemeFragment() {
    }

    public static GovernanceShemeFragment newInstance(HiddenDangerDetailsBean dangerDetailsBean) {
        GovernanceShemeFragment fragment = new GovernanceShemeFragment();
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
        return R.layout.fragment_governance_sheme;
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
            tvPersonLiable.setText("责任人：" + data.getSubTaskList().getResponsibleUserName());
            tvContentLiable.setText("方案内容: " + data.getSubTaskList().getSolutionContent());
            tvAcceptor.setText("验收单位：" + data.getSubTaskList().getAcceptanceDepartmentsName());
            tvInspectedContent.setText("验收依据: " + data.getSubTaskList().getAcceptReason());
        }

        if (data.getFafileList() != null && data.getFafileList().size() > 0) {
            tvSeeAttachment.setText("查看附件(" + data.getFafileList().size() + ")");
            tvSeeAttachment.setEnabled(true);
            tvSeeAttachment.setTextColor(getResources().getColor(R.color.bule));
        } else {
            tvSeeAttachment.setText("无附件");
            tvSeeAttachment.setEnabled(false);
            tvSeeAttachment.setTextColor(getResources().getColor(R.color.gray));
        }

        if (data.getYsfileList() != null && data.getYsfileList().size() > 0) {
            tvSeeAttachment1.setText("查看附件(" + data.getYsfileList().size() + ")");
            tvSeeAttachment1.setEnabled(true);
            tvSeeAttachment1.setTextColor(getResources().getColor(R.color.bule));
        } else {
            tvSeeAttachment1.setText("无附件");
            tvSeeAttachment1.setEnabled(false);
            tvSeeAttachment1.setTextColor(getResources().getColor(R.color.gray));
        }
    }

//    @OnClick(R.id.tv_solution)
//    public void onTvSolutionClicked() { //治理方案
//        if (mParam != null && mParam.getData() != null && mParam.getData().getSubTaskList() != null
//                && !StringUtils.isEmpty(mParam.getData().getSubTaskList().getSolutionContent())) {
//            Intent intent = new Intent(getActivity(), SolutionActivity.class);
//            intent.putExtra("title", "治理方案");
//            intent.putExtra("content", mParam.getData().getSubTaskList().getSolutionContent());
//            startActivity(intent);
//        } else {
//            ToastUtils.showShort("暂无治理方案");
//        }
//    }

    @OnClick(R.id.tv_see_attachment)
    public void onTvSeeAttachmentClicked() { //治理方案附件
        Intent intent = new Intent(getActivity(), AttachmentsListActivity.class);
        intent.putExtra("fafileListBeans", mParam.getData().getFafileList());
        startActivity(intent);
    }

//    @OnClick(R.id.tv_inspection_instruction)
//    public void onTvInspectionInstructionClicked() { //验收说明
//        if (mParam != null && mParam.getData() != null
//                && mParam.getData().getSubTaskList() != null
//                && !StringUtils.isEmpty(mParam.getData().getSubTaskList().getAcceptReason())) {
//            Intent intent = new Intent(getActivity(), SolutionActivity.class);
//            intent.putExtra("title", "验收说明");
//            intent.putExtra("content", mParam.getData().getSubTaskList().getAcceptReason());
//            startActivity(intent);
//        } else {
//            ToastUtils.showShort("暂无验收说明");
//        }
//    }

    @OnClick(R.id.tv_see_attachment1)
    public void onTvSeeAttachment1Clicked() { //验收说明附件
        Intent intent = new Intent(getActivity(), AttachmentsListActivity.class);
        intent.putExtra("ysfileListBeans", mParam.getData().getYsfileList());
        startActivity(intent);
    }

}
