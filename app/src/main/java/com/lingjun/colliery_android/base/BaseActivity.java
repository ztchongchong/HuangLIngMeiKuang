package com.lingjun.colliery_android.base;

import android.app.ActivityManager;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.SPUtils;
import com.gyf.barlibrary.ImmersionBar;
import com.lingjun.colliery_android.Manifest;
import com.lingjun.colliery_android.R;
import com.lingjun.colliery_android.utils.retrofit.RetrofitUtils;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;
import com.tbruyelle.rxpermissions2.Permission;
import com.tbruyelle.rxpermissions2.RxPermissions;
import com.tencent.mm.opensdk.utils.Log;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.List;
import java.util.concurrent.TimeUnit;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import io.reactivex.functions.Consumer;


/**
 * 基类
 * Created by nefa on 2017/12/23.
 */

public abstract class BaseActivity extends AppCompatActivity {

    protected RetrofitUtils mRetrofit;
    protected abstract int getResourcesId();
    protected abstract void init(Bundle savedInstanceState) throws PackageManager.NameNotFoundException;
    private ActivityManager activityManager;
    private String packageName;
    private boolean stop = false;
    protected SmartRefreshLayout refreshLayout;
    private BaseRefreshLoadMoreInterface baseRefreshLoadMoreInterface;
    private PopupWindow mPopupWindow;
    protected int pageIndex = 1;
    private TextView tv_content;
    private TextView tv_renshu;
    //dialog,临时使用
    private ProgressDialog loadDialog;

    private Unbinder unbinder;
    protected ImmersionBar mImmersionBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        setContentView(getResourcesId());
        unbinder = ButterKnife.bind(this);
        mImmersionBar = ImmersionBar.with(this);
        mImmersionBar.statusBarDarkFont(false).fitsSystemWindows(true).statusBarColor(R.color.colorPrimary).init();   //所有子类都将继承这些相同的属性
        mRetrofit = RetrofitUtils.getInstance(BaseActivity.this).createBaseApi();
        activityManager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
        packageName = this.getPackageName();
        refreshLayout = findViewById(R.id.refreshLayout);
        ImageView iv_back = findViewById(R.id.iv_back);
        EventBus.getDefault().register(this);
        try {
            init(savedInstanceState);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        if (null != refreshLayout){
            LogUtils.e("RefreshLayout不为Null");
            baseRefreshLoadMoreInterface = setRefreshLoadMoreListener();
            initRefresh();
        }

        if (null != iv_back){
            iv_back.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    finish();
                }
            });
        }
    }

    public void initRefresh(){
        if (null != baseRefreshLoadMoreInterface){
            refreshLayout.setEnableAutoLoadMore(false);
            //refreshLayout.finishRefresh(3000);
            refreshLayout.autoRefresh();
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
        }else {
            refreshLayout.setEnableRefresh(false);
            refreshLayout.setEnableLoadMore(false);
        }
    }

    protected interface BaseRefreshLoadMoreInterface{
        void onLoadMore();
        void onRefresh();
    }

    protected abstract BaseRefreshLoadMoreInterface setRefreshLoadMoreListener();

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void Event(EventMessageBean messageEvent) {
        LogUtils.e("BaseActivity接收到消息->>"+messageEvent.getMessage());
        String customMessage = SPUtils.getInstance().getString("customMessage");
        try {
            if (TextUtils.isEmpty(customMessage)){
                //新的
                JSONArray jsonArray = new JSONArray();
                JSONObject jsonObject = new JSONObject(messageEvent.getMessage());
                jsonArray.put(jsonObject);
                JSONObject curJson = new JSONObject();
                curJson.put("announcement",jsonArray);
                String curNewJson = curJson.toString();
                SPUtils.getInstance().put("customMessage",curNewJson);
            } else {
                //增加
                JSONObject titleJson = new JSONObject(customMessage);
                JSONArray jsonArray = titleJson.getJSONArray("announcement");
                JSONObject jsonObject = new JSONObject(messageEvent.getMessage());
                jsonArray.put(jsonObject);
                JSONObject curJson = new JSONObject();
                curJson.put("announcement",jsonArray);
                String curNewJson = curJson.toString();
                SPUtils.getInstance().put("customMessage",curNewJson);
            }
        }catch (JSONException e){
            LogUtils.e("JsonArray格式化错误");
        }
    }

    public void showLoadDialog(){
        showLoadDialog("正在加载...", false);
    }

    public void showLoadDialog(String message, boolean cancelable) {
        if (loadDialog == null){
            loadDialog = ProgressDialog.show(this, "", message);
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

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().unregister(this);
        }
        if (null != loadDialog){
            dismissDialog();
            loadDialog = null;
        }
        if (unbinder != null){
            unbinder.unbind();
        }
        if (mImmersionBar != null) {
            mImmersionBar.destroy();  //必须调用该方法，防止内存泄漏，不调用该方法，如果界面bar发生改变，在不关闭app的情况下，退出此界面再进入将记忆最后一次bar改变的状态
        }
    }

    /*
    * 判断服务是否启动,context上下文对象 ，className服务的name
    */
    public boolean isServiceRunning(String className) {
        boolean isRunning = false;
        ActivityManager activityManager = (ActivityManager) getApplicationContext().getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningServiceInfo> serviceList = activityManager.getRunningServices(30);

        if (!(serviceList.size() > 0)) {
            return false;
        }

        for (int i = 0; i < serviceList.size(); i++) {
            if (serviceList.get(i).service.getClassName().equals(className) == true) {
                isRunning = true;
                break;
            }
        }
        return isRunning;
    }


    protected PopupWindow initPop(View rootView){
        final PopupWindow mPopup = new PopupWindow(rootView, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        mPopup.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        mPopup.setOutsideTouchable(true);
        /*mPopup.setInputMethodMode(PopupWindow.INPUT_METHOD_NEEDED);
        mPopup.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);*/
        mPopup.setAnimationStyle(R.style.MyPopupWindow_anim_style);
        mPopup.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                Window window = getWindow();
                WindowManager.LayoutParams lp = window.getAttributes();
                lp.alpha = 1.0f;
                window.addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
                window.setAttributes(lp);
            }
        });

        Window window = getWindow();
        WindowManager.LayoutParams lp = window.getAttributes();
        lp.alpha = 0.4f;
        window.addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
        window.setAttributes(lp);
        return mPopup;
    }

    /**
     * 检测App是否在前台
     */
    private class AppStatus implements Runnable {
        @Override
        public void run() {
            stop = false;

            while (!stop) {
                try {
                    if (appOnForeground()) {
                        //可见
                    } else {
                        //不可见
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        private boolean appOnForeground() {
            List<ActivityManager.RunningAppProcessInfo> appProcesses = activityManager.getRunningAppProcesses();
            if (appProcesses == null)
                return false;
            for (ActivityManager.RunningAppProcessInfo appProcess : appProcesses) {
                if (appProcess.processName.equals(packageName) && appProcess.importance == ActivityManager.RunningAppProcessInfo.IMPORTANCE_FOREGROUND) {
                    return true;
                }
            }
            return false;
        }
    }

    /**
     * 强制隐藏键盘
     */
    public void forceHideIM() {
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        if (inputMethodManager == null) {
            return;
        }
        View decorView = getWindow().getDecorView();
        inputMethodManager.hideSoftInputFromWindow(decorView.getWindowToken(), 0);
    }
}
