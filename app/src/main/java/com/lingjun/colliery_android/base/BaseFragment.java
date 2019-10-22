package com.lingjun.colliery_android.base;

import android.app.ProgressDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.PopupWindow;

import com.lingjun.colliery_android.R;
import com.lingjun.colliery_android.utils.retrofit.RetrofitUtils;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;

import butterknife.ButterKnife;
import butterknife.Unbinder;


/**
 * Created by nefa on 2018/4/19.
 */

public abstract class BaseFragment extends Fragment {

    protected View mRootView;
    protected RetrofitUtils mRetrofit;
    protected SmartRefreshLayout refreshLayout;
    private BaseRefreshLoadMoreInterface baseRefreshLoadMoreInterface;
    protected int pageIndex = 1;
    private Unbinder unbinder;
    private ProgressDialog loadDialog;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    protected abstract int setLayout(LayoutInflater inflater);

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mRootView = inflater.inflate(setLayout(inflater), container, false);
        unbinder = ButterKnife.bind(this, mRootView);
        mRetrofit = RetrofitUtils.getInstance(getActivity()).createBaseApi();
        refreshLayout = mRootView.findViewById(R.id.refreshLayout);
        ImageView iv_back = mRootView.findViewById(R.id.iv_back);

        init(savedInstanceState);
        if (null != refreshLayout){
            baseRefreshLoadMoreInterface = setRefreshLoadMoreListener();
            initRefresh();
        }

        if (null != iv_back){
            iv_back.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    getActivity().finish();
                }
            });
        }
        return mRootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (unbinder != null)
            unbinder.unbind();
    }

    public void initRefresh(){
        if (null != baseRefreshLoadMoreInterface){
            refreshLayout.setEnableAutoLoadMore(false);
            //refreshLayout.finishRefresh(3000);
            refreshLayout.setOnRefreshLoadMoreListener(new OnRefreshLoadMoreListener() {
                @Override
                public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                    pageIndex++;
                    baseRefreshLoadMoreInterface.onLoadMore();
                }

                @Override
                public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                    pageIndex = 1;
                    baseRefreshLoadMoreInterface.onRefresh();
                }
            });
            refreshLayout.autoRefresh();
        }else {
            refreshLayout.setEnableRefresh(false);
            refreshLayout.setEnableLoadMore(false);
        }
    }

    protected abstract void init(Bundle savedInstanceState);

    protected interface BaseRefreshLoadMoreInterface{
        void onLoadMore();
        void onRefresh();
    }

    protected abstract BaseRefreshLoadMoreInterface setRefreshLoadMoreListener();

    protected PopupWindow initPop(View rootView){
        PopupWindow mPopup = new PopupWindow(rootView, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        mPopup.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        mPopup.setOutsideTouchable(true);
        /*mPopup.setInputMethodMode(PopupWindow.INPUT_METHOD_NEEDED);
        mPopup.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);*/
        mPopup.setAnimationStyle(R.style.MyPopupWindow_anim_style);
        mPopup.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                Window window = getActivity().getWindow();
                WindowManager.LayoutParams lp = window.getAttributes();
                lp.alpha = 1.0f;
                window.addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
                window.setAttributes(lp);
            }
        });

        Window window = getActivity().getWindow();
        WindowManager.LayoutParams lp = window.getAttributes();
        lp.alpha = 0.4f;
        window.addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
        window.setAttributes(lp);
        return mPopup;
    }

    public void showLoadDialog(){
        showLoadDialog("正在加载...", false);
    }

    public void showLoadDialog(String message, boolean cancelable) {
        if (loadDialog == null){
            loadDialog = ProgressDialog.show(getActivity(), "", message);
            loadDialog.setCancelable(cancelable);
        }
        else if (!loadDialog.isShowing()) {
            loadDialog.show();
            loadDialog.setCancelable(cancelable);
        }
    }

    public void dismissDialog() {
        if (loadDialog != null && loadDialog.isShowing()) {
            loadDialog.dismiss();
        }
    }
}
