package com.lingjun.colliery_android.module.main.rectifyingviolations.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.blankj.utilcode.util.LogUtils;
import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lingjun.colliery_android.R;
import com.lingjun.colliery_android.base.BaseFragment;
import com.lingjun.colliery_android.base.BaseLinkList;
import com.lingjun.colliery_android.base.OnGlobalListener;
import com.lingjun.colliery_android.bean.DisobeyInfoBean;
import com.lingjun.colliery_android.module.main.rectifyingviolations.RectifyingViolationsActivity;
import com.lingjun.colliery_android.utils.FastJsonTools;
import com.lingjun.colliery_android.utils.RecyclerViewUtils;
import com.lingjun.colliery_android.utils.ToastUtils;
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
 * 预览处罚单
 * Created by nefa on 2018/11/18.
 */

public class PreviewPunishmentFragment extends BaseFragment {

    private TextView tv_number;//编号
    private TextView tv_zeren;//责任人
    private TextView tv_leader;//领导
    private TextView tv_jingjichufa;//经济处罚
    private TextView tv_xuexi;//学习
    private TextView tv_time;//时间
    private TextView tv_auditor;//审核人
    private TextView tv_bianzhi;//编制人
    private TextView tv_content;//描述
    private TextView tv_shensu;//是否可申诉
    private RecyclerView rv_img_list;//图片
    private RecyclerView rv_img_list1;//图片
    private Button btn_complete;//确定
    private LinearLayout ll_bohui_root;
    private TextView tv_bohui;
    private TextView tv_sanweren;
    private TextView tv_banci;
    private TextView tv_quyu;
    private String taskId;
    private String state;
    private String type;//

    private LinearLayout ll_zidingyi;
    private ImageView iv_chengdu;
    private TextView tv_text;
    @Override
    protected int setLayout(LayoutInflater inflater) {
        return R.layout.fragment_preview_punishment;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        tv_number = mRootView.findViewById(R.id.tv_number);
        tv_zeren = mRootView.findViewById(R.id.tv_zeren);
        tv_leader = mRootView.findViewById(R.id.tv_leader);
        tv_jingjichufa = mRootView.findViewById(R.id.tv_jingjichufa);
        tv_xuexi = mRootView.findViewById(R.id.tv_xuexi);
        tv_time = mRootView.findViewById(R.id.tv_time);
        tv_auditor = mRootView.findViewById(R.id.tv_auditor);
        tv_bianzhi = mRootView.findViewById(R.id.tv_bianzhi);
        rv_img_list = mRootView.findViewById(R.id.rv_img_list);
        rv_img_list1 = mRootView.findViewById(R.id.rv_img_list1);
        tv_content = mRootView.findViewById(R.id.tv_content);
        tv_shensu = mRootView.findViewById(R.id.tv_shensu);
        btn_complete = mRootView.findViewById(R.id.btn_complete);
        ll_bohui_root = mRootView.findViewById(R.id.ll_bohui_root);
        tv_bohui = mRootView.findViewById(R.id.tv_bohui);

        ll_zidingyi = mRootView.findViewById(R.id.ll_zidingyi);
        iv_chengdu = mRootView.findViewById(R.id.iv_chengdu);
        tv_text = mRootView.findViewById(R.id.tv_text);

        refreshView();
    }


    @Override
    protected BaseRefreshLoadMoreInterface setRefreshLoadMoreListener() {
        return null;
    }

