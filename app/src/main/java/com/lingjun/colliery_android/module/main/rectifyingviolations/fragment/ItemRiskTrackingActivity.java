package com.lingjun.colliery_android.module.main.rectifyingviolations.fragment;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.TextView;

import com.lingjun.colliery_android.R;
import com.lingjun.colliery_android.base.BaseActivity;
import com.lingjun.colliery_android.bean.RiskTrackingsBean;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import java.text.SimpleDateFormat;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 作者: zengtao
 * 时间: 2019/5/5  10:59.
 * 注释:  风险跟踪详情
 */
public class ItemRiskTrackingActivity extends BaseActivity {
    @BindView(R.id.tv_name)
    TextView tvName; //检查人
    @BindView(R.id.tv_time)
    TextView tvTime;//检查时间
    @BindView(R.id.tv_guankong_state)
    TextView tvGuankongState;//管控情况
    @BindView(R.id.tv_content)
    TextView tvContent;//情况说明
    @BindView(R.id.refreshLayout)
    SmartRefreshLayout refreshLayout;
    private TextView tv_title;

    private RiskTrackingsBean.DataBean.ImplementlistBean implementlistBean;

    @Override
    protected int getResourcesId() {
        return R.layout.activity_item_risk_tracking;
    }

    @Override
    protected void init(Bundle savedInstanceState) throws PackageManager.NameNotFoundException {
        tv_title=findViewById(R.id.tv_title);
        implementlistBean = (RiskTrackingsBean.DataBean.ImplementlistBean) getIntent().getSerializableExtra("data");
        String checkdate=new SimpleDateFormat("yyyy-MM-dd").format(new Date(implementlistBean.getCheckdate()));
        tv_title.setText(checkdate);
        if (null != implementlistBean) {
            tvName.setText(implementlistBean.getCheckerName() + "");
            if (implementlistBean.getImplementState().equals("0")) {
                tvGuankongState.setText("未检查");
            } else if (implementlistBean.getImplementState().equals("1")) {
                tvGuankongState.setText("正常");
            } else if (implementlistBean.getImplementState().equals("2")) {
                tvGuankongState.setText("异常");
            }
            if (implementlistBean.getCheckTime() != 0) {
                String time = new SimpleDateFormat("yyyy-MM-dd").format(new Date(implementlistBean.getCheckTime()));
                tvTime.setText(time);
            } else {
                tvTime.setText("");
            }
            if (implementlistBean.getImplementRemark() != null && !TextUtils.isEmpty(implementlistBean.getImplementRemark())) {
                tvContent.setText(implementlistBean.getImplementRemark());
            } else {
                tvContent.setText("无");
            }
        }

    }

    @Override
    protected BaseRefreshLoadMoreInterface setRefreshLoadMoreListener() {
        return null;
    }
}
