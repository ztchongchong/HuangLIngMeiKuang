package com.lingjun.colliery_android.module.dealwith.adapter;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lingjun.colliery_android.R;
import com.lingjun.colliery_android.bean.ToReviewBean;
import com.lingjun.colliery_android.module.dealwith.activity.ToReviewInfoActivity;
import com.lingjun.colliery_android.module.dealwith.myinterface.ListviewInterface;


import java.util.List;

/**
 * Created by shurrikann on 2018/3/28.
 */

public class ToReviewAdapter<T> extends BaseQuickAdapter<T, BaseViewHolder> {
    //    private ListviewInterface listviewInterface;
    private String taskid;

    public ToReviewAdapter(int layoutResId, String taskid) {
        super(layoutResId);
        this.taskid = taskid;
    }

    public ToReviewAdapter(int layoutResId, ListviewInterface listviewInterface) {
        super(layoutResId);
//        this.listviewInterface = listviewInterface;
    }

    public ToReviewAdapter(int layoutResId, @Nullable List<T> data) {
        super(layoutResId, data);
    }

    public ToReviewAdapter(@Nullable List<T> data) {
        super(data);
    }

    public ToReviewAdapter(int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void convert(final BaseViewHolder helper, T item) {

        final ToReviewBean.DataBean.CategoryarrayBean str = (ToReviewBean.DataBean.CategoryarrayBean) item;
        helper.setText(R.id.tv_name, str.getName());
        TextView fen = helper.getView(R.id.fen);
        fen.setVisibility(View.VISIBLE);
        TextView nocheck = helper.getView(R.id.no_check);
        TextView defen = helper.getView(R.id.defen);
        if (str.getScore() == -1) {
            defen.setVisibility(View.GONE);
            fen.setVisibility(View.INVISIBLE);
            nocheck.setVisibility(View.VISIBLE);
        } else {
            defen.setVisibility(View.VISIBLE);
            fen.setVisibility(View.VISIBLE);
            nocheck.setVisibility(View.GONE);
            defen.setText(str.getScore() + "");
        }
        LinearLayout root = helper.getView(R.id.root);
        root.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (str.getScore() != -1) {
                    Log.d("taskid222", taskid);
                    Intent intent = new Intent();
                    intent.setClass(mContext, ToReviewInfoActivity.class);
                    intent.putExtra("taskid", taskid);
                    intent.putExtra("typeid", str.getId());
                    intent.putExtra("title", str.getName());
                    mContext.startActivity(intent);
//                    listviewInterface.btnsClicks(v, helper.getAdapterPosition(), true, 1);
                }
            }
        });

    }

//
//    public void setInterface(ListviewInterface listviewInterface) {
//        this.listviewInterface = listviewInterface;
//    }
}
