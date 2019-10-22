package com.lingjun.colliery_android.module.siyuanliangzhang;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.lingjun.colliery_android.R;
import com.lingjun.colliery_android.base.BaseActivity;
import com.lingjun.colliery_android.view.tablayout.RoundProgressBar;

import java.lang.reflect.GenericArrayType;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * @author: ztcc
 * @Data： 2019/9/18 9:27
 * Describe:四员两长表盘
 */
public class SylzClockdialActivity extends BaseActivity {

    @BindView(R.id.month)
    TextView month;
    @BindView(R.id.name)
    TextView name;
    @BindView(R.id.rpd)
    RoundProgressBar rpd;
    @BindView(R.id.rl_biaopan1)
    RelativeLayout rlBiaopan1;
    @BindView(R.id.rl_biaopan2)
    RelativeLayout rlBiaopan2;
    @BindView(R.id.rl_biaopan3)
    RelativeLayout rlBiaopan3;
    @BindView(R.id.rl_biaopan4)
    RelativeLayout rlBiaopan4;
    @BindView(R.id.tv_leader1)
    TextView tvLeader1;
    @BindView(R.id.tv_leader2)
    TextView tvLeader2;
    @BindView(R.id.ll_leader1)
    LinearLayout llLeader1;
    @BindView(R.id.tv_leader3)
    TextView tvLeader3;
    @BindView(R.id.tv_leader4)
    TextView tvLeader4;
    @BindView(R.id.ll_leader2)
    LinearLayout llLeader2;
    @BindView(R.id.tv_leader5)
    TextView tvLeader5;
    @BindView(R.id.ll_leader3)
    LinearLayout llLeader3;

    private View dialogview;
    private AlertDialog dialog;

    private String time;
    private int yue = 1;
    private int sylz = 1;

    @Override
    protected int getResourcesId() {
        return R.layout.activity_sylzclockdial;
    }

    @Override
    protected void init(Bundle savedInstanceState) throws PackageManager.NameNotFoundException {
        sylz = getIntent().getIntExtra("sylz", -1);
        if (sylz != -1) {
            if (sylz == 1) {
                llLeader2.setVisibility(View.GONE);
                tvLeader1.setText("安全矿长：");
                tvLeader2.setText("安检部部长：");
                tvLeader5.setText("安全监察部主任科员：");
            } else {
                llLeader3.setVisibility(View.GONE);
                if (sylz == 2) {
                    tvLeader4.setVisibility(View.INVISIBLE);
                }
                tvLeader1.setText("分管副矿长：");
                tvLeader2.setText("部室负责人：");
                tvLeader3.setText("区队主管：");
                tvLeader4.setText("所在区队：");
            }
        }
        //设置当前进度
        rpd.setCurrentProgress(100);
        //设置最大进度
        rpd.setMaxProgress(100);
    }

    @Override
    protected BaseRefreshLoadMoreInterface setRefreshLoadMoreListener() {
        return null;
    }


