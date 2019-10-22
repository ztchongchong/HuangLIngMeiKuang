package com.lingjun.colliery_android.module.dealwith.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.lingjun.colliery_android.R;
import com.lingjun.colliery_android.base.BaseActivity;
import com.lingjun.colliery_android.base.BaseLinkList;
import com.lingjun.colliery_android.bean.HiddenDangerDetailsBean;
import com.lingjun.colliery_android.bean.Result;
import com.lingjun.colliery_android.eventbus.MsgEvent;
import com.lingjun.colliery_android.module.dealwith.fragment.DangerEscalationragment;
import com.lingjun.colliery_android.module.dealwith.fragment.FieldSituationFragment;
import com.lingjun.colliery_android.module.dealwith.fragment.NoticeRectificationFragment;
import com.lingjun.colliery_android.module.dealwith.fragment.PostponedReasonFragment;
import com.lingjun.colliery_android.module.dealwith.fragment.RectificationSituationFragment;
import com.lingjun.colliery_android.module.dealwith.fragment.RejectOpinionFragment;
import com.lingjun.colliery_android.utils.FastJsonTools;
import com.lingjun.colliery_android.utils.retrofit.BaseSubscriber;
import com.lingjun.colliery_android.utils.retrofit.ExceptionHandle;
import com.lingjun.colliery_android.view.NoScrollViewpager;
import com.lingjun.colliery_android.view.tablayout.TabLayout;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 作者: lihuan
 * 时间: 2018/11/17 16:07
 * 说明: 限时整改（待审核）
 */
