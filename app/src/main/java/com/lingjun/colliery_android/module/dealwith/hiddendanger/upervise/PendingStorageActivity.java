package com.lingjun.colliery_android.module.dealwith.hiddendanger.upervise;

import android.os.Bundle;

import com.lingjun.colliery_android.view.tablayout.TabLayout;

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
import com.lingjun.colliery_android.module.dealwith.fragment.AcceptanceFragment;
import com.lingjun.colliery_android.module.dealwith.fragment.DangerEscalationragment;
import com.lingjun.colliery_android.module.dealwith.fragment.FieldSituationFragment;
import com.lingjun.colliery_android.module.dealwith.fragment.GovernanceShemeFragment;
import com.lingjun.colliery_android.module.dealwith.fragment.NoticeRectificationFragment;
import com.lingjun.colliery_android.module.dealwith.fragment.PostponedReasonFragment;
import com.lingjun.colliery_android.module.dealwith.fragment.PunishmentSchemeFragment;
import com.lingjun.colliery_android.module.dealwith.fragment.RectificationSituationFragment;
import com.lingjun.colliery_android.module.dealwith.fragment.RejectOpinionFragment;
import com.lingjun.colliery_android.utils.FastJsonTools;
import com.lingjun.colliery_android.utils.retrofit.BaseSubscriber;
import com.lingjun.colliery_android.utils.retrofit.ExceptionHandle;
import com.lingjun.colliery_android.view.NoScrollViewpager;

import org.greenrobot.eventbus.EventBus;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 作者: lihuan
 * 时间: 2018/11/22 20:15
 * 说明: 督办待存储
 */
public class PendingStorageActivity extends BaseActivity {

