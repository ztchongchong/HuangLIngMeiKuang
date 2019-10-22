package com.lingjun.colliery_android.module.dealwith.hiddendanger.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lingjun.colliery_android.R;
import com.lingjun.colliery_android.base.BaseActivity;
import com.lingjun.colliery_android.base.BaseLinkList;
import com.lingjun.colliery_android.base.OnGlobalListener;
import com.lingjun.colliery_android.bean.HiddenDangerFourFgBean;
import com.lingjun.colliery_android.bean.HiddenDangerPlanBean;
import com.lingjun.colliery_android.bean.HiddenDangersHandleBean;
import com.lingjun.colliery_android.bean.UpgradeAuditorBean;
import com.lingjun.colliery_android.module.dealwith.hiddendanger.general_hidden_danger.HiddenDangerPlanActivity;
import com.lingjun.colliery_android.utils.FastJsonTools;
import com.lingjun.colliery_android.utils.RecyclerViewUtils;
import com.lingjun.colliery_android.utils.retrofit.BaseSubscriber;
import com.lingjun.colliery_android.utils.retrofit.ExceptionHandle;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 隐患升级审核人
 */
public class UpgradeAuditorActivity extends BaseActivity {
    public static final int RectifyingCode = 20;

    private RecyclerView rv_list;

    @Override
    protected int getResourcesId() {
        return R.layout.activity_upgrade_auditor;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        rv_list = findViewById(R.id.rv_list);
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
        hashMap.put(BaseLinkList.apiurl, BaseLinkList.coal_mine + BaseLinkList.upgrade_auditor);
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

                final UpgradeAuditorBean upgradeAuditorBean = FastJsonTools.getBean(jsonObject.toString(), UpgradeAuditorBean.class);
                if (null != upgradeAuditorBean && null != upgradeAuditorBean.getData()) {
                    final ArrayList<UpgradeAuditorBean.DataBean.ListBean> results = (ArrayList<UpgradeAuditorBean.DataBean.ListBean>) upgradeAuditorBean.getData().getList();
                    if (pageIndex > 1) {
                        if (null != results && results.size() != 0) {
                            BaseQuickAdapter adapter = (BaseQuickAdapter) rv_list.getAdapter();
                            ArrayList<UpgradeAuditorBean.DataBean.ListBean> data = (ArrayList<UpgradeAuditorBean.DataBean.ListBean>) adapter.getData();
                            for (int i = 0; i < results.size(); i++) {
                                data.add(results.get(i));
                                adapter.notifyItemChanged(data.size() + (i + 1), results.get(i));
                            }
                        } else {
                            com.blankj.utilcode.util.ToastUtils.showShort("没有更多数据了!");
                        }
                    } else {
                        RecyclerViewUtils.initLiner(UpgradeAuditorActivity.this, rv_list, R.layout.item_upgrade_auditor, results, new OnGlobalListener() {
                            @Override
                            public <T> void logic(BaseViewHolder helper, List<T> mData, T item, BaseQuickAdapter mAdapter) {
                                UpgradeAuditorBean.DataBean.ListBean resultsBean = (UpgradeAuditorBean.DataBean.ListBean) item;

                                TextView tv_name = helper.getView(R.id.tv_name);
                                tv_name.setText(resultsBean.getName());

                            }
                        }, new BaseQuickAdapter.OnItemClickListener() {
                            @SuppressLint("ResourceType")
                            @Override
                            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                                UpgradeAuditorBean.DataBean.ListBean resultsBean = (UpgradeAuditorBean.DataBean.ListBean) adapter.getData().get(position);
                                Intent intent = new Intent();
                                intent.putExtra("upgrade_id", "" + resultsBean.getId());//审核人ID
                                intent.putExtra("upgrade", "" + resultsBean.getName());//审核人
                                setResult(RectifyingCode, intent);
                                finish();
                            }
                        }, null);
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
