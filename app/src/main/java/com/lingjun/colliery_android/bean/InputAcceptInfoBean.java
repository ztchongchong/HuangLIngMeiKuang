package com.lingjun.colliery_android.bean;

import java.util.List;

/**
 * 作者: zengtao
 * 时间: 2019/7/29  15:18.
 * 注释:
 */
public class InputAcceptInfoBean {


    /**
     * msg : 成功
     * code : 200
     * data : {"acceptorInfo":{"id":249,"username":null,"password":"","employeeno":"01221137","name":"王红伟","mobile":"","registrationid":"100d85590968df53d3a","token":"a49ffda7-8e5f-4bb9-8dd7-53700f7c146f","idcard":"","sex":1,"external":0,"enabled":1,"leaved":0,"deleted":0,"contactinfo":null,"email":null,"admin":0,"sort":null,"remark":null,"pictureId":18825,"signatureId":11867,"roleset":"5/+87///7///Af8H","builtinrolelist":["SYSADMIN","SYSUSER","SYSTEM_USER","STDCHK_ADMIN","STDCHK_USER","STDCHK_HISTORY","STDCHK_ARCHIVE","STDCHK_PREDEFINE","STDCHK_USERMAN","STDCHK_END","STDFILE_ADMIN","STDFILE_USER","STDFILE_MAN","STDFILE_VERSION","TROUBLE_ADMIN","TROUBLE_USER","TROUBLE_MANAGER","TROUBLE_FATALMAN","TROUBLE_RANDOMCHECK","TROUBLE_CHECKHISTORY","TROUBLE_MANHISTORY","TROUBLE_ARCHIVE","TROUBLE_STDMAN","NOTICE_ADMIN","NOTICE_USER","NOTICE_END","DISOBEY_ADMIN","DISOBEY_USER","DISOBEY_MANHISTORY","DISOBEY_ARCHIVE","DISOBEY_STDMAN","DISOBEY_MANAGER","DISOBEY_CLOSE","DISOBEY_PARAMETER","DISOBEY_END","RISKCONTROL_ADMIN","RISKCONTROL_USER","RISKCONTROL_PLAN","RISKCONTROL_RISK","RISKCONTROL_PREDEFINE","RISKCONTROL_IMPLEMENT","RISKCONTROL_HISTORY","RISKCONTROL_ARCHIVE","RISKCONTROL_SOURCE","RISKCONTROL_RECORD","RISKCONTROL_END","ANALYSIS_ADMIN","ANALYSIS_USER","ANALYSIS_STDCHK_ALLCHECK","ANALYSIS_STDCHK_COUNT","ANALYSIS_STDCHK_SCORE","ANALYSIS_STDCHK_XIAOLV","ANALYSIS_STDCHK_RESULT","ANALYSIS_STDFILE_TYPE","ANALYSIS_STDFILE_ADD","ANALYSIS_STDFILE_DATE","ANALYSIS_TROUBLE_SOURCE","ANALYSIS_TROUBLE_GOVERN","ANALYSIS_TROUBLE_PROGRAMME","ANALYSIS_TROUBLE_DEPARTMENT","ANALYSIS_TROUBLE_DUIWU","ANALYSIS_DISOBEY_STANDARD","ANALYSIS_DISOBEY_DATE","ANALYSIS_DISOBEY_LIST","ANALYSIS_DISOBEY_DUIWU","ANALYSIS_DISOBEY_TUBIAO","STUDY_USER","STUDY_END","SYSTEM_CONFIGORG","ANALYSIS_STDCHK_MAIN","ANALYSIS_STDFILE_MAIN","ANALYSIS_TROUBLE_MAIN","ANALYSIS_DISOBEY_MAIN","ANALYSIS_RISKCONTROL_MAIN","ANALYSIS_MONITORSCREEN_MAIN","TROUBLE_PLAN","ORE_ANALYSIS"],"pictureurl":"/upload/1562580489610.jpg","signaturedurl":null,"catagoryIds":"{\"riskcontrolGK\":\"1,2,3,4,5,6,7,8\",\"riskcontrolFX\":\"1,2,3,4,5,6,7,8\",\"stdchk\":\"all,1,16,37,82,144,164,187,222,244,278,301\"}","departmentnames":"安全监察部","unitId":null,"studyappurl":""},"acceptDepartmentInfo":[{"id":642,"parentId":1,"name":"安全监察部","parentname":"综合管理部","deptno":null,"fullDeptno":null,"level":1,"remark":null,"deleted":0,"userlist":null,"departmentleader":null,"children":null,"roleset":null,"builtinrolelist":null}],"approverInfo":[{"id":null,"userId":249,"departmentId":642,"leader":1,"enabled":null,"dePartMentName":"安全监察部","userName":"王红伟","employeeno":null}]}
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
         * acceptorInfo : {"id":249,"username":null,"password":"","employeeno":"01221137","name":"王红伟","mobile":"","registrationid":"100d85590968df53d3a","token":"a49ffda7-8e5f-4bb9-8dd7-53700f7c146f","idcard":"","sex":1,"external":0,"enabled":1,"leaved":0,"deleted":0,"contactinfo":null,"email":null,"admin":0,"sort":null,"remark":null,"pictureId":18825,"signatureId":11867,"roleset":"5/+87///7///Af8H","builtinrolelist":["SYSADMIN","SYSUSER","SYSTEM_USER","STDCHK_ADMIN","STDCHK_USER","STDCHK_HISTORY","STDCHK_ARCHIVE","STDCHK_PREDEFINE","STDCHK_USERMAN","STDCHK_END","STDFILE_ADMIN","STDFILE_USER","STDFILE_MAN","STDFILE_VERSION","TROUBLE_ADMIN","TROUBLE_USER","TROUBLE_MANAGER","TROUBLE_FATALMAN","TROUBLE_RANDOMCHECK","TROUBLE_CHECKHISTORY","TROUBLE_MANHISTORY","TROUBLE_ARCHIVE","TROUBLE_STDMAN","NOTICE_ADMIN","NOTICE_USER","NOTICE_END","DISOBEY_ADMIN","DISOBEY_USER","DISOBEY_MANHISTORY","DISOBEY_ARCHIVE","DISOBEY_STDMAN","DISOBEY_MANAGER","DISOBEY_CLOSE","DISOBEY_PARAMETER","DISOBEY_END","RISKCONTROL_ADMIN","RISKCONTROL_USER","RISKCONTROL_PLAN","RISKCONTROL_RISK","RISKCONTROL_PREDEFINE","RISKCONTROL_IMPLEMENT","RISKCONTROL_HISTORY","RISKCONTROL_ARCHIVE","RISKCONTROL_SOURCE","RISKCONTROL_RECORD","RISKCONTROL_END","ANALYSIS_ADMIN","ANALYSIS_USER","ANALYSIS_STDCHK_ALLCHECK","ANALYSIS_STDCHK_COUNT","ANALYSIS_STDCHK_SCORE","ANALYSIS_STDCHK_XIAOLV","ANALYSIS_STDCHK_RESULT","ANALYSIS_STDFILE_TYPE","ANALYSIS_STDFILE_ADD","ANALYSIS_STDFILE_DATE","ANALYSIS_TROUBLE_SOURCE","ANALYSIS_TROUBLE_GOVERN","ANALYSIS_TROUBLE_PROGRAMME","ANALYSIS_TROUBLE_DEPARTMENT","ANALYSIS_TROUBLE_DUIWU","ANALYSIS_DISOBEY_STANDARD","ANALYSIS_DISOBEY_DATE","ANALYSIS_DISOBEY_LIST","ANALYSIS_DISOBEY_DUIWU","ANALYSIS_DISOBEY_TUBIAO","STUDY_USER","STUDY_END","SYSTEM_CONFIGORG","ANALYSIS_STDCHK_MAIN","ANALYSIS_STDFILE_MAIN","ANALYSIS_TROUBLE_MAIN","ANALYSIS_DISOBEY_MAIN","ANALYSIS_RISKCONTROL_MAIN","ANALYSIS_MONITORSCREEN_MAIN","TROUBLE_PLAN","ORE_ANALYSIS"],"pictureurl":"/upload/1562580489610.jpg","signaturedurl":null,"catagoryIds":"{\"riskcontrolGK\":\"1,2,3,4,5,6,7,8\",\"riskcontrolFX\":\"1,2,3,4,5,6,7,8\",\"stdchk\":\"all,1,16,37,82,144,164,187,222,244,278,301\"}","departmentnames":"安全监察部","unitId":null,"studyappurl":""}
         * acceptDepartmentInfo : [{"id":642,"parentId":1,"name":"安全监察部","parentname":"综合管理部","deptno":null,"fullDeptno":null,"level":1,"remark":null,"deleted":0,"userlist":null,"departmentleader":null,"children":null,"roleset":null,"builtinrolelist":null}]
         * approverInfo : [{"id":null,"userId":249,"departmentId":642,"leader":1,"enabled":null,"dePartMentName":"安全监察部","userName":"王红伟","employeeno":null}]
         */

