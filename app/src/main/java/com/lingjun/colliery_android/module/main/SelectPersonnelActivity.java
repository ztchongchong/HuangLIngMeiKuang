package com.lingjun.colliery_android.module.main;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ScreenUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lingjun.colliery_android.R;
import com.lingjun.colliery_android.base.BaseActivity;
import com.lingjun.colliery_android.base.BaseLinkList;
import com.lingjun.colliery_android.base.MyNestExpandableAdapter;
import com.lingjun.colliery_android.base.OnGlobalListener;
import com.lingjun.colliery_android.bean.ResponsibleBean;
import com.lingjun.colliery_android.bean.SelectPersonnelBean;
import com.lingjun.colliery_android.module.dealwith.hiddendanger.general_hidden_danger.HiddenDangerContentActivity;
import com.lingjun.colliery_android.utils.FastJsonTools;
import com.lingjun.colliery_android.utils.RecyclerViewUtils;
import com.lingjun.colliery_android.utils.ToastUtils;
import com.lingjun.colliery_android.utils.retrofit.BaseSubscriber;
import com.lingjun.colliery_android.utils.retrofit.ExceptionHandle;
import com.lingjun.colliery_android.view.NestExpandableListView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 选择人员
 * 此页面通用, requestCode请写在此类防止重复
 * JumpCode为必传参数, 用来区分从哪里跳转,可以和requestCode相同
 * Created by nefa on 2018/10/24.
 */

public class SelectPersonnelActivity extends BaseActivity {

    public static final int RectifyingCode = 301;//三违录入页面使用
    private PopupWindow window;
    private RecyclerView rv_list;
    private ImageView iv_screen;
    private TextView tvTitle;
    private Button button;
    private int width;
    private int JumpCode = 0;
    private SmartRefreshLayout refreshLayout;
    private LinearLayout ll_beijing;

    //搜索
    private EditText et_earch;
    private ImageView iv_clear;
    private TextView tv_reset;
    private TextView tv_search;
    private ArrayList<ResponsibleBean.DataBean.DepartmentlistBean> list = new ArrayList<>();

    @Override
    protected int getResourcesId() {
        return R.layout.activity_select_personnel;
    }


