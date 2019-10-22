package com.lingjun.colliery_android.bean;

import java.util.List;

/**
 * 作者: zengtao
 * 时间: 2019/2/28  11:20.
 * 注释:
 */
public class LoanApplicationBean {


    /**
     * msg : 成功
     * code : 200
     * data : null
     * resultMaps : [{"taskType":"3","approverUserName":"孔德昊","approver_id":95,"taskstateFlag":"已同意","endTime":1551322308000,"state":"2","returnTime":1551322308000,"name":"资料名称"}]
     */

    private String msg;
    private String code;
    private Object data;
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

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public List<ResultMapsBean> getResultMaps() {
        return resultMaps;
    }

    public void setResultMaps(List<ResultMapsBean> resultMaps) {
        this.resultMaps = resultMaps;
    }

    public static class ResultMapsBean {
        /**
         * taskType : 3
         * approverUserName : 孔德昊
         * approver_id : 95
         * taskstateFlag : 已同意
         * endTime : 1551322308000
         * state : 2
         * returnTime : 1551322308000
         * name : 资料名称
         */

        private String taskType;
        private String approverUserName;
        private int approver_id;
        private String taskstateFlag;
        private long endTime;
        private String state;
        private long returnTime;
        private String name;

        public String getTaskType() {
            return taskType;
        }

        public void setTaskType(String taskType) {
            this.taskType = taskType;
        }

        public String getApproverUserName() {
            return approverUserName;
        }

        public void setApproverUserName(String approverUserName) {
            this.approverUserName = approverUserName;
        }

        public int getApprover_id() {
            return approver_id;
        }

        public void setApprover_id(int approver_id) {
            this.approver_id = approver_id;
        }

        public String getTaskstateFlag() {
            return taskstateFlag;
        }

        public void setTaskstateFlag(String taskstateFlag) {
            this.taskstateFlag = taskstateFlag;
        }

        public long getEndTime() {
            return endTime;
        }

        public void setEndTime(long endTime) {
            this.endTime = endTime;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public long getReturnTime() {
            return returnTime;
        }

        public void setReturnTime(long returnTime) {
            this.returnTime = returnTime;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
