package com.lingjun.colliery_android.utils.retrofit;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;

import com.blankj.utilcode.util.LogUtils;
import com.lingjun.colliery_android.base.UserBean;

import java.io.IOException;

import io.reactivex.Flowable;
import io.reactivex.functions.Consumer;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Cookies拦截器
 * Created by Nefa on 2017/9/5.
 */

public class AddCookiesInterceptor implements Interceptor {

    private Context context;
    private String lang;

    public AddCookiesInterceptor(Context context, String language) {
        super();
        this.context = context;
        this.lang = language;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        if (chain == null){
            Log.d("RetrofitClent", "Addchain == null");
        }
        //取出request
        final Request.Builder builder = chain.request().newBuilder();
        //建立cookie缓存
        SharedPreferences sharedPreferences = context.getSharedPreferences("cookie", Context.MODE_PRIVATE);
        //利用RxJava背压功能,传入保存的cookie
        Flowable.just(sharedPreferences.getString("cookie",""))
                //开启简单订阅
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String cookie) {
                        //判断cookie是否包含"lang=ch"
                        if (cookie.contains("lang=ch")){
                            //如果包含,则更改语言信息为本地设置的语言
                            cookie = cookie.replace("lang=ch","lang="+lang);
                        }
                        //同上
                        if (cookie.contains("lang=en")){
                            cookie = cookie.replace("lang=en","lang="+lang);
                        }
                        Log.d("RetrofitClent", "AddCookiesInterceptor: "+cookie);
                        /*if (null != UserBean.getInstance() && !TextUtils.isEmpty(UserBean.getInstance().getToken())){
                            cookie = "safety.session.id="+UserBean.getInstance().getToken();
                        }*/
                        //重新添加cookie
                        builder.addHeader("cookie", cookie);
                    }
                });
        //放行
        return chain.proceed(builder.build());
    }
}
