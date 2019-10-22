package com.lingjun.colliery_android.module.login;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.lingjun.colliery_android.BuildConfig;
import com.lingjun.colliery_android.R;
import com.lingjun.colliery_android.base.BaseActivity;
import com.lingjun.colliery_android.base.BaseLinkList;
import com.lingjun.colliery_android.base.UserBean;
import com.lingjun.colliery_android.base.UserBeans;
import com.lingjun.colliery_android.module.main.MainActivity;
import com.lingjun.colliery_android.utils.FastJsonTools;
import com.lingjun.colliery_android.utils.retrofit.BaseSubscriber;
import com.lingjun.colliery_android.utils.retrofit.ExceptionHandle;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by nefa on 2018/10/25.
 */

public class LoginActivity extends BaseActivity {

    private EditText user_name;
    private EditText user_pwd;
    private Button btn_login;

    private String newcode;
    private String oldcode;

    @Override
    protected int getResourcesId() {
        return R.layout.activity_login;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        mImmersionBar.statusBarDarkFont(true).fitsSystemWindows(true).statusBarColor(R.color.white).init();
        user_name = findViewById(R.id.user_name);
        user_pwd = findViewById(R.id.user_pwd);
        btn_login = findViewById(R.id.btn_login);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });

        newcode = BuildConfig.VERSION_CODE + "";
        SharedPreferences b = getSharedPreferences("version", Context.MODE_PRIVATE);
        oldcode = b.getString("versioncode", "");
        Log.e("新版本好+旧版本号", newcode + "<=====>" + oldcode);

        if (null != UserBeans.getInstance() && !TextUtils.isEmpty(UserBeans.getInstance().getToken())) {
            if (null != oldcode) {
                if (newcode.equals(oldcode)) {
                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                    finish();
                }
            }
        } else {
            user_name.setText("");
            user_pwd.setText("");
        }

        SharedPreferences preferences = getSharedPreferences("Info", Activity.MODE_PRIVATE);
        String account = preferences.getString("account", "");
        int password = preferences.getInt("password", -1);
        user_name.setText(account);
        if (password == -1) {
            user_pwd.setText("");
        } else {
            user_pwd.setText(password + "");
        }
    }

    @Override
    protected BaseRefreshLoadMoreInterface setRefreshLoadMoreListener() {
        return null;
    }

    private void login() {
        if (TextUtils.isEmpty(user_name.getText().toString().trim()) || TextUtils.isEmpty(user_pwd.getText().toString().trim())) {
            ToastUtils.showShort("账号或密码不能为空!");
            return;
        }

        showLoadDialog();
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(BaseLinkList.apiurl, BaseLinkList.coal_mine + BaseLinkList.login);
        hashMap.put("username", user_name.getText().toString().trim());
        hashMap.put("password", user_pwd.getText().toString().trim());
        hashMap.put("mobile", "1");
        mRetrofit.get(BaseLinkList.Base_Url, hashMap, new BaseSubscriber() {
            @Override
            public void onError(ExceptionHandle.ResponeThrowable e) {
                dismissDialog();
            }

            @Override
            public void onSuccess(JSONObject jsonObject) throws JSONException {
                LogUtils.e("登录返回->>" + jsonObject.toString());
                dismissDialog();
                    //成功
                if (jsonObject.getInt("errno") == 0) {
                    UserBeans userBeans = FastJsonTools.getBean(jsonObject.toString(), UserBeans.class);
                    SharedPreferences token = getSharedPreferences("userinfo", Context.MODE_PRIVATE);
                    token.edit().putString("userinfoDetails", userBeans.getToken()).commit();
                    Log.e("获取的token", userBeans.getToken() + "");
                    UserBeans.saveUserBean(userBeans);

                    SharedPreferences code = getSharedPreferences("version", Context.MODE_PRIVATE);
                    code.edit().putString("versioncode", BuildConfig.VERSION_CODE + "").commit();

                    SharedPreferences sharedPreferences = getSharedPreferences("Info", Context.MODE_PRIVATE);
                    sharedPreferences.edit().putString("account", String.valueOf(user_name.getText().toString().trim())).commit();
                    sharedPreferences.edit().putInt("password", Integer.valueOf(user_pwd.getEditableText().toString().trim())).commit();

                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                    finish();
                    return;
                } else if (jsonObject.getInt("errno") == 1) {
                    //用户不存在
                    ToastUtils.showShort(jsonObject.getString("message"));
                    return;
                } else if (jsonObject.getInt("errno") == 2) {
                    //密码错误
                    ToastUtils.showShort(jsonObject.getString("message"));
                    return;
                } else if (jsonObject.getInt("errno") == 3) {
                    //验证码错误
                    ToastUtils.showShort(jsonObject.getString("message"));
                    return;
                } else if (jsonObject.getInt("errno") == 4) {
                    //其他错误
                    ToastUtils.showShort(jsonObject.getString("message"));
                    return;
                }
            }
        });
    }
}
