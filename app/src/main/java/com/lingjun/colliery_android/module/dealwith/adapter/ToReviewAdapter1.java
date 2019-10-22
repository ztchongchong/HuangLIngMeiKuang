package com.lingjun.colliery_android.module.dealwith.adapter;

import android.support.annotation.Nullable;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lingjun.colliery_android.module.dealwith.myinterface.ListviewInterface;


import java.util.List;

/**
 * Created by shurrikann on 2018/3/28.
 */

public class ToReviewAdapter1<T> extends BaseQuickAdapter<T, BaseViewHolder> {
    private ListviewInterface listviewInterface;


    public ToReviewAdapter1(int layoutResId, ListviewInterface listviewInterface) {
        super(layoutResId);
        this.listviewInterface = listviewInterface;
    }

    public ToReviewAdapter1(int layoutResId, @Nullable List<T> data) {
        super(layoutResId, data);
    }

    public ToReviewAdapter1(@Nullable List<T> data) {
        super(data);
    }

    public ToReviewAdapter1(int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void convert(BaseViewHolder helper, T item) {
//        StaffBean bean = (StaffBean) item;
//        helper.setText(R.id.title, bean.getStaff());
//        helper.setText(R.id.defen_tv, bean.getNum());
//        TextView fenstr = helper.getView(R.id.fen);
//        if (bean.getStaff().equals("特邀人员")) {
//            fenstr.setVisibility(View.GONE);
//        } else {
//            fenstr.setVisibility(View.VISIBLE);
//        }
//        RelativeLayout roots = helper.getView(R.id.root);
//        roots.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                listviewInterface.btnClick(v, helper.getAdapterPosition(), true);
//
//            }
//        });

    }


}
