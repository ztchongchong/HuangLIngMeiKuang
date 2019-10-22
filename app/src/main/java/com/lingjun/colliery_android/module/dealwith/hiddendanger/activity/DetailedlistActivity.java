package com.lingjun.colliery_android.module.dealwith.hiddendanger.activity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.lingjun.colliery_android.R;
import com.lingjun.colliery_android.base.BaseActivity;
import com.lingjun.colliery_android.base.BaseLinkList;
import com.lingjun.colliery_android.bean.HiddenDangerDetailsBean;
import com.lingjun.colliery_android.bean.Result;
import com.lingjun.colliery_android.eventbus.MsgEvent;
import com.lingjun.colliery_android.module.dealwith.activity.DelayApplyActivity;
import com.lingjun.colliery_android.module.dealwith.activity.RectificationActivity;
import com.lingjun.colliery_android.module.dealwith.activity.RejectCommitActivity;
import com.lingjun.colliery_android.utils.DateUtil;
import com.lingjun.colliery_android.utils.FastJsonTools;
import com.lingjun.colliery_android.utils.retrofit.BaseSubscriber;
import com.lingjun.colliery_android.utils.retrofit.ExceptionHandle;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 作者: zengtao
 * 时间: 2019/8/16  9:38.
 * 注释: 整改问题清单
 *
 * @author ztchongchong
 */
public class DetailedlistActivity extends BaseActivity {
    @BindView(R.id.tv_number)
    TextView tvNumber;
    @BindView(R.id.tv_major)
    TextView tvMajor;
    @BindView(R.id.tv_time_limit)
    TextView tvTimeLimit;
    @BindView(R.id.tv_cooperation)
    TextView tvCooperation;
    @BindView(R.id.ll_xietong)
    LinearLayout llXietong;
    @BindView(R.id.tv_accountability_unit)
    TextView tvAccountabilityUnit;
    @BindView(R.id.tv_zerenren)
    TextView tvZerenren;
    @BindView(R.id.tv_person_liable)
    TextView tvPersonLiable;
    @BindView(R.id.tv_leader)
    TextView tvLeader;
    @BindView(R.id.tv_acceptor_danwei)
    TextView tvAcceptorDanwei;
    @BindView(R.id.tv_acceptor)
    TextView tvAcceptor;
    @BindView(R.id.tv_problem)
    TextView tvProblem;
    @BindView(R.id.tv_rectification_goal)
    TextView tvRectificationGoal;
    @BindView(R.id.tv_zg_explain)
    TextView tvZgExplain;
    @BindView(R.id.rl_view)
    RecyclerView rlView;
    @BindView(R.id.ll_zg_explain)
    LinearLayout llZgExplain;
    @BindView(R.id.tv_time)
    TextView tvTime;
    @BindView(R.id.tv_auditor)
    TextView tvAuditor;
    @BindView(R.id.tv_compile_person)
    TextView tvCompilePerson;
    @BindView(R.id.btn_rectification)
    TextView btnRectification;
    @BindView(R.id.ll_bottom)
    LinearLayout llBottom;
    @BindView(R.id.btn_inspection_instruction)
    TextView btnInspectionInstruction;
    @BindView(R.id.ll_bottom1)
    LinearLayout llBottom1;
    @BindView(R.id.btn_cancel)
    TextView btnCancel;
    @BindView(R.id.ll_bottom2)
    LinearLayout llBottom2;
    @BindView(R.id.btn_file)
    TextView btnFile;
    @BindView(R.id.ll_bottom3)
    LinearLayout llBottom3;
    @BindView(R.id.tv_bohuiliyou)
    TextView tvBohuiliyou;
    @BindView(R.id.tv_yanshouliyou)
    TextView tvYanshouliyou;
    @BindView(R.id.tv_bohuiliyou1)
    TextView tvBohuiliyou1;
    @BindView(R.id.btn_delay)
    TextView btnDelay;
    @BindView(R.id.btn_reject)
    TextView btnReject;
    @BindView(R.id.btn_pass)
    TextView btnPass;
    @BindView(R.id.ll_bottom4)
    LinearLayout llBottom4;
    @BindView(R.id.btn_yq_pass)
    Button btnYqPass;
    @BindView(R.id.ll_bottom5)
    LinearLayout llBottom5;
    private String taskId;
    private String mainTaskId;
    private int exhibition;
    private String status;

