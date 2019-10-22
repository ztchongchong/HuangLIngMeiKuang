package com.lingjun.colliery_android.module.main.rectifyingviolations.fragment;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.lingjun.colliery_android.R;
import com.lingjun.colliery_android.base.BaseFragment;
import com.lingjun.colliery_android.base.BaseLinkList;
import com.lingjun.colliery_android.base.UserBeans;
import com.lingjun.colliery_android.utils.retrofit.BaseSubscriber;
import com.lingjun.colliery_android.utils.retrofit.ExceptionHandle;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Calendar;
import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * @author: ztcc
 * @Data： 2019/9/4 18:34
 * Describe:岗位描述考核
 */
public class OneAssessmentFragment extends BaseFragment {
    @BindView(R.id.et_question1)
    EditText etQuestion1;
    @BindView(R.id.et_question2)
    EditText etQuestion2;
    @BindView(R.id.et_question3)
    EditText etQuestion3;
    @BindView(R.id.et_question4)
    EditText etQuestion4;
    @BindView(R.id.et_question5)
    EditText etQuestion5;
    @BindView(R.id.et_question6)
    EditText etQuestion6;
    @BindView(R.id.et_question7)
    EditText etQuestion7;
    @BindView(R.id.et_question8)
    EditText etQuestion8;
    @BindView(R.id.tv_submission)
    TextView tvSubmission;
    @BindView(R.id.tv_time)
    TextView tvTime;
    @BindView(R.id.tv_team)
    TextView tvTeam;
    @BindView(R.id.tv_examinee)
    TextView tvExaminee;

    private int istate;
    private String time;
    private String teamid;
    private String teamname;
    private String examineeid;
    private String examineename;

    private UserBeans.UserBean user;

    @Override
    protected int setLayout(LayoutInflater inflater) {
        return R.layout.fragment_oneassessment;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        user = UserBeans.getInstance().getUser();
    }

    @Override
    protected BaseRefreshLoadMoreInterface setRefreshLoadMoreListener() {
        return null;
    }


    @OnClick({R.id.tv_submission, R.id.tv_time, R.id.tv_team, R.id.tv_examinee})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_time:
                new DatePickerDialog(getActivity(),
                        // 绑定监听器(How the parent is notified that the date is set.)
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {
                                // 此处得到选择的时间，可以进行你想要的操作
                                Calendar c = Calendar.getInstance();
                                c.set(year, monthOfYear, dayOfMonth);
                                LogUtils.e("sleect ===========>" + c.getTimeInMillis());
                                LogUtils.e("sleect1 ===========>" + System.currentTimeMillis());
                                if (c.getTimeInMillis() >= System.currentTimeMillis() + 5000) {
                                    ToastUtils.showShort("只能选择今日之前的日期");
                                    return;
                                }
//                                time = year + "-" + (monthOfYear + 1) + "-" + dayOfMonth;
                                time = year + "-" + (monthOfYear + 1);
                                tvTime.setText(time);
                            }
                        }
                        // 设置初始日期
                        , Calendar.getInstance().get(Calendar.YEAR)
                        , Calendar.getInstance().get(Calendar.MONTH)
                        , Calendar.getInstance().get(Calendar.DAY_OF_MONTH)).show();
                break;
            case R.id.tv_team:
                Intent intent = new Intent(getActivity(), TeamActivity.class);
                startActivityForResult(intent, TeamActivity.Code);
                teamid = null;
                break;
            case R.id.tv_examinee:
                if (teamid == null && TextUtils.isEmpty(teamid)) {
                    ToastUtils.showLong("请先选择班组");
                } else {
                    Intent intent1 = new Intent(getActivity(), ExamineeActivity.class);
                    if (istate == 0) {
                        intent1.putExtra("isAdmin", "1");
                    } else {
                        intent1.putExtra("isAdmin", "0");
                    }
                    intent1.putExtra("departmentId", teamid);
                    startActivityForResult(intent1, ExamineeActivity.Code);
                }
                break;
            case R.id.tv_submission:
                if (TextUtils.isEmpty(time)) {
                    ToastUtils.showLong("请选择时间");
                    return;
                }
                if (TextUtils.isEmpty(teamid)) {
                    ToastUtils.showLong("请选择班组");
                    return;
                }
                if (TextUtils.isEmpty(examineeid)) {
                    ToastUtils.showLong("请选择被考核人");
                    return;
                }
                if (TextUtils.isEmpty(etQuestion1.getText().toString().trim())) {
                    ToastUtils.showLong("请给基本要求打分");
                    return;
                }
                if (TextUtils.isEmpty(etQuestion2.getText().toString().trim())) {
                    ToastUtils.showLong("请给作业流程打分");
                    return;
                }
                if (TextUtils.isEmpty(etQuestion3.getText().toString().trim())) {
                    ToastUtils.showLong("请给作业标准打分");
                    return;
                }
                if (TextUtils.isEmpty(etQuestion4.getText().toString().trim())) {
                    ToastUtils.showLong("请给岗位风险预知预防打分");
                    return;
                }
                if (TextUtils.isEmpty(etQuestion5.getText().toString().trim())) {
                    ToastUtils.showLong("请给应急处置打分");
                    return;
                }
                if (TextUtils.isEmpty(etQuestion6.getText().toString().trim())) {
                    ToastUtils.showLong("请给典型事故案例打分");
                    return;
                }
                if (TextUtils.isEmpty(etQuestion7.getText().toString().trim())) {
                    ToastUtils.showLong("请合计打分");
                    return;
                }
                Submission();
                break;
        }
    }

    private void Submission() {
        HashMap<String, String> hashMap = new HashMap<>();
        //时间
        hashMap.put("", time);
        //班组 id  name
        hashMap.put("", teamid);
        hashMap.put("", teamname);
        //被审核人 id  name
        hashMap.put("", examineeid);
        hashMap.put("", examineename);
        //审核人
        hashMap.put("", user.getId() + "");
        hashMap.put("", user.getName() + "");
        //本岗位基本要求
        hashMap.put("", etQuestion1.getText().toString().trim());
        //本岗位的基本流程
        hashMap.put("", etQuestion2.getText().toString().trim());
        //作业标准
        hashMap.put("", etQuestion3.getText().toString().trim());
        //岗位风险预知预防
        hashMap.put("", etQuestion4.getText().toString().trim());
        //应急处置
        hashMap.put("", etQuestion5.getText().toString().trim());
        //典型事故案例
        hashMap.put("", etQuestion6.getText().toString().trim());
        //合计
        hashMap.put("", etQuestion7.getText().toString().trim());

        hashMap.put(BaseLinkList.apiurl, BaseLinkList.coal_mine + BaseLinkList.inspectionbehavior);

        mRetrofit.JsonToColliery(BaseLinkList.Base_Url, hashMap, new BaseSubscriber() {
            @Override
            public void onError(ExceptionHandle.ResponeThrowable e) {
                ToastUtils.showShort("提交失败!");
            }

            @Override
            public void onSuccess(JSONObject jsonObject) throws JSONException {

            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (data != null) {
            switch (resultCode) {
                case TeamActivity.Code:
                    teamid = data.getStringExtra("id");
                    teamname = data.getStringExtra("parentname");
                    tvTeam.setText(teamname);
                    break;
                case ExamineeActivity.Code:
                    examineeid = data.getStringExtra("examineeid");
                    examineename = data.getStringExtra("examineename");
                    tvExaminee.setText(examineename);
                    break;
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

}
