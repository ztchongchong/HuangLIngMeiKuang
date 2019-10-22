package com.lingjun.colliery_android.module.dealwith.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.StringUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lingjun.colliery_android.R;
import com.lingjun.colliery_android.base.BaseFragment;
import com.lingjun.colliery_android.base.BaseLinkList;
import com.lingjun.colliery_android.base.OnGlobalListener;
import com.lingjun.colliery_android.bean.DealWithBean;
import com.lingjun.colliery_android.module.dealwith.activity.ImplementedActivity;
import com.lingjun.colliery_android.module.dealwith.activity.MajorHiddenDangerActivity;
import com.lingjun.colliery_android.module.dealwith.activity.RectifyTimeLimitActivity;
import com.lingjun.colliery_android.module.dealwith.activity.SiteManagementActivity;
import com.lingjun.colliery_android.module.dealwith.hiddendanger.activity.DetailedlistActivity;
import com.lingjun.colliery_android.module.dealwith.standardized.accepted.AcceptedActivity;
import com.lingjun.colliery_android.module.dealwith.standardized.audit.AuditActivity;
import com.lingjun.colliery_android.module.dealwith.standardized.check.CheckActivity;
import com.lingjun.colliery_android.module.dealwith.standardized.review.ReviewActivity;
import com.lingjun.colliery_android.module.main.MainActivity;
import com.lingjun.colliery_android.module.main.rectifyingviolations.PreviewViolationInformationActivity;
import com.lingjun.colliery_android.module.main.rectifyingviolations.RectifyingViolationsManagementActivity;
import com.lingjun.colliery_android.utils.FastJsonTools;
import com.lingjun.colliery_android.utils.MessageEvent;
import com.lingjun.colliery_android.utils.RecyclerViewUtils;
import com.lingjun.colliery_android.utils.retrofit.BaseSubscriber;
import com.lingjun.colliery_android.utils.retrofit.ExceptionHandle;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import org.greenrobot.eventbus.EventBus;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * 待办任务
 * Created by nefa on 2018/10/18.
 */

public class DealWithTaskFragment extends BaseFragment {

    @BindView(R.id.ll_1)
    LinearLayout ll1;
    @BindView(R.id.ll_2)
    LinearLayout ll2;
    @BindView(R.id.ll_3)
    LinearLayout ll3;
    @BindView(R.id.ll_5)
    LinearLayout ll5;
    LinearLayout ll7;
    @BindView(R.id.ll_8)
    LinearLayout ll8;
    @BindView(R.id.ll_9)
    LinearLayout ll9;

    private EditText et_daiban;
    private ImageView iv_delete;

    private RecyclerView rv_list;
    private Intent intent;
    private long i;
    private RelativeLayout rl_daiban;
    private LinearLayout ll_cancel;
    private LinearLayout ll_daiban;
    private LinearLayout ll_toobar1;
    private LinearLayout ll_toobar2;
    private LinearLayout ll_beijing;
    private SmartRefreshLayout refreshLayout;

    private ArrayList<DealWithBean.DataBean.PageBean.ResultsBean> results = new ArrayList<>();


