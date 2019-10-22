package com.lingjun.colliery_android.module.my;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.lingjun.colliery_android.R;
import com.lingjun.colliery_android.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 作者: zengtao
 * 时间: 2018/12/3  10:46.
 * 注释: 修改手机
 */
public class ModifyPhoneActivity extends BaseActivity {
    @BindView(R.id.et_mod_pho)
    EditText etModPho;
    @BindView(R.id.tv_preservation)
    TextView tvPreservation;

    @Override
    protected int getResourcesId() {
        return R.layout.activity_modify_phone;
    }

    @Override
    protected void init(Bundle savedInstanceState) {

    }

    @Override
    protected BaseRefreshLoadMoreInterface setRefreshLoadMoreListener() {
        return null;
    }


    @OnClick({R.id.et_mod_pho, R.id.tv_preservation})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.et_mod_pho:
                break;
            case R.id.tv_preservation:
                etModPho.getText().toString().trim();
                Preservation();
                break;
        }
    }

    private void Preservation() {
    }
}
