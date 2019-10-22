package com.lingjun.colliery_android.module.main.rectifyingviolations.fragment;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.lingjun.colliery_android.R;
import com.lingjun.colliery_android.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @author: ztcc
 * @Data： 2019/9/12 17:13
 * Describe:
 */
public class NegativeActivity extends BaseActivity {
    public static final int Code = 4;

    @BindView(R.id.tv_1)
    TextView tv1;
    @BindView(R.id.tv_2)
    TextView tv2;
    private Intent intent = new Intent();

    @Override
    protected int getResourcesId() {
        return R.layout.activity_negative;
    }

    @Override
    protected void init(Bundle savedInstanceState) throws PackageManager.NameNotFoundException {

    }

    @Override
    protected BaseRefreshLoadMoreInterface setRefreshLoadMoreListener() {
        return null;
    }

    @OnClick({R.id.tv_1, R.id.tv_2})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_1:
                intent = new Intent(NegativeActivity.this, AssessmentActivity.class);
                intent.putExtra("fouding", 1);
                setResult(Code, intent);
                finish();
                break;
            case R.id.tv_2:
                intent = new Intent(NegativeActivity.this, AssessmentActivity.class);
                intent.putExtra("fouding", 2);
                setResult(Code, intent);
                finish();
                break;
        }
    }
}