    @BindView(R.id.tv_name)
    TextView tvTitle;
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tb_title)
    TabLayout tb_layout;
    @BindView(R.id.vp_content)
    NoScrollViewpager vp_content;
    @BindView(R.id.btn_reject)
    Button btnReject;
    @BindView(R.id.btn_pass)
    Button btnPass;
    @BindView(R.id.ll_bottom_button)
    LinearLayout llBottomButton;

    private String[] tabTitle;
    private List<String> tab = new ArrayList<>();
    private String taskId = "";
    private String status = "";
    private String taskType = "";

    @Override
    protected int getResourcesId() {
        return R.layout.activity_pending_storage;
    }

    @Override
    protected BaseRefreshLoadMoreInterface setRefreshLoadMoreListener() {
        return null;
    }

    @Override
    protected void init(Bundle savedInstanceState) {

        taskId = getIntent().getStringExtra("taskId");
        String mainTaskId = getIntent().getStringExtra("taskMainId");
        taskType = getIntent().getStringExtra("taskType");
        status = getIntent().getStringExtra("state");
        String title = getIntent().getStringExtra("title");

        tvTitle.setText(title);

        if ("9".equals(taskType) || "10".equals(taskType)) {
            switch (status) {
                case "8":  //待销号
                    llBottomButton.setVisibility(View.VISIBLE);
                    btnPass.setText("存入历史");
                    btnReject.setVisibility(View.GONE);
                    break;
                case "12": //延期待审核
                    llBottomButton.setVisibility(View.VISIBLE);
                    break;
                case "13": //延期中
                    llBottomButton.setVisibility(View.VISIBLE);
                    btnPass.setText("恢复");
                    btnReject.setVisibility(View.GONE);
                    break;
                default:
                    llBottomButton.setVisibility(View.GONE);
                    break;
            }
        } else {
            llBottomButton.setVisibility(View.GONE);
        }

        showLoadDialog();
        getHiddenDanagerDetailsById(taskId, mainTaskId, taskType, status);
    }

    @OnClick(R.id.iv_back)
    public void onViewClicked() {
        finish();
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

                ArrayList<Fragment> mList = new ArrayList<>();
                tab.clear();

                FieldSituationFragment fieldSituationFragment = FieldSituationFragment.newInstance(dangerDetailsBean);
                switch (taskType) {
                    case "9": //限时整改
                    case "10": //隐患督办
                        NoticeRectificationFragment noticeRectificationFragment = NoticeRectificationFragment.newInstance(dangerDetailsBean);
                        if ("6".equals(status)) { //验收中
                            RectificationSituationFragment rectificationSituationFragment = RectificationSituationFragment.newInstance(dangerDetailsBean);
                            mList.add(noticeRectificationFragment);
                            mList.add(fieldSituationFragment);
                            mList.add(rectificationSituationFragment);
                            tab.add("整改通知书");
                            tab.add("现场情况");
                            tab.add("整改情况");
                        } else if ("8".equals(status)) { //待销号
                            RectificationSituationFragment rectificationSituationFragment = RectificationSituationFragment.newInstance(dangerDetailsBean);
                            AcceptanceFragment acceptanceFragment = AcceptanceFragment.newInstance(dangerDetailsBean);
                            mList.add(noticeRectificationFragment);
                            mList.add(fieldSituationFragment);
                            mList.add(rectificationSituationFragment);
                            mList.add(acceptanceFragment);
                            tab.add("整改通知书");
                            tab.add("现场情况");
                            tab.add("整改情况");
                            tab.add("验收情况");
                        } else if ("12".equals(status)) { //延期待审核
                            PostponedReasonFragment postponedReasonFragment = PostponedReasonFragment.newInstance(dangerDetailsBean);
                            mList.add(noticeRectificationFragment);
                            mList.add(fieldSituationFragment);
                            mList.add(postponedReasonFragment);
                            tab.add("整改通知书");
                            tab.add("现场情况");
                            tab.add("延后理由");
                        } else if ("4".equals(status) && "9".equals(taskType)) {
                            mList.add(noticeRectificationFragment);
                            mList.add(fieldSituationFragment);
                            tab.add("限时整改");
                            tab.add("现场情况");
                        } else if ("4".equals(status) && "10".equals(taskType)) {
                            mList.add(fieldSituationFragment);
                            mList.add(noticeRectificationFragment);
                            tab.add("现场情况");
                            tab.add("整改通知书");
                        } else if ("11".equals(status)) {
                            PostponedReasonFragment postponedReasonFragment = PostponedReasonFragment.newInstance(dangerDetailsBean);
                            mList.add(noticeRectificationFragment);
                            mList.add(fieldSituationFragment);
                            mList.add(postponedReasonFragment);
                            tab.add("整改通知书");
                            tab.add("现场情况");
                            tab.add("延后理由");
                        } else if ("12".equals(status)) {
                            PostponedReasonFragment postponedReasonFragment = PostponedReasonFragment.newInstance(dangerDetailsBean);
                            mList.add(noticeRectificationFragment);
                            mList.add(fieldSituationFragment);
                            mList.add(postponedReasonFragment);
                            tab.add("整改通知书");
                            tab.add("现场情况");
                            tab.add("延后理由");
                        } else if ("2".equals(status) && "10".equals(taskType)) {
                            mList.add(noticeRectificationFragment);
                            mList.add(fieldSituationFragment);
                            tab.add("整改通知书");
                            tab.add("现场情况");
                        } else if ("2".equals(status) && "9".equals(taskType)) {
                            mList.add(noticeRectificationFragment);
                            mList.add(fieldSituationFragment);
                            tab.add("整改通知书");
                            tab.add("现场情况");
                        } else if ("7".equals(status)) {
                            RejectOpinionFragment rejectOpinionFragment = RejectOpinionFragment.newInstance(dangerDetailsBean);
                            mList.add(rejectOpinionFragment);
                            mList.add(noticeRectificationFragment);
                            mList.add(fieldSituationFragment);
                            tab.add("驳回意见");
                            tab.add("整改通知书");
                            tab.add("现场情况");
                        } else { //13 延期中 5整改中
                            mList.add(fieldSituationFragment);
                            mList.add(noticeRectificationFragment);
                            tab.add("现场情况");
                            tab.add("整改通知书");
                        }
                        break;
                    case "11": //隐患升级
                        DangerEscalationragment dangerEscalationragment = DangerEscalationragment.newInstance(dangerDetailsBean);
                        mList.add(fieldSituationFragment);
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

    @OnClick(R.id.btn_reject)
    public void onBtnRejectClicked() { //延期待审核驳回
        delayPassOrReject(taskId, "5");
    }

    @OnClick(R.id.btn_pass)
    public void onBtnPassClicked() { // 恢复/存入历史/通过
        if ("8".equals(status)) { //存入历史（待销号）限时整改/挂牌督办
            getSaveTypeButton(taskId);
        }
        if ("11".equals(status)) {
            delayPassOrReject(taskId, "12");
        } else if ("13".equals(status)) { //恢复（延期中） 限时整改/挂牌督办
            delayPassOrReject(taskId, "-1");
        }
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
                LogUtils.e("延期待审核通过->>" + jsonObject.toString());
                Result result = FastJsonTools.getBean(jsonObject.toString(), Result.class);
                ToastUtils.showShort(result.getMsg());
                if ("200".equals(result.getCode())) {
                    EventBus.getDefault().post(new MsgEvent.RejectCommitSuccess());
                    finish();
                }
            }
        });
    }

    /**
     * 存入历史
     */
    private void getSaveTypeButton(String taskId) {
        HashMap<String, String> hashMap = new HashMap<>();

        hashMap.put("taskId", taskId);
        hashMap.put("saveType", "1");
        hashMap.put(BaseLinkList.apiurl, BaseLinkList.coal_mine + BaseLinkList.getSaveTypeButton);
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
                LogUtils.e("隐患处理存入历史->>" + jsonObject.toString());
                Result result = FastJsonTools.getBean(jsonObject.toString(), Result.class);
                ToastUtils.showShort(result.getMsg());
                if ("200".equals(result.getCode())) {
                    EventBus.getDefault().post(new MsgEvent.RejectCommitSuccess());
                    finish();
                }
            }
        });
    }
}