        private AcceptorInfoBean acceptorInfo;
        private List<AcceptDepartmentInfoBean> acceptDepartmentInfo;
        private List<ApproverInfoBean> approverInfo;

        public AcceptorInfoBean getAcceptorInfo() {
            return acceptorInfo;
        }

        public void setAcceptorInfo(AcceptorInfoBean acceptorInfo) {
            this.acceptorInfo = acceptorInfo;
        }

        public List<AcceptDepartmentInfoBean> getAcceptDepartmentInfo() {
            return acceptDepartmentInfo;
        }

        public void setAcceptDepartmentInfo(List<AcceptDepartmentInfoBean> acceptDepartmentInfo) {
            this.acceptDepartmentInfo = acceptDepartmentInfo;
        }

        public List<ApproverInfoBean> getApproverInfo() {
            return approverInfo;
        }

        public void setApproverInfo(List<ApproverInfoBean> approverInfo) {
            this.approverInfo = approverInfo;
        }

        public static class AcceptorInfoBean {
            /**
             * id : 249
             * username : null
             * password :
             * employeeno : 01221137
             * name : 王红伟
             * mobile :
             * registrationid : 100d85590968df53d3a
             * token : a49ffda7-8e5f-4bb9-8dd7-53700f7c146f
             * idcard :
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
             * pictureId : 18825
             * signatureId : 11867
             * roleset : 5/+87///7///Af8H
             * builtinrolelist : ["SYSADMIN","SYSUSER","SYSTEM_USER","STDCHK_ADMIN","STDCHK_USER","STDCHK_HISTORY","STDCHK_ARCHIVE","STDCHK_PREDEFINE","STDCHK_USERMAN","STDCHK_END","STDFILE_ADMIN","STDFILE_USER","STDFILE_MAN","STDFILE_VERSION","TROUBLE_ADMIN","TROUBLE_USER","TROUBLE_MANAGER","TROUBLE_FATALMAN","TROUBLE_RANDOMCHECK","TROUBLE_CHECKHISTORY","TROUBLE_MANHISTORY","TROUBLE_ARCHIVE","TROUBLE_STDMAN","NOTICE_ADMIN","NOTICE_USER","NOTICE_END","DISOBEY_ADMIN","DISOBEY_USER","DISOBEY_MANHISTORY","DISOBEY_ARCHIVE","DISOBEY_STDMAN","DISOBEY_MANAGER","DISOBEY_CLOSE","DISOBEY_PARAMETER","DISOBEY_END","RISKCONTROL_ADMIN","RISKCONTROL_USER","RISKCONTROL_PLAN","RISKCONTROL_RISK","RISKCONTROL_PREDEFINE","RISKCONTROL_IMPLEMENT","RISKCONTROL_HISTORY","RISKCONTROL_ARCHIVE","RISKCONTROL_SOURCE","RISKCONTROL_RECORD","RISKCONTROL_END","ANALYSIS_ADMIN","ANALYSIS_USER","ANALYSIS_STDCHK_ALLCHECK","ANALYSIS_STDCHK_COUNT","ANALYSIS_STDCHK_SCORE","ANALYSIS_STDCHK_XIAOLV","ANALYSIS_STDCHK_RESULT","ANALYSIS_STDFILE_TYPE","ANALYSIS_STDFILE_ADD","ANALYSIS_STDFILE_DATE","ANALYSIS_TROUBLE_SOURCE","ANALYSIS_TROUBLE_GOVERN","ANALYSIS_TROUBLE_PROGRAMME","ANALYSIS_TROUBLE_DEPARTMENT","ANALYSIS_TROUBLE_DUIWU","ANALYSIS_DISOBEY_STANDARD","ANALYSIS_DISOBEY_DATE","ANALYSIS_DISOBEY_LIST","ANALYSIS_DISOBEY_DUIWU","ANALYSIS_DISOBEY_TUBIAO","STUDY_USER","STUDY_END","SYSTEM_CONFIGORG","ANALYSIS_STDCHK_MAIN","ANALYSIS_STDFILE_MAIN","ANALYSIS_TROUBLE_MAIN","ANALYSIS_DISOBEY_MAIN","ANALYSIS_RISKCONTROL_MAIN","ANALYSIS_MONITORSCREEN_MAIN","TROUBLE_PLAN","ORE_ANALYSIS"]
             * pictureurl : /upload/1562580489610.jpg
             * signaturedurl : null
             * catagoryIds : {"riskcontrolGK":"1,2,3,4,5,6,7,8","riskcontrolFX":"1,2,3,4,5,6,7,8","stdchk":"all,1,16,37,82,144,164,187,222,244,278,301"}
             * departmentnames : 安全监察部
             * unitId : null
             * studyappurl :
             */

