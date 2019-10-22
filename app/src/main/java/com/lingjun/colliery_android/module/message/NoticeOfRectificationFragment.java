package com.lingjun.colliery_android.module.message;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.blankj.utilcode.util.LogUtils;
import com.lingjun.colliery_android.R;
import com.lingjun.colliery_android.base.BaseFragment;
import com.lingjun.colliery_android.base.BaseLinkList;
import com.lingjun.colliery_android.bean.HiddenDangerDetailsBean;
import com.lingjun.colliery_android.bean.HiddenDangersDetailsBean;
import com.lingjun.colliery_android.module.dealwith.hiddendanger.activity.HiddenDangersDetailsActivity;
import com.lingjun.colliery_android.utils.DateUtil;
import com.lingjun.colliery_android.utils.FastJsonTools;
import com.lingjun.colliery_android.utils.retrofit.BaseSubscriber;
import com.lingjun.colliery_android.utils.retrofit.ExceptionHandle;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

import butterknife.BindView;


/**
 * 作者: 黄泉买骨人(zengtao)
 * 时间: 2018/11/26  11:54.
 * 注释:整改通知书
 */
public class NoticeOfRectificationFragment extends BaseFragment {
    private TextView tvNumber;
    private TextView tvAccountabilityUnit;
    private TextView tvHiddenDangerLevel;
    private TextView tvTimeLimit;
    private TextView tvPersonLiable;
    private TextView tvLeader;
    private TextView tv_acceptor;
    private TextView tvRectificationCause;
    private TextView tvRectificationGoal;
    private TextView tvCompanyDeductScore;
    private TextView tvFines;
    private TextView tvTime;
    private TextView tv_shenhe;
    private TextView tvCompilePerson;
    private TextView tv_acceptor_danwei;
    private TextView tv_cooperation;
    private String taskId;
    private LinearLayout ll_xietong;
    private TextView tv_technician;

    @Override
    protected int setLayout(LayoutInflater inflater) {
        return R.layout.fragment_notice_rectification;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        tvNumber = mRootView.findViewById(R.id.tv_number);
        tvAccountabilityUnit = mRootView.findViewById(R.id.tv_accountability_unit);
        tvHiddenDangerLevel = mRootView.findViewById(R.id.tv_hidden_danger_level);
        tvTimeLimit = mRootView.findViewById(R.id.tv_time_limit);
        tvPersonLiable = mRootView.findViewById(R.id.tv_person_liable);
        tvLeader = mRootView.findViewById(R.id.tv_leader);
        tv_acceptor = mRootView.findViewById(R.id.tv_acceptor);
        tvRectificationCause = mRootView.findViewById(R.id.tv_rectification_cause);
        tvRectificationGoal = mRootView.findViewById(R.id.tv_rectification_goal);
        tvCompanyDeductScore = mRootView.findViewById(R.id.tv_company_deduct_score);
        tvFines = mRootView.findViewById(R.id.tv_fines);
        tvTime = mRootView.findViewById(R.id.tv_time);
        tvCompilePerson = mRootView.findViewById(R.id.tv_compile_person);
        tv_shenhe = mRootView.findViewById(R.id.tv_shenhe);
        tv_acceptor_danwei = mRootView.findViewById(R.id.tv_acceptor_danwei);
        ll_xietong = mRootView.findViewById(R.id.ll_xietong);
        tv_cooperation = mRootView.findViewById(R.id.tv_cooperation);
        tv_technician = mRootView.findViewById(R.id.tv_technician);
        Intent getIntent = getActivity().getIntent();
        taskId = getIntent.getStringExtra("task_id");

        Refreshview();

    }

