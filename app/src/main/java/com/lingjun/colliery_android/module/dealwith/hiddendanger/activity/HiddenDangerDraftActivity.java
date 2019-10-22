package com.lingjun.colliery_android.module.dealwith.hiddendanger.activity;

import android.os.Bundle;

import com.lingjun.colliery_android.R;
import com.lingjun.colliery_android.base.BaseActivity;

/**
 * 隐患内容草稿
 */
public class HiddenDangerDraftActivity extends BaseActivity {
    @Override
    protected int getResourcesId() {
        return R.layout.activity_hidden_danger_draft;
    }

    @Override
    protected void init(Bundle savedInstanceState) {

    }

    @Override
    protected BaseRefreshLoadMoreInterface setRefreshLoadMoreListener() {
        return null;
    }
}
