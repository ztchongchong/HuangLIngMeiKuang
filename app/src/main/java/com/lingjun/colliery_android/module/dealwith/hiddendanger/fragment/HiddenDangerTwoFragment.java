package com.lingjun.colliery_android.module.dealwith.hiddendanger.fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lingjun.colliery_android.R;
import com.lingjun.colliery_android.base.BaseFragment;
import com.lingjun.colliery_android.base.BaseLinkList;
import com.lingjun.colliery_android.base.OnGlobalListener;
import com.lingjun.colliery_android.bean.AcceptanceUnitBean;
import com.lingjun.colliery_android.bean.CooperativeSwitchBean;
import com.lingjun.colliery_android.bean.HiddenDangersHandleBean;
import com.lingjun.colliery_android.bean.InputAcceptInfoBean;
import com.lingjun.colliery_android.bean.PersonLiableBean;
import com.lingjun.colliery_android.module.dealwith.hiddendanger.activity.AcceptanceUnitActivity;
import com.lingjun.colliery_android.module.dealwith.hiddendanger.activity.AcceptorActivity;
import com.lingjun.colliery_android.module.dealwith.hiddendanger.activity.CooperationActivity;
import com.lingjun.colliery_android.module.dealwith.hiddendanger.activity.HiddenDangeGradeActivity;
import com.lingjun.colliery_android.module.dealwith.hiddendanger.activity.HiddenDangersHandleActivity;
import com.lingjun.colliery_android.module.dealwith.hiddendanger.activity.PersonLiableActivity;
import com.lingjun.colliery_android.module.dealwith.hiddendanger.activity.ResponsibilityActivity;
import com.lingjun.colliery_android.module.dealwith.hiddendanger.activity.ShiftsNameActivity;
import com.lingjun.colliery_android.module.dealwith.hiddendanger.activity.SuperiorLeaderActivity;
import com.lingjun.colliery_android.module.dealwith.hiddendanger.general_hidden_danger.HiddenDangerNtryActivity;
import com.lingjun.colliery_android.utils.DateUtil;
import com.lingjun.colliery_android.utils.FastJsonTools;
import com.lingjun.colliery_android.utils.RecyclerViewUtils;
import com.lingjun.colliery_android.utils.retrofit.BaseSubscriber;
import com.lingjun.colliery_android.utils.retrofit.ExceptionHandle;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * 限时整改
 */
public class HiddenDangerTwoFragment extends BaseFragment implements View.OnClickListener {
    private RelativeLayout rl_company;//责任单位
    private RelativeLayout rl_grade;//责任等级
    private RelativeLayout rl_auditor;//审核人
    private RelativeLayout rl_cooperation;//协作单位
    private LinearLayout ll_cooperation;//协作单位

    private RelativeLayout rl_name1;//
    private RelativeLayout rl_name2;//
    private RelativeLayout rl_name3;//
    private RelativeLayout rl_name4;//
    private RelativeLayout rl_name5;//
    private RelativeLayout rl_name6;//


    private TextView tv_company;//责任单位
    private TextView tv_grade;//责任等级
    private TextView name1, name2, name3, name4, name5, name6;//参与人员
    private TextView tv_time;//录入时间
    private TextView tv_submission;//提交
    private TextView tv_auditor;//审核人
    private TextView tv_cooperation;//协作单位
    private EditText et_time;//限时
    private EditText et_deduction;//扣分
    private EditText et_fine;//罚金

    private String name;//责任单位
    private String grade;//隐患等级
    private String department_id;//部门ID
    private String processor_id;//处理人ID
    private String leader_id;//部门领导ID
    private String technician_id;//技术人员ID
    private String time;//录入时间
    private String slight;//隐患等级
    private String acceptor;//验收单位
    private String acceptor2;//验收单位
    private String technicianInfo;//技术员
    private String processorInfo;//处理人（整改人）
    private String leaderInfo;//领导
    private String content;
    private String bohui;
    private String bohuitaskId;
    private String sourceDescription;

    private String userId;
    private String userName;
    private String dePartMentName;

