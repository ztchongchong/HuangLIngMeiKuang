package com.lingjun.colliery_android.utils;

import android.Manifest;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.FileProvider;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.lingjun.colliery_android.R;
import java.io.File;
import java.text.SimpleDateFormat;

/**
 * Created by shuttle on 2017/12/16.
 */

public class PhotoPopupManager {
    private volatile static PhotoPopupManager sInstance;
    private Activity mActivity;
    private PopupWindow mPopup;
    private static final String IMAGE_TYPE = "image/*";
    public static final int REQUEST_GALLERY = 0x666;
    public static final int REQUEST_CAMERA = 0x777;
    public static final int REQUEST_CLIP = 0x888;
    private Uri mCameraUri;
    private String photoPath;
    private OnPhotoSelectedListener mOnPhotoSelectedListener;

    private PhotoPopupManager() {
    }

    /**
     * Singleton
     *
     * @return
     */
    public static PhotoPopupManager getInstance() {
        if (sInstance == null) {
            synchronized (PhotoPopupManager.class) {
                if (sInstance == null) {
                    sInstance = new PhotoPopupManager();
                }
            }
        }
        return sInstance;
    }

    /**
     * 显示
     *
     * @param activity
     */
    public void show(Activity activity) {
        if (!checkActivityLeak(activity)) {
            return;
        }
        initPopup();
    }

    /**
     * 显示
     *
     * @param activity
     */
    public void showvideo(Activity activity) {
        if (!checkActivityLeak(activity)) {
            return;
        }
        initvideotape();
    }

    /**
     * 是否可见
     *
     * @return
     */
    public boolean isVisible() {
        if (mPopup != null) {
            return mPopup.isShowing();
        }
        return false;
    }

    /**
     * 隐藏
     */
    public void dismiss() {
        if (mPopup != null) {
            mPopup.dismiss();
        }
    }

    private void initPopup() {
        View rootView = LayoutInflater.from(mActivity).inflate(R.layout.pop_photo, null);
        mPopup = new PopupWindow(rootView, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        mPopup.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        mPopup.setOutsideTouchable(true);
        mPopup.setAnimationStyle(R.style.MyPopupWindow_anim_style);
        mPopup.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                setBackgroudAlpha(1.0f);
            }
        });
        TextView tvGallery = rootView.findViewById(R.id.tv_gallery);
        TextView tvCamera = rootView.findViewById(R.id.tv_camera);
        TextView tvCancel = rootView.findViewById(R.id.tv_cancel);
        mPopup.showAtLocation(tvCancel, Gravity.BOTTOM, 0, 0);
        setBackgroudAlpha(0.4f);
        RelativeLayout rlRoot = rootView.findViewById(R.id.rl_root);
        rlRoot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mPopup != null && mPopup.isShowing()) {
                    mPopup.dismiss();
                }
            }
        });

        // camera
        tvCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mPopup != null && mPopup.isShowing()) {
                    mPopup.dismiss();
                }
                //拍照权限

                gotoCamera();
            }
        });
        // gallery
        tvGallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mPopup != null && mPopup.isShowing()) {
                    mPopup.dismiss();
                }
                gotoGallery();
            }
        });
        // 取消
        tvCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mPopup != null && mPopup.isShowing()) {
                    mPopup.dismiss();
                }
            }
        });
    }

    private void initvideotape() {
        View rootView = LayoutInflater.from(mActivity).inflate(R.layout.pop_video, null);
        mPopup = new PopupWindow(rootView, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        mPopup.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        mPopup.setOutsideTouchable(true);
        mPopup.setAnimationStyle(R.style.MyPopupWindow_anim_style);
        mPopup.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                setBackgroudAlpha(1.0f);
            }
        });
        TextView tvGallery = rootView.findViewById(R.id.tv_gallery);
        TextView tvCamera = rootView.findViewById(R.id.tv_camera);
        TextView tvCancel = rootView.findViewById(R.id.tv_cancel);
//        TextView tvVideo = rootView.findViewById(R.id.tv_video);
        mPopup.showAtLocation(tvCancel, Gravity.BOTTOM, 0, 0);
        setBackgroudAlpha(0.4f);
        RelativeLayout rlRoot = rootView.findViewById(R.id.rl_root);
        rlRoot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mPopup != null && mPopup.isShowing()) {
                    mPopup.dismiss();
                }
            }
        });

