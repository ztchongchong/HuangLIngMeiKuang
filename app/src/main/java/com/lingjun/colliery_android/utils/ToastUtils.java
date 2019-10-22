package com.lingjun.colliery_android.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.Gravity;
import android.widget.Toast;

/**
 * @author ningyibo.
 * @fileName ToastUtils.
 * @package com.sunthink.healthrecords.utils.
 * @projectName YCResidentHealthFiles.
 * @date on 2017/11/15 17:21.
 */

public class ToastUtils {
    private static Toast toast;
    @SuppressLint("ShowToast")
    public  static  void showToast (Context context, String str) {
        if (toast == null) {
            toast = Toast.makeText(context,str, Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER,0,0);
        }
        toast.setText(str);
        toast.show();
    }

    @SuppressLint("ShowToast")
    public  static  void showLongToast (Context context, String str) {
        if (toast == null) {
            toast = Toast.makeText(context,str, Toast.LENGTH_LONG);
            toast.setGravity(Gravity.CENTER,0,0);
        }
        toast.setText(str);
        toast.show();
    }
}
