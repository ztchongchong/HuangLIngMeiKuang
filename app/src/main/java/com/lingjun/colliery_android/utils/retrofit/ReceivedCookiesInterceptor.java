package com.lingjun.colliery_android.utils.retrofit;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;

import com.lingjun.colliery_android.base.UserBean;

import java.io.IOException;

import io.reactivex.Flowable;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import okhttp3.Interceptor;
import okhttp3.Response;

/**
 * 接收Cookies拦截器
 * 初次请求cookie为空,从响应头中拿出cookie信息并进行存储
 * Created by Nefa on 2017/9/5.
 */

public class ReceivedCookiesInterceptor implements Interceptor {
    private Context context;
    SharedPreferences sharedPreferences;

    public ReceivedCookiesInterceptor(Context context) {
        super();
        this.context = context;
        sharedPreferences = context.getSharedPreferences("cookie", Context.MODE_PRIVATE);
    }


    @SuppressLint("CheckResult")
    @Override
    public Response intercept(Chain chain) throws IOException {
        if (chain == null) {
            Log.d("RetrofitClent", "Receivedchain == null");
        }
        //放行request请求获取response
        Response originalResponse = chain.proceed(chain.request());
        Log.d("RetrofitClent", "originalResponse" + originalResponse.toString());

        //如果响应头中cookie信息不为null
        if (!originalResponse.headers("set-cookie").isEmpty()) {
            final StringBuffer cookieBuffer = new StringBuffer();
            //开启RxJava背压功能放入cookie
            Flowable.fromIterable(originalResponse.headers("set-cookie"))
                    //开启转换,这里说一下map方法
                    //map的基本作用就是将一个Observable通过某种函数关系,转换为另一种Observable
                    .map(new Function<String, String>() {
                        @Override
                        public String apply(@NonNull String s) {
                            //剪切出所有cookie信息
                            String[] cookieArray = s.split(";");

                            SharedPreferences token = context.getSharedPreferences("userinfo", Context.MODE_PRIVATE);
                            Log.e("RetrofitUtilslan拦截器", token + "");
                            if (null != token && !TextUtils.isEmpty(token.getString("userinfoDetails", ""))) {
                                    for (String curCookie : cookieArray) {
                                        if (curCookie.contains("safety.session.id=")) {
                                            return "safety.session.id=" + token.getString("userinfoDetails", "");
                                        } else {
                                            return curCookie;
                                        }
                                    }
                            }
                            Log.d("RetrofitUtils", cookieArray[0]);
                            return cookieArray[0];
                        }
                    }).subscribe(new Consumer<String>() {
                @Override
                public void accept(@NonNull String cookie) {
                    //字符串拼接
                    cookieBuffer.append(cookie).append(";");
                }
            });
            //存储
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("cookie", cookieBuffer.toString()).commit();
            Log.e("cookie", "ReceivedCookiesInterceptor:" + cookieBuffer.toString());
        }
        return originalResponse;
    }
}
