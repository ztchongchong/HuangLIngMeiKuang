package com.lingjun.colliery_android.base;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import com.lingjun.colliery_android.R;
import com.lingjun.colliery_android.view.ClipViewLayout;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;


public class BaseClipImageActivity extends BaseActivity implements View.OnClickListener{
    private static final String TAG = "ClipImageActivity";
    private ClipViewLayout clipViewLayout1;
    private TextView btnCancel;
    private TextView btnOk;

    @Override
    protected BaseRefreshLoadMoreInterface setRefreshLoadMoreListener() {
        return null;
    }


    @Override
    protected int getResourcesId() {
        return R.layout.activity_clip_image;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        initData();
    }

    private void initData() {
        clipViewLayout1 = findViewById(R.id.clipViewLayout1);
        btnCancel = findViewById(R.id.btn_cancel);
        btnOk = findViewById(R.id.bt_ok);

        btnCancel.setOnClickListener(this);
        btnOk.setOnClickListener(this);
    }
    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "image uri: "+getIntent().getData());
            clipViewLayout1.setVisibility(View.VISIBLE);
            //设置图片资源
            clipViewLayout1.setImageSrc(getIntent().getData());
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_cancel:
                finish();
                break;
            case R.id.bt_ok:
                generateUriAndReturn();
                break;
        }
    }
    /**
     * 生成Uri并且通过setResult返回给打开的activity
     */
    private void generateUriAndReturn() {
        //调用返回剪切图
        Bitmap zoomedCropBitmap;
            zoomedCropBitmap = clipViewLayout1.clip();
        if (zoomedCropBitmap == null) {
            Log.e("android", "zoomedCropBitmap == null");
            return;
        }
        Uri mSaveUri = Uri.fromFile(new File(getCacheDir(), "cropped_" + System.currentTimeMillis() + ".jpg"));
        if (mSaveUri != null) {
            OutputStream outputStream = null;
            try {
                outputStream = getContentResolver().openOutputStream(mSaveUri);
                if (outputStream != null) {
                    zoomedCropBitmap.compress(Bitmap.CompressFormat.JPEG, 90, outputStream);
                }
            } catch (IOException ex) {
                Log.e("android", "Cannot open file: " + mSaveUri, ex);
            } finally {
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            Intent intent = new Intent();
            intent.setData(mSaveUri);
            setResult(RESULT_OK, intent);
            finish();
        }
    }
}
