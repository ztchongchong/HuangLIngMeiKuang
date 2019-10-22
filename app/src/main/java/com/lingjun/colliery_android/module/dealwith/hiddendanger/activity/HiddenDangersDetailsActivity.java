package com.lingjun.colliery_android.module.dealwith.hiddendanger.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lingjun.colliery_android.R;
import com.lingjun.colliery_android.base.BaseActivity;
import com.lingjun.colliery_android.base.BaseLinkList;
import com.lingjun.colliery_android.base.OnGlobalListener;
import com.lingjun.colliery_android.bean.DisobeyInfoBean;
import com.lingjun.colliery_android.bean.HiddenDangerContentBean;
import com.lingjun.colliery_android.bean.HiddenDangerDetailsBean;
import com.lingjun.colliery_android.bean.HiddenDangersDetailsBean;
import com.lingjun.colliery_android.bean.HiddenDangersHandleBean;
import com.lingjun.colliery_android.module.dealwith.hiddendanger.fragment.HiddenDangerFourFragment;
import com.lingjun.colliery_android.module.dealwith.hiddendanger.fragment.HiddenDangerOneFragment;
import com.lingjun.colliery_android.module.dealwith.hiddendanger.fragment.HiddenDangerThreeFragment;
import com.lingjun.colliery_android.module.dealwith.hiddendanger.fragment.HiddenDangerTwoFragment;
import com.lingjun.colliery_android.module.dealwith.hiddendanger.general_hidden_danger.HiddenDangerNtryActivity;
import com.lingjun.colliery_android.module.message.PenaltySheetActivity;
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

import cc.shinichi.library.ImagePreview;

/**
 * 隐患详情
 */

public class HiddenDangersDetailsActivity extends BaseActivity implements View.OnClickListener {
    private TextView tv_details_draft;//处理方案提交
    private TextView tv_details_plan;//隐患计划
    private TextView tv_details_position;//隐患位置
    private TextView tv_details_standard;//详情标准
    private TextView tv_details_content;//详情内容标题
    private TextView tv_details_content1;//详情内容
    private TextView tv_details_time1;//录入时间
    private TextView tv_details_people1;//录入人

    private String details_plan;//隐患计划
    private String details_position;//隐患位置
    private String details_standard;//隐患位置
    private String details_content;//详情内容标题
    private String details_content1;//详情内容
    private String details_time;//内容时间
    private long details_time1;//录入时间
    private String details_people;//处理人
    private String details_people1;//录入人
    private String details_acceptor;//验收单位
    private String t1;
    private String t2;
    private String task_id;
    private String mainId;
    private int deduction;//扣分
    private int fine;//罚金
    private RecyclerView rv_img_list;//图片
    private String jilu;

    private String taskSubId;
    private String mainTaskId;

    private String clauseMeasures;
    private String collaborativeUnitsSwitch;

    @Override
    protected int getResourcesId() {
        return R.layout.activity_hidden_dangers_details;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        tv_details_draft = findViewById(R.id.tv_details_draft);
        tv_details_draft.setOnClickListener(this);
        tv_details_standard = findViewById(R.id.tv_details_standard);
        tv_details_content = findViewById(R.id.tv_details_content);
        tv_details_content1 = findViewById(R.id.tv_details_content1);
        tv_details_plan = findViewById(R.id.tv_details_plan);
        tv_details_position = findViewById(R.id.tv_details_position);
        tv_details_time1 = findViewById(R.id.tv_details_time1);
        tv_details_people1 = findViewById(R.id.tv_details_people1);
        rv_img_list = findViewById(R.id.rv_img_list);

        Intent getIntent = getIntent();
        //隐患处理获取的id
        task_id = getIntent.getStringExtra("task_id");
        mainId = getIntent.getStringExtra("mainId");
        //隐患录入直接跳转的id
        taskSubId = getIntent.getStringExtra("taskSubId");
        mainTaskId = getIntent.getStringExtra("mainTaskId");

        jilu = getIntent.getStringExtra("jilu");
        if (jilu.equals("0")) {
            tv_details_draft.setVisibility(View.GONE);
        } else if (jilu.equals("1")) {
            tv_details_draft.setVisibility(View.VISIBLE);
        } else if (jilu.equals("2")) {
            tv_details_draft.setVisibility(View.VISIBLE);
        }
        pick_up_information();//获取隐患详情信息
    }

