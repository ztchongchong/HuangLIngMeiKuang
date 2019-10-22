package com.lingjun.colliery_android.module.main.rectifyingviolations.fragment;

import android.annotation.TargetApi;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lingjun.colliery_android.R;
import com.lingjun.colliery_android.base.BaseActivity;
import com.lingjun.colliery_android.base.BaseFragment;
import com.lingjun.colliery_android.base.BaseLinkList;
import com.lingjun.colliery_android.base.OnGlobalListener;
import com.lingjun.colliery_android.base.UserBean;
import com.lingjun.colliery_android.base.UserBeans;
import com.lingjun.colliery_android.bean.DisobeyInfoBean;
import com.lingjun.colliery_android.bean.DisobeyLeaderBean;
import com.lingjun.colliery_android.bean.PersonLiableBean;
import com.lingjun.colliery_android.bean.RectifyingManagerBean;
import com.lingjun.colliery_android.bean.ReviewerBean;
import com.lingjun.colliery_android.bean.UnsafeBehaviorInfoBean;
import com.lingjun.colliery_android.bean.UpLoadImageBean;
import com.lingjun.colliery_android.module.dealwith.hiddendanger.activity.AcceptorActivity;
import com.lingjun.colliery_android.module.dealwith.hiddendanger.activity.ShiftsNameActivity;
import com.lingjun.colliery_android.module.dealwith.hiddendanger.general_hidden_danger.HiddenDangerNtryActivity;
import com.lingjun.colliery_android.module.dealwith.hiddendanger.general_hidden_danger.HiddenDangerRegionActivity;
import com.lingjun.colliery_android.module.main.SelectPersonnelActivity;
import com.lingjun.colliery_android.module.main.SelectReviewerActivity;
import com.lingjun.colliery_android.module.main.rectifyingviolations.DisobeyLeaderActivity;
import com.lingjun.colliery_android.module.main.rectifyingviolations.InspectorActivity;
import com.lingjun.colliery_android.module.main.rectifyingviolations.JWcustomActivity;
import com.lingjun.colliery_android.module.main.rectifyingviolations.RectifyingViolationsManagementActivity;
import com.lingjun.colliery_android.module.main.rectifyingviolations.UnsafeBehaviorActivity;
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
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * 三违录入
 * Created by nefa on 2018/11/14.
 */

public class RectifyingViolationsFragment extends BaseFragment implements View.OnClickListener {

    private TextView tv_num1;//负责人
    private TextView tv_num2;//责任单位
    private TextView tv_num3;//责任领导
    private TextView tv_num4;//检查人
    private EditText et_edit;//行为描述
    private RecyclerView rv_list;//照片
    private Switch switch_select;//选择
    private LinearLayout ll_add;//添加entry
    private RecyclerView rv_entry_list;//entry
    private Button btn_complete;//提交
    private RelativeLayout rl_1;
    private RelativeLayout rl_2;
    private LinearLayout rl_3;
    private RelativeLayout rl_4;//选择审核人
    private RelativeLayout rl_5;//选择审核人
    private RelativeLayout rl_6;
    private RelativeLayout rl_8;//班次
    private RelativeLayout rl_9;//班次
    private EditText et_sanweiren;//班次
    private TextView tv_banci;//班次
    private TextView tv_quyu;//班次
    private TextView tv_shenhe;//审核人
    private RecyclerView rv_entry_additional_list;//额外处罚
    private EditText et_economic;
    private TextView tv_time;
    private TextView tv_left;
    private TextView tv_right;
    private TextView tv_tab_left;
    private TextView tv_tab_right;
    private RelativeLayout rl_buanquan;
    private RelativeLayout rl_custom;
    private LinearLayout ll_zidingyi;
    private EditText et_custom;
    private TextView tv_grade;
    private String time = "";

    private String userName;
    private String departmentName;
    private String leaderName;
    private String approverName;
    private String discovererName;
    private String discovererId;
    private String extraMoney;
    private String showtime;
    private String behavior;
    private String extraType;
    private int fileId;
    private String fileName;
    private String taskId;
    private String taskType;
    private String clauseDescription;
    private String levelId;
    private String type;
    private String jiuweiname;
    private String jiuweiid;

    private String departmentId = "";//责任单位ID
    private String departmenUserId = "";//责任人ID
    private String leaderId = "";//领导ID
    private String approverId = "";//审核人ID
    private String ids = "";//不安全行为ids
    private String additIds = "";//额外惩罚
    private String grade = "";//自定义等级
    private String number;
    private String responsibleLeaderId;
    private ArrayList<DisobeyInfoBean.DataBean.DisobeytaskdocBean> disobeytaskdoc = new ArrayList<>();
    //三违单不安全行为列表
    private ArrayList<DisobeyInfoBean.DataBean.TaskclauselistBean> taskclauselist = new ArrayList<>();
    private ArrayList<UnsafeBehaviorInfoBean.DataBean.ListBean> mList = new ArrayList<>();
    private RelativeLayout rl_leixing;
    private TextView tv_leixing;
    private String unsafeBehaviorid;

    private ArrayList<String> disobeyLeaderid = new ArrayList<>();
    private ArrayList<String> disobeyLeadername = new ArrayList<>();

    private boolean choice = true;//标准or自定义

    private String region;
    private String region_id;
    private String classTime;