    @OnClick({R.id.month, R.id.name, R.id.rl_biaopan1, R.id.rl_biaopan2, R.id.rl_biaopan3, R.id.rl_biaopan4})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.month:
                Selectiondate();
                break;
            case R.id.name:
                startActivity(new Intent(SylzClockdialActivity.this, SylzAssessorActivity.class));
                break;
            //本队考核
            case R.id.rl_biaopan1:
                startActivity(new Intent(SylzClockdialActivity.this, SylzCheckListActivity.class));
                break;
            //安监部考核
            case R.id.rl_biaopan2:
                break;
            //干部考核
            case R.id.rl_biaopan3:
                break;
            //奖励得分
            case R.id.rl_biaopan4:
                break;
        }
    }

    //选择日期
    private void Selectiondate() {
        AlertDialog.Builder builder11 = new AlertDialog.Builder(SylzClockdialActivity.this);
        dialogview = View.inflate(SylzClockdialActivity.this, R.layout.alertdialog_calendar, null);
        builder11.setView(dialogview);
        builder11.setCancelable(true);
        RelativeLayout front = dialogview.findViewById(R.id.rl_front);
        RelativeLayout after = dialogview.findViewById(R.id.rl_after);
        final TextView tv_year = dialogview.findViewById(R.id.tv_year);
        final TextView tv_1yue = dialogview.findViewById(R.id.tv_1yue);
        final TextView tv_2yue = dialogview.findViewById(R.id.tv_2yue);
        final TextView tv_3yue = dialogview.findViewById(R.id.tv_3yue);
        final TextView tv_4yue = dialogview.findViewById(R.id.tv_4yue);
        final TextView tv_5yue = dialogview.findViewById(R.id.tv_5yue);
        final TextView tv_6yue = dialogview.findViewById(R.id.tv_6yue);
        final TextView tv_7yue = dialogview.findViewById(R.id.tv_7yue);
        final TextView tv_8yue = dialogview.findViewById(R.id.tv_8yue);
        final TextView tv_9yue = dialogview.findViewById(R.id.tv_9yue);
        final TextView tv_10yue = dialogview.findViewById(R.id.tv_10yue);
        final TextView tv_11yue = dialogview.findViewById(R.id.tv_11yue);
        final TextView tv_12yue = dialogview.findViewById(R.id.tv_12yue);
        TextView tv_cancel = dialogview.findViewById(R.id.tv_cancel);
        TextView tv_complete = dialogview.findViewById(R.id.tv_complete);

        tv_1yue.setBackgroundResource(R.drawable.bj_form1);
        final SimpleDateFormat sf = new SimpleDateFormat("yyyy年");
        final Calendar c = Calendar.getInstance();
        time = sf.format(c.getTime());
        tv_year.setText(time);
        View.OnClickListener listener = new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.rl_front:
                        c.add(Calendar.YEAR, -1);
                        time = sf.format(c.getTime());
                        tv_year.setText(time);
                        break;
                    case R.id.rl_after:
                        c.add(Calendar.YEAR, 1);
                        time = sf.format(c.getTime());
                        tv_year.setText(time);
                        break;
                    case R.id.tv_1yue:
                        yue = 1;
                        tv_1yue.setBackgroundResource(R.drawable.bj_form1);
                        tv_2yue.setBackgroundResource(Color.parseColor("#00000000"));
                        tv_3yue.setBackgroundResource(Color.parseColor("#00000000"));
                        tv_4yue.setBackgroundResource(Color.parseColor("#00000000"));
                        tv_5yue.setBackgroundResource(Color.parseColor("#00000000"));
                        tv_6yue.setBackgroundResource(Color.parseColor("#00000000"));
                        tv_7yue.setBackgroundResource(Color.parseColor("#00000000"));
                        tv_8yue.setBackgroundResource(Color.parseColor("#00000000"));
                        tv_9yue.setBackgroundResource(Color.parseColor("#00000000"));
                        tv_10yue.setBackgroundResource(Color.parseColor("#00000000"));
                        tv_11yue.setBackgroundResource(Color.parseColor("#00000000"));
                        tv_12yue.setBackgroundResource(Color.parseColor("#00000000"));
                        break;
                    case R.id.tv_2yue:
                        yue = 2;
                        tv_1yue.setBackgroundResource(Color.parseColor("#00000000"));
                        tv_2yue.setBackgroundResource(R.drawable.bj_form1);
                        tv_3yue.setBackgroundResource(Color.parseColor("#00000000"));
                        tv_4yue.setBackgroundResource(Color.parseColor("#00000000"));
                        tv_5yue.setBackgroundResource(Color.parseColor("#00000000"));
                        tv_6yue.setBackgroundResource(Color.parseColor("#00000000"));
                        tv_7yue.setBackgroundResource(Color.parseColor("#00000000"));
                        tv_8yue.setBackgroundResource(Color.parseColor("#00000000"));
                        tv_9yue.setBackgroundResource(Color.parseColor("#00000000"));
                        tv_10yue.setBackgroundResource(Color.parseColor("#00000000"));
                        tv_11yue.setBackgroundResource(Color.parseColor("#00000000"));
                        tv_12yue.setBackgroundResource(Color.parseColor("#00000000"));
                        break;
                    case R.id.tv_3yue:
                        yue = 3;
                        tv_1yue.setBackgroundResource(Color.parseColor("#00000000"));
                        tv_2yue.setBackgroundResource(Color.parseColor("#00000000"));
                        tv_3yue.setBackgroundResource(R.drawable.bj_form1);
                        tv_4yue.setBackgroundResource(Color.parseColor("#00000000"));
                        tv_5yue.setBackgroundResource(Color.parseColor("#00000000"));
                        tv_6yue.setBackgroundResource(Color.parseColor("#00000000"));
                        tv_7yue.setBackgroundResource(Color.parseColor("#00000000"));
                        tv_8yue.setBackgroundResource(Color.parseColor("#00000000"));
                        tv_9yue.setBackgroundResource(Color.parseColor("#00000000"));
                        tv_10yue.setBackgroundResource(Color.parseColor("#00000000"));
                        tv_11yue.setBackgroundResource(Color.parseColor("#00000000"));
                        tv_12yue.setBackgroundResource(Color.parseColor("#00000000"));
                        break;
                    case R.id.tv_4yue:
                        yue = 4;
                        tv_1yue.setBackgroundResource(Color.parseColor("#00000000"));
                        tv_2yue.setBackgroundResource(Color.parseColor("#00000000"));
                        tv_3yue.setBackgroundResource(Color.parseColor("#00000000"));
                        tv_4yue.setBackgroundResource(R.drawable.bj_form1);
                        tv_5yue.setBackgroundResource(Color.parseColor("#00000000"));
                        tv_6yue.setBackgroundResource(Color.parseColor("#00000000"));
                        tv_7yue.setBackgroundResource(Color.parseColor("#00000000"));
                        tv_8yue.setBackgroundResource(Color.parseColor("#00000000"));
                        tv_9yue.setBackgroundResource(Color.parseColor("#00000000"));
                        tv_10yue.setBackgroundResource(Color.parseColor("#00000000"));
                        tv_11yue.setBackgroundResource(Color.parseColor("#00000000"));
                        tv_12yue.setBackgroundResource(Color.parseColor("#00000000"));
                        break;
                    case R.id.tv_5yue:
                        yue = 5;
                        tv_1yue.setBackgroundResource(Color.parseColor("#00000000"));
                        tv_2yue.setBackgroundResource(Color.parseColor("#00000000"));
                        tv_3yue.setBackgroundResource(Color.parseColor("#00000000"));
                        tv_4yue.setBackgroundResource(Color.parseColor("#00000000"));
                        tv_5yue.setBackgroundResource(R.drawable.bj_form1);
                        tv_6yue.setBackgroundResource(Color.parseColor("#00000000"));
                        tv_7yue.setBackgroundResource(Color.parseColor("#00000000"));
                        tv_8yue.setBackgroundResource(Color.parseColor("#00000000"));
                        tv_9yue.setBackgroundResource(Color.parseColor("#00000000"));
                        tv_10yue.setBackgroundResource(Color.parseColor("#00000000"));
                        tv_11yue.setBackgroundResource(Color.parseColor("#00000000"));
                        tv_12yue.setBackgroundResource(Color.parseColor("#00000000"));
                        break;
                    case R.id.tv_6yue:
                        yue = 6;
                        tv_1yue.setBackgroundResource(Color.parseColor("#00000000"));
                        tv_2yue.setBackgroundResource(Color.parseColor("#00000000"));
                        tv_3yue.setBackgroundResource(Color.parseColor("#00000000"));
                        tv_4yue.setBackgroundResource(Color.parseColor("#00000000"));
                        tv_5yue.setBackgroundResource(Color.parseColor("#00000000"));
                        tv_6yue.setBackgroundResource(R.drawable.bj_form1);
                        tv_7yue.setBackgroundResource(Color.parseColor("#00000000"));
                        tv_8yue.setBackgroundResource(Color.parseColor("#00000000"));
                        tv_9yue.setBackgroundResource(Color.parseColor("#00000000"));
                        tv_10yue.setBackgroundResource(Color.parseColor("#00000000"));
                        tv_11yue.setBackgroundResource(Color.parseColor("#00000000"));
                        tv_12yue.setBackgroundResource(Color.parseColor("#00000000"));
                        break;
                    case R.id.tv_7yue:
                        yue = 7;
                        tv_1yue.setBackgroundResource(Color.parseColor("#00000000"));
                        tv_2yue.setBackgroundResource(Color.parseColor("#00000000"));
                        tv_3yue.setBackgroundResource(Color.parseColor("#00000000"));
                        tv_4yue.setBackgroundResource(Color.parseColor("#00000000"));
                        tv_5yue.setBackgroundResource(Color.parseColor("#00000000"));
                        tv_6yue.setBackgroundResource(Color.parseColor("#00000000"));
                        tv_7yue.setBackgroundResource(R.drawable.bj_form1);
                        tv_8yue.setBackgroundResource(Color.parseColor("#00000000"));
                        tv_9yue.setBackgroundResource(Color.parseColor("#00000000"));
                        tv_10yue.setBackgroundResource(Color.parseColor("#00000000"));
                        tv_11yue.setBackgroundResource(Color.parseColor("#00000000"));
                        tv_12yue.setBackgroundResource(Color.parseColor("#00000000"));
                        break;
                    case R.id.tv_8yue:
                        yue = 8;
                        tv_1yue.setBackgroundResource(Color.parseColor("#00000000"));
                        tv_2yue.setBackgroundResource(Color.parseColor("#00000000"));
                        tv_3yue.setBackgroundResource(Color.parseColor("#00000000"));
                        tv_4yue.setBackgroundResource(Color.parseColor("#00000000"));
                        tv_5yue.setBackgroundResource(Color.parseColor("#00000000"));
                        tv_6yue.setBackgroundResource(Color.parseColor("#00000000"));
                        tv_7yue.setBackgroundResource(Color.parseColor("#00000000"));
                        tv_8yue.setBackgroundResource(R.drawable.bj_form1);
                        tv_9yue.setBackgroundResource(Color.parseColor("#00000000"));
                        tv_10yue.setBackgroundResource(Color.parseColor("#00000000"));
                        tv_11yue.setBackgroundResource(Color.parseColor("#00000000"));
                        tv_12yue.setBackgroundResource(Color.parseColor("#00000000"));
                        break;
                    case R.id.tv_9yue:
                        yue = 9;
                        tv_1yue.setBackgroundResource(Color.parseColor("#00000000"));
                        tv_2yue.setBackgroundResource(Color.parseColor("#00000000"));
                        tv_3yue.setBackgroundResource(Color.parseColor("#00000000"));
                        tv_4yue.setBackgroundResource(Color.parseColor("#00000000"));
                        tv_5yue.setBackgroundResource(Color.parseColor("#00000000"));
                        tv_6yue.setBackgroundResource(Color.parseColor("#00000000"));
                        tv_7yue.setBackgroundResource(Color.parseColor("#00000000"));
                        tv_8yue.setBackgroundResource(Color.parseColor("#00000000"));
                        tv_9yue.setBackgroundResource(R.drawable.bj_form1);
                        tv_10yue.setBackgroundResource(Color.parseColor("#00000000"));
                        tv_11yue.setBackgroundResource(Color.parseColor("#00000000"));
                        tv_12yue.setBackgroundResource(Color.parseColor("#00000000"));
                        break;
                    case R.id.tv_10yue:
                        yue = 10;
                        tv_1yue.setBackgroundResource(Color.parseColor("#00000000"));
                        tv_2yue.setBackgroundResource(Color.parseColor("#00000000"));
                        tv_3yue.setBackgroundResource(Color.parseColor("#00000000"));
                        tv_4yue.setBackgroundResource(Color.parseColor("#00000000"));
                        tv_5yue.setBackgroundResource(Color.parseColor("#00000000"));
                        tv_6yue.setBackgroundResource(Color.parseColor("#00000000"));
                        tv_7yue.setBackgroundResource(Color.parseColor("#00000000"));
                        tv_8yue.setBackgroundResource(Color.parseColor("#00000000"));
                        tv_9yue.setBackgroundResource(Color.parseColor("#00000000"));
                        tv_10yue.setBackgroundResource(R.drawable.bj_form1);
                        tv_11yue.setBackgroundResource(Color.parseColor("#00000000"));
                        tv_12yue.setBackgroundResource(Color.parseColor("#00000000"));
                        break;
                    case R.id.tv_11yue:
                        yue = 11;
                        tv_1yue.setBackgroundResource(Color.parseColor("#00000000"));
                        tv_2yue.setBackgroundResource(Color.parseColor("#00000000"));
                        tv_3yue.setBackgroundResource(Color.parseColor("#00000000"));
                        tv_4yue.setBackgroundResource(Color.parseColor("#00000000"));
                        tv_5yue.setBackgroundResource(Color.parseColor("#00000000"));
                        tv_6yue.setBackgroundResource(Color.parseColor("#00000000"));
                        tv_7yue.setBackgroundResource(Color.parseColor("#00000000"));
                        tv_8yue.setBackgroundResource(Color.parseColor("#00000000"));
                        tv_9yue.setBackgroundResource(Color.parseColor("#00000000"));
                        tv_10yue.setBackgroundResource(Color.parseColor("#00000000"));
                        tv_11yue.setBackgroundResource(R.drawable.bj_form1);
                        tv_12yue.setBackgroundResource(Color.parseColor("#00000000"));
                        break;
                    case R.id.tv_12yue:
                        yue = 12;
                        tv_1yue.setBackgroundResource(Color.parseColor("#00000000"));
                        tv_2yue.setBackgroundResource(Color.parseColor("#00000000"));
                        tv_3yue.setBackgroundResource(Color.parseColor("#00000000"));
                        tv_4yue.setBackgroundResource(Color.parseColor("#00000000"));
                        tv_5yue.setBackgroundResource(Color.parseColor("#00000000"));
                        tv_6yue.setBackgroundResource(Color.parseColor("#00000000"));
                        tv_7yue.setBackgroundResource(Color.parseColor("#00000000"));
                        tv_8yue.setBackgroundResource(Color.parseColor("#00000000"));
                        tv_9yue.setBackgroundResource(Color.parseColor("#00000000"));
                        tv_10yue.setBackgroundResource(Color.parseColor("#00000000"));
                        tv_11yue.setBackgroundResource(Color.parseColor("#00000000"));
                        tv_12yue.setBackgroundResource(R.drawable.bj_form1);
                        break;
                    case R.id.tv_cancel:
                        dialog.dismiss();
                        break;
                    case R.id.tv_complete:
                        dialog.dismiss();
                        month.setText(time + yue + "月");
                        break;
                }
            }
        };
        front.setOnClickListener(listener);
        after.setOnClickListener(listener);
        tv_1yue.setOnClickListener(listener);
        tv_2yue.setOnClickListener(listener);
        tv_3yue.setOnClickListener(listener);
        tv_4yue.setOnClickListener(listener);
        tv_5yue.setOnClickListener(listener);
        tv_6yue.setOnClickListener(listener);
        tv_7yue.setOnClickListener(listener);
        tv_8yue.setOnClickListener(listener);
        tv_9yue.setOnClickListener(listener);
        tv_10yue.setOnClickListener(listener);
        tv_11yue.setOnClickListener(listener);
        tv_12yue.setOnClickListener(listener);
        tv_cancel.setOnClickListener(listener);
        tv_complete.setOnClickListener(listener);
        dialog = builder11.create();
        dialog.getWindow().setBackgroundDrawable(new BitmapDrawable());
        dialog.show();
    }

}
