package com.lingjun.colliery_android.bean;

/**
 * Created by shurrikann on 2018/4/26.
 */

public class CheckInfoBean {

    /**
     * msg : 成功
     * code : 200
     * data : {"taskitem":{"taskId":26,"projectId":22,"taskcategoryId":23,"itemId":8,"serialno":"1.2.1.1","categoryname":"安全风险分级管控/安全风险辨识评估/年度辨识评估","standard":"","demand":"每年底矿长组织各分管负责人和相关业务科室、区队进行年度安全风险辨识，重点对井工煤矿瓦斯、水、火、粉尘、顶板、冲击地压及提升运输系统，露天煤矿边坡、爆 破、机电运输等容易导致群死群伤事故的危险因素开展安全风险辨识；及时编制年度安全风险辨识评估报告，建立可能引发重特大事故的重大安全风险清单，制定相应的管控措施；  将辨识评估结果用于确定下一年度安全生产工作重点，并指导和完善下一年度生产计划、灾害预防和处理计划、应急救援预案","score":10,"responsibleId":3,"invited":null,"rejectremark":"","resultscore":null,"resultremark":null,"systask":null,"responsibleName":"张无忌","cooperatorIds":"1","cooperatorNames":"赵敏","starttime":null,"endtime":null}}
     */

    private String msg;
    private String code;
    private DataBean data;

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

    public static class DataBean {
        /**
         * taskitem : {"taskId":26,"projectId":22,"taskcategoryId":23,"itemId":8,"serialno":"1.2.1.1","categoryname":"安全风险分级管控/安全风险辨识评估/年度辨识评估","standard":"","demand":"每年底矿长组织各分管负责人和相关业务科室、区队进行年度安全风险辨识，重点对井工煤矿瓦斯、水、火、粉尘、顶板、冲击地压及提升运输系统，露天煤矿边坡、爆 破、机电运输等容易导致群死群伤事故的危险因素开展安全风险辨识；及时编制年度安全风险辨识评估报告，建立可能引发重特大事故的重大安全风险清单，制定相应的管控措施；  将辨识评估结果用于确定下一年度安全生产工作重点，并指导和完善下一年度生产计划、灾害预防和处理计划、应急救援预案","score":10,"responsibleId":3,"invited":null,"rejectremark":"","resultscore":null,"resultremark":null,"systask":null,"responsibleName":"张无忌","cooperatorIds":"1","cooperatorNames":"赵敏","starttime":null,"endtime":null}
         */

        private TaskitemBean taskitem;

        public TaskitemBean getTaskitem() {
            return taskitem;
        }

        public void setTaskitem(TaskitemBean taskitem) {
            this.taskitem = taskitem;
        }

        public static class TaskitemBean {
            /**
             * taskId : 26
             * projectId : 22
             * taskcategoryId : 23
             * itemId : 8
             * serialno : 1.2.1.1
             * categoryname : 安全风险分级管控/安全风险辨识评估/年度辨识评估
             * standard :
             * demand : 每年底矿长组织各分管负责人和相关业务科室、区队进行年度安全风险辨识，重点对井工煤矿瓦斯、水、火、粉尘、顶板、冲击地压及提升运输系统，露天煤矿边坡、爆 破、机电运输等容易导致群死群伤事故的危险因素开展安全风险辨识；及时编制年度安全风险辨识评估报告，建立可能引发重特大事故的重大安全风险清单，制定相应的管控措施；  将辨识评估结果用于确定下一年度安全生产工作重点，并指导和完善下一年度生产计划、灾害预防和处理计划、应急救援预案
             * score : 10
             * responsibleId : 3
             * invited : null
             * rejectremark :
             * resultscore : null
             * resultremark : null
             * systask : null
             * responsibleName : 张无忌
             * cooperatorIds : 1
             * cooperatorNames : 赵敏
             * starttime : null
             * endtime : null
             */

