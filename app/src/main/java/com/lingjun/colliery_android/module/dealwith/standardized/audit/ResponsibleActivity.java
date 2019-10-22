package com.lingjun.colliery_android.module.dealwith.standardized.audit;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lingjun.colliery_android.R;
import com.lingjun.colliery_android.base.BaseActivity;
import com.lingjun.colliery_android.base.BaseLinkList;
import com.lingjun.colliery_android.base.OnGlobalListener;
import com.lingjun.colliery_android.bean.PeiHeBean;
import com.lingjun.colliery_android.bean.ZeRenBean;
import com.lingjun.colliery_android.module.dealwith.adapter.ResponsibleAdapter;
import com.lingjun.colliery_android.module.dealwith.myinterface.ListviewInterface;
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

import butterknife.BindView;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * 责任人
 * Created by nefa on 2018/11/2.
 */

public class ResponsibleActivity extends BaseActivity implements ListviewInterface {
    @OnClick(R.id.iv_back)
    void back() {
        finish();
    }

    @BindView(R.id.rv_list)
    RecyclerView rv_list;
    private String taskid;
    private ResponsibleAdapter adapter;
    private List<PeiHeBean.DataBean.MapBean> list = new ArrayList<>();

    @Override
    protected int getResourcesId() {
        return R.layout.activity_responsible;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        taskid = getIntent().getStringExtra("taskid");
        initAdapter();
    }

    private void initAdapter() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setAutoMeasureEnabled(true);
        adapter = new ResponsibleAdapter(R.layout.item_responsren);
        adapter.setListviewInterface(ResponsibleActivity.this);
        rv_list.setLayoutManager(new LinearLayoutManager(ResponsibleActivity.this));
        rv_list.setAdapter(adapter);
        rv_list.setNestedScrollingEnabled(false);
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
        hashMap.put("apiurl",BaseLinkList.coal_mine+ BaseLinkList.MOBILE_GETSTADCHKRESPONSIBLELIST);
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
                Log.d("json", jsonObject.toString());
                PeiHeBean bean = FastJsonTools.getBean(jsonObject.toString(), PeiHeBean.class);
                if (null != bean) {
                    if (bean.getData().getMap().size() != 0) {
                        list = bean.getData().getMap();
                        adapter.setNewData(list);
                    }
                }
            }
        });

        if (null != refreshLayout) {
            refreshLayout.finishRefresh();
            refreshLayout.finishLoadMore();
        }
    }

    @Override
    public void btnClick(View v, int pos, boolean type) {
        list.get(pos).setState(!type);
        adapter.notifyItemChanged(pos);
    }

    @Override
    public void btnsClick(View v, int pos, int state, boolean type) {

    }

    @Override
    public void btnsClicks(View v, int pos, boolean state, int type) {

    }
}
