package com.lingjun.colliery_android.module.main.rectifyingviolations.fragment;

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
import com.lingjun.colliery_android.bean.TaskTrackingBean;
import com.lingjun.colliery_android.bean.TeamBean;
import com.lingjun.colliery_android.module.document.activity.TaskTrackingActivity;
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
 * @Data： 2019/9/6 16:04
 * Describe: 班组列表
 */
public class TeamActivity extends BaseActivity {

    public static final int Code = 1;

    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.ll_beijing)
    LinearLayout llBeijing;
    @BindView(R.id.rv_list)
    RecyclerView rvList;

    private ArrayList<TeamBean.ListBean> arrayList = new ArrayList<>();

    @Override
    protected int getResourcesId() {
        return R.layout.activity_hidden_danger_region;
    }

    @Override
    protected void init(Bundle savedInstanceState) throws PackageManager.NameNotFoundException {
        tvName.setText("班组");
        RefreshView();
    }

    private void RefreshView() {
        HashMap<String, String> hashMap = new HashMap<>();

        hashMap.put(BaseLinkList.apiurl, BaseLinkList.coal_mine + BaseLinkList.TEAM);
        mRetrofit.JsonToColliery(BaseLinkList.Base_Url, hashMap, new BaseSubscriber() {
            @Override
            public void onError(ExceptionHandle.ResponeThrowable e) {
                refreshLayout.setVisibility(View.GONE);
                llBeijing.setVisibility(View.VISIBLE);
            }

            @Override
            public void onSuccess(JSONObject jsonObject) throws JSONException {
                LogUtils.e("TEAM列表->>" + jsonObject.toString());
                final TeamBean teamBean = FastJsonTools.getBean(jsonObject.toString(), TeamBean.class);
//                arrayList = (ArrayList<TeamBean.ListBean>) teamBean.getList();
                if (teamBean != null) {
                    if (pageIndex > 1) {
                        if (null != teamBean.getList() && teamBean.getList().size() != 0) {
                            BaseQuickAdapter adapter = (BaseQuickAdapter) rvList.getAdapter();
                            arrayList.addAll(teamBean.getList());
                            adapter.notifyDataSetChanged();
                        } else {
                            ToastUtils.showShort("没有更多数据了!");
                        }
                    } else {
                        if (arrayList.size() != 0) {
                            arrayList.clear();
                        }
                        if (teamBean.getList().size() != 0) {
                            arrayList.addAll(teamBean.getList());
                            RecyclerViewUtils.initLiner(TeamActivity.this, rvList, R.layout.item_hidden_danger_paln, arrayList, new OnGlobalListener() {
                                @Override
                                public <T> void logic(BaseViewHolder helper, List<T> mData, T item, BaseQuickAdapter mAdapter) {
                                    TeamBean.ListBean resultsBean = (TeamBean.ListBean) item;
                                    TextView ll_plan = helper.getView(R.id.ll_plan);
                                    ll_plan.setText(resultsBean.getParentname());
                                }
                            }, new BaseQuickAdapter.OnItemClickListener() {
                                @Override
                                public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                                    TeamBean.ListBean resultsBean = (TeamBean.ListBean) adapter.getData().get(position);
                                    Intent intent = new Intent(TeamActivity.this, AssessmentActivity.class);
                                    intent.putExtra("id", resultsBean.getId() + "");
                                    intent.putExtra("parentname", resultsBean.getParentname() + "");
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
            }
        });
    }

    @Override
    protected BaseRefreshLoadMoreInterface setRefreshLoadMoreListener() {
        return null;
    }


}
