package com.lingjun.colliery_android.module.dealwith.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.TextView;

import com.lingjun.colliery_android.R;
import com.lingjun.colliery_android.base.BaseFragment;
import com.lingjun.colliery_android.bean.ImplementedBean;

import java.text.SimpleDateFormat;
import java.util.Date;

import butterknife.BindView;


/**
 * 作者: zengtao
 * 时间: 2018/12/4  16:15.
 * 注释: 管控要求
 */
public class ControlRequirementsFragment extends BaseFragment {
    @BindView(R.id.tv_responsibleName)
    TextView tvResponsibleName;//责任人名字
    @BindView(R.id.tv_publisherTime)
    TextView tvPublisherTime;//管控日期
    @BindView(R.id.tv_riskcontrolSourceMeasures)
    TextView tvRiskcontrolSourceMeasures;//基本措施
    @BindView(R.id.tv_measures)
    TextView tvMeasures;//追加措施


    private String taskId = "";
    private int measuresId = 0;

    private ImplementedBean implemented;

    public ControlRequirementsFragment() {

    }

    public static ControlRequirementsFragment newInstance(ImplementedBean implementedBean) {
//        Bundle args = new Bundle();
        ControlRequirementsFragment fragment = new ControlRequirementsFragment();
        fragment.implemented = implementedBean;
        return fragment;
    }

    @Override
    protected int setLayout(LayoutInflater inflater) {
        return R.layout.fragment_control_requirements;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        if (implemented != null && implemented.getData() != null) {
            dataDisplay(implemented.getData());
        }
    }

    /**
     * 数据展示
     *
     * @param dataBean
     */
    private void dataDisplay(ImplementedBean.DataBean dataBean) {
        tvResponsibleName.setText(dataBean.getRiskcontrolTrouble().getMeasures().getResponsibleName());//责任人名字
        String t1 = new SimpleDateFormat("yyyy-MM-dd").format(new Date(dataBean.getImplement().getCheckdate()));
        tvPublisherTime.setText(t1);//管控日期
        tvRiskcontrolSourceMeasures.setText(dataBean.getRiskcontrolTrouble().getRiskcontrolSourceMeasures());//基本措施
        tvMeasures.setText(dataBean.getRiskcontrolTrouble().getMeasures().getMeasures());//追加措施
        measuresId = dataBean.getRiskcontrolTrouble().getMeasures().getId();
    }

    @Override
    protected BaseRefreshLoadMoreInterface setRefreshLoadMoreListener() {
        return null;
    }

}
