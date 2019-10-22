package com.lingjun.colliery_android.module.dealwith.hiddendanger.activity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
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
import com.lingjun.colliery_android.bean.SuperiorLeaderBean;
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

import butterknife.BindView;


/**
 * 作者: zengtao
 * 时间: 2019/6/4  18:26.
 * 注释: 上级领导
 */
public class SuperiorLeaderActivity extends BaseActivity {
    public static final int RectifyingCode = 465;

    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.ll_beijing)
    LinearLayout llBeijing;
    @BindView(R.id.rv_list)
    RecyclerView rvList;
    private String department_id;

    @Override
    protected int getResourcesId() {
        return R.layout.activity_hidden_danger_paln;
    }

    @Override
    protected void init(Bundle savedInstanceState) throws PackageManager.NameNotFoundException {
        tvName.setText("上级领导");
        department_id = getIntent().getStringExtra("department_id");
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
        hashMap.put("page", "1");
        hashMap.put("pageSize", "10");
        hashMap.put("departmentId", department_id);
        hashMap.put(BaseLinkList.apiurl, BaseLinkList.coal_mine + BaseLinkList.getUserLeaderByDepartment);

        mRetrofit.JsonToColliery(BaseLinkList.Base_Url, hashMap, new BaseSubscriber() {
            @Override
            public void onError(ExceptionHandle.ResponeThrowable e) {
                if (null != refreshLayout) {
                    refreshLayout.finishRefresh();
                    refreshLayout.finishLoadMore();
                }
            }

            @Override
            public void onSuccess(JSONObject jsonObject) throws JSONException {
                LogUtils.e("上级领导->>" + jsonObject.toString());
                final SuperiorLeaderBean superiorLeaderBean = FastJsonTools.getBean(jsonObject.toString(), SuperiorLeaderBean.class);
                if (null != superiorLeaderBean) {
                    ArrayList<SuperiorLeaderBean.DataBean.UserpageBean.ResultsBean> resultsBeans = (ArrayList<SuperiorLeaderBean.DataBean.UserpageBean.ResultsBean>) superiorLeaderBean.getData().getUserpage().getResults();
                    RecyclerViewUtils.initLiner(SuperiorLeaderActivity.this, rvList, R.layout.item_hidden_danger_paln, resultsBeans, new OnGlobalListener() {
                        @Override
                        public <T> void logic(BaseViewHolder helper, List<T> mData, T item, BaseQuickAdapter mAdapter) {
                            SuperiorLeaderBean.DataBean.UserpageBean.ResultsBean resultsBean = (SuperiorLeaderBean.DataBean.UserpageBean.ResultsBean) item;
                            TextView ll_plan = helper.getView(R.id.ll_plan);
                            ll_plan.setText(resultsBean.getName());
                        }
                    }, new BaseQuickAdapter.OnItemClickListener() {
                        @Override
                        public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                            SuperiorLeaderBean.DataBean.UserpageBean.ResultsBean resultsBean = (SuperiorLeaderBean.DataBean.UserpageBean.ResultsBean) adapter.getData().get(position);
                            Intent intent = new Intent();
                            intent.putExtra("superiorleaderid", "" + resultsBean.getUserid());
                            intent.putExtra("superiorleadername", "" + resultsBean.getName());
                            setResult(RectifyingCode, intent);
                            finish();
                        }
                    }, null);

                }
                if (null != refreshLayout) {
                    refreshLayout.finishRefresh();
                    refreshLayout.finishLoadMore();
                }
            }
        });
    }

}
