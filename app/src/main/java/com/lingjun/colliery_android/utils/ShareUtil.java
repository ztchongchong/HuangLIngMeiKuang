package com.lingjun.colliery_android.utils;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Log;

import com.blankj.utilcode.util.LogUtils;
import com.lingjun.colliery_android.R;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.media.UMWeb;

/**
 * Created by nefa on 2018/9/11.
 */

public class ShareUtil {
    /**
     * 分享链接
     */
    public static void shareWeb(final Activity activity, String WebUrl, String title, String description, String imageUrl, int imageID){
        UMWeb web = new UMWeb(WebUrl);//连接地址
        web.setTitle(title);//标题
        web.setDescription(description);//描述
        if (TextUtils.isEmpty(imageUrl)) {
            web.setThumb(new UMImage(activity, imageID));  //本地缩略图
        } else {
            web.setThumb(new UMImage(activity, imageUrl));  //网络缩略图
        }
        new ShareAction(activity)
                .setDisplayList(SHARE_MEDIA.QQ,SHARE_MEDIA.WEIXIN,SHARE_MEDIA.WEIXIN_CIRCLE)
                .withMedia(web)
                .setCallback(new UMShareListener() {
                    @Override
                    public void onStart(SHARE_MEDIA share_media) {

                    }

                    @Override
                    public void onResult(final SHARE_MEDIA share_media) {
                        activity.runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                if (share_media.name().equals("WEIXIN_FAVORITE")) {
                                    //Toast.makeText(activity, share_media + " 收藏成功", Toast.LENGTH_SHORT).show();
                                } else {
                                    //Toast.makeText(activity, share_media + " 分享成功", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                    }

                    @Override
                    public void onError(final SHARE_MEDIA share_media, final Throwable throwable) {
                        if (throwable != null) {
                            Log.d("throw", "throw:" + throwable.getMessage());
                        }
                        activity.runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                //Toast.makeText(activity, share_media + " 分享失败", Toast.LENGTH_SHORT).show();

                            }
                        });
                    }

                    @Override
                    public void onCancel(final SHARE_MEDIA share_media) {
                        activity.runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                //Toast.makeText(activity, share_media + " 分享取消", Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                }).open();

        //open()是打开面板,和.setDisplayList(SHARE_MEDIA.SINA,SHARE_MEDIA.QQ,SHARE_MEDIA.WEIXIN)一起使用
        //.share();如果是调用share方法的时候不会使用面板,,,setPlatform()一起使用

        //新浪微博中图文+链接
        /*new ShareAction(activity)
                .setPlatform(platform)
                .withText(description + " " + WebUrl)
                .withMedia(new UMImage(activity,imageID))
                .share();*/
    }


    /**
     * 分享图片
     */
    public static void shareBitMapOrUserInfo(Activity activity,String text){
        /*Bitmap bitmapBG = ImageUtil.takeScreenShot(activity);
        Bitmap bitmapQRCode = BitmapFactory.decodeResource(activity.getResources(), R.drawable.qrcode_saige);
        Bitmap waterMaskCenter = ImageUtil.createWaterMaskCenter(bitmapBG, bitmapQRCode);
        //Bitmap waterMaskCenter = ImageUtil.createWaterMaskLeftBottom(activity,bitmapBG,bitmapQRCode,25,35);
        //暂不加文字
        //Bitmap bitmap = ImageUtil.drawTextToLeftBottom(activity, waterMaskCenter, text, 14, R.color.black,15,15);
        UMImage image = new UMImage(activity,waterMaskCenter);
        image.setThumb(new UMImage(activity,waterMaskCenter));
        new ShareAction(activity)
                .withText("赛格助手")
                .withMedia(image).setDisplayList(SHARE_MEDIA.QQ,SHARE_MEDIA.WEIXIN_CIRCLE,SHARE_MEDIA.WEIXIN)
                .setCallback(new UMShareListener() {
                    @Override
                    public void onStart(SHARE_MEDIA share_media) {
                    }

                    @Override
                    public void onResult(SHARE_MEDIA share_media) {
                    }

                    @Override
                    public void onError(SHARE_MEDIA share_media, Throwable throwable) {
                        ToastUtils.showShort(throwable.getMessage());
                    }

                    @Override
                    public void onCancel(SHARE_MEDIA share_media) {
                    }
                }).open();*/

        UMWeb web = new UMWeb("http://www.weilikj.cn/Share/Prompt.html");//连接地址
        web.setTitle("煤矿");//标题
        web.setDescription("安全生产化标准");//描述
        //web.setThumb(new UMImage(activity, R.drawable.ic_launcher));  //本地缩略图

        new ShareAction(activity)
                .setDisplayList(SHARE_MEDIA.QQ,SHARE_MEDIA.WEIXIN,SHARE_MEDIA.WEIXIN_CIRCLE)
                .withMedia(web)
                .setCallback(new UMShareListener() {
                    @Override
                    public void onStart(SHARE_MEDIA share_media) {

                    }

                    @Override
                    public void onResult(final SHARE_MEDIA share_media) {

                    }

                    @Override
                    public void onError(final SHARE_MEDIA share_media, final Throwable throwable) {
                        LogUtils.e("分享错误->>"+throwable.getMessage());
                    }

                    @Override
                    public void onCancel(final SHARE_MEDIA share_media) {

                    }
                }).open();
    }
}
