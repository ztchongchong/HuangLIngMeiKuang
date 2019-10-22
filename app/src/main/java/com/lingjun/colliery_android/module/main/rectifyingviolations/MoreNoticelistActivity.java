package com.lingjun.colliery_android.module.main.rectifyingviolations;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lingjun.colliery_android.R;
import com.lingjun.colliery_android.base.BaseActivity;
import com.lingjun.colliery_android.base.BaseLinkList;
import com.lingjun.colliery_android.base.OnGlobalListener;
import com.lingjun.colliery_android.bean.HiddenDangerPlanBean;
import com.lingjun.colliery_android.bean.MainNewsBean;
import com.lingjun.colliery_android.module.dealwith.hiddendanger.general_hidden_danger.HiddenDangerPlanActivity;
import com.lingjun.colliery_android.utils.FastJsonTools;
import com.lingjun.colliery_android.utils.RecyclerViewUtils;
import com.lingjun.colliery_android.utils.retrofit.BaseSubscriber;
import com.lingjun.colliery_android.utils.retrofit.ExceptionHandle;

import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * 作者: zengtao
 * 时间: 2019/1/21  14:48.
 * 注释:更多公示通知
 */
public class MoreNoticelistActivity extends BaseActivity {
    private RecyclerView rv_list;

    @Override
    protected int getResourcesId() {
        return R.layout.activity_more_noticelist;
    }

    @Override
    protected void init(Bundle savedInstanceState) throws PackageManager.NameNotFoundException {
        rv_list = findViewById(R.id.rv_list);

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
        LogUtils.e("当前第" + pageIndex + "页");

        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("page", "" + pageIndex);
        hashMap.put("pageSize", "10");
        hashMap.put(BaseLinkList.apiurl, BaseLinkList.coal_mine + BaseLinkList.Noticelist);

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
                LogUtils.e("首页列表->>" + jsonObject.toString());

                MainNewsBean mainNewsBean = FastJsonTools.getBean(jsonObject.toString(), MainNewsBean.class);
                ArrayList<MainNewsBean.DataBean.ListBean.ResultsBean> results = mainNewsBean.getData().getList().getResults();
                if (null != results) {
                    if (pageIndex > 1) {
                        BaseQuickAdapter mAdapter = (BaseQuickAdapter) rv_list.getAdapter();
                        ArrayList<MainNewsBean.DataBean.ListBean.ResultsBean> resList = (ArrayList<MainNewsBean.DataBean.ListBean.ResultsBean>) mAdapter.getData();
                        LogUtils.e("总数->>" + resList.size());
                        if (results.size() == 0) {
                            ToastUtils.showShort("没有更多数据了!");
                        } else {
                            for (int i = 0; i < results.size(); i++) {
                                resList.add(results.get(i));
                                mAdapter.notifyItemChanged(resList.size() + (i + 1), results.get(i));
                            }
                        }
                    } else {
//                        rv_list.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));
                        RecyclerViewUtils.initLiner(MoreNoticelistActivity.this, rv_list, R.layout.item_main_news, results, new OnGlobalListener() {
                            @Override
                            public <T> void logic(BaseViewHolder helper, List<T> mData, T item, BaseQuickAdapter mAdapter) {
                                MainNewsBean.DataBean.ListBean.ResultsBean resBean = (MainNewsBean.DataBean.ListBean.ResultsBean) item;
                                TextView tv_name = helper.getView(R.id.tv_name);
                                ImageView iv_journalism = helper.getView(R.id.iv_journalism);
                                TextView tv_time = helper.getView(R.id.tv_time);
                                if (!TextUtils.isEmpty(resBean.getApppicurl())) {
                                    Glide.with(MoreNoticelistActivity.this).load(BaseLinkList.Base_Url + "?" + BaseLinkList.apiurl + "=" + BaseLinkList.coal_mine + resBean.getApppicurl()).into(iv_journalism);
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

                            /*// &nbsp;转成空格
                            content=content.replace(/(\s|&nbsp;)+/g,' ');
                            content=content.replace(/<\/?.+?>/g,"");
                            content=content.replace(/ /g,"");//dds为得到后的内容*/

                                LogUtils.e("转换后->>" + source);
//                                tv_content.setText(Html.fromHtml(source));
//                                tv_guankanrenshu.setText("" + resBean.getHits());
                                tv_time.setText("" + time);
                            }
                        }, new BaseQuickAdapter.OnItemClickListener() {
                            @Override
                            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                                MainNewsBean.DataBean.ListBean.ResultsBean resultsBean = (MainNewsBean.DataBean.ListBean.ResultsBean) adapter.getData().get(position);
                                Intent intent = new Intent(MoreNoticelistActivity.this, NoticelistActivity.class);
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
        });

    }

}
