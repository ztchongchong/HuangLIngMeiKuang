package com.lingjun.colliery_android.module.dealwith.activity;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.blankj.utilcode.util.ToastUtils;
import com.lingjun.colliery_android.R;
import com.lingjun.colliery_android.base.BaseActivity;
import com.lingjun.colliery_android.base.BaseFragment;
import com.lingjun.colliery_android.base.BaseLinkList;
import com.lingjun.colliery_android.bean.CheckFileBean;
import com.lingjun.colliery_android.bean.CheckInfoBean;
import com.lingjun.colliery_android.bean.CheckMlBean;
import com.lingjun.colliery_android.bean.EditionCataLogInListAPPBean;
import com.lingjun.colliery_android.bean.LXBean;
import com.lingjun.colliery_android.module.dealwith.adapter.AgencyCategoriesAdapter;
import com.lingjun.colliery_android.module.dealwith.adapter.CheckQxAdapter;
import com.lingjun.colliery_android.module.dealwith.adapter.DivideWorkAdapter;
import com.lingjun.colliery_android.module.dealwith.adapter.QuanXianAdapter;
import com.lingjun.colliery_android.module.dealwith.fragment.DatePickerDialogFragment;
import com.lingjun.colliery_android.module.dealwith.myinterface.ListviewInterface;
import com.lingjun.colliery_android.module.dealwith.standardized.check.CheckActivity;
import com.lingjun.colliery_android.utils.FastJsonTools;
import com.lingjun.colliery_android.utils.retrofit.BaseSubscriber;
import com.lingjun.colliery_android.utils.retrofit.ExceptionHandle;
import com.lingjun.colliery_android.view.CalendarHelper;
import com.lingjun.colliery_android.view.WheelView;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
 * Created by shurrikann on 2018/3/26.
 */

public class DivideWorkActivity extends BaseActivity implements ListviewInterface {
    private ImageView iv_back;
    private TextView request;
    private TextView data;
    private TextView grade;
    private RecyclerView fg_recy;
    private RelativeLayout recy_rel;
    private LinearLayout pingfen;
    private DivideWorkAdapter adapter;
    private PopupWindow popupWindow;
    private PopupWindow popupWindows;
    private QuanXianAdapter quanXianAdapter;
    private RelativeLayout cut_off;
    private Dialog dialog;
    private TextView cut_off_text;
    private int pos;
    private int zf;
    private int df;
    private int jf;
    private TextView zongfen;
    private TextView defen;
    private TextView save;
    private String jianfen = "0";
    private EditText liyou;
    private String taskid;
    private LinearLayout request_lay;
    private TextView title_str;
    private TextView renyuan;
    private TextView project_name;
    private TextView number;
    private TextView yaoqiu;
    private TextView pfstr;
    private String titlestr;
    private TextView tv_name;
    private ImageView mulu;
    private TextView zeren;
    private TextView peihe;
    private TextView teyao;
    private TextView tv_add_ziliao;
    int page = 1;
    private String itemid;
    private List<LXBean.ResultMapsBean> lxlist = new ArrayList<>();
    private AgencyCategoriesAdapter lxadapter;

    private String searchstr = "";
    private String stateTime = "";
    private String emdTime = "";
    private String mulustr = "";
    private String lxstr = "";
    private StringBuffer lxsb;
    private StringBuffer mlsb;
    private List<CheckMlBean.DataBean.CatalogListBean> mllist = new ArrayList<>();
    private EditionCataLogInListAPPBean bean;
    private List<EditionCataLogInListAPPBean.DataBean.ResultStdfileEditionListBean> filelist = new ArrayList<>();
    private List<CheckMlBean.DataBean.CatalogListBean> selectmllist = new ArrayList<>();
    private CheckQxAdapter checkQxAdapter;
    private CheckInfoBean checkInfoBean;
    private TextView jiancha;
    private TextView ziliao;
    private TextView koufen;

