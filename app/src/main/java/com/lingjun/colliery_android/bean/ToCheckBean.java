package com.lingjun.colliery_android.bean;

import java.util.List;

/**
 * Created by shurrikann on 2018/4/21.
 */

public class ToCheckBean {

    /**
     * msg : 成功
     * code : 200
     * data : {"page":{"pageNo":1,"pageSize":10,"totalRecord":294,"totalPage":30,"results":null,"params":{"finishtime":1545022800000,"h5url":"","creator":"孔德昊","createtime":1544940715000,"rejectreason":false,"description":"","itemlist":[{"taskId":1970,"projectId":1969,"taskcategoryId":3,"itemId":1,"serialno":"1.1.1(1)","categoryname":"安全风险分级管控/工作机制/职责分工","standard":"查资料和现场。未建立责任体系不得分，随机抽查，矿领导1人不清楚职责扣1分","demand":"建立安全风险分级管控工作责任体系，矿长全面负责，分管负责人负责分管范围内的安全风险分级管控工作","score":4,"responsibleId":95,"invited":"","rejectremark":"","resultscore":0,"resultremark":null,"systask":{"id":1970,"title":null,"tasktype":null,"description":null,"createtime":1544940715000,"creatorId":95,"state":"5","modifytime":1545058704000,"priority":null,"deleted":null,"starttime":null,"endtime":null,"auth":null,"delaytime":null,"creatorName":null,"mainTaskId":null},"responsibleName":"孔德昊","cooperatorIds":"","cooperatorNames":"","categoryname1":null,"categoryname2":null,"categoryname3":"职责分工","starttime":null,"endtime":null,"flags":1}]}}}
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
         * page : {"pageNo":1,"pageSize":10,"totalRecord":294,"totalPage":30,"results":null,"params":{"finishtime":1545022800000,"h5url":"","creator":"孔德昊","createtime":1544940715000,"rejectreason":false,"description":"","itemlist":[{"taskId":1970,"projectId":1969,"taskcategoryId":3,"itemId":1,"serialno":"1.1.1(1)","categoryname":"安全风险分级管控/工作机制/职责分工","standard":"查资料和现场。未建立责任体系不得分，随机抽查，矿领导1人不清楚职责扣1分","demand":"建立安全风险分级管控工作责任体系，矿长全面负责，分管负责人负责分管范围内的安全风险分级管控工作","score":4,"responsibleId":95,"invited":"","rejectremark":"","resultscore":0,"resultremark":null,"systask":{"id":1970,"title":null,"tasktype":null,"description":null,"createtime":1544940715000,"creatorId":95,"state":"5","modifytime":1545058704000,"priority":null,"deleted":null,"starttime":null,"endtime":null,"auth":null,"delaytime":null,"creatorName":null,"mainTaskId":null},"responsibleName":"孔德昊","cooperatorIds":"","cooperatorNames":"","categoryname1":null,"categoryname2":null,"categoryname3":"职责分工","starttime":null,"endtime":null,"flags":1}]}}
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
             * pageNo : 1
             * pageSize : 10
             * totalRecord : 294
             * totalPage : 30
             * results : null
             * params : {"finishtime":1545022800000,"h5url":"","creator":"孔德昊","createtime":1544940715000,"rejectreason":false,"description":"","itemlist":[{"taskId":1970,"projectId":1969,"taskcategoryId":3,"itemId":1,"serialno":"1.1.1(1)","categoryname":"安全风险分级管控/工作机制/职责分工","standard":"查资料和现场。未建立责任体系不得分，随机抽查，矿领导1人不清楚职责扣1分","demand":"建立安全风险分级管控工作责任体系，矿长全面负责，分管负责人负责分管范围内的安全风险分级管控工作","score":4,"responsibleId":95,"invited":"","rejectremark":"","resultscore":0,"resultremark":null,"systask":{"id":1970,"title":null,"tasktype":null,"description":null,"createtime":1544940715000,"creatorId":95,"state":"5","modifytime":1545058704000,"priority":null,"deleted":null,"starttime":null,"endtime":null,"auth":null,"delaytime":null,"creatorName":null,"mainTaskId":null},"responsibleName":"孔德昊","cooperatorIds":"","cooperatorNames":"","categoryname1":null,"categoryname2":null,"categoryname3":"职责分工","starttime":null,"endtime":null,"flags":1}]}
             */

            private int pageNo;
            private int pageSize;
            private int totalRecord;
            private int totalPage;
            private Object results;
            private ParamsBean params;

            public int getPageNo() {
                return pageNo;
            }

            public void setPageNo(int pageNo) {
                this.pageNo = pageNo;
            }

            public int getPageSize() {
                return pageSize;
            }

            public void setPageSize(int pageSize) {
                this.pageSize = pageSize;
            }

            public int getTotalRecord() {
                return totalRecord;
            }

            public void setTotalRecord(int totalRecord) {
                this.totalRecord = totalRecord;
            }

            public int getTotalPage() {
                return totalPage;
            }

            public void setTotalPage(int totalPage) {
                this.totalPage = totalPage;
            }