            private int taskId;
            private int projectId;
            private int taskcategoryId;
            private int itemId;
            private String serialno;
            private String categoryname;
            private String standard;
            private String demand;
            private int score;
            private int responsibleId;
            private Object invited;
            private String rejectremark;
            private Object resultscore;
            private Object resultremark;
            private Object systask;
            private String responsibleName;
            private String cooperatorIds;
            private String cooperatorNames;
            private Object starttime;
            private Object endtime;

            public String getMethodContent() {
                return methodContent;
            }

            public void setMethodContent(String methodContent) {
                this.methodContent = methodContent;
            }

            private String methodContent;

            public String getRequiredInfo() {
                return requiredInfo;
            }

            public void setRequiredInfo(String requiredInfo) {
                this.requiredInfo = requiredInfo;
            }

            private String requiredInfo;

            public String getDetailedRules() {
                return detailedRules;
            }

            public void setDetailedRules(String detailedRules) {
                this.detailedRules = detailedRules;
            }

            private String detailedRules;


            public int getTaskId() {
                return taskId;
            }

            public void setTaskId(int taskId) {
                this.taskId = taskId;
            }

            public int getProjectId() {
                return projectId;
            }

            public void setProjectId(int projectId) {
                this.projectId = projectId;
            }

            public int getTaskcategoryId() {
                return taskcategoryId;
            }

            public void setTaskcategoryId(int taskcategoryId) {
                this.taskcategoryId = taskcategoryId;
            }

            public int getItemId() {
                return itemId;
            }

            public void setItemId(int itemId) {
                this.itemId = itemId;
            }

            public String getSerialno() {
                return serialno;
            }

            public void setSerialno(String serialno) {
                this.serialno = serialno;
            }

            public String getCategoryname() {
                return categoryname;
            }

            public void setCategoryname(String categoryname) {
                this.categoryname = categoryname;
            }

            public String getStandard() {
                return standard;
            }

            public void setStandard(String standard) {
                this.standard = standard;
            }

            public String getDemand() {
                return demand;
            }

            public void setDemand(String demand) {
                this.demand = demand;
            }

            public int getScore() {
                return score;
            }

            public void setScore(int score) {
                this.score = score;
            }

            public int getResponsibleId() {
                return responsibleId;
            }

            public void setResponsibleId(int responsibleId) {
                this.responsibleId = responsibleId;
            }

            public Object getInvited() {
                return invited;
            }

            public void setInvited(Object invited) {
                this.invited = invited;
            }

            public String getRejectremark() {
                return rejectremark;
            }

            public void setRejectremark(String rejectremark) {
                this.rejectremark = rejectremark;
            }

            public Object getResultscore() {
                return resultscore;
            }

            public void setResultscore(Object resultscore) {
                this.resultscore = resultscore;
            }

            public Object getResultremark() {
                return resultremark;
            }

            public void setResultremark(Object resultremark) {
                this.resultremark = resultremark;
            }

            public Object getSystask() {
                return systask;
            }

            public void setSystask(Object systask) {
                this.systask = systask;
            }

            public String getResponsibleName() {
                return responsibleName;
            }

            public void setResponsibleName(String responsibleName) {
                this.responsibleName = responsibleName;
            }

            public String getCooperatorIds() {
                return cooperatorIds;
            }

            public void setCooperatorIds(String cooperatorIds) {
                this.cooperatorIds = cooperatorIds;
            }

            public String getCooperatorNames() {
                return cooperatorNames;
            }

            public void setCooperatorNames(String cooperatorNames) {
                this.cooperatorNames = cooperatorNames;
            }

            public Object getStarttime() {
                return starttime;
            }

            public void setStarttime(Object starttime) {
                this.starttime = starttime;
            }

            public Object getEndtime() {
                return endtime;
            }

            public void setEndtime(Object endtime) {
                this.endtime = endtime;
            }
        }
    }
}
