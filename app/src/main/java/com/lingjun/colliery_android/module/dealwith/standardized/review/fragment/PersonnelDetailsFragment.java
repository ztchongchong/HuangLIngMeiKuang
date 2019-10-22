package com.lingjun.colliery_android.module.dealwith.standardized.review.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lingjun.colliery_android.R;
import com.lingjun.colliery_android.base.BaseFragment;
import com.lingjun.colliery_android.base.OnGlobalListener;
import com.lingjun.colliery_android.bean.ToReviewBean;
import com.lingjun.colliery_android.module.dealwith.activity.InviteLeadActivity;
import com.lingjun.colliery_android.module.dealwith.standardized.audit.CooperateWithStaffActivity;
import com.lingjun.colliery_android.module.dealwith.standardized.audit.LeadershipActivity;
import com.lingjun.colliery_android.module.dealwith.standardized.audit.ResponsibleActivity;
import com.lingjun.colliery_android.module.dealwith.standardized.audit.SpecialPersonnelActivity;
import com.lingjun.colliery_android.utils.RecyclerViewUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * 人员详情
 * Created by nefa on 2018/11/12.
 */

public class PersonnelDetailsFragment extends BaseFragment {

    private static final String KEY = "title";
    private ToReviewBean.DataBean bean;
    @BindView(R.id.lingdao)
    TextView lingdao;
    @BindView(R.id.zerenren)
    TextView zerenren;
    @BindView(R.id.peihe)
    TextView peihe;
    @BindView(R.id.teyao)
    TextView teyao;

    @BindView(R.id.lingdao_rel)
    RelativeLayout lingdao_rel;
    @BindView(R.id.zerenren_rel)
    RelativeLayout zerenren_rel;
    @BindView(R.id.peihe_rel)
    RelativeLayout peihe_rel;
    @BindView(R.id.teyao_rel)
    RelativeLayout teyao_rel;

    private String taskid;
    private Intent intent;

    @Override
    protected int setLayout(LayoutInflater inflater) {
        return R.layout.fragment_personnel_details;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        Bundle bundle = getArguments();
        bean = (ToReviewBean.DataBean) bundle.getSerializable("bean");
        taskid = bundle.getString("taskid");
        Log.d("taskid", taskid);
        refreshView();
        initClick();
    }

    private void initClick() {
        lingdao_rel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent();
                intent.setClass(getActivity(), InviteLeadActivity.class);
                intent.putExtra("taskid", taskid);
                startActivity(intent);
            }
        });
        zerenren_rel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent();
                intent.setClass(getActivity(), ResponsibleActivity.class);
                intent.putExtra("taskid", taskid);
                startActivity(intent);
            }
        });
        peihe_rel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent();
                intent.setClass(getActivity(), CooperateWithStaffActivity.class);
                intent.putExtra("taskid", taskid);
                startActivity(intent);
            }
        });
        teyao_rel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent();
                intent.setClass(getActivity(), SpecialPersonnelActivity.class);
                intent.putExtra("taskid", taskid);
                startActivity(intent);
            }
        });

    }

    public static PersonnelDetailsFragment newInstance(String str, int pos, ToReviewBean.DataBean bean, String taskid) {
        PersonnelDetailsFragment fragment = new PersonnelDetailsFragment();
        Bundle bundle = new Bundle();
        bundle.putString(KEY, str);
        bundle.putInt("pos", pos);
        bundle.putSerializable("bean", bean);
        bundle.putString("taskid", taskid);
        fragment.setArguments(bundle);
        return fragment;
    }


    @Override
    protected BaseRefreshLoadMoreInterface setRefreshLoadMoreListener() {
        return null;
    }

    private void refreshView() {
        lingdao.setText(bean.getLeadercount() + "名");
        zerenren.setText(bean.getResponsiblecount() + "名");
        peihe.setText(bean.getCooperatorcount() + "名");
        teyao.setText(bean.getInvitedcount() + "名");
    }

}
