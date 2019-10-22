package com.lingjun.colliery_android.bean;

import java.util.List;

public class UpgradeAuditorBean {

    /**
     * msg : 成功
     * data : {"List":[{"employeeno":"01080242","id":17,"groupType":8,"name":"唐建荣","enabled":1,"sex":1,"departmentname":"党政办","userid":0},{"employeeno":"01080017","id":13,"groupType":8,"name":"柳铁军","enabled":1,"sex":1,"departmentname":"党政办","userid":0},{"employeeno":"40000041","id":8,"groupType":8,"name":"梁锐","enabled":1,"sex":1,"departmentname":"党政办","userid":0},{"employeeno":"01080123","id":95,"pictureId":4141,"groupType":8,"name":"孔德昊","enabled":1,"sex":1,"departmentname":"党政办,安全质量科,生产科,综采队","userid":0}]}
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
        private java.util.List<ListBean> List;

        public List<ListBean> getList() {
            return List;
        }

        public void setList(List<ListBean> List) {
            this.List = List;
        }

        public static class ListBean {
            /**
             * employeeno : 01080242
             * id : 17
             * groupType : 8
             * name : 唐建荣
             * enabled : 1
             * sex : 1
             * departmentname : 党政办
             * userid : 0
             * pictureId : 4141
             */

            private String employeeno;
            private int id;
            private int groupType;
            private String name;
            private int enabled;
            private int sex;
            private String departmentname;
            private int userid;
            private int pictureId;

            public String getEmployeeno() {
                return employeeno;
            }

            public void setEmployeeno(String employeeno) {
                this.employeeno = employeeno;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getGroupType() {
                return groupType;
            }

            public void setGroupType(int groupType) {
                this.groupType = groupType;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public int getEnabled() {
                return enabled;
            }

            public void setEnabled(int enabled) {
                this.enabled = enabled;
            }

            public int getSex() {
                return sex;
            }

            public void setSex(int sex) {
                this.sex = sex;
            }

            public String getDepartmentname() {
                return departmentname;
            }

            public void setDepartmentname(String departmentname) {
                this.departmentname = departmentname;
            }

            public int getUserid() {
                return userid;
            }

            public void setUserid(int userid) {
                this.userid = userid;
            }

            public int getPictureId() {
                return pictureId;
            }

            public void setPictureId(int pictureId) {
                this.pictureId = pictureId;
            }
        }
    }
}
