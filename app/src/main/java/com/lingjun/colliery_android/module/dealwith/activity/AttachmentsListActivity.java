package com.lingjun.colliery_android.module.dealwith.activity;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lingjun.colliery_android.R;
import com.lingjun.colliery_android.base.BaseActivity;
import com.lingjun.colliery_android.base.OnGlobalListener;
import com.lingjun.colliery_android.bean.DealWithBean;
import com.lingjun.colliery_android.bean.HiddenDangerDetailsBean;
import com.lingjun.colliery_android.utils.RecyclerViewUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 作者: lihuan
 * 时间: 2018/11/22 15:23
 * 说明: 附件列表
 */
public class AttachmentsListActivity extends BaseActivity {

    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.rv_img_list)
    RecyclerView rvImgList;

    private ArrayList<HiddenDangerDetailsBean.DataBean.YsfileListBean> ysfileListBeans;
    private ArrayList<HiddenDangerDetailsBean.DataBean.FafileListBean> fafileListBeans;

    @Override
    protected int getResourcesId() {
        return R.layout.activity_attachments_list;
    }

    @Override
    protected BaseRefreshLoadMoreInterface setRefreshLoadMoreListener() {
        return null;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        ysfileListBeans = (ArrayList<HiddenDangerDetailsBean.DataBean.YsfileListBean>) getIntent().getSerializableExtra("ysfileListBeans");
        fafileListBeans = (ArrayList<HiddenDangerDetailsBean.DataBean.FafileListBean>) getIntent().getSerializableExtra("fafileListBeans");

        if (ysfileListBeans != null) {
            RecyclerViewUtils.initLiner(this, rvImgList, R.layout.item_deal_with_file, ysfileListBeans, new OnGlobalListener() {
                @Override
                public <T> void logic(BaseViewHolder helper, List<T> mData, T item, BaseQuickAdapter mAdapter) {
                    HiddenDangerDetailsBean.DataBean.YsfileListBean resultsBean = (HiddenDangerDetailsBean.DataBean.YsfileListBean) item;

                    TextView imgName = helper.getView(R.id.tv_img_name);

                    //图片名称
                    imgName.setText(resultsBean.getFileName());

                }
            }, new BaseQuickAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                    HiddenDangerDetailsBean.DataBean.YsfileListBean resultsBean = (HiddenDangerDetailsBean.DataBean.YsfileListBean) adapter.getData().get(position);

                }
            }, null);
        }

        if (fafileListBeans != null) {
            RecyclerViewUtils.initLiner(this, rvImgList, R.layout.item_deal_with_file, fafileListBeans, new OnGlobalListener() {
                @Override
                public <T> void logic(BaseViewHolder helper, List<T> mData, T item, BaseQuickAdapter mAdapter) {
                    HiddenDangerDetailsBean.DataBean.FafileListBean resultsBean = (HiddenDangerDetailsBean.DataBean.FafileListBean) item;

                    TextView imgName = helper.getView(R.id.tv_img_name);

                    //图片名称
                    imgName.setText(resultsBean.getFileName());

                }
            }, new BaseQuickAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                    HiddenDangerDetailsBean.DataBean.FafileListBean resultsBean = (HiddenDangerDetailsBean.DataBean.FafileListBean) adapter.getData().get(position);

                }
            }, null);
        }
    }

    @OnClick(R.id.iv_back)
    public void onViewClicked() {
        finish();
    }
}
