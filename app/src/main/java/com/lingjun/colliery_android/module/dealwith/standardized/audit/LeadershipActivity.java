package com.lingjun.colliery_android.module.dealwith.standardized.audit;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.blankj.utilcode.util.ScreenUtils;
import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lingjun.colliery_android.R;
import com.lingjun.colliery_android.base.BaseActivity;
import com.lingjun.colliery_android.base.BaseLinkList;
import com.lingjun.colliery_android.base.OnGlobalListener;
import com.lingjun.colliery_android.bean.LeadBean;
import com.lingjun.colliery_android.utils.FastJsonTools;
import com.lingjun.colliery_android.utils.RecyclerViewUtils;
import com.lingjun.colliery_android.utils.retrofit.BaseSubscriber;
import com.lingjun.colliery_android.utils.retrofit.ExceptionHandle;
import com.scwang.smartrefresh.layout.api.RefreshLayout;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 特邀领导
 * Created by nefa on 2018/11/2.
 */

public class LeadershipActivity extends BaseActivity {

    private RecyclerView rv_list;
    private String taskid;
    private List<LeadBean.DataBean.InuserBean> list = new ArrayList<>();

    @Override
    protected int getResourcesId() {
        return R.layout.activity_leader_ship;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        rv_list = findViewById(R.id.rv_list);
        taskid = getIntent().getStringExtra("taskid");
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
        HashMap<String, String> hashMap = new HashMap<>();
        if (TextUtils.isEmpty(taskid)) {
            return;
        }
        hashMap.put("taskid", taskid);
        mRetrofit.JsonToColliery(BaseLinkList.Base_Url + BaseLinkList.MOBILE_GETSTADCHKLEADERLIST, hashMap, new BaseSubscriber() {
            @Override
            public void onError(ExceptionHandle.ResponeThrowable e) {
                if (null != refreshLayout) {
                    refreshLayout.finishLoadMore();
                    refreshLayout.finishRefresh();
                }
            }

            @Override
            public void onSuccess(JSONObject jsonObject) throws JSONException {
                Log.d("json", jsonObject.toString());
                LeadBean bean = FastJsonTools.getBean(jsonObject.toString(), LeadBean.class);
                if (null != bean) {
                    if (bean.getData().getInuser().size() != 0) {
                        list = bean.getData().getInuser();
                    }
                }
            }
        });
        final ArrayList<LeaderShipBean> mList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            LeaderShipBean leaderShipBean = new LeaderShipBean();
            switch (i) {
                case 0:
                    leaderShipBean.name = "主要领导";
                    leaderShipBean.type = i;
                    break;
                case 1:
                    leaderShipBean.name = "内网特邀领导";
                    leaderShipBean.type = i;
                    break;
                case 2:
                    leaderShipBean.name = "外网特邀领导";
                    leaderShipBean.type = i;
                    break;
            }

            ArrayList<LeaderShipBean.LeaderShipInfoBean> arrayList = new ArrayList<>();

            for (int j = 0; j < 3; j++) {
                LeaderShipBean.LeaderShipInfoBean leaderShipInfoBean = new LeaderShipBean.LeaderShipInfoBean();
                leaderShipInfoBean.entryName = "李晓光";
                leaderShipInfoBean.icon = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1541141214691&di=6c9c8c21fb1fc37cc1879ee7bae46871&imgtype=0&src=http%3A%2F%2Fi0.hdslb.com%2Fbfs%2Farchive%2F1b6e96735930655e2c4ba1df2a5c4c9846c8aef7.jpg";
                switch (i) {
                    case 0:
                        leaderShipInfoBean.zhiwei = "技术部经理";
                        break;
                    case 1:
                        leaderShipInfoBean.zhiwei = "董事长";
                        break;
                    case 2:
                        leaderShipInfoBean.zhiwei = "技术部经理";
                        break;
                }
                arrayList.add(leaderShipInfoBean);
                arrayList.add(leaderShipInfoBean);
            }

            leaderShipBean.leaderData = arrayList;
            mList.add(leaderShipBean);
        }

        final int screenWidth = ScreenUtils.getScreenWidth();

        RecyclerViewUtils.initLinerNoSc(LeadershipActivity.this, rv_list, R.layout.item_leader_ship_entry, mList, new OnGlobalListener() {
            @Override
            public <T> void logic(BaseViewHolder helper, List<T> mData, T item, BaseQuickAdapter mAdapter) {
                final LeaderShipBean leaderShipBean = (LeaderShipBean) item;
                TextView tv_title = helper.getView(R.id.tv_title);
                RecyclerView rv_entry_list = helper.getView(R.id.rv_entry_list);

                tv_title.setText(leaderShipBean.name);
                ArrayList<LeaderShipBean.LeaderShipInfoBean> LeaderShipInfoBeans = leaderShipBean.leaderData;

                RecyclerViewUtils.initGridNoSc(LeadershipActivity.this, rv_entry_list, R.layout.item_grid_leader_button, LeaderShipInfoBeans, new OnGlobalListener() {
                    @Override
                    public <T> void logic(BaseViewHolder helper, List<T> mData, T item, BaseQuickAdapter mAdapter) {
                        LeaderShipBean.LeaderShipInfoBean leaderShipInfoBean = (LeaderShipBean.LeaderShipInfoBean) item;
                        ImageView iv_icon = helper.getView(R.id.iv_icon);
                        TextView tv_buttonName = helper.getView(R.id.tv_buttonName);
                        TextView tv_zhiwei = helper.getView(R.id.tv_zhiwei);
                        CardView cv_root = helper.getView(R.id.cv_root);

                        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(screenWidth / 3, ViewGroup.LayoutParams.WRAP_CONTENT);
                        cv_root.setLayoutParams(layoutParams);

                        if (!TextUtils.isEmpty(leaderShipInfoBean.icon)) {
                            Glide.with(LeadershipActivity.this).load(leaderShipInfoBean.icon).into(iv_icon);
                        }

                        tv_buttonName.setText(leaderShipInfoBean.entryName);
                        tv_zhiwei.setText(leaderShipInfoBean.zhiwei);
                        switch (leaderShipBean.type) {
                            case 0://主要领导
                                tv_zhiwei.setBackgroundColor(Color.parseColor("#FFCA28"));
                                break;
                            case 1://内网特邀领导
                                tv_zhiwei.setBackgroundColor(Color.parseColor("#42A5F5"));
                                break;
                            case 2://外网特邀领导
                                tv_zhiwei.setBackgroundColor(Color.parseColor("#4DD0E1"));
                                break;
                        }
                    }
                }, null, 3, null);

            }
        }, null, null);

        if (null != refreshLayout) {
            refreshLayout.finishLoadMore();
            refreshLayout.finishRefresh();
        }

    }


    static class LeaderShipBean {
        public String name;
        public int type;
        public ArrayList<LeaderShipInfoBean> leaderData;

        static class LeaderShipInfoBean {
            public String icon;
            public String entryName;
            public String zhiwei;
        }
    }

}
