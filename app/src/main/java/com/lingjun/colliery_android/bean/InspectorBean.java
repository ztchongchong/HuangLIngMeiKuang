package com.lingjun.colliery_android.bean;

import java.util.List;

/**
 * 作者: zengtao
 * 时间: 2019/7/11  14:13.
 * 注释: 三违检查人
 */
public class InspectorBean {

    /**
     * msg : 成功
     * data : {"userpage":{"totalRecord":751,"results":[{"idcard":"","token":"85d1f346-12c8-4cef-8bbf-ce6b9ff9cc1e","enabled":1,"external":0,"admin":0,"leaved":0,"employeeno":"01221684","id":783,"password":"","mobile":"","departmentnames":"实业公司","studyappurl":"","registrationid":"100d85590968df53d3a","name":"强欢欢","deleted":0,"sex":0},{"idcard":"","token":"d30cb212-beae-482f-b5d6-5e54a2cec31e","enabled":1,"external":0,"admin":0,"leaved":0,"employeeno":"01221192","id":782,"mobile":"","departmentnames":"实业公司","studyappurl":"","name":"马锦耀","deleted":0,"sex":1},{"idcard":"","enabled":1,"external":0,"admin":0,"leaved":0,"employeeno":"01221182","id":781,"mobile":"","departmentnames":"实业公司","studyappurl":"","name":"李洁","deleted":0,"sex":0},{"idcard":"","enabled":1,"external":0,"admin":0,"leaved":0,"employeeno":"01221042","id":780,"mobile":"","departmentnames":"实业公司","studyappurl":"","name":"陈静","deleted":0,"sex":0},{"idcard":"","enabled":1,"external":0,"admin":0,"leaved":0,"employeeno":"01221037","id":779,"mobile":"","departmentnames":"实业公司","studyappurl":"","name":"王淑云","deleted":0,"sex":0},{"idcard":"","enabled":1,"external":0,"admin":0,"leaved":0,"employeeno":"01221039","id":778,"mobile":"","departmentnames":"实业公司","studyappurl":"","name":"卢红军","deleted":0,"sex":1},{"idcard":"","enabled":1,"external":0,"admin":0,"leaved":0,"employeeno":"01221011","id":777,"mobile":"","departmentnames":"实业公司","studyappurl":"","name":"马耀东","deleted":0,"sex":1},{"idcard":"","enabled":1,"external":0,"admin":0,"leaved":0,"employeeno":"01221059","id":776,"mobile":"","departmentnames":"实业公司","studyappurl":"","name":"李鹏","deleted":0,"sex":1},{"idcard":"","token":"d51e5dce-4bee-4a2c-a73f-4e13e9ffc0e9","enabled":1,"external":0,"admin":0,"leaved":0,"employeeno":"01221006","id":775,"roleset":"AAAAAAAABA==","mobile":"","departmentnames":"实业公司","studyappurl":"","name":"高波","deleted":0,"sex":1},{"idcard":"","enabled":1,"external":0,"admin":0,"leaved":0,"employeeno":"01221040","id":774,"mobile":"","departmentnames":"实业公司","studyappurl":"","name":"王锁强","deleted":0,"sex":1}],"pageSize":10,"dateFormat":"","totalPage":76,"pageNo":1,"params":{"searchstr":""},"resultMaps":[]}}
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
        /**
         * userpage : {"totalRecord":751,"results":[{"idcard":"","token":"85d1f346-12c8-4cef-8bbf-ce6b9ff9cc1e","enabled":1,"external":0,"admin":0,"leaved":0,"employeeno":"01221684","id":783,"password":"","mobile":"","departmentnames":"实业公司","studyappurl":"","registrationid":"100d85590968df53d3a","name":"强欢欢","deleted":0,"sex":0,"roleset":"AAAAAAAABA=="},{"idcard":"","token":"d30cb212-beae-482f-b5d6-5e54a2cec31e","enabled":1,"external":0,"admin":0,"leaved":0,"employeeno":"01221192","id":782,"mobile":"","departmentnames":"实业公司","studyappurl":"","name":"马锦耀","deleted":0,"sex":1},{"idcard":"","enabled":1,"external":0,"admin":0,"leaved":0,"employeeno":"01221182","id":781,"mobile":"","departmentnames":"实业公司","studyappurl":"","name":"李洁","deleted":0,"sex":0},{"idcard":"","enabled":1,"external":0,"admin":0,"leaved":0,"employeeno":"01221042","id":780,"mobile":"","departmentnames":"实业公司","studyappurl":"","name":"陈静","deleted":0,"sex":0},{"idcard":"","enabled":1,"external":0,"admin":0,"leaved":0,"employeeno":"01221037","id":779,"mobile":"","departmentnames":"实业公司","studyappurl":"","name":"王淑云","deleted":0,"sex":0},{"idcard":"","enabled":1,"external":0,"admin":0,"leaved":0,"employeeno":"01221039","id":778,"mobile":"","departmentnames":"实业公司","studyappurl":"","name":"卢红军","deleted":0,"sex":1},{"idcard":"","enabled":1,"external":0,"admin":0,"leaved":0,"employeeno":"01221011","id":777,"mobile":"","departmentnames":"实业公司","studyappurl":"","name":"马耀东","deleted":0,"sex":1},{"idcard":"","enabled":1,"external":0,"admin":0,"leaved":0,"employeeno":"01221059","id":776,"mobile":"","departmentnames":"实业公司","studyappurl":"","name":"李鹏","deleted":0,"sex":1},{"idcard":"","token":"d51e5dce-4bee-4a2c-a73f-4e13e9ffc0e9","enabled":1,"external":0,"admin":0,"leaved":0,"employeeno":"01221006","id":775,"roleset":"AAAAAAAABA==","mobile":"","departmentnames":"实业公司","studyappurl":"","name":"高波","deleted":0,"sex":1},{"idcard":"","enabled":1,"external":0,"admin":0,"leaved":0,"employeeno":"01221040","id":774,"mobile":"","departmentnames":"实业公司","studyappurl":"","name":"王锁强","deleted":0,"sex":1}],"pageSize":10,"dateFormat":"","totalPage":76,"pageNo":1,"params":{"searchstr":""},"resultMaps":[]}
         */

