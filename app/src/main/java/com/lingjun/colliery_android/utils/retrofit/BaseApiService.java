package com.lingjun.colliery_android.utils.retrofit;

import java.util.Map;

import io.reactivex.Flowable;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Header;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import retrofit2.http.Streaming;
import retrofit2.http.Url;

/**
 * 郑海
 * (摘自网络,添加注释,便于理解)
 * Retrofit学习类,可直接使用,建议理解
 * Created by Nefa on 2017/9/4.
 */

public interface BaseApiService {

    /**
     * 测试<-----
     * 注意这里直接返回Flowable而不是Observable,Flowable为rxjava2.0新增,用以解决背压问题.(背压问题自己百度)
     * 这种写法把url写死了,所以并不提倡,写在这里是当做一个例子与下面进行比对
     */
    @GET("api.php")
    Flowable<ResponseBody> getData(@Query("action") String action, @Query("authhash") String authhash);

    /**
     * Get请求 url作为参数传递,大大提升扩展性
     *
     * @param url  : 你懂的
     * @param maps : 参数
     * @return
     * @GET: 1.用于发送一个get请求
     * 2.GET注解一般必须添加相对路径或绝对路径或者全路径,
     * 如果不想在GET注解后添加请求路径,则可以在方法的第一个参数中用@Url注解添加请求路径
     * @Url: 1.作用于方法参数
     * 2.用于添加请求的接口地址
     * @QueryMap: 1.作用于方法的参数
     * 2.以map的形式添加查询参数,即请求参数
     * 3.参数的键和值都通过String.valueOf()转换为String格式
     * 4.map的键和值默认进行URL编码
     * 5.map中每一项的键和值都不能为空,否则抛出IllegalArgumentException异常
     */
    @GET()
    Flowable<ResponseBody> get(@Url() String url, @QueryMap Map<String, String> maps);

    /**
     * Post请求 用法跟上面get请求一样
     * 这里说一下注解:
     *
     * @param url  : 你懂的
     * @param maps : 参数
     * @return Flowable<ResponseBody>, 返回okhttp3的respanseBody
     * @Field: 1.作用于方法的参数
     * 2.用于发送一个表单请求,也就是参数在请求体中
     * 3.用String.valueOf()把参数值转换为String,然后进行URL编码,当参数值为null值时,会自动忽略,
     * 如果传入的是一个List或array,则为每一个非空的item拼接一个键值对,每一个键值对中的键是相同的,值就是非空item的值,
     * 如: name=张三&name=李四&name=王五,另外,如果item的值有空格,在拼接时会自动忽略,例如某个item的值为:张 三,则拼接后为name=张三.
     * @FieldMap: 1.作用于方法的参数
     * 2.用于发送一个表单请求,也就是参数在请求体中
     * 3.map中每一项的键和值都不能为空,否则抛出IllegalArgumentException异常
     * @FormUrlEncoded: 1.用于修饰Field注解和FieldMap注解
     * 2.使用该注解,表示请求正文将使用表单网址编码。
     * 字段应该声明为参数，并用@Field注释或FieldMap注释。
     * 使用FormUrlEncoded注解的请求将具”application / x-www-form-urlencoded” MIME类型。
     * 字段名称和值将先进行UTF-8进行编码,再根据RFC-3986进行URI编码.
     */
    @FormUrlEncoded
    @POST()
    Flowable<ResponseBody> post(@Url() String url, @FieldMap Map<String, String> maps);

    @FormUrlEncoded
    @POST()
    Flowable<ResponseBody> post(@FieldMap Map<String, String> maps);


    /**
     * Post请求,传递json.
     *
     * @param url     : 你懂的
     * @param jsonStr : 你懂的
     * @return Flowable<ResponseBody>, 返回okhttp3的respanseBody
     * @Post: 1.
     * @Body: 1.作用于方法的参数
     * 2.使用该注解定义的参数不可为null
     * 3.当你发送一个post或put请求,但是又不想作为请求参数或表单的方式发送请求时,
     * 使用该注解定义的参数可以直接传入一个实体类,retrofit会通过convert把该实体序列化并将序列化后的结果直接作为请求体发送出去.
     */
    @POST()
    Flowable<ResponseBody> json(@Url String url, @Body RequestBody jsonStr);


    /**
     * Post请求,传递json.
     *
     * @param url    : 你懂的
     * @param xmlstr : 你懂的
     * @return Flowable<ResponseBody>, 返回okhttp3的respanseBody
     * @Post: 1.
     * @Body: 1.作用于方法的参数
     * 2.使用该注解定义的参数不可为null
     * 3.当你发送一个post或put请求,但是又不想作为请求参数或表单的方式发送请求时,
     * 使用该注解定义的参数可以直接传入一个实体类,retrofit会通过convert把该实体序列化并将序列化后的结果直接作为请求体发送出去.
     */
    @POST()
    Flowable<ResponseBody> xml(@Url String url, @Body RequestBody xmlstr);


    /**
     * 上传图片(这个貌似没啥好说的)
     *
     * @param url
     * @param Body
     * @return
     */
    @POST()
    Call<ResponseBody> upLoad(
            @Header("apiurl") String api,
            @Url() String url,
            @Body RequestBody Body);


    /**
     * Get文件/图片下载
     *
     * @param fileUrl : 下载地址
     * @return Flowable<ResponseBody>, 返回okhttp3的respanseBody
     * @Streaming: 1.作用于方法
     * 2.处理返回Response的方法的响应体，即没有将body（）转换为byte []。
     */
    @Streaming
    @GET
    Flowable<ResponseBody> downLoadFile(@Url String fileUrl);
}
