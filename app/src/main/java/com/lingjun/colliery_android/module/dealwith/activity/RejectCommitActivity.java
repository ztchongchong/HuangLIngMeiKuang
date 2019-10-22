package com.lingjun.colliery_android.module.dealwith.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.StringUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.lingjun.colliery_android.R;
import com.lingjun.colliery_android.base.BaseActivity;
import com.lingjun.colliery_android.base.BaseLinkList;
import com.lingjun.colliery_android.bean.DealWithBean;
import com.lingjun.colliery_android.bean.HiddenDangerDetailsBean;
import com.lingjun.colliery_android.bean.Result;
import com.lingjun.colliery_android.eventbus.MsgEvent;
import com.lingjun.colliery_android.module.dealwith.fragment.FieldSituationFragment;
import com.lingjun.colliery_android.module.dealwith.fragment.PrePlanMeasuresFragment;
import com.lingjun.colliery_android.module.dealwith.fragment.ResponsibilityContentFragment;
import com.lingjun.colliery_android.module.dealwith.fragment.SchemeDescriptionFragment;
import com.lingjun.colliery_android.utils.FastJsonTools;
import com.lingjun.colliery_android.utils.retrofit.BaseSubscriber;
import com.lingjun.colliery_android.utils.retrofit.ExceptionHandle;

import org.greenrobot.eventbus.EventBus;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 作者: lihuan
 * 时间: 2018/11/22 19:43
 * 说明: 驳回操作
 */
public class RejectCommitActivity extends BaseActivity {

    @BindView(R.id.tv_back)
    ImageView tvBack;
    @BindView(R.id.et_rectification_opinion)
    EditText etOpinion;
    @BindView(R.id.btn_commit)
    Button btnCommit;

    private String taskId = "";

    @Override
    protected int getResourcesId() {
        return R.layout.activity_reject_commit;
    }

    @Override
    protected BaseRefreshLoadMoreInterface setRefreshLoadMoreListener() {
        return null;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        taskId = getIntent().getStringExtra("taskId");
    }

    @OnClick(R.id.tv_back)
    public void onTvBackClicked() {
        finish();
    }

    @OnClick(R.id.btn_commit)
    public void onBtnCommitClicked() {
        String reason = etOpinion.getText().toString().trim();
        if (StringUtils.isEmpty(reason)) {
            ToastUtils.showShort("请输入驳回意见");
            return;
        }

        showLoadDialog();
        getTODOCurrRefuseButton(taskId, reason);
    }

    /**
     * 待办，待审核,待确认,隐患升级驳回
     */
    private void getTODOCurrRefuseButton(String taskId, String reason) {
        HashMap<String, String> hashMap = new HashMap<>();

        hashMap.put("taskId", taskId);
        hashMap.put("refuseReason", reason);
        hashMap.put(BaseLinkList.apiurl, BaseLinkList.coal_mine + BaseLinkList.getTODOCurrRefuseButton);
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
                LogUtils.e("驳回->>" + jsonObject.toString());
                Result result = FastJsonTools.getBean(jsonObject.toString(), Result.class);
                ToastUtils.showShort(result.getMsg());
                if ("200".equals(result.getCode())) {
                    EventBus.getDefault().post(new MsgEvent.RejectCommitSuccess());
                    finish();
                }
                dismissDialog();
            }
        });
    }
}
