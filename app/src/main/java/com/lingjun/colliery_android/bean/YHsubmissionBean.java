package com.lingjun.colliery_android.bean;

import java.util.List;

/**
 * 作者: zengtao
 * 时间: 2019/4/25  14:11.
 * 注释:
 */
public class YHsubmissionBean {

    /**
     * msg : 成功
     * data : {"maintaskId1":"13579","noprocessorFlag":1,"subtaskId1":"13580"}
     * code : 200
     * resultMaps : []
     */

    private String msg;
    private DataBean data;
    private String code;
    private List<?> resultMaps;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<?> getResultMaps() {
        return resultMaps;
    }

    public void setResultMaps(List<?> resultMaps) {
        this.resultMaps = resultMaps;
    }

    public static class DataBean {
        /**
         * maintaskId1 : 13579
         * noprocessorFlag : 1
         * subtaskId1 : 13580
         */

        private String maintaskId1;
        private int noprocessorFlag;
        private String subtaskId1;

        public String getMaintaskId1() {
            return maintaskId1;
        }

        public void setMaintaskId1(String maintaskId1) {
            this.maintaskId1 = maintaskId1;
        }

        public int getNoprocessorFlag() {
            return noprocessorFlag;
        }

        public void setNoprocessorFlag(int noprocessorFlag) {
            this.noprocessorFlag = noprocessorFlag;
        }

        public String getSubtaskId1() {
            return subtaskId1;
        }

        public void setSubtaskId1(String subtaskId1) {
            this.subtaskId1 = subtaskId1;
        }
    }
}
