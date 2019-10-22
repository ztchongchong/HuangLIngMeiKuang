package com.lingjun.colliery_android.utils.banner;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import com.lingjun.colliery_android.R;
import com.youth.banner.loader.ImageLoaderInterface;

public abstract class MyImageLoader implements ImageLoaderInterface<ImageView> {

    @Override
    public ImageView createImageView(Context context) {
        ImageView view = (ImageView) View.inflate(context, R.layout.item_banner, null);
        return view;
    }

}