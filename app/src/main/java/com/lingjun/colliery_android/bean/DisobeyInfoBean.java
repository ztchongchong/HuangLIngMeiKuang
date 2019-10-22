package com.lingjun.colliery_android.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by nefa on 2018/11/19.
 */

public class DisobeyInfoBean implements Serializable {


    /**
     * msg : 成功
     * code : 200
     * data : {"giveupappeal":"1","allowdeleteorder":"0","appealtime":"24","allowappeal":"0","closebeforeautofiling":"1","taskclauselist":[{"id":1686,"taskId":1685,"number":274,"clauseId":274,"clauseCategory":"","clauseDescription":"肩扛长柄工具在架空线巷道行走","penaltyMoney":0,"penaltyLeaderMoney":0,"penaltyScore":0,"levelName":"一般","keys":null,"chapters":null,"testCount":0,"testScore":60,"testState":0,"flags":0,"levelId":1,"resultScore":null,"systask":{"id":1686,"title":null,"tasktype":null,"description":null,"createtime":null,"creatorId":null,"state":null,"modifytime":null,"priority":null,"deleted":null,"starttime":null,"endtime":null,"auth":null,"delaytime":null,"creatorName":null,"mainTaskId":null},"levelnumber":null,"name":"帮教,停工,培训"},{"id":1687,"taskId":1685,"number":275,"clauseId":275,"clauseCategory":"","clauseDescription":"电机车司机驾驶电机车不关车门","penaltyMoney":0,"penaltyLeaderMoney":0,"penaltyScore":0,"levelName":"一般","keys":null,"chapters":null,"testCount":0,"testScore":60,"testState":0,"flags":0,"levelId":1,"resultScore":null,"systask":{"id":1687,"title":null,"tasktype":null,"description":null,"createtime":null,"creatorId":null,"state":null,"modifytime":null,"priority":null,"deleted":null,"starttime":null,"endtime":null,"auth":null,"delaytime":null,"creatorName":null,"mainTaskId":null},"levelnumber":null,"name":"帮教,停工,培训"},{"id":1688,"taskId":1685,"number":276,"clauseId":276,"clauseCategory":"","clauseDescription":"电机车司机起步停车不鸣笛","penaltyMoney":0,"penaltyLeaderMoney":0,"penaltyScore":0,"levelName":"一般","keys":null,"chapters":null,"testCount":0,"testScore":60,"testState":0,"flags":0,"levelId":1,"resultScore":null,"systask":{"id":1688,"title":null,"tasktype":null,"description":null,"createtime":null,"creatorId":null,"state":null,"modifytime":null,"priority":null,"deleted":null,"starttime":null,"endtime":null,"auth":null,"delaytime":null,"creatorName":null,"mainTaskId":null},"levelnumber":null,"name":"帮教,停工,培训"}],"refusereason":"1","disobeytask":{"taskId":1685,"behavior":"哈哈哈","canAppeal":"0","number":"201811170001","responsibleDepartmentScore":null,"responsibleDepartmentId":1128,"responsibleDepartmentName":"通风防火科","responsibleUserMoney":null,"responsibleUserId":1131,"responsibleUserName":"张鹏飞","responsibleLeaderMoney":null,"responsibleLeaderId":1130,"responsibleLeaderName":"杨建平","responsibleLeaderRemark":null,"approverId":39,"approverRemark":null,"appealType":null,"appealReason":null,"adminId":1326,"adminRemark":null,"startTime":1542454862000,"endTime":null,"flags":0,"state":"8","deleted":"0","approverName":"段玉喜","adminName":"郭高民","user":null,"extraType":"1,2,3","extraMoney":200,"name":null,"discovererId":0,"discovererName":null,"showtime":null},"allowarbitration":"1","disobeytaskdoc":[{"taskId":null,"docId":null,"docUsage":null,"number":null,"url":"/upload/1542454848388.png","fileId":1684,"swfUrl":null,"fileName":"1542454848388.png"}],"closeappeal":"1","url":"http://192.168.1.183:8888/safety/"}
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

    public static class DataBean implements Serializable {
        /**
         * giveupappeal : 1
         * allowdeleteorder : 0
         * appealtime : 24
         * allowappeal : 0
         * closebeforeautofiling : 1
         * taskclauselist : [{"id":1686,"taskId":1685,"number":274,"clauseId":274,"clauseCategory":"","clauseDescription":"肩扛长柄工具在架空线巷道行走","penaltyMoney":0,"penaltyLeaderMoney":0,"penaltyScore":0,"levelName":"一般","keys":null,"chapters":null,"testCount":0,"testScore":60,"testState":0,"flags":0,"levelId":1,"resultScore":null,"systask":{"id":1686,"title":null,"tasktype":null,"description":null,"createtime":null,"creatorId":null,"state":null,"modifytime":null,"priority":null,"deleted":null,"starttime":null,"endtime":null,"auth":null,"delaytime":null,"creatorName":null,"mainTaskId":null},"levelnumber":null,"name":"帮教,停工,培训"},{"id":1687,"taskId":1685,"number":275,"clauseId":275,"clauseCategory":"","clauseDescription":"电机车司机驾驶电机车不关车门","penaltyMoney":0,"penaltyLeaderMoney":0,"penaltyScore":0,"levelName":"一般","keys":null,"chapters":null,"testCount":0,"testScore":60,"testState":0,"flags":0,"levelId":1,"resultScore":null,"systask":{"id":1687,"title":null,"tasktype":null,"description":null,"createtime":null,"creatorId":null,"state":null,"modifytime":null,"priority":null,"deleted":null,"starttime":null,"endtime":null,"auth":null,"delaytime":null,"creatorName":null,"mainTaskId":null},"levelnumber":null,"name":"帮教,停工,培训"},{"id":1688,"taskId":1685,"number":276,"clauseId":276,"clauseCategory":"","clauseDescription":"电机车司机起步停车不鸣笛","penaltyMoney":0,"penaltyLeaderMoney":0,"penaltyScore":0,"levelName":"一般","keys":null,"chapters":null,"testCount":0,"testScore":60,"testState":0,"flags":0,"levelId":1,"resultScore":null,"systask":{"id":1688,"title":null,"tasktype":null,"description":null,"createtime":null,"creatorId":null,"state":null,"modifytime":null,"priority":null,"deleted":null,"starttime":null,"endtime":null,"auth":null,"delaytime":null,"creatorName":null,"mainTaskId":null},"levelnumber":null,"name":"帮教,停工,培训"}]
         * refusereason : 1
         * disobeytask : {"taskId":1685,"behavior":"哈哈哈","canAppeal":"0","number":"201811170001","responsibleDepartmentScore":null,"responsibleDepartmentId":1128,"responsibleDepartmentName":"通风防火科","responsibleUserMoney":null,"responsibleUserId":1131,"responsibleUserName":"张鹏飞","responsibleLeaderMoney":null,"responsibleLeaderId":1130,"responsibleLeaderName":"杨建平","responsibleLeaderRemark":null,"approverId":39,"approverRemark":null,"appealType":null,"appealReason":null,"adminId":1326,"adminRemark":null,"startTime":1542454862000,"endTime":null,"flags":0,"state":"8","deleted":"0","approverName":"段玉喜","adminName":"郭高民","user":null,"extraType":"1,2,3","extraMoney":200,"name":null,"discovererId":0,"discovererName":null,"showtime":null}
         * allowarbitration : 1
         * disobeytaskdoc : [{"taskId":null,"docId":null,"docUsage":null,"number":null,"url":"/upload/1542454848388.png","fileId":1684,"swfUrl":null,"fileName":"1542454848388.png"}]
         * closeappeal : 1
         * url : http://192.168.1.183:8888/safety/
         */

