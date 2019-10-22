package com.lingjun.colliery_android.module.main;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.CardView;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.blankj.utilcode.util.ConvertUtils;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ScreenUtils;
import com.blankj.utilcode.util.StringUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lingjun.colliery_android.R;
import com.lingjun.colliery_android.base.BaseFragment;
import com.lingjun.colliery_android.base.BaseLinkList;
import com.lingjun.colliery_android.base.OnGlobalListener;
import com.lingjun.colliery_android.base.UserBean;
import com.lingjun.colliery_android.base.UserBeans;
import com.lingjun.colliery_android.bean.MainButtionBean;
import com.lingjun.colliery_android.bean.MainImageBean;
import com.lingjun.colliery_android.bean.MainNewsBean;
import com.lingjun.colliery_android.bean.WebViewBean;
import com.lingjun.colliery_android.module.dealwith.hiddendanger.activity.HiddenDangersDetailsActivity;
import com.lingjun.colliery_android.module.dealwith.hiddendanger.activity.HiddenDangersHandleActivity;
import com.lingjun.colliery_android.module.dealwith.hiddendanger.activity.HiddenDangersHistoryActivity;
import com.lingjun.colliery_android.module.dealwith.hiddendanger.activity.QuestionsListActivity;
import com.lingjun.colliery_android.module.dealwith.hiddendanger.activity.RectificationListActivity;
import com.lingjun.colliery_android.module.dealwith.hiddendanger.activity.RectifyHistoryActivity;
import com.lingjun.colliery_android.module.dealwith.hiddendanger.activity.SupervisionOfListingActivity;
import com.lingjun.colliery_android.module.dealwith.hiddendanger.activity.SurveyRecordActivity;
import com.lingjun.colliery_android.module.dealwith.hiddendanger.activity.ToBeAuditedActivity;
import com.lingjun.colliery_android.module.dealwith.hiddendanger.general_hidden_danger.HiddenDangerNtryActivity;
import com.lingjun.colliery_android.module.document.activity.DocumentSearchActivity;
import com.lingjun.colliery_android.module.document.activity.TaskTrackingActivity;
import com.lingjun.colliery_android.module.login.LoginActivity;
import com.lingjun.colliery_android.module.main.rectifyingviolations.MoreNoticelistActivity;
import com.lingjun.colliery_android.module.main.rectifyingviolations.NoticelistActivity;
import com.lingjun.colliery_android.module.main.rectifyingviolations.PreviewViolationInformationActivity;
import com.lingjun.colliery_android.module.main.rectifyingviolations.RectifyingViolationsActivity;
import com.lingjun.colliery_android.module.main.rectifyingviolations.RectifyingViolationsManagementActivity;
import com.lingjun.colliery_android.module.main.rectifyingviolations.RiskTrackingActivity;
import com.lingjun.colliery_android.module.main.rectifyingviolations.fragment.AssessmentActivity;
import com.lingjun.colliery_android.module.main.rectifyingviolations.fragment.RectifyingViolationsFragment;
import com.lingjun.colliery_android.module.siyuanliangzhang.SyliangzhangActivity;
import com.lingjun.colliery_android.utils.FastJsonTools;
import com.lingjun.colliery_android.utils.RecyclerViewUtils;
import com.lingjun.colliery_android.utils.retrofit.BaseSubscriber;
import com.lingjun.colliery_android.utils.retrofit.ExceptionHandle;
import com.vondear.rxui.view.RxTextViewVerticalMore;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.loader.ImageLoader;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import cc.shinichi.library.tool.utility.ui.ToastUtil;

/**
 * 2222
 * Created by nefa on 2018/10/15.
 */

public class MainFragment extends BaseFragment {
    private ImageView lv_main1;
    private LinearLayout ll_main1, ll_main2;
    private RecyclerView rv_grid_list;
    private RecyclerView rv_grid_list1;
    private RecyclerView rv_grid_list2;
    private RxTextViewVerticalMore tv_upScroll;
    private ArrayList<String> titleList = new ArrayList<String>();
    private Banner banner;
    private CardView cv_banner;
    private RecyclerView rv_list;
    private LinearLayout ll_list_root;
    boolean flag = true;
    private TextView tv_more;
    private ArrayList<String> jurisdiction = new ArrayList<>();
    private View dialogview;
    private AlertDialog dialog;

