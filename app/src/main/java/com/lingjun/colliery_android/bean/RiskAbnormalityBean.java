package com.lingjun.colliery_android.bean;

import java.util.List;

/**
 * 作者: zengtao
 * 时间: 2019/5/27  18:27.
 * 注释:
 */
public class RiskAbnormalityBean {

    /**
     * msg : 成功
     * code : 200
     * data : {"meassageInfo":""}
     * resultMaps : []
     */

    private String msg;
    private String code;
    private DataBean data;
    private List<?> resultMaps;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public List<?> getResultMaps() {
        return resultMaps;
    }

    public void setResultMaps(List<?> resultMaps) {
        this.resultMaps = resultMaps;
    }

    public static class DataBean {
        /**
         * meassageInfo :
         */

        private String meassageInfo;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        private String name;

        public String getMeassageInfo() {
            return meassageInfo;
        }

        public void setMeassageInfo(String meassageInfo) {
            this.meassageInfo = meassageInfo;
        }
    }
}
