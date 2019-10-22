package com.lingjun.colliery_android.module.message;


import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.widget.TextView;

import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.lingjun.colliery_android.R;
import com.lingjun.colliery_android.base.BaseFragment;
import com.lingjun.colliery_android.base.BaseLinkList;
import com.lingjun.colliery_android.bean.HiddenDangerDetailsBean;
import com.lingjun.colliery_android.bean.HiddenDangerPlanBean;
import com.lingjun.colliery_android.bean.NotificationContentBean;
import com.lingjun.colliery_android.utils.FastJsonTools;
import com.lingjun.colliery_android.utils.retrofit.BaseSubscriber;
import com.lingjun.colliery_android.utils.retrofit.ExceptionHandle;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

/**
 * 作者: 黄泉买骨人(zengtao)
 * 时间: 2018/11/24  14:38.
 * 注释: 通知内容
 */
public class NotificationContentFragment extends BaseFragment {
    private TextView tv_zerenren;//责任人
    private TextView tv_department;//部门
    private TextView tv_content;//内容
    private TextView tv_bianhao;//编号
    private TextView tv_chuliren;//处理人

    private String id;
    private String message_type;

    @Override
    protected int setLayout(LayoutInflater inflater) {
        return R.layout.fragment_notification_content;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        tv_zerenren = mRootView.findViewById(R.id.tv_zerenren);
        tv_department = mRootView.findViewById(R.id.tv_department);
        tv_content = mRootView.findViewById(R.id.tv_content);
        tv_bianhao = mRootView.findViewById(R.id.tv_bianhao);
        tv_chuliren = mRootView.findViewById(R.id.tv_chuliren);
        Intent getIntent = getActivity().getIntent();
        id = getIntent.getStringExtra("task_id");
        message_type = getIntent.getStringExtra("message_type");
        if (message_type.equals("6") || message_type.equals("7")) {
            refreshview();//隐患
        } else {
            Refreshview();//三违
        }

        if (message_type.equals("6") || message_type.equals("7")) {
            tv_content.setText("整改已超时，请领导关注执行");
        } else if (message_type.equals("3")) {
            tv_content.setText("未按规定时间进行销号，请领导进行关注处理");
        } else if (message_type.equals("4")) {
            tv_content.setText("不安全行为记录已销号");

        }
    }

    private void refreshview() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("id", "" + id);
        hashMap.put(BaseLinkList.apiurl, BaseLinkList.coal_mine + BaseLinkList.troubleinfo);
        mRetrofit.JsonToColliery(BaseLinkList.Base_Url, hashMap, new BaseSubscriber() {
            @Override
            public void onError(ExceptionHandle.ResponeThrowable e) {
                ToastUtils.showShort("提交失败!");
            }

            @Override
            public void onSuccess(JSONObject jsonObject) {
                LogUtils.e("隐患通知内容->>" + jsonObject.toString());

                final HiddenDangerDetailsBean hiddenDangerDetailsBean = FastJsonTools.getBean(jsonObject.toString(), HiddenDangerDetailsBean.class);
                if (hiddenDangerDetailsBean.getData() != null) {
                    if (null != hiddenDangerDetailsBean.getData().getSubTaskList()) {
                        tv_zerenren.setText("员工:" + hiddenDangerDetailsBean.getData().getSubTaskList().getResponsibleUserName());//责任人
//                        tv_content.setText(hiddenDangerDetailsBean.getData().getSubTaskList().getTroubleContent());//内容)
                        tv_bianhao.setText("整改通知书编号：" + hiddenDangerDetailsBean.getData().getSubTaskList().getCorrectNoticeNo());//编号
                        tv_chuliren.setText("处理人： " + hiddenDangerDetailsBean.getData().getSubTaskList().getResponsibleUserName());
                        tv_department.setText("( " + hiddenDangerDetailsBean.getData().getSubTaskList().getResponsibleDepartmentName() + " )");//责任人单位
                    }
                }
            }
        });
    }

    private void Refreshview() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("id", "" + id);
        hashMap.put(BaseLinkList.apiurl, BaseLinkList.coal_mine + BaseLinkList.rectify);
        mRetrofit.JsonToColliery(BaseLinkList.Base_Url, hashMap, new BaseSubscriber() {
            @Override
            public void onError(ExceptionHandle.ResponeThrowable e) {
                ToastUtils.showShort("提交失败!");
            }

            @Override
            public void onSuccess(JSONObject jsonObject) {

                LogUtils.e("三违通知内容->>" + jsonObject.toString());

                final NotificationContentBean notificationContentBean = FastJsonTools.getBean(jsonObject.toString(), NotificationContentBean.class);
                if (null != notificationContentBean.getData()) {
                    if (null != notificationContentBean.getData().getDisobeytask()) {
                        tv_zerenren.setText("员工  " + notificationContentBean.getData().getDisobeytask().getResponsibleLeaderName() + "  ");//责任人
                        tv_content.setText(notificationContentBean.getData().getDisobeytask().getBehavior());//内容)
                        tv_bianhao.setText("三违编号:" + notificationContentBean.getData().getDisobeytask().getNumber());//编号
                        tv_chuliren.setText("处理人: " + notificationContentBean.getData().getDisobeytask().getResponsibleUserName());
                        tv_department.setText("( " + notificationContentBean.getData().getDisobeytask().getResponsibleDepartmentName() + " )");//责任人单位
                    }
                }
            }
        });
    }

    @Override
    protected BaseRefreshLoadMoreInterface setRefreshLoadMoreListener() {
        return null;
    }
}
