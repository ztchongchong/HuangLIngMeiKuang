package com.lingjun.colliery_android.module.siyuanliangzhang;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.lingjun.colliery_android.R;
import com.lingjun.colliery_android.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * @author: ztcc
 * @Data： 2019/9/16 10:57
 * Describe:四员两长
 */
public class SyliangzhangActivity extends BaseActivity {


    @BindView(R.id.ll_anjianyuan)
    LinearLayout llAnjianyuan;
    @BindView(R.id.ll_wanjianyuan)
    LinearLayout llWanjianyuan;
    @BindView(R.id.ll_jishuyuan)
    LinearLayout llJishuyuan;
    @BindView(R.id.ll_yanshouyuan)
    LinearLayout llYanshouyuan;
    @BindView(R.id.ll_banzuzhang)
    LinearLayout llBanzuzhang;
    @BindView(R.id.ll_banfu)
    LinearLayout llBanfu;
    private Intent intent;

    @Override
    protected int getResourcesId() {
        return R.layout.activity_syliangzhang;
    }

    @Override
    protected void init(Bundle savedInstanceState) throws PackageManager.NameNotFoundException {

    }

    @Override
    protected BaseRefreshLoadMoreInterface setRefreshLoadMoreListener() {
        return null;
    }

    @OnClick({R.id.ll_anjianyuan, R.id.ll_wanjianyuan, R.id.ll_jishuyuan, R.id.ll_yanshouyuan, R.id.ll_banzuzhang, R.id.ll_banfu})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_anjianyuan:
                intent = new Intent(SyliangzhangActivity.this, SylzClockdialActivity.class);
                intent.putExtra("sylz", 1);
                startActivity(intent);
                break;
            case R.id.ll_wanjianyuan:
                intent = new Intent(SyliangzhangActivity.this, SylzClockdialActivity.class);
                intent.putExtra("sylz", 2);
                startActivity(intent);
                break;
            case R.id.ll_jishuyuan:
                intent = new Intent(SyliangzhangActivity.this, SylzClockdialActivity.class);
                intent.putExtra("sylz", 3);
                startActivity(intent);
                break;
            case R.id.ll_yanshouyuan:
                intent = new Intent(SyliangzhangActivity.this, SylzClockdialActivity.class);
                intent.putExtra("sylz", 4);
                startActivity(intent);
                break;
            case R.id.ll_banzuzhang:
                intent = new Intent(SyliangzhangActivity.this, SylzClockdialActivity.class);
                intent.putExtra("sylz", 5);
                startActivity(intent);
                break;
            case R.id.ll_banfu:
                intent = new Intent(SyliangzhangActivity.this, SylzClockdialActivity.class);
                intent.putExtra("sylz", 6);
                startActivity(intent);
                break;
        }
    }
}
