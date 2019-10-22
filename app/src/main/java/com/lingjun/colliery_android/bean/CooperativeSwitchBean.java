package com.lingjun.colliery_android.bean;

import java.util.List;

/**
 * 作者: zengtao
 * 时间: 2019/6/15  17:08.
 * 注释:
 */
public class CooperativeSwitchBean {

    /**
     * msg : 成功
     * code : 200
     * data : {"technicalSwitch":"0","collaborativeUnitsSwitch":"0"}
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
         * technicalSwitch : 0
         * collaborativeUnitsSwitch : 0
         */

        private String technicalSwitch;
        private String collaborativeUnitsSwitch;

        public String getTechnicalSwitch() {
            return technicalSwitch;
        }

        public void setTechnicalSwitch(String technicalSwitch) {
            this.technicalSwitch = technicalSwitch;
        }

        public String getCollaborativeUnitsSwitch() {
            return collaborativeUnitsSwitch;
        }

        public void setCollaborativeUnitsSwitch(String collaborativeUnitsSwitch) {
            this.collaborativeUnitsSwitch = collaborativeUnitsSwitch;
        }
    }
}
