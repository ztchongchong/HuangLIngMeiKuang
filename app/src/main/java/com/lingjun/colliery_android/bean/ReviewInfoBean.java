package com.lingjun.colliery_android.bean;

import java.util.List;

/**
 * Created by shurrikann on 2018/12/26.
 */

public class ReviewInfoBean {

    /**
     * msg : 成功
     * code : 200
     * data : {"weight":0.1,"itemlist":[{"itemid":0,"standard":"查资料和现场。未建立责任体系不得分，随机抽查，矿领导1人不清楚职责扣1分","demand":"建立安全风险分级管控工作责任体系，矿长全面负责，分管负责人负责分管范围内的安全风险分级管控工作","score":4,"remark":null,"enabled":null,"defResponsibleId":95,"defCooperatorIds":"","invited":"","serialno":"1.1.1(1)","categoryname":"安全风险分级管控/工作机制/职责分工","categoryId":null,"taskid":1842,"defResponsibleName":"孔德昊","defCooperatorNames":"","categoryname1":null,"child1":0,"categoryname2":null,"child2":0,"categoryname3":"职责分工","child3":0,"state":"6","rejectremark":"","resultscore":0,"resultremark":" ","flags":1},{"itemid":0,"standard":"查资料。未明确管理部门不得分","demand":"有负责安全风险分级管控工作的管理部门","score":2,"remark":null,"enabled":null,"defResponsibleId":95,"defCooperatorIds":"","invited":"","serialno":"1.1.1(2)","categoryname":"安全风险分级管控/工作机制/职责分工","categoryId":null,"taskid":1843,"defResponsibleName":"孔德昊","defCooperatorNames":"","categoryname1":null,"child1":0,"categoryname2":null,"child2":0,"categoryname3":"职责分工","child3":0,"state":"6","rejectremark":"","resultscore":0,"resultremark":" ","flags":1}]}
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
         * weight : 0.1
         * itemlist : [{"itemid":0,"standard":"查资料和现场。未建立责任体系不得分，随机抽查，矿领导1人不清楚职责扣1分","demand":"建立安全风险分级管控工作责任体系，矿长全面负责，分管负责人负责分管范围内的安全风险分级管控工作","score":4,"remark":null,"enabled":null,"defResponsibleId":95,"defCooperatorIds":"","invited":"","serialno":"1.1.1(1)","categoryname":"安全风险分级管控/工作机制/职责分工","categoryId":null,"taskid":1842,"defResponsibleName":"孔德昊","defCooperatorNames":"","categoryname1":null,"child1":0,"categoryname2":null,"child2":0,"categoryname3":"职责分工","child3":0,"state":"6","rejectremark":"","resultscore":0,"resultremark":" ","flags":1},{"itemid":0,"standard":"查资料。未明确管理部门不得分","demand":"有负责安全风险分级管控工作的管理部门","score":2,"remark":null,"enabled":null,"defResponsibleId":95,"defCooperatorIds":"","invited":"","serialno":"1.1.1(2)","categoryname":"安全风险分级管控/工作机制/职责分工","categoryId":null,"taskid":1843,"defResponsibleName":"孔德昊","defCooperatorNames":"","categoryname1":null,"child1":0,"categoryname2":null,"child2":0,"categoryname3":"职责分工","child3":0,"state":"6","rejectremark":"","resultscore":0,"resultremark":" ","flags":1}]
         */

        private double weight;
        private List<ItemlistBean> itemlist;

        public double getWeight() {
            return weight;
        }

        public void setWeight(double weight) {
            this.weight = weight;
        }

        public List<ItemlistBean> getItemlist() {
            return itemlist;
        }

        public void setItemlist(List<ItemlistBean> itemlist) {
            this.itemlist = itemlist;
        }

        public static class ItemlistBean {
            /**
             * itemid : 0
             * standard : 查资料和现场。未建立责任体系不得分，随机抽查，矿领导1人不清楚职责扣1分
             * demand : 建立安全风险分级管控工作责任体系，矿长全面负责，分管负责人负责分管范围内的安全风险分级管控工作
             * score : 4
             * remark : null
             * enabled : null
             * defResponsibleId : 95
             * defCooperatorIds :
             * invited :
             * serialno : 1.1.1(1)
             * categoryname : 安全风险分级管控/工作机制/职责分工
             * categoryId : null
             * taskid : 1842
             * defResponsibleName : 孔德昊
             * defCooperatorNames :
             * categoryname1 : null
             * child1 : 0
             * categoryname2 : null
             * child2 : 0
             * categoryname3 : 职责分工
             * child3 : 0
             * state : 6
             * rejectremark :
             * resultscore : 0
             * resultremark :
             * flags : 1
             */

