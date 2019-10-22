package com.lingjun.colliery_android.module.main.rectifyingviolations.fragment;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.blankj.utilcode.util.LogUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lingjun.colliery_android.R;
import com.lingjun.colliery_android.base.BaseFragment;
import com.lingjun.colliery_android.base.BaseLinkList;
import com.lingjun.colliery_android.base.OnGlobalListener;
import com.lingjun.colliery_android.bean.DisobeyInfoBean;
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
 * 执行情况
 * Created by nefa on 2018/11/20.
 */

public class ImplementationFragment extends BaseFragment {

    private RecyclerView rv_list;
    private String taskId;
    private String state;
    private String jiuwei;
    private RadioGroup rg_select;
    private RadioButton rb_1;
    private RadioButton rb_2;

    @Override
    protected int setLayout(LayoutInflater inflater) {
        return R.layout.fragment_implementation;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        rv_list = mRootView.findViewById(R.id.rv_list);

        jiuwei = getActivity().getIntent().getStringExtra("jiuwei");


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

    public boolean checkState() {
        if (null != rv_list.getAdapter()) {
            BaseQuickAdapter adapter = (BaseQuickAdapter) rv_list.getAdapter();
            ArrayList<CheckBean> mList = (ArrayList<CheckBean>) adapter.getData();
            for (CheckBean entry : mList) {
                if (!entry.isComplete) {
                    return false;
                }
            }
            return true;
        } else {
            return false;
        }
    }

    //刷新列表
    private void refreshView() {
        taskId = getArguments().getString("taskId");
        state = getArguments().getString("state");

        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("id", taskId);
        hashMap.put(BaseLinkList.apiurl, BaseLinkList.coal_mine + BaseLinkList.disobeyinfo);
        mRetrofit.JsonToColliery(BaseLinkList.Base_Url, hashMap, new BaseSubscriber() {
            @Override
            public void onError(ExceptionHandle.ResponeThrowable e) {
                if (null != refreshLayout) {
                    refreshLayout.finishLoadMore();
                    refreshLayout.finishRefresh();
                }
            }

            @Override
            public void onSuccess(JSONObject jsonObject) {
                LogUtils.e("三违单信息->>" + jsonObject.toString());
                final DisobeyInfoBean disobeyInfoBean = FastJsonTools.getBean(jsonObject.toString(), DisobeyInfoBean.class);
                DisobeyInfoBean.DataBean.DisobeytaskBean disobeytask = disobeyInfoBean.getData().getDisobeytask();
                String name = disobeytask.getName();
                String[] names = name.split(",");

                ArrayList<CheckBean> mList = new ArrayList<>();
                for (String curName : names) {
                    CheckBean checkBean = new CheckBean();
                    checkBean.name = curName;
                    mList.add(checkBean);
                }

                RecyclerViewUtils.initLiner(getActivity(), rv_list, R.layout.item_select_radio, mList, new OnGlobalListener() {
                    @Override
                    public <T> void logic(BaseViewHolder helper, List<T> mData, T item, BaseQuickAdapter mAdapter) {
                        final CheckBean checkBean = (CheckBean) item;
                        TextView tv_child_title = helper.getView(R.id.tv_child_title);
                        rg_select = helper.getView(R.id.rg_select);
                        tv_child_title.setText(checkBean.name);
                        rg_select.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                            @Override
                            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                                if (jiuwei.equals("1")) {



                                } else if (jiuwei.equals("0")) {
                                    if (i == R.id.rb_1) {
                                        checkBean.isComplete = false;
                                        LogUtils.e("选中未完成");
                                    } else if (i == R.id.rb_2) {
                                        checkBean.isComplete = true;
                                        LogUtils.e("选中已完成");
                                    }
                                }
                            }
                        });
                    }
                }, null, null);


                if (null != refreshLayout) {
                    refreshLayout.finishLoadMore();
                    refreshLayout.finishRefresh();
                }

            }
        });
    }

    public class CheckBean {
        public String name;
        public boolean isComplete;
    }
}
