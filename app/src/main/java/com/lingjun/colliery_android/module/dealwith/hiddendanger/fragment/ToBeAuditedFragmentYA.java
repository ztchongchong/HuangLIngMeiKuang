package com.lingjun.colliery_android.module.dealwith.hiddendanger.fragment;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lingjun.colliery_android.R;
import com.lingjun.colliery_android.base.BaseFragment;
import com.lingjun.colliery_android.base.OnGlobalListener;
import com.lingjun.colliery_android.utils.RecyclerViewUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 预案措施（待审核）
 */
public class ToBeAuditedFragmentYA extends BaseFragment{

    private RecyclerView rv_list;

    @Override
    protected int setLayout(LayoutInflater inflater) {
        return R.layout.fragment_tobeaudited_ya;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        rv_list = mRootView.findViewById(R.id.rv_list);




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
        String[] names = {"《防爆及讨论资料》", "《煤矿行业风险管控通则》", "《防爆及讨账资料》", "《煤矿行业风险管控通则》", "《煤矿行业风险管控通则》"};
        ArrayList<InfoBean> mList = new ArrayList<>();
        for (int i = 0; i < names.length; i++) {
            InfoBean bean = new InfoBean();
            bean.name = names[i];
            mList.add(bean);

        }

        RecyclerViewUtils.initLiner(getActivity(), rv_list, R.layout.item_fragment_tobeaudited_jj, mList, new OnGlobalListener() {
            @Override
            public <T> void logic(BaseViewHolder helper, List<T> mData, T item, BaseQuickAdapter mAdapter) {
                InfoBean infoBean = (InfoBean) item;
                TextView tv_jj_name = helper.getView(R.id.tv_jj_name);
                tv_jj_name.setText(infoBean.name);
            }
        }, null, null);


        if (null != refreshLayout) {
            refreshLayout.finishLoadMore();
            refreshLayout.finishRefresh();
        }
    }





    class InfoBean {
        public String name;
        public String state;
    }


}