        private UserpageBean userpage;

        public UserpageBean getUserpage() {
            return userpage;
        }

        public void setUserpage(UserpageBean userpage) {
            this.userpage = userpage;
        }

        public static class UserpageBean {
            /**
             * totalRecord : 751
             * results : [{"idcard":"","token":"85d1f346-12c8-4cef-8bbf-ce6b9ff9cc1e","enabled":1,"external":0,"admin":0,"leaved":0,"employeeno":"01221684","id":783,"password":"","mobile":"","departmentnames":"实业公司","studyappurl":"","registrationid":"100d85590968df53d3a","name":"强欢欢","deleted":0,"sex":0},{"idcard":"","token":"d30cb212-beae-482f-b5d6-5e54a2cec31e","enabled":1,"external":0,"admin":0,"leaved":0,"employeeno":"01221192","id":782,"mobile":"","departmentnames":"实业公司","studyappurl":"","name":"马锦耀","deleted":0,"sex":1},{"idcard":"","enabled":1,"external":0,"admin":0,"leaved":0,"employeeno":"01221182","id":781,"mobile":"","departmentnames":"实业公司","studyappurl":"","name":"李洁","deleted":0,"sex":0},{"idcard":"","enabled":1,"external":0,"admin":0,"leaved":0,"employeeno":"01221042","id":780,"mobile":"","departmentnames":"实业公司","studyappurl":"","name":"陈静","deleted":0,"sex":0},{"idcard":"","enabled":1,"external":0,"admin":0,"leaved":0,"employeeno":"01221037","id":779,"mobile":"","departmentnames":"实业公司","studyappurl":"","name":"王淑云","deleted":0,"sex":0},{"idcard":"","enabled":1,"external":0,"admin":0,"leaved":0,"employeeno":"01221039","id":778,"mobile":"","departmentnames":"实业公司","studyappurl":"","name":"卢红军","deleted":0,"sex":1},{"idcard":"","enabled":1,"external":0,"admin":0,"leaved":0,"employeeno":"01221011","id":777,"mobile":"","departmentnames":"实业公司","studyappurl":"","name":"马耀东","deleted":0,"sex":1},{"idcard":"","enabled":1,"external":0,"admin":0,"leaved":0,"employeeno":"01221059","id":776,"mobile":"","departmentnames":"实业公司","studyappurl":"","name":"李鹏","deleted":0,"sex":1},{"idcard":"","token":"d51e5dce-4bee-4a2c-a73f-4e13e9ffc0e9","enabled":1,"external":0,"admin":0,"leaved":0,"employeeno":"01221006","id":775,"roleset":"AAAAAAAABA==","mobile":"","departmentnames":"实业公司","studyappurl":"","name":"高波","deleted":0,"sex":1},{"idcard":"","enabled":1,"external":0,"admin":0,"leaved":0,"employeeno":"01221040","id":774,"mobile":"","departmentnames":"实业公司","studyappurl":"","name":"王锁强","deleted":0,"sex":1}]
             * pageSize : 10
             * dateFormat :
             * totalPage : 76
             * pageNo : 1
             * params : {"searchstr":""}
             * resultMaps : []
             */

