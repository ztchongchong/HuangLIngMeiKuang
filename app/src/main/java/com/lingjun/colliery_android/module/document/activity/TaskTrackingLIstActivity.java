package com.lingjun.colliery_android.module.document.activity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lingjun.colliery_android.R;
import com.lingjun.colliery_android.base.BaseActivity;
import com.lingjun.colliery_android.base.BaseLinkList;
import com.lingjun.colliery_android.base.OnGlobalListener;
import com.lingjun.colliery_android.bean.TaskTrackingBean;
import com.lingjun.colliery_android.bean.TaskTrackingLIstBean;
import com.lingjun.colliery_android.utils.FastJsonTools;
import com.lingjun.colliery_android.utils.RecyclerViewUtils;
import com.lingjun.colliery_android.utils.retrofit.BaseSubscriber;
import com.lingjun.colliery_android.utils.retrofit.ExceptionHandle;
import com.lingjun.colliery_android.view.RoundlProgresWithNum;

import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 作者: zengtao
 * 时间: 2019/2/18  8:56.
 * 注释: 任务跟踪详情
 */
public class TaskTrackingLIstActivity extends BaseActivity {
    private RoundlProgresWithNum rpw_jindu;//自定义圆形进度条 带数字进度
    private Timer timer32;
    private ConstraintLayout cl_content;
    private ImageView iv_show_more;
    private boolean isOpen = false;
    private RecyclerView rv_document_list;
    private String taskId;
    private ArrayList<TaskTrackingLIstBean.ResultMapsBean> results = new ArrayList<>();
    private TextView tv_doc_number;//编号
    private TextView tv_doc_name;//资料名称
    private TextView tv_borrowing_time;//借阅时间
    private TextView tv_standard;//规范
    private TextView tv_borrowing_explain;//借阅说明
    private TextView tv_create_time;//创建时间

    @Override
    protected int getResourcesId() {
        return R.layout.activity_tasktracking_list;
    }

