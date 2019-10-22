package com.lingjun.colliery_android.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by shurrikann on 2018/12/12.
 */

public class TaskBean implements Serializable {


    /**
     * msg : 成功
     * code : 200
     * data : {"itemmap":[{"id":0,"name":"安全风险分级管控","picurl":null,"list":[{"itemid":1,"standard":"查资料和现场。未建立责任体系不得分，随机抽查，矿领导1人不清楚职责扣1分","demand":"建立安全风险分级管控工作责任体系，矿长全面负责，分管负责人负责分管范围内的安全风险分级管控工作","score":4,"remark":null,"enabled":null,"defResponsibleId":null,"defCooperatorIds":null,"invited":null,"serialno":"1.1.1(1)","categoryname":"安全风险分级管控/工作机制/职责分工","categoryId":null,"taskid":null,"defResponsibleName":null,"defCooperatorNames":null,"categoryname1":null,"child1":0,"categoryname2":null,"child2":0,"categoryname3":null,"child3":0,"state":null,"rejectremark":null,"resultscore":0,"resultremark":null,"flags":1},{"itemid":2,"standard":"查资料。未明确管理部门不得分","demand":"有负责安全风险分级管控工作的管理部门","score":2,"remark":null,"enabled":null,"defResponsibleId":null,"defCooperatorIds":null,"invited":null,"serialno":"1.1.1(2)","categoryname":"安全风险分级管控/工作机制/职责分工","categoryId":null,"taskid":null,"defResponsibleName":null,"defCooperatorNames":null,"categoryname1":null,"child1":0,"categoryname2":null,"child2":0,"categoryname3":null,"child3":0,"state":null,"rejectremark":null,"resultscore":0,"resultremark":null,"flags":1}]}]}
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

    public static class DataBean implements Serializable {
        private List<ItemmapBean> itemmap;

        public List<ItemmapBean> getItemmap() {
            return itemmap;
        }

        public void setItemmap(List<ItemmapBean> itemmap) {
            this.itemmap = itemmap;
        }

        public static class ItemmapBean implements Serializable {
            /**
             * id : 0
             * name : 安全风险分级管控
             * picurl : null
             * list : [{"itemid":1,"standard":"查资料和现场。未建立责任体系不得分，随机抽查，矿领导1人不清楚职责扣1分","demand":"建立安全风险分级管控工作责任体系，矿长全面负责，分管负责人负责分管范围内的安全风险分级管控工作","score":4,"remark":null,"enabled":null,"defResponsibleId":null,"defCooperatorIds":null,"invited":null,"serialno":"1.1.1(1)","categoryname":"安全风险分级管控/工作机制/职责分工","categoryId":null,"taskid":null,"defResponsibleName":null,"defCooperatorNames":null,"categoryname1":null,"child1":0,"categoryname2":null,"child2":0,"categoryname3":null,"child3":0,"state":null,"rejectremark":null,"resultscore":0,"resultremark":null,"flags":1},{"itemid":2,"standard":"查资料。未明确管理部门不得分","demand":"有负责安全风险分级管控工作的管理部门","score":2,"remark":null,"enabled":null,"defResponsibleId":null,"defCooperatorIds":null,"invited":null,"serialno":"1.1.1(2)","categoryname":"安全风险分级管控/工作机制/职责分工","categoryId":null,"taskid":null,"defResponsibleName":null,"defCooperatorNames":null,"categoryname1":null,"child1":0,"categoryname2":null,"child2":0,"categoryname3":null,"child3":0,"state":null,"rejectremark":null,"resultscore":0,"resultremark":null,"flags":1}]
             */

            private int id;
            private String name;
            private Object picurl;
            private List<ListBean> list;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public Object getPicurl() {
                return picurl;
            }

            public void setPicurl(Object picurl) {
                this.picurl = picurl;
            }

            public List<ListBean> getList() {
                return list;
            }

            public void setList(List<ListBean> list) {
                this.list = list;
            }

            public static class ListBean implements Serializable {
                /**
                 * itemid : 1
                 * standard : 查资料和现场。未建立责任体系不得分，随机抽查，矿领导1人不清楚职责扣1分
                 * demand : 建立安全风险分级管控工作责任体系，矿长全面负责，分管负责人负责分管范围内的安全风险分级管控工作
                 * score : 4
                 * remark : null
                 * enabled : null
                 * defResponsibleId : null
                 * defCooperatorIds : null
                 * invited : null
                 * serialno : 1.1.1(1)
                 * categoryname : 安全风险分级管控/工作机制/职责分工
                 * categoryId : null
                 * taskid : null
                 * defResponsibleName : null
                 * defCooperatorNames : null
                 * categoryname1 : null
                 * child1 : 0
                 * categoryname2 : null
                 * child2 : 0
                 * categoryname3 : null
                 * child3 : 0
                 * state : null
                 * rejectremark : null
                 * resultscore : 0
                 * resultremark : null
                 * flags : 1
                 */

                private int itemid;
                private String standard;
                private String demand;
                private int score;
                private Object remark;
                private Object enabled;
                private Object defResponsibleId;
                private Object defCooperatorIds;
                private Object invited;
                private String serialno;
                private String categoryname;
                private Object categoryId;
                private Object taskid;
                private Object defResponsibleName;
                private Object defCooperatorNames;
                private Object categoryname1;
                private int child1;
                private Object categoryname2;
                private int child2;
                private Object categoryname3;
                private int child3;
                private Object state;
                private Object rejectremark;
                private int resultscore;
                private Object resultremark;
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

                public Object getDefResponsibleId() {
                    return defResponsibleId;
                }

                public void setDefResponsibleId(Object defResponsibleId) {
                    this.defResponsibleId = defResponsibleId;
                }

                public Object getDefCooperatorIds() {
                    return defCooperatorIds;
                }

                public void setDefCooperatorIds(Object defCooperatorIds) {
                    this.defCooperatorIds = defCooperatorIds;
                }

                public Object getInvited() {
                    return invited;
                }

                public void setInvited(Object invited) {
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

                public Object getTaskid() {
                    return taskid;
                }

                public void setTaskid(Object taskid) {
                    this.taskid = taskid;
                }

                public Object getDefResponsibleName() {
                    return defResponsibleName;
                }

                public void setDefResponsibleName(Object defResponsibleName) {
                    this.defResponsibleName = defResponsibleName;
                }

                public Object getDefCooperatorNames() {
                    return defCooperatorNames;
                }

                public void setDefCooperatorNames(Object defCooperatorNames) {
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

                public Object getCategoryname3() {
                    return categoryname3;
                }

                public void setCategoryname3(Object categoryname3) {
                    this.categoryname3 = categoryname3;
                }

                public int getChild3() {
                    return child3;
                }

                public void setChild3(int child3) {
                    this.child3 = child3;
                }

                public Object getState() {
                    return state;
                }

                public void setState(Object state) {
                    this.state = state;
                }

                public Object getRejectremark() {
                    return rejectremark;
                }

                public void setRejectremark(Object rejectremark) {
                    this.rejectremark = rejectremark;
                }

                public int getResultscore() {
                    return resultscore;
                }

                public void setResultscore(int resultscore) {
                    this.resultscore = resultscore;
                }

                public Object getResultremark() {
                    return resultremark;
                }

                public void setResultremark(Object resultremark) {
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
}
