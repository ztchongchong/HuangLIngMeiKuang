package com.lingjun.colliery_android.module.dealwith.standardized.accepted;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lingjun.colliery_android.R;
import com.lingjun.colliery_android.base.BaseActivity;
import com.lingjun.colliery_android.base.BaseLinkList;
import com.lingjun.colliery_android.base.OnGlobalListener;
import com.lingjun.colliery_android.bean.AcceptableBean;
import com.lingjun.colliery_android.bean.ResultBean;
import com.lingjun.colliery_android.bean.TaskBean;
import com.lingjun.colliery_android.bean.ToCheckBean;
import com.lingjun.colliery_android.module.dealwith.adapter.AcceptableAdapter;
import com.lingjun.colliery_android.module.dealwith.myinterface.ListviewInterface;
import com.lingjun.colliery_android.module.dealwith.standardized.audit.AuditActivity;
import com.lingjun.colliery_android.utils.DateUtil;
import com.lingjun.colliery_android.utils.FastJsonTools;
import com.lingjun.colliery_android.utils.RecyclerViewUtils;
import com.lingjun.colliery_android.utils.ToastUtils;
import com.lingjun.colliery_android.utils.retrofit.BaseSubscriber;
import com.lingjun.colliery_android.utils.retrofit.ExceptionHandle;
import com.scwang.smartrefresh.layout.api.RefreshLayout;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 待接受
 * Created by nefa on 2018/11/2.
 */

public class AcceptedActivity extends BaseActivity implements ListviewInterface {


    private RecyclerView rv_list;
    private Button rl_button;
    private String taskid;
    private List<AcceptableBean.DataBean.ResultObjBean.TaskitemlistBean> list = new ArrayList<>();
    private AcceptableAdapter adapter;
    private TextView titlestr;
    private TextView create;
    private TextView create_data;
    private TextView qixian;
    private TextView info;
    private TextView pass;
    private int page = 1;

    @Override
    protected int getResourcesId() {
        return R.layout.activity_accepted;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        taskid = getIntent().getStringExtra("taskid");
        rv_list = findViewById(R.id.rv_list);
        rl_button = findViewById(R.id.rl_button);
        titlestr = findViewById(R.id.titlestr);
        create = findViewById(R.id.create);
        create_data = findViewById(R.id.create_data);
        qixian = findViewById(R.id.qixian);
        info = findViewById(R.id.info);
        initAdapter();
        initClick();

        refreshView();
    }

    private void initClick() {
        rl_button.setOnClickListener(  new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    JSONArray jsonArray = new JSONArray();
                    for (int i = 0; i < list.size(); i++) {
                        JSONObject jsonObject = new JSONObject();
                        jsonObject.put("taskid", list.get(i).getTaskId());
                        if (list.get(i).isState()) {
                            jsonObject.put("results", "1");
                        } else {
                            jsonObject.put("results", "0");
                        }
                        jsonObject.put("resultreason", list.get(i).getRejectremark());
                        jsonArray.put(jsonObject);
                    }
                    CommdTask(jsonArray);
                } catch (Exception e) {

                }
            }
        });
    }

    private void CommdTask(JSONArray jsonArray) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("projectList", jsonArray.toString());
        hashMap.put("apiurl", BaseLinkList.coal_mine + BaseLinkList.MOBILE_USERTASKRECEIVE);
        Log.d("map", hashMap.toString());
        mRetrofit.JsonToColliery(BaseLinkList.Base_Url, hashMap, new BaseSubscriber() {
            @Override
            public void onError(ExceptionHandle.ResponeThrowable e) {

            }

            @Override
            public void onSuccess(JSONObject jsonObject) throws JSONException {
                Log.d("json", jsonObject.toString());
                ResultBean bean = FastJsonTools.getBean(jsonObject.toString(), ResultBean.class);
                if (null != bean) {
                    ToastUtils.showToast(AcceptedActivity.this, "提交成功");
                    finish();
                }
            }
        });
    }

    @Override
    protected BaseRefreshLoadMoreInterface setRefreshLoadMoreListener() {
//        return new BaseRefreshLoadMoreInterface() {
//            @Override
//            public void onLoadMore() {
//                page++;
//                refreshView();
//            }
//
//            @Override
//            public void onRefresh() {
//                page = 1;
//                refreshView();
//            }
//        };
        return null;
    }

    //    private void refreshView() {
