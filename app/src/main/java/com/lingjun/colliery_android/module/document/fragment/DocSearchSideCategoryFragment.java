package com.lingjun.colliery_android.module.document.fragment;


import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.blankj.utilcode.util.StringUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.lingjun.colliery_android.R;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * 作者: lihuan
 * 时间: 2018/12/24 9:53
 * 说明: 资料搜索过滤
 */
public class DocSearchSideCategoryFragment extends DialogFragment implements RadioGroup.OnCheckedChangeListener, CompoundButton.OnCheckedChangeListener {

    @BindView(R.id.rb_1)
    RadioButton rb1;
    @BindView(R.id.rb_2)
    RadioButton rb2;
    @BindView(R.id.rg_task_type)
    RadioGroup rgTaskType;
    @BindView(R.id.et_key)
    EditText etKey;
    @BindView(R.id.iv_del_keyword)
    ImageView ivDel;
    @BindView(R.id.tv_start_time)
    TextView tvStartTime;
    @BindView(R.id.tv_end_time)
    TextView tvEndTime;
    @BindView(R.id.cb_1)
    CheckBox cb1;
    @BindView(R.id.cb_2)
    CheckBox cb2;
    @BindView(R.id.cb_3)
    CheckBox cb3;
    @BindView(R.id.cb_4)
    CheckBox cb4;
    @BindView(R.id.btn_reset)
    Button btnReset;
    @BindView(R.id.btn_search)
    Button btnSearch;
    Unbinder unbinder;
    private OnSearchCategoryListener listener;

    private int taskType = 1; //任务类型
    private String keyWord = ""; //搜索关键字
    private String startTime = ""; //开始时间
    private String endTime = "";//结束时间
    private String tag = "";//筛选标签
    private List<String> tagList = new ArrayList<>();