        private String giveupappeal;
        private String allowdeleteorder;
        private String appealtime;
        private String allowappeal;
        private String closebeforeautofiling;
        private String refusereason;
        private DisobeytaskBean disobeytask;
        private String allowarbitration;
        private String closeappeal;
        private String url;
        private ArrayList<TaskclauselistBean> taskclauselist;
        private ArrayList<DisobeytaskdocBean> disobeytaskdoc;

        public String getResponsibleUserPhone() {
            return responsibleUserPhone;
        }

        public void setResponsibleUserPhone(String responsibleUserPhone) {
            this.responsibleUserPhone = responsibleUserPhone;
        }

        private String responsibleUserPhone;

        public String getGiveupappeal() {
            return giveupappeal;
        }

        public void setGiveupappeal(String giveupappeal) {
            this.giveupappeal = giveupappeal;
        }

        public String getAllowdeleteorder() {
            return allowdeleteorder;
        }

        public void setAllowdeleteorder(String allowdeleteorder) {
            this.allowdeleteorder = allowdeleteorder;
        }

        public String getAppealtime() {
            return appealtime;
        }

        public void setAppealtime(String appealtime) {
            this.appealtime = appealtime;
        }

        public String getAllowappeal() {
            return allowappeal;
        }

        public void setAllowappeal(String allowappeal) {
            this.allowappeal = allowappeal;
        }

