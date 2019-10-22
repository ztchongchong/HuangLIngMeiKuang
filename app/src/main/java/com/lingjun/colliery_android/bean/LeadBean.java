package com.lingjun.colliery_android.bean;

import java.util.List;

/**
 * Created by shurrikann on 2018/4/23.
 */

public class LeadBean {


    /**
     * msg : 成功
     * code : 200
     * data : {"approver":{"id":17,"username":null,"password":null,"employeeno":"01080242","name":"唐建荣","mobile":null,"idcard":null,"sex":1,"external":0,"enabled":1,"leaved":0,"deleted":0,"contactinfo":null,"email":null,"admin":0,"sort":null,"remark":null,"pictureId":null,"roleset":null,"builtinrolelist":null,"pictureurl":null,"catagoryIds":null,"departmentnames":"党政办","unitId":null,"studyappurl":""},"inuser":[{"id":173,"username":null,"password":"","employeeno":"01010004","name":"岳峰","mobile":null,"idcard":null,"sex":1,"external":0,"enabled":1,"leaved":0,"deleted":0,"contactinfo":null,"email":null,"admin":0,"sort":null,"remark":null,"pictureId":null,"roleset":null,"builtinrolelist":null,"pictureurl":null,"catagoryIds":null,"departmentnames":null,"unitId":null,"studyappurl":""}],"outuser":[]}
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
         * approver : {"id":17,"username":null,"password":null,"employeeno":"01080242","name":"唐建荣","mobile":null,"idcard":null,"sex":1,"external":0,"enabled":1,"leaved":0,"deleted":0,"contactinfo":null,"email":null,"admin":0,"sort":null,"remark":null,"pictureId":null,"roleset":null,"builtinrolelist":null,"pictureurl":null,"catagoryIds":null,"departmentnames":"党政办","unitId":null,"studyappurl":""}
         * inuser : [{"id":173,"username":null,"password":"","employeeno":"01010004","name":"岳峰","mobile":null,"idcard":null,"sex":1,"external":0,"enabled":1,"leaved":0,"deleted":0,"contactinfo":null,"email":null,"admin":0,"sort":null,"remark":null,"pictureId":null,"roleset":null,"builtinrolelist":null,"pictureurl":null,"catagoryIds":null,"departmentnames":null,"unitId":null,"studyappurl":""}]
         * outuser : []
         */

        private ApproverBean approver;
        private List<InuserBean> inuser;
        private List<OutuserBean> outuser;

        public ApproverBean getApprover() {
            return approver;
        }

        public void setApprover(ApproverBean approver) {
            this.approver = approver;
        }

        public List<InuserBean> getInuser() {
            return inuser;
        }

        public void setInuser(List<InuserBean> inuser) {
            this.inuser = inuser;
        }

        public List<OutuserBean> getOutuser() {
            return outuser;
        }

        public void setOutuser(List<OutuserBean> outuser) {
            this.outuser = outuser;
        }

        public static class ApproverBean {
            /**
             * id : 17
             * username : null
             * password : null
             * employeeno : 01080242
             * name : 唐建荣
             * mobile : null
             * idcard : null
             * sex : 1
             * external : 0
             * enabled : 1
             * leaved : 0
             * deleted : 0
             * contactinfo : null
             * email : null
             * admin : 0
             * sort : null
             * remark : null
             * pictureId : null
             * roleset : null
             * builtinrolelist : null
             * pictureurl : null
             * catagoryIds : null
             * departmentnames : 党政办
             * unitId : null
             * studyappurl :
             */

            private int id;
            private Object username;
            private Object password;
            private String employeeno;
            private String name;
            private Object mobile;
            private Object idcard;
            private int sex;
            private int external;
            private int enabled;
            private int leaved;
            private int deleted;
            private Object contactinfo;
            private Object email;
            private int admin;
            private Object sort;
            private Object remark;
            private Object pictureId;
            private Object roleset;
            private Object builtinrolelist;
            private Object pictureurl;
            private Object catagoryIds;
            private String departmentnames;
            private Object unitId;
            private String studyappurl;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public Object getUsername() {
                return username;
            }

            public void setUsername(Object username) {
                this.username = username;
            }

            public Object getPassword() {
                return password;
            }