            private int itemid;
            private String standard;
            private String demand;
            private int score;
            private Object remark;
            private Object enabled;
            private int defResponsibleId;
            private String defCooperatorIds;
            private String invited;
            private String serialno;
            private String categoryname;
            private Object categoryId;
            private int taskid;
            private String defResponsibleName;
            private String defCooperatorNames;
            private Object categoryname1;
            private int child1;
            private Object categoryname2;
            private int child2;
            private String categoryname3;
            private int child3;
            private String state;
            private String rejectremark;
            private int resultscore;
            private String resultremark;
            private int flags;
            private boolean states;

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

            public boolean isStates() {
                return states;
            }

            public void setStates(boolean states) {
                this.states = states;
            }

            public int getItemid() {
                return itemid;
            }

            public void setItemid(int itemid) {
                this.itemid = itemid;
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

            public Object getRemark() {
                return remark;
            }

            public void setRemark(Object remark) {
                this.remark = remark;
            }

            public Object getEnabled() {
                return enabled;
            }

            public void setEnabled(Object enabled) {
                this.enabled = enabled;
            }

            public int getDefResponsibleId() {
                return defResponsibleId;
            }

            public void setDefResponsibleId(int defResponsibleId) {
                this.defResponsibleId = defResponsibleId;
            }

            public String getDefCooperatorIds() {
                return defCooperatorIds;
            }

            public void setDefCooperatorIds(String defCooperatorIds) {
                this.defCooperatorIds = defCooperatorIds;
            }

            public String getInvited() {
                return invited;
            }

            public void setInvited(String invited) {
                this.invited = invited;
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

            public Object getCategoryId() {
                return categoryId;
            }

            public void setCategoryId(Object categoryId) {
                this.categoryId = categoryId;
            }

            public int getTaskid() {
                return taskid;
            }

            public void setTaskid(int taskid) {
                this.taskid = taskid;
            }

            public String getDefResponsibleName() {
                return defResponsibleName;
            }

            public void setDefResponsibleName(String defResponsibleName) {
                this.defResponsibleName = defResponsibleName;
            }

            public String getDefCooperatorNames() {
                return defCooperatorNames;
            }

            public void setDefCooperatorNames(String defCooperatorNames) {
                this.defCooperatorNames = defCooperatorNames;
            }

            public Object getCategoryname1() {
                return categoryname1;
            }

            public void setCategoryname1(Object categoryname1) {
                this.categoryname1 = categoryname1;
            }

            public int getChild1() {
                return child1;
            }

            public void setChild1(int child1) {
                this.child1 = child1;
            }

            public Object getCategoryname2() {
                return categoryname2;
            }

            public void setCategoryname2(Object categoryname2) {
                this.categoryname2 = categoryname2;
            }

            public int getChild2() {
                return child2;
            }

            public void setChild2(int child2) {
                this.child2 = child2;
            }

            public String getCategoryname3() {
                return categoryname3;
            }

            public void setCategoryname3(String categoryname3) {
                this.categoryname3 = categoryname3;
            }

            public int getChild3() {
                return child3;
            }

            public void setChild3(int child3) {
                this.child3 = child3;
            }

            public String getState() {
                return state;
            }

            public void setState(String state) {
                this.state = state;
            }

            public String getRejectremark() {
                return rejectremark;
            }

            public void setRejectremark(String rejectremark) {
                this.rejectremark = rejectremark;
            }

            public int getResultscore() {
                return resultscore;
            }

            public void setResultscore(int resultscore) {
                this.resultscore = resultscore;
            }

            public String getResultremark() {
                return resultremark;
            }

            public void setResultremark(String resultremark) {
                this.resultremark = resultremark;
            }

            public int getFlags() {
                return flags;
            }

            public void setFlags(int flags) {
                this.flags = flags;
            }
        }
    }
}
