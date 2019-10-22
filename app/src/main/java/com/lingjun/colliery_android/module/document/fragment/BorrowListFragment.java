package com.lingjun.colliery_android.module.document.fragment;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.blankj.utilcode.util.ConvertUtils;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.StringUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lingjun.colliery_android.R;
import com.lingjun.colliery_android.base.BaseFragment;
import com.lingjun.colliery_android.base.BaseLinkList;
import com.lingjun.colliery_android.base.OnGlobalListener;
import com.lingjun.colliery_android.bean.BorrowInfoBean;
import com.lingjun.colliery_android.bean.DocumentInfoBean;
import com.lingjun.colliery_android.bean.HiddenDangerDetailsBean;
import com.lingjun.colliery_android.bean.MainNewsBean;
import com.lingjun.colliery_android.module.document.activity.BorrowApplyActivity;
import com.lingjun.colliery_android.module.document.activity.DocumentSearchListActivity;
import com.lingjun.colliery_android.module.main.FileTransferActivity;
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
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 作者: lihuan
 * 时间: 2018/12/17 17:05
 * 说明: 借阅列表
 */
public class BorrowListFragment extends BaseFragment {
    private static final String ARG_PARAM1 = "param1";

    @BindView(R.id.rv_list)
    RecyclerView rv_list;
    Unbinder unbinder;

    private int mParam;
    private LinearLayout ll_beijing;
    private ArrayList<BorrowInfoBean.ResultMapsBean> results = new ArrayList<>();

    public BorrowListFragment() {
    }

    public static BorrowListFragment newInstance(int param1) {
        BorrowListFragment fragment = new BorrowListFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        if (getArguments() != null) {
//            mParam = getArguments().getInt(ARG_PARAM1);
//        }
//    }

    @Override
    protected int setLayout(LayoutInflater inflater) {
        return R.layout.fragment_borrow_list;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        if (getArguments() != null) {
            mParam = getArguments().getInt(ARG_PARAM1);
        }
        ll_beijing = mRootView.findViewById(R.id.ll_beijing);
        ll_beijing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                refreshLayout.autoRefresh();
                refreshLayout.setVisibility(View.VISIBLE);
                ll_beijing.setVisibility(View.GONE);
            }
        });
        rv_list.addItemDecoration(new RxRecyclerViewDividerTool(0, 0, 0, RxImageTool.dp2px(8f), true));
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

