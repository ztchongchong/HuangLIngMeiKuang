package com.lingjun.colliery_android.module.dealwith.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.CalendarView;


import com.lingjun.colliery_android.R;
import com.lingjun.colliery_android.view.CalendarHelper;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import static android.view.Gravity.BOTTOM;


public class DatePickerDialogFragment extends DialogFragment {
    private Window window;
    private CalendarHelper.OnDateTapedListener onDateTapedListener;

    private CalendarView calendar;

    public static DatePickerDialogFragment newInstance() {
        Bundle args = new Bundle();
        DatePickerDialogFragment fragment = new DatePickerDialogFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NO_TITLE, R.style.DialogFragmentAnimStyle);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.popup_calendar, null);
        window = getDialog().getWindow();
        window.setWindowAnimations(R.style.DialogFragmentAnimStyle);
        initLayout();
        initView(rootView);
        return rootView;
    }

    private void initView(View rootView) {

        final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());

        calendar = rootView.findViewById(R.id.calendar);
        calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                Log.d("year", year + "");
//                String dayStr = sdf.format(new Date(year, month, dayOfMonth));
                String dayStr = year + "-" + (month + 1) + "-" + dayOfMonth;
                if (onDateTapedListener != null) {
                    onDateTapedListener.onDateTaped(dayStr);
                    dismiss();
                }
            }
        });

        rootView.findViewById(R.id.ll_content).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
    }

    /**
     * 初始化布局
     */
    private void initLayout() {
        int screenWidth = getResources().getDisplayMetrics().widthPixels;
        int screenHeight = getResources().getDisplayMetrics().heightPixels;


        WindowManager.LayoutParams lp = null;
        if (window != null) {
            lp = window.getAttributes();
            lp.height = screenHeight / 5 * 3;
            lp.gravity = BOTTOM;
            window.setAttributes(lp);
        }
    }


    public static interface OnDateTapedListener {
        void onDateTaped(String date);
    }

    public void setOnDateTapedListener(CalendarHelper.OnDateTapedListener listener) {
        if (listener == null) {
            return;
        }

        onDateTapedListener = listener;
    }
}
