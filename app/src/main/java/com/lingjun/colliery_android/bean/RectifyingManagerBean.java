package com.lingjun.colliery_android.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nefa on 2018/11/17.
 */

public class RectifyingManagerBean {

    /**
     * msg : 成功
     * code : 200
     * data : {"page":{"pageNo":1,"pageSize":10,"totalRecord":1,"totalPage":1,"results":[{"taskId":1679,"behavior":"非常不安全啊\n","canAppeal":"0","number":"201811170001","responsibleDepartmentScore":null,"responsibleDepartmentId":497,"responsibleDepartmentName":"机电车间","responsibleUserMoney":null,"responsibleUserId":498,"responsibleUserName":"机电车间","responsibleLeaderMoney":null,"responsibleLeaderId":502,"responsibleLeaderName":"惠军平","responsibleLeaderRemark":null,"approverId":39,"approverRemark":null,"appealType":null,"appealReason":null,"adminId":1326,"adminRemark":null,"startTime":1542446701000,"endTime":null,"flags":0,"state":"1","deleted":"0","approverName":null,"adminName":null,"user":{"id":498,"username":null,"password":null,"employeeno":"01010269","name":"罗小团","mobile":null,"idcard":null,"sex":1,"external":0,"enabled":1,"leaved":0,"deleted":0,"contactinfo":null,"email":null,"admin":0,"sort":null,"remark":null,"pictureId":null,"roleset":null,"builtinrolelist":null,"pictureurl":null,"catagoryIds":null,"departmentnames":"机电车间"},"extraType":null,"extraMoney":null,"name":null,"discovererId":0,"discovererName":null}],"params":{"processorid":1326,"searchstr":"","startTime":"","endTime":"","state":"1,2,3,4,5,6,7,8"},"resultMaps":[],"dateFormat":""},"url":"http://192.168.1.183:8888/safety/"}
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
         * page : {"pageNo":1,"pageSize":10,"totalRecord":1,"totalPage":1,"results":[{"taskId":1679,"behavior":"非常不安全啊\n","canAppeal":"0","number":"201811170001","responsibleDepartmentScore":null,"responsibleDepartmentId":497,"responsibleDepartmentName":"机电车间","responsibleUserMoney":null,"responsibleUserId":498,"responsibleUserName":"机电车间","responsibleLeaderMoney":null,"responsibleLeaderId":502,"responsibleLeaderName":"惠军平","responsibleLeaderRemark":null,"approverId":39,"approverRemark":null,"appealType":null,"appealReason":null,"adminId":1326,"adminRemark":null,"startTime":1542446701000,"endTime":null,"flags":0,"state":"1","deleted":"0","approverName":null,"adminName":null,"user":{"id":498,"username":null,"password":null,"employeeno":"01010269","name":"罗小团","mobile":null,"idcard":null,"sex":1,"external":0,"enabled":1,"leaved":0,"deleted":0,"contactinfo":null,"email":null,"admin":0,"sort":null,"remark":null,"pictureId":null,"roleset":null,"builtinrolelist":null,"pictureurl":null,"catagoryIds":null,"departmentnames":"机电车间"},"extraType":null,"extraMoney":null,"name":null,"discovererId":0,"discovererName":null}],"params":{"processorid":1326,"searchstr":"","startTime":"","endTime":"","state":"1,2,3,4,5,6,7,8"},"resultMaps":[],"dateFormat":""}
         * url : http://192.168.1.183:8888/safety/
         */

        private PageBean page;
        private String url;

        public PageBean getPage() {
            return page;
        }

