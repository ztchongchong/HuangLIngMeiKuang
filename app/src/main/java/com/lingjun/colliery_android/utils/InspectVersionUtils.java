package com.lingjun.colliery_android.utils;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.support.v4.content.FileProvider;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.blankj.utilcode.util.LogUtils;
import com.google.gson.JsonObject;
import com.lingjun.colliery_android.R;
import com.lingjun.colliery_android.base.BaseLinkList;
import com.lingjun.colliery_android.bean.UpgradeAppBean;
import com.lingjun.colliery_android.module.main.MainActivity;
import com.lingjun.colliery_android.utils.retrofit.BaseSubscriber;
import com.lingjun.colliery_android.utils.retrofit.ExceptionHandle;
import com.lingjun.colliery_android.utils.retrofit.RetrofitUtils;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 作者: zengtao
 * 时间: 2018/12/10  16:35.
 * 注释: 版本升级
 */
public class InspectVersionUtils {
    private static final String TAG = InspectVersionUtils.class.getSimpleName();
    public static long downloadUpdateApkId = -1;//下载更新Apk 下载任务对应的Id
    public static String downloadUpdateApkFilePath;//下载更新Apk 文件路径


    //任务定时器
    private Timer mTimer;
    //定时任务
    private TimerTask mTask;
    //文件总大小
    private int fileLength = 1;
    //下载的文件大小
    private int fileCurrentLength;

    private Context context;
    private String httpUrl;
    private String savePath;
    private String saveName;
    private DownloadCallBack downloadCallBack;
    private static File saveFile;

    private boolean isComplete = false;


    public interface DownloadCallBack {
        void onStart();

        void onComplete(String path);

        void onLoading(long total, long current);

        void onFail(Exception e);
    }

    public interface InstallCallBack {

        void onSuccess();

        void onFail(Exception e);
    }

    public InspectVersionUtils(Context context, String httpUrl, String saveName, DownloadCallBack downloadCallBack) {
        this.context = context;
        this.httpUrl = httpUrl;
        this.saveName = saveName;
        this.downloadCallBack = downloadCallBack;
        this.savePath = getCachePath(this.context);
    }


