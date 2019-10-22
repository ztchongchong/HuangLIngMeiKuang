package com.lingjun.colliery_android.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * lishi
 */
public class Result {


    /**
     * msg : 成功
     * code : 200
     * data : null
     * resultMaps : [{"locationhistory":[{"id":49,"location":"111","timestamp":1542257581000,"sysuserId":1326},{"id":48,"location":"我 ","timestamp":1542253022000,"sysuserId":1326},{"id":47,"location":"11","timestamp":1542252877000,"sysuserId":1326},{"id":46,"location":"4","timestamp":1542252125000,"sysuserId":1326},{"id":45,"location":"3","timestamp":1542252116000,"sysuserId":1326}]}]
     */

    private String msg;
    private String code;
    private Object data;
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

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public List<?> getResultMaps() {
        return resultMaps;
    }

    public void setResultMaps(List<?> resultMaps) {
        this.resultMaps = resultMaps;
    }
}
