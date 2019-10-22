package com.lingjun.colliery_android.module.main.rectifyingviolations.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lingjun.colliery_android.R;
import com.lingjun.colliery_android.base.BaseActivity;
import com.lingjun.colliery_android.base.BaseFragment;
import com.lingjun.colliery_android.base.BaseLinkList;
import com.lingjun.colliery_android.base.OnGlobalListener;
import com.lingjun.colliery_android.base.UserBean;
import com.lingjun.colliery_android.base.UserBeans;
import com.lingjun.colliery_android.bean.DisobeyInfoBean;
import com.lingjun.colliery_android.bean.RectifyingManagerBean;
import com.lingjun.colliery_android.module.main.rectifyingviolations.PreviewViolationInformationActivity;
import com.lingjun.colliery_android.module.main.rectifyingviolations.ToBeStoredActivity;
import com.lingjun.colliery_android.utils.FastJsonTools;
import com.lingjun.colliery_android.utils.RecyclerViewUtils;
import com.lingjun.colliery_android.utils.retrofit.BaseSubscriber;
import com.lingjun.colliery_android.utils.retrofit.ExceptionHandle;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 作者: zengtao
 * 时间: 2019/2/27  13:45.
 * 注释:三违处理
 */
public class RectificationAndHandlingFragment extends BaseFragment {
    private RecyclerView rv_list;
    private SmartRefreshLayout refreshLayout;
    private UserBeans.UserBean dataBean;
    private ArrayList<String> jurisdiction = new ArrayList<>();
    private LinearLayout ll_beijing;

    @Override
    protected int setLayout(LayoutInflater inflater) {
        return R.layout.fragment_rectificationandhandling;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        rv_list = mRootView.findViewById(R.id.rv_list);
        refreshLayout = mRootView.findViewById(R.id.refreshLayout);
        ll_beijing = mRootView.findViewById(R.id.ll_beijing);
        dataBean = UserBeans.getInstance().getUser();
        if (null != dataBean) {
            for (String a : dataBean.getBuiltinrolelist()) {
                jurisdiction.add(a);
            }
        }

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
        if (jurisdiction.contains("DISOBEY_USER")) {
            Log.e("三违处理", jurisdiction.contains("DISOBEY_USER") + "");
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
        } else {
            return null;
        }
    }

    //列表刷新
    private void refreshView() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("page", "" + pageIndex);
        hashMap.put("pageSize", "10");
        hashMap.put("type", "1");
        hashMap.put(BaseLinkList.apiurl, BaseLinkList.coal_mine + BaseLinkList.disobeylist);
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
                LogUtils.e("三违处理列表->>" + jsonObject.toString());
                final RectifyingManagerBean managerBean = FastJsonTools.getBean(jsonObject.toString(), RectifyingManagerBean.class);
                ArrayList<RectifyingManagerBean.DataBean.PageBean.ResultsBean> resultsBeans = managerBean.getData().getPage().getResults();
                if (pageIndex > 1) {
                    BaseQuickAdapter mAdapter = (BaseQuickAdapter) rv_list.getAdapter();
                    ArrayList<RectifyingManagerBean.DataBean.PageBean.ResultsBean> resList = (ArrayList<RectifyingManagerBean.DataBean.PageBean.ResultsBean>) mAdapter.getData();
                    LogUtils.e("总数->>" + resList.size());

                    if (resultsBeans.size() == 0) {
                        ToastUtils.showShort("没有更多数据了!");
                    } else {
                        for (int i = 0; i < resultsBeans.size(); i++) {
                            resList.add(resultsBeans.get(i));
                            mAdapter.notifyItemChanged(resList.size() + (i + 1), resultsBeans.get(i));
                        }
                    }
                } else {
                    if (resultsBeans.size() != 0) {
                        RecyclerViewUtils.initLiner(getActivity(), rv_list, R.layout.item_rectifying_manager, resultsBeans, new OnGlobalListener() {
                            @Override
                            public <T> void logic(BaseViewHolder helper, List<T> mData, T item, BaseQuickAdapter mAdapter) {

                                RectifyingManagerBean.DataBean.PageBean.ResultsBean resBean = (RectifyingManagerBean.DataBean.PageBean.ResultsBean) item;
                                RectifyingManagerBean.DataBean.PageBean.ResultsBean.UserBean user = resBean.getUser();
                                TextView tv_text = helper.getView(R.id.tv_text);
                                TextView tv_leader = helper.getView(R.id.tv_leader);
                                TextView tv_time = helper.getView(R.id.tv_time);
                                TextView tv_bumen = helper.getView(R.id.tv_bumen);
                                TextView tv_state = helper.getView(R.id.tv_state);
                                TextView tv_name = helper.getView(R.id.tv_name);
                                ImageView iv_icon = helper.getView(R.id.iv_icon);

                                tv_text.setText(resBean.getBehavior());
                                tv_leader.setText("领导:" + resBean.getResponsibleLeaderName());
                                tv_time.setText("" + resBean.getShowtime());
                                tv_bumen.setText(resBean.getResponsibleDepartmentName());

                                tv_name.setText(user.getName());
                                if (!TextUtils.isEmpty(user.getPictureurl())) {
                                    Glide.with(getActivity()).load(user.getPictureurl()).into(iv_icon);
                                } else {
//                                    String url = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1540203338&di=9247014afd935d47a128122e8c73c549&imgtype=jpg&er=1&src=http%3A%2F%2Fi2.hdslb.com%2Fbfs%2Farchive%2F1b6e96735930655e2c4ba1df2a5c4c9846c8aef7.jpg";
                                    Glide.with(getActivity()).load(R.drawable.deafultuser).into(iv_icon);
                                }

                                if (!TextUtils.isEmpty(resBean.getState())) {
                                    if (resBean.getState().equals("2")) {
                                        tv_state.setText("审核中");
                                    } else if (resBean.getState().equals("3")) {
                                        tv_state.setText("被驳回");
                                    } else if (resBean.getState().equals("4")) {
                                        tv_state.setText("确认中");
                                    } else if (resBean.getState().equals("8")) {
                                        tv_state.setText("待销号");
                                    } else if (resBean.getState().equals("6")) {
                                        tv_state.setText("被申诉");
                                    }
                                }
                            }
                        }, new BaseQuickAdapter.OnItemClickListener() {
                            @Override
                            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                                RectifyingManagerBean.DataBean.PageBean.ResultsBean resBean = (RectifyingManagerBean.DataBean.PageBean.ResultsBean) adapter.getData().get(position);

                                if (resBean.getState().equals("8")) {
                                    Intent intent = new Intent(getActivity(), ToBeStoredActivity.class);
                                    intent.putExtra("taskId", "" + resBean.getTaskId());
                                    intent.putExtra("state", "" + resBean.getState());
                                    intent.putExtra("extraType", "" + resBean.getExtraType());
                                    intent.putExtra("jiuwei", "0");
                                    startActivity(intent);
                                } else {
                                    Intent intent = new Intent(getActivity(), PreviewViolationInformationActivity.class);
                                    intent.putExtra("taskId", "" + resBean.getTaskId());
                                    intent.putExtra("state", "" + resBean.getState());
                                    intent.putExtra("type", "1");
                                    startActivity(intent);
                                }

                            }
                        }, null);
                    } else {
                        refreshLayout.setVisibility(View.GONE);
                        ll_beijing.setVisibility(View.VISIBLE);
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
    public void onResume() {
        super.onResume();
        refreshLayout.autoRefresh();
    }


}
