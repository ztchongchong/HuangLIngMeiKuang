package com.lingjun.colliery_android.module.dealwith.standardized.review.fragment;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.lingjun.colliery_android.R;
import com.lingjun.colliery_android.base.BaseFragment;
import com.lingjun.colliery_android.bean.ToReviewBean;
import com.lingjun.colliery_android.module.dealwith.fragment.ZeroTaskFragment;
import com.lingjun.colliery_android.utils.DateUtil;
import com.lingjun.colliery_android.view.DiscView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * 结果汇总
 * Created by nefa on 2018/11/7.
 */

public class ResultsSummaryFragment extends BaseFragment {
    private static final String KEY = "title";
    private ToReviewBean.DataBean bean;
    @BindView(R.id.xiangmu_num)
     TextView xiangmu_num;
    @BindView(R.id.file_num)
     TextView file_num;
    @BindView(R.id.hour)
     TextView hour;
    @BindView(R.id.minute)
     TextView minute;
    @BindView(R.id.score_str)
     TextView score_str;
    @BindView(R.id.disc)
     DiscView disc;
    @BindView(R.id.remark_text)
     TextView remark_text;
    private double scores;
    private boolean readtype;

    @Override
    protected int setLayout(LayoutInflater inflater) {
        return R.layout.fragment_results_summary;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        Bundle bundle = getArguments();
        bean = (ToReviewBean.DataBean) bundle.getSerializable("bean");
        refreshView();
        initData();
    }

    private void initData() {
        readtype = bean.isReadingopinions();
        scores = bean.getAutoscore();
        score_str.setText(scores + "");
        Log.e("黄泉", bean.getAutoscore()+"");
        double value = 36 * scores;
        disc.setValue(value);
        xiangmu_num.setText(bean.getItemcount() + "");
        file_num.setText(bean.getFilecount() + "");
        if (!TextUtils.isEmpty(bean.getSummary())) {
            remark_text.setText(bean.getSummary());
        } else {
            remark_text.setText("暂无评分说明");
        }
        long time = Math.abs(bean.getTime());
        String timestr = DateUtil.getTime(time);
        hour.setText(timestr.split(":")[0]);
        minute.setText(timestr.split(":")[1]);
    }


    public static ResultsSummaryFragment newInstance(String str, int pos, ToReviewBean.DataBean bean) {
        ResultsSummaryFragment fragment = new ResultsSummaryFragment();
        Bundle bundle = new Bundle();
        bundle.putString(KEY, str);
        bundle.putSerializable("bean", bean);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected BaseRefreshLoadMoreInterface setRefreshLoadMoreListener() {
        return new BaseRefreshLoadMoreInterface() {
            @Override
            public void onLoadMore() {
                refreshView();
            }

            @Override
            public void onRefresh() {
                refreshView();
            }
        };
    }

    private void refreshView() {
        if (null != refreshLayout) {
            refreshLayout.finishRefresh();
            refreshLayout.finishLoadMore();
        }
    }
}
