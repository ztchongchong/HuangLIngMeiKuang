package com.lingjun.colliery_android.module.learning;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.webkit.DownloadListener;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.lingjun.colliery_android.R;
import com.lingjun.colliery_android.base.BaseFragment;
import com.lingjun.colliery_android.base.BaseLinkList;
import com.lingjun.colliery_android.base.UserBean;
import com.lingjun.colliery_android.base.UserBeans;
import com.lingjun.colliery_android.bean.MainMessageBean;
import com.lingjun.colliery_android.bean.WebViewBean;
import com.lingjun.colliery_android.module.dealwith.hiddendanger.general_hidden_danger.HiddenDangerNtryActivity;
import com.lingjun.colliery_android.module.main.MainActivity;
import com.lingjun.colliery_android.utils.FastJsonTools;
import com.lingjun.colliery_android.utils.retrofit.BaseSubscriber;
import com.lingjun.colliery_android.utils.retrofit.ExceptionHandle;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 学习
 * Created by nefa on 2018/10/18.
 *
 * @author
 */

public class LearningFragment extends BaseFragment {

    private WebView webBase;
    private ProgressBar pbWebBase;
    private String webPath = "";

    private String currEmployeeno = "";
    private String unitId = "";

    @Override
    protected int setLayout(LayoutInflater inflater) {
        return R.layout.fragment_learning;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        webBase = mRootView.findViewById(R.id.web_base);
        pbWebBase = mRootView.findViewById(R.id.pb_web_base);
        webPath = "http://118.190.0.100:8881";
        refreshView();
        initWebView();
    }

    private void refreshView() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(BaseLinkList.apiurl, BaseLinkList.coal_mine + BaseLinkList.getCurrEmployeeno);
        mRetrofit.JsonToColliery(BaseLinkList.Base_Url, hashMap, new BaseSubscriber() {
            @Override
            public void onError(ExceptionHandle.ResponeThrowable e) {

            }

            @Override
            public void onSuccess(JSONObject jsonObject) throws JSONException {
                LogUtils.e("webview->>" + jsonObject.toString());
                WebViewBean webViewBean = FastJsonTools.getBean(jsonObject.toString(), WebViewBean.class);
                WebViewBean.DataBean webview = webViewBean.getData();
                currEmployeeno = webview.getCurrEmployeeno();
                unitId = webview.getUnitId();
            }
        });
    }

    @Override
    protected BaseRefreshLoadMoreInterface setRefreshLoadMoreListener() {
        return null;
    }

    private void initWebView() {
        //设置加载进度最大值
        pbWebBase.setMax(100);

        WebSettings webSettings = webBase.getSettings();
        if (Build.VERSION.SDK_INT >= 19) {
            //加载缓存否则网络
            webSettings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        }

        if (Build.VERSION.SDK_INT >= 19) {
            //图片自动缩放 打开
            webSettings.setLoadsImagesAutomatically(true);
        } else {
            //图片自动缩放 关闭
            webSettings.setLoadsImagesAutomatically(false);
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            //软件解码
            webBase.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        }
        //硬件解码
        webBase.setLayerType(View.LAYER_TYPE_HARDWARE, null);

//        webSettings.setAllowContentAccess(true);
//        webSettings.setAllowFileAccessFromFileURLs(true);
//        webSettings.setAppCacheEnabled(true);
   /*     if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            webSettings.setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);
        }*/


        // setMediaPlaybackRequiresUserGesture(boolean require) //是否需要用户手势来播放Media，默认true

        webSettings.setJavaScriptEnabled(true); // 设置支持javascript脚本
//        webSettings.setPluginState(WebSettings.PluginState.ON);
        webSettings.setSupportZoom(true);// 设置可以支持缩放
        webSettings.setBuiltInZoomControls(true);// 设置出现缩放工具 是否使用WebView内置的缩放组件，由浮动在窗口上的缩放控制和手势缩放控制组成，默认false
        webSettings.setDisplayZoomControls(false);//隐藏缩放工具
        webSettings.setUseWideViewPort(true);// 扩大比例的缩放
        webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);//自适应屏幕
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setDatabaseEnabled(true);//
        webSettings.setSavePassword(true);//保存密码
        webSettings.setDomStorageEnabled(true);//是否开启本地DOM存储  鉴于它的安全特性（任何人都能读取到它，尽管有相应的限制，将敏感数据存储在这里依然不是明智之举），Android 默认是关闭该功能的。
        webBase.setSaveEnabled(true);
        webBase.setKeepScreenOn(true);


        // 设置setWebChromeClient对象
        webBase.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onReceivedTitle(WebView view, String title) {
                super.onReceivedTitle(view, title);
                //mRxTextAutoZoom.setText(title);
            }

            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                // TODO Auto-generated method stub
                pbWebBase.setProgress(newProgress);
                super.onProgressChanged(view, newProgress);
            }
        });
        //设置此方法可在WebView中打开链接，反之用浏览器打开
        webBase.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                if (!webBase.getSettings().getLoadsImagesAutomatically()) {
                    webBase.getSettings().setLoadsImagesAutomatically(true);
                }
                pbWebBase.setVisibility(View.GONE);
            }

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                // TODO Auto-generated method stub
                pbWebBase.setVisibility(View.VISIBLE);
                super.onPageStarted(view, url, favicon);
            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {

                if (url.startsWith("http:") || url.startsWith("https:")) {
                    view.loadUrl(url);
                    return false;
                }

                // Otherwise allow the OS to handle things like tel, mailto, etc.
                try {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                    startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return true;
            }
        });
        webBase.setDownloadListener(new DownloadListener() {
            @Override
            public void onDownloadStart(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, String paramAnonymousString4, long paramAnonymousLong) {
                Intent intent = new Intent();
                intent.setAction("android.intent.action.VIEW");
                intent.setData(Uri.parse(paramAnonymousString1));
                startActivity(intent);
            }
        });

        webBase.loadUrl(webPath);
//        webBase.loadUrl(UserBeans.getInstance().getUser().getStudyappurl());
    }

    public class AndroidApi {
        private MainActivity activity;

        public AndroidApi(MainActivity activity) {
            this.activity = activity;
        }

        @JavascriptInterface
        public void show() {
            activity.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    LogUtils.e("开始show");
//                    activity.topview.setVisibility(View.VISIBLE);
                    activity.getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_VISIBLE);
                    //this.activity!!.getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_VISIBLE);
                }
            });
        }

        @JavascriptInterface
        public void hide() {
            activity.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    LogUtils.e("开始hide");
//                    activity.setHalfTransparent(activity);
//                    activity.setFitSystemWindow(false, activity);
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                        View decorView = activity.getWindow().getDecorView();
                        decorView.setSystemUiVisibility((View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                                | View.SYSTEM_UI_FLAG_FULLSCREEN
                                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY));
//                        activity.topview.setVisibility(View.GONE);
                    }
                }
            });
        }

        @JavascriptInterface
        public String getDeviceId() {
            JsonObject json = new JsonObject();
            json.addProperty("unitId", unitId);
            if (!TextUtils.isEmpty(currEmployeeno)) {
                json.addProperty("employeeno", currEmployeeno);
            } else {
                json.addProperty("employeeno", UserBeans.getInstance().getUser().getId());
            }
            String str = json.toString();
            LogUtils.e("json======>" + json);
            return str;
        }
    }

}