    //刷新view
    private void refreshView() {
        taskId = getArguments().getString("taskId");
        state = getArguments().getString("state");
        type = getArguments().getString("type");

        if (!TextUtils.isEmpty(taskId)) {
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("id", taskId);
            hashMap.put(BaseLinkList.apiurl, BaseLinkList.coal_mine + BaseLinkList.disobeyinfo);
            mRetrofit.JsonToColliery(BaseLinkList.Base_Url, hashMap, new BaseSubscriber() {
                @Override
                public void onError(ExceptionHandle.ResponeThrowable e) {
                    if (null != refreshLayout) {
                        refreshLayout.finishLoadMore();
                        refreshLayout.finishRefresh();
                    }
                }

                @Override
                public void onSuccess(JSONObject jsonObject) {
                    LogUtils.e("三违单信息->>" + jsonObject.toString());
                    final DisobeyInfoBean disobeyInfoBean = FastJsonTools.getBean(jsonObject.toString(), DisobeyInfoBean.class);
                    //三违单信息
                    DisobeyInfoBean.DataBean.DisobeytaskBean disobeytask = disobeyInfoBean.getData().getDisobeytask();
                    //三违单图片列表
                    ArrayList<DisobeyInfoBean.DataBean.DisobeytaskdocBean> disobeytaskdoc = disobeyInfoBean.getData().getDisobeytaskdoc();
                    //三违单不安全行为列表
                    ArrayList<DisobeyInfoBean.DataBean.TaskclauselistBean> taskclauselist = disobeyInfoBean.getData().getTaskclauselist();

                    //discovererName 发现人
                    //canAppeal 是否允许申诉 1 可以 0不行
                    // behavior 不安全行为描述描述
                    //extraMoney 额外罚款
                    //approverRemark 驳回意见
                    //approverName 驳回人/审核人
                    //number 编号
                    //adminName 编制人
                    //showtime 时间
                    //归档前关闭  closebeforeautofiling    1归档前可关闭   0 不可关闭
                    //是否开启放弃申诉时间  giveupappeal  1 开启  0 关闭
                    //放弃申诉时间：appealtime    （开启后，如果超出 appealtime   ，则不显示 申诉按钮）
                    //allowarbitration  是否允许仲裁
                    //refusereason   审核驳回是否需要理由
                    tv_number.setText("编号：" + disobeytask.getNumber());
                    tv_zeren.setText("责任：" + disobeytask.getResponsibleUserName());//负责人
                    tv_leader.setText("领导：" + disobeytask.getResponsibleLeaderName());//责任领导
                    tv_auditor.setText("审核人：" + disobeytask.getApproverName());//审核人
                    tv_bianzhi.setText("编制人：" + disobeytask.getAdminName());//编制人
                    //switch_select.setChecked(!(""+disobeytask.getCanAppeal()).equals("0"));//是否可申诉
                    String jingji = "<font color='#000000'>经济：  </font>" + disobeytask.getExtraMoney() + "元";
                    tv_jingjichufa.setText(Html.fromHtml(jingji));//惩罚金额
                    String str = "<font color='#000000'>描述：  </font>" + disobeytask.getBehavior();
                    tv_content.setText(Html.fromHtml(str));//行为描述
                    String xuexi = "<font color='#000000'>学习：  </font>" + disobeytask.getName();
                    tv_time.setText("时间：" + disobeytask.getShowtime());//时间
                    tv_xuexi.setText(Html.fromHtml(xuexi));//额外处罚内容

                    if (("" + disobeytask.getCanAppeal()).equals("0")) {
                        tv_shensu.setText("不可申诉");
                    } else {
                        tv_shensu.setText("可申诉");
                    }

                    if (state.equals("3")) {
                        //被驳回状态
                        ll_bohui_root.setVisibility(View.VISIBLE);
                        tv_bohui.setText("" + disobeytask.getApproverName() + "(领导):" + disobeytask.getApproverRemark());
                    } else if (state.equals("8")) {
                        //待存储

                    }

                    //填充图片
                    RecyclerViewUtils.initGridNoSc(getActivity(), rv_img_list, R.layout.item_image, disobeytaskdoc, new OnGlobalListener() {
                        @Override
                        public <T> void logic(BaseViewHolder helper, List<T> mData, T item, BaseQuickAdapter mAdapter) {

                            DisobeyInfoBean.DataBean.DisobeytaskdocBean disobeytaskdocBean = (DisobeyInfoBean.DataBean.DisobeytaskdocBean) item;
                            ImageView iv_icon = helper.getView(R.id.iv_icon);
                            TextView tv_jiahao = helper.getView(R.id.tv_jiahao);
                            ImageView iv_delete = helper.getView(R.id.iv_delete);
                            tv_jiahao.setVisibility(View.GONE);
                            iv_delete.setVisibility(View.GONE);

                            if (!TextUtils.isEmpty(disobeytaskdocBean.getUrl()) && !TextUtils.isEmpty(disobeyInfoBean.getData().getUrl())) {
                                Glide.with(getActivity()).load(BaseLinkList.Base_Url + "?" + BaseLinkList.apiurl + "=" + BaseLinkList.coal_mine + disobeytaskdocBean.getUrl()).into(iv_icon);
                            }

                        }
                    }, new BaseQuickAdapter.OnItemClickListener() {
                        @Override
                        public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                            DisobeyInfoBean.DataBean.DisobeytaskdocBean disobeytaskdocBean = (DisobeyInfoBean.DataBean.DisobeytaskdocBean) adapter.getData().get(position);
                            ImagePreview
                                    .getInstance()
                                    // 上下文，必须是activity，不需要担心内存泄漏，本框架已经处理好；
                                    .setContext(getActivity())
                                    // 有三种设置数据集合的方式，根据自己的需求进行选择：
                                    // 第一步生成的imageInfo List
//                                          .setImageInfoList(imageInfoList)
                                    // 直接传url List
                                    .setImageList(Collections.singletonList(BaseLinkList.Base_Url + "?" + BaseLinkList.apiurl + "=" + BaseLinkList.coal_mine + disobeytaskdocBean.getUrl()))
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

                    if (disobeytask.getTaskType() == 1) {
                        //填充不安全行为
                        RecyclerViewUtils.initLinerNoSc(getActivity(), rv_img_list1, R.layout.item_jiuwei_unsafe, taskclauselist, new OnGlobalListener() {
                            @Override
                            public <T> void logic(BaseViewHolder helper, List<T> mData, T item, BaseQuickAdapter mAdapter) {
                                DisobeyInfoBean.DataBean.TaskclauselistBean taskclauselistBean = (DisobeyInfoBean.DataBean.TaskclauselistBean) item;
                                TextView tv_text = helper.getView(R.id.tv_text);
                                ImageView tv_chengdu = helper.getView(R.id.tv_chengdu);

                                tv_text.setText("" + taskclauselistBean.getClauseDescription());

                                if (taskclauselistBean.getLevelId() == 1) {
                                    tv_chengdu.setImageResource(R.drawable.jiuwei_yiban);
                                } else if (taskclauselistBean.getLevelId() == 2) {
                                    tv_chengdu.setImageResource(R.drawable.jiuwei_zhongda);
                                }


                            }
                        }, null, null);
                    } else if (disobeytask.getTaskType() == 2) {
                        ll_zidingyi.setVisibility(View.VISIBLE);
                        rv_img_list1.setVisibility(View.GONE);

                        tv_text.setText(disobeytask.getClauseDescription());
                        if (disobeytask.getLevelId() == 1) {
                            iv_chengdu.setImageResource(R.drawable.jiuwei_yiban);
                        } else if (disobeytask.getLevelId() == 2) {
                            iv_chengdu.setImageResource(R.drawable.jiuwei_zhongda);
                        }

                    }

                    //提交
                    //initButton();

                    if (null != refreshLayout) {
                        refreshLayout.finishLoadMore();
                        refreshLayout.finishRefresh();
                    }

                }
            });
        } else {
            if (null != refreshLayout) {
                refreshLayout.finishLoadMore();
                refreshLayout.finishRefresh();
            }
        }

    }

    //初始化button
    private void initButton() {
        if (state.equals("2")) {//审核中
            if (type.equals("2"))
                btn_complete.setText("待审核");
            btn_complete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ToastUtils.showToast(getActivity(), "待审核");
                }
            });
            btn_complete.setVisibility(View.VISIBLE);
        } else if (state.equals("3")) {//被驳回
            btn_complete.setText("重新录入");
            btn_complete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(getActivity(), RectifyingViolationsActivity.class));
                }
            });
            btn_complete.setVisibility(View.GONE);
        } else if (state.equals("4")) {//确认中
            btn_complete.setText("下发处罚单");
            btn_complete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });
        } else if (state.equals("8")) {//待存储
            btn_complete.setText("存入三违历史");
            btn_complete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });
        }
    }
}
