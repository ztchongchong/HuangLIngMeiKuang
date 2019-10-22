package com.lingjun.colliery_android.module.dealwith.hiddendanger.general_hidden_danger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
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
import com.lingjun.colliery_android.bean.HiddenDangerPositionBean;
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
 * 隐患位置
 */
public class HiddenDangerPositionActivity extends BaseActivity {
    public static final int HiddenDangerCode = 2;

    private String hiposition, et;

    private RecyclerView rv_list;
    private SmartRefreshLayout refreshLayout;
    private LinearLayout ll_beijing;

    private EditText et_position;
    private TextView tv_number;
    private TextView tv_position_sure;

    @Override
    protected int getResourcesId() {
        return R.layout.activity_hidden_danger_position;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        rv_list = findViewById(R.id.rv_list);

        et_position = findViewById(R.id.et_position);
        tv_number = findViewById(R.id.tv_number);
        tv_position_sure = findViewById(R.id.tv_position_sure);
        refreshLayout = findViewById(R.id.refreshLayout);
        ll_beijing = findViewById(R.id.ll_beijing);

        tv_position_sure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                et = et_position.getText().toString().trim();
                if (!TextUtils.isEmpty(et_position.getText().toString().trim())) {
                    Intent intent = new Intent();
                    intent.putExtra("隐患位置历史", "" + hiposition);
                    intent.putExtra("隐患位置历史", "" + et);
                    setResult(HiddenDangerCode, intent);
                    finish();
                } else {
                    Toast.makeText(HiddenDangerPositionActivity.this, "请选择或者输入隐患位置", Toast.LENGTH_SHORT).show();
                }
            }
        });

        et_position.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                tv_number.setText(String.valueOf(s.length()));
                if (s.length() >= 50) {
                    Toast.makeText(HiddenDangerPositionActivity.this, "字数上限", Toast.LENGTH_SHORT);
                }

            }
        });
        refreshView();
    }

    @Override
    protected BaseRefreshLoadMoreInterface setRefreshLoadMoreListener() {
//        return new BaseRefreshLoadMoreInterface() {
//            @Override
//            public void onLoadMore() {
//                refreshView();//加载
//            }
//
//            @Override
//            public void onRefresh() {
//                refreshView();//刷新
//            }
//        };
        return null;
    }

    private void refreshView() {

        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(BaseLinkList.apiurl, BaseLinkList.coal_mine + BaseLinkList.hidden_position);
        mRetrofit.JsonToColliery(BaseLinkList.Base_Url, hashMap, new BaseSubscriber() {
            @Override
            public void onError(ExceptionHandle.ResponeThrowable e) {
                refreshLayout.setVisibility(View.GONE);
                ll_beijing.setVisibility(View.VISIBLE);
            }

            @Override
            public void onSuccess(JSONObject jsonObject) {
                LogUtils.e("列表->>" + jsonObject.toString());

                final HiddenDangerPositionBean hiddenDangerPositionBean = FastJsonTools.getBean(jsonObject.toString(), HiddenDangerPositionBean.class);
                if (null != hiddenDangerPositionBean && null != hiddenDangerPositionBean.getMsg() && null != hiddenDangerPositionBean.getCode() && null != hiddenDangerPositionBean.getResultMaps()) {
                    refreshLayout.setVisibility(View.VISIBLE);
                    ll_beijing.setVisibility(View.GONE);

                    final ArrayList<HiddenDangerPositionBean.ResultMapsBean.LocationhistoryBean> results = (ArrayList<HiddenDangerPositionBean.ResultMapsBean.LocationhistoryBean>) hiddenDangerPositionBean.getResultMaps().get(0).getLocationhistory();
                    if (results.size() != 0) {
                        RecyclerViewUtils.initLiner(HiddenDangerPositionActivity.this, rv_list, R.layout.item_hidden_danger_position, results, new OnGlobalListener() {
                            @Override
                            public <T> void logic(BaseViewHolder helper, List<T> mData, T item, BaseQuickAdapter mAdapter) {
                                HiddenDangerPositionBean.ResultMapsBean.LocationhistoryBean resultsBean = (HiddenDangerPositionBean.ResultMapsBean.LocationhistoryBean) item;
                                TextView tv_history = helper.getView(R.id.tv_history);
                                tv_history.setText(resultsBean.getLocation());
                            }
                        }, new BaseQuickAdapter.OnItemClickListener() {
                            @Override
                            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                                HiddenDangerPositionBean.ResultMapsBean.LocationhistoryBean resultsBean = (HiddenDangerPositionBean.ResultMapsBean.LocationhistoryBean) adapter.getData().get(position);
                                hiposition = resultsBean.getLocation();
                                et_position.setText(hiposition);
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