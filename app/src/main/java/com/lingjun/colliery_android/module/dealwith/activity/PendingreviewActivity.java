package com.lingjun.colliery_android.module.dealwith.activity;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.lingjun.colliery_android.R;
import com.lingjun.colliery_android.base.BaseActivity;
import com.lingjun.colliery_android.module.dealwith.adapter.PendingReviewAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shurrikann on 2018/12/4.
 */

public class PendingreviewActivity extends BaseActivity {
    //    private RecyclerView recy1;
//    private RecyclerView recy2;
    private ImageView iv_back;
    //    private PendingReviewAdapter adapter;
//    private List<PendingReviewBean> list1 = new ArrayList<>();
//    private List<PendingReviewBean> list2 = new ArrayList<>();
//    private String[] str1 = {"检查领导","","",""};
//    private String[] str2 = {};
    private RelativeLayout lingdao;
    private RelativeLayout zerenren;
    private RelativeLayout peihe;
    private RelativeLayout teyao;
    private RelativeLayout renwu1;
    private RelativeLayout renwu2;
    private RelativeLayout renwu3;
    private Button bh_btn;
    private Button pass_btn;

    @Override
    protected int getResourcesId() {
        return R.layout.activity_pending_review;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        initView();
//        initAdapter();
        initClick();
        initData();

    }

    private void initData() {

    }

//    private void initAdapter() {
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
//        LinearLayoutManager linearLayoutManager11 = new LinearLayoutManager(this);
//        adapter = new PendingReviewAdapter(R.layout.item_pendreview);
//        recy1.setLayoutManager(linearLayoutManager);
//        recy2.setLayoutManager(linearLayoutManager11);
//        recy1.setAdapter(adapter);
//        recy2.setAdapter(adapter);
//    }

    private void getTaskINfo(){

    }

    private void initClick() {
        iv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        lingdao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
        zerenren.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        peihe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
        teyao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
        renwu1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
        renwu2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
        renwu3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
        bh_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
        pass_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showdeldialog(PendingreviewActivity.this);
            }
        });
    }

    private void initView() {
        iv_back = findViewById(R.id.iv_back);
        lingdao = findViewById(R.id.lingdao);
        zerenren = findViewById(R.id.zerenren);
        peihe = findViewById(R.id.peihe);
        teyao = findViewById(R.id.teyao);
        renwu1 = findViewById(R.id.renwu1);
        renwu2 = findViewById(R.id.renwu2);
        renwu3 = findViewById(R.id.renwu3);
        bh_btn = findViewById(R.id.bh_btn);
        pass_btn = findViewById(R.id.pass_btn);
    }

    @Override
    protected BaseRefreshLoadMoreInterface setRefreshLoadMoreListener() {
        return null;
    }

//    class PendingReviewBean {
//        private String title;
//        private String info;
//
//        public String getTitle() {
//            return title;
//        }
//
//        public void setTitle(String title) {
//            this.title = title;
//        }
//
//        public String getInfo() {
//            return info;
//        }
//
//        public void setInfo(String info) {
//            this.info = info;
//        }
//    }

    private void showdeldialog(Context context) {
        final Dialog dialog = new Dialog(context, R.style.dialog);//
        dialog.getWindow().setContentView(R.layout.dialog_pendreview);
        TextView pass = dialog.findViewById(R.id.pass);
        TextView cancel = dialog.findViewById(R.id.cancel);
        pass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        dialog.show();
    }

    private void showdeldialog1(Context context, int type) {
        final Dialog dialog = new Dialog(context, R.style.dialog);//
        dialog.getWindow().setContentView(R.layout.dialog_refuse);
        TextView title = dialog.findViewById(R.id.title);
        EditText sake_info = dialog.findViewById(R.id.sake_info);
        TextView pass = dialog.findViewById(R.id.pass);
        TextView cancel = dialog.findViewById(R.id.cancel);
        if (type == 1) {
            title.setText("");
            sake_info.setHint("");
        } else {
            title.setText("");
            sake_info.setHint("");
        }
        pass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }


}