//        ArrayList<TaskBean> mList = new ArrayList<>();
//
//        for (int i = 0; i < 10; i++) {
//            TaskBean taskBean = new TaskBean();
//            taskBean.isShow = false;
//            taskBean.num = i;
//            mList.add(taskBean);
    private void refreshView() {
//        showLoadDialog();
        HashMap<String, String> hashMap = new HashMap<>();
        if (TextUtils.isEmpty(taskid)) {
            return;
        }
        hashMap.put("page", page + "");
        hashMap.put("pageSize", "500");
        hashMap.put("projectId", taskid);
        hashMap.put("apiurl", BaseLinkList.coal_mine + BaseLinkList.getMyStadchkTask);
        mRetrofit.JsonToColliery(BaseLinkList.Base_Url, hashMap, new BaseSubscriber() {
            @Override
            public void onError(ExceptionHandle.ResponeThrowable e) {
                if (null != refreshLayout) {
                    refreshLayout.finishLoadMore();
                    refreshLayout.finishRefresh();
                }
//                dismissDialog();
            }

            @Override
            public void onSuccess(JSONObject jsonObject) throws JSONException {
                Log.d("json", jsonObject.toString());
                AcceptableBean bean = FastJsonTools.getBean(jsonObject.toString(), AcceptableBean.class);
                if (null != bean) {
                    if (page == 1) {
                        if (list.size() != 0) {
                            list.clear();
                        }
                        if (bean.getData().getResultObj().getTaskitemlist().size() != 0) {
                            list = bean.getData().getResultObj().getTaskitemlist();
                            for (int i = 0; i < list.size(); i++) {
                                list.get(i).setState(true);
                            }
                        } else {
                            ToastUtils.showToast(AcceptedActivity.this, "没有查到相关数据");
                        }
                        adapter.setNewData(list);
                    } else {
                        if (bean.getData().getResultObj().getTaskitemlist().size() != 0) {
                            list.addAll(bean.getData().getResultObj().getTaskitemlist());
                            for (int i = 0; i < list.size(); i++) {
                                list.get(i).setState(true);
                            }
                            adapter.setNewData(list);
                        }else{
                            ToastUtils.showToast(AcceptedActivity.this, "没有查到新的数据");
                        }
                    }
                    titlestr.setText(bean.getData().getResultObj().getTask().getTitle());
                    create.setText("创建人：" + bean.getData().getResultObj().getTask().getCreatorName());
//                    create_data.setText(Util.getData(bean.getData().getCreatetime()));
                    qixian.setText("期限：" + (DateUtil.getData(bean.getData().getResultObj().getProject().getFinishtime())));
                    info.setText(bean.getData().getResultObj().getTask().getDescription());
                }
//                dismissDialog();
                if (null != refreshLayout) {
                    refreshLayout.finishLoadMore();
                    refreshLayout.finishRefresh();
                }
            }
        });
        if (null != refreshLayout) {

            rl_button.setVisibility(View.VISIBLE);

            if (null != refreshLayout) {
                refreshLayout.finishLoadMore();
                refreshLayout.finishRefresh();
            }
        }
    }


    private void initAdapter() {
        adapter = new AcceptableAdapter(R.layout.item_acceptable, AcceptedActivity.this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(AcceptedActivity.this);
        linearLayoutManager.setAutoMeasureEnabled(true);
        rv_list.setLayoutManager(linearLayoutManager);
        rv_list.setAdapter(adapter);
//    class TaskBean {
//        public boolean isShow;
//        public int num;
    }

    @Override
    public void btnClick(View v, int pos, boolean type) {
        list.get(pos).setRoot(!type);
        adapter.notifyItemChanged(pos);

    }

    @Override
    public void btnsClick(View v, int pos, int state, boolean type) {

    }

    @Override
    public void btnsClicks(View v, final int pos, boolean state, int type) {
        switch (type) {
            case 2:
                if (state) {
                    showdeldialog(AcceptedActivity.this, pos);
                }
                break;
            case 3:
                if (!state) {
                    list.get(pos).setState(true);
                    list.get(pos).setRejectremark("");
                    rv_list.post(new Runnable() {
                        @Override
                        public void run() {
                            adapter.notifyItemChanged(pos);
                        }
                    });

                }
                break;
        }
    }

    private void showdeldialog(Context context, final int pos) {
        final Dialog dialog = new Dialog(context, R.style.dialog);//
        dialog.getWindow().setContentView(R.layout.dialog_refuse);
        dialog.setCancelable(false);
        TextView title = dialog.findViewById(R.id.title);
        final EditText sake_info = dialog.findViewById(R.id.sake_info);
        TextView confirm = dialog.findViewById(R.id.confirm);
        TextView cancel = dialog.findViewById(R.id.cancel);
        title.setText("拒绝理由");
        sake_info.setHint("请输入拒绝理由");
        dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {
                forceHideIM();
            }
        });
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(sake_info.getText().toString().trim())) {
                    ToastUtils.showToast(AcceptedActivity.this, "请填写您的意见");
                    return;
                }
                list.get(pos).setState(false);
                list.get(pos).setRejectremark(sake_info.getText().toString().trim());
                adapter.notifyItemChanged(pos);
                dialog.dismiss();
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                list.get(pos).setState(true);
//                list.get(pos).setError("");
                adapter.notifyItemChanged(pos);
                dialog.dismiss();
            }
        });
        dialog.show();
    }

}
