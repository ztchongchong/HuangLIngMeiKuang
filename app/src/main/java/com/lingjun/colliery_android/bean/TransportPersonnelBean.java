package com.lingjun.colliery_android.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者: zengtao
 * 时间: 2019/3/11  9:20.
 * 注释:
 */
public class TransportPersonnelBean {


    /**
     * msg : 成功
     * code : 200
     * data : {"departmentResult":[{"departmentName":"党群工作部","userlist":[{"userid":686,"username":null,"employeeno":"01221119","name":"姚恒福","mobile":null,"idcard":null,"sex":1,"pictureId":null,"leader":1,"id":667,"picurl":null},{"userid":687,"username":null,"employeeno":"01221120","name":"张彩侠","mobile":null,"idcard":null,"sex":0,"pictureId":null,"leader":0,"id":668,"picurl":null},{"userid":688,"username":null,"employeeno":"01221126","name":"党彦鹏","mobile":null,"idcard":null,"sex":1,"pictureId":null,"leader":0,"id":669,"picurl":null},{"userid":689,"username":null,"employeeno":"01221071","name":"李亮","mobile":null,"idcard":null,"sex":1,"pictureId":10659,"leader":0,"id":670,"picurl":"/upload/1551854821518.jpg"},{"userid":690,"username":null,"employeeno":"01040054","name":"李浩","mobile":null,"idcard":null,"sex":1,"pictureId":null,"leader":0,"id":671,"picurl":null}],"departmentid":685}]}
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
        private ArrayList<DepartmentResultBean> departmentResult;

        public ArrayList<DepartmentResultBean> getDepartmentResult() {
            return departmentResult;
        }

        public void setDepartmentResult(ArrayList<DepartmentResultBean> departmentResult) {
            this.departmentResult = departmentResult;
        }

        public static class DepartmentResultBean {
            /**
             * departmentName : 党群工作部
             * userlist : [{"userid":686,"username":null,"employeeno":"01221119","name":"姚恒福","mobile":null,"idcard":null,"sex":1,"pictureId":null,"leader":1,"id":667,"picurl":null},{"userid":687,"username":null,"employeeno":"01221120","name":"张彩侠","mobile":null,"idcard":null,"sex":0,"pictureId":null,"leader":0,"id":668,"picurl":null},{"userid":688,"username":null,"employeeno":"01221126","name":"党彦鹏","mobile":null,"idcard":null,"sex":1,"pictureId":null,"leader":0,"id":669,"picurl":null},{"userid":689,"username":null,"employeeno":"01221071","name":"李亮","mobile":null,"idcard":null,"sex":1,"pictureId":10659,"leader":0,"id":670,"picurl":"/upload/1551854821518.jpg"},{"userid":690,"username":null,"employeeno":"01040054","name":"李浩","mobile":null,"idcard":null,"sex":1,"pictureId":null,"leader":0,"id":671,"picurl":null}]
             * departmentid : 685
             */

            private String departmentName;
            private int departmentid;
            private List<UserlistBean> userlist;

            public String getDepartmentName() {
                return departmentName;
            }

            public void setDepartmentName(String departmentName) {
                this.departmentName = departmentName;
            }

            public int getDepartmentid() {
                return departmentid;
            }

            public void setDepartmentid(int departmentid) {
                this.departmentid = departmentid;
            }

            public List<UserlistBean> getUserlist() {
                return userlist;
            }

            public void setUserlist(List<UserlistBean> userlist) {
                this.userlist = userlist;
            }

            public static class UserlistBean {
                /**
                 * userid : 686
                 * username : null
                 * employeeno : 01221119
                 * name : 姚恒福
                 * mobile : null
                 * idcard : null
                 * sex : 1
                 * pictureId : null
                 * leader : 1
                 * id : 667
                 * picurl : null
                 */

                private int userid;
                private Object username;
                private String employeeno;
                private String name;
                private Object mobile;
                private Object idcard;
                private int sex;
                private Object pictureId;
                private int leader;
                private int id;
                private Object picurl;
                private boolean isSelect;


                public boolean isSelect() {
                    return isSelect;
                }

                public void setSelect(boolean select) {
                    isSelect = select;
                }

                public int getUserid() {
                    return userid;
                }

                public void setUserid(int userid) {
                    this.userid = userid;
                }

                public Object getUsername() {
                    return username;
                }

                public void setUsername(Object username) {
                    this.username = username;
                }

                public String getEmployeeno() {
                    return employeeno;
                }

                public void setEmployeeno(String employeeno) {
                    this.employeeno = employeeno;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public Object getMobile() {
                    return mobile;
                }

                public void setMobile(Object mobile) {
                    this.mobile = mobile;
                }

                public Object getIdcard() {
                    return idcard;
                }

                public void setIdcard(Object idcard) {
                    this.idcard = idcard;
                }

                public int getSex() {
                    return sex;
                }

                public void setSex(int sex) {
                    this.sex = sex;
                }

                public Object getPictureId() {
                    return pictureId;
                }

                public void setPictureId(Object pictureId) {
                    this.pictureId = pictureId;
                }

                public int getLeader() {
                    return leader;
                }

                public void setLeader(int leader) {
                    this.leader = leader;
                }

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public Object getPicurl() {
                    return picurl;
                }

                public void setPicurl(Object picurl) {
                    this.picurl = picurl;
                }
            }
        }
    }
}
