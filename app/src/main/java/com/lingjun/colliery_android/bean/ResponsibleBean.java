package com.lingjun.colliery_android.bean;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Created by nefa on 2018/11/16.
 */

public class ResponsibleBean {

    /**
     * msg : 成功
     * code : 200
     * data : {"departmentlist":[{"id":19,"departmentId":48,"flags":1,"remark":null,"userlist":[{"userid":49,"username":null,"employeeno":"01062449","name":"李向锋","mobile":null,"idcard":null,"sex":1,"pictureId":null,"leader":0,"id":46,"picurl":null},{"userid":50,"username":null,"employeeno":"01060360","name":"王北海","mobile":null,"idcard":null,"sex":1,"pictureId":null,"leader":0,"id":47,"picurl":null},{"userid":51,"username":null,"employeeno":"01062448","name":"程新民","mobile":null,"idcard":null,"sex":1,"depno":"036"}],"url":"http://127.0.0.1:8080/safety/"}
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
         * departmentlist : [{"id":19,"departmentId":48,"flags":1,"remark":null,"userlist":[{"userid":49,"username":null,"employeeno":"01062449","name":"李向锋","mobile":null,"idcard":null,"sex":1,"pictureId":null,"leader":0,"id":46,"picurl":null},{"userid":50,"username":null,"employeeno":"01060360","depno":"036"}]
         * url : http://127.0.0.1:8080/safety/
         */

        private String url;
        private ArrayList<DepartmentlistBean> departmentlist;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public ArrayList<DepartmentlistBean> getDepartmentlist() {
            return departmentlist;
        }

        public void setDepartmentlist(ArrayList<DepartmentlistBean> departmentlist) {
            this.departmentlist = departmentlist;
        }

        public static class DepartmentlistBean {
            /**
             * id : 19
             * departmentId : 48
             * flags : 1
             * remark : null
             * userlist : [{"userid":49,"username":null,"employeeno":"01062449","name":"李向锋","mobile":null,"idcard":null,"sex":1,"pictureId":null,"leader":0,"id":46,"picurl":null},{"userid":50,"username":null,"employeeno":"01060360","name":"王北海","mobile":null,"idcard":null,"sex":1,"pictureId":null,"leader":0,"id":47,"picurl":null},{"userid":51,"username":null,"employeeno":"01062448","name":"程新民","mobile":null,
             * departmentleader : {"userid":59,"username":null,"employeeno":"01062451","name":"何万明","mobile":null,"idcard":null,"sex":1,"pictureId":null,"leader":1,"id":56,"picurl":null}
             * depName : 综采队
             * depno : 021
             */

            private int id;
            private int departmentId;
            private int flags;
            private Object remark;
            private DepartmentleaderBean departmentleader;
            private String depName;
            private String depno;
            private ArrayList<UserlistBean> userlist;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getDepartmentId() {
                return departmentId;
            }

            public void setDepartmentId(int departmentId) {
                this.departmentId = departmentId;
            }

            public int getFlags() {
                return flags;
            }

            public void setFlags(int flags) {
                this.flags = flags;
            }

            public Object getRemark() {
                return remark;
            }

            public void setRemark(Object remark) {
                this.remark = remark;
            }

            public DepartmentleaderBean getDepartmentleader() {
                return departmentleader;
            }

            public void setDepartmentleader(DepartmentleaderBean departmentleader) {
                this.departmentleader = departmentleader;
            }

            public String getDepName() {
                return depName;
            }

            public void setDepName(String depName) {
                this.depName = depName;
            }

            public String getDepno() {
                return depno;
            }

            public void setDepno(String depno) {
                this.depno = depno;
            }

            public ArrayList<UserlistBean> getUserlist() {
                return userlist;
            }

            public void setUserlist(ArrayList<UserlistBean> userlist) {
                this.userlist = userlist;
            }

            public static class DepartmentleaderBean {
                /**
                 * userid : 59
                 * username : null
                 * employeeno : 01062451
                 * name : 何万明
                 * mobile : null
                 * idcard : null
                 * sex : 1
                 * pictureId : null
                 * leader : 1
                 * id : 56
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

            public static class UserlistBean {
                /**
                 * userid : 49
                 * username : null
                 * employeeno : 01062449
                 * name : 李向锋
                 * mobile : null
                 * idcard : null
                 * sex : 1
                 * pictureId : null
                 * leader : 0
                 * id : 46
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
