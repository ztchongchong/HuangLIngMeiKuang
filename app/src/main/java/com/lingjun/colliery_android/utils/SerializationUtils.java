package com.lingjun.colliery_android.utils;

import android.text.TextUtils;

import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.ToastUtils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Created by nefa on 2018/8/2.
 */

public class SerializationUtils {

    public static final String QQLogin = "qqlogin";
    public static final String WXLogin = "wxlogin";

    public static <T> T GetSerialize(String spKey,String dataKey,Class<T> clazz){
        if (TextUtils.isEmpty(SPUtils.getInstance(spKey).getString(dataKey).trim())){
            LogUtils.e("无数据");
            return null;
        }else {
            T t = null;
            try {
                t = clazz.newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }
            t = SerializationUtils.deSerialization(SPUtils.getInstance(spKey).getString(dataKey), clazz);
            return t;
        }
    }

    public static void SaveSerialize(String spKey,String dataKey,Object object){
        if (null != object){
            SPUtils.getInstance(spKey).put(dataKey, SerializationUtils.enSerialize(object));
        }else {
            ToastUtils.showShort("序列化对象为空");
        }
    }

    public static void ClearSerialize(String spKey,String dataKey){
        SPUtils.getInstance(spKey).put(dataKey,"");
    }


    /**
     * 序列化对象
     */
    public static String enSerialize(Object person) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        String serStr = null;
        try{
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(person);
            serStr = byteArrayOutputStream.toString("ISO-8859-1");
            serStr = java.net.URLEncoder.encode(serStr, "UTF-8");
            objectOutputStream.close();
            byteArrayOutputStream.close();
        }catch (Exception e){
            ToastUtils.showShort("序列化错误!");
        }
        return serStr;
    }

    /**
     * 反序列化对象
     */
    public static <T> T deSerialization(String str,Class<T> clazz){

        T person = null;
        try {
            person = clazz.newInstance();
            String redStr = java.net.URLDecoder.decode(str, "UTF-8");
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(redStr.getBytes("ISO-8859-1"));
            ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
            person = (T) objectInputStream.readObject();
            objectInputStream.close();
            byteArrayInputStream.close();
        }catch (Exception e){
            ToastUtils.showShort("反序列化错误!");
        }

        return person;
    }

}
