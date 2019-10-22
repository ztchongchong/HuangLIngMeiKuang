package com.lingjun.colliery_android.module.dealwith.hiddendanger.activity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
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
import com.lingjun.colliery_android.bean.PersonLiableBean;
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
 * 时间: 2019/4/28  9:59.
 * 注释: 验收人
 */
public class AcceptorActivity extends BaseActivity {
    public static final int HiddenDangerCode = 232;

    private RecyclerView rv_list;
    private TextView tv_num;
    private Button btn_queding;

    private ArrayList<String> list = new ArrayList<>();
    private ArrayList<PersonLiableBean.DataBean.PageBean.ResultsBean> resultMapBeans = new ArrayList<>();
    private String acceptanceunitid;
    private TextView tv_biaoji;

    @Override
    protected int getResourcesId() {
        return R.layout.activity_keyword;
    }

    @Override
    protected void init(Bundle savedInstanceState) throws PackageManager.NameNotFoundException {

        acceptanceunitid = getIntent().getStringExtra("acceptanceunitid");
        Log.e("验收人获取的ID", acceptanceunitid + "");
        rv_list = findViewById(R.id.rv_list);
        btn_queding = findViewById(R.id.btn_queding);
        tv_num = findViewById(R.id.tv_num);
        tv_biaoji = findViewById(R.id.tv_biaoji);
        tv_biaoji.setText("验收人");

        btn_queding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (resultMapBeans.size() != 0) {
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    TestBean testBean = new TestBean();
                    testBean.arrayList = resultMapBeans;
                    bundle.putSerializable("acceptance", testBean);
                    intent.putExtra("bundle", bundle);
                    setResult(AcceptorActivity.HiddenDangerCode, intent);
                    finish();
                } else {
                    ToastUtils.showShort("至少选择一个验收人");
                    return;
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
        hashMap.put("page", pageIndex + "");
        hashMap.put("pageSize", "500");
        String a = acceptanceunitid.replace("[", "").replace("]", "").replace(" ", "");
        hashMap.put("departmentid", a);
        hashMap.put(BaseLinkList.apiurl, BaseLinkList.coal_mine + BaseLinkList.getUserByDepartmentId);

        mRetrofit.JsonToColliery(BaseLinkList.Base_Url, hashMap, new BaseSubscriber() {
            @Override
            public void onError(ExceptionHandle.ResponeThrowable e) {
//                refreshLayout.setVisibility(View.GONE);
//                ll_beijing.setVisibility(View.VISIBLE);
                if (null != refreshLayout) {
                    refreshLayout.finishRefresh();
                    refreshLayout.finishLoadMore();
                }
            }

            @Override
            public void onSuccess(JSONObject jsonObject) {
                LogUtils.e("隐患等级->>" + jsonObject.toString());

                final PersonLiableBean personLiableBean = FastJsonTools.getBean(jsonObject.toString(), PersonLiableBean.class);
                if (null != personLiableBean && null != personLiableBean.getMsg() && null != personLiableBean.getCode()) {
                    final ArrayList<PersonLiableBean.DataBean.PageBean.ResultsBean> results = (ArrayList<PersonLiableBean.DataBean.PageBean.ResultsBean>) personLiableBean.getData().getPage().getResults();
                    if (results.size() != 0) {
//                        refreshLayout.setVisibility(View.VISIBLE);
//                        ll_beijing.setVisibility(View.GONE);
                        if (pageIndex > 1) {
                            if (null != results && results.size() != 0) {
                                BaseQuickAdapter adapter = (BaseQuickAdapter) rv_list.getAdapter();
                                ArrayList<PersonLiableBean.DataBean.PageBean.ResultsBean> data = (ArrayList<PersonLiableBean.DataBean.PageBean.ResultsBean>) adapter.getData();
                                for (int i = 0; i < results.size(); i++) {
                                    data.add(results.get(i));
                                    adapter.notifyItemChanged(data.size() + (i + 1), results.get(i));
                                }
                            } else {
                                ToastUtils.showShort("没有更多数据了!");
                            }
                        } else {
                            RecyclerViewUtils.initLiner(AcceptorActivity.this, rv_list, R.layout.item_hidden_danger_paln, results, new OnGlobalListener() {
                                @Override
                                public <T> void logic(BaseViewHolder helper, List<T> mData, T item, BaseQuickAdapter mAdapter) {
                                    PersonLiableBean.DataBean.PageBean.ResultsBean resultsBean = (PersonLiableBean.DataBean.PageBean.ResultsBean) item;
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
                                    PersonLiableBean.DataBean.PageBean.ResultsBean resultsBean = (PersonLiableBean.DataBean.PageBean.ResultsBean) adapter.getData().get(position);

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
//                        refreshLayout.setVisibility(View.GONE);
//                        ll_beijing.setVisibility(View.VISIBLE);
                    }
                }

                if (null != refreshLayout) {
                    refreshLayout.finishRefresh();
                    refreshLayout.finishLoadMore();
                }
            }
        });
    }

    public static class TestBean implements Serializable {
        public ArrayList<PersonLiableBean.DataBean.PageBean.ResultsBean> arrayList;
    }
}
