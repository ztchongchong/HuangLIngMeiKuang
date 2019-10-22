package com.lingjun.colliery_android.bean;

import java.util.List;

/**
 * 作者: zengtao
 * 时间: 2019/2/27  16:10.
 * 注释:
 */
public class DisobeysaveBean {

    /**
     * msg : 成功
     * code : 200
     * data : {"flog":true,"isSave":true}
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
         * flog : true
         * isSave : true
         */

        private boolean flog;
        private boolean isSave;

        public boolean isFlog() {
            return flog;
        }

        public void setFlog(boolean flog) {
            this.flog = flog;
        }

        public boolean isIsSave() {
            return isSave;
        }

        public void setIsSave(boolean isSave) {
            this.isSave = isSave;
        }
    }
}
