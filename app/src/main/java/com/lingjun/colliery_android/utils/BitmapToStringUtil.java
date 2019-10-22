package com.lingjun.colliery_android.utils;


import android.graphics.Bitmap;
import android.util.Base64;

import java.io.ByteArrayOutputStream;

/**
 * 图片转成字符串的工具类
 * Created by yj001 on 2016/1/5.
 */
public class BitmapToStringUtil {

    private static BitmapToStringUtil ourInstance = null;

    public static BitmapToStringUtil getInstance() {
        if (null == ourInstance) {
            ourInstance = new BitmapToStringUtil();
        }
        return ourInstance;
    }

    private BitmapToStringUtil() {

    }

    /**
     * 图片转成字符串
     * @param bitmap    图片实体类
     * @return  图片转成的字符串
     */
    public String bitmapToString(Bitmap bitmap) {
        /**
         * byte数组流的初始化
         */
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        //将图片百分百压缩给byte数组
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
         //将流转成64位byte数组
        byte[] b = byteArrayOutputStream.toByteArray();
        //将byte数字采用Base64系统默认编码  编码成字符串
        return Base64.encodeToString(b, Base64.DEFAULT);
    }

}
