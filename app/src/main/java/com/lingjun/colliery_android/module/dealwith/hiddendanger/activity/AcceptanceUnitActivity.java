package com.lingjun.colliery_android.module.dealwith.hiddendanger.activity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lingjun.colliery_android.R;
import com.lingjun.colliery_android.base.BaseActivity;
import com.lingjun.colliery_android.base.BaseLinkList;
import com.lingjun.colliery_android.base.OnGlobalListener;
import com.lingjun.colliery_android.bean.AcceptanceUnitBean;
import com.lingjun.colliery_android.bean.KeyWordBean;
import com.lingjun.colliery_android.module.dealwith.activity.KeyWordActivity;
import com.lingjun.colliery_android.utils.FastJsonTools;
import com.lingjun.colliery_android.utils.RecyclerViewUtils;
import com.lingjun.colliery_android.utils.retrofit.BaseSubscriber;
import com.lingjun.colliery_android.utils.retrofit.ExceptionHandle;

import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 作者: zengtao
 * 时间: 2019/4/25  9:49.
 * 注释: 验收单位
 */
public class AcceptanceUnitActivity extends BaseActivity {

    public static final int HiddenDangerCode = 322;

    private RecyclerView rv_list;
    private LinearLayout ll_beijing;
    private TextView tv_num;
    private Button btn_queding;

    private ArrayList<AcceptanceUnitBean.DataBean.ResultMapBean> resultMapBeans = new ArrayList<>();
    private TextView tv_biaoji;

    @Override
    protected int getResourcesId() {
        return R.layout.activity_keyword;
    }

    @Override
    protected void init(Bundle savedInstanceState) throws PackageManager.NameNotFoundException {
        rv_list = findViewById(R.id.rv_list);
        btn_queding = findViewById(R.id.btn_queding);
        tv_num = findViewById(R.id.tv_num);
        tv_biaoji = findViewById(R.id.tv_biaoji);
        ll_beijing = findViewById(R.id.ll_beijing);
        tv_biaoji.setText("验收单位");
        btn_queding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (resultMapBeans.size() == 0) {
                    ToastUtils.showShort("至少选择一个验收单位");
                    return;
                } else {
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    TestBean testBean = new TestBean();
                    testBean.arrayList = resultMapBeans;
                    bundle.putSerializable("acceptanceunit", testBean);
                    intent.putExtra("bundle", bundle);
                    setResult(AcceptanceUnitActivity.HiddenDangerCode, intent);
                    finish();
                }
            }
        });
        refreshView();
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
        hashMap.put(BaseLinkList.apiurl, BaseLinkList.coal_mine + BaseLinkList.getSelectAcceptDeparment);
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

                final AcceptanceUnitBean acceptanceUnitBean = FastJsonTools.getBean(jsonObject.toString(), AcceptanceUnitBean.class);
                if (null != acceptanceUnitBean && null != acceptanceUnitBean.getMsg() && null != acceptanceUnitBean.getCode()) {
                    if (acceptanceUnitBean.getData().getResultMap().size() != 0) {
                        final ArrayList<AcceptanceUnitBean.DataBean.ResultMapBean> results = (ArrayList<AcceptanceUnitBean.DataBean.ResultMapBean>) acceptanceUnitBean.getData().getResultMap();
                        RecyclerViewUtils.initLiner(AcceptanceUnitActivity.this, rv_list, R.layout.item_hidden_danger_paln, results, new OnGlobalListener() {
                            @Override
                            public <T> void logic(BaseViewHolder helper, List<T> mData, T item, BaseQuickAdapter mAdapter) {
                                AcceptanceUnitBean.DataBean.ResultMapBean resultsBean = (AcceptanceUnitBean.DataBean.ResultMapBean) item;
                                RelativeLayout rl_plan = helper.getView(R.id.rl_plan);
                                TextView ll_plan = helper.getView(R.id.ll_plan);
                                ll_plan.setText(resultsBean.getName());
                                if (!resultsBean.isType()) {
                                    rl_plan.setBackgroundResource(R.drawable.shape_bg_gray);
                                } else {
                                    rl_plan.setBackgroundResource(R.drawable.shape_bg_blue);
                                }
                            }
                        }, new BaseQuickAdapter.OnItemClickListener() {
                            @Override
                            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                                AcceptanceUnitBean.DataBean.ResultMapBean resultsBean = (AcceptanceUnitBean.DataBean.ResultMapBean) adapter.getData().get(position);
                                if (resultsBean.isType()) {
                                    resultsBean.setType(false);
                                    resultMapBeans.remove(resultsBean);
                                } else {
                                    resultsBean.setType(true);
                                    resultMapBeans.add(resultsBean);
                                }
                                adapter.notifyItemChanged(position);
                                tv_num.setText("" + (resultMapBeans.size()));
                            }
                        }, null);
                    }
                } else {
                    refreshLayout.setVisibility(View.VISIBLE);
                    ll_beijing.setVisibility(View.GONE);
                }
                if (null != refreshLayout) {
                    refreshLayout.finishRefresh();
                    refreshLayout.finishLoadMore();
                }
            }
        });
    }

    public static class TestBean implements Serializable {
        public ArrayList<AcceptanceUnitBean.DataBean.ResultMapBean> arrayList;
    }
}
