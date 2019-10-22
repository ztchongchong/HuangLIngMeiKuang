package com.lingjun.colliery_android.module.dealwith.adapter;

import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lingjun.colliery_android.R;
import com.lingjun.colliery_android.base.BaseLinkList;
import com.lingjun.colliery_android.bean.PeiHeBean;
import com.lingjun.colliery_android.bean.TaskBean;
import com.lingjun.colliery_android.bean.TeYaoBean;
import com.lingjun.colliery_android.module.dealwith.myinterface.ListviewInterface;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by shurrikann on 2018/12/12.
 */

public class TeYaoAdapter<T> extends BaseQuickAdapter<T, BaseViewHolder> {
    private int type;
    private ListviewInterface listviewInterface;

    private String types;

    public TeYaoAdapter(int layoutResId, int type, ListviewInterface listviewInterface) {
        super(layoutResId);
        this.type = type;
        this.listviewInterface = listviewInterface;
    }

    public TeYaoAdapter(int layoutResId, int type) {
        super(layoutResId);
        this.type = type;
    }

    public TeYaoAdapter(int layoutResId, @Nullable List<T> data) {
        super(layoutResId, data);
    }

    public TeYaoAdapter(@Nullable List<T> data) {
        super(data);
    }

    public TeYaoAdapter(int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void convert(final BaseViewHolder helper, T item) {
        switch (type) {
            case 0:
                TeYaoBean.DataBean.ItemmapBean.ListBean tybean = (TeYaoBean.DataBean.ItemmapBean.ListBean) item;
                helper.setText(R.id.tv_task_name, tybean.getSerialno() + " " + tybean.getCategoryname());
                helper.setText(R.id.tv_teyao, "特邀：" + tybean.getInvited());
                break;
            case 1:
                final PeiHeBean.DataBean.MapBean phbean = (PeiHeBean.DataBean.MapBean) item;
                helper.setText(R.id.tv_buttonName, phbean.getName());
//                helper.setText(R.id.tv_taskcount, phbean.getName());
//                helper.setText(R.id.tv_teyao, "特邀：" + phbean.get());
                CircleImageView iv_icon = helper.getView(R.id.iv_icon);
                if (TextUtils.isEmpty(phbean.getPicurl() + "")) {
                    Glide.with(mContext).load(BaseLinkList.Base_Url + phbean.getPicurl()).into(iv_icon);
                }
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mContext);
                ResponsibleInfoAdapter adapter = new ResponsibleInfoAdapter(R.layout.item_responsible_info);
                RecyclerView recy_info = helper.getView(R.id.rv_entry_list);
                recy_info.setLayoutManager(linearLayoutManager);
                recy_info.setAdapter(adapter);
                adapter.setNewData(phbean.getList());
                RelativeLayout root = helper.getView(R.id.rl_top);
                RelativeLayout info = helper.getView(R.id.rl_list);
//                View view = helper.getView(R.id.view);
                ImageView img = helper.getView(R.id.iv_jiantou);
                if (phbean.isState()) {
                    info.setVisibility(View.VISIBLE);
//                    view.setVisibility(View.VISIBLE);
                    img.setImageDrawable(mContext.getResources().getDrawable(R.drawable.jiantou_top));
                } else {
                    info.setVisibility(View.GONE);
//                    view.setVisibility(View.GONE);
                    img.setImageDrawable(mContext.getResources().getDrawable(R.drawable.jiantou_bottom));
                }
                root.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        listviewInterface.btnClick(v, helper.getAdapterPosition(), phbean.isState());
                    }
                });
                break;
            case 3:
                final TaskBean.DataBean.ItemmapBean.ListBean bean = (TaskBean.DataBean.ItemmapBean.ListBean) item;
                helper.setText(R.id.tv_task_name, bean.getSerialno() + " " + bean.getCategoryname());
                helper.setText(R.id.zongfen, "共 " + bean.getScore() + "分 得 ");
                if (types.equals("0")) {
                    helper.setText(R.id.defen, "0");
                } else if (types.equals("1")) {
                    helper.setText(R.id.defen, bean.getScore() + "");
                } else {
                    helper.setText(R.id.defen, bean.getScore() + "");
                }
                helper.setText(R.id.info_title, bean.getCategoryname());
                helper.setText(R.id.info, bean.getDemand());
                helper.setText(R.id.pingfen, bean.getStandard());
                helper.setText(R.id.jiancha, bean.getMethodContent());//检查
                helper.setText(R.id.ziliao, bean.getRequiredInfo());//资料
                helper.setText(R.id.koufen, bean.getDetailedRules());//扣分
                RelativeLayout rl_is_show = helper.getView(R.id.rl_is_show);
                LinearLayout ll_content = helper.getView(R.id.ll_content);
                ImageView iconimg = helper.getView(R.id.iv_icon);
                if (bean.isStates()) {
                    ll_content.setVisibility(View.VISIBLE);
                    iconimg.setImageDrawable(mContext.getResources().getDrawable(R.drawable.jiantou_top));
                } else {
                    ll_content.setVisibility(View.GONE);
                    iconimg.setImageDrawable(mContext.getResources().getDrawable(R.drawable.jiantou_bottom));
                }
                rl_is_show.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        bean.setStates(!bean.isStates());
                        notifyItemChanged(helper.getAdapterPosition());
                    }
                });
                break;
        }
    }

    public void setTypes(String types) {
        this.types = types;
    }

}
