package com.lingjun.colliery_android.module.main.rectifyingviolations;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lingjun.colliery_android.R;
import com.lingjun.colliery_android.base.BaseActivity;
import com.lingjun.colliery_android.base.BaseLinkList;
import com.lingjun.colliery_android.base.OnGlobalListener;
import com.lingjun.colliery_android.bean.UnsafeBehaviorBean;
import com.lingjun.colliery_android.bean.UnsafeBehaviorInfoBean;
import com.lingjun.colliery_android.module.main.SelectPersonnelActivity;
import com.lingjun.colliery_android.utils.FastJsonTools;
import com.lingjun.colliery_android.utils.RecyclerViewUtils;
import com.lingjun.colliery_android.utils.retrofit.BaseSubscriber;
import com.lingjun.colliery_android.utils.retrofit.ExceptionHandle;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 选择不安全行为
 * Created by nefa on 2018/11/16.
 */

public class UnsafeBehaviorActivity extends BaseActivity {

    public static final int RectifyingCode = 302;
    private TextView tv_num;
    private RecyclerView rv_left_list;
    private RecyclerView rv_right_list;
    private RelativeLayout rl_bottom;
    private Button btn_queding;
    private ArrayList<String> mSelect = new ArrayList<>();
    private ArrayList<UnsafeBehaviorInfoBean.DataBean.ListBean> mSelectData = new ArrayList<>();
    private SmartRefreshLayout smartRefreshLayout;
    private PopupWindow window;
    //搜索
    private EditText et_earch;
    private ImageView iv_clear;
    private TextView tv_reset;
    private TextView tv_search;
    private ImageView iv_screen;

    private int unsafeBehaviorid;

    private ArrayList<String> catalogidlist = new ArrayList<>();// 不安全目录集合

    @Override
    protected int getResourcesId() {
        return R.layout.activity_unsafe_behavior;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        rv_left_list = findViewById(R.id.rv_left_list);
        rv_right_list = findViewById(R.id.rv_right_list);
        tv_num = findViewById(R.id.tv_num);
        rl_bottom = findViewById(R.id.rl_bottom);
        btn_queding = findViewById(R.id.btn_queding);
        iv_screen = findViewById(R.id.iv_screen);

        //搜索
        pop_name();
        refreshView();
    }

