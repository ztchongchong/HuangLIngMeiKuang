package com.lingjun.colliery_android.utils.code;

import com.blankj.utilcode.util.LogUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Set;

/**
 * @since 1.0
 * <p/>
 * SnowJun  2016/9/8
 */
public class JsonUtil {


    /**
     * @param api    访问的api
     * @param method 访问的method
     * @param paras  访问提交的参数
     * @return 返回最终生成的post字符串
     * @since 1.0
     * 生成post字符串的方法
     */
    public static String genPostString(String api, String method, HashMap<String, String> paras) {
        JSONObject object = new JSONObject();
        try {
            object.put("api", api);
            object.put("m", method);
            JSONObject object1 = new JSONObject();
            if (null != paras) {
                Set<String> strings = paras.keySet();
                for (String str : strings) {
                    object1.put(str, paras.get(str));
                }
                JSONArray array = new JSONArray();
                array.put(object1);
                LogUtils.e("访问方法m:" + method+"\n"+"提交参数：" + object1.toString());
                object.put("p", MyEncrypt.EncryptData(array.toString(), CodeConfig.DES_KEY1, CodeConfig.DES_KEY2));
//                JSONObject object2 = new JSONObject();
//                object2.put("api", api);
//                object2.put("m", method);
//                object2.put("p", array.toString());
//                Logger.e("不加密串："+object2.toString() );
            }

        } catch (JSONException e) {
            return null;
        }

        return object.toString();
    }


    /**
     * @param json 返回的json字符串
     * @return 返回结果是否正常
     * true   返回正常结果
     * false  返回出现异常
     * @since 1.0
     * 检测是否是正常返回
     */
    public static boolean isActiveReturn(String json) {
        try {
            JSONObject object = new JSONObject(json);
            int code = object.getInt("result_code");
            return code == 100;
        } catch (JSONException e) {
            LogUtils.e("e:" + e);
        }
        return false;
    }





}
