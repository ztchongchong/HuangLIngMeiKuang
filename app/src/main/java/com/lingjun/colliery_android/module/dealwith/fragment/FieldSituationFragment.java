package com.lingjun.colliery_android.module.dealwith.fragment;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
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
import com.lingjun.colliery_android.bean.UpLoadImageBean;
import com.lingjun.colliery_android.module.dealwith.hiddendanger.activity.HiddenDangersDetailsActivity;
import com.lingjun.colliery_android.utils.DateUtil;
import com.lingjun.colliery_android.utils.RecyclerViewUtils;

import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import cc.shinichi.library.ImagePreview;

/**
 * 作者: lihuan
 * 时间: 2018/11/17 14:36
 * 说明: 现场情况
 */
public class FieldSituationFragment extends BaseFragment {
    @BindView(R.id.tv_write_time)
    TextView tvWriteTime;
    @BindView(R.id.tv_discovery_person)
    TextView tvDiscoveryPerson;
    @BindView(R.id.tv_discovery_position)
    TextView tvDiscoveryPosition;
    @BindView(R.id.tv_assess_standard)
    TextView tvAssessStandard;
    @BindView(R.id.tv_hidden_danger_content)
    TextView tvHiddenDangerContent;
    @BindView(R.id.tv_dispose_time)
    TextView tvDisposeTime;
    @BindView(R.id.tv_dispose_person)
    TextView tvDisposePerson;
    @BindView(R.id.tv_dispose_desc)
    TextView tvDisposeDesc;
    @BindView(R.id.rv_locale_img)
    RecyclerView rvLocaleImg;

    private HiddenDangerDetailsBean mParam;

    private TextView tv_clauseConsequence;

    public FieldSituationFragment() {
    }

    public static FieldSituationFragment newInstance(HiddenDangerDetailsBean dangerDetailsBean) {
        FieldSituationFragment fragment = new FieldSituationFragment();
        fragment.mParam = dangerDetailsBean;
//        Bundle args = new Bundle();
//        args.put(ARG_PARAM1, param1);
//        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected BaseRefreshLoadMoreInterface setRefreshLoadMoreListener() {
        return null;
    }

    @Override
    protected int setLayout(LayoutInflater inflater) {
        return R.layout.fragment_field_situation;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        tv_clauseConsequence = mRootView.findViewById(R.id.tv_clauseConsequence);
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
        if (data.getMaintask() != null) {
            tvWriteTime.setText(DateUtil.getStringByFormat(data.getMaintask().getCreateTime(), "yyyy-MM-dd HH:mm"));
            tvDiscoveryPerson.setText(data.getMaintask().getUserName());
            tvDiscoveryPosition.setText(data.getMaintask().getAreaName());
            tvAssessStandard.setText(data.getMaintask().getClauseDescription());
            if (TextUtils.isEmpty(data.getMaintask().getClauseConsequence())) {
                tv_clauseConsequence.setText("隐患结果：无");
            } else {
                if (data.getMaintask().getClauseConsequence().equals("null")) {
                    tv_clauseConsequence.setText("隐患结果：无");
                } else {
                    tv_clauseConsequence.setText("隐患结果：" + data.getMaintask().getClauseConsequence());
                }
            }

        }
        if (data.getSubTaskList() != null) {
            tvHiddenDangerContent.setText("隐患描述：" + data.getSubTaskList().getSourceDescription());
            tvDisposePerson.setText("处理：" + data.getSubTaskList().getProcessorName());
            tvDisposeDesc.setText(data.getSubTaskList().getTroubleContent());
        }

        if (data.getListSubTaskimg() != null) {
            LogUtils.e("data.getListSubTaskimg().size==>" + data.getListSubTaskimg().size());
            RecyclerViewUtils.initGridNoSc(getActivity(), rvLocaleImg, R.layout.item_image, data.getListSubTaskimg(), new OnGlobalListener() {
                @Override
                public <T> void logic(BaseViewHolder helper, List<T> mData, T item, BaseQuickAdapter mAdapter) {
                    HiddenDangerDetailsBean.DataBean.ListSubTaskimgBean bean = (HiddenDangerDetailsBean.DataBean.ListSubTaskimgBean) item;
                    ImageView iv_icon = helper.getView(R.id.iv_icon);
                    TextView tv_jiahao = helper.getView(R.id.tv_jiahao);
                    ImageView iv_delete = helper.getView(R.id.iv_delete);

//                    if (TextUtils.isEmpty(bean.getUrl())) {
                    tv_jiahao.setVisibility(View.GONE);
                    iv_delete.setVisibility(View.GONE);
//                    } else {
//                        tv_jiahao.setVisibility(View.GONE);
//                    RequestOptions options = new RequestOptions()
//                            .placeholder(R.mipmap.ic_launcher)
//                            .error(R.mipmap.ic_launcher); // 加载失败的图片  
                    Glide.with(getActivity()).load(BaseLinkList.Base_Url + "?" + BaseLinkList.apiurl + "=" + BaseLinkList.coal_mine + bean.getUrl()).into(iv_icon);
                    Log.e("现场情况的图片", BaseLinkList.Base_Url + "?" + BaseLinkList.apiurl + "=" + BaseLinkList.coal_mine + bean.getUrl());
//                        iv_delete.setVisibility(View.VISIBLE);
//                    }

//                    helper.addOnClickListener(R.id.iv_delete);

                }
            }, new BaseQuickAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(final BaseQuickAdapter adapter, View view, final int position) {
                    HiddenDangerDetailsBean.DataBean.ListSubTaskimgBean ysfileListBean = (HiddenDangerDetailsBean.DataBean.ListSubTaskimgBean) adapter.getData().get(position);
                    ImagePreview
                            .getInstance()
                            // 上下文，必须是activity，不需要担心内存泄漏，本框架已经处理好；
                            .setContext(getActivity())
                            // 有三种设置数据集合的方式，根据自己的需求进行选择：
                            // 第一步生成的imageInfo List.setImageInfoList(imageInfoList)
                            // 直接传url List
                            .setImageList(Collections.singletonList(BaseLinkList.Base_Url + "?" + BaseLinkList.apiurl + "=" + BaseLinkList.coal_mine + ysfileListBean.getUrl()))
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
