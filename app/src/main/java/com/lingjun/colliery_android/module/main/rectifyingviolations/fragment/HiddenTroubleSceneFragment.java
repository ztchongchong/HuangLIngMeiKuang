package com.lingjun.colliery_android.module.main.rectifyingviolations.fragment;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.blankj.utilcode.util.LogUtils;
import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lingjun.colliery_android.R;
import com.lingjun.colliery_android.base.BaseFragment;
import com.lingjun.colliery_android.base.BaseLinkList;
import com.lingjun.colliery_android.base.OnGlobalListener;
import com.lingjun.colliery_android.bean.HiddenDangerDetailsBean;
import com.lingjun.colliery_android.utils.FastJsonTools;
import com.lingjun.colliery_android.utils.RecyclerViewUtils;
import com.lingjun.colliery_android.utils.retrofit.BaseSubscriber;
import com.lingjun.colliery_android.utils.retrofit.ExceptionHandle;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import cc.shinichi.library.ImagePreview;


/**
 * 现场治理
 * Created by nefa on 2018/11/20.
 */

public class HiddenTroubleSceneFragment extends BaseFragment {

    private TextView tv_yinhuandengji;//隐患等级
    private TextView tv_zerendanwei;//责任单位
    private TextView tv_koufen;//扣分
    private TextView tv_fajin;//罚金
    private TextView tv_zhenggaifangan; //整改方案(灰)
    private TextView tv_content;//方案内容
    private RecyclerView rv_image_list;//图片处理
    private RecyclerView rv_image_yanshou_list;//验收人图片
    private TextView tv_jishuyuan;//技术员
    private TextView tv_zerenren;//责任人
    private TextView tv_yanshouren;//验收人
    private TextView tv_jujueliyou;//拒绝理由
    private TextView tv_chuliren;//拒绝人
    private TextView tv_yanshouren_content;//验收人书写的内容
    private RelativeLayout rl_root;//驳回布局
    private TextView tv_auditor;
    private TextView tv_yanshoudanwei;
    private TextView tv_Superiorleader;//上级领导

    private TextView tv_Personliable;
    private TextView tv_classtime;

    @Override
    protected int setLayout(LayoutInflater inflater) {
        return R.layout.fragment_hidden_trouble;
    }


    @Override
    protected void init(Bundle savedInstanceState) {
        tv_yinhuandengji = mRootView.findViewById(R.id.tv_yinhuandengji);
        tv_zerendanwei = mRootView.findViewById(R.id.tv_zerendanwei);
        tv_koufen = mRootView.findViewById(R.id.tv_koufen);
        tv_fajin = mRootView.findViewById(R.id.tv_fajin);
        tv_zhenggaifangan = mRootView.findViewById(R.id.tv_zhenggaifangan);
        tv_content = mRootView.findViewById(R.id.tv_content);
        rv_image_list = mRootView.findViewById(R.id.rv_image_list);
        tv_yanshouren_content = mRootView.findViewById(R.id.tv_yanshouren_content);
        rv_image_yanshou_list = mRootView.findViewById(R.id.rv_image_yanshou_list);
        tv_jishuyuan = mRootView.findViewById(R.id.tv_jishuyuan);
        tv_zerenren = mRootView.findViewById(R.id.tv_zerenren);
        tv_yanshouren = mRootView.findViewById(R.id.tv_yanshouren);
        tv_jujueliyou = mRootView.findViewById(R.id.tv_jujueliyou);
        tv_chuliren = mRootView.findViewById(R.id.tv_chuliren);
        rl_root = mRootView.findViewById(R.id.rl_root);
        tv_auditor = mRootView.findViewById(R.id.tv_auditor);
        tv_yanshoudanwei = mRootView.findViewById(R.id.tv_yanshoudanwei);
        tv_Personliable = mRootView.findViewById(R.id.tv_Personliable);
        tv_classtime = mRootView.findViewById(R.id.tv_classtime);
        tv_Superiorleader = mRootView.findViewById(R.id.tv_Superiorleader);
        refreshView();
    }

    @Override
    protected BaseRefreshLoadMoreInterface setRefreshLoadMoreListener() {
        return null;
    }