//        // video
//        tvVideo.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (mPopup != null && mPopup.isShowing()) {
//                    mPopup.dismiss();
//                }
//                //拍照权限
////                gotoCamera();
//                ToastUtils.showShort("上传视频");
//            }
//        });

        // camera
        tvCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mPopup != null && mPopup.isShowing()) {
                    mPopup.dismiss();
                }
                //拍照权限

                gotoCamera();
            }
        });
        // gallery
        tvGallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mPopup != null && mPopup.isShowing()) {
                    mPopup.dismiss();
                }
                gotoGallery();
            }
        });
        // 取消
        tvCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mPopup != null && mPopup.isShowing()) {
                    mPopup.dismiss();
                }
            }
        });
    }

    /**
     * 前往相册
     */
    private void gotoGallery() {
        if (ContextCompat.checkSelfPermission(mActivity, Manifest.permission.READ_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(mActivity, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 0x32);
        } else {
            Intent intent = new Intent();
            intent.setType(IMAGE_TYPE);
            intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            intent.setAction(Intent.ACTION_PICK);
            mActivity.startActivityForResult(intent, REQUEST_GALLERY);
        }
    }

    /**
     * 前往相机
     */
    @SuppressLint("SimpleDateFormat")
    private void gotoCamera() {
        AndPermissionUtils.requestPermission(mActivity, 0x31, Manifest.permission.CAMERA, new AndPermissionUtils.RequestPermissionCall() {
            @Override
            public void isSucceed() {
                AndPermissionUtils.requestPermission(mActivity, 0x31, Manifest.permission.WRITE_EXTERNAL_STORAGE, new AndPermissionUtils.RequestPermissionCall() {
                    @Override
                    public void isSucceed() {
                        LogUtils.e("拥有权限");
                        Intent intent = null;
                        //file
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
                        File file = PhotoUtils.getCacheFilePath(mActivity, sdf.format(System.currentTimeMillis()));
                        photoPath = file.getAbsolutePath();

                        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.N) {
                            intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                            intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(file));
                            mActivity.startActivityForResult(intent, REQUEST_CAMERA);
                        } else {
                            try {
                                intent = new Intent();
                                mCameraUri  = FileProvider.getUriForFile(mActivity, "com.lingjun.colliery_android.fileprovider", file);

                                //对目标应用临时授权该URI所代表的文件
                                intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                                //设置Action为拍照
                                intent.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
                                intent.putExtra(MediaStore.EXTRA_OUTPUT, mCameraUri);
                                mActivity.startActivityForResult(intent, REQUEST_CAMERA);
                                LogUtils.e("已跳转相机");
                            } catch (SecurityException e) {
                                e.printStackTrace();
                                AndPermissionUtils.requestPermission(mActivity,101, Manifest.permission.CAMERA,null);
                            }
                        }
                    }
                });
            }
        });

    }

    /**
     * 在宿主Activity回调，获取从相册或者相机传回来的值
     *
     * @param requestCode
     * @param resultCode
     * @param data
     */
    public void onActivityResulted(Activity activity, int requestCode, int resultCode, Intent data) {
        if (!checkActivityLeak(activity)) {
            mActivity = activity;
        }
        switch (requestCode) {
            case REQUEST_CAMERA:
                if (resultCode != Activity.RESULT_OK) {
                    photoPath = "";
                    LogUtils.e("照相机返回出错");
                }

                if (null != mOnPhotoSelectedListener){
                    mOnPhotoSelectedListener.onPhotoSelected(photoPath,REQUEST_CAMERA);
                    LogUtils.e("path--->" + photoPath);
                }else {
                    LogUtils.e("回调为null");
                }

                break;
            case REQUEST_GALLERY:
                if (resultCode == Activity.RESULT_OK) {
                    Uri uri = data.getData();
                    photoPath = PhotoUtils.getPath(mActivity, uri);
                } else {
                    photoPath = "";
                    LogUtils.e("相册返回出错");
                }

                if (null != mOnPhotoSelectedListener){
                    mOnPhotoSelectedListener.onPhotoSelected(photoPath,REQUEST_GALLERY);
                    LogUtils.e("path--->" + photoPath);
                }else {
                    LogUtils.e("回调为null");
                }

                break;
            case REQUEST_CLIP:
                //裁剪
                if (null != data){
                    if (null != data.getData()){
                        LogUtils.e("裁剪返回->>"+data.getData());
                        String cropImagePath = getRealFilePathFromUri(activity,data.getData());


                        if (null != mOnPhotoSelectedListener){
                            mOnPhotoSelectedListener.onPhotoSelected(cropImagePath,REQUEST_CLIP);
                            LogUtils.e("处理后的地址->>" + cropImagePath);
                        }else {
                            LogUtils.e("回调为null");
                        }

                    }
                }
                break;
            default:
                break;
        }
        LogUtils.e("走完了");
        // 全局变量可能导致数据一直存在
        photoPath = "";
    }


    private static String getRealFilePathFromUri(final Context context, final Uri uri) {
        if (null == uri) return null;
        final String scheme = uri.getScheme();
        String data = null;
        if (scheme == null)
            data = uri.getPath();
        else if (ContentResolver.SCHEME_FILE.equals(scheme)) {
            data = uri.getPath();
        } else if (ContentResolver.SCHEME_CONTENT.equals(scheme)) {
            Cursor cursor = context.getContentResolver().query(uri, new String[]{MediaStore.Images.ImageColumns.DATA}, null, null, null);
            if (null != cursor) {
                if (cursor.moveToFirst()) {
                    int index = cursor.getColumnIndex(MediaStore.Images.ImageColumns.DATA);
                    if (index > -1) {
                        data = cursor.getString(index);
                    }
                }
                cursor.close();
            }
        }
        return data;
    }


    /**
     * 半透明背景
     *
     * @param alpha
     */
    private void setBackgroudAlpha(float alpha) {
        Window window = mActivity.getWindow();
        WindowManager.LayoutParams lp = window.getAttributes();
        lp.alpha = alpha;
        window.addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
        window.setAttributes(lp);
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    private boolean checkActivityLeak(Activity activity) {
        if (activity != null) {
            if (activity.isFinishing() || activity.isDestroyed()) {
                return false;
            }
        } else {
            return false;
        }
        mActivity = activity;
        return true;
    }

    public interface OnPhotoSelectedListener {
        void onPhotoSelected(String photoPath, int callBack_location);
    }

    public void setOnPhotoSelectedListener(OnPhotoSelectedListener listener) {
        if (listener != null) {
            mOnPhotoSelectedListener = listener;
        }
    }
}
