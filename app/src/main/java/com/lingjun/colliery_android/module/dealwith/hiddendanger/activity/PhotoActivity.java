package com.lingjun.colliery_android.module.dealwith.hiddendanger.activity;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.lingjun.colliery_android.R;
import com.lingjun.colliery_android.base.BaseActivity;
import com.lingjun.colliery_android.base.BaseLinkList;

import butterknife.BindView;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * 作者: zengtao
 * 时间: 2018/12/18  17:24.
 * 注释: 照片放大界面
 */
public class PhotoActivity extends BaseActivity {
    @BindView(R.id.iv_user_photo)
    ImageView ivUserPhoto;

    private String photo;

    @Override
    protected int getResourcesId() {
        return R.layout.activity_photo;
    }

    @Override
    protected void init(Bundle savedInstanceState) throws PackageManager.NameNotFoundException {
        photo = getIntent().getStringExtra("photo");
        RequestOptions options = new RequestOptions()
                .override(100, 100)
                .error(R.drawable.icon_biaozhunhua); // 加载失败的图片  
        Glide.with(this).load(BaseLinkList.coal_mine + photo).apply(options).into(ivUserPhoto);
//        Glide.with(this).load("http://192.168.1.223:8080/safety/upload/1545055694010.jpg").into(ivUserPhoto);
    }

    @Override
    protected BaseRefreshLoadMoreInterface setRefreshLoadMoreListener() {
        return null;
    }
}
