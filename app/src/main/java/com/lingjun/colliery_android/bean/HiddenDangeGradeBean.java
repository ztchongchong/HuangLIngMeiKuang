package com.lingjun.colliery_android.bean;

import java.util.List;

/**
 * 隐患等级
 */
public class HiddenDangeGradeBean {


    /**
     * msg : 成功
     * code : 200
     * data : null
     * resultMaps : [{"number":1,"slight":false,"name":"一般","id":1}]
     */

    private String msg;
    private String code;
    private Object data;
    private List<ResultMapsBean> resultMaps;

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

    public List<ResultMapsBean> getResultMaps() {
        return resultMaps;
    }

    public void setResultMaps(List<ResultMapsBean> resultMaps) {
        this.resultMaps = resultMaps;
    }

    public static class ResultMapsBean {
        /**
         * number : 1
         * slight : false
         * name : 一般
         * id : 1
         */

        private int number;
        private boolean slight;
        private String name;
        private int id;

        public int getNumber() {
            return number;
        }

        public void setNumber(int number) {
            this.number = number;
        }

        public boolean isSlight() {
            return slight;
        }

        public void setSlight(boolean slight) {
            this.slight = slight;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }
    }
}
