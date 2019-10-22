package com.lingjun.colliery_android.module.dealwith.fragment;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lingjun.colliery_android.R;
import com.lingjun.colliery_android.base.BaseFragment;
import com.lingjun.colliery_android.base.OnGlobalListener;
import com.lingjun.colliery_android.bean.HiddenDangerDetailsBean;
import com.lingjun.colliery_android.bean.HiddenDangersDetailsBean;
import com.lingjun.colliery_android.utils.DateUtil;
import com.lingjun.colliery_android.utils.RecyclerViewUtils;
import com.lingjun.colliery_android.utils.ToastUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * 作者: lihuan
 * 时间: 2018/11/17 16:13
 * 说明: 整改通知书
 */
public class NoticeRectificationFragment extends BaseFragment {
    @BindView(R.id.tv_number)
    TextView tvNumber;
    @BindView(R.id.tv_accountability_unit)
    TextView tvAccountabilityUnit;
    @BindView(R.id.tv_hidden_danger_level)
    TextView tvHiddenDangerLevel;
    @BindView(R.id.tv_time_limit)
    TextView tvTimeLimit;
    @BindView(R.id.tv_person_liable)
    TextView tvPersonLiable;
    @BindView(R.id.tv_leader)
    TextView tvLeader;
    @BindView(R.id.tv_acceptor)
    TextView tvAcceptor;
    @BindView(R.id.tv_rectification_cause)
    TextView tvRectificationCause;
    @BindView(R.id.tv_rectification_goal)
    TextView tvRectificationGoal;
    @BindView(R.id.tv_company_deduct_score)
    TextView tvCompanyDeductScore;
    @BindView(R.id.tv_fines)
    TextView tvFines;
    @BindView(R.id.tv_time)
    TextView tvTime;
    @BindView(R.id.tv_auditor)
    TextView tvAuditor;
    @BindView(R.id.tv_compile_person)
    TextView tvCompilePerson;
    private TextView tv_shenhe;
    private TextView tv_cooperation;
    private LinearLayout ll_zg_explain;
    private TextView tv_zg_explain;
    private RecyclerView rl_view;
    private HiddenDangerDetailsBean mParam;
    private TextView tv_acceptor_danwei;
    private TextView tv_technician;//技术员
    private LinearLayout ll_xietong;

    private TextView tv_zerenren;
    private TextView tv_classTime;

    public NoticeRectificationFragment() {
    }

    public static NoticeRectificationFragment newInstance(HiddenDangerDetailsBean dangerDetailsBean) {
        NoticeRectificationFragment fragment = new NoticeRectificationFragment();
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
        return R.layout.fragment_notice_rectification;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        ll_zg_explain = mRootView.findViewById(R.id.ll_zg_explain);
        tv_zg_explain = mRootView.findViewById(R.id.tv_zg_explain);
        rl_view = mRootView.findViewById(R.id.rl_view);
        tv_cooperation = mRootView.findViewById(R.id.tv_cooperation);
        tv_shenhe = mRootView.findViewById(R.id.tv_shenhe);
        tv_acceptor_danwei = mRootView.findViewById(R.id.tv_acceptor_danwei);
        tv_technician = mRootView.findViewById(R.id.tv_technician);
        ll_xietong = mRootView.findViewById(R.id.ll_xietong);
        tv_zerenren = mRootView.findViewById(R.id.tv_zerenren);
        tv_classTime = mRootView.findViewById(R.id.tv_classTime);
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
            if (data.getCurrUserIdcard() == 2) {
                ll_zg_explain.setVisibility(View.VISIBLE);
                tv_zg_explain.setText(data.getSubTaskList().getSolutionContent());
                if (null != data.getZgfileList()) {
                    RecyclerViewUtils.initLiner(getActivity(), rl_view, R.layout.item_personal_folders_child, data.getZgfileList(), new OnGlobalListener() {
                        @Override
                        public <T> void logic(BaseViewHolder helper, List<T> mData, T item, BaseQuickAdapter mAdapter) {
                            HiddenDangerDetailsBean.DataBean.ZgfileListBean zgfileListBean = (HiddenDangerDetailsBean.DataBean.ZgfileListBean) item;
                            TextView tv_child_title = helper.getView(R.id.tv_child_title);
                            ImageView iv_download = helper.getView(R.id.iv_download);
//                            iv_download.setVisibility(View.VISIBLE);
                            tv_child_title.setText(zgfileListBean.getFileName());
                        }
                    }, new BaseQuickAdapter.OnItemClickListener() {
                        @Override
                        public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                            HiddenDangerDetailsBean.DataBean.ZgfileListBean zgfileListBean = (HiddenDangerDetailsBean.DataBean.ZgfileListBean) adapter.getData().get(position);
                            ToastUtils.showToast(getActivity(), "" + zgfileListBean.getFileName());
                        }
                    }, null);
                }
            }
            //编号
            tvNumber.setText("编号：" + data.getSubTaskList().getCorrectNoticeNo());
            //责任单位
            tvAccountabilityUnit.setText("责任单位：" + data.getSubTaskList().getResponsibleDepartmentName());
            //隐患等级
            tvHiddenDangerLevel.setText(data.getSubTaskList().getTroubleLevel());
            //时限
            tvTimeLimit.setText(data.getSubTaskList().getRectifyDay() + "天");

