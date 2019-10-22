package com.lingjun.colliery_android.bean;

import java.util.List;

public class HiddenDangerFourFgBean {

    /**
     * msg : 成功
     * code : 200
     * data : null
     * resultMaps : []
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