    @Override
    protected int getResourcesId() {
        return R.layout.activity_divide_work;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        jiancha = findViewById(R.id.jiancha);
        ziliao = findViewById(R.id.ziliao);
        koufen = findViewById(R.id.koufen);
        pos = getIntent().getIntExtra("pos", -1);
        zf = getIntent().getIntExtra("zongfen", -1);
        df = getIntent().getIntExtra("defen", -1);
        jf = getIntent().getIntExtra("jianfen", -1);
        Log.d("zf22222", zf + "," + df);
        taskid = getIntent().getStringExtra("taskid");
        titlestr = getIntent().getStringExtra("title");
        itemid = getIntent().getStringExtra("itemid");
        initView();
        setClick();
        initAdapter();
        getCheckInfo();
        zongfen.setText(zf + "");
        defen.setText(df + "");
        cut_off_text.setText(String.valueOf(jf));
    }

    private void initAdapter() {
        lxadapter = new AgencyCategoriesAdapter(R.layout.recy_item_agency_categories);
        quanXianAdapter = new QuanXianAdapter(R.layout.item_quanxian);
        adapter = new DivideWorkAdapter(R.layout.item_data);
        checkQxAdapter = new CheckQxAdapter(R.layout.item_check_qx);
        fg_recy.setLayoutManager(new LinearLayoutManager(this));
        fg_recy.setAdapter(adapter);
    }

    private void getCheckInfo() {
        showLoadDialog();
        HashMap<String, String> hashMap = new HashMap<>();
        if (TextUtils.isEmpty(taskid)) {
            return;
        }
        hashMap.put("taskid", taskid);
        hashMap.put("apiurl", BaseLinkList.coal_mine + BaseLinkList.MOBILE_GETSTADCHKITEMTASK);
        mRetrofit.JsonToColliery(BaseLinkList.Base_Url, hashMap, new BaseSubscriber() {
            @Override
            public void onError(ExceptionHandle.ResponeThrowable e) {
                dismissDialog();
            }

            @Override
            public void onSuccess(JSONObject jsonObject) throws JSONException {
                Log.d("检查要求", jsonObject.toString());
                checkInfoBean = FastJsonTools.getBean(jsonObject.toString(), CheckInfoBean.class);
                if (null != checkInfoBean) {
                    title_str.setText(checkInfoBean.getData().getTaskitem().getSerialno() + checkInfoBean.getData().getTaskitem().getCategoryname().replace("/", "-"));
//                    renyuan.setText("责任：" + checkInfoBean.getData().getTaskitem().getResponsibleName() + " " + "配合：" + bean.getData().getTaskitem().getCooperatorNames() + " " + "特邀：" + bean.getData().getTaskitem().getInvited());
                    zeren.setText("责任：" + checkInfoBean.getData().getTaskitem().getResponsibleName());
                    peihe.setText("配合：" + checkInfoBean.getData().getTaskitem().getCooperatorNames());
                    teyao.setText("特邀：" + checkInfoBean.getData().getTaskitem().getInvited());
                    project_name.setText(checkInfoBean.getData().getTaskitem().getCategoryname().replace("/", "-"));
                    number.setText("编号：" + checkInfoBean.getData().getTaskitem().getSerialno());
                    yaoqiu.setText(checkInfoBean.getData().getTaskitem().getDemand());
                    pfstr.setText(checkInfoBean.getData().getTaskitem().getStandard());
                    jiancha.setText(checkInfoBean.getData().getTaskitem().getMethodContent());
                    ziliao.setText(checkInfoBean.getData().getTaskitem().getRequiredInfo());
                    koufen.setText(checkInfoBean.getData().getTaskitem().getDetailedRules());
                }
                dismissDialog();
            }
        });
        GetLXTask();
        GetZLInfo();
    }

