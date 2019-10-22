package com.lingjun.colliery_android.module.dealwith.hiddendanger.activity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lingjun.colliery_android.R;
import com.lingjun.colliery_android.base.BaseActivity;
import com.lingjun.colliery_android.base.BaseLinkList;
import com.lingjun.colliery_android.base.OnGlobalListener;
import com.lingjun.colliery_android.bean.HiddenDangeGradeBean;
import com.lingjun.colliery_android.bean.KeyWordBean;
import com.lingjun.colliery_android.bean.PersonLiableBean;
import com.lingjun.colliery_android.module.dealwith.activity.KeyWordActivity;
import com.lingjun.colliery_android.utils.FastJsonTools;
import com.lingjun.colliery_android.utils.RecyclerViewUtils;
import com.lingjun.colliery_android.utils.retrofit.BaseSubscriber;
import com.lingjun.colliery_android.utils.retrofit.ExceptionHandle;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 作者: zengtao
 * 时间: 2019/4/25  16:43.
 * 注释: 整改人
 */
public class PersonLiableActivity extends BaseActivity {
    public static final int RectifyingCode = 19;

    private RecyclerView rv_list;
    private SmartRefreshLayout refreshLayout;
//    private LinearLayout ll_beijing;

    private String rectificationPersonnelFlag;
    private String department_id;
    private RelativeLayout rl_duoxuan;
    private Button btn_queding;
    private TextView tv_num;
    private TextView tv_biaoji;
    private String personLiable;
    private int single;

    private ArrayList<String> list = new ArrayList<>();
    private ArrayList<PersonLiableBean.DataBean.PageBean.ResultsBean> resultsBeans = new ArrayList<>();

    @Override
    protected int getResourcesId() {
        return R.layout.activity_person_liable;
    }

