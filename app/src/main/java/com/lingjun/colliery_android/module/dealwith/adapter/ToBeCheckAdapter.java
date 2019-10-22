package com.lingjun.colliery_android.module.dealwith.adapter;

import android.support.annotation.Nullable;
import android.text.TextUtils;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lingjun.colliery_android.R;
import com.lingjun.colliery_android.bean.ToCheckBean;

import java.util.List;

/**
 * Created by shurrikann on 2018/3/26.
 */

public class ToBeCheckAdapter<T> extends BaseQuickAdapter<T, BaseViewHolder> {

    public String getDefen() {
        return defen;
    }

    public void setDefen(String defen) {
        this.defen = defen;
    }

    private String defen;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    public ToBeCheckAdapter(int layoutResId, @Nullable List<T> data) {
        super(layoutResId, data);
    }

    public ToBeCheckAdapter(@Nullable List<T> data) {
        super(data);
    }

    public ToBeCheckAdapter(int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void convert(BaseViewHolder helper, T item) {
        ToCheckBean.DataBean.PageBean.ParamsBean.ItemlistBean bean = (ToCheckBean.DataBean.PageBean.ParamsBean.ItemlistBean) item;
        helper.setText(R.id.tv_task_name, bean.getSerialno() + bean.getCategoryname());
        name = bean.getSerialno() + bean.getCategoryname();
        helper.setText(R.id.info, bean.getDemand());
        helper.setText(R.id.zongfen, "共" + bean.getScore() + "分");
//        if (bean.getType() == 0) {
//            helper.setText(R.id.defen, bean.getScore() + "");
//            defen = bean.getScore() + "";
//        } else if (bean.getType() == 1) {
//            helper.setText(R.id.defen, String.valueOf(bean.getScore() - bean.getResultscore()));
//        }
        helper.setText(R.id.defen, String.valueOf(bean.getScore() - bean.getResultscore()));
        if (null != bean.getResultremark()) {
            if (bean.getResultremark().equals("null")) {
                helper.setText(R.id.tv_yijian, "意见：");
            } else {
                helper.setText(R.id.tv_yijian, "意见：" + bean.getResultremark());
            }
        } else {
            helper.setText(R.id.tv_yijian, "意见：");
        }
    }
}
