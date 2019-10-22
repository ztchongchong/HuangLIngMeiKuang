package com.lingjun.colliery_android.utils;

import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * @since 1.0
 * <p/>
 * SnowJun  2016/11/21
 */
public class DecimalFormatUtil {


    private static DecimalFormatUtil ourInstance = new DecimalFormatUtil();

    public static DecimalFormatUtil getInstance() {
        return ourInstance;
    }

    private DecimalFormatUtil() {
    }

    /**
     * 格式化浮点型数据的方法
     * @param format    规则  例如"0.00"表示保留两位小数
     * @param info      格式化的浮点型数据
     * @return          返回格式化后的字符串
     */
    public String format(String format, Double info){
        DecimalFormat format1 = new DecimalFormat(format);
        format1.setRoundingMode(RoundingMode.DOWN);//舍去法
        return format1.format(info);
    }


    /**
     *
     * @param format
     * @param info
     * @return
     */
    public String formatHalf(String format, Double info){
        DecimalFormat format1 = new DecimalFormat(format);
        format1.setRoundingMode(RoundingMode.HALF_UP);//四舍五入
        return format1.format(info);
    }



}
