package com.lingjun.colliery_android.module.main.rectifyingviolations.fragment;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;
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
 * 预览三违信息
 * Created by nefa on 2018/11/18.
 */

public class PreviewInformationFragment extends BaseFragment {

    private TextView tv_num1;//负责人
    private TextView tv_num2;//责任单位
    private TextView tv_num3;//责任领导
    private TextView tv_shenhe;//审核人
    private TextView tv_num4;//发现人
    private TextView tv_ewaichufa;//额外处罚
    private Switch switch_select;//是否可申诉
    private RecyclerView rv_entry_list;//不安全行为
    private TextView tv_economic;//惩罚金额
    private RecyclerView rv_entry_additional_list;//额外处罚
    private TextView tv_edit;//行为描述
    private RecyclerView rv_list;//图片
    private String taskId;//任务id
    private String state;//当前状态
    private String type;//
    private Button btn_complete;//提交
    private LinearLayout ll_bohui_root;//驳回
    private TextView tv_bohui;

    private LinearLayout ll_zidingyi;
    private ImageView iv_chengdu;
    private TextView tv_text;

    @Override
    protected int setLayout(LayoutInflater inflater) {
        return R.layout.fragment_preview_information;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        tv_num1 = mRootView.findViewById(R.id.tv_num1);
        tv_num2 = mRootView.findViewById(R.id.tv_num2);
        tv_num3 = mRootView.findViewById(R.id.tv_num3);
        tv_shenhe = mRootView.findViewById(R.id.tv_shenhe);
        tv_num4 = mRootView.findViewById(R.id.tv_num4);
        switch_select = mRootView.findViewById(R.id.switch_select);
        rv_entry_list = mRootView.findViewById(R.id.rv_entry_list);
        tv_economic = mRootView.findViewById(R.id.tv_economic);
        rv_entry_additional_list = mRootView.findViewById(R.id.rv_entry_additional_list);
        tv_edit = mRootView.findViewById(R.id.tv_edit);
        rv_list = mRootView.findViewById(R.id.rv_list);
        tv_ewaichufa = mRootView.findViewById(R.id.tv_ewaichufa);
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
                    btn_complete.setVisibility(View.GONE);
                    final DisobeyInfoBean disobeyInfoBean = FastJsonTools.getBean(jsonObject.toString(), DisobeyInfoBean.class);
                    //三违单信息
                    DisobeyInfoBean.DataBean.DisobeytaskBean disobeytask = disobeyInfoBean.getData().getDisobeytask();
                    //三违单图片列表
                    ArrayList<DisobeyInfoBean.DataBean.DisobeytaskdocBean> disobeytaskdoc = disobeyInfoBean.getData().getDisobeytaskdoc();
                    //三违单不安全行为列表
                    final ArrayList<DisobeyInfoBean.DataBean.TaskclauselistBean> taskclauselist = disobeyInfoBean.getData().getTaskclauselist();

                    tv_num1.setText("" + disobeytask.getResponsibleUserName());//负责人
                    tv_num2.setText("" + disobeytask.getResponsibleDepartmentName());//责任单位
                    tv_num3.setText("" + disobeytask.getResponsibleLeaderName());//责任领导
                    tv_shenhe.setText("" + disobeytask.getApproverName());//审核人
                    tv_num4.setText("" + disobeytask.getDiscovererName());//发现人
                    switch_select.setChecked(!("" + disobeytask.getCanAppeal()).equals("0"));//是否可申诉
                    tv_economic.setText("" + disobeytask.getExtraMoney() + "元");//惩罚金额
                    String str = "<font color='#000000'>文字描述:</font>" + disobeytask.getBehavior();
                    tv_edit.setText(Html.fromHtml(str));//行为描述
                    tv_ewaichufa.setText("" + disobeytask.getName());//额外处罚内容

                    if (state.equals("3")) {
                        //被驳回状态
                        ll_bohui_root.setVisibility(View.VISIBLE);
                        tv_bohui.setText("" + disobeytask.getApproverName() + "(领导):" + disobeytask.getApproverRemark());
                    }
                    if (disobeytask.getTaskType() == 1) {
                        //填充不安全行为
                        RecyclerViewUtils.initLinerNoSc(getActivity(), rv_entry_list, R.layout.item_jiuwei_unsafe, taskclauselist, new OnGlobalListener() {
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
                        rv_entry_list.setVisibility(View.GONE);

                        tv_text.setText(disobeytask.getClauseDescription());
                        if (disobeytask.getLevelId() == 1) {
                            iv_chengdu.setImageResource(R.drawable.jiuwei_yiban);
                        } else if (disobeytask.getLevelId() == 2) {
                            iv_chengdu.setImageResource(R.drawable.jiuwei_zhongda);
                        }
                    }

                    //填充图片
                    RecyclerViewUtils.initGridNoSc(getActivity(), rv_list, R.layout.item_image, disobeytaskdoc, new OnGlobalListener() {
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
}
