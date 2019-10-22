package com.lingjun.colliery_android.module.dealwith.hiddendanger.fragment;

import android.content.Intent;
import android.drm.DrmStore;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
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
import com.lingjun.colliery_android.bean.AcceptanceUnitBean;
import com.lingjun.colliery_android.bean.CooperativeSwitchBean;
import com.lingjun.colliery_android.bean.InputAcceptInfoBean;
import com.lingjun.colliery_android.bean.PersonLiableBean;
import com.lingjun.colliery_android.bean.UpLoadImageBean;
import com.lingjun.colliery_android.module.dealwith.hiddendanger.activity.AcceptanceUnitActivity;
import com.lingjun.colliery_android.module.dealwith.hiddendanger.activity.AcceptorActivity;
import com.lingjun.colliery_android.module.dealwith.hiddendanger.activity.HiddenDangeGradeActivity;
import com.lingjun.colliery_android.module.dealwith.hiddendanger.activity.PersonLiableActivity;
import com.lingjun.colliery_android.module.dealwith.hiddendanger.activity.ResponsibilityActivity;
import com.lingjun.colliery_android.module.dealwith.hiddendanger.activity.ShiftsNameActivity;
import com.lingjun.colliery_android.module.dealwith.hiddendanger.activity.SuperiorLeaderActivity;
import com.lingjun.colliery_android.module.dealwith.hiddendanger.general_hidden_danger.HiddenDangerNtryActivity;
import com.lingjun.colliery_android.module.main.SelectPersonnelActivity;
import com.lingjun.colliery_android.module.main.SelectReviewerActivity;
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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * 现场治理
 */
public class HiddenDangerOneFragment extends BaseFragment implements View.OnClickListener {
    private RelativeLayout rl_grade;//隐患等级
    private RelativeLayout rl_company;//责任单位
    private RelativeLayout rl_auditor;//审核人
    private RelativeLayout rl_cooperation;//协作单位
    private RelativeLayout rl_classTime;//隐患班次
    private RelativeLayout rl_technician;//技术员
    private RelativeLayout rl_person_liable;//整改人
    private RelativeLayout rl_SuperiorLeader;//上级领导
    private RelativeLayout rl_acceptor;//验收单位
    private RelativeLayout rl_acceptor_people;//验收人

    private TextView tv_grade;//隐患等级
    private EditText et_deduction;//扣分
    private EditText et_fine;//罚金
    private EditText et_content;//方案类型输入框
    private EditText et_content1;//方案内容输入框
    private TextView tv_acceptor;//验收单位
    private TextView tv_company;//责任单位
    private TextView tv_technician;//技术员
    private TextView tv_person_liable;//整改人
    private TextView tv_auditor;//审核人
    private TextView tv_cooperation;//协作单位
    private TextView tv_acceptor_people;

    private TextView tv_ntry_sure;//现场治理提交

    private String acceptor;
    private String acceptor2;
    private String details_time1;//前一页传来的录入时间
    private String technicianInfo;
    private String processorInfo;
    private String name;
    private String grade;
    private String technician_id;
    private String department_id;
    private String processor_id;
    private String leader_id;
    private String imgIds;//图片
    private String imgIds1;//图片
    private String slight;
    private String bohuitaskId;

    private RecyclerView rv_list;
    private RecyclerView rv_list1;

    private String userId;
    private String userName;
    private String dePartMentName;

    private String zrrname;
    private String zrrid;
    private String jsyname;
    private String jsyid;

    private ArrayList<String> id = new ArrayList<>();
    private String type;

    ArrayList<String> acceptanceunitid = new ArrayList<>();
    ArrayList<String> acceptanceid = new ArrayList<>();
    ArrayList<String> acceptorname = new ArrayList<>();
    ArrayList<String> acceptanceDepartmentsName = new ArrayList<>();

    private String rectificationPersonnelFlag;
    private String clauseMeasures;
    private String troubleLevelId;
    private String ysdwid;
    private String ysrid;
    private String ysdwname;
    private String ysrname;

    private TextView tv_classTime;
    private String classTime;
    private TextView tv_SuperiorLeader;//上级领导
    private TextView tv_zerenren;//责任人
    private String leaderInfo;
    private String responsibleLeaderId;
    private String responsibleLeaderinfo;