    private void pick_up_information() {
        final HashMap<String, String> hashMap = new HashMap<>();
        if (!TextUtils.isEmpty(task_id)) {
            hashMap.put("id", task_id);
            hashMap.put("mainid", mainId);
        } else {
            hashMap.put("id", taskSubId);
            hashMap.put("mainid", mainTaskId);
        }
        hashMap.put(BaseLinkList.apiurl, BaseLinkList.coal_mine + BaseLinkList.hidden_details);

        mRetrofit.JsonToColliery(BaseLinkList.Base_Url, hashMap, new BaseSubscriber() {
            @Override
            public void onError(ExceptionHandle.ResponeThrowable e) {
                if (null != refreshLayout) {
                    refreshLayout.finishRefresh();
                    refreshLayout.finishLoadMore();
                }
            }

            @Override
            public void onSuccess(JSONObject jsonObject) {
                LogUtils.e(" * 隐患详情->>" + jsonObject.toString());

                final HiddenDangerDetailsBean hiddenDangersDetailsBean = FastJsonTools.getBean(jsonObject.toString(), HiddenDangerDetailsBean.class);
                if (null != hiddenDangersDetailsBean) {
                    details_plan = (String) hiddenDangersDetailsBean.getData().getSubTaskList().getTroublePlanName();//详情计划
                    details_position = hiddenDangersDetailsBean.getData().getMaintask().getLocation();//详情位置
                    details_standard = hiddenDangersDetailsBean.getData().getMaintask().getClauseDescription();//考核标准
                    details_content = hiddenDangersDetailsBean.getData().getSubTaskList().getSourceDescription();//隐患内容
                    details_content1 = hiddenDangersDetailsBean.getData().getSubTaskList().getTroubleContent();//详情描述
                    hiddenDangersDetailsBean.getData().getListSubTaskimg();//详情图片
                    details_time1 = hiddenDangersDetailsBean.getData().getMaintask().getCreateTime();//录入时间
                    details_people1 = hiddenDangersDetailsBean.getData().getMaintask().getUserName();//发现人
                    deduction = hiddenDangersDetailsBean.getData().getSubTaskList().getSourceMoney();//扣分
                    fine = hiddenDangersDetailsBean.getData().getSubTaskList().getSourceScore();//罚金
                    details_acceptor = hiddenDangersDetailsBean.getData().getSubTaskList().getAcceptorName();//验收人
                    clauseMeasures = hiddenDangersDetailsBean.getData().getMaintask().getClauseMeasures();
                    tv_details_plan.setText(details_plan);//详情计划
                    tv_details_position.setText(details_position);//详情位置
                    if (TextUtils.isEmpty(details_standard)) {
                        tv_details_standard.setText("无");//考核标准
                    } else {
                        tv_details_standard.setText(details_standard);//考核标准
                    }
                    tv_details_content.setText(details_content);//隐患内容
                    tv_details_content1.setText(details_content1);//详情描述
                    tv_details_people1.setText(details_people1);//发现人

                    collaborativeUnitsSwitch = hiddenDangersDetailsBean.getData().getCollaborativeUnitsSwitch();

                    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                    SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    Date d = new Date(details_time1);
                    Date d1 = new Date(details_time1);
                    t2 = format1.format(d);
                    t1 = format.format(d1);
                    tv_details_time1.setText(t1);

                    final ArrayList<HiddenDangerDetailsBean.DataBean.ListSubTaskimgBean> disobeytaskdoc = (ArrayList<HiddenDangerDetailsBean.DataBean.ListSubTaskimgBean>) hiddenDangersDetailsBean.getData().getListSubTaskimg();
                    //填充图片
                    RecyclerViewUtils.initGridNoSc(HiddenDangersDetailsActivity.this, rv_img_list, R.layout.item_image, disobeytaskdoc, new OnGlobalListener() {
                        @Override
                        public <T> void logic(BaseViewHolder helper, List<T> mData, T item, BaseQuickAdapter mAdapter) {

                            HiddenDangerDetailsBean.DataBean.ListSubTaskimgBean disobeytaskdocBean = (HiddenDangerDetailsBean.DataBean.ListSubTaskimgBean) item;
                            ImageView iv_icon = helper.getView(R.id.iv_icon);
                            TextView tv_jiahao = helper.getView(R.id.tv_jiahao);
                            ImageView iv_delete = helper.getView(R.id.iv_delete);
                            tv_jiahao.setVisibility(View.GONE);
                            iv_delete.setVisibility(View.GONE);

                            if (!TextUtils.isEmpty(disobeytaskdocBean.getUrl()) && !TextUtils.isEmpty(hiddenDangersDetailsBean.getData().getUrl())) {
                                Glide.with(HiddenDangersDetailsActivity.this).load(BaseLinkList.Base_Url + "?" + BaseLinkList.apiurl + "=" + BaseLinkList.coal_mine + disobeytaskdocBean.getUrl()).into(iv_icon);
                            }

                        }
                    }, new BaseQuickAdapter.OnItemClickListener() {
                        @Override
                        public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                            HiddenDangerDetailsBean.DataBean.ListSubTaskimgBean listSubTaskimgBean = (HiddenDangerDetailsBean.DataBean.ListSubTaskimgBean) adapter.getData().get(position);
                            ImagePreview
                                    .getInstance()
                                    // 上下文，必须是activity，不需要担心内存泄漏，本框架已经处理好；
                                    .setContext(HiddenDangersDetailsActivity.this)
                                    // 有三种设置数据集合的方式，根据自己的需求进行选择：
                                    // 第一步生成的imageInfo List
//                        .setImageInfoList(imageInfoList)
                                    // 直接传url List
                                    .setImageList(Collections.singletonList(BaseLinkList.Base_Url + "?" + BaseLinkList.apiurl + "=" + BaseLinkList.coal_mine + listSubTaskimgBean.getUrl()))
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
        });
    }

    @Override
    protected BaseRefreshLoadMoreInterface setRefreshLoadMoreListener() {
        return null;
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(HiddenDangersDetailsActivity.this, ProcessingSchemeActivity.class);
        intent.putExtra("deduction", "" + deduction);
        intent.putExtra("fine", "" + fine);
        intent.putExtra("details_acceptor", "" + details_acceptor);//验收单位
        if (!TextUtils.isEmpty(task_id)) {
            intent.putExtra("task_id", "" + task_id);//子任务ID
        } else {
            intent.putExtra("task_id", "" + taskSubId);//子任务ID
        }
        intent.putExtra("details_time1", "" + t2);
        intent.putExtra("sourcedescription", "" + details_content);
        intent.putExtra("clauseMeasures", "" + clauseMeasures);
        intent.putExtra("collaborativeUnitsSwitch", collaborativeUnitsSwitch);
        LogUtils.e("jialaoban" + collaborativeUnitsSwitch);
        startActivity(intent);
        finish();
    }
}
