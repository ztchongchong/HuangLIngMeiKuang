package com.lingjun.colliery_android.module.document.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.lingjun.colliery_android.R;
import com.lingjun.colliery_android.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 作者: lihuan
 * 时间: 2018/12/17 11:06
 * 说明: 资料检索
 */
public class DocumentSearchActivity extends BaseActivity {

    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_list)
    TextView tvList;
    @BindView(R.id.et_search)
    EditText etSearch;
    @BindView(R.id.btn_search)
    Button btnSearch;
    @BindView(R.id.iv_del_history)
    ImageView ivDelHistory;
    @BindView(R.id.search_history)
    RecyclerView searchHistory;

    @Override
    protected int getResourcesId() {
        return R.layout.activity_document_search;
    }

    @Override
    protected BaseRefreshLoadMoreInterface setRefreshLoadMoreListener() {
        return null;
    }

    @Override
    protected void init(Bundle savedInstanceState) {

    }

    @OnClick(R.id.iv_back)
    public void onIvBackClicked() { //返回
        finish();
    }

    @OnClick(R.id.tv_list)
    public void onTvListClicked() { //借阅清单
        Intent intent = new Intent(this,BorrowListActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.btn_search)
    public void onBtnSearchClicked() { //搜索
        String searchContent = etSearch.getText().toString().trim();
        Intent intent = new Intent(this,DocumentSearchListActivity.class);
        intent.putExtra("searchContent",searchContent);
        startActivity(intent);
    }

    @OnClick(R.id.iv_del_history)
    public void onIvDelHistoryClicked() { //清除搜索历史
    }
}
