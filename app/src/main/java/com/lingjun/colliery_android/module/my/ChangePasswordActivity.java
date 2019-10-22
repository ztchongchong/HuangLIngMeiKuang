package com.lingjun.colliery_android.module.my;

import android.os.Bundle;
import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lingjun.colliery_android.R;
import com.lingjun.colliery_android.base.BaseActivity;
import com.lingjun.colliery_android.base.BaseLinkList;
import com.lingjun.colliery_android.base.OnGlobalListener;
import com.lingjun.colliery_android.bean.MainMessageBean;
import com.lingjun.colliery_android.utils.FastJsonTools;
import com.lingjun.colliery_android.utils.RecyclerViewUtils;
import com.lingjun.colliery_android.utils.retrofit.BaseSubscriber;
import com.lingjun.colliery_android.utils.retrofit.ExceptionHandle;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 作者: zengtao
 * 时间: 2018/12/3  11:03.
 * 注释: 修改密码
 */
public class ChangePasswordActivity extends BaseActivity {
    @BindView(R.id.et_old_pad)
    EditText etOldPad;
    @BindView(R.id.et_new_pad)
    EditText etNewPad;
    @BindView(R.id.et_new_pad1)
    EditText etNewPad1;
    @BindView(R.id.tv_sure)
    TextView tvSure;

    @Override
    protected int getResourcesId() {
        return R.layout.activity_change_password;
    }

    @Override
    protected void init(Bundle savedInstanceState) {

    }

    @Override
    protected BaseRefreshLoadMoreInterface setRefreshLoadMoreListener() {
        return null;
    }


    @OnClick({R.id.et_old_pad, R.id.et_new_pad, R.id.et_new_pad1, R.id.tv_sure})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.et_old_pad:
                break;
            case R.id.et_new_pad:
                break;
            case R.id.et_new_pad1:
                break;
            case R.id.tv_sure:
                check();//校验
                break;
        }
    }

    //校验
    private void check() {
        if (TextUtils.isEmpty(etOldPad.getText().toString().trim())
                || TextUtils.isEmpty(etNewPad.getText().toString().trim())
                || TextUtils.isEmpty(etNewPad1.getText().toString().trim())
                ) {
            ToastUtils.showShort("新旧密码不能为空");
            return;
        } else if (!etNewPad.getText().toString().trim().equals(etNewPad1.getText().toString().trim())) {
            ToastUtils.showShort("新密码不一致+");
            return;
        } else {
            ChangePassword();//修改密码提交
        }
    }

    //修改密码提交
    private void ChangePassword() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("oldpwd", "" + etOldPad.getText().toString().trim());
        hashMap.put("newpwd", "" + etNewPad.getText().toString().trim());
        hashMap.put(BaseLinkList.apiurl, BaseLinkList.coal_mine + BaseLinkList.modifypwd);
        mRetrofit.JsonToColliery(BaseLinkList.Base_Url, hashMap, new BaseSubscriber() {
            @Override
            public void onError(ExceptionHandle.ResponeThrowable e) {
                Toast.makeText(ChangePasswordActivity.this, "旧密码错误", Toast.LENGTH_SHORT).show();
                if (null != refreshLayout) {
                    refreshLayout.finishLoadMore();
                    refreshLayout.finishRefresh();
                }
            }

            @Override
            public void onSuccess(JSONObject jsonObject) throws JSONException {
                LogUtils.e("修改密码->>" + jsonObject.toString());
                if (jsonObject.get("code").equals("200")) {
                    ToastUtils.showShort("修改成功!");
                    ChangePasswordActivity.this.finish();
                } else {
                    ToastUtils.showShort(jsonObject.getString("msg"));
                }
            }
        });
    }
}