    //隐患录入传入的数据
    private String planId;//隐患录入计划id
    private String location;//隐患录入位置
    private String areaId;//隐患录入区域id
    private String areaName;//隐患录入区域名称
    private String sourceFolder;//隐患类型id
    private String sourceId;//隐患内容ID
    private String sourceDesc;//隐患内容
    private String clauseId;//检查标准id 默认0
    private String clauseDesc;//检查标准
    private String torubleMeasures;//隐患措施
    private String fileIds;//图片id
    private String addTime;//录入时间
    private String taskStatus;//任务状态（0草稿，1主任务）
    private String sourceMoney;//罚款
    private String sourceScore;//扣分
    private String hiddentype;
    //技术员开关
    private String technicalSwitch;
    private InputAcceptInfoBean infoBean;

    @Override
    protected int setLayout(LayoutInflater inflater) {
        return R.layout.fragment_hiddendanger0ne;
    }

    public static HiddenDangerOneFragment newInstance(InputAcceptInfoBean cooperativeSwitchBean) {
//        Bundle args = new Bundle();
//        HiddenDangerOneFragment fragment = new HiddenDangerOneFragment();
//        fragment.setArguments(args);
        HiddenDangerOneFragment fragment = new HiddenDangerOneFragment();
        fragment.infoBean = cooperativeSwitchBean;
        return fragment;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        rl_grade = mRootView.findViewById(R.id.rl_grade);
        rl_company = mRootView.findViewById(R.id.rl_company);
        rl_cooperation = mRootView.findViewById(R.id.rl_cooperation);
        rl_classTime = mRootView.findViewById(R.id.rl_classTime);

        rl_technician = mRootView.findViewById(R.id.rl_technician);
        rl_person_liable = mRootView.findViewById(R.id.rl_person_liable);
        rl_SuperiorLeader = mRootView.findViewById(R.id.rl_SuperiorLeader);
        rl_acceptor = mRootView.findViewById(R.id.rl_acceptor);
        rl_acceptor_people = mRootView.findViewById(R.id.rl_acceptor_people);


        et_deduction = mRootView.findViewById(R.id.et_deduction);
        et_fine = mRootView.findViewById(R.id.et_fine);
        et_content = mRootView.findViewById(R.id.et_content);
        et_content1 = mRootView.findViewById(R.id.et_content1);
        tv_acceptor = mRootView.findViewById(R.id.tv_acceptor);
        tv_ntry_sure = mRootView.findViewById(R.id.tv_ntry_sure);
        tv_grade = mRootView.findViewById(R.id.tv_grade);
        tv_company = mRootView.findViewById(R.id.tv_company);
        tv_technician = mRootView.findViewById(R.id.tv_technician);
        tv_person_liable = mRootView.findViewById(R.id.tv_person_liable);
        rl_auditor = mRootView.findViewById(R.id.rl_auditor);
        tv_auditor = mRootView.findViewById(R.id.tv_auditor);
        tv_cooperation = mRootView.findViewById(R.id.tv_cooperation);
        rv_list = mRootView.findViewById(R.id.rv_list);
        rv_list1 = mRootView.findViewById(R.id.rv_list1);
        tv_acceptor_people = mRootView.findViewById(R.id.tv_acceptor_people);


        tv_classTime = mRootView.findViewById(R.id.tv_classTime);
        tv_SuperiorLeader = mRootView.findViewById(R.id.tv_SuperiorLeader);
        tv_zerenren = mRootView.findViewById(R.id.tv_zerenren);

        rl_grade.setOnClickListener(this);
        rl_company.setOnClickListener(this);
        rl_auditor.setOnClickListener(this);
        rl_classTime.setOnClickListener(this);
        tv_ntry_sure.setOnClickListener(this);
        rl_cooperation.setOnClickListener(this);
        rl_technician.setOnClickListener(this);
        rl_person_liable.setOnClickListener(this);
        rl_SuperiorLeader.setOnClickListener(this);
        rl_acceptor.setOnClickListener(this);
        rl_acceptor_people.setOnClickListener(this);


        Intent getIntent = getActivity().getIntent();
//        acceptor = getIntent.getStringExtra("details_acceptor");//验收单位
//        acceptor2 = getIntent.getStringExtra("details_acceptor_2");//验收单位
//        clauseMeasures = getIntent.getStringExtra("clauseMeasures");
//        if (TextUtils.isEmpty(clauseMeasures)) {
//            et_content.setText("");
//        } else {
//            et_content.setText(clauseMeasures);
//        }
//        details_time1 = getIntent.getStringExtra("details_time1");
        if (infoBean != null) {
            if (infoBean.getData() != null) {
                if (infoBean.getData().getAcceptorInfo() != null) {
                    ysrid = infoBean.getData().getAcceptorInfo().getId() + "";//验收人id
                    ysrname = infoBean.getData().getAcceptorInfo().getName();//验收人name
                    tv_acceptor_people.setText(ysrname);
                }
                if (infoBean.getData().getAcceptDepartmentInfo() != null) {
                    ysdwid = infoBean.getData().getAcceptDepartmentInfo().get(0).getId() + "";//验收单位id
                    ysdwname = infoBean.getData().getAcceptDepartmentInfo().get(0).getName();//验收单位name
                    tv_acceptor.setText(ysdwname);
                }
                if (infoBean.getData().getApproverInfo() != null) {
                    userId = infoBean.getData().getApproverInfo().get(0).getUserId() + "";//审核人id
                    userName = infoBean.getData().getApproverInfo().get(0).getUserName();//审核人name
                    dePartMentName = infoBean.getData().getApproverInfo().get(0).getDePartMentName();
                    tv_auditor.setText(userName + "(" + dePartMentName + ")");
                }
            }
        }


        Bundle bundle = getIntent.getBundleExtra("bundle");
        //隐患录入计划id
        planId = bundle.getString("planId");
        location = bundle.getString("location");//隐患录入位置
        areaId = bundle.getString("areaId");//隐患录入区域id
        areaName = bundle.getString("areaName");//隐患录入区域名称
        sourceFolder = bundle.getString("sourceFolder");//隐患类型id
        sourceId = bundle.getString("sourceId");//隐患内容ID
        sourceDesc = bundle.getString("sourceDesc");//隐患内容
        clauseId = bundle.getString("clauseId");//检查标准id 默认0
        clauseDesc = bundle.getString("clauseDesc");//检查标准
        torubleMeasures = bundle.getString("torubleMeasures");//隐患措施
        fileIds = bundle.getString("fileIds");//图片id
        addTime = bundle.getString("addTime");//录入时间
        taskStatus = bundle.getString("taskStatus");//任务状态（0草稿，1主任务）
        sourceMoney = bundle.getString("sourceMoney");//罚款
        sourceScore = bundle.getString("sourceScore");//扣分
        hiddentype = bundle.getString("type");//正常 驳回录入判断
        if (hiddentype.equals("2")) {
            bohuitaskId = bundle.getString("bohuitaskId");
            LogUtils.e("现场治理接受bohuitaskId" + bohuitaskId);
        }
        et_deduction.setText(sourceScore);
        et_fine.setText(sourceMoney);

        refreshView();

    }