        public void setPage(PageBean page) {
            this.page = page;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public static class PageBean {
            /**
             * pageNo : 1
             * pageSize : 10
             * totalRecord : 1
             * totalPage : 1
             * results : [{"taskId":1679,"behavior":"非常不安全啊\n","canAppeal":"0","number":"201811170001","responsibleDepartmentScore":null,"responsibleDepartmentId":497,"responsibleDepartmentName":"机电车间","responsibleUserMoney":null,"responsibleUserId":498,"responsibleUserName":"机电车间","responsibleLeaderMoney":null,"responsibleLeaderId":502,"responsibleLeaderName":"惠军平","responsibleLeaderRemark":null,"approverId":39,"approverRemark":null,"appealType":null,"appealReason":null,"adminId":1326,"adminRemark":null,"startTime":1542446701000,"endTime":null,"flags":0,"state":"1","deleted":"0","approverName":null,"adminName":null,"user":{"id":498,"username":null,"password":null,"employeeno":"01010269","name":"罗小团","mobile":null,"idcard":null,"sex":1,"external":0,"enabled":1,"leaved":0,"deleted":0,"contactinfo":null,"email":null,"admin":0,"sort":null,"remark":null,"pictureId":null,"roleset":null,"builtinrolelist":null,"pictureurl":null,"catagoryIds":null,"departmentnames":"机电车间"},"extraType":null,"extraMoney":null,"name":null,"discovererId":0,"discovererName":null}]
             * params : {"processorid":1326,"searchstr":"","startTime":"","endTime":"","state":"1,2,3,4,5,6,7,8"}
             * resultMaps : []
             * dateFormat :
             */

            private int pageNo;
            private int pageSize;
            private int totalRecord;
            private int totalPage;
            private ParamsBean params;
            private String dateFormat;
            private ArrayList<ResultsBean> results;
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
                 * processorid : 1326
                 * searchstr :
                 * startTime :
                 * endTime :
                 * state : 1,2,3,4,5,6,7,8
                 */

                private int processorid;
                private String searchstr;
                private String startTime;
                private String endTime;
                private String state;

                public int getProcessorid() {
                    return processorid;
                }

                public void setProcessorid(int processorid) {
                    this.processorid = processorid;
                }

                public String getSearchstr() {
                    return searchstr;
                }

                public void setSearchstr(String searchstr) {
                    this.searchstr = searchstr;
                }

                public String getStartTime() {
                    return startTime;
                }

                public void setStartTime(String startTime) {
                    this.startTime = startTime;
                }

                public String getEndTime() {
                    return endTime;
                }

                public void setEndTime(String endTime) {
                    this.endTime = endTime;
                }

                public String getState() {
                    return state;
                }

                public void setState(String state) {
                    this.state = state;
                }
            }

            public static class ResultsBean {
                /**
                 * taskId : 1679
                 * behavior : 非常不安全啊

                 * canAppeal : 0
                 * number : 201811170001
                 * responsibleDepartmentScore : null
                 * responsibleDepartmentId : 497
                 * responsibleDepartmentName : 机电车间
                 * responsibleUserMoney : null
                 * responsibleUserId : 498
                 * responsibleUserName : 机电车间
                 * responsibleLeaderMoney : null
                 * responsibleLeaderId : 502
                 * responsibleLeaderName : 惠军平
                 * responsibleLeaderRemark : null
                 * approverId : 39
                 * approverRemark : null
                 * appealType : null
                 * appealReason : null
                 * adminId : 1326
                 * adminRemark : null
                 * startTime : 1542446701000
                 * endTime : null
                 * flags : 0
                 * state : 1
                 * deleted : 0
                 * approverName : null
                 * adminName : null
                 * user : {"id":498,"username":null,"password":null,"employeeno":"01010269","name":"罗小团","mobile":null,"idcard":null,"sex":1,"external":0,"enabled":1,"leaved":0,"deleted":0,"contactinfo":null,"email":null,"admin":0,"sort":null,"remark":null,"pictureId":null,"roleset":null,"builtinrolelist":null,"pictureurl":null,"catagoryIds":null,"departmentnames":"机电车间"}
                 * extraType : null
                 * extraMoney : null
                 * name : null
                 * discovererId : 0
                 * discovererName : null
                 */

                private int taskId;
                private String behavior;
                private String canAppeal;
                private String number;
                private Object responsibleDepartmentScore;
                private int responsibleDepartmentId;
                private String responsibleDepartmentName;
                private Object responsibleUserMoney;
                private int responsibleUserId;
                private String responsibleUserName;
                private Object responsibleLeaderMoney;
                private String responsibleLeaderId;
                private String responsibleLeaderName;
                private Object responsibleLeaderRemark;
                private int approverId;

                public String getShowtime() {
                    return showtime;
                }

                public void setShowtime(String showtime) {
                    this.showtime = showtime;
                }

                private String showtime;
                private Object approverRemark;
                private Object appealType;
                private Object appealReason;
                private int adminId;
                private Object adminRemark;
                private String startTime;
                private Object endTime;
                private int flags;
                private String state;
                private String deleted;
                private Object approverName;
                private Object adminName;
                private UserBean user;
                private Object extraType;
                private Object extraMoney;
                private Object name;
                private int discovererId;
                private Object discovererName;

                public int getTaskId() {
                    return taskId;
                }

                public void setTaskId(int taskId) {
                    this.taskId = taskId;
                }

                public String getBehavior() {
                    return behavior;
                }

                public void setBehavior(String behavior) {
                    this.behavior = behavior;
                }

                public String getCanAppeal() {
                    return canAppeal;
                }

                public void setCanAppeal(String canAppeal) {
                    this.canAppeal = canAppeal;
                }

                public String getNumber() {
                    return number;
                }

                public void setNumber(String number) {
                    this.number = number;
                }

                public Object getResponsibleDepartmentScore() {
                    return responsibleDepartmentScore;
                }

                public void setResponsibleDepartmentScore(Object responsibleDepartmentScore) {
                    this.responsibleDepartmentScore = responsibleDepartmentScore;
                }

                public int getResponsibleDepartmentId() {
                    return responsibleDepartmentId;
                }

                public void setResponsibleDepartmentId(int responsibleDepartmentId) {
                    this.responsibleDepartmentId = responsibleDepartmentId;
                }

                public String getResponsibleDepartmentName() {
                    return responsibleDepartmentName;
                }

                public void setResponsibleDepartmentName(String responsibleDepartmentName) {
                    this.responsibleDepartmentName = responsibleDepartmentName;
                }

                public Object getResponsibleUserMoney() {
                    return responsibleUserMoney;
                }

                public void setResponsibleUserMoney(Object responsibleUserMoney) {
                    this.responsibleUserMoney = responsibleUserMoney;
                }

                public int getResponsibleUserId() {
                    return responsibleUserId;
                }

                public void setResponsibleUserId(int responsibleUserId) {
                    this.responsibleUserId = responsibleUserId;
                }

                public String getResponsibleUserName() {
                    return responsibleUserName;
                }

                public void setResponsibleUserName(String responsibleUserName) {
                    this.responsibleUserName = responsibleUserName;
                }

                public Object getResponsibleLeaderMoney() {
                    return responsibleLeaderMoney;
                }

                public void setResponsibleLeaderMoney(Object responsibleLeaderMoney) {
                    this.responsibleLeaderMoney = responsibleLeaderMoney;
                }

                public String getResponsibleLeaderId() {
                    return responsibleLeaderId;
                }

                public void setResponsibleLeaderId(String responsibleLeaderId) {
                    this.responsibleLeaderId = responsibleLeaderId;
                }

                public String getResponsibleLeaderName() {
                    return responsibleLeaderName;
                }

                public void setResponsibleLeaderName(String responsibleLeaderName) {
                    this.responsibleLeaderName = responsibleLeaderName;
                }

                public Object getResponsibleLeaderRemark() {
                    return responsibleLeaderRemark;
                }

                public void setResponsibleLeaderRemark(Object responsibleLeaderRemark) {
                    this.responsibleLeaderRemark = responsibleLeaderRemark;
                }

                public int getApproverId() {
                    return approverId;
                }

                public void setApproverId(int approverId) {
                    this.approverId = approverId;
                }

                public Object getApproverRemark() {
                    return approverRemark;
                }

                public void setApproverRemark(Object approverRemark) {
                    this.approverRemark = approverRemark;
                }

                public Object getAppealType() {
                    return appealType;
                }

                public void setAppealType(Object appealType) {
                    this.appealType = appealType;
                }

                public Object getAppealReason() {
                    return appealReason;
                }

                public void setAppealReason(Object appealReason) {
                    this.appealReason = appealReason;
                }

                public int getAdminId() {
                    return adminId;
                }

                public void setAdminId(int adminId) {
                    this.adminId = adminId;
                }

                public Object getAdminRemark() {
                    return adminRemark;
                }

                public void setAdminRemark(Object adminRemark) {
                    this.adminRemark = adminRemark;
                }

                public String getStartTime() {
                    return startTime;
                }

                public void setStartTime(String startTime) {
                    this.startTime = startTime;
                }

                public Object getEndTime() {
                    return endTime;
                }

                public void setEndTime(Object endTime) {
                    this.endTime = endTime;
                }

                public int getFlags() {
                    return flags;
                }

                public void setFlags(int flags) {
                    this.flags = flags;
                }

                public String getState() {
                    return state;
                }

                public void setState(String state) {
                    this.state = state;
                }

                public String getDeleted() {
                    return deleted;
                }

                public void setDeleted(String deleted) {
                    this.deleted = deleted;
                }

                public Object getApproverName() {
                    return approverName;
                }

                public void setApproverName(Object approverName) {
                    this.approverName = approverName;
                }

                public Object getAdminName() {
                    return adminName;
                }

                public void setAdminName(Object adminName) {
                    this.adminName = adminName;
                }

                public UserBean getUser() {
                    return user;
                }

                public void setUser(UserBean user) {
                    this.user = user;
                }

                public Object getExtraType() {
                    return extraType;
                }

                public void setExtraType(Object extraType) {
                    this.extraType = extraType;
                }

                public Object getExtraMoney() {
                    return extraMoney;
                }

                public void setExtraMoney(Object extraMoney) {
                    this.extraMoney = extraMoney;
                }

                public Object getName() {
                    return name;
                }

                public void setName(Object name) {
                    this.name = name;
                }

                public int getDiscovererId() {
                    return discovererId;
                }

                public void setDiscovererId(int discovererId) {
                    this.discovererId = discovererId;
                }

                public Object getDiscovererName() {
                    return discovererName;
                }

                public void setDiscovererName(Object discovererName) {
                    this.discovererName = discovererName;
                }

                public static class UserBean {
                    /**
                     * id : 498
                     * username : null
                     * password : null
                     * employeeno : 01010269
                     * name : 罗小团
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
                     * departmentnames : 机电车间
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
                    private String pictureurl;
                    private Object catagoryIds;
                    private String departmentnames;

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

                    public String getPictureurl() {
                        return pictureurl;
                    }

                    public void setPictureurl(String pictureurl) {
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
                }
            }
        }
    }
}
