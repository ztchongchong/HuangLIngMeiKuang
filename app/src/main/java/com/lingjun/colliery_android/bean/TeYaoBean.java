package com.lingjun.colliery_android.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by shurrikann on 2018/12/12.
 */

public class TeYaoBean implements Serializable{

    /**
     * msg : 成功
     * code : 200
     * data : {"itemmap":[{"id":0,"name":"安全风险分级管控","picurl":null,"list":[{"itemid":1,"standard":"查资料和现场。未建立责任体系不得分，随机抽查，矿领导1人不清楚职责扣1分","demand":"建立安全风险分级管控工作责任体系，矿长全面负责，分管负责人负责分管范围内的安全风险分级管控工作","score":4,"remark":null,"enabled":null,"defResponsibleId":95,"defCooperatorIds":"95","invited":" teyaorenyuan 123","serialno":"1.1.1(1)","categoryname":"安全风险分级管控/工作机制/职责分工","categoryId":null,"taskid":1339,"defResponsibleName":"孔德昊","defCooperatorNames":"孔德昊","categoryname1":"工作机制","child1":3,"categoryname2":"职责分工","child2":2,"categoryname3":null,"child3":0,"state":"2","rejectremark":null,"resultscore":0,"resultremark":null,"flags":1}]}]}
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

    public static class DataBean implements Serializable{
        private List<ItemmapBean> itemmap;

        public List<ItemmapBean> getItemmap() {
            return itemmap;
        }

        public void setItemmap(List<ItemmapBean> itemmap) {
            this.itemmap = itemmap;
        }

        public static class ItemmapBean implements Serializable{
            /**
             * id : 0
             * name : 安全风险分级管控
             * picurl : null
             * list : [{"itemid":1,"standard":"查资料和现场。未建立责任体系不得分，随机抽查，矿领导1人不清楚职责扣1分","demand":"建立安全风险分级管控工作责任体系，矿长全面负责，分管负责人负责分管范围内的安全风险分级管控工作","score":4,"remark":null,"enabled":null,"defResponsibleId":95,"defCooperatorIds":"95","invited":" teyaorenyuan 123","serialno":"1.1.1(1)","categoryname":"安全风险分级管控/工作机制/职责分工","categoryId":null,"taskid":1339,"defResponsibleName":"孔德昊","defCooperatorNames":"孔德昊","categoryname1":"工作机制","child1":3,"categoryname2":"职责分工","child2":2,"categoryname3":null,"child3":0,"state":"2","rejectremark":null,"resultscore":0,"resultremark":null,"flags":1}]
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

            public static class ListBean implements Serializable{
                /**
                 * itemid : 1
                 * standard : 查资料和现场。未建立责任体系不得分，随机抽查，矿领导1人不清楚职责扣1分
                 * demand : 建立安全风险分级管控工作责任体系，矿长全面负责，分管负责人负责分管范围内的安全风险分级管控工作
                 * score : 4
                 * remark : null
                 * enabled : null
                 * defResponsibleId : 95
                 * defCooperatorIds : 95
                 * invited :  teyaorenyuan 123
                 * serialno : 1.1.1(1)
                 * categoryname : 安全风险分级管控/工作机制/职责分工
                 * categoryId : null
                 * taskid : 1339
                 * defResponsibleName : 孔德昊
                 * defCooperatorNames : 孔德昊
                 * categoryname1 : 工作机制
                 * child1 : 3
                 * categoryname2 : 职责分工
                 * child2 : 2
                 * categoryname3 : null
                 * child3 : 0
                 * state : 2
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
                private int defResponsibleId;
                private String defCooperatorIds;
                private String invited;
                private String serialno;
                private String categoryname;
                private Object categoryId;
                private int taskid;
                private String defResponsibleName;
                private String defCooperatorNames;
                private String categoryname1;
                private int child1;
                private String categoryname2;
                private int child2;
                private Object categoryname3;
                private int child3;
                private String state;
                private Object rejectremark;
                private int resultscore;
                private Object resultremark;
                private int flags;

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

                public String getCategoryname1() {
                    return categoryname1;
                }

                public void setCategoryname1(String categoryname1) {
                    this.categoryname1 = categoryname1;
                }

                public int getChild1() {
                    return child1;
                }

                public void setChild1(int child1) {
                    this.child1 = child1;
                }

                public String getCategoryname2() {
                    return categoryname2;
                }

                public void setCategoryname2(String categoryname2) {
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

                public String getState() {
                    return state;
                }

                public void setState(String state) {
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