    private void GetZLInfo() {//获取目录
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("itemidStr", itemid);
        hashMap.put("apiurl", BaseLinkList.coal_mine + BaseLinkList.MOBILE_GETCATALOGINFOLISTBYITEM);
        mRetrofit.JsonToColliery(BaseLinkList.Base_Url, hashMap, new BaseSubscriber() {
            @Override
            public void onError(ExceptionHandle.ResponeThrowable e) {

            }

            @Override
            public void onSuccess(JSONObject jsonObject) throws JSONException {
                Log.d("json3333333", jsonObject.toString());
                CheckMlBean bean = FastJsonTools.getBean(jsonObject.toString(), CheckMlBean.class);
                if (null != bean) {
                    if (bean.getData().getCatalogList().size() != 0) {
                        mllist = bean.getData().getCatalogList();
                        quanXianAdapter.setNewData(mllist);
                    }
                }
            }
        });
    }

    private void GetCheckTj() {//获取资料
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("itemId", itemid);
//        hashMap.put("page", page + "");
//        hashMap.put("pageSize", "10");
//        hashMap.put("searchstr", searchstr);
//        hashMap.put("catalogId", mulustr);
//        hashMap.put("starttime", stateTime);
//        hashMap.put("endtime", emdTime);
//        hashMap.put("brand", lxstr);
        hashMap.put("apiurl", BaseLinkList.coal_mine + BaseLinkList.MOBILE_GETCATALOGINLIST);
        mRetrofit.JsonToColliery(BaseLinkList.Base_Url, hashMap, new BaseSubscriber() {
            @Override
            public void onError(ExceptionHandle.ResponeThrowable e) {
                if (null != refreshLayout) {
                    refreshLayout.finishRefresh();
                    refreshLayout.finishLoadMore();
                }
            }

            @Override
            public void onSuccess(JSONObject jsonObject) throws JSONException {
                Log.d("标准资料", jsonObject.toString());
                bean = FastJsonTools.getBean(jsonObject.toString(), EditionCataLogInListAPPBean.class);
                if (null != bean) {
                    adapter.setType(2);
                    filelist = bean.getData().getResultStdfileEditionList();
                    adapter.setNewData(filelist);
//                    if (page == 1) {
//                        if (filelist.size() != 0) {
//                            filelist.clear();
//                        }
//                        if (bean.getData().getResultStdfileEditionList().size()!= 0) {
//                            filelist = bean.getData().getResultStdfileEditionList();
//                        }
//                        adapter.setNewData(filelist);
//                    } else {
//                        if (bean.getData().getResultStdfileEditionList().size() != 0) {
//                            filelist.addAll(bean.getData().getResultStdfileEditionList());
//                            adapter.setNewData(filelist);
//                        }
//                    }
                }
                if (null != refreshLayout) {
                    refreshLayout.finishRefresh();
                    refreshLayout.finishLoadMore();
                }
            }
        });
    }

    private void GetLXTask() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("apiurl", BaseLinkList.coal_mine + BaseLinkList.MOBILE_GETBRANDS);
        mRetrofit.JsonToColliery(BaseLinkList.Base_Url, hashMap, new BaseSubscriber() {
            @Override
            public void onError(ExceptionHandle.ResponeThrowable e) {

            }

            @Override
            public void onSuccess(JSONObject jsonObject) throws JSONException {
                Log.d("json2222222", jsonObject.toString());
                LXBean bean = FastJsonTools.getBean(jsonObject.toString(), LXBean.class);
                if (null != bean) {
                    if (bean.getResultMaps().size() != 0) {
                        lxlist = bean.getResultMaps();
                        lxadapter.setNewData(lxlist);
                    }
                }
            }
        });
    }

    @Override
    protected BaseRefreshLoadMoreInterface setRefreshLoadMoreListener() {
        return new BaseRefreshLoadMoreInterface() {
            @Override
            public void onLoadMore() {
                page++;
                GetCheckTj();
            }

            @Override
            public void onRefresh() {
                page = 1;
                GetCheckTj();
            }
        };
    }


    private void setClick() {
        iv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        request.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                forceHideIM();
                request.setTextColor(getResources().getColor(R.color.blue0092));
                data.setTextColor(getResources().getColor(R.color.color9797));
                grade.setTextColor(getResources().getColor(R.color.color9797));
//                setData(1);
                request_lay.setVisibility(View.VISIBLE);
                recy_rel.setVisibility(View.GONE);
                pingfen.setVisibility(View.GONE);
                save.setVisibility(View.GONE);
                mulu.setVisibility(View.INVISIBLE);
            }
        });
        data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                forceHideIM();
                request.setTextColor(getResources().getColor(R.color.color9797));
                data.setTextColor(getResources().getColor(R.color.blue0092));
                grade.setTextColor(getResources().getColor(R.color.color9797));