            public void setPassword(Object password) {
                this.password = password;
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

            public int getExternal() {
                return external;
            }

            public void setExternal(int external) {
                this.external = external;
            }

            public int getEnabled() {
                return enabled;
            }

            public void setEnabled(int enabled) {
                this.enabled = enabled;
            }

            public int getLeaved() {
                return leaved;
            }

            public void setLeaved(int leaved) {
                this.leaved = leaved;
            }

            public int getDeleted() {
                return deleted;
            }

            public void setDeleted(int deleted) {
                this.deleted = deleted;
            }

            public Object getContactinfo() {
                return contactinfo;
            }

            public void setContactinfo(Object contactinfo) {
                this.contactinfo = contactinfo;
            }

            public Object getEmail() {
                return email;
            }

            public void setEmail(Object email) {
                this.email = email;
            }

            public int getAdmin() {
                return admin;
            }

            public void setAdmin(int admin) {
                this.admin = admin;
            }

            public Object getSort() {
                return sort;
            }

            public void setSort(Object sort) {
                this.sort = sort;
            }

            public Object getRemark() {
                return remark;
            }

            public void setRemark(Object remark) {
                this.remark = remark;
            }

            public Object getPictureId() {
                return pictureId;
            }

            public void setPictureId(Object pictureId) {
                this.pictureId = pictureId;
            }

            public Object getRoleset() {
                return roleset;
            }

            public void setRoleset(Object roleset) {
                this.roleset = roleset;
            }

            public Object getBuiltinrolelist() {
                return builtinrolelist;
            }

            public void setBuiltinrolelist(Object builtinrolelist) {
                this.builtinrolelist = builtinrolelist;
            }

            public Object getPictureurl() {
                return pictureurl;
            }

            public void setPictureurl(Object pictureurl) {
                this.pictureurl = pictureurl;
            }

            public Object getCatagoryIds() {
                return catagoryIds;
            }

            public void setCatagoryIds(Object catagoryIds) {
                this.catagoryIds = catagoryIds;
            }

            public String getDepartmentnames() {
                return departmentnames;
            }

            public void setDepartmentnames(String departmentnames) {
                this.departmentnames = departmentnames;
            }

            public Object getUnitId() {
                return unitId;
            }

            public void setUnitId(Object unitId) {
                this.unitId = unitId;
            }

            public String getStudyappurl() {
                return studyappurl;
            }

            public void setStudyappurl(String studyappurl) {
                this.studyappurl = studyappurl;
            }
        }

        public static class InuserBean {
            /**
             * id : 173
             * username : null
             * password :
             * employeeno : 01010004
             * name : 岳峰
             * mobile : null
             * idcard : null
             * sex : 1
             * external : 0
             * enabled : 1
             * leaved : 0
             * deleted : 0
             * contactinfo : null
             * email : null
             * admin : 0
             * sort : null
             * remark : null
             * pictureId : null
             * roleset : null
             * builtinrolelist : null
             * pictureurl : null
             * catagoryIds : null
             * departmentnames : null
             * unitId : null
             * studyappurl :
             */

            private int id;
            private Object username;
            private String password;
            private String employeeno;
            private String name;
            private Object mobile;
            private Object idcard;
            private int sex;
            private int external;
            private int enabled;
            private int leaved;
            private int deleted;
            private Object contactinfo;
            private Object email;
            private int admin;
            private Object sort;
            private Object remark;
            private Object pictureId;
            private Object roleset;
            private Object builtinrolelist;
            private Object pictureurl;
            private Object catagoryIds;
            private Object departmentnames;
            private Object unitId;
            private String studyappurl;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public Object getUsername() {
                return username;
            }

            public void setUsername(Object username) {
                this.username = username;
            }

            public String getPassword() {
                return password;
            }

            public void setPassword(String password) {
                this.password = password;
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

            public int getExternal() {
                return external;
            }

            public void setExternal(int external) {
                this.external = external;
            }

            public int getEnabled() {
                return enabled;
            }

            public void setEnabled(int enabled) {
                this.enabled = enabled;
            }

            public int getLeaved() {
                return leaved;
            }

            public void setLeaved(int leaved) {
                this.leaved = leaved;
            }

            public int getDeleted() {
                return deleted;
            }

            public void setDeleted(int deleted) {
                this.deleted = deleted;
            }

            public Object getContactinfo() {
                return contactinfo;
            }

            public void setContactinfo(Object contactinfo) {
                this.contactinfo = contactinfo;
            }

            public Object getEmail() {
                return email;
            }

            public void setEmail(Object email) {
                this.email = email;
            }

            public int getAdmin() {
                return admin;
            }

            public void setAdmin(int admin) {
                this.admin = admin;
            }

            public Object getSort() {
                return sort;
            }

            public void setSort(Object sort) {
                this.sort = sort;
            }

            public Object getRemark() {
                return remark;
            }

            public void setRemark(Object remark) {
                this.remark = remark;
            }

            public Object getPictureId() {
                return pictureId;
            }

            public void setPictureId(Object pictureId) {
                this.pictureId = pictureId;
            }

            public Object getRoleset() {
                return roleset;
            }

            public void setRoleset(Object roleset) {
                this.roleset = roleset;
            }

            public Object getBuiltinrolelist() {
                return builtinrolelist;
            }

            public void setBuiltinrolelist(Object builtinrolelist) {
                this.builtinrolelist = builtinrolelist;
            }

            public Object getPictureurl() {
                return pictureurl;
            }

            public void setPictureurl(Object pictureurl) {
                this.pictureurl = pictureurl;
            }

            public Object getCatagoryIds() {
                return catagoryIds;
            }

            public void setCatagoryIds(Object catagoryIds) {
                this.catagoryIds = catagoryIds;
            }

            public Object getDepartmentnames() {
                return departmentnames;
            }

            public void setDepartmentnames(Object departmentnames) {
                this.departmentnames = departmentnames;
            }

            public Object getUnitId() {
                return unitId;
            }

            public void setUnitId(Object unitId) {
                this.unitId = unitId;
            }

            public String getStudyappurl() {
                return studyappurl;
            }

            public void setStudyappurl(String studyappurl) {
                this.studyappurl = studyappurl;
            }
        }