            private int totalRecord;
            private int pageSize;
            private String dateFormat;
            private int totalPage;
            private int pageNo;
            private ParamsBean params;
            private List<ResultsBean> results;
            private List<?> resultMaps;

            public int getTotalRecord() {
                return totalRecord;
            }

            public void setTotalRecord(int totalRecord) {
                this.totalRecord = totalRecord;
            }

            public int getPageSize() {
                return pageSize;
            }

            public void setPageSize(int pageSize) {
                this.pageSize = pageSize;
            }

            public String getDateFormat() {
                return dateFormat;
            }

            public void setDateFormat(String dateFormat) {
                this.dateFormat = dateFormat;
            }

            public int getTotalPage() {
                return totalPage;
            }

            public void setTotalPage(int totalPage) {
                this.totalPage = totalPage;
            }

            public int getPageNo() {
                return pageNo;
            }

            public void setPageNo(int pageNo) {
                this.pageNo = pageNo;
            }

            public ParamsBean getParams() {
                return params;
            }

            public void setParams(ParamsBean params) {
                this.params = params;
            }

            public List<ResultsBean> getResults() {
                return results;
            }

            public void setResults(List<ResultsBean> results) {
                this.results = results;
            }

            public List<?> getResultMaps() {
                return resultMaps;
            }

            public void setResultMaps(List<?> resultMaps) {
                this.resultMaps = resultMaps;
            }

            public static class ParamsBean {
                /**
                 * searchstr :
                 */

                private String searchstr;

                public String getSearchstr() {
                    return searchstr;
                }

                public void setSearchstr(String searchstr) {
                    this.searchstr = searchstr;
                }
            }

            public static class ResultsBean {
                /**
                 * idcard :
                 * token : 85d1f346-12c8-4cef-8bbf-ce6b9ff9cc1e
                 * enabled : 1
                 * external : 0
                 * admin : 0
                 * leaved : 0
                 * employeeno : 01221684
                 * id : 783
                 * password :
                 * mobile :
                 * departmentnames : 实业公司
                 * studyappurl :
                 * registrationid : 100d85590968df53d3a
                 * name : 强欢欢
                 * deleted : 0
                 * sex : 0
                 * roleset : AAAAAAAABA==
                 */

                private String idcard;
                private String token;
                private int enabled;
                private int external;
                private int admin;
                private int leaved;
                private String employeeno;
                private int id;
                private String password;
                private String mobile;
                private String departmentnames;
                private String studyappurl;
                private String registrationid;
                private String name;
                private int deleted;
                private int sex;
                private String roleset;

                public String getIdcard() {
                    return idcard;
                }

                public void setIdcard(String idcard) {
                    this.idcard = idcard;
                }

                public String getToken() {
                    return token;
                }

                public void setToken(String token) {
                    this.token = token;
                }

                public int getEnabled() {
                    return enabled;
                }

                public void setEnabled(int enabled) {
                    this.enabled = enabled;
                }

                public int getExternal() {
                    return external;
                }

                public void setExternal(int external) {
                    this.external = external;
                }

                public int getAdmin() {
                    return admin;
                }

                public void setAdmin(int admin) {
                    this.admin = admin;
                }

                public int getLeaved() {
                    return leaved;
                }

                public void setLeaved(int leaved) {
                    this.leaved = leaved;
                }

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

                public String getPassword() {
                    return password;
                }

                public void setPassword(String password) {
                    this.password = password;
                }

                public String getMobile() {
                    return mobile;
                }

                public void setMobile(String mobile) {
                    this.mobile = mobile;
                }

                public String getDepartmentnames() {
                    return departmentnames;
                }

                public void setDepartmentnames(String departmentnames) {
                    this.departmentnames = departmentnames;
                }

                public String getStudyappurl() {
                    return studyappurl;
                }

                public void setStudyappurl(String studyappurl) {
                    this.studyappurl = studyappurl;
                }

                public String getRegistrationid() {
                    return registrationid;
                }

                public void setRegistrationid(String registrationid) {
                    this.registrationid = registrationid;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public int getDeleted() {
                    return deleted;
                }

                public void setDeleted(int deleted) {
                    this.deleted = deleted;
                }

                public int getSex() {
                    return sex;
                }

                public void setSex(int sex) {
                    this.sex = sex;
                }

                public String getRoleset() {
                    return roleset;
                }

                public void setRoleset(String roleset) {
                    this.roleset = roleset;
                }
            }
        }
    }
}
