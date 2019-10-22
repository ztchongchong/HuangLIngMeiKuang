package com.lingjun.colliery_android.module.dealwith.fragment;


import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.blankj.utilcode.util.StringUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lingjun.colliery_android.R;
import com.lingjun.colliery_android.base.BaseFragment;
import com.lingjun.colliery_android.base.OnGlobalListener;
import com.lingjun.colliery_android.bean.HiddenDangerDetailsBean;
import com.lingjun.colliery_android.bean.ResponsibleRemarkBean;
import com.lingjun.colliery_android.utils.RecyclerViewUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * 作者: lihuan
 * 时间: 2018/11/20 14:33
 * 说明: 责任内容
 */
public class ResponsibilityContentFragment extends BaseFragment {
    @BindView(R.id.rv_locale_img)
    RecyclerView rvLocaleImg;

    private HiddenDangerDetailsBean mParam;

    public ResponsibilityContentFragment() {
    }

    public static ResponsibilityContentFragment newInstance(HiddenDangerDetailsBean dangerDetailsBean) {
        ResponsibilityContentFragment fragment = new ResponsibilityContentFragment();
        fragment.mParam = dangerDetailsBean;
//        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
//        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int setLayout(LayoutInflater inflater) {
        return R.layout.fragment_responsibility_content;
    }

    @Override
    protected BaseRefreshLoadMoreInterface setRefreshLoadMoreListener() {
        return null;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        if (mParam != null && mParam.getData() != null) {
            dataDisplay(mParam.getData());
        }
    }

    /**
     * 界面数据填充
     *
     * @param data
     */
    private void dataDisplay(HiddenDangerDetailsBean.DataBean data) {

        if (data.getSubTaskList() != null && !StringUtils.isEmpty(data.getSubTaskList().getResponsibleRemark())) {
            String json = "[" + data.getSubTaskList().getResponsibleRemark() + "]";
            ArrayList<ResponsibleRemarkBean> list2 = (ArrayList<ResponsibleRemarkBean>) JSON.parseArray(json, ResponsibleRemarkBean.class);
            if (list2 != null) {
                RecyclerViewUtils.initLiner(getActivity(), rvLocaleImg, R.layout.item_responsibility_content, list2, new OnGlobalListener() {
                    @Override
                    public <T> void logic(BaseViewHolder helper, List<T> mData, T item, BaseQuickAdapter mAdapter) {
                        ResponsibleRemarkBean resultsBean = (ResponsibleRemarkBean) item;

                        TextView tvCompany = helper.getView(R.id.tv_company);
                        TextView tvName = helper.getView(R.id.tv_name);
                        TextView tvHander = helper.getView(R.id.tv_header);
                        TextView tvContent = helper.getView(R.id.tv_content);
                        TextView tvScore = helper.getView(R.id.tv_score);
                        TextView tvMoney = helper.getView(R.id.tv_money);

                        tvCompany.setText(resultsBean.getDepartmentName());
                        tvName.setText("责任人：" + resultsBean.getUserName());
                        tvHander.setText("领导：" + resultsBean.getLeaderName());
                        tvContent.setText(resultsBean.getRemark());
                        tvScore.setText(resultsBean.getScore() + "分");
                        tvMoney.setText(resultsBean.getMoney() + "元");


                    }
                }, new BaseQuickAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {

                    }
                }, null);
            }
        }
    }

}
