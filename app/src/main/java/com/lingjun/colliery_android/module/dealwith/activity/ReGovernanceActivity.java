package com.lingjun.colliery_android.module.dealwith.activity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

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

import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ReGovernanceActivity extends BaseActivity {

    @BindView(R.id.tv_back)
    ImageView tvBack;
    @BindView(R.id.et_rectification_opinion)
    EditText etRectificationOpinion;
    @BindView(R.id.btn_commit)
    Button btnCommit;

    private String taskId = "";

    @Override
    protected int getResourcesId() {
        return R.layout.activity_re_governance;
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
        String reason = etRectificationOpinion.getText().toString().trim();
        if (StringUtils.isEmpty(reason)) {
            ToastUtils.showShort("请输入重新治理理由");
            return;
        }
        updateTroubleGPButton(taskId, reason);
    }

    /**
     * 督办-->重新治理
     */
    private void updateTroubleGPButton(String taskId, String reason) {
        HashMap<String, String> hashMap = new HashMap<>();

        hashMap.put("taskId", taskId);
        hashMap.put("reDoTroubleGP", reason);
        hashMap.put(BaseLinkList.apiurl, BaseLinkList.coal_mine + BaseLinkList.updateTroubleGPButton);
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