            tv_classTime.setText(data.getSubTaskList().getHazardDivisions() + "点");//班次

            if (data.getSubTaskList().getResponsiblePersonLeadership() != null) {
                tv_zerenren.setText("责任人：" + data.getSubTaskList().getResponsiblePersonLeadership());//责任人
            } else {
                tv_zerenren.setText("责任人：");//责任人
            }
            //整改人
            if (data.getSubTaskList().getState().equals("5")) {//待整改
                tvPersonLiable.setText("整改人：" + data.getSubTaskList().getResponsibleUserName());
            } else if (data.getSubTaskList().getState().equals("2")) {//带审核
                tvPersonLiable.setText("整改人：" + data.getSubTaskList().getResponsibleUserName());
            } else if (data.getSubTaskList().getState().equals("6")) {//待验收
                tvPersonLiable.setText("整改人：" + data.getSubTaskList().getSolutionResponsibleUserName());
            } else if (data.getSubTaskList().getState().equals("8")) {//待销号
                tvPersonLiable.setText("整改人：" + data.getSubTaskList().getSolutionResponsibleUserName());
            } else {
                tvPersonLiable.setText("整改人：" + data.getSubTaskList().getResponsibleUserName());
            }
            //上级领导
            tvLeader.setText("上级领导：" + data.getSubTaskList().getResponsibleLeaderName());
            //验收人
            if (data.getSubTaskList().getState().equals("5")) {
                tvAcceptor.setText("验收人：" + data.getSubTaskList().getAcceptorName());
            } else if (data.getSubTaskList().getState().equals("8")) {
                tvAcceptor.setText("验收人：" + data.getSubTaskList().getSolutionAcceptorName());
            } else if (data.getSubTaskList().getState().equals("2")) {
                tvAcceptor.setText("验收人：" + data.getSubTaskList().getAcceptorName());
            } else {
                tvAcceptor.setText("验收人：" + data.getSubTaskList().getAcceptorName());
            }
            //由于
            tvRectificationCause.setText(data.getSubTaskList().getSourceDescription());
            //整改目标
            tvRectificationGoal.setText(data.getMaintask().getClauseMeasures());
            //单位扣分
            tvCompanyDeductScore.setText("单位扣分：" + data.getSubTaskList().getResponsibleScore() + "分");
            //主责罚款
            tvFines.setText("主责罚款：" + data.getSubTaskList().getResponsibleMoney() + "元");
            //编制人
            tvCompilePerson.setText("编制人：" + data.getSubTaskList().getProcessorName());
            //审核人
            tvAuditor.setText("审核人：" + data.getSubTaskList().getSourceProcessorName());
            //时间
            tvTime.setText("时间：" + DateUtil.getStringByFormat(data.getSubTaskList().getProcessTime(), "yyyy/MM/dd"));
            //审核人
            tv_shenhe.setText("审核人：" + data.getSubTaskList().getApproverName());
            //技术员
            tv_technician.setText("技术员:" + data.getSubTaskList().getTechnicianName());
            //验收单位
            if (data.getSubTaskList().getAcceptanceDepartmentsName() != null && !TextUtils.isEmpty(data.getSubTaskList().getAcceptanceDepartmentsName())) {
                StringBuffer stringBuffer = new StringBuffer(data.getSubTaskList().getAcceptanceDepartmentsName());
                if (',' == stringBuffer.charAt(stringBuffer.length() - 1) && ',' == stringBuffer.charAt(0)) {
                    stringBuffer = stringBuffer.deleteCharAt(stringBuffer.length() - 1).deleteCharAt(0);
                }
                tv_acceptor_danwei.setText("验收单位：" + stringBuffer);
            }
            if (data.getCollaborativeUnitsSwitch() != null) {
                if (data.getCollaborativeUnitsSwitch().equals("0")) {
                    ll_xietong.setVisibility(View.GONE);
                } else if (data.getCollaborativeUnitsSwitch().equals("1")) {
                    ll_xietong.setVisibility(View.VISIBLE);
                    //协作单位
                    tv_cooperation.setText(data.getSubTaskList().getCollaborativeUnits());
                }
            }
        }
    }
}
