package com.lingjun.colliery_android.module.dealwith.hiddendanger.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.blankj.utilcode.util.LogUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lingjun.colliery_android.R;
import com.lingjun.colliery_android.base.BaseActivity;
import com.lingjun.colliery_android.base.BaseLinkList;
import com.lingjun.colliery_android.base.OnGlobalListener;
import com.lingjun.colliery_android.bean.RectifyHistoryBean;
import com.lingjun.colliery_android.bean.SurveyRecordBean;
import com.lingjun.colliery_android.module.dealwith.hiddendanger.general_hidden_danger.HiddenDangerContentActivity;
import com.lingjun.colliery_android.module.dealwith.hiddendanger.general_hidden_danger.HiddenDangerPlanActivity;
import com.lingjun.colliery_android.module.dealwith.hiddendanger.general_hidden_danger.HiddenDangerPositionActivity;
import com.lingjun.colliery_android.module.dealwith.hiddendanger.general_hidden_danger.HiddenDangerRegionActivity;
import com.lingjun.colliery_android.module.main.rectifyingviolations.RectifyingViolationsManagementActivity;
import com.lingjun.colliery_android.module.main.rectifyingviolations.ToBeStoredActivity;
import com.lingjun.colliery_android.utils.FastJsonTools;
import com.lingjun.colliery_android.utils.RecyclerViewUtils;
import com.lingjun.colliery_android.utils.ToastUtils;
import com.lingjun.colliery_android.utils.retrofit.BaseSubscriber;
import com.lingjun.colliery_android.utils.retrofit.ExceptionHandle;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 作者: zengtao
 * 时间: 2018/12/25  15:17.
 * 注释: 三违历史
 */
public class RectifyHistoryActivity extends BaseActivity {

    @BindView(R.id.rv_list)
    RecyclerView rv_list;
    private LinearLayout ll_beijing;
    private ArrayList<RectifyHistoryBean.DataBean.PageBean.ResultsBean> results = new ArrayList<>();

    @Override
    protected int getResourcesId() {
        return R.layout.activity_rectify_history;
    }

