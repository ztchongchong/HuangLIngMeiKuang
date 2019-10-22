/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.lingjun.colliery_android.utils.code;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


/**
 * <b>MD5加密</b>
 */
public class MD5Encode {
    

    public static final String encode(String s) {
//        char HexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
        char HexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };
        String strEncode = "";
        try {
            byte[] strTemp=s.getBytes("UTF-8");
            MessageDigest mdTemp = MessageDigest.getInstance("MD5");
            mdTemp.update(strTemp);
            byte[] md = mdTemp.digest();
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte strTemp2 = md[i];
                str[k++] = HexDigits[strTemp2 >>> 4 & 0xf];
                str[k++] = HexDigits[strTemp2 & 0xf];
            }
            strEncode = new String(str);
        } catch (NoSuchAlgorithmException e) {
            return strEncode;
        } catch (UnsupportedEncodingException e) {
            return strEncode;
        }
        return strEncode;
    }
    /**
     * <b>比较俩MD5值是否相等</b>
     * 
     * @param ps
     *            需要加密的字符串
     * @param md5ps
     *            md5码
     * @return true 相等/false 不相等
     */
    public static boolean eq(String ps, String md5ps) {
        boolean is = false;
        if ("".equals(ps) && "".equals(md5ps)) {
            return is;
        }
        String mps = MD5Encode.encode(ps);
        is = mps.equalsIgnoreCase(md5ps);
        return is;
    }
}
