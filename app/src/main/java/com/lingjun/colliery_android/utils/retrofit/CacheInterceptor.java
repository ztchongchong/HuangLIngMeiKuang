package com.lingjun.colliery_android.utils.retrofit;


import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import java.io.IOException;

import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * 缓存拦截器:
 *      简单说一下,Retrofit是没有缓存功能的,而我们要做缓存,就需要使用okhttp的拦截器
 *      okhttp添加拦截器有两种:
 *          1.addInterceptor:
 *              addinterceptor添加的是application拦截器，他只会在response被调用一次。
 *          2.addNetworkInterceptor:
 *              addNetworkInterceptor添加的是网络拦截器，他会在在request和resposne是分别被调用一次
 *
 * 此处涉及http协议的请求头和响应头,如果想了解
 * 请移步: http://www.jianshu.com/p/2710ed1e6b48 了解拦截器
 * 然后再移步: http://blog.chinaunix.net/uid-10540984-id-3130355.html 了解http协议
 * Created by Nefa on 2017/9/4.
 */

public class CacheInterceptor implements Interceptor {

    public static final String TAG = "CacheInterceptor";
    private Context context;
    //缓存保存时间, 此处为3天
    int maxStale = 60 * 60 * 24 * 3;
    //int maxStale = 0;

    public CacheInterceptor(Context context){
        this.context = context;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();

        //查看网络是否可用
        if (NetworkUtil.isNetworkAvailable(context)){
            //继续执行request获取Response对象(都知道是啥吧,所以我就不说了)
            Response response = chain.proceed(request);
            //设置为60秒后连接网络
            int maxAge = 60;

            String cacheControl = request.cacheControl().toString();
            Log.d(TAG,"60s load cahe" + cacheControl);
            //重写服务器响应头信息
            return  response.newBuilder()
                    //清除头信息，因为服务器如果不支持，会返回一些干扰信息，不清除下面无法生效
                    .removeHeader("Pragma")
                    .removeHeader("Cache-Control")
                    //重写响应头
                    //此处max-age设置为60即表示在60秒内,数据由缓存提供,并且60秒内不会发送请求到服务器
                    //当时间超过60秒后,才会发送请求
                    .header("Cache-Control","public, max-age=" + maxAge)
                    .build();
        }else {
            ((Activity)context).runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(context, "当前无网络!智能加载缓存", Toast.LENGTH_SHORT).show();
                }
            });
            Log.d(TAG, "无网络,加载缓存!");
            request = request.newBuilder()
                    .cacheControl(CacheControl.FORCE_CACHE)
                    .build();
            Response response = chain.proceed(request);
            //重写服务器响应头信息
            return response.newBuilder()
                    //清除头信息，因为服务器如果不支持，会返回一些干扰信息，不清除下面无法生效
                    .removeHeader("Pragma")
                    .removeHeader("Cache-Control")
                    //重写响应头
                    //此处重写响应头,Cache-Control响应头中max-stale设置为3天,则表示3天内,使用缓存信息
                    .header("Cache-Control", "public, only-if-cached, max-stale=" + maxStale)
                    .build();
        }
    }



}