    @Override
    protected int setLayout(LayoutInflater inflater) {
        return R.layout.fragment_rectifying_violations;
    }


    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void init(Bundle savedInstanceState) {
        getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        rl_1 = mRootView.findViewById(R.id.rl_1);
        rl_2 = mRootView.findViewById(R.id.rl_2);
        rl_3 = mRootView.findViewById(R.id.rl_3);
        rl_4 = mRootView.findViewById(R.id.rl_4);
        rl_5 = mRootView.findViewById(R.id.rl_5);
        rl_6 = mRootView.findViewById(R.id.rl_6);
        rl_8 = mRootView.findViewById(R.id.rl_8);
        rl_9 = mRootView.findViewById(R.id.rl_9);
        et_economic = mRootView.findViewById(R.id.et_economic);
        et_sanweiren = mRootView.findViewById(R.id.et_sanweiren);
        tv_banci = mRootView.findViewById(R.id.tv_banci);
        tv_quyu = mRootView.findViewById(R.id.tv_quyu);

        tv_num1 = mRootView.findViewById(R.id.tv_num1);
        tv_num2 = mRootView.findViewById(R.id.tv_num2);
        tv_num3 = mRootView.findViewById(R.id.tv_num3);
        tv_num4 = mRootView.findViewById(R.id.tv_num4);
        tv_shenhe = mRootView.findViewById(R.id.tv_shenhe);
        tv_time = mRootView.findViewById(R.id.tv_time);
        et_edit = mRootView.findViewById(R.id.et_edit);
        rv_list = mRootView.findViewById(R.id.rv_list);
        btn_complete = mRootView.findViewById(R.id.btn_complete);
        switch_select = mRootView.findViewById(R.id.switch_select);
        ll_add = mRootView.findViewById(R.id.ll_add);
        rv_entry_list = mRootView.findViewById(R.id.rv_entry_list);
        btn_complete = mRootView.findViewById(R.id.btn_complete);
        rv_entry_additional_list = mRootView.findViewById(R.id.rv_entry_additional_list);

        tv_left = mRootView.findViewById(R.id.tv_left);
        tv_right = mRootView.findViewById(R.id.tv_right);
        tv_tab_left = mRootView.findViewById(R.id.tv_tab_left);
        tv_tab_right = mRootView.findViewById(R.id.tv_tab_right);
        rl_buanquan = mRootView.findViewById(R.id.rl_buanquan);
        ll_zidingyi = mRootView.findViewById(R.id.ll_zidingyi);
        et_custom = mRootView.findViewById(R.id.et_custom);
        rl_custom = mRootView.findViewById(R.id.rl_custom);
        tv_grade = mRootView.findViewById(R.id.tv_grade);

        rl_leixing = mRootView.findViewById(R.id.rl_leixing);
        tv_leixing = mRootView.findViewById(R.id.tv_leixing);

        tv_left.setOnClickListener(this);
        tv_right.setOnClickListener(this);
        rl_custom.setOnClickListener(this);
        rl_1.setOnClickListener(this);
        rl_2.setOnClickListener(this);
        rl_3.setOnClickListener(this);
        rl_4.setOnClickListener(this);
        rl_5.setOnClickListener(this);
        rl_6.setOnClickListener(this);
        rl_8.setOnClickListener(this);
        rl_9.setOnClickListener(this);
        ll_add.setOnClickListener(this);
        btn_complete.setOnClickListener(this);
        rl_leixing.setOnClickListener(this);
        type = getActivity().getIntent().getStringExtra("type");

        if (type.equals("2")) {
            userName = getActivity().getIntent().getStringExtra("userName");
            tv_num1.setText(userName);
            departmentName = getActivity().getIntent().getStringExtra("departmentName");
            tv_num2.setText(departmentName);
            leaderName = getActivity().getIntent().getStringExtra("leaderName");
            tv_num3.setText(leaderName);
            approverName = getActivity().getIntent().getStringExtra("approverName");
            tv_shenhe.setText(approverName);
//            discovererName = getActivity().getIntent().getStringExtra("discovererName");
//            tv_num4.setText(discovererName);
            extraMoney = getActivity().getIntent().getStringExtra("extraMoney");
            et_economic.setText(extraMoney);
            showtime = getActivity().getIntent().getStringExtra("showtime");
            tv_time.setText(showtime);
            behavior = getActivity().getIntent().getStringExtra("behavior");
            et_edit.setText(behavior);
            extraType = getActivity().getIntent().getStringExtra("extraType");
            //三违单图片列表
            disobeytaskdoc = (ArrayList<DisobeyInfoBean.DataBean.DisobeytaskdocBean>) getActivity().getIntent().getSerializableExtra("disobeytaskdoc");
            //三违单不安全行为列表
            taskclauselist = (ArrayList<DisobeyInfoBean.DataBean.TaskclauselistBean>) getActivity().getIntent().getSerializableExtra("taskclauselist");
            if (taskclauselist.size() != 0) {
                for (int i = 0; i < taskclauselist.size(); i++) {
                    taskclauselist.get(i).getClauseDescription();
                    taskclauselist.get(i).getLevelId();
                    taskclauselist.get(i).getClauseId();
                    UnsafeBehaviorInfoBean.DataBean.ListBean listBean = new UnsafeBehaviorInfoBean.DataBean.ListBean();
                    listBean.setDescription(taskclauselist.get(i).getClauseDescription());
                    listBean.setLevelId(taskclauselist.get(i).getLevelId());
                    listBean.setId(taskclauselist.get(i).getClauseId());
                    mList.add(listBean);
                }
            }
            Unsafe();
            taskType = getActivity().getIntent().getStringExtra("taskType");
            Log.e("标准化和自定义", taskType);
            clauseDescription = getActivity().getIntent().getStringExtra("clauseDescription");
            levelId = getActivity().getIntent().getStringExtra("levelId");
            departmenUserId = getActivity().getIntent().getStringExtra("responsibleUserId");
            departmentId = getActivity().getIntent().getStringExtra("departmentId");
            number = getActivity().getIntent().getStringExtra("number");
            responsibleLeaderId = getActivity().getIntent().getStringExtra("responsibleLeaderId");
            approverId = getActivity().getIntent().getStringExtra("approverId");
            taskId = getActivity().getIntent().getStringExtra("taskId");
            if (taskType.equals("2")) {
                choice = false;
                tv_tab_left.setVisibility(View.INVISIBLE);
                tv_tab_right.setVisibility(View.VISIBLE);
                rl_buanquan.setVisibility(View.GONE);
                ll_zidingyi.setVisibility(View.VISIBLE);
                tv_left.setTextColor(getActivity().getColor(R.color.black));
                tv_right.setTextColor(getActivity().getColor(R.color.bule));
                if (levelId.equals("1")) {
                    tv_grade.setText("一般");
                } else if (levelId.equals("2")) {
                    tv_grade.setText("重大");
                }
                et_custom.setText(clauseDescription);
            } else {
                choice = true;
            }
        }

//        if (null != UserBeans.getInstance() && !TextUtils.isEmpty(UserBeans.getInstance().getUser().getName())) {
//            tv_num4.setText(UserBeans.getInstance().getUser().getName());
//        }
        refreshView();
    }

