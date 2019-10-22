package com.lingjun.colliery_android.module.dealwith.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.blankj.utilcode.util.LogUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lingjun.colliery_android.R;
import com.lingjun.colliery_android.base.BaseActivity;
import com.lingjun.colliery_android.base.BaseLinkList;
import com.lingjun.colliery_android.base.OnGlobalListener;
import com.lingjun.colliery_android.bean.StandardizationDetailsBean;
import com.lingjun.colliery_android.bean.StandardizationListBean;
import com.lingjun.colliery_android.module.dealwith.hiddendanger.activity.RectificationListActivity;
import com.lingjun.colliery_android.utils.FastJsonTools;
import com.lingjun.colliery_android.utils.RecyclerViewUtils;
import com.lingjun.colliery_android.utils.retrofit.BaseSubscriber;
import com.lingjun.colliery_android.utils.retrofit.ExceptionHandle;
import com.ruffian.library.widget.RTextView;

import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 作者: zengtao
 * 时间: 2019/8/23  9:55.
 * 注释:标准化详情界面
 *
 * @author ztchongchong
 */
public class StandardizationDetailsActivity extends BaseActivity {
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_project)
    TextView tvProject;
    @BindView(R.id.tv_explain)
    TextView tvExplain;
    @BindView(R.id.tv_starttime)
    TextView tvStarttime;
    @BindView(R.id.tv_endtime)
    TextView tvEndtime;
    @BindView(R.id.tv_state)
    TextView tvState;
    @BindView(R.id.tv_score)
    TextView tvScore;
    @BindView(R.id.rl_Scoredetails)
    RelativeLayout rlScoredetails;

    private String taskid;
    private String jindu;
    private String defen;

    @Override
    protected int getResourcesId() {
        return R.layout.activity_standardizationdetails;
    }

    @Override
    protected void init(Bundle savedInstanceState) throws PackageManager.NameNotFoundException {
        taskid = getIntent().getStringExtra("taskId");
        jindu = getIntent().getStringExtra("jindu");
        defen = getIntent().getStringExtra("defen");
        refreshView();
    }

    private void refreshView() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(BaseLinkList.apiurl, BaseLinkList.coal_mine + BaseLinkList.getSmallStadchk);
        hashMap.put("taskid", taskid);
        hashMap.put("standdetail", "1");
        mRetrofit.get(BaseLinkList.Base_Url, hashMap, new BaseSubscriber() {
            @Override
            public void onError(ExceptionHandle.ResponeThrowable e) {

            }

            @Override
            public void onSuccess(JSONObject jsonObject) {
                LogUtils.e("列表->>" + jsonObject.toString());
                final StandardizationDetailsBean bean = FastJsonTools.getBean(jsonObject.toString(), StandardizationDetailsBean.class);
                if (null != bean) {
                    //标题
                    tvTitle.setText(bean.getTask().getTitle());
                    //项目
                    if (bean.getProject().getCustom() == 0) {
                        tvProject.setText("标准化检查");
                    } else {
                        tvProject.setText(bean.getProject().getCategoryName());
                        rlScoredetails.setVisibility(View.GONE);
                    }
                    //说明
                    tvExplain.setText(bean.getTask().getDescription());
                    //开始时间
                    tvStarttime.setText(new SimpleDateFormat("yyyy-MM-dd").format(new Date(bean.getProject().getStarttime())));
                    //结束时间
                    tvEndtime.setText(new SimpleDateFormat("yyyy-MM-dd").format(new Date(bean.getProject().getFinishtime())));
                    //状态
                    switch (bean.getTask().getState()) {
                        case "1":
                            tvState.setText("草稿");
                            tvScore.setText(jindu);
                            break;
                        case "2":
                            tvState.setText("待审核");
                            tvScore.setText(jindu);
                            break;
                        case "3":
                            tvState.setText("审核通过");
                            tvScore.setText(jindu);
                            break;
                        case "4":
                            tvState.setText("审核驳回");
                            tvScore.setText(jindu);
                            break;
                        case "5":
                            tvState.setText("分配中");
                            tvScore.setText(jindu);
                            break;
                        case "6":
                            tvState.setText("待检查");
                            tvScore.setText(jindu);
                            break;
                        case "7":
                            tvState.setText("检查中");
                            tvScore.setText(jindu);
                            break;
                        case "8":
                            tvState.setText("已评分");
                            tvScore.setText(defen + "分");
                            break;
                        case "9":
                            tvState.setText("审阅中");
                            tvScore.setText(defen + "分");
                            break;
                        case "10":
                            tvState.setText("待存储");
                            tvScore.setText(defen + "分");
                            break;
                        case "11":
                            tvState.setText("已存储");
                            tvScore.setText(defen + "分");
                            break;
                        case "12":
                            tvState.setText("已归档");
                            tvScore.setText(defen + "分");
                            break;
                        default:
                    }
                }
            }
        });
    }

    @Override
    protected BaseRefreshLoadMoreInterface setRefreshLoadMoreListener() {
        return null;
    }

    @OnClick(R.id.rl_Scoredetails)
    public void onViewClicked() {
        //得分
        Intent intent = new Intent(StandardizationDetailsActivity.this, ScoreDetailsActivity.class);
        intent.putExtra("taskid", taskid + "");
        startActivity(intent);
    }
}
