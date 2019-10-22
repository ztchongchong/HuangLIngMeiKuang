package com.lingjun.colliery_android.module.my;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.lingjun.colliery_android.R;
import com.lingjun.colliery_android.base.BaseActivity;
import com.lingjun.colliery_android.base.BaseLinkList;
import com.lingjun.colliery_android.base.UserBean;
import com.lingjun.colliery_android.base.UserBeans;
import com.lingjun.colliery_android.bean.UpLoadImageBean;
import com.lingjun.colliery_android.module.login.LoginActivity;
import com.lingjun.colliery_android.module.main.MainActivity;
import com.lingjun.colliery_android.utils.FastJsonTools;
import com.lingjun.colliery_android.utils.PhotoPopupManager;
import com.lingjun.colliery_android.utils.retrofit.BaseSubscriber;
import com.lingjun.colliery_android.utils.retrofit.ExceptionHandle;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * 作者: zengtao
 * 时间: 2019/1/27  9:17.
 * 注释:个人信息
 */
public class PersonalSettingsActivity extends BaseActivity {

    @BindView(R.id.iv_user_photo)
    CircleImageView ivUserPhoto;
    @BindView(R.id.rl_user_photo)
    RelativeLayout rlUserPhoto;
    @BindView(R.id.tv_set_pwd)
    TextView tvSetPwd;
    private String touxiang;

    @Override
    protected int getResourcesId() {
        return R.layout.fragment_personal_settings;
    }

    @Override
    protected void init(Bundle savedInstanceState) throws PackageManager.NameNotFoundException {
        dataDisplay();
    }

    /**
     * 界面数据填充
     */
    private void dataDisplay() {
        UserBeans.UserBean bean = UserBeans.getInstance().getUser();
        if (bean != null) {
            RequestOptions options = new RequestOptions()
                    .override(100, 100)
                    .error(R.drawable.deafultuser); // 加载失败的图片  
            Glide.with(PersonalSettingsActivity.this).load(BaseLinkList.Base_Url + "?" + BaseLinkList.apiurl + "=" + BaseLinkList.coal_mine + bean.getPictureurl()).apply(options).into(ivUserPhoto);
            Log.e("黄泉买骨人", BaseLinkList.Base_Url + "?" + BaseLinkList.apiurl + "=" + BaseLinkList.coal_mine + bean.getPictureurl());
        }
    }

    @Override
    protected BaseRefreshLoadMoreInterface setRefreshLoadMoreListener() {
        return null;
    }


    @OnClick({R.id.rl_user_photo, R.id.tv_set_pwd})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rl_user_photo:
                //更换头像
                userphoto();
                break;
            case R.id.tv_set_pwd:
                //修改密码
                startActivity(new Intent(PersonalSettingsActivity.this, ChangePasswordActivity.class));
                break;
            default:
        }
    }

    //更换头像
    private void userphoto() {

        //添加
        PhotoPopupManager.getInstance().show(PersonalSettingsActivity.this);
        PhotoPopupManager.getInstance().setOnPhotoSelectedListener(new PhotoPopupManager.OnPhotoSelectedListener() {
            @Override
            public void onPhotoSelected(String photoPath, int callBack_location) {
                //返回path
                LogUtils.e("返回Path:" + photoPath);
                if (TextUtils.isEmpty(photoPath)) {
                    return;
                }

                final File file = new File(photoPath);
                final BaseActivity activity = PersonalSettingsActivity.this;
                activity.showLoadDialog();
                HashMap<String, File> params = new HashMap<>();
                params.put("image", file);

                mRetrofit.upload(BaseLinkList.Base_Url, new HashMap<String, String>(), params, new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        String str = "";
                        try {
                            str = new String(response.body().bytes());
                            LogUtils.e("上传成功->>" + str);

                        } catch (IOException e) {
                            e.printStackTrace();
                            LogUtils.e("转换出错->>" + e.getMessage());
                            return;
                        }
                        activity.dismissDialog();
                        Glide.with(PersonalSettingsActivity.this).load(file).into(ivUserPhoto);

                        final UpLoadImageBean upLoadImageBean = FastJsonTools.getBean(str, UpLoadImageBean.class);

                        HashMap<String, String> hashMap = new HashMap<>();
                        hashMap.put("mobile", "");
                        hashMap.put("picid", upLoadImageBean.getResultMaps().get(0).getFileId() + "");
                        hashMap.put(BaseLinkList.apiurl, BaseLinkList.coal_mine + BaseLinkList.modifyuser);
                        mRetrofit.JsonToColliery(BaseLinkList.Base_Url, hashMap, new BaseSubscriber() {
                            @Override
                            public void onError(ExceptionHandle.ResponeThrowable e) {
                                Toast.makeText(PersonalSettingsActivity.this, "头像保存失败", Toast.LENGTH_SHORT).show();
                                if (null != refreshLayout) {
                                    refreshLayout.finishLoadMore();
                                    refreshLayout.finishRefresh();
                                }
                            }

                            @Override
                            public void onSuccess(JSONObject jsonObject) throws JSONException {
                                LogUtils.e("->>" + jsonObject.toString());
                                if (jsonObject.get("code").equals("200")) {
                                    touxiang = "/upload/" + upLoadImageBean.getResultMaps().get(0).getFileName();
                                    UserBeans bean = UserBeans.getInstance();
                                    UserBeans.UserBean bean1 = bean.getUser();
                                    bean1.setPictureurl(touxiang);
                                    Log.e("头像地址====>", "/upload/" + upLoadImageBean.getResultMaps().get(0).getFileName());
                                    UserBeans.saveUserBean(bean);
                                } else {
                                    ToastUtils.showShort(jsonObject.getString("msg"));
                                }

                            }
                        });
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        LogUtils.e("上传失败->>" + t.getMessage());
                        activity.dismissDialog();
                    }
                });
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        PhotoPopupManager.getInstance().onActivityResulted(PersonalSettingsActivity.this, requestCode, resultCode, data);
    }

}