    /**
     * 借阅清单
     */
    private void refreshView() {
        LogUtils.e("当前第" + pageIndex + "页");

        HashMap<String, String> hashMap = new HashMap<>();

        hashMap.put("pageNum", String.valueOf(pageIndex));//当前页码
        hashMap.put("pageSize", "10"); //每页数量
        hashMap.put("taskType", "3"); //任务类型
        hashMap.put("state", String.valueOf(mParam)); //借阅状态
        hashMap.put(BaseLinkList.apiurl, BaseLinkList.coal_mine + BaseLinkList.getBorrowList);
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
                LogUtils.e("借阅清单列表->>" + jsonObject.toString());

                BorrowInfoBean borrowInfoBean = FastJsonTools.getBean(jsonObject.toString(), BorrowInfoBean.class);
                if (null != borrowInfoBean && null != borrowInfoBean.getResultMaps()) {
                    if (pageIndex > 1) {
                        if (null != borrowInfoBean.getResultMaps() && borrowInfoBean.getResultMaps().size() != 0) {
                            BaseQuickAdapter adapter = (BaseQuickAdapter) rv_list.getAdapter();
//                            ArrayList<BorrowInfoBean.ResultMapsBean> data = (ArrayList<BorrowInfoBean.ResultMapsBean>) adapter.getData();
//                            for (int i = 0; i < results.size(); i++) {
//                                data.add(results.get(i));
//                                adapter.notifyItemChanged(data.size() + (i + 1), results.get(i));
//                            }
                            results.addAll(borrowInfoBean.getResultMaps());
                            adapter.notifyDataSetChanged();
                        } else {
                            ToastUtils.showShort("没有更多数据了!");
                        }
                    } else {
                        if (results.size() != 0) {
                            results.clear();
                        }
                        if (borrowInfoBean.getResultMaps().size() != 0) {
                            results.addAll(borrowInfoBean.getResultMaps());
                            RecyclerViewUtils.initLiner(getActivity(), rv_list, R.layout.item_document_list, results, new OnGlobalListener() {
                                @Override
                                public <T> void logic(BaseViewHolder helper, List<T> mData, T item, BaseQuickAdapter mAdapter) {
                                    final BorrowInfoBean.ResultMapsBean resultsBean = (BorrowInfoBean.ResultMapsBean) item;
                                    TextView tvTaskName = helper.getView(R.id.tv_doc_name);
                                    TextView tvStatus = helper.getView(R.id.tv_doc_day);
                                    LinearLayout llShowMore = helper.getView(R.id.ll_show_more);
                                    TextView tvDocNumber = helper.getView(R.id.tv_doc_number);
                                    final ImageView ivArrow = helper.getView(R.id.iv_show_more);
                                    TextView tvGuiFan = helper.getView(R.id.tv_standard);
                                    TextView tvTime = helper.getView(R.id.tv_create_time);
                                    TextView tvFlag = helper.getView(R.id.tv_flag);
                                    Button btnDetail = helper.getView(R.id.btn_detail);
                                    RecyclerView rv_list = helper.getView(R.id.rv_document_list);
                                    final ConstraintLayout layout = helper.getView(R.id.cl_content);

                                    if (resultsBean != null) {
                                        tvTaskName.setText(resultsBean.getName());
                                        tvDocNumber.setText("编号：" + StringUtils.null2Length0(resultsBean.getNumber()));
                                        tvGuiFan.setText("规范：" + StringUtils.null2Length0(resultsBean.getStdname()));
                                        tvTime.setText("创建：" + DateUtil.getStringByFormat(resultsBean.getEditionTime(), "yyyy-MM-dd"));

                                        //TODO
                                        GradientDrawable drawable = (GradientDrawable) tvStatus.getBackground();
                                        drawable.setColor(getResources().getColor(R.color.transparent));
                                        if (mParam == 2) {
                                            drawable.setStroke(1, Color.parseColor("#FFFFFF"));
                                            tvStatus.setText(Html.fromHtml("<font color='#FFCA28'>剩" + resultsBean.getReturnDay() + "</font>"));
                                        } else if (mParam == 1) {
                                            //设置圆角大小
//                                      drawable.setCornerRadius(5);
                                            //设置边缘线的宽以及颜色
                                            drawable.setStroke(ConvertUtils.dp2px(0.5f), Color.parseColor("#FFFFCA28"));
//                                      //设置shape背景色
//                                      drawable.setColor(Color.parseColor("#FFFFFF"));
                                            tvStatus.setText(Html.fromHtml("<font color='#FFCA28'>" + resultsBean.getTaskStateFlag() + "</font>"));
                                        } else {
                                            //设置边缘线的宽以及颜色
                                            drawable.setStroke(ConvertUtils.dp2px(0.5f), Color.parseColor("#FFFE0000"));
                                            tvStatus.setText(Html.fromHtml("<font color='#FE0000'>" + resultsBean.getTaskStateFlag() + "</font>"));
                                        }
                                        tvStatus.setBackgroundDrawable(drawable);

//                                    //标签处理
//                                    StringBuilder builder = new StringBuilder();
//                                    if (resultsBean.getEditionKeysName() != null) {
//                                        for (int i = 0; i < resultsBean.getEditionKeysName().size(); i++) {
//                                            DocumentInfoBean.DataBean.PageBean.ResultsBean.EditionKeysNameBean flag =
//                                                    resultsBean.getEditionKeysName().get(i);
//                                            builder.append(flag.getName());
//                                            if (i != resultsBean.getEditionKeysName().size() - 1) {
//                                                builder.append("、");
//                                            }
//                                        }
//                                    }
//                                    tvFlag.setText("标签：" + builder.toString());
                                        tvFlag.setText("标签：" + resultsBean.getKeysName());

                                        if (resultsBean.getFileList() != null) {
                                            RecyclerViewUtils.initLiner(getActivity(), rv_list, R.layout.item_deal_with_file2, resultsBean.getFileList(), new OnGlobalListener() {
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

                                    if (resultsBean.isOpen()) {
                                        layout.setVisibility(View.VISIBLE);
                                    } else {
                                        layout.setVisibility(View.GONE);
                                    }

                                    llShowMore.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View view) {
                                            if (resultsBean.isOpen()) {
                                                resultsBean.setOpen(false);
                                                layout.setVisibility(View.GONE);
                                                ivArrow.setImageResource(R.drawable.ic_arrow_down);
                                            } else {
                                                resultsBean.setOpen(true);
                                                layout.setVisibility(View.VISIBLE);
                                                ivArrow.setImageResource(R.drawable.ic_arrow_up);
                                            }
                                        }
                                    });

                                    btnDetail.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View view) {
                                            Intent intent = new Intent(getActivity(), BorrowApplyActivity.class);
                                            intent.putExtra("taskId", resultsBean.getTaskId());
                                            intent.putExtra("from", "applyList");
                                            startActivity(intent);
                                        }
                                    });

                                }
                            }, new BaseQuickAdapter.OnItemClickListener() {
                                @SuppressLint("ResourceType")
                                @Override
                                public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
//                                BorrowInfoBean.ResultMapsBean resultMapsBean = (BorrowInfoBean.ResultMapsBean) adapter.getData().get(position);
//                                Intent intent = new Intent(getActivity(), BorrowApplyActivity.class);
//                                intent.putExtra("taskId", resultMapsBean.getTaskId());
//                                intent.putExtra("from", "applyList");
//                                startActivity(intent);
                                }
                            }, null);
                        } else {
                            refreshLayout.setVisibility(View.GONE);
                            ll_beijing.setVisibility(View.VISIBLE);
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

}