    private void refreshView() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(BaseLinkList.apiurl, BaseLinkList.coal_mine + BaseLinkList.getCollaborativeUnitsSwitch);

        mRetrofit.JsonToColliery(BaseLinkList.Base_Url, hashMap, new BaseSubscriber() {
            @Override
            public void onError(ExceptionHandle.ResponeThrowable e) {
            }

            @Override
            public void onSuccess(JSONObject jsonObject) {
                LogUtils.e("协同单位开关->>" + jsonObject.toString());
                final CooperativeSwitchBean cooperativeSwitchBean = FastJsonTools.getBean(jsonObject.toString(), CooperativeSwitchBean.class);
                if (null != cooperativeSwitchBean.getData()) {
                    technicalSwitch = cooperativeSwitchBean.getData().getTechnicalSwitch();
                }
            }
        });


        ArrayList<UpLoadImageBean.ResultMapsBean> mArray = new ArrayList<>();
        UpLoadImageBean.ResultMapsBean imgBean = new UpLoadImageBean.ResultMapsBean();
        imgBean.setCurCode(9999);
        mArray.add(imgBean);

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
//                    Glide.with(getActivity()).load(data.getUrl()).into(iv_icon);
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
                            HashMap<String, String> hashMap = new HashMap<>();
                            hashMap.put(BaseLinkList.apiurl, BaseLinkList.coal_mine + BaseLinkList.getUpload);
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

