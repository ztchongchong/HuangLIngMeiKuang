package com.lingjun.colliery_android.module.main;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.blankj.utilcode.util.LogUtils;
import com.lingjun.colliery_android.R;
import com.lingjun.colliery_android.base.BaseActivity;
import com.lingjun.colliery_android.base.BaseLinkList;
import com.lingjun.colliery_android.base.UserBeans;
import com.lingjun.colliery_android.bean.UpgradeAppBean;
import com.lingjun.colliery_android.bean.XiaoXiBean;
import com.lingjun.colliery_android.module.dealwith.fragment.DealWithTaskFragment;
import com.lingjun.colliery_android.module.learning.LearningFragment;
import com.lingjun.colliery_android.module.message.MessageFragment;
import com.lingjun.colliery_android.module.my.MyFragment;
import com.lingjun.colliery_android.utils.FastJsonTools;
import com.lingjun.colliery_android.utils.MessageEvent;
import com.lingjun.colliery_android.utils.PhotoPopupManager;
import com.lingjun.colliery_android.utils.RecyclerViewUtils;
import com.lingjun.colliery_android.utils.retrofit.BaseSubscriber;
import com.lingjun.colliery_android.utils.retrofit.ExceptionHandle;
import com.lingjun.colliery_android.view.NoScrollViewpager;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.tbruyelle.rxpermissions2.Permission;
import com.tbruyelle.rxpermissions2.RxPermissions;
import com.tencent.mm.opensdk.utils.Log;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

import cn.jpush.android.api.JPushInterface;
import io.reactivex.functions.Consumer;
import me.majiajie.pagerbottomtabstrip.NavigationController;
import me.majiajie.pagerbottomtabstrip.PageNavigationView;
import util.UpdateAppUtils;


public class MainActivity extends BaseActivity {
    //记录是否有首次按键
    private static boolean mBackKeyPressed = false;

    private NoScrollViewpager viewPager;
    private PageNavigationView main_bottom;
    private NavigationController mNavigationController;
    //域名
    private String coalname;
    //下载地址
    private String coalUrl;
    //服务器版本号
    private String coalversion;
    private int i;
    //极光
    private String Jpushid;
    private UpgradeAppBean upgradeAppBean;

    private UserBeans.UserBean bean;

    private RelativeLayout rl_jiaobiao;
    private TextView tv_jiaobiao;
    private RelativeLayout rl_xiaoxi;
    private TextView tv_xiaoxi;

    private int daiban = 0;
    private int xiaoxi = 0;

    @Override
    protected int getResourcesId() {
        return R.layout.activity_main;
    }

    @Override
    protected void init(Bundle savedInstanceState) throws PackageManager.NameNotFoundException {
        mImmersionBar.statusBarDarkFont(false).fitsSystemWindows(true).statusBarColor(R.color.colorPrimary).init();
        viewPager = findViewById(R.id.viewPager);
        main_bottom = findViewById(R.id.main_bottom);

        rl_jiaobiao = findViewById(R.id.rl_jiaobiao);
        tv_jiaobiao = findViewById(R.id.tv_jiaobiao);
        rl_xiaoxi = findViewById(R.id.rl_xiaoxi);
        tv_xiaoxi = findViewById(R.id.tv_xiaoxi);

        mNavigationController = main_bottom.material()
                .addItem(R.drawable.mk_main_selected, R.drawable.mk_main, "首页")
                .addItem(R.drawable.mk_xuexi_selected, R.drawable.mk_xuexi, "学习")
                .addItem(R.drawable.mk_daiban_selected, R.drawable.mk_daiban, "待办")
                .addItem(R.drawable.mk_xiaoxi_selected, R.drawable.mk_xiaoxi, "消息")
                .addItem(R.drawable.mk_wode_selected, R.drawable.mk_wode, "我的")
                .build();

        ArrayList<Fragment> mList = new ArrayList<>();
        //首页
        mList.add(new MainFragment());
        //学习
        mList.add(new LearningFragment());
        //待办
        mList.add(new DealWithTaskFragment());
        //消息
        mList.add(new MessageFragment());
        //我的
        mList.add(new MyFragment());
        viewPager.setOffscreenPageLimit(5);
        viewPager.setScroll(false);

        RecyclerViewUtils.initFtagmentViewPager(viewPager, mList, getSupportFragmentManager(), mNavigationController);

        // 升级版本
        inspectVersion();

        requestPermissions();

        Jpushid = JPushInterface.getRegistrationID(MainActivity.this);
        Log.e("极光id", Jpushid);
        //极光推送
        jpushid();

        setHuaweiBadge(daiban + xiaoxi, MainActivity.this);

        String id = getIntent().getStringExtra("jgid");
        if (id != null) {
            Log.e("pull_jgid", id);
            if (id.equals("{\"messageType\":\"1\"}")) {
                viewPager.setCurrentItem(2);
            } else if (id.equals("{\"messageType\":\"2\"}")) {
                viewPager.setCurrentItem(3);
            }
        }

    }

