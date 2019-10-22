package com.lingjun.colliery_android.module.dealwith.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lingjun.colliery_android.R;
import com.lingjun.colliery_android.bean.CheckFileBean;
import com.lingjun.colliery_android.bean.EditionCataLogInListAPPBean;
import com.lingjun.colliery_android.module.dealwith.activity.DataEditingActivity;
import com.lingjun.colliery_android.module.dealwith.activity.DivideWorkActivity;
import com.lingjun.colliery_android.module.dealwith.myinterface.ListviewInterface;
import com.lingjun.colliery_android.utils.ToastUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by shurrikann on 2018/3/26.
 */

public class DivideWorkAdapter<T> extends BaseQuickAdapter<T, BaseViewHolder> {
    private int type;
    //    private List<String> list = new ArrayList<>();
    private ListviewInterface listviewInterface;

    public DivideWorkAdapter(int layoutResId, @Nullable List<T> data) {
        super(layoutResId, data);
    }

    public DivideWorkAdapter(@Nullable List<T> data) {
        super(data);
    }

    public DivideWorkAdapter(int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void convert(final BaseViewHolder helper, T item) {
        switch (type) {
            case 1:
//                final String str = (String) item;
//                helper.setText(R.id.number, str);
//                RecyclerView recy = helper.getView(R.id.recy);
//                recy.setLayoutManager(new LinearLayoutManager(mContext));
//                RequestInfoAdapter adapter = new RequestInfoAdapter(R.layout.item_request_info, list, 1);
//                recy.setAdapter(adapter);
                break;
            case 2:
                final EditionCataLogInListAPPBean.DataBean.ResultStdfileEditionListBean strs = (EditionCataLogInListAPPBean.DataBean.ResultStdfileEditionListBean) item;
                helper.setText(R.id.file_name, strs.getName());
                helper.setText(R.id.number, strs.getNumber());
                helper.setText(R.id.tv_stdname, strs.getStdname());
                helper.setText(R.id.tv_position,"位置:"+strs.getCatalogName());
                RelativeLayout root = helper.getView(R.id.root);
                ImageView img_down = helper.getView(R.id.img_down);
                LinearLayout ll_add_ziliao = helper.getView(R.id.ll_add_ziliao);
                LinearLayout info = helper.getView(R.id.info);
                if (strs.getFileData().getFileList().size() != 0) {
                    List<EditionCataLogInListAPPBean.DataBean.ResultStdfileEditionListBean.FileDataBean.FileListBean> filelist = (List<EditionCataLogInListAPPBean.DataBean.ResultStdfileEditionListBean.FileDataBean.FileListBean>) strs.getFileData().getFileList();
                    RecyclerView data_recy = helper.getView(R.id.data_recy);
                    data_recy.setLayoutManager(new LinearLayoutManager(mContext));
                    RequestInfoAdapter adapters = new RequestInfoAdapter(R.layout.item_data_info, filelist, 2);
                    data_recy.setAdapter(adapters);
                }
                if (strs.isStates()) {
                    info.setVisibility(View.VISIBLE);
                    img_down.setImageDrawable(mContext.getResources().getDrawable(R.drawable.jiantou_top));
                } else {
                    info.setVisibility(View.GONE);
                    img_down.setImageDrawable(mContext.getResources().getDrawable(R.drawable.jiantou_bottom));
                }

                root.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        strs.setStates(!strs.isStates());
                        notifyItemChanged(helper.getAdapterPosition());
//                        listviewInterface.btnsClicks(v, helper.getAdapterPosition(), strs.isStates(), 1);
                    }
                });

                ll_add_ziliao.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent inten = new Intent(mContext, DataEditingActivity.class);
                        inten.putExtra("judge","2");
                        inten.putExtra("bean",strs);
                        mContext.startActivity(inten);
                    }
                });
                break;
            case 3:
                break;
        }
    }

    public void setType(int type) {
        this.type = type;
    }

//    public void setData(List<String> list) {
//        this.list = list;
//    }

    public void setInterface(ListviewInterface listviewInterface) {
        this.listviewInterface = listviewInterface;
    }
}
