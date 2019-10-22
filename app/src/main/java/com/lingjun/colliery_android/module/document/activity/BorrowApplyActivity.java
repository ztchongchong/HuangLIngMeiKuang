package com.lingjun.colliery_android.module.document.activity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.StringUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lingjun.colliery_android.R;
import com.lingjun.colliery_android.base.BaseActivity;
import com.lingjun.colliery_android.base.BaseLinkList;
import com.lingjun.colliery_android.base.OnGlobalListener;
import com.lingjun.colliery_android.bean.BorrowInfoBean;
import com.lingjun.colliery_android.bean.DocumentInfoBean;
import com.lingjun.colliery_android.bean.Result;
import com.lingjun.colliery_android.utils.DateUtil;
import com.lingjun.colliery_android.utils.FastJsonTools;
import com.lingjun.colliery_android.utils.RecyclerViewUtils;
import com.lingjun.colliery_android.utils.retrofit.BaseSubscriber;
import com.lingjun.colliery_android.utils.retrofit.ExceptionHandle;

import org.json.JSONObject;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 作者: lihuan
 * 时间: 2018/12/18 9:34
 * 说明: 借阅申请
 */
public class BorrowApplyActivity extends BaseActivity {

    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_status)
    TextView tvStatus;
    @BindView(R.id.tv_doc_name)
    TextView tvDocName;
    @BindView(R.id.tv_doc_number)
    TextView tvDocNumber;
    @BindView(R.id.tv_standard)
    TextView tvGuiFan;
    @BindView(R.id.iv_show_more)
    ImageView ivShowMore;
    @BindView(R.id.ll_show_more)
    LinearLayout llShowMore;
    @BindView(R.id.tv_create_time)
    TextView tvTime;
    @BindView(R.id.tv_flag)
    TextView tvFlag;
    @BindView(R.id.tv_day)
    TextView tvDay;
    @BindView(R.id.rv_document_list)
    RecyclerView rv_list;
    @BindView(R.id.tv_borrow_day_count)
    TextView tvBorrowDayCount;
    @BindView(R.id.ll_borrow_day_count)
    LinearLayout llBorrowDayCount;
    @BindView(R.id.tv_borrow_time)
    TextView tvBorrowTime;
    @BindView(R.id.ll_borrow_time)
    LinearLayout llBorrowTime;
    @BindView(R.id.et_reason)
    EditText etReason;
    @BindView(R.id.btn_commit)
    Button btnCommit;
    @BindView(R.id.ll_commit)
    LinearLayout llCommit;
    @BindView(R.id.cl_content)
    ConstraintLayout layout;

    private int taskId = 0;
    private BorrowInfoBean.ResultMapsBean resultMapsBean;
    private DocumentInfoBean.DataBean.PageBean.ResultsBean searchBean;

    @Override
    protected int getResourcesId() {
        return R.layout.activity_borrow_apply;
    }

    @Override
    protected BaseRefreshLoadMoreInterface setRefreshLoadMoreListener() {
        return null;
    }

    @Override
    protected void init(Bundle savedInstanceState) {

        taskId = getIntent().getIntExtra("taskId", 0);
        String from = getIntent().getStringExtra("from");
        searchBean = (DocumentInfoBean.DataBean.PageBean.ResultsBean) getIntent().getSerializableExtra("searchDocInfo");
        if ("applyList".equals(from)) {
            tvName.setText("申请详情");
            tvStatus.setVisibility(View.VISIBLE);
            llBorrowDayCount.setVisibility(View.VISIBLE);
            etReason.setEnabled(false);
            llCommit.setVisibility(View.GONE);
            ivShowMore.setVisibility(View.VISIBLE);
            llShowMore.setEnabled(true);
            llBorrowTime.setEnabled(false);
            layout.setVisibility(View.GONE);
            tvDay.setVisibility(View.GONE);
            getBorrowDetail();
        } else {
            tvName.setText("借阅申请");
            tvStatus.setVisibility(View.GONE);
            llBorrowDayCount.setVisibility(View.GONE);
            etReason.setEnabled(true);
            ivShowMore.setVisibility(View.GONE);
            llShowMore.setEnabled(false);
            layout.setVisibility(View.VISIBLE);
            llCommit.setVisibility(View.VISIBLE);
            tvDay.setVisibility(View.GONE);
            setData();
        }
    }

    /**
     * 设置借阅申请数据
     */
    private void setData() {
        if (searchBean != null) {
            tvDocName.setText(searchBean.getName());
            tvDocNumber.setText("编号：" + StringUtils.null2Length0(searchBean.getNumber()));
            tvGuiFan.setText("规范：" + StringUtils.null2Length0(searchBean.getStdname()));
            tvTime.setText("创建：" + DateUtil.getStringByFormat(searchBean.getTimestamp(), "yyyy-MM-dd"));
            StringBuilder builder = new StringBuilder();
            if (searchBean.getEditionKeysName() != null) {
                for (int i = 0; i < searchBean.getEditionKeysName().size(); i++) {
                    DocumentInfoBean.DataBean.PageBean.ResultsBean.EditionKeysNameBean flag =
                            searchBean.getEditionKeysName().get(i);
                    builder.append(flag.getName());
                    if (i != searchBean.getEditionKeysName().size() - 1) {
                        builder.append("、");
                    }
                }
            }
            tvFlag.setText("标签：" + builder.toString());
            if (searchBean.getFileData() != null && searchBean.getFileData().getFiles() != null) {
                RecyclerViewUtils.initLiner(BorrowApplyActivity.this, rv_list, R.layout.item_deal_with_file2, searchBean.getFileData().getFiles(), new OnGlobalListener() {
                    @Override
                    public <T> void logic(BaseViewHolder helper, List<T> mData, T item, BaseQuickAdapter mAdapter) {
                        DocumentInfoBean.DataBean.PageBean.ResultsBean.FileDataBean.FilesBean resultsBean = (DocumentInfoBean.DataBean.PageBean.ResultsBean.FileDataBean.FilesBean) item;
                        TextView imgName = helper.getView(R.id.tv_img_name);

                        if (resultsBean.getSysFiles() != null && resultsBean.getSysFiles().getFilename() != null) {
                            imgName.setText(resultsBean.getSysFiles().getFilename());
                        }

                    }
                }, new BaseQuickAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                        DocumentInfoBean.DataBean.PageBean.ResultsBean.FileDataBean.FilesBean resultsBean = (DocumentInfoBean.DataBean.PageBean.ResultsBean.FileDataBean.FilesBean) adapter.getData().get(position);
                        if (resultsBean.getSysFiles() != null && resultsBean.getSysFiles().getFilename() != null) {
                            ToastUtils.showShort(resultsBean.getSysFiles().getFilename());
                        }
                    }
                }, null);
            }
        }

    }

    @OnClick(R.id.iv_back)
    public void onIvBackClicked() { //返回
        finish();
    }

    @OnClick(R.id.ll_show_more)
    public void onLlShowMoreClicked() { //展开界面
        if (resultMapsBean.isOpen()) {
            layout.setVisibility(View.GONE);
            resultMapsBean.setOpen(false);
            ivShowMore.setImageResource(R.drawable.ic_arrow_down);
        } else {
            layout.setVisibility(View.VISIBLE);
            resultMapsBean.setOpen(true);
            ivShowMore.setImageResource(R.drawable.ic_arrow_up);
        }
    }

    @OnClick(R.id.ll_borrow_day_count)
    public void onLlBorrowDayCountClicked() { //选择天数
    }

    boolean isStart = true;
    int day = 0;

    @OnClick(R.id.ll_borrow_time)
    public void onLlBorrowTimeClicked() { //选择时间
        isStart = true;
        new DatePickerDialog(this,
                // 绑定监听器(How the parent is notified that the date is set.)
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year,
                                          int monthOfYear, int dayOfMonth) {
                        // 此处得到选择的时间，可以进行你想要的操作
                        final Calendar c1 = Calendar.getInstance();
                        c1.set(year, monthOfYear, dayOfMonth);
                        if (c1.getTimeInMillis() <= System.currentTimeMillis() + 5000) {
                            ToastUtils.showShort("只能选择今日之后的日期");
                            return;
                        }
                        final String time = year + "-" + (monthOfYear + 1) + "-" + dayOfMonth;
                        if (isStart) {
                            isStart = false;
                            new DatePickerDialog(BorrowApplyActivity.this,
                                    // 绑定监听器(How the parent is notified that the date is set.)
                                    new DatePickerDialog.OnDateSetListener() {
                                        @Override
                                        public void onDateSet(DatePicker view, int year,
                                                              int monthOfYear, int dayOfMonth) {
                                            // 此处得到选择的时间，可以进行你想要的操作
                                            Calendar c = Calendar.getInstance();
                                            c.set(year, monthOfYear, dayOfMonth);
                                            String time1 = year + "-" + (monthOfYear + 1) + "-" + dayOfMonth;
//                                            if (time.compareTo(time1) >= 0) {
//                                                ToastUtils.showShort("只能选择开始时间之后的日期");
//                                                return;
//                                            }
                                            if (c.getTimeInMillis() <= c1.getTimeInMillis()) {
                                                ToastUtils.showShort("只能选择开始时间之后的日期");
                                                return;
                                            }
                                            long times = c.getTimeInMillis() - c1.getTimeInMillis();
                                            day = (int) (times / (1000 * 3600 * 24));
                                            tvBorrowTime.setText(time + " - " + time1);
                                        }
                                    }
                                    // 设置初始日期
                                    , Calendar.getInstance().get(Calendar.YEAR)
                                    , Calendar.getInstance().get(Calendar.MONTH)
                                    , Calendar.getInstance().get(Calendar.DAY_OF_MONTH)).show();
                        }
                    }
                }
                // 设置初始日期
                , Calendar.getInstance().get(Calendar.YEAR)
                , Calendar.getInstance().get(Calendar.MONTH)
                , Calendar.getInstance().get(Calendar.DAY_OF_MONTH)).show();
    }

    @OnClick(R.id.btn_commit)
    public void onBtnCommitClicked() { //申请借阅
        String borrowRemark = etReason.getText().toString().trim();
        if (day <= 0) {
            ToastUtils.showShort("请选择借阅时间");
            return;
        }
        if (StringUtils.isEmpty(borrowRemark)) {
            ToastUtils.showShort("请输入借阅理由");
            return;
        }

        getApplyBorrow(String.valueOf(day), borrowRemark);
    }


    /**
     * 借阅申请详情
     */
    private void getBorrowDetail() {

        HashMap hashMap = new HashMap<>();
        hashMap.put("taskId", taskId);//当前页码
        hashMap.put(BaseLinkList.apiurl, BaseLinkList.coal_mine + BaseLinkList.getApplyList);
        mRetrofit.JsonToColliery(BaseLinkList.Base_Url, hashMap, new BaseSubscriber() {
            @Override
            public void onError(ExceptionHandle.ResponeThrowable e) {
                if (null != refreshLayout) {
                    refreshLayout.finishRefresh();
                    refreshLayout.finishLoadMore();
                }
            }

            @Override
            public void onSuccess(JSONObject jsonObject) {
                LogUtils.e("借阅申请详情->>" + jsonObject.toString());

                BorrowInfoBean borrowInfoBean = FastJsonTools.getBean(jsonObject.toString(), BorrowInfoBean.class);
                if (null != borrowInfoBean && null != borrowInfoBean.getResultMaps()) {

                    resultMapsBean = borrowInfoBean.getResultMaps().get(0);

                    if (resultMapsBean != null) {
                        tvDocName.setText(resultMapsBean.getName());
                        tvDocNumber.setText("编号：" + StringUtils.null2Length0(resultMapsBean.getNumber()));
                        tvGuiFan.setText("规范：" + StringUtils.null2Length0(resultMapsBean.getStdname()));
                        tvTime.setText("创建：" + DateUtil.getStringByFormat(resultMapsBean.getEditionTime(), "yyyy-MM-dd"));
                        tvStatus.setText(resultMapsBean.getTaskStateFlag());
                        tvFlag.setText("标签：" + resultMapsBean.getKeysname());

                        tvBorrowDayCount.setText(resultMapsBean.getBorrowDay() + "天");
                        tvBorrowTime.setText(DateUtil.getStringByFormat(resultMapsBean.getBorrowTime(), "yyyy-MM-dd HH:mm"));
                        etReason.setText(resultMapsBean.getDescription());

                        if (resultMapsBean.getFileList() != null) {
                            RecyclerViewUtils.initLiner(BorrowApplyActivity.this, rv_list, R.layout.item_deal_with_file2, resultMapsBean.getFileList(), new OnGlobalListener() {
                                @Override
                                public <T> void logic(BaseViewHolder helper, List<T> mData, T item, BaseQuickAdapter mAdapter) {
                                    BorrowInfoBean.ResultMapsBean.FileListBean resultsBean = (BorrowInfoBean.ResultMapsBean.FileListBean) item;
                                    TextView imgName = helper.getView(R.id.tv_img_name);

                                    imgName.setText(StringUtils.null2Length0(resultsBean.getFilename()));

                                }
                            }, new BaseQuickAdapter.OnItemClickListener() {
                                @Override
                                public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                                    BorrowInfoBean.ResultMapsBean.FileListBean resultsBean = (BorrowInfoBean.ResultMapsBean.FileListBean) adapter.getData().get(position);
                                    ToastUtils.showShort(resultsBean.getFilename());
                                }
                            }, null);
                        }

                    }


                }

                if (null != refreshLayout) {
                    refreshLayout.finishRefresh();
                    refreshLayout.finishLoadMore();
                }
            }
        });
    }

    /**
     * 申请借阅
     */
    private void getApplyBorrow(String borrowDay, String borrowRemark) {

        HashMap hashMap = new HashMap<>();
        hashMap.put("editionId", searchBean.getId());//资料Id
        hashMap.put("borrowDay", borrowDay);//借阅天数
        hashMap.put("borrowRemark", borrowRemark);//借阅说明
        hashMap.put(BaseLinkList.apiurl, BaseLinkList.coal_mine + BaseLinkList.applyForborrowing);
        mRetrofit.JsonToColliery(BaseLinkList.Base_Url, hashMap, new BaseSubscriber() {
            @Override
            public void onError(ExceptionHandle.ResponeThrowable e) {
                if (null != refreshLayout) {
                    refreshLayout.finishRefresh();
                    refreshLayout.finishLoadMore();
                }
            }

            @Override
            public void onSuccess(JSONObject jsonObject) {
                LogUtils.e("申请借阅->>" + jsonObject.toString());

                Result result = FastJsonTools.getBean(jsonObject.toString(), Result.class);
                if (null != result && "200".equals(result.getCode())) {
                    ToastUtils.showShort("提交借阅申请成功");
                    finish();
                }

                if (null != refreshLayout) {
                    refreshLayout.finishRefresh();
                    refreshLayout.finishLoadMore();
                }
            }
        });
    }
}