//                setData(2);
                request_lay.setVisibility(View.GONE);
                recy_rel.setVisibility(View.VISIBLE);
                pingfen.setVisibility(View.GONE);
                save.setVisibility(View.GONE);
                mulu.setVisibility(View.VISIBLE);
            }
        });
        grade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                forceHideIM();
                request.setTextColor(getResources().getColor(R.color.color9797));
                data.setTextColor(getResources().getColor(R.color.color9797));
                grade.setTextColor(getResources().getColor(R.color.blue0092));
                recy_rel.setVisibility(View.GONE);
                pingfen.setVisibility(View.VISIBLE);
                request_lay.setVisibility(View.GONE);
                save.setVisibility(View.VISIBLE);
                mulu.setVisibility(View.INVISIBLE);
            }
        });
        mulu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showdepartmentpopupwindow(selectmllist);
//                FenGongDialogFragment.newInstance().show(instance.getSupportFragmentManager(), "WholeCategory");
            }
        });
        cut_off.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showCutoffDialog(DivideWorkActivity.this);
            }
        });
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(jianfen)) {
                    ToastUtils.showShort("请对检查打分");
                    return;
                }
                if (TextUtils.isEmpty(liyou.getText().toString().trim())) {
                    ToastUtils.showShort("请填写扣分理由");
                    return;
                }
                Intent intent = new Intent();
                intent.setClass(DivideWorkActivity.this, CheckActivity.class);
                intent.putExtra("pos", pos);
                intent.putExtra("jianfen", jianfen);
                intent.putExtra("defen", df + "");
                intent.putExtra("liyou", liyou.getText().toString().trim());
                intent.putExtra("name", checkInfoBean.getData().getTaskitem().getSerialno() + checkInfoBean.getData().getTaskitem().getCategoryname().replace("/", "-"));
                DivideWorkActivity.this.setResult(1, intent);
                forceHideIM();
                finish();
            }
        });

        tv_add_ziliao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DivideWorkActivity.this, DataEditingActivity.class);
                intent.putExtra("judge", "1");
                intent.putExtra("id", bean.getResultMaps().get(1).getCatalogIdResult() + "");
                startActivity(intent);
            }
        });
    }

    @SuppressLint("WrongViewCast")
    private void initView() {
        iv_back = findViewById(R.id.iv_back);
        request = findViewById(R.id.request);
        data = findViewById(R.id.data);
        grade = findViewById(R.id.grade);
        fg_recy = findViewById(R.id.fg_recy);
        recy_rel = findViewById(R.id.recy_rel);
        pingfen = findViewById(R.id.pingfen);
        cut_off = findViewById(R.id.cut_off);
        cut_off_text = findViewById(R.id.cut_off_text);
        zongfen = findViewById(R.id.zongfen);
        defen = findViewById(R.id.defen);
        save = findViewById(R.id.save);
        liyou = findViewById(R.id.liyou);

        zeren = findViewById(R.id.zeren);
        peihe = findViewById(R.id.peihe);
        teyao = findViewById(R.id.teyao);

        request_lay = findViewById(R.id.request_lay);
        title_str = findViewById(R.id.title_str);
        project_name = findViewById(R.id.project_name);
        number = findViewById(R.id.number);
        yaoqiu = findViewById(R.id.yaoqiu);
        pfstr = findViewById(R.id.pfstr);
        mulu = findViewById(R.id.mulu);
        tv_name = findViewById(R.id.tv_name);
        tv_add_ziliao = findViewById(R.id.tv_add_ziliao);
    }

    @Override
    public void btnClick(View v, int pos, boolean type) {

//        ToastUtils.showShort(pos + "");
    }

    @Override
    public void btnsClick(View v, int pos, int state, boolean type) {

    }

    @Override
    public void btnsClicks(View v, int pos, boolean state, int type) {
//        switch (type) {
//            case 1:
//                beanlist.get(pos).setState(!state);
//                adapter.notifyItemChanged(pos);
//                break;
//            case 2:
//                tagList.get(pos).setState(!state);
//                quanXianAdapter.notifyItemChanged(pos);
//                break;
//        }
    }

    private void showdepartmentpopupwindow(List<CheckMlBean.DataBean.CatalogListBean> lists) {
        View view = LayoutInflater.from(DivideWorkActivity.this).inflate(R.layout.popupwindows_fengong, null);
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
                getWindow().setAttributes(params);
                popupWindow = null;
            }
        });
        RecyclerView recyAgencyCategories = view.findViewById(R.id.recy_agency_cateory);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(DivideWorkActivity.this, 3) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
        recyAgencyCategories.setLayoutManager(gridLayoutManager);
        recyAgencyCategories.setAdapter(lxadapter);
        final TextView btnStartTime = view.findViewById(R.id.tv_start_time);
        final TextView btnEndTime = view.findViewById(R.id.tv_end_time);
        final TextView tv_search = view.findViewById(R.id.tv_search);
        final RecyclerView mulu_recy = view.findViewById(R.id.mulu_recy);
        final EditText et_earch = view.findViewById(R.id.et_earch);
        final ImageView iv_clear = view.findViewById(R.id.iv_clear);
        final RelativeLayout select_ml = view.findViewById(R.id.select_ml);
        if (!TextUtils.isEmpty(searchstr)) {
            et_earch.setText(searchstr);
        }
        if (!TextUtils.isEmpty(stateTime)) {
            btnStartTime.setText(stateTime);
        }
        if (!TextUtils.isEmpty(emdTime)) {
            btnEndTime.setText(emdTime);
        }
        TextView tv_reset = view.findViewById(R.id.tv_reset);
        RelativeLayout mulu = view.findViewById(R.id.mulu);
        if (lists.size() == 0) {
            select_ml.setVisibility(View.VISIBLE);
            mulu_recy.setVisibility(View.GONE);
        } else {
            select_ml.setVisibility(View.GONE);
            mulu_recy.setVisibility(View.VISIBLE);
            mulu_recy.setLayoutManager(new LinearLayoutManager(this));
            mulu_recy.setAdapter(checkQxAdapter);
            checkQxAdapter.setNewData(selectmllist);
        }
        mulu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchstr = et_earch.getText().toString().trim();
                stateTime = btnStartTime.getText().toString().trim();
                emdTime = btnEndTime.getText().toString().trim();
                popupWindow.dismiss();