        ArrayList<UpLoadImageBean.ResultMapsBean> mArray1 = new ArrayList<>();
        UpLoadImageBean.ResultMapsBean imgBean1 = new UpLoadImageBean.ResultMapsBean();
        imgBean1.setCurCode(9999);
        mArray1.add(imgBean1);

        RecyclerViewUtils.initGridNoSc(getActivity(), rv_list1, R.layout.item_image, mArray1, new OnGlobalListener() {
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
//                    Glide.with(getActivity()).load(data.getUrl()).into(iv_icon);
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

    @Override
    protected BaseRefreshLoadMoreInterface setRefreshLoadMoreListener() {
        return null;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (resultCode) {
            case ResponsibilityActivity.RectifyingCode: //责任单位
                //带回数据
                if (data != null) {
                    technicianInfo = data.getStringExtra("technicianInfo");//技术人员
                    technician_id = data.getStringExtra("technician_id");//技术人员ID
                    Log.e("责任单位技术员==>", technician_id);
//                    processorInfo = data.getStringExtra("processorInfo");//整改人
                    department_id = data.getStringExtra("department_id");//部门ID
//                    processor_id = data.getStringExtra("processor_id");//整改人ID
                    leader_id = data.getStringExtra("leader_id");//领导人ID
                    leaderInfo = data.getStringExtra("leaderInfo");//部门领导
                    name = data.getStringExtra("name");//责任单位
                    rectificationPersonnelFlag = data.getStringExtra("rectificationPersonnelFlag");//责任人单选多选
                    responsibleLeaderId = data.getStringExtra("ResponsibleLeaderId");
                    responsibleLeaderinfo = data.getStringExtra("ResponsibleLeaderinfo");
                    if (TextUtils.isEmpty(technicianInfo)) {
                        tv_technician.setText("无技术员");
                    } else {
                        tv_technician.setText(technicianInfo);
                    }

//                    tv_person_liable.setText(processorInfo);
                    tv_company.setText(name);
                    tv_zerenren.setText(responsibleLeaderinfo);
                    tv_SuperiorLeader.setText(leaderInfo);
                }
                break;
            case HiddenDangeGradeActivity.RectifyingCode://隐患等级
                //带回数据
                if (data != null) {
                    grade = data.getStringExtra("name");
                    slight = data.getStringExtra("slight");
                    troubleLevelId = data.getStringExtra("troubleLevelId");
                    tv_grade.setText(grade);
                }
                break;
            case com.lingjun.colliery_android.module.dealwith.hiddendanger.activity.SelectReviewerActivity.HiddenDangerCode://审核人
                userId = data.getStringExtra("userId");
                userName = data.getStringExtra("userName");
                dePartMentName = data.getStringExtra("dePartMentName");
                tv_auditor.setText(userName + "(" + dePartMentName + ")");
                break;
            case PersonLiableActivity.RectifyingCode://责任人
                if (data != null) {
                    type = data.getStringExtra("type");
                    if (type.equals("0")) {
                        processor_id = data.getStringExtra("zrrid");
                        zrrname = data.getStringExtra("zrrname");
                        tv_person_liable.setText(zrrname);
                    } else if (type.equals("1")) {
                        Bundle bundle = data.getBundleExtra("bundle");
                        PersonLiableActivity.TestBean testBean = (PersonLiableActivity.TestBean) bundle.getSerializable("zrr");
                        ArrayList<PersonLiableBean.DataBean.PageBean.ResultsBean> resultsBeans = testBean.arrayList;
                        ArrayList<String> name = new ArrayList<>();
                        if (id.size() > 0 && id != null) {
                            id.clear();
                            name.clear();
                        }
                        for (int i = 0; i < resultsBeans.size(); i++) {
                            name.add(resultsBeans.get(i).getName());
                            id.add(resultsBeans.get(i).getUserid() + "");
                            String name1 = String.valueOf(name).replace("[", "").replace("]", "").replace(" ", "");
                            tv_person_liable.setText(name1 + "");
                            processor_id = String.valueOf(id).replace("[", "").replace("]", "").replace(" ", "");
                        }
                    } else if (type.equals("2")) {
                        technician_id = data.getStringExtra("jsyid");
                        Log.e("技术员==>", technician_id);
                        jsyname = data.getStringExtra("jsyname");
                        tv_technician.setText(jsyname);
                    }

                }
                break;
            case AcceptanceUnitActivity.HiddenDangerCode:   //验收单位
                //带回数据
                if (data != null) {
                    Bundle bundle = data.getBundleExtra("bundle");
                    AcceptanceUnitActivity.TestBean testBean = (AcceptanceUnitActivity.TestBean) bundle.getSerializable("acceptanceunit");
                    ArrayList<AcceptanceUnitBean.DataBean.ResultMapBean> resultsBeans = testBean.arrayList;
                    if (acceptanceunitid.size() > 0 && acceptanceunitid != null) {
                        acceptanceunitid.clear();
                        acceptanceDepartmentsName.clear();
                    }
                    for (int i = 0; i < resultsBeans.size(); i++) {
                        acceptanceDepartmentsName.add(resultsBeans.get(i).getName());
                        acceptanceunitid.add(resultsBeans.get(i).getId() + "");
                        ysdwname = String.valueOf(acceptanceDepartmentsName).replace("[", "").replace("]", "").replace("", "");
                        ysdwid = String.valueOf(acceptanceunitid).replace("[", "").replace("]", "").replace(" ", "");
                        tv_acceptor.setText(ysdwname);
                        ysrid = "";
                        ysrname = "";
                        tv_acceptor_people.setText("请选择");
                    }
                }
                break;
            case AcceptorActivity.HiddenDangerCode://验收人
                //带回数据
                if (data != null) {
                    Bundle bundle = data.getBundleExtra("bundle");
                    AcceptorActivity.TestBean testBean = (AcceptorActivity.TestBean) bundle.getSerializable("acceptance");
                    ArrayList<PersonLiableBean.DataBean.PageBean.ResultsBean> resultsBeans = testBean.arrayList;
                    if (acceptanceid.size() > 0 && acceptanceid != null) {
                        acceptanceid.clear();
                        acceptorname.clear();
                    }
                    for (int i = 0; i < resultsBeans.size(); i++) {
                        acceptorname.add(resultsBeans.get(i).getName());
                        acceptanceid.add(resultsBeans.get(i).getUserid() + "");
                        ysrname = String.valueOf(acceptorname).replace("[", "").replace("]", "").replace(" ", "");
                        ysrid = String.valueOf(acceptanceid).replace("[", "").replace("]", "").replace(" ", "");
                        tv_acceptor_people.setText(ysrname);
                    }
                }
                break;
            case SuperiorLeaderActivity.RectifyingCode://上级领导
                //带回数据
                if (data != null) {
                    leader_id = data.getStringExtra("superiorleaderid");
                    leaderInfo = data.getStringExtra("superiorleadername");
                    tv_SuperiorLeader.setText(leaderInfo);
                }
                break;
            case ShiftsNameActivity.HiddenDangerCode:
                classTime = data.getStringExtra("classTime");
                tv_classTime.setText(classTime + "点");
                break;
            default:
        }
        super.onActivityResult(requestCode, resultCode, data);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            //隐患等级
            case R.id.rl_grade:
                startActivityForResult(new Intent(getActivity(), HiddenDangeGradeActivity.class), HiddenDangeGradeActivity.RectifyingCode);
                break;
            //责任单位
            case R.id.rl_company:
                startActivityForResult(new Intent(getActivity(), ResponsibilityActivity.class), ResponsibilityActivity.RectifyingCode);
                break;
            //审核人
            case R.id.rl_auditor:
                startActivityForResult(new Intent(getActivity(), com.lingjun.colliery_android.module.dealwith.hiddendanger.activity.SelectReviewerActivity.class), com.lingjun.colliery_android.module.dealwith.hiddendanger.activity.SelectReviewerActivity.HiddenDangerCode);
                break;
            case R.id.rl_classTime://班次名称
                startActivityForResult(new Intent(getActivity(), ShiftsNameActivity.class), ShiftsNameActivity.HiddenDangerCode);
                break;
            case R.id.tv_name1://上级领导
                startActivityForResult(new Intent(getActivity(), SuperiorLeaderActivity.class), SuperiorLeaderActivity.RectifyingCode);
                break;
            case R.id.tv_ntry_sure://提交
                if (TextUtils.isEmpty(grade)) {
                    ToastUtils.showShort("请选择隐患等级");
                    return;
                }
                if (TextUtils.isEmpty(classTime)) {
                    ToastUtils.showShort("请选择班次");
                    return;
                }
                if (TextUtils.isEmpty(et_deduction.getText().toString())) {
                    ToastUtils.showShort("请输入扣分值");
                    return;
                }
                if (TextUtils.isEmpty(et_fine.getText().toString().trim())) {
                    ToastUtils.showShort("请输入罚金");
                    return;
                }
                if (TextUtils.isEmpty(et_content.getText().toString().trim())) {
                    ToastUtils.showShort("请输入方案内容");
                    return;
                }
                if (TextUtils.isEmpty(et_content1.getText().toString().trim())) {
                    ToastUtils.showShort("请输入验收依据");
                    return;
                }
                if (TextUtils.isEmpty(name)) {
                    ToastUtils.showShort("请选择责任单位");
                    return;
                }
                if (technicalSwitch.equals("0")) {
                    if (technician_id.equals("0")) {
                        ToastUtils.showShort("请选择技术员");
                        return;
                    }
                }
                if (TextUtils.isEmpty(processor_id)) {
                    ToastUtils.showShort("请选择整改人");
                    return;
                }
                if (TextUtils.isEmpty(ysdwid)) {
                    ToastUtils.showShort("请选择验收单位");
                    return;
                }
                if (TextUtils.isEmpty(ysrid)) {
                    ToastUtils.showShort("请选择验收人");
                    return;
                }
                if (TextUtils.isEmpty(userId)) {
                    ToastUtils.showShort("请选择审核人");
                    return;
                }
                submission();//提交数据

                break;
            case R.id.rl_technician://技术员
                if (TextUtils.isEmpty(department_id)) {
                    Toast.makeText(getActivity(), "请先选择责任单位", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    Intent intent = new Intent(getActivity(), PersonLiableActivity.class);
                    intent.putExtra("personLiable", "1");
                    intent.putExtra("department_id", department_id);
                    startActivityForResult(intent, PersonLiableActivity.RectifyingCode);
                }
                break;
            case R.id.rl_person_liable://整改人
//                if (TextUtils.isEmpty(department_id)) {
//                    Toast.makeText(getActivity(), "请先选择责任单位", Toast.LENGTH_SHORT).show();
//                    return;
//                } else {
//                    Intent intent = new Intent(getActivity(), PersonLiableActivity.class);
//                    intent.putExtra("personLiable", "2");
//                    intent.putExtra("rectificationPersonnelFlag", rectificationPersonnelFlag);
//                    intent.putExtra("department_id", department_id);
//                    intent.putExtra("single", 1);
//                    startActivityForResult(intent, PersonLiableActivity.RectifyingCode);
//                }
                Intent intent1 = new Intent(getActivity(), PersonLiableActivity.class);
                intent1.putExtra("personLiable", "2");
                intent1.putExtra("rectificationPersonnelFlag", rectificationPersonnelFlag);
                intent1.putExtra("department_id", department_id);
                intent1.putExtra("single", 1);
                startActivityForResult(intent1, PersonLiableActivity.RectifyingCode);
                break;
            case R.id.rl_acceptor://验收单位
                startActivityForResult(new Intent(getActivity(), AcceptanceUnitActivity.class), AcceptanceUnitActivity.HiddenDangerCode);
                break;
            case R.id.rl_acceptor_people://验收人
//                if (acceptanceunitid == null || acceptanceunitid.size() == 0) {
//                    Toast.makeText(getActivity(), "请先选择验收单位", Toast.LENGTH_SHORT).show();
//                } else {
//                    Intent intent = new Intent(getActivity(), AcceptorActivity.class);
//                    intent.putExtra("acceptanceunitid", acceptanceunitid + "");
//                    startActivityForResult(intent, AcceptorActivity.HiddenDangerCode);
//                }
                Intent intent = new Intent(getActivity(), AcceptorActivity.class);
                intent.putExtra("acceptanceunitid", ysdwid + "");
                startActivityForResult(intent, AcceptorActivity.HiddenDangerCode);
                break;
            case R.id.rl_SuperiorLeader://上级领导
                if (TextUtils.isEmpty(department_id)) {
                    Toast.makeText(getActivity(), "请先选择责任单位", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    Intent intent2 = new Intent(getActivity(), SuperiorLeaderActivity.class);
                    intent2.putExtra("department_id", department_id);
                    startActivityForResult(intent2, SuperiorLeaderActivity.RectifyingCode);
                }
                break;
            default:
        }
    }

    //提交所有数据
    private void submission() {
        showLoadDialog();
        JSONArray array = new JSONArray();
        JSONObject jsonObject = new JSONObject();
        HashMap<String, String> hashMap = new HashMap<>();
        try {
            jsonObject.put("sourceprocessorId", "0");//隐患处理人id
            jsonObject.put("sourceFolder", sourceFolder);//隐患目录ID
            jsonObject.put("sourceId", sourceId);//隐患内容ID
            jsonObject.put("sourceDesc", sourceDesc);//隐患内容
            jsonObject.put("troubleContent", "");//现场描述  删除了给个空字符
            jsonObject.put("sourceMoney", "" + sourceMoney);//罚款
            jsonObject.put("sourceScore", "" + sourceScore);//罚款
            jsonObject.put("fileIds", "" + fileIds);//照片
        } catch (Exception e) {

        }
        array.put(jsonObject);
        hashMap.put("location", "" + location);//隐患位置
        hashMap.put("taskStatus", "1");//任务状态（0草稿，1主任务）
        hashMap.put("planId", "" + planId);//隐患计划
        hashMap.put("areaId", "" + areaId);//区域ID
        hashMap.put("areaName", "" + areaName);//区域名
        hashMap.put("clauseId", "0");//条款ID
        hashMap.put("clauseDesc", clauseDesc);//隐患标准
        hashMap.put("addTime", addTime);//录入时间
        hashMap.put("torubleMeasures", torubleMeasures);//隐患措施
        hashMap.put("childTask", array.toString());//

        hashMap.put("troubleLevel", "" + grade);//隐患等级
        hashMap.put("troubleLevelId", troubleLevelId + "");
        hashMap.put("troubleDepartmentId", "" + department_id);//部门ID
        if (slight.equals("true")) {
            hashMap.put("troubleLevelslight", "1");//隐患等级slight
        } else {
            hashMap.put("troubleLevelslight", "0");//隐患等级slight
        }
        hashMap.put("responsibleScore", et_deduction.getText().toString().trim() + "");//扣分
        hashMap.put("responsibleMoney", et_fine.getText().toString().trim() + "");//扣钱
        hashMap.put("solutionContent", "" + et_content.getText().toString().trim());//处理方案
        hashMap.put("acceptContent", "" + et_content1.getText().toString().trim());//验收依据

        hashMap.put("processorId", "" + processor_id);//处理人ID
        hashMap.put("technicianId", "" + technician_id);//技术人员ID
        hashMap.put("leaderId", "" + leader_id);//部门领导ID
        if (null != details_time1) {
            hashMap.put("sulotionTime", "" + details_time1);//
        } else {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date d1 = new Date(System.currentTimeMillis());
            String t1 = format.format(d1);
            hashMap.put("sulotionTime", "" + t1);//处理方案时间
        }
        hashMap.put("responsibleleaderId", responsibleLeaderId);//责任人id
        hashMap.put("responsibleleaderName", responsibleLeaderinfo);//责任人名字
        hashMap.put("classTime", classTime);//班次名称

        hashMap.put("approverId", "" + userId);//审核人ID
        hashMap.put("approverName", "" + userName);//审核人

        //验收单位
        hashMap.put("acceptanceDepartmentsName", ysdwname);
        //验收部门人员
        hashMap.put("acceptanceDepartmentsId", ysdwid);
        //验收人员名称
        hashMap.put("acceptanceName", ysrname);
        //验收人员ID
        hashMap.put("acceptanceId", ysrid);

        //方案类型0整改方案1治理方案 (目前只为0)
        hashMap.put("solutionPlan", "0");
        //上传的图片ids
        BaseQuickAdapter imageAdapter = (BaseQuickAdapter) rv_list.getAdapter();
        ArrayList<UpLoadImageBean.ResultMapsBean> imageArray = (ArrayList<UpLoadImageBean.ResultMapsBean>) imageAdapter.getData();
        if (imageArray.size() > 1) {
            imgIds = "";
            for (UpLoadImageBean.ResultMapsBean resBean : imageArray) {
                if (resBean.getFileId() != 0) {
                    imgIds += (resBean.getFileId() + ",");
                }
            }

            imgIds = imgIds.substring(0, imgIds.length() - 1);
            LogUtils.e("剪切后图片ids->>" + imgIds);
            //方案图片 多个用都好链接（false）
            hashMap.put("solutionFileIds", "" + imgIds);
        }
        //上传的图片ids
        BaseQuickAdapter imageAdapter1 = (BaseQuickAdapter) rv_list1.getAdapter();
        ArrayList<UpLoadImageBean.ResultMapsBean> imageArray1 = (ArrayList<UpLoadImageBean.ResultMapsBean>) imageAdapter1.getData();
        if (imageArray1.size() > 1) {
            imgIds1 = "";
            for (UpLoadImageBean.ResultMapsBean resBean : imageArray1) {
                if (resBean.getFileId() != 0) {
                    imgIds1 += (resBean.getFileId() + ",");
                }
            }

            imgIds1 = imgIds1.substring(0, imgIds1.length() - 1);
            LogUtils.e("剪切后图片ids->>" + imgIds1);
            //验收图片 多个用都好链接（false）
            hashMap.put("acceptFileIds", "" + imgIds1);
        }
        if (hiddentype.equals("1")) {
            hashMap.put(BaseLinkList.apiurl, BaseLinkList.coal_mine + BaseLinkList.saveAndSolutionCurrTrouble);
            mRetrofit.JsonToColliery(BaseLinkList.Base_Url, hashMap, new BaseSubscriber() {
                @Override
                public void onError(ExceptionHandle.ResponeThrowable e) {
                    dismissDialog();
                    ToastUtils.showShort("提交失败!");

                }

                @Override
                public void onSuccess(JSONObject jsonObject) throws JSONException {
                    dismissDialog();
                    LogUtils.e("现场治理->>" + jsonObject.toString());
                    if (jsonObject.get("code").equals("200")) {
                        ToastUtils.showShort("提交成功!");
                        getActivity().finish();
                    } else {
                        ToastUtils.showShort(jsonObject.getString("msg"));
                    }
                }
            });
        } else if (hiddentype.equals("2")) {
            //子任务id
            hashMap.put("taskId", "" + bohuitaskId);
            LogUtils.e("现场治理提交bohuitaskId" + bohuitaskId);
            hashMap.put(BaseLinkList.apiurl, BaseLinkList.coal_mine + BaseLinkList.updateAndSolutionCurrTrouble);
            mRetrofit.JsonToColliery(BaseLinkList.Base_Url, hashMap, new BaseSubscriber() {
                @Override
                public void onError(ExceptionHandle.ResponeThrowable e) {
                    dismissDialog();
                    ToastUtils.showShort("提交失败!");
                }

                @Override
                public void onSuccess(JSONObject jsonObject) throws JSONException {
                    dismissDialog();
                    LogUtils.e("现场治理->>" + jsonObject.toString());
                    if (jsonObject.get("code").equals("200")) {
                        ToastUtils.showShort("提交成功!");
                        getActivity().finish();
                    } else {
                        ToastUtils.showShort(jsonObject.getString("msg"));
                    }
                }
            });
        }
    }
}