    //极光推送
    private void jpushid() {

        bean = UserBeans.getInstance().getUser();
        if (TextUtils.isEmpty(bean.getRegistrationid())) {
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("registrationid", Jpushid);
            hashMap.put(BaseLinkList.apiurl, BaseLinkList.coal_mine + BaseLinkList.updateRegistrationid);
            mRetrofit.JsonToColliery(BaseLinkList.Base_Url, hashMap, new BaseSubscriber() {
                @Override
                public void onError(ExceptionHandle.ResponeThrowable e) {

                }

                @Override
                public void onSuccess(JSONObject jsonObject) throws JSONException {
                    LogUtils.e("极光推送回调->>" + jsonObject.toString());

                }
            });
        } else {
            if (!bean.getRegistrationid().equals(Jpushid)) {
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("registrationid", Jpushid);
                hashMap.put(BaseLinkList.apiurl, BaseLinkList.coal_mine + BaseLinkList.updateRegistrationid);
                mRetrofit.JsonToColliery(BaseLinkList.Base_Url, hashMap, new BaseSubscriber() {
                    @Override
                    public void onError(ExceptionHandle.ResponeThrowable e) {

                    }

                    @Override
                    public void onSuccess(JSONObject jsonObject) throws JSONException {
                        LogUtils.e("极光推送回调->>" + jsonObject.toString());

                    }
                });
            }
        }
    }


    @SuppressLint("CheckResult")
    private void requestPermissions() {
        RxPermissions rxPermission = new RxPermissions(MainActivity.this);
        rxPermission
                .requestEach(android.Manifest.permission.ACCESS_FINE_LOCATION,
                        android.Manifest.permission.WRITE_EXTERNAL_STORAGE,
                        android.Manifest.permission.READ_CALENDAR,
                        android.Manifest.permission.READ_CALL_LOG,
                        android.Manifest.permission.READ_CONTACTS,
                        android.Manifest.permission.READ_PHONE_STATE,
                        android.Manifest.permission.RECORD_AUDIO,
                        android.Manifest.permission.CAMERA,
                        android.Manifest.permission.CALL_PHONE,
                        android.Manifest.permission.GET_ACCOUNTS
                )
                .subscribe(new Consumer<Permission>() {
                    @Override
                    public void accept(Permission permission) throws Exception {
                        if (permission.granted) {
                            // 用户已经同意该权限
                        } else if (permission.shouldShowRequestPermissionRationale) {
                            // 用户拒绝了该权限，没有选中『不再询问』（Never ask again）,那么下次再次启动时，还会提示请求权限的对话框
                        } else {
                            // 用户拒绝了该权限，并且选中『不再询问』
                        }
                    }
                });

    }

    @Override
    protected BaseRefreshLoadMoreInterface setRefreshLoadMoreListener() {
        return null;
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        PhotoPopupManager.getInstance().onActivityResulted(MainActivity.this, requestCode, resultCode, data);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }


    @Override
    protected void onPause() {
        super.onPause();
    }

    //退出app
    @Override
    public void onBackPressed() {
        if (!mBackKeyPressed) {
            Toast.makeText(this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
            mBackKeyPressed = true;
            //延时两秒，如果超出则擦错第一次按键记录
            new Timer().schedule(new TimerTask() {
                @Override
                public void run() {
                    mBackKeyPressed = false;
                }
            }, 2000);
        } else {
            //退出程序
            this.finish();
            System.exit(0);
        }
    }

    /**
     * 从服务器获取版本最新的版本信息
     */
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
                coalversion = upgradeAppBean.getCoalversion();
                try {
                    i = Integer.parseInt(coalversion);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
                UpdateAppUtils.from(MainActivity.this)
                        .checkBy(UpdateAppUtils.CHECK_BY_VERSION_CODE)//更新检测方式，默认为VersionCode
                        .serverVersionCode(i)//服务器 code
                        .apkPath(coalUrl)
                        .showNotification(true)//是否显示下载进度到通知栏，默认为true
                        .downloadBy(UpdateAppUtils.DOWNLOAD_BY_BROWSER)//下载方式：app下载、手机浏览器下载。默认app下载
                        .isForce(true)//是否强制更新，默认false 强制更新情况下用户不同意更新则不能使用app
                        .update();
            }
        });
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMsgFromEventBus(MessageEvent messageEvent) {
        daiban = messageEvent.getMessage();
        if (messageEvent.getMessage() != 0) {
            rl_jiaobiao.setVisibility(View.VISIBLE);
            if (messageEvent.getMessage() > 99) {
                tv_jiaobiao.setText(99 + "+");
            } else {
                tv_jiaobiao.setText(messageEvent.getMessage() + "");
            }
        } else if (messageEvent.getMessage() == 0 || null == messageEvent.getMessage() + "") {
            rl_jiaobiao.setVisibility(View.GONE);
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMsgFromEventBus(XiaoXiBean xiaoXiBean) {
        xiaoxi = xiaoXiBean.getXiaoxi();
        if (xiaoXiBean.getXiaoxi() != 0) {
            rl_xiaoxi.setVisibility(View.VISIBLE);
            if (xiaoXiBean.getXiaoxi() > 99) {
                tv_xiaoxi.setText(99 + "+");
            } else {
                tv_xiaoxi.setText(xiaoXiBean.getXiaoxi() + "");
            }
        } else if (xiaoXiBean.getXiaoxi() == 0 || null == xiaoXiBean.getXiaoxi() + "") {
            rl_xiaoxi.setVisibility(View.GONE);
        }
    }

    /**
     * @param count
     * @param context
     * @return 华为角标外放接口
     */
    private static boolean setHuaweiBadge(int count, Context context) {
        try {
//            String launchClassName = getLauncherClassName(context);
//            if (TextUtils.isEmpty(launchClassName)) {
//                return false;
//            }
            Bundle bundle = new Bundle();
            bundle.putString("package", context.getPackageName());//应用包名
            bundle.putString("class", "com.lingjun.colliery_android.module.main.MainActivity");//桌面图标对应的应用入口Activity类
            bundle.putInt("badgenumber", count);//角标数字
            context.getContentResolver().call(Uri.parse("content://com.huawei.android.launcher" +
                    ".settings/badge/"), "change_badge", null, bundle);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        setHuaweiBadge(daiban + xiaoxi, MainActivity.this);
    }
}
