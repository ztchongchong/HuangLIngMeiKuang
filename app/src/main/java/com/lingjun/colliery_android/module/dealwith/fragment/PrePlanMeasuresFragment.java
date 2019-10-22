package com.lingjun.colliery_android.module.dealwith.fragment;


import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.blankj.utilcode.util.ToastUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lingjun.colliery_android.R;
import com.lingjun.colliery_android.base.BaseFragment;
import com.lingjun.colliery_android.base.OnGlobalListener;
import com.lingjun.colliery_android.bean.HiddenDangerDetailsBean;
import com.lingjun.colliery_android.utils.RecyclerViewUtils;

import java.util.List;

import butterknife.BindView;

/**
 * 作者: lihuan
 * 时间: 2018/11/20 14:47
 * 说明: 治理方案 预案措施 资金方案
 */
public class PrePlanMeasuresFragment extends BaseFragment {
    private static final String ARG_PARAM1 = "param1";

    @BindView(R.id.tv_scheme_type)
    TextView tvSchemeType;
    @BindView(R.id.ll_scheme_type)
    LinearLayout llSchemeType;
    @BindView(R.id.view_scheme_type)
    View viewSchemeType;
    @BindView(R.id.tv_scheme_content)
    TextView tvSchemeContent;
    @BindView(R.id.rv_related_file)
    RecyclerView rvRelatedFile;

    private HiddenDangerDetailsBean mParam;
    private int type = 0;

    public PrePlanMeasuresFragment() {
    }

    public static PrePlanMeasuresFragment newInstance(HiddenDangerDetailsBean dangerDetailsBean, int param) {
        PrePlanMeasuresFragment fragment = new PrePlanMeasuresFragment();
        fragment.mParam = dangerDetailsBean;
        fragment.type = param;
//        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
//        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int setLayout(LayoutInflater inflater) {
        return R.layout.fragment_pre_plan_measures;
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
        if (type == 0) {
            llSchemeType.setVisibility(View.VISIBLE);
            viewSchemeType.setVisibility(View.VISIBLE);
            if (data.getSubTaskList() != null) {
                tvSchemeType.setText("1".equals(data.getSubTaskList().getSolutionType()) ? "治理方案" : "整改方案");
                tvSchemeContent.setText(data.getSubTaskList().getSolutionContent());
            }

            RecyclerViewUtils.initLiner(getActivity(), rvRelatedFile, R.layout.item_deal_with_file, data.getFafileList(), new OnGlobalListener() {
                @Override
                public <T> void logic(BaseViewHolder helper, List<T> mData, T item, BaseQuickAdapter mAdapter) {
                    HiddenDangerDetailsBean.DataBean.YsfileListBean resultsBean = (HiddenDangerDetailsBean.DataBean.YsfileListBean) item;

                    TextView imgName = helper.getView(R.id.tv_img_name);

                    //图片名称
                    imgName.setText(resultsBean.getFileName());


                }
            }, new BaseQuickAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                    HiddenDangerDetailsBean.DataBean.YsfileListBean resultsBean = (HiddenDangerDetailsBean.DataBean.YsfileListBean) adapter.getData().get(position);
                    ToastUtils.showShort(resultsBean.getFileName());
                }
            }, null);

            //fafileList
        } else if (type == 1) {
            llSchemeType.setVisibility(View.GONE);
            viewSchemeType.setVisibility(View.GONE);
            if (data.getSubTaskList() != null) {
                tvSchemeContent.setText(data.getSubTaskList().getSolutionPlan());
            }
            //jjfileList
            RecyclerViewUtils.initLiner(getActivity(), rvRelatedFile, R.layout.item_deal_with_file, data.getJjfileList(), new OnGlobalListener() {
                @Override
                public <T> void logic(BaseViewHolder helper, List<T> mData, T item, BaseQuickAdapter mAdapter) {
                    HiddenDangerDetailsBean.DataBean.YsfileListBean resultsBean = (HiddenDangerDetailsBean.DataBean.YsfileListBean) item;

                    TextView imgName = helper.getView(R.id.tv_img_name);

                    //图片名称
                    imgName.setText(resultsBean.getFileName());


                }
            }, new BaseQuickAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                    HiddenDangerDetailsBean.DataBean.YsfileListBean resultsBean = (HiddenDangerDetailsBean.DataBean.YsfileListBean) adapter.getData().get(position);
                    ToastUtils.showShort(resultsBean.getFileName());
                }
            }, null);
        } else {
            llSchemeType.setVisibility(View.GONE);
            viewSchemeType.setVisibility(View.GONE);
            if (data.getSubTaskList() != null) {
                tvSchemeContent.setText(data.getSubTaskList().getSolutionFunding());
            }
            //zjfileList
            RecyclerViewUtils.initLiner(getActivity(), rvRelatedFile, R.layout.item_deal_with_file, data.getZjfileList(), new OnGlobalListener() {
                @Override
                public <T> void logic(BaseViewHolder helper, List<T> mData, T item, BaseQuickAdapter mAdapter) {
                    HiddenDangerDetailsBean.DataBean.YsfileListBean resultsBean = (HiddenDangerDetailsBean.DataBean.YsfileListBean) item;

                    TextView imgName = helper.getView(R.id.tv_img_name);

                    //图片名称
                    imgName.setText(resultsBean.getFileName());


                }
            }, new BaseQuickAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                    HiddenDangerDetailsBean.DataBean.YsfileListBean resultsBean = (HiddenDangerDetailsBean.DataBean.YsfileListBean) adapter.getData().get(position);
                    ToastUtils.showShort(resultsBean.getFileName());
                }
            }, null);
        }

    }
}
