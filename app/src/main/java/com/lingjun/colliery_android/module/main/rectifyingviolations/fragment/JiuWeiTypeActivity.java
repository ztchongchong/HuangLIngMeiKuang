package com.lingjun.colliery_android.module.main.rectifyingviolations.fragment;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
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
import com.lingjun.colliery_android.bean.HiddenDangerPlanBean;
import com.lingjun.colliery_android.bean.UnsafeBehaviorBean;
import com.lingjun.colliery_android.module.dealwith.hiddendanger.general_hidden_danger.HiddenDangerPlanActivity;
import com.lingjun.colliery_android.utils.FastJsonTools;
import com.lingjun.colliery_android.utils.RecyclerViewUtils;
import com.lingjun.colliery_android.utils.retrofit.BaseSubscriber;
import com.lingjun.colliery_android.utils.retrofit.ExceptionHandle;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 作者: zengtao
 * 时间: 2019/5/9  9:25.
 * 注释: 三违类型
 */
public class JiuWeiTypeActivity extends BaseActivity {

    public static final int RectifyingCode = 432;

    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.ll_beijing)
    LinearLayout llBeijing;
    @BindView(R.id.rv_list)
    RecyclerView rvList;
    @BindView(R.id.refreshLayout)
    SmartRefreshLayout refreshLayout;

    @Override
    protected int getResourcesId() {
        return R.layout.activity_hidden_danger_paln;
    }

    @Override
    protected void init(Bundle savedInstanceState) throws PackageManager.NameNotFoundException {
        tvName.setText("三违类型");

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
        hashMap.put(BaseLinkList.apiurl, BaseLinkList.coal_mine + BaseLinkList.clausecategorytree);
        mRetrofit.JsonToColliery(BaseLinkList.Base_Url, hashMap, new BaseSubscriber() {
            @Override
            public void onError(ExceptionHandle.ResponeThrowable e) {
                refreshLayout.setVisibility(View.GONE);
                llBeijing.setVisibility(View.VISIBLE);
                if (null != refreshLayout) {
                    refreshLayout.finishRefresh();
                    refreshLayout.finishLoadMore();
                }
            }

            @Override
            public void onSuccess(JSONObject jsonObject) {
                LogUtils.e("列表->>" + jsonObject.toString());

                final UnsafeBehaviorBean unsafeBehaviorBean = FastJsonTools.getBean(jsonObject.toString(), UnsafeBehaviorBean.class);
                if (null != unsafeBehaviorBean && null != unsafeBehaviorBean.getMsg() && null != unsafeBehaviorBean.getCode()) {
                    final ArrayList<UnsafeBehaviorBean.DataBean.TreeBean> results = (ArrayList<UnsafeBehaviorBean.DataBean.TreeBean>) unsafeBehaviorBean.getData().getTree();
                    if (results.size() != 0) {
                        refreshLayout.setVisibility(View.VISIBLE);
                        llBeijing.setVisibility(View.GONE);
                        if (pageIndex > 1) {
                            if (null != results && results.size() != 0) {
                                BaseQuickAdapter adapter = (BaseQuickAdapter) rvList.getAdapter();
                                ArrayList<UnsafeBehaviorBean.DataBean.TreeBean> data = (ArrayList<UnsafeBehaviorBean.DataBean.TreeBean>) adapter.getData();
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
                            RecyclerViewUtils.initLiner(JiuWeiTypeActivity.this, rvList, R.layout.item_unsafebehavior, results, new OnGlobalListener() {
                                @Override
                                public <T> void logic(BaseViewHolder helper, List<T> mData, T item, BaseQuickAdapter mAdapter) {
                                    UnsafeBehaviorBean.DataBean.TreeBean resultsBean = (UnsafeBehaviorBean.DataBean.TreeBean) item;
                                    TextView tv_name = helper.getView(R.id.tv_name);
                                    tv_name.setText(resultsBean.getName());

                                }
                            }, new BaseQuickAdapter.OnItemClickListener() {
                                @Override
                                public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                                    UnsafeBehaviorBean.DataBean.TreeBean resultsBean = (UnsafeBehaviorBean.DataBean.TreeBean) adapter.getData().get(position);

                                    Intent intent = new Intent();
                                    intent.putExtra("jiuweiname", "" + resultsBean.getName());
                                    intent.putExtra("jiuweiid", "" + resultsBean.getId());
                                    setResult(RectifyingCode, intent);
                                    finish();
                                }
                            }, null);
                        }
                    } else {
                        refreshLayout.setVisibility(View.GONE);
                        llBeijing.setVisibility(View.VISIBLE);
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
