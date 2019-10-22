package com.lingjun.colliery_android.module.main.rectifyingviolations;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.blankj.utilcode.util.LogUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lingjun.colliery_android.R;
import com.lingjun.colliery_android.base.BaseActivity;
import com.lingjun.colliery_android.base.BaseLinkList;
import com.lingjun.colliery_android.base.OnGlobalListener;
import com.lingjun.colliery_android.bean.InspectorBean;
import com.lingjun.colliery_android.module.main.SelectPersonnelActivity;
import com.lingjun.colliery_android.utils.FastJsonTools;
import com.lingjun.colliery_android.utils.RecyclerViewUtils;
import com.lingjun.colliery_android.utils.ToastUtils;
import com.lingjun.colliery_android.utils.retrofit.BaseSubscriber;
import com.lingjun.colliery_android.utils.retrofit.ExceptionHandle;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;

/**
 * 作者: zengtao
 * 时间: 2019/7/11  13:56.
 * 注释: 三违检查人
 */
public class InspectorActivity extends BaseActivity {
    public static final int HiddenDangerCode = 454;
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.ll_beijing)
    LinearLayout llBeijing;
    @BindView(R.id.rv_list)
    RecyclerView rvList;
    @BindView(R.id.refreshLayout)
    SmartRefreshLayout refreshLayout;
    private ImageView iv_screen;
    private PopupWindow window;

    private EditText et_earch;
    private ImageView iv_clear;
    private TextView tv_reset;
    private TextView tv_search;
    private ArrayList<InspectorBean.DataBean.UserpageBean.ResultsBean> results = new ArrayList<>();

    @Override
    protected int getResourcesId() {
        return R.layout.activity_hidden_danger_paln;
    }

    @Override
    protected void init(Bundle savedInstanceState) throws PackageManager.NameNotFoundException {
        tvName.setText("检查人");
        iv_screen = findViewById(R.id.iv_screen);
        iv_screen.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                Search();
                return false;
            }
        });

        llBeijing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                refreshLayout.autoRefresh();
            }
        });
    }

    private void Search() {

        // 构建一个popupwindow的布局
        final View popupView = getLayoutInflater().inflate(R.layout.popupwindows_name, null);
        //  为了演示效果，简单的设置了一些数据，实际中大家自己设置数据即可，相信大家都会。
        //  创建PopupWindow对象，指定宽度和高度
        window = new PopupWindow(popupView, LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        //   设置动画
        window.setAnimationStyle(R.style.AnimationFade);
        //  设置背景颜色
        window.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#FFFFFF")));
        //  设置可以获取焦点
        window.setFocusable(true);
        //  设置可以触摸弹出框以外的区域
        window.setOutsideTouchable(true);
        // 更新popupwindow的状态
        window.update();
        //  以下拉的方式显示，并且可以设置显示的位置
        window.showAsDropDown(iv_screen, 0, 40);
        //
        window.showAtLocation(getLayoutInflater().inflate(R.layout.activity_select_personnel, null), Gravity.RIGHT, 0, 500);

        et_earch = popupView.findViewById(R.id.et_earch);
        iv_clear = popupView.findViewById(R.id.iv_clear);
        tv_reset = popupView.findViewById(R.id.tv_reset);
        tv_search = popupView.findViewById(R.id.tv_search);

        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.iv_clear://清除
                        et_earch.setText("");
                        break;
                    case R.id.tv_reset://重置
                        et_earch.setText("");
                        break;
                    case R.id.tv_search://确定
                        if (!TextUtils.isEmpty(et_earch.getText().toString().trim())) {
                            window.dismiss();
                            refreshView(1);
                        } else {
                            ToastUtils.showToast(InspectorActivity.this, "关键词不能为空");
                            return;
                        }
                        break;
                    default:
                }

            }
        };

        iv_clear.setOnClickListener(onClickListener);
        tv_reset.setOnClickListener(onClickListener);
        tv_search.setOnClickListener(onClickListener);
    }

    private void refreshView(int type) {
        HashMap<String, String> hashMap = new HashMap<>();
        if (type == 0) {
            hashMap.put("page", pageIndex + "");
            hashMap.put("pageSize", "10");
            hashMap.put("searchstr", "");
        } else if (type == 1) {
            pageIndex = 1;
            hashMap.put("page", pageIndex + "");
            hashMap.put("pageSize", "5000");
            hashMap.put("searchstr", et_earch.getText().toString().trim());
        }
        hashMap.put(BaseLinkList.apiurl, BaseLinkList.coal_mine + BaseLinkList.disobeyUserList);

        mRetrofit.JsonToColliery(BaseLinkList.Base_Url, hashMap, new BaseSubscriber() {
            @Override
            public void onError(ExceptionHandle.ResponeThrowable e) {
                refreshLayout.setVisibility(View.GONE);
                llBeijing.setVisibility(View.VISIBLE);
                if (null != refreshLayout) {
                    refreshLayout.finishRefresh();
                    refreshLayout.finishLoadMore();
                }
            }

            @Override
            public void onSuccess(JSONObject jsonObject) {
                LogUtils.e("列表->>" + jsonObject.toString());
                final InspectorBean inspectorBean = FastJsonTools.getBean(jsonObject.toString(), InspectorBean.class);
                if (null != inspectorBean && null != inspectorBean.getMsg() && null != inspectorBean.getCode()) {
                    refreshLayout.setVisibility(View.VISIBLE);
                    llBeijing.setVisibility(View.GONE);
                    if (pageIndex > 1) {
                        if (null != inspectorBean.getData().getUserpage().getResults() && inspectorBean.getData().getUserpage().getResults().size() != 0) {
                            BaseQuickAdapter adapter = (BaseQuickAdapter) rvList.getAdapter();
                            results.addAll(inspectorBean.getData().getUserpage().getResults());
                            adapter.notifyDataSetChanged();
                        }
                    } else {
                        if (results.size() != 0) {
                            results.clear();
                        }
                        if (inspectorBean.getData().getUserpage().getResults().size() != 0) {
                            results.addAll(inspectorBean.getData().getUserpage().getResults());
                            RecyclerViewUtils.initLiner(InspectorActivity.this, rvList, R.layout.item_hidden_danger_paln, results, new OnGlobalListener() {
                                @Override
                                public <T> void logic(BaseViewHolder helper, List<T> mData, T item, BaseQuickAdapter mAdapter) {
                                    InspectorBean.DataBean.UserpageBean.ResultsBean resultsBean = (InspectorBean.DataBean.UserpageBean.ResultsBean) item;
                                    TextView ll_plan = helper.getView(R.id.ll_plan);
                                    ll_plan.setText(resultsBean.getName());
                                }
                            }, new BaseQuickAdapter.OnItemClickListener() {
                                @Override
                                public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                                    InspectorBean.DataBean.UserpageBean.ResultsBean resultsBean = (InspectorBean.DataBean.UserpageBean.ResultsBean) adapter.getData().get(position);
                                    Intent intent = new Intent();
                                    intent.putExtra("Inspectorname", "" + resultsBean.getName());
                                    intent.putExtra("Inspectorid", "" + resultsBean.getId());
                                    setResult(HiddenDangerCode, intent);
                                    finish();
                                }
                            }, null);
                        } else {
                            refreshLayout.setVisibility(View.GONE);
                            llBeijing.setVisibility(View.VISIBLE);
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

    @Override
    protected BaseRefreshLoadMoreInterface setRefreshLoadMoreListener() {
        return new BaseRefreshLoadMoreInterface() {
            @Override
            public void onLoadMore() {
                refreshView(0);
            }

            @Override
            public void onRefresh() {
                refreshView(0);
            }
        };
    }

}
