package com.lingjun.colliery_android.module.dealwith.fragment;


import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.blankj.utilcode.util.LogUtils;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lingjun.colliery_android.R;
import com.lingjun.colliery_android.base.BaseFragment;
import com.lingjun.colliery_android.base.BaseLinkList;
import com.lingjun.colliery_android.base.OnGlobalListener;
import com.lingjun.colliery_android.bean.HiddenDangerDetailsBean;
import com.lingjun.colliery_android.bean.HiddenDangersDetailsBean;
import com.lingjun.colliery_android.bean.ImplementedBean;
import com.lingjun.colliery_android.utils.DateUtil;
import com.lingjun.colliery_android.utils.RecyclerViewUtils;

import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import cc.shinichi.library.ImagePreview;

/**
 * 作者: lihuan
 * 时间: 2018/11/23 13:54
 * 说明: 验收情况
 */
public class AcceptanceFragment extends BaseFragment {
    @BindView(R.id.et_scheme_content)
    TextView etSchemeContent;
    @BindView(R.id.rv_related_file)
    RecyclerView rvRelatedFile;

    private HiddenDangerDetailsBean mParam;


    public AcceptanceFragment() {
    }

    public static AcceptanceFragment newInstance(HiddenDangerDetailsBean dangerDetailsBean) {
        AcceptanceFragment fragment = new AcceptanceFragment();
        fragment.mParam = dangerDetailsBean;
//        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
//        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int setLayout(LayoutInflater inflater) {
        return R.layout.fragment_acceptance;
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
    private void dataDisplay(final HiddenDangerDetailsBean.DataBean data) {
        if (data.getSubTaskList() != null) {
            etSchemeContent.setText(data.getSubTaskList().getAcceptReason());
        }

        if (data.getYsfileList() != null) {
            LogUtils.e("data.getYsfileList().size==>" + data.getYsfileList().size());
            RecyclerViewUtils.initGridNoSc(getActivity(), rvRelatedFile, R.layout.item_image, data.getYsfileList(), new OnGlobalListener() {
                @Override
                public <T> void logic(BaseViewHolder helper, List<T> mData, T item, BaseQuickAdapter mAdapter) {
                    HiddenDangerDetailsBean.DataBean.YsfileListBean bean = (HiddenDangerDetailsBean.DataBean.YsfileListBean) item;

                    ImageView iv_icon = helper.getView(R.id.iv_icon);
                    TextView tv_jiahao = helper.getView(R.id.tv_jiahao);
                    ImageView iv_delete = helper.getView(R.id.iv_delete);
                    tv_jiahao.setVisibility(View.GONE);
                    iv_delete.setVisibility(View.GONE);

                    if (!TextUtils.isEmpty(bean.getUrl())) {
                        Glide.with(getActivity()).load(BaseLinkList.Base_Url + "?" + BaseLinkList.apiurl + "=" + BaseLinkList.coal_mine + bean.getUrl()).into(iv_icon);
                    }
                }
            }, new BaseQuickAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(final BaseQuickAdapter adapter, View view, final int position) {
                    HiddenDangerDetailsBean.DataBean.YsfileListBean bean = (HiddenDangerDetailsBean.DataBean.YsfileListBean) adapter.getData().get(position);
                    ImagePreview
                            .getInstance()
                            // 上下文，必须是activity，不需要担心内存泄漏，本框架已经处理好；
                            .setContext(getActivity())
                            // 有三种设置数据集合的方式，根据自己的需求进行选择：
                            // 第一步生成的imageInfo List
//                                          .setImageInfoList(imageInfoList)
                            // 直接传url List
                            .setImageList(Collections.singletonList(BaseLinkList.Base_Url + "?" + BaseLinkList.apiurl + "=" + BaseLinkList.coal_mine + bean.getUrl()))
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

}
