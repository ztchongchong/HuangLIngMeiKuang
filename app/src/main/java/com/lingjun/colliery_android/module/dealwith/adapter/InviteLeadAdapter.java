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

public class InviteLeadAdapter<T> extends BaseQuickAdapter<T, BaseViewHolder> {

    public InviteLeadAdapter(int layoutResId, @Nullable List<T> data, int type) {
        super(layoutResId, data);
    }

    public InviteLeadAdapter(int layoutResId, @Nullable List<T> data) {
        super(layoutResId, data);
    }

    public InviteLeadAdapter(@Nullable List<T> data) {
        super(data);
    }

    public InviteLeadAdapter(int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void convert(BaseViewHolder helper, T item) {
        LeadBean.DataBean.InuserBean bean = (LeadBean.DataBean.InuserBean) item;
        helper.setText(R.id.tv_buttonName, bean.getName());
        CircleImageView lead_img = helper.getView(R.id.iv_icon);
        TextView zhiwei = helper.getView(R.id.tv_zhiwei);
        if (TextUtils.isEmpty(bean.getPictureurl()+"")) {
            Glide.with(mContext).load(BaseLinkList.Base_Url + bean.getPictureurl() + "").into(lead_img);
        }
        zhiwei.setBackgroundColor(Color.parseColor("#42A5F5"));
    }
}