    private Integer[] imgs = {R.drawable.banner, R.drawable.banner1, R.drawable.banner2};

    @Override
    protected int setLayout(LayoutInflater inflater) {
        return R.layout.fragment_main;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        refreshView();
        ll_main1 = mRootView.findViewById(R.id.ll_main1);
        ll_main2 = mRootView.findViewById(R.id.ll_main2);
        tv_more = mRootView.findViewById(R.id.tv_more);
        rv_grid_list = mRootView.findViewById(R.id.rv_grid_list);
        rv_grid_list1 = mRootView.findViewById(R.id.rv_grid_list1);
        rv_grid_list2 = mRootView.findViewById(R.id.rv_grid_list2);

        tv_upScroll = mRootView.findViewById(R.id.tv_upScroll);
        ll_list_root = mRootView.findViewById(R.id.ll_list_root);
        rv_list = mRootView.findViewById(R.id.rv_list);

        Jurisdiction();
        tv_more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), MoreNoticelistActivity.class));
            }
        });

        List<View> views = new ArrayList<>();
        setUPMarqueeView(views, 20);
        tv_upScroll.setViews(views);

        tv_upScroll.setOnItemClickListener(new RxTextViewVerticalMore.OnItemClickListener() {
            @Override
            public void onItemClick(int i, View view) {
                ToastUtils.showShort("嘿嘿");
            }
        });


        int[] main1Images = {R.drawable.main_ybyh, R.drawable.main_yhcl, R.drawable.main_yhdb, R.drawable.main_zdyh, R.drawable.main_jwlr, R.drawable.main_swgl, R.drawable.main_swls, R.drawable.main_fxgz1};
        String[] names1 = {"隐患录入", "隐患处理", "隐患督办", "隐患历史", "三违录入", "三违管理", "三违历史 ", "风险跟踪"};

        int[] main2Images = {R.drawable.main_zgqd, R.drawable.main_wtqd, R.drawable.main_xylz, R.drawable.main_gzgz};
        String[] names2 = {"标准化清单", "问题清单", "四员两长", "行为考核"};


        ArrayList<MainButtionBean> mList1 = new ArrayList<>();
        for (int i = 0; i < names1.length; i++) {
            MainButtionBean mainButtionBean = new MainButtionBean();
            mainButtionBean.setImgUrl(main1Images[i]);
            mainButtionBean.setBtnName(names1[i]);
            mList1.add(mainButtionBean);
        }

        ArrayList<MainButtionBean> mList2 = new ArrayList<>();
        for (int i = 0; i < names2.length; i++) {
            MainButtionBean mainButtionBean = new MainButtionBean();
            mainButtionBean.setImgUrl(main2Images[i]);
            mainButtionBean.setBtnName(names2[i]);
            mList2.add(mainButtionBean);
        }

        int screenWidth = ScreenUtils.getScreenWidth();
        final int curWidth = screenWidth / 4;

        RecyclerViewUtils.initGridNoSc(getActivity(), rv_grid_list1, R.layout.item_grid_button, mList1, new OnGlobalListener() {
            @Override
            public <T> void logic(BaseViewHolder helper, List<T> mData, T item, BaseQuickAdapter mAdapter) {
                MainButtionBean bean = (MainButtionBean) item;
                ImageView iv_icon = helper.getView(R.id.iv_icon);
                TextView tv_buttonName = helper.getView(R.id.tv_buttonName);
                CardView cv_root = helper.getView(R.id.cv_root);
                int curHeight = ConvertUtils.dp2px(95);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(curWidth, curHeight);
                cv_root.setLayoutParams(layoutParams);
                iv_icon.setImageResource(bean.getImgUrl());
                tv_buttonName.setText(bean.getBtnName());
            }
        }, new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                switch (position) {
                    case 0://隐患录入
                        Log.e("一般隐患", jurisdiction.contains("TROUBLE_USER") + "");
                        if (jurisdiction.contains("TROUBLE_USER")) {
                            Intent intent = new Intent(getActivity(), HiddenDangerNtryActivity.class);
                            intent.putExtra("type", 1);
                            startActivity(intent);
                        } else {
                            ToastUtils.showShort("你没有权限");
                        }
                        break;
                    case 1://隐患处理
                        Log.e("隐患处理", jurisdiction.contains("TROUBLE_MANAGER") + "");
                        if (jurisdiction.contains("TROUBLE_MANAGER")) {
                            startActivity(new Intent(getActivity(), HiddenDangersHandleActivity.class));
                        } else {
                            ToastUtils.showShort("你没有权限");
                        }
                        break;
                    case 2://隐患督办
                        Log.e("隐患督办", jurisdiction.contains("TROUBLE_RANDOMCHECK") + "");
                        if (jurisdiction.contains("TROUBLE_RANDOMCHECK")) {
                            startActivity(new Intent(getActivity(), SupervisionOfListingActivity.class));
                        } else {
                            ToastUtils.showShort("你没有权限");
                        }
                        break;
                    case 3://隐患历史
                        Log.e("隐患历史", jurisdiction.contains("TROUBLE_MANHISTORY") + "");
                        if (jurisdiction.contains("TROUBLE_MANHISTORY")) {
                            startActivity(new Intent(getActivity(), HiddenDangersHistoryActivity.class));
                        } else {
                            ToastUtils.showShort("你没有权限");
                        }
                        break;
                    case 4://三违录入
                        Log.e("三违录入", jurisdiction.contains("DISOBEY_USER") + "");
                        if (jurisdiction.contains("DISOBEY_USER")) {
                            Intent intent = new Intent(getActivity(), RectifyingViolationsActivity.class);
                            intent.putExtra("type", "1");
                            startActivity(intent);
                        } else {
                            ToastUtils.showShort("你没有权限");
                        }
                        break;
                    case 5://三违管理
                        startActivity(new Intent(getActivity(), RectifyingViolationsManagementActivity.class));
                        break;
                    case 6://三违历史
                        if (jurisdiction.contains("DISOBEY_MANHISTORY")) {
                            startActivity(new Intent(getActivity(), RectifyHistoryActivity.class));
                        } else {
                            ToastUtils.showShort("你没有权限");
                        }
//                        startActivity(new Intent(getActivity(), FileTransferActivity.class));//文件传输
                        break;
                    case 7://风险跟踪
                        startActivity(new Intent(getActivity(), RiskTrackingActivity.class));
                        break;
                    default:
                }
            }
        }, 4, null);
        RecyclerViewUtils.initGridNoSc(getActivity(), rv_grid_list2, R.layout.item_grid_button1, mList2, new OnGlobalListener() {
            @Override
            public <T> void logic(BaseViewHolder helper, List<T> mData, T item, BaseQuickAdapter mAdapter) {
                MainButtionBean bean = (MainButtionBean) item;
                ImageView iv_icon = helper.getView(R.id.iv_icon);
                TextView tv_buttonName = helper.getView(R.id.tv_buttonName);
                CardView cv_root = helper.getView(R.id.cv_root);
                int curHeight = ConvertUtils.dp2px(90);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(curWidth, curHeight);
                cv_root.setLayoutParams(layoutParams);
                iv_icon.setImageResource(bean.getImgUrl());
                tv_buttonName.setText(bean.getBtnName());
            }
        }, new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                switch (position) {
                    case 0://标准化清单
                        startActivity(new Intent(getActivity(), RectificationListActivity.class));
//                        Log.e("排查记录", jurisdiction.contains("TROUBLE_MANHISTORY") + "");
//                        if (jurisdiction.contains("TROUBLE_MANHISTORY")) {
//                            startActivity(new Intent(getActivity(), SurveyRecordActivity.class));
//                        } else {
//                            ToastUtils.showShort("你没有权限");
//                        }
                        break;
                    case 1://问题清单
                        startActivity(new Intent(getActivity(), QuestionsListActivity.class));
                        break;
                    case 2://四员两长
                        startActivity(new Intent(getActivity(), SyliangzhangActivity.class));
                        break;
                    case 3://行为考核
                        startActivity(new Intent(getActivity(), AssessmentActivity.class));
                        break;
                    default:
                }
            }
        }, 4, null);

    }

    private void setUPMarqueeView(List<View> views, int size) {
        for (int i = 0; i < size; i++) {
            //设置滚动的单个布局
            LinearLayout moreView = (LinearLayout) LayoutInflater.from(getActivity()).inflate(R.layout.item_main_rolling_text, null);
            //初始化布局的控件
            TextView tv_topname = moreView.findViewById(R.id.tv_topname);
            TextView tv_leftname = moreView.findViewById(R.id.tv_leftname);
            TextView tv_number = moreView.findViewById(R.id.tv_number);

            //进行对控件赋值
            tv_topname.setText("协商函的步骤正在办理中,今年的任务必须完成,今年的任务必须完成,今年的任务必须完成,今年的任务必须完成,今年的任务必须完成,今年的任务必须完成,今年的任务必须完成!");
            tv_leftname.setText("协商函");
            tv_number.setText("" + (i + 1));

            //添加到循环滚动数组里面去
            views.add(moreView);
        }
    }

    @Override
    protected BaseRefreshLoadMoreInterface setRefreshLoadMoreListener() {
        return new BaseRefreshLoadMoreInterface() {
            @Override
            public void onLoadMore() {
                if (null != refreshLayout) {
                    refreshLayout.finishRefresh();
                    refreshLayout.finishLoadMore();
                }
            }

            @Override
            public void onRefresh() {
                refreshView();

            }
        };
    }

    //reshresh
    private void refreshView() {
        HashMap<String, String> params = new HashMap<>();
        params.put("page", "" + pageIndex);
        params.put("pageSize", "10");
        //params.put("appshow","1");
        params.put(BaseLinkList.apiurl, BaseLinkList.coal_mine + BaseLinkList.Noticelist);
        mRetrofit.JsonToColliery(BaseLinkList.Base_Url, params, new BaseSubscriber() {
            @Override
            public void onError(ExceptionHandle.ResponeThrowable e) {
                LogUtils.e(e.getMessage());
                if (null != refreshLayout) {
                    refreshLayout.finishRefresh();
                    refreshLayout.finishLoadMore();
                }
            }

            @Override
            public void onSuccess(JSONObject jsonObject) {
                LogUtils.e("首页列表->>" + jsonObject.toString());

                MainNewsBean mainNewsBean = FastJsonTools.getBean(jsonObject.toString(), MainNewsBean.class);
                ArrayList<MainNewsBean.DataBean.ListBean.ResultsBean> results = mainNewsBean.getData().getList().getResults();
                if (mainNewsBean != null) {
                    if (null != results) {
                        if (pageIndex > 1) {
                            BaseQuickAdapter mAdapter = (BaseQuickAdapter) rv_list.getAdapter();
                            ArrayList<MainNewsBean.DataBean.ListBean.ResultsBean> resList = (ArrayList<MainNewsBean.DataBean.ListBean.ResultsBean>) mAdapter.getData();
                            LogUtils.e("总数->>" + resList.size());
                            if (results.size() == 0) {
                                ToastUtils.showShort("没有更多数据了!");
                            } else {
                                resList.addAll(results);
                            }
                        } else {
                            RecyclerViewUtils.initLinerNoSc(getActivity(), rv_list, R.layout.item_main_news, results, new OnGlobalListener() {
                                @Override
                                public <T> void logic(BaseViewHolder helper, List<T> mData, T item, BaseQuickAdapter mAdapter) {
                                    MainNewsBean.DataBean.ListBean.ResultsBean resBean = (MainNewsBean.DataBean.ListBean.ResultsBean) item;
                                    TextView tv_name = helper.getView(R.id.tv_name);
                                    ImageView iv_journalism = helper.getView(R.id.iv_journalism);
                                    TextView tv_time = helper.getView(R.id.tv_time);
                                    if (!TextUtils.isEmpty(resBean.getApppicurl())) {
                                        Glide.with(getActivity()).load(BaseLinkList.Base_Url + "?" + BaseLinkList.apiurl + "=" + BaseLinkList.coal_mine + resBean.getApppicurl()).into(iv_journalism);
                                    } else {
                                        iv_journalism.setImageResource(R.drawable.shuanglong_pt);
                                    }
                                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                                    Date date = new Date();
                                    date.setTime(resBean.getCreateTime());
                                    String time = simpleDateFormat.format(date);


                                    String source_name = "" + resBean.getTitle();
                                    source_name = source_name.replace("&lt;", "<");
                                    source_name = source_name.replace("&gt;", ">");
                                    source_name = source_name.replace("&amp;", "&");
                                    source_name = source_name.replace("&quot;", "\"");
                                    source_name = source_name.replace("&nbsp;", " ");
                                    source_name = source_name.replace("&ldquo;", "\"");
                                    source_name = source_name.replace("&rdquo;", "\"");
                                    tv_name.setText(Html.fromHtml(source_name));

                                    String source = "" + resBean.getContent();
                                    source = source.replace("&lt;", "<");
                                    source = source.replace("&gt;", ">");
                                    source = source.replace("&amp;", "&");
                                    source = source.replace("&quot;", "\"");
                                    source = source.replace("&nbsp;", " ");
                                    source = source.replace("&ldquo;", "\"");
                                    source = source.replace("&rdquo;", "\"");
                                    LogUtils.e("转换后->>" + source);

                                    tv_time.setText("" + time);
                                }
                            }, new BaseQuickAdapter.OnItemClickListener() {
                                @Override
                                public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                                    MainNewsBean.DataBean.ListBean.ResultsBean resultsBean = (MainNewsBean.DataBean.ListBean.ResultsBean) adapter.getData().get(position);
                                    Intent intent = new Intent(getActivity(), NoticelistActivity.class);
                                    intent.putExtra("Noticedetail", "" + resultsBean.getId());
                                    startActivity(intent);
                                }
                            }, null);
                        }
                        if (null != refreshLayout) {
                            refreshLayout.finishRefresh();
                            refreshLayout.finishLoadMore();
                        }
                    } else {
                        ToastUtils.showShort("没数据!");
                    }
                }
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        //人员权限的判断
        Jurisdiction();
    }

    /**
     * 人员权限的判断
     */
    private void Jurisdiction() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(BaseLinkList.apiurl, BaseLinkList.coal_mine + BaseLinkList.getCurrEmployeeno);
        mRetrofit.JsonToColliery(BaseLinkList.Base_Url, hashMap, new BaseSubscriber() {
            @Override
            public void onError(ExceptionHandle.ResponeThrowable e) {

            }

            @Override
            public void onSuccess(JSONObject jsonObject) throws JSONException {
                LogUtils.e("人员的权限->>" + jsonObject.toString());
                WebViewBean webViewBean = FastJsonTools.getBean(jsonObject.toString(), WebViewBean.class);
                Log.e("是否重新登录", webViewBean.getData().getNoUser() + "");
                if (webViewBean.getData().getNoUser() != null) {
                    //不存在
                    if (webViewBean.getData().getNoUser().equals("0")) {
                        UserBeans.clearUserBean();
                        SharedPreferences cookie = getActivity().getSharedPreferences("cookie", Context.MODE_PRIVATE);
                        cookie.edit().clear().commit();
                        SharedPreferences token = getActivity().getSharedPreferences("userinfo", Context.MODE_PRIVATE);
                        token.edit().clear().commit();
                        Intent intent = new Intent(getActivity(), LoginActivity.class);
                        startActivity(intent);
                        getActivity().finish();
                    }
                }

                jurisdiction.clear();
                if (null != webViewBean) {
                    if (null != webViewBean.getData()) {
                        if (null != webViewBean.getData().getBuiltinrolelist()) {
                            for (String a : webViewBean.getData().getBuiltinrolelist()) {
                                jurisdiction.add(a);
                            }
                        }
                    }
                }
            }
        });
    }
}
