package com.lingjun.colliery_android.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 作者: zengtao
 * 时间: 2019/5/8  9:09.
 * 注释: 风险跟踪详情
 */
public class RiskTrackingsBean implements Serializable {

    /**
     * msg : 成功
     * code : 200
     * data : {"riskcontrolTrouble":{"id":20790,"planId":6,"planName":"1月中旬检查","riskcontrolAreaId":"","riskcontrolAreaName":"","riskcontrolSourceId":9,"riskcontrolLevelId":1,"riskcontrolLevelName":"一般","riskcontrolSourceDescription":"顶板破碎、局部压力大、顶板淋水，造成巷道成型差，顶板下沉","riskcontrolSourceMeasures":"1、加强巷道顶板管理，巷道压力大的区域进行加强支护。\n2、正确规范使用支护材料，确保巷道成型效果。\n3、加强顶板离层检测仪的日常检修维护工作，确保数据真实，及时上传。","riskcontrolDescription":"顶板破碎、局部压力大、顶板淋水，造成巷道成型差，顶板下沉","publisherId":249,"publisherName":"王红伟","publisherTime":1554977937000,"riskcontrolCategoryId":1,"riskcontrolCategoryName":"顶板","closeplanId":0,"closeplanTime":null,"lastcheckdate":null,"nextcheckdate":null,"states":2,"deleted":0,"closeplanReason":null,"measures":{"id":20790,"responsibleId":167,"responsibleName":"于发根","saveType":2,"beginDate":1554955200000,"checkCycle":"2","fileCycle":"1","publisherId":249,"publisherName":"王红伟","modifyTime":1554978002000,"checkdate":12,"checkState":"0","lastCheckdate":"2019-4-12","nextCheckdate":"2019-5-12","measures":"","lastFiledate":null},"implementcounts":0,"remark":null,"implementState":0,"checkName":null,"checkdate":null,"riskcontrolsource":null,"riskcontrolplan":null},"implementlist":[{"id":20793,"measuresId":20790,"checkdate":1555041600000,"implementState":"0","implementRemark":null,"checkerId":167,"checkerName":"于发根","checkTime":null}],"planlist":[{"id":6,"title":"1月中旬检查","responsibleId":632,"responsibleName":"","planTime":1547395200000,"userIds":"26,243,579,667","userNames":"焦立民,张延锋,王青峰,郑凯凯","remarks":"安全风险分级管控旬查","publisherId":648,"publisherTime":1547034858000,"enabled":1,"deleted":0,"troublecount":0},{"id":8,"title":"19年年初风险预测管理","responsibleId":2,"responsibleName":"史永民","planTime":1552320000000,"userIds":"34,167","userNames":"翟保龙,于发根","remarks":"19年年初风险预测管理","publisherId":249,"publisherTime":1552376435000,"enabled":1,"deleted":0,"troublecount":0}],"imglist":[],"url":"http://192.168.1.223:8080/safety/"}
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
         * riskcontrolTrouble : {"id":20790,"planId":6,"planName":"1月中旬检查","riskcontrolAreaId":"","riskcontrolAreaName":"","riskcontrolSourceId":9,"riskcontrolLevelId":1,"riskcontrolLevelName":"一般","riskcontrolSourceDescription":"顶板破碎、局部压力大、顶板淋水，造成巷道成型差，顶板下沉","riskcontrolSourceMeasures":"1、加强巷道顶板管理，巷道压力大的区域进行加强支护。\n2、正确规范使用支护材料，确保巷道成型效果。\n3、加强顶板离层检测仪的日常检修维护工作，确保数据真实，及时上传。","riskcontrolDescription":"顶板破碎、局部压力大、顶板淋水，造成巷道成型差，顶板下沉","publisherId":249,"publisherName":"王红伟","publisherTime":1554977937000,"riskcontrolCategoryId":1,"riskcontrolCategoryName":"顶板","closeplanId":0,"closeplanTime":null,"lastcheckdate":null,"nextcheckdate":null,"states":2,"deleted":0,"closeplanReason":null,"measures":{"id":20790,"responsibleId":167,"responsibleName":"于发根","saveType":2,"beginDate":1554955200000,"checkCycle":"2","fileCycle":"1","publisherId":249,"publisherName":"王红伟","modifyTime":1554978002000,"checkdate":12,"checkState":"0","lastCheckdate":"2019-4-12","nextCheckdate":"2019-5-12","measures":"","lastFiledate":null},"implementcounts":0,"remark":null,"implementState":0,"checkName":null,"checkdate":null,"riskcontrolsource":null,"riskcontrolplan":null}
         * implementlist : [{"id":20793,"measuresId":20790,"checkdate":1555041600000,"implementState":"0","implementRemark":null,"checkerId":167,"checkerName":"于发根","checkTime":null}]
         * planlist : [{"id":6,"title":"1月中旬检查","responsibleId":632,"responsibleName":"","planTime":1547395200000,"userIds":"26,243,579,667","userNames":"焦立民,张延锋,王青峰,郑凯凯","remarks":"安全风险分级管控旬查","publisherId":648,"publisherTime":1547034858000,"enabled":1,"deleted":0,"troublecount":0},{"id":8,"title":"19年年初风险预测管理","responsibleId":2,"responsibleName":"史永民","planTime":1552320000000,"userIds":"34,167","userNames":"翟保龙,于发根","remarks":"19年年初风险预测管理","publisherId":249,"publisherTime":1552376435000,"enabled":1,"deleted":0,"troublecount":0}]
         * imglist : []
         * url : http://192.168.1.223:8080/safety/
         */

