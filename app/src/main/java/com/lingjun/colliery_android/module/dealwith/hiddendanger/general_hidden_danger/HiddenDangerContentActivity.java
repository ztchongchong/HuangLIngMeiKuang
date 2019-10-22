package com.lingjun.colliery_android.module.dealwith.hiddendanger.general_hidden_danger;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ScreenUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lingjun.colliery_android.R;
import com.lingjun.colliery_android.base.BaseActivity;
import com.lingjun.colliery_android.base.BaseLinkList;
import com.lingjun.colliery_android.base.MyNestExpandableAdapter;
import com.lingjun.colliery_android.base.OnGlobalListener;
import com.lingjun.colliery_android.bean.DealWithBean;
import com.lingjun.colliery_android.bean.HiddenDangerContentBean;
import com.lingjun.colliery_android.bean.PopCatalogwordBean;
import com.lingjun.colliery_android.bean.PopKeywordBean;
import com.lingjun.colliery_android.bean.ResponsibleBean;
import com.lingjun.colliery_android.bean.SelectPersonnelBean;
import com.lingjun.colliery_android.module.main.SelectPersonnelActivity;
import com.lingjun.colliery_android.utils.FastJsonTools;
import com.lingjun.colliery_android.utils.PopWindowUtils;
import com.lingjun.colliery_android.utils.RecyclerViewUtils;
import com.lingjun.colliery_android.utils.ToastUtils;
import com.lingjun.colliery_android.utils.retrofit.BaseSubscriber;
import com.lingjun.colliery_android.utils.retrofit.ExceptionHandle;
import com.lingjun.colliery_android.view.NestExpandableListView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 选择隐患内容
 */
public class HiddenDangerContentActivity extends BaseActivity implements View.OnClickListener {
    public static final int HiddenDangerCode = 4;

    private TextView tv_label_reset, tv_label_sure, tv_content_sure;
    private EditText et_label;
    private ImageView ivMuLu, ivKey;
    private String content, pop_key;
    private RecyclerView rv_list, rv_list1;
    private RecyclerView rv_pop_list;
    private SmartRefreshLayout refreshLayout;
    private LinearLayout ll_beijing;

    private LinearLayout pop_hidden_contents_directory;
    private LinearLayout pop_hidden_cvontent_keyword;

    private PopWindowUtils popWindowUtils;

    private PopupWindow window, window1;

    private int width;
    private DealWithBean.DataBean.PageBean.ResultsBean resultsBean;

    private int sourceId;
    private String clause;
    private int score;
    private int money;
    private int processor_id;
    private int sourceFolder;
    private int popCatalogword;
    private String categoryName;


    private ArrayList<HiddenDangerContentBean.ResultMapsBean> results;
    private BaseQuickAdapter adapter;

