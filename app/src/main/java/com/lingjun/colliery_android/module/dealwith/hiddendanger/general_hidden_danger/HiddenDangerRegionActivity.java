package com.lingjun.colliery_android.module.dealwith.hiddendanger.general_hidden_danger;

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
import com.lingjun.colliery_android.bean.HiddenDangerRegionBean;
import com.lingjun.colliery_android.utils.FastJsonTools;
import com.lingjun.colliery_android.utils.RecyclerViewUtils;
import com.lingjun.colliery_android.utils.retrofit.BaseSubscriber;
import com.lingjun.colliery_android.utils.retrofit.ExceptionHandle;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 隐患区域
 */
public class HiddenDangerRegionActivity extends BaseActivity {
    public static final int HiddenDangerCode = 3;

    private RecyclerView rv_list;
    private SmartRefreshLayout refreshLayout;
    private LinearLayout ll_beijing;

    @Override
    protected int getResourcesId() {
        return R.layout.activity_hidden_danger_region;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        rv_list = findViewById(R.id.rv_list);
        refreshLayout = findViewById(R.id.refreshLayout);
        ll_beijing = findViewById(R.id.ll_beijing);
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
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(BaseLinkList.apiurl, BaseLinkList.coal_mine + BaseLinkList.hidden_region);

        mRetrofit.JsonToColliery(BaseLinkList.Base_Url, hashMap, new BaseSubscriber() {
            @Override
            public void onError(ExceptionHandle.ResponeThrowable e) {
                refreshLayout.setVisibility(View.GONE);
                ll_beijing.setVisibility(View.VISIBLE);
            }

            @Override
            public void onSuccess(JSONObject jsonObject) {
                LogUtils.e("列表->>" + jsonObject.toString());

                final HiddenDangerRegionBean hiddenDangerRegionBean = FastJsonTools.getBean(jsonObject.toString(), HiddenDangerRegionBean.class);
                if (null != hiddenDangerRegionBean && null != hiddenDangerRegionBean.getMsg() && null != hiddenDangerRegionBean.getCode() && null != hiddenDangerRegionBean.getResultMaps()) {
                    refreshLayout.setVisibility(View.VISIBLE);
                    ll_beijing.setVisibility(View.GONE);

                    final ArrayList<HiddenDangerRegionBean.ResultMapsBean.ArealistBean> results = (ArrayList<HiddenDangerRegionBean.ResultMapsBean.ArealistBean>) hiddenDangerRegionBean.getResultMaps().get(0).getArealist();
                    if (results.size() != 0) {
                        RecyclerViewUtils.initLiner(HiddenDangerRegionActivity.this, rv_list, R.layout.item_hidden_danger_region, results, new OnGlobalListener() {
                            @Override
                            public <T> void logic(BaseViewHolder helper, List<T> mData, T item, BaseQuickAdapter mAdapter) {
                                HiddenDangerRegionBean.ResultMapsBean.ArealistBean resultsBean = (HiddenDangerRegionBean.ResultMapsBean.ArealistBean) item;

                                TextView ll_region = helper.getView(R.id.ll_region);
                                ll_region.setText(resultsBean.getName());

                            }
                        }, new BaseQuickAdapter.OnItemClickListener() {
                            @Override
                            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                                HiddenDangerRegionBean.ResultMapsBean.ArealistBean resultsBean = (HiddenDangerRegionBean.ResultMapsBean.ArealistBean) adapter.getData().get(position);

                                Intent intent = new Intent();
                                intent.putExtra("隐患区域", "" + resultsBean.getName());
                                intent.putExtra("隐患区域id", "" + resultsBean.getId());
                                setResult(HiddenDangerCode, intent);
                                finish();
                            }
                        }, null);
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
