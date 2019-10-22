package com.lingjun.colliery_android.module.main.rectifyingviolations;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.blankj.utilcode.util.LogUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lingjun.colliery_android.R;
import com.lingjun.colliery_android.base.BaseActivity;
import com.lingjun.colliery_android.base.BaseLinkList;
import com.lingjun.colliery_android.base.MyNestExpandableAdapter;
import com.lingjun.colliery_android.base.OnGlobalListener;
import com.lingjun.colliery_android.base.TransportPersonnelAdapter;
import com.lingjun.colliery_android.bean.ResponsibleBean;
import com.lingjun.colliery_android.bean.TransportPersonnelBean;
import com.lingjun.colliery_android.module.main.SelectPersonnelActivity;
import com.lingjun.colliery_android.utils.FastJsonTools;
import com.lingjun.colliery_android.utils.RecyclerViewUtils;
import com.lingjun.colliery_android.utils.retrofit.BaseSubscriber;
import com.lingjun.colliery_android.utils.retrofit.ExceptionHandle;
import com.lingjun.colliery_android.view.NestExpandableListView;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 作者: zengtao
 * 时间: 2019/3/11  9:10.
 * 注释:传输人员
 */
public class TransportPersonnelActivity extends BaseActivity {
    public static final int RectifyingCode = 404;//三违录入页面使用
    private int width;
    private int JumpCode = 0;
    private RecyclerView rv_list;
    private TextView tv_sure;
    private LinearLayout ll_beijing;
    private ArrayList<Integer> userid = new ArrayList<>();
    private ArrayList<String> name = new ArrayList<>();

    @Override
    protected int getResourcesId() {
        return R.layout.activity_transportpersonnel;
    }

    @Override
    protected void init(Bundle savedInstanceState) throws PackageManager.NameNotFoundException {
        rv_list = findViewById(R.id.rv_list);
        tv_sure = findViewById(R.id.tv_sure);
        ll_beijing = findViewById(R.id.ll_beijing);
        tv_sure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("userid", userid + "");
                intent.putExtra("name", name + "");
                setResult(TransportPersonnelActivity.RectifyingCode, intent);
                finish();
            }
        });
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
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(BaseLinkList.apiurl, BaseLinkList.coal_mine + BaseLinkList.getTransferpeople);
        mRetrofit.JsonToColliery(BaseLinkList.Base_Url, hashMap, new BaseSubscriber() {
            @Override
            public void onError(ExceptionHandle.ResponeThrowable e) {
                refreshLayout.setVisibility(View.GONE);
                ll_beijing.setVisibility(View.VISIBLE);
                dismissDialog();
            }

            @Override
            public void onSuccess(JSONObject jsonObject) {
                LogUtils.e("责任人信息->>" + jsonObject.toString());
                TransportPersonnelBean transportPersonnelBean = FastJsonTools.getBean(jsonObject.toString(), TransportPersonnelBean.class);
                if (null != transportPersonnelBean.getData()) {
                    refreshLayout.setVisibility(View.VISIBLE);
                    ll_beijing.setVisibility(View.GONE);
                    RecyclerViewUtils.initLinerNoSc(TransportPersonnelActivity.this, rv_list, R.layout.item_select_file, transportPersonnelBean.getData().getDepartmentResult(), new OnGlobalListener() {
                        @Override
                        public <T> void logic(BaseViewHolder helper, List<T> mData, T item, BaseQuickAdapter mAdapter) {

                            final ArrayList<TransportPersonnelBean.DataBean.DepartmentResultBean> departmentBeans = new ArrayList<>();
                            TransportPersonnelBean.DataBean.DepartmentResultBean departmentBean = (TransportPersonnelBean.DataBean.DepartmentResultBean) item;
                            departmentBeans.add(departmentBean);
                            NestExpandableListView nestExpandable = helper.getView(R.id.nestExpandable);
                            TransportPersonnelAdapter exAdapter = new TransportPersonnelAdapter(TransportPersonnelActivity.this, departmentBeans);
                            Drawable drawable = getResources().getDrawable(R.color.transparent);
                            nestExpandable.setIndicatorBounds(width - 200, 0);
                            nestExpandable.setBackgroundResource(R.drawable.shape_bg_white);
                            nestExpandable.setDivider(drawable);
                            nestExpandable.setChildDivider(drawable);
                            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                            //ViewGroup.MarginLayoutParams layoutParams = new ViewGroup.MarginLayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                            layoutParams.setMargins(0, 50, 0, 0);
                            nestExpandable.setLayoutParams(layoutParams);
                            nestExpandable.setAdapter(exAdapter);

                            nestExpandable.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
                                @Override
                                public boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i1, long l) {
                                    //组信息
                                    TransportPersonnelBean.DataBean.DepartmentResultBean resultMapsBean = departmentBeans.get(i);
                                    //领导信息
                                    String departmentleader = resultMapsBean.getDepartmentName();
                                    //子信息
                                    TransportPersonnelBean.DataBean.DepartmentResultBean.UserlistBean personnelBean = resultMapsBean.getUserlist().get(i1);

                                    CheckBox cbox = view.findViewById(R.id.cbox);
                                    if (null != cbox) {
                                        personnelBean.setSelect(!personnelBean.isSelect());
                                        cbox.setChecked(personnelBean.isSelect());

                                        if (personnelBean.isSelect()) {
                                            userid.add(personnelBean.getId());
                                            name.add(personnelBean.getName());
                                        } else if (!personnelBean.isSelect()) {
                                            userid.remove((Integer) personnelBean.getId());
                                            name.remove((String) personnelBean.getName());
                                        }

                                    } else {
                                        LogUtils.e("cbox为空");
                                    }
                                    return true;
                                }
                            });
                        }
                    }, null, null);
                } else {
                    refreshLayout.setVisibility(View.GONE);
                    ll_beijing.setVisibility(View.VISIBLE);
                }

                if (null != refreshLayout) {
                    refreshLayout.finishLoadMore();
                    refreshLayout.finishRefresh();
                }
            }
        });
    }
}
