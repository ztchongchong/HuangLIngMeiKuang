package com.lingjun.colliery_android.utils;

import android.text.TextUtils;

import com.blankj.utilcode.util.LogUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * @since 1.0
 * <p/>
 * SnowJun  2016/9/8
 */
public class DateUtil {
    private static DateUtil ourInstance = new DateUtil();

    public static DateUtil getInstance() {
        return ourInstance;
    }

    private DateUtil() {
    }


    /**
     * 是否在当前时间之后
     * @param time 数据库日期时间戳 如：/Date(1489852800000)/
     * @return
     */
    public boolean isAboveNowTime(String time){
        if (TextUtils.isEmpty(time)){
            return true;//默认在当前时间之前
        }
        String longTime = time.replace("/Date(", "").replace(")/", "");
        long longTime1 = Long.parseLong(longTime);
        return longTime1 < System.currentTimeMillis();
    }

    /**
     * 获取当天的日期
     *
     * @return 当天日期字符串
     */
    public String getNowDateStart() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        //返回当天的日期
        return format.format(System.currentTimeMillis()) + " 00:00:00";
    }

    public static String getData(long date) {
        String datastr;
        datastr = new SimpleDateFormat("yyyy年MM月dd日").format(new Date(date));
        if (datastr == null) {
            return null;
        }
        return datastr;
    }

    public static String getTime(long time) {
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
        formatter.setTimeZone(TimeZone.getTimeZone("GMT+00:00"));
        String hms = formatter.format(time);
        return hms;
    }

    /**
     * 获取当天的日期
     *
     * @return 当天日期字符串
     */
    public String getDateEnd() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        //返回当天的日期
        return format.format(System.currentTimeMillis()) + " 23:59:59";
    }


    /**
     * 获取两天前的日期
     *
     * @return 两天前的日期字符串
     */
    public String getTwoDayAgoDateStart() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        //两天的毫秒数
        long timeMillons = 2 * 24 * 60 * 60 * 1000;
        //返回两天前的日期
        return format.format(System.currentTimeMillis() - timeMillons) + " 00:00:00";
    }

    /**
     * 格式化日期
     *
     * @param dateStr 数据库日期时间戳 如：/Date(1489852800000)/
     * @return 格式化后的日期
     */
    public String genDataTimSecond(String dateStr) {
        if (TextUtils.isEmpty(dateStr)) {
            return "0000-00-00";
        }
        String longTime = dateStr.replace("/Date(", "").replace(")/", "");
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format.format(Long.parseLong(longTime));
    }

    /**
     * 格式化日期
     *
     * @param dateStr 数据库日期时间戳 如：/Date(1489852800000)/
     * @return 格式化后的日期
     */
    public String genDataTime(String dateStr) {
        if (TextUtils.isEmpty(dateStr)) {
            return "0000-00-00";
        }
        String longTime = dateStr.replace("/Date(", "").replace(")/", "");
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(Long.parseLong(longTime));
    }



    /**
     * 格式化日期
     *
     * @param dateStr 数据库日期时间戳 如：/Date(1489852800000)/
     * @return 格式化后的日期
     */
    public String genDataTimeWithHour(String dateStr) {
        if (TextUtils.isEmpty(dateStr)) {
            return "0000-00-00 00:00";
        }
        String longTime = dateStr.replace("/Date(", "").replace(")/", "");
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        return format.format(Long.parseLong(longTime));
    }

    /**
     * 描述：获取milliseconds表示的日期时间的字符串.
     *
     * @param milliseconds the milliseconds
     * @param format       格式化字符串，如："yyyy-MM-dd HH:mm:ss"
     * @return String 日期时间字符串
     */
    public static String getStringByFormat(long milliseconds, String format) {
        String thisDateTime = "";
        try {
            SimpleDateFormat mSimpleDateFormat = new SimpleDateFormat(format);
            thisDateTime = mSimpleDateFormat.format(milliseconds);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return thisDateTime;
    }

    public String genData(String dateStr, String format) {
        if (TextUtils.isEmpty(dateStr)) {
            return "0000-00-00 00:00";
        }
        String longTime = dateStr.replace("/Date(", "").replace(")/", "");
        SimpleDateFormat format1 = new SimpleDateFormat(format);
        return format1.format(Long.parseLong(longTime));
    }


    /**
     * 获取当天的日期
     *
     * @return 当天日期字符串
     */
    public String getDateYear() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy");
        //返回当天的日期
        return format.format(System.currentTimeMillis());
    }


    public long praserTime(String dateFormat, String time) {
        SimpleDateFormat format = new SimpleDateFormat(dateFormat);
        //返回当天的日期
        try {
            return format.parse(time).getTime();
        } catch (ParseException e) {
//            format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//            try {
//                return format.parse(time).getTime();
//            } catch (ParseException e1) {
//                e1.printStackTrace();
//                Logger.e("解析异常："+time);
//            }
//            e.printStackTrace();
            LogUtils.e("解析异常："+time);
        }
        //解析异常 返回0
        return 0;
    }

}
