package com.lingjun.colliery_android.module.dealwith.standardized.check.fragment;

import android.media.Image;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lingjun.colliery_android.R;
import com.lingjun.colliery_android.base.BaseFragment;
import com.lingjun.colliery_android.base.OnGlobalListener;
import com.lingjun.colliery_android.utils.RecyclerViewUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 标化资料
 * Created by nefa on 2018/11/13.
 */

public class StandardizedDataFragment extends BaseFragment {

    private RecyclerView rv_list;

    @Override
    protected int setLayout(LayoutInflater inflater) {
        return R.layout.fragment_standardized_data;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        rv_list = mRootView.findViewById(R.id.rv_list);
        refreshView();
    }

    @Override
    protected BaseRefreshLoadMoreInterface setRefreshLoadMoreListener() {
        return null;
    }

    private void refreshView(){
        ArrayList<TestBean> mList = new ArrayList<>();
        for (int i=0;i<10;i++){
            TestBean testBean = new TestBean();
            testBean.name = "哈哈哈";
            mList.add(testBean);
        }

        RecyclerViewUtils.initLiner(getActivity(), rv_list, R.layout.item_standardized_data, mList, new OnGlobalListener() {
            @Override
            public <T> void logic(BaseViewHolder helper, List<T> mData, T item, BaseQuickAdapter mAdapter) {
                TestBean myBean = (TestBean) item;
                LinearLayout ll_content = helper.getView(R.id.ll_content);
                ImageView iv_icon = helper.getView(R.id.iv_icon);
                helper.addOnClickListener(R.id.rl_is_show);
                if (myBean.isShow){
                    iv_icon.setImageResource(R.drawable.jiantou_top);
                    ll_content.setVisibility(View.VISIBLE);
                }else {
                    iv_icon.setImageResource(R.drawable.jiantou_bottom);
                    ll_content.setVisibility(View.GONE);
                }

                ArrayList<String> mList = new ArrayList<>();
                mList.add("《防爆及讨账资料》");
                mList.add("《煤矿行业风险管控通则》");

                RecyclerView rv_list = helper.getView(R.id.rv_list);
                RecyclerViewUtils.initLinerNoSc(getActivity(), rv_list, R.layout.item_blue_standardized, mList, new OnGlobalListener() {
                    @Override
                    public <T> void logic(BaseViewHolder helper, List<T> mData, T item, BaseQuickAdapter mAdapter) {

                    }
                }, null, null);

            }
        }, null, new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                TestBean testBean = (TestBean) adapter.getData().get(position);
                testBean.isShow = !testBean.isShow;
                adapter.notifyItemChanged(position);
            }
        });
    }


    class TestBean {
        public String name;
        public boolean isShow;
    }
}
