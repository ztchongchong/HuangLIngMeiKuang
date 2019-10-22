package com.lingjun.colliery_android.myjpush;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;


import com.lingjun.colliery_android.module.main.MainActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;

import cn.jpush.android.api.JPushInterface;

/**
 * 自定义接收器
 * <p>
 * 如果不定义这个 Receiver，则：
 * 1) 默认用户会打开主界面
 * 2) 接收不到自定义消息
 */
@SuppressWarnings("ALL")
public class MyReceiver extends BroadcastReceiver {
    private static final String TAG = "JIGUANG-Example";
    private String mExtraJson;
    private JSONObject json;
    private Intent i;
    private String title;

    public static final String NOTIFY_MSG_COUNT = "notify_msg_count";
    private static HashMap<String, JSONObject> jpushmap = new HashMap<>();

    @Override
    public void onReceive(Context context, Intent intent) {
        try {
            Bundle bundle = intent.getExtras();
            // 接收到的消息
            String receivedMessage = printBundle(bundle);
            Log.d(TAG, "[MyReceiver] onReceive - " + intent.getAction() + ", extras: " + receivedMessage);

            if (JPushInterface.ACTION_REGISTRATION_ID.equals(intent.getAction())) {
                String regId = bundle.getString(JPushInterface.EXTRA_REGISTRATION_ID);
                Log.d(TAG, "[MyReceiver] 接收Registration Id : " + regId);
                //send the Registration Id to your server...

            } else if (JPushInterface.ACTION_MESSAGE_RECEIVED.equals(intent.getAction())) {
                Log.d(TAG, "[MyReceiver] 接收到推送下来的自定义消息: " + tranforBundleToString(bundle));
                Log.e("msg", bundle.getString(JPushInterface.EXTRA_EXTRA));
                Log.d("收到msgid", bundle.getString(JPushInterface.EXTRA_MSG_ID));
                // 拿到的extra json 数据
                if (bundle.getString(JPushInterface.EXTRA_EXTRA) != null) {
                    Log.d(TAG, "接收到推送下来`的通知 = " + tranforBundleToString(bundle));
                }
                json = new JSONObject(bundle.getString(JPushInterface.EXTRA_EXTRA));
                jpushmap.put(bundle.getString(JPushInterface.EXTRA_MSG_ID), json);
                Log.d("jpushmap", jpushmap.size() + "");
                // 保存通知消息数量
//                String msgCountStr = aCache.getAsString(NOTIFY_MSG_COUNT);
////                String msgCountStr = "0";
//                if (!TextUtils.isEmpty(msgCountStr)) {
//                    Integer msgCount = Integer.valueOf(msgCountStr.trim());
//                    if (msgCount < 0) {
//                        msgCount = 0;
//                    }
//                    msgCount += 1;
//                    ShortcutBadger.applyCount(context, msgCount);
//                    Log.e(TAG, "<><><> msgCount = " + msgCountStr);
//                    aCache.put(NOTIFY_MSG_COUNT, String.valueOf(msgCount));
//                } else {
//                    aCache.put(NOTIFY_MSG_COUNT, String.valueOf(1));
//                }

            } else if (JPushInterface.ACTION_NOTIFICATION_RECEIVED.equals(intent.getAction())) {
                Log.d(TAG, "[MyReceiver] 接收到推送下来的通知" + tranforBundleToString(bundle));
                String regId = bundle.getString(JPushInterface.EXTRA_REGISTRATION_ID);
                Log.d(TAG, "[MyReceiver] 接收Registration Id : " + regId);
            } else if (JPushInterface.ACTION_NOTIFICATION_OPENED.equals(intent.getAction())) {
                Log.d(TAG, "[MyReceiver] 用户点击打开了通知");
                Log.e("str", printBundle(bundle));
                Log.e("点击msgid", bundle.getString(JPushInterface.EXTRA_MSG_ID));
                // 移除通知消息数量
                Log.d("jpushmap2", jpushmap.size() + "");

                //打开自定义的Activity
                Intent i = new Intent(context, MainActivity.class);
                i.putExtra("jgid", bundle.getString(JPushInterface.EXTRA_EXTRA));
                Log.e("push_jgid", bundle.getString(JPushInterface.EXTRA_EXTRA));
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                context.startActivity(i);


//                String msgCountStr = aCache.getAsString(NOTIFY_MSG_COUNT);
//                if (!TextUtils.isEmpty(msgCountStr)) {
//                    Integer msgCount = Integer.valueOf(msgCountStr.trim());
//                    if (msgCount > 0) {
//                        msgCount -= 1;
//                    } else {
//                        msgCount = 0;
//                    }
//                    aCache.put(NOTIFY_MSG_COUNT, String.valueOf(msgCount));
//                } else {
//                    aCache.put(NOTIFY_MSG_COUNT, String.valueOf(0));
//                }
//                JSONObject json = new JSONObject(str);
//                JSONObject pushjson = jpushmap.get(bundle.getString(JPushInterface.EXTRA_MSG_ID));
//                String msgtype = pushjson.get("msg_type").toString();
//                title = bundle.getString(JPushInterface.EXTRA_NOTIFICATION_TITLE);
//                Log.e("jpush_json---->", "<><><> title = " + title + " msgType = " + msgtype + "-info-" + pushjson.toString());
//                int approveType = 0;
//                if (title.contains("水")) {
//                    approveType = 0;
//                } else if (title.contains("电")) {
//                    approveType = 1;
//                } else if (title.contains("房租")) {
//                    approveType = 2;
//                } else if (title.contains("物业")) {
//                    approveType = 3;
//                } else if (title.contains("后勤")) {
//                    approveType = 4;
//                } else if (title.contains("校办")) {
//                    approveType = 5;
//                } else if (title.contains("月报")) {
//                    approveType = 6;
//                } else if (title.contains("部门")) {
//                    approveType = 7;
//                }
//                if (msgtype.equals("1")) {
//                    if (title.contains("驳回")) {
//                        i = new Intent(context, ReimburseDetailsActivity.class);
//                        i.putExtra(ReimburseDetailsActivity.CATEGORY_TYPE, approveType);
//                        i.putExtra(ReimburseDetailsActivity.DATA_ITEM_BEAN, "");
//                        i.putExtra("id", pushjson.get("mgs_id").toString());
//                        i.putExtra("tag", "notification");
//                        context.startActivity(i);
//                    } else {
//                        Log.e("审批", msgtype);
//                        i = new Intent(context, ApprovalDetailsActivity.class);
//                        i.putExtra("approveType", approveType);
//                        i.putExtra("type", 10);
//                        i.putExtra("id", pushjson.get("mgs_id").toString());
//                        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
//                        context.startActivity(i);
//                    }
//                } else if (msgtype.equals("2")) {
//                    Log.e("请假", msgtype);
//                    if (pushjson.get("msg_action").toString().equals("exe")) {
//                        i = new Intent(context, ExamineVacationActivity.class);
//                    } else {
//                        i = new Intent(context, NotifyMyVacationActivity.class);
//                    }
//                    i.putExtra("type", "2");
//                    i.putExtra("id", pushjson.get("mgs_id").toString());
//                    i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                    context.startActivity(i);
//                } else if (msgtype.equals("4")) {//转班
//                    i = new Intent(context, ZBSPInfoActivity.class);
//                    i.putExtra("type", msgtype);
//                    i.putExtra("id", pushjson.get("mgs_id").toString());
//                    i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                    context.startActivity(i);
//                } else if (msgtype.equals("5")) {//退费
//                    i = new Intent(context, TFSPInfoActivity.class);
//                    i.putExtra("type", msgtype);
//                    i.putExtra("id", pushjson.get("mgs_id").toString());
//                    i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                    context.startActivity(i);
//                } else if (msgtype.equals("6")) {//转费
//                    i = new Intent(context, ZFSPInfoActivity.class);
//                    i.putExtra("type", msgtype);
//                    i.putExtra("id", pushjson.get("mgs_id").toString());
//                    i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                    context.startActivity(i);
//                } else if (msgtype.equals("7")) {//特殊优惠
//                    i = new Intent(context, YHSPInfoActivity.class);
//                    i.putExtra("type", msgtype);
//                    i.putExtra("id", pushjson.get("mgs_id").toString());
//                    i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                    context.startActivity(i);
//                } else if (msgtype.equals("8")) {//招聘推送
//                    i = new Intent(context, QiuZhiActivity.class);
//                    i.putExtra("msgtype", msgtype);
//                    i.putExtra("msgid", pushjson.get("mgs_id").toString());
//                    i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                    context.startActivity(i);
//                }else if(msgtype.equals("9")){
//                    i = new Intent(context, RzFileInfoActivity.class);
//                    i.putExtra("type", 3);
//                    i.putExtra("msgid", pushjson.get("mgs_id").toString());
//                    i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                    context.startActivity(i);
//                }else if(msgtype.equals("10")){
//                    i = new Intent(context, ZzFileInfoActivity.class);
//                    i.putExtra("type", 3);
//                    i.putExtra("msgid", pushjson.get("mgs_id").toString());
//                    i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                    context.startActivity(i);
//                }else if(msgtype.equals("11")){
//                    i = new Intent(context, ZgFileInfoActivity.class);
//                    i.putExtra("type", 3);
//                    i.putExtra("msgid", pushjson.get("mgs_id").toString());
//                    i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                    context.startActivity(i);
//                }else if(msgtype.equals("12")){
//                    i = new Intent(context, LzFileInfoActivity.class);
//                    i.putExtra("type", 3);
//                    i.putExtra("msgid", pushjson.get("mgs_id").toString());
//                    i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                    context.startActivity(i);
//                }
            } else if (JPushInterface.ACTION_RICHPUSH_CALLBACK.equals(intent.getAction())) {
                Log.d(TAG, "[MyReceiver] 用户收到到RICH PUSH CALLBACK: " + bundle.getString(JPushInterface.EXTRA_EXTRA));
                //在这里根据 JPushInterface.EXTRA_EXTRA 的内容处理代码，比如打开新的Activity， 打开一个网页等..
            } else if (JPushInterface.ACTION_CONNECTION_CHANGE.equals(intent.getAction())) {
                boolean connected = intent.getBooleanExtra(JPushInterface.EXTRA_CONNECTION_CHANGE, false);
                Log.w(TAG, "[MyReceiver]" + intent.getAction() + " connected state change to " + connected);
            } else {
                Log.d(TAG, "[MyReceiver] Unhandled intent - " + intent.getAction());
            }
        } catch (Exception e) {
            Log.e("error", e.toString());
        }
    }

