package com.lingjun.colliery_android.utils.code;


import android.text.TextUtils;
import android.util.Base64;

import com.lingjun.colliery_android.utils.code.base64.BASE64Decoder;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;


/// <summary>
/// 解密
/// </summary>
public class MyDecrypt {
    private String Key1;
    private String Key2;

    // / <summary>
    // / 解密
    // / </summary>
    // / <param name="data">解密数据</param>
    // / <param name="Key1">key1</param>
    // / <param name="Key2">key2</param>
    // / <returns>解密后明文数据</returns>
    public static String DecryptData(String data, String key1, String key2) {
        //强字符串中的双引号去掉
        data = data.replace("\"","");
        if (TextUtils.isEmpty(data)){
            return "";
        }
        String str1 = data.substring(data.toString().length() - 1);
        String str2 = data.substring(0, data.toString().length() - 3);
        MyDecrypt decrypt = new MyDecrypt();
        decrypt.Key1 = key1;
        decrypt.Key2 = key2;
        String ret = "";
        try {
            ret = decrypt.DecryptData1(str2 + str1);
            String md5= ret.substring(ret.length() - 64,ret.length() - 32);
            ret = ret.substring(0, ret.length() - 32);
            ret = ret.substring(0, ret.length() - 32);
            if (null != md5 && md5.equals(MD5Encode.encode(ret + CodeConfig.MDE_KEY).toLowerCase())){
                return ret;
            }else {
                return "md5签名不一致";
            }
        } catch (Exception ex) {
            return "解密异常" + ex;
        }
    }

    private String DecryptData1(String data) {
        byte[] retByte = null;
        try {
            byte[] bytesrc = Base64.decode(data.getBytes(), Base64.DEFAULT);
            Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
            DESKeySpec desKeySpec = new DESKeySpec(Key1.getBytes("UTF-8"));
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            SecretKey secretKey = keyFactory.generateSecret(desKeySpec);
            IvParameterSpec iv = new IvParameterSpec(Key2.getBytes("UTF-8"));
            cipher.init(Cipher.DECRYPT_MODE, secretKey, iv);
           retByte = cipher.doFinal(bytesrc);
        }catch (Exception e){
        }
         return new String(retByte);
    }


    private String DecryptData(String data) {
        String decryptData = "";
        try {
            byte[] keyBytes;
            keyBytes = new BASE64Decoder().decodeBuffer(Key1);
            byte[] keyIV = new BASE64Decoder().decodeBuffer(Key2); // 将12位密钥转为8位
//			byte[] byteMi = new BASE64Decoder().decodeBuffer(data);
            byte[] byteMi = Base64.decode(data, Base64.DEFAULT);
            IvParameterSpec zeroIv = new IvParameterSpec(keyIV);
            SecretKeySpec key = new SecretKeySpec(keyBytes, "DES");
            Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, key, zeroIv);
            byte[] decryptedData = cipher.doFinal(byteMi);
            decryptData = new String(decryptedData, "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return decryptData;
    }
}
