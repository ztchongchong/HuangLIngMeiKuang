package com.lingjun.colliery_android.module.dealwith.activity;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.lingjun.colliery_android.R;
import com.lingjun.colliery_android.base.BaseActivity;
import com.lingjun.colliery_android.module.dealwith.adapter.AgencyCategoriesAdapter;
import com.lingjun.colliery_android.module.dealwith.fragment.DatePickerDialogFragment;
import com.lingjun.colliery_android.view.CalendarHelper;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by shurrikann on 2018/12/7.
 */

public class CheckHistoryActivity extends BaseActivity {
    @OnClick(R.id.iv_back)
    void back() {
        finish();
    }

    @BindView(R.id.mulu)
    ImageView mulu;

    @BindView(R.id.refreshLayout)
    SmartRefreshLayout refreshLayout;
    @BindView(R.id.check_history_recy)
    RecyclerView check_history_recy;
    private PopupWindow popupWindow;
    private List<String> categoryList = new ArrayList<>();
    private AgencyCategoriesAdapter adapter;
    @Override
    protected int getResourcesId() {
        return R.layout.activity_check_history;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        initData();
        initClick();
    }

    private void initClick() {
        mulu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showdepartmentpopupwindow();
            }
        });
    }

    @Override
    protected BaseRefreshLoadMoreInterface setRefreshLoadMoreListener() {
        return null;
    }

    private void showdepartmentpopupwindow() {
        View view = LayoutInflater.from(CheckHistoryActivity.this).inflate(R.layout.popupwindows_ck_history, null);
        if (popupWindow == null) {
            popupWindow = new PopupWindow(view, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT);
            //popupWindow在弹窗的时候背景半透明
        }
        popupWindow.setBackgroundDrawable(getResources().getDrawable(android.R.color.transparent));
        popupWindow.setAnimationStyle(R.style.AnimationFade);
        popupWindow.setOutsideTouchable(true);
        popupWindow.setFocusable(true);
        View parent = LayoutInflater.from(this).inflate(R.layout.activity_divide_work, null);
        popupWindow.showAtLocation(parent, Gravity.RIGHT, 0, 0);
        final WindowManager.LayoutParams params = getWindow().getAttributes();
        params.alpha = 0.8f;
        getWindow().setAttributes(params);
        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                params.alpha = 1.0f;
                forceHideIM();
                getWindow().setAttributes(params);
                popupWindow = null;
            }
        });
        RecyclerView recyAgencyCategories = view.findViewById(R.id.recy_agency_cateory);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(CheckHistoryActivity.this, 3) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
        adapter = new AgencyCategoriesAdapter(R.layout.recy_item_agency_categories);
//        adapter.setNewData(categoryList);
        recyAgencyCategories.setLayoutManager(gridLayoutManager);
        recyAgencyCategories.setAdapter(adapter);
        TextView btnStartTime = view.findViewById(R.id.tv_start_time);
        TextView btnEndTime = view.findViewById(R.id.tv_end_time);
        final TextView tvStart = view.findViewById(R.id.tv_start);
        final TextView tvEnd = view.findViewById(R.id.tv_end);
        final TextView tvAnd = view.findViewById(R.id.tv_and);
//        RelativeLayout mulu = view.findViewById(R.id.mulu);
//        mulu.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                popupWindow.dismiss();
//                popupWindow = null;
////                showdepartmentpopupwindows();
//            }
//        });
        btnStartTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialogFragment datePickerDialogFragment = DatePickerDialogFragment.newInstance();
                datePickerDialogFragment.show(getSupportFragmentManager(), "DatePicker");
                datePickerDialogFragment.setOnDateTapedListener(new CalendarHelper.OnDateTapedListener() {
                    @Override
                    public void onDateTaped(String date) {
                        if (!TextUtils.isEmpty(date)) {
                            tvStart.setVisibility(View.VISIBLE);
                            tvAnd.setVisibility(View.VISIBLE);
                            tvStart.setText(date);
                        } else {
                            tvStart.setVisibility(View.VISIBLE);
                            tvAnd.setVisibility(View.VISIBLE);
                        }
                    }
                });
            }
        });

        btnEndTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialogFragment datePickerDialogFragment = DatePickerDialogFragment.newInstance();
                datePickerDialogFragment.show(getSupportFragmentManager(), "DatePicker");
                datePickerDialogFragment.setOnDateTapedListener(new CalendarHelper.OnDateTapedListener() {
                    @Override
                    public void onDateTaped(String date) {
                        if (!TextUtils.isEmpty(date)) {
                            tvEnd.setVisibility(View.VISIBLE);
                            tvEnd.setText(date);
                        } else {
                            tvEnd.setVisibility(View.VISIBLE);
                        }
                    }
                });
            }
        });
    }

    private void initData() {
        categoryList.add("审核历史");
        categoryList.add("接受历史");
        categoryList.add("接受历史");
        categoryList.add("检查历史");

    }
}
