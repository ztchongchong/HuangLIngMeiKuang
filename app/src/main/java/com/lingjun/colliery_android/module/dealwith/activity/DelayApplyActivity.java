package com.lingjun.colliery_android.module.dealwith.activity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.StringUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.lingjun.colliery_android.R;
import com.lingjun.colliery_android.base.BaseActivity;
import com.lingjun.colliery_android.base.BaseLinkList;
import com.lingjun.colliery_android.bean.Result;
import com.lingjun.colliery_android.eventbus.MsgEvent;
import com.lingjun.colliery_android.utils.FastJsonTools;
import com.lingjun.colliery_android.utils.retrofit.BaseSubscriber;
import com.lingjun.colliery_android.utils.retrofit.ExceptionHandle;

import org.greenrobot.eventbus.EventBus;
import org.json.JSONObject;

import java.util.Calendar;
import java.util.HashMap;

import butterknife.BindView;
import butterknife.OnClick;

public class DelayApplyActivity extends BaseActivity {

    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_recovery_time)
    TextView tvRecoveryTime;
    @BindView(R.id.ll_recovery_time)
    LinearLayout llRecoveryTime;
    @BindView(R.id.tv_reasons_delay)
    EditText etReasonsDelay;
    @BindView(R.id.btn_commit)
    Button btnCommit;

    private String time = "";
    private String taskId = "";

    @Override
    protected int getResourcesId() {
        return R.layout.activity_delay_apply;
    }

    @Override
    protected BaseRefreshLoadMoreInterface setRefreshLoadMoreListener() {
        return null;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        taskId = getIntent().getStringExtra("taskId");
    }

    @OnClick(R.id.iv_back)
    public void onIvBackClicked() {
        finish();
    }

    @OnClick(R.id.ll_recovery_time)
    public void onLlRecoveryTimeClicked() {
//        new TimePickerDialog( this,
//                // 绑定监听器
//                new TimePickerDialog.OnTimeSetListener() {
//                    @Override
//                    public void onTimeSet(TimePicker view,
//                                          int hourOfDay, int minute) {
//                       ToastUtils.showShort("您选择了：" + hourOfDay + "时" + minute
//                                + "分");
//                    }
//                }
//                // 设置初始时间
//                , Calendar.getInstance().get(Calendar.HOUR_OF_DAY)
//                , Calendar.getInstance().get(Calendar.MINUTE)
//                // true表示采用24小时制
//                ,true).show();

        new DatePickerDialog(this,
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
                        if (c.getTimeInMillis() <= System.currentTimeMillis() + 5000) {
                            ToastUtils.showShort("只能选择今日之后的日期");
                            return;
                        }
                        time = year + "-" + (monthOfYear + 1) + "-" + dayOfMonth;
                        tvRecoveryTime.setText(time);
                    }
                }
                // 设置初始日期
                , Calendar.getInstance().get(Calendar.YEAR)
                , Calendar.getInstance().get(Calendar.MONTH)
                , Calendar.getInstance().get(Calendar.DAY_OF_MONTH)).show();

    }

    @OnClick(R.id.btn_commit)
    public void onBtnCommitClicked() {

        String reason = etReasonsDelay.getText().toString().trim();
//        if (StringUtils.isEmpty(reason)) {
//            ToastUtils.showShort("请选择回复时间");
//            return;
//        }

        if (StringUtils.isEmpty(reason)) {
            ToastUtils.showShort("输入延期理由");
            return;
        }
        if (StringUtils.isEmpty(time)) {
            ToastUtils.showShort("请选择恢复时间");
            return;
        }
        troubledelayWriteProgram(taskId, reason);
    }

    /**
     * 待办-->整改 延期申请
     */
    private void troubledelayWriteProgram(String taskId, String reason) {
        HashMap<String, String> hashMap = new HashMap<>();

        hashMap.put("taskSubId", taskId);
        hashMap.put("delayContent", reason);
        hashMap.put("delaytimestr", time);
        hashMap.put(BaseLinkList.apiurl, BaseLinkList.coal_mine + BaseLinkList.troubledelayWriteProgram);
        mRetrofit.JsonToColliery(BaseLinkList.Base_Url, hashMap, new BaseSubscriber() {
            @Override
            public void onError(ExceptionHandle.ResponeThrowable e) {
                if (null != refreshLayout) {
                    refreshLayout.finishRefresh();
                    refreshLayout.finishLoadMore();
                }
                dismissDialog();
            }

            @Override
            public void onSuccess(JSONObject jsonObject) {
                dismissDialog();
                LogUtils.e("整改 延期申请->>" + jsonObject.toString());
                Result result = FastJsonTools.getBean(jsonObject.toString(), Result.class);
                ToastUtils.showShort(result.getMsg());
                if ("200".equals(result.getCode())) {
                    EventBus.getDefault().post(new MsgEvent.RejectCommitSuccess());
                    finish();
                }
            }
        });
    }
}
