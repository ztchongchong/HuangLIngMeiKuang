package com.lingjun.colliery_android.bean;

import java.io.Serializable;
import java.util.List;

/**
 * 作者: zengtao
 * 时间: 2019/4/29  14:31.
 * 注释: 三违领导
 */
public class DisobeyLeaderBean implements Serializable {

    /**
     * msg : 成功
     * data : {"list":{"totalRecord":20,"results":[{"employeeno":"01000231","idcard":"","mobile":"","leader":false,"name":"陈攀","roleset":"AAA4AAI=","picture_id":11832,"sex":1,"user_id":4},{"employeeno":"01221110","idcard":"","mobile":"","leader":false,"name":"单红民","roleset":"QAAAAAI=","sex":1,"user_id":17},{"employeeno":"01221097","idcard":"","mobile":"","leader":false,"name":"杜芳周","roleset":"wie4T55/","picture_id":5167,"sex":1,"user_id":10},{"employeeno":"01221111","idcard":"","mobile":"","leader":false,"name":"段有民","roleset":"wAc4AAI=","sex":1,"user_id":5},{"employeeno":"01221064","idcard":"","mobile":"","leader":false,"name":"高军","roleset":"wAe4T/7/77+977+9Pw==","sex":1,"user_id":18},{"employeeno":"01040010","idcard":"","mobile":"","leader":false,"name":"何刚","roleset":"QAA4AAI=","sex":1,"user_id":11},{"employeeno":"01221104","idcard":"","mobile":"","leader":true,"name":"李鸿武","roleset":"QACYAAI=","picture_id":3968,"sex":1,"user_id":2},{"employeeno":"01221109","idcard":"","mobile":"","leader":false,"name":"李俊","roleset":"QAA4AAI=","sex":1,"user_id":8},{"employeeno":"01010403","idcard":"","mobile":"","leader":false,"name":"李满平","roleset":"AAA4AO+/vQI=","sex":1,"user_id":12},{"employeeno":"01221019","idcard":"","mobile":"","leader":false,"name":"李伟辉","roleset":"QAC4AAIA77+977+9Hw==","sex":1,"user_id":19},{"employeeno":"01221122","idcard":"","mobile":"","leader":false,"name":"刘应军","roleset":"QAA4AAI=","sex":1,"user_id":7},{"employeeno":"01221043","idcard":"","mobile":"","leader":false,"name":"刘振记","roleset":"QAAAAO+/vQ4=","sex":1,"user_id":15},{"employeeno":"01221112","idcard":"","mobile":"","leader":false,"name":"强云","roleset":"wAc4AAI=","sex":1,"user_id":6},{"employeeno":"01221106","idcard":"","mobile":"","leader":false,"name":"史永民","roleset":"QAA4AAI=","sex":1,"user_id":3},{"employeeno":"01221113","idcard":"","mobile":"","leader":false,"name":"孙清平","roleset":"QAA4AAI=","sex":1,"user_id":9},{"employeeno":"01221089","idcard":"","mobile":"","leader":false,"name":"田滨涛","roleset":"QACIAAIA77+977+9Hw==","sex":1,"user_id":20},{"employeeno":"01221123","idcard":"","mobile":"","leader":false,"name":"王雷石","roleset":"QAA4AO+/vQ4=","sex":1,"user_id":16},{"employeeno":"01221048","idcard":"","mobile":"","leader":false,"name":"王增望","roleset":"QAC4AAIO7L+977+9Hw==","sex":1,"user_id":14},{"employeeno":"01050047","idcard":"","mobile":"","leader":false,"name":"许保社","roleset":"QAC4AAIO7L+977+9Hw==","picture_id":11870,"sex":1,"user_id":13},{"employeeno":"01221129","idcard":"","mobile":"","leader":false,"name":"张建军","roleset":"AAAY","sex":1,"user_id":22}],"pageSize":500,"dateFormat":"","totalPage":1,"pageNo":1,"params":{"searchstr":"","departmentid":"1","typeno":""},"resultMaps":[]}}
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
         * list : {"totalRecord":20,"results":[{"employeeno":"01000231","idcard":"","mobile":"","leader":false,"name":"陈攀","roleset":"AAA4AAI=","picture_id":11832,"sex":1,"user_id":4},{"employeeno":"01221110","idcard":"","mobile":"","leader":false,"name":"单红民","roleset":"QAAAAAI=","sex":1,"user_id":17},{"employeeno":"01221097","idcard":"","mobile":"","leader":false,"name":"杜芳周","roleset":"wie4T55/","picture_id":5167,"sex":1,"user_id":10},{"employeeno":"01221111","idcard":"","mobile":"","leader":false,"name":"段有民","roleset":"wAc4AAI=","sex":1,"user_id":5},{"employeeno":"01221064","idcard":"","mobile":"","leader":false,"name":"高军","roleset":"wAe4T/7/77+977+9Pw==","sex":1,"user_id":18},{"employeeno":"01040010","idcard":"","mobile":"","leader":false,"name":"何刚","roleset":"QAA4AAI=","sex":1,"user_id":11},{"employeeno":"01221104","idcard":"","mobile":"","leader":true,"name":"李鸿武","roleset":"QACYAAI=","picture_id":3968,"sex":1,"user_id":2},{"employeeno":"01221109","idcard":"","mobile":"","leader":false,"name":"李俊","roleset":"QAA4AAI=","sex":1,"user_id":8},{"employeeno":"01010403","idcard":"","mobile":"","leader":false,"name":"李满平","roleset":"AAA4AO+/vQI=","sex":1,"user_id":12},{"employeeno":"01221019","idcard":"","mobile":"","leader":false,"name":"李伟辉","roleset":"QAC4AAIA77+977+9Hw==","sex":1,"user_id":19},{"employeeno":"01221122","idcard":"","mobile":"","leader":false,"name":"刘应军","roleset":"QAA4AAI=","sex":1,"user_id":7},{"employeeno":"01221043","idcard":"","mobile":"","leader":false,"name":"刘振记","roleset":"QAAAAO+/vQ4=","sex":1,"user_id":15},{"employeeno":"01221112","idcard":"","mobile":"","leader":false,"name":"强云","roleset":"wAc4AAI=","sex":1,"user_id":6},{"employeeno":"01221106","idcard":"","mobile":"","leader":false,"name":"史永民","roleset":"QAA4AAI=","sex":1,"user_id":3},{"employeeno":"01221113","idcard":"","mobile":"","leader":false,"name":"孙清平","roleset":"QAA4AAI=","sex":1,"user_id":9},{"employeeno":"01221089","idcard":"","mobile":"","leader":false,"name":"田滨涛","roleset":"QACIAAIA77+977+9Hw==","sex":1,"user_id":20},{"employeeno":"01221123","idcard":"","mobile":"","leader":false,"name":"王雷石","roleset":"QAA4AO+/vQ4=","sex":1,"user_id":16},{"employeeno":"01221048","idcard":"","mobile":"","leader":false,"name":"王增望","roleset":"QAC4AAIO7L+977+9Hw==","sex":1,"user_id":14},{"employeeno":"01050047","idcard":"","mobile":"","leader":false,"name":"许保社","roleset":"QAC4AAIO7L+977+9Hw==","picture_id":11870,"sex":1,"user_id":13},{"employeeno":"01221129","idcard":"","mobile":"","leader":false,"name":"张建军","roleset":"AAAY","sex":1,"user_id":22}],"pageSize":500,"dateFormat":"","totalPage":1,"pageNo":1,"params":{"searchstr":"","departmentid":"1","typeno":""},"resultMaps":[]}
         */

