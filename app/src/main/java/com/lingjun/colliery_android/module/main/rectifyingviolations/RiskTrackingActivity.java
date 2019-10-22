package com.lingjun.colliery_android.module.main.rectifyingviolations;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lingjun.colliery_android.R;
import com.lingjun.colliery_android.base.BaseActivity;
import com.lingjun.colliery_android.base.BaseLinkList;
import com.lingjun.colliery_android.base.OnGlobalListener;
import com.lingjun.colliery_android.bean.HiddenDangersHandleBean;
import com.lingjun.colliery_android.bean.RiskTrackingBean;
import com.lingjun.colliery_android.module.dealwith.hiddendanger.activity.HiddenDangersHandleActivity;
import com.lingjun.colliery_android.module.main.SelectPersonnelActivity;
import com.lingjun.colliery_android.utils.DateUtil;
import com.lingjun.colliery_android.utils.FastJsonTools;
import com.lingjun.colliery_android.utils.RecyclerViewUtils;
import com.lingjun.colliery_android.utils.retrofit.BaseSubscriber;
import com.lingjun.colliery_android.utils.retrofit.ExceptionHandle;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import io.reactivex.annotations.Nullable;

/**
 * 作者: zengtao
 * 时间: 2019/4/29  15:51.
 * 注释: 风险跟踪
 */
public class RiskTrackingActivity extends BaseActivity {

    private RecyclerView rv_list;
    private SmartRefreshLayout refreshLayout;
    private LinearLayout ll_beijing;

    private ImageView iv_screen;
    private PopupWindow window;

    //搜索
    private ImageView iv_hint;
    private ImageView iv_clear;
    private EditText et_earch;
    private TextView tv_normal;
    private TextView tv_abnormal;
    private TextView tv_not_checked;
    private TextView tv_reset;
    private TextView tv_search;
    private ArrayList<RiskTrackingBean.DataBean.PageBean.ResultsBean> results = new ArrayList<>();

    @Override
    protected int getResourcesId() {
        return R.layout.activity_risktracking;
    }

