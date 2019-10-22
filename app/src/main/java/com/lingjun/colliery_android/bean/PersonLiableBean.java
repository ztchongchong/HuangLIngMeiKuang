package com.lingjun.colliery_android.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 作者: zengtao
 * 时间: 2019/4/25  17:23.
 * 注释:
 */
public class PersonLiableBean implements Serializable {


    /**
     * msg : 成功
     * data : {"page":{"totalRecord":10,"results":[{"employeeno":"01221360","id":29,"idcard":"","leader":0,"mobile":"","name":"传小军","sex":1,"userid":31},{"employeeno":"01221275","id":28,"idcard":"","leader":0,"mobile":"","name":"高金旗","sex":1,"userid":30},{"employeeno":"01221324","id":27,"idcard":"","leader":0,"mobile":"","name":"冯昆","sex":1,"userid":29},{"employeeno":"01221720","id":25,"idcard":"","leader":0,"mobile":"","name":"张大磊","sex":1,"userid":27},{"employeeno":"01221065","id":24,"idcard":"","leader":0,"mobile":"","name":"焦立民","sex":1,"userid":26},{"employeeno":"01030765","id":23,"idcard":"","leader":0,"mobile":"","name":"王卫云","sex":1,"userid":25},{"employeeno":"01050097","id":22,"idcard":"","leader":0,"mobile":"","name":"赵小龙","sex":1,"userid":24},{"employeeno":"01221068","id":21,"idcard":"","leader":0,"mobile":"","name":"杨黎明","sex":1,"userid":23},{"employeeno":"01221129","id":20,"idcard":"","leader":1,"mobile":"","name":"张建军","sex":1,"userid":22},{"employeeno":"01050047","id":760,"idcard":"","leader":0,"pictureId":11870,"mobile":"","name":"许保社","sex":1,"userid":13}],"pageSize":500,"dateFormat":"","totalPage":1,"pageNo":1,"params":{"searchstr":"","departmentid":"21"},"resultMaps":[]}}
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

    public static class DataBean implements Serializable {
        /**
         * page : {"totalRecord":10,"results":[{"employeeno":"01221360","id":29,"idcard":"","leader":0,"mobile":"","name":"传小军","sex":1,"userid":31,"pictureId":11870},{"employeeno":"01221275","id":28,"idcard":"","leader":0,"mobile":"","name":"高金旗","sex":1,"userid":30},{"employeeno":"01221324","id":27,"idcard":"","leader":0,"mobile":"","name":"冯昆","sex":1,"userid":29},{"employeeno":"01221720","id":25,"idcard":"","leader":0,"mobile":"","name":"张大磊","sex":1,"userid":27},{"employeeno":"01221065","id":24,"idcard":"","leader":0,"mobile":"","name":"焦立民","sex":1,"userid":26},{"employeeno":"01030765","id":23,"idcard":"","leader":0,"mobile":"","name":"王卫云","sex":1,"userid":25},{"employeeno":"01050097","id":22,"idcard":"","leader":0,"mobile":"","name":"赵小龙","sex":1,"userid":24},{"employeeno":"01221068","id":21,"idcard":"","leader":0,"mobile":"","name":"杨黎明","sex":1,"userid":23},{"employeeno":"01221129","id":20,"idcard":"","leader":1,"mobile":"","name":"张建军","sex":1,"userid":22},{"employeeno":"01050047","id":760,"idcard":"","leader":0,"pictureId":11870,"mobile":"","name":"许保社","sex":1,"userid":13}],"pageSize":500,"dateFormat":"","totalPage":1,"pageNo":1,"params":{"searchstr":"","departmentid":"21"},"resultMaps":[]}
         */

        private PageBean page;

        public PageBean getPage() {
            return page;
        }

        public void setPage(PageBean page) {
            this.page = page;
        }

        public static class PageBean implements Serializable {
            /**
             * totalRecord : 10
             * results : [{"employeeno":"01221360","id":29,"idcard":"","leader":0,"mobile":"","name":"传小军","sex":1,"userid":31},{"employeeno":"01221275","id":28,"idcard":"","leader":0,"mobile":"","name":"高金旗","sex":1,"userid":30},{"employeeno":"01221324","id":27,"idcard":"","leader":0,"mobile":"","name":"冯昆","sex":1,"userid":29},{"employeeno":"01221720","id":25,"idcard":"","leader":0,"mobile":"","name":"张大磊","sex":1,"userid":27},{"employeeno":"01221065","id":24,"idcard":"","leader":0,"mobile":"","name":"焦立民","sex":1,"userid":26},{"employeeno":"01030765","id":23,"idcard":"","leader":0,"mobile":"","name":"王卫云","sex":1,"userid":25},{"employeeno":"01050097","id":22,"idcard":"","leader":0,"mobile":"","name":"赵小龙","sex":1,"userid":24},{"employeeno":"01221068","id":21,"idcard":"","leader":0,"mobile":"","name":"杨黎明","sex":1,"userid":23},{"employeeno":"01221129","id":20,"idcard":"","leader":1,"mobile":"","name":"张建军","sex":1,"userid":22},{"employeeno":"01050047","id":760,"idcard":"","leader":0,"pictureId":11870,"mobile":"","name":"许保社","sex":1,"userid":13}]
             * pageSize : 500
             * dateFormat :
             * totalPage : 1
             * pageNo : 1
             * params : {"searchstr":"","departmentid":"21"}
             * resultMaps : []
             */

            private int totalRecord;
            private int pageSize;
            private String dateFormat;
            private int totalPage;
            private int pageNo;
            private ParamsBean params;
            private ArrayList<ResultsBean> results;
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

            public ArrayList<ResultsBean> getResults() {
                return results;
            }

            public void setResults(ArrayList<ResultsBean> results) {
                this.results = results;
            }

            public List<?> getResultMaps() {
                return resultMaps;
            }

            public void setResultMaps(List<?> resultMaps) {
                this.resultMaps = resultMaps;
            }

            public static class ParamsBean implements Serializable {
                /**
                 * searchstr :
                 * departmentid : 21
                 */

                private String searchstr;
                private String departmentid;

                public String getSearchstr() {
                    return searchstr;
                }

                public void setSearchstr(String searchstr) {
                    this.searchstr = searchstr;
                }

                public String getDepartmentid() {
                    return departmentid;
                }

                public void setDepartmentid(String departmentid) {
                    this.departmentid = departmentid;
                }
            }

            public static class ResultsBean implements Serializable {
                /**
                 * employeeno : 01221360
                 * id : 29
                 * idcard :
                 * leader : 0
                 * mobile :
                 * name : 传小军
                 * sex : 1
                 * userid : 31
                 * pictureId : 11870
                 */

                private String employeeno;
                private int id;
                private String idcard;
                private int leader;
                private String mobile;
                private String name;
                private int sex;
                private int userid;
                private int pictureId;

                public boolean isColour() {
                    return colour;
                }

                public void setColour(boolean colour) {
                    this.colour = colour;
                }

                private boolean colour=false;

                public boolean isType() {
                    return type;
                }

                public void setType(boolean type) {
                    this.type = type;
                }

                private boolean type = false;

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

                public String getIdcard() {
                    return idcard;
                }

                public void setIdcard(String idcard) {
                    this.idcard = idcard;
                }

                public int getLeader() {
                    return leader;
                }

                public void setLeader(int leader) {
                    this.leader = leader;
                }

                public String getMobile() {
                    return mobile;
                }

                public void setMobile(String mobile) {
                    this.mobile = mobile;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public int getSex() {
                    return sex;
                }

                public void setSex(int sex) {
                    this.sex = sex;
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
}
