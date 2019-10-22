package com.lingjun.colliery_android.module.dealwith.adapter;

import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lingjun.colliery_android.R;
import com.lingjun.colliery_android.bean.CheckMlBean;
import com.lingjun.colliery_android.module.dealwith.activity.DivideWorkActivity;
import com.lingjun.colliery_android.module.dealwith.myinterface.ListviewInterface;

import java.util.List;

/**
 * Created by shurrikann on 2018/4/3.
 */

public class QuanXianAdapter<T> extends BaseQuickAdapter<T, BaseViewHolder> {
    private ListviewInterface listviewInterface;

    public QuanXianAdapter(int layoutResId, @Nullable List<T> data) {
        super(layoutResId, data);
    }

    public QuanXianAdapter(@Nullable List<T> data) {
        super(data);
    }

    public QuanXianAdapter(int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void convert(final BaseViewHolder helper, T item) {
        final CheckMlBean.DataBean.CatalogListBean bean = (CheckMlBean.DataBean.CatalogListBean) item;
        helper.setText(R.id.str, bean.getName());
        CheckBox checkbox = helper.getView(R.id.checkbox);
        RecyclerView info_recy = helper.getView(R.id.info_recy);
        LinearLayout root = helper.getView(R.id.root);
        info_recy.setLayoutManager(new LinearLayoutManager(mContext));
        QuanXianInfoAdapter adapter = new QuanXianInfoAdapter(R.layout.item_quanxian_info);
        info_recy.setAdapter(adapter);
        if (bean.isChecktype()) {
            checkbox.setChecked(true);
        } else {
            checkbox.setChecked(false);
        }
        checkbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bean.setChecktype(!bean.isChecktype());
                notifyItemChanged(helper.getAdapterPosition());
            }
        });
        if (bean.isState()) {
            info_recy.setVisibility(View.VISIBLE);
        } else {
            info_recy.setVisibility(View.GONE);
        }
        root.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listviewInterface.btnsClicks(v, helper.getAdapterPosition(), bean.isState(), 2);
            }
        });
    }

//    public void setData(List<String> list) {
//        this.list = list;
//    }

    public void setInterface(ListviewInterface listviewInterface) {
        this.listviewInterface = listviewInterface;
    }
}
