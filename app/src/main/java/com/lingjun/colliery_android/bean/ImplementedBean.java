package com.lingjun.colliery_android.bean;

import java.util.List;

/**
 * 作者: zengtao
 * 时间: 2018/12/5  9:31.
 * 注释:
 */
public class ImplementedBean {


    /**
     * msg : 成功
     * data : {"url":"http://134.175.189.65:8888/safety/","riskcontrolTrouble":{"riskcontrolSourceMeasures":"1、综放工作面初采初放前制定专项安全技术措施，进行两巷预裂爆破；区队加强上下隅角支护材料的拆除并落实好上隅角埋管抽放措施。","states":2,"planName":"11","riskcontrolLevelId":1,"planId":2,"riskcontrolDescription":"回采工作面初采初放上下隅角悬顶距离过大，有可能突然大面积垮落，瓦斯涌出","riskcontrolSourceId":13,"measures":{"lastCheckdate":"2018-12-28","nextCheckdate":"2019-1-28","checkCycle":"2","modifyTime":1545882332000,"checkdate":28,"measures":"有图两月","publisherId":95,"beginDate":1545840000000,"id":3985,"publisherName":"孔德昊","fileCycle":"2","responsibleId":95,"checkState":"0","saveType":3,"responsibleName":"孔德昊"},"riskcontrolSourceDescription":"回采工作面初采初放上下隅角悬顶距离过大，有可能突然大面积垮落，瓦斯涌出","publisherId":95,"riskcontrolAreaId":16,"id":3985,"publisherName":"孔德昊","deleted":0,"riskcontrolCategoryName":"瓦斯","riskcontrolLevelName":"一般","riskcontrolCategoryId":2,"closeplanId":0,"riskcontrolAreaName":"副井","implementcounts":0,"publisherTime":1545882304000},"planlist":[{"remarks":"2018年风险分级管控","publisherId":97,"title":"2018年风险分级管控","id":1,"deleted":0,"enabled":1,"responsibleId":1,"troublecount":0,"planTime":1542816000000,"publisherTime":1542873978000,"responsibleName":"岳东"},{"remarks":"111","userIds":"4","publisherId":95,"title":"11","id":2,"deleted":0,"enabled":1,"userNames":"马铜生","responsibleId":2,"troublecount":0,"planTime":1544976000000,"publisherTime":1544925227000,"responsibleName":"田战强"}],"taskloglist":[{"taskType":"15","operator":"孔德昊","datas":"{'measures':'{\"beginDate\":1545840000000,\"checkCycle\":\"2\",\"checkState\":\"0\",\"checkdate\":28,\"fileCycle\":\"2\",\"id\":3985,\"lastCheckdate\":\"\",\"measures\":\"有图两月\",\"modifyTime\":1545882332365,\"nextCheckdate\":\"2018-12-28\",\"publisherId\":95,\"publisherName\":\"孔德昊\",\"responsibleId\":95,\"responsibleName\":\"孔德昊\",\"saveType\":3}'}","action":"2","id":1089,"remark":"添加措施","data":"有图两月","operatorId":95,"timestamp":1545882332000,"result":"成功","taskId":3985},{"taskType":"15","operator":"孔德昊","action":"1","id":1088,"remark":"录入风险","operatorId":95,"timestamp":1545882304000,"result":"成功","taskId":3985}],"imglist":[{"fileName":"1545882302943.jpg","url":"/upload/1545882302943.jpg","troubleId":0,"fileId":3983},{"fileName":"1545882303115.jpg","url":"/upload/1545882303115.jpg","troubleId":0,"fileId":3984}]}
     * code : 200
     * resultMaps : []
     */

    private String msg;
    private DataBean data;
    private String code;
    private List<?> resultMaps;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<?> getResultMaps() {
        return resultMaps;
    }

    public void setResultMaps(List<?> resultMaps) {
        this.resultMaps = resultMaps;
    }

