package com.lingjun.colliery_android.bean;

import java.io.Serializable;
import java.util.List;

public class SubmissionBena implements Serializable {


    /**
     * location : 陕西1
     * planId : 1
     * areaId : 1
     * areaName : 巷道
     * taskStatus : 1
     * clauseId : 1
     * clauseDesc : 隐患标准描述
     * addTime : 1526004599000
     * childTask : [{"sourceprocessorId":"1","sourceId":"1","sourceFolder":"4","sourceDesc":"隐患任务描述","sourceMoney":"300","sourceScore":"10","troubleContent":"子隐患相关描述","fileIds":"605"}]
     */

    private String location;
    private String planId;
    private String areaId;
    private String areaName;
    private String taskStatus;
    private String clauseId;
    private String clauseDesc;
    private String addTime;
    private List<ChildTaskBean> childTask;

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPlanId() {
        return planId;
    }

    public void setPlanId(String planId) {
        this.planId = planId;
    }

    public String getAreaId() {
        return areaId;
    }

    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(String taskStatus) {
        this.taskStatus = taskStatus;
    }

    public String getClauseId() {
        return clauseId;
    }

    public void setClauseId(String clauseId) {
        this.clauseId = clauseId;
    }

    public String getClauseDesc() {
        return clauseDesc;
    }

    public void setClauseDesc(String clauseDesc) {
        this.clauseDesc = clauseDesc;
    }

    public String getAddTime() {
        return addTime;
    }

    public void setAddTime(String addTime) {
        this.addTime = addTime;
    }

    public List<ChildTaskBean> getChildTask() {
        return childTask;
    }

    public void setChildTask(List<ChildTaskBean> childTask) {
        this.childTask = childTask;
    }

    public static class ChildTaskBean {
        /**
         * sourceprocessorId : 1
         * sourceId : 1
         * sourceFolder : 4
         * sourceDesc : 隐患任务描述
         * sourceMoney : 300
         * sourceScore : 10
         * troubleContent : 子隐患相关描述
         * fileIds : 605
         */

        private String sourceprocessorId;
        private String sourceId;
        private String sourceFolder;
        private String sourceDesc;
        private String sourceMoney;
        private String sourceScore;
        private String troubleContent;
        private String fileIds;

        public String getSourceprocessorId() {
            return sourceprocessorId;
        }

        public void setSourceprocessorId(String sourceprocessorId) {
            this.sourceprocessorId = sourceprocessorId;
        }

        public String getSourceId() {
            return sourceId;
        }

        public void setSourceId(String sourceId) {
            this.sourceId = sourceId;
        }

        public String getSourceFolder() {
            return sourceFolder;
        }

        public void setSourceFolder(String sourceFolder) {
            this.sourceFolder = sourceFolder;
        }

        public String getSourceDesc() {
            return sourceDesc;
        }

        public void setSourceDesc(String sourceDesc) {
            this.sourceDesc = sourceDesc;
        }

        public String getSourceMoney() {
            return sourceMoney;
        }

        public void setSourceMoney(String sourceMoney) {
            this.sourceMoney = sourceMoney;
        }

        public String getSourceScore() {
            return sourceScore;
        }

        public void setSourceScore(String sourceScore) {
            this.sourceScore = sourceScore;
        }

        public String getTroubleContent() {
            return troubleContent;
        }

        public void setTroubleContent(String troubleContent) {
            this.troubleContent = troubleContent;
        }

        public String getFileIds() {
            return fileIds;
        }

        public void setFileIds(String fileIds) {
            this.fileIds = fileIds;
        }
    }
}
