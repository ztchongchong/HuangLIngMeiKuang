package com.lingjun.colliery_android.utils;

import android.Manifest;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;

import com.blankj.utilcode.util.LogUtils;
import com.yanzhenjie.permission.AndPermission;
import com.yanzhenjie.permission.PermissionListener;

import java.util.List;

import static com.blankj.utilcode.util.ActivityUtils.startActivity;

/**
 * Created by nefa on 2017/12/28.
 */

public class AndPermissionUtils {

    //只获取某个权限
    public static void requestPermission(final Activity activity, final int code, String permission, @Nullable final RequestPermissionCall requestPermissionCall){
        AndPermission.with(activity)
                .requestCode(code)
                .permission(permission)
                .callback(new PermissionListener() {
                    @Override
                    public void onSucceed(int requestCode, @NonNull List<String> grantPermissions) {
                        if (requestCode == code){
                            if (AndPermission.hasPermission(activity,grantPermissions)){
                                //获取成功
                                LogUtils.e("权限获取成功");

                                if (null != requestPermissionCall){
                                    requestPermissionCall.isSucceed();
                                }
                            }else {
                                LogUtils.e("权限获取失败-1");

                                AndPermission.defaultSettingDialog(activity, code)
                                        .setTitle("权限申请失败")
                                        .setMessage("您拒绝了我们必要的一些权限,请在设置中授权！")
                                        .setPositiveButton("好，去设置")
                                        .show();
                            }
                        }
                    }

                    @Override
                    public void onFailed(int requestCode, @NonNull List<String> deniedPermissions) {
                        LogUtils.e("权限获取失败");
                        if (requestCode == code){
                            AndPermission.defaultSettingDialog(activity, code)
                                    .setTitle("权限申请失败")
                                    .setMessage("您拒绝了我们必要的一些权限,请在设置中授权！")
                                    .setPositiveButton("好，去设置")
                                    .show();
                        }
                    }
                }).start();
    }

    //只获取某个权限
    public static void requestPermissionList(final Activity activity, final int code, String[] permissionList, @Nullable final RequestPermissionCall requestPermissionCall){
        AndPermission.with(activity)
                .requestCode(code)
                .permission(permissionList)
                .callback(new PermissionListener() {
                    @Override
                    public void onSucceed(int requestCode, @NonNull List<String> grantPermissions) {
                        if (requestCode == code){
                            if (AndPermission.hasPermission(activity,grantPermissions)){
                                //获取成功
                                LogUtils.e("权限获取成功");

                                if (null != requestPermissionCall){
                                    requestPermissionCall.isSucceed();
                                }
                            }else {
                                LogUtils.e("权限获取失败-1");

                                AndPermission.defaultSettingDialog(activity, code)
                                        .setTitle("权限申请失败")
                                        .setMessage("您拒绝了我们必要的一些权限,请在设置中授权！")
                                        .setPositiveButton("好，去设置")
                                        .show();
                            }
                        }
                    }

                    @Override
                    public void onFailed(int requestCode, @NonNull List<String> deniedPermissions) {
                        LogUtils.e("权限获取失败");
                        if (requestCode == code){
                            AndPermission.defaultSettingDialog(activity, code)
                                    .setTitle("权限申请失败")
                                    .setMessage("您拒绝了我们必要的一些权限,请在设置中授权！")
                                    .setPositiveButton("好，去设置")
                                    .show();
                        }
                    }
                }).start();
    }

    //获取打电话权限并跳转
    public static void callPhone(final Activity activty, final String phone){
        AndPermission.with(activty)
                .requestCode(100)
                .permission(Manifest.permission.CALL_PHONE)
                .callback(new PermissionListener() {
                    @Override
                    public void onSucceed(int i, @NonNull List<String> list) {
                        if (i == 100) {
                            if (AndPermission.hasPermission(activty, list)) {
                                new AlertDialog.Builder(activty)
                                        .setMessage("" + phone)
                                        .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                                dialog.dismiss();
                                            }
                                        })
                                        .setPositiveButton("呼叫", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                                dialog.dismiss();
                                                Intent intent = new Intent(Intent.ACTION_DIAL);
                                                Uri data = Uri.parse("tel:" + phone);
                                                intent.setData(data);
                                                startActivity(intent);
                                            }
                                        }).show();
                            } else {
                                AndPermission.defaultSettingDialog(activty, 100)
                                        .setTitle("权限申请失败")
                                        .setMessage("您拒绝了我们必要的一些权限,请在设置中授权！")
                                        .setPositiveButton("好，去设置")
                                        .show();
                            }
                        }
                    }

                    @Override
                    public void onFailed(int i, @NonNull List<String> list) {
                        if (i == 100) {
                            AndPermission.defaultSettingDialog(activty, 100)
                                    .setTitle("权限申请失败")
                                    .setMessage("您拒绝了我们必要的一些权限,请在设置中授权！")
                                    .setPositiveButton("好，去设置")
                                    .show();
                        }
                    }
                })
                .start();
    }


    private void initPoker(int[] paker){
        //遍历牌组
        for(int i =0;i<paker.length-1;i++) {
            //内循环遍历比对,0位对比1位,1位对比2位,以此类推
            for(int j=0;j<paker.length-i-1;j++) {//-1为了防止溢出
                if(paker[j]>paker[j+1]) {
                    //若当前位大于下一位则交换位置
                    int temp = paker[j];
                    paker[j]=paker[j+1];
                    paker[j+1]=temp;
                }
            }
        }
    }

    public interface RequestPermissionCall{
        void isSucceed();
    }
}
