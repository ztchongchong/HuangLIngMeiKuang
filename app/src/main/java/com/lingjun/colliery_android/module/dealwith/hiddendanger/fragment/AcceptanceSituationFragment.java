package com.lingjun.colliery_android.module.dealwith.hiddendanger.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lingjun.colliery_android.R;
import com.lingjun.colliery_android.base.BaseFragment;
import com.lingjun.colliery_android.base.BaseLinkList;
import com.lingjun.colliery_android.base.OnGlobalListener;
import com.lingjun.colliery_android.bean.HiddenDangerDetailsBean;

import com.lingjun.colliery_android.utils.RecyclerViewUtils;


import java.util.ArrayList;
import java.util.Collections;

import java.util.List;

import cc.shinichi.library.ImagePreview;

/**
 * 验收情况
 * Created by nefa on 2018/11/22.
 */

public class AcceptanceSituationFragment extends BaseFragment {


    private HiddenDangerDetailsBean mData;
    private TextView tv_scheme_content;
    private RecyclerView rv_related_file;


    @Override
    protected int setLayout(LayoutInflater inflater) {
        return R.layout.fragment_acceptance_situation;
    }

    public static AcceptanceSituationFragment newInstance(HiddenDangerDetailsBean dangerDetailsBean) {
        AcceptanceSituationFragment fragment = new AcceptanceSituationFragment();
        fragment.mData = dangerDetailsBean;
//        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        tv_scheme_content = mRootView.findViewById(R.id.tv_scheme_content);
        rv_related_file = mRootView.findViewById(R.id.rv_related_file);
        refreshView();
    }

    @Override
    protected BaseRefreshLoadMoreInterface setRefreshLoadMoreListener() {
        return null;
    }

    //刷新View
    private void refreshView() {
        ArrayList<HiddenDangerDetailsBean.DataBean.YsfileListBean> ysfileList = mData.getData().getYsfileList();
        String a = "" + mData.getData().getSubTaskList().getAcceptReason();
        String b = a.substring(1).toString();
        tv_scheme_content.setText(b);
        RecyclerViewUtils.initGridNoSc(getActivity(), rv_related_file, R.layout.item_image, ysfileList, new OnGlobalListener() {
            @Override
            public <T> void logic(BaseViewHolder helper, List<T> mData, T item, BaseQuickAdapter mAdapter) {
                HiddenDangerDetailsBean.DataBean.YsfileListBean data = (HiddenDangerDetailsBean.DataBean.YsfileListBean) item;
                ImageView iv_icon = helper.getView(R.id.iv_icon);
                TextView tv_jiahao = helper.getView(R.id.tv_jiahao);
                ImageView iv_delete = helper.getView(R.id.iv_delete);
                tv_jiahao.setVisibility(View.GONE);
                iv_delete.setVisibility(View.GONE);

                if (!TextUtils.isEmpty(data.getUrl())) {
//                    Glide.with(getActivity()).load(BaseUrl + data.getUrl()).into(iv_icon);
                    Glide.with(getActivity()).load(BaseLinkList.Base_Url + "?" + BaseLinkList.apiurl + "=" + BaseLinkList.coal_mine + data.getUrl()).into(iv_icon);

                }

            }
        }, new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                HiddenDangerDetailsBean.DataBean.YsfileListBean resultsBean = (HiddenDangerDetailsBean.DataBean.YsfileListBean) adapter.getData().get(position);
//                Intent intent = new Intent(getActivity(), PhotoActivity.class);
//                intent.putExtra("photo", "" + resultsBean.getUrl());
//                startActivity(intent);
                // 最简单的调用，即可实现大部分需求，如需定制，可参考下一步的自定义代码

                ImagePreview
                        .getInstance()
                        // 上下文，必须是activity，不需要担心内存泄漏，本框架已经处理好；
                        .setContext(getActivity())
                        // 有三种设置数据集合的方式，根据自己的需求进行选择：
                        // 第一步生成的imageInfo List
//                        .setImageInfoList(imageInfoList)
                        // 直接传url List
                        .setImageList(Collections.singletonList(BaseLinkList.Base_Url + "?" + BaseLinkList.apiurl + "=" + BaseLinkList.coal_mine + resultsBean.getUrl()))
                        // 只有一张图片的情况，可以直接传入这张图片的url
                        //.setImage(String image)
                        // 是否显示下载按钮，在页面右下角。默认显示
                        .setShowDownButton(false)
                        // 是否显示关闭页面按钮，在页面左下角。默认不显示
                        .setShowCloseButton(true)
                        // 开启预览
                        .start();
            }
        }, 4, null);
    }
}