    public static class DataBean {
        /**
         * url : http://134.175.189.65:8888/safety/
         * riskcontrolTrouble : {"riskcontrolSourceMeasures":"1、综放工作面初采初放前制定专项安全技术措施，进行两巷预裂爆破；区队加强上下隅角支护材料的拆除并落实好上隅角埋管抽放措施。","states":2,"planName":"11","riskcontrolLevelId":1,"planId":2,"riskcontrolDescription":"回采工作面初采初放上下隅角悬顶距离过大，有可能突然大面积垮落，瓦斯涌出","riskcontrolSourceId":13,"measures":{"lastCheckdate":"2018-12-28","nextCheckdate":"2019-1-28","checkCycle":"2","modifyTime":1545882332000,"checkdate":28,"measures":"有图两月","publisherId":95,"beginDate":1545840000000,"id":3985,"publisherName":"孔德昊","fileCycle":"2","responsibleId":95,"checkState":"0","saveType":3,"responsibleName":"孔德昊"},"riskcontrolSourceDescription":"回采工作面初采初放上下隅角悬顶距离过大，有可能突然大面积垮落，瓦斯涌出","publisherId":95,"riskcontrolAreaId":16,"id":3985,"publisherName":"孔德昊","deleted":0,"riskcontrolCategoryName":"瓦斯","riskcontrolLevelName":"一般","riskcontrolCategoryId":2,"closeplanId":0,"riskcontrolAreaName":"副井","implementcounts":0,"publisherTime":1545882304000}
         * planlist : [{"remarks":"2018年风险分级管控","publisherId":97,"title":"2018年风险分级管控","id":1,"deleted":0,"enabled":1,"responsibleId":1,"troublecount":0,"planTime":1542816000000,"publisherTime":1542873978000,"responsibleName":"岳东"},{"remarks":"111","userIds":"4","publisherId":95,"title":"11","id":2,"deleted":0,"enabled":1,"userNames":"马铜生","responsibleId":2,"troublecount":0,"planTime":1544976000000,"publisherTime":1544925227000,"responsibleName":"田战强"}]
         * taskloglist : [{"taskType":"15","operator":"孔德昊","datas":"{'measures':'{\"beginDate\":1545840000000,\"checkCycle\":\"2\",\"checkState\":\"0\",\"checkdate\":28,\"fileCycle\":\"2\",\"id\":3985,\"lastCheckdate\":\"\",\"measures\":\"有图两月\",\"modifyTime\":1545882332365,\"nextCheckdate\":\"2018-12-28\",\"publisherId\":95,\"publisherName\":\"孔德昊\",\"responsibleId\":95,\"responsibleName\":\"孔德昊\",\"saveType\":3}'}","action":"2","id":1089,"remark":"添加措施","data":"有图两月","operatorId":95,"timestamp":1545882332000,"result":"成功","taskId":3985},{"taskType":"15","operator":"孔德昊","action":"1","id":1088,"remark":"录入风险","operatorId":95,"timestamp":1545882304000,"result":"成功","taskId":3985}]
         * imglist : [{"fileName":"1545882302943.jpg","url":"/upload/1545882302943.jpg","troubleId":0,"fileId":3983},{"fileName":"1545882303115.jpg","url":"/upload/1545882303115.jpg","troubleId":0,"fileId":3984}]
         */

        private String url;
        private RiskcontrolTroubleBean riskcontrolTrouble;
        private List<PlanlistBean> planlist;
        private List<TaskloglistBean> taskloglist;
        private List<ImglistBean> imglist;


        public ImplementBean getImplement() {
            return implement;
        }

        public void setImplement(ImplementBean implement) {
            this.implement = implement;
        }

        private ImplementBean implement;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public RiskcontrolTroubleBean getRiskcontrolTrouble() {
            return riskcontrolTrouble;
        }

        public void setRiskcontrolTrouble(RiskcontrolTroubleBean riskcontrolTrouble) {
            this.riskcontrolTrouble = riskcontrolTrouble;
        }

        public List<PlanlistBean> getPlanlist() {
            return planlist;
        }