        private RiskcontrolTroubleBean riskcontrolTrouble;
        private String url;
        private ArrayList<ImplementlistBean> implementlist;
        private List<PlanlistBean> planlist;
        private ArrayList<ImglistBean> imglist;

        public RiskcontrolTroubleBean getRiskcontrolTrouble() {
            return riskcontrolTrouble;
        }

        public void setRiskcontrolTrouble(RiskcontrolTroubleBean riskcontrolTrouble) {
            this.riskcontrolTrouble = riskcontrolTrouble;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public ArrayList<ImplementlistBean> getImplementlist() {
            return implementlist;
        }

        public void setImplementlist(ArrayList<ImplementlistBean> implementlist) {
            this.implementlist = implementlist;
        }

        public List<PlanlistBean> getPlanlist() {
            return planlist;
        }

        public void setPlanlist(List<PlanlistBean> planlist) {
            this.planlist = planlist;
        }

        public ArrayList<ImglistBean> getImglist() {
            return imglist;
        }

        public void setImglist(ArrayList<ImglistBean> imglist) {
            this.imglist = imglist;
        }

        public static class RiskcontrolTroubleBean implements Serializable {
            /**
             * id : 20790
             * planId : 6
             * planName : 1月中旬检查
             * riskcontrolAreaId :
             * riskcontrolAreaName :
             * riskcontrolSourceId : 9
             * riskcontrolLevelId : 1
             * riskcontrolLevelName : 一般
             * riskcontrolSourceDescription : 顶板破碎、局部压力大、顶板淋水，造成巷道成型差，顶板下沉
             * riskcontrolSourceMeasures : 1、加强巷道顶板管理，巷道压力大的区域进行加强支护。
             * 2、正确规范使用支护材料，确保巷道成型效果。
             * 3、加强顶板离层检测仪的日常检修维护工作，确保数据真实，及时上传。
             * riskcontrolDescription : 顶板破碎、局部压力大、顶板淋水，造成巷道成型差，顶板下沉
             * publisherId : 249
             * publisherName : 王红伟
             * publisherTime : 1554977937000
             * riskcontrolCategoryId : 1
             * riskcontrolCategoryName : 顶板
             * closeplanId : 0
             * closeplanTime : null
             * lastcheckdate : null
             * nextcheckdate : null
             * states : 2
             * deleted : 0
             * closeplanReason : null
             * measures : {"id":20790,"responsibleId":167,"responsibleName":"于发根","saveType":2,"beginDate":1554955200000,"checkCycle":"2","fileCycle":"1","publisherId":249,"publisherName":"王红伟","modifyTime":1554978002000,"checkdate":12,"checkState":"0","lastCheckdate":"2019-4-12","nextCheckdate":"2019-5-12","measures":"","lastFiledate":null}
             * implementcounts : 0
             * remark : null
             * implementState : 0
             * checkName : null
             * checkdate : null
             * riskcontrolsource : null
             * riskcontrolplan : null
             */

            private int id;
            private int planId;
            private String planName;
            private String riskcontrolAreaId;
            private String riskcontrolAreaName;
            private int riskcontrolSourceId;
            private int riskcontrolLevelId;
            private String riskcontrolLevelName;
            private String riskcontrolSourceDescription;
            private String riskcontrolSourceMeasures;
            private String riskcontrolDescription;
            private int publisherId;
            private String publisherName;
            private long publisherTime;
            private int riskcontrolCategoryId;
            private String riskcontrolCategoryName;
            private int closeplanId;
            private Object closeplanTime;
            private Object lastcheckdate;
            private Object nextcheckdate;
            private int states;
            private int deleted;
            private Object closeplanReason;
            private MeasuresBean measures;
            private int implementcounts;
            private Object remark;
            private int implementState;
            private Object checkName;
            private long checkdate;
            private Object riskcontrolsource;
            private Object riskcontrolplan;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getPlanId() {
                return planId;
            }

            public void setPlanId(int planId) {
                this.planId = planId;
            }

            public String getPlanName() {
                return planName;
            }

            public void setPlanName(String planName) {
                this.planName = planName;
            }

            public String getRiskcontrolAreaId() {
                return riskcontrolAreaId;
            }

            public void setRiskcontrolAreaId(String riskcontrolAreaId) {
                this.riskcontrolAreaId = riskcontrolAreaId;
            }

            public String getRiskcontrolAreaName() {
                return riskcontrolAreaName;
            }

            public void setRiskcontrolAreaName(String riskcontrolAreaName) {
                this.riskcontrolAreaName = riskcontrolAreaName;
            }

            public int getRiskcontrolSourceId() {
                return riskcontrolSourceId;
            }

            public void setRiskcontrolSourceId(int riskcontrolSourceId) {
                this.riskcontrolSourceId = riskcontrolSourceId;
            }

            public int getRiskcontrolLevelId() {
                return riskcontrolLevelId;
            }

            public void setRiskcontrolLevelId(int riskcontrolLevelId) {
                this.riskcontrolLevelId = riskcontrolLevelId;
            }

            public String getRiskcontrolLevelName() {
                return riskcontrolLevelName;
            }

            public void setRiskcontrolLevelName(String riskcontrolLevelName) {
                this.riskcontrolLevelName = riskcontrolLevelName;
            }

            public String getRiskcontrolSourceDescription() {
                return riskcontrolSourceDescription;
            }

            public void setRiskcontrolSourceDescription(String riskcontrolSourceDescription) {
                this.riskcontrolSourceDescription = riskcontrolSourceDescription;
            }

            public String getRiskcontrolSourceMeasures() {
                return riskcontrolSourceMeasures;
            }

            public void setRiskcontrolSourceMeasures(String riskcontrolSourceMeasures) {
                this.riskcontrolSourceMeasures = riskcontrolSourceMeasures;
            }

            public String getRiskcontrolDescription() {
                return riskcontrolDescription;
            }

            public void setRiskcontrolDescription(String riskcontrolDescription) {
                this.riskcontrolDescription = riskcontrolDescription;
            }

            public int getPublisherId() {
                return publisherId;
            }

            public void setPublisherId(int publisherId) {
                this.publisherId = publisherId;
            }

            public String getPublisherName() {
                return publisherName;
            }

            public void setPublisherName(String publisherName) {
                this.publisherName = publisherName;
            }

            public long getPublisherTime() {
                return publisherTime;
            }

            public void setPublisherTime(long publisherTime) {
                this.publisherTime = publisherTime;
            }

            public int getRiskcontrolCategoryId() {
                return riskcontrolCategoryId;
            }

            public void setRiskcontrolCategoryId(int riskcontrolCategoryId) {
                this.riskcontrolCategoryId = riskcontrolCategoryId;
            }

            public String getRiskcontrolCategoryName() {
                return riskcontrolCategoryName;
            }

            public void setRiskcontrolCategoryName(String riskcontrolCategoryName) {
                this.riskcontrolCategoryName = riskcontrolCategoryName;
            }

            public int getCloseplanId() {
                return closeplanId;
            }

            public void setCloseplanId(int closeplanId) {
                this.closeplanId = closeplanId;
            }

            public Object getCloseplanTime() {
                return closeplanTime;
            }

            public void setCloseplanTime(Object closeplanTime) {
                this.closeplanTime = closeplanTime;
            }

            public Object getLastcheckdate() {
                return lastcheckdate;
            }

            public void setLastcheckdate(Object lastcheckdate) {
                this.lastcheckdate = lastcheckdate;
            }

            public Object getNextcheckdate() {
                return nextcheckdate;
            }

            public void setNextcheckdate(Object nextcheckdate) {
                this.nextcheckdate = nextcheckdate;
            }

            public int getStates() {
                return states;
            }

            public void setStates(int states) {
                this.states = states;
            }

            public int getDeleted() {
                return deleted;
            }

            public void setDeleted(int deleted) {
                this.deleted = deleted;
            }

            public Object getCloseplanReason() {
                return closeplanReason;
            }

            public void setCloseplanReason(Object closeplanReason) {
                this.closeplanReason = closeplanReason;
            }

            public MeasuresBean getMeasures() {
                return measures;
            }

            public void setMeasures(MeasuresBean measures) {
                this.measures = measures;
            }

            public int getImplementcounts() {
                return implementcounts;
            }

            public void setImplementcounts(int implementcounts) {
                this.implementcounts = implementcounts;
            }

            public Object getRemark() {
                return remark;
            }

            public void setRemark(Object remark) {
                this.remark = remark;
            }

            public int getImplementState() {
                return implementState;
            }

            public void setImplementState(int implementState) {
                this.implementState = implementState;
            }

            public Object getCheckName() {
                return checkName;
            }

            public void setCheckName(Object checkName) {
                this.checkName = checkName;
            }

            public long
            getCheckdate() {
                return checkdate;
            }

            public void setCheckdate(long checkdate) {
                this.checkdate = checkdate;
            }

            public Object getRiskcontrolsource() {
                return riskcontrolsource;
            }

            public void setRiskcontrolsource(Object riskcontrolsource) {
                this.riskcontrolsource = riskcontrolsource;
            }

            public Object getRiskcontrolplan() {
                return riskcontrolplan;
            }

            public void setRiskcontrolplan(Object riskcontrolplan) {
                this.riskcontrolplan = riskcontrolplan;
            }

            public static class MeasuresBean implements Serializable {
                /**
                 * id : 20790
                 * responsibleId : 167
                 * responsibleName : 于发根
                 * saveType : 2
                 * beginDate : 1554955200000
                 * checkCycle : 2
                 * fileCycle : 1
                 * publisherId : 249
                 * publisherName : 王红伟
                 * modifyTime : 1554978002000
                 * checkdate : 12
                 * checkState : 0
                 * lastCheckdate : 2019-4-12
                 * nextCheckdate : 2019-5-12
                 * measures :
                 * lastFiledate : null
                 */

                private int id;
                private int responsibleId;
                private String responsibleName;
                private int saveType;
                private long beginDate;
                private String checkCycle;
                private String fileCycle;
                private int publisherId;
                private String publisherName;
                private long modifyTime;
                private int checkdate;
                private String checkState;
                private String lastCheckdate;
                private String nextCheckdate;
                private String measures;
                private Object lastFiledate;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
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

                public int getSaveType() {
                    return saveType;
                }

                public void setSaveType(int saveType) {
                    this.saveType = saveType;
                }

                public long getBeginDate() {
                    return beginDate;
                }

                public void setBeginDate(long beginDate) {
                    this.beginDate = beginDate;
                }

                public String getCheckCycle() {
                    return checkCycle;
                }

                public void setCheckCycle(String checkCycle) {
                    this.checkCycle = checkCycle;
                }

                public String getFileCycle() {
                    return fileCycle;
                }

                public void setFileCycle(String fileCycle) {
                    this.fileCycle = fileCycle;
                }

                public int getPublisherId() {
                    return publisherId;
                }

                public void setPublisherId(int publisherId) {
                    this.publisherId = publisherId;
                }

                public String getPublisherName() {
                    return publisherName;
                }

                public void setPublisherName(String publisherName) {
                    this.publisherName = publisherName;
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

                public String getCheckState() {
                    return checkState;
                }

                public void setCheckState(String checkState) {
                    this.checkState = checkState;
                }

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

                public String getMeasures() {
                    return measures;
                }

                public void setMeasures(String measures) {
                    this.measures = measures;
                }

                public Object getLastFiledate() {
                    return lastFiledate;
                }

                public void setLastFiledate(Object lastFiledate) {
                    this.lastFiledate = lastFiledate;
                }
            }
        }

        public static class ImplementlistBean implements Serializable {
            /**
             * id : 20793
             * measuresId : 20790
             * checkdate : 1555041600000
             * implementState : 0
             * implementRemark : null
             * checkerId : 167
             * checkerName : 于发根
             * checkTime : null
             */

            private int id;
            private int measuresId;
            private long checkdate;
            private String implementState;
            private String implementRemark;
            private int checkerId;
            private String checkerName;
            private long checkTime;

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

            public long getCheckTime() {
                return checkTime;
            }

            public void setCheckTime(long checkTime) {
                this.checkTime = checkTime;
            }
        }

        public static class PlanlistBean implements Serializable {
            /**
             * id : 6
             * title : 1月中旬检查
             * responsibleId : 632
             * responsibleName :
             * planTime : 1547395200000
             * userIds : 26,243,579,667
             * userNames : 焦立民,张延锋,王青峰,郑凯凯
             * remarks : 安全风险分级管控旬查
             * publisherId : 648
             * publisherTime : 1547034858000
             * enabled : 1
             * deleted : 0
             * troublecount : 0
             */

            private int id;
            private String title;
            private int responsibleId;
            private String responsibleName;
            private long planTime;
            private String userIds;
            private String userNames;
            private String remarks;
            private int publisherId;
            private long publisherTime;
            private int enabled;
            private int deleted;
            private int troublecount;

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

            public long getPlanTime() {
                return planTime;
            }

            public void setPlanTime(long planTime) {
                this.planTime = planTime;
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

            public long getPublisherTime() {
                return publisherTime;
            }

            public void setPublisherTime(long publisherTime) {
                this.publisherTime = publisherTime;
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

            public int getTroublecount() {
                return troublecount;
            }

            public void setTroublecount(int troublecount) {
                this.troublecount = troublecount;
            }
        }

        public static class ImglistBean implements Serializable {

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getFileId() {
                return fileId;
            }

            public void setFileId(String fileId) {
                this.fileId = fileId;
            }

            public String getSwfUrl() {
                return swfUrl;
            }

            public void setSwfUrl(String swfUrl) {
                this.swfUrl = swfUrl;
            }

            public String getFileName() {
                return fileName;
            }

            public void setFileName(String fileName) {
                this.fileName = fileName;
            }

            private String url;
            private String fileId;
            private String swfUrl;
            private String fileName;


        }
    }
}
