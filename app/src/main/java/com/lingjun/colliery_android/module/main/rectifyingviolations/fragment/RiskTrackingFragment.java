package com.lingjun.colliery_android.module.main.rectifyingviolations.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lingjun.colliery_android.R;
import com.lingjun.colliery_android.base.BaseFragment;
import com.lingjun.colliery_android.base.OnGlobalListener;
import com.lingjun.colliery_android.bean.HiddenDangerDetailsBean;
import com.lingjun.colliery_android.bean.HiddenDangerPlanBean;
import com.lingjun.colliery_android.bean.RiskTrackingsBean;
import com.lingjun.colliery_android.utils.RecyclerViewUtils;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 作者: zengtao
 * 时间: 2019/5/5  10:24.
 * 注释:  风险跟踪
 */
public class RiskTrackingFragment extends BaseFragment {
    @BindView(R.id.tv_name)
    TextView tvName;//责任人
    @BindView(R.id.tv_time)
    TextView tvTime;//计划开始时间
    @BindView(R.id.tv_cycle)
    TextView tvCycle;//检查周期
    @BindView(R.id.tv_date)
    TextView tvDate;//检查日期
    @BindView(R.id.tv_content)
    TextView tvContent;//基本措施
    @BindView(R.id.rv_list)
    RecyclerView rvList;
    @BindView(R.id.refreshLayout)
    SmartRefreshLayout refreshLayout;


    private RiskTrackingsBean mParam;

    public RiskTrackingFragment() {
    }

    public static RiskTrackingFragment newInstance(RiskTrackingsBean riskTrackingsBean) {
//        Bundle args = new Bundle();
//        RiskTrackingFragment fragment = new RiskTrackingFragment();
//        fragment.setArguments(args);
        RiskTrackingFragment fragment = new RiskTrackingFragment();
        fragment.mParam = riskTrackingsBean;
        return fragment;
    }

    @Override
    protected int setLayout(LayoutInflater inflater) {
        return R.layout.fragment_risk_tracking;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        if (mParam != null && mParam.getData() != null) {
            dataDisplay(mParam.getData());
        }
    }

    /**
     * 数据展示
     *
     * @param data
     */
    private void dataDisplay(final RiskTrackingsBean.DataBean data) {
        if (null != data) {
            tvName.setText(data.getRiskcontrolTrouble().getMeasures().getResponsibleName());//责任人
            String begindate = new SimpleDateFormat("yyyy-MM-dd").format(new Date(data.getRiskcontrolTrouble().getMeasures().getBeginDate()));
            tvTime.setText(begindate);//计划开始时间
            if (data.getRiskcontrolTrouble().getMeasures().getCheckCycle().equals("1")) {
                tvCycle.setText("旬");//检查周期
            } else {
                tvCycle.setText("月");//检查周期
            }
//            String checkdate = new SimpleDateFormat("dd" + "号").format(new Date(data.getRiskcontrolTrouble().getMeasures().getCheckdate());
            tvDate.setText(data.getRiskcontrolTrouble().getMeasures().getCheckdate() + "号");//检查日期
            String cuoshi = data.getRiskcontrolTrouble().getRiskcontrolSourceMeasures().replace("&ldquo;", "“").replace("&rdquo;", "”");
            tvContent.setText(cuoshi);//基本措施
            if (null != data.getImplementlist()) {
                RecyclerViewUtils.initLiner(getActivity(), rvList, R.layout.item_fragment_risk_tracking, data.getImplementlist(), new OnGlobalListener() {
                    @Override
                    public <T> void logic(BaseViewHolder helper, List<T> mData, T item, BaseQuickAdapter mAdapter) {
                        RiskTrackingsBean.DataBean.ImplementlistBean resultsBean = (RiskTrackingsBean.DataBean.ImplementlistBean) item;
                        TextView tv_content = helper.getView(R.id.tv_content);
                        String time = new SimpleDateFormat("yyyy-MM-dd").format(new Date(resultsBean.getCheckdate()));
                        TextView tv_state = helper.getView(R.id.tv_state);
                        if (resultsBean.getImplementState().equals("0")) {
                            tv_content.setText(time + "(空)");
                            tv_state.setText("未检查");
                        } else if (resultsBean.getImplementState().equals("1")) {
                            tv_content.setText(time);
                            tv_state.setText("正常");
                        } else if (resultsBean.getImplementState().equals("2")) {
                            tv_content.setText(time);
                            tv_state.setText("异常");
                        }
                    }
                }, new BaseQuickAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                        RiskTrackingsBean.DataBean.ImplementlistBean implementlistBean = (RiskTrackingsBean.DataBean.ImplementlistBean) adapter.getData().get(position);

                        Intent intent = new Intent(getActivity(), ItemRiskTrackingActivity.class);
                        intent.putExtra("data", implementlistBean);
                        startActivity(intent);


                    }
                }, null);
            }

        }
    }

    @Override
    protected BaseRefreshLoadMoreInterface setRefreshLoadMoreListener() {
        return null;
    }
}