        public void setPlanlist(List<PlanlistBean> planlist) {
            this.planlist = planlist;
        }

        public List<TaskloglistBean> getTaskloglist() {
            return taskloglist;
        }

        public void setTaskloglist(List<TaskloglistBean> taskloglist) {
            this.taskloglist = taskloglist;
        }

        public List<ImglistBean> getImglist() {
            return imglist;
        }

        public void setImglist(List<ImglistBean> imglist) {
            this.imglist = imglist;
        }

        public static class RiskcontrolTroubleBean {
            /**
             * riskcontrolSourceMeasures : 1、综放工作面初采初放前制定专项安全技术措施，进行两巷预裂爆破；区队加强上下隅角支护材料的拆除并落实好上隅角埋管抽放措施。
             * states : 2
             * planName : 11
             * riskcontrolLevelId : 1
             * planId : 2
             * riskcontrolDescription : 回采工作面初采初放上下隅角悬顶距离过大，有可能突然大面积垮落，瓦斯涌出
             * riskcontrolSourceId : 13
             * measures : {"lastCheckdate":"2018-12-28","nextCheckdate":"2019-1-28","checkCycle":"2","modifyTime":1545882332000,"checkdate":28,"measures":"有图两月","publisherId":95,"beginDate":1545840000000,"id":3985,"publisherName":"孔德昊","fileCycle":"2","responsibleId":95,"checkState":"0","saveType":3,"responsibleName":"孔德昊"}
             * riskcontrolSourceDescription : 回采工作面初采初放上下隅角悬顶距离过大，有可能突然大面积垮落，瓦斯涌出
             * publisherId : 95
             * riskcontrolAreaId : 16
             * id : 3985
             * publisherName : 孔德昊
             * deleted : 0
             * riskcontrolCategoryName : 瓦斯
             * riskcontrolLevelName : 一般
             * riskcontrolCategoryId : 2
             * closeplanId : 0
             * riskcontrolAreaName : 副井
             * implementcounts : 0
             * publisherTime : 1545882304000
             */

            private String riskcontrolSourceMeasures;
            private int states;
            private String planName;
            private int riskcontrolLevelId;
            private int planId;
            private String riskcontrolDescription;
            private int riskcontrolSourceId;
            private MeasuresBean measures;
            private String riskcontrolSourceDescription;
            private int publisherId;
            private int riskcontrolAreaId;
            private int id;
            private String publisherName;
            private int deleted;
            private String riskcontrolCategoryName;
            private String riskcontrolLevelName;
            private int riskcontrolCategoryId;
            private int closeplanId;
            private String riskcontrolAreaName;
            private int implementcounts;
            private long publisherTime;

            public String getRiskcontrolSourceMeasures() {
                return riskcontrolSourceMeasures;
            }

            public void setRiskcontrolSourceMeasures(String riskcontrolSourceMeasures) {
                this.riskcontrolSourceMeasures = riskcontrolSourceMeasures;
            }

            public int getStates() {
                return states;
            }

            public void setStates(int states) {
                this.states = states;
            }

            public String getPlanName() {
                return planName;
            }

            public void setPlanName(String planName) {
                this.planName = planName;
            }

            public int getRiskcontrolLevelId() {
                return riskcontrolLevelId;
            }

            public void setRiskcontrolLevelId(int riskcontrolLevelId) {
                this.riskcontrolLevelId = riskcontrolLevelId;
            }

            public int getPlanId() {
                return planId;
            }

            public void setPlanId(int planId) {
                this.planId = planId;
            }

            public String getRiskcontrolDescription() {
                return riskcontrolDescription;
            }

            public void setRiskcontrolDescription(String riskcontrolDescription) {
                this.riskcontrolDescription = riskcontrolDescription;
            }

            public int getRiskcontrolSourceId() {
                return riskcontrolSourceId;
            }

            public void setRiskcontrolSourceId(int riskcontrolSourceId) {
                this.riskcontrolSourceId = riskcontrolSourceId;
            }

