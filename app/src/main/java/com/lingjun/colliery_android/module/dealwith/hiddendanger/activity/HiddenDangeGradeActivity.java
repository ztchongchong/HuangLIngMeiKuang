package com.lingjun.colliery_android.module.dealwith.hiddendanger.activity;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lingjun.colliery_android.R;
import com.lingjun.colliery_android.base.BaseActivity;
import com.lingjun.colliery_android.base.BaseLinkList;
import com.lingjun.colliery_android.base.OnGlobalListener;
import com.lingjun.colliery_android.bean.HiddenDangeGradeBean;
import com.lingjun.colliery_android.bean.HiddenDangerPlanBean;
import com.lingjun.colliery_android.bean.HiddenDangersDetailsBean;
import com.lingjun.colliery_android.bean.UnsafeBehaviorInfoBean;
import com.lingjun.colliery_android.module.dealwith.hiddendanger.general_hidden_danger.HiddenDangerPlanActivity;
import com.lingjun.colliery_android.module.main.SelectPersonnelActivity;
import com.lingjun.colliery_android.module.main.SelectReviewerActivity;
import com.lingjun.colliery_android.module.main.rectifyingviolations.UnsafeBehaviorActivity;
import com.lingjun.colliery_android.utils.FastJsonTools;
import com.lingjun.colliery_android.utils.RecyclerViewUtils;
import com.lingjun.colliery_android.utils.retrofit.BaseSubscriber;
import com.lingjun.colliery_android.utils.retrofit.ExceptionHandle;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;


/**
 * 隐患等级
 */
public class HiddenDangeGradeActivity extends BaseActivity {
    public static final int RectifyingCode = 11;

    private RecyclerView rv_list;
    private SmartRefreshLayout refreshLayout;
    private LinearLayout ll_beijing;

    @Override
    protected int getResourcesId() {
        return R.layout.activity_hidden_dange_grade;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        rv_list = findViewById(R.id.rv_list);
        refreshLayout = findViewById(R.id.refreshLayout);
        ll_beijing = findViewById(R.id.ll_beijing);
        refreshView();//刷新
    }

    @Override
    protected BaseRefreshLoadMoreInterface setRefreshLoadMoreListener() {
//        return new BaseRefreshLoadMoreInterface() {
//            @Override
//            public void onLoadMore() {
//                refreshView();
//            }
//
//            @Override
//            public void onRefresh() {
//                refreshView();
//            }
//        };

        return null;
    }

    private void refreshView() {
        LogUtils.e("当前第" + pageIndex + "页");

        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("levelType", "0");
        hashMap.put(BaseLinkList.apiurl, BaseLinkList.coal_mine + BaseLinkList.hidden_grade);

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
                LogUtils.e("隐患等级->>" + jsonObject.toString());

                final HiddenDangeGradeBean hiddenDangeGradeBean = FastJsonTools.getBean(jsonObject.toString(), HiddenDangeGradeBean.class);
                if (null != hiddenDangeGradeBean && null != hiddenDangeGradeBean.getMsg() && null != hiddenDangeGradeBean.getCode() && null != hiddenDangeGradeBean.getResultMaps()) {
                    final ArrayList<HiddenDangeGradeBean.ResultMapsBean> results = (ArrayList<HiddenDangeGradeBean.ResultMapsBean>) hiddenDangeGradeBean.getResultMaps();
                    final HiddenDangeGradeBean.ResultMapsBean resBean = results.get(0);
                    if (results.size() != 0) {
                        refreshLayout.setVisibility(View.VISIBLE);
                        ll_beijing.setVisibility(View.GONE);
                        if (pageIndex > 1) {
                            if (null != results && results.size() != 0) {
                                BaseQuickAdapter adapter = (BaseQuickAdapter) rv_list.getAdapter();
                                ArrayList<HiddenDangeGradeBean.ResultMapsBean> data = (ArrayList<HiddenDangeGradeBean.ResultMapsBean>) adapter.getData();
                                if (data.size() != 0 && data != null) {
                                    data.clear();
                                }
                                for (int i = 0; i < results.size(); i++) {
                                    data.add(results.get(i));
                                    adapter.notifyItemChanged(data.size() + (i + 1), results.get(i));
                                }
                            } else {
                                ToastUtils.showShort("没有更多数据了!");
                            }
                        } else {
                            RecyclerViewUtils.initLiner(HiddenDangeGradeActivity.this, rv_list, R.layout.item_hidden_danger_paln, results, new OnGlobalListener() {
                                @Override
                                public <T> void logic(BaseViewHolder helper, List<T> mData, T item, BaseQuickAdapter mAdapter) {
                                    HiddenDangeGradeBean.ResultMapsBean resultsBean = (HiddenDangeGradeBean.ResultMapsBean) item;
                                    TextView ll_plan = helper.getView(R.id.ll_plan);
                                    ll_plan.setText(resultsBean.getName());

                                }
                            }, new BaseQuickAdapter.OnItemClickListener() {
                                @Override
                                public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                                    HiddenDangeGradeBean.ResultMapsBean resultsBean = (HiddenDangeGradeBean.ResultMapsBean) adapter.getData().get(position);

                                    Intent intent = new Intent();
                                    intent.putExtra("name", "" + resultsBean.getName());
                                    intent.putExtra("slight", "" + resultsBean.isSlight());
                                    intent.putExtra("troubleLevelId",""+resultsBean.getId());
                                    setResult(RectifyingCode, intent);
                                    finish();
                                }
                            }, null);
                        }
                    } else {
                        refreshLayout.setVisibility(View.GONE);
                        ll_beijing.setVisibility(View.VISIBLE);
                    }
                }

                if (null != refreshLayout) {
                    refreshLayout.finishRefresh();
                    refreshLayout.finishLoadMore();
                }
            }
        });
    }

}