//                popupWindow = null;
                showdepartmentpopupwindows();
            }
        });
        mulu_recy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchstr = et_earch.getText().toString().trim();
                stateTime = btnStartTime.getText().toString().trim();
                emdTime = btnEndTime.getText().toString().trim();
                popupWindow.dismiss();
//                popupWindow = null;
                showdepartmentpopupwindows();
            }
        });
        btnStartTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialogFragment datePickerDialogFragment = DatePickerDialogFragment.newInstance();
                datePickerDialogFragment.show(getSupportFragmentManager(), "DatePicker");
                datePickerDialogFragment.setOnDateTapedListener(new CalendarHelper.OnDateTapedListener() {
                    @Override
                    public void onDateTaped(String date) {
                        Log.d("date", date);
                        if (!TextUtils.isEmpty(date)) {
                            btnStartTime.setText(date);
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
                            btnEndTime.setText(date);
                        }
                    }
                });
            }
        });
        tv_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lxsb = new StringBuffer();
                mlsb = new StringBuffer();
                searchstr = et_earch.getText().toString().trim();
                stateTime = btnStartTime.getText().toString().trim();
                emdTime = btnEndTime.getText().toString().trim();
                page = 1;
                Log.d("str", searchstr + "," + stateTime + "," + emdTime);
                if (lxlist.size() != 0) {
                    for (int i = 0; i < lxlist.size(); i++) {
                        if (lxlist.get(i).isState()) {
                            lxsb.append(lxlist.get(i).getKeyword().getKeyId()).append(",");
                        }
                    }
                    if (lxsb.length() != 0) {
                        lxstr = lxsb.substring(0, lxsb.length() - 1);
                    }
                }
                if (selectmllist.size() != 0) {
                    for (int i = 0; i < selectmllist.size(); i++) {
                        mlsb.append(selectmllist.get(i).getId()).append(",");
                    }
                    mulustr = mlsb.substring(0, mlsb.length() - 1);
                }
                GetCheckTj();
                et_earch.setText("");
                btnStartTime.setText("");
                btnEndTime.setText("");
                if (selectmllist.size() != 0) {
                    selectmllist.clear();
                    select_ml.setVisibility(View.VISIBLE);
                    mulu_recy.setVisibility(View.GONE);
                }
                for (int i = 0; i < lxlist.size(); i++) {
                    lxlist.get(i).setState(false);
                    lxadapter.notifyDataSetChanged();
                }
                popupWindow.dismiss();
                popupWindow = null;
            }
        });
        tv_reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et_earch.setText("");
                btnStartTime.setText("");
                btnEndTime.setText("");
                if (selectmllist.size() != 0) {
                    selectmllist.clear();
                    select_ml.setVisibility(View.VISIBLE);
                    mulu_recy.setVisibility(View.GONE);
                }
                for (int i = 0; i < lxlist.size(); i++) {
                    lxlist.get(i).setState(false);
                    lxadapter.notifyDataSetChanged();
                }
            }
        });
        iv_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et_earch.setText("");
            }
        });
    }

    private void showdepartmentpopupwindows() {
        View view = LayoutInflater.from(DivideWorkActivity.this).inflate(R.layout.popupwindows_quanxian, null);
        if (popupWindows == null) {
            popupWindows = new PopupWindow(view, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT);
        }
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        popupWindows.setBackgroundDrawable(getResources().getDrawable(R.color.spark_light_grey_pop_bg));
        popupWindows.setAnimationStyle(R.style.AnimationFade);
        popupWindows.setOutsideTouchable(true);
        popupWindows.setFocusable(true);
        View parent = LayoutInflater.from(this).inflate(R.layout.activity_divide_work, null);
        popupWindows.showAtLocation(parent, Gravity.RIGHT, 0, 0);
        //popupWindow在弹窗的时候背景半透明
        final WindowManager.LayoutParams params = getWindow().getAttributes();
        params.alpha = 0.8f;
        getWindow().setAttributes(params);
        popupWindows.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                params.alpha = 1.0f;
                getWindow().setAttributes(params);
                popupWindows = null;
            }
        });
        TextView tv_back = view.findViewById(R.id.tv_back);
        TextView tv_pass = view.findViewById(R.id.tv_pass);
        RecyclerView recyAgencyTags = view.findViewById(R.id.quanxian_recy);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(DivideWorkActivity.this) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
        recyAgencyTags.setLayoutManager(linearLayoutManager);

        quanXianAdapter.setInterface(this);
