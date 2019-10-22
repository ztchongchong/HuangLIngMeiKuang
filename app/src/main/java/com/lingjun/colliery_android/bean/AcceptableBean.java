package com.lingjun.colliery_android.bean;

import java.util.List;

/**
 * Created by shurrikann on 2018/4/24.
 */

public class AcceptableBean {
    /**
     * msg : null
     * code : null
     * data : {"resultObj":{"task":{"id":13107,"title":"不vvv","tasktype":"1","description":"","createtime":1555315986000,"creatorId":249,"state":"5","modifytime":1555377725000,"priority":null,"deleted":0,"starttime":null,"endtime":null,"auth":null,"delaytime":null,"creatorName":"王红伟","mainTaskId":null},"wusername":"","nusername":"","project":{"taskId":13107,"approverId":2,"finishtime":1555257600000,"custom":1,"publishtype":null,"approveremark":"","summary":null,"finalremark":null,"autoscore":null,"autosummary1":null,"autosummary2":null,"starttime":null,"endtime":null,"approverName":"李鸿武","categoryId":1},"taskitemlist":[{"taskId":13109,"projectId":13107,"taskcategoryId":3,"itemId":2,"serialno":"1.1.1(2)","categoryname":"安全风险分级管控/工作机制/职责分工","standard":"查资料。未明确管理部门不得分","demand":"有负责安全风险分级管控工作的管理部门","score":2,"responsibleId":2,"invited":"","rejectremark":null,"resultscore":0,"resultremark":null,"systask":{"id":13109,"title":null,"tasktype":"2","description":null,"createtime":1555315986000,"creatorId":249,"state":"2","modifytime":1555378678000,"priority":null,"deleted":null,"starttime":null,"endtime":null,"auth":null,"delaytime":null,"creatorName":null,"mainTaskId":null},"responsibleName":"李鸿武","cooperatorIds":"","cooperatorNames":"","categoryname1":null,"categoryname2":null,"categoryname3":null,"starttime":null,"endtime":null,"flags":1}]}}
     * resultMaps : []
     */

    private Object msg;
    private Object code;
    private DataBean data;
    private List<?> resultMaps;

    public Object getMsg() {
        return msg;
    }

    public void setMsg(Object msg) {
        this.msg = msg;
    }

    public Object getCode() {
        return code;
    }

