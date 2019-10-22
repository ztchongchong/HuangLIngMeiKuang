package com.lingjun.colliery_android.view;

import android.content.Context;
import android.content.res.TypedArray;  
import android.graphics.Bitmap;  
import android.graphics.Bitmap.Config;  
import android.graphics.Canvas;  
import android.graphics.Color;  
import android.graphics.Paint;  
import android.graphics.Path;  
import android.graphics.PorterDuff;  
import android.graphics.PorterDuffXfermode;  
import android.graphics.RectF;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import android.widget.ImageView;

import com.lingjun.colliery_android.R;


/** 
 * 实现圆角头像 
 */  
public class RoundAngleImageView extends AppCompatImageView {
  
    private static final int defaultCornerSize = 0; // 单位dp
    private Paint paint;  
    private Paint paint2;  
  
    /** 
     * 左上角角度
     */  
    private int leftTop = defaultCornerSize;
    private int rightTop = defaultCornerSize;
    private int leftBottom = defaultCornerSize;
    private int rightBottom = defaultCornerSize;
    private int allAngle = defaultCornerSize;

    public RoundAngleImageView(Context context, AttributeSet attrs, int defStyle) {  
        super(context, attrs, defStyle);  
        init(context, attrs);  
    }  
  
    public RoundAngleImageView(Context context, AttributeSet attrs) {  
        super(context, attrs);  
        init(context, attrs);  
    }  
  
    public RoundAngleImageView(Context context) {  
        super(context);  
        init(context, null);  
    }  
  
    private void init(Context context, AttributeSet attrs) {  
        if (attrs != null) {  
            TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.RoundAngleImageView);

            allAngle = a.getDimensionPixelSize(R.styleable.RoundAngleImageView_allAngle, allAngle);
            leftTop = a.getDimensionPixelSize(R.styleable.RoundAngleImageView_leftTop, allAngle);
            rightTop = a.getDimensionPixelSize(R.styleable.RoundAngleImageView_rightTop, allAngle);
            leftBottom = a.getDimensionPixelSize(R.styleable.RoundAngleImageView_leftBottom, allAngle);
            rightBottom = a.getDimensionPixelSize(R.styleable.RoundAngleImageView_rightBottom, allAngle);
        } else {
            float density = context.getResources().getDisplayMetrics().density;
            leftTop = (int) (leftTop * density);
            rightTop = (int) (rightTop * density);
            leftBottom = (int) (leftBottom * density);
            rightBottom = (int) (rightBottom * density);
        }
  
        paint = new Paint();  
        paint.setColor(Color.WHITE);  
        paint.setAntiAlias(true);  
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));  
  
        paint2 = new Paint();  
        paint2.setXfermode(null);  
    }  
  
    @Override  
    public void draw(Canvas canvas) {  
        Bitmap bitmap = Bitmap.createBitmap(getWidth(), getHeight(), Config.ARGB_8888);  
        Canvas canvas2 = new Canvas(bitmap);  
        super.draw(canvas2);  
  
        // 分别裁剪4个角  
        drawLeftUp(canvas2);  
        drawLeftDown(canvas2);  
        drawRightUp(canvas2);  
        drawRightDown(canvas2);  
  
        canvas.drawBitmap(bitmap, 0, 0, paint2);  
        bitmap.recycle();  
    }  
  
    private void drawLeftUp(Canvas canvas) {  
        Path path = new Path();  
        path.moveTo(0, leftTop);
        path.lineTo(0, 0);  
        path.lineTo(leftTop, 0);
        path.arcTo(new RectF(0, 0, leftTop * 2, leftTop * 2), -90, -90);
        path.close();  
        canvas.drawPath(path, paint);  
    }  
  
    private void drawLeftDown(Canvas canvas) {  
        Path path = new Path();  
        path.moveTo(0, getHeight() - leftBottom);
        path.lineTo(0, getHeight());  
        path.lineTo(leftBottom, getHeight());
        path.arcTo(new RectF(0, getHeight() - leftBottom * 2, leftBottom * 2, getHeight()), 90, 90);
        path.close();  
        canvas.drawPath(path, paint);  
    }  
  
    private void drawRightDown(Canvas canvas) {  
        Path path = new Path();  
        path.moveTo(getWidth() - rightBottom, getHeight());
        path.lineTo(getWidth(), getHeight());  
        path.lineTo(getWidth(), getHeight() - rightBottom);
        path.arcTo(new RectF(getWidth() - rightBottom * 2, getHeight() - rightBottom * 2, getWidth(), getHeight()), -0, 90);
        path.close();  
        canvas.drawPath(path, paint);  
    }  
  
    private void drawRightUp(Canvas canvas) {  
        Path path = new Path();  
        path.moveTo(getWidth(), rightTop);
        path.lineTo(getWidth(), 0);  
        path.lineTo(getWidth() - rightTop, 0);
        path.arcTo(new RectF(getWidth() - rightTop * 2, 0, getWidth(), 0 + rightTop * 2), -90, 90);
        path.close();  
        canvas.drawPath(path, paint);  
    }  
}  