package com.lingjun.colliery_android.module.main.rectifyingviolations.fragment;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.lingjun.colliery_android.R;
import com.lingjun.colliery_android.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 作者: zengtao
 * 时间: 2019/5/23  15:47.
 * 注释:
 */
public class AmendmentPenaltyItemActivity extends BaseActivity {

    public static final int HiddenDangerCode = 19;
    @BindView(R.id.tv_1)
    TextView tv1;
    @BindView(R.id.tv_2)
    TextView tv2;
    @BindView(R.id.tv_3)
    TextView tv3;
    private String id;
    private int position;

    private Intent intent = new Intent();

    @Override
    protected int getResourcesId() {
        return R.layout.activity_amendmentpenalty_item;
    }

    @Override
    protected void init(Bundle savedInstanceState) throws PackageManager.NameNotFoundException {
        id = getIntent().getStringExtra("unsafeid");
        position = getIntent().getIntExtra("position", -1);
    }

    @Override
    protected BaseRefreshLoadMoreInterface setRefreshLoadMoreListener() {
        return null;
    }

    @OnClick({R.id.tv_1, R.id.tv_2, R.id.tv_3})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_1:
                intent.putExtra("levelId", "1");
                intent.putExtra("unsafeid", id);
                intent.putExtra("position", position);
                setResult(HiddenDangerCode, intent);
                finish();
                break;
            case R.id.tv_2:
                intent.putExtra("levelId", "2");
                intent.putExtra("unsafeid", id);
                intent.putExtra("position", position);
                setResult(HiddenDangerCode, intent);
                finish();
                break;
            case R.id.tv_3:
                intent.putExtra("levelId", "3");
                intent.putExtra("unsafeid", id);
                intent.putExtra("position", position);
                setResult(HiddenDangerCode, intent);
                finish();
                break;
        }
    }
}
