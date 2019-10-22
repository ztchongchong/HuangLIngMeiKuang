package com.lingjun.colliery_android.module.dealwith.adapter;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lingjun.colliery_android.R;
import com.lingjun.colliery_android.bean.ReviewInfoBean;
import com.lingjun.colliery_android.module.dealwith.myinterface.ListviewInterface;

import java.util.List;

/**
 * Created by shurrikann on 2018/3/28.
 */

public class ToReviewInfoAdapter<T> extends BaseQuickAdapter<T, BaseViewHolder> {
    private ListviewInterface listviewInterface;

    public ToReviewInfoAdapter(int layoutResId, ListviewInterface listviewInterface) {
        super(layoutResId);
        this.listviewInterface = listviewInterface;
    }

    public ToReviewInfoAdapter(int layoutResId, @Nullable List<T> data) {
        super(layoutResId, data);
    }

    public ToReviewInfoAdapter(@Nullable List<T> data) {
        super(data);
    }

    public ToReviewInfoAdapter(int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void convert(final BaseViewHolder helper, T item) {
        final ReviewInfoBean.DataBean.ItemlistBean bean = (ReviewInfoBean.DataBean.ItemlistBean) item;
        RelativeLayout root = helper.getView(R.id.root);
        LinearLayout data_info = helper.getView(R.id.data_info);
        helper.setText(R.id.title, bean.getSerialno() + " " + bean.getCategoryname3());
//        helper.setText(R.id.zongfen, "共" + bean.getScore() + "分 得");
        helper.setText(R.id.fen_data, bean.getScore() - bean.getResultscore() + "");
        if (TextUtils.isEmpty(bean.getDefResponsibleName())) {
            helper.setText(R.id.zeren, "责任：");
        } else {
            helper.setText(R.id.zeren, "责任：" + bean.getDefResponsibleName());
        }

        helper.setText(R.id.peihe, "配合：" + bean.getDefCooperatorNames());
        helper.setText(R.id.teyao, "特邀：" + bean.getInvited());
        helper.setText(R.id.title_info, bean.getCategoryname().replace("/", "-"));
        helper.setText(R.id.num, "编号：" + bean.getSerialno());
        helper.setText(R.id.yaoqiu, bean.getDemand());
        helper.setText(R.id.pingfen, bean.getStandard());
        helper.setText(R.id.jiancha, bean.getMethodContent());//检查
        helper.setText(R.id.ziliao, bean.getRequiredInfo());//资料
        helper.setText(R.id.koufen, bean.getDetailedRules());//扣分
        ImageView pull = helper.getView(R.id.pull);
        root.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listviewInterface.btnClick(v, helper.getAdapterPosition(), bean.isStates());
            }
        });

        if (bean.isStates()) {
            data_info.setVisibility(View.VISIBLE);
            pull.setImageDrawable(mContext.getResources().getDrawable(R.drawable.jiantou_top));
        } else {
            data_info.setVisibility(View.GONE);
            pull.setImageDrawable(mContext.getResources().getDrawable(R.drawable.jiantou_bottom));
        }
    }
}
