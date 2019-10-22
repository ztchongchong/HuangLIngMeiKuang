package com.lingjun.colliery_android.module.dealwith.fragment;

import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lingjun.colliery_android.R;
import com.lingjun.colliery_android.base.BaseFragment;
import com.lingjun.colliery_android.base.BaseLinkList;
import com.lingjun.colliery_android.base.OnGlobalListener;
import com.lingjun.colliery_android.bean.ImplementedBean;
import com.lingjun.colliery_android.module.dealwith.activity.RectificationActivity;
import com.lingjun.colliery_android.utils.FastJsonTools;
import com.lingjun.colliery_android.utils.RecyclerViewUtils;
import com.lingjun.colliery_android.utils.retrofit.BaseSubscriber;
import com.lingjun.colliery_android.utils.retrofit.ExceptionHandle;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import cc.shinichi.library.ImagePreview;

/**
 * 作者: zengtao
 * 时间: 2018/12/4  16:17.
 * 注释: 管控现场情况
 */
public class ControlSituationFragment extends BaseFragment {
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
    TextView tvRiskcontrolSourceDescription;//风险描述1
    @BindView(R.id.tv_riskcontrolDescription)
    TextView tvRiskcontrolDescription;//风险描述2
    @BindView(R.id.rl_view)
    RecyclerView rlView;

    private String taskId = "";
    private int measuresId = 0;


    private ImageView delete;
    private TextView title;
    private EditText dialog_edit;
    private TextView tv_cancel;
    private TextView tv_comfirm;

    private View dialogview;
    private AlertDialog dialog;
    private ImplementedBean implemented;

    public ControlSituationFragment() {

    }

    public static ControlSituationFragment newInstance(ImplementedBean implementedBean) {
//        Bundle args = new Bundle();
//        setArguments(args);
        ControlSituationFragment fragment = new ControlSituationFragment();
        fragment.implemented = implementedBean;
        return fragment;
    }


    @Override
    protected int setLayout(LayoutInflater inflater) {
        return R.layout.fragment_control_situation;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        if (implemented != null && implemented.getData() != null) {
            dataDisplay(implemented.getData());
        }
    }

    /**
     * 数据展示
     *
     * @param dataBean
     */
    private void dataDisplay(ImplementedBean.DataBean dataBean) {
        tvPublisherName.setText(dataBean.getRiskcontrolTrouble().getPublisherName());//录入人
        String t1 = new SimpleDateFormat("yyyy-MM-dd").format(new Date(dataBean.getImplement().getCheckdate()));
        tvPublisherTime.setText(t1);//管控日期
        tvRiskcontrolAreaName.setText(dataBean.getRiskcontrolTrouble().getRiskcontrolAreaName());//位置
        tvPlanName.setText(dataBean.getRiskcontrolTrouble().getPlanName());//所属计划
        tvRiskcontrolLevelName.setText(dataBean.getRiskcontrolTrouble().getRiskcontrolLevelName());//等级
        String fengxian1 = dataBean.getRiskcontrolTrouble().getRiskcontrolSourceDescription().replace("&ldquo;", "“").replace("&rdquo;", "”");
        tvRiskcontrolSourceDescription.setText(fengxian1);//风险描述1
        tvRiskcontrolDescription.setText(dataBean.getRiskcontrolTrouble().getRiskcontrolDescription());//风险描述2
        measuresId = dataBean.getRiskcontrolTrouble().getMeasures().getId();
        //图片列表
        final ArrayList<ImplementedBean.DataBean.ImglistBean> disobeytaskdoc = (ArrayList<ImplementedBean.DataBean.ImglistBean>) dataBean.getImglist();
        //填充图片
        RecyclerViewUtils.initGridNoSc(getActivity(), rlView, R.layout.item_image, disobeytaskdoc, new OnGlobalListener() {
            @Override
            public <T> void logic(BaseViewHolder helper, List<T> mData, T item, BaseQuickAdapter mAdapter) {

                ImplementedBean.DataBean.ImglistBean disobeytaskdocBean = (ImplementedBean.DataBean.ImglistBean) item;
                ImageView iv_icon = helper.getView(R.id.iv_icon);
                TextView tv_jiahao = helper.getView(R.id.tv_jiahao);
                ImageView iv_delete = helper.getView(R.id.iv_delete);
                tv_jiahao.setVisibility(View.GONE);
                iv_delete.setVisibility(View.GONE);

                if (!TextUtils.isEmpty(disobeytaskdocBean.getUrl())) {
                    Glide.with(getActivity()).load(BaseLinkList.Base_Url + "?" + BaseLinkList.apiurl + "=" + BaseLinkList.coal_mine + disobeytaskdocBean.getUrl()).into(iv_icon);
                    Log.e("黄泉买骨人", BaseLinkList.Base_Url + "?" + BaseLinkList.apiurl + "=" + BaseLinkList.coal_mine + disobeytaskdocBean.getUrl());
                }

            }
        }, new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                ImplementedBean.DataBean.ImglistBean imglistBean = (ImplementedBean.DataBean.ImglistBean) adapter.getData().get(position);
                ImagePreview
                        .getInstance()
                        // 上下文，必须是activity，不需要担心内存泄漏，本框架已经处理好；
                        .setContext(getActivity())
                        // 有三种设置数据集合的方式，根据自己的需求进行选择：
                        // 第一步生成的imageInfo List
//                                          .setImageInfoList(imageInfoList)
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


    @Override
    protected BaseRefreshLoadMoreInterface setRefreshLoadMoreListener() {
        return null;
    }
}
