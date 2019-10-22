package com.lingjun.colliery_android.view;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.CalendarView;
import android.widget.PopupWindow;


import com.lingjun.colliery_android.R;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class CalendarHelper {

    private OnDateTapedListener onDateTapedListener;

    private CalendarView calendar;

    private PopupWindow initPopup(final Activity activity) {
        View rootView = LayoutInflater.from(activity).inflate(R.layout.popup_calendar, null);

        PopupWindow popupWindow = new PopupWindow(rootView, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        popupWindow.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        popupWindow.setOutsideTouchable(false);
        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                setBackgroudAlpha(activity, 1.0f);
            }
        });

        final SimpleDateFormat sdf = new SimpleDateFormat("YY.dd.MM", Locale.getDefault());

        calendar = rootView.findViewById(R.id.calendar);
        calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                String dayStr = sdf.format(new Date(year, month, dayOfMonth));
                if (onDateTapedListener != null) {
                    onDateTapedListener.onDateTaped(dayStr);
                }
            }
        });
        return popupWindow;
    }

    public void show(Activity activity) {
        initPopup(activity).showAtLocation(calendar, Gravity.BOTTOM, 0, 0);
        setBackgroudAlpha(activity, 0.6f);
    }


    /**
     * 半透明背景
     *
     * @param alpha
     */
    private void setBackgroudAlpha(Activity activity, float alpha) {
        Window window = activity.getWindow();
        WindowManager.LayoutParams lp = window.getAttributes();
        lp.alpha = alpha;
        window.addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
        window.setAttributes(lp);
    }

    public static interface OnDateTapedListener {
        void onDateTaped(String date);
    }

    public void setOnDateTapedListener(OnDateTapedListener listener) {
        if (listener == null) {
            return;
        }

        onDateTapedListener = listener;
    }

}
