package com.lingjun.colliery_android.module.my;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lingjun.colliery_android.R;
import com.lingjun.colliery_android.base.BaseActivity;
import com.lingjun.colliery_android.base.BaseFragment;
import com.lingjun.colliery_android.base.BaseLinkList;
import com.lingjun.colliery_android.base.OnGlobalListener;
import com.lingjun.colliery_android.base.UserBean;
import com.lingjun.colliery_android.base.UserBeans;
import com.lingjun.colliery_android.bean.HiddenDangerDetailsBean;
import com.lingjun.colliery_android.bean.UpLoadImageBean;
import com.lingjun.colliery_android.module.dealwith.activity.ImplementedActivity;
import com.lingjun.colliery_android.module.dealwith.hiddendanger.general_hidden_danger.HiddenDangerNtryActivity;
import com.lingjun.colliery_android.module.login.LoginActivity;
import com.lingjun.colliery_android.utils.DateUtil;
import com.lingjun.colliery_android.utils.FastJsonTools;
import com.lingjun.colliery_android.utils.PhotoPopupManager;
import com.lingjun.colliery_android.utils.RecyclerViewUtils;
import com.lingjun.colliery_android.utils.retrofit.BaseSubscriber;
import com.lingjun.colliery_android.utils.retrofit.ExceptionHandle;
import com.lingjun.colliery_android.utils.retrofit.ReceivedCookiesInterceptor;
import com.yanzhenjie.permission.PermissionActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import de.hdodenhof.circleimageview.CircleImageView;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.lingjun.colliery_android.base.BaseLinkList.Base_Url;

/**
 * 作者: lihuan
 * 时间: 2018/11/28 10:22
 * 说明: 个人设置
 */
public class PersonalSettingsFragment extends BaseFragment {

    @BindView(R.id.iv_user_photo)
    CircleImageView ivUserPhoto;
    TextView tvPhone;
    @BindView(R.id.tv_set_pwd)
    TextView tvSetPwd;


    public PersonalSettingsFragment() {
    }

    public static PersonalSettingsFragment newInstance(String param1, String param2) {
        PersonalSettingsFragment fragment = new PersonalSettingsFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int setLayout(LayoutInflater inflater) {
        return R.layout.fragment_personal_settings;
    }

    @Override
    protected BaseRefreshLoadMoreInterface setRefreshLoadMoreListener() {
        return null;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        dataDisplay();
    }

    /**
     * 界面数据填充
     */
    private void dataDisplay() {
        UserBeans.UserBean bean = UserBeans.getInstance().getUser();
        if (bean != null) {

            tvPhone.setText(bean.getMobile());

            RequestOptions options = new RequestOptions()
                    .override(100, 100)
                    .error(R.drawable.icon_biaozhunhua); // 加载失败的图片  
            Glide.with(getActivity()).load(BaseLinkList.Base_Url + "?" + BaseLinkList.apiurl + "=" + BaseLinkList.coal_mine + bean.getPictureurl()).apply(options).into(ivUserPhoto);
        }
    }

    @OnClick(R.id.iv_user_photo)
    public void onIvUserPhotoClicked() { //设置头像
        userphoto();
    }

    private void userphoto() {

        //添加
        PhotoPopupManager.getInstance().show(getActivity());
        PhotoPopupManager.getInstance().setOnPhotoSelectedListener(new PhotoPopupManager.OnPhotoSelectedListener() {
            @Override
            public void onPhotoSelected(String photoPath, int callBack_location) {
                //返回path
                LogUtils.e("返回Path:" + photoPath);
                if (TextUtils.isEmpty(photoPath)) {
                    return;
                }

                final File file = new File(photoPath);
                final BaseActivity activity = (BaseActivity) getActivity();
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
                        Glide.with(getActivity()).load(file).into(ivUserPhoto);

                        UpLoadImageBean upLoadImageBean = FastJsonTools.getBean(str, UpLoadImageBean.class);
                        HashMap<String, String> hashMap = new HashMap<>();
                        hashMap.put("mobile", "");
                        hashMap.put("picid", upLoadImageBean.getResultMaps().get(0).getFileId() + "");
                        hashMap.put(BaseLinkList.apiurl, BaseLinkList.coal_mine + BaseLinkList.modifyuser);
                        mRetrofit.JsonToColliery(BaseLinkList.Base_Url, hashMap, new BaseSubscriber() {
                            @Override
                            public void onError(ExceptionHandle.ResponeThrowable e) {
                                Toast.makeText(getActivity(), "头像保存失败", Toast.LENGTH_SHORT).show();
                                if (null != refreshLayout) {
                                    refreshLayout.finishLoadMore();
                                    refreshLayout.finishRefresh();
                                }
                            }

                            @Override
                            public void onSuccess(JSONObject jsonObject) throws JSONException {
                                LogUtils.e("->>" + jsonObject.toString());
                                if (jsonObject.get("code").equals("200")) {
                                    ToastUtils.showShort("头像已保存!");
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


    @OnClick(R.id.tv_set_pwd)
    public void onTvSetPwdClicked() { //设置密码
        startActivity(new Intent(getActivity(), ChangePasswordActivity.class));
    }

}
