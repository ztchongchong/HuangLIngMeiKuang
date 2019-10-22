package com.lingjun.colliery_android.utils.code;


import android.util.Base64;


import com.lingjun.colliery_android.utils.code.base64.BASE64Decoder;
import com.lingjun.colliery_android.utils.code.base64.BASE64Encoder;

import java.util.Date;
import java.util.Random;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;


public class MyEncrypt {


    public String Key1;
    public String Key2;

    public String EncryptData(String Data) throws Exception {
        byte[] keyBytes = new BASE64Decoder().decodeBuffer(Key1);//ASCIIEncoding.ASCII.GetBytes(key);
        byte[] keyIV = new BASE64Decoder().decodeBuffer(Key2); //将12位密钥转为8位
        IvParameterSpec zeroIv = new IvParameterSpec(keyIV);
        SecretKeySpec key = new SecretKeySpec(keyBytes, "DES");
        Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, key, zeroIv);
        byte[] encryptedData = cipher.doFinal(Data.getBytes());
        String encode = new BASE64Encoder().encode(encryptedData);
        return encode;
    }

    public String EncryptData1(String Data) throws Exception {
            Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
            DESKeySpec desKeySpec = new DESKeySpec(Key1.getBytes("UTF-8"));
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            SecretKey secretKey = keyFactory.generateSecret(desKeySpec);
            IvParameterSpec iv = new IvParameterSpec(Key2.getBytes("UTF-8"));
            cipher.init(Cipher.ENCRYPT_MODE, secretKey, iv);
            byte[] encryptbyte = cipher.doFinal(Data.getBytes());
            return new String(Base64.encode(encryptbyte, Base64.DEFAULT));
    }



    public static String EncryptData(String Data, String Key1, String Key2) {
        String result = "";
        MyEncrypt encrypt = new MyEncrypt();
        encrypt.Key1 = Key1;
        encrypt.Key2 = Key2;
        try {
//            String data = URLEncoder.encode(Data, "UTF-8");
            String md5 = getMd5Hash(Data + CodeConfig.MDE_KEY);
            result = encrypt.EncryptData1(Data + md5.toLowerCase() + getMd5Hash(getMac() + new Date().getTime() + "").toLowerCase());
//            result = encrypt.EncryptData1(Data);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        result = result.trim();
        String str1 = result.substring(result.length() - 1);
        String str2 = result.substring(0, result.length() - 1);
        return str2 + "ab" + str1;
    }

    static String getMd5Hash(String input) {
        return new MD5Encode().encode(input);
    }

    private static String getMac() {
        Random random = new Random();
        return new Date().getTime() + "" + random.nextInt();
    }

}



