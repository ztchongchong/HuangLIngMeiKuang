package com.lingjun.colliery_android.module.main.rectifyingviolations;

import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lingjun.colliery_android.R;
import com.lingjun.colliery_android.base.BaseActivity;
import com.lingjun.colliery_android.base.BaseLinkList;
import com.lingjun.colliery_android.base.OnGlobalListener;
import com.lingjun.colliery_android.bean.DisobeyInfoBean;
import com.lingjun.colliery_android.bean.DisobeyappeallistBean;
import com.lingjun.colliery_android.eventbus.MsgEvent;
import com.lingjun.colliery_android.module.main.rectifyingviolations.fragment.AmendmentPenaltyActivity;
import com.lingjun.colliery_android.module.main.rectifyingviolations.fragment.PreviewInformationFragment;
import com.lingjun.colliery_android.module.main.rectifyingviolations.fragment.PreviewPunishmentFragment;
import com.lingjun.colliery_android.utils.FastJsonTools;
import com.lingjun.colliery_android.utils.RecyclerViewUtils;
import com.lingjun.colliery_android.utils.retrofit.BaseSubscriber;
import com.lingjun.colliery_android.utils.retrofit.ExceptionHandle;
import com.lingjun.colliery_android.view.NoScrollViewpager;
import com.lingjun.colliery_android.view.tablayout.TabLayout;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 预览三违任务
 * Created by nefa on 2018/11/18.
 */

public class PreviewViolationInformationActivity extends BaseActivity {

    private TabLayout tb_title;
    private NoScrollViewpager vp_content;
    private ArrayList<String> tabTitle;
    private TextView tv_name;
    private TextView tv_no_sure;
    private TextView tv_sure;
    private LinearLayout ll_button;
    private LinearLayout ll_button1;
    private View dialogview;
    private AlertDialog dialog;
    private String taskId = "";
    private String state = "";
    private String type = "";
    private ImageView delete;
    private TextView title;
    private EditText dialog_edit;
    private TextView tv_cancel;
    private TextView tv_comfirm;
    private TextView tv_compile;
    private int responsibleUserId;
    private String userName;
    private String departmentName;
    private String leaderName;
    private String approverName;
    private String discovererName;
    private int extraMoney;
    private String showtime;
    private String behavior;
    private String extraType;
    private int taskType;
    private String clauseDescription;
    private int levelId;
    private int departmentId;
    private String number;
    private String responsibleLeaderId;
    private int approverId;
    private ArrayList<DisobeyInfoBean.DataBean.DisobeytaskdocBean> disobeytaskdoc = new ArrayList<>();
    //三违单不安全行为列表
    private ArrayList<DisobeyInfoBean.DataBean.TaskclauselistBean> taskclauselist = new ArrayList<>();

    private LinearLayout ll_button2;//确认中
    private TextView tv_appeal;//申诉
    private TextView tv_accept;//接受

    private LinearLayout ll_button3;//被驳回
    private TextView tv_punish;//修改处罚
    private TextView tv_arbitration;//原方案仲裁

    private CheckBox checkBox;
    private ArrayList<String> appealnamesidlist = new ArrayList<>();

    @Override
    protected int getResourcesId() {
        return R.layout.activity_preview_violation;
    }