        private ListBean list;

        public ListBean getList() {
            return list;
        }

        public void setList(ListBean list) {
            this.list = list;
        }

        public static class ListBean implements Serializable {
            /**
             * totalRecord : 20
             * results : [{"employeeno":"01000231","idcard":"","mobile":"","leader":false,"name":"陈攀","roleset":"AAA4AAI=","picture_id":11832,"sex":1,"user_id":4},{"employeeno":"01221110","idcard":"","mobile":"","leader":false,"name":"单红民","roleset":"QAAAAAI=","sex":1,"user_id":17},{"employeeno":"01221097","idcard":"","mobile":"","leader":false,"name":"杜芳周","roleset":"wie4T55/","picture_id":5167,"sex":1,"user_id":10},{"employeeno":"01221111","idcard":"","mobile":"","leader":false,"name":"段有民","roleset":"wAc4AAI=","sex":1,"user_id":5},{"employeeno":"01221064","idcard":"","mobile":"","leader":false,"name":"高军","roleset":"wAe4T/7/77+977+9Pw==","sex":1,"user_id":18},{"employeeno":"01040010","idcard":"","mobile":"","leader":false,"name":"何刚","roleset":"QAA4AAI=","sex":1,"user_id":11},{"employeeno":"01221104","idcard":"","mobile":"","leader":true,"name":"李鸿武","roleset":"QACYAAI=","picture_id":3968,"sex":1,"user_id":2},{"employeeno":"01221109","idcard":"","mobile":"","leader":false,"name":"李俊","roleset":"QAA4AAI=","sex":1,"user_id":8},{"employeeno":"01010403","idcard":"","mobile":"","leader":false,"name":"李满平","roleset":"AAA4AO+/vQI=","sex":1,"user_id":12},{"employeeno":"01221019","idcard":"","mobile":"","leader":false,"name":"李伟辉","roleset":"QAC4AAIA77+977+9Hw==","sex":1,"user_id":19},{"employeeno":"01221122","idcard":"","mobile":"","leader":false,"name":"刘应军","roleset":"QAA4AAI=","sex":1,"user_id":7},{"employeeno":"01221043","idcard":"","mobile":"","leader":false,"name":"刘振记","roleset":"QAAAAO+/vQ4=","sex":1,"user_id":15},{"employeeno":"01221112","idcard":"","mobile":"","leader":false,"name":"强云","roleset":"wAc4AAI=","sex":1,"user_id":6},{"employeeno":"01221106","idcard":"","mobile":"","leader":false,"name":"史永民","roleset":"QAA4AAI=","sex":1,"user_id":3},{"employeeno":"01221113","idcard":"","mobile":"","leader":false,"name":"孙清平","roleset":"QAA4AAI=","sex":1,"user_id":9},{"employeeno":"01221089","idcard":"","mobile":"","leader":false,"name":"田滨涛","roleset":"QACIAAIA77+977+9Hw==","sex":1,"user_id":20},{"employeeno":"01221123","idcard":"","mobile":"","leader":false,"name":"王雷石","roleset":"QAA4AO+/vQ4=","sex":1,"user_id":16},{"employeeno":"01221048","idcard":"","mobile":"","leader":false,"name":"王增望","roleset":"QAC4AAIO7L+977+9Hw==","sex":1,"user_id":14},{"employeeno":"01050047","idcard":"","mobile":"","leader":false,"name":"许保社","roleset":"QAC4AAIO7L+977+9Hw==","picture_id":11870,"sex":1,"user_id":13},{"employeeno":"01221129","idcard":"","mobile":"","leader":false,"name":"张建军","roleset":"AAAY","sex":1,"user_id":22}]
             * pageSize : 500
             * dateFormat :
             * totalPage : 1
             * pageNo : 1
             * params : {"searchstr":"","departmentid":"1","typeno":""}
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

            public static class ParamsBean implements Serializable {
                /**
                 * searchstr :
                 * departmentid : 1
                 * typeno :
                 */