public class RectifyTimeLimitActivity extends BaseActivity {
    @BindView(R.id.tv_name)
    TextView tvTitle;
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tb_title)
    TabLayout tb_layout;
    @BindView(R.id.vp_content)
    NoScrollViewpager vp_content;
    @BindView(R.id.btn_reject)
    TextView btnReject;
    @BindView(R.id.btn_pass)
    TextView btnPass;
    @BindView(R.id.ll_bottom_button)
    LinearLayout llBottomButton;
    @BindView(R.id.ll_bottom_button1)
    LinearLayout llBottomButton1;
    @BindView(R.id.btn_rectification)
    TextView btnRectification;
    @BindView(R.id.btn_delay)
    TextView btnDelay;
    @BindView(R.id.btn_inspection_instruction)
    Button btnInspectionInstruction;

    private TextView tv_zg_reject;
    private TextView tv_zg_pass;
    private LinearLayout ll_bottom_button2;

    private String[] tabTitle;
    private List<String> tab = new ArrayList<>();
    private String taskId = "";
    private String taskType = "";
    private String status = "";
    private String clauseMeasures;
    private String acceptreason;

    @Override
    protected int getResourcesId() {
        return R.layout.activity_rectify_time_limit;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        tv_zg_reject = findViewById(R.id.tv_zg_reject);
        tv_zg_pass = findViewById(R.id.tv_zg_pass);
        ll_bottom_button2 = findViewById(R.id.ll_bottom_button2);

        taskId = getIntent().getStringExtra("taskId");
        String mainTaskId = getIntent().getStringExtra("mainTaskId");
        taskType = getIntent().getStringExtra("taskType");
        status = getIntent().getStringExtra("status");

        switch (taskType) {
            case "9": //限时整改
            case "10": //隐患督办
                if ("2".equals(status)) {
                    tvTitle.setText("待审核");
                    llBottomButton.setVisibility(View.VISIBLE);
                    btnInspectionInstruction.setVisibility(View.INVISIBLE);
                    llBottomButton1.setVisibility(View.INVISIBLE);
                } else if ("4".equals(status)) {
                    tvTitle.setText("待确认");
                    llBottomButton.setVisibility(View.VISIBLE);
                    btnInspectionInstruction.setVisibility(View.INVISIBLE);
                    llBottomButton1.setVisibility(View.INVISIBLE);
                } else if ("5".equals(status) || "7".equals(status)) {
                    tvTitle.setText("待整改");
                    llBottomButton.setVisibility(View.INVISIBLE);
                    btnInspectionInstruction.setVisibility(View.INVISIBLE);
                    llBottomButton1.setVisibility(View.VISIBLE);
                } else if ("6".equals(status)) {
                    tvTitle.setText("待验收");
                    llBottomButton.setVisibility(View.INVISIBLE);
                    btnInspectionInstruction.setVisibility(View.VISIBLE);
                    llBottomButton1.setVisibility(View.INVISIBLE);
                } else if ("11".equals(status)) {
                    tvTitle.setText("延期待审核");
                    llBottomButton.setVisibility(View.VISIBLE);
                    btnInspectionInstruction.setVisibility(View.INVISIBLE);
                    llBottomButton1.setVisibility(View.INVISIBLE);
                } else if ("12".equals(status)) {
                    tvTitle.setText("延期申请中，处理人待审核");
                    llBottomButton.setVisibility(View.VISIBLE);
                    btnInspectionInstruction.setVisibility(View.INVISIBLE);
                    llBottomButton1.setVisibility(View.INVISIBLE);
                }
                break;
            case "11": //隐患升级
                tvTitle.setText("隐患处理");
                llBottomButton.setVisibility(View.VISIBLE);
                btnInspectionInstruction.setVisibility(View.INVISIBLE);
                btnRectification.setVisibility(View.INVISIBLE);
                break;
            default:
        }
        showLoadDialog();
        getHiddenDanagerDetailsById(taskId, mainTaskId, taskType, status);

        tv_zg_reject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RectifyTimeLimitActivity.this, RejectCommitActivity.class);
                intent.putExtra("taskId", taskId);
                startActivity(intent);
            }
        });

        tv_zg_pass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv_zg_pass();//
            }
        });
    }

    private void tv_zg_pass() {
        HashMap<String, String> hashMap = new HashMap<>();

        hashMap.put("taskId", taskId);
        hashMap.put(BaseLinkList.apiurl, BaseLinkList.coal_mine + BaseLinkList.rectifyIngButton);
        mRetrofit.JsonToColliery(BaseLinkList.Base_Url, hashMap, new BaseSubscriber() {
            @Override
            public void onError(ExceptionHandle.ResponeThrowable e) {
                if (null != refreshLayout) {
                    refreshLayout.finishRefresh();
                    refreshLayout.finishLoadMore();
                }
                dismissDialog();
            }

            @Override
            public void onSuccess(JSONObject jsonObject) {
                dismissDialog();
                LogUtils.e("驳回->>" + jsonObject.toString());
                Result result = FastJsonTools.getBean(jsonObject.toString(), Result.class);
                ToastUtils.showShort(result.getMsg());
                if ("200".equals(result.getCode())) {
                    finish();
                    EventBus.getDefault().post(new MsgEvent.RejectCommitSuccess());
                }
            }
        });
    }

    /**
     * 根据id获得某条隐患信息
     */
    private void getHiddenDanagerDetailsById(String taskId, String mainTaskId, final String taskType, final String status) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("id", taskId);
        hashMap.put("mainid", mainTaskId);
        hashMap.put(BaseLinkList.apiurl, BaseLinkList.coal_mine + BaseLinkList.troubleinfo);
        mRetrofit.JsonToColliery(BaseLinkList.Base_Url, hashMap, new BaseSubscriber() {
            @Override
            public void onError(ExceptionHandle.ResponeThrowable e) {
                if (null != refreshLayout) {
                    refreshLayout.finishRefresh();
                    refreshLayout.finishLoadMore();
                }
                dismissDialog();
            }

            @Override
            public void onSuccess(JSONObject jsonObject) {
                dismissDialog();
                LogUtils.e("隐患信息限时整改->>" + jsonObject.toString());
                final HiddenDangerDetailsBean dangerDetailsBean = FastJsonTools.getBean(jsonObject.toString(), HiddenDangerDetailsBean.class);
                clauseMeasures = dangerDetailsBean.getData().getMaintask().getClauseMeasures();
                acceptreason = dangerDetailsBean.getData().getSubTaskList().getAcceptReason();
                ArrayList<Fragment> mList = new ArrayList<>();
                tab.clear();
                switch (taskType) {
                    case "9": //限时整改
                    case "10": //隐患督办
                        FieldSituationFragment fieldSituationFragment = FieldSituationFragment.newInstance(dangerDetailsBean);
                        NoticeRectificationFragment noticeRectificationFragment = NoticeRectificationFragment.newInstance(dangerDetailsBean);

                        if ("7".equals(status)) { //验收驳回
                            RejectOpinionFragment rejectOpinionFragment = RejectOpinionFragment.newInstance(dangerDetailsBean);
                            mList.add(rejectOpinionFragment);
                            mList.add(noticeRectificationFragment);
                            mList.add(fieldSituationFragment);
                            tab.add("驳回意见");
                            tab.add("整改通知书");
                            tab.add("现场情况");
                        } else if ("6".equals(status)) { //待验收
                            RectificationSituationFragment rectificationSituationFragment = RectificationSituationFragment.newInstance(dangerDetailsBean);
                            mList.add(noticeRectificationFragment);
                            mList.add(fieldSituationFragment);
                            mList.add(rectificationSituationFragment);
                            tab.add("整改通知书");
                            tab.add("现场情况");
                            tab.add("整改情况");
                        } else if ("11".equals(status)) {
                            PostponedReasonFragment postponedReasonFragment = PostponedReasonFragment.newInstance(dangerDetailsBean);
                            mList.add(noticeRectificationFragment);
                            mList.add(fieldSituationFragment);
                            mList.add(postponedReasonFragment);
                            tab.add("整改通知书");
                            tab.add("现场情况");
                            tab.add("延后理由");
                        } else if ("2".equals(status)) {
                            mList.add(fieldSituationFragment);
                            mList.add(noticeRectificationFragment);
                            tab.add("现场情况");
                            tab.add("整改通知书");
                        } else if ("12".equals(status)) {
                            PostponedReasonFragment postponedReasonFragment = PostponedReasonFragment.newInstance(dangerDetailsBean);
                            mList.add(noticeRectificationFragment);
                            mList.add(fieldSituationFragment);
                            mList.add(postponedReasonFragment);
                            tab.add("整改通知书");
                            tab.add("现场情况");
                            tab.add("延后理由");
                        } else if ("5".equals(status)) {
                            if (dangerDetailsBean.getData().getCurrUserIdcard() == 2) {//1 责任人 2 协作单位
                                llBottomButton.setVisibility(View.INVISIBLE);
                                btnInspectionInstruction.setVisibility(View.INVISIBLE);
                                llBottomButton1.setVisibility(View.INVISIBLE);
                                ll_bottom_button2.setVisibility(View.VISIBLE);
                            }
                            mList.add(fieldSituationFragment);
                            mList.add(noticeRectificationFragment);
                            tab.add("现场情况");
                            tab.add("整改通知书");
                        } else {
                            mList.add(fieldSituationFragment);
                            mList.add(noticeRectificationFragment);
                            tab.add("现场情况");
                            tab.add("整改通知书");
                        }
                        break;
                    case "11": //隐患升级
                        FieldSituationFragment fieldSituationFragment2 = FieldSituationFragment.newInstance(dangerDetailsBean);
                        DangerEscalationragment dangerEscalationragment = DangerEscalationragment.newInstance(dangerDetailsBean);
                        mList.add(fieldSituationFragment2);
                        mList.add(dangerEscalationragment);
                        tab.add("现场情况");
                        tab.add("危险升级");
                        break;
                    default:
                }

                tabTitle = new String[tab.size()];
                tab.toArray(tabTitle);

                CourseDetailsAdapter adapter = new CourseDetailsAdapter(getSupportFragmentManager(), mList);
                vp_content.setAdapter(adapter);
                tb_layout.setupWithViewPager(vp_content);
                tb_layout.setTabMode(TabLayout.MODE_FIXED);
                vp_content.setScroll(false);
            }
        });
    }

    @Override
    protected BaseRefreshLoadMoreInterface setRefreshLoadMoreListener() {
        return null;
    }

    @OnClick(R.id.iv_back)
    public void onIvBackClicked() {
        finish();
    }

    @OnClick(R.id.btn_reject)
    public void onBtnRejectClicked() { //驳回
        if ("11".equals(status)) {
            delayPassOrReject(taskId, "5");
        }
        if ("12".equals(status)) {
            delayPassOrReject(taskId, "5");
        } else {
            Intent intent = new Intent(this, RejectCommitActivity.class);
            intent.putExtra("taskId", taskId);
            startActivity(intent);
        }
    }

    @OnClick(R.id.btn_pass)
    public void onBtnPassClicked() { //通过
        switch (taskType) {
            case "9": //限时整改
            case "10"://挂牌督办
                if ("11".equals(status)) {
                    delayPassOrReject(taskId, "12");
                } else {
                    getTODOLimitButton(taskId);
                }
                break;
            case "11": //隐患升级
                getFatalPassButton(taskId);
                break;
            default:
        }
    }

    @OnClick(R.id.btn_rectification)
    public void onBtnRectificationClicked() { //进行整改
        Intent intent = new Intent(this, RectificationActivity.class);
        intent.putExtra("taskId", taskId);
        intent.putExtra("type", 0);
        intent.putExtra("clauseMeasures", clauseMeasures);
        startActivity(intent);
    }

    @OnClick(R.id.btn_delay)
    public void onBtnDelayClicked() { //延期申请
        Intent intent = new Intent(this, DelayApplyActivity.class);
        intent.putExtra("taskId", taskId);
        startActivity(intent);
    }

    @OnClick(R.id.btn_inspection_instruction)
    public void onBtnInspectionInstructionClicked() { // 验收说明
        Intent intent = new Intent(this, RectificationActivity.class);
        intent.putExtra("taskId", taskId);
        intent.putExtra("type", 1);
        intent.putExtra("acceptreason", acceptreason);
        startActivity(intent);
    }

    @OnClick(R.id.btn_rectification)
    public void onViewClicked() {
    }

    class CourseDetailsAdapter extends FragmentStatePagerAdapter {
        private List<Fragment> fragments;

        public CourseDetailsAdapter(FragmentManager fm, List<Fragment> fragments) {
            super(fm);
            this.fragments = fragments;
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return tabTitle[position];
        }
    }

    /**
     * 待办--> 限时整改、挂牌督办待审核通过
     */
    private void getTODOLimitButton(String taskId) {
        HashMap<String, String> hashMap = new HashMap<>();

        hashMap.put("taskId", taskId);
        if (status.equals("2")) {
            hashMap.put("approveState", "2");
        } else if (status.equals("4")) {
            hashMap.put("confirmState", "4");
        }
        hashMap.put(BaseLinkList.apiurl, BaseLinkList.coal_mine + BaseLinkList.getTODOLimitButton);
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
                LogUtils.e("待办待审核通过->>" + jsonObject.toString());
                Result result = FastJsonTools.getBean(jsonObject.toString(), Result.class);
                ToastUtils.showShort(result.getMsg());
                if ("200".equals(result.getCode())) {
                    EventBus.getDefault().post(new MsgEvent.RejectCommitSuccess());
                }
            }
        });
    }

    /**
     * 待办、督办--> 限时整改、挂牌督办延期待审核通过、驳回、延期中恢复接口
     */
    private void delayPassOrReject(String taskId, String flag) {
        HashMap<String, String> hashMap = new HashMap<>();

        hashMap.put("taskSubId", taskId);
        hashMap.put("flag", flag);
        hashMap.put(BaseLinkList.apiurl, BaseLinkList.coal_mine + BaseLinkList.delayPassOrReject);
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
                LogUtils.e("待办待审核通过->>" + jsonObject.toString());
                Result result = FastJsonTools.getBean(jsonObject.toString(), Result.class);
                ToastUtils.showShort(result.getMsg());
                if ("200".equals(result.getCode())) {
                    EventBus.getDefault().post(new MsgEvent.RejectCommitSuccess());
                }
            }
        });
    }

    /**
     * 待办--> 隐患升级待审核通过
     */
    private void getFatalPassButton(String taskId) {
        HashMap<String, String> hashMap = new HashMap<>();

        hashMap.put("taskId", taskId);
        hashMap.put("approveState", "2");
        hashMap.put(BaseLinkList.apiurl, BaseLinkList.coal_mine + BaseLinkList.getFatalPassButton);
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
                LogUtils.e("隐患升级待审核通过->>" + jsonObject.toString());
                Result result = FastJsonTools.getBean(jsonObject.toString(), Result.class);
                ToastUtils.showShort(result.getMsg());
                if ("200".equals(result.getCode())) {
                    EventBus.getDefault().post(new MsgEvent.RejectCommitSuccess());
                }
            }
        });
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void rejectSuccess(MsgEvent.RejectCommitSuccess messageEvent) {
        finish();
    }

}