    private String cooperativeUnitId;
    private String cooperativeUnitLeaderId;
    private String cooperativeUnitsName;

    private String zrrname;
    private String zrrid;
    private String clauseMeasures;

    private String rectificationPersonnelFlag;
    private ArrayList<String> id = new ArrayList<>();
    private String type;
    private String troubleLevelId;

    private String ysdwid;
    private String ysdwname;
    private String ysrid;
    private String ysrname;


    private String jsyname;
    private String collaborativeUnitsSwitch;//协同单单位开关
    private String technicalSwitch;//技术员开关

    private String responsibleLeaderId;
    private String responsibleLeaderinfo;

    private RelativeLayout rl_classTime;
    private TextView tv_classTime;
    private String classTime;
    ArrayList<String> acceptanceunitid = new ArrayList<>();
    ArrayList<String> acceptanceid = new ArrayList<>();
    ArrayList<String> acceptorname = new ArrayList<>();
    ArrayList<String> acceptanceDepartmentsName = new ArrayList<>();

    //隐患录入传入的数据
    private String planId;//隐患录入计划id
    private String location;//隐患录入位置
    private String areaId;//隐患录入区域id
    private String areaName;//隐患录入区域名称
    private String sourceFolder;//隐患类型id
    private String sourceId;//隐患内容ID
    private String sourceDesc;//隐患内容
    private String clauseId;//检查标准id 默认0
    private String clauseDesc;//检查标准
    private String torubleMeasures;//隐患措施
    private String fileIds;//图片id
    private String addTime;//录入时间
    private String taskStatus;//任务状态（0草稿，1主任务）
    private String sourceMoney;//罚款
    private String sourceScore;//扣分
    private String hiddentype;
    private InputAcceptInfoBean infoBean;

    public static HiddenDangerTwoFragment newInstance(InputAcceptInfoBean cooperativeSwitchBean) {
        //        Bundle args = new Bundle();
//        HiddenDangerOneFragment fragment = new HiddenDangerOneFragment();
//        fragment.setArguments(args);
        HiddenDangerTwoFragment fragment = new HiddenDangerTwoFragment();
        fragment.infoBean = cooperativeSwitchBean;
        return fragment;
    }

