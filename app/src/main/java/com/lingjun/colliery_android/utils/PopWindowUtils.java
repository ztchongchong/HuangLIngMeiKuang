package com.lingjun.colliery_android.utils;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.lingjun.colliery_android.R;


/**
 * Created by nefa on 2018/7/26.
 */

public class PopWindowUtils {

    private Activity mActivity;
    private PopupWindow mPopup;

    public PopupWindow showCustomPop(Activity mActivity,int layoutID){
        View rootView = LayoutInflater.from(mActivity).inflate(layoutID, null);
        mPopup = new PopupWindow(rootView, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        mPopup.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        mPopup.setOutsideTouchable(true);
        mPopup.setAnimationStyle(R.style.MyPopupWindow_anim_style);
        mPopup.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                setBackgroudAlpha(1.0f);
            }
        });
        TextView tvCancel = rootView.findViewById(R.id.tv_cancel);
        mPopup.showAtLocation(tvCancel, Gravity.BOTTOM, 0, 0);
        setBackgroudAlpha(0.4f);
        return mPopup;
    }

    /**
     * 半透明背景
     * @param alpha
     */
    private void setBackgroudAlpha(float alpha) {
        Window window = mActivity.getWindow();
        WindowManager.LayoutParams lp = window.getAttributes();
        lp.alpha = alpha;
        window.addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
        window.setAttributes(lp);
    }

}