        public String getClosebeforeautofiling() {
            return closebeforeautofiling;
        }

        public void setClosebeforeautofiling(String closebeforeautofiling) {
            this.closebeforeautofiling = closebeforeautofiling;
        }

        public String getRefusereason() {
            return refusereason;
        }

        public void setRefusereason(String refusereason) {
            this.refusereason = refusereason;
        }

        public DisobeytaskBean getDisobeytask() {
            return disobeytask;
        }

        public void setDisobeytask(DisobeytaskBean disobeytask) {
            this.disobeytask = disobeytask;
        }

        public String getAllowarbitration() {
            return allowarbitration;
        }

        public void setAllowarbitration(String allowarbitration) {
            this.allowarbitration = allowarbitration;
        }

        public String getCloseappeal() {
            return closeappeal;
        }

        public void setCloseappeal(String closeappeal) {
            this.closeappeal = closeappeal;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public ArrayList<TaskclauselistBean> getTaskclauselist() {
            return taskclauselist;
        }

        public void setTaskclauselist(ArrayList<TaskclauselistBean> taskclauselist) {
            this.taskclauselist = taskclauselist;
        }

        public ArrayList<DisobeytaskdocBean> getDisobeytaskdoc() {
            return disobeytaskdoc;
        }

        public void setDisobeytaskdoc(ArrayList<DisobeytaskdocBean> disobeytaskdoc) {
            this.disobeytaskdoc = disobeytaskdoc;
        }

        public static class DisobeytaskBean implements Serializable {
            /**
             * taskId : 1685
             * behavior : 哈哈哈
             * canAppeal : 0
             * number : 201811170001
             * responsibleDepartmentScore : null
             * responsibleDepartmentId : 1128
             * responsibleDepartmentName : 通风防火科
             * responsibleUserMoney : null
             * responsibleUserId : 1131
             * responsibleUserName : 张鹏飞
             * responsibleLeaderMoney : null
             * responsibleLeaderId : 1130
             * responsibleLeaderName : 杨建平
             * responsibleLeaderRemark : null
             * approverId : 39
             * approverRemark : null
             * appealType : null
             * appealReason : null
             * adminId : 1326
             * adminRemark : null
             * startTime : 1542454862000
             * endTime : null
             * flags : 0
             * state : 8
             * deleted : 0
             * approverName : 段玉喜
             * adminName : 郭高民
             * user : null
             * extraType : 1,2,3
             * extraMoney : 200
             * name : null
             * discovererId : 0
             * discovererName : null
             * showtime : null
             */

            private int taskId;
            private String behavior;
            private String canAppeal;
            private String number;
            private Object responsibleDepartmentScore;
            private int responsibleDepartmentId;
            private String responsibleDepartmentName;
            private Object responsibleUserMoney;
            private int responsibleUserId;
            private String responsibleUserName;
            private Object responsibleLeaderMoney;
            private String responsibleLeaderId;
            private String responsibleLeaderName;
            private Object responsibleLeaderRemark;
            private int approverId;
            private Object approverRemark;
            private Object appealType;
            private Object appealReason;
            private int adminId;
            private Object adminRemark;
            private long startTime;
            private Object endTime;
            private int flags;
            private String state;
            private String deleted;
            private String approverName;
            private String adminName;
            private Object user;
            private String extraType;
            private int extraMoney;
            private String name;
            private int discovererId;
            private String discovererName;
            private Object showtime;
            private int taskType;
            private String clauseDescription;
            private int levelId;

            public int getTaskType() {
                return taskType;
            }

            public void setTaskType(int taskType) {
                this.taskType = taskType;
            }

            public String getClauseDescription() {
                return clauseDescription;
            }

            public void setClauseDescription(String clauseDescription) {
                this.clauseDescription = clauseDescription;
            }


            public int getLevelId() {
                return levelId;
            }

            public void setLevelId(int levelId) {
                this.levelId = levelId;
            }


            public int getTaskId() {
                return taskId;
            }

            public void setTaskId(int taskId) {
                this.taskId = taskId;
            }

            public String getBehavior() {
                return behavior;
            }

            public void setBehavior(String behavior) {
                this.behavior = behavior;
            }

            public String getCanAppeal() {
                return canAppeal;
            }

            public void setCanAppeal(String canAppeal) {
                this.canAppeal = canAppeal;
            }

            public String getNumber() {
                return number;
            }

            public void setNumber(String number) {
                this.number = number;
            }

            public Object getResponsibleDepartmentScore() {
                return responsibleDepartmentScore;
            }

            public void setResponsibleDepartmentScore(Object responsibleDepartmentScore) {
                this.responsibleDepartmentScore = responsibleDepartmentScore;
            }

            public int getResponsibleDepartmentId() {
                return responsibleDepartmentId;
            }

            public void setResponsibleDepartmentId(int responsibleDepartmentId) {
                this.responsibleDepartmentId = responsibleDepartmentId;
            }

            public String getResponsibleDepartmentName() {
                return responsibleDepartmentName;
            }

            public void setResponsibleDepartmentName(String responsibleDepartmentName) {
                this.responsibleDepartmentName = responsibleDepartmentName;
            }

            public Object getResponsibleUserMoney() {
                return responsibleUserMoney;
            }

            public void setResponsibleUserMoney(Object responsibleUserMoney) {
                this.responsibleUserMoney = responsibleUserMoney;
            }

            public int getResponsibleUserId() {
                return responsibleUserId;
            }

            public void setResponsibleUserId(int responsibleUserId) {
                this.responsibleUserId = responsibleUserId;
            }

            public String getResponsibleUserName() {
                return responsibleUserName;
            }

            public void setResponsibleUserName(String responsibleUserName) {
                this.responsibleUserName = responsibleUserName;
            }

            public Object getResponsibleLeaderMoney() {
                return responsibleLeaderMoney;
            }

            public void setResponsibleLeaderMoney(Object responsibleLeaderMoney) {
                this.responsibleLeaderMoney = responsibleLeaderMoney;
            }

            public String getResponsibleLeaderId() {
                return responsibleLeaderId;
            }

            public void setResponsibleLeaderId(String responsibleLeaderId) {
                this.responsibleLeaderId = responsibleLeaderId;
            }

            public String getResponsibleLeaderName() {
                return responsibleLeaderName;
            }

            public void setResponsibleLeaderName(String responsibleLeaderName) {
                this.responsibleLeaderName = responsibleLeaderName;
            }

            public Object getResponsibleLeaderRemark() {
                return responsibleLeaderRemark;
            }

            public void setResponsibleLeaderRemark(Object responsibleLeaderRemark) {
                this.responsibleLeaderRemark = responsibleLeaderRemark;
            }

            public int getApproverId() {
                return approverId;
            }

            public void setApproverId(int approverId) {
                this.approverId = approverId;
            }

            public Object getApproverRemark() {
                return approverRemark;
            }

            public void setApproverRemark(Object approverRemark) {
                this.approverRemark = approverRemark;
            }

            public Object getAppealType() {
                return appealType;
            }

            public void setAppealType(Object appealType) {
                this.appealType = appealType;
            }

            public Object getAppealReason() {
                return appealReason;
            }

            public void setAppealReason(Object appealReason) {
                this.appealReason = appealReason;
            }

            public int getAdminId() {
                return adminId;
            }

            public void setAdminId(int adminId) {
                this.adminId = adminId;
            }

            public Object getAdminRemark() {
                return adminRemark;
            }

            public void setAdminRemark(Object adminRemark) {
                this.adminRemark = adminRemark;
            }

            public long getStartTime() {
                return startTime;
            }

            public void setStartTime(long startTime) {
                this.startTime = startTime;
            }

            public Object getEndTime() {
                return endTime;
            }

            public void setEndTime(Object endTime) {
                this.endTime = endTime;
            }

            public int getFlags() {
                return flags;
            }

            public void setFlags(int flags) {
                this.flags = flags;
            }

            public String getState() {
                return state;
            }

            public void setState(String state) {
                this.state = state;
            }

            public String getDeleted() {
                return deleted;
            }

            public void setDeleted(String deleted) {
                this.deleted = deleted;
            }

            public String getApproverName() {
                return approverName;
            }

            public void setApproverName(String approverName) {
                this.approverName = approverName;
            }

            public String getAdminName() {
                return adminName;
            }

            public void setAdminName(String adminName) {
                this.adminName = adminName;
            }

            public Object getUser() {
                return user;
            }

            public void setUser(Object user) {
                this.user = user;
            }

            public String getExtraType() {
                return extraType;
            }

            public void setExtraType(String extraType) {
                this.extraType = extraType;
            }

            public int getExtraMoney() {
                return extraMoney;
            }

            public void setExtraMoney(int extraMoney) {
                this.extraMoney = extraMoney;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public int getDiscovererId() {
                return discovererId;
            }

            public void setDiscovererId(int discovererId) {
                this.discovererId = discovererId;
            }

            public String getDiscovererName() {
                return discovererName;
            }

            public void setDiscovererName(String discovererName) {
                this.discovererName = discovererName;
            }

            public Object getShowtime() {
                return showtime;
            }

            public void setShowtime(Object showtime) {
                this.showtime = showtime;
            }
        }

        public static class TaskclauselistBean implements Serializable {
            /**
             * id : 1686
             * taskId : 1685
             * number : 274
             * clauseId : 274
             * clauseCategory :
             * clauseDescription : 肩扛长柄工具在架空线巷道行走
             * penaltyMoney : 0
             * penaltyLeaderMoney : 0
             * penaltyScore : 0
             * levelName : 一般
             * keys : null
             * chapters : null
             * testCount : 0
             * testScore : 60
             * testState : 0
             * flags : 0
             * levelId : 1
             * resultScore : null
             * systask : {"id":1686,"title":null,"tasktype":null,"description":null,"createtime":null,"creatorId":null,"state":null,"modifytime":null,"priority":null,"deleted":null,"starttime":null,"endtime":null,"auth":null,"delaytime":null,"creatorName":null,"mainTaskId":null}
             * levelnumber : null
             * name : 帮教,停工,培训
             */

            private int id;
            private int taskId;
            private int number;
            private int clauseId;
            private String clauseCategory;
            private String clauseDescription;
            private int penaltyMoney;
            private int penaltyLeaderMoney;
            private int penaltyScore;
            private String levelName;
            private Object keys;
            private Object chapters;
            private int testCount;
            private int testScore;
            private int testState;
            private int flags;
            private int levelId;
            private Object resultScore;
            private SystaskBean systask;
            private Object levelnumber;
            private String name;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getTaskId() {
                return taskId;
            }

            public void setTaskId(int taskId) {
                this.taskId = taskId;
            }

            public int getNumber() {
                return number;
            }

            public void setNumber(int number) {
                this.number = number;
            }

            public int getClauseId() {
                return clauseId;
            }

            public void setClauseId(int clauseId) {
                this.clauseId = clauseId;
            }

            public String getClauseCategory() {
                return clauseCategory;
            }

            public void setClauseCategory(String clauseCategory) {
                this.clauseCategory = clauseCategory;
            }

            public String getClauseDescription() {
                return clauseDescription;
            }

            public void setClauseDescription(String clauseDescription) {
                this.clauseDescription = clauseDescription;
            }

            public int getPenaltyMoney() {
                return penaltyMoney;
            }

            public void setPenaltyMoney(int penaltyMoney) {
                this.penaltyMoney = penaltyMoney;
            }

            public int getPenaltyLeaderMoney() {
                return penaltyLeaderMoney;
            }

            public void setPenaltyLeaderMoney(int penaltyLeaderMoney) {
                this.penaltyLeaderMoney = penaltyLeaderMoney;
            }

            public int getPenaltyScore() {
                return penaltyScore;
            }

            public void setPenaltyScore(int penaltyScore) {
                this.penaltyScore = penaltyScore;
            }

            public String getLevelName() {
                return levelName;
            }

            public void setLevelName(String levelName) {
                this.levelName = levelName;
            }

            public Object getKeys() {
                return keys;
            }

            public void setKeys(Object keys) {
                this.keys = keys;
            }

            public Object getChapters() {
                return chapters;
            }

            public void setChapters(Object chapters) {
                this.chapters = chapters;
            }

            public int getTestCount() {
                return testCount;
            }

            public void setTestCount(int testCount) {
                this.testCount = testCount;
            }

            public int getTestScore() {
                return testScore;
            }

            public void setTestScore(int testScore) {
                this.testScore = testScore;
            }

            public int getTestState() {
                return testState;
            }

            public void setTestState(int testState) {
                this.testState = testState;
            }

            public int getFlags() {
                return flags;
            }

            public void setFlags(int flags) {
                this.flags = flags;
            }

            public int getLevelId() {
                return levelId;
            }

            public void setLevelId(int levelId) {
                this.levelId = levelId;
            }

            public Object getResultScore() {
                return resultScore;
            }

            public void setResultScore(Object resultScore) {
                this.resultScore = resultScore;
            }

            public SystaskBean getSystask() {
                return systask;
            }

            public void setSystask(SystaskBean systask) {
                this.systask = systask;
            }

            public Object getLevelnumber() {
                return levelnumber;
            }

            public void setLevelnumber(Object levelnumber) {
                this.levelnumber = levelnumber;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public static class SystaskBean implements Serializable {
                /**
                 * id : 1686
                 * title : null
                 * tasktype : null
                 * description : null
                 * createtime : null
                 * creatorId : null
                 * state : null
                 * modifytime : null
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
                private Object createtime;
                private Object creatorId;
                private Object state;
                private Object modifytime;
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

                public Object getCreatetime() {
                    return createtime;
                }

                public void setCreatetime(Object createtime) {
                    this.createtime = createtime;
                }

                public Object getCreatorId() {
                    return creatorId;
                }

                public void setCreatorId(Object creatorId) {
                    this.creatorId = creatorId;
                }

                public Object getState() {
                    return state;
                }

                public void setState(Object state) {
                    this.state = state;
                }

                public Object getModifytime() {
                    return modifytime;
                }

                public void setModifytime(Object modifytime) {
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

        public static class DisobeytaskdocBean implements Serializable {
            /**
             * taskId : null
             * docId : null
             * docUsage : null
             * number : null
             * url : /upload/1542454848388.png
             * fileId : 1684
             * swfUrl : null
             * fileName : 1542454848388.png
             */

            private Object taskId;
            private Object docId;
            private Object docUsage;
            private Object number;
            private String url;
            private int fileId;
            private Object swfUrl;
            private String fileName;

            public Object getTaskId() {
                return taskId;
            }

            public void setTaskId(Object taskId) {
                this.taskId = taskId;
            }

            public Object getDocId() {
                return docId;
            }

            public void setDocId(Object docId) {
                this.docId = docId;
            }

            public Object getDocUsage() {
                return docUsage;
            }

            public void setDocUsage(Object docUsage) {
                this.docUsage = docUsage;
            }

            public Object getNumber() {
                return number;
            }

            public void setNumber(Object number) {
                this.number = number;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public int getFileId() {
                return fileId;
            }

            public void setFileId(int fileId) {
                this.fileId = fileId;
            }

            public Object getSwfUrl() {
                return swfUrl;
            }

            public void setSwfUrl(Object swfUrl) {
                this.swfUrl = swfUrl;
            }

            public String getFileName() {
                return fileName;
            }

            public void setFileName(String fileName) {
                this.fileName = fileName;
            }
        }
    }
}
