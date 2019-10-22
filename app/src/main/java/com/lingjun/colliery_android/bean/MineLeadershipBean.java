package com.lingjun.colliery_android.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者: zengtao
 * 时间: 2019/7/2  10:26.
 * 注释: 矿领导
 */
public class MineLeadershipBean {


    /**
     * msg : 成功
     * data : {"userpage":{"totalRecord":33,"results":[{"employeeno":"41140015","id":0,"leader":1,"name":"岳东","registrationid":"13065ffa4e45f180ba4","sex":1,"userid":1},{"employeeno":"01050207","id":0,"leader":0,"name":"田战强","sex":1,"userid":2},{"employeeno":"01080007","id":0,"leader":0,"name":"张毅","sex":1,"userid":3},{"employeeno":"01080004","id":0,"leader":0,"name":"马铜生","registrationid":"100d85590968df53d3a","sex":1,"userid":4},{"employeeno":"01080005","id":0,"leader":0,"name":"马现卫","sex":1,"userid":5},{"employeeno":"01080006","id":0,"leader":0,"name":"刘余平","sex":1,"userid":6},{"employeeno":"01062344","id":0,"leader":0,"name":"寇义民","sex":1,"userid":7},{"employeeno":"01062347","id":0,"leader":0,"name":"罗东身","sex":1,"userid":9},{"employeeno":"01080013","id":0,"leader":0,"name":"张晓峰","sex":1,"userid":10},{"employeeno":"01080016","id":0,"leader":0,"name":"马小印","sex":1,"userid":11},{"employeeno":"01080014","id":0,"leader":0,"name":"吕和平","sex":1,"userid":12},{"employeeno":"01080017","id":0,"leader":0,"name":"柳铁军","registrationid":"18071adc03419488753","sex":1,"userid":13},{"employeeno":"09000002","id":0,"leader":0,"name":"万军","sex":1,"userid":14},{"employeeno":"09000006","id":0,"leader":0,"name":"刘跃章","sex":1,"userid":15},{"employeeno":"01080106","id":0,"leader":0,"name":"郭东涛","sex":1,"userid":16},{"employeeno":"01080242","id":0,"leader":0,"name":"唐建荣","registrationid":"18071adc03419488753","sex":1,"userid":17},{"employeeno":"01070142","id":0,"leader":0,"name":"史军涛","sex":1,"userid":161},{"employeeno":"01080052","id":0,"leader":0,"name":"王东武","sex":1,"userid":18},{"employeeno":"01080091","id":0,"leader":0,"name":"刘荣国","registrationid":"1507bfd3f7ec11e3da8","sex":1,"userid":67},{"employeeno":"01080019","id":0,"leader":0,"name":"李俊鹏","sex":1,"userid":1923},{"employeeno":"01050194","id":0,"leader":0,"name":"白军战","sex":1,"userid":1924},{"employeeno":"01080180","id":0,"leader":0,"name":"董昌宏","sex":1,"userid":1925},{"employeeno":"01080450","id":0,"leader":0,"name":"郝军强","sex":1,"userid":1926},{"employeeno":"01080020","id":0,"leader":0,"name":"张晓龙","sex":1,"userid":1927},{"employeeno":"01080023","id":0,"leader":0,"name":"刘鹏","sex":1,"userid":1929},{"employeeno":"01080024","id":0,"leader":0,"name":"延永国","sex":1,"userid":1930},{"employeeno":"01080025","id":0,"leader":0,"name":"陈晨","sex":1,"userid":1931},{"employeeno":"01080026","id":0,"leader":0,"name":"汤东子","sex":1,"userid":1932},{"employeeno":"01080087","id":0,"leader":0,"name":"亢晓静","sex":0,"userid":1934},{"employeeno":"01080022","id":0,"leader":0,"name":"张莲","sex":0,"userid":1935},{"employeeno":"01081124","id":0,"leader":0,"name":"黑国军","sex":1,"userid":1936},{"employeeno":"01081118","id":0,"leader":0,"name":"侯海涛","sex":1,"userid":1937},{"employeeno":"01081446","id":0,"leader":0,"name":"贺森","sex":1,"userid":1938}],"pageSize":500,"dateFormat":"","totalPage":1,"pageNo":1,"params":{"searchstr":"","departmentid":0,"typeno":""},"resultMaps":[]}}
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
         * userpage : {"totalRecord":33,"results":[{"employeeno":"41140015","id":0,"leader":1,"name":"岳东","registrationid":"13065ffa4e45f180ba4","sex":1,"userid":1},{"employeeno":"01050207","id":0,"leader":0,"name":"田战强","sex":1,"userid":2},{"employeeno":"01080007","id":0,"leader":0,"name":"张毅","sex":1,"userid":3},{"employeeno":"01080004","id":0,"leader":0,"name":"马铜生","registrationid":"100d85590968df53d3a","sex":1,"userid":4},{"employeeno":"01080005","id":0,"leader":0,"name":"马现卫","sex":1,"userid":5},{"employeeno":"01080006","id":0,"leader":0,"name":"刘余平","sex":1,"userid":6},{"employeeno":"01062344","id":0,"leader":0,"name":"寇义民","sex":1,"userid":7},{"employeeno":"01062347","id":0,"leader":0,"name":"罗东身","sex":1,"userid":9},{"employeeno":"01080013","id":0,"leader":0,"name":"张晓峰","sex":1,"userid":10},{"employeeno":"01080016","id":0,"leader":0,"name":"马小印","sex":1,"userid":11},{"employeeno":"01080014","id":0,"leader":0,"name":"吕和平","sex":1,"userid":12},{"employeeno":"01080017","id":0,"leader":0,"name":"柳铁军","registrationid":"18071adc03419488753","sex":1,"userid":13},{"employeeno":"09000002","id":0,"leader":0,"name":"万军","sex":1,"userid":14},{"employeeno":"09000006","id":0,"leader":0,"name":"刘跃章","sex":1,"userid":15},{"employeeno":"01080106","id":0,"leader":0,"name":"郭东涛","sex":1,"userid":16},{"employeeno":"01080242","id":0,"leader":0,"name":"唐建荣","registrationid":"18071adc03419488753","sex":1,"userid":17},{"employeeno":"01070142","id":0,"leader":0,"name":"史军涛","sex":1,"userid":161},{"employeeno":"01080052","id":0,"leader":0,"name":"王东武","sex":1,"userid":18},{"employeeno":"01080091","id":0,"leader":0,"name":"刘荣国","registrationid":"1507bfd3f7ec11e3da8","sex":1,"userid":67},{"employeeno":"01080019","id":0,"leader":0,"name":"李俊鹏","sex":1,"userid":1923},{"employeeno":"01050194","id":0,"leader":0,"name":"白军战","sex":1,"userid":1924},{"employeeno":"01080180","id":0,"leader":0,"name":"董昌宏","sex":1,"userid":1925},{"employeeno":"01080450","id":0,"leader":0,"name":"郝军强","sex":1,"userid":1926},{"employeeno":"01080020","id":0,"leader":0,"name":"张晓龙","sex":1,"userid":1927},{"employeeno":"01080023","id":0,"leader":0,"name":"刘鹏","sex":1,"userid":1929},{"employeeno":"01080024","id":0,"leader":0,"name":"延永国","sex":1,"userid":1930},{"employeeno":"01080025","id":0,"leader":0,"name":"陈晨","sex":1,"userid":1931},{"employeeno":"01080026","id":0,"leader":0,"name":"汤东子","sex":1,"userid":1932},{"employeeno":"01080087","id":0,"leader":0,"name":"亢晓静","sex":0,"userid":1934},{"employeeno":"01080022","id":0,"leader":0,"name":"张莲","sex":0,"userid":1935},{"employeeno":"01081124","id":0,"leader":0,"name":"黑国军","sex":1,"userid":1936},{"employeeno":"01081118","id":0,"leader":0,"name":"侯海涛","sex":1,"userid":1937},{"employeeno":"01081446","id":0,"leader":0,"name":"贺森","sex":1,"userid":1938}],"pageSize":500,"dateFormat":"","totalPage":1,"pageNo":1,"params":{"searchstr":"","departmentid":0,"typeno":""},"resultMaps":[]}
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
             * totalRecord : 33
             * results : [{"employeeno":"41140015","id":0,"leader":1,"name":"岳东","registrationid":"13065ffa4e45f180ba4","sex":1,"userid":1},{"employeeno":"01050207","id":0,"leader":0,"name":"田战强","sex":1,"userid":2},{"employeeno":"01080007","id":0,"leader":0,"name":"张毅","sex":1,"userid":3},{"employeeno":"01080004","id":0,"leader":0,"name":"马铜生","registrationid":"100d85590968df53d3a","sex":1,"userid":4},{"employeeno":"01080005","id":0,"leader":0,"name":"马现卫","sex":1,"userid":5},{"employeeno":"01080006","id":0,"leader":0,"name":"刘余平","sex":1,"userid":6},{"employeeno":"01062344","id":0,"leader":0,"name":"寇义民","sex":1,"userid":7},{"employeeno":"01062347","id":0,"leader":0,"name":"罗东身","sex":1,"userid":9},{"employeeno":"01080013","id":0,"leader":0,"name":"张晓峰","sex":1,"userid":10},{"employeeno":"01080016","id":0,"leader":0,"name":"马小印","sex":1,"userid":11},{"employeeno":"01080014","id":0,"leader":0,"name":"吕和平","sex":1,"userid":12},{"employeeno":"01080017","id":0,"leader":0,"name":"柳铁军","registrationid":"18071adc03419488753","sex":1,"userid":13},{"employeeno":"09000002","id":0,"leader":0,"name":"万军","sex":1,"userid":14},{"employeeno":"09000006","id":0,"leader":0,"name":"刘跃章","sex":1,"userid":15},{"employeeno":"01080106","id":0,"leader":0,"name":"郭东涛","sex":1,"userid":16},{"employeeno":"01080242","id":0,"leader":0,"name":"唐建荣","registrationid":"18071adc03419488753","sex":1,"userid":17},{"employeeno":"01070142","id":0,"leader":0,"name":"史军涛","sex":1,"userid":161},{"employeeno":"01080052","id":0,"leader":0,"name":"王东武","sex":1,"userid":18},{"employeeno":"01080091","id":0,"leader":0,"name":"刘荣国","registrationid":"1507bfd3f7ec11e3da8","sex":1,"userid":67},{"employeeno":"01080019","id":0,"leader":0,"name":"李俊鹏","sex":1,"userid":1923},{"employeeno":"01050194","id":0,"leader":0,"name":"白军战","sex":1,"userid":1924},{"employeeno":"01080180","id":0,"leader":0,"name":"董昌宏","sex":1,"userid":1925},{"employeeno":"01080450","id":0,"leader":0,"name":"郝军强","sex":1,"userid":1926},{"employeeno":"01080020","id":0,"leader":0,"name":"张晓龙","sex":1,"userid":1927},{"employeeno":"01080023","id":0,"leader":0,"name":"刘鹏","sex":1,"userid":1929},{"employeeno":"01080024","id":0,"leader":0,"name":"延永国","sex":1,"userid":1930},{"employeeno":"01080025","id":0,"leader":0,"name":"陈晨","sex":1,"userid":1931},{"employeeno":"01080026","id":0,"leader":0,"name":"汤东子","sex":1,"userid":1932},{"employeeno":"01080087","id":0,"leader":0,"name":"亢晓静","sex":0,"userid":1934},{"employeeno":"01080022","id":0,"leader":0,"name":"张莲","sex":0,"userid":1935},{"employeeno":"01081124","id":0,"leader":0,"name":"黑国军","sex":1,"userid":1936},{"employeeno":"01081118","id":0,"leader":0,"name":"侯海涛","sex":1,"userid":1937},{"employeeno":"01081446","id":0,"leader":0,"name":"贺森","sex":1,"userid":1938}]
             * pageSize : 500
             * dateFormat :
             * totalPage : 1
             * pageNo : 1
             * params : {"searchstr":"","departmentid":0,"typeno":""}
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

            public static class ParamsBean {
                /**
                 * searchstr :
                 * departmentid : 0
                 * typeno :
                 */