    @Override
    protected int setLayout(LayoutInflater inflater) {
        return R.layout.fragment_hiddendangertwo;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        rl_company = mRootView.findViewById(R.id.rl_company);
        rl_grade = mRootView.findViewById(R.id.rl_grade);
        rl_auditor = mRootView.findViewById(R.id.rl_auditor);
        rl_cooperation = mRootView.findViewById(R.id.rl_cooperation);
        ll_cooperation = mRootView.findViewById(R.id.ll_cooperation);

        rl_name1 = mRootView.findViewById(R.id.rl_name1);
        rl_name2 = mRootView.findViewById(R.id.rl_name2);
        rl_name3 = mRootView.findViewById(R.id.rl_name3);
        rl_name4 = mRootView.findViewById(R.id.rl_name4);
        rl_name5 = mRootView.findViewById(R.id.rl_name5);
        rl_name6 = mRootView.findViewById(R.id.rl_name6);

        tv_company = mRootView.findViewById(R.id.tv_company);
        tv_grade = mRootView.findViewById(R.id.tv_grade);
        tv_auditor = mRootView.findViewById(R.id.tv_auditor);
        name1 = mRootView.findViewById(R.id.tv_name1);
        name2 = mRootView.findViewById(R.id.tv_name2);
        name3 = mRootView.findViewById(R.id.tv_name3);
        name4 = mRootView.findViewById(R.id.tv_name4);
        name5 = mRootView.findViewById(R.id.tv_name5);
        name6 = mRootView.findViewById(R.id.tv_name6);
        tv_time = mRootView.findViewById(R.id.tv_time);
        tv_submission = mRootView.findViewById(R.id.tv_submission);
        tv_cooperation = mRootView.findViewById(R.id.tv_cooperation);
        et_time = mRootView.findViewById(R.id.et_time);
        et_deduction = mRootView.findViewById(R.id.et_deduction);
        et_fine = mRootView.findViewById(R.id.et_fine);
        rl_classTime = mRootView.findViewById(R.id.rl_classTime);
        tv_classTime = mRootView.findViewById(R.id.tv_classTime);

        tv_submission.setOnClickListener(this);
        rl_company.setOnClickListener(this);
        rl_grade.setOnClickListener(this);
        rl_auditor.setOnClickListener(this);
        rl_cooperation.setOnClickListener(this);
        rl_classTime.setOnClickListener(this);
        rl_name1.setOnClickListener(this);
        rl_name2.setOnClickListener(this);
        rl_name3.setOnClickListener(this);
        rl_name4.setOnClickListener(this);
        rl_name5.setOnClickListener(this);
        refreshView();

        Intent getIntent = getActivity().getIntent();
//        acceptor = getIntent.getStringExtra("details_acceptor");//验收单位
//        acceptor2 = getIntent.getStringExtra("details_acceptor_2");//验收单位
//        time = getIntent.getStringExtra("details_time1");//时间
//        content = getIntent.getStringExtra("sourcedescription");//内容
//        sourceDescription = getIntent.getStringExtra("sourceDescription");
//        clauseMeasures = getIntent.getStringExtra("clauseMeasures");

//        if (TextUtils.isEmpty(clauseMeasures)) {
//            et_content.setText("");
//        } else {
//            et_content.setText(clauseMeasures);
//        }
//        if (TextUtils.isEmpty(content)) {
//            tv_content.setText(sourceDescription);
//        } else {
//            tv_content.setText(content);
//        }

//        if (TextUtils.isEmpty(acceptor)) {
//            name4.setText("验收单位:" + acceptor2);//验收单位
//        } else {
//            name4.setText("验收单位:" + acceptor);//验收单位
//        }
        if (infoBean != null) {
            if (infoBean.getData() != null) {
                if (infoBean.getData().getAcceptorInfo() != null) {
                    ysrid = infoBean.getData().getAcceptorInfo().getId() + "";//验收人id
                    ysrname = infoBean.getData().getAcceptorInfo().getName();//验收人name
                    name5.setText(ysrname);
                }
                if (infoBean.getData().getAcceptDepartmentInfo() != null) {
                    ysdwid = infoBean.getData().getAcceptDepartmentInfo().get(0).getId() + "";//验收单位id
                    ysdwname = infoBean.getData().getAcceptDepartmentInfo().get(0).getName();//验收单位name
                    name4.setText(ysdwname);
                }
                if (infoBean.getData().getApproverInfo() != null) {
                    userId = infoBean.getData().getApproverInfo().get(0).getUserId() + "";//审核人id
                    userName = infoBean.getData().getApproverInfo().get(0).getUserName();//审核人name
                    dePartMentName = infoBean.getData().getApproverInfo().get(0).getDePartMentName();
                    tv_auditor.setText(userName + "(" + dePartMentName + ")");
                }
            }
        }


        Bundle bundle = getIntent.getBundleExtra("bundle");
        planId = bundle.getString("planId");//隐患录入计划id
        location = bundle.getString("location");//隐患录入位置
        areaId = bundle.getString("areaId");//隐患录入区域id
        areaName = bundle.getString("areaName");//隐患录入区域名称
        sourceFolder = bundle.getString("sourceFolder");//隐患类型id
        sourceId = bundle.getString("sourceId");//隐患内容ID
        sourceDesc = bundle.getString("sourceDesc");//隐患内容
        clauseId = bundle.getString("clauseId");//检查标准id 默认0
        clauseDesc = bundle.getString("clauseDesc");//检查标准
        torubleMeasures = bundle.getString("torubleMeasures");//隐患措施
        fileIds = bundle.getString("fileIds");//图片id
        addTime = bundle.getString("addTime");//录入时间
        taskStatus = bundle.getString("taskStatus");//任务状态（0草稿，1主任务）
        sourceMoney = bundle.getString("sourceMoney");//罚款
        sourceScore = bundle.getString("sourceScore");//扣分
        hiddentype = bundle.getString("type");//正常 驳回录入判断
        if (hiddentype.equals("2")) {
            bohuitaskId = bundle.getString("bohuitaskId");
        }

        et_deduction.setText(sourceScore);
        et_fine.setText(sourceMoney);

        tv_time.setText(time);
    }

