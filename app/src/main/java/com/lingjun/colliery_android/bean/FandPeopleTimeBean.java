package com.lingjun.colliery_android.bean;

import java.util.List;

/**
 * 录入人和当前时间
 */
public class FandPeopleTimeBean {

    /**
     * msg : 成功
     * code : 200
     * data : null
     * resultMaps : [{"nowdate":"2018-11-15","userName":"郭高民","userId":1326}]
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
         * nowdate : 2018-11-15
         * userName : 郭高民
         * userId : 1326
         */

        private String nowdate;
        private String userName;
        private int userId;

        public String getNowdate() {
            return nowdate;
        }

        public void setNowdate(String nowdate) {
            this.nowdate = nowdate;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }
    }
}
