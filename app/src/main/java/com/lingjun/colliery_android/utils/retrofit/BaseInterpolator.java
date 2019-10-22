package com.lingjun.colliery_android.utils.retrofit;

import android.util.Log;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * 基础拦截器
 * Created by Nefa on 2017/9/5.
 */

public class BaseInterpolator implements Interceptor {

    private Map<String, String> headers;

    public BaseInterpolator(Map<String, String> headers) {
        this.headers = headers;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        //构建Request
        Request.Builder builder = chain.request().newBuilder();
        //如果请求头不为空并且请求头数量大于0
        if (headers != null && headers.size() > 0){
            //取出所有请求头
            Set<String> keys = headers.keySet();
            //循环,统一处理请求头并重新添加
            for (String headerKey : keys){
                builder.addHeader(headerKey, headers.get(headerKey)).build();
            }
        }
        Log.d("RetrofitClent",  "Okhttp url:" + builder.build().url());
        return chain.proceed(builder.build());
    }
}