    @Override
    protected void init(Bundle savedInstanceState) throws PackageManager.NameNotFoundException {
        personLiable = getIntent().getStringExtra("personLiable");
        rectificationPersonnelFlag = getIntent().getStringExtra("rectificationPersonnelFlag");
        department_id = getIntent().getStringExtra("department_id");
        single = getIntent().getIntExtra("single", -1);
        rv_list = findViewById(R.id.rv_list);
        rl_duoxuan = findViewById(R.id.rl_duoxuan);
        if (personLiable.equals("2")) {
            if (single == 1) {
                rl_duoxuan.setVisibility(View.GONE);
            } else {
                if (rectificationPersonnelFlag.equals("1")) {
                    rl_duoxuan.setVisibility(View.VISIBLE);
                }
            }


        }
        btn_queding = findViewById(R.id.btn_queding);
        tv_num = findViewById(R.id.tv_num);
        refreshLayout = findViewById(R.id.refreshLayout);
        tv_biaoji = findViewById(R.id.tv_biaoji);
        tv_biaoji.setText("责任人");
//        ll_beijing = findViewById(R.id.ll_beijing);
        refreshView();//刷新

        btn_queding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                TestBean testBean = new TestBean();
                testBean.arrayList = resultsBeans;
                bundle.putSerializable("zrr", testBean);
                intent.putExtra("bundle", bundle);
                intent.putExtra("type", "1");
                setResult(PersonLiableActivity.RectifyingCode, intent);
                finish();
            }
        });
    }

    @Override
    protected BaseRefreshLoadMoreInterface setRefreshLoadMoreListener() {
//        return new BaseRefreshLoadMoreInterface() {
//            @Override
//            public void onLoadMore() {
//                refreshView();
//            }
//
//            @Override
//            public void onRefresh() {
//                refreshView();
//            }
//        };
        return null;
    }

    private void refreshView() {
        LogUtils.e("当前第" + pageIndex + "页");

        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("page", pageIndex + "");
        hashMap.put("pageSize", "500");
        hashMap.put("departmentid", department_id + "");
        hashMap.put(BaseLinkList.apiurl, BaseLinkList.coal_mine + BaseLinkList.getUserByDepartmentId);

        mRetrofit.JsonToColliery(BaseLinkList.Base_Url, hashMap, new BaseSubscriber() {
            @Override
            public void onError(ExceptionHandle.ResponeThrowable e) {
//                refreshLayout.setVisibility(View.GONE);
//                ll_beijing.setVisibility(View.VISIBLE);
                if (null != refreshLayout) {
                    refreshLayout.finishRefresh();
                    refreshLayout.finishLoadMore();
                }
            }

            @Override
            public void onSuccess(JSONObject jsonObject) {
                LogUtils.e("隐患等级->>" + jsonObject.toString());

                final PersonLiableBean personLiableBean = FastJsonTools.getBean(jsonObject.toString(), PersonLiableBean.class);
                if (null != personLiableBean && null != personLiableBean.getMsg() && null != personLiableBean.getCode()) {
                    final ArrayList<PersonLiableBean.DataBean.PageBean.ResultsBean> results = (ArrayList<PersonLiableBean.DataBean.PageBean.ResultsBean>) personLiableBean.getData().getPage().getResults();
                    if (results.size() != 0) {
//                        refreshLayout.setVisibility(View.VISIBLE);
//                        ll_beijing.setVisibility(View.GONE);
                        if (pageIndex > 1) {
                            if (null != results && results.size() != 0) {
                                BaseQuickAdapter adapter = (BaseQuickAdapter) rv_list.getAdapter();
                                ArrayList<PersonLiableBean.DataBean.PageBean.ResultsBean> data = (ArrayList<PersonLiableBean.DataBean.PageBean.ResultsBean>) adapter.getData();
                                for (int i = 0; i < results.size(); i++) {
                                    data.add(results.get(i));
                                    adapter.notifyItemChanged(data.size() + (i + 1), results.get(i));
                                }
                            } else {
                                ToastUtils.showShort("没有更多数据了!");
                            }
                        } else {
                            RecyclerViewUtils.initLiner(PersonLiableActivity.this, rv_list, R.layout.item_hidden_danger_paln, results, new OnGlobalListener() {
                                @Override
                                public <T> void logic(BaseViewHolder helper, List<T> mData, T item, BaseQuickAdapter mAdapter) {
                                    PersonLiableBean.DataBean.PageBean.ResultsBean resultsBean = (PersonLiableBean.DataBean.PageBean.ResultsBean) item;
                                    RelativeLayout rl_plan = helper.getView(R.id.rl_plan);
                                    TextView ll_plan = helper.getView(R.id.ll_plan);
                                    ll_plan.setText(resultsBean.getName());
                                    if (!resultsBean.isColour()) {
                                        rl_plan.setBackgroundResource(R.drawable.shape_bg_gray);
                                    } else {
                                        rl_plan.setBackgroundResource(R.drawable.shape_bg_blue);
                                    }

                                }
                            }, new BaseQuickAdapter.OnItemClickListener() {
                                @Override
                                public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                                    PersonLiableBean.DataBean.PageBean.ResultsBean resultsBean = (PersonLiableBean.DataBean.PageBean.ResultsBean) adapter.getData().get(position);
                                    if (personLiable.equals("1")) {//技术员
                                        Intent intent = new Intent();
                                        intent.putExtra("jsyid", "" + resultsBean.getUserid());
                                        intent.putExtra("jsyname", "" + resultsBean.getName());
                                        intent.putExtra("type", "2");
                                        setResult(RectifyingCode, intent);
                                        finish();
                                    } else if (personLiable.equals("2")) {//责任人
                                        if (single == 2) {
                                            if (rectificationPersonnelFlag.equals("0")) {//单个责任人
                                                Intent intent = new Intent();
                                                intent.putExtra("zrrid", "" + resultsBean.getUserid());
                                                intent.putExtra("zrrname", "" + resultsBean.getName());
                                                intent.putExtra("type", "0");
                                                setResult(RectifyingCode, intent);
                                                finish();
                                            } else if (rectificationPersonnelFlag.equals("1")) {//多个责任人
                                                if (resultsBean.isColour()) {
                                                    resultsBean.setColour(false);
                                                    resultsBeans.remove(resultsBean);
                                                } else {
                                                    resultsBean.setColour(true);
                                                    resultsBeans.add(resultsBean);
                                                }
                                                adapter.notifyItemChanged(position);
                                                tv_num.setText("" + (resultsBeans.size()));
                                            }
                                        } else {
                                            Intent intent = new Intent();
                                            intent.putExtra("zrrid", "" + resultsBean.getUserid());
                                            intent.putExtra("zrrname", "" + resultsBean.getName());
                                            intent.putExtra("type", "0");
                                            setResult(RectifyingCode, intent);
                                            finish();
                                        }

                                    }
                                }
                            }, null);
                        }
                    } else {
//                        refreshLayout.setVisibility(View.GONE);
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

    public static class TestBean implements Serializable {
        public ArrayList<PersonLiableBean.DataBean.PageBean.ResultsBean> arrayList;
    }
}
