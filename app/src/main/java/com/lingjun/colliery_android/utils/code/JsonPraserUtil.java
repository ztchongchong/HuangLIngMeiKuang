package com.lingjun.colliery_android.utils.code;

import android.content.Context;

import com.blankj.utilcode.util.LogUtils;
import com.google.gson.Gson;

/**
 * @since 1.0
 * <p/>
 * SnowJun  2017/2/13
 */
public class JsonPraserUtil {
    private static JsonPraserUtil ourInstance = new JsonPraserUtil();

    public static JsonPraserUtil getInstance() {
        return ourInstance;
    }

    private JsonPraserUtil() {
    }

    /**
     * 进行解密
     * @return
     */
    public String genJsonString(String codeInfo){
        String info = MyDecrypt.DecryptData(codeInfo, CodeConfig.DES_KEY1,CodeConfig.DES_KEY2);
        return info;
    }

    /**
     * 根据加密错误信息获取提示信息
     * @param codeError
     */
    public void genTipMsg(Context context, String codeError){
        String info = MyDecrypt.DecryptData(codeError, CodeConfig.DES_KEY1,CodeConfig.DES_KEY2);
        ErrorBean bean =  new Gson().fromJson(info,ErrorBean.class);
        if ("UserNothingness".equals(bean.getResult_info().get(0).getError())){
            LogUtils.e("手机号码不存在，请先注册",false);
            return;
        }
//        if ("".equals(bean.getResult_info().get(0).getError())){//todo  添加验证码过期错误码
//            ToastUtils.getInstance(context).showToast("验证码已过期，请重新获取",false);
//            return;
//        }
        if ("UserAccountOrPwdFormatError".equals(bean.getResult_info().get(0).getError())){
            LogUtils.e("用户名或密码错误",false);
            return;
        }
        if ("UserNothingness".equals(bean.getResult_info().get(0).getError())){
            LogUtils.e("手机号码不存在，请先注册",false);
            return;
        }
        if ("UserExist".equals(bean.getResult_info().get(0).getError())){
            LogUtils.e("用户已存在，请直接登录",false);
            return;
        }
        if ("CodeError".equals(bean.getResult_info().get(0).getError())){
            LogUtils.e("请输入正确的验证码",false);
            return;
        }
        if ("Error".equals(bean.getResult_info().get(0).getError())){
            LogUtils.e("操作失败", false);
            return;
        }
        if ("AccountExist".equals(bean.getResult_info().get(0).getError())){
            LogUtils.e("用户已存在", false);
            return;
        }
        if ("IntegralInadequate".equals(bean.getResult_info().get(0).getError())){
            LogUtils.e("鸽豆不足", false);
            return;
        }

    }


}
