package com.lingjun.colliery_android.module.main.rectifyingviolations.fragment;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
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
import java.util.Hashtable;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * @author: ztcc
 * @Data： 2019/9/4 18:35
 * Describe:良好行为考核
 */
public class ThreeAssessmentFragment extends BaseFragment {


    @BindView(R.id.tv_administrators)
    TextView tvAdministrators;
    @BindView(R.id.tv_workers)
    TextView tvWorkers;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_time)
    TextView tvTime;
    @BindView(R.id.tv_team)
    TextView tvTeam;
    @BindView(R.id.tv_examinee)
    TextView tvExaminee;
    @BindView(R.id.tv_examiner)
    TextView tvExaminer;
    @BindView(R.id.tv_tendays)
    TextView tvTendays;
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
    @BindView(R.id.et_question9)
    EditText etQuestion9;
    @BindView(R.id.tv_submission)
    TextView tvSubmission;
    @BindView(R.id.ll_1)
    LinearLayout ll1;
    @BindView(R.id.ll_2)
    LinearLayout ll2;
    @BindView(R.id.ll_3)
    LinearLayout ll3;
    @BindView(R.id.ll_4)
    LinearLayout ll4;
    @BindView(R.id.v_2)
    View v2;
    @BindView(R.id.v_4)
    View v4;

    private int istate = 0;
    private UserBeans.UserBean user;
    private String teamid;
    private String teamname;
    private String examineeid;
    private String examineename;
    private String xun;
    private String time;

    @Override
    protected int setLayout(LayoutInflater inflater) {
        return R.layout.fragment_threeassessment;
    }

    @SuppressLint("ResourceAsColor")
    @Override
    protected void init(Bundle savedInstanceState) {
        tvAdministrators.setTextColor(Color.BLUE);
        istate = 0;
        user = UserBeans.getInstance().getUser();
        if (user != null) {
            tvExaminer.setText(user.getName());
        }

    }

    @Override
    protected BaseRefreshLoadMoreInterface setRefreshLoadMoreListener() {
        return null;
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
                case TenDaysActivity.Code:
                    xun = data.getStringExtra("xun");
                    if (xun.equals("1")) {
                        tvTendays.setText("上旬");
                    } else if (xun.equals("2")) {
                        tvTendays.setText("中旬");
                    } else {
                        tvTendays.setText("下旬");
                    }
                    break;
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    @SuppressLint("ResourceAsColor")
    @OnClick({R.id.tv_administrators, R.id.tv_workers, R.id.tv_time, R.id.tv_team, R.id.tv_examinee, R.id.tv_tendays, R.id.tv_submission})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_administrators:
                istate = 0;
                tvAdministrators.setTextColor(Color.BLUE);
                tvWorkers.setTextColor(Color.BLACK);
                ll1.setVisibility(View.VISIBLE);
                ll2.setVisibility(View.VISIBLE);
                v2.setVisibility(View.VISIBLE);
                ll3.setVisibility(View.GONE);
                ll4.setVisibility(View.GONE);
                v4.setVisibility(View.GONE);
                etQuestion3.setText("");
                etQuestion4.setText("");
                tvTitle.setText("“管理干部”考核打分表");
                break;
            case R.id.tv_workers:
                istate = 1;
                tvAdministrators.setTextColor(Color.BLACK);
                tvWorkers.setTextColor(Color.BLUE);
                ll1.setVisibility(View.GONE);
                ll2.setVisibility(View.GONE);
                v2.setVisibility(View.GONE);
                ll3.setVisibility(View.VISIBLE);
                ll4.setVisibility(View.VISIBLE);
                v4.setVisibility(View.VISIBLE);
                etQuestion1.setText("");
                etQuestion2.setText("");
                tvTitle.setText("“员工”考核打分表");
                break;
            //时间
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
            //班组
            case R.id.tv_team:
                Intent intent = new Intent(getActivity(), TeamActivity.class);
                startActivityForResult(intent, TeamActivity.Code);
                teamid = null;
                break;
            //被审核人
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
            //旬
            case R.id.tv_tendays:
                startActivityForResult(new Intent(getActivity(), TenDaysActivity.class), TenDaysActivity.Code);
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
                if (TextUtils.isEmpty(xun)) {
                    ToastUtils.showLong("请选择旬");
                    return;
                }
                if (istate == 0) {
                    if (TextUtils.isEmpty(etQuestion1.getText().toString().trim())) {
                        ToastUtils.showLong("请给工作验收打分");
                        return;
                    }
                    if (TextUtils.isEmpty(etQuestion2.getText().toString().trim())) {
                        ToastUtils.showLong("请给干部危险预知打分");
                        return;
                    }
                } else {
                    if (TextUtils.isEmpty(etQuestion3.getText().toString().trim())) {
                        ToastUtils.showLong("请给干排队上下班打分");
                        return;
                    }
                    if (TextUtils.isEmpty(etQuestion4.getText().toString().trim())) {
                        ToastUtils.showLong("请给统一着装打分");
                        return;
                    }
                }
                if (TextUtils.isEmpty(etQuestion5.getText().toString().trim())) {
                    ToastUtils.showLong("请给安全确认打分");
                    return;
                }
                if (TextUtils.isEmpty(etQuestion6.getText().toString().trim())) {
                    ToastUtils.showLong("请给班前礼仪打分");
                    return;
                }
                if (TextUtils.isEmpty(etQuestion7.getText().toString().trim())) {
                    ToastUtils.showLong("请给准军事化管理打分");
                    return;
                }
                if (TextUtils.isEmpty(etQuestion8.getText().toString().trim())) {
                    ToastUtils.showLong("请填写奖励");
                    return;
                }
                if (TextUtils.isEmpty(etQuestion9.getText().toString().trim())) {
                    ToastUtils.showLong("请填写处罚");
                    return;
                }
                Submission();
                break;
        }
    }

    private void Submission() {
        HashMap<String, String> hashMap = new HashMap<>();
        //考核时间
        hashMap.put("inspectionTime", time);
        //部门id  name
        hashMap.put("departmentId", teamid);
        hashMap.put("departmentName", teamname);
        //被考核人id  name
        hashMap.put("userId", examineeid);
        hashMap.put("userName", examineename);
        //考核人id  name
        hashMap.put("inspectionUserId", user.getId() + "");
        hashMap.put("inspectionUserName", user.getName() + "");
        //旬 上中 下
        hashMap.put("timeType", xun);
        if (istate == 0) {
            //干部  1
            hashMap.put("isAdmin", "1");
            //验收确认列表化
            hashMap.put("acceptanceConfirmation", etQuestion1.getText().toString().trim());
            //干部预知危险表格
            hashMap.put("forecastFormalized", etQuestion2.getText().toString().trim());
        } else {
            // 员工  0
            hashMap.put("isAdmin", "0");
            //排队上下班
            hashMap.put("lineup", etQuestion3.getText().toString().trim());
            //统一着装
            hashMap.put("dress", etQuestion4.getText().toString().trim());
        }
        //安全确认
        hashMap.put("safetyConfirmation", etQuestion5.getText().toString().trim());
        //班前礼仪
        hashMap.put("etiquette", etQuestion6.getText().toString().trim());
        //准军事化管理
        hashMap.put("management", etQuestion7.getText().toString().trim());
        //奖励
        hashMap.put("reward", etQuestion8.getText().toString().trim());
        //处罚
        hashMap.put("punishment", etQuestion9.getText().toString().trim());

        hashMap.put(BaseLinkList.apiurl, BaseLinkList.coal_mine + BaseLinkList.inspectionbehavior);

        mRetrofit.get(BaseLinkList.Base_Url, hashMap, new BaseSubscriber() {
            @Override
            public void onError(ExceptionHandle.ResponeThrowable e) {
                ToastUtils.showShort("提交失败!");
            }

            @Override
            public void onSuccess(JSONObject jsonObject) throws JSONException {
                LogUtils.e("" + jsonObject.toString());
                if (jsonObject.getInt("code") == 200) {
                    ToastUtils.showShort("提交成功!");
//                    getActivity().finish();
                } else {
                    ToastUtils.showShort(jsonObject.getString("msg"));
                }
            }
        });
    }
}
