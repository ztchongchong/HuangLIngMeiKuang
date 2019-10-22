package com.lingjun.colliery_android.utils.retrofit;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;

import com.blankj.utilcode.util.LogUtils;
import com.lingjun.colliery_android.base.BaseLinkList;
import com.lingjun.colliery_android.utils.code.CodeConfig;
import com.lingjun.colliery_android.utils.code.MyEncrypt;

import org.json.JSONArray;
import org.json.JSONObject;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import io.reactivex.Flowable;
import io.reactivex.FlowableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.annotations.Nullable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;
import okhttp3.Cache;
import okhttp3.ConnectionPool;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 主要封装类
 * Created by Nefa on 2017/9/4.
 */

public class RetrofitUtils {
    private static final int DEFAULT_TIMEOUT = 40;//默认超时
    private BaseApiService apiService;
    private static OkHttpClient okHttpClient;
    public static final String Base_URL = " http://192.168.1.166:8888/safety/";
    public static String baseUrl = Base_URL;
    private static Context mContext;
    private static RetrofitUtils sNewInstance;
    private static Retrofit retrofit;
    private Cache cache = null;
    private File httpCacheDirectory;
    private static Retrofit.Builder builder = new Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())//添加转换器
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())//添加适配器
            .baseUrl(baseUrl);

    private static OkHttpClient.Builder httpClinent = new OkHttpClient.Builder()
            .addNetworkInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
            .writeTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);

    private static class SingletonHolder {
        private static RetrofitUtils INSTANCE = new RetrofitUtils(mContext);
    }

    public static RetrofitUtils getInstance(Context context) {
        if (context != null) {
            mContext = context;
        }
        return SingletonHolder.INSTANCE;
    }

    public static RetrofitUtils getInstance(Context context, String url) {
        if (context != null) {
            mContext = context;
        }
        return new RetrofitUtils(context, url);
    }

    public static RetrofitUtils getInstance(Context context, String url, Map<String, String> headers) {
        if (context != null) {
            mContext = context;
        }
        return new RetrofitUtils(context, url, headers);
    }

    private RetrofitUtils() {

    }

    private RetrofitUtils(Context context) {
        this(context, baseUrl, null);
    }

    private RetrofitUtils(Context context, String url) {
        this(context, url, null);
    }

    //此处为主方法,所有getInstance和构造最终调用的都是此方法
    private RetrofitUtils(Context context, String url, Map<String, String> headers) {

        if (TextUtils.isEmpty(url)) {
            url = baseUrl;
        }

        if (httpCacheDirectory == null) {
            httpCacheDirectory = new File(mContext.getCacheDir(), "nefa_cache");
        }

        try {
            if (cache == null) {
                cache = new Cache(httpCacheDirectory, 10 * 1024 * 1024);
            }
        } catch (Exception e) {
            Log.e("RetrofitUtils", "Could not create http cache", e);
        }

        okHttpClient = new OkHttpClient.Builder()
                .addNetworkInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .cache(cache)
                .addInterceptor(new BaseInterpolator(headers))//添加基础拦截器,处理请求头信息
//                .addInterceptor(new CacheInterceptor(context))//添加缓存拦截器,处理缓存信息
                .addInterceptor(new AddCookiesInterceptor(context, "ch"))//添加Cookie拦截器,处理cookie信息
                .addInterceptor(new ReceivedCookiesInterceptor(context))//添加首次Cookie处理拦截器
//                .addNetworkInterceptor(new CacheInterceptor(context))//添加Network形式缓存拦截器,处理缓存信息
                .connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)//设置超时时间为6秒
                .writeTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)//设置写入超时时间为6秒
                .readTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)//设置读取超时时间为6秒
                .connectionPool(new ConnectionPool(8, 15, TimeUnit.SECONDS))//设置线程池,超时时间为6秒,详细移步: http://www.jianshu.com/p/92a61357164b
                .build();//构建httpClient

        retrofit = new Retrofit.Builder()
                .client(okHttpClient)//传入httpClient
                .addConverterFactory(GsonConverterFactory.create())//传入Gson解析器
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())//传入Rxjava填充器
                .baseUrl(url)//传入url
                .build();//构建
    }

    /**
     * ApiBaseUrl
     *
     * @param newApiBaseUrl
     */
    public static void changeApiBaseUrl(String newApiBaseUrl) {
        baseUrl = newApiBaseUrl;
        builder = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(baseUrl);
    }

    /**
     * 添加Cookie
     */
    public static void addCookie() {
        okHttpClient.newBuilder().cookieJar(new NovateCookieManger(mContext)).build();
        retrofit = builder.client(okHttpClient).build();
    }

    /**
     * 更改Api请求头
     * 根据接口需要可以自定义请求头
     */
    public static void changeApiHeader(Map<String, String> newApiHeaders) {
        okHttpClient.newBuilder().addInterceptor(new BaseInterpolator(newApiHeaders)).build();
        builder.client(httpClinent.build()).build();

    }

    /**
     * 创建BaseApi
     * (这里创建的是已经定义好的Api,如果要创建自定义的Api使用下面的Create方法)
     *
     * @return
     */
    public RetrofitUtils createBaseApi() {
        apiService = create(BaseApiService.class);
        return this;
    }

    /**
     * 创建Apiserver
     * 如果BaseApiService无法满足,可以调用此方法创建自己的MyApiService
     */
    public <T> T create(final Class<T> service) {
        if (service == null) {
            throw new RuntimeException("Api service is null!");
        }
        return retrofit.create(service);
    }

    //普通用法(不提倡使用,只用于学习)
    public Flowable getData(String action, String hash) {
        Flowable data = apiService.getData(action, hash);
        Flowable compose = data.compose(schedulersTransformer());
        //Flowable<TestBean> flowable = compose.compose(transformer());
        return compose;
    }


    //get方式
    public Flowable<ResponseBody> get(@Nullable String url, Map<String, String> parameters, BaseSubscriber subscriber) {
        Flowable<ResponseBody> get = null;
        if (null == url) {
            get = apiService.get("index.php", parameters);
        } else {
            get = apiService.get(url, parameters);
            LogUtils.e("访问接口->>" + url + "  参数->>" + parameters);
        }
        Flowable<ResponseBody> compose = get.compose(schedulersTransformer());
        //Flowable flowable = compose.compose(transformer());
        compose.subscribe(subscriber);
        return compose;
    }


    //post方式
    public Flowable<ResponseBody> post(Map<String, String> parameters, Subscriber subscriber) {
        //parameters.put("hashcode","HJDJ88KSB61SD2KSD88N5BV11E");
        Flowable<ResponseBody> post = apiService.post("index.php", parameters);
        Flowable<ResponseBody> compose = post.compose(schedulersTransformer());
        compose.subscribe(subscriber);
        //Flowable flowable = compose.compose(transformer());
        return compose;
    }

    public Flowable<ResponseBody> postToXinge(String url, Map<String, String> parameters, Subscriber subscriber) {
        Flowable<ResponseBody> post = apiService.post(url, parameters);
        Flowable<ResponseBody> compose = post.compose(schedulersTransformer());
        compose.subscribe(subscriber);
        //Flowable flowable = compose.compose(transformer());
        return compose;
    }

    //post方式
    public Flowable<ResponseBody> post(String url, Map<String, String> parameters) {
        Flowable<ResponseBody> post = null;
        if (null == url) {
            post = apiService.post("index.php", parameters);
        } else {
            post = apiService.post(url, parameters);
            LogUtils.e("访问接口->>" + url + "  参数->>" + parameters);
        }
        Flowable<ResponseBody> compose = post.compose(schedulersTransformer());
        //Flowable flowable = compose.compose(transformer());
        return compose;
    }


    //发送json(post)
    public Flowable<ResponseBody> JsonToColliery(String url, Map<String, String> parameters, Subscriber subscriber) {
        Flowable<ResponseBody> json = null;
        JSONObject jsonObject = null;
        try {
            jsonObject = new JSONObject();
            Set<String> strings = parameters.keySet();
            if (parameters.size() != 0) {
                for (String key : strings) {
                    jsonObject.put(key, parameters.get(key));
                }
            }
            LogUtils.e("访问接口->>" + url + "  参数->>" + jsonObject.toString());
        } catch (Exception e) {
            LogUtils.e("访问接口->>" + url + "出错->>" + e.getMessage());
        }
        MediaType parse = MediaType.parse("application/json; charset=utf-8");
        RequestBody body = RequestBody.create(parse, jsonObject.toString());
        json = apiService.json(url, body);
        Flowable<ResponseBody> compose = json.compose(schedulersTransformer());
        compose.subscribe(subscriber);
        //Flowable flowable = compose.compose(transformer());
        return compose;
    }

    /**
     * 图片批量上传
     *
     * @param params 携带参数, 可为空
     * @param files  文件
     * @return
     */
    public Call<ResponseBody> upload(@Nullable HashMap<String, String> params, @NonNull HashMap<String, File> files) {
        boolean isFiles = false;
        MultipartBody.Builder requestBody = new MultipartBody.Builder().setType(MultipartBody.FORM);
        if (null != params && params.size() != 0) {
            Set<String> keys = params.keySet();
            for (String key : keys) {
                requestBody.addFormDataPart(key, params.get(key));
            }
        }
        if (null != files && files.size() != 0) {
            isFiles = true;
            Set<String> keys = files.keySet();
            for (String key : keys) {
                requestBody.addFormDataPart(key, files.get(key).getName(), RequestBody.create(MediaType.parse("image/*"), files.get(key)));
            }
        }
        if (isFiles) {
            MultipartBody build = requestBody.build();
            Call<ResponseBody> call = apiService.upLoad(BaseLinkList.coal_mine + BaseLinkList.getUpload, "index.php", build);
            return call;
        }
        return null;
    }

    /**
     * 图片批量上传
     *
     * @param params   携带参数, 可为空
     * @param files    文件
     * @param callback 回调
     * @return
     */
    public Call<ResponseBody> upload(@Nullable HashMap<String, String> params, @NonNull HashMap<String, File> files, Callback<ResponseBody> callback) {
        boolean isFiles = false;
        MultipartBody.Builder requestBody = new MultipartBody.Builder().setType(MultipartBody.FORM);
        if (null != params && params.size() != 0) {
            Set<String> keys = params.keySet();
            for (String key : keys) {
                requestBody.addFormDataPart(key, params.get(key));
            }
        }
        if (null != files && files.size() != 0) {
            isFiles = true;
            Set<String> keys = files.keySet();
            for (String key : keys) {
                requestBody.addFormDataPart(key, files.get(key).getName(), RequestBody.create(MediaType.parse("image/*"), files.get(key)));
            }
        }
        if (isFiles) {
            MultipartBody build = requestBody.build();
            Call<ResponseBody> call = apiService.upLoad(BaseLinkList.coal_mine + BaseLinkList.getUpload, "index.php", build);
            call.enqueue(callback);
            return call;
        }
        return null;
    }

    /**
     * 图片批量上传
     *
     * @param params   携带参数, 可为空
     * @param files    文件
     * @param callback 回调
     * @return
     */
    public Call<ResponseBody> upload(String url, @Nullable HashMap<String, String> params, @NonNull HashMap<String, File> files, Callback<ResponseBody> callback) {
        boolean isFiles = false;
        MultipartBody.Builder requestBody = new MultipartBody.Builder().setType(MultipartBody.FORM);
        if (null != params && params.size() != 0) {
            Set<String> keys = params.keySet();
            for (String key : keys) {
                requestBody.addFormDataPart(key, params.get(key));
            }
        }
        if (null != files && files.size() != 0) {
            isFiles = true;
            Set<String> keys = files.keySet();
            for (String key : keys) {
                requestBody.addFormDataPart(key, files.get(key).getName(), RequestBody.create(MediaType.parse("image/*"), files.get(key)));
            }
        }
        if (isFiles) {
            MultipartBody build = requestBody.build();
            Call<ResponseBody> call = apiService.upLoad(BaseLinkList.coal_mine + BaseLinkList.getUpload, url, build);
            call.enqueue(callback);
            return call;
        }
        return null;
    }

    //下载文件
    public void download(String url, final CallBack callBack) {
        if (null != url) {
            Flowable<ResponseBody> downLoadFile = apiService.downLoadFile(url);
            Flowable<ResponseBody> compose = downLoadFile.compose(schedulersTransformer());
            //Flowable flowable = compose.compose(transformer());
            compose.subscribe(new DownSubscriber<ResponseBody>(callBack));
        } else {
            Log.e("Retrofit", "下载地址为空!");
        }

    }


    /**
     * 转换线程
     * 因为RxJava中每一次都必须要指定生产线程和消费线程,而代码很多都是重复的
     * 所以我们在这里利用RxJava的转换器写一个Transformer,让其统一处理
     * 这样一来,封装的更加完整,在上层调用时不需要你去考虑是在io线程还是主线程
     * 调用完毕直接更新UI即可
     *
     * @return
     */

    public FlowableTransformer schedulersTransformer() {
        return new FlowableTransformer() {
            @Override
            public Publisher apply(@NonNull Flowable upstream) {
                return upstream.subscribeOn(Schedulers.io())
                        .unsubscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread());
            }
        };
    }

    /**
     * 转换线程
     * io线程 -> 子线程 -> 主线程
     * 意义同上,由于下载文件需要经历的线程逻辑不同,这里重新封装
     *
     * @return
     */
    public FlowableTransformer schedulersTransformernewThread() {
        return new FlowableTransformer() {
            @Override
            public Publisher apply(@NonNull Flowable upstream) {
                return upstream.subscribeOn(Schedulers.io())
                        .unsubscribeOn(Schedulers.io())
                        .subscribeOn(Schedulers.newThread())
                        .observeOn(AndroidSchedulers.mainThread());
            }
        };
    }


    /**
     * 添加一个错误处理,当定义的Observable遇到错误时执行onErrorResumeNext方法
     * 此方法让Observable在遇到错误时开始发射第二个Observable的数据序列。
     * 这个方法返回的FlowableTransformer对象就是第二个Observable
     * (这块的处理方式我也没他妈怎么看明白,我再研究研究再说)
     *
     * @param <T>
     * @return
     */
    /*public <T> FlowableTransformer<<T>, T> transformer() {

        FlowableTransformer flowableTransformer = new FlowableTransformer() {
            @Override
            public Publisher apply(@NonNull Flowable upstream) {
                return upstream.map(new HandleFuc<T>()).onErrorResumeNext(new HttpResponseFunc<T>());
            }

             *//* @Override
            public Object call(Object observable) {
                return observable.map(new HandleFuc<T>()).onErrorResumeNext(new HttpResponseFunc<T>());
            }*//*
        };
        return flowableTransformer;
    }*/


    <T> FlowableTransformer<T, T> applySchedulers() {
        return (FlowableTransformer<T, T>) schedulersTransformer();
    }

    //转换所有线程为IO线程 (用于观察者接收到通知后依然需要进行IO操作的场景)
    public <T> Flowable<T> switchSchedulersIo(Flowable<T> observable) {
        return observable.subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(Schedulers.io());
    }

    //转换回io线程+主线程模式
    public static <T> Flowable<T> switchSchedulersMain(Flowable<T> observable) {
        return observable.subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    //用于上面error处理
    private static class HttpResponseFunc<T> implements Function<Throwable, Flowable<T>> {
        @Override
        public Flowable<T> apply(@NonNull Throwable t) {
            return Flowable.error(ExceptionHandle.handleException(t));
        }
    }


    /**
     * /**
     * execute your customer API
     * For example:
     * MyApiService service =
     * RetrofitClient.getInstance(Activity.this).create(MyApiService.class);
     * <p>
     * RetrofitClient.getInstance(Activity.this)
     * .execute(service.lgon("name", "password"), subscriber)
     * * @param subscriber
     */

    public static <T> Flowable<T> call(Flowable<T> observable, Subscriber<T> subscriber) {
        observable = observable.subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
        observable.subscribe(subscriber);
        return observable;
    }

    /**
     * DownSubscriber
     * 订阅者
     *
     * @param <ResponseBody>
     */
    class DownSubscriber<ResponseBody> extends DisposableSubscriber<ResponseBody> {
        CallBack callBack;

        public DownSubscriber(CallBack callBack) {
            this.callBack = callBack;
        }

        @Override
        public void onStart() {
            super.onStart();
            if (callBack != null) {
                callBack.onStart();
            }
        }

        @Override
        public void onError(Throwable e) {
            if (callBack != null) {
                callBack.onError(e);
            }
        }

        @Override
        public void onComplete() {
            if (callBack != null) {
                callBack.onCompleted();
            }
        }

        @Override
        public void onNext(ResponseBody responseBody) {
            DownLoadManager.getInstance(callBack).writeResponseBodyToDisk(mContext, (okhttp3.ResponseBody) responseBody);
        }
    }

}