    //刷新
    private void refreshView() {
        String taskMainId = getArguments().getString("taskMainId");
        String taskId = getArguments().getString("taskId");
        String state = getArguments().getString("state");
        if (state.equals("3")) {
            tv_jujueliyou.setVisibility(View.VISIBLE);
            tv_chuliren.setVisibility(View.VISIBLE);
            rl_root.setVisibility(View.VISIBLE);
        } else {
            tv_jujueliyou.setVisibility(View.GONE);
            tv_chuliren.setVisibility(View.GONE);
            rl_root.setVisibility(View.GONE);
        }

        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("mainid", taskMainId);
        hashMap.put("id", taskId);
        hashMap.put(BaseLinkList.apiurl, BaseLinkList.coal_mine + BaseLinkList.hidden_details);
        mRetrofit.JsonToColliery(BaseLinkList.Base_Url, hashMap, new BaseSubscriber() {
            @Override
            public void onError(ExceptionHandle.ResponeThrowable e) {
                LogUtils.e("隐患错误->>" + e.getMessage());
                if (null != refreshLayout) {
                    refreshLayout.finishRefresh();
                    refreshLayout.finishLoadMore();
                }
            }

            @Override
            public void onSuccess(JSONObject jsonObject) {
                LogUtils.e("隐患信息单->>" + jsonObject.toString());
                //隐患信息
                final HiddenDangerDetailsBean troubleSceneBean = FastJsonTools.getBean(jsonObject.toString(), HiddenDangerDetailsBean.class);
                HiddenDangerDetailsBean.DataBean.SubTaskListBean subTaskList = troubleSceneBean.getData().getSubTaskList();
                ArrayList<HiddenDangerDetailsBean.DataBean.FafileListBean> fafileList = (ArrayList<HiddenDangerDetailsBean.DataBean.FafileListBean>) troubleSceneBean.getData().getFafileList();//方案图片
                ArrayList<HiddenDangerDetailsBean.DataBean.YsfileListBean> ysfileList = (ArrayList<HiddenDangerDetailsBean.DataBean.YsfileListBean>) troubleSceneBean.getData().getYsfileList();//验收图片

                tv_yinhuandengji.setText("" + subTaskList.getTroubleLevel());
                tv_zerendanwei.setText("" + subTaskList.getResponsibleDepartmentName());
                tv_koufen.setText("" + subTaskList.getResponsibleScore());
                tv_fajin.setText("" + subTaskList.getResponsibleMoney());
                tv_content.setText("" + subTaskList.getSolutionContent());//方案内容
                tv_yanshouren_content.setText("" + subTaskList.getAcceptReason());//验收内容
                if (TextUtils.isEmpty(subTaskList.getTechnicianName())) {
                    tv_jishuyuan.setText("");
                } else {
                    tv_jishuyuan.setText("" + subTaskList.getTechnicianName());
                }
                tv_zerenren.setText("" + subTaskList.getResponsibleUserName());
                tv_yanshouren.setText("" + subTaskList.getAcceptorName());//验收人
                tv_yanshoudanwei.setText("" + subTaskList.getAcceptanceDepartmentsName());//验收单位
//                tv_jujueliyou.setText("拒绝事由: "+subTaskList.getApproveRemark());//驳回理由
                tv_chuliren.setText("" + subTaskList.getApproverName());//驳回人
                tv_auditor.setText("" + subTaskList.getApproverName());

                tv_Superiorleader.setText("" + subTaskList.getResponsibleLeaderName());//上级领导
                if (subTaskList.getResponsiblePersonLeadership() != null) {
                    tv_Personliable.setText("" + subTaskList.getResponsiblePersonLeadership());//责任人
                } else {
                    tv_Personliable.setText("");//责任人
                }

                tv_classtime.setText(subTaskList.getHazardDivisions() + "点");//班次
                //方案图片
                RecyclerViewUtils.initLinerNoSc(getActivity(), rv_image_list, R.layout.item_image, fafileList, new OnGlobalListener() {
                    @Override
                    public <T> void logic(BaseViewHolder helper, List<T> mData, T item, BaseQuickAdapter mAdapter) {
                        HiddenDangerDetailsBean.DataBean.FafileListBean fafileListBean = (HiddenDangerDetailsBean.DataBean.FafileListBean) item;
                        ImageView iv_icon = helper.getView(R.id.iv_icon);
                        ImageView iv_delete = helper.getView(R.id.iv_delete);
                        TextView tv_jiahao = helper.getView(R.id.tv_jiahao);
                        iv_delete.setVisibility(View.GONE);
                        tv_jiahao.setVisibility(View.GONE);
                        LogUtils.e("加载方案图->>" + BaseLinkList.Base_Url + "?" + BaseLinkList.apiurl + "=" + BaseLinkList.coal_mine + fafileListBean.getUrl());
                        Glide.with(getActivity()).load(BaseLinkList.Base_Url + "?" + BaseLinkList.apiurl + "=" + BaseLinkList.coal_mine + fafileListBean.getUrl()).into(iv_icon);
                    }
                }, new BaseQuickAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                        HiddenDangerDetailsBean.DataBean.FafileListBean fafileListBean = (HiddenDangerDetailsBean.DataBean.FafileListBean) adapter.getData().get(position);
                        ImagePreview
                                .getInstance()
                                // 上下文，必须是activity，不需要担心内存泄漏，本框架已经处理好；
                                .setContext(getActivity())
                                // 有三种设置数据集合的方式，根据自己的需求进行选择：
                                // 第一步生成的imageInfo List
//                                          .setImageInfoList(imageInfoList)
                                // 直接传url List
                                .setImageList(Collections.singletonList(BaseLinkList.Base_Url + "?" + BaseLinkList.apiurl + "=" + BaseLinkList.coal_mine + fafileListBean.getUrl()))
                                // 只有一张图片的情况，可以直接传入这张图片的url
                                //.setImage(String image)
                                // 是否显示下载按钮，在页面右下角。默认显示
                                .setShowDownButton(false)
                                // 是否显示关闭页面按钮，在页面左下角。默认不显示
                                .setShowCloseButton(true)
                                // 开启预览
                                .start();
                    }
                }, null);

                //验收图片
                RecyclerViewUtils.initLinerNoSc(getActivity(), rv_image_yanshou_list, R.layout.item_image, ysfileList, new OnGlobalListener() {
                    @Override
                    public <T> void logic(BaseViewHolder helper, List<T> mData, T item, BaseQuickAdapter mAdapter) {
                        HiddenDangerDetailsBean.DataBean.YsfileListBean ysfileListBean = (HiddenDangerDetailsBean.DataBean.YsfileListBean) item;
                        ImageView iv_icon = helper.getView(R.id.iv_icon);
                        ImageView iv_delete = helper.getView(R.id.iv_delete);
                        TextView tv_jiahao = helper.getView(R.id.tv_jiahao);
                        iv_delete.setVisibility(View.GONE);
                        tv_jiahao.setVisibility(View.GONE);
                        LogUtils.e("加载验收图->>" + BaseLinkList.Base_Url + "?" + BaseLinkList.apiurl + "=" + BaseLinkList.coal_mine + ysfileListBean.getUrl());
                        Glide.with(getActivity()).load(BaseLinkList.Base_Url + "?" + BaseLinkList.apiurl + "=" + BaseLinkList.coal_mine + ysfileListBean.getUrl()).into(iv_icon);
                    }
                }, new BaseQuickAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                        HiddenDangerDetailsBean.DataBean.YsfileListBean ysfileListBean = (HiddenDangerDetailsBean.DataBean.YsfileListBean) adapter.getData().get(position);
                        ImagePreview
                                .getInstance()
                                // 上下文，必须是activity，不需要担心内存泄漏，本框架已经处理好；
                                .setContext(getActivity())
                                // 有三种设置数据集合的方式，根据自己的需求进行选择：
                                // 第一步生成的imageInfo List
//                                          .setImageInfoList(imageInfoList)
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
                }, null);


                if (null != refreshLayout) {
                    refreshLayout.finishRefresh();
                    refreshLayout.finishLoadMore();
                }
            }
        });
    }
}
