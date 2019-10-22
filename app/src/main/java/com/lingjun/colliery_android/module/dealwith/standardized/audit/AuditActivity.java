package com.lingjun.colliery_android.module.dealwith.standardized.audit;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.lingjun.colliery_android.R;
import com.lingjun.colliery_android.base.BaseActivity;
import com.lingjun.colliery_android.base.BaseLinkList;
import com.lingjun.colliery_android.bean.PendTaskBean;
import com.lingjun.colliery_android.bean.ResultBean;
import com.lingjun.colliery_android.module.dealwith.activity.InviteLeadActivity;
import com.lingjun.colliery_android.module.dealwith.activity.AllTaskActivity;
import com.lingjun.colliery_android.utils.FastJsonTools;
import com.lingjun.colliery_android.utils.ToastUtils;
import com.lingjun.colliery_android.utils.retrofit.BaseSubscriber;
import com.lingjun.colliery_android.utils.retrofit.ExceptionHandle;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

/**
 * 标准化检查待审核
 * Created by nefa on 2018/10/31.
 */

public class AuditActivity extends BaseActivity implements View.OnClickListener {


    private RelativeLayout rl_all_overview;//分配总览
    private RelativeLayout rl_lingdao;//特邀领导
    private RelativeLayout rl_fuzeren;//责任人
    private RelativeLayout rl_peihe;//配合
    private RelativeLayout rl_teyao;//特邀
    private RelativeLayout rl_0fen;//0分
    private RelativeLayout rl_manfen;//满分
    private RelativeLayout rl_zhengchang;//正常
    private Button btn_rejected;
    private Button btn_through;
    private String taskid;

    private TextView task_title;
    private TextView chuangjian;
    private TextView date;
    private TextView qixian;
    private TextView tv_content;
    private TextView lingdao;
    private TextView fuzeren;
    private TextView peihe;
    private TextView teyao;
    private TextView zero_task;
    private TextView all_full_task;
    private TextView zc_task;
    private Intent intent;
    private String remark;
    private String taskids;
    private int zero_num = 0;
    private int full_num = 0;
    private int zc_num = 0;

    @Override
    protected int getResourcesId() {
        return R.layout.activity_audit;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        taskid = getIntent().getStringExtra("taskid");
        Log.d("taskid", taskid);
        rl_all_overview = findViewById(R.id.rl_all_overview);
        rl_lingdao = findViewById(R.id.rl_lingdao);
        rl_fuzeren = findViewById(R.id.rl_fuzeren);
        rl_peihe = findViewById(R.id.rl_peihe);
        rl_teyao = findViewById(R.id.rl_teyao);
        rl_0fen = findViewById(R.id.rl_0fen);
        rl_manfen = findViewById(R.id.rl_manfen);
        rl_zhengchang = findViewById(R.id.rl_zhengchang);
        btn_rejected = findViewById(R.id.btn_rejected);
        btn_through = findViewById(R.id.btn_through);

        task_title = findViewById(R.id.task_title);
        chuangjian = findViewById(R.id.chuangjian);
        date = findViewById(R.id.date);
        qixian = findViewById(R.id.qixian);
        tv_content = findViewById(R.id.tv_content);
        lingdao = findViewById(R.id.lingdao);
        fuzeren = findViewById(R.id.fuzeren);
        peihe = findViewById(R.id.peihe);
        teyao = findViewById(R.id.teyao);
        zero_task = findViewById(R.id.zero_task);
        all_full_task = findViewById(R.id.all_full_task);
        zc_task = findViewById(R.id.zc_task);

        rl_all_overview.setOnClickListener(this);
        rl_lingdao.setOnClickListener(this);
        rl_fuzeren.setOnClickListener(this);
        rl_peihe.setOnClickListener(this);
        rl_teyao.setOnClickListener(this);
        rl_0fen.setOnClickListener(this);
        rl_manfen.setOnClickListener(this);
        rl_zhengchang.setOnClickListener(this);
        btn_rejected.setOnClickListener(this);
        btn_through.setOnClickListener(this);
    }

    @Override
    protected BaseRefreshLoadMoreInterface setRefreshLoadMoreListener() {
        return new BaseRefreshLoadMoreInterface() {
            @Override
            public void onLoadMore() {
                refreshView();
            }

            @Override
            public void onRefresh() {
                refreshView();
            }
        };
    }