    @Override
    protected void init(Bundle savedInstanceState) throws PackageManager.NameNotFoundException {
        rv_list = findViewById(R.id.rv_list);
        refreshLayout = findViewById(R.id.refreshLayout);
        ll_beijing = findViewById(R.id.ll_beijing);
        iv_screen = findViewById(R.id.iv_screen);
        ll_beijing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                refreshLayout.autoRefresh();
            }
        });
        pop_search();//搜索
    }

    @SuppressLint("ClickableViewAccessibility")
    private void pop_search() {
        iv_screen.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                // 构建一个popupwindow的布局
                final View popupView = getLayoutInflater().inflate(R.layout.pop_risk_tracking, null);
                //  为了演示效果，简单的设置了一些数据，实际中大家自己设置数据即可，相信大家都会。
                //  创建PopupWindow对象，指定宽度和高度
                window = new PopupWindow(popupView, LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                //   设置动画
                window.setAnimationStyle(R.style.AnimationFade);
                //  设置背景颜色
                window.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#FFFFFF")));
                //  设置可以获取焦点
                window.setFocusable(true);
                //  设置可以触摸弹出框以外的区域
                window.setOutsideTouchable(true);
                // 更新popupwindow的状态
                window.update();
                //  以下拉的方式显示，并且可以设置显示的位置
                window.showAsDropDown(iv_screen, 0, 40);
                //
                window.showAtLocation(getLayoutInflater().inflate(R.layout.activity_select_personnel, null), Gravity.RIGHT, 0, 500);

                iv_hint = popupView.findViewById(R.id.iv_hint);//搜索
                iv_clear = popupView.findViewById(R.id.iv_clear);//清除
                et_earch = popupView.findViewById(R.id.et_earch);//输入框
                tv_normal = popupView.findViewById(R.id.tv_normal);//正常
                tv_abnormal = popupView.findViewById(R.id.tv_abnormal);//异常
                tv_not_checked = popupView.findViewById(R.id.tv_not_checked);//未检查
                tv_reset = popupView.findViewById(R.id.tv_reset);//重置
                tv_search = popupView.findViewById(R.id.tv_search);//确定搜索

                View.OnClickListener onClickListener = new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        switch (view.getId()) {
                            case R.id.iv_hint:
                                break;
                            case R.id.iv_clear://清除
                                et_earch.setText("");
                                break;
                            case R.id.tv_normal://正常
                                window.dismiss();
                                refreshView("1", null);
                                break;
                            case R.id.tv_abnormal://异常
                                window.dismiss();
                                refreshView("2", null);
                                break;
                            case R.id.tv_not_checked://未检查
                                window.dismiss();
                                refreshView("0", null);
                                break;
                            case R.id.tv_reset://重置
                                et_earch.setText("");
                                break;
                            case R.id.tv_search://确定
                                if (!TextUtils.isEmpty(et_earch.getText().toString().trim())) {
                                    window.dismiss();
                                    refreshView(null, et_earch.getText().toString().trim());
                                } else {
                                    com.lingjun.colliery_android.utils.ToastUtils.showToast(RiskTrackingActivity.this, "关键词不能为空");
                                    return;
                                }
                                break;
                            default:
                        }
                    }
                };

                iv_hint.setOnClickListener(onClickListener);
                iv_clear.setOnClickListener(onClickListener);
                et_earch.setOnClickListener(onClickListener);
                tv_normal.setOnClickListener(onClickListener);
                tv_abnormal.setOnClickListener(onClickListener);
                tv_not_checked.setOnClickListener(onClickListener);
                tv_reset.setOnClickListener(onClickListener);
                tv_search.setOnClickListener(onClickListener);

                return false;
            }
        });
    }

    @Override
    protected BaseRefreshLoadMoreInterface setRefreshLoadMoreListener() {
        return new BaseRefreshLoadMoreInterface() {
            @Override
            public void onLoadMore() {
                refreshView(null, null);
            }

            @Override
            public void onRefresh() {
                refreshView(null, null);
            }
        };
    }

    private void refreshView(@Nullable String state, @Nullable String keyword) {
        LogUtils.e("当前第" + pageIndex + "页");

        HashMap<String, String> hashMap = new HashMap<>();
        if (!TextUtils.isEmpty(state)) {
            hashMap.put("checkstate", state);
        }
        if (!TextUtils.isEmpty(keyword)) {
            hashMap.put("searchstr", keyword);
        }
        if (!TextUtils.isEmpty(state) || !TextUtils.isEmpty(keyword)) {
            pageIndex = 1;
            hashMap.put("page", pageIndex + "");
            hashMap.put("pageSize", "500");
        } else {
            hashMap.put("page", "" + pageIndex);
            hashMap.put("pageSize", "10");
        }
        hashMap.put(BaseLinkList.apiurl, BaseLinkList.coal_mine + BaseLinkList.getRiskList);

        mRetrofit.JsonToColliery(BaseLinkList.Base_Url, hashMap, new BaseSubscriber() {
            @Override
            public void onError(ExceptionHandle.ResponeThrowable e) {
                refreshLayout.setVisibility(View.GONE);
                ll_beijing.setVisibility(View.VISIBLE);
                if (null != refreshLayout) {
                    refreshLayout.finishRefresh();
                    refreshLayout.finishLoadMore();
                }
            }

            @Override
            public void onSuccess(JSONObject jsonObject) {
                LogUtils.e("列表->>" + jsonObject.toString());
                final RiskTrackingBean riskTrackingBean = FastJsonTools.getBean(jsonObject.toString(), RiskTrackingBean.class);
                if (null != riskTrackingBean && null != riskTrackingBean.getData()) {
                    refreshLayout.setVisibility(View.VISIBLE);
                    ll_beijing.setVisibility(View.GONE);
                    if (pageIndex > 1) {
                        if (null != riskTrackingBean.getData().getPage().getResults() && riskTrackingBean.getData().getPage().getResults().size() != 0) {
//                            if (riskTrackingBean.getData().getPage().getResults().size() != 0) {
//                                results.addAll(riskTrackingBean.getData().getPage().getResults());
//                                BaseQuickAdapter adapter = (BaseQuickAdapter) rv_list.getAdapter();
//                                adapter.setNewData(results);
//                            } else {
//                                ToastUtils.showShort("没有更多数据了!");
//                            }
//                            ArrayList<RiskTrackingBean.DataBean.PageBean.ResultsBean> data = (ArrayList<RiskTrackingBean.DataBean.PageBean.ResultsBean>) adapter.getData();
//                            for (int i = 0; i < results.size(); i++) {
//                                data.add(results.get(i));
//                                adapter.notifyItemChanged(data.size() + (i + 1), results.get(i));
//                            }
                            BaseQuickAdapter adapter = (BaseQuickAdapter) rv_list.getAdapter();
                            results.addAll(riskTrackingBean.getData().getPage().getResults());
                            adapter.notifyDataSetChanged();
                        } else {
                            com.blankj.utilcode.util.ToastUtils.showShort("没有更多数据了!");
                        }
                    } else {
                        if (results.size() != 0) {
                            results.clear();
                        }
                        if (riskTrackingBean.getData().getPage().getResults().size() != 0) {
                            results = (ArrayList<RiskTrackingBean.DataBean.PageBean.ResultsBean>) riskTrackingBean.getData().getPage().getResults();
                            RecyclerViewUtils.initLiner(RiskTrackingActivity.this, rv_list, R.layout.item_risk_tracking, results, new OnGlobalListener() {
                                @SuppressLint("ResourceAsColor")
                                @Override
                                public <T> void logic(BaseViewHolder helper, List<T> mData, T item, BaseQuickAdapter mAdapter) {
                                    RiskTrackingBean.DataBean.PageBean.ResultsBean resultsBean = (RiskTrackingBean.DataBean.PageBean.ResultsBean) item;
                                    TextView tv_name = helper.getView(R.id.tv_name);//标题
                                    TextView tv_state = helper.getView(R.id.tv_state);//状态
                                    TextView tv_people = helper.getView(R.id.tv_people);//管控人
                                    TextView tv_last_time = helper.getView(R.id.tv_last_time);//上次时间
                                    TextView tv_next_time = helper.getView(R.id.tv_next_time);//下次时间
                                    TextView tv_content = helper.getView(R.id.tv_content);//内容

                                    tv_name.setText(resultsBean.getRiskcontrolCategoryName());//标题
                                    if (resultsBean.getImplementState() == 0) {//状态
                                        tv_state.setText("未检查");
                                        tv_state.setTextColor(R.color.state_wjc);
                                        tv_state.setBackgroundResource(R.drawable.state_wjc);
                                    } else if (resultsBean.getImplementState() == 1) {
                                        tv_state.setText("合格");
                                        tv_state.setTextColor(R.color.state_zc);
                                        tv_state.setBackgroundResource(R.drawable.state_zc);
                                    } else if (resultsBean.getImplementState() == 2) {
                                        tv_state.setText("不合格");
                                        tv_state.setTextColor(R.color.state_yc);
                                        tv_state.setBackgroundResource(R.drawable.state_yc);
                                    }
                                    tv_people.setText(resultsBean.getMeasures().getResponsibleName());//管控人
                                    tv_last_time.setText(resultsBean.getMeasures().getLastCheckdate()); //上次时间
                                    tv_next_time.setText(resultsBean.getMeasures().getNextCheckdate());//下次时间
                                    tv_content.setText(resultsBean.getRiskcontrolSourceDescription()); //内容

                                }
                            }, new BaseQuickAdapter.OnItemClickListener() {
                                @SuppressLint("ResourceType")
                                @Override
                                public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                                    RiskTrackingBean.DataBean.PageBean.ResultsBean resultsBean = (RiskTrackingBean.DataBean.PageBean.ResultsBean) adapter.getData().get(position);
                                    Intent intent = new Intent(RiskTrackingActivity.this, RiskTrackingsActivity.class);
                                    intent.putExtra("id", resultsBean.getId() + "");
                                    startActivity(intent);
                                }
                            }, null);
                        } else {
                            refreshLayout.setVisibility(View.GONE);
                            ll_beijing.setVisibility(View.VISIBLE);
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

    @Override
    public void onResume() {
        super.onResume();
        if (refreshLayout != null) {
            refreshLayout.autoRefresh();
        }
    }
}
