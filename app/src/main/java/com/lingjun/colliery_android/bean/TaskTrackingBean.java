package com.lingjun.colliery_android.bean;

import java.util.List;

/**
 * 作者: zengtao
 * 时间: 2019/2/15  17:17.
 * 注释: 任务跟踪 列表
 */
public class TaskTrackingBean {

    /**
     * msg : 成功
     * code : 200
     * data : {"pageCount":20,"count":115,"pageSize":6,"pageNum":1}
     * resultMaps : [{"taskType":"3","description":"滚","taskstateFlag":"待处理","state":"1","id":8226,"approveName":null,"title":"借阅申请"}]
     */

    private String msg;
    private String code;
    private DataBean data;
    private List<ResultMapsBean> resultMaps;

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

    public List<ResultMapsBean> getResultMaps() {
        return resultMaps;
    }

    public void setResultMaps(List<ResultMapsBean> resultMaps) {
        this.resultMaps = resultMaps;
    }

    public static class DataBean {
        /**
         * pageCount : 20
         * count : 115
         * pageSize : 6
         * pageNum : 1
         */

        private int pageCount;
        private int count;
        private int pageSize;
        private int pageNum;

        public int getPageCount() {
            return pageCount;
        }

        public void setPageCount(int pageCount) {
            this.pageCount = pageCount;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public int getPageSize() {
            return pageSize;
        }

        public void setPageSize(int pageSize) {
            this.pageSize = pageSize;
        }

        public int getPageNum() {
            return pageNum;
        }

        public void setPageNum(int pageNum) {
            this.pageNum = pageNum;
        }
    }

    public static class ResultMapsBean {
        /**
         * taskType : 3
         * description : 滚
         * taskstateFlag : 待处理
         * state : 1
         * id : 8226
         * approveName : null
         * title : 借阅申请
         */

        private String taskType;
        private String description;
        private String taskstateFlag;
        private String state;
        private int id;
        private Object approveName;
        private String title;

        public String getTaskType() {
            return taskType;
        }

        public void setTaskType(String taskType) {
            this.taskType = taskType;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getTaskstateFlag() {
            return taskstateFlag;
        }

        public void setTaskstateFlag(String taskstateFlag) {
            this.taskstateFlag = taskstateFlag;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public Object getApproveName() {
            return approveName;
        }

        public void setApproveName(Object approveName) {
            this.approveName = approveName;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }
}