    @Override
    protected int setLayout(LayoutInflater inflater) {
        return R.layout.fragment_dealwith_task;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        rv_list = mRootView.findViewById(R.id.rv_list);
        et_daiban = mRootView.findViewById(R.id.et_daiban);
        iv_delete = mRootView.findViewById(R.id.iv_delete);
        ll_daiban = mRootView.findViewById(R.id.ll_daiban);
        ll_toobar1 = mRootView.findViewById(R.id.ll_toobar1);
        ll_toobar2 = mRootView.findViewById(R.id.ll_toobar2);
        ll_cancel = mRootView.findViewById(R.id.ll_cancel);
        ll_beijing = mRootView.findViewById(R.id.ll_beijing);
        rl_daiban = mRootView.findViewById(R.id.rl_daiban);
        refreshLayout = mRootView.findViewById(R.id.refreshLayout);


        iv_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                et_daiban.setText("");
            }
        });

        ll_toobar1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ll_toobar1.setVisibility(View.GONE);
                ll_toobar2.setVisibility(View.VISIBLE);
                rl_daiban.setVisibility(View.GONE);
                ll_daiban.setVisibility(View.VISIBLE);
            }
        });

        et_daiban.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rl_daiban.setVisibility(View.GONE);
                ll_daiban.setVisibility(View.VISIBLE);
                et_daiban.setText("");

            }
        });

        et_daiban.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_ENTER && event.getAction() == KeyEvent.ACTION_UP) {
                    //先隐藏键盘
                    SoftKeyboardUtils.closeInoutDecorView(getActivity());
                    rl_daiban.setVisibility(View.VISIBLE);
                    ll_daiban.setVisibility(View.GONE);
                    refreshView(et_daiban.getText().toString().trim(), null, null);
                    et_daiban.setText("");
                }
                if (keyCode == KeyEvent.KEYCODE_DEL) {
                    if (et_daiban.getKeyListener().getInputType() == 0) {
                        return false;
                    }
                    return false;
                }
                return true;
            }
        });

        ll_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rl_daiban.setVisibility(View.VISIBLE);
                ll_daiban.setVisibility(View.GONE);
                ll_toobar1.setVisibility(View.VISIBLE);
                ll_toobar2.setVisibility(View.GONE);
                refreshLayout.autoRefresh();
            }
        });

        rl_daiban.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showLoadDialog();
                refreshView(null, null, null);
                dismissDialog();
            }
        });

        ll_beijing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                refreshLayout.autoRefresh();
                ll_beijing.setVisibility(View.GONE);
                refreshLayout.setVisibility(View.VISIBLE);
            }
        });

    }

    @Override
    protected BaseRefreshLoadMoreInterface setRefreshLoadMoreListener() {
        return new BaseRefreshLoadMoreInterface() {
            @Override
            public void onLoadMore() {
                refreshView(null, null, null);
            }

            @Override
            public void onRefresh() {
                refreshView(null, null, null);
            }
        };
    }


    @Override
    public void onResume() {
        super.onResume();
        if (refreshLayout != null) {
            refreshLayout.autoRefresh();
        }
    }

    private void refreshView(@Nullable String searchkey, @Nullable String taskState, @Nullable String taskType) {

        LogUtils.e("当前第" + pageIndex + "页");

        HashMap<String, String> hashMap = new HashMap<>();
        //是否有关键字
        if (!TextUtils.isEmpty(searchkey)) {
            hashMap.put("searchstr", searchkey);
        }

        //是否有状态
        if (!TextUtils.isEmpty(taskState)) {
            hashMap.put("state", taskState);
        }

        //是否有任务类型
        if (!TextUtils.isEmpty(taskType)) {
            hashMap.put("taskType", taskType);
        }

        hashMap.put("page", "" + pageIndex);
        if (!TextUtils.isEmpty(searchkey) || !TextUtils.isEmpty(taskState) || !TextUtils.isEmpty(taskType)) {
            hashMap.put("pageSize", "500");
        } else {
            hashMap.put("pageSize", "500");
        }
        hashMap.put("apiurl", BaseLinkList.coal_mine + BaseLinkList.todoTask);
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
                LogUtils.e("列表->>" + jsonObject.toString());

                final DealWithBean dealWithBean = FastJsonTools.getBean(jsonObject.toString(), DealWithBean.class);
                if (null != dealWithBean && null != dealWithBean.getData() && null != dealWithBean.getData().getPage() && null != dealWithBean.getData().getPage().getResults()) {
                    jiaobiaoupdate(dealWithBean.getData().getPage().getResults().size());//角标更新
                    ll_beijing.setVisibility(View.GONE);
                    refreshLayout.setVisibility(View.VISIBLE);
                    if (pageIndex > 1) {
                        if (null != dealWithBean.getData().getPage().getResults() && dealWithBean.getData().getPage().getResults().size() != 0) {
//                            results.addAll(dealWithBean.getData().getPage().getResults());
//                            BaseQuickAdapter adapter = (BaseQuickAdapter) rv_list.getAdapter();
//                            ArrayList<DealWithBean.DataBean.PageBean.ResultsBean> data = (ArrayList<DealWithBean.DataBean.PageBean.ResultsBean>) adapter.getData();
//                            for (int i = 0; i < results.size(); i++) {
//                                data.add(results.get(i));
//                                adapter.notifyItemChanged(data.size() + (i + 1), results.get(i));
//                            }
                            BaseQuickAdapter adapter = (BaseQuickAdapter) rv_list.getAdapter();
                            results.addAll(dealWithBean.getData().getPage().getResults());
                            adapter.notifyDataSetChanged();
                        } else {
                            ToastUtils.showShort("没有更多数据了!");
                        }
                    } else {
                        if (results.size() != 0) {
                            results.clear();
                        }
                        if (dealWithBean.getData().getPage().getResults().size() != 0) {
                            results.addAll(dealWithBean.getData().getPage().getResults());
                            RecyclerViewUtils.initLiner(getActivity(), rv_list, R.layout.item_deal_with_task, results, new OnGlobalListener() {
                                @Override
                                public <T> void logic(BaseViewHolder helper, List<T> mData, T item, BaseQuickAdapter mAdapter) {
                                    DealWithBean.DataBean.PageBean.ResultsBean resultsBean = (DealWithBean.DataBean.PageBean.ResultsBean) item;
                                    TextView tv_task_name = helper.getView(R.id.tv_task_name);
                                    TextView tv_title = helper.getView(R.id.tv_title);
                                    TextView tv_task_time = helper.getView(R.id.tv_task_time);
                                    ImageView iv_state = helper.getView(R.id.iv_state);
                                    ImageView iv_type = helper.getView(R.id.iv_type);

                                    if (resultsBean.getTasktype().equals("1")) {
                                        tv_title.setText(resultsBean.getTitle());
                                    } else {
                                        tv_title.setText(resultsBean.getDescription());
                                    }

                                    tv_task_time.setText(resultsBean.getTimes());
                                    //状态初始化
                                    checkTaskTypeToView(resultsBean, tv_task_name, iv_state, iv_type);
                                }
                            }, new BaseQuickAdapter.OnItemClickListener() {
                                @Override
                                public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                                    DealWithBean.DataBean.PageBean.ResultsBean resultsBean = (DealWithBean.DataBean.PageBean.ResultsBean) adapter.getData().get(position);
                                    checkTaskType(resultsBean);
                                }
                            }, null);
                        } else {
                            ll_beijing.setVisibility(View.VISIBLE);
                            refreshLayout.setVisibility(View.GONE);
                        }
                    }
                }
                if (null != refreshLayout) {
                    refreshLayout.finishRefresh();
                    refreshLayout.finishLoadMore();
                }
            }
        });
    }

    private void jiaobiaoupdate(int size) {
        int jiaobiao = size;
        EventBus.getDefault().postSticky(new MessageEvent(jiaobiao));
    }

    //逻辑处理
    private void checkTaskType(DealWithBean.DataBean.PageBean.ResultsBean resultsBean) {
        switch (resultsBean.getTasktype()) {
            //标准化检查
            case "1":
                switch (resultsBean.getStates()) {
                    case "2":
                        //待审核(标准化检查)
                        intent = new Intent();
                        intent.setClass(getActivity(), AuditActivity.class);
                        intent.putExtra("taskid", resultsBean.getId() + "");
                        startActivity(intent);
                        break;
                    case "5":
                        //待接受(标准化检查)
                        intent = new Intent();
                        intent.setClass(getActivity(), AcceptedActivity.class);
                        intent.putExtra("taskid", resultsBean.getId() + "");
                        startActivity(intent);
                        break;
                    case "7":
                        //待检查(标准化检查)
                        intent = new Intent();
                        intent.setClass(getActivity(), CheckActivity.class);
                        intent.putExtra("taskid", resultsBean.getId() + "");
                        startActivity(intent);
                        break;
                    case "9":
                        //待审阅(标准化检查)
                        intent = new Intent();
                        intent.setClass(getActivity(), ReviewActivity.class);
                        intent.putExtra("taskid", resultsBean.getId() + "");
                        startActivity(intent);
                        break;
                    default:
                }
                break;
            //隐患排查
            case "7":
                break;
            case "8"://现场治理
                switch (resultsBean.getStates()) {
                    case "2":
                        //待审核（现场治理）
                        Intent intent = new Intent(getActivity(), SiteManagementActivity.class);
                        intent.putExtra("taskId", String.valueOf(resultsBean.getId()));
                        intent.putExtra("mainTaskId", String.valueOf(resultsBean.getMainTaskId()));
                        startActivity(intent);
                        break;
                    case "3":
                        //被驳回（现场治理）
                        break;
                    default:
                }

            case "9"://限时整改
            case "10"://隐患督办
            case "11"://隐患升级
                switch (resultsBean.getTaskSource()) {
                    case 0:
                        Intent intent2 = new Intent(getActivity(), RectifyTimeLimitActivity.class);
                        intent2.putExtra("taskId", String.valueOf(resultsBean.getId()));
                        intent2.putExtra("mainTaskId", String.valueOf(resultsBean.getMainTaskId()));
                        intent2.putExtra("taskType", String.valueOf(resultsBean.getTasktype()));
                        intent2.putExtra("status", String.valueOf(resultsBean.getStates()));
                        startActivity(intent2);
                        break;
                    case 1:
                        Intent intent = new Intent(getActivity(), DetailedlistActivity.class);
                        intent.putExtra("taskId", String.valueOf(resultsBean.getId()));
                        intent.putExtra("mainTaskId", String.valueOf(resultsBean.getMainTaskId()));
                        intent.putExtra("exhibition", 0);
                        intent.putExtra("status", String.valueOf(resultsBean.getStates()));
                        startActivity(intent);
                        break;
                    default:
                }
                break;
            case "12"://重大隐患
                ToastUtils.showShort("未开发");
                break;
            case "13"://三违处理
                switch (resultsBean.getStates()) {
                    case "2"://待审核
                    case "4":
                    case "7":
                        Intent intent = new Intent(getActivity(), PreviewViolationInformationActivity.class);
                        intent.putExtra("type", "2");
                        intent.putExtra("taskId", String.valueOf(resultsBean.getId()));
                        intent.putExtra("mainTaskId", String.valueOf(resultsBean.getMainTaskId()));
                        intent.putExtra("taskType", String.valueOf(resultsBean.getTasktype()));
                        intent.putExtra("state", String.valueOf(resultsBean.getStates()));
                        startActivity(intent);
                        break;
                    default:
                }
                break;
            case "16"://风险管控
                //待检查(风险管控)
                if (resultsBean.getStates().equals("1")) {
                    if (resultsBean.getStates().equals("1")) {
                        Intent intent = new Intent(getActivity(), ImplementedActivity.class);
                        intent.putExtra("taskId", String.valueOf(resultsBean.getId()));
                        startActivity(intent);
                        break;
                    }
                }
                break;
            default:
        }
    }

    //处理View显示
    private void checkTaskTypeToView(DealWithBean.DataBean.PageBean.ResultsBean resultsBean, TextView tv_task_name, ImageView iv_state, ImageView iv_type) {
        switch (resultsBean.getTasktype()) {
            case "1"://标准化检查
                tv_task_name.setText("标准化检查");
                iv_type.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.daiban_bzhjc));
                switch (resultsBean.getStates()) {
                    case "2"://待审核(标准化检查)
                        iv_state.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.daiban_dsh));
                        break;
                    case "5"://待接受(标准化检查)
                        iv_state.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.daiban_djs));
                        break;
                    case "7"://待检查(标准化检查)
                        iv_state.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.daiban_djc));
                        break;
                    case "9"://待审阅(标准化检查)
                        iv_state.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.daiban_dsy));
                        break;
                    default:
                }
                break;
            case "7"://隐患排查
                tv_task_name.setText("隐患排查");
                iv_type.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.daiban_yhpc));
                if (resultsBean.getStates().equals("1")) {
                    //待处理(隐患排查)
                    iv_state.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.daiban_dcl));
                }
                break;
            case "8"://现场治理
                tv_task_name.setText("现场治理");
                iv_type.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.daiban_xczl));
                switch (resultsBean.getStates()) {
                    case "2"://待审核（现场治理）
                        iv_state.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.daiban_dsh));
                        break;
                    case "3"://被驳回（现场治理）
                        iv_state.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.daiban_bbh));
                        break;
                    default:
                }
                break;
            case "9"://限时整改
                switch (resultsBean.getTaskSource()) {
                    case 0:
                        tv_task_name.setText("限时整改（隐患排查）");
                        break;
                    case 1:
                        tv_task_name.setText("限时整改(标准化检查)");
                        break;
                    default:
                }
                iv_type.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.daiban_xszg));
                switch (resultsBean.getStates()) {
                    case "2": //待审核（限时整改）
                        iv_state.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.daiban_dsh));
                        break;
                    case "3"://被驳回（限时整改）
                        iv_state.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.daiban_bbh));
                        break;
                    case "4"://待确认（限时整改）
                        iv_state.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.daiban_dqr));
                        break;
                    case "5"://待整改（限时整改）
                        iv_state.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.daiban_dzg));
                        break;
                    case "6"://待验收（限时整改）
                        iv_state.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.daiban_dys));
                        break;
                    case "7"://验收驳回（限时整改）
                        iv_state.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.daiban_ysbh));
                        break;
                    case "11"://延期待审核（限时整改）
                        iv_state.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.daiban_yqdsh));
                        break;
                    case "12"://延期待审核（限时整改）
                        iv_state.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.daiban_yqdsh));
                        break;
                    default:
                }
                break;
            case "10"://隐患督办
                switch (resultsBean.getTaskSource()) {
                    case 0:
                        tv_task_name.setText("挂牌督办（隐患排查）");
                        break;
                    case 1:
                        tv_task_name.setText("挂牌督办(标准化检查)");
                        break;
                    default:
                }
                iv_type.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.daiban_yhdb));
                switch (resultsBean.getStates()) {
                    case "2"://待审核（隐患督办）
                        iv_state.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.daiban_dsh));
                        break;
                    case "3"://被驳回（隐患督办）
                        iv_state.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.daiban_bbh));
                        break;
                    case "4"://待确认（隐患督办）
                        iv_state.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.daiban_dqr));
                        break;
                    case "5": //待整改（隐患督办）
                        iv_state.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.daiban_dzg));
                        break;
                    case "6"://待验收（隐患督办）
                        iv_state.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.daiban_dys));
                        break;
                    case "7"://验收驳回（隐患督办）
                        iv_state.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.daiban_ysbh));
                        break;
                    case "11"://延期待审核（隐患督办）
                        iv_state.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.daiban_yqdsh));
                        break;
                    //延期待审核（隐患督办） 废除
                    case "12":
                        iv_state.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.daiban_yqdsh));
                        break;
                    default:
                }
                break;
            case "11"://隐患升级
                tv_task_name.setText("隐患升级");
                if (resultsBean.getStates().equals("2")) {
                    //待审核
                    iv_state.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.daiban_dsh));
                }
                break;
            case "12"://重大隐患
                tv_task_name.setText("重大隐患");
                if (resultsBean.getStates().equals("2")) {
                    //待审核（重大隐患）
                    iv_state.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.daiban_dsh));
                }
                break;
            case "13"://三违处理
                tv_task_name.setText("三违处理");
                iv_type.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.daiban_jwcl));
                switch (resultsBean.getStates()) {
                    case "2"://待审核(三违处理)
                        iv_state.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.daiban_dsh));
                        break;
                    case "4"://待确认(三违处理)
                        iv_state.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.daiban_dqr));
                        break;
                    case "7"://待审阅(三违处理)
                        iv_state.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.daiban_dsy));
                        break;
                    default:
                }
                break;
            case "16"://风险管控
                tv_task_name.setText("风险管控");
                iv_type.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.daiban_fxgk));
                if (resultsBean.getStates().equals("1")) {
                    //待检查
                    iv_state.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.daiban_dls));
                    break;
                }
                break;
            default:
        }
    }

    @OnClick({R.id.ll_1, R.id.ll_2, R.id.ll_3, R.id.ll_5, R.id.ll_8, R.id.ll_9})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_1://现场治理
                rl_daiban.setVisibility(View.VISIBLE);
                ll_daiban.setVisibility(View.GONE);
                refreshView(null, null, "8");
                break;
            case R.id.ll_2://风险管控
                rl_daiban.setVisibility(View.VISIBLE);
                ll_daiban.setVisibility(View.GONE);
                refreshView(null, null, "16");
                break;
            case R.id.ll_3://限时整改
                rl_daiban.setVisibility(View.VISIBLE);
                ll_daiban.setVisibility(View.GONE);
                refreshView(null, null, "9");
                break;
            case R.id.ll_5://隐患督办
                rl_daiban.setVisibility(View.VISIBLE);
                ll_daiban.setVisibility(View.GONE);
                refreshView(null, null, "10");
                break;
            case R.id.ll_8://三违处理
                rl_daiban.setVisibility(View.VISIBLE);
                ll_daiban.setVisibility(View.GONE);
                refreshView(null, null, "13");
                break;
            case R.id.ll_9://标准化检查
                rl_daiban.setVisibility(View.VISIBLE);
                ll_daiban.setVisibility(View.GONE);
                refreshView(null, null, "1");
                break;
            default:
        }
    }

    public static class SoftKeyboardUtils {
        /**
         * 关闭软件盘
         */
        public static void closeInoutDecorView(Activity activity) {
            View view = activity.getWindow().peekDecorView();
            InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }
}
