package com.lingjun.colliery_android.module.dealwith.activity;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.blankj.utilcode.util.ToastUtils;
import com.lingjun.colliery_android.R;
import com.lingjun.colliery_android.base.BaseActivity;
import com.lingjun.colliery_android.module.dealwith.adapter.AcceptableAdapter;
import com.lingjun.colliery_android.module.dealwith.myinterface.ListviewInterface;


import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shurrikann on 2018/3/23.
 */

public class AcceptableActivity extends BaseActivity implements ListviewInterface {
    private RecyclerView recy;
    private ImageView iv_back;
    private TextView titlestr;
    private TextView create;
    private TextView create_data;
    private TextView qixian;
    private TextView info;
    private TextView pass;
    private AcceptableAdapter acceptableAdapter;
    private Dialog dialog;
    private int id;

    @Override
    protected int getResourcesId() {
        return R.layout.activity_acceptable;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        id = getIntent().getIntExtra("id", -1);
        initView();
        setClick();
        initAdapter();
//        new ToCheckTask().execute();
    }

    @Override
    protected BaseRefreshLoadMoreInterface setRefreshLoadMoreListener() {
        return null;
    }


    private void initAdapter() {
        acceptableAdapter = new AcceptableAdapter(R.layout.item_acceptable, AcceptableActivity.this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(AcceptableActivity.this);
        linearLayoutManager.setAutoMeasureEnabled(true);
        recy.setLayoutManager(linearLayoutManager);
        recy.setAdapter(acceptableAdapter);
    }

    private void setClick() {
        iv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        pass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                try {
//                    List<JSONObject> jsonlist = new ArrayList<>();
//                    for (int i = 0; i < list.size(); i++) {
//                        JSONObject jsonObject = new JSONObject();
//                        jsonObject.put("taskid", list.get(i).getItemId());
//                        if (list.get(i).isState()) {
//                            jsonObject.put("results", 1);
//                        } else {
//                            jsonObject.put("results", 0);
//                        }
//                        jsonObject.put("resultreason", list.get(i).getResultremark());
//                        jsonlist.add(jsonObject);
//                        new StdchkcheckTask(jsonlist).execute();
//                    }
//                } catch (Exception e) {
//
//                }
//                Intent intent = new Intent();
//                intent.setClass(AcceptableActivity.this, TaskFollowActivity.class);
//                startActivity(intent);
            }
        });
    }

    private void initView() {
        recy = findViewById(R.id.recy);
        iv_back = findViewById(R.id.iv_back);
        titlestr = findViewById(R.id.titlestr);
        create = findViewById(R.id.create);
        create_data = findViewById(R.id.create_data);
        qixian = findViewById(R.id.qixian);
        info = findViewById(R.id.info);
        recy.setNestedScrollingEnabled(false);
        pass = findViewById(R.id.pass);
    }

    @Override
    public void btnClick(View v, int pos, boolean type) {
//        list.get(pos).setRoot(!type);
//        acceptableAdapter.notifyItemChanged(pos);
    }

    @Override
    public void btnsClick(View v, int pos, int state, boolean type) {
//        list.get(pos).setRoot(!type);
//        acceptableAdapter.notifyItemChanged(pos);
//        recy.post(new Runnable()
//        {
//            public void run() {
//                acceptableAdapter.notifyDataSetChanged();
//            }
//        });
//        acceptableAdapter.notifyDataSetChanged();
    }

    @Override
    public void btnsClicks(View v, int pos, boolean state, int type) {
        switch (type) {
            case 2:
                if (state) {
                    showdeldialog(AcceptableActivity.this, pos);
                }
                break;
            case 3:
                if (!state) {
//                    list.get(pos).setState(true);
//                    list.get(pos).setResultremark("");
//                    recy.post(new Runnable() {
//                        @Override
//                        public void run() {
//                            acceptableAdapter.notifyItemChanged(pos);
//                        }
//                    });

                }
                break;
            default:
        }
    }


    public class AcceptableBean1 {
        boolean state;
        boolean root;
        String error;

        public String getError() {
            return error;
        }

        public void setError(String error) {
            this.error = error;
        }

        public boolean isState() {
            return state;
        }

        public void setState(boolean state) {
            this.state = state;
        }

        public boolean isRoot() {
            return root;
        }

        public void setRoot(boolean root) {
            this.root = root;
        }
    }

    private void showdeldialog(Context context, final int pos) {
        if (dialog == null) {
            dialog = new Dialog(context, R.style.dialog);
        }
        dialog.setCancelable(false);
        dialog.getWindow().setContentView(R.layout.dialog_refuse);
        final EditText sake_info = dialog.findViewById(R.id.sake_info);
        TextView confirm = dialog.findViewById(R.id.confirm);
        TextView cancel = dialog.findViewById(R.id.cancel);
        if (!dialog.isShowing()) {
            dialog.show();
        }
        dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialogs) {
                dialog = null;
            }
        });
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(sake_info.getText().toString().trim())) {
                    ToastUtils.showShort("请输入拒绝理由");
                    return;
                }
//                CheckBox checkBox = (CheckBox) v;
//                checkBox.setChecked(false);
//                list.get(pos).setState(false);
//                list.get(pos).setResultremark(sake_info.getText().toString().trim());
                acceptableAdapter.notifyItemChanged(pos);
                dialog.dismiss();

            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                list.get(pos).setState(true);
////                list.get(pos).setError("");
//                acceptableAdapter.notifyItemChanged(pos);
                dialog.dismiss();
            }
        });
    }
}
