package com.lingjun.colliery_android.module.dealwith.adapter;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.kyleduo.switchbutton.SwitchButton;
import com.lingjun.colliery_android.R;
import com.lingjun.colliery_android.bean.AcceptableBean;
import com.lingjun.colliery_android.module.dealwith.myinterface.ListviewInterface;

import java.util.List;

/**
 * Created by shurrikann on 2018/3/23.
 */

public class AcceptableAdapter<T> extends BaseQuickAdapter<T, BaseViewHolder> {
    ListviewInterface listviewInterface;

    public AcceptableAdapter(int layoutResId, ListviewInterface listviewInterface) {
        super(layoutResId);
        this.listviewInterface = listviewInterface;
    }

    public AcceptableAdapter(int layoutResId, @Nullable List<T> data) {
        super(layoutResId, data);
    }

    public AcceptableAdapter(@Nullable List<T> data) {
        super(data);
    }

    public AcceptableAdapter(int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void convert(final BaseViewHolder helper, T item) {
        final AcceptableBean.DataBean.ResultObjBean.TaskitemlistBean bean = (AcceptableBean.DataBean.ResultObjBean.TaskitemlistBean) item;
        RelativeLayout root = helper.getView(R.id.root);
        LinearLayout data_info = helper.getView(R.id.data_info);
        helper.setText(R.id.item_title, bean.getSerialno() + " " + bean.getCategoryname3());
        if (!TextUtils.isEmpty(bean.getResultscore() + "")) {
            helper.setText(R.id.score, String.valueOf(bean.getScore() - (int) bean.getResultscore()));
        } else {
            helper.setText(R.id.score, bean.getScore() + "");
        }
        helper.setText(R.id.zeren, "责任：" + bean.getResponsibleName());
        helper.setText(R.id.peihe, "配合：" + bean.getCooperatorNames());
        helper.setText(R.id.teyao, "特邀：" + bean.getInvited());
        helper.setText(R.id.typestr, bean.getCategoryname().replace("/", "-"));
        helper.setText(R.id.number, "编号：" + bean.getSerialno());
        helper.setText(R.id.yaoqiu, bean.getDemand());//要求
        helper.setText(R.id.pingfen, String.valueOf(bean.getScore()));//评分
        helper.setText(R.id.jiancha, bean.getMethodContent());//检查方式及内容
        helper.setText(R.id.ziliao, bean.getRequiredInfo());//所需资料
        helper.setText(R.id.koufen, bean.getDetailedRules());//扣分细则
        helper.setText(R.id.liyou_text, bean.getRejectremark());

        ImageView pull = helper.getView(R.id.pull);
        TextView liyou_text = helper.getView(R.id.liyou_text);
        if (!TextUtils.isEmpty(bean.getRejectremark())) {
            liyou_text.setText("意见：" + bean.getRejectremark());
        } else {
            liyou_text.setText("");
        }
        SwitchButton sw_state = helper.getView(R.id.sw_state);
        sw_state.setChecked(bean.isState());
        sw_state.setText("接受", "关闭");
        sw_state.setFadeBack(bean.isState());
        sw_state.setTextExtra(20);
        sw_state.setBackDrawable(mContext.getResources().getDrawable(R.drawable.switch_button_bg));
        sw_state.setTextColor(mContext.getResources().getColor(R.color.white));
        root.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listviewInterface.btnClick(v, helper.getAdapterPosition(), bean.isRoot());
            }
        });
        sw_state.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (!isChecked) {
                    listviewInterface.btnsClicks(buttonView, helper.getAdapterPosition(), bean.isState(), 2);
                } else {
                    listviewInterface.btnsClicks(buttonView, helper.getAdapterPosition(), bean.isState(), 3);
                }
            }
        });
        if (bean.isRoot()) {
            data_info.setVisibility(View.VISIBLE);
            pull.setImageDrawable(mContext.getResources().getDrawable(R.drawable.jiantou_top));
        } else {
            data_info.setVisibility(View.GONE);
            pull.setImageDrawable(mContext.getResources().getDrawable(R.drawable.jiantou_bottom));
        }
    }
}
