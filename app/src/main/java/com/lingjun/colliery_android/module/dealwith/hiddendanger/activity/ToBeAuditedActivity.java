package com.lingjun.colliery_android.module.dealwith.hiddendanger.activity;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.View;
import android.widget.TextView;

import com.lingjun.colliery_android.R;
import com.lingjun.colliery_android.base.BaseActivity;
import com.lingjun.colliery_android.module.dealwith.hiddendanger.fragment.ToBeAuditedFragmentFA;
import com.lingjun.colliery_android.module.dealwith.hiddendanger.fragment.ToBeAuditedFragmentJJ;
import com.lingjun.colliery_android.module.dealwith.hiddendanger.fragment.ToBeAuditedFragmentXC;
import com.lingjun.colliery_android.module.dealwith.hiddendanger.fragment.ToBeAuditedFragmentYA;
import com.lingjun.colliery_android.module.dealwith.hiddendanger.fragment.ToBeAuditedFragmentZJ;
import com.lingjun.colliery_android.module.dealwith.hiddendanger.fragment.ToBeAuditedFragmentZR;
import com.lingjun.colliery_android.view.NoScrollViewpager;

import java.util.ArrayList;
import java.util.List;

/**
 * 重大隐患
 */
public class ToBeAuditedActivity extends BaseActivity implements View.OnClickListener {
    private TextView tv_fangan, tv_xianchang, tv_zeren, tv_jiejue, tv_yuan, tv_zijin;
    private NoScrollViewpager vp_to_be_audited;

    @Override
    protected int getResourcesId() {
        return R.layout.activity_to_be_audited;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        tv_fangan = findViewById(R.id.tv_fangan);
        tv_xianchang = findViewById(R.id.tv_xianchang);
        tv_zeren = findViewById(R.id.tv_zeren);
        tv_jiejue = findViewById(R.id.tv_jiejue);
        tv_yuan = findViewById(R.id.tv_yuan);
        tv_zijin = findViewById(R.id.tv_zijin);
        vp_to_be_audited = findViewById(R.id.vp_to_be_audited);

        tv_fangan.setOnClickListener(this);
        tv_xianchang.setOnClickListener(this);
        tv_zeren.setOnClickListener(this);
        tv_jiejue.setOnClickListener(this);
        tv_yuan.setOnClickListener(this);
        tv_zijin.setOnClickListener(this);


        ArrayList<Fragment> mList = new ArrayList<>();
        ToBeAuditedFragmentFA toBeAuditedFragmentFA = new ToBeAuditedFragmentFA();
        ToBeAuditedFragmentXC toBeAuditedFragmentXC = new ToBeAuditedFragmentXC();
        ToBeAuditedFragmentZR toBeAuditedFragmentZR = new ToBeAuditedFragmentZR();
        ToBeAuditedFragmentJJ toBeAuditedFragmentJJ = new ToBeAuditedFragmentJJ();
        ToBeAuditedFragmentYA toBeAuditedFragmentYA = new ToBeAuditedFragmentYA();
        ToBeAuditedFragmentZJ toBeAuditedFragmentZJ = new ToBeAuditedFragmentZJ();

        mList.add(toBeAuditedFragmentFA);
        mList.add(toBeAuditedFragmentXC);
        mList.add(toBeAuditedFragmentZR);
        mList.add(toBeAuditedFragmentJJ);
        mList.add(toBeAuditedFragmentYA);
        mList.add(toBeAuditedFragmentZJ);

        MyViewPager myViewPager = new MyViewPager(getSupportFragmentManager(), mList);
        vp_to_be_audited.setAdapter(myViewPager);
        vp_to_be_audited.setScroll(false);
        vp_to_be_audited.setCurrentItem(0);
    }

    @Override
    protected BaseRefreshLoadMoreInterface setRefreshLoadMoreListener() {
        return null;
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_fangan:
                tv_fangan.setTextColor(getColor(R.color.bule));
                tv_xianchang.setTextColor(Color.BLACK);
                tv_zeren.setTextColor(Color.BLACK);
                tv_jiejue.setTextColor(Color.BLACK);
                tv_yuan.setTextColor(Color.BLACK);
                tv_zijin.setTextColor(Color.BLACK);
                vp_to_be_audited.setCurrentItem(0);
                break;
            case R.id.tv_xianchang:
                tv_fangan.setTextColor(Color.BLACK);
                tv_xianchang.setTextColor(getColor(R.color.bule));
                tv_zeren.setTextColor(Color.BLACK);
                tv_jiejue.setTextColor(Color.BLACK);
                tv_yuan.setTextColor(Color.BLACK);
                tv_zijin.setTextColor(Color.BLACK);
                vp_to_be_audited.setCurrentItem(1);
                break;
            case R.id.tv_zeren:
                tv_fangan.setTextColor(Color.BLACK);
                tv_xianchang.setTextColor(Color.BLACK);
                tv_zeren.setTextColor(getColor(R.color.bule));
                tv_jiejue.setTextColor(Color.BLACK);
                tv_yuan.setTextColor(Color.BLACK);
                tv_zijin.setTextColor(Color.BLACK);
                vp_to_be_audited.setCurrentItem(2);
                break;
            case R.id.tv_jiejue:
                tv_fangan.setTextColor(Color.BLACK);
                tv_xianchang.setTextColor(Color.BLACK);
                tv_zeren.setTextColor(Color.BLACK);
                tv_jiejue.setTextColor(getColor(R.color.bule));
                tv_yuan.setTextColor(Color.BLACK);
                tv_zijin.setTextColor(Color.BLACK);
                vp_to_be_audited.setCurrentItem(3);
                break;
            case R.id.tv_yuan:
                tv_fangan.setTextColor(Color.BLACK);
                tv_xianchang.setTextColor(Color.BLACK);
                tv_zeren.setTextColor(Color.BLACK);
                tv_jiejue.setTextColor(Color.BLACK);
                tv_yuan.setTextColor(getColor(R.color.bule));
                tv_zijin.setTextColor(Color.BLACK);
                vp_to_be_audited.setCurrentItem(4);
                break;
            case R.id.tv_zijin:
                tv_fangan.setTextColor(Color.BLACK);
                tv_xianchang.setTextColor(Color.BLACK);
                tv_zeren.setTextColor(Color.BLACK);
                tv_jiejue.setTextColor(Color.BLACK);
                tv_yuan.setTextColor(Color.BLACK);
                tv_zijin.setTextColor(getColor(R.color.bule));
                vp_to_be_audited.setCurrentItem(5);
                break;
        }
    }


    class MyViewPager extends FragmentStatePagerAdapter {

        private List<Fragment> fragmentList;

        public MyViewPager(FragmentManager fm, List<Fragment> fragmentList) {
            super(fm);
            this.fragmentList = fragmentList;
        }


        @Override
        public Fragment getItem(int position) {
            return fragmentList.get(position);
        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }
    }
}
