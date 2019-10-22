package com.lingjun.colliery_android.module.dealwith.standardized.audit;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

import com.lingjun.colliery_android.R;
import com.lingjun.colliery_android.base.BaseActivity;

/**
 * 驳回意见
 * Created by nefa on 2018/11/2.
 */

public class RejectedOpinionActivity extends BaseActivity {

    private TextView tv_count;
    private EditText et_text;

    @Override
    protected int getResourcesId() {
        return R.layout.activity_rejected_opinion;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        tv_count = findViewById(R.id.tv_count);
        et_text = findViewById(R.id.et_text);
        et_text.addTextChangedListener(new TextWatcher() {
            //输入前
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            //输入中
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (TextUtils.isEmpty(charSequence)) {
                    tv_count.setText("0/800");
                } else {
                    int length = charSequence.length();
                    tv_count.setText(length + "/800");
                }
            }

            //输入后
            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    @Override
    protected BaseRefreshLoadMoreInterface setRefreshLoadMoreListener() {
        return null;
    }
}