//        quanXianAdapter.setData(strlist);
        recyAgencyTags.setAdapter(quanXianAdapter);
        tv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindows.dismiss();
                showdepartmentpopupwindow(selectmllist);
            }
        });
        tv_pass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindows.dismiss();
                for (int i = 0; i < mllist.size(); i++) {
                    if (mllist.get(i).isChecktype()) {
                        selectmllist.add(mllist.get(i));
                    }
                }
                showdepartmentpopupwindow(selectmllist);
            }
        });
    }


    public class InfoBean {
        String str;
        boolean state;

        public String getStr() {
            return str;
        }

        public void setStr(String str) {
            this.str = str;
        }

        public boolean isState() {
            return state;
        }

        public void setState(boolean state) {
            this.state = state;
        }
    }

    private void showCutoffDialog(Context context) {
        if (dialog == null) {
            dialog = new Dialog(context, R.style.dialog);//
        }
        dialog.setCancelable(false);
        dialog.getWindow().setContentView(R.layout.dialog_cut_off);
        dialog.setCanceledOnTouchOutside(true);
        final WheelView wheelView = dialog.findViewById(R.id.wheel);
        final List<String> lists = new ArrayList<>();
        for (int i = 0; i < zf + 1; i++) {
            lists.add(i + "");
        }
//        if (zf % 2 == 0) {
//            zf=zf+1;
//        }
        wheelView.lists(lists).fontSize(50).showCount(zf).selectTip("分").select(0).listener(new WheelView.OnWheelViewItemSelectListener() {
            @Override
            public void onItemSelect(int index) {
                jianfen = lists.get(index);
                cut_off_text.setText(lists.get(index));
                defen.setText(zf - Integer.valueOf(lists.get(index)) + "");
                df = zf - Integer.valueOf(lists.get(index));
                Log.d("cc", "current select:" + wheelView.getSelectItem() + " index :" + index + ",result=" + lists.get(index));
            }
        }).build();
        dialog.show();

    }

    /**
     * 强制隐藏键盘
     */
    public void forceHideIM() {
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        if (inputMethodManager == null) {
            return;
        }
        View decorView = getWindow().getDecorView();
        inputMethodManager.hideSoftInputFromWindow(decorView.getWindowToken(), 0);
    }

