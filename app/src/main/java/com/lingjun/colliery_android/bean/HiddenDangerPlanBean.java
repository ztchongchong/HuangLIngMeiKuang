package com.lingjun.colliery_android.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * 隐患计划
 */
public class HiddenDangerPlanBean {


    /**
     * msg : 成功
     * code : 200
     * data : null
     * resultMaps : [{"planlist":[{"id":1,"planName":"2016年每巡顶板检查任务","clausecategoryId":0,"clausecategoryName":null,"responsibleId":23,"responsibleName":"张建忠","planCycle":"1","beginDate":1541001600000,"planDuration":3,"sendTime":"08:30","userId":1326,"publishtime":1541071587000,"enabled":1,"deleted":0,"planRemark":"需要进行一次隐患检查任务","checkdate":2}]}]
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
        private ArrayList<PlanlistBean> planlist;

        public ArrayList<PlanlistBean> getPlanlist() {
            return planlist;
        }

        public void setPlanlist(ArrayList<PlanlistBean> planlist) {
            this.planlist = planlist;
        }

        public static class PlanlistBean {
            /**
             * id : 1
             * planName : 2016年每巡顶板检查任务
             * clausecategoryId : 0
             * clausecategoryName : null
             * responsibleId : 23
             * responsibleName : 张建忠
             * planCycle : 1
             * beginDate : 1541001600000
             * planDuration : 3
             * sendTime : 08:30
             * userId : 1326
             * publishtime : 1541071587000
             * enabled : 1
             * deleted : 0
             * planRemark : 需要进行一次隐患检查任务
             * checkdate : 2
             */

            private int id;
            private String planName;
            private int clausecategoryId;
            private Object clausecategoryName;
            private int responsibleId;
            private String responsibleName;
            private String planCycle;
            private long beginDate;
            private int planDuration;
            private String sendTime;
            private int userId;
            private long publishtime;
            private int enabled;
            private int deleted;
            private String planRemark;
            private int checkdate;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getPlanName() {
                return planName;
            }

            public void setPlanName(String planName) {
                this.planName = planName;
            }

            public int getClausecategoryId() {
                return clausecategoryId;
            }

            public void setClausecategoryId(int clausecategoryId) {
                this.clausecategoryId = clausecategoryId;
            }

            public Object getClausecategoryName() {
                return clausecategoryName;
            }

            public void setClausecategoryName(Object clausecategoryName) {
                this.clausecategoryName = clausecategoryName;
            }

            public int getResponsibleId() {
                return responsibleId;
            }

            public void setResponsibleId(int responsibleId) {
                this.responsibleId = responsibleId;
            }

            public String getResponsibleName() {
                return responsibleName;
            }

            public void setResponsibleName(String responsibleName) {
                this.responsibleName = responsibleName;
            }

            public String getPlanCycle() {
                return planCycle;
            }

            public void setPlanCycle(String planCycle) {
                this.planCycle = planCycle;
            }

            public long getBeginDate() {
                return beginDate;
            }

            public void setBeginDate(long beginDate) {
                this.beginDate = beginDate;
            }

            public int getPlanDuration() {
                return planDuration;
            }

            public void setPlanDuration(int planDuration) {
                this.planDuration = planDuration;
            }

            public String getSendTime() {
                return sendTime;
            }

            public void setSendTime(String sendTime) {
                this.sendTime = sendTime;
            }

            public int getUserId() {
                return userId;
            }

            public void setUserId(int userId) {
                this.userId = userId;
            }

            public long getPublishtime() {
                return publishtime;
            }

            public void setPublishtime(long publishtime) {
                this.publishtime = publishtime;
            }

            public int getEnabled() {
                return enabled;
            }

            public void setEnabled(int enabled) {
                this.enabled = enabled;
            }

            public int getDeleted() {
                return deleted;
            }

            public void setDeleted(int deleted) {
                this.deleted = deleted;
            }

            public String getPlanRemark() {
                return planRemark;
            }

            public void setPlanRemark(String planRemark) {
                this.planRemark = planRemark;
            }

            public int getCheckdate() {
                return checkdate;
            }

            public void setCheckdate(int checkdate) {
                this.checkdate = checkdate;
            }
        }
    }
}