    /**
     * 打印所有的 intent extra 数据
     */
    private static String printBundle(Bundle bundle) {
        StringBuilder sb = new StringBuilder();
        for (String key : bundle.keySet()) {
            if (key.equals(JPushInterface.EXTRA_NOTIFICATION_ID)) {
                sb.append("\nkey:" + key + ", value:" + bundle.getInt(key));
            } else if (key.equals(JPushInterface.EXTRA_CONNECTION_CHANGE)) {
                sb.append("\nkey:" + key + ", value:" + bundle.getBoolean(key));
            } else if (key.equals(JPushInterface.EXTRA_EXTRA)) {
                if (TextUtils.isEmpty(bundle.getString(JPushInterface.EXTRA_EXTRA))) {
                    Log.i(TAG, "This message has no Extra data");
                    continue;
                }
                try {
                    JSONObject json = new JSONObject(bundle.getString(JPushInterface.EXTRA_EXTRA));
                    Iterator<String> it = json.keys();
                    while (it.hasNext()) {
                        String myKey = it.next();
                        sb.append("\nkey:" + key + ", value: [" +
                                myKey + " - " + json.optString(myKey) + "]");
                    }
                } catch (JSONException e) {
                    Log.e(TAG, "Get message extra JSON error!");
                }
            } else {
                sb.append("\nkey:" + key + ", value:" + bundle.getString(key));
            }
        }
        return sb.toString();
    }

    private static String tranforBundleToString(Bundle bundle) {
        JSONObject jsonObject = new JSONObject();
        try {
            for (String key : bundle.keySet()) {
                if (key.equals(JPushInterface.EXTRA_NOTIFICATION_ID)) {
                    jsonObject.put(key, bundle.getInt(key));
                } else if (key.equals(JPushInterface.ACTION_CONNECTION_CHANGE)) {
                    jsonObject.put(key, bundle.getBoolean(key));
                } else if (key.equals(JPushInterface.EXTRA_EXTRA)) {
                    jsonObject.put(key, new JSONObject(bundle.getString(JPushInterface.EXTRA_EXTRA)));
                } else {
                    jsonObject.put(key, bundle.getString(key));
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObject.toString();
    }
}
