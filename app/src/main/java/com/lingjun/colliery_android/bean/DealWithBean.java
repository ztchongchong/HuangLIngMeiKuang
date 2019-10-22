package com.lingjun.colliery_android.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nefa on 2018/10/25.
 */

public class DealWithBean {


    /**
     * msg : 成功
     * data : {"page":{"totalRecord":4,"results":[{"taskTypeFlag":2,"description":"","title":"任务待办3","states":"9","id":8458,"times":"56分钟前","statesstr":"审阅中","tasktype":"标准化检查","descTime":"1540518900000"},{"taskTypeFlag":2,"description":"","title":"任务待办2","states":"7","id":8432,"times":"58分钟前","statesstr":"检查中","tasktype":"标准化检查","descTime":"1540518812000"},{"taskTypeFlag":2,"description":"","title":"任务待办1","states":"5","id":8414,"times":"59分钟前","statesstr":"分配中","tasktype":"标准化检查","descTime":"1540518753000"},{"taskTypeFlag":2,"description":"是的顶顶顶顶顶顶顶顶顶顶","title":"20181026测试","states":"2","id":7990,"times":"1小时前","statesstr":"审核中","tasktype":"标准化检查","descTime":"1540517808000"}],"pageSize":10,"dateFormat":"","totalPage":1,"pageNo":1,"params":{"taskType":"1","state":"2,5,7,9","deleted":"0","itemtask":"1","userid":95},"resultMaps":[]}}
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
         * page : {"totalRecord":4,"results":[{"taskTypeFlag":2,"description":"","title":"任务待办3","states":"9","id":8458,"times":"56分钟前","statesstr":"审阅中","tasktype":"标准化检查","descTime":"1540518900000"},{"taskTypeFlag":2,"description":"","title":"任务待办2","states":"7","id":8432,"times":"58分钟前","statesstr":"检查中","tasktype":"标准化检查","descTime":"1540518812000"},{"taskTypeFlag":2,"description":"","title":"任务待办1","states":"5","id":8414,"times":"59分钟前","statesstr":"分配中","tasktype":"标准化检查","descTime":"1540518753000"},{"taskTypeFlag":2,"description":"是的顶顶顶顶顶顶顶顶顶顶","title":"20181026测试","states":"2","id":7990,"times":"1小时前","statesstr":"审核中","tasktype":"标准化检查","descTime":"1540517808000"}],"pageSize":10,"dateFormat":"","totalPage":1,"pageNo":1,"params":{"taskType":"1","state":"2,5,7,9","deleted":"0","itemtask":"1","userid":95},"resultMaps":[]}
         */

        private PageBean page;

        public PageBean getPage() {
            return page;
        }

        public void setPage(PageBean page) {
            this.page = page;
        }

        public static class PageBean {
            /**
             * totalRecord : 4
             * results : [{"taskTypeFlag":2,"description":"","title":"任务待办3","states":"9","id":8458,"times":"56分钟前","statesstr":"审阅中","tasktype":"标准化检查","descTime":"1540518900000"},{"taskTypeFlag":2,"description":"","title":"任务待办2","states":"7","id":8432,"times":"58分钟前","statesstr":"检查中","tasktype":"标准化检查","descTime":"1540518812000"},{"taskTypeFlag":2,"description":"","title":"任务待办1","states":"5","id":8414,"times":"59分钟前","statesstr":"分配中","tasktype":"标准化检查","descTime":"1540518753000"},{"taskTypeFlag":2,"description":"是的顶顶顶顶顶顶顶顶顶顶","title":"20181026测试","states":"2","id":7990,"times":"1小时前","statesstr":"审核中","tasktype":"标准化检查","descTime":"1540517808000"}]
             * pageSize : 10
             * dateFormat :
             * totalPage : 1
             * pageNo : 1
             * params : {"taskType":"1","state":"2,5,7,9","deleted":"0","itemtask":"1","userid":95}
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
                 * taskType : 1
                 * state : 2,5,7,9
                 * deleted : 0
                 * itemtask : 1
                 * userid : 95
                 */

                private String taskType;
                private String state;
                private String deleted;
                private String itemtask;
                private int userid;

                public String getTaskType() {
                    return taskType;
                }

                public void setTaskType(String taskType) {
                    this.taskType = taskType;
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

                public String getItemtask() {
                    return itemtask;
                }

                public void setItemtask(String itemtask) {
                    this.itemtask = itemtask;
                }

                public int getUserid() {
                    return userid;
                }

                public void setUserid(int userid) {
                    this.userid = userid;
                }
            }

            public static class ResultsBean {
                /**
                 * taskTypeFlag : 2
                 * description :
                 * title : 任务待办3
                 * states : 9
                 * id : 8458
                 * times : 56分钟前
                 * statesstr : 审阅中
                 * tasktype : 标准化检查
                 * descTime : 1540518900000
                 */
                private int taskTypeFlag;
                private String description;
                private String title;
                private String states;
                private int id;
                private String times;
                private String statesstr;
                private String tasktype;
                private String descTime;
                private int mainTaskId;
                private String type;
                private String urls;
                private int taskSource;

                public int getMainTaskId() {
                    return mainTaskId;
                }

                public int getTaskSource() {
                    return taskSource;
                }

                public void setTaskSource(int taskSource) {
                    this.taskSource = taskSource;
                }

                public void setMainTaskId(int mainTaskId) {
                    this.mainTaskId = mainTaskId;
                }

                public String getType() {
                    return type;
                }

                public void setType(String type) {
                    this.type = type;
                }

                public String getUrls() {
                    return urls;
                }

                public void setUrls(String urls) {
                    this.urls = urls;
                }

                public int getTaskTypeFlag() {
                    return taskTypeFlag;
                }

                public void setTaskTypeFlag(int taskTypeFlag) {
                    this.taskTypeFlag = taskTypeFlag;
                }

                public String getDescription() {
                    return description;
                }

                public void setDescription(String description) {
                    this.description = description;
                }

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }

                public String getStates() {
                    return states;
                }

                public void setStates(String states) {
                    this.states = states;
                }

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getTimes() {
                    return times;
                }

                public void setTimes(String times) {
                    this.times = times;
                }

                public String getStatesstr() {
                    return statesstr;
                }

                public void setStatesstr(String statesstr) {
                    this.statesstr = statesstr;
                }

                public String getTasktype() {
                    return tasktype;
                }

                public void setTasktype(String tasktype) {
                    this.tasktype = tasktype;
                }

                public String getDescTime() {
                    return descTime;
                }

                public void setDescTime(String descTime) {
                    this.descTime = descTime;
                }
            }
        }
    }
}