            public MeasuresBean getMeasures() {
                return measures;
            }

            public void setMeasures(MeasuresBean measures) {
                this.measures = measures;
            }

            public String getRiskcontrolSourceDescription() {
                return riskcontrolSourceDescription;
            }

            public void setRiskcontrolSourceDescription(String riskcontrolSourceDescription) {
                this.riskcontrolSourceDescription = riskcontrolSourceDescription;
            }

            public int getPublisherId() {
                return publisherId;
            }

            public void setPublisherId(int publisherId) {
                this.publisherId = publisherId;
            }

            public int getRiskcontrolAreaId() {
                return riskcontrolAreaId;
            }

            public void setRiskcontrolAreaId(int riskcontrolAreaId) {
                this.riskcontrolAreaId = riskcontrolAreaId;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getPublisherName() {
                return publisherName;
            }

            public void setPublisherName(String publisherName) {
                this.publisherName = publisherName;
            }

            public int getDeleted() {
                return deleted;
            }

            public void setDeleted(int deleted) {
                this.deleted = deleted;
            }

            public String getRiskcontrolCategoryName() {
                return riskcontrolCategoryName;
            }

            public void setRiskcontrolCategoryName(String riskcontrolCategoryName) {
                this.riskcontrolCategoryName = riskcontrolCategoryName;
            }

            public String getRiskcontrolLevelName() {
                return riskcontrolLevelName;
            }

            public void setRiskcontrolLevelName(String riskcontrolLevelName) {
                this.riskcontrolLevelName = riskcontrolLevelName;
            }

            public int getRiskcontrolCategoryId() {
                return riskcontrolCategoryId;
            }

            public void setRiskcontrolCategoryId(int riskcontrolCategoryId) {
                this.riskcontrolCategoryId = riskcontrolCategoryId;
            }

            public int getCloseplanId() {
                return closeplanId;
            }

            public void setCloseplanId(int closeplanId) {
                this.closeplanId = closeplanId;
            }

            public String getRiskcontrolAreaName() {
                return riskcontrolAreaName;
            }

            public void setRiskcontrolAreaName(String riskcontrolAreaName) {
                this.riskcontrolAreaName = riskcontrolAreaName;
            }

            public int getImplementcounts() {
                return implementcounts;
            }

            public void setImplementcounts(int implementcounts) {
                this.implementcounts = implementcounts;
            }

            public long getPublisherTime() {
                return publisherTime;
            }

            public void setPublisherTime(long publisherTime) {
                this.publisherTime = publisherTime;
            }

            public static class MeasuresBean {
                /**
                 * lastCheckdate : 2018-12-28
                 * nextCheckdate : 2019-1-28
                 * checkCycle : 2
                 * modifyTime : 1545882332000
                 * checkdate : 28
                 * measures : 有图两月
                 * publisherId : 95
                 * beginDate : 1545840000000
                 * id : 3985
                 * publisherName : 孔德昊
                 * fileCycle : 2
                 * responsibleId : 95
                 * checkState : 0
                 * saveType : 3
                 * responsibleName : 孔德昊
                 */

                private String lastCheckdate;
                private String nextCheckdate;
                private String checkCycle;
                private long modifyTime;
                private int checkdate;
                private String measures;
                private int publisherId;
                private long beginDate;
                private int id;
                private String publisherName;
                private String fileCycle;
                private int responsibleId;
                private String checkState;
                private int saveType;
                private String responsibleName;

                public String getLastCheckdate() {
                    return lastCheckdate;
                }

                public void setLastCheckdate(String lastCheckdate) {
                    this.lastCheckdate = lastCheckdate;
                }

                public String getNextCheckdate() {
                    return nextCheckdate;
                }

                public void setNextCheckdate(String nextCheckdate) {
                    this.nextCheckdate = nextCheckdate;
                }

                public String getCheckCycle() {
                    return checkCycle;
                }

                public void setCheckCycle(String checkCycle) {
                    this.checkCycle = checkCycle;
                }

                public long getModifyTime() {
                    return modifyTime;
                }

                public void setModifyTime(long modifyTime) {
                    this.modifyTime = modifyTime;
                }

                public int getCheckdate() {
                    return checkdate;
                }

                public void setCheckdate(int checkdate) {
                    this.checkdate = checkdate;
                }

                public String getMeasures() {
                    return measures;
                }

                public void setMeasures(String measures) {
                    this.measures = measures;
                }

                public int getPublisherId() {
                    return publisherId;
                }

                public void setPublisherId(int publisherId) {
                    this.publisherId = publisherId;
                }

                public long getBeginDate() {
                    return beginDate;
                }

                public void setBeginDate(long beginDate) {
                    this.beginDate = beginDate;
                }

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getPublisherName() {
                    return publisherName;
                }

                public void setPublisherName(String publisherName) {
                    this.publisherName = publisherName;
                }

                public String getFileCycle() {
                    return fileCycle;
                }

                public void setFileCycle(String fileCycle) {
                    this.fileCycle = fileCycle;
                }

                public int getResponsibleId() {
                    return responsibleId;
                }

                public void setResponsibleId(int responsibleId) {
                    this.responsibleId = responsibleId;
                }

                public String getCheckState() {
                    return checkState;
                }

                public void setCheckState(String checkState) {
                    this.checkState = checkState;
                }

                public int getSaveType() {
                    return saveType;
                }

                public void setSaveType(int saveType) {
                    this.saveType = saveType;
                }

                public String getResponsibleName() {
                    return responsibleName;
                }

                public void setResponsibleName(String responsibleName) {
                    this.responsibleName = responsibleName;
                }
            }
        }

