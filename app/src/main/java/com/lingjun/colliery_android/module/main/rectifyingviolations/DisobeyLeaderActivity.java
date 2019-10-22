package com.lingjun.colliery_android.module.main.rectifyingviolations;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
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
import com.lingjun.colliery_android.bean.DisobeyLeaderBean;
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
 * 时间: 2019/4/29  14:09.
 * 注释: 三违领导
 */
public class DisobeyLeaderActivity extends BaseActivity {
    public static final int HiddenDangerCode = 444;
    private RecyclerView rv_list;
    private TextView tv_num;
    private Button btn_queding;

    private ArrayList<String> list = new ArrayList<>();
    private ArrayList<DisobeyLeaderBean.DataBean.ListBean.ResultsBean> resultsBeans = new ArrayList<>();

    private String departmentId;
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
        tv_biaoji.setText("三违领导");

        departmentId = getIntent().getStringExtra("departmentId");
        btn_queding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                TestBean testBean = new TestBean();
                testBean.arrayList = resultsBeans;
                bundle.putSerializable("disobeyLeader", testBean);
                intent.putExtra("bundle", bundle);
                setResult(DisobeyLeaderActivity.HiddenDangerCode, intent);
                finish();
            }
        });
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
        hashMap.put("departmentId", departmentId);
        hashMap.put("page", pageIndex + "");
        hashMap.put("pageSize", "500");
        hashMap.put(BaseLinkList.apiurl, BaseLinkList.coal_mine + BaseLinkList.getdisobeyLeader);

        mRetrofit.JsonToColliery(BaseLinkList.Base_Url, hashMap, new BaseSubscriber() {
            @Override
            public void onError(ExceptionHandle.ResponeThrowable e) {
                refreshLayout.setVisibility(View.GONE);
//                ll_beijing.setVisibility(View.VISIBLE);
                if (null != refreshLayout) {
                    refreshLayout.finishRefresh();
                    refreshLayout.finishLoadMore();
                }
            }

            @Override
            public void onSuccess(JSONObject jsonObject) {
                LogUtils.e("列表->>" + jsonObject.toString());

                final DisobeyLeaderBean disobeyLeaderBean = FastJsonTools.getBean(jsonObject.toString(), DisobeyLeaderBean.class);
                if (null != disobeyLeaderBean && null != disobeyLeaderBean.getMsg() && null != disobeyLeaderBean.getCode()) {
                    final ArrayList<DisobeyLeaderBean.DataBean.ListBean.ResultsBean> results = (ArrayList<DisobeyLeaderBean.DataBean.ListBean.ResultsBean>) disobeyLeaderBean.getData().getList().getResults();

                    refreshLayout.setVisibility(View.VISIBLE);
//                        ll_beijing.setVisibility(View.GONE);
                    if (pageIndex > 1) {
                        BaseQuickAdapter mAdapter = (BaseQuickAdapter) rv_list.getAdapter();
                        ArrayList<DisobeyLeaderBean.DataBean.ListBean.ResultsBean> resList = (ArrayList<DisobeyLeaderBean.DataBean.ListBean.ResultsBean>) mAdapter.getData();
                        LogUtils.e("总数->>" + resList.size());
                        if (results.size() == 0) {
                            ToastUtils.showShort("没有更多数据了!");
                        } else {
                            resList.addAll(results);
                        }
                    } else {
                        if (results.size() != 0) {
                            RecyclerViewUtils.initLiner(DisobeyLeaderActivity.this, rv_list, R.layout.item_hidden_danger_paln, results, new OnGlobalListener() {
                                @Override
                                public <T> void logic(BaseViewHolder helper, List<T> mData, T item, BaseQuickAdapter mAdapter) {
                                    DisobeyLeaderBean.DataBean.ListBean.ResultsBean resultsBean = (DisobeyLeaderBean.DataBean.ListBean.ResultsBean) item;
                                    RelativeLayout rl_plan=helper.getView(R.id.rl_plan);
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
                                    DisobeyLeaderBean.DataBean.ListBean.ResultsBean resultsBean = (DisobeyLeaderBean.DataBean.ListBean.ResultsBean) adapter.getData().get(position);

//                                    if (list.size() != 0) {
//                                        for (String id : list) {
//                                            if (id.equals("" + resultsBean.getName())) {
//                                                ToastUtils.showShort("已经添加过这个责任领导!");
//                                                return;
//                                            }
//                                        }
//                                    }
                                    if (resultsBean.isType()) {
                                        resultsBean.setType(false);
//                                        list.remove("" + resultsBean.getName());
//                                        for(int i=0;i<resultsBeans.size();i++){
//                                            if(resultsBeans.get(i).getName().equals(resultsBean.getName())){
//                                                resultsBeans.remove(i);
//                                                break;
//                                            }
//                                        }
                                        resultsBeans.remove(resultsBean);
                                    } else {
                                        resultsBean.setType(true);
//                                        list.add("" + resultsBean.getName());
                                        resultsBeans.add(resultsBean);
                                    }
                                    adapter.notifyItemChanged(position);

//                                    else {
//                                        list.add("" + resultsBean.getName());
//                                    }
                                    tv_num.setText("" + (resultsBeans.size()));

                                }
                            }, null);
                        } else {
                            refreshLayout.setVisibility(View.VISIBLE);
//                        ll_beijing.setVisibility(View.GONE);
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

    public static class TestBean implements Serializable {
        public ArrayList<DisobeyLeaderBean.DataBean.ListBean.ResultsBean> arrayList;
    }
}
