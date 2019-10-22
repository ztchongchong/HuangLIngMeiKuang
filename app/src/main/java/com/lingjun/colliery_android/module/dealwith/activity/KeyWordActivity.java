package com.lingjun.colliery_android.module.dealwith.activity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
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
import com.lingjun.colliery_android.bean.KeyWordBean;
import com.lingjun.colliery_android.bean.MainNewsBean;
import com.lingjun.colliery_android.bean.UnsafeBehaviorInfoBean;
import com.lingjun.colliery_android.module.dealwith.hiddendanger.general_hidden_danger.HiddenDangerPlanActivity;
import com.lingjun.colliery_android.module.main.rectifyingviolations.UnsafeBehaviorActivity;
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
 * 时间: 2019/2/19  15:18.
 * 注释: 关键词
 */
public class KeyWordActivity extends BaseActivity {
    public static final int HiddenDangerCode = 233;

    private RecyclerView rv_list;
    private TextView tv_num;
    private Button btn_queding;
    private LinearLayout ll_beijing;

    private ArrayList<String> list = new ArrayList<>();
    private ArrayList<String> id = new ArrayList<>();
    private ArrayList<KeyWordBean.DataBean.KeylistBean> keylistBean = new ArrayList<>();

    @Override
    protected int getResourcesId() {
        return R.layout.activity_keyword;
    }


    @Override
    protected void init(Bundle savedInstanceState) throws PackageManager.NameNotFoundException {
        rv_list = findViewById(R.id.rv_list);
        btn_queding = findViewById(R.id.btn_queding);
        ll_beijing = findViewById(R.id.ll_beijing);
        tv_num = findViewById(R.id.tv_num);

        btn_queding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                TestBean testBean = new TestBean();
                testBean.arrayList = keylistBean;
                bundle.putSerializable("keyword", testBean);
                intent.putExtra("bundle", bundle);
//                intent.putExtra("ids", bundle);
                setResult(KeyWordActivity.HiddenDangerCode, intent);
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
        hashMap.put(BaseLinkList.apiurl, BaseLinkList.coal_mine + BaseLinkList.selectstdfilekeylists);

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

                final KeyWordBean keyWordBean = FastJsonTools.getBean(jsonObject.toString(), KeyWordBean.class);
                if (null != keyWordBean && null != keyWordBean.getMsg() && null != keyWordBean.getCode() && null != keyWordBean.getResultMaps() && null != keyWordBean.getData() && TextUtils.isEmpty(keyWordBean.getData() + "")) {
                    final ArrayList<KeyWordBean.DataBean.KeylistBean> results = (ArrayList<KeyWordBean.DataBean.KeylistBean>) keyWordBean.getData().getKeylist();
                    if (results.size() != 0) {
                        refreshLayout.setVisibility(View.VISIBLE);
                        ll_beijing.setVisibility(View.GONE);
                        RecyclerViewUtils.initLiner(KeyWordActivity.this, rv_list, R.layout.item_hidden_danger_paln, results, new OnGlobalListener() {
                            @Override
                            public <T> void logic(BaseViewHolder helper, List<T> mData, T item, BaseQuickAdapter mAdapter) {
                                KeyWordBean.DataBean.KeylistBean resultsBean = (KeyWordBean.DataBean.KeylistBean) item;
                                TextView ll_plan = helper.getView(R.id.ll_plan);
                                ll_plan.setText(resultsBean.getName());

                            }
                        }, new BaseQuickAdapter.OnItemClickListener() {
                            @Override
                            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                                KeyWordBean.DataBean.KeylistBean resultsBean = (KeyWordBean.DataBean.KeylistBean) adapter.getData().get(position);

                                if (list.size() != 0) {
                                    for (String id : list) {
                                        if (id.equals("" + resultsBean.getName())) {
                                            ToastUtils.showShort("已经添加过这个关键字!");
                                            return;
                                        }
                                    }
                                    list.add("" + resultsBean.getName());
                                } else {
                                    list.add("" + resultsBean.getName());
                                }
                                tv_num.setText("" + (list.size()));
                                keylistBean.add(resultsBean);
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

    public static class TestBean implements Serializable {
        public ArrayList<KeyWordBean.DataBean.KeylistBean> arrayList;
    }
}
