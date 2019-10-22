package com.lingjun.colliery_android.module.document.activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.blankj.utilcode.util.ConvertUtils;
import com.blankj.utilcode.util.KeyboardUtils;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.StringUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lingjun.colliery_android.R;
import com.lingjun.colliery_android.base.BaseActivity;
import com.lingjun.colliery_android.base.BaseLinkList;
import com.lingjun.colliery_android.base.OnGlobalListener;
import com.lingjun.colliery_android.bean.DocumentInfoBean;
import com.lingjun.colliery_android.module.document.fragment.DocSearchSideCategoryFragment;
import com.lingjun.colliery_android.utils.DateUtil;
import com.lingjun.colliery_android.utils.FastJsonTools;
import com.lingjun.colliery_android.utils.RecyclerViewUtils;
import com.lingjun.colliery_android.utils.retrofit.BaseSubscriber;
import com.lingjun.colliery_android.utils.retrofit.ExceptionHandle;
import com.vondear.rxtool.RxImageTool;
import com.vondear.rxtool.RxRecyclerViewDividerTool;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 作者: lihuan
 * 时间: 2018/12/18 10:10
 * 说明: 二次检索列表
 */
public class DocumentSearchListActivity extends BaseActivity implements DocSearchSideCategoryFragment.OnSearchCategoryListener {

    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.iv_filter)
    ImageView ivFilter;
    @BindView(R.id.et_key)
    EditText etKey;
    @BindView(R.id.btn_search)
    TextView btnSearch;
    @BindView(R.id.iv_del_keyword)
    ImageView ivDelKeyword;
    @BindView(R.id.rv_list)
    RecyclerView rv_list;
    @BindView(R.id.recy_data_search_history)
    RecyclerView recyHistory;
    @BindView(R.id.tv_clear_history)
    TextView tvClearHistory;
    @BindView(R.id.tv_close)
    TextView tvCloseHistory;
    @BindView(R.id.rl_history_ctrl)
    RelativeLayout rlHistoryCtrl;
    @BindView(R.id.ll_search_history)
    LinearLayout llSearchHistory;

    //    private String searchContent;
