package com.lingjun.colliery_android.utils;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;

/**
 * Created by nefa on 2018/9/3.
 */

public class URLDrawable extends BitmapDrawable {
    public Bitmap bitmap;


    @Override
    public void draw(Canvas canvas) {
        if (bitmap != null) {
            canvas.drawBitmap(bitmap, 0, 0, getPaint());
        }
    }
}
