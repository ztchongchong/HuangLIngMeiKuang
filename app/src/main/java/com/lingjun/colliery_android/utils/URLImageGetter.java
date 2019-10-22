package com.lingjun.colliery_android.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.Html;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;

/**
 * Created by nefa on 2018/9/3.
 * textview 显示html图片
 */

public class URLImageGetter implements Html.ImageGetter {

    Context c;
    TextView tv_image;

    public URLImageGetter(TextView t, Context c) {
        this.tv_image = t;
        this.c = c;
    }

    @Override
    public Drawable getDrawable(final String source) {
        final URLDrawable urlDrawable = new URLDrawable();
        Glide.with(c).asBitmap().load(source).into(new SimpleTarget<Bitmap>() {
            @Override
            public void onResourceReady(@NonNull Bitmap resource, @Nullable Transition<? super Bitmap> transition) {
                urlDrawable.bitmap = resource;
                urlDrawable.setBounds(0, 0, resource.getWidth(), resource.getHeight());
                tv_image.invalidate();
                tv_image.setText(tv_image.getText());
            }
        });

        return urlDrawable;
    }
}
