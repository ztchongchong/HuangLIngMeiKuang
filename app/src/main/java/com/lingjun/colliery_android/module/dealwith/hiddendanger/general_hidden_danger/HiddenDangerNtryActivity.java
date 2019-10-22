package com.lingjun.colliery_android.module.dealwith.hiddendanger.general_hidden_danger;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.google.gson.JsonObject;
import com.lingjun.colliery_android.R;
import com.lingjun.colliery_android.base.BaseActivity;
import com.lingjun.colliery_android.base.BaseLinkList;
import com.lingjun.colliery_android.base.OnGlobalListener;
import com.lingjun.colliery_android.bean.FandPeopleTimeBean;
import com.lingjun.colliery_android.bean.HiddenDangerPlanBean;
import com.lingjun.colliery_android.bean.HiddenDangerPositionBean;
import com.lingjun.colliery_android.bean.ReviewerBean;
import com.lingjun.colliery_android.bean.SubmissionBena;
import com.lingjun.colliery_android.bean.UnsafeBehaviorInfoBean;
import com.lingjun.colliery_android.bean.UpLoadImageBean;
import com.lingjun.colliery_android.bean.YHsubmissionBean;
import com.lingjun.colliery_android.module.dealwith.hiddendanger.activity.CustomInputActivity;
import com.lingjun.colliery_android.module.dealwith.hiddendanger.activity.HiddenDangeGradeActivity;
import com.lingjun.colliery_android.module.dealwith.hiddendanger.activity.HiddenDangersDetailsActivity;
import com.lingjun.colliery_android.module.dealwith.hiddendanger.activity.ProcessingSchemeActivity;
import com.lingjun.colliery_android.module.dealwith.hiddendanger.activity.ShiftsNameActivity;
import com.lingjun.colliery_android.module.main.SelectPersonnelActivity;
import com.lingjun.colliery_android.module.main.SelectReviewerActivity;
import com.lingjun.colliery_android.module.main.rectifyingviolations.UnsafeBehaviorActivity;
import com.lingjun.colliery_android.utils.BitmapUtil;
import com.lingjun.colliery_android.utils.FastJsonTools;
import com.lingjun.colliery_android.utils.PhotoPopupManager;
import com.lingjun.colliery_android.utils.RecyclerViewUtils;
import com.lingjun.colliery_android.utils.retrofit.BaseSubscriber;
import com.lingjun.colliery_android.utils.retrofit.ExceptionHandle;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import cc.shinichi.library.ImagePreview;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * 隐患录入
 */
public class HiddenDangerNtryActivity extends BaseActivity implements View.OnClickListener {
    //计划
    private RelativeLayout rl_hidden_danger_plan;
    //位置
    private RelativeLayout rl_hidden_danger_position;
    //区域
    private RelativeLayout rl_assessment_standard;
    //隐患源
    private RelativeLayout rl_hidden_danger_content;
    private RecyclerView rv_list;
    //计划，位置，区域，录入时间，录入，发现人，内容,审核人
    private TextView tv_plan, tv_position, tv_region, tv_time, tv_discovery;
    //提交隐患
    private TextView tv_ntry_sure;
    private String imgIds;
    private String region_id;
    //隐患录入计划
    private String plan = "";
    //隐患录入位置
    private String position = "";
    //隐患录入区域
    private String region = "";
    //隐患录入内容
    private String content = "";
    //id
    private String sourceId = "";
    //隐患标准
    private String clause = "";
    //扣分
    private String score = "";
    //罚款
    private String money = "";
    //处理人ID
    private String processor_id;
    //目录ID
    private String sourceFolder;
    private String planid;
    private String customInput_id;
    private String customInput_name;
    private String time = "";
    private String measures;
    private EditText tv_clause, tv_measures, tv_content;
    private TextView tv_type;
    private String categoryName;
    //1第一次录入2驳回后录入
    private int type = 1;
    private String bohuitaskId;


