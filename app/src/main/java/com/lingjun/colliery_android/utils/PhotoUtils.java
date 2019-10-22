package com.lingjun.colliery_android.utils;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.util.Base64;
import android.util.Log;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * <pre>
 *     author : lenovo
 *     e-mail : dang8080@qq.com
 *     time   : 2017/09/11
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public class PhotoUtils {
    private static final String TAG = "PhotoUtils";

    /**
     * @param activity    当前activity
     * @param imageUri    拍照后照片存储路径
     * @param requestCode 调用系统相机请求码
     */
    public static void takePicture(Activity activity, Uri imageUri, int requestCode) {
        //调用系统相机
        Intent intentCamera = new Intent();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            intentCamera.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION); //添加这一句表示对目标应用临时授权该Uri所代表的文件
        }
        intentCamera.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
        //将拍照结果保存至photo_file的Uri中，不保留在相册中
        intentCamera.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
        activity.startActivityForResult(intentCamera, requestCode);
    }

    //获取旋转的角度
    public static int readPictureDegree(String path) {
        int degree = 0;
        try {
            ExifInterface exifInterface = new ExifInterface(path);
            int orientation = exifInterface.getAttributeInt(ExifInterface.TAG_ORIENTATION, ExifInterface.ORIENTATION_NORMAL);
            switch (orientation) {
                case ExifInterface.ORIENTATION_ROTATE_90:
                    degree = 90;
                    break;
                case ExifInterface.ORIENTATION_ROTATE_180:
                    degree = 180;
                    break;
                case ExifInterface.ORIENTATION_ROTATE_270:
                    degree = 270;
                    break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return degree;
    }

    /**
     * @param activity    当前activity
     * @param requestCode 打开相册的请求码
     */
    public static void openPic(Activity activity, int requestCode) {
        Intent photoPickerIntent = new Intent(Intent.ACTION_GET_CONTENT);
        photoPickerIntent.setType("image/*");
        activity.startActivityForResult(photoPickerIntent, requestCode);
    }

    /**
     * @param activity    当前activity
     * @param orgUri      剪裁原图的Uri
     * @param desUri      剪裁后的图片的Uri
     * @param aspectX     X方向的比例
     * @param aspectY     Y方向的比例
     * @param width       剪裁图片的宽度
     * @param height      剪裁图片高度
     * @param requestCode 剪裁图片的请求码
     */
    public static void cropImageUri(Activity activity, Uri orgUri, Uri desUri, int aspectX, int aspectY, int width, int height, int requestCode) {
        Intent intent = new Intent("com.android.camera.action.CROP");
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        }
        intent.setDataAndType(orgUri, "image/*");
        intent.putExtra("crop", "true");
        intent.putExtra("aspectX", aspectX);
        intent.putExtra("aspectY", aspectY);
        intent.putExtra("outputX", width);
        intent.putExtra("outputY", height);
        intent.putExtra("scale", true);
        //将剪切的图片保存到目标Uri中
        intent.putExtra(MediaStore.EXTRA_OUTPUT, desUri);
        intent.putExtra("return-data", false);
        intent.putExtra("outputFormat", Bitmap.CompressFormat.JPEG.toString());
        intent.putExtra("noFaceDetection", true);
        activity.startActivityForResult(intent, requestCode);
    }

    /**
     * 读取uri所在的图片
     *
     * @param uri      图片对应的Uri
     * @param mContext 上下文对象
     * @return 获取图像的Bitmap
     */
    public static Bitmap getBitmapFromUri(Uri uri, Context mContext) {
        try {
            Bitmap bitmap = MediaStore.Images.Media.getBitmap(mContext.getContentResolver(), uri);
            return bitmap;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * @param context 上下文对象
     * @param uri     当前相册照片的Uri
     * @return 解析后的Uri对应的String
     */
    @SuppressLint("NewApi")
    public static String getPath(final Context context, final Uri uri) {

        final boolean isKitKat = Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT;
        String pathHead = "file:///";
        // DocumentProvider
        if (isKitKat && DocumentsContract.isDocumentUri(context, uri)) {
            // ExternalStorageProvider
            if (isExternalStorageDocument(uri)) {
                final String docId = DocumentsContract.getDocumentId(uri);
                final String[] split = docId.split(":");
                final String type = split[0];
                if ("primary".equalsIgnoreCase(type)) {
                    //return pathHead + Environment.getExternalStorageDirectory() + "/" + split[1];
                    return Environment.getExternalStorageDirectory() + "/" + split[1];
                }
            }
            // DownloadsProvider
            else if (isDownloadsDocument(uri)) {
                Log.e(TAG, "<><><> download 文件夹");
                Log.e(TAG, "<><><> uri = " + uri);
                final String id = DocumentsContract.getDocumentId(uri);
                Log.e(TAG, "<><><> parser id = " + id);
                if (id.startsWith("raw")) {
                    Log.e(TAG, "<><><> real path = " + id.substring(3));
                    return id.substring(4);
                }
                final Uri contentUri = ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.valueOf(id));
                Log.e(TAG, "<><><> 这是解析过的uri地址" + contentUri.getPath());
                //return pathHead + getDataColumn(context, contentUri, null, null);
                return getDataColumn(context, contentUri, null, null);
            }
            // MediaProvider
            else if (isMediaDocument(uri)) {
                Log.e(TAG, "<><><> 多多媒体文件夹");
                final String docId = DocumentsContract.getDocumentId(uri);
                Log.e(TAG, "<><><> parse id = " + docId);
                final String[] split = docId.split(":");
                final String type = split[0];

                Uri contentUri = null;
                if ("image".equals(type)) {
                    contentUri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                } else if ("video".equals(type)) {
                    contentUri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
                } else if ("audio".equals(type)) {
                    contentUri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
                }

                final String selection = "_id=?";
                final String[] selectionArgs = new String[]{split[1]};

                //return pathHead + getDataColumn(context, contentUri, selection, selectionArgs);
                return getDataColumn(context, contentUri, selection, selectionArgs);
            }
        }
        // MediaStore (and general)
        else if ("content".equalsIgnoreCase(uri.getScheme())) {
            Log.e(TAG, "<><><> content前缀 ");
            //return pathHead + getDataColumn(context, uri, null, null);
            return getDataColumn(context, uri, null, null);
        }
        // File
        else if ("file".equalsIgnoreCase(uri.getScheme())) {
            //return pathHead + uri.getPath();
            Log.e(TAG, "<><><> file前缀");
            return uri.getPath();
        }
        return null;
    }

    /**
     * Get the value of the data column for this Uri. This is useful for
     * MediaStore Uris, and other file-based ContentProviders.
     *
     * @param context       The context.
     * @param uri           The Uri to query.
     * @param selection     (Optional) Filter used in the query.
     * @param selectionArgs (Optional) Selection arguments used in the query.
     * @return The value of the _data column, which is typically a file path.
     */
    private static String getDataColumn(Context context, Uri uri, String selection, String[] selectionArgs) {

        Cursor cursor = null;
        final String column = "_data";
        final String[] projection = {column};
        try {
            cursor = context.getContentResolver().query(uri, projection, selection, selectionArgs, null);
            if (cursor != null && cursor.moveToFirst()) {
                final int column_index = cursor.getColumnIndexOrThrow(column);
                return cursor.getString(column_index);
            }
        } finally {
            if (cursor != null)
                cursor.close();
        }
        return null;
    }

    /**
     * @param uri The Uri to check.
     * @return Whether the Uri authority is ExternalStorageProvider.
     */
    private static boolean isExternalStorageDocument(Uri uri) {
        return "com.android.externalstorage.documents".equals(uri.getAuthority());
    }

    /**
     * @param uri The Uri to check.
     * @return Whether the Uri authority is DownloadsProvider.
     */
    private static boolean isDownloadsDocument(Uri uri) {
        return "com.android.providers.downloads.documents".equals(uri.getAuthority());
    }

    /**
     * 是否是多媒体文件夹
     * @param uri target uri
     * @return Whether the Uri authority is MediaProvider.
     */
    private static boolean isMediaDocument(Uri uri) {
        return "com.android.providers.media.documents".equals(uri.getAuthority());
    }

    /**
     * 获取文件缓存路径
     *
     * @param context
     * @param filename
     * @return
     */
    public static File getCacheFilePath(Context context, String filename) {
        File file = null;
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            file = new File(context.getExternalCacheDir(), String.format("%s.jpeg", filename));
        } else {
            file = new File(context.getCacheDir(), String.format("%s.jpeg", filename));
        }
        return file;
    }

    public static int calculateInSampleSize(BitmapFactory.Options options, int reqWidth, int reqHeight) {
        int outWidth = options.outWidth;
        int outHeight = options.outHeight;

        int inSample = 1;

        if (outHeight > reqHeight || outWidth > reqWidth) {
            int heightRatio = Math.round((float) outHeight / reqHeight);
            int widthRatio = Math.round((float) outWidth / reqWidth);
            inSample = heightRatio < widthRatio ? heightRatio : widthRatio;
        }
        return inSample;
    }

    public static Bitmap getSmallBitmap(String filePath) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(filePath, options);

        options.inSampleSize = calculateInSampleSize(options, 480, 800);
        options.inJustDecodeBounds = false;

        return BitmapFactory.decodeFile(filePath, options);
    }


    public static String bitmapToString(String path) {
        Bitmap smallBitmap = getSmallBitmap(path);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        smallBitmap.compress(Bitmap.CompressFormat.JPEG, 40, baos);
        byte[] bytes = baos.toByteArray();
        return Base64.encodeToString(bytes, Base64.DEFAULT);
    }

    public static byte[] bitmap2Bytes(String path) {
        Bitmap smallBitmap = getSmallBitmap(path);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        smallBitmap.compress(Bitmap.CompressFormat.JPEG, 40, baos);
        return baos.toByteArray();
    }

    public static String copyImg2Target(Context context, String srcPath) throws IOException {
        String tartPath = "";
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            tartPath = context.getExternalCacheDir().getAbsolutePath();
        } else {
            tartPath = context.getCacheDir().getAbsolutePath();
        }
        // 图片名
        int lastSplash = srcPath.lastIndexOf("/");
        String imgName = srcPath.substring(lastSplash);
        // 后缀
        int lastDot = srcPath.lastIndexOf(".");
        String postFix = srcPath.substring(lastDot);

        File upload = new File(tartPath, "upload");
        if (!upload.isFile() && !upload.exists()) {
            upload.mkdirs();
        }
        File imgFile = new File(upload, imgName);

        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(imgFile));

        //Bitmap smallBitmap = getSmallBitmap(srcPath);
        Bitmap smallBitmap = rotatePhoto(context, srcPath);
        if (smallBitmap == null) {
            return "";
        }
        Bitmap.CompressFormat imgFormat = Bitmap.CompressFormat.JPEG;

        if ("jpeg".equals(postFix) || "jpg".equals(postFix)) {
            imgFormat = Bitmap.CompressFormat.JPEG;
        } else if ("png".equals(postFix)) {
            imgFormat = Bitmap.CompressFormat.PNG;
        } else if ("webp".equals(postFix)) {
            imgFormat = Bitmap.CompressFormat.WEBP;
        }
        boolean result = smallBitmap.compress(imgFormat, 40, bos);
        bos.close();
        bos.flush();

        if (result) {
            return imgFile.getAbsolutePath();
        }
        return "";
    }

    /**
     * 获取本应用的缓存路径 /sdcard/Android/data/com.xxx.xxx
     * @param context context
     * @param dirName 缓存路径的文件夹名
     * @return
     */
    public static String getImageCacheDir(Context context, String dirName) {
        String tartPath = "";
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            tartPath = context.getExternalCacheDir().getAbsolutePath();
        } else {
            tartPath = context.getCacheDir().getAbsolutePath();
        }

        File targetDir = new File(tartPath, dirName);

        if (!targetDir.exists()) {
            targetDir.mkdirs();
        } else if (targetDir.isFile()) {
            targetDir.delete();
            targetDir.mkdirs();
        }
        return targetDir.getAbsolutePath();
    }

    /**
     * 将图片转为原始角度，某些手机可能会将拍到的照片进行旋转
     *
     * @param context    context
     * @param originPath 图片原始路径
     * @return
     */
    public static Bitmap rotatePhoto(Context context, String originPath) {
        int photoDegree = getPhotoDegree(originPath);
        Bitmap smallBitmap = getSmallBitmap(originPath);
        return rotateBitmap(smallBitmap, photoDegree);
    }

    /**
     * 根据 Exif 获取图片当前的角度
     *
     * @param photoPath 图片地址
     * @return
     */
    public static int getPhotoDegree(String photoPath) {
        int degree = 0;
        try {
            ExifInterface exifInterface = new ExifInterface(photoPath);
            int orientation = exifInterface.getAttributeInt(ExifInterface.TAG_ORIENTATION, ExifInterface.ORIENTATION_NORMAL);
            switch (orientation) {
                case ExifInterface.ORIENTATION_ROTATE_90:
                    degree = 90;
                    break;
                case ExifInterface.ORIENTATION_ROTATE_180:
                    degree = 180;
                    break;
                case ExifInterface.ORIENTATION_ROTATE_270:
                    degree = 270;
                    break;
                default:
                    break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return degree;
    }

    /**
     * 对 btimap 进行旋转
     *
     * @param bitmap target bitmap
     * @param angle  旋转角度
     * @return
     */
    public static Bitmap rotateBitmap(Bitmap bitmap, int angle) {
        Bitmap resultBitmap = null;
        Matrix matrix = new Matrix();
        matrix.postRotate(angle);
        try {
            resultBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (resultBitmap == null) {
            resultBitmap = bitmap;
        }
        if (bitmap != resultBitmap) {
            bitmap.recycle();
        }
        return resultBitmap;
    }
}
