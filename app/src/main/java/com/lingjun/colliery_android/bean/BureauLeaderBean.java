package com.lingjun.colliery_android.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者: zengtao
 * 时间: 2019/5/25  16:53.
 * 注释: 局领导
 */
public class BureauLeaderBean {


    /**
     * msg : 请求成功！
     * code : 200
     * data : {"totalRecord":2196,"results":[{"id":2252,"username":null,"password":"","employeeno":"01082174","name":"闫海琴","mobile":"","registrationid":null,"token":null,"idcard":"","sex":0,"external":0,"enabled":1,"leaved":0,"deleted":0,"contactinfo":null,"email":null,"admin":0,"sort":null,"remark":null,"pictureId":4737,"signatureId":4740,"roleset":null,"builtinrolelist":null,"pictureurl":null,"signaturedurl":null,"catagoryIds":null,"departmentnames":"招待所","unitId":null,"studyappurl":""},{"id":2251,"username":null,"password":"","employeeno":"01082180","name":"刘建斌","mobile":null,"registrationid":null,"token":null,"idcard":null,"sex":1,"external":0,"enabled":1,"leaved":0,"deleted":0,"contactinfo":null,"email":null,"admin":0,"sort":null,"remark":null,"pictureId":null,"signatureId":0,"roleset":null,"builtinrolelist":null,"pictureurl":null,"signaturedurl":null,"catagoryIds":null,"departmentnames":"物业公司","unitId":null,"studyappurl":""}]}
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
         * totalRecord : 2196
         * results : [{"id":2252,"username":null,"password":"","employeeno":"01082174","name":"闫海琴","mobile":"","registrationid":null,"token":null,"idcard":"","sex":0,"external":0,"enabled":1,"leaved":0,"deleted":0,"contactinfo":null,"email":null,"admin":0,"sort":null,"remark":null,"pictureId":4737,"signatureId":4740,"roleset":null,"builtinrolelist":null,"pictureurl":null,"signaturedurl":null,"catagoryIds":null,"departmentnames":"招待所","unitId":null,"studyappurl":""},{"id":2251,"username":null,"password":"","employeeno":"01082180","name":"刘建斌","mobile":null,"registrationid":null,"token":null,"idcard":null,"sex":1,"external":0,"enabled":1,"leaved":0,"deleted":0,"contactinfo":null,"email":null,"admin":0,"sort":null,"remark":null,"pictureId":null,"signatureId":0,"roleset":null,"builtinrolelist":null,"pictureurl":null,"signaturedurl":null,"catagoryIds":null,"departmentnames":"物业公司","unitId":null,"studyappurl":""}]
         */

        private int totalRecord;
        private ArrayList<ResultsBean> results;

        public int getTotalRecord() {
            return totalRecord;
        }

        public void setTotalRecord(int totalRecord) {
            this.totalRecord = totalRecord;
        }

        public ArrayList<ResultsBean> getResults() {
            return results;
        }

        public void setResults(ArrayList<ResultsBean> results) {
            this.results = results;
        }

        public static class ResultsBean {
            /**
             * id : 2252
             * username : null
             * password :
             * employeeno : 01082174
             * name : 闫海琴
             * mobile :
             * registrationid : null
             * token : null
             * idcard :
             * sex : 0
             * external : 0
             * enabled : 1
             * leaved : 0
             * deleted : 0
             * contactinfo : null
             * email : null
             * admin : 0
             * sort : null
             * remark : null
             * pictureId : 4737
             * signatureId : 4740
             * roleset : null
             * builtinrolelist : null
             * pictureurl : null
             * signaturedurl : null
             * catagoryIds : null
             * departmentnames : 招待所
             * unitId : null
             * studyappurl :
             */

            private int id;
            private Object username;
            private String password;
            private String employeeno;
            private String name;
            private String mobile;
            private Object registrationid;
            private Object token;
            private String idcard;
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
            private int pictureId;
            private int signatureId;
            private Object roleset;
            private Object builtinrolelist;
            private Object pictureurl;
            private Object signaturedurl;
            private Object catagoryIds;
            private String departmentnames;
            private Object unitId;
            private String studyappurl;

            public boolean isType() {
                return type;
            }

            public void setType(boolean type) {
                this.type = type;
            }

            private boolean type;

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

            public String getMobile() {
                return mobile;
            }

            public void setMobile(String mobile) {
                this.mobile = mobile;
            }

            public Object getRegistrationid() {
                return registrationid;
            }

            public void setRegistrationid(Object registrationid) {
                this.registrationid = registrationid;
            }

            public Object getToken() {
                return token;
            }

            public void setToken(Object token) {
                this.token = token;
            }

            public String getIdcard() {
                return idcard;
            }

            public void setIdcard(String idcard) {
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

            public int getPictureId() {
                return pictureId;
            }

            public void setPictureId(int pictureId) {
                this.pictureId = pictureId;
            }

            public int getSignatureId() {
                return signatureId;
            }

            public void setSignatureId(int signatureId) {
                this.signatureId = signatureId;
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

            public Object getSignaturedurl() {
                return signaturedurl;
            }

            public void setSignaturedurl(Object signaturedurl) {
                this.signaturedurl = signaturedurl;
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
    }
}