        public static class PlanlistBean {
            /**
             * remarks : 2018年风险分级管控
             * publisherId : 97
             * title : 2018年风险分级管控
             * id : 1
             * deleted : 0
             * enabled : 1
             * responsibleId : 1
             * troublecount : 0
             * planTime : 1542816000000
             * publisherTime : 1542873978000
             * responsibleName : 岳东
             * userIds : 4
             * userNames : 马铜生
             */

            private String remarks;
            private int publisherId;
            private String title;
            private int id;
            private int deleted;
            private int enabled;
            private int responsibleId;
            private int troublecount;
            private long planTime;
            private long publisherTime;
            private String responsibleName;
            private String userIds;
            private String userNames;

            public String getRemarks() {
                return remarks;
            }

            public void setRemarks(String remarks) {
                this.remarks = remarks;
            }

            public int getPublisherId() {
                return publisherId;
            }

            public void setPublisherId(int publisherId) {
                this.publisherId = publisherId;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getDeleted() {
                return deleted;
            }

            public void setDeleted(int deleted) {
                this.deleted = deleted;
            }

            public int getEnabled() {
                return enabled;
            }

            public void setEnabled(int enabled) {
                this.enabled = enabled;
            }

            public int getResponsibleId() {
                return responsibleId;
            }

            public void setResponsibleId(int responsibleId) {
                this.responsibleId = responsibleId;
            }

            public int getTroublecount() {
                return troublecount;
            }

            public void setTroublecount(int troublecount) {
                this.troublecount = troublecount;
            }

            public long getPlanTime() {
                return planTime;
            }

            public void setPlanTime(long planTime) {
                this.planTime = planTime;
            }

            public long getPublisherTime() {
                return publisherTime;
            }

            public void setPublisherTime(long publisherTime) {
                this.publisherTime = publisherTime;
            }

            public String getResponsibleName() {
                return responsibleName;
            }

            public void setResponsibleName(String responsibleName) {
                this.responsibleName = responsibleName;
            }

            public String getUserIds() {
                return userIds;
            }

            public void setUserIds(String userIds) {
                this.userIds = userIds;
            }

            public String getUserNames() {
                return userNames;
            }

            public void setUserNames(String userNames) {
                this.userNames = userNames;
            }
        }

