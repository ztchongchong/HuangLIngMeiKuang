package com.lingjun.colliery_android.module.dealwith.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lingjun.colliery_android.R;
import com.lingjun.colliery_android.bean.CheckFileBean;
import com.lingjun.colliery_android.bean.EditionCataLogInListAPPBean;
import com.lingjun.colliery_android.module.dealwith.myinterface.ListviewInterface;
import com.lingjun.colliery_android.utils.ToastUtils;

import java.util.List;

/**
 * Created by shurrikann on 2018/3/26.
 */

public class RequestInfoAdapter<T> extends BaseQuickAdapter<T, BaseViewHolder> {
    private int type;
    private ListviewInterface listviewInterface;
    private Context context;

    public RequestInfoAdapter(int layoutResId, @Nullable List<T> data, int type) {
        super(layoutResId, data);
        this.type = type;
    }

    public RequestInfoAdapter(int layoutResId, @Nullable List<T> data) {
        super(layoutResId, data);
    }

    public RequestInfoAdapter(@Nullable List<T> data) {
        super(data);
    }

    public RequestInfoAdapter(int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void convert(BaseViewHolder helper, T item) {
        final EditionCataLogInListAPPBean.DataBean.ResultStdfileEditionListBean.FileDataBean.FileListBean str = ( EditionCataLogInListAPPBean.DataBean.ResultStdfileEditionListBean.FileDataBean.FileListBean) item;
        helper.setText(R.id.text, str.getSysFiles().getFilename());
        ImageView eye = helper.getView(R.id.eye_img);
    }
}