            private int id;
            private Object username;
            private String password;
            private String employeeno;
            private String name;
            private String mobile;
            private String registrationid;
            private String token;
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
            private String roleset;
            private String pictureurl;
            private Object signaturedurl;
            private String catagoryIds;
            private String departmentnames;
            private Object unitId;
            private String studyappurl;
            private List<String> builtinrolelist;

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

            public String getRegistrationid() {
                return registrationid;
            }

            public void setRegistrationid(String registrationid) {
                this.registrationid = registrationid;
            }

            public String getToken() {
                return token;
            }

            public void setToken(String token) {
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

            public String getRoleset() {
                return roleset;
            }

            public void setRoleset(String roleset) {
                this.roleset = roleset;
            }

            public String getPictureurl() {
                return pictureurl;
            }

            public void setPictureurl(String pictureurl) {
                this.pictureurl = pictureurl;
            }

            public Object getSignaturedurl() {
                return signaturedurl;
            }

            public void setSignaturedurl(Object signaturedurl) {
                this.signaturedurl = signaturedurl;
            }

            public String getCatagoryIds() {
                return catagoryIds;
            }

            public void setCatagoryIds(String catagoryIds) {
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

            public List<String> getBuiltinrolelist() {
                return builtinrolelist;
            }

            public void setBuiltinrolelist(List<String> builtinrolelist) {
                this.builtinrolelist = builtinrolelist;
            }
        }

        public static class AcceptDepartmentInfoBean {
            /**
             * id : 642
             * parentId : 1
             * name : 安全监察部
             * parentname : 综合管理部
             * deptno : null
             * fullDeptno : null
             * level : 1
             * remark : null
             * deleted : 0
             * userlist : null
             * departmentleader : null
             * children : null
             * roleset : null
             * builtinrolelist : null
             */

            private int id;
            private int parentId;
            private String name;
            private String parentname;
            private Object deptno;
            private Object fullDeptno;
            private int level;
            private Object remark;
            private int deleted;
            private Object userlist;
            private Object departmentleader;
            private Object children;
            private Object roleset;
            private Object builtinrolelist;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getParentId() {
                return parentId;
            }

            public void setParentId(int parentId) {
                this.parentId = parentId;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getParentname() {
                return parentname;
            }

            public void setParentname(String parentname) {
                this.parentname = parentname;
            }

            public Object getDeptno() {
                return deptno;
            }

            public void setDeptno(Object deptno) {
                this.deptno = deptno;
            }

            public Object getFullDeptno() {
                return fullDeptno;
            }

            public void setFullDeptno(Object fullDeptno) {
                this.fullDeptno = fullDeptno;
            }

            public int getLevel() {
                return level;
            }

            public void setLevel(int level) {
                this.level = level;
            }

            public Object getRemark() {
                return remark;
            }

            public void setRemark(Object remark) {
                this.remark = remark;
            }

            public int getDeleted() {
                return deleted;
            }

            public void setDeleted(int deleted) {
                this.deleted = deleted;
            }

            public Object getUserlist() {
                return userlist;
            }

            public void setUserlist(Object userlist) {
                this.userlist = userlist;
            }

            public Object getDepartmentleader() {
                return departmentleader;
            }

            public void setDepartmentleader(Object departmentleader) {
                this.departmentleader = departmentleader;
            }

            public Object getChildren() {
                return children;
            }

            public void setChildren(Object children) {
                this.children = children;
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
        }

        public static class ApproverInfoBean {
            /**
             * id : null
             * userId : 249
             * departmentId : 642
             * leader : 1
             * enabled : null
             * dePartMentName : 安全监察部
             * userName : 王红伟
             * employeeno : null
             */

            private Object id;
            private int userId;
            private int departmentId;
            private int leader;
            private Object enabled;
            private String dePartMentName;
            private String userName;
            private Object employeeno;

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

            public Object getEmployeeno() {
                return employeeno;
            }

            public void setEmployeeno(Object employeeno) {
                this.employeeno = employeeno;
            }
        }
    }
}
