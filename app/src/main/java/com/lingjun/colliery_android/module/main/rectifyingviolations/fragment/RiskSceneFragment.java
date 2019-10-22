package com.lingjun.colliery_android.module.main.rectifyingviolations.fragment;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lingjun.colliery_android.R;
import com.lingjun.colliery_android.base.BaseFragment;
import com.lingjun.colliery_android.base.BaseLinkList;
import com.lingjun.colliery_android.base.OnGlobalListener;
import com.lingjun.colliery_android.bean.HiddenDangerDetailsBean;
import com.lingjun.colliery_android.bean.RiskTrackingsBean;
import com.lingjun.colliery_android.module.dealwith.hiddendanger.activity.HiddenDangersDetailsActivity;
import com.lingjun.colliery_android.utils.RecyclerViewUtils;

import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import cc.shinichi.library.ImagePreview;

/**
 * 作者: zengtao
 * 时间: 2019/5/5  11:26.
 * 注释: 现场情况（风险）
 */
public class RiskSceneFragment extends BaseFragment {

    @BindView(R.id.tv_publisherName)
    TextView tvPublisherName;//录入人
    @BindView(R.id.tv_publisherTime)
    TextView tvPublisherTime;//管控日期
    @BindView(R.id.tv_riskcontrolAreaName)
    TextView tvRiskcontrolAreaName;//位置
    @BindView(R.id.tv_planName)
    TextView tvPlanName;//所属计划
    @BindView(R.id.tv_riskcontrolLevelName)
    TextView tvRiskcontrolLevelName;//等级
    @BindView(R.id.tv_riskcontrolSourceDescription)
    TextView tvRiskcontrolSourceDescription;//第一风险内容
    @BindView(R.id.tv_riskcontrolDescription)
    TextView tvRiskcontrolDescription;//第二风险内容
    @BindView(R.id.rl_view)
    RecyclerView rlView;
    private RiskTrackingsBean mParam;

    public RiskSceneFragment() {
    }

    public static RiskSceneFragment newInstance(RiskTrackingsBean riskTrackingsBean) {
        RiskSceneFragment fragment = new RiskSceneFragment();
        fragment.mParam = riskTrackingsBean;
        return fragment;
    }

    @Override
    protected int setLayout(LayoutInflater inflater) {
        return R.layout.fragment_control_situation;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        if (mParam != null && mParam.getData() != null) {
            dataDisplay(mParam.getData());
        }

    }

    /**
     * 数据展示
     *
     * @param data
     */
    private void dataDisplay(final RiskTrackingsBean.DataBean data) {
        if (null != data && null != data.getRiskcontrolTrouble()) {
            tvPublisherName.setText(data.getRiskcontrolTrouble().getPublisherName());//录入人
            String publisherTime = new SimpleDateFormat("yyyy-MM-dd").format(new Date(data.getRiskcontrolTrouble().getPublisherTime()));
            tvPublisherTime.setText(publisherTime);//管控日期
            tvRiskcontrolAreaName.setText(data.getRiskcontrolTrouble().getRiskcontrolAreaName());//位置
            tvPlanName.setText(data.getRiskcontrolTrouble().getPlanName());//所属计划
            tvRiskcontrolLevelName.setText(data.getRiskcontrolTrouble().getRiskcontrolLevelName());//等级
            String yiji = data.getRiskcontrolTrouble().getRiskcontrolSourceDescription().replace("&ldquo;", "“").replace("&rdquo;", "”");
            tvRiskcontrolSourceDescription.setText(yiji);//第一风险内容
            String erji = data.getRiskcontrolTrouble().getRiskcontrolSourceMeasures().replace("&ldquo;", "“").replace("&rdquo;", "”");
            tvRiskcontrolDescription.setText(erji);//第二风险内容
        }
        if (null != data.getImplementlist()) {
            RecyclerViewUtils.initGridNoSc(getActivity(), rlView, R.layout.item_image, data.getImglist(), new OnGlobalListener() {
                @Override
                public <T> void logic(BaseViewHolder helper, List<T> mData, T item, BaseQuickAdapter mAdapter) {

                    RiskTrackingsBean.DataBean.ImglistBean implementlistBean = (RiskTrackingsBean.DataBean.ImglistBean) item;
                    ImageView iv_icon = helper.getView(R.id.iv_icon);
                    TextView tv_jiahao = helper.getView(R.id.tv_jiahao);
                    ImageView iv_delete = helper.getView(R.id.iv_delete);
                    tv_jiahao.setVisibility(View.GONE);
                    iv_delete.setVisibility(View.GONE);

                    if (!TextUtils.isEmpty(implementlistBean.getUrl())) {
                        Glide.with(getActivity()).load(BaseLinkList.Base_Url + "?" + BaseLinkList.apiurl + "=" + BaseLinkList.coal_mine + implementlistBean.getUrl()).into(iv_icon);
                    }

                }
            }, new BaseQuickAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                    RiskTrackingsBean.DataBean.ImglistBean imglistBean = (RiskTrackingsBean.DataBean.ImglistBean) adapter.getData().get(position);
                    ImagePreview
                            .getInstance()
                            // 上下文，必须是activity，不需要担心内存泄漏，本框架已经处理好；
                            .setContext(getActivity())
                            // 有三种设置数据集合的方式，根据自己的需求进行选择：
                            // 第一步生成的imageInfo List
//                        .setImageInfoList(imageInfoList)
                            // 直接传url List
                            .setImageList(Collections.singletonList(BaseLinkList.Base_Url + "?" + BaseLinkList.apiurl + "=" + BaseLinkList.coal_mine + imglistBean.getUrl()))
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

    @Override
    protected BaseRefreshLoadMoreInterface setRefreshLoadMoreListener() {
        return null;
    }
}