    @Override
    protected void init(Bundle savedInstanceState) {
        rv_list = findViewById(R.id.rv_list);
        tvTitle = findViewById(R.id.tv_name);
        button = findViewById(R.id.button);
        refreshLayout = findViewById(R.id.refreshLayout);
        ll_beijing = findViewById(R.id.ll_beijing);
        iv_screen = findViewById(R.id.iv_screen);
        //搜索
        pop_name();

        width = ScreenUtils.getScreenWidth();
        JumpCode = getIntent().getIntExtra("jumpCode", 0);
        String title = getIntent().getStringExtra("title");
        String type = getIntent().getStringExtra("type");
        if (type.equals("0")) {
            iv_screen.setVisibility(View.GONE);
            button.setVisibility(View.VISIBLE);
        } else {
            button.setVisibility(View.GONE);
        }
        tvTitle.setText(title);

        ll_beijing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                refreshLayout.autoRefresh();
            }
        });
    }

    @SuppressLint("ClickableViewAccessibility")
    private void pop_name() {
        iv_screen.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                // 构建一个popupwindow的布局
                final View popupView = getLayoutInflater().inflate(R.layout.popupwindows_name, null);
                //  为了演示效果，简单的设置了一些数据，实际中大家自己设置数据即可，相信大家都会。
                //  创建PopupWindow对象，指定宽度和高度
                window = new PopupWindow(popupView, LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                //   设置动画
                window.setAnimationStyle(R.style.AnimationFade);
                //  设置背景颜色
                window.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#FFFFFF")));
                //  设置可以获取焦点
                window.setFocusable(true);
                //  设置可以触摸弹出框以外的区域
                window.setOutsideTouchable(true);
                // 更新popupwindow的状态
                window.update();
                //  以下拉的方式显示，并且可以设置显示的位置
                window.showAsDropDown(iv_screen, 0, 40);
                //
                window.showAtLocation(getLayoutInflater().inflate(R.layout.activity_select_personnel, null), Gravity.RIGHT, 0, 500);

                et_earch = popupView.findViewById(R.id.et_earch);
                iv_clear = popupView.findViewById(R.id.iv_clear);
                tv_reset = popupView.findViewById(R.id.tv_reset);
                tv_search = popupView.findViewById(R.id.tv_search);

                View.OnClickListener onClickListener = new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        switch (view.getId()) {
                            case R.id.iv_clear://清除
                                et_earch.setText("");
                                break;
                            case R.id.tv_reset://重置
                                et_earch.setText("");
                                break;
                            case R.id.tv_search://确定
                                if (!TextUtils.isEmpty(et_earch.getText().toString().trim())) {
                                    window.dismiss();
                                    pop_refreshView();//搜索
                                } else {
                                    ToastUtils.showToast(SelectPersonnelActivity.this, "关键词不能为空");
                                    return;
                                }
                                break;
                        }

                    }
                };

                iv_clear.setOnClickListener(onClickListener);
                tv_reset.setOnClickListener(onClickListener);
                tv_search.setOnClickListener(onClickListener);

                return false;
            }
        });
    }

    //搜索
    private void pop_refreshView() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("transferUser", et_earch.getText().toString().trim());
        hashMap.put(BaseLinkList.apiurl, BaseLinkList.coal_mine + BaseLinkList.disobeyDepartmentlist);
        mRetrofit.JsonToColliery(BaseLinkList.Base_Url, hashMap, new BaseSubscriber() {
            @Override
            public void onError(ExceptionHandle.ResponeThrowable e) {
                refreshLayout.setVisibility(View.GONE);
                ll_beijing.setVisibility(View.VISIBLE);
                if (null != refreshLayout) {
                    refreshLayout.finishLoadMore();
                    refreshLayout.finishRefresh();
                }
            }

            @Override
            public void onSuccess(JSONObject jsonObject) {


                LogUtils.e("责任人信息->>" + jsonObject.toString());
                final ResponsibleBean responsibleBean = FastJsonTools.getBean(jsonObject.toString(), ResponsibleBean.class);
                if (null != responsibleBean) {
//                ArrayListst<ResponsibleBean.DataBean.DepartmentlistBean> list = new ArrayList<>();
                    if (list.size() != 0) {
                        list.clear();
                    }

                    list = responsibleBean.getData().getDepartmentlist();
                    Log.d("size", list.size() + "");
                    RecyclerViewUtils.initLinerNoSc(SelectPersonnelActivity.this, rv_list, R.layout.item_select_file, list, new OnGlobalListener() {
                        @Override
                        public <T> void logic(BaseViewHolder helper, List<T> mData, T item, BaseQuickAdapter mAdapter) {
                            if (list.size() != 0) {
//                                if(departmentBeans.size()!=0){
//                                    departmentBeans.clear();
//                                }
                                refreshLayout.setVisibility(View.VISIBLE);
                                ll_beijing.setVisibility(View.GONE);
                                final ArrayList<ResponsibleBean.DataBean.DepartmentlistBean> departmentBeans = new ArrayList<>();
                                ResponsibleBean.DataBean.DepartmentlistBean departmentBean = (ResponsibleBean.DataBean.DepartmentlistBean) item;
                                departmentBeans.add(departmentBean);
                                NestExpandableListView nestExpandable = helper.getView(R.id.nestExpandable);
                                MyNestExpandableAdapter exAdapter = new MyNestExpandableAdapter(SelectPersonnelActivity.this, departmentBeans);
                                Drawable drawable = getResources().getDrawable(R.color.transparent);
                                nestExpandable.setIndicatorBounds(width - 200, 0);
                                nestExpandable.setBackgroundResource(R.drawable.shape_bg_white);
                                nestExpandable.setDivider(drawable);
                                nestExpandable.setChildDivider(drawable);
                                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                                //ViewGroup.MarginLayoutParams layoutParams = new ViewGroup.MarginLayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                                layoutParams.setMargins(0, 50, 0, 0);
                                nestExpandable.setLayoutParams(layoutParams);
                                nestExpandable.setAdapter(exAdapter);

                                nestExpandable.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
                                    @Override
                                    public boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i1, long l) {
                                        //组信息
                                        ResponsibleBean.DataBean.DepartmentlistBean departmentlistBean = departmentBeans.get(i);
                                        //领导信息
                                        ResponsibleBean.DataBean.DepartmentlistBean.DepartmentleaderBean departmentleader = departmentlistBean.getDepartmentleader();
                                        //子信息
                                        ResponsibleBean.DataBean.DepartmentlistBean.UserlistBean personnelBean = departmentlistBean.getUserlist().get(i1);

                                        CheckBox cbox = view.findViewById(R.id.cbox);
                                        if (null != cbox) {
                                            personnelBean.setSelect(!personnelBean.isSelect());
                                            cbox.setChecked(personnelBean.isSelect());
                                            //拿出此bean中需要的信息
                                            switch (JumpCode) {
                                                case RectifyingCode:
                                                    String depName = departmentlistBean.getDepName();//部门名称
                                                    String departmentId = "" + departmentlistBean.getDepartmentId();//部门id
                                                    String leaderName = departmentleader.getName();//领导名称
                                                    String departmenUser = personnelBean.getName();//选择的人
                                                    String departmenUserId = "" + personnelBean.getUserid();//责任人ID
                                                    String leaderId = "" + departmentleader.getUserid();//领导ID

                                                    Intent intent = new Intent();
                                                    intent.putExtra("depName", depName);
                                                    intent.putExtra("departmentId", departmentId);
                                                    intent.putExtra("leaderName", leaderName);
                                                    intent.putExtra("leaderId", leaderId);
                                                    intent.putExtra("departmenUser", departmenUser);
                                                    intent.putExtra("departmenUserId", departmenUserId);

                                                    setResult(RectifyingCode, intent);
                                                    finish();
                                                    break;
                                                case 1:
                                                    break;
                                            }
                                        } else {
                                            LogUtils.e("cbox为空");
                                        }
                                        return true;
                                    }
                                });
                            } else {
                                refreshLayout.setVisibility(View.GONE);
                                ll_beijing.setVisibility(View.VISIBLE);
//                                if(departmentBeans.size()!=0){
//                                    departmentBeans.clear();
//                                    mAdapter.notifyDataSetChanged();
//                                }
                            }

                        }
                    }, null, null);

                }
                if (null != refreshLayout) {
                    refreshLayout.finishLoadMore();
                    refreshLayout.finishRefresh();
                }
            }

        });

    }


    @Override
    protected BaseRefreshLoadMoreInterface setRefreshLoadMoreListener() {
        return new BaseRefreshLoadMoreInterface() {
            @Override
            public void onLoadMore() {
                refreshView();
            }

            @Override
            public void onRefresh() {
                refreshView();
            }
        };
    }


    //
    private void refreshView() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(BaseLinkList.apiurl, BaseLinkList.coal_mine + BaseLinkList.disobeyDepartmentlist);
        mRetrofit.JsonToColliery(BaseLinkList.Base_Url, hashMap, new BaseSubscriber() {
            @Override
            public void onError(ExceptionHandle.ResponeThrowable e) {
                refreshLayout.setVisibility(View.GONE);
                ll_beijing.setVisibility(View.VISIBLE);
                dismissDialog();
            }

            @Override
            public void onSuccess(JSONObject jsonObject) {
                LogUtils.e("责任人信息->>" + jsonObject.toString());
                ResponsibleBean responsibleBean = FastJsonTools.getBean(jsonObject.toString(), ResponsibleBean.class);
                if (null != responsibleBean.getData().getDepartmentlist() && responsibleBean.getData().getDepartmentlist().size() != 0) {
                    refreshLayout.setVisibility(View.VISIBLE);
                    ll_beijing.setVisibility(View.GONE);
                    RecyclerViewUtils.initLinerNoSc(SelectPersonnelActivity.this, rv_list, R.layout.item_select_file, responsibleBean.getData().getDepartmentlist(), new OnGlobalListener() {
                        @Override
                        public <T> void logic(BaseViewHolder helper, List<T> mData, T item, BaseQuickAdapter mAdapter) {
                            ResponsibleBean.DataBean.DepartmentlistBean departmentBean = (ResponsibleBean.DataBean.DepartmentlistBean) item;

                            final ArrayList<ResponsibleBean.DataBean.DepartmentlistBean> departmentBeans = new ArrayList<>();
                            departmentBeans.add(departmentBean);
                            NestExpandableListView nestExpandable = helper.getView(R.id.nestExpandable);
                            MyNestExpandableAdapter exAdapter = new MyNestExpandableAdapter(SelectPersonnelActivity.this, departmentBeans);
                            Drawable drawable = getResources().getDrawable(R.color.transparent);
                            nestExpandable.setIndicatorBounds(width - 200, 0);
                            nestExpandable.setBackgroundResource(R.drawable.shape_bg_white);
                            nestExpandable.setDivider(drawable);
                            nestExpandable.setChildDivider(drawable);
                            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                            //ViewGroup.MarginLayoutParams layoutParams = new ViewGroup.MarginLayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                            layoutParams.setMargins(0, 50, 0, 0);
                            nestExpandable.setLayoutParams(layoutParams);
                            nestExpandable.setAdapter(exAdapter);

                            nestExpandable.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
                                @Override
                                public boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i1, long l) {
                                    //组信息
                                    ResponsibleBean.DataBean.DepartmentlistBean departmentlistBean = departmentBeans.get(i);
                                    //领导信息
                                    ResponsibleBean.DataBean.DepartmentlistBean.DepartmentleaderBean departmentleader = departmentlistBean.getDepartmentleader();
                                    //子信息
                                    ResponsibleBean.DataBean.DepartmentlistBean.UserlistBean personnelBean = departmentlistBean.getUserlist().get(i1);

                                    CheckBox cbox = view.findViewById(R.id.cbox);
                                    if (null != cbox) {
                                        personnelBean.setSelect(!personnelBean.isSelect());
                                        cbox.setChecked(personnelBean.isSelect());
                                        //拿出此bean中需要的信息
                                        switch (JumpCode) {
                                            case RectifyingCode:
                                                String depName = departmentlistBean.getDepName();//部门名称
                                                String departmentId = "" + departmentlistBean.getDepartmentId();//部门id
                                                String leaderName = departmentleader.getName();//领导名称
                                                String departmenUser = personnelBean.getName();//选择的人
                                                String departmenUserId = "" + personnelBean.getUserid();//责任人ID
                                                String leaderId = "" + departmentleader.getUserid();//领导ID

                                                Intent intent = new Intent();
                                                intent.putExtra("depName", depName);
                                                intent.putExtra("departmentId", departmentId);
                                                intent.putExtra("leaderName", leaderName);
                                                intent.putExtra("leaderId", leaderId);
                                                intent.putExtra("departmenUser", departmenUser);
                                                intent.putExtra("departmenUserId", departmenUserId);

                                                setResult(RectifyingCode, intent);
                                                finish();
                                                break;
                                        }
                                    } else {
                                        LogUtils.e("cbox为空");
                                    }
                                    return true;
                                }
                            });
                        }
                    }, null, null);
                } else {
                    refreshLayout.setVisibility(View.GONE);
                    ll_beijing.setVisibility(View.VISIBLE);
                }

                if (null != refreshLayout) {
                    refreshLayout.finishLoadMore();
                    refreshLayout.finishRefresh();
                }
            }
        });
    }


}