        public static class TaskloglistBean {
            /**
             * taskType : 15
             * operator : 孔德昊
             * datas : {'measures':'{"beginDate":1545840000000,"checkCycle":"2","checkState":"0","checkdate":28,"fileCycle":"2","id":3985,"lastCheckdate":"","measures":"有图两月","modifyTime":1545882332365,"nextCheckdate":"2018-12-28","publisherId":95,"publisherName":"孔德昊","responsibleId":95,"responsibleName":"孔德昊","saveType":3}'}
             * action : 2
             * id : 1089
             * remark : 添加措施
             * data : 有图两月
             * operatorId : 95
             * timestamp : 1545882332000
             * result : 成功
             * taskId : 3985
             */

            private String taskType;
            private String operator;
            private String datas;
            private String action;
            private int id;
            private String remark;
            private String data;
            private int operatorId;
            private long timestamp;
            private String result;
            private int taskId;

            public String getTaskType() {
                return taskType;
            }

            public void setTaskType(String taskType) {
                this.taskType = taskType;
            }

            public String getOperator() {
                return operator;
            }

            public void setOperator(String operator) {
                this.operator = operator;
            }

            public String getDatas() {
                return datas;
            }

            public void setDatas(String datas) {
                this.datas = datas;
            }

            public String getAction() {
                return action;
            }

            public void setAction(String action) {
                this.action = action;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getRemark() {
                return remark;
            }

            public void setRemark(String remark) {
                this.remark = remark;
            }

            public String getData() {
                return data;
            }

            public void setData(String data) {
                this.data = data;
            }

            public int getOperatorId() {
                return operatorId;
            }

            public void setOperatorId(int operatorId) {
                this.operatorId = operatorId;
            }

            public long getTimestamp() {
                return timestamp;
            }

            public void setTimestamp(long timestamp) {
                this.timestamp = timestamp;
            }

            public String getResult() {
                return result;
            }

            public void setResult(String result) {
                this.result = result;
            }

            public int getTaskId() {
                return taskId;
            }

            public void setTaskId(int taskId) {
                this.taskId = taskId;
            }
        }

        public static class ImglistBean {
            /**
             * fileName : 1545882302943.jpg
             * url : /upload/1545882302943.jpg
             * troubleId : 0
             * fileId : 3983
             */

            private String fileName;
            private String url;
            private int troubleId;
            private int fileId;

            public String getFileName() {
                return fileName;
            }

            public void setFileName(String fileName) {
                this.fileName = fileName;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public int getTroubleId() {
                return troubleId;
            }

            public void setTroubleId(int troubleId) {
                this.troubleId = troubleId;
            }

            public int getFileId() {
                return fileId;
            }

            public void setFileId(int fileId) {
                this.fileId = fileId;
            }
        }

        public static class ImplementBean {
            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getMeasuresId() {
                return measuresId;
            }

            public void setMeasuresId(int measuresId) {
                this.measuresId = measuresId;
            }

            public long getCheckdate() {
                return checkdate;
            }

            public void setCheckdate(long checkdate) {
                this.checkdate = checkdate;
            }

            public String getImplementState() {
                return implementState;
            }

            public void setImplementState(String implementState) {
                this.implementState = implementState;
            }

            public String getImplementRemark() {
                return implementRemark;
            }

            public void setImplementRemark(String implementRemark) {
                this.implementRemark = implementRemark;
            }

            public int getCheckerId() {
                return checkerId;
            }

            public void setCheckerId(int checkerId) {
                this.checkerId = checkerId;
            }

            public String getCheckerName() {
                return checkerName;
            }

            public void setCheckerName(String checkerName) {
                this.checkerName = checkerName;
            }

            public String getCheckTime() {
                return checkTime;
            }

            public void setCheckTime(String checkTime) {
                this.checkTime = checkTime;
            }

            private int id;
            private int measuresId;
            private long checkdate;
            private String implementState;
            private String implementRemark;
            private int checkerId;
            private String checkerName;
            private String checkTime;


        }
    }
}
