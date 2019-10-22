package com.lingjun.colliery_android.module.dealwith.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.lingjun.colliery_android.R;
import com.lingjun.colliery_android.base.BaseActivity;
import com.lingjun.colliery_android.module.dealwith.adapter.ToReviewAdapter;
import com.lingjun.colliery_android.module.dealwith.adapter.ToReviewAdapter1;
import com.lingjun.colliery_android.module.dealwith.myinterface.ListviewInterface;
import com.lingjun.colliery_android.view.DiscView;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by shurrikann on 2018/12/5.
 */

public class ToReviewActivity extends BaseActivity implements ListviewInterface {
    @OnClick(R.id.iv_back)
    void back() {
        finish();
    }

    @BindView(R.id.disc)
    DiscView disc;
    @BindView(R.id.recy)
    RecyclerView recy;
    @BindView(R.id.recy1)
    RecyclerView recy1;
    @BindView(R.id.result)
    TextView result;
    @BindView(R.id.score)
    TextView score;
    @BindView(R.id.crew)
    TextView crew;
    @BindView(R.id.recy_rel)
    RelativeLayout recy_rel;
    @BindView(R.id.huizong)
    LinearLayout huizong;
    @BindView(R.id.recy_rel1)
    RelativeLayout recy_rel1;

    private ToReviewAdapter adapter;
    private ToReviewAdapter1 adapter1;

    private String taskid;
    @Override
    protected int getResourcesId() {
        return R.layout.activity_to_review;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        initAdapter();
        disc.setValue(36 * 75);
        initClick();
    }

    private void initClick() {
        result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Util.forceHideIM(ToReviewActivity.this);
                result.setTextColor(getResources().getColor(R.color.blue0092));
                score.setTextColor(getResources().getColor(R.color.color9797));
                crew.setTextColor(getResources().getColor(R.color.color9797));
                recy_rel.setVisibility(View.GONE);
                recy_rel1.setVisibility(View.GONE);
                huizong.setVisibility(View.VISIBLE);
            }
        });
        score.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Util.forceHideIM(ToReviewActivity.this);
                result.setTextColor(getResources().getColor(R.color.color9797));
                score.setTextColor(getResources().getColor(R.color.blue0092));
                crew.setTextColor(getResources().getColor(R.color.color9797));
//                setData(1);
                recy_rel.setVisibility(View.VISIBLE);
                recy_rel1.setVisibility(View.GONE);
                huizong.setVisibility(View.GONE);
            }
        });
        crew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Util.forceHideIM(ToReviewActivity.this);
                result.setTextColor(getResources().getColor(R.color.color9797));
                score.setTextColor(getResources().getColor(R.color.color9797));
                crew.setTextColor(getResources().getColor(R.color.blue0092));
//                setData(2);
                recy_rel.setVisibility(View.GONE);
                recy_rel1.setVisibility(View.VISIBLE);
                huizong.setVisibility(View.GONE);
            }
        });
    }

    @Override
    protected BaseRefreshLoadMoreInterface setRefreshLoadMoreListener() {
        return null;
    }

    private void initAdapter() {
        adapter = new ToReviewAdapter(R.layout.item_to_review, ToReviewActivity.this);
        adapter1 = new ToReviewAdapter1(R.layout.item_to_review1, ToReviewActivity.this);
        recy.setLayoutManager(new LinearLayoutManager(ToReviewActivity.this));
        recy1.setLayoutManager(new LinearLayoutManager(ToReviewActivity.this));
        recy.setAdapter(adapter);
        recy1.setAdapter(adapter1);
        recy.setNestedScrollingEnabled(false);
        recy1.setNestedScrollingEnabled(false);
    }

    @Override
    public void btnClick(View v, int pos, boolean type) {

    }

    @Override
    public void btnsClick(View v, int pos, int state, boolean type) {

    }

    @Override
    public void btnsClicks(View v, int pos, boolean state, int type) {

    }
}