                private String searchstr;
                private int departmentid;
                private String typeno;

                public String getSearchstr() {
                    return searchstr;
                }

                public void setSearchstr(String searchstr) {
                    this.searchstr = searchstr;
                }

                public int getDepartmentid() {
                    return departmentid;
                }

                public void setDepartmentid(int departmentid) {
                    this.departmentid = departmentid;
                }

                public String getTypeno() {
                    return typeno;
                }

                public void setTypeno(String typeno) {
                    this.typeno = typeno;
                }
            }

            public static class ResultsBean {
                /**
                 * employeeno : 41140015
                 * id : 0
                 * leader : 1
                 * name : 岳东
                 * registrationid : 13065ffa4e45f180ba4
                 * sex : 1
                 * userid : 1
                 */

                private String employeeno;
                private int id;
                private int leader;
                private String name;
                private String registrationid;
                private int sex;
                private int userid;

                public boolean isType() {
                    return type;
                }

                public void setType(boolean type) {
                    this.type = type;
                }

                private boolean type;

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

                public int getLeader() {
                    return leader;
                }

                public void setLeader(int leader) {
                    this.leader = leader;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getRegistrationid() {
                    return registrationid;
                }

                public void setRegistrationid(String registrationid) {
                    this.registrationid = registrationid;
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
            }
        }
    }
}
