package com.lingjun.colliery_android.module.main.rectifyingviolations;

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
 * 时间: 2019/2/11  15:51.
 * 注释: 三违自定义等级
 */
public class JWcustomActivity extends BaseActivity {
    public static final int RectifyingCode = 307;
    @BindView(R.id.tv_yiban)
    TextView tvYiban;
    @BindView(R.id.tv_zhongda)
    TextView tvZhongda;
    private Intent intent = new Intent();

    @Override
    protected int getResourcesId() {
        return R.layout.activity_jw_custom;
    }

    @Override
    protected void init(Bundle savedInstanceState) throws PackageManager.NameNotFoundException {

    }

    @Override
    protected BaseRefreshLoadMoreInterface setRefreshLoadMoreListener() {
        return null;
    }


    @OnClick({R.id.tv_yiban, R.id.tv_zhongda})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_yiban:
                intent = new Intent();
                intent.putExtra("grade", "1");
                setResult(RectifyingCode, intent);
                finish();
                break;
            case R.id.tv_zhongda:
                intent = new Intent();
                intent.putExtra("grade", "2");
                setResult(RectifyingCode, intent);
                finish();
                break;
        }
    }
}
