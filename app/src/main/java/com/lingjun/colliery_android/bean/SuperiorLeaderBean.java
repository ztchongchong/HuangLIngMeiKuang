package com.lingjun.colliery_android.bean;

import java.util.List;

/**
 * 作者: zengtao
 * 时间: 2019/6/4  19:34.
 * 注释:
 */
public class SuperiorLeaderBean {

    /**
     * msg : 成功
     * code : 200
     * data : {"userpage":{"pageNo":1,"pageSize":9,"totalRecord":33,"totalPage":4,"results":[{"userid":1,"name":"岳东"}],"params":{"searchstr":null,"departmentid":1867,"pageSize":9,"page":1},"resultMaps":[],"dateFormat":""}}
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
         * userpage : {"pageNo":1,"pageSize":9,"totalRecord":33,"totalPage":4,"results":[{"userid":1,"name":"岳东"}],"params":{"searchstr":null,"departmentid":1867,"pageSize":9,"page":1},"resultMaps":[],"dateFormat":""}
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
             * pageNo : 1
             * pageSize : 9
             * totalRecord : 33
             * totalPage : 4
             * results : [{"userid":1,"name":"岳东"}]
             * params : {"searchstr":null,"departmentid":1867,"pageSize":9,"page":1}
             * resultMaps : []
             * dateFormat :
             */

            private int pageNo;
            private int pageSize;
            private int totalRecord;
            private int totalPage;
            private ParamsBean params;
            private String dateFormat;
            private List<ResultsBean> results;
            private List<?> resultMaps;

            public int getPageNo() {
                return pageNo;
            }

            public void setPageNo(int pageNo) {
                this.pageNo = pageNo;
            }

            public int getPageSize() {
                return pageSize;
            }

            public void setPageSize(int pageSize) {
                this.pageSize = pageSize;
            }

            public int getTotalRecord() {
                return totalRecord;
            }

            public void setTotalRecord(int totalRecord) {
                this.totalRecord = totalRecord;
            }

            public int getTotalPage() {
                return totalPage;
            }

            public void setTotalPage(int totalPage) {
                this.totalPage = totalPage;
            }

            public ParamsBean getParams() {
                return params;
            }

            public void setParams(ParamsBean params) {
                this.params = params;
            }

            public String getDateFormat() {
                return dateFormat;
            }

            public void setDateFormat(String dateFormat) {
                this.dateFormat = dateFormat;
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
                 * searchstr : null
                 * departmentid : 1867
                 * pageSize : 9
                 * page : 1
                 */

                private Object searchstr;
                private int departmentid;
                private int pageSize;
                private int page;

                public Object getSearchstr() {
                    return searchstr;
                }

                public void setSearchstr(Object searchstr) {
                    this.searchstr = searchstr;
                }

                public int getDepartmentid() {
                    return departmentid;
                }

                public void setDepartmentid(int departmentid) {
                    this.departmentid = departmentid;
                }

                public int getPageSize() {
                    return pageSize;
                }

                public void setPageSize(int pageSize) {
                    this.pageSize = pageSize;
                }

                public int getPage() {
                    return page;
                }

                public void setPage(int page) {
                    this.page = page;
                }
            }

            public static class ResultsBean {
                /**
                 * userid : 1
                 * name : 岳东
                 */

                private int userid;
                private String name;

                public int getUserid() {
                    return userid;
                }

                public void setUserid(int userid) {
                    this.userid = userid;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }
            }
        }
    }
}