    public void setOnSearchCategoryListener(OnSearchCategoryListener listener) {
        this.listener = listener;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_doc_search_side_category, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NO_TITLE, R.style.DialogFragmentAnimStyle);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tagList.clear();
        rgTaskType.setOnCheckedChangeListener(this);
        cb1.setOnCheckedChangeListener(this);
        cb2.setOnCheckedChangeListener(this);
        cb3.setOnCheckedChangeListener(this);
        cb4.setOnCheckedChangeListener(this);
        Window window = getDialog().getWindow();
        if (window != null) {
            window.setWindowAnimations(R.style.DialogFragmentAnimStyle);
            initLayout(window);

            window.getDecorView().setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    dismiss();
                    return false;
                }
            });
        }

        if (getActivity() != null) {
            getActivity().setFinishOnTouchOutside(true);
        }
    }

    private void initLayout(Window window) {
        int widthPixels = getResources().getDisplayMetrics().widthPixels;
        WindowManager.LayoutParams params = window.getAttributes();
        params.width = (int) (widthPixels * 0.85);
        params.gravity = Gravity.RIGHT;
        window.setAttributes(params);
    }

    @Override
    public void onResume() {
        super.onResume();
        Window window = getActivity().getWindow();
        WindowManager.LayoutParams params = window.getAttributes();
        params.alpha = 0.3f;
        window.setAttributes(params);
    }

    @Override
    public void onDismiss(DialogInterface dialog) {
        super.onDismiss(dialog);
        Window window = getActivity().getWindow();
        WindowManager.LayoutParams params = window.getAttributes();
        params.alpha = 1.0f;
        window.setAttributes(params);
        if (listener != null) {
            listener.onDismiss();
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.tv_start_time)
    public void onTvStartTimeClicked() { //选择开始时间
        new DatePickerDialog(getActivity(),
                // 绑定监听器(How the parent is notified that the date is set.)
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year,
                                          int monthOfYear, int dayOfMonth) {
                        // 此处得到选择的时间，可以进行你想要的操作
                        Calendar c = Calendar.getInstance();
                        c.set(year, monthOfYear, dayOfMonth);
                        if (c.getTimeInMillis() <= System.currentTimeMillis() + 5000) {
                            ToastUtils.showShort("只能选择今日之后的日期");
                            return;
                        }
                        String time = year + "-" + (monthOfYear + 1) + "-" + dayOfMonth;
                        startTime = time;
                        tvStartTime.setText(time);
                    }
                }
                // 设置初始日期
                , Calendar.getInstance().get(Calendar.YEAR)
                , Calendar.getInstance().get(Calendar.MONTH)
                , Calendar.getInstance().get(Calendar.DAY_OF_MONTH)).show();
    }

    @OnClick(R.id.tv_end_time)
    public void onTvEndTimeClicked() { //选择结束时间
        if (StringUtils.isEmpty(startTime)) {
            ToastUtils.showShort("请先选择开始时间");
            return;
        }
        new DatePickerDialog(getActivity(),
                // 绑定监听器(How the parent is notified that the date is set.)
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year,
                                          int monthOfYear, int dayOfMonth) {
                        // 此处得到选择的时间，可以进行你想要的操作
                        Calendar c = Calendar.getInstance();
                        c.set(year, monthOfYear, dayOfMonth);
                        if (c.getTimeInMillis() <= System.currentTimeMillis() + 5000) {
                            ToastUtils.showShort("只能选择今日之后的日期");
                            return;
                        }
                        String time = year + "-" + (monthOfYear + 1) + "-" + dayOfMonth;
                        if (startTime.compareTo(time) > 0) {
                            ToastUtils.showShort("结束时间应该大于开始时间");
                        } else {
                            endTime = time;
                            tvEndTime.setText(time);
                        }

                    }
                }
                // 设置初始日期
                , Calendar.getInstance().get(Calendar.YEAR)
                , Calendar.getInstance().get(Calendar.MONTH)
                , Calendar.getInstance().get(Calendar.DAY_OF_MONTH)).show();
    }

    @OnClick(R.id.btn_reset)
    public void onBtnResetClicked() { //重置
        taskType = 0; //任务类型
        keyWord = ""; //搜索关键字
        startTime = ""; //开始时间
        endTime = "";//结束时间
        tag = "";//筛选标签
        etKey.setText("");
        tvEndTime.setText("");
        tvStartTime.setText("");

        rb1.setChecked(false);
        rb2.setChecked(false);
        cb1.setChecked(false);
        cb2.setChecked(false);
        cb3.setChecked(false);
        cb4.setChecked(false);
    }

    @OnClick(R.id.btn_search)
    public void onBtnSearchClicked() { //搜索
        keyWord = etKey.getText().toString().trim();

        if (listener != null) {
            listener.onSearch(taskType, keyWord, startTime, endTime, tag.replaceAll(" ", ""));
        }
        dismiss();
    }

    /**
     * 任务类型选择回调
     *
     * @param radioGroup
     * @param checkedId
     */
    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
        switch (checkedId) {
            case R.id.rb_1:
                taskType = 1;
                break;
            case R.id.rb_2:
                taskType = 2;
                break;
        }
    }

    /**
     * 任务标签选择回调
     *
     * @param compoundButton
     * @param b
     */
    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        String tag1 = "";
        switch (compoundButton.getId()) {
            case R.id.cb_1:
                tag1 = "现场治理";
                break;
            case R.id.cb_2:
                tag1 = "限时整改";
                break;
            case R.id.cb_3:
                tag1 = "挂牌督办";
                break;
            case R.id.cb_4:
                tag1 = "重大隐患";
                break;
        }
        if (tagList.contains(tag1)) {
            tagList.remove(tag1);
        } else {
            tagList.add(tag1);
        }
        tag = tagList.toString().substring(1, tagList.toString().length() - 1);
    }

    /**
     * 关键字删除
     */
    @OnClick(R.id.iv_del_keyword)
    public void onViewClicked() {
        etKey.setText("");
        keyWord = "";
    }

    /**
     * 筛选dialog监听
     */
    public interface OnSearchCategoryListener {
        /**
         * 关闭搜索过滤界面
         */
        void onDismiss();

        /**
         * 搜索条件
         *
         * @param taskType  任务类型
         * @param keyWord   关键字
         * @param startTime 开始时间
         * @param endTime   结束时间
         * @param tag       标签
         */
        void onSearch(int taskType, String keyWord, String startTime, String endTime, String tag);
    }
}
