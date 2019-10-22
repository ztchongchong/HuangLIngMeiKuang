package com.lingjun.colliery_android.module.dealwith.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.blankj.utilcode.util.ToastUtils;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lingjun.colliery_android.R;
import com.lingjun.colliery_android.base.BaseFragment;
import com.lingjun.colliery_android.base.BaseLinkList;
import com.lingjun.colliery_android.base.OnGlobalListener;
import com.lingjun.colliery_android.bean.HiddenDangerDetailsBean;
import com.lingjun.colliery_android.bean.UpLoadImageBean;
import com.lingjun.colliery_android.module.dealwith.activity.RectificationActivity;
import com.lingjun.colliery_android.module.dealwith.hiddendanger.activity.HiddenDangersHandleActivity;
import com.lingjun.colliery_android.module.dealwith.hiddendanger.activity.PhotoActivity;
import com.lingjun.colliery_android.module.dealwith.hiddendanger.activity.TimeLimitToBeStoredActivity;
import com.lingjun.colliery_android.utils.RecyclerViewUtils;

import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import cc.shinichi.library.ImagePreview;

/**
 * 作者: lihuan
 * 时间: 2018/11/17 17:44
 * 说明: 整改情况
 */
public class RectificationSituationFragment extends BaseFragment {

    /**
     * 方案类型
     */
    @BindView(R.id.tv_scheme_type)
    TextView tvSchemeType;
    /**
     * 方案内容
     */
    @BindView(R.id.tv_scheme_content)
    TextView tvSchemeContent;
    /**
     * 上传文件按钮
     */
    @BindView(R.id.btn_upload)
    Button btnUpload;
    /**
     * 文件列表
     */
    @BindView(R.id.rv_related_file)
    RecyclerView rvRelatedFile;

    private HiddenDangerDetailsBean mParam;

    public RectificationSituationFragment() {
    }

    public static RectificationSituationFragment newInstance(HiddenDangerDetailsBean dangerDetailsBean) {
        RectificationSituationFragment fragment = new RectificationSituationFragment();
        fragment.mParam = dangerDetailsBean;
//        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected BaseRefreshLoadMoreInterface setRefreshLoadMoreListener() {
        return null;
    }

    @Override
    protected int setLayout(LayoutInflater inflater) {
        return R.layout.fragment_rectification_situation;
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
        if (data.getSubTaskList() != null) {
            tvSchemeType.setText("1".equals(data.getSubTaskList().getSolutionType()) ? "治理方案" : "整改方案");
            tvSchemeContent.setText(data.getSubTaskList().getSolutionContent());

            RecyclerViewUtils.initGridNoSc(getActivity(), rvRelatedFile, R.layout.item_image, data.getZgfileList(), new OnGlobalListener() {
                @Override
                public <T> void logic(BaseViewHolder helper, List<T> mData, T item, BaseQuickAdapter mAdapter) {
                    HiddenDangerDetailsBean.DataBean.ZgfileListBean resultsBean = (HiddenDangerDetailsBean.DataBean.ZgfileListBean) item;

                    ImageView iv_icon = helper.getView(R.id.iv_icon);
                    TextView tv_jiahao = helper.getView(R.id.tv_jiahao);
                    ImageView iv_delete = helper.getView(R.id.iv_delete);

                    if (TextUtils.isEmpty(resultsBean.getUrl())) {

                    } else {
                        tv_jiahao.setVisibility(View.GONE);
                        iv_delete.setVisibility(View.GONE);
                        RequestOptions options = new RequestOptions()
                                .override(100, 100)
                                .error(R.drawable.icon_biaozhunhua); // 加载失败的图片  
                        Glide.with(getActivity()).load(BaseLinkList.Base_Url+"?"+BaseLinkList.apiurl+"="+BaseLinkList.coal_mine + resultsBean.getUrl()).apply(options).into(iv_icon);
                        Log.e("整改情况的图片",BaseLinkList.Base_Url+"?"+BaseLinkList.apiurl+"="+BaseLinkList.coal_mine + resultsBean.getUrl());
                    }

//                    helper.addOnClickListener(R.id.iv_delete);

                }
            }, new BaseQuickAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                    HiddenDangerDetailsBean.DataBean.ZgfileListBean resultsBean = (HiddenDangerDetailsBean.DataBean.ZgfileListBean) adapter.getData().get(position);
                    ImagePreview
                            .getInstance()
                            // 上下文，必须是activity，不需要担心内存泄漏，本框架已经处理好；
                            .setContext(getActivity())
                            // 有三种设置数据集合的方式，根据自己的需求进行选择：
                            // 第一步生成的imageInfo List
//                        .setImageInfoList(imageInfoList)
                            // 直接传url List
                            .setImageList(Collections.singletonList(BaseLinkList.Base_Url+"?"+BaseLinkList.apiurl+"="+BaseLinkList.coal_mine + resultsBean.getUrl()))
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

    @OnClick(R.id.btn_upload)
    public void onBtnUploadClicked() {
    }

}
