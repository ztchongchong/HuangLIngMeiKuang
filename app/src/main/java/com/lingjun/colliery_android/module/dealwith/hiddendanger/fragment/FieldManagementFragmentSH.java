package com.lingjun.colliery_android.module.dealwith.hiddendanger.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
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
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 现场治理（审核中）
 */
public class FieldManagementFragmentSH extends BaseFragment {
    private TextView tv_yinhuandengji;//隐患等级
    private TextView tv_zerendanwei;//责任单位
    private TextView tv_koufen;//扣分
    private TextView tv_fajin;//罚金
    private TextView tv_content;//方案内容
    private RecyclerView rv_image_list;//图片处理
    private TextView tv_yanshouren_content;//验收人书写的内容
    private RecyclerView rv_image_yanshou_list;//验收人图片
    private TextView tv_jishuyuan;//技术员
    private TextView tv_zerenren;//整改人
    private TextView tv_yanshouren;//验收人
    private TextView tv_yanshoudanwei;//验收单位
    private TextView tv_auditor;//审核人
    private TextView tv_cooperation;//协作单位
    private String taskMainId;
    private String taskId;

    private TextView tv_classtime;//班次
    private TextView tv_Personliable;//责任人
    private TextView tv_Superiorleader;//上级领导

    @Override
    protected int setLayout(LayoutInflater inflater) {
        return R.layout.fragment_field_management_sh;
    }


    @Override
    protected void init(Bundle savedInstanceState) {
        tv_yinhuandengji = mRootView.findViewById(R.id.tv_yinhuandengji);
        tv_zerendanwei = mRootView.findViewById(R.id.tv_zerendanwei);
        tv_koufen = mRootView.findViewById(R.id.tv_koufen);
        tv_fajin = mRootView.findViewById(R.id.tv_fajin);
        tv_cooperation = mRootView.findViewById(R.id.tv_cooperation);
        tv_content = mRootView.findViewById(R.id.tv_content);
        rv_image_list = mRootView.findViewById(R.id.rv_image_list);
        tv_yanshouren_content = mRootView.findViewById(R.id.tv_yanshouren_content);
        rv_image_yanshou_list = mRootView.findViewById(R.id.rv_image_yanshou_list);
        tv_jishuyuan = mRootView.findViewById(R.id.tv_jishuyuan);
        tv_zerenren = mRootView.findViewById(R.id.tv_zerenren);
        tv_yanshouren = mRootView.findViewById(R.id.tv_yanshouren);
        tv_auditor = mRootView.findViewById(R.id.tv_auditor);
        tv_yanshoudanwei = mRootView.findViewById(R.id.tv_yanshoudanwei);
        tv_classtime = mRootView.findViewById(R.id.tv_classtime);
        tv_Personliable = mRootView.findViewById(R.id.tv_Personliable);
        tv_Superiorleader = mRootView.findViewById(R.id.tv_Superiorleader);


        Intent getIntent = getActivity().getIntent();
        taskMainId = getIntent.getStringExtra("taskMainId");
        taskId = getIntent.getStringExtra("taskId");

        refreshView();
    }

    @Override
    protected BaseRefreshLoadMoreInterface setRefreshLoadMoreListener() {
        return null;
    }

    //刷新
    private void refreshView() {


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
                final HiddenDangerDetailsBean HiddenDangerDetailsBean = FastJsonTools.getBean(jsonObject.toString(), HiddenDangerDetailsBean.class);
                HiddenDangerDetailsBean.DataBean.SubTaskListBean subTaskList = HiddenDangerDetailsBean.getData().getSubTaskList();
                ArrayList<HiddenDangerDetailsBean.DataBean.FafileListBean> fafileList = (ArrayList<HiddenDangerDetailsBean.DataBean.FafileListBean>) HiddenDangerDetailsBean.getData().getFafileList();//方案图片
                ArrayList<HiddenDangerDetailsBean.DataBean.YsfileListBean> ysfileList = (ArrayList<HiddenDangerDetailsBean.DataBean.YsfileListBean>) HiddenDangerDetailsBean.getData().getYsfileList();//验收图片

                tv_yinhuandengji.setText("" + subTaskList.getTroubleLevel());
                tv_zerendanwei.setText("" + subTaskList.getResponsibleDepartmentName());
                tv_koufen.setText("" + subTaskList.getResponsibleScore());
                tv_fajin.setText("" + subTaskList.getResponsibleMoney());
                tv_content.setText("" + subTaskList.getSolutionContent());//方案内容
                tv_yanshouren_content.setText("" + subTaskList.getAcceptReason());//验收内容

                tv_classtime.setText(subTaskList.getHazardDivisions() + "点");//班次
                if (subTaskList.getResponsiblePersonLeadership() != null) {
                    tv_Personliable.setText("" + subTaskList.getResponsiblePersonLeadership());//责任人
                } else {
                    tv_Personliable.setText("");//责任人
                }
                tv_Superiorleader.setText("" + subTaskList.getResponsibleLeaderName());//上级领导
                if (TextUtils.isEmpty(subTaskList.getTechnicianName())) {
                    tv_jishuyuan.setText("");
                } else {
                    tv_jishuyuan.setText("" + subTaskList.getTechnicianName());
                }
                tv_zerenren.setText("" + subTaskList.getResponsibleUserName());
                tv_yanshouren.setText("" + subTaskList.getAcceptorName());//验收人
                if (subTaskList.getAcceptanceDepartmentsName() != null && !TextUtils.isEmpty(subTaskList.getAcceptanceDepartmentsName())) {
                    StringBuffer stringBuffer = new StringBuffer(subTaskList.getAcceptanceDepartmentsName());
                    if (',' == stringBuffer.charAt(stringBuffer.length() - 1) && ',' == stringBuffer.charAt(0)) {
                        stringBuffer = stringBuffer.deleteCharAt(stringBuffer.length() - 1).deleteCharAt(0);
                    }
                    tv_yanshoudanwei.setText("" + stringBuffer);//验收单位
                } else {
                    tv_yanshoudanwei.setText("");//验收单位
                }
                if (TextUtils.isEmpty(subTaskList.getApproverName())) {
                    tv_auditor.setText("");
                } else {
                    tv_auditor.setText("" + subTaskList.getApproverName());
                }
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
                        LogUtils.e("加载方案图->>" + HiddenDangerDetailsBean.getData().getUrl() + fafileListBean.getUrl());
                        Glide.with(getActivity()).load(HiddenDangerDetailsBean.getData().getUrl() + fafileListBean.getUrl()).into(iv_icon);
                    }
                }, null, null);

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
                        LogUtils.e("加载验收图->>" + HiddenDangerDetailsBean.getData().getUrl() + ysfileListBean.getUrl());
                        Glide.with(getActivity()).load(HiddenDangerDetailsBean.getData().getUrl() + ysfileListBean.getUrl()).into(iv_icon);
                    }
                }, null, null);


                if (null != refreshLayout) {
                    refreshLayout.finishRefresh();
                    refreshLayout.finishLoadMore();
                }
            }
        });
    }

}