    @Override
    protected int getResourcesId() {
        return R.layout.activity_detailedlist;
    }

    @Override
    protected void init(Bundle savedInstanceState) throws PackageManager.NameNotFoundException {
        taskId = getIntent().getStringExtra("taskId");
        mainTaskId = getIntent().getStringExtra("mainTaskId");
        exhibition = getIntent().getIntExtra("exhibition", -1);
        status = getIntent().getStringExtra("status");
        if (exhibition == 0) {
            if (status.equals("5")) {
                llBottom.setVisibility(View.VISIBLE);
            } else if (status.equals("6")) {
                llBottom1.setVisibility(View.VISIBLE);
            } else if (status.equals("7")) {
                llBottom.setVisibility(View.VISIBLE);
            } else if (status.equals("11")) {
                llBottom4.setVisibility(View.VISIBLE);
            } else if (status.equals("12")) {
                llBottom4.setVisibility(View.VISIBLE);
            }
        } else {
            if (status.equals("8")) {
                llBottom2.setVisibility(View.VISIBLE);
            } else if (status.equals("9")) {
                llBottom3.setVisibility(View.VISIBLE);
            }
            if (status.equals("13")) {
                llBottom5.setVisibility(View.VISIBLE);
            }
        }

        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("id", taskId);
        hashMap.put("mainid", mainTaskId);
        hashMap.put(BaseLinkList.apiurl, BaseLinkList.coal_mine + BaseLinkList.troubleinfo);
        mRetrofit.JsonToColliery(BaseLinkList.Base_Url, hashMap, new BaseSubscriber() {
            @Override
            public void onError(ExceptionHandle.ResponeThrowable e) {
                dismissDialog();
            }

            @Override
            public void onSuccess(JSONObject jsonObject) {
                dismissDialog();
                LogUtils.e("隐患信息限时整改->>" + jsonObject.toString());
                final HiddenDangerDetailsBean dangerDetailsBean = FastJsonTools.getBean(jsonObject.toString(), HiddenDangerDetailsBean.class);
                if (dangerDetailsBean != null && dangerDetailsBean.getData() != null && dangerDetailsBean.getData().getSubTaskList() != null) {
                    //编号
                    tvNumber.setText("编号：" + dangerDetailsBean.getData().getSubTaskList().getCorrectNoticeNo());
                    //专业
                    tvMajor.setText(dangerDetailsBean.getData().getSubTaskList().getCheckProfessional());
                    //限时
                    tvTimeLimit.setText(dangerDetailsBean.getData().getSubTaskList().getRectifyDay() + "天");
                    //责任单位
                    tvAccountabilityUnit.setText("责任单位：" + dangerDetailsBean.getData().getSubTaskList().getResponsibleDepartmentName());
                    //责任人
                    if (dangerDetailsBean.getData().getSubTaskList().getResponsiblePersonLeadership() != null) {
                        tvZerenren.setText("责任人：" + dangerDetailsBean.getData().getSubTaskList().getResponsiblePersonLeadership());
                    } else {
                        tvZerenren.setText("责任人：");
                    }
                    //整改人
                    if (dangerDetailsBean.getData().getSubTaskList().getState().equals("5")) {//待整改
                        tvPersonLiable.setText("整改人：" + dangerDetailsBean.getData().getSubTaskList().getResponsibleUserName());
                    } else if (dangerDetailsBean.getData().getSubTaskList().getState().equals("2")) {//带审核
                        tvPersonLiable.setText("整改人：" + dangerDetailsBean.getData().getSubTaskList().getResponsibleUserName());
                    } else if (dangerDetailsBean.getData().getSubTaskList().getState().equals("6")) {//待验收
                        tvPersonLiable.setText("整改人：" + dangerDetailsBean.getData().getSubTaskList().getSolutionResponsibleUserName());
                    } else if (dangerDetailsBean.getData().getSubTaskList().getState().equals("8")) {//待销号
                        tvPersonLiable.setText("整改人：" + dangerDetailsBean.getData().getSubTaskList().getSolutionResponsibleUserName());
                    } else {
                        tvPersonLiable.setText("整改人：" + dangerDetailsBean.getData().getSubTaskList().getResponsibleUserName());
                    }
                    //上级领导
                    if (dangerDetailsBean.getData().getSubTaskList().getResponsibleLeaderName() != null) {
                        tvLeader.setText("上级领导：" + dangerDetailsBean.getData().getSubTaskList().getResponsibleLeaderName());
                    } else {
                        tvLeader.setText("上级领导：");
                    }
                    //验收单位
                    if (dangerDetailsBean.getData().getSubTaskList().getAcceptanceDepartmentsName() != null && !TextUtils.isEmpty(dangerDetailsBean.getData().getSubTaskList().getAcceptanceDepartmentsName())) {
                        StringBuffer stringBuffer = new StringBuffer(dangerDetailsBean.getData().getSubTaskList().getAcceptanceDepartmentsName());
                        if (',' == stringBuffer.charAt(stringBuffer.length() - 1) && ',' == stringBuffer.charAt(0)) {
                            stringBuffer = stringBuffer.deleteCharAt(stringBuffer.length() - 1).deleteCharAt(0);
                        }
                        tvAcceptorDanwei.setText("验收单位：" + stringBuffer);
                    }
                    //验收人
                    tvAcceptor.setText("验收人：" + dangerDetailsBean.getData().getSubTaskList().getAcceptorName());
                    //问题描述
//                    tvProblem.setText(dangerDetailsBean.getData().getSubTaskList().getSourceDescription());
                    tvProblem.setText(dangerDetailsBean.getData().getSubTaskList().getTroubleContent());
                    //整改措施
                    tvRectificationGoal.setText(dangerDetailsBean.getData().getSubTaskList().getSolutionContent());
//                    tvRectificationGoal.setText(dangerDetailsBean.getData().getSubTaskList().getAcceptanceDismiss());
                    //时间
                    tvTime.setText("时间：" + DateUtil.getStringByFormat(dangerDetailsBean.getData().getSubTaskList().getProcessTime(), "yyyy/MM/dd"));
                    //
                    tvCompilePerson.setText("编制人：" + dangerDetailsBean.getData().getSubTaskList().getSourceProcessorName());
                    if (dangerDetailsBean.getData().getSubTaskList().getAcceptanceDismiss() != null && !TextUtils.isEmpty(dangerDetailsBean.getData().getSubTaskList().getAcceptanceDismiss())) {
                        //验收驳回理由
                        tvBohuiliyou.setText(dangerDetailsBean.getData().getSubTaskList().getAcceptanceDismiss());
                    } else {
                        tvBohuiliyou1.setVisibility(View.GONE);
                        tvBohuiliyou.setVisibility(View.GONE);
                    }

                    //验收方案
                    if (dangerDetailsBean.getData().getSubTaskList().getAcceptReason() != null && !TextUtils.isEmpty(dangerDetailsBean.getData().getSubTaskList().getAcceptReason())) {
                        String a = dangerDetailsBean.getData().getSubTaskList().getAcceptReason().substring(1);
                        tvYanshouliyou.setText(a);
                    } else {
                        tvYanshouliyou.setText("");
                    }

                }
            }
        });
    }