    @Override
    protected int getResourcesId() {
        return R.layout.activity_hidden_danger_ntry;
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void init(Bundle savedInstanceState) {
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        tv_discovery = findViewById(R.id.tv_discovery);
        rl_hidden_danger_plan = findViewById(R.id.rl_hidden_danger_plan);
        rl_hidden_danger_position = findViewById(R.id.rl_hidden_danger_position);
        rl_assessment_standard = findViewById(R.id.rl_assessment_standard);
        rv_list = findViewById(R.id.rv_list);
        rl_hidden_danger_content = findViewById(R.id.rl_hidden_danger_content);
        tv_ntry_sure = findViewById(R.id.tv_ntry_sure);
        tv_plan = findViewById(R.id.tv_plan);
        tv_position = findViewById(R.id.tv_position);
        tv_region = findViewById(R.id.tv_region);
        tv_time = findViewById(R.id.tv_time);
        tv_content = findViewById(R.id.tv_content);
        tv_type = findViewById(R.id.tv_type);
        tv_measures = findViewById(R.id.tv_measures);
        tv_clause = findViewById(R.id.tv_clause);

        tv_type.setOnClickListener(this);
        tv_ntry_sure.setOnClickListener(this);
        rl_hidden_danger_plan.setOnClickListener(this);
        rl_hidden_danger_position.setOnClickListener(this);
        rl_assessment_standard.setOnClickListener(this);
        rl_hidden_danger_content.setOnClickListener(this);
        tv_time.setOnClickListener(this);

        type = getIntent().getIntExtra("type", -1);
        if (type == 2) {
            bohuitaskId = getIntent().getStringExtra("bohuitaskId");
        }
        //获取录入时间和发现人
        findtimepeople();
        //刷新
        refreshView();

    }

    //刷新
    private void refreshView() {

        ArrayList<UpLoadImageBean.ResultMapsBean> mArray = new ArrayList<>();
        UpLoadImageBean.ResultMapsBean imgBean = new UpLoadImageBean.ResultMapsBean();
        imgBean.setCurCode(9999);
        mArray.add(imgBean);

        RecyclerViewUtils.initGridNoSc(HiddenDangerNtryActivity.this, rv_list, R.layout.item_image, mArray, new OnGlobalListener() {
            @Override
            public <T> void logic(BaseViewHolder helper, List<T> mData, T item, BaseQuickAdapter mAdapter) {
                UpLoadImageBean.ResultMapsBean data = (UpLoadImageBean.ResultMapsBean) item;
                ImageView iv_icon = helper.getView(R.id.iv_icon);
                TextView tv_jiahao = helper.getView(R.id.tv_jiahao);
                ImageView iv_delete = helper.getView(R.id.iv_delete);

                if (TextUtils.isEmpty(data.getUrl())) {
                    tv_jiahao.setVisibility(View.VISIBLE);
                    iv_delete.setVisibility(View.GONE);
                } else {
                    tv_jiahao.setVisibility(View.GONE);

                    Glide.with(HiddenDangerNtryActivity.this).load(BaseLinkList.Base_Url + "?" + BaseLinkList.apiurl + "=" + BaseLinkList.coal_mine + "/upload/" + data.getFileName()).into(iv_icon);
                    LogUtils.e("测试图片尺寸" + BaseLinkList.Base_Url + "?" + BaseLinkList.apiurl + "=" + BaseLinkList.coal_mine + "/upload/" + data.getFileName());
                    iv_delete.setVisibility(View.VISIBLE);
                }

                helper.addOnClickListener(R.id.iv_delete);

            }
        }, new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(final BaseQuickAdapter adapter, View view, final int position) {
                UpLoadImageBean.ResultMapsBean img = (UpLoadImageBean.ResultMapsBean) adapter.getData().get(position);
                if (img.getCurCode() == 9999) {
                    //添加
                    PhotoPopupManager.getInstance().show(HiddenDangerNtryActivity.this);
                    PhotoPopupManager.getInstance().setOnPhotoSelectedListener(new PhotoPopupManager.OnPhotoSelectedListener() {
                        @Override
                        public void onPhotoSelected(String photoPath, int callBack_location) {
                            //返回path
                            LogUtils.e("返回Path:" + photoPath);
                            if (TextUtils.isEmpty(photoPath)) {
                                return;
                            }


                            File file = new File(photoPath);
                            final BaseActivity activity = HiddenDangerNtryActivity.this;
                            activity.showLoadDialog();
                            HashMap<String, File> params = new HashMap<>();
                            params.put("image", file);
                            mRetrofit.upload(BaseLinkList.Base_Url, new HashMap<String, String>(), params, new Callback<ResponseBody>() {
                                @Override
                                public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                                    String str = "";
                                    try {
                                        str = new String(response.body().bytes());
                                        LogUtils.e("上传成功->>" + str);
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                        LogUtils.e("转换出错->>" + e.getMessage());
                                        return;
                                    }

                                    UpLoadImageBean uploadImageBean = FastJsonTools.getBean(str, UpLoadImageBean.class);
                                    if (null != uploadImageBean.getResultMaps() && uploadImageBean.getResultMaps().size() != 0) {
                                        adapter.addData(0, uploadImageBean.getResultMaps().get(0));
                                        adapter.notifyItemChanged(0);
                                    }
                                    activity.dismissDialog();
                                }

                                @Override
                                public void onFailure(Call<ResponseBody> call, Throwable t) {
                                    LogUtils.e("上传失败->>" + t.getMessage());
                                    activity.dismissDialog();
                                }
                            });
                        }
                    });
                }
            }
        }, 4, new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(final BaseQuickAdapter adapter, View view, final int position) {
                //删除
                final BaseActivity activity = HiddenDangerNtryActivity.this;
                activity.showLoadDialog();
                UpLoadImageBean.ResultMapsBean img = (UpLoadImageBean.ResultMapsBean) adapter.getData().get(position);
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put(BaseLinkList.apiurl, BaseLinkList.coal_mine + BaseLinkList.getDeletePic);
                hashMap.put("fileId", "" + img.getFileId());
                mRetrofit.JsonToColliery(BaseLinkList.Base_Url, hashMap, new BaseSubscriber() {
                    @Override
                    public void onError(ExceptionHandle.ResponeThrowable e) {
                        ToastUtils.showShort("删除失败,请保持网络通畅!");
                        activity.dismissDialog();
                    }

                    @Override
                    public void onSuccess(JSONObject jsonObject) throws JSONException {
                        LogUtils.e("删除接口返回->>" + jsonObject.toString());
                        JSONObject json = jsonObject.getJSONObject("data");
                        boolean flag = json.getBoolean("flag");
                        if (flag) {
                            LogUtils.e("成功");
                            adapter.remove(position);
                        } else {
                            LogUtils.e("失败");
                            ToastUtils.showShort("删除失败,请保持网络通畅!");
                        }
                        activity.dismissDialog();
                    }
                });
            }
        });
    }

    private void findtimepeople() {

        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(BaseLinkList.apiurl, BaseLinkList.coal_mine + BaseLinkList.fandpeople_time);
        mRetrofit.JsonToColliery(BaseLinkList.Base_Url, hashMap, new BaseSubscriber() {
            @Override
            public void onError(ExceptionHandle.ResponeThrowable e) {

            }

            @Override
            public void onSuccess(JSONObject jsonObject) {
                LogUtils.e("列表->>" + jsonObject.toString());
                final FandPeopleTimeBean fandPeopleTimeBean = FastJsonTools.getBean(jsonObject.toString(), FandPeopleTimeBean.class);
                if (null != fandPeopleTimeBean && null != fandPeopleTimeBean.getMsg() && null != fandPeopleTimeBean.getCode() && null != fandPeopleTimeBean.getResultMaps()) {
                    tv_discovery.setText(fandPeopleTimeBean.getResultMaps().get(0).getUserName());
                }
            }
        });
    }

    @Override
    protected BaseRefreshLoadMoreInterface setRefreshLoadMoreListener() {
        return null;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (data != null) {
            switch (resultCode) {
                case HiddenDangerPlanActivity.HiddenDangerCode:
                    //带回数据
                    plan = data.getStringExtra("隐患计划");
                    planid = data.getStringExtra("隐患计划ID");
                    tv_plan.setText(plan);
                    break;
                case HiddenDangerPositionActivity.HiddenDangerCode:
                    //带回数据
                    position = data.getStringExtra("隐患位置历史");
                    tv_position.setText(position);
                    break;
                case HiddenDangerRegionActivity.HiddenDangerCode:
                    //带回数据
                    region = data.getStringExtra("隐患区域");
                    region_id = data.getStringExtra("隐患区域id");
                    tv_region.setText(region);
                    break;
                case HiddenDangerContentActivity.HiddenDangerCode:
                    //带回数据
                    content = data.getStringExtra("隐患内容");
                    sourceId = data.getStringExtra("隐患内容ID");
                    clause = data.getStringExtra("隐患标准");
                    score = data.getStringExtra("扣分");
                    money = data.getStringExtra("罚款");
                    processor_id = data.getStringExtra("处理人ID");
                    sourceFolder = data.getStringExtra("目录ID");
                    measures = data.getStringExtra("measures");
                    categoryName = data.getStringExtra("隐患源");
                    tv_type.setText(categoryName);
                    tv_content.setText(content);
                    tv_measures.setText(measures);
                    tv_clause.setText(clause);
                    break;
                case CustomInputActivity.HiddenDangerCode:
                    //带回数据
                    customInput_id = data.getStringExtra("customInput_id");
                    customInput_name = data.getStringExtra("customInput_name");
                    tv_type.setText(customInput_name);
                    break;
                default:
            }
        }
        super.onActivityResult(requestCode, resultCode, data);

        PhotoPopupManager.getInstance().onActivityResulted(HiddenDangerNtryActivity.this, requestCode, resultCode, data);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            //计划
            case R.id.rl_hidden_danger_plan:
                startActivityForResult(new Intent(HiddenDangerNtryActivity.this, HiddenDangerPlanActivity.class), HiddenDangerPlanActivity.HiddenDangerCode);
                break;
            //位置
            case R.id.rl_hidden_danger_position:
                startActivityForResult(new Intent(HiddenDangerNtryActivity.this, HiddenDangerPositionActivity.class), HiddenDangerPositionActivity.HiddenDangerCode);
                break;
            //隐患源
            case R.id.rl_hidden_danger_content:
                startActivityForResult(new Intent(HiddenDangerNtryActivity.this, HiddenDangerContentActivity.class), HiddenDangerContentActivity.HiddenDangerCode);
                break;
            //隐患源
            case R.id.tv_type:
                startActivityForResult(new Intent(HiddenDangerNtryActivity.this, CustomInputActivity.class), CustomInputActivity.HiddenDangerCode);
                break;
            //区域
            case R.id.rl_assessment_standard:
                startActivityForResult(new Intent(HiddenDangerNtryActivity.this, HiddenDangerRegionActivity.class), HiddenDangerRegionActivity.HiddenDangerCode);
                break;
            //提交隐患
            case R.id.tv_ntry_sure:
                if (TextUtils.isEmpty(region)) {
                    ToastUtils.showShort("请选择隐患源区域");
                    return;
                }
                if (TextUtils.isEmpty(categoryName) && TextUtils.isEmpty(customInput_name)) {
                    ToastUtils.showShort("请选择隐患类型");
                    return;
                }
                if (TextUtils.isEmpty(tv_content.getText().toString().trim())) {
                    ToastUtils.showShort("请选择/输入隐患源");
                    return;
                }
                if (TextUtils.isEmpty(tv_measures.getText().toString().trim())) {
                    ToastUtils.showShort("请选择/输入隐患措施");
                    return;
                }
                if (TextUtils.isEmpty(time)) {
                    ToastUtils.showShort("请选择录入时间");
                    return;
                }
                //跳转到待处理
                Jump();
                break;
            case R.id.tv_time:
                new DatePickerDialog(this,
                        // 绑定监听器(How the parent is notified that the date is set.)
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {
                                // 此处得到选择的时间，可以进行你想要的操作
                                Calendar c = Calendar.getInstance();
                                c.set(year, monthOfYear, dayOfMonth);
                                LogUtils.e("sleect ===========>" + c.getTimeInMillis());
                                LogUtils.e("sleect1 ===========>" + System.currentTimeMillis());
                                if (c.getTimeInMillis() >= System.currentTimeMillis() + 5000) {
                                    ToastUtils.showShort("只能选择今日之前的日期");
                                    return;
                                }
                                String shijian = new SimpleDateFormat("HH:mm:ss").format(new Date(System.currentTimeMillis()));
                                time = year + "-" + (monthOfYear + 1) + "-" + dayOfMonth + " " + shijian;
                                tv_time.setText(time);
                            }
                        }
                        // 设置初始日期
                        , Calendar.getInstance().get(Calendar.YEAR)
                        , Calendar.getInstance().get(Calendar.MONTH)
                        , Calendar.getInstance().get(Calendar.DAY_OF_MONTH)).show();
                break;
            default:
        }
    }

    //跳转到待处理
    private void Jump() {
        BaseQuickAdapter imageAdapter = (BaseQuickAdapter) rv_list.getAdapter();
        ArrayList<UpLoadImageBean.ResultMapsBean> imageArray = (ArrayList<UpLoadImageBean.ResultMapsBean>) imageAdapter.getData();
        if (imageArray.size() > 1) {
            imgIds = "";
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < imageArray.size(); i++) {
                if (imageArray.get(i).getFileId() != 0) {
                    sb.append(imageArray.get(i).getFileId()).append(",");
                }
            }
            imgIds = sb.substring(0, sb.length() - 1);
            Log.d("img", imgIds);
        }
        Bundle bundle = new Bundle();
        //隐患录入计划id
        bundle.putString("planId", planid);
        //隐患录入位置
        bundle.putString("location", position);
        //隐患录入区域id;
        bundle.putString("areaId", region_id);
        //隐患录入区域名称
        bundle.putString("areaName", region);
        if (!TextUtils.isEmpty(customInput_id)) {
            //隐患类型id
            bundle.putString("sourceFolder", customInput_id);
        } else {
            //隐患类型id
            bundle.putString("sourceFolder", sourceFolder);
        }
        if (!TextUtils.isEmpty(sourceId)) {
            //隐患内容ID
            bundle.putString("sourceId", sourceId);
        } else {
            //不选择默认传0
            bundle.putString("sourceId", "0");
        }
        //隐患源描述
        bundle.putString("sourceDesc", tv_content.getText().toString().trim());
        //检查标准id 默认0
        bundle.putString("clauseId", "0");
        //检查标准
        bundle.putString("clauseDesc", tv_clause.getText().toString().trim());
        //隐患措施
        bundle.putString("torubleMeasures", tv_measures.getText().toString().trim());
        //图片id
        bundle.putString("fileIds", imgIds);
        //录入时间
        bundle.putString("addTime", time);
        //任务状态（0草稿，1主任务）
        bundle.putString("taskStatus", "1");
        if (!TextUtils.isEmpty(money)) {
            //罚款
            bundle.putString("sourceMoney", money);
        } else {
            //罚款
            bundle.putString("sourceMoney", "0");
        }
        if (!TextUtils.isEmpty(score)) {
            //扣分
            bundle.putString("sourceScore", score);
        } else {
            //扣分
            bundle.putString("sourceScore", "0");
        }
        //第一次录入和驳回
        bundle.putString("type", String.valueOf(type));
        if (type == 2) {
            //第一次录入和驳回
            bundle.putString("bohuitaskId", bohuitaskId);
            LogUtils.e("隐患录入传出bohuitaskId" + bohuitaskId);
        }
        Intent intent = new Intent(HiddenDangerNtryActivity.this, ProcessingSchemeActivity.class);
        intent.putExtra("bundle", bundle);
        startActivity(intent);
        finish();
    }
}