//    class GetInfoTask extends AsyncTask<String, String, CheckInfoBean> {
//
//        @Override
//        protected void onPreExecute() {
//            super.onPreExecute();
//        }
//
//        @Override
//        protected CheckInfoBean doInBackground(String... strings) {
//            String result;
//            CheckInfoBean bean = null;
//            try {
//                JSONObject jsonObject = new JSONObject();
//                jsonObject.put("taskid", id + "");
//                result = SingleOkHttpUtils.doJsonLingJun(jsonObject.toString(), NetConstantUtils.BASE_URL + NetConstantUtils.MOBILE_GETSTADCHKITEMTASK, DivideWorkActivity.this);
//                Log.d("result-1", result);
//                bean = FastJsonTools.getBean(result, CheckInfoBean.class);
//            } catch (Exception e) {
//                e.getSuppressed();
//                return null;
//            }
//            return bean;
//        }
//
//        @Override
//        protected void onPostExecute(CheckInfoBean bean) {
//            super.onPostExecute(bean);
//            if (bean != null) {
//                if (bean.getCode().equals("200")) {
//                    title_str.setText(bean.getData().getTaskitem().getSerialno() + bean.getData().getTaskitem().getCategoryname().replace("/", "-"));
//                    renyuan.setText("责任：" + bean.getData().getTaskitem().getResponsibleName() + " " + "配合：" + bean.getData().getTaskitem().getCooperatorNames() + " " + "特邀：" + bean.getData().getTaskitem().getInvited());
//                    project_name.setText(bean.getData().getTaskitem().getCategoryname().replace("/", "-"));
//                    number.setText("编号：" + bean.getData().getTaskitem().getSerialno());
//                    yaoqiu.setText(bean.getData().getTaskitem().getDemand());
//                    pfstr.setText(bean.getData().getTaskitem().getStandard());
//                } else {
//
//                }
//            } else {
//
//            }
//        }
//    }


    @Override
    protected void onResume() {
        GetCheckTj();
        GetZLInfo();
        super.onResume();
    }
}