    @Override
    protected int getResourcesId() {
        return R.layout.activity_hidden_danger_content;
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void init(Bundle savedInstanceState) {
        rv_list = findViewById(R.id.rv_list);
        refreshLayout = findViewById(R.id.refreshLayout);
        ll_beijing = findViewById(R.id.ll_beijing);
        ivMuLu = findViewById(R.id.iv_arrow_mulu);
        ivKey = findViewById(R.id.iv_arrow_key);
        width = ScreenUtils.getScreenWidth();

        ll_beijing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                refreshLayout.autoRefresh(1, 2, 1);
            }
        });


        pop_hidden_contents_directory = findViewById(R.id.ll_hidden_contents_directory);
        pop_hidden_cvontent_keyword = findViewById(R.id.ll_hidden_cvontent_keyword);

        //目录
        pop_hidden_contents_directory.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                ivMuLu.setImageResource(R.drawable.ic_arrow_dwon1);
                // 构建一个popupwindow的布局
                View popupView = getLayoutInflater().inflate(R.layout.popup_hidden_contents_directory, null);
                //  为了演示效果，简单的设置了一些数据，实际中大家自己设置数据即可，相信大家都会。
                //  创建PopupWindow对象，指定宽度和高度
                window1 = new PopupWindow(popupView, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                //   设置动画
//                window.setAnimationStyle(R.style.popup_window_anim);
                //  设置背景颜色
                window1.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#FFFFFF")));
                //  设置可以获取焦点
                window1.setFocusable(true);
                //  设置可以触摸弹出框以外的区域
                window1.setOutsideTouchable(true);
                // 更新popupwindow的状态
                window1.update();
                //  以下拉的方式显示，并且可以设置显示的位置
                window1.showAsDropDown(pop_hidden_contents_directory, 0, 40);
                ll_beijing = popupView.findViewById(R.id.ll_beijing);
                rv_pop_list = popupView.findViewById(R.id.rv_pop_list);

                window1.setOnDismissListener(new PopupWindow.OnDismissListener() {
                    @Override
                    public void onDismiss() {
                        ivMuLu.setImageResource(R.drawable.ic_arrow_up1);
                    }
                });

                ll_beijing.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        pop_mulu();//目录列表
                    }
                });
                pop_mulu();//目录列表
                return false;
            }
        });

        //关键字
        pop_hidden_cvontent_keyword.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                ivKey.setImageResource(R.drawable.ic_arrow_dwon1);
                // 构建一个popupwindow的布局
                View popupView = getLayoutInflater().inflate(R.layout.popup_hidden_cvontent_keyword, null);
                //  为了演示效果，简单的设置了一些数据，实际中大家自己设置数据即可，相信大家都会。
                //  创建PopupWindow对象，指定宽度和高度
                window = new PopupWindow(popupView, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
//                //   设置动画
//                window.setAnimationStyle(R.style.popup_window_anim);
                //  设置背景颜色
                window.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#FFFFFF")));
                //  设置可以获取焦点
                window.setFocusable(true);
                //  设置可以触摸弹出框以外的区域
                window.setOutsideTouchable(true);
                // 更新popupwindow的状态
                window.update();
                //  以下拉的方式显示，并且可以设置显示的位置
                window.showAsDropDown(pop_hidden_cvontent_keyword, 0, 40);
                et_label = popupView.findViewById(R.id.et_label);
                rv_list1 = popupView.findViewById(R.id.rv_list1);
                tv_label_reset = popupView.findViewById(R.id.tv_label_reset);
                tv_label_sure = popupView.findViewById(R.id.tv_label_sure);

                tv_label_reset.setOnClickListener(HiddenDangerContentActivity.this);
                tv_label_sure.setOnClickListener(HiddenDangerContentActivity.this);

                window.setOnDismissListener(new PopupWindow.OnDismissListener() {
                    @Override
                    public void onDismiss() {
                        ivKey.setImageResource(R.drawable.ic_arrow_up1);
                    }
                });
                return false;
            }
        });

    }

    //pop 目录刷新
    private void pop_mulu() {

        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(BaseLinkList.apiurl, BaseLinkList.coal_mine + BaseLinkList.pop_catalogword);
        mRetrofit.JsonToColliery(BaseLinkList.Base_Url, hashMap, new BaseSubscriber() {
            @Override
            public void onError(ExceptionHandle.ResponeThrowable e) {
                ll_beijing.setVisibility(View.VISIBLE);
//                if (null != refreshLayout) {
//                    refreshLayout.finishRefresh();
//                    refreshLayout.finishLoadMore();
//                }
            }

            @Override
            public void onSuccess(JSONObject jsonObject) {
                LogUtils.e("列表->>" + jsonObject.toString());
                final PopCatalogwordBean popCatalogwordBean = FastJsonTools.getBean(jsonObject.toString(), PopCatalogwordBean.class);
                if (null != popCatalogwordBean && null != popCatalogwordBean.getMsg() && null != popCatalogwordBean.getCode()) {
                    final ArrayList<PopCatalogwordBean.DataBean.TreejsonBean> results = popCatalogwordBean.getData().getTreejson();
                    if (results.size() != 0) {
                        ll_beijing.setVisibility(View.GONE);
                        RecyclerViewUtils.initLiner(HiddenDangerContentActivity.this, rv_pop_list, R.layout.item_hidden_danger_paln, results, new OnGlobalListener() {
                            @Override
                            public <T> void logic(BaseViewHolder helper, List<T> mData, T item, BaseQuickAdapter mAdapter) {
                                PopCatalogwordBean.DataBean.TreejsonBean resultsBean = (PopCatalogwordBean.DataBean.TreejsonBean) item;

                                TextView tv_handle_name = helper.getView(R.id.ll_plan);//标题
                                tv_handle_name.setText(resultsBean.getName());

                            }
                        }, new BaseQuickAdapter.OnItemClickListener() {
                            @Override
                            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                                PopCatalogwordBean.DataBean.TreejsonBean resultsBean = (PopCatalogwordBean.DataBean.TreejsonBean) adapter.getData().get(position);
                                popCatalogword = resultsBean.getId();
                                window1.dismiss();
                                refreshView_mulu();
                            }
                        }, null);

                    } else {
                        ll_beijing.setVisibility(View.VISIBLE);
                    }
                }
            }
        });

    }

    private void refreshView_mulu() {
        LogUtils.e("当前第" + pageIndex + "页");

        HashMap<String, String> hashMap = new HashMap<>();
        pageIndex = 1;
        hashMap.put("pageNum", "" + pageIndex);
        hashMap.put("pageSize", "500");
        hashMap.put("sourceFolderId", "" + popCatalogword);
        hashMap.put(BaseLinkList.apiurl, BaseLinkList.coal_mine + BaseLinkList.hidden_content);

        mRetrofit.JsonToColliery(BaseLinkList.Base_Url, hashMap, new BaseSubscriber() {
            @Override
            public void onError(ExceptionHandle.ResponeThrowable e) {
                refreshLayout.setVisibility(View.GONE);
                ll_beijing.setVisibility(View.VISIBLE);
                if (null != refreshLayout) {
                    refreshLayout.finishRefresh();
                    refreshLayout.finishLoadMore();
                }
            }

            @Override
            public void onSuccess(JSONObject jsonObject) {
                LogUtils.e("列表->>" + jsonObject.toString());

                final HiddenDangerContentBean hiddenDangerContentBean = FastJsonTools.getBean(jsonObject.toString(), HiddenDangerContentBean.class);
                if (null != hiddenDangerContentBean && null != hiddenDangerContentBean.getMsg() && null != hiddenDangerContentBean.getData() && null != hiddenDangerContentBean.getCode() && null != hiddenDangerContentBean.getResultMaps()) {
                    refreshLayout.setVisibility(View.VISIBLE);
                    ll_beijing.setVisibility(View.GONE);
                    results = (ArrayList<HiddenDangerContentBean.ResultMapsBean>) hiddenDangerContentBean.getResultMaps();
                    adapter = (BaseQuickAdapter) rv_list.getAdapter();

                    if (pageIndex > 1) {
                        if (null != results && results.size() != 0) {
//                            adapter = (BaseQuickAdapter) rv_list.getAdapter();
                            ArrayList<HiddenDangerContentBean.ResultMapsBean> data = (ArrayList<HiddenDangerContentBean.ResultMapsBean>) adapter.getData();
//                            data.addAll(results);
//                            adapter.setNewData(data);
                            for (int i = 0; i < results.size(); i++) {
                                data.add(results.get(i));
                                adapter.notifyItemChanged(data.size() + (i + 1), results.get(i));
                            }

                        } else {
                            com.blankj.utilcode.util.ToastUtils.showShort("没有更多数据了!");
                        }
                    } else {
                        RecyclerViewUtils.initLiner(HiddenDangerContentActivity.this, rv_list, R.layout.item_hidden_danger_content, results, new OnGlobalListener() {
                            @Override
                            public <T> void logic(BaseViewHolder helper, List<T> mData, T item, BaseQuickAdapter mAdapter) {
                                HiddenDangerContentBean.ResultMapsBean resultsBean = (HiddenDangerContentBean.ResultMapsBean) item;
                                TextView tv_content_content = helper.getView(R.id.tv_content_content);
                                tv_content_content.setText(resultsBean.getDescription());
                            }
                        }, new BaseQuickAdapter.OnItemClickListener() {
                            @Override
                            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                                HiddenDangerContentBean.ResultMapsBean resultsBean = (HiddenDangerContentBean.ResultMapsBean) adapter.getData().get(position);
                                content = resultsBean.getDescription();
                                sourceId = resultsBean.getSourceId();
                                clause = resultsBean.getClause();//隐患标准
                                score = resultsBean.getScore();//扣分
                                money = resultsBean.getMoney();//罚款
                                processor_id = resultsBean.getProcessor_id();//处理人
                                sourceFolder = resultsBean.getCategoryId();//目录ID
                                categoryName = resultsBean.getCategoryName();

                                Intent intent = new Intent();
                                intent.putExtra("隐患内容", "" + content);
                                intent.putExtra("隐患内容ID", "" + sourceId);
                                intent.putExtra("隐患标准", "" + clause);//隐患标准
                                intent.putExtra("扣分", "" + score);//扣分
                                intent.putExtra("罚款", "" + money);//罚款
                                intent.putExtra("处理人ID", "" + processor_id);
                                intent.putExtra("目录ID", "" + sourceFolder);
                                intent.putExtra("隐患源", "" + categoryName);
                                setResult(HiddenDangerCode, intent);
                                finish();
                            }
                        }, null);
                    }
                } else {
                    refreshLayout.setVisibility(View.GONE);
                    ll_beijing.setVisibility(View.VISIBLE);
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
                refreshView();
            }

            @Override
            public void onRefresh() {
                refreshView();
            }
        };
    }

    //刷新
    private void refreshView() {
        LogUtils.e("当前第" + pageIndex + "页");

        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("pageNum", "" + pageIndex);
        hashMap.put("pageSize", "6");
        hashMap.put(BaseLinkList.apiurl, BaseLinkList.coal_mine + BaseLinkList.hidden_content);

        mRetrofit.JsonToColliery(BaseLinkList.Base_Url, hashMap, new BaseSubscriber() {
            @Override
            public void onError(ExceptionHandle.ResponeThrowable e) {
                refreshLayout.setVisibility(View.GONE);
                ll_beijing.setVisibility(View.VISIBLE);
                if (null != refreshLayout) {
                    refreshLayout.finishRefresh();
                    refreshLayout.finishLoadMore();
                }
            }

            @Override
            public void onSuccess(JSONObject jsonObject) {
                LogUtils.e("列表->>" + jsonObject.toString());

                final HiddenDangerContentBean hiddenDangerContentBean = FastJsonTools.getBean(jsonObject.toString(), HiddenDangerContentBean.class);
                if (null != hiddenDangerContentBean && null != hiddenDangerContentBean.getMsg() && null != hiddenDangerContentBean.getData() && null != hiddenDangerContentBean.getCode() && null != hiddenDangerContentBean.getResultMaps()) {
                    refreshLayout.setVisibility(View.VISIBLE);
                    ll_beijing.setVisibility(View.GONE);
                    results = (ArrayList<HiddenDangerContentBean.ResultMapsBean>) hiddenDangerContentBean.getResultMaps();
                    adapter = (BaseQuickAdapter) rv_list.getAdapter();
                    if (pageIndex > 1) {
                        if (null != results && results.size() != 0) {
//                            adapter = (BaseQuickAdapter) rv_list.getAdapter();
                            ArrayList<HiddenDangerContentBean.ResultMapsBean> data = (ArrayList<HiddenDangerContentBean.ResultMapsBean>) adapter.getData();
//                            data.addAll(results);
//                            adapter.setNewData(data);
                            for (int i = 0; i < results.size(); i++) {
                                data.add(results.get(i));
                                adapter.notifyItemChanged(data.size() + (i + 1), results.get(i));
                            }

                        } else {
                            com.blankj.utilcode.util.ToastUtils.showShort("没有更多数据了!");
                        }
                    } else {
                        RecyclerViewUtils.initLiner(HiddenDangerContentActivity.this, rv_list, R.layout.item_hidden_danger_content, results, new OnGlobalListener() {
                            @Override
                            public <T> void logic(BaseViewHolder helper, List<T> mData, T item, BaseQuickAdapter mAdapter) {
                                HiddenDangerContentBean.ResultMapsBean resultsBean = (HiddenDangerContentBean.ResultMapsBean) item;
                                TextView tv_content_content = helper.getView(R.id.tv_content_content);
                                tv_content_content.setText(resultsBean.getDescription());
                            }
                        }, new BaseQuickAdapter.OnItemClickListener() {
                            @Override
                            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                                HiddenDangerContentBean.ResultMapsBean resultsBean = (HiddenDangerContentBean.ResultMapsBean) adapter.getData().get(position);
                                content = resultsBean.getDescription();
                                sourceId = resultsBean.getSourceId();
                                clause = resultsBean.getClause();//隐患标准
                                score = resultsBean.getScore();//扣分
                                money = resultsBean.getMoney();//罚款
                                processor_id = resultsBean.getProcessor_id();//处理人
                                sourceFolder = resultsBean.getCategoryId();//目录ID
                                categoryName = resultsBean.getCategoryName();
                                Intent intent = new Intent();
                                intent.putExtra("隐患内容", "" + content);
                                intent.putExtra("隐患内容ID", "" + sourceId);
                                intent.putExtra("隐患标准", "" + clause);//隐患标准
                                intent.putExtra("扣分", "" + score);//扣分
                                intent.putExtra("罚款", "" + money);//罚款
                                intent.putExtra("处理人ID", "" + processor_id);
                                intent.putExtra("目录ID", "" + sourceFolder);
                                intent.putExtra("measures", resultsBean.getMeasures());
                                intent.putExtra("隐患源", "" + categoryName);
                                setResult(HiddenDangerCode, intent);
                                finish();
                            }
                        }, null);
                    }
                } else {
                    refreshLayout.setVisibility(View.GONE);
                    ll_beijing.setVisibility(View.VISIBLE);
                }
                if (null != refreshLayout) {
                    refreshLayout.finishRefresh();
                    refreshLayout.finishLoadMore();
                }
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_label_reset:
                et_label.setText("");
                break;
            case R.id.tv_label_sure:
                //TODO  POP的值为传给Activity
                if (!TextUtils.isEmpty(et_label.getText().toString().trim())) {
                    window.dismiss();
                    //关键字搜索
                    pop_refreshView();
                } else {
                    ToastUtils.showToast(HiddenDangerContentActivity.this, "请选择关键字");
                }
                break;
        }
    }

    //关键字搜索
    private void pop_refreshView() {
        LogUtils.e("当前第" + pageIndex + "页");

        HashMap<String, String> hashMap = new HashMap<>();
        pageIndex = 1;
        hashMap.put("pageNum", "" + pageIndex);
        hashMap.put("pageSize", "500");
        hashMap.put("sourceDescSearch", "" + et_label.getText().toString().trim());
        hashMap.put(BaseLinkList.apiurl, BaseLinkList.coal_mine + BaseLinkList.hidden_content);

        mRetrofit.JsonToColliery(BaseLinkList.Base_Url, hashMap, new BaseSubscriber() {
            @Override
            public void onError(ExceptionHandle.ResponeThrowable e) {
                refreshLayout.setVisibility(View.GONE);
                ll_beijing.setVisibility(View.VISIBLE);
                if (null != refreshLayout) {
                    refreshLayout.finishRefresh();
                    refreshLayout.finishLoadMore();
                }
            }

            @Override
            public void onSuccess(JSONObject jsonObject) {
                LogUtils.e("列表->>" + jsonObject.toString());

                final HiddenDangerContentBean hiddenDangerContentBean = FastJsonTools.getBean(jsonObject.toString(), HiddenDangerContentBean.class);
                if (null != hiddenDangerContentBean && null != hiddenDangerContentBean.getMsg() && null != hiddenDangerContentBean.getData() && null != hiddenDangerContentBean.getCode() && null != hiddenDangerContentBean.getResultMaps()) {
                    refreshLayout.setVisibility(View.VISIBLE);
                    ll_beijing.setVisibility(View.GONE);
                    results = (ArrayList<HiddenDangerContentBean.ResultMapsBean>) hiddenDangerContentBean.getResultMaps();
                    adapter = (BaseQuickAdapter) rv_list.getAdapter();


                    if (pageIndex > 1) {
                        if (null != results && results.size() != 0) {
//                            adapter = (BaseQuickAdapter) rv_list.getAdapter();
                            ArrayList<HiddenDangerContentBean.ResultMapsBean> data = (ArrayList<HiddenDangerContentBean.ResultMapsBean>) adapter.getData();
//                            data.addAll(results);
//                            adapter.setNewData(data);
                            for (int i = 0; i < results.size(); i++) {
                                data.add(results.get(i));
                                adapter.notifyItemChanged(data.size() + (i + 1), results.get(i));
                            }

                        } else {
                            com.blankj.utilcode.util.ToastUtils.showShort("没有更多数据了!");
                        }
                    } else {
                        if (results.size() != 0) {
                            RecyclerViewUtils.initLiner(HiddenDangerContentActivity.this, rv_list, R.layout.item_hidden_danger_content, results, new OnGlobalListener() {
                                @Override
                                public <T> void logic(BaseViewHolder helper, List<T> mData, T item, BaseQuickAdapter mAdapter) {
                                    HiddenDangerContentBean.ResultMapsBean resultsBean = (HiddenDangerContentBean.ResultMapsBean) item;
                                    TextView tv_content_content = helper.getView(R.id.tv_content_content);
                                    tv_content_content.setText(resultsBean.getDescription());
                                }
                            }, new BaseQuickAdapter.OnItemClickListener() {
                                @Override
                                public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                                    HiddenDangerContentBean.ResultMapsBean resultsBean = (HiddenDangerContentBean.ResultMapsBean) adapter.getData().get(position);
                                    content = resultsBean.getDescription();
                                    sourceId = resultsBean.getSourceId();
                                    clause = resultsBean.getClause();//隐患标准
                                    score = resultsBean.getScore();//扣分
                                    money = resultsBean.getMoney();//罚款
                                    processor_id = resultsBean.getProcessor_id();//处理人
                                    sourceFolder = resultsBean.getCategoryId();//目录ID
                                    categoryName = resultsBean.getCategoryName();
                                    Intent intent = new Intent();
                                    intent.putExtra("隐患内容", "" + content);
                                    intent.putExtra("隐患内容ID", "" + sourceId);
                                    intent.putExtra("隐患标准", "" + clause);//隐患标准
                                    intent.putExtra("扣分", "" + score);//扣分
                                    intent.putExtra("罚款", "" + money);//罚款
                                    intent.putExtra("处理人ID", "" + processor_id);
                                    intent.putExtra("目录ID", "" + sourceFolder);
                                    intent.putExtra("隐患源", "" + categoryName);
                                    setResult(HiddenDangerCode, intent);
                                    finish();
                                }
                            }, null);
                        } else {
                            refreshLayout.setVisibility(View.GONE);
                            ll_beijing.setVisibility(View.VISIBLE);
                        }
                    }

                } else {
                    refreshLayout.setVisibility(View.GONE);
                    ll_beijing.setVisibility(View.VISIBLE);
                }
                if (null != refreshLayout) {
                    refreshLayout.finishRefresh();
                    refreshLayout.finishLoadMore();
                }
            }
        });
    }
}