    public void downloadAPK() {
        if (TextUtils.isEmpty(httpUrl)) {
            return;
        }
        saveFile = new File(savePath);
        if (!saveFile.exists()) {
            boolean isMK = saveFile.mkdirs();
            if (!isMK) {
                //创建失败
                return;
            }
        }

        saveFile = new File(savePath + File.separator + saveName + ".apk");

        if (downloadCallBack != null) {
            //下载开始
            downloadCallBack.onStart();
        }

        new Thread(new Runnable() {
            @Override
            public void run() {
                InputStream inputStream = null;
                FileOutputStream outputStream = null;
                HttpURLConnection connection = null;
                try {
                    URL url = new URL(httpUrl);
                    connection = (HttpURLConnection) url.openConnection();
                    connection.setConnectTimeout(10 * 1000);
                    connection.setReadTimeout(10 * 1000);
                    connection.connect();
                    inputStream = connection.getInputStream();
                    outputStream = new FileOutputStream(saveFile);
                    fileLength = connection.getContentLength();

                    //判断fileLength大小
                    if (fileLength <= 0) {
                        //失败的地址
                        ((Activity) context).runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                if (downloadCallBack != null) {
                                    downloadCallBack.onFail(new Exception("下载地址异常"));
                                    downloadCallBack = null;
                                }
                            }
                        });
                        return;
                    }

                    //计时器
                    initTimer();

                    byte[] buffer = new byte[1024];
                    int current = 0;
                    int len;
                    while ((len = inputStream.read(buffer)) > 0) {
                        outputStream.write(buffer, 0, len);
                        current += len;
                        if (fileLength > 0) {
                            fileCurrentLength = current;
                        }
                    }
                    isComplete = true;
                    //下载完成
                    ((Activity) context).runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            //解决某些低版本安装失败的问题
                            changeApkFileMode(saveFile);

                            if (downloadCallBack != null) {
                                downloadCallBack.onComplete(saveFile.getPath());
                                downloadCallBack = null;
                            }
                        }
                    });
                } catch (final Exception e) {
                    e.printStackTrace();
                    ((Activity) context).runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            if (downloadCallBack != null) {
                                downloadCallBack.onFail(e);
                                downloadCallBack = null;
                            }
                        }
                    });
                } finally {
                    try {
                        if (inputStream != null)
                            inputStream.close();
                        if (outputStream != null)
                            outputStream.close();
                        if (connection != null)
                            connection.disconnect();
                    } catch (IOException e) {
                    }
                    //销毁Timer
                    destroyTimer();
                }
            }
        }).start();

    }

    private void initTimer() {
        mTimer = new Timer();
        mTask = new TimerTask() {//在run方法中执行定时的任务
            @Override
            public void run() {
                ((Activity) context).runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (downloadCallBack != null) {
                            if (!isComplete) {
                                downloadCallBack.onLoading(fileLength, fileCurrentLength);
                            }
                        }
                    }
                });
            }
        };
        //任务定时器一定要启动
        mTimer.schedule(mTask, 0, 200);
    }


    private void destroyTimer() {
        if (mTimer != null && mTask != null) {
            mTask.cancel();
            mTimer.cancel();
            mTask = null;
            mTimer = null;
        }
    }

    /**
     * 安装APK工具类
     *
     * @param context  上下文
     * @param filePath 文件路径
     * @param callBack 安装界面成功调起的回调
     */
    public static void installAPK(Context context, String filePath, InstallCallBack callBack) {
        try {
            Intent intent = new Intent();
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.setAction(Intent.ACTION_VIEW);
            File apkFile = new File(filePath);
            Uri apkUri;
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                String authority = context.getPackageName() + ".updateFileProvider";
                apkUri = FileProvider.getUriForFile(context, authority, apkFile);
                // 授予目录临时共享权限
                intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            } else {
                apkUri = Uri.fromFile(apkFile);
            }
            intent.setDataAndType(apkUri, "application/vnd.android.package-archive");
            context.startActivity(intent);
            if (callBack != null) {
                callBack.onSuccess();
            }
            //关闭当前
            android.os.Process.killProcess(android.os.Process.myPid());
        } catch (Exception e) {
            if (callBack != null) {
                callBack.onFail(e);
            }
        }
    }

    /**
     * 通过浏览器下载APK更新安装
     *
     * @param context    上下文
     * @param httpUrlApk APK下载地址
     */
    public static void installAPKWithBrower(Context context, String httpUrlApk) {
        Uri uri = Uri.parse(httpUrlApk);
        Intent viewIntent = new Intent(Intent.ACTION_VIEW, uri);
        context.startActivity(viewIntent);
    }


    /**
     * 获取app缓存路径    SDCard/Android/data/你的应用的包名/cache
     *
     * @param context
     * @return
     */
    public String getCachePath(Context context) {
        String cachePath;
        if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())
                || !Environment.isExternalStorageRemovable()) {
            //外部存储可用
            cachePath = context.getExternalCacheDir().getPath();
        } else {
            //外部存储不可用
            cachePath = context.getCacheDir().getPath();
        }
        return cachePath;
    }

    //参照：APK放到data/data/下面提示解析失败 (http://blog.csdn.net/lonely_fireworks/article/details/27693073)
    private void changeApkFileMode(File file) {
        try {
            //apk放在缓存目录时，低版本安装提示权限错误，需要对父级目录和apk文件添加权限
            String cmd1 = "chmod 777 " + file.getParent();
            Runtime.getRuntime().exec(cmd1);

            String cmd = "chmod 777 " + file.getAbsolutePath();
            Runtime.getRuntime().exec(cmd);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取版本号
     *
     * @param context
     * @return
     * @throws PackageManager.NameNotFoundException
     */
    public static int getVersionName(Context context) throws PackageManager.NameNotFoundException {
        // 获取packagemanager的实例
        PackageManager packageManager = context.getPackageManager();
        // getPackageName()是你当前类的包名，0代表是获取版本信息
        PackageInfo packInfo = packageManager.getPackageInfo(context.getPackageName(), 0);
        int version = packInfo.versionCode;
        return version;
    }


    /**
     * Dialog 弹窗提示
     */
    public static void showDialog(final Context context) {

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        View dialogview = View.inflate(context, R.layout.upgrade_dialog, null);
        builder.setView(dialogview);
        builder.setCancelable(true);
        TextView update_conten = dialogview.findViewById(R.id.tv_update_content);//更新内容
        update_conten.setText("更新你妹个烂扳手");
        TextView tv_cancel = dialogview.findViewById(R.id.tv_cancel);//取消
        final AlertDialog dialog = builder.create();
        tv_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();//取消
            }
        });
        TextView tv_install = dialogview.findViewById(R.id.tv_install);//安装
        tv_install.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                downloadNewVersionFromServer(context,"https://www.pgyer.com/mbpd");//下载
                ToastUtils.showToast(context, "安装");
                dialog.dismiss();
            }
        });
        dialog.setCanceledOnTouchOutside(false);//点击空白不消失
        dialog.show();
    }

    //下载
    public static void downloadNewVersionFromServer(Context context, String httpUrlApk) {
        /**
         * 通过浏览器下载APK包
         * @param context
         * @param url
         */
        Uri uri = Uri.parse(httpUrlApk);
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//        intent.setDataAndType(Uri.fromFile(new File(Environment
//                        .getExternalStorageDirectory(), "coalUrl")),
//                "https://www.pgyer.com/mbpd");
        context.startActivity(intent);
    }

    /**
     * 下载更新apk包
     * 权限:1,<uses-permission android:name="android.permission.DOWNLOAD_WITHOUT_NOTIFICATION" />
     * @param context
     * @param url
     */
    public static void downloadForAutoInstall(Context context, String url, String fileName, String title) {
        //LogUtil.e("App 下载 url="+url+",fileName="+fileName+",title="+title);
        if (TextUtils.isEmpty(url)) {
            return;
        }
        try {
            Uri uri = Uri.parse(url);
            DownloadManager downloadManager = (DownloadManager) context
                    .getSystemService(Context.DOWNLOAD_SERVICE);
            DownloadManager.Request request = new DownloadManager.Request(uri);
            //在通知栏中显示
            request.setVisibleInDownloadsUi(true);
            request.setTitle(title);
            String filePath = null;
            if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {//外部存储卡
                filePath = Environment.getExternalStorageDirectory().getAbsolutePath();

            } else {

                return;
            }
            downloadUpdateApkFilePath = filePath + File.separator + fileName;
            // 若存在，则删除
            deleteFile(downloadUpdateApkFilePath);
            Uri fileUri = Uri.parse("file://" + downloadUpdateApkFilePath);
            request.setDestinationUri(fileUri);
            downloadUpdateApkId = downloadManager.enqueue(request);
        } catch (Exception e) {
            e.printStackTrace();
            downloadNewVersionFromServer(context, url);
        }
    }


    private static boolean deleteFile(String fileStr) {
        File file = new File(fileStr);
        return file.delete();
    }



}