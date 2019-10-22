package com.lingjun.colliery_android.module.dealwith.adapter;

import android.graphics.Color;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lingjun.colliery_android.R;
import com.lingjun.colliery_android.base.BaseLinkList;
import com.lingjun.colliery_android.bean.LeadBean;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by shurrikann on 2018/3/20.
 */

public class InviteLeadAdapter1<T> extends BaseQuickAdapter<T, BaseViewHolder> {


    public InviteLeadAdapter1(int layoutResId, @Nullable List<T> data, int type) {
        super(layoutResId, data);
    }

    public InviteLeadAdapter1(int layoutResId, @Nullable List<T> data) {
        super(layoutResId, data);
    }

    public InviteLeadAdapter1(@Nullable List<T> data) {
        super(data);
    }

    public InviteLeadAdapter1(int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void convert(BaseViewHolder helper, T item) {
        LeadBean.DataBean.OutuserBean beans = (LeadBean.DataBean.OutuserBean) item;
        helper.setText(R.id.tv_buttonName, beans.getName());
        TextView zhiwei = helper.getView(R.id.tv_zhiwei);
        CircleImageView lead_img = helper.getView(R.id.iv_icon);
        zhiwei.setBackgroundColor(Color.parseColor("#4DD0E1"));
        if (TextUtils.isEmpty(beans.getPictureurl()+"")) {
            Glide.with(mContext).load(BaseLinkList.Base_Url + beans.getPictureurl() + "").into(lead_img);
        }
    }

}
