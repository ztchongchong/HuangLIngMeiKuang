package com.lingjun.colliery_android.module.main.rectifyingviolations.fragment;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.lingjun.colliery_android.R;
import com.lingjun.colliery_android.base.BaseActivity;
import com.lingjun.colliery_android.module.document.activity.TaskTrackingLIstActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author: ztcc
 * @Data： 2019/9/8 9:38
 * Describe:旬
 */
public class TenDaysActivity extends BaseActivity {

    public static final int Code = 3;

    @BindView(R.id.tv_1)
    TextView tv1;
    @BindView(R.id.tv_2)
    TextView tv2;
    @BindView(R.id.tv_3)
    TextView tv3;
    private Intent intent = new Intent();

    @Override
    protected int getResourcesId() {
        return R.layout.activity_tendays;
    }

    @Override
    protected void init(Bundle savedInstanceState) throws PackageManager.NameNotFoundException {

    }

    @Override
    protected BaseRefreshLoadMoreInterface setRefreshLoadMoreListener() {
        return null;
    }

    @OnClick({R.id.tv_1, R.id.tv_2, R.id.tv_3})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_1:
                intent = new Intent(TenDaysActivity.this, AssessmentActivity.class);
                intent.putExtra("xun", "1");
                setResult(Code, intent);
                finish();
                break;
            case R.id.tv_2:
                intent = new Intent(TenDaysActivity.this, AssessmentActivity.class);
                intent.putExtra("xun", "2");
                setResult(Code, intent);
                finish();
                break;
            case R.id.tv_3:
                intent = new Intent(TenDaysActivity.this, AssessmentActivity.class);
                intent.putExtra("xun", "3");
                setResult(Code, intent);
                finish();
                break;
        }
    }
}
