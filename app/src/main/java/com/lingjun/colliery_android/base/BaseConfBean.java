package com.lingjun.colliery_android.base;



import com.lingjun.colliery_android.utils.SerializationUtils;

import java.io.Serializable;

/**
 * Created by nefa on 2018/8/2.
 */

public class BaseConfBean implements Serializable{

    private static final String SPKey = "ConfBean";
    private static final String DATAKey = "ConfBeanDetails";
    private static BaseConfBean mConf = null;

    //        return SerializationUtils.GetSerialize(SPKey,DATAKey,BaseConfBean.class);

    public static BaseConfBean getInstance(){
        if (null == mConf){
            if (null == SerializationUtils.GetSerialize(SPKey,DATAKey,BaseConfBean.class)){
                mConf = new BaseConfBean();
            }else {
                mConf = SerializationUtils.GetSerialize(SPKey,DATAKey,BaseConfBean.class);
            }
        }
        return mConf;
    }

    public static void saveConf(BaseConfBean mConf){
        SerializationUtils.SaveSerialize(SPKey,DATAKey,mConf);
    }

    public static void clearConf(){
        SerializationUtils.ClearSerialize(SPKey,DATAKey);
    }


    public boolean isShow() {
        return isShow;
    }

    public void setShow(boolean show) {
        isShow = show;
    }

    private boolean isShow;//是否展现过引导图?
    private int curMain;//定制首页 1为题库 2为课程 3位刷课 4为我的
    private boolean play4G;//是否可以使用运营商流量观看视频 true为可以
    private boolean nightMode;//是否开启夜间模式 true为开启
    private boolean autoNext;//自动下一题
    private int answerTextSize;//答题页文字大小 1:小号(14sp) 2:标准(16sp) 3:大号(18sp)



    public int getCurMain() {
        return curMain;
    }

    public boolean isNightMode() {
        return nightMode;
    }

    public void setNightMode(boolean nightMode) {
        this.nightMode = nightMode;
    }

    public boolean isAutoNext() {
        return autoNext;
    }

    public void setAutoNext(boolean autoNext) {
        this.autoNext = autoNext;
    }

    public int getAnswerTextSize() {
        return answerTextSize;
    }

    public void setAnswerTextSize(int answerTextSize) {
        this.answerTextSize = answerTextSize;
    }

    public void setCurMain(int curMain) {

        this.curMain = curMain;
    }


    public boolean isPlay4G() {
        return play4G;
    }

    public void setPlay4G(boolean play4G) {
        this.play4G = play4G;
    }
}
