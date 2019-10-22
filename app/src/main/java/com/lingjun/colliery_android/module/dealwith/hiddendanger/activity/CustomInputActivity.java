package com.lingjun.colliery_android.module.dealwith.hiddendanger.activity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.blankj.utilcode.util.LogUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lingjun.colliery_android.R;
import com.lingjun.colliery_android.base.BaseActivity;
import com.lingjun.colliery_android.base.BaseLinkList;
import com.lingjun.colliery_android.base.OnGlobalListener;
import com.lingjun.colliery_android.bean.PopCatalogwordBean;
import com.lingjun.colliery_android.module.dealwith.hiddendanger.general_hidden_danger.HiddenDangerContentActivity;
import com.lingjun.colliery_android.utils.FastJsonTools;
import com.lingjun.colliery_android.utils.RecyclerViewUtils;
import com.lingjun.colliery_android.utils.retrofit.BaseSubscriber;
import com.lingjun.colliery_android.utils.retrofit.ExceptionHandle;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 作者: zengtao
 * 时间: 2019/1/9  16:47.
 * 注释: 自定义隐患类型
 */
public class CustomInputActivity extends BaseActivity {
    public static final int HiddenDangerCode = 7;

    private RecyclerView rv_list;
    private SmartRefreshLayout refreshLayout;
    private LinearLayout ll_beijing;

    @Override
    protected int getResourcesId() {
        return R.layout.activity_custom_input;
    }

    @Override
    protected void init(Bundle savedInstanceState) throws PackageManager.NameNotFoundException {
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
        hashMap.put(BaseLinkList.apiurl, BaseLinkList.coal_mine + BaseLinkList.pop_catalogword);

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

                final PopCatalogwordBean popCatalogwordBean = FastJsonTools.getBean(jsonObject.toString(), PopCatalogwordBean.class);
                if (null != popCatalogwordBean && null != popCatalogwordBean.getMsg() && null != popCatalogwordBean.getCode()) {
                    refreshLayout.setVisibility(View.VISIBLE);
                    ll_beijing.setVisibility(View.GONE);

                    final ArrayList<PopCatalogwordBean.DataBean.TreejsonBean> results = (ArrayList<PopCatalogwordBean.DataBean.TreejsonBean>) popCatalogwordBean.getData().getTreejson();
                    RecyclerViewUtils.initLiner(CustomInputActivity.this, rv_list, R.layout.item_hidden_danger_paln, results, new OnGlobalListener() {
                        @Override
                        public <T> void logic(BaseViewHolder helper, List<T> mData, T item, BaseQuickAdapter mAdapter) {
                            PopCatalogwordBean.DataBean.TreejsonBean resultsBean = (PopCatalogwordBean.DataBean.TreejsonBean) item;
                            TextView tv_handle_name = helper.getView(R.id.ll_plan);//标题
                            tv_handle_name.setText(resultsBean.getName());
                        }
                    }, new BaseQuickAdapter.OnItemClickListener() {
                        @Override
                        public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                            PopCatalogwordBean.DataBean.TreejsonBean treejsonBean = (PopCatalogwordBean.DataBean.TreejsonBean) adapter.getData().get(position);
                            Intent intent = new Intent();
                            intent.putExtra("customInput_id", "" + treejsonBean.getId());
                            intent.putExtra("customInput_name", "" + treejsonBean.getName());
                            setResult(HiddenDangerCode, intent);
                            finish();
                        }
                    }, null);
                } else {
                    refreshLayout.setVisibility(View.GONE);
                    ll_beijing.setVisibility(View.VISIBLE);
                }
                if (null != refreshLayout) {
                    refreshLayout.finishRefresh();
                    refreshLayout.finishLoadMore();
                }
            }
        });
    }
}
