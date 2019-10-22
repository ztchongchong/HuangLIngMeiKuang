package com.lingjun.colliery_android.application;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.multidex.MultiDexApplication;
import com.blankj.utilcode.util.Utils;
import com.scwang.smartrefresh.header.WaterDropHeader;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.DefaultRefreshFooterCreator;
import com.scwang.smartrefresh.layout.api.DefaultRefreshHeaderCreator;
import com.scwang.smartrefresh.layout.api.RefreshFooter;
import com.scwang.smartrefresh.layout.api.RefreshHeader;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.footer.ClassicsFooter;
import com.vondear.rxtool.RxTool;


import cn.jpush.android.api.JPushInterface;

/**
 *
 * @author nefa
 * @date 2018/10/15
 */

public class CollieryApplication extends MultiDexApplication {

    static {
        SmartRefreshLayout.setDefaultRefreshHeaderCreator(new DefaultRefreshHeaderCreator() {
            @NonNull
            @Override
            public RefreshHeader createRefreshHeader(@NonNull Context context, @NonNull RefreshLayout layout) {
                WaterDropHeader header = new WaterDropHeader(context);
                return header;
            }
        });

        SmartRefreshLayout.setDefaultRefreshFooterCreator(new DefaultRefreshFooterCreator() {
            @Override
            public RefreshFooter createRefreshFooter(Context context, RefreshLayout layout) {
                return new ClassicsFooter(context).setDrawableSize(17).setTextSizeTitle(14);
            }
        });
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Utils.init(this);
        RxTool.init(this);
        JPushInterface.setDebugMode(true);
        JPushInterface.init(this);

    }
}