    private void Refreshview() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("id", "" + taskId);
        hashMap.put(BaseLinkList.apiurl, BaseLinkList.coal_mine + BaseLinkList.troubleinfo);
        mRetrofit.JsonToColliery(BaseLinkList.Base_Url, hashMap, new BaseSubscriber() {
            @Override
            public void onError(ExceptionHandle.ResponeThrowable e) {

            }

            @Override
            public void onSuccess(JSONObject jsonObject) {
                LogUtils.e("整改通知书->>" + jsonObject.toString());
                final HiddenDangerDetailsBean hiddenDangerDetailsBean = FastJsonTools.getBean(jsonObject.toString(), HiddenDangerDetailsBean.class);

                //编号
                tvNumber.setText("编号：" + hiddenDangerDetailsBean.getData().getSubTaskList().getCorrectNoticeNo());
                //责任单位
                tvAccountabilityUnit.setText(hiddenDangerDetailsBean.getData().getSubTaskList().getResponsibleDepartmentName());
                //隐患等级
                tvHiddenDangerLevel.setText(hiddenDangerDetailsBean.getData().getSubTaskList().getTroubleLevel());
                //时限
                tvTimeLimit.setText(hiddenDangerDetailsBean.getData().getSubTaskList().getRectifyDay() + "天");
                //责任人
                tvPersonLiable.setText("责任：" + hiddenDangerDetailsBean.getData().getSubTaskList().getResponsibleUserName());
                //领导
                tvLeader.setText("领导：" + hiddenDangerDetailsBean.getData().getSubTaskList().getResponsibleLeaderName());
                //验收人
                tv_acceptor.setText("验收：" + hiddenDangerDetailsBean.getData().getSubTaskList().getResponsibleDepartmentName());

                //验收人
                if (hiddenDangerDetailsBean.getData().getSubTaskList().getState().equals("5")) {
                    tv_acceptor.setText("验收人：" + hiddenDangerDetailsBean.getData().getSubTaskList().getAcceptorName());
                } else if (hiddenDangerDetailsBean.getData().getSubTaskList().getState().equals("8")) {
                    tv_acceptor.setText("验收人：" + hiddenDangerDetailsBean.getData().getSubTaskList().getSolutionAcceptorName());
                } else if (hiddenDangerDetailsBean.getData().getSubTaskList().getState().equals("2")) {
                    tv_acceptor.setText("验收人：" + hiddenDangerDetailsBean.getData().getSubTaskList().getAcceptorName());
                } else {
                    tv_acceptor.setText("验收人：" + hiddenDangerDetailsBean.getData().getSubTaskList().getAcceptorName());
                }
                //整改原因
                tvRectificationCause.setText(hiddenDangerDetailsBean.getData().getSubTaskList().getTroubleContent());
                //整改目标
                tvRectificationGoal.setText(hiddenDangerDetailsBean.getData().getSubTaskList().getSolutionGoal());
                //单位扣分
                tvCompanyDeductScore.setText("单位扣分：" + hiddenDangerDetailsBean.getData().getSubTaskList().getResponsibleScore() + "分");
                //主责罚款
                tvFines.setText("主责罚款：" + hiddenDangerDetailsBean.getData().getSubTaskList().getResponsibleMoney() + "元");
                //编制人
                tvCompilePerson.setText("编制人：" + hiddenDangerDetailsBean.getData().getSubTaskList().getProcessorName());
                //审核人
                tv_shenhe.setText(hiddenDangerDetailsBean.getData().getSubTaskList().getApproverName());
                //时间
                tvTime.setText("时间：" + DateUtil.getStringByFormat(hiddenDangerDetailsBean.getData().getSubTaskList().getProcessTime(), "yyyy/MM/dd"));
                //验收单位
                if (hiddenDangerDetailsBean.getData().getSubTaskList().getAcceptanceDepartmentsName() != null) {
                    StringBuffer stringBuffer = new StringBuffer(hiddenDangerDetailsBean.getData().getSubTaskList().getAcceptanceDepartmentsName());
                    if (',' == stringBuffer.charAt(stringBuffer.length() - 1) && ',' == stringBuffer.charAt(0)) {
                        stringBuffer = stringBuffer.deleteCharAt(stringBuffer.length() - 1).deleteCharAt(0);
                    }
                    tv_acceptor_danwei.setText("验收单位:" + stringBuffer);
                }
                if (hiddenDangerDetailsBean.getData().getCollaborativeUnitsSwitch().equals("0")) {
                    ll_xietong.setVisibility(View.GONE);
                } else if (hiddenDangerDetailsBean.getData().getCollaborativeUnitsSwitch().equals("1")) {
                    ll_xietong.setVisibility(View.VISIBLE);
                    //协作单位
                    tv_cooperation.setText(hiddenDangerDetailsBean.getData().getSubTaskList().getCollaborativeUnits());
                }
                //技术员
                tv_technician.setText("技术员:" + hiddenDangerDetailsBean.getData().getSubTaskList().getTechnicianName());
            }
        });
    }

    @Override
    protected BaseRefreshLoadMoreInterface setRefreshLoadMoreListener() {
        return null;
    }


}
