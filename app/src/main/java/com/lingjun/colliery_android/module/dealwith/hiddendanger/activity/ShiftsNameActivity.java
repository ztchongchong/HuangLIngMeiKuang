package com.lingjun.colliery_android.module.dealwith.hiddendanger.activity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.lingjun.colliery_android.R;
import com.lingjun.colliery_android.base.BaseActivity;
import com.lingjun.colliery_android.module.dealwith.hiddendanger.general_hidden_danger.HiddenDangerNtryActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 作者: zengtao
 * 时间: 2019/6/4  19:11.
 * 注释: 班次名称
 */
public class ShiftsNameActivity extends BaseActivity {
    public static final int HiddenDangerCode = 331;
    @BindView(R.id.tv1)
    TextView tv1;
    @BindView(R.id.tv2)
    TextView tv2;
    @BindView(R.id.tv3)
    TextView tv3;
    private Intent intent;

    @Override
    protected int getResourcesId() {
        return R.layout.activity_shiftsname;
    }

    @Override
    protected void init(Bundle savedInstanceState) throws PackageManager.NameNotFoundException {

    }

    @Override
    protected BaseRefreshLoadMoreInterface setRefreshLoadMoreListener() {
        return null;
    }

    @OnClick({R.id.tv1, R.id.tv2, R.id.tv3})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv1:
                intent = new Intent();
                intent.putExtra("classTime", "0");
                setResult(HiddenDangerCode, intent);
                finish();
                break;
            case R.id.tv2:
                intent = new Intent();
                intent.putExtra("classTime", "4");
                setResult(HiddenDangerCode, intent);
                finish();
                break;
            case R.id.tv3:
                intent = new Intent();
                intent.putExtra("classTime", "8");
                setResult(HiddenDangerCode, intent);
                finish();
                break;
        }
    }
}
