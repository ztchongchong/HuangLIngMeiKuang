package com.lingjun.colliery_android.utils.retrofit;

import android.content.Context;

import java.util.List;

import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;

/**
 * Cookie管理器
 * Created by Nefa on 2017/9/5.
 */

public class NovateCookieManger implements CookieJar {

    private static final String TAG = "NovateCookieManger";
    private static Context mContext;
    private static PersistentCookieStore cookieStore;

    //构造
    public NovateCookieManger(Context context){
        mContext = context;
        if (cookieStore == null){
            cookieStore = new PersistentCookieStore(mContext);
        }
    }

    //保存响应中的cookies
    @Override
    public void saveFromResponse(HttpUrl url, List<Cookie> cookies){
        if (cookies != null && cookies.size() > 0){
            for (Cookie item : cookies){
                cookieStore.add(url,item);
            }
        }
    }

    //加载
    @Override
    public List<Cookie> loadForRequest(HttpUrl url){
        List<Cookie> cookies = cookieStore.get(url);
        return cookies;
    }

}