    @Override
    protected BaseRefreshLoadMoreInterface setRefreshLoadMoreListener() {
        return null;
    }

    //刷新view
    private void refreshView() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(BaseLinkList.apiurl, BaseLinkList.coal_mine + BaseLinkList.disobeyinit);
        mRetrofit.JsonToColliery(BaseLinkList.Base_Url, hashMap, new BaseSubscriber() {
            @Override
            public void onError(ExceptionHandle.ResponeThrowable e) {

            }

            @Override
            public void onSuccess(JSONObject jsonObject) {
                ReviewerBean reviewerBean = FastJsonTools.getBean(jsonObject.toString(), ReviewerBean.class);
                ArrayList<ReviewerBean.DataBean.ExtralistBean> extralist = reviewerBean.getData().getExtralist();
                if (!TextUtils.isEmpty(extraType)) {
                    for (int i = 0; i < extralist.size(); i++) {
                        if (extraType.indexOf(extralist.get(i).getId() + "") != -1) {
                            extralist.get(i).setSelect(true);
                        }
                    }
                }
                RecyclerViewUtils.initGridNoSc(getActivity(), rv_entry_additional_list, R.layout.item_select_additional, extralist, new OnGlobalListener() {
                    @Override
                    public <T> void logic(BaseViewHolder helper, List<T> mData, T item, BaseQuickAdapter mAdapter) {

                        ReviewerBean.DataBean.ExtralistBean extralistBean = (ReviewerBean.DataBean.ExtralistBean) item;

                        CheckBox cbox = helper.getView(R.id.cbox);
                        TextView tv_child_title = helper.getView(R.id.tv_child_title);
                        cbox.setChecked(extralistBean.isSelect());
                        tv_child_title.setText(extralistBean.getName());
                    }
                }, new BaseQuickAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                        ReviewerBean.DataBean.ExtralistBean extralistBean = (ReviewerBean.DataBean.ExtralistBean) adapter.getData().get(position);
                        extralistBean.setSelect(!extralistBean.isSelect());
                        adapter.notifyItemChanged(position);

                    }
                }, 3, null);
            }
        });

        if (type.equals("2")) {
            ArrayList<UpLoadImageBean.ResultMapsBean> mArray = new ArrayList<>();
            UpLoadImageBean.ResultMapsBean imgBean = null;
            if (null != disobeytaskdoc && disobeytaskdoc.size() != 0) {
                for (int i = 0; i < disobeytaskdoc.size(); i++) {
                    fileId = disobeytaskdoc.get(i).getFileId();
                    fileName = disobeytaskdoc.get(i).getFileName();
                    imgBean = new UpLoadImageBean.ResultMapsBean();
                    imgBean.setFileName(fileName);
                    imgBean.setFileId(fileId);
                    imgBean.setUrl(disobeytaskdoc.get(i).getUrl());
                    mArray.add(imgBean);
                }
                imgBean = new UpLoadImageBean.ResultMapsBean();
                imgBean.setCurCode(9999);
                mArray.add(imgBean);
            } else {
                imgBean = new UpLoadImageBean.ResultMapsBean();
                imgBean.setCurCode(9999);
//            mArray = new ArrayList<>();
                mArray.add(imgBean);
            }


            RecyclerViewUtils.initGridNoSc(getActivity(), rv_list, R.layout.item_image, mArray, new OnGlobalListener() {
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
                        Glide.with(getActivity()).load(BaseLinkList.Base_Url + "?" + BaseLinkList.apiurl + "=" + BaseLinkList.coal_mine + "/upload/" + data.getFileName()).into(iv_icon);
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
                        PhotoPopupManager.getInstance().show(getActivity());
                        PhotoPopupManager.getInstance().setOnPhotoSelectedListener(new PhotoPopupManager.OnPhotoSelectedListener() {
                            @Override
                            public void onPhotoSelected(String photoPath, int callBack_location) {
                                //返回path
                                LogUtils.e("返回Path:" + photoPath);
                                if (TextUtils.isEmpty(photoPath)) {
                                    return;
                                }

                                File file = new File(photoPath);
                                final BaseActivity activity = (BaseActivity) getActivity();
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
                    final BaseActivity activity = (BaseActivity) getActivity();
                    activity.showLoadDialog();
                    UpLoadImageBean.ResultMapsBean img = (UpLoadImageBean.ResultMapsBean) adapter.getData().get(position);
                    HashMap<String, String> hashMap = new HashMap<>();
                    hashMap.put("fileId", "" + img.getFileId());
                    hashMap.put("taskid", taskId);
                    hashMap.put(BaseLinkList.apiurl, BaseLinkList.coal_mine + BaseLinkList.DisobeyDeletePic);
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
        } else {
            ArrayList<UpLoadImageBean.ResultMapsBean> mArray = new ArrayList<>();
            UpLoadImageBean.ResultMapsBean imgBean = null;
            if (null != disobeytaskdoc && disobeytaskdoc.size() != 0) {
                for (int i = 0; i < disobeytaskdoc.size(); i++) {
                    fileId = disobeytaskdoc.get(i).getFileId();
                    fileName = disobeytaskdoc.get(i).getFileName();
                    imgBean = new UpLoadImageBean.ResultMapsBean();
                    imgBean.setFileName(fileName);
                    imgBean.setFileId(fileId);
                    imgBean.setUrl(disobeytaskdoc.get(i).getUrl());
                    mArray.add(imgBean);
                }
                imgBean = new UpLoadImageBean.ResultMapsBean();
                imgBean.setCurCode(9999);
                mArray.add(imgBean);
            } else {
                imgBean = new UpLoadImageBean.ResultMapsBean();
                imgBean.setCurCode(9999);
//            mArray = new ArrayList<>();
                mArray.add(imgBean);
            }


            RecyclerViewUtils.initGridNoSc(getActivity(), rv_list, R.layout.item_image, mArray, new OnGlobalListener() {
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
                        Glide.with(getActivity()).load(BaseLinkList.Base_Url + "?" + BaseLinkList.apiurl + "=" + BaseLinkList.coal_mine + "/upload/" + data.getFileName()).into(iv_icon);
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
                        PhotoPopupManager.getInstance().show(getActivity());
                        PhotoPopupManager.getInstance().setOnPhotoSelectedListener(new PhotoPopupManager.OnPhotoSelectedListener() {
                            @Override
                            public void onPhotoSelected(String photoPath, int callBack_location) {
                                //返回path
                                LogUtils.e("返回Path:" + photoPath);
                                if (TextUtils.isEmpty(photoPath)) {
                                    return;
                                }

                                File file = new File(photoPath);
                                final BaseActivity activity = (BaseActivity) getActivity();
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
                    final BaseActivity activity = (BaseActivity) getActivity();
                    activity.showLoadDialog();
                    UpLoadImageBean.ResultMapsBean img = (UpLoadImageBean.ResultMapsBean) adapter.getData().get(position);
                    HashMap<String, String> hashMap = new HashMap<>();
                    hashMap.put("fileId", "" + img.getFileId());
                    hashMap.put(BaseLinkList.apiurl, BaseLinkList.coal_mine + BaseLinkList.getDeletePic);
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

    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (resultCode) {
            case SelectPersonnelActivity.RectifyingCode:
                //带回数据
                String depName = data.getStringExtra("depName");
                departmentId = data.getStringExtra("departmentId");
                departmenUserId = data.getStringExtra("departmenUserId");
                leaderId = data.getStringExtra("leaderId");
                String leaderName = data.getStringExtra("leaderName");
                String departmenUser = data.getStringExtra("departmenUser");

                tv_num1.setText(departmenUser);
                tv_num2.setText(depName);
                tv_num3.setText(leaderName);

                break;
            case UnsafeBehaviorActivity.RectifyingCode:
                setFile(data);
                break;
            case SelectReviewerActivity.RectifyingCode:
                //带回数据
                approverId = data.getStringExtra("approverId");
                approverName = data.getStringExtra("approverName");
                tv_shenhe.setText(approverName);
                break;
            case JWcustomActivity.RectifyingCode:
                //带回数据
                grade = data.getStringExtra("grade");
                if (grade.equals("1")) {
                    tv_grade.setText("一般");
                } else if (grade.equals("2")) {
                    tv_grade.setText("重大");
                }
                break;
            case DisobeyLeaderActivity.HiddenDangerCode:
                //带回数据
                if (data != null) {
                    Bundle bundle = data.getBundleExtra("bundle");
                    DisobeyLeaderActivity.TestBean testBean = (DisobeyLeaderActivity.TestBean) bundle.getSerializable("disobeyLeader");
                    ArrayList<DisobeyLeaderBean.DataBean.ListBean.ResultsBean> resultsBeans = testBean.arrayList;
                    if (disobeyLeaderid.size() > 0 && disobeyLeaderid != null) {
                        disobeyLeaderid.clear();
                        disobeyLeadername.clear();
                    }
                    for (int i = 0; i < resultsBeans.size(); i++) {
                        disobeyLeadername.add(resultsBeans.get(i).getName());
                        disobeyLeaderid.add(resultsBeans.get(i).getUser_id() + "");
                        String name = String.valueOf(disobeyLeadername).replace("[", "").replace("]", "").replace(" ", "");
                        tv_num3.setText(name);
                    }
                }
                break;
            case JiuWeiTypeActivity.RectifyingCode:
                if (data != null) {
                    jiuweiname = data.getStringExtra("jiuweiname");
                    jiuweiid = data.getStringExtra("jiuweiid");
                    tv_leixing.setText(jiuweiname);
                }
                break;
            case InspectorActivity.HiddenDangerCode:
                if (data != null) {
                    discovererName = data.getStringExtra("Inspectorname");
                    discovererId = data.getStringExtra("Inspectorid");
                    tv_num4.setText(discovererName);
                }
                break;
            case HiddenDangerRegionActivity.HiddenDangerCode:
                //带回数据
                region = data.getStringExtra("隐患区域");
                region_id = data.getStringExtra("隐患区域id");
                tv_quyu.setText(region);
                break;
            case ShiftsNameActivity.HiddenDangerCode:
                classTime = data.getStringExtra("classTime");
                tv_banci.setText(classTime + "点");
                break;
            default:
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    private void setFile(Intent data) {
        if (data != null) {
            //带回数据
            unsafeBehaviorid = data.getStringExtra("unsafeBehaviorid");
            ids = data.getStringExtra("ids");
            Bundle bundle = data.getBundleExtra("bundle");
            UnsafeBehaviorActivity.TestBean curBean = (UnsafeBehaviorActivity.TestBean) bundle.getSerializable("databean");
            mList = curBean.arrayList;
            UnsafeBehaviorInfoBean.DataBean.ListBean listBean = null;
            if (null != taskclauselist && taskclauselist.size() != 0) {
                for (int i = 0; i < taskclauselist.size(); i++) {
                    int levelId = taskclauselist.get(i).getLevelId();
                    String clauseDescription = taskclauselist.get(i).getClauseDescription();
                    int id = taskclauselist.get(i).getId();
                    listBean = new UnsafeBehaviorInfoBean.DataBean.ListBean();
                    listBean.setLevelId(levelId);
                    listBean.setDescription(clauseDescription);
                    listBean.setId(id);
                    mList.add(listBean);
                }
            }
            if (mList.size() != 0 && mList != null) {
                StringBuffer stringBuffer = new StringBuffer();
                for (int i = 0; i < mList.size(); i++) {
                    stringBuffer.append(i + 1).append(":").append(mList.get(i).getDescription());
                }
                et_edit.setText(stringBuffer.toString());
            }
        } else {
            UnsafeBehaviorInfoBean.DataBean.ListBean listBean = null;
            unsafeBehaviorid = data.getStringExtra("unsafeBehaviorid");
            if (null != taskclauselist && taskclauselist.size() != 0) {
                for (int i = 0; i < taskclauselist.size(); i++) {
                    int levelId = taskclauselist.get(i).getLevelId();
                    String clauseDescription = taskclauselist.get(i).getClauseDescription();
                    int id = taskclauselist.get(i).getId();
                    listBean = new UnsafeBehaviorInfoBean.DataBean.ListBean();
                    listBean.setLevelId(levelId);
                    listBean.setDescription(clauseDescription);
                    listBean.setId(id);
                    mList.add(listBean);
                }
            }
        }

        Unsafe();

    }

    private void Unsafe() {
        //不安全行为列表
        RecyclerViewUtils.initLinerNoSc(getActivity(), rv_entry_list, R.layout.item_unsafe_jiuwei, mList, new OnGlobalListener() {
            @Override
            public <T> void logic(BaseViewHolder helper, List<T> mData, T item, BaseQuickAdapter mAdapter) {
                UnsafeBehaviorInfoBean.DataBean.ListBean mCurList = (UnsafeBehaviorInfoBean.DataBean.ListBean) item;

                TextView tv_text = helper.getView(R.id.tv_text);
                ImageView iv_chengdu = helper.getView(R.id.tv_chengdu);
                helper.addOnClickListener(R.id.tv_delete);

                tv_text.setText(mCurList.getDescription());

                if (mCurList.getLevelId() == 1) {
                    iv_chengdu.setImageResource(R.drawable.jiuwei_yiban);
                } else if (mCurList.getLevelId() == 2) {
                    iv_chengdu.setImageResource(R.drawable.jiuwei_zhongda);
                }
            }
        }, null, new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                UnsafeBehaviorInfoBean.DataBean.ListBean mCurList = (UnsafeBehaviorInfoBean.DataBean.ListBean) adapter.getData().get(position);

                mList.remove(position);
                Log.d("ids", mList.size() + "");
                adapter.notifyItemRemoved(position);

            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.rl_custom://自定义三违等级
                startActivityForResult(new Intent(getActivity(), JWcustomActivity.class), JWcustomActivity.RectifyingCode);
                break;
            case R.id.tv_left://不安全隐患
                choice = true;
                tv_tab_left.setVisibility(View.VISIBLE);
                tv_tab_right.setVisibility(View.INVISIBLE);
                rl_buanquan.setVisibility(View.VISIBLE);
                ll_zidingyi.setVisibility(View.GONE);
                tv_left.setTextColor(getActivity().getColor(R.color.bule));
                tv_right.setTextColor(getActivity().getColor(R.color.black));
                et_custom.setText("");
                break;
            case R.id.tv_right://自定义录入
                choice = false;
                tv_tab_left.setVisibility(View.INVISIBLE);
                tv_tab_right.setVisibility(View.VISIBLE);
                rl_buanquan.setVisibility(View.GONE);
                ll_zidingyi.setVisibility(View.VISIBLE);
                tv_left.setTextColor(getActivity().getColor(R.color.black));
                tv_right.setTextColor(getActivity().getColor(R.color.bule));
                break;
            case R.id.rl_leixing://自定义三违类型
                startActivityForResult(new Intent(getActivity(), JiuWeiTypeActivity.class), JiuWeiTypeActivity.RectifyingCode);
                break;
            case R.id.rl_1://责任人
                Intent intent = new Intent(getActivity(), SelectPersonnelActivity.class);
                intent.putExtra("jumpCode", SelectPersonnelActivity.RectifyingCode);
                intent.putExtra("title", "选择人员");
                intent.putExtra("type", "1");
                startActivityForResult(intent, SelectPersonnelActivity.RectifyingCode);
                break;
            case R.id.rl_2://责任单位
//                Intent intent1 = new Intent(getActivity(),SelectPersonnelActivity.class);
//                intent1.putExtra("jumpCode",SelectPersonnelActivity.RectifyingCode);
//                intent1.putExtra("title","选择单位");
//                startActivityForResult(intent1,SelectPersonnelActivity.RectifyingCode);
                break;
            case R.id.rl_3://责任领导
                if (departmentId == null || TextUtils.isEmpty(departmentId)) {
                    Toast.makeText(getActivity(), "请先选择负责人", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent2 = new Intent(getActivity(), DisobeyLeaderActivity.class);
                    intent2.putExtra("departmentId", departmentId);
                    startActivityForResult(intent2, DisobeyLeaderActivity.HiddenDangerCode);
                }
                break;
            case R.id.rl_4://审核人
                startActivityForResult(new Intent(getActivity(), SelectReviewerActivity.class), SelectReviewerActivity.RectifyingCode);
                break;
            case R.id.rl_5:
                new DatePickerDialog(getActivity(),
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
                                String times = new SimpleDateFormat("HH:mm:ss").format(new Date());


                                time = year + "-" + (monthOfYear + 1) + "-" + dayOfMonth + " " + times;


                                tv_time.setText(time);
                            }
                        }
                        // 设置初始日期
                        , Calendar.getInstance().get(Calendar.YEAR)
                        , Calendar.getInstance().get(Calendar.MONTH)
                        , Calendar.getInstance().get(Calendar.DAY_OF_MONTH)).show();
                break;
            case R.id.rl_6:
                startActivityForResult(new Intent(getActivity(), InspectorActivity.class), InspectorActivity.HiddenDangerCode);
                break;
            case R.id.rl_8://班次
                startActivityForResult(new Intent(getActivity(), ShiftsNameActivity.class), ShiftsNameActivity.HiddenDangerCode);
                break;
            case R.id.rl_9://区域
                startActivityForResult(new Intent(getActivity(), HiddenDangerRegionActivity.class), HiddenDangerRegionActivity.HiddenDangerCode);
                break;
            case R.id.ll_add://添加entry
                disobeyLeaderid.clear();
                startActivityForResult(new Intent(getActivity(), UnsafeBehaviorActivity.class), UnsafeBehaviorActivity.RectifyingCode);
                break;
            case R.id.btn_complete://确定
                //组合参数
                if (type.equals("1")) {//1  第一次三违录入  2驳回后重新的三违录入
                    if (choice == true) {//true 标准  f  自定义
                        if (TextUtils.isEmpty(departmentId)) {
                            ToastUtils.showShort("请选择责任人");
                            return;
                        }
                        if (TextUtils.isEmpty(approverName)) {
                            ToastUtils.showShort("请选择审核人");
                            return;
                        }
                        if (TextUtils.isEmpty(time)) {
                            ToastUtils.showShort("请选择责录入时间");
                            return;
                        }
                        if (TextUtils.isEmpty(discovererId)) {
                            ToastUtils.showShort("请选择检查人");
                            return;
                        }
                        if (mList.size() == 0) {
                            ToastUtils.showShort("请选择责不安全行为");
                            return;
                        }
                        if (TextUtils.isEmpty(et_economic.getText().toString())) {
                            ToastUtils.showShort("请填写经济处罚");
                            return;
                        }
                        if (TextUtils.isEmpty(et_edit.getText().toString())) {
                            ToastUtils.showShort("请填写行为描述");
                            return;
                        }
                    } else {
                        if (TextUtils.isEmpty(departmentId)) {
                            ToastUtils.showShort("请选择责任人");
                            return;
                        }
                        if (TextUtils.isEmpty(approverName)) {
                            ToastUtils.showShort("请选择审核人");
                            return;
                        }
                        if (TextUtils.isEmpty(time)) {
                            ToastUtils.showShort("请选择责录入时间");
                            return;
                        }
                        if (TextUtils.isEmpty(discovererId)) {
                            ToastUtils.showShort("请选择检查人");
                            return;
                        }
                        if (TextUtils.isEmpty(grade)) {
                            ToastUtils.showShort("请选择三违程度");
                            return;
                        }
                        if (TextUtils.isEmpty(jiuweiid)) {
                            ToastUtils.showShort("请选择三违类型");
                            return;
                        }
                        if (TextUtils.isEmpty(et_custom.getText().toString().trim())) {
                            ToastUtils.showShort("请输入处罚依据");
                            return;
                        }
                        if (TextUtils.isEmpty(et_economic.getText().toString())) {
                            ToastUtils.showShort("请填写经济处罚");
                            return;
                        }
                        if (TextUtils.isEmpty(et_edit.getText().toString())) {
                            ToastUtils.showShort("请填写行为描述");
                            return;
                        }
                    }
                    additIds = "";
                    BaseQuickAdapter additAdapter = (BaseQuickAdapter) rv_entry_additional_list.getAdapter();
                    if (additAdapter != null) {
                        ArrayList<ReviewerBean.DataBean.ExtralistBean> additArray = (ArrayList<ReviewerBean.DataBean.ExtralistBean>) additAdapter.getData();
                        for (ReviewerBean.DataBean.ExtralistBean extraListBean : additArray) {
                            if (extraListBean.isSelect()) {
                                additIds += extraListBean.getId() + ",";
                            }
                        }

                        if (!TextUtils.isEmpty(additIds)) {
                            additIds = additIds.substring(0, additIds.length() - 1);
                        } else {
//                        ToastUtils.showShort("至少选择一项额外惩罚");
//                        return;
                        }
                        showLoadDialog();
                        mRetrofit.JsonToColliery(BaseLinkList.Base_Url, initJson(), new BaseSubscriber() {
                            @Override
                            public void onError(ExceptionHandle.ResponeThrowable e) {
                                dismissDialog();

                            }

                            @Override
                            public void onSuccess(JSONObject jsonObject) throws JSONException {
                                dismissDialog();
                                LogUtils.e("三违提交->>" + jsonObject.toString());
                                //{"msg":"成功","resultMaps":[],"code":"200","data":{"flog":true}}
                                if (jsonObject.get("code").equals("200")) {
                                    ToastUtils.showShort("提交成功!");
                                    getActivity().finish();
                                } else {
                                    ToastUtils.showShort(jsonObject.getString("msg"));
                                }
                            }
                        });
                    } else {
                        ToastUtils.showShort("提交出错");
                    }
                } else if (type.equals("2")) {
                    if (taskType.equals("1")) {
                        if (choice == true) {//true 标准  f  自定义
                            if (TextUtils.isEmpty(departmentId)) {
                                ToastUtils.showShort("请选择责任人");
                                return;
                            }
                            if (TextUtils.isEmpty(approverName)) {
                                ToastUtils.showShort("请选择审核人");
                                return;
                            }
                            if (TextUtils.isEmpty(time) && TextUtils.isEmpty(showtime)) {
                                ToastUtils.showShort("请选择责录入时间");
                                return;
                            }
                            if (TextUtils.isEmpty(discovererId)) {
                                ToastUtils.showShort("请选择检查人");
                                return;
                            }
                            if (mList.size() == 0) {
                                ToastUtils.showShort("请选择责不安全行为");
                                return;
                            }
                            if (TextUtils.isEmpty(et_economic.getText().toString()) || TextUtils.isEmpty(extraMoney)) {
                                ToastUtils.showShort("请填写经济处罚");
                                return;
                            }
                            if (TextUtils.isEmpty(et_edit.getText().toString())) {
                                ToastUtils.showShort("请填写行为描述");
                                return;
                            }
                        } else {
                            if (TextUtils.isEmpty(departmentId)) {
                                ToastUtils.showShort("请选择责任人");
                                return;
                            }
                            if (TextUtils.isEmpty(approverName)) {
                                ToastUtils.showShort("请选择审核人");
                                return;
                            }
                            if (TextUtils.isEmpty(time) && TextUtils.isEmpty(showtime)) {
                                ToastUtils.showShort("请选择责录入时间");
                                return;
                            }
                            if (TextUtils.isEmpty(discovererId)) {
                                ToastUtils.showShort("请选择检查人");
                                return;
                            }
                            if (TextUtils.isEmpty(grade) && TextUtils.isEmpty(levelId)) {
                                ToastUtils.showShort("请选择三违程度");
                                return;
                            }
                            if (TextUtils.isEmpty(jiuweiid)) {
                                ToastUtils.showShort("请选择三违类型");
                                return;
                            }
                            if (TextUtils.isEmpty(et_custom.getText().toString().trim())) {
                                ToastUtils.showShort("请输入处罚依据");
                                return;
                            }
                            if (TextUtils.isEmpty(et_economic.getText().toString()) || TextUtils.isEmpty(extraMoney)) {
                                ToastUtils.showShort("请填写经济处罚");
                                return;
                            }
                            if (TextUtils.isEmpty(et_edit.getText().toString())) {
                                ToastUtils.showShort("请填写行为描述");
                                return;
                            }
                        }
                    } else if (taskType.equals("2")) {
                        if (choice == true) {//true 标准  f  自定义
                            if (TextUtils.isEmpty(departmentId)) {
                                ToastUtils.showShort("请选择责任人");
                                return;
                            }
                            if (TextUtils.isEmpty(approverName)) {
                                ToastUtils.showShort("请选择审核人");
                                return;
                            }
                            if (TextUtils.isEmpty(time) && TextUtils.isEmpty(showtime)) {
                                ToastUtils.showShort("请选择责录入时间");
                                return;
                            }
                            if (TextUtils.isEmpty(discovererId)) {
                                ToastUtils.showShort("请选择检查人");
                                return;
                            }
                            if (mList.size() == 0) {
                                ToastUtils.showShort("请选择责不安全行为");
                                return;
                            }
                            if (TextUtils.isEmpty(et_economic.getText().toString()) || TextUtils.isEmpty(extraMoney)) {
                                ToastUtils.showShort("请填写经济处罚");
                                return;
                            }
                            if (TextUtils.isEmpty(et_edit.getText().toString())) {
                                ToastUtils.showShort("请填写行为描述");
                                return;
                            }
                        } else {
                            if (TextUtils.isEmpty(departmentId)) {
                                ToastUtils.showShort("请选择责任人");
                                return;
                            }
                            if (TextUtils.isEmpty(approverName)) {
                                ToastUtils.showShort("请选择审核人");
                                return;
                            }
                            if (TextUtils.isEmpty(time) && TextUtils.isEmpty(showtime)) {
                                ToastUtils.showShort("请选择责录入时间");
                                return;
                            }
                            if (TextUtils.isEmpty(discovererId)) {
                                ToastUtils.showShort("请选择检查人");
                                return;
                            }
                            if (TextUtils.isEmpty(grade) && TextUtils.isEmpty(levelId)) {
                                ToastUtils.showShort("请选择三违程度");
                                return;
                            }
                            if (TextUtils.isEmpty(jiuweiid)) {
                                ToastUtils.showShort("请选择三违类型");
                                return;
                            }
                            if (TextUtils.isEmpty(et_custom.getText().toString().trim())) {
                                ToastUtils.showShort("请输入处罚依据");
                                return;
                            }
                            if (TextUtils.isEmpty(et_economic.getText().toString()) || TextUtils.isEmpty(extraMoney)) {
                                ToastUtils.showShort("请填写经济处罚");
                                return;
                            }
                            if (TextUtils.isEmpty(et_edit.getText().toString())) {
                                ToastUtils.showShort("请填写行为描述");
                                return;
                            }
                        }
                    }
                    additIds = "";
                    BaseQuickAdapter additAdapter = (BaseQuickAdapter) rv_entry_additional_list.getAdapter();
                    if (additAdapter != null) {
                        ArrayList<ReviewerBean.DataBean.ExtralistBean> additArray = (ArrayList<ReviewerBean.DataBean.ExtralistBean>) additAdapter.getData();
                        for (ReviewerBean.DataBean.ExtralistBean extraListBean : additArray) {
                            if (extraListBean.isSelect()) {
                                additIds += extraListBean.getId() + ",";
                            }
                        }

                        if (!TextUtils.isEmpty(additIds)) {
                            additIds = additIds.substring(0, additIds.length() - 1);
                        } else {

                        }

                        showLoadDialog();
                        mRetrofit.JsonToColliery(BaseLinkList.Base_Url, initJson1(), new BaseSubscriber() {
                            @Override
                            public void onError(ExceptionHandle.ResponeThrowable e) {
                                dismissDialog();

                            }

                            @Override
                            public void onSuccess(JSONObject jsonObject) throws JSONException {
                                dismissDialog();
                                LogUtils.e("三违提交->>" + jsonObject.toString());
                                //{"msg":"成功","resultMaps":[],"code":"200","data":{"flog":true}}
                                if (jsonObject.get("code").equals("200")) {
                                    ToastUtils.showShort("提交成功!");
                                    startActivity(new Intent(getActivity(), RectifyingViolationsManagementActivity.class));
                                    getActivity().finish();
                                } else {
                                    ToastUtils.showShort(jsonObject.getString("msg"));
                                }
                            }
                        });
                    } else {
                        ToastUtils.showShort("提交出错");
                    }
                }
                break;
            default:
        }
    }

    private Map<String, String> initJson1() {
        HashMap<String, String> hashMap = new HashMap<>();

        try {
            if (switch_select.isChecked()) {
                hashMap.put("canAppeal", "1");
            } else {
                hashMap.put("canAppeal", "0");
            }
            if (TextUtils.isEmpty(et_custom.getText().toString().trim())) {
                //1三违源 2自定义
                hashMap.put("selecttype", "1");
            } else if (!TextUtils.isEmpty(et_custom.getText().toString().trim())) {
                //1三违源 2自定义
                hashMap.put("selecttype", "2");
                //自定义级别
                if (TextUtils.isEmpty(levelId)) {
                    hashMap.put("selectlevel", grade);
                } else {
                    hashMap.put("selectlevel", levelId);
                }
                //自定义内容
                hashMap.put("custompunishment", et_custom.getText().toString().trim());
            }
            hashMap.put("taskid", taskId);
            hashMap.put("number", number);
            //责任单位id
            hashMap.put("responsibleDepartmentId", departmentId);
            //责任单位
            hashMap.put("responsibleDepartmentName", tv_num2.getText().toString());
            //责任人ID
            hashMap.put("responsibleUserId", departmenUserId);
            //责任人姓名
            hashMap.put("responsibleUserName", tv_num1.getText().toString());
            //领导ID
            if (null == disobeyLeaderid || disobeyLeaderid.size() == 0) {
                hashMap.put("responsibleLeaderId", responsibleLeaderId);
            } else {
                String id = String.valueOf(disobeyLeaderid).replace("[", "").replace("]", "").replace(" ", "");
                hashMap.put("responsibleLeaderId", id);
            }
            //领导姓名
            hashMap.put("responsibleLeaderName", tv_num3.getText().toString());
            //不安全行为描述
            hashMap.put("behavior", et_edit.getText().toString());
            //审核人ID
            hashMap.put("approverId", approverId);
            //发现人
            hashMap.put("discovererName", discovererName);
            hashMap.put("discovererId", discovererId);
            if (jiuweiid != null) {
                //三违不安全行为ids目录
                hashMap.put("disobeyCategory", jiuweiid);
            }
            //三违不安全行为idsinfo条目
            JSONArray array = new JSONArray();
            for (int i = 0; i < mList.size(); i++) {
                array.put(mList.get(i).getId());
            }
            String clauseid = array.toString();
            String str = clauseid.substring(1, clauseid.length() - 1);
            hashMap.put("clauseid", str + "");
            //经济处罚
            hashMap.put("extraMoney", et_economic.getText().toString());
            //额外惩罚
            hashMap.put("extraTypes", additIds);
            hashMap.put("status", "2");
            //录入时间
            hashMap.put("creattime", time);
            hashMap.put(BaseLinkList.apiurl, BaseLinkList.coal_mine + BaseLinkList.disobeymodify);
            //上传的图片ids
            BaseQuickAdapter imageAdapter = (BaseQuickAdapter) rv_list.getAdapter();
            ArrayList<UpLoadImageBean.ResultMapsBean> imageArray = (ArrayList<UpLoadImageBean.ResultMapsBean>) imageAdapter.getData();
            if (imageArray.size() > 1) {
                String imgIds = "";
                for (UpLoadImageBean.ResultMapsBean resBean : imageArray) {
                    if (resBean.getFileId() != 0) {
                        imgIds += (resBean.getFileId() + ",");
                    }
                }
                imgIds = imgIds.substring(0, imgIds.length() - 1);
                LogUtils.e("剪切后图片ids->>" + imgIds);
                hashMap.put("fileidstr", imgIds);
            }

        } catch (Exception e) {
            LogUtils.e("初始化Json出错");
            return null;
        }
        return hashMap;
    }


    private HashMap<String, String> initJson() {
        HashMap<String, String> hashMap = new HashMap<>();

        try {
            if (switch_select.isChecked()) {
                hashMap.put("canAppeal", "1");
            } else {
                hashMap.put("canAppeal", "0");
            }

            if (choice == true) {
                //1三违源 2自定义
                hashMap.put("selecttype", "1");
            } else {
                //1三违源 2自定义
                hashMap.put("selecttype", "2");
                //自定义级别
                hashMap.put("selectlevel", grade);
                //自定义内容
                hashMap.put("custompunishment", et_custom.getText().toString().trim());
            }
            //责任单位
            hashMap.put("responsibleDepartmentId", departmentId);
            //责任单位
            hashMap.put("responsibleDepartmentName", tv_num2.getText().toString());
            //责任人ID
            hashMap.put("responsibleUserId", departmenUserId);
            //责任人姓名
            hashMap.put("responsibleUserName", tv_num1.getText().toString());
            //领导ID
            if (null == disobeyLeaderid || disobeyLeaderid.size() == 0) {
                hashMap.put("responsibleLeaderId", leaderId);
            } else {
                String id = String.valueOf(disobeyLeaderid).replace("[", "").replace("]", "").replace(" ", "");
                hashMap.put("responsibleLeaderId", id);
            }
            //领导姓名
            hashMap.put("responsibleLeaderName", tv_num3.getText().toString());
            //不安全行为描述
            hashMap.put("behavior", et_edit.getText().toString());
            //审核人ID
            hashMap.put("approverId", approverId);
            //发现人
            hashMap.put("discovererName", discovererName);
            hashMap.put("discovererId", discovererId);
            if (jiuweiid != null) {
                //三违不安全行为ids目录
                hashMap.put("disobeyCategory", jiuweiid);
            }
            //三违不安全行为idsifo
            JSONArray array = new JSONArray();
            for (int i = 0; i < mList.size(); i++) {
                array.put(mList.get(i).getId());
            }
            String clauseid = array.toString();
            String str = clauseid.substring(1, clauseid.length() - 1);
            hashMap.put("clauseid", str + "");
            //经济处罚
            hashMap.put("extraMoney", et_economic.getText().toString());
            //额外惩罚
            hashMap.put("extraTypes", additIds);
            hashMap.put("status", "2");
            //录入时间
            hashMap.put("creattime", time);
            hashMap.put(BaseLinkList.apiurl, BaseLinkList.coal_mine + BaseLinkList.disobeyadd);
            //上传的图片ids
            BaseQuickAdapter imageAdapter = (BaseQuickAdapter) rv_list.getAdapter();
            ArrayList<UpLoadImageBean.ResultMapsBean> imageArray = (ArrayList<UpLoadImageBean.ResultMapsBean>) imageAdapter.getData();
            if (imageArray.size() > 1) {
                String imgIds = "";
                for (UpLoadImageBean.ResultMapsBean resBean : imageArray) {
                    if (resBean.getFileId() != 0) {
                        imgIds += (resBean.getFileId() + ",");
                    }
                }

                imgIds = imgIds.substring(0, imgIds.length() - 1);
                LogUtils.e("剪切后图片ids->>" + imgIds);
                hashMap.put("fileidstr", imgIds);
            }

        } catch (Exception e) {
            LogUtils.e("初始化Json出错");
            return null;
        }
        return hashMap;
    }

}