//    private final String[] data = new String[]{
//            "小猪猪", "小狗狗", "小鸡鸡", "小猫猫", "小咪咪"
//    };
    private List<String> searchHistory = new ArrayList<>();

    private int taskType = 0; //任务类型
    private String keyWord = ""; //搜索关键字
    private String startTime = ""; //开始时间
    private String endTime = "";//结束时间
    private String tag = "";//筛选标签

    @Override
    protected int getResourcesId() {
        return R.layout.activity_document_search_list;
    }

    @Override
    protected BaseRefreshLoadMoreInterface setRefreshLoadMoreListener() {
        return new BaseRefreshLoadMoreInterface() {
            @Override
            public void onLoadMore() {
                refreshView(taskType, keyWord, startTime, endTime, tag);
            }

            @Override
            public void onRefresh() {
                refreshView(taskType, keyWord, startTime, endTime, tag);
            }
        };
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        searchHistory.clear();
        keyWord = getIntent().getStringExtra("searchContent");
        SharedPreferences token = getSharedPreferences("userinfo", Context.MODE_PRIVATE);
        String json = token.getString("searchHistory", "");
        if (!StringUtils.isEmpty(json)) {
            List<String> list = new Gson().fromJson(json, new TypeToken<List<String>>() {
            }.getType());
            searchHistory.addAll(list);
        }
        etKey.setText(keyWord);
        rv_list.setLayoutManager(new LinearLayoutManager(DocumentSearchListActivity.this));
        rv_list.addItemDecoration(new RxRecyclerViewDividerTool(0, 0, 0, RxImageTool.dp2px(8f), true));
        recyHistory.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

        etKey.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                llSearchHistory.setVisibility(View.VISIBLE);
                refreshLayout.setVisibility(View.GONE);
                setSearchHistory();
                return false;
            }
        });


    }

    /**
     * 初始化历史搜索记录
     */
    private void setSearchHistory() {

        ArrayList<String> strings = new ArrayList<>();
        for (String str : searchHistory) {
            strings.add(str);
        }

        if (searchHistory.size() == 0) {
            llSearchHistory.setVisibility(View.GONE);
            refreshLayout.setVisibility(View.VISIBLE);
        }

        RecyclerViewUtils.initLiner(this, recyHistory, R.layout.item_search_history, strings, new OnGlobalListener() {
            @Override
            public <T> void logic(BaseViewHolder helper, List<T> mData, T item, BaseQuickAdapter mAdapter) {
                String str = (String) item;
                TextView name = helper.getView(R.id.tv_history_name);
                name.setText(str);

            }
        }, new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                String content = (String) adapter.getData().get(position);
                etKey.setText(content);
                etKey.clearFocus();
//                etKey.setSelection(content.length());
                llSearchHistory.setVisibility(View.GONE);
                refreshLayout.setVisibility(View.VISIBLE);
                KeyboardUtils.hideSoftInput(DocumentSearchListActivity.this);
            }
        }, null);
    }

    /**
     * 检索资料列表
     *
     * @param taskType
     * @param keyWord
     * @param startTime
     * @param endTime
     * @param tag
     */
    private void refreshView(int taskType, String keyWord, String startTime, String endTime, String tag) {
        LogUtils.e("当前第" + pageIndex + "页");

        HashMap<String, String> hashMap = new HashMap<>();

        hashMap.put("page", "" + pageIndex);//当前页码
        hashMap.put("pageSize", "10"); //每页数量
        if (!StringUtils.isEmpty(keyWord)) {
            hashMap.put("searchStr", keyWord); //关键字
        }
        if (taskType != 0) {
            hashMap.put("accreditVal", "" + taskType); //文件是否授权1授权文件2未授权文件
        }
        if (!StringUtils.isEmpty(keyWord)) {
            hashMap.put("keyValue", tag); //标签(可多选用分号;隔开)
        }
        if (!StringUtils.isEmpty(startTime)) {
            hashMap.put("startTime", startTime); //开始时间
        }
        if (!StringUtils.isEmpty(endTime)) {
            hashMap.put("endTime", endTime); //结束时间
        }
        hashMap.put(BaseLinkList.apiurl, BaseLinkList.coal_mine + BaseLinkList.getEditionList);
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
                LogUtils.e("检索资料列表->>" + jsonObject.toString());

                DocumentInfoBean documentInfoBean = FastJsonTools.getBean(jsonObject.toString(), DocumentInfoBean.class);
                if (null != documentInfoBean && null != documentInfoBean.getData() && null != documentInfoBean.getData().getPage()) {
                    final ArrayList<DocumentInfoBean.DataBean.PageBean.ResultsBean> results = documentInfoBean.getData().getPage().getResults();
                    if (pageIndex > 1) {
                        if (null != results && results.size() != 0) {
                            BaseQuickAdapter adapter = (BaseQuickAdapter) rv_list.getAdapter();
                            ArrayList<DocumentInfoBean.DataBean.PageBean.ResultsBean> data = (ArrayList<DocumentInfoBean.DataBean.PageBean.ResultsBean>) adapter.getData();
                            for (int i = 0; i < results.size(); i++) {
                                data.add(results.get(i));
                                adapter.notifyItemChanged(data.size() + (i + 1), results.get(i));
                            }
                        } else {
                            ToastUtils.showShort("没有更多数据了!");
                        }
                    } else {
                        RecyclerViewUtils.initLiner(DocumentSearchListActivity.this, rv_list, R.layout.item_document_search, results, new OnGlobalListener() {
                            @Override
                            public <T> void logic(BaseViewHolder helper, List<T> mData, T item, BaseQuickAdapter mAdapter) {
                                final DocumentInfoBean.DataBean.PageBean.ResultsBean resultsBean = (DocumentInfoBean.DataBean.PageBean.ResultsBean) item;
                                TextView tvTaskName = helper.getView(R.id.tv_doc_name);
                                TextView tvDocNumber = helper.getView(R.id.tv_doc_number);
                                LinearLayout llShowMore = helper.getView(R.id.ll_show_more);
                                TextView tvGuiFan = helper.getView(R.id.tv_standard);
                                final ImageView ivArrow = helper.getView(R.id.iv_show_more);
                                TextView tvTime = helper.getView(R.id.tv_create_time);
                                TextView tvFlag = helper.getView(R.id.tv_flag);
                                TextView tvDay = helper.getView(R.id.tv_day);
                                RecyclerView rv_list = helper.getView(R.id.rv_document_list);
                                final ConstraintLayout layout = helper.getView(R.id.cl_content);

                                if (resultsBean != null) {
                                    tvTaskName.setText(resultsBean.getName());
                                    tvDocNumber.setText("编号：" + StringUtils.null2Length0(resultsBean.getNumber()));
                                    tvGuiFan.setText("规范：" + StringUtils.null2Length0(resultsBean.getStdname()));
                                    tvTime.setText("创建：" + DateUtil.getStringByFormat(resultsBean.getTimestamp(), "yyyy-MM-dd"));

                                    //TODO
                                    tvDay.setText(Html.fromHtml("第 <font color='#FFCA28'>" + 4 + "</font> 天"));

                                    StringBuilder builder = new StringBuilder();
                                    if (resultsBean.getEditionKeysName() != null) {
                                        for (int i = 0; i < resultsBean.getEditionKeysName().size(); i++) {
                                            DocumentInfoBean.DataBean.PageBean.ResultsBean.EditionKeysNameBean flag =
                                                    resultsBean.getEditionKeysName().get(i);
                                            builder.append(flag.getName());
                                            if (i != resultsBean.getEditionKeysName().size() - 1) {
                                                builder.append("、");
                                            }
                                        }
                                    }
                                    tvFlag.setText("标签：" + builder.toString());
                                    if (resultsBean.getFileData() != null && resultsBean.getFileData().getFiles() != null) {
                                        RecyclerViewUtils.initLiner(DocumentSearchListActivity.this, rv_list, R.layout.item_deal_with_file2, resultsBean.getFileData().getFiles(), new OnGlobalListener() {
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

                                    if (resultsBean.isOpen()) {
                                        layout.setVisibility(View.VISIBLE);
                                        ivArrow.setImageResource(R.drawable.ic_arrow_up);
                                    } else {
                                        layout.setVisibility(View.GONE);
                                        ivArrow.setImageResource(R.drawable.ic_arrow_down);
                                    }

                                    llShowMore.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View view) {
                                            if (resultsBean.isOpen()) {
                                                resultsBean.setOpen(false);
                                                ivArrow.setImageResource(R.drawable.ic_arrow_down);
                                                layout.setVisibility(View.GONE);
                                            } else {
                                                resultsBean.setOpen(true);
                                                ivArrow.setImageResource(R.drawable.ic_arrow_up);
                                                layout.setVisibility(View.VISIBLE);
                                            }
                                        }
                                    });

                                    GradientDrawable drawable = (GradientDrawable) tvDay.getBackground();
                                    drawable.setColor(getResources().getColor(R.color.transparent));
                                    switch (resultsBean.getBorrowStatus()) {
                                        case 1: //可查阅
                                        case 2: //可借阅
                                            drawable.setColor(Color.parseColor("#2196F3"));
                                            tvDay.setText(Html.fromHtml("<font color='#FFFFFF'>申请查阅</font>"));
                                            break;
                                        case 3: //审核中
                                            drawable.setStroke(ConvertUtils.dp2px(0.5f), Color.parseColor("#FFCA28"));
                                            tvDay.setText(Html.fromHtml("<font color='#FFCA28'>审核中</font>"));
                                            break;
                                        case 4: //借阅中
                                            drawable.setStroke(1, Color.parseColor("#FFFFFF"));
                                            tvDay.setText(Html.fromHtml("<font color='#FFCA28'>第 " + 3 + " 天</font>"));
                                            break;
                                        case 5: //已拒绝
                                            drawable.setStroke(ConvertUtils.dp2px(0.5f), Color.parseColor("#FE0000"));
                                            tvDay.setText(Html.fromHtml("<font color='#FE0000'>已拒绝</font>"));
                                            break;
                                    }
                                    tvDay.setBackgroundDrawable(drawable);

                                    tvDay.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View view) {
                                            if (resultsBean.getBorrowStatus() == 1 || resultsBean.getBorrowStatus() == 2) {
                                                Intent intent = new Intent(DocumentSearchListActivity.this, BorrowApplyActivity.class);
                                                intent.putExtra("searchDocInfo", resultsBean);
                                                startActivity(intent);
                                            }
                                        }
                                    });

                                }

                            }
                        }, new BaseQuickAdapter.OnItemClickListener() {
                            @SuppressLint("ResourceType")
                            @Override
                            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {

                            }
                        }, null);
                    }
                }

                if (null != refreshLayout) {
                    refreshLayout.finishRefresh();
                    refreshLayout.finishLoadMore();
                }
            }
        });
    }

    @OnClick(R.id.iv_back)
    public void onIvBackClicked() { //返回
        finish();
    }

    @OnClick(R.id.iv_filter)
    public void onIvFilterClicked() { //筛选条件
        llSearchHistory.setVisibility(View.GONE);
        refreshLayout.setVisibility(View.VISIBLE);
        mImmersionBar.statusBarDarkFont(true).fitsSystemWindows(true).statusBarColor(R.color.colorPrimary).init();
        DocSearchSideCategoryFragment fragment = new DocSearchSideCategoryFragment();
        fragment.setOnSearchCategoryListener(this);
        fragment.show(getSupportFragmentManager(), "sidecategory");
    }

    @OnClick(R.id.btn_search)
    public void onBtnSearchClicked() { //搜索按钮
        keyWord = etKey.getText().toString().trim();

        if (!StringUtils.isEmpty(keyWord)) {
            if (searchHistory.contains(keyWord)) {
                searchHistory.remove(keyWord);
                searchHistory.add(0, keyWord);
            } else {
                searchHistory.add(0, keyWord);
            }
            SharedPreferences token = getSharedPreferences("userinfo", Context.MODE_PRIVATE);
            token.edit().putString("searchHistory", searchHistory.toString()).commit();

        }

        refreshLayout.autoRefresh();

//        if (StringUtils.isEmpty(key)) {
//            pageIndex = 1;
//            refreshView(taskType, keyWord, startTime, endTime, tag);
//        }else{
//            pageIndex = 1;
//            refreshView(taskType, key, startTime, endTime, tag);
//        }

        llSearchHistory.setVisibility(View.GONE);
        refreshLayout.setVisibility(View.VISIBLE);
        KeyboardUtils.hideSoftInput(this);
    }

    @OnClick(R.id.iv_del_keyword)
    public void onIvDelKeywordClicked() { //删除输入内容
        keyWord = "";
        etKey.setText("");
    }

    @Override
    public void onDismiss() {
        mImmersionBar.statusBarDarkFont(false).fitsSystemWindows(true).statusBarColor(R.color.colorPrimary).init();
    }

    @Override
    public void onSearch(int taskType, String keyWord, String startTime, String endTime, String tag) {
        this.taskType = taskType; //任务类型
        this.keyWord = keyWord; //搜索关键字
        this.startTime = startTime; //开始时间
        this.endTime = endTime;//结束时间
        this.tag = tag;//筛选标签
        //按照搜索条件查询数据
        refreshLayout.autoRefresh();
    }

    @OnClick(R.id.tv_clear_history)
    public void onTvClearHistoryClicked() { //删除历史记录
        searchHistory.clear();
        SharedPreferences token = getSharedPreferences("userinfo", Context.MODE_PRIVATE);
        token.edit().putString("searchHistory", "").commit();
        setSearchHistory();
    }

    @OnClick(R.id.tv_close)
    public void onTvCloseClicked() { //关闭历史记录
        llSearchHistory.setVisibility(View.GONE);
        refreshLayout.setVisibility(View.VISIBLE);
        KeyboardUtils.hideSoftInput(this);
    }

    @OnClick(R.id.ll_search_history)
    public void onViewClicked() { //关闭历史记录
        llSearchHistory.setVisibility(View.GONE);
        refreshLayout.setVisibility(View.VISIBLE);
        KeyboardUtils.hideSoftInput(this);
    }
}