            public Object getResults() {
                return results;
            }

            public void setResults(Object results) {
                this.results = results;
            }

            public ParamsBean getParams() {
                return params;
            }

            public void setParams(ParamsBean params) {
                this.params = params;
            }

            public static class ParamsBean {
                /**
                 * finishtime : 1545022800000
                 * h5url :
                 * creator : 孔德昊
                 * createtime : 1544940715000
                 * rejectreason : false
                 * description :
                 * itemlist : [{"taskId":1970,"projectId":1969,"taskcategoryId":3,"itemId":1,"serialno":"1.1.1(1)","categoryname":"安全风险分级管控/工作机制/职责分工","standard":"查资料和现场。未建立责任体系不得分，随机抽查，矿领导1人不清楚职责扣1分","demand":"建立安全风险分级管控工作责任体系，矿长全面负责，分管负责人负责分管范围内的安全风险分级管控工作","score":4,"responsibleId":95,"invited":"","rejectremark":"","resultscore":0,"resultremark":null,"systask":{"id":1970,"title":null,"tasktype":null,"description":null,"createtime":1544940715000,"creatorId":95,"state":"5","modifytime":1545058704000,"priority":null,"deleted":null,"starttime":null,"endtime":null,"auth":null,"delaytime":null,"creatorName":null,"mainTaskId":null},"responsibleName":"孔德昊","cooperatorIds":"","cooperatorNames":"","categoryname1":null,"categoryname2":null,"categoryname3":"职责分工","starttime":null,"endtime":null,"flags":1}]
                 */

                private long finishtime;
                private String title;
                private String h5url;
                private String creator;
                private long createtime;
                private boolean rejectreason;
                private String description;
                private List<ItemlistBean> itemlist;

                public long getFinishtime() {
                    return finishtime;
                }

                public void setFinishtime(long finishtime) {
                    this.finishtime = finishtime;
                }

                public String getH5url() {
                    return h5url;
                }

                public void setH5url(String h5url) {
                    this.h5url = h5url;
                }

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }

                public String getCreator() {
                    return creator;
                }

                public void setCreator(String creator) {
                    this.creator = creator;
                }

                public long getCreatetime() {
                    return createtime;
                }

                public void setCreatetime(long createtime) {
                    this.createtime = createtime;
                }

                public boolean isRejectreason() {
                    return rejectreason;
                }

                public void setRejectreason(boolean rejectreason) {
                    this.rejectreason = rejectreason;
                }

                public String getDescription() {
                    return description;
                }

                public void setDescription(String description) {
                    this.description = description;
                }

                public List<ItemlistBean> getItemlist() {
                    return itemlist;
                }

                public void setItemlist(List<ItemlistBean> itemlist) {
                    this.itemlist = itemlist;
                }

                public static class ItemlistBean {
                    /**
                     * taskId : 1970
                     * projectId : 1969
                     * taskcategoryId : 3
                     * itemId : 1
                     * serialno : 1.1.1(1)
                     * categoryname : 安全风险分级管控/工作机制/职责分工
                     * standard : 查资料和现场。未建立责任体系不得分，随机抽查，矿领导1人不清楚职责扣1分
                     * demand : 建立安全风险分级管控工作责任体系，矿长全面负责，分管负责人负责分管范围内的安全风险分级管控工作
                     * score : 4
                     * responsibleId : 95
                     * invited :
                     * rejectremark :
                     * resultscore : 0
                     * resultremark : null
                     * systask : {"id":1970,"title":null,"tasktype":null,"description":null,"createtime":1544940715000,"creatorId":95,"state":"5","modifytime":1545058704000,"priority":null,"deleted":null,"starttime":null,"endtime":null,"auth":null,"delaytime":null,"creatorName":null,"mainTaskId":null}
                     * responsibleName : 孔德昊
                     * cooperatorIds :
                     * cooperatorNames :
                     * categoryname1 : null
                     * categoryname2 : null
                     * categoryname3 : 职责分工
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
                    private int resultscore = 0;
                    private Object resultremark;
                    private SystaskBean systask;
                    private String responsibleName;
                    private String cooperatorIds;
                    private String cooperatorNames;
                    private Object categoryname1;
                    private Object categoryname2;
                    private String categoryname3;
                    private Object starttime;
                    private Object endtime;
                    private int flags;
                    private int type;

                    public boolean isSetState() {
                        return setState;
                    }

                    public void setSetState(boolean setState) {
                        this.setState = setState;
                    }

                    private boolean setState=false;




                    public int getType() {
                        return type;
                    }

                    public void setType(int type) {
                        this.type = type;
                    }

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

                    public String getCategoryname3() {
                        return categoryname3;
                    }

                    public void setCategoryname3(String categoryname3) {
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
                         * id : 1970
                         * title : null
                         * tasktype : null
                         * description : null
                         * createtime : 1544940715000
                         * creatorId : 95
                         * state : 5
                         * modifytime : 1545058704000
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
                        private Object tasktype;
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

                        public Object getTasktype() {
                            return tasktype;
                        }

                        public void setTasktype(Object tasktype) {
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
}