    @SuppressLint("ClickableViewAccessibility")
    private void pop_name() {
        iv_screen.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

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
                                    pop_refreshView();//搜索
                                } else {
                                    com.lingjun.colliery_android.utils.ToastUtils.showToast(UnsafeBehaviorActivity.this, "关键词不能为空");
                                    return;
                                }
                                break;
                        }

                    }
                };

                iv_clear.setOnClickListener(onClickListener);
                tv_reset.setOnClickListener(onClickListener);
                tv_search.setOnClickListener(onClickListener);

                return false;
            }
        });
    }

    private void pop_refreshView() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(BaseLinkList.apiurl, BaseLinkList.coal_mine + BaseLinkList.clausecategorytree);
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
                LogUtils.e("目录1->>" + jsonObject.toString());
                UnsafeBehaviorBean unsafeBehaviorBean = FastJsonTools.getBean(jsonObject.toString(), UnsafeBehaviorBean.class);
                if (null != unsafeBehaviorBean.getData().getTree() && unsafeBehaviorBean.getData().getTree().size() != 0) {
                    RecyclerViewUtils.initLiner(UnsafeBehaviorActivity.this, rv_left_list, R.layout.item_unsafebehavior, unsafeBehaviorBean.getData().getTree(), new OnGlobalListener() {
                        @Override
                        public <T> void logic(BaseViewHolder helper, List<T> mData, T item, BaseQuickAdapter mAdapter) {
                            UnsafeBehaviorBean.DataBean.TreeBean treeBean = (UnsafeBehaviorBean.DataBean.TreeBean) item;
                            TextView tv_name = helper.getView(R.id.tv_name);
                            tv_name.setText(treeBean.getName());
                        }
                    }, new BaseQuickAdapter.OnItemClickListener() {
                        @Override
                        public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                            UnsafeBehaviorBean.DataBean.TreeBean treeBean = (UnsafeBehaviorBean.DataBean.TreeBean) adapter.getData().get(position);
                            showLoadDialog();
                            HashMap<String, String> params = new HashMap<>();
                            params.put("categoryid", "" + treeBean.getId());
                            params.put("searchStr", "" + et_earch.getText().toString().trim());
                            params.put(BaseLinkList.apiurl, BaseLinkList.coal_mine + BaseLinkList.clauselistBycategoryid);
                            mRetrofit.JsonToColliery(BaseLinkList.Base_Url, params, new BaseSubscriber() {
                                @Override
                                public void onError(ExceptionHandle.ResponeThrowable e) {
                                    dismissDialog();
                                }

                                @Override
                                public void onSuccess(JSONObject jsonObject) {
                                    LogUtils.e("详情->>" + jsonObject.toString());
                                    UnsafeBehaviorInfoBean unsafeBehaviorInfoBean = FastJsonTools.getBean(jsonObject.toString(), UnsafeBehaviorInfoBean.class);
                                    ArrayList<UnsafeBehaviorInfoBean.DataBean.ListBean> list = unsafeBehaviorInfoBean.getData().getList();
                                    RecyclerViewUtils.initLiner(UnsafeBehaviorActivity.this, rv_right_list, R.layout.item_hidden_danger_paln, list, new OnGlobalListener() {
                                        @Override
                                        public <T> void logic(BaseViewHolder helper, List<T> mData, T item, BaseQuickAdapter mAdapter) {
                                            UnsafeBehaviorInfoBean.DataBean.ListBean data = (UnsafeBehaviorInfoBean.DataBean.ListBean) item;
                                            RelativeLayout rl_name = helper.getView(R.id.rl_plan);
                                            TextView tv_name = helper.getView(R.id.ll_plan);
                                            tv_name.setText(data.getDescription());

                                            if (!data.isType()) {
                                                rl_name.setBackgroundResource(R.drawable.shape_bg_gray);
                                            } else {
                                                rl_name.setBackgroundResource(R.drawable.shape_bg_blue);
                                            }
                                        }
                                    }, new BaseQuickAdapter.OnItemClickListener() {
                                        @Override
                                        public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                                            UnsafeBehaviorInfoBean.DataBean.ListBean data = (UnsafeBehaviorInfoBean.DataBean.ListBean) adapter.getData().get(position);
//                                            if (mSelect.size() != 0) {
//                                                for (String id : mSelect) {
//                                                    if (id.equals("" + data.getId())) {
//                                                        return;
//                                                    }
//                                                }
//                                                mSelect.add("" + data.getId());
//                                            } else {
//                                                mSelect.add("" + data.getId());
//                                            }

                                            if (data.isType()) {
                                                data.setType(false);
                                                mSelectData.remove(data);
                                            } else {
                                                data.setType(true);
                                                mSelectData.add(data);
                                            }
                                            adapter.notifyItemChanged(position);
                                            tv_num.setText("" + (mSelectData.size()));
                                        }
                                    }, null);
                                    dismissDialog();
                                }
                            });
                        }
                    }, null);

                }
                if (null != refreshLayout) {
                    refreshLayout.finishRefresh();
                    refreshLayout.finishLoadMore();
                }
            }
        });

        btn_queding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mSelectData.size() == 0) {
                    ToastUtils.showShort("至少选择一个");
                    return;
                }

                String str = "";
                for (int i = 0; i < mSelect.size(); i++) {
                    if (i == 0) {
                        str = mSelect.get(i);
                    } else {
                        str += "," + mSelect.get(i);
                    }
                }

                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                TestBean testBean = new TestBean();
                testBean.arrayList = mSelectData;
                bundle.putSerializable("databean", testBean);
                intent.putExtra("ids", str);
                intent.putExtra("bundle", bundle);
                setResult(UnsafeBehaviorActivity.RectifyingCode, intent);
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
//        return null;
    }

    //刷新View
    private void refreshView() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(BaseLinkList.apiurl, BaseLinkList.coal_mine + BaseLinkList.clausecategorytree);
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
                LogUtils.e("目录1->>" + jsonObject.toString());
                UnsafeBehaviorBean unsafeBehaviorBean = FastJsonTools.getBean(jsonObject.toString(), UnsafeBehaviorBean.class);
                if (null != unsafeBehaviorBean.getData().getTree() && unsafeBehaviorBean.getData().getTree().size() != 0) {
                    RecyclerViewUtils.initLiner(UnsafeBehaviorActivity.this, rv_left_list, R.layout.item_unsafebehavior, unsafeBehaviorBean.getData().getTree(), new OnGlobalListener() {
                        @Override
                        public <T> void logic(BaseViewHolder helper, List<T> mData, T item, BaseQuickAdapter mAdapter) {
                            UnsafeBehaviorBean.DataBean.TreeBean treeBean = (UnsafeBehaviorBean.DataBean.TreeBean) item;
                            TextView tv_name = helper.getView(R.id.tv_name);
                            tv_name.setText(treeBean.getName());
                        }
                    }, new BaseQuickAdapter.OnItemClickListener() {
                        @Override
                        public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                            UnsafeBehaviorBean.DataBean.TreeBean treeBean = (UnsafeBehaviorBean.DataBean.TreeBean) adapter.getData().get(position);
                            showLoadDialog();
                            HashMap<String, String> params = new HashMap<>();
                            unsafeBehaviorid = treeBean.getId();
                            catalogidlist.add(unsafeBehaviorid + "");
                            Log.e("catalogidlist", catalogidlist + "");
                            params.put("categoryid", "" + unsafeBehaviorid);
                            params.put(BaseLinkList.apiurl, BaseLinkList.coal_mine + BaseLinkList.clauselistBycategoryid);
                            mRetrofit.JsonToColliery(BaseLinkList.Base_Url, params, new BaseSubscriber() {
                                @Override
                                public void onError(ExceptionHandle.ResponeThrowable e) {
                                    dismissDialog();
                                }

                                @Override
                                public void onSuccess(JSONObject jsonObject) {
                                    LogUtils.e("详情->>" + jsonObject.toString());
                                    UnsafeBehaviorInfoBean unsafeBehaviorInfoBean = FastJsonTools.getBean(jsonObject.toString(), UnsafeBehaviorInfoBean.class);
                                    ArrayList<UnsafeBehaviorInfoBean.DataBean.ListBean> list = unsafeBehaviorInfoBean.getData().getList();
                                    RecyclerViewUtils.initLiner(UnsafeBehaviorActivity.this, rv_right_list, R.layout.item_hidden_danger_paln, list, new OnGlobalListener() {
                                        @Override
                                        public <T> void logic(BaseViewHolder helper, List<T> mData, T item, BaseQuickAdapter mAdapter) {
                                            UnsafeBehaviorInfoBean.DataBean.ListBean data = (UnsafeBehaviorInfoBean.DataBean.ListBean) item;
                                            RelativeLayout rl_name = helper.getView(R.id.rl_plan);
                                            TextView tv_name = helper.getView(R.id.ll_plan);
                                            tv_name.setText(data.getDescription());

                                            if (!data.isType()) {
                                                rl_name.setBackgroundResource(R.drawable.shape_bg_gray);
                                            } else {
                                                rl_name.setBackgroundResource(R.drawable.shape_bg_blue);
                                            }
                                        }
                                    }, new BaseQuickAdapter.OnItemClickListener() {
                                        @Override
                                        public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                                            UnsafeBehaviorInfoBean.DataBean.ListBean data = (UnsafeBehaviorInfoBean.DataBean.ListBean) adapter.getData().get(position);
//                                            if (mSelect.size() != 0) {
////                                                for (String id : mSelect) {
////                                                    if (id.equals("" + data.getId())) {
////                                                        return;
////                                                    }
////                                                }
////                                                mSelect.add("" + data.getId());
////                                            } else {
////                                                mSelect.add("" + data.getId());
////                                            }

                                            if (data.isType()) {
                                                data.setType(false);
                                                mSelectData.remove(data);
                                            } else {
                                                data.setType(true);
                                                mSelectData.add(data);
                                            }
                                            adapter.notifyItemChanged(position);
                                            tv_num.setText("" + (mSelectData.size()));
                                        }
                                    }, null);
                                    dismissDialog();
                                }
                            });
                        }
                    }, null);

                }
                if (null != refreshLayout) {
                    refreshLayout.finishRefresh();
                    refreshLayout.finishLoadMore();
                }
            }
        });

        btn_queding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mSelectData.size() == 0) {
                    ToastUtils.showShort("至少选择一个");
                    return;
                }

                String str = "";
                for (int i = 0; i < mSelect.size(); i++) {
                    if (i == 0) {
                        str = mSelect.get(i);
                    } else {
                        str += "," + mSelect.get(i);
                    }
                }

                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                TestBean testBean = new TestBean();
                testBean.arrayList = mSelectData;
                bundle.putSerializable("databean", testBean);
                intent.putExtra("ids", str);
                intent.putExtra("bundle", bundle);
                intent.putExtra("unsafeBehaviorid", unsafeBehaviorid);
                setResult(UnsafeBehaviorActivity.RectifyingCode, intent);
                finish();
            }
        });

        /*rl_bottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mSelect.size() == 0){
                    ToastUtils.showShort("至少选择一个");
                    return;
                }

                String str = "";
                for (int i=0;i<mSelect.size();i++){
                    if (i == 0){
                        str = mSelect.get(i);
                    }else {
                        str += ","+mSelect.get(i);
                    }
                }

                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                TestBean testBean = new TestBean();
                testBean.arrayList = mSelectData;
                bundle.putSerializable("databean",testBean);
                intent.putExtra("ids",str);
                intent.putExtra("bundle",bundle);
                setResult(UnsafeBehaviorActivity.RectifyingCode,intent);
                finish();
            }
        });*/
    }

    public static class TestBean implements Serializable {
        public ArrayList<UnsafeBehaviorInfoBean.DataBean.ListBean> arrayList;
    }
}
