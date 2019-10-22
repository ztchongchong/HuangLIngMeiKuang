package com.lingjun.colliery_android.module.document.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.lingjun.colliery_android.R;
import com.lingjun.colliery_android.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 借阅申请通知
 */
public class BorrowApplyNoticeActivity extends BaseActivity {

    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_borrow_status)
    TextView tvBorrowStatus;
    @BindView(R.id.tv_content)
    TextView tvContent;
    @BindView(R.id.tv_user_name)
    TextView tvUserName;
    @BindView(R.id.iv_status)
    ImageView ivStatus;
    @BindView(R.id.tv_hint)
    TextView tvHint;

    @Override
    protected int getResourcesId() {
        return R.layout.activity_borrow_apply_notice;
    }

    @Override
    protected BaseRefreshLoadMoreInterface setRefreshLoadMoreListener() {
        return null;
    }

    @Override
    protected void init(Bundle savedInstanceState) {

    }

    @OnClick(R.id.iv_back)
    public void onViewClicked() {
        finish();
    }
}
