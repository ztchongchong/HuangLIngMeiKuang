package com.lingjun.colliery_android.utils.retrofit;

import android.app.ProgressDialog;
import android.text.TextUtils;
import android.util.Log;

import com.alibaba.fastjson.JSON;
import com.blankj.utilcode.util.LogUtils;
import com.lingjun.colliery_android.utils.code.JsonPraserUtil;

import org.json.JSONException;
import org.json.JSONObject;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.io.IOException;


/**
 * Subscriber基类
 * Created by Nefa on 2017/9/5.
 */

public abstract class BaseSubscriber implements Subscriber<okhttp3.ResponseBody> {

    private ProgressDialog progress;

    public BaseSubscriber(){
       /* progress = new ProgressDialog(context);
        progress.setMessage("加载中,请稍后....");*/
    }

    @Override
    public void onSubscribe(Subscription s) {
        //progress.show();
        s.request(10);
    }

    @Override
    public void onError(Throwable e) {
        if (!TextUtils.isEmpty(e.getMessage())){
            LogUtils.e("onError->>"+e.getMessage());
        }
        /*if (progress != null && progress.isShowing()){
            progress.dismiss();
        }*/
        if (e instanceof ExceptionHandle.ResponeThrowable){
            onError((ExceptionHandle.ResponeThrowable)e);
        }else {
            onError(new ExceptionHandle.ResponeThrowable(e, ExceptionHandle.ERROR.UNKNOWN));
        }
    }

    @Override
    public void onNext(okhttp3.ResponseBody responseBody) {
        try {
            String str = new String(responseBody.bytes());
            Log.e("返回参数",""+str);
            String jsonStr = JSON.parseObject(str, String.class);
            //String info = JsonPraserUtil.getInstance().genJsonString(jsonStr);
            JSONObject jsonObject = new JSONObject(jsonStr);
            onSuccess(jsonObject);
            //不需要截获
            /*if (jsonObject.getString("code").equals("2")){
                ToastUtils.showShort(jsonObject.getString("msg"));
                ActivityUtils.finishAllActivities();
                mActivity.startActivity(new Intent(mActivity, LoginActivity.class));
            }else {
                onSuccess(jsonObject);
            }*/
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }


    @Override
    public void onComplete() {
        /*if (progress != null && progress.isShowing()){
            progress.dismiss();
        }*/
        Log.d("BaseSubscriber","http is Complete");
    }

    public abstract void onError(ExceptionHandle.ResponeThrowable e);

    public abstract void onSuccess(JSONObject jsonObject) throws JSONException;
}
