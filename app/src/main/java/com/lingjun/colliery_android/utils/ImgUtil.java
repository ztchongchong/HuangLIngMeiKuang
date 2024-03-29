package com.lingjun.colliery_android.utils;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
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
import com.lingjun.colliery_android.R;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by nefa on 2018/9/15.
 */

public class ImgUtil {

    public static final int TAKE_PHOTO = 1;//拍照
    public static final int CHOOSE_PHOTO = 2;//选择相册
    public static final int REQUEST_CODE_CAMERA = 3;//相机权限请求
    public static final int REQUEST_CODE_ALBUM = 4;//相册权限请求
    public static Uri imageUri;//相机拍照图片保存地址

    /**
     * 选择图片，从图库、相机
     *
     * @param activity 上下文
     */
    public static void choicePhoto(final Activity activity) {

        View rootView = LayoutInflater.from(activity).inflate(R.layout.pop_photo, null);
        final PopupWindow mPopup = new PopupWindow(rootView, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        mPopup.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        mPopup.setOutsideTouchable(true);
        mPopup.setAnimationStyle(R.style.MyPopupWindow_anim_style);
        mPopup.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                setBackgroudAlpha(1.0f,activity);
            }
        });
        TextView tvGallery = rootView.findViewById(R.id.tv_gallery);
        TextView tvCamera = rootView.findViewById(R.id.tv_camera);
        TextView tvCancel = rootView.findViewById(R.id.tv_cancel);
        mPopup.showAtLocation(tvCancel, Gravity.BOTTOM, 0, 0);
        setBackgroudAlpha(0.4f,activity);
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
                if (Build.VERSION.SDK_INT >= 23) {//检查相机权限
                    ArrayList<String> permissions = new ArrayList<>();
                    if (activity.checkSelfPermission(Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                        permissions.add(Manifest.permission.CAMERA);
                    }

                    if (permissions.size() == 0) {//有权限,跳转
                        //打开相机-兼容7.0
                        openCamera(activity);
                    } else {
                        activity.requestPermissions(permissions.toArray(new String[permissions.size()]), REQUEST_CODE_CAMERA);
                    }
                } else {
                    //打开相机-兼容7.0
                    openCamera(activity);
                }
            }
        });
        // gallery
        tvGallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mPopup != null && mPopup.isShowing()) {
                    mPopup.dismiss();
                }

                if (ContextCompat.checkSelfPermission(activity, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(activity, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, REQUEST_CODE_ALBUM);
                } else {
                    openAlbum(activity);
                }
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


       /* //采用的是系统Dialog作为选择弹框
        new AlertDialog.Builder(activity).setTitle("上传头像")//设置对话框标题
                .setPositiveButton("拍照", new DialogInterface.OnClickListener() {//添加确定按钮
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (Build.VERSION.SDK_INT >= 23) {//检查相机权限
                            ArrayList<String> permissions = new ArrayList<>();
                            if (activity.checkSelfPermission(Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                                permissions.add(Manifest.permission.CAMERA);
                            }

                            if (permissions.size() == 0) {//有权限,跳转
                                //打开相机-兼容7.0
                                openCamera(activity);
                            } else {
                                activity.requestPermissions(permissions.toArray(new String[permissions.size()]), REQUEST_CODE_CAMERA);
                            }
                        } else {
                            //打开相机-兼容7.0
                            openCamera(activity);
                        }
                    }
                }).setNegativeButton("系统相册", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //如果有权限申请，请在Activity中onRequestPermissionsResult权限返回里面重新调用openAlbum()
                if (ContextCompat.checkSelfPermission(activity, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(activity, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, REQUEST_CODE_ALBUM);
                } else {
                    openAlbum(activity);
                }
            }
        }).show();//在按键响应事件中显示此对话框*/
    }

    /**
     * 半透明背景
     *
     * @param alpha
     */
    private static void setBackgroudAlpha(float alpha, Activity activity) {
        Window window = activity.getWindow();
        WindowManager.LayoutParams lp = window.getAttributes();
        lp.alpha = alpha;
        window.addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
        window.setAttributes(lp);
    }

    /**
     * 打开相机
     * 兼容7.0
     *
     * @param activity
     */
    public static void openCamera(final Activity activity) {
        // 创建File对象，用于存储拍照后的图片
        AndPermissionUtils.requestPermission(activity, 0x31, Manifest.permission.CAMERA, new AndPermissionUtils.RequestPermissionCall() {
            @Override
            public void isSucceed() {
                AndPermissionUtils.requestPermission(activity, 0x31, Manifest.permission.WRITE_EXTERNAL_STORAGE, new AndPermissionUtils.RequestPermissionCall() {
                    @Override
                    public void isSucceed() {
                        LogUtils.e("拥有权限");
                        File outputImage = new File(activity.getExternalCacheDir(), "output_image.jpg");
                        try {
                            if (outputImage.exists()) {
                                outputImage.delete();
                            }
                            outputImage.createNewFile();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        if (Build.VERSION.SDK_INT < 24) {
                            imageUri = Uri.fromFile(outputImage);
                        } else {
                            //Android 7.0系统开始 使用本地真实的Uri路径不安全,使用FileProvider封装共享Uri
                            //参数二:fileprovider绝对路径 com.dyb.testcamerademo：项目包名
                            imageUri = FileProvider.getUriForFile(activity, "com.weili.xinge.fileprovider", outputImage);
                        }
                        // 启动相机程序
                        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
                        intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
                        activity.startActivityForResult(intent, TAKE_PHOTO);
                    }
                });
            }
        });

    }

    public static void openAlbum(Activity activity) {
        //调用系统图库的意图
        Intent choosePicIntent = new Intent(Intent.ACTION_PICK, null);
        choosePicIntent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
        activity.startActivityForResult(choosePicIntent, CHOOSE_PHOTO);

        //打开系统默认的软件
        //Intent intent = new Intent("android.intent.action.GET_CONTENT");
        //intent.setType("image/*");
        //activity.startActivityForResult(intent, CHOOSE_PHOTO); // 打开相册
    }



    /**
     * 得到byte[]
     * 这里对传入的图片Uri压缩到1M以内，并转换为byte[]后返回
     *
     * @param activity 上下文
     * @param uri      传入图片的Uri
     * @return byte[]
     */
    public static byte[] getImgByteFromUri(Activity activity, Uri uri) throws IOException {
        Bitmap bitmap = MediaStore.Images.Media.getBitmap(activity.getContentResolver(), uri);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, out);//100表示不压缩，直接放到out里面
        int options = 90;//压缩比例
        while (out.toByteArray().length / 1024 > 200) { // 循环判断如果压缩后图片是否大于100kb,大于继续压缩
            out.reset(); // 重置baos即清空baos
            bitmap.compress(Bitmap.CompressFormat.JPEG, options, out);// 这里压缩options%，把压缩后的数据存放到baos中
            options -= 10;// 每次都减少10
        }
        byte[] bs = out.toByteArray();

        return bs;
    }
}
