package com.lingjun.colliery_android.module.dealwith.hiddendanger.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
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
import com.lingjun.colliery_android.utils.DateUtil;
import com.lingjun.colliery_android.utils.FastJsonTools;
import com.lingjun.colliery_android.utils.RecyclerViewUtils;
import com.lingjun.colliery_android.utils.retrofit.BaseSubscriber;
import com.lingjun.colliery_android.utils.retrofit.ExceptionHandle;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

import static com.lingjun.colliery_android.R2.id.edit_query;
import static com.lingjun.colliery_android.R2.id.view;

/**
 * 现场情况（审核中）
 */
public class FieldSituationFragmentSH extends BaseFragment {

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

    private String taskMainId;
    private String taskId;

    private TextView tv_clauseConsequence;

    @Override
    protected int setLayout(LayoutInflater inflater) {
        return R.layout.fragment_field_situation;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        Intent getIntent = getActivity().getIntent();
        taskMainId = getIntent.getStringExtra("taskMainId");
        taskId = getIntent.getStringExtra("taskId");
        tv_clauseConsequence = mRootView.findViewById(R.id.tv_clauseConsequence);
        refreshView();
    }

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
                final HiddenDangerDetailsBean troubleSceneBean = FastJsonTools.getBean(jsonObject.toString(), HiddenDangerDetailsBean.class);
                HiddenDangerDetailsBean.DataBean.SubTaskListBean subTaskList = troubleSceneBean.getData().getSubTaskList();
                ArrayList<HiddenDangerDetailsBean.DataBean.FafileListBean> fafileList = (ArrayList<HiddenDangerDetailsBean.DataBean.FafileListBean>) troubleSceneBean.getData().getFafileList();//方案图片
                tvWriteTime.setText(DateUtil.getStringByFormat(troubleSceneBean.getData().getMaintask().getCreateTime(), "yyyy-MM-dd HH:mm"));
                tvDiscoveryPerson.setText(troubleSceneBean.getData().getMaintask().getUserName());
                tvDiscoveryPosition.setText(troubleSceneBean.getData().getMaintask().getAreaName());
                tvAssessStandard.setText(troubleSceneBean.getData().getMaintask().getClauseDescription());

                tvHiddenDangerContent.setText("隐患描述：" + troubleSceneBean.getData().getSubTaskList().getSourceDescription());
                tvDisposePerson.setText("处理：" + troubleSceneBean.getData().getSubTaskList().getProcessorName());
                tvDisposeDesc.setText(troubleSceneBean.getData().getSubTaskList().getTroubleContent());
                if (TextUtils.isEmpty(troubleSceneBean.getData().getMaintask().getClauseConsequence())) {
                    tv_clauseConsequence.setText("隐患结果：无");
                } else {
                    if (troubleSceneBean.getData().getMaintask().getClauseConsequence().equals("null")) {
                        tv_clauseConsequence.setText("隐患结果：无");
                    } else {
                        tv_clauseConsequence.setText("隐患结果：" + troubleSceneBean.getData().getMaintask().getClauseConsequence());
                    }
                }

                //方案图片
                RecyclerViewUtils.initLinerNoSc(getActivity(), rvLocaleImg, R.layout.item_image, troubleSceneBean.getData().getListSubTaskimg(), new OnGlobalListener() {
                    @Override
                    public <T> void logic(BaseViewHolder helper, List<T> mData, T item, BaseQuickAdapter mAdapter) {
                        HiddenDangerDetailsBean.DataBean.ListSubTaskimgBean listSubTaskimgBean = (HiddenDangerDetailsBean.DataBean.ListSubTaskimgBean) item;
                        ImageView iv_icon = helper.getView(R.id.iv_icon);
                        ImageView iv_delete = helper.getView(R.id.iv_delete);
                        TextView tv_jiahao = helper.getView(R.id.tv_jiahao);
                        iv_delete.setVisibility(View.GONE);
                        tv_jiahao.setVisibility(View.GONE);
                        LogUtils.e("加载方案图->>" + troubleSceneBean.getData().getUrl() + listSubTaskimgBean.getUrl());
                        Glide.with(getActivity()).load(troubleSceneBean.getData().getUrl() + listSubTaskimgBean.getUrl()).into(iv_icon);
                    }
                }, null, null);


                if (null != refreshLayout) {
                    refreshLayout.finishRefresh();
                    refreshLayout.finishLoadMore();
                }
            }
        });
    }


    @Override
    protected BaseRefreshLoadMoreInterface setRefreshLoadMoreListener() {
        return null;
    }


}