    @Override
    protected BaseRefreshLoadMoreInterface setRefreshLoadMoreListener() {
        return null;
    }

    @OnClick({R.id.btn_rectification, R.id.btn_inspection_instruction, R.id.btn_cancel, R.id.btn_file, R.id.btn_delay, R.id.btn_reject, R.id.btn_pass, R.id.btn_yq_pass})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            //整改
            case R.id.btn_rectification:
                Intent intent = new Intent(this, RectificationActivity.class);
                intent.putExtra("taskId", taskId);
                intent.putExtra("type", 0);
                startActivity(intent);
                break;
            //延期申请
            case R.id.btn_delay:
                Intent intent2 = new Intent(this, DelayApplyActivity.class);
                intent2.putExtra("taskId", taskId);
                startActivity(intent2);
                break;
            //验收
            case R.id.btn_inspection_instruction:
                Intent intent1 = new Intent(this, RectificationActivity.class);
                intent1.putExtra("taskId", taskId);
                intent1.putExtra("type", 1);
                startActivity(intent1);
                break;
            //销号
            case R.id.btn_cancel:
                cancelandfile(1);
                break;
            //归档
            case R.id.btn_file:
                cancelandfile(2);
                break;
            //驳回
            case R.id.btn_reject:
                if ("11".equals(status)) {
                    delayPassOrReject(taskId, "5");
                }
                if ("12".equals(status)) {
                    delayPassOrReject(taskId, "5");
                }
//                else {
//                    Intent intent4 = new Intent(this, RejectCommitActivity.class);
//                    intent4.putExtra("taskId", taskId);
//                    startActivity(intent4);
//                }
                break;
            //通过
            case R.id.btn_pass:
                delayPassOrReject(taskId, "12");
                break;
            //延期通过
            case R.id.btn_yq_pass:
                delayPassOrReject(taskId, "-1");
                break;
            default:
        }

    }

    /**
     * 待办、督办--> 限时整改、挂牌督办延期待审核通过、驳回、延期中恢复接口
     */
    private void delayPassOrReject(String taskId, String flag) {
        HashMap<String, String> hashMap = new HashMap<>();

        hashMap.put("taskSubId", taskId);
        hashMap.put("flag", flag);
        hashMap.put(BaseLinkList.apiurl, BaseLinkList.coal_mine + BaseLinkList.delayPassOrReject);
        mRetrofit.JsonToColliery(BaseLinkList.Base_Url, hashMap, new BaseSubscriber() {
            @Override
            public void onError(ExceptionHandle.ResponeThrowable e) {
                if (null != refreshLayout) {
                    refreshLayout.finishRefresh();
                    refreshLayout.finishLoadMore();
                }
            }

            @Override
            public void onSuccess(JSONObject jsonObject) {
                LogUtils.e("待办待审核通过->>" + jsonObject.toString());
                Result result = FastJsonTools.getBean(jsonObject.toString(), Result.class);
                ToastUtils.showShort(result.getMsg());
                if ("200".equals(result.getCode())) {
                    EventBus.getDefault().post(new MsgEvent.RejectCommitSuccess());
                }
            }
        });
    }

    private void cancelandfile(int saveType) {
        HashMap<String, String> params = new HashMap<>();
        params.put("taskId", taskId);
        params.put("saveType", saveType + "");
        params.put(BaseLinkList.apiurl, BaseLinkList.coal_mine + BaseLinkList.getSaveTypeButton);
        mRetrofit.JsonToColliery(BaseLinkList.Base_Url, params, new BaseSubscriber() {
            @Override
            public void onError(ExceptionHandle.ResponeThrowable e) {
                dismissDialog();
            }

            @Override
            public void onSuccess(JSONObject jsonObject) throws JSONException {
                if (jsonObject.getString("code").equals("200")) {
                    finish();
                    ToastUtils.showShort("成功!");
                }
                dismissDialog();
            }
        });
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void rejectSuccess(MsgEvent.RejectCommitSuccess messageEvent) {
        finish();
    }

}
