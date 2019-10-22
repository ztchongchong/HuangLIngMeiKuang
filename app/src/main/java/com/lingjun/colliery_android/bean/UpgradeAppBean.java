package com.lingjun.colliery_android.bean;

/**
 * 作者: zengtao
 * 时间: 2018/12/15  11:54.
 * 注释:
 */
public class UpgradeAppBean {


    /**
     * coalname : yuhua
     * coalUrl : http://118.190.0.100:9999/yuhua/safety.apk
     * updateconment : 12
     * coalversion : 11
     * updatetime : 2018-12-6
     */

    private String coalname;
    private String coalUrl;
    private String updateconment;
    private String coalversion;
    private String updatetime;

    public String getCoalname() {
        return coalname;
    }

    public void setCoalname(String coalname) {
        this.coalname = coalname;
    }

    public String getCoalUrl() {
        return coalUrl;
    }

    public void setCoalUrl(String coalUrl) {
        this.coalUrl = coalUrl;
    }

    public String getUpdateconment() {
        return updateconment;
    }

    public void setUpdateconment(String updateconment) {
        this.updateconment = updateconment;
    }

    public String getCoalversion() {
        return coalversion;
    }

    public void setCoalversion(String coalversion) {
        this.coalversion = coalversion;
    }

    public String getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(String updatetime) {
        this.updatetime = updatetime;
    }
}
