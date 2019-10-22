package com.lingjun.colliery_android.module.main;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ScreenUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lingjun.colliery_android.R;
import com.lingjun.colliery_android.base.BaseActivity;
import com.lingjun.colliery_android.base.BaseLinkList;
import com.lingjun.colliery_android.base.MyNestExpandableAdapter;
import com.lingjun.colliery_android.base.MySelectFileAdapter;
import com.lingjun.colliery_android.base.OnGlobalListener;
import com.lingjun.colliery_android.bean.ResponsibleBean;
import com.lingjun.colliery_android.bean.SelectFileBean;
import com.lingjun.colliery_android.bean.SelectPersonnelBean;
import com.lingjun.colliery_android.utils.FastJsonTools;
import com.lingjun.colliery_android.utils.RecyclerViewUtils;
import com.lingjun.colliery_android.utils.retrofit.BaseSubscriber;
import com.lingjun.colliery_android.utils.retrofit.ExceptionHandle;
import com.lingjun.colliery_android.view.NestExpandableListView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 选择文件
 * Created by nefa on 2018/10/25.
 */

public class SelectFileActivity extends BaseActivity {
    public static final int RectifyingCode = 303;
    private Button button;
    private RecyclerView rv_list;
    private int width;
    private LinearLayout ll_beijing;
    private SmartRefreshLayout refreshLayout;

    @Override
    protected int getResourcesId() {
        return R.layout.activity_select_file;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        button = findViewById(R.id.button);
        rv_list = findViewById(R.id.rv_list);
        ll_beijing = findViewById(R.id.ll_beijing);
        refreshLayout = findViewById(R.id.refreshLayout);

        width = ScreenUtils.getScreenWidth();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        ll_beijing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                refreshLayout.autoRefresh();
                refreshLayout.setVisibility(View.VISIBLE);
                ll_beijing.setVisibility(View.GONE);
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
        hashMap.put(BaseLinkList.apiurl, BaseLinkList.coal_mine + BaseLinkList.getTransferfile);

        mRetrofit.JsonToColliery(BaseLinkList.Base_Url, hashMap, new BaseSubscriber() {
            @Override
            public void onError(ExceptionHandle.ResponeThrowable e) {
                if (null != refreshLayout)
                {
                    refreshLayout.setVisibility(View.GONE);
                    ll_beijing.setVisibility(View.VISIBLE);
                    refreshLayout.finishRefresh();
                    refreshLayout.finishLoadMore();
                }
            }

            @Override
            public void onSuccess(JSONObject jsonObject) throws JSONException {
                LogUtils.e("-资料文件->>" + jsonObject.toString());
                SelectFileBean selectFileBean = FastJsonTools.getBean(jsonObject.toString(), SelectFileBean.class);
                if (null != selectFileBean) {
                    refreshLayout.setVisibility(View.VISIBLE);
                    ll_beijing.setVisibility(View.GONE);
                    if (selectFileBean.getResultMaps() != null && selectFileBean.getResultMaps().size() != 0) {
                        RecyclerViewUtils.initLinerNoSc(SelectFileActivity.this, rv_list, R.layout.item_select_file, selectFileBean.getResultMaps(), new OnGlobalListener() {
                            @Override
                            public <T> void logic(BaseViewHolder helper, List<T> mData, T item, BaseQuickAdapter mAdapter) {
                                SelectFileBean.ResultMapsBean resultMapsBean = (SelectFileBean.ResultMapsBean) item;

                                final ArrayList<SelectFileBean.ResultMapsBean> departmentBeans = new ArrayList<>();
                                departmentBeans.add(resultMapsBean);
                                NestExpandableListView nestExpandable = helper.getView(R.id.nestExpandable);
                                MySelectFileAdapter exAdapter = new MySelectFileAdapter(SelectFileActivity.this, departmentBeans);
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
                                        SelectFileBean.ResultMapsBean resultMapsBean = departmentBeans.get(i);
                                        //子信息
                                        SelectFileBean.ResultMapsBean.FileListBean personnelBean = resultMapsBean.getFileList().get(i1);

                                        CheckBox cbox = view.findViewById(R.id.cbox);
                                        if (null != cbox) {
                                            personnelBean.setSelect(!personnelBean.isSelect());
                                            cbox.setChecked(personnelBean.isSelect());
                                            //拿出此bean中需要的信息
                                            String privatefolderName = resultMapsBean.getPrivatefolderName();
                                            String filename = personnelBean.getFilename();
                                            Intent intent = new Intent();
                                            intent.putExtra("privatefolderName", privatefolderName);
                                            intent.putExtra("filename", filename);
                                            intent.putExtra("id", personnelBean.getId() + "");
                                            setResult(RectifyingCode, intent);
                                            finish();
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
                }
                if (null != refreshLayout) {
                    refreshLayout.finishLoadMore();
                    refreshLayout.finishRefresh();
                }

            }
        });
    }

}