    private void refreshView() {
        HashMap<String, String> hashMap = new HashMap<>();
        if (TextUtils.isEmpty(taskid)) {
            return;
        }
        hashMap.put("page", "1");
        hashMap.put("pageSize", "10");
        hashMap.put("taskid", taskid);
        hashMap.put("apiurl", BaseLinkList.coal_mine + BaseLinkList.MOBILE_GETSTADCHK);
        mRetrofit.JsonToColliery(BaseLinkList.Base_Url, hashMap, new BaseSubscriber() {
            @Override
            public void onError(ExceptionHandle.ResponeThrowable e) {
                if (null != refreshLayout) {
                    refreshLayout.finishRefresh();
                    refreshLayout.finishLoadMore();
                }
            }

            @Override
            public void onSuccess(JSONObject jsonObject) throws JSONException {
                Log.e("json", jsonObject.toString());
                PendTaskBean bean = FastJsonTools.getBean(jsonObject.toString(), PendTaskBean.class);
                if (null != bean) {
                    task_title.setText(bean.getData().getTitle());
                    chuangjian.setText(bean.getData().getCreator());
                    String datestr = new SimpleDateFormat("yyyy年MM月dd日").format(new Date(bean.getData().getCreatetime()));
                    date.setText(datestr);
                    String finishdate = new SimpleDateFormat("yyyy年MM月dd日").format(new Date(bean.getData().getFinishtime()));
                    qixian.setText("期限:"+finishdate);
                    tv_content.setText(bean.getData().getDescription());
                    lingdao.setText(bean.getData().getLeadercount() + "名");
                    fuzeren.setText(bean.getData().getResponsiblecount() + "名");
                    peihe.setText(bean.getData().getCooperatorcount() + "名");
                    teyao.setText(bean.getData().getInvitedcount());
                    zero_num = bean.getData().getZerocount();
                    zero_task.setText(bean.getData().getZerocount() + "项");
                    full_num = bean.getData().getMancount();
                    all_full_task.setText(bean.getData().getMancount() + "项");
                    zc_num = bean.getData().getItemcount();
                    zc_task.setText(bean.getData().getItemcount() + "项");
//                    taskids = bean.getResultMaps().get(0).getAllitembuff();
                }
                if (null != refreshLayout) {
                    refreshLayout.finishLoadMore();
                    refreshLayout.finishRefresh();
                }
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.rl_all_overview://分配总览
//                startActivity(new Intent(AuditActivity.this, AllTaskActivity.class));
                intent = new Intent();
                intent.setClass(AuditActivity.this, AllTaskActivity.class);
                intent.putExtra("taskid", taskid);
                startActivity(intent);
                break;
            case R.id.rl_lingdao://特邀领导
//                startActivity(new Intent(AuditActivity.this, LeadershipActivity.class));
                intent = new Intent();
                intent.setClass(AuditActivity.this, InviteLeadActivity.class);
                intent.putExtra("taskid", taskid);
                startActivity(intent);
                break;
            case R.id.rl_fuzeren://责任人
//                startActivity(new Intent(AuditActivity.this, ResponsibleActivity.class));
                intent = new Intent();
                intent.setClass(AuditActivity.this, ResponsibleActivity.class);
                intent.putExtra("taskid", taskid);
                startActivity(intent);
                break;
            case R.id.rl_peihe://配合
                intent = new Intent();
                intent.setClass(AuditActivity.this, CooperateWithStaffActivity.class);
                intent.putExtra("taskid", taskid);
                startActivity(intent);
//                startActivity(new Intent(AuditActivity.this, CooperateWithStaffActivity.class));
                break;
            case R.id.rl_teyao://特邀
//                startActivity(new Intent(AuditActivity.this, SpecialPersonnelActivity.class));
                intent = new Intent();
                intent.setClass(AuditActivity.this, SpecialPersonnelActivity.class);
                intent.putExtra("taskid", taskid);
                startActivity(intent);
                break;
            case R.id.rl_0fen://0分任务
                if (zero_num == 0) {
                    ToastUtils.showToast(AuditActivity.this, "暂无0分任务");
                    return;
                }
                intent = new Intent();
                intent.setClass(AuditActivity.this, AZeroTaskActivity.class);
                intent.putExtra("taskid", taskid);
                intent.putExtra("type", "0");
                startActivity(intent);
                break;
            case R.id.rl_manfen://满分任务
                if (full_num == 0) {
                    ToastUtils.showToast(AuditActivity.this, "暂无满分任务");
                    return;
                }
                intent = new Intent();
                intent.setClass(AuditActivity.this, FullMarksTaskActivity.class);
                intent.putExtra("taskid", taskid);
                intent.putExtra("type", "1");
                startActivity(intent);
                break;
            case R.id.rl_zhengchang://正常任务
                if (zc_num == 0) {
                    ToastUtils.showToast(AuditActivity.this, "暂无正常任务");
                    return;
                }
                intent = new Intent();
                intent.setClass(AuditActivity.this, CheckTaskActivity.class);
                intent.putExtra("taskid", taskid);
                intent.putExtra("type", "2");
                startActivity(intent);
                break;
            case R.id.btn_rejected://驳回
                showdeldialog(AuditActivity.this, 0);
//                View dialogView = View.inflate(AuditActivity.this, R.layout.pop_audit, null);
//                final PopupWindow popupWindow = initPop(dialogView);
//                TextView tv_determine = dialogView.findViewById(R.id.tv_determine);
//                TextView tv_cancel = dialogView.findViewById(R.id.tv_cancel);
//                TextView tv_message = dialogView.findViewById(R.id.tv_message);
//                tv_message.setText("是否确认驳回");
//
//                tv_determine.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        startActivity(new Intent(AuditActivity.this, RejectedOpinionActivity.class));
//                        popupWindow.dismiss();
//                    }
//                });
//
//                tv_cancel.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        popupWindow.dismiss();
//                    }
//                });
//
//                popupWindow.setFocusable(true);
//                popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);
//                View dialogView = View.inflate(AuditActivity.this, R.layout.pop_audit, null);
//                final PopupWindow popupWindow = initPop(dialogView);
//                TextView tv_determine = dialogView.findViewById(R.id.tv_determine);
//                TextView tv_cancel = dialogView.findViewById(R.id.tv_cancel);
//                TextView tv_message = dialogView.findViewById(R.id.tv_message);
//                tv_message.setText("是否确认驳回");
//
//                tv_determine.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        startActivity(new Intent(AuditActivity.this, RejectedOpinionActivity.class));
//                        popupWindow.dismiss();
//                    }
//                });
//
//                tv_cancel.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        popupWindow.dismiss();
//                    }
//                });
//
//                popupWindow.setFocusable(true);
//                popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);
                break;
            case R.id.btn_through://通过
                showdeldialog(AuditActivity.this, 1);
//                View dialogView1 = View.inflate(AuditActivity.this, R.layout.pop_audit, null);
//                final PopupWindow popupWindow1 = initPop(dialogView1);
//                TextView tv_determine1 = dialogView1.findViewById(R.id.tv_determine);
//                TextView tv_cancel1 = dialogView1.findViewById(R.id.tv_cancel);
//                TextView tv_message1 = dialogView1.findViewById(R.id.tv_message);
//                tv_message1.setText("是否确认通过");
//                tv_determine1.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        startActivity(new Intent(AuditActivity.this, ThroughOpinionActivity.class));
//                        popupWindow1.dismiss();
//                    }
//                });
//
//                tv_cancel1.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        popupWindow1.dismiss();
//                    }
//                });
//                popupWindow1.setFocusable(true);
//                popupWindow1.showAtLocation(view, Gravity.CENTER, 0, 0);
                break;
//            showdeldialog(AuditActivity.this, 1);
//                View dialogView1 = View.inflate(AuditActivity.this, R.layout.pop_audit, null);
//                final PopupWindow popupWindow1 = initPop(dialogView1);
//                TextView tv_determine1 = dialogView1.findViewById(R.id.tv_determine);
//                TextView tv_cancel1 = dialogView1.findViewById(R.id.tv_cancel);
//                TextView tv_message1 = dialogView1.findViewById(R.id.tv_message);
//                tv_message1.setText("是否确认通过");
//                tv_determine1.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        startActivity(new Intent(AuditActivity.this, ThroughOpinionActivity.class));
//                        popupWindow1.dismiss();
//                    }
//                });
//
//                tv_cancel1.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        popupWindow1.dismiss();
//                    }
//                });
//                popupWindow1.setFocusable(true);
//                popupWindow1.showAtLocation(view, Gravity.CENTER, 0, 0);
//            break;
        }
    }

    private void showdeldialog(Context context, final int type) {
        final Dialog dialog = new Dialog(context, R.style.dialog);//
        dialog.getWindow().setContentView(R.layout.dialog_refuse);
        TextView title = dialog.findViewById(R.id.title);
        final EditText sake_info = dialog.findViewById(R.id.sake_info);
        TextView confirm = dialog.findViewById(R.id.confirm);
        TextView cancel = dialog.findViewById(R.id.cancel);
        if (type == 1) {
            title.setText("通过意见");
            sake_info.setHint("输入通过意见");
        } else {
            title.setText("驳回意见");
            sake_info.setHint("输入驳回意见");
        }
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(sake_info.getText().toString().trim())) {
                    ToastUtils.showToast(AuditActivity.this, "请填写您的意见");
                    return;
                }
                remark = sake_info.getText().toString().trim();
                CommTask(remark, type + "");
                dialog.dismiss();
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    private void CommTask(String remark, String type) {
        HashMap<String, String> hashMap = new HashMap<>();
        if (TextUtils.isEmpty(remark)) {
            ToastUtils.showToast(AuditActivity.this, "请填写您的意见");
            return;
        }
        hashMap.put("taskid", taskid + "");
        hashMap.put("status", type + "");
        hashMap.put("remark", remark);
        hashMap.put("apiurl", BaseLinkList.coal_mine + BaseLinkList.MOBILE_STDCHKCHECK);
        mRetrofit.JsonToColliery(BaseLinkList.Base_Url, hashMap, new BaseSubscriber() {
            @Override
            public void onError(ExceptionHandle.ResponeThrowable e) {

            }

            @Override
            public void onSuccess(JSONObject jsonObject) throws JSONException {
                ResultBean bean = FastJsonTools.getBean(jsonObject.toString(), ResultBean.class);
                if (null != bean) {
                    forceHideIM();
                    ToastUtils.showToast(AuditActivity.this, "成功提交审核结果");
                    finish();
                }
            }
        });
    }
}
