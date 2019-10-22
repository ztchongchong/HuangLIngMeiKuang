package com.lingjun.colliery_android.module.dealwith.hiddendanger.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.blankj.utilcode.util.LogUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lingjun.colliery_android.R;
import com.lingjun.colliery_android.base.BaseActivity;
import com.lingjun.colliery_android.base.BaseLinkList;
import com.lingjun.colliery_android.base.OnGlobalListener;
import com.lingjun.colliery_android.bean.CooperationBean;
import com.lingjun.colliery_android.bean.ResponsibilityBean;
import com.lingjun.colliery_android.module.dealwith.activity.KeyWordActivity;
import com.lingjun.colliery_android.utils.FastJsonTools;
import com.lingjun.colliery_android.utils.RecyclerViewUtils;
import com.lingjun.colliery_android.utils.ToastUtils;
import com.lingjun.colliery_android.utils.retrofit.BaseSubscriber;
import com.lingjun.colliery_android.utils.retrofit.ExceptionHandle;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.security.auth.login.LoginException;

/**
 * 作者: zengtao
 * 时间: 2019/4/11  11:52.
 * 注释: 协作单位
 */
public class CooperationActivity extends BaseActivity {
    public static final int RectifyingCode = 12;
    private RecyclerView rv_list;
    private String id;
    private TextView ll_plan;
    private TextView tv_num;
    private Button btn_queding;

    private ArrayList<String> cooperativeUnitId = new ArrayList<>();//协同单位id
    private ArrayList<String> cooperativeUnitLeaderId = new ArrayList<>();//协同单位领导id
    private ArrayList<String> cooperativeUnitsName = new ArrayList<>();//协同单位名称

    @Override
    protected int getResourcesId() {
        return R.layout.activity_cooperation;
    }

    @Override
    protected void init(Bundle savedInstanceState) throws PackageManager.NameNotFoundException {
        rv_list = findViewById(R.id.rv_list);
        tv_num = findViewById(R.id.tv_num);
        btn_queding = findViewById(R.id.btn_queding);
        id = getIntent().getStringExtra("department_id");

        btn_queding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("cooperativeUnitId", cooperativeUnitId + "");
                intent.putExtra("cooperativeUnitLeaderId", cooperativeUnitLeaderId + "");
                intent.putExtra("cooperativeUnitsName", cooperativeUnitsName + "");
                setResult(RectifyingCode, intent);
                finish();
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

        hashMap.put(BaseLinkList.apiurl, BaseLinkList.coal_mine + BaseLinkList.getSelectCooperativeUnitDepartment);
        hashMap.put("selectDepartmentId", id);
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
                LogUtils.e("协作单位->>" + jsonObject.toString());

                final CooperationBean cooperationBean = FastJsonTools.getBean(jsonObject.toString(), CooperationBean.class);
                if (null != cooperationBean && null != cooperationBean.getMsg() && null != cooperationBean.getResultMaps()) {
                    final ArrayList<CooperationBean.ResultMapsBean> results = (ArrayList<CooperationBean.ResultMapsBean>) cooperationBean.getResultMaps();
                    if (pageIndex > 1) {
                        if (null != results && results.size() != 0) {
                            BaseQuickAdapter adapter = (BaseQuickAdapter) rv_list.getAdapter();
                            ArrayList<CooperationBean.ResultMapsBean> data = (ArrayList<CooperationBean.ResultMapsBean>) adapter.getData();
                            for (int i = 0; i < results.size(); i++) {
                                data.add(results.get(i));
                                adapter.notifyItemChanged(data.size() + (i + 1), results.get(i));
                            }
                        } else {
                            com.blankj.utilcode.util.ToastUtils.showShort("没有更多数据了!");
                        }
                    } else {
                        RecyclerViewUtils.initLiner(CooperationActivity.this, rv_list, R.layout.item_hidden_danger_paln, results, new OnGlobalListener() {
                            @Override
                            public <T> void logic(BaseViewHolder helper, List<T> mData, T item, BaseQuickAdapter mAdapter) {
                                CooperationBean.ResultMapsBean resultsBean = (CooperationBean.ResultMapsBean) item;

                                ll_plan = helper.getView(R.id.ll_plan);
                                ll_plan.setText(resultsBean.getDepartementName());
//                                helper.addOnClickListener(R.id.ll_plan);

                            }
                        }, new BaseQuickAdapter.OnItemClickListener() {
                            @SuppressLint("ResourceType")
                            @Override
                            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                                CooperationBean.ResultMapsBean resultsBean = (CooperationBean.ResultMapsBean) adapter.getData().get(position);
                                if (cooperativeUnitId.size() != 0) {//协作单位id
                                    for (String id : cooperativeUnitId) {
                                        if (id.equals("" + resultsBean.getDepartementId())) {
                                            com.blankj.utilcode.util.ToastUtils.showShort("已经添加过这个部门了!");
                                            return;
                                        }
                                    }
                                    cooperativeUnitId.add(resultsBean.getDepartementId() + "");
                                } else {
                                    cooperativeUnitId.add(resultsBean.getDepartementId() + "");
                                }
                                if (cooperativeUnitLeaderId.size() != 0) {//协作单位领导id
                                    for (String id : cooperativeUnitLeaderId) {
                                        if (id.equals("" + resultsBean.getLeaderId())) {
                                            return;
                                        }
                                    }
                                    cooperativeUnitLeaderId.add(resultsBean.getLeaderId() + "");
                                } else {
                                    cooperativeUnitLeaderId.add(resultsBean.getLeaderId() + "");
                                }
                                if (cooperativeUnitsName.size() != 0) {//协作单位名称
                                    for (String id : cooperativeUnitsName) {
                                        if (id.equals("" + resultsBean.getDepartementName())) {
                                            return;
                                        }
                                    }
                                    cooperativeUnitsName.add(resultsBean.getDepartementName() + "");
                                } else {
                                    cooperativeUnitsName.add(resultsBean.getDepartementName() + "");
                                }
                                tv_num.setText("" + (cooperativeUnitId.size()));
                            }
                        }, new BaseQuickAdapter.OnItemChildClickListener() {
                            @Override
                            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
//                                ResponsibilityBean.ResultMapsBean resultsBean = (ResponsibilityBean.ResultMapsBean) adapter.getData().get(position);
//                                resultsBean.isColour();
//                               if (resultsBean.isColour()){
//                                   com.blankj.utilcode.util.ToastUtils.showShort("选择!");
////                                   view.setBackgroundResource(R.drawable.shape_blue_button);
//                               }else if (!resultsBean.isColour()){
//                                   com.blankj.utilcode.util.ToastUtils.showShort("取消!");
////                                   view.setBackgroundResource(R.drawable.shape_blue_button);
//                                }
                            }
                        });
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
