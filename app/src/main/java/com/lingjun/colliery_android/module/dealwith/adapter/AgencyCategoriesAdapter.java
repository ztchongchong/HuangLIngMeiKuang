package com.lingjun.colliery_android.module.dealwith.adapter;

import android.support.annotation.Nullable;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lingjun.colliery_android.R;
import com.lingjun.colliery_android.bean.LXBean;
import com.lingjun.colliery_android.module.dealwith.myinterface.ListviewInterface;

import java.util.List;


public class AgencyCategoriesAdapter<T> extends BaseQuickAdapter<T, BaseViewHolder> {
    private ListviewInterface listviewInterface;

    public AgencyCategoriesAdapter(int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void convert(final BaseViewHolder helper, T item) {
        final LXBean.ResultMapsBean bean = (LXBean.ResultMapsBean) item;
        TextView tv_category_name = helper.getView(R.id.tv_category_name);
        RelativeLayout root = helper.getView(R.id.root);
        tv_category_name.setText(bean.getKeyword().getName());
        if (bean.isState()) {
            tv_category_name.setTextColor(mContext.getResources().getColor(R.color.tab_text_color_selected));
        } else {
            tv_category_name.setTextColor(mContext.getResources().getColor(R.color.gray3));
        }
        root.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bean.setState(!bean.isState());
                notifyItemChanged(helper.getAdapterPosition());
            }
        });
    }

    public void setInterface(ListviewInterface listviewInterface) {
        this.listviewInterface = listviewInterface;
    }
}
