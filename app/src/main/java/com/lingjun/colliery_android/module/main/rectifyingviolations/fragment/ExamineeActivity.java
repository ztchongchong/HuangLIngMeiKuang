package com.lingjun.colliery_android.module.main.rectifyingviolations.fragment;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
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
import com.lingjun.colliery_android.bean.ExamineeBean;
import com.lingjun.colliery_android.bean.TeamBean;
import com.lingjun.colliery_android.module.document.activity.TaskTrackingLIstActivity;
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
import butterknife.ButterKnife;

/**
 * @author: ztcc
 * @Data： 2019/9/7 14:20
 * Describe: 被审核人
 */
public class ExamineeActivity extends BaseActivity {

    public static final int Code = 2;

    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.ll_beijing)
    LinearLayout llBeijing;
    @BindView(R.id.rv_list)
    RecyclerView rvList;
    private String isAdmin;
    private String departmentId;
    private ArrayList<ExamineeBean.PageBean.ResultMapsBean> arrayList = new ArrayList<>();

    @Override
    protected int getResourcesId() {
        return R.layout.activity_hidden_danger_region;
    }

    @Override
    protected void init(Bundle savedInstanceState) throws PackageManager.NameNotFoundException {
        tvName.setText("被审核人");
        isAdmin = getIntent().getStringExtra("isAdmin");
        departmentId = getIntent().getStringExtra("departmentId");
        RefreshView();
    }

    @Override
    protected BaseRefreshLoadMoreInterface setRefreshLoadMoreListener() {
        return null;
    }

    private void RefreshView() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("departmentId", departmentId);
        hashMap.put("page", "1");
        hashMap.put("pageSize", "10");
        hashMap.put("isAdmin", isAdmin);
        hashMap.put(BaseLinkList.apiurl, BaseLinkList.coal_mine + BaseLinkList.EXAMINEE);
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
                LogUtils.e("EXAMINEE列表->>" + jsonObject.toString());
                final ExamineeBean examineeBean = FastJsonTools.getBean(jsonObject.toString(), ExamineeBean.class);
                if (examineeBean != null) {
                    if (pageIndex > 1) {
                        if (null != examineeBean.getPage().getResultMaps() && examineeBean.getPage().getResultMaps().size() != 0) {
                            BaseQuickAdapter adapter = (BaseQuickAdapter) rvList.getAdapter();
                            arrayList.addAll(examineeBean.getPage().getResultMaps());
                            adapter.notifyDataSetChanged();
                        } else {
                            ToastUtils.showShort("没有更多数据了!");
                        }
                    } else {
                        if (arrayList.size() != 0) {
                            arrayList.clear();
                        }
                        if (examineeBean.getPage().getResultMaps().size() != 0) {
                            arrayList.addAll(examineeBean.getPage().getResultMaps());
                            RecyclerViewUtils.initLiner(ExamineeActivity.this, rvList, R.layout.item_hidden_danger_paln, arrayList, new OnGlobalListener() {
                                @Override
                                public <T> void logic(BaseViewHolder helper, List<T> mData, T item, BaseQuickAdapter mAdapter) {
                                    ExamineeBean.PageBean.ResultMapsBean resultsBean = (ExamineeBean.PageBean.ResultMapsBean) item;
                                    TextView ll_plan = helper.getView(R.id.ll_plan);
                                    ll_plan.setText(resultsBean.getName());
                                }
                            }, new BaseQuickAdapter.OnItemClickListener() {
                                @Override
                                public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                                    ExamineeBean.PageBean.ResultMapsBean resultsBean = (ExamineeBean.PageBean.ResultMapsBean) adapter.getData().get(position);
                                    Intent intent = new Intent(ExamineeActivity.this, AssessmentActivity.class);
                                    intent.putExtra("examineeid", resultsBean.getId() + "");
                                    intent.putExtra("examineename", resultsBean.getName() + "");
                                    setResult(Code, intent);
                                    finish();
                                }
                            }, null);
                        } else {
                            refreshLayout.setVisibility(View.GONE);
                            llBeijing.setVisibility(View.VISIBLE);
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
}