                private String searchstr;
                private String departmentid;
                private String typeno;

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

                public String getTypeno() {
                    return typeno;
                }

                public void setTypeno(String typeno) {
                    this.typeno = typeno;
                }
            }

            public static class ResultsBean implements Serializable {
                /**
                 * employeeno : 01000231
                 * idcard :
                 * mobile :
                 * leader : false
                 * name : 陈攀
                 * roleset : AAA4AAI=
                 * picture_id : 11832
                 * sex : 1
                 * user_id : 4
                 */

                private String employeeno;
                private String idcard;
                private String mobile;
                private boolean leader;
                private String name;
                private String roleset;
                private int picture_id;
                private int sex;
                private int user_id;
                private boolean type =false;


                public boolean isType() {
                    return type;
                }

                public void setType(boolean type) {
                    this.type = type;
                }




                public String getEmployeeno() {
                    return employeeno;
                }

                public void setEmployeeno(String employeeno) {
                    this.employeeno = employeeno;
                }

                public String getIdcard() {
                    return idcard;
                }

                public void setIdcard(String idcard) {
                    this.idcard = idcard;
                }

                public String getMobile() {
                    return mobile;
                }

                public void setMobile(String mobile) {
                    this.mobile = mobile;
                }

                public boolean isLeader() {
                    return leader;
                }

                public void setLeader(boolean leader) {
                    this.leader = leader;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getRoleset() {
                    return roleset;
                }

                public void setRoleset(String roleset) {
                    this.roleset = roleset;
                }

                public int getPicture_id() {
                    return picture_id;
                }

                public void setPicture_id(int picture_id) {
                    this.picture_id = picture_id;
                }

                public int getSex() {
                    return sex;
                }

                public void setSex(int sex) {
                    this.sex = sex;
                }

                public int getUser_id() {
                    return user_id;
                }

                public void setUser_id(int user_id) {
                    this.user_id = user_id;
                }
            }
        }
    }
}