    @Override
    protected void init(Bundle savedInstanceState) {


        tb_title = findViewById(R.id.tb_title);
        vp_content = findViewById(R.id.vp_content);
        tv_name = findViewById(R.id.tv_name);
        tv_no_sure = findViewById(R.id.tv_no_sure);
        tv_sure = findViewById(R.id.tv_sure);
        tv_compile = findViewById(R.id.tv_compile);
        tv_appeal = findViewById(R.id.tv_appeal);
        tv_accept = findViewById(R.id.tv_accept);
        tv_punish = findViewById(R.id.tv_punish);
        tv_arbitration = findViewById(R.id.tv_arbitration);
        ll_button = findViewById(R.id.ll_button);
        ll_button1 = findViewById(R.id.ll_button1);
        ll_button2 = findViewById(R.id.ll_button2);
        ll_button3 = findViewById(R.id.ll_button3);
        vp_content.setScroll(true);
        ArrayList<Fragment> mList = new ArrayList<>();
        tabTitle = new ArrayList<>();
        tabTitle.add("三违信息");
        tabTitle.add("处罚单预览");

        taskId = getIntent().getStringExtra("taskId");
        state = getIntent().getStringExtra("state");
        type = getIntent().getStringExtra("type");
        if (state.equals("2")) {//审核中
            if (type.equals("1")) {
                tv_name.setText("审核中");
            } else if (type.equals("2")) {
                tv_name.setText("待审核");
                ll_button.setVisibility(View.VISIBLE);
            }
        } else if (state.equals("3")) {//被驳回
            tv_name.setText("被驳回");
            ll_button1.setVisibility(View.VISIBLE);
        } else if (state.equals("4")) {//确认中
            if (type.equals("2")) {
                tv_name.setText("确认中");
                ll_button2.setVisibility(View.VISIBLE);
            } else if (type.equals("1")) {
                tv_name.setText("确认中");
                ll_button2.setVisibility(View.GONE);
            }
        } else if (state.equals("8")) {//待销号
            tv_name.setText("待销号");
        } else if (state.equals("9")) {//待销号
            tv_name.setText("已销号");
        } else if (state.equals("6")) {
            tv_name.setText("被申诉");
            ll_button3.setVisibility(View.VISIBLE);
        }
        //修改处罚
        tv_punish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                punish();
            }
        });
        //原方案仲裁
        tv_arbitration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("id", taskId);
                hashMap.put(BaseLinkList.apiurl, BaseLinkList.coal_mine + BaseLinkList.disobeyconfirmfinally);
                mRetrofit.JsonToColliery(BaseLinkList.Base_Url, hashMap, new BaseSubscriber() {
                    @Override
                    public void onError(ExceptionHandle.ResponeThrowable e) {
                        ToastUtils.showShort("提交失败!");
                    }

                    @Override
                    public void onSuccess(JSONObject jsonObject) throws JSONException {
                        LogUtils.e("三违原方案仲裁返回->>" + jsonObject.toString());
                        if (jsonObject.get("code").equals("200")) {
                            ToastUtils.showShort("提交成功!");
                            PreviewViolationInformationActivity.this.finish();
                        } else {
                            ToastUtils.showShort(jsonObject.getString("msg"));
                        }
                    }
                });

            }
        });
        //申诉
        tv_appeal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder1 = new AlertDialog.Builder(PreviewViolationInformationActivity.this);
                dialogview = View.inflate(PreviewViolationInformationActivity.this, R.layout.alertdialog_appeal, null);
                builder1.setView(dialogview);
                builder1.setCancelable(true);
                dialog_edit = dialogview.findViewById(R.id.dialog_edit);//输入内容
                tv_cancel = dialogview.findViewById(R.id.tv_cancel);//取消按钮
                tv_comfirm = dialogview.findViewById(R.id.tv_comfirm);//确定按钮
                final RecyclerView rl_view;
                rl_view = dialogview.findViewById(R.id.rl_view);

                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put(BaseLinkList.apiurl, BaseLinkList.coal_mine + BaseLinkList.disobeyappeallist);
                mRetrofit.JsonToColliery(BaseLinkList.Base_Url, hashMap, new BaseSubscriber() {
                    @Override
                    public void onError(ExceptionHandle.ResponeThrowable e) {

                    }

                    @Override
                    public void onSuccess(JSONObject jsonObject) throws JSONException {
                        LogUtils.e("申诉主体->>" + jsonObject.toString());
                        final DisobeyappeallistBean disobeyappeallistBean = FastJsonTools.getBean(jsonObject.toString(), DisobeyappeallistBean.class);
                        if (null != disobeyappeallistBean.getData() && null != disobeyappeallistBean.getCode() && null != disobeyappeallistBean.getMsg()) {
                            RecyclerViewUtils.initLiner(PreviewViolationInformationActivity.this, rl_view, R.layout.item_punish, disobeyappeallistBean.getData().getList(), new OnGlobalListener() {
                                @Override
                                public <T> void logic(BaseViewHolder helper, List<T> mData, T item, BaseQuickAdapter mAdapter) {
                                    DisobeyappeallistBean.DataBean.ListBean listBean = (DisobeyappeallistBean.DataBean.ListBean) item;
                                    checkBox = helper.getView(R.id.tv_name);
                                    checkBox.setText(listBean.getName());
                                    checkBox.setChecked(listBean.isType());
                                    helper.addOnClickListener(R.id.tv_name);

                                    if (listBean.isType()) {
                                        appealnamesidlist.add(listBean.getName());
                                    } else if (!listBean.isType()) {
                                        appealnamesidlist.remove(listBean.getName());
                                    }
                                }
                            }, new BaseQuickAdapter.OnItemClickListener() {
                                @Override
                                public void onItemClick(BaseQuickAdapter adapter, View view, int position) {

                                }
                            }, new BaseQuickAdapter.OnItemChildClickListener() {
                                @Override
                                public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
//                                    DisobeyappeallistBean.DataBean.ListBean listBean = (DisobeyappeallistBean.DataBean.ListBean) adapter.getData().get(position);

                                    if (((DisobeyappeallistBean.DataBean.ListBean) adapter.getData().get(position)).isType()) {
                                        ((DisobeyappeallistBean.DataBean.ListBean) adapter.getData().get(position)).setType(false);
                                    } else {
                                        ((DisobeyappeallistBean.DataBean.ListBean) adapter.getData().get(position)).setType(true);
                                    }
                                    adapter.notifyItemChanged(position);
                                }
                            });

                        }
                        if (null != refreshLayout) {
                            refreshLayout.finishRefresh();
                            refreshLayout.finishLoadMore();
                        }
                    }
                });

                tv_cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });
                tv_comfirm.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (!TextUtils.isEmpty(dialog_edit.getText().toString().trim())) {
                            if (appealnamesidlist.size() == 0) {
                                ToastUtils.showShort("最少选择一条申诉主体!");
                                return;
                            }
                            appeal();
                            dialog.dismiss();
                        } else {
                            ToastUtils.showShort("请输入理由!");
                            return;
                        }
                    }
                });
                dialog = builder1.create();
                dialog.getWindow().setBackgroundDrawable(new BitmapDrawable());
                dialog.show();
            }
        });
        //接受
        tv_accept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                accep();
            }
        });
        tv_no_sure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder1 = new AlertDialog.Builder(PreviewViolationInformationActivity.this);
                dialogview = View.inflate(PreviewViolationInformationActivity.this, R.layout.alertdialog_implemented, null);
                builder1.setView(dialogview);
                builder1.setCancelable(true);
                delete = dialogview.findViewById(R.id.iv_delete);//删除
                title = dialogview.findViewById(R.id.title);//设置标题
                title.setText("驳回理由");
                dialog_edit = dialogview.findViewById(R.id.dialog_edit);//输入内容
                tv_cancel = dialogview.findViewById(R.id.tv_cancel);//取消按钮
                tv_comfirm = dialogview.findViewById(R.id.tv_comfirm);//确定按钮
                //取消或确定按钮监听事件处理
                delete.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });
                tv_cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });
                tv_comfirm.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (!TextUtils.isEmpty(dialog_edit.getText().toString().trim())) {
                            reject();
                            dialog.dismiss();
                        } else {
                            ToastUtils.showShort("请输入理由!");
                            return;
                        }
                    }
                });
                dialog = builder1.create();
                dialog.getWindow().setBackgroundDrawable(new BitmapDrawable());
                dialog.show();
            }
        });

        tv_sure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adopt();
            }
        });

        tv_compile.setOnClickListener(new View.OnClickListener() {//编辑
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PreviewViolationInformationActivity.this, RectifyingViolationsActivity.class);

                if (null != userName) {
                    intent.putExtra("userName", userName);
                }
                if (null != departmentName) {
                    intent.putExtra("departmentName", departmentName);
                }
                if (null != leaderName) {
                    intent.putExtra("leaderName", leaderName);
                }
                if (null != approverName) {
                    intent.putExtra("approverName", approverName);
                }
                if (null != discovererName) {
                    intent.putExtra("discovererName", discovererName);
                }
                if (null != responsibleUserId + "") {
                    intent.putExtra("responsibleUserId", responsibleUserId + "");
                }
                if (null != approverId + "") {
                    intent.putExtra("approverId", approverId + "");
                }
                if (null != number + "") {
                    intent.putExtra("number", number + "");
                }
                if (null != extraMoney + "") {
                    intent.putExtra("extraMoney", extraMoney + "");
                }
                if (null != showtime) {
                    intent.putExtra("showtime", showtime);
                }
                if (null != behavior) {
                    intent.putExtra("behavior", behavior);
                }
                if (null != extraType) {
                    intent.putExtra("extraType", extraType);
                }
                if (null != departmentId + "") {
                    intent.putExtra("departmentId", departmentId + "");
                }
                if (null != responsibleLeaderId + "") {
                    intent.putExtra("responsibleLeaderId", responsibleLeaderId + "");
                }
                if (null != disobeytaskdoc) {  //三违单图片列表
                    intent.putExtra("disobeytaskdoc", disobeytaskdoc);
                }
                if (null != taskclauselist) {     //三违单不安全行为列表
                    intent.putExtra("taskclauselist", taskclauselist);
                }
                if (null != taskType + "") {
                    intent.putExtra("taskType", taskType + "");
                }
                if (null != clauseDescription) {
                    intent.putExtra("clauseDescription", clauseDescription);
                }
                if (null != levelId + "") {
                    intent.putExtra("levelId", levelId + "");
                }
                intent.putExtra("type", "2");
                intent.putExtra("taskId", taskId);
                startActivity(intent);
                finish();
            }
        });
        Bundle bundle = new Bundle();
        bundle.putString("taskId", taskId);
        bundle.putString("state", state);
        bundle.putString("type", type);
        PreviewInformationFragment previewInformationFragment = new PreviewInformationFragment();
        PreviewPunishmentFragment previewPunishmentFragment = new PreviewPunishmentFragment();
        previewInformationFragment.setArguments(bundle);
        previewPunishmentFragment.setArguments(bundle);
        mList.add(previewInformationFragment);
        mList.add(previewPunishmentFragment);
        CourseDetailsAdapter adapter = new CourseDetailsAdapter(getSupportFragmentManager(), mList, tabTitle);
        vp_content.setAdapter(adapter);
        tb_title.setupWithViewPager(vp_content);
        tb_title.setTabMode(TabLayout.MODE_FIXED);
        refresview();
    }

    //修改处罚
    private void punish() {
        Intent intent = new Intent(PreviewViolationInformationActivity.this, AmendmentPenaltyActivity.class);
        intent.putExtra("id", taskId);
        startActivity(intent);
    }

    //申诉
    private void appeal() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("id", taskId);
        String appealnames = String.valueOf(appealnamesidlist).replace("[", "").replace("]", "").replace(" ", "");
        hashMap.put("appealnames", appealnames);
        hashMap.put("appealReason", dialog_edit.getText().toString());//申诉原因

        hashMap.put(BaseLinkList.apiurl, BaseLinkList.coal_mine + BaseLinkList.disobeyappeal);
        mRetrofit.JsonToColliery(BaseLinkList.Base_Url, hashMap, new BaseSubscriber() {
            @Override
            public void onError(ExceptionHandle.ResponeThrowable e) {
                ToastUtils.showShort("提交失败!");
            }

            @Override
            public void onSuccess(JSONObject jsonObject) throws JSONException {
                LogUtils.e("三违申诉返回->>" + jsonObject.toString());
                if (jsonObject.get("code").equals("200")) {
                    ToastUtils.showShort("提交成功!");
                    PreviewViolationInformationActivity.this.finish();
                } else {
                    ToastUtils.showShort(jsonObject.getString("msg"));
                }
            }
        });
    }

    //接受
    private void accep() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("id", taskId);
        hashMap.put(BaseLinkList.apiurl, BaseLinkList.coal_mine + BaseLinkList.disobeyconfirm);
        mRetrofit.JsonToColliery(BaseLinkList.Base_Url, hashMap, new BaseSubscriber() {
            @Override
            public void onError(ExceptionHandle.ResponeThrowable e) {
                ToastUtils.showShort("提交失败!");
            }

            @Override
            public void onSuccess(JSONObject jsonObject) throws JSONException {
                LogUtils.e("三违接受返回->>" + jsonObject.toString());
                if (jsonObject.get("code").equals("200")) {
                    ToastUtils.showShort("提交成功!");
                    PreviewViolationInformationActivity.this.finish();
                } else {
                    ToastUtils.showShort(jsonObject.getString("msg"));
                }
            }
        });
    }

    private void refresview() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("id", taskId);
        hashMap.put(BaseLinkList.apiurl, BaseLinkList.coal_mine + BaseLinkList.disobeyinfo);
        mRetrofit.JsonToColliery(BaseLinkList.Base_Url, hashMap, new BaseSubscriber() {
            @Override
            public void onError(ExceptionHandle.ResponeThrowable e) {

            }

            @Override
            public void onSuccess(JSONObject jsonObject) throws JSONException {
                LogUtils.e("三违处理详情列表->>" + jsonObject.toString());
                final DisobeyInfoBean disobeyInfoBean = FastJsonTools.getBean(jsonObject.toString(), DisobeyInfoBean.class);
                //三违单信息
                DisobeyInfoBean.DataBean.DisobeytaskBean disobeytask = disobeyInfoBean.getData().getDisobeytask();
                //三违单图片列表
                disobeytaskdoc = disobeyInfoBean.getData().getDisobeytaskdoc();
                //三违单不安全行为列表
                taskclauselist = disobeyInfoBean.getData().getTaskclauselist();
                departmentId = disobeytask.getResponsibleDepartmentId();
                taskType = disobeytask.getTaskType();//1标准化2 自定义
                clauseDescription = disobeytask.getClauseDescription();//自定义等级
                userName = disobeytask.getResponsibleUserName();//负责人
                responsibleUserId = disobeytask.getResponsibleUserId();//责任人id
                departmentName = disobeytask.getResponsibleDepartmentName();//责任单位
                leaderName = disobeytask.getResponsibleLeaderName();//责任领导
                approverName = disobeytask.getApproverName();//审核人
                discovererName = disobeytask.getDiscovererName();//发现人
                extraMoney = disobeytask.getExtraMoney();//惩罚金内容
                levelId = disobeytask.getLevelId();//自定义额
                showtime = disobeytask.getShowtime() + "";//录入时间
                behavior = disobeytask.getBehavior();//描述内容
                number = disobeytask.getNumber();
                responsibleLeaderId = disobeytask.getResponsibleLeaderId();
                approverId = disobeytask.getApproverId();
                if (null != disobeytask.getExtraType()) {
                    extraType = disobeytask.getExtraType();//额外处罚 ID
                }

            }
        });
    }

    private void adopt() {

        HashMap<String, String> hashMap = new HashMap<>();

        hashMap.put("id", "" + taskId);//任务id
        hashMap.put("status", "1");//落实状态 1通过 0驳回
        hashMap.put(BaseLinkList.apiurl, BaseLinkList.coal_mine + BaseLinkList.disobeycheck);

        mRetrofit.JsonToColliery(BaseLinkList.Base_Url, hashMap, new BaseSubscriber() {
            @Override
            public void onError(ExceptionHandle.ResponeThrowable e) {
                ToastUtils.showShort("提交失败!");
            }

            @Override
            public void onSuccess(JSONObject jsonObject) throws JSONException {
                LogUtils.e("合格->>" + jsonObject.toString());
                if (jsonObject.get("code").equals("200")) {
                    ToastUtils.showShort("提交成功!");
                    PreviewViolationInformationActivity.this.finish();
                } else {
                    ToastUtils.showShort(jsonObject.getString("msg"));
                }
            }
        });
    }

    private void reject() {
        HashMap<String, String> hashMap = new HashMap<>();

        hashMap.put("id", "" + taskId);//任务id
        hashMap.put("status", "0");// 1通过 0驳回
        hashMap.put("remark", "" + dialog_edit.getText().toString().trim());
        hashMap.put(BaseLinkList.apiurl, BaseLinkList.coal_mine + BaseLinkList.disobeycheck);

        mRetrofit.JsonToColliery(BaseLinkList.Base_Url, hashMap, new BaseSubscriber() {
            @Override
            public void onError(ExceptionHandle.ResponeThrowable e) {
                ToastUtils.showShort("提交失败!");
            }

            @Override
            public void onSuccess(JSONObject jsonObject) throws JSONException {
                LogUtils.e("通过->>" + jsonObject.toString());
                if (jsonObject.get("code").equals("200")) {
                    ToastUtils.showShort("提交成功!");
                    PreviewViolationInformationActivity.this.finish();
                } else {
                    ToastUtils.showShort(jsonObject.getString("msg"));
                }
            }
        });
    }

    @Override
    protected BaseRefreshLoadMoreInterface setRefreshLoadMoreListener() {
        return null;
    }

    class CourseDetailsAdapter extends FragmentStatePagerAdapter {
        private List<Fragment> fragments;
        private ArrayList<String> tabName;

        public CourseDetailsAdapter(FragmentManager fm, List<Fragment> fragments, ArrayList<String> tab) {
            super(fm);
            this.fragments = fragments;
            this.tabName = tab;
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return tabName.get(position);
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void rejectSuccess(MsgEvent.RejectCommitSuccess messageEvent) {
        finish();
    }
}
