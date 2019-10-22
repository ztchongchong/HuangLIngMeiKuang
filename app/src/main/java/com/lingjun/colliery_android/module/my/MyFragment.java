package com.lingjun.colliery_android.module.my;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.lingjun.colliery_android.BuildConfig;
import com.lingjun.colliery_android.R;
import com.lingjun.colliery_android.base.BaseFragment;
import com.lingjun.colliery_android.base.BaseLinkList;
import com.lingjun.colliery_android.base.UserBeans;
import com.lingjun.colliery_android.bean.UpgradeAppBean;
import com.lingjun.colliery_android.module.document.activity.DocumentSearchActivity;
import com.lingjun.colliery_android.module.document.activity.TaskTrackingActivity;
import com.lingjun.colliery_android.module.login.LoginActivity;
import com.lingjun.colliery_android.utils.FastJsonTools;
import com.lingjun.colliery_android.utils.retrofit.BaseSubscriber;
import com.lingjun.colliery_android.utils.retrofit.ExceptionHandle;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import cc.shinichi.library.ImagePreview;
import de.hdodenhof.circleimageview.CircleImageView;
import util.UpdateAppUtils;

/**
 * Created by nefa on 2018/11/13.
 * 个人中心
 */

public class MyFragment extends BaseFragment {

    @BindView(R.id.iv_touxiang)
    CircleImageView ivTouxiang;
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.tv_gonghao)
    TextView tvGonghao;
    @BindView(R.id.ll_1)
    LinearLayout ll1;
    @BindView(R.id.ll_2)
    LinearLayout ll2;
    @BindView(R.id.tv_logout)
    TextView tvLogout;
    @BindView(R.id.ll_3)
    LinearLayout ll3;
    @BindView(R.id.ll_4)
    LinearLayout ll4;


    private TextView tv_company;
    private UserBeans.UserBean bean;
    private UpgradeAppBean upgradeAppBean;

    //域名
    private String coalname;
    //下载地址
    private String coalUrl;
    //服务器版本号
    private int newcode;
    private int oldcode;


    @Override
    protected int setLayout(LayoutInflater inflater) {
        return R.layout.fragment_my;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        oldcode = BuildConfig.VERSION_CODE;
        tv_company = mRootView.findViewById(R.id.tv_company);
        dataDisplay();
    }

    private void dataDisplay() {
        bean = UserBeans.getInstance().getUser();
        if (bean != null) {

            tvGonghao.setText(bean.getEmployeeno() + "");
            tvName.setText(bean.getName() + "");
            tv_company.setText(bean.getDepartmentnames() + "");
            // 加载失败的图片  
            RequestOptions options = new RequestOptions()
                    .override(100, 100)
                    .error(R.drawable.deafultuser);
            Glide.with(getActivity()).load(BaseLinkList.Base_Url + "?" + BaseLinkList.apiurl + "=" + BaseLinkList.coal_mine + bean.getPictureurl()).apply(options).into(ivTouxiang);
        }
    }

    @Override
    protected BaseRefreshLoadMoreInterface setRefreshLoadMoreListener() {
        return null;
    }


    @OnClick({R.id.iv_touxiang, R.id.ll_1, R.id.ll_2, R.id.ll_3, R.id.tv_logout})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_touxiang:
                break;
            //个人信息
            case R.id.ll_1:
                startActivity(new Intent(getActivity(), PersonalSettingsActivity.class));
                break;
            //检查更新
            case R.id.ll_2:
                inspectVersion();
                break;
            //工作跟踪
            case R.id.ll_3:
                startActivity(new Intent(getActivity(), TaskTrackingActivity.class));
                break;
            //退出登录
            case R.id.tv_logout:
                //退出app
                logout();
                break;
            default:
        }
    }

    private void inspectVersion() {
        HashMap<String, String> hashMap = new HashMap<>();
        //玉华
//        hashMap.put("coalname", "yuhua");
        //陈家山
//        hashMap.put("coalname", "chenjiashan");
        //下石节
//        hashMap.put("coalname", "xiashijie");
        //柴家沟
//        hashMap.put("coalname", "chaijiagou");
        //双龙
        hashMap.put("coalname", "shuanglong");
        mRetrofit.get("http://134.175.189.65:8881/forwardhandout/version", hashMap, new BaseSubscriber() {
            @Override
            public void onError(ExceptionHandle.ResponeThrowable e) {

            }

            @Override
            public void onSuccess(JSONObject jsonObject) throws JSONException {
                LogUtils.e("服务器新版号->>" + jsonObject.toString());

                upgradeAppBean = FastJsonTools.getBean(jsonObject.toString(), UpgradeAppBean.class);
                coalname = upgradeAppBean.getCoalname();
                coalUrl = upgradeAppBean.getCoalUrl();
                newcode = Integer.valueOf(upgradeAppBean.getCoalversion());
                if (oldcode < newcode) {
                    UpdateAppUtils.from(getActivity())
                            .checkBy(UpdateAppUtils.CHECK_BY_VERSION_CODE)//更新检测方式，默认为VersionCode
                            .serverVersionCode(newcode)//服务器 code
                            .apkPath(coalUrl)
                            .showNotification(true)//是否显示下载进度到通知栏，默认为true
                            .downloadBy(UpdateAppUtils.DOWNLOAD_BY_BROWSER)//下载方式：app下载、手机浏览器下载。默认app下载
                            .isForce(true)//是否强制更新，默认false 强制更新情况下用户不同意更新则不能使用app
                            .update();
                } else {
                    Toast.makeText(getActivity(), "当前已是最新版本！版本号：" + BuildConfig.VERSION_NAME, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    //查看头像
    private void touxiang() {
        String a = bean.getPictureurl();
        if (a != null) {
            ImagePreview
                    .getInstance()
                    // 上下文，必须是activity，不需要担心内存泄漏，本框架已经处理好；
                    .setContext(getActivity())
                    // 有三种设置数据集合的方式，根据自己的需求进行选择：
                    // 第一步生成的imageInfo List
//                        .setImageInfoList(imageInfoList)
                    // 直接传url List
//                    .setImageList(Collections.singletonList(BaseLinkList.Base_Url + "?" + BaseLinkList.apiurl + "=" + BaseLinkList.coal_mine + a))
                    // 只有一张图片的情况，可以直接传入这张图片的url
                    .setImage(BaseLinkList.Base_Url + "?" + BaseLinkList.apiurl + "=" + BaseLinkList.coal_mine + a)
                    // 是否显示下载按钮，在页面右下角。默认显示
                    .setShowDownButton(false)
                    // 是否显示关闭页面按钮，在页面左下角。默认不显示
                    .setShowCloseButton(true)
                    // 开启预览
                    .start();
        } else {
            ToastUtils.showShort("请先设置头像");
        }
    }

    //退出登录
    private void logout() {
        UserBeans.clearUserBean();
        SharedPreferences cookie = getActivity().getSharedPreferences("cookie", Context.MODE_PRIVATE);
        cookie.edit().clear().commit();
        SharedPreferences token = getActivity().getSharedPreferences("userinfo", Context.MODE_PRIVATE);
        token.edit().clear().commit();
        Intent intent = new Intent(getActivity(), LoginActivity.class);
        startActivity(intent);
        getActivity().finish();
    }

    @Override
    public void onResume() {
        dataDisplay();
        super.onResume();
    }

    @OnClick(R.id.ll_4)
    public void onViewClicked() {
        startActivity(new Intent(getActivity(), DocumentSearchActivity.class));
    }
}