    private void refreshView() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(BaseLinkList.apiurl, BaseLinkList.coal_mine + BaseLinkList.getCollaborativeUnitsSwitch);

        mRetrofit.JsonToColliery(BaseLinkList.Base_Url, hashMap, new BaseSubscriber() {
            @Override
            public void onError(ExceptionHandle.ResponeThrowable e) {
            }

            @Override
            public void onSuccess(JSONObject jsonObject) {
                LogUtils.e("协同单位开关->>" + jsonObject.toString());
                final CooperativeSwitchBean cooperativeSwitchBean = FastJsonTools.getBean(jsonObject.toString(), CooperativeSwitchBean.class);
                if (null != cooperativeSwitchBean.getData()) {
                    collaborativeUnitsSwitch = cooperativeSwitchBean.getData().getCollaborativeUnitsSwitch();
                    technicalSwitch = cooperativeSwitchBean.getData().getTechnicalSwitch();
                    LogUtils.e("协同单位开关Switch==>" + collaborativeUnitsSwitch);
                    if (collaborativeUnitsSwitch.equals("1")) {
                        ll_cooperation.setVisibility(View.VISIBLE);
                    } else {
                        ll_cooperation.setVisibility(View.GONE);
                    }
                }
            }
        });
    }

    //提交
    private void submission() {
        showLoadDialog();
        JSONArray array = new JSONArray();
        JSONObject jsonObject = new JSONObject();

        HashMap<String, String> hashMap = new HashMap<>();

        try {
            jsonObject.put("sourceprocessorId", "0");//隐患处理人id
            jsonObject.put("sourceFolder", sourceFolder);//隐患目录ID
            jsonObject.put("sourceId", sourceId);//隐患内容ID
            jsonObject.put("sourceDesc", sourceDesc);//隐患内容
            jsonObject.put("troubleContent", "");//现场描述  删除了给个空字符
            jsonObject.put("sourceMoney", "" + sourceMoney);//罚款
            jsonObject.put("sourceScore", "" + sourceScore);//罚款
            jsonObject.put("fileIds", "" + fileIds);//照片
        } catch (Exception e) {

        }
        array.put(jsonObject);
        hashMap.put("location", "" + location);//隐患位置
        hashMap.put("taskStatus", "1");//任务状态（0草稿，1主任务）
        hashMap.put("planId", "" + planId);//隐患计划
        hashMap.put("areaId", "" + areaId);//区域ID
        hashMap.put("areaName", "" + areaName);//区域名
        hashMap.put("clauseId", "0");//条款ID
        hashMap.put("clauseDesc", clauseDesc);//隐患标准
        hashMap.put("addTime", addTime);//录入时间
        hashMap.put("torubleMeasures", torubleMeasures);//隐患措施
        hashMap.put("childTask", array.toString());//

        hashMap.put("troubleLevel", "" + grade);//隐患等级number
        hashMap.put("troubleLevelId", troubleLevelId + "");//隐患等级名称
        if (slight.equals("true")) {
            hashMap.put("troubleLevelslight", "1");//隐患等级slight
        } else {
            hashMap.put("troubleLevelslight", "0");//隐患等级slight
        }
        hashMap.put("solutionType", "0");//方案  默认是0  整改方案
        hashMap.put("troubleType", "2");//troubleType判断1现场治理，2限时整改,3挂牌督办,4隐患升级
        hashMap.put("limitTime", et_time.getText().toString().trim());//限时时间(手动输入的)
        hashMap.put("troubleDepartmentId", "" + department_id);//部门ID
        hashMap.put("responsibleScore", "" + et_deduction.getText().toString().trim());//扣分
        hashMap.put("responsibleMoney", "" + et_fine.getText().toString().trim());//扣钱

        hashMap.put("processorId", "" + processor_id);//整改人ID
        hashMap.put("leaderId", "" + leader_id);//部门领导ID
        hashMap.put("technicianId", "" + technician_id);//技术人员ID
//        hashMap.put("solutionGoal", "" + et_content.getText().toString().trim());//验收依据(手动输入)
        hashMap.put("approvedId", "" + userId);//审核人ID
        hashMap.put("approvedName", "" + userName);//审核人姓名
        if (!TextUtils.isEmpty(cooperativeUnitId) && !TextUtils.isEmpty(cooperativeUnitLeaderId) && !TextUtils.isEmpty(cooperativeUnitsName)) {
            String xzid = cooperativeUnitId.replace("[", "").replace("]", "");
            hashMap.put("cooperativeUnitId", xzid);//协同单位id
            String xzldid = cooperativeUnitLeaderId.replace("[", "").replace("]", "");
            hashMap.put("cooperativeUnitLeaderId", xzldid);//协同单位领导id
            String xzname = cooperativeUnitsName.replace("[", "").replace("]", "");
            hashMap.put("cooperativeUnitsName", xzname);//协同单位名称
        } else {
            hashMap.put("cooperativeUnitId", "");//协同单位id
            hashMap.put("cooperativeUnitLeaderId", "");//协同单位领导id
            hashMap.put("cooperativeUnitsName", "");//协同单位名称
        }
        hashMap.put("responsibleleaderId", responsibleLeaderId);//责任人id
        hashMap.put("responsibleleaderName", responsibleLeaderinfo);//责任人名字
        hashMap.put("classTime", classTime);//班次名称

        hashMap.put("acceptanceDepartmentsName", ysdwname);//验收单位
        hashMap.put("acceptanceDepartmentsId", ysdwid);//验收部门人员
        hashMap.put("acceptanceName", ysrname);//验收人员名称
        hashMap.put("acceptanceId", ysrid);//验收人员ID

        if (null != time) {
            hashMap.put("sulotionTime", "" + time);//处理方案时间
        } else {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date d1 = new Date(System.currentTimeMillis());
            String t1 = format.format(d1);
            hashMap.put("sulotionTime", "" + t1);//处理方案时间
        }

        if (hiddentype.equals("1")) {
            hashMap.put(BaseLinkList.apiurl, BaseLinkList.coal_mine + BaseLinkList.saveAndSolutionLimitTrouble);
            mRetrofit.JsonToColliery(BaseLinkList.Base_Url, hashMap, new BaseSubscriber() {
                @Override
                public void onError(ExceptionHandle.ResponeThrowable e) {
                    dismissDialog();
                    ToastUtils.showShort("提交失败!");
                }

                @Override
                public void onSuccess(JSONObject jsonObject) throws JSONException {
                    dismissDialog();
                    LogUtils.e("限时整改->>" + jsonObject.toString());
                    if (jsonObject.get("code").equals("200")) {
                        ToastUtils.showShort("提交成功!");
                        getActivity().finish();
                    } else {
                        ToastUtils.showShort(jsonObject.getString("msg"));
                    }
                }
            });
        } else if (hiddentype.equals("2")) {
            hashMap.put("taskId", "" + bohuitaskId);//子任务id
            hashMap.put(BaseLinkList.apiurl, BaseLinkList.coal_mine + BaseLinkList.updateAndSolutionLimitTrouble);
            mRetrofit.JsonToColliery(BaseLinkList.Base_Url, hashMap, new BaseSubscriber() {
                @Override
                public void onError(ExceptionHandle.ResponeThrowable e) {
                    dismissDialog();
                    ToastUtils.showShort("提交失败!");
                }

                @Override
                public void onSuccess(JSONObject jsonObject) throws JSONException {
                    dismissDialog();
                    LogUtils.e("限时整改->>" + jsonObject.toString());
                    if (jsonObject.get("code").equals("200")) {
                        ToastUtils.showShort("提交成功!");
                        getActivity().finish();
                    } else {
                        ToastUtils.showShort(jsonObject.getString("msg"));
                    }
                }
            });
        }


    }

    @Override
    protected BaseRefreshLoadMoreInterface setRefreshLoadMoreListener() {
        return null;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_submission:
                if (TextUtils.isEmpty(grade)) {
                    ToastUtils.showShort("请选择隐患等级");
                    return;
                }
                if (TextUtils.isEmpty(classTime)) {
                    ToastUtils.showShort("请选择班次");
                    return;
                }
                if (TextUtils.isEmpty(et_time.getText().toString().trim())) {
                    ToastUtils.showShort("请输入整改时间");
                    return;
                }
                if (TextUtils.isEmpty(name)) {
                    ToastUtils.showShort("请选择责任单位");
                    return;
                }
                if (processor_id.equals("0")) {
                    ToastUtils.showShort("请选择整改人");
                    return;
                }
                if (technicalSwitch.equals("0")) {
                    if (technician_id.equals("0")) {
                        ToastUtils.showShort("请选择技术员");
                        return;
                    }
                }
                if (TextUtils.isEmpty(ysdwid)) {
                    ToastUtils.showShort("请选择验收单位");
                    return;
                }
                if (TextUtils.isEmpty(ysrid)) {
                    ToastUtils.showShort("请选择验收人");
                    return;
                }
                if (TextUtils.isEmpty(userId)) {
                    ToastUtils.showShort("请选择审核人");
                    return;
                }
                if (TextUtils.isEmpty(et_deduction.getText().toString().trim())) {
                    ToastUtils.showShort("请输入扣分数值");
                    return;
                }
                if (TextUtils.isEmpty(et_fine.getText().toString().trim())) {
                    ToastUtils.showShort("请输入罚金数值");
                    return;
                }
                submission();//提交

                break;
            case R.id.rl_company://责任单位
                startActivityForResult(new Intent(getActivity(), ResponsibilityActivity.class), ResponsibilityActivity.RectifyingCode);
                break;
            case R.id.rl_grade://隐患等级
                startActivityForResult(new Intent(getActivity(), HiddenDangeGradeActivity.class), HiddenDangeGradeActivity.RectifyingCode);
                break;
            case R.id.rl_auditor://审核人
                startActivityForResult(new Intent(getActivity(), com.lingjun.colliery_android.module.dealwith.hiddendanger.activity.SelectReviewerActivity.class), com.lingjun.colliery_android.module.dealwith.hiddendanger.activity.SelectReviewerActivity.HiddenDangerCode);
                break;
            case R.id.rl_cooperation://协作单位
                if (TextUtils.isEmpty(department_id)) {
                    Toast.makeText(getActivity(), "请先选择责任单位", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(getActivity(), CooperationActivity.class);
                    intent.putExtra("department_id", department_id);
                    startActivityForResult(intent, CooperationActivity.RectifyingCode);
                }
                break;
            case R.id.rl_classTime://班次名称
                startActivityForResult(new Intent(getActivity(), ShiftsNameActivity.class), ShiftsNameActivity.HiddenDangerCode);
                break;
            case R.id.rl_name1://上级领导
                if (TextUtils.isEmpty(department_id)) {
                    Toast.makeText(getActivity(), "请先选择责任单位", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    Intent intent = new Intent(getActivity(), SuperiorLeaderActivity.class);
                    intent.putExtra("department_id", department_id);
                    startActivityForResult(intent, SuperiorLeaderActivity.RectifyingCode);
                }
                break;
            case R.id.rl_name2://技术员
                if (TextUtils.isEmpty(department_id)) {
                    Toast.makeText(getActivity(), "请先选择责任单位", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    Intent intent = new Intent(getActivity(), PersonLiableActivity.class);
                    intent.putExtra("personLiable", "1");
                    intent.putExtra("department_id", department_id);
                    startActivityForResult(intent, PersonLiableActivity.RectifyingCode);
                }
                break;
            case R.id.rl_name3://整改人
                if (TextUtils.isEmpty(department_id)) {
                    Toast.makeText(getActivity(), "请先选择责任单位", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    Intent intent = new Intent(getActivity(), PersonLiableActivity.class);
                    intent.putExtra("personLiable", "2");
                    intent.putExtra("rectificationPersonnelFlag", rectificationPersonnelFlag);
                    intent.putExtra("department_id", department_id);
                    intent.putExtra("single", 2);
                    startActivityForResult(intent, PersonLiableActivity.RectifyingCode);
                }
                break;
            case R.id.rl_name4://验收单位
                startActivityForResult(new Intent(getActivity(), AcceptanceUnitActivity.class), AcceptanceUnitActivity.HiddenDangerCode);
                break;
            case R.id.rl_name5://验收人
//                if (acceptanceunitid == null || acceptanceunitid.size() == 0) {
//                    Toast.makeText(getActivity(), "请先选择验收单位", Toast.LENGTH_SHORT).show();
//                } else {
//                    Intent intent = new Intent(getActivity(), AcceptorActivity.class);
//                    intent.putExtra("acceptanceunitid", acceptanceunitid + "");
//                    startActivityForResult(intent, AcceptorActivity.HiddenDangerCode);
//                }
                    Intent intent = new Intent(getActivity(), AcceptorActivity.class);
                    intent.putExtra("acceptanceunitid", ysdwid + "");
                    startActivityForResult(intent, AcceptorActivity.HiddenDangerCode);
                break;
            default:
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (resultCode) {
            case ResponsibilityActivity.RectifyingCode:
                //带回数据
                if (data != null) {
                    technician_id = data.getStringExtra("technician_id");//技术人员ID
                    technicianInfo = data.getStringExtra("technicianInfo");//技术人员
                    department_id = data.getStringExtra("department_id");//部门ID
                    processor_id = data.getStringExtra("processor_id");//整改人ID
                    Log.e("整改人id", processor_id);
                    processorInfo = data.getStringExtra("processorInfo");//处理人
                    Log.e("整改人name", processorInfo);
                    leader_id = data.getStringExtra("leader_id");//部门领导ID
                    leaderInfo = data.getStringExtra("leaderInfo");//部门领导
                    name = data.getStringExtra("name");//责任单位
                    rectificationPersonnelFlag = data.getStringExtra("rectificationPersonnelFlag");//整改人单选多选
                    responsibleLeaderId = data.getStringExtra("ResponsibleLeaderId");
                    responsibleLeaderinfo = data.getStringExtra("ResponsibleLeaderinfo");
                    tv_company.setText(name);
                    if (TextUtils.isEmpty(technicianInfo)) {
                        name2.setText("无技术员");
                    } else {
                        name2.setText(technicianInfo);
                    }
                    name1.setText(leaderInfo);//领导
                    name3.setText(processorInfo);//整改人
                    name6.setText(responsibleLeaderinfo);
                }
                break;
            case HiddenDangeGradeActivity.RectifyingCode:
                //带回数据
                if (data != null) {
                    grade = data.getStringExtra("name");
                    slight = data.getStringExtra("slight");
                    troubleLevelId = data.getStringExtra("troubleLevelId");
                    tv_grade.setText(grade);
                }
                break;
            case com.lingjun.colliery_android.module.dealwith.hiddendanger.activity.SelectReviewerActivity.HiddenDangerCode:
                userId = data.getStringExtra("userId");
                userName = data.getStringExtra("userName");
                dePartMentName = data.getStringExtra("dePartMentName");
                tv_auditor.setText(userName + "(" + dePartMentName + ")");
                break;
            case CooperationActivity.RectifyingCode:
                if (data != null) {
                    cooperativeUnitId = data.getStringExtra("cooperativeUnitId");
                    cooperativeUnitLeaderId = data.getStringExtra("cooperativeUnitLeaderId");
                    cooperativeUnitsName = data.getStringExtra("cooperativeUnitsName");
                    String name = cooperativeUnitsName.replace("[", "").replace("]", "");
                    tv_cooperation.setText(name);
                }
                break;
            case PersonLiableActivity.RectifyingCode:
                if (data != null) {
                    type = data.getStringExtra("type");
                    if (type.equals("0")) {
                        processor_id = data.getStringExtra("zrrid");
                        zrrname = data.getStringExtra("zrrname");
                        name3.setText(zrrname);
                    } else if (type.equals("1")) {
                        Bundle bundle = data.getBundleExtra("bundle");
                        PersonLiableActivity.TestBean testBean = (PersonLiableActivity.TestBean) bundle.getSerializable("zrr");
                        ArrayList<PersonLiableBean.DataBean.PageBean.ResultsBean> resultsBeans = testBean.arrayList;
                        ArrayList<String> name = new ArrayList<>();
                        if (id.size() > 0 && id != null) {
                            id.clear();
                            name.clear();
                        }
                        for (int i = 0; i < resultsBeans.size(); i++) {
                            name.add(resultsBeans.get(i).getName());
                            id.add(resultsBeans.get(i).getUserid() + "");
                            String zerenren = String.valueOf(name).replace("[", "").replace("]", "").replace(" ", "");
                            name3.setText(zerenren);
                            processor_id = String.valueOf(id).replace("[", "").replace("]", "").replace(" ", "");
                        }
                    } else if (type.equals("2")) {
                        technician_id = data.getStringExtra("jsyid");
                        jsyname = data.getStringExtra("jsyname");
                        name2.setText(jsyname);
                    }

                }
                break;
            case AcceptanceUnitActivity.HiddenDangerCode:
                //带回数据
                if (data != null) {
                    Bundle bundle = data.getBundleExtra("bundle");
                    AcceptanceUnitActivity.TestBean testBean = (AcceptanceUnitActivity.TestBean) bundle.getSerializable("acceptanceunit");
                    ArrayList<AcceptanceUnitBean.DataBean.ResultMapBean> resultsBeans = testBean.arrayList;
                    if (acceptanceunitid.size() > 0 && acceptanceunitid != null) {
                        acceptanceunitid.clear();
                        acceptanceDepartmentsName.clear();
                    }
                    for (int i = 0; i < resultsBeans.size(); i++) {
                        acceptanceDepartmentsName.add(resultsBeans.get(i).getName());
                        acceptanceunitid.add(resultsBeans.get(i).getId() + "");

                        ysdwname = String.valueOf(acceptanceDepartmentsName).replace("[", "").replace("]", "").replace(" ", "");
                        ysdwid = String.valueOf(acceptanceunitid).replace("[", "").replace("]", "").replace(" ", "");
                        name4.setText(ysdwname);
                        ysrid = "";
                        ysrname = "";
                        name5.setText("请选择");
                    }
                }
                break;
            case AcceptorActivity.HiddenDangerCode:
                //带回数据
                if (data != null) {
                    Bundle bundle = data.getBundleExtra("bundle");
                    AcceptorActivity.TestBean testBean = (AcceptorActivity.TestBean) bundle.getSerializable("acceptance");
                    ArrayList<PersonLiableBean.DataBean.PageBean.ResultsBean> resultsBeans = testBean.arrayList;
                    if (acceptanceid.size() > 0 && acceptanceid != null) {
                        acceptanceid.clear();
                        acceptorname.clear();
                    }
                    for (int i = 0; i < resultsBeans.size(); i++) {
                        acceptorname.add(resultsBeans.get(i).getName());
                        acceptanceid.add(resultsBeans.get(i).getUserid() + "");
                        ysrid = String.valueOf(acceptanceid).replace("[", "").replace("]", "").replace(" ", "");
                        ysrname = String.valueOf(acceptorname).replace("[", "").replace("]", "").replace(" ", "");
                        name5.setText(ysrname);
                    }
                }
                break;
            case SuperiorLeaderActivity.RectifyingCode://上级领导
                //带回数据
                if (data != null) {
                    leader_id = data.getStringExtra("superiorleaderid");
                    leaderInfo = data.getStringExtra("superiorleadername");
                    name1.setText(leaderInfo);
                }
                break;
            case ShiftsNameActivity.HiddenDangerCode:
                classTime = data.getStringExtra("classTime");
                tv_classTime.setText(classTime + "点");
                break;
            default:
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