        public static class OutuserBean {
            /**
             * id : 25
             * username : mgh
             * password : 123
             * employeeno : null
             * name : 马国华
             * mobile : null
             * idcard : null
             * sex : null
             * external : 1
             * enabled : 1
             * leaved : null
             * deleted : 0
             * contactinfo : null
             * email : null
             * admin : 0
             * sort : null
             * remark : null
             * pictureId : null
             * roleset : null
             * builtinrolelist : null
             * pictureurl : null
             * departmentnames : null
             */

            private int id;
            private String username;
            private String password;
            private Object employeeno;
            private String name;
            private Object mobile;
            private Object idcard;
            private Object sex;
            private int external;
            private int enabled;
            private Object leaved;
            private int deleted;
            private Object contactinfo;
            private Object email;
            private int admin;
            private Object sort;
            private Object remark;
            private Object pictureId;
            private Object roleset;
            private Object builtinrolelist;
            private Object pictureurl;
            private Object departmentnames;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getUsername() {
                return username;
            }

            public void setUsername(String username) {
                this.username = username;
            }

            public String getPassword() {
                return password;
            }

            public void setPassword(String password) {
                this.password = password;
            }

            public Object getEmployeeno() {
                return employeeno;
            }

            public void setEmployeeno(Object employeeno) {
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

            public Object getSex() {
                return sex;
            }

            public void setSex(Object sex) {
                this.sex = sex;
            }

            public int getExternal() {
                return external;
            }

            public void setExternal(int external) {
                this.external = external;
            }

            public int getEnabled() {
                return enabled;
            }

            public void setEnabled(int enabled) {
                this.enabled = enabled;
            }

            public Object getLeaved() {
                return leaved;
            }

            public void setLeaved(Object leaved) {
                this.leaved = leaved;
            }

            public int getDeleted() {
                return deleted;
            }

            public void setDeleted(int deleted) {
                this.deleted = deleted;
            }

            public Object getContactinfo() {
                return contactinfo;
            }

            public void setContactinfo(Object contactinfo) {
                this.contactinfo = contactinfo;
            }

            public Object getEmail() {
                return email;
            }

            public void setEmail(Object email) {
                this.email = email;
            }

            public int getAdmin() {
                return admin;
            }

            public void setAdmin(int admin) {
                this.admin = admin;
            }

            public Object getSort() {
                return sort;
            }

            public void setSort(Object sort) {
                this.sort = sort;
            }

            public Object getRemark() {
                return remark;
            }

            public void setRemark(Object remark) {
                this.remark = remark;
            }

            public Object getPictureId() {
                return pictureId;
            }

            public void setPictureId(Object pictureId) {
                this.pictureId = pictureId;
            }

            public Object getRoleset() {
                return roleset;
            }

            public void setRoleset(Object roleset) {
                this.roleset = roleset;
            }

            public Object getBuiltinrolelist() {
                return builtinrolelist;
            }

            public void setBuiltinrolelist(Object builtinrolelist) {
                this.builtinrolelist = builtinrolelist;
            }

            public Object getPictureurl() {
                return pictureurl;
            }

            public void setPictureurl(Object pictureurl) {
                this.pictureurl = pictureurl;
            }

            public Object getDepartmentnames() {
                return departmentnames;
            }

            public void setDepartmentnames(Object departmentnames) {
                this.departmentnames = departmentnames;
            }
        }

    }
}
