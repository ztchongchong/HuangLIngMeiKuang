package com.lingjun.colliery_android.module.message;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lingjun.colliery_android.R;
import com.lingjun.colliery_android.base.BaseActivity;
import com.lingjun.colliery_android.base.BaseLinkList;
import com.lingjun.colliery_android.base.OnGlobalListener;
import com.lingjun.colliery_android.bean.HiddenDangerDetailsBean;
import com.lingjun.colliery_android.bean.MainMessageBean;
import com.lingjun.colliery_android.bean.RiskAbnormalityBean;
import com.lingjun.colliery_android.utils.DateUtil;
import com.lingjun.colliery_android.utils.FastJsonTools;
import com.lingjun.colliery_android.utils.RecyclerViewUtils;
import com.lingjun.colliery_android.utils.retrofit.BaseSubscriber;
import com.lingjun.colliery_android.utils.retrofit.ExceptionHandle;

import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 作者: zengtao
 * 时间: 2019/5/27  18:15.
 * 注释:风险异常
 */
public class RiskAbnormalityActivity extends BaseActivity {

    @BindView(R.id.tv_content)
    TextView tvContent;
    private String implementId;
    @BindView(R.id.tv_name)
    TextView tvName;

    @Override
    protected int getResourcesId() {
        return R.layout.activity_risk_abnormality;
    }

    @Override
    protected void init(Bundle savedInstanceState) throws PackageManager.NameNotFoundException {
        implementId = getIntent().getStringExtra("implementId");
        refreshView();
    }

    private void refreshView() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("implementId", implementId);
        hashMap.put(BaseLinkList.apiurl, BaseLinkList.coal_mine + BaseLinkList.getRiskMeassesinfo);
        mRetrofit.JsonToColliery(BaseLinkList.Base_Url, hashMap, new BaseSubscriber() {
            @Override
            public void onError(ExceptionHandle.ResponeThrowable e) {

            }

            @Override
            public void onSuccess(JSONObject jsonObject) {
                LogUtils.e("风险异常->>" + jsonObject.toString());
                final RiskAbnormalityBean riskAbnormalityBean = FastJsonTools.getBean(jsonObject.toString(), RiskAbnormalityBean.class);
                if (riskAbnormalityBean.getData() != null) {
                    tvContent.setText(riskAbnormalityBean.getData().getMeassageInfo());
                    tvName.setText(riskAbnormalityBean.getData().getName());
                }
            }
        });
    }

    @Override
    protected BaseRefreshLoadMoreInterface setRefreshLoadMoreListener() {
        return null;
    }
}
