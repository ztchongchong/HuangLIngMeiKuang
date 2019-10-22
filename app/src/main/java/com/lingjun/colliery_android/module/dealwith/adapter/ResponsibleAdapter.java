package com.lingjun.colliery_android.module.dealwith.adapter;

import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lingjun.colliery_android.R;
import com.lingjun.colliery_android.base.BaseLinkList;
import com.lingjun.colliery_android.bean.CheckFileBean;
import com.lingjun.colliery_android.bean.PeiHeBean;
import com.lingjun.colliery_android.bean.ZeRenBean;
import com.lingjun.colliery_android.module.dealwith.myinterface.ListviewInterface;
import com.lingjun.colliery_android.view.CircleImageView;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by shurrikann on 2018/3/20.
 */

public class ResponsibleAdapter<T> extends BaseQuickAdapter<T, BaseViewHolder> {
    List<String> list = new ArrayList<>();
    ListviewInterface listviewInterface;

    public ResponsibleAdapter(int layoutResId, @Nullable List<T> data) {
        super(layoutResId, data);
    }

    public ResponsibleAdapter(@Nullable List<T> data) {
        super(data);
    }

    public ResponsibleAdapter(int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void convert(final BaseViewHolder helper, T item) {
        if (list.size() != 0) {
            list.clear();
        }
        for (int i = 0; i < 5; i++) {
            list.add("1");
        }
        final PeiHeBean.DataBean.MapBean bean = (PeiHeBean.DataBean.MapBean) item;
        helper.setText(R.id.name, bean.getName());
        helper.setText(R.id.size, bean.getList().size() + "项任务");
        CircleImageView userimg = helper.getView(R.id.user_img);
        Glide.with(mContext)
                .load(BaseLinkList.Base_Url + bean.getPicurl())
                .into(userimg);
        ResponsibleInfoAdapter adapter = new ResponsibleInfoAdapter(R.layout.item_responsren_info);
        RecyclerView recy_info = helper.getView(R.id.recy_info);
        recy_info.setLayoutManager(new LinearLayoutManager(mContext));
        recy_info.setAdapter(adapter);
        adapter.setNewData(bean.getList());
        RelativeLayout root = helper.getView(R.id.root);
        RelativeLayout info = helper.getView(R.id.info);
        View view = helper.getView(R.id.view);
        ImageView img = helper.getView(R.id.check_img);
        if (bean.isState()) {
            info.setVisibility(View.VISIBLE);
            view.setVisibility(View.VISIBLE);
            img.setImageDrawable(mContext.getResources().getDrawable(R.drawable.jiantou_top));
        } else {
            info.setVisibility(View.GONE);
            view.setVisibility(View.GONE);
            img.setImageDrawable(mContext.getResources().getDrawable(R.drawable.jiantou_bottom));
        }
        root.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listviewInterface.btnClick(v, helper.getAdapterPosition(), bean.isState());
            }
        });
    }

    public void setListviewInterface(ListviewInterface listviewInterface) {
        this.listviewInterface = listviewInterface;
    }
}
