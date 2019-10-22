package com.lingjun.colliery_android.module.dealwith.activity;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.ImageView;
import android.widget.TextView;

import com.lingjun.colliery_android.R;
import com.lingjun.colliery_android.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 作者: lihuan
 * 时间: 2018/11/19 14:51
 * 说明: 现场治理 ---> 治理方案,验收说明
 */
public class SolutionActivity extends BaseActivity {

    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.tv_back)
    ImageView tvBack;
    @BindView(R.id.tv_content)
    TextView tvContent;

    @Override
    protected int getResourcesId() {
        return R.layout.activity_solution;
    }

    @Override
    protected BaseRefreshLoadMoreInterface setRefreshLoadMoreListener() {
        return null;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        String title = getIntent().getStringExtra("title");
        String content = getIntent().getStringExtra("content");

        tvName.setText(title);
        tvContent.setText(content);
        tvContent.setMovementMethod(ScrollingMovementMethod.getInstance());
    }

    @OnClick(R.id.tv_back)
    public void onViewClicked() {
        finish();
    }
}
