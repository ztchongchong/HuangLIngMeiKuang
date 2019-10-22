package com.lingjun.colliery_android.module.document.activity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.TextView;

import com.blankj.utilcode.util.LogUtils;
import com.lingjun.colliery_android.R;
import com.lingjun.colliery_android.base.BaseActivity;
import com.lingjun.colliery_android.base.BaseLinkList;
import com.lingjun.colliery_android.bean.HiddenDangerPositionBean;
import com.lingjun.colliery_android.bean.LoanApplicationBean;
import com.lingjun.colliery_android.utils.FastJsonTools;
import com.lingjun.colliery_android.utils.retrofit.BaseSubscriber;
import com.lingjun.colliery_android.utils.retrofit.ExceptionHandle;

import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 作者: zengtao
 * 时间: 2019/2/28  10:08.
 * 注释:  消息列表（借阅申请）
 */
public class LoanApplicationActivity extends BaseActivity {
    @BindView(R.id.tv_taskstateFlag)
    TextView tvTaskstateFlag;
    @BindView(R.id.tv_content)
    TextView tvContent;
    @BindView(R.id.tv_returnTimee)
    TextView tvReturnTimee;
    @BindView(R.id.tv_name)
    TextView tvName;
    private String task_id;
    private String message_type;

    @Override
    protected int getResourcesId() {
        return R.layout.activity_loanapplication;
    }

    @Override
    protected void init(Bundle savedInstanceState) throws PackageManager.NameNotFoundException {
        Intent intent = getIntent();
        task_id = intent.getStringExtra("task_id");
        message_type = intent.getStringExtra("message_type");
        refreshView();
    }

    private void refreshView() {
        HashMap<String, String> hashMap = new HashMap<>();

        hashMap.put("messageType", message_type);
        hashMap.put("taskId", task_id);

        hashMap.put(BaseLinkList.apiurl, BaseLinkList.coal_mine + BaseLinkList.getBorNoticeDetail);
        mRetrofit.JsonToColliery(BaseLinkList.Base_Url, hashMap, new BaseSubscriber() {
            @Override
            public void onError(ExceptionHandle.ResponeThrowable e) {

            }

            @Override
            public void onSuccess(JSONObject jsonObject) {
                LogUtils.e("借阅->>" + jsonObject.toString());
                final LoanApplicationBean loanApplicationBean = FastJsonTools.getBean(jsonObject.toString(), LoanApplicationBean.class);
                if (loanApplicationBean != null) {
                    if (loanApplicationBean.getResultMaps() != null && loanApplicationBean.getResultMaps().size() != 0) {
                        tvName.setText("处理人:" + loanApplicationBean.getResultMaps().get(0).getApproverUserName());
                        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                        String t = format.format(loanApplicationBean.getResultMaps().get(0).getReturnTime());
                        tvReturnTimee.setText("借阅结束时间: " + t);
                        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                        String t1 = format1.format(loanApplicationBean.getResultMaps().get(0).getEndTime());
                        if (loanApplicationBean.getResultMaps().get(0).getTaskstateFlag().equals("已同意")) {
                            tvTaskstateFlag.setText("借阅申请已经通过");
                            tvContent.setText("您借阅的《" + loanApplicationBean.getResultMaps().get(0).getName() + "》已于" + t1 + "已过审");
                            tvName.setBackgroundResource(R.drawable.jieyue_adopt);
                        } else {
                            tvTaskstateFlag.setText("借阅申请未通过");
                            tvContent.setText("您借阅的《" + loanApplicationBean.getResultMaps().get(0).getName() + "》已于" + t1 + "被拒绝");
                            tvName.setBackgroundResource(R.drawable.jieyue_refuse);
                        }
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