    public void setCode(Object code) {
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
         * resultObj : {"task":{"id":13107,"title":"不vvv","tasktype":"1","description":"","createtime":1555315986000,"creatorId":249,"state":"5","modifytime":1555377725000,"priority":null,"deleted":0,"starttime":null,"endtime":null,"auth":null,"delaytime":null,"creatorName":"王红伟","mainTaskId":null},"wusername":"","nusername":"","project":{"taskId":13107,"approverId":2,"finishtime":1555257600000,"custom":1,"publishtype":null,"approveremark":"","summary":null,"finalremark":null,"autoscore":null,"autosummary1":null,"autosummary2":null,"starttime":null,"endtime":null,"approverName":"李鸿武","categoryId":1},"taskitemlist":[{"taskId":13109,"projectId":13107,"taskcategoryId":3,"itemId":2,"serialno":"1.1.1(2)","categoryname":"安全风险分级管控/工作机制/职责分工","standard":"查资料。未明确管理部门不得分","demand":"有负责安全风险分级管控工作的管理部门","score":2,"responsibleId":2,"invited":"","rejectremark":null,"resultscore":0,"resultremark":null,"systask":{"id":13109,"title":null,"tasktype":"2","description":null,"createtime":1555315986000,"creatorId":249,"state":"2","modifytime":1555378678000,"priority":null,"deleted":null,"starttime":null,"endtime":null,"auth":null,"delaytime":null,"creatorName":null,"mainTaskId":null},"responsibleName":"李鸿武","cooperatorIds":"","cooperatorNames":"","categoryname1":null,"categoryname2":null,"categoryname3":null,"starttime":null,"endtime":null,"flags":1}]}
         */

        private ResultObjBean resultObj;

        public ResultObjBean getResultObj() {
            return resultObj;
        }

        public void setResultObj(ResultObjBean resultObj) {
            this.resultObj = resultObj;
        }

        public static class ResultObjBean {
            /**
             * task : {"id":13107,"title":"不vvv","tasktype":"1","description":"","createtime":1555315986000,"creatorId":249,"state":"5","modifytime":1555377725000,"priority":null,"deleted":0,"starttime":null,"endtime":null,"auth":null,"delaytime":null,"creatorName":"王红伟","mainTaskId":null}
             * wusername :
             * nusername :
             * project : {"taskId":13107,"approverId":2,"finishtime":1555257600000,"custom":1,"publishtype":null,"approveremark":"","summary":null,"finalremark":null,"autoscore":null,"autosummary1":null,"autosummary2":null,"starttime":null,"endtime":null,"approverName":"李鸿武","categoryId":1}
             * taskitemlist : [{"taskId":13109,"projectId":13107,"taskcategoryId":3,"itemId":2,"serialno":"1.1.1(2)","categoryname":"安全风险分级管控/工作机制/职责分工","standard":"查资料。未明确管理部门不得分","demand":"有负责安全风险分级管控工作的管理部门","score":2,"responsibleId":2,"invited":"","rejectremark":null,"resultscore":0,"resultremark":null,"systask":{"id":13109,"title":null,"tasktype":"2","description":null,"createtime":1555315986000,"creatorId":249,"state":"2","modifytime":1555378678000,"priority":null,"deleted":null,"starttime":null,"endtime":null,"auth":null,"delaytime":null,"creatorName":null,"mainTaskId":null},"responsibleName":"李鸿武","cooperatorIds":"","cooperatorNames":"","categoryname1":null,"categoryname2":null,"categoryname3":null,"starttime":null,"endtime":null,"flags":1}]
             */

            private TaskBean task;
            private String wusername;
            private String nusername;
            private ProjectBean project;
            private List<TaskitemlistBean> taskitemlist;

            public TaskBean getTask() {
                return task;
            }

            public void setTask(TaskBean task) {
                this.task = task;
            }

            public String getWusername() {
                return wusername;
            }

            public void setWusername(String wusername) {
                this.wusername = wusername;
            }

            public String getNusername() {
                return nusername;
            }

            public void setNusername(String nusername) {
                this.nusername = nusername;
            }

            public ProjectBean getProject() {
                return project;
            }

            public void setProject(ProjectBean project) {
                this.project = project;
            }

            public List<TaskitemlistBean> getTaskitemlist() {
                return taskitemlist;
            }

            public void setTaskitemlist(List<TaskitemlistBean> taskitemlist) {
                this.taskitemlist = taskitemlist;
            }

            public static class TaskBean {
                /**
                 * id : 13107
                 * title : 不vvv
                 * tasktype : 1
                 * description :
                 * createtime : 1555315986000
                 * creatorId : 249
                 * state : 5
                 * modifytime : 1555377725000
                 * priority : null
                 * deleted : 0
                 * starttime : null
                 * endtime : null
                 * auth : null
                 * delaytime : null
                 * creatorName : 王红伟
                 * mainTaskId : null
                 */

                private int id;
                private String title;
                private String tasktype;
                private String description;
                private long createtime;
                private int creatorId;
                private String state;
                private long modifytime;
                private Object priority;
                private int deleted;
                private Object starttime;
                private Object endtime;
                private Object auth;
                private Object delaytime;
                private String creatorName;
                private Object mainTaskId;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }

                public String getTasktype() {
                    return tasktype;
                }

                public void setTasktype(String tasktype) {
                    this.tasktype = tasktype;
                }

                public String getDescription() {
                    return description;
                }

                public void setDescription(String description) {
                    this.description = description;
                }

                public long getCreatetime() {
                    return createtime;
                }

                public void setCreatetime(long createtime) {
                    this.createtime = createtime;
                }

                public int getCreatorId() {
                    return creatorId;
                }

                public void setCreatorId(int creatorId) {
                    this.creatorId = creatorId;
                }

                public String getState() {
                    return state;
                }

                public void setState(String state) {
                    this.state = state;
                }

                public long getModifytime() {
                    return modifytime;
                }

                public void setModifytime(long modifytime) {
                    this.modifytime = modifytime;
                }

                public Object getPriority() {
                    return priority;
                }

                public void setPriority(Object priority) {
                    this.priority = priority;
                }

                public int getDeleted() {
                    return deleted;
                }

                public void setDeleted(int deleted) {
                    this.deleted = deleted;
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

                public Object getAuth() {
                    return auth;
                }

                public void setAuth(Object auth) {
                    this.auth = auth;
                }

                public Object getDelaytime() {
                    return delaytime;
                }

                public void setDelaytime(Object delaytime) {
                    this.delaytime = delaytime;
                }

                public String getCreatorName() {
                    return creatorName;
                }

                public void setCreatorName(String creatorName) {
                    this.creatorName = creatorName;
                }

                public Object getMainTaskId() {
                    return mainTaskId;
                }

                public void setMainTaskId(Object mainTaskId) {
                    this.mainTaskId = mainTaskId;
                }
            }

            public static class ProjectBean {
                /**
                 * taskId : 13107
                 * approverId : 2
                 * finishtime : 1555257600000
                 * custom : 1
                 * publishtype : null
                 * approveremark :
                 * summary : null
                 * finalremark : null
                 * autoscore : null
                 * autosummary1 : null
                 * autosummary2 : null
                 * starttime : null
                 * endtime : null
                 * approverName : 李鸿武
                 * categoryId : 1
                 */

                private int taskId;
                private int approverId;
                private long finishtime;
                private int custom;
                private Object publishtype;
                private String approveremark;
                private Object summary;
                private Object finalremark;
                private Object autoscore;
                private Object autosummary1;
                private Object autosummary2;
                private Object starttime;
                private Object endtime;
                private String approverName;
                private int categoryId;

                public int getTaskId() {
                    return taskId;
                }

                public void setTaskId(int taskId) {
                    this.taskId = taskId;
                }

                public int getApproverId() {
                    return approverId;
                }

                public void setApproverId(int approverId) {
                    this.approverId = approverId;
                }

                public long getFinishtime() {
                    return finishtime;
                }

                public void setFinishtime(long finishtime) {
                    this.finishtime = finishtime;
                }

                public int getCustom() {
                    return custom;
                }

                public void setCustom(int custom) {
                    this.custom = custom;
                }

                public Object getPublishtype() {
                    return publishtype;
                }

                public void setPublishtype(Object publishtype) {
                    this.publishtype = publishtype;
                }

                public String getApproveremark() {
                    return approveremark;
                }

                public void setApproveremark(String approveremark) {
                    this.approveremark = approveremark;
                }

                public Object getSummary() {
                    return summary;
                }

                public void setSummary(Object summary) {
                    this.summary = summary;
                }

                public Object getFinalremark() {
                    return finalremark;
                }

                public void setFinalremark(Object finalremark) {
                    this.finalremark = finalremark;
                }

                public Object getAutoscore() {
                    return autoscore;
                }

                public void setAutoscore(Object autoscore) {
                    this.autoscore = autoscore;
                }

                public Object getAutosummary1() {
                    return autosummary1;
                }

                public void setAutosummary1(Object autosummary1) {
                    this.autosummary1 = autosummary1;
                }

                public Object getAutosummary2() {
                    return autosummary2;
                }

                public void setAutosummary2(Object autosummary2) {
                    this.autosummary2 = autosummary2;
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

                public String getApproverName() {
                    return approverName;
                }

                public void setApproverName(String approverName) {
                    this.approverName = approverName;
                }

                public int getCategoryId() {
                    return categoryId;
                }

                public void setCategoryId(int categoryId) {
                    this.categoryId = categoryId;
                }
            }

            public static class TaskitemlistBean {
                /**
                 * taskId : 13109
                 * projectId : 13107
                 * taskcategoryId : 3
                 * itemId : 2
                 * serialno : 1.1.1(2)
                 * categoryname : 安全风险分级管控/工作机制/职责分工
                 * standard : 查资料。未明确管理部门不得分
                 * demand : 有负责安全风险分级管控工作的管理部门
                 * score : 2
                 * responsibleId : 2
                 * invited :
                 * rejectremark : null
                 * resultscore : 0
                 * resultremark : null
                 * systask : {"id":13109,"title":null,"tasktype":"2","description":null,"createtime":1555315986000,"creatorId":249,"state":"2","modifytime":1555378678000,"priority":null,"deleted":null,"starttime":null,"endtime":null,"auth":null,"delaytime":null,"creatorName":null,"mainTaskId":null}
                 * responsibleName : 李鸿武
                 * cooperatorIds :
                 * cooperatorNames :
                 * categoryname1 : null
                 * categoryname2 : null
                 * categoryname3 : null
                 * starttime : null
                 * endtime : null
                 * flags : 1
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
                private String invited;
                private String rejectremark;
                private int resultscore;
                private Object resultremark;
                private SystaskBean systask;
                private String responsibleName;
                private String cooperatorIds;
                private String cooperatorNames;
                private Object categoryname1;
                private Object categoryname2;
                private Object categoryname3;
                private Object starttime;
                private Object endtime;
                private int flags;

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


                public boolean isRoot() {
                    return root;
                }

                public void setRoot(boolean root) {
                    this.root = root;
                }

                private boolean root;

                public boolean isState() {
                    return state;
                }

                public void setState(boolean state) {
                    this.state = state;
                }

                private boolean state;

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

                public String getInvited() {
                    return invited;
                }

                public void setInvited(String invited) {
                    this.invited = invited;
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

                public Object getResultremark() {
                    return resultremark;
                }

                public void setResultremark(Object resultremark) {
                    this.resultremark = resultremark;
                }

                public SystaskBean getSystask() {
                    return systask;
                }

                public void setSystask(SystaskBean systask) {
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

                public Object getCategoryname1() {
                    return categoryname1;
                }

                public void setCategoryname1(Object categoryname1) {
                    this.categoryname1 = categoryname1;
                }

                public Object getCategoryname2() {
                    return categoryname2;
                }

                public void setCategoryname2(Object categoryname2) {
                    this.categoryname2 = categoryname2;
                }

                public Object getCategoryname3() {
                    return categoryname3;
                }

                public void setCategoryname3(Object categoryname3) {
                    this.categoryname3 = categoryname3;
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

                public int getFlags() {
                    return flags;
                }

                public void setFlags(int flags) {
                    this.flags = flags;
                }

                public static class SystaskBean {
                    /**
                     * id : 13109
                     * title : null
                     * tasktype : 2
                     * description : null
                     * createtime : 1555315986000
                     * creatorId : 249
                     * state : 2
                     * modifytime : 1555378678000
                     * priority : null
                     * deleted : null
                     * starttime : null
                     * endtime : null
                     * auth : null
                     * delaytime : null
                     * creatorName : null
                     * mainTaskId : null
                     */

                    private int id;
                    private Object title;
                    private String tasktype;
                    private Object description;
                    private long createtime;
                    private int creatorId;
                    private String state;
                    private long modifytime;
                    private Object priority;
                    private Object deleted;
                    private Object starttime;
                    private Object endtime;
                    private Object auth;
                    private Object delaytime;
                    private Object creatorName;
                    private Object mainTaskId;

                    public int getId() {
                        return id;
                    }

                    public void setId(int id) {
                        this.id = id;
                    }

                    public Object getTitle() {
                        return title;
                    }

                    public void setTitle(Object title) {
                        this.title = title;
                    }

                    public String getTasktype() {
                        return tasktype;
                    }

                    public void setTasktype(String tasktype) {
                        this.tasktype = tasktype;
                    }

                    public Object getDescription() {
                        return description;
                    }

                    public void setDescription(Object description) {
                        this.description = description;
                    }

                    public long getCreatetime() {
                        return createtime;
                    }

                    public void setCreatetime(long createtime) {
                        this.createtime = createtime;
                    }

                    public int getCreatorId() {
                        return creatorId;
                    }

                    public void setCreatorId(int creatorId) {
                        this.creatorId = creatorId;
                    }

                    public String getState() {
                        return state;
                    }

                    public void setState(String state) {
                        this.state = state;
                    }

                    public long getModifytime() {
                        return modifytime;
                    }

                    public void setModifytime(long modifytime) {
                        this.modifytime = modifytime;
                    }

                    public Object getPriority() {
                        return priority;
                    }

                    public void setPriority(Object priority) {
                        this.priority = priority;
                    }

                    public Object getDeleted() {
                        return deleted;
                    }

                    public void setDeleted(Object deleted) {
                        this.deleted = deleted;
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

                    public Object getAuth() {
                        return auth;
                    }

                    public void setAuth(Object auth) {
                        this.auth = auth;
                    }

                    public Object getDelaytime() {
                        return delaytime;
                    }

                    public void setDelaytime(Object delaytime) {
                        this.delaytime = delaytime;
                    }

                    public Object getCreatorName() {
                        return creatorName;
                    }

                    public void setCreatorName(Object creatorName) {
                        this.creatorName = creatorName;
                    }

                    public Object getMainTaskId() {
                        return mainTaskId;
                    }

                    public void setMainTaskId(Object mainTaskId) {
                        this.mainTaskId = mainTaskId;
                    }
                }
            }
        }
    }

}
