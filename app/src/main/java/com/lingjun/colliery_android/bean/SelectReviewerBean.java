package com.lingjun.colliery_android.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者: zengtao
 * 时间: 2019/3/29  10:53.
 * 注释:
 */
public class SelectReviewerBean {

    /**
     * msg : 成功
     * code : 200
     * data : {"listUserDepartMent":[{"id":null,"userId":94,"departmentId":1869,"leader":1,"enabled":null,"dePartMentName":"安全质量科","userName":"熊爱明","employeeno":"01080120"},{"id":null,"userId":95,"departmentId":1868,"leader":1,"enabled":null,"dePartMentName":"生产科","userName":"孔德昊","employeeno":null},{"id":null,"userId":1,"departmentId":1867,"leader":1,"enabled":null,"dePartMentName":"党政办","userName":"岳东","employeeno":"41140015"}]}
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
        private ArrayList<ListUserDepartMentBean> listUserDepartMent;

        public ArrayList<ListUserDepartMentBean> getListUserDepartMent() {
            return listUserDepartMent;
        }

        public void setListUserDepartMent(ArrayList<ListUserDepartMentBean> listUserDepartMent) {
            this.listUserDepartMent = listUserDepartMent;
        }

        public static class ListUserDepartMentBean {
            /**
             * id : null
             * userId : 94
             * departmentId : 1869
             * leader : 1
             * enabled : null
             * dePartMentName : 安全质量科
             * userName : 熊爱明
             * employeeno : 01080120
             */

            private Object id;
            private int userId;
            private int departmentId;
            private int leader;
            private Object enabled;
            private String dePartMentName;
            private String userName;
            private String employeeno;

            public Object getId() {
                return id;
            }

            public void setId(Object id) {
                this.id = id;
            }

            public int getUserId() {
                return userId;
            }

            public void setUserId(int userId) {
                this.userId = userId;
            }

            public int getDepartmentId() {
                return departmentId;
            }

            public void setDepartmentId(int departmentId) {
                this.departmentId = departmentId;
            }

            public int getLeader() {
                return leader;
            }

            public void setLeader(int leader) {
                this.leader = leader;
            }

            public Object getEnabled() {
                return enabled;
            }

            public void setEnabled(Object enabled) {
                this.enabled = enabled;
            }

            public String getDePartMentName() {
                return dePartMentName;
            }

            public void setDePartMentName(String dePartMentName) {
                this.dePartMentName = dePartMentName;
            }

            public String getUserName() {
                return userName;
            }

            public void setUserName(String userName) {
                this.userName = userName;
            }

            public String getEmployeeno() {
                return employeeno;
            }

            public void setEmployeeno(String employeeno) {
                this.employeeno = employeeno;
            }
        }
    }
}
