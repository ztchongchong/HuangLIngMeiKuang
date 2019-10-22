package com.lingjun.colliery_android.base;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.scwang.smartrefresh.layout.api.RefreshHeader;
import com.scwang.smartrefresh.layout.api.RefreshInternal;
import com.scwang.smartrefresh.layout.internal.InternalAbstract;

/**
 * Created by nefa on 2018/11/8.
 */

public class BaseRefreshHeader extends InternalAbstract implements RefreshHeader {


    protected BaseRefreshHeader(@NonNull View wrapped) {
        super(wrapped);
    }

    protected BaseRefreshHeader(@NonNull View wrappedView, @Nullable RefreshInternal wrappedInternal) {
        super(wrappedView, wrappedInternal);
    }

    protected BaseRefreshHeader(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
}
