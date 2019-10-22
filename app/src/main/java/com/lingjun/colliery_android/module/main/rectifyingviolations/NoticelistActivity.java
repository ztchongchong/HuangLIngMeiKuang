package com.lingjun.colliery_android.module.main.rectifyingviolations;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.blankj.utilcode.util.LogUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lingjun.colliery_android.R;
import com.lingjun.colliery_android.base.BaseActivity;
import com.lingjun.colliery_android.base.BaseLinkList;
import com.lingjun.colliery_android.base.OnGlobalListener;
import com.lingjun.colliery_android.bean.HiddenDangersHandleBean;
import com.lingjun.colliery_android.bean.NoticedetailBean;
import com.lingjun.colliery_android.module.dealwith.hiddendanger.activity.HiddenDangersHandleActivity;
import com.lingjun.colliery_android.utils.FastJsonTools;
import com.lingjun.colliery_android.utils.RecyclerViewUtils;
import com.lingjun.colliery_android.utils.URLImageGetter;
import com.lingjun.colliery_android.utils.retrofit.BaseSubscriber;
import com.lingjun.colliery_android.utils.retrofit.ExceptionHandle;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * 首页公告通知详情
 */
public class NoticelistActivity extends BaseActivity {
    private TextView tv_title;//标题
    private TextView tv_author;//作者
    private TextView tv_time;//时间
    private TextView tv_content;//内容
    private String id;//ltem传的ID

    @Override
    protected int getResourcesId() {
        return R.layout.activity_noticelist;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        Intent getIntent = NoticelistActivity.this.getIntent();
        id = getIntent.getStringExtra("Noticedetail");

        tv_title = findViewById(R.id.tv_title);
        tv_author = findViewById(R.id.tv_author);
        tv_time = findViewById(R.id.tv_time);
        tv_content = findViewById(R.id.tv_content);
        //刷新
        Refreshview();

    }

    private void Refreshview() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("id", "" + id);
        hashMap.put(BaseLinkList.apiurl, BaseLinkList.coal_mine + BaseLinkList.Noticedetail);

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
                final NoticedetailBean noticedetailBean = FastJsonTools.getBean(jsonObject.toString(), NoticedetailBean.class);

                tv_author.setText(noticedetailBean.getData().getNotice().getAuthor());//作者
                SimpleDateFormat format = new SimpleDateFormat("MM/dd");
                Date d1 = new Date(noticedetailBean.getData().getNotice().getCreateTime());
                String t1 = format.format(d1);
                tv_time.setText(t1);//时间
                String source_title = "" + noticedetailBean.getData().getNotice().getTitle();
                source_title = source_title.replace("&lt;", "<");
                source_title = source_title.replace("&gt;", ">");
                source_title = source_title.replace("&amp;", "&");
                source_title = source_title.replace("&quot;", "\"");
                source_title = source_title.replace("&nbsp;", " ");
                source_title = source_title.replace("&ldquo;", "\"");
                source_title = source_title.replace("&rdquo;", "\"");
                tv_title.setText(Html.fromHtml(source_title));//标题栏
                String source = "" + noticedetailBean.getData().getNotice().getContent();//创建内容
                source = source.replace("&lt;", "<");
                source = source.replace("&gt;", ">");
                source = source.replace("&amp;", "&");
                source = source.replace("&quot;", "\"");
                source = source.replace("&nbsp;", " ");
                source = source.replace("&ldquo;", "\"");
                source = source.replace("&rdquo;", "\"");

                LogUtils.e("转换后->>" + source);
                tv_content.setText(Html.fromHtml(source, new URLImageGetter(tv_content, tv_content.getContext()), null));

                if (null != refreshLayout) {
                    refreshLayout.finishRefresh();
                    refreshLayout.finishLoadMore();
                }
            }
        });
    }

    @Override
    protected BaseRefreshLoadMoreInterface setRefreshLoadMoreListener() {
        return null;
    }
}