    @Override
    protected void init(Bundle savedInstanceState) throws PackageManager.NameNotFoundException {
        refreshLayout = findViewById(R.id.refreshLayout);
        ll_beijing = findViewById(R.id.ll_beijing);
        ll_beijing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                refreshLayout.autoRefresh();
                refreshLayout.setVisibility(View.VISIBLE);
                ll_beijing.setVisibility(View.GONE);
            }
        });
    }

    @Override
    protected BaseRefreshLoadMoreInterface setRefreshLoadMoreListener() {
        return new BaseRefreshLoadMoreInterface() {
            @Override
            public void onLoadMore() {
                refreshView();
            }

            @Override
            public void onRefresh() {
                refreshView();
            }
        };
    }

    private void refreshView() {
        LogUtils.e("当前第" + pageIndex + "页");

        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(BaseLinkList.apiurl, BaseLinkList.coal_mine + BaseLinkList.disobeyhistorylist);
        hashMap.put("page", "" + pageIndex);
        hashMap.put("pageSize", "10");

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
                LogUtils.e("三违历史列表->>" + jsonObject.toString());

                final RectifyHistoryBean rectifyHistoryBean = FastJsonTools.getBean(jsonObject.toString(), RectifyHistoryBean.class);
                if (null != rectifyHistoryBean && null != rectifyHistoryBean.getData() && !TextUtils.isEmpty(rectifyHistoryBean.getData() + "")) {
                    refreshLayout.setVisibility(View.VISIBLE);
                    ll_beijing.setVisibility(View.GONE);
                    if (pageIndex > 1) {
                        if (null != rectifyHistoryBean.getData().getPage().getResults() && rectifyHistoryBean.getData().getPage().getResults().size() != 0) {
                            BaseQuickAdapter adapter = (BaseQuickAdapter) rv_list.getAdapter();
//                            ArrayList<RectifyHistoryBean.DataBean.PageBean.ResultsBean> data = (ArrayList<RectifyHistoryBean.DataBean.PageBean.ResultsBean>) adapter.getData();
//                            for (int i = 0; i < results.size(); i++) {
//                                data.add(results.get(i));
//                                adapter.notifyItemChanged(data.size() + (i + 1), results.get(i));
//                            }
                            results.addAll(rectifyHistoryBean.getData().getPage().getResults());
                            adapter.notifyDataSetChanged();
                        } else {
                            com.blankj.utilcode.util.ToastUtils.showShort("没有更多数据了!");
                        }
                    } else {
                        if (results.size() != 0) {
                            results.clear();
                        }
                        if (rectifyHistoryBean.getData().getPage().getResults().size() != 0) {
                            results.addAll(rectifyHistoryBean.getData().getPage().getResults());
                            RecyclerViewUtils.initLiner(RectifyHistoryActivity.this, rv_list, R.layout.item_rectify_history, results, new OnGlobalListener() {
                                @Override
                                public <T> void logic(BaseViewHolder helper, List<T> mData, T item, BaseQuickAdapter mAdapter) {
                                    RectifyHistoryBean.DataBean.PageBean.ResultsBean resultsBean = (RectifyHistoryBean.DataBean.PageBean.ResultsBean) item;

                                    TextView tv_rectify_name = helper.getView(R.id.tv_rectify_name);//标题
                                    ImageView iv_rectify_state = helper.getView(R.id.iv_rectify_state);//状态
                                    TextView tv_rectify_content = helper.getView(R.id.tv_rectify_content);//内容
                                    TextView tv_rectify_time = helper.getView(R.id.tv_rectify_time);//时间
                                    TextView tv_rectify_responsible = helper.getView(R.id.tv_rectify_responsible);//责任单位
                                    TextView tv_rectify_leader = helper.getView(R.id.tv_rectify_leader);//领导人

                                    String t1 = new SimpleDateFormat("yyyy年MM月dd日").format(new Date(resultsBean.getStartTime()));

                                    tv_rectify_time.setText(t1);
                                    tv_rectify_content.setText(resultsBean.getBehavior());//内容
                                    tv_rectify_leader.setText("领导: " + resultsBean.getResponsibleLeaderName());
                                    tv_rectify_name.setText(resultsBean.getResponsibleUserName());
                                    tv_rectify_responsible.setText(resultsBean.getResponsibleDepartmentName());

                                    rectify_state(resultsBean, iv_rectify_state);


                                }
                            }, new BaseQuickAdapter.OnItemClickListener() {
                                @SuppressLint("ResourceType")
                                @Override
                                public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                                    RectifyHistoryBean.DataBean.PageBean.ResultsBean resultsBean = (RectifyHistoryBean.DataBean.PageBean.ResultsBean) adapter.getData().get(position);

                                    Intent intent = new Intent(RectifyHistoryActivity.this, ToBeStoredActivity.class);
                                    intent.putExtra("taskId", "" + resultsBean.getTaskId());
                                    intent.putExtra("state", "" + resultsBean.getState());
                                    intent.putExtra("extraType", "" + resultsBean.getExtraType());
                                    intent.putExtra("deleted", "" + resultsBean.getDeleted());
                                    intent.putExtra("jiuwei", "1");
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

    private void rectify_state(RectifyHistoryBean.DataBean.PageBean.ResultsBean resultsBean, ImageView iv_rectify_state) {
        if (resultsBean.getDeleted().equals("2")) {
            iv_rectify_state.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.rectify_ygb));
        } else {
            switch (resultsBean.getState()) {
                //草稿
                case "1":
                    iv_rectify_state.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.rectify_cg));
                    break;
                //审核中
                case "2":
                    iv_rectify_state.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.rectify_shz));
                    break;
                //被驳回
                case "3":
                    iv_rectify_state.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.rectify_bbh));
                    break;
                //确认中
                case "4":
                    iv_rectify_state.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.rectify_qrz));
                    break;
                //学习中
                case "5":
                    iv_rectify_state.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.rectify_xxz));
                    break;
                //被申诉
                case "6":
                    iv_rectify_state.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.rectify_bss));
                    break;
                //审阅中
                case "7":
                    iv_rectify_state.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.rectify_syz));
                    break;
                //带存储
                case "8":
                    iv_rectify_state.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.rectify_dcc));
                    break;
                //已存储
                case "9":
                    iv_rectify_state.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.rectify_yxh));
                    break;
                //已归档`
                case "10":
                    iv_rectify_state.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.rectify_ygd));
                    break;
                default:
            }
        }

    }

    @Override
    protected void onResume() {
        refreshView();
        super.onResume();
    }
}