    @Override
    protected void init(Bundle savedInstanceState) throws PackageManager.NameNotFoundException {
        Intent intent = getIntent();
        taskId = intent.getStringExtra("taskId");
        iv_show_more = findViewById(R.id.iv_show_more);
        cl_content = findViewById(R.id.cl_content);
        rv_document_list = findViewById(R.id.rv_document_list);
        tv_doc_number = findViewById(R.id.tv_doc_number);
        tv_doc_name = findViewById(R.id.tv_doc_name);
        tv_borrowing_time = findViewById(R.id.tv_borrowing_time);
        tv_borrowing_explain = findViewById(R.id.tv_borrowing_explain);
        tv_standard = findViewById(R.id.tv_standard);
        tv_create_time = findViewById(R.id.tv_create_time);
        //Circle progress no num
        rpw_jindu = findViewById(R.id.rpw_jindu);
        rpw_jindu.setProgress(0);
        rpw_jindu.setMax(100);

        timer32 = new Timer();
        timer32.schedule(new TimerTask() {
            @Override
            public void run() {
                //实时更新进度
                if (rpw_jindu.getProgress() >= 100) {//指定时间取消
                    timer32.cancel();
                }
                rpw_jindu.setProgress(rpw_jindu.getProgress() + 1);

            }
        }, 30, 20);

        iv_show_more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isOpen) {
                    isOpen = false;
                    cl_content.setVisibility(View.VISIBLE);
                    iv_show_more.setImageResource(R.drawable.ic_arrow_up);
                } else {
                    isOpen = true;
                    cl_content.setVisibility(View.GONE);
                    iv_show_more.setImageResource(R.drawable.ic_arrow_down);
                }

            }
        });
        refreshView();
    }


    private void refreshView() {
        LogUtils.e("当前第" + pageIndex + "页");

        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("taskId", taskId);
        hashMap.put(BaseLinkList.apiurl, BaseLinkList.coal_mine + BaseLinkList.getApplyfollow);

        mRetrofit.JsonToColliery(BaseLinkList.Base_Url, hashMap, new BaseSubscriber() {
            @Override
            public void onError(ExceptionHandle.ResponeThrowable e) {
                refreshLayout.setVisibility(View.GONE);
//                ll_beijing.setVisibility(View.VISIBLE);
                if (null != refreshLayout) {
                    refreshLayout.finishRefresh();
                    refreshLayout.finishLoadMore();
                }
            }

            @Override
            public void onSuccess(JSONObject jsonObject) {
                LogUtils.e("列表->>" + jsonObject.toString());

                final TaskTrackingLIstBean taskTrackingLIstBean = FastJsonTools.getBean(jsonObject.toString(), TaskTrackingLIstBean.class);
                if (null != taskTrackingLIstBean && null != taskTrackingLIstBean.getMsg() && null != taskTrackingLIstBean.getCode() && null != taskTrackingLIstBean.getResultMaps()) {
                    results = (ArrayList<TaskTrackingLIstBean.ResultMapsBean>) taskTrackingLIstBean.getResultMaps();

                    tv_doc_number.setText("编号:" + results.get(0).getNumber());
                    tv_doc_name.setText(results.get(0).getName());
                    tv_standard.setText("规范:" + results.get(0).getStdname());
                    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                    String t = format.format(results.get(0).getBorrowTime());
                    tv_borrowing_time.setText(t);
                    tv_borrowing_explain.setText(results.get(0).getDescription());
                    SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                    String t1 = format1.format(results.get(0).getTimestamp());
                    tv_create_time.setText("创建:"+t1);

                    if (results.size() != 0) {
                        refreshLayout.setVisibility(View.VISIBLE);
//                        ll_beijing.setVisibility(View.GONE);
                        if (pageIndex > 1) {
                            if (null != results && results.size() != 0) {
                                BaseQuickAdapter adapter = (BaseQuickAdapter) rv_document_list.getAdapter();
                                ArrayList<TaskTrackingLIstBean.ResultMapsBean> data = (ArrayList<TaskTrackingLIstBean.ResultMapsBean>) adapter.getData();
                                for (int i = 0; i < results.size(); i++) {
                                    data.add(results.get(i));
                                    adapter.notifyItemChanged(data.size() + (i + 1), results.get(i));
                                }
                            } else {
                                ToastUtils.showShort("没有更多数据了!");
                            }
                        } else {
                            RecyclerViewUtils.initLiner(TaskTrackingLIstActivity.this, rv_document_list, R.layout.item_tasktrackinglist, results, new OnGlobalListener() {
                                @Override
                                public <T> void logic(BaseViewHolder helper, List<T> mData, T item, BaseQuickAdapter mAdapter) {
                                    TaskTrackingLIstBean.ResultMapsBean resultsBean = (TaskTrackingLIstBean.ResultMapsBean) item;
//                                    ArrayList<TaskTrackingLIstBean.ResultMapsBean.FileListBean> fileListBeanArrayList = (ArrayList<TaskTrackingLIstBean.ResultMapsBean.FileListBean>) resultsBean.getFileList();
                                    TextView tv_name = helper.getView(R.id.tv_name);
                                    if (resultsBean != null && TextUtils.isEmpty(resultsBean + "+")) {
                                        for (int i = 0; i < resultsBean.getFileList().size(); i++) {
                                            ArrayList<String> a = new ArrayList<>();
                                            a.add(resultsBean.getFileList().get(i).getFilename());
                                            tv_name.setText(a + "");
                                        }
                                    }

                                }
                            }, new BaseQuickAdapter.OnItemClickListener() {
                                @Override
                                public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                                }
                            }, null);
                        }
                    } else {
                        refreshLayout.setVisibility(View.GONE);
//                        ll_beijing.setVisibility(View.VISIBLE);
                    }
                }

                if (null != refreshLayout) {
                    refreshLayout.finishRefresh();
                    refreshLayout.finishLoadMore();
                }
            }
        });


    }

    @Override
    protected BaseRefreshLoadMoreInterface setRefreshLoadMoreListener() {
        return null;
    }


}
