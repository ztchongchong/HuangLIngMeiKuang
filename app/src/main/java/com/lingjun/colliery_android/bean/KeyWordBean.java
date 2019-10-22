package com.lingjun.colliery_android.bean;

import java.io.Serializable;
import java.util.List;

/**
 * 作者: zengtao
 * 时间: 2019/2/20  15:26.
 * 注释:
 */
public class KeyWordBean implements Serializable{

    /**
     * msg : 成功
     * code : 200
     * data : {"keylist":[{"id":4,"number":"01","groupId":0,"name":"工作类","remark":"","enabled":true,"selectName":"工作类"},{"id":6,"number":"0101","groupId":4,"name":"顶板","remark":"","enabled":true,"selectName":"--顶板"},{"id":7,"number":"0102","groupId":4,"name":"通风","remark":"","enabled":true,"selectName":"--通风"},{"id":8,"number":"0103","groupId":4,"name":"瓦斯","remark":"","enabled":true,"selectName":"--瓦斯"},{"id":9,"number":"0104","groupId":4,"name":"煤尘","remark":"","enabled":true,"selectName":"--煤尘"},{"id":10,"number":"0105","groupId":4,"name":"机电","remark":"","enabled":true,"selectName":"--机电"},{"id":11,"number":"0106","groupId":4,"name":"运输","remark":"","enabled":true,"selectName":"--运输"},{"id":12,"number":"0107","groupId":4,"name":"火灾","remark":"","enabled":true,"selectName":"--火灾"},{"id":13,"number":"0108","groupId":4,"name":"水灾","remark":"","enabled":true,"selectName":"--水灾"},{"id":14,"number":"0109","groupId":4,"name":"其他","remark":"","enabled":true,"selectName":"--其他"},{"id":5,"number":"02","groupId":0,"name":"资料类","remark":"","enabled":true,"selectName":"资料类"},{"id":26,"number":"0201","groupId":5,"name":"文献","remark":"","enabled":true,"selectName":"--文献"},{"id":27,"number":"0202","groupId":5,"name":"报表","remark":"","enabled":true,"selectName":"--报表"},{"id":28,"number":"0203","groupId":5,"name":"图表","remark":"","enabled":true,"selectName":"--图表"},{"id":29,"number":"0204","groupId":5,"name":"台账","remark":"","enabled":true,"selectName":"--台账"}]}
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
        private List<KeylistBean> keylist;

        public List<KeylistBean> getKeylist() {
            return keylist;
        }

        public void setKeylist(List<KeylistBean> keylist) {
            this.keylist = keylist;
        }

        public static class KeylistBean implements Serializable{
            /**
             * id : 4
             * number : 01
             * groupId : 0
             * name : 工作类
             * remark :
             * enabled : true
             * selectName : 工作类
             */

            private int id;
            private String number;
            private int groupId;
            private String name;
            private String remark;
            private boolean enabled;
            private String selectName;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getNumber() {
                return number;
            }

            public void setNumber(String number) {
                this.number = number;
            }

            public int getGroupId() {
                return groupId;
            }

            public void setGroupId(int groupId) {
                this.groupId = groupId;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getRemark() {
                return remark;
            }

            public void setRemark(String remark) {
                this.remark = remark;
            }

            public boolean isEnabled() {
                return enabled;
            }

            public void setEnabled(boolean enabled) {
                this.enabled = enabled;
            }

            public String getSelectName() {
                return selectName;
            }

            public void setSelectName(String selectName) {
                this.selectName = selectName;
            }
        }
    }
}
