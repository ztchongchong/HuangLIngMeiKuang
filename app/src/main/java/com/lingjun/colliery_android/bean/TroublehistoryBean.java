package com.lingjun.colliery_android.bean;

import java.util.List;

/**
 * 作者: zengtao
 * 时间: 2018/12/24  16:14.
 * 注释: 隐患历史
 */
public class TroublehistoryBean {
    /**
     * msg : 成功
     * code : 200
     * resultMaps : [{"page":{"totalRecord":21,"results":[{"sourceId":2,"technicianName":"","troubleLevelId":0,"sourceCategory":"1","responsibleLeaderName":"李鸿武","sourceProcessorName":"乔改生","responsibleDepartmentId":21,"processorId":"249","processTime":1556616877000,"taskId":13769,"acceptorName":"张明明,张根虎","responsibleMoney":0,"responsibleUserId":",30,","technicianId":0,"mainId":13768,"rectifyDay":0,"acceptorId":",337,336,","troublePlanId":0,"sourceScore":0,"acceptanceDepartmentsId":"","acceptReason":"有啥","sourceMoney":0,"isRectification":0,"sourceDescription":"掘进工作面顶、帮状况差或顶板破碎、两帮片帮严重","fatal":false,"troubleContent":"买的","troubleSubtaskDocList":[],"responsibleUserName":"高金旗","acceptanceDepartmentsName":"","taskType":"8","solutionContent":"跟班队长随时对巷道顶板、巷帮进行检查，当发现顶板有离层、活矸、鳞皮以及巷帮有片帮煤时，需及时安排处理，当顶板离层严重或巷帮片帮严重时，必须组织人员进行加强支护。 111","responsibleScore":0,"responsibleDepartmentName":"生产技术部","troubleLevel":"一般B级","solutionType":0,"processType":1,"responsibleLeaderId":2,"state":"5","sourceProcessorId":95,"approverName":"王红伟","entryUserId":0,"deletes":"0","nowTroubleLevelId":0,"approverId":249},{"sourceId":1,"troubleLevelId":0,"sourceCategory":"1","responsibleLeaderName":"李鸿武","sourceProcessorName":"王红伟","responsibleDepartmentId":21,"processorId":"249","processTime":1556156272000,"taskId":13632,"responsibleMoney":12,"responsibleUserId":"783,782,781,780,580,4","mainId":13631,"rectifyDay":0,"acceptorId":" ","troublePlanId":4,"sourceScore":0,"correctNoticeNo":"201904250003","acceptReason":"1","sourceMoney":0,"isRectification":0,"sourceDescription":"未检查掘进面或未认真执行敲帮问顶","fatal":false,"troubleContent":"未检查掘进面或未认真执行敲帮问顶","acceptanceRuleOut":" ","troubleSubtaskDocList":[],"responsibleUserName":"陈攀,王俊,陈静,李洁,马锦耀,强欢欢","taskType":"8","solutionContent":"1","responsibleScore":12,"responsibleDepartmentName":"生产技术部","troubleLevel":"重大A级","solutionType":0,"processType":1,"responsibleLeaderId":2,"state":"4","sourceProcessorId":249,"entryUserId":0,"deletes":"4","nowTroubleLevelId":0,"approverId":0},{"sourceId":3,"troubleLevelId":0,"sourceCategory":"1","responsibleLeaderName":"李鸿武","sourceProcessorName":"王红伟","responsibleDepartmentId":21,"processorId":"249","processTime":1556519897000,"taskId":13749,"responsibleMoney":0,"responsibleUserId":"31","mainId":13748,"rectifyDay":0,"acceptorId":" ","troublePlanId":4,"sourceScore":0,"correctNoticeNo":"201904290001","acceptReason":"11","sourceMoney":0,"isRectification":0,"sourceDescription":"未选择在顶板状况好的地方吊挂、拆卸调校激光指向仪","fatal":false,"troubleContent":"11","acceptanceRuleOut":" ","troubleSubtaskDocList":[],"responsibleUserName":"传小军","taskType":"8","solutionContent":"跟班队长必须在现场指挥作业。","responsibleScore":0,"responsibleDepartmentName":"生产技术部","troubleLevel":"一般B级","solutionType":0,"processType":1,"responsibleLeaderId":2,"state":"5","sourceProcessorId":249,"approverName":"王红伟","entryUserId":0,"deletes":"0","nowTroubleLevelId":0,"approverId":249}],"pageSize":3,"dateFormat":"","totalPage":7,"pageNo":1,"params":{},"resultMaps":[]}}]
     */

    private String msg;
    private String code;
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

    public List<ResultMapsBean> getResultMaps() {
        return resultMaps;
    }

    public void setResultMaps(List<ResultMapsBean> resultMaps) {
        this.resultMaps = resultMaps;
    }

    public static class ResultMapsBean {
        /**
         * page : {"totalRecord":21,"results":[{"sourceId":2,"technicianName":"","troubleLevelId":0,"sourceCategory":"1","responsibleLeaderName":"李鸿武","sourceProcessorName":"乔改生","responsibleDepartmentId":21,"processorId":"249","processTime":1556616877000,"taskId":13769,"acceptorName":"张明明,张根虎","responsibleMoney":0,"responsibleUserId":",30,","technicianId":0,"mainId":13768,"rectifyDay":0,"acceptorId":",337,336,","troublePlanId":0,"sourceScore":0,"acceptanceDepartmentsId":"","acceptReason":"有啥","sourceMoney":0,"isRectification":0,"sourceDescription":"掘进工作面顶、帮状况差或顶板破碎、两帮片帮严重","fatal":false,"troubleContent":"买的","troubleSubtaskDocList":[],"responsibleUserName":"高金旗","acceptanceDepartmentsName":"","taskType":"8","solutionContent":"跟班队长随时对巷道顶板、巷帮进行检查，当发现顶板有离层、活矸、鳞皮以及巷帮有片帮煤时，需及时安排处理，当顶板离层严重或巷帮片帮严重时，必须组织人员进行加强支护。 111","responsibleScore":0,"responsibleDepartmentName":"生产技术部","troubleLevel":"一般B级","solutionType":0,"processType":1,"responsibleLeaderId":2,"state":"5","sourceProcessorId":95,"approverName":"王红伟","entryUserId":0,"deletes":"0","nowTroubleLevelId":0,"approverId":249,"correctNoticeNo":"201904250003","acceptanceRuleOut":" "},{"sourceId":1,"troubleLevelId":0,"sourceCategory":"1","responsibleLeaderName":"李鸿武","sourceProcessorName":"王红伟","responsibleDepartmentId":21,"processorId":"249","processTime":1556156272000,"taskId":13632,"responsibleMoney":12,"responsibleUserId":"783,782,781,780,580,4","mainId":13631,"rectifyDay":0,"acceptorId":" ","troublePlanId":4,"sourceScore":0,"correctNoticeNo":"201904250003","acceptReason":"1","sourceMoney":0,"isRectification":0,"sourceDescription":"未检查掘进面或未认真执行敲帮问顶","fatal":false,"troubleContent":"未检查掘进面或未认真执行敲帮问顶","acceptanceRuleOut":" ","troubleSubtaskDocList":[],"responsibleUserName":"陈攀,王俊,陈静,李洁,马锦耀,强欢欢","taskType":"8","solutionContent":"1","responsibleScore":12,"responsibleDepartmentName":"生产技术部","troubleLevel":"重大A级","solutionType":0,"processType":1,"responsibleLeaderId":2,"state":"4","sourceProcessorId":249,"entryUserId":0,"deletes":"4","nowTroubleLevelId":0,"approverId":0},{"sourceId":3,"troubleLevelId":0,"sourceCategory":"1","responsibleLeaderName":"李鸿武","sourceProcessorName":"王红伟","responsibleDepartmentId":21,"processorId":"249","processTime":1556519897000,"taskId":13749,"responsibleMoney":0,"responsibleUserId":"31","mainId":13748,"rectifyDay":0,"acceptorId":" ","troublePlanId":4,"sourceScore":0,"correctNoticeNo":"201904290001","acceptReason":"11","sourceMoney":0,"isRectification":0,"sourceDescription":"未选择在顶板状况好的地方吊挂、拆卸调校激光指向仪","fatal":false,"troubleContent":"11","acceptanceRuleOut":" ","troubleSubtaskDocList":[],"responsibleUserName":"传小军","taskType":"8","solutionContent":"跟班队长必须在现场指挥作业。","responsibleScore":0,"responsibleDepartmentName":"生产技术部","troubleLevel":"一般B级","solutionType":0,"processType":1,"responsibleLeaderId":2,"state":"5","sourceProcessorId":249,"approverName":"王红伟","entryUserId":0,"deletes":"0","nowTroubleLevelId":0,"approverId":249}],"pageSize":3,"dateFormat":"","totalPage":7,"pageNo":1,"params":{},"resultMaps":[]}
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
             * totalRecord : 21
             * results : [{"sourceId":2,"technicianName":"","troubleLevelId":0,"sourceCategory":"1","responsibleLeaderName":"李鸿武","sourceProcessorName":"乔改生","responsibleDepartmentId":21,"processorId":"249","processTime":1556616877000,"taskId":13769,"acceptorName":"张明明,张根虎","responsibleMoney":0,"responsibleUserId":",30,","technicianId":0,"mainId":13768,"rectifyDay":0,"acceptorId":",337,336,","troublePlanId":0,"sourceScore":0,"acceptanceDepartmentsId":"","acceptReason":"有啥","sourceMoney":0,"isRectification":0,"sourceDescription":"掘进工作面顶、帮状况差或顶板破碎、两帮片帮严重","fatal":false,"troubleContent":"买的","troubleSubtaskDocList":[],"responsibleUserName":"高金旗","acceptanceDepartmentsName":"","taskType":"8","solutionContent":"跟班队长随时对巷道顶板、巷帮进行检查，当发现顶板有离层、活矸、鳞皮以及巷帮有片帮煤时，需及时安排处理，当顶板离层严重或巷帮片帮严重时，必须组织人员进行加强支护。 111","responsibleScore":0,"responsibleDepartmentName":"生产技术部","troubleLevel":"一般B级","solutionType":0,"processType":1,"responsibleLeaderId":2,"state":"5","sourceProcessorId":95,"approverName":"王红伟","entryUserId":0,"deletes":"0","nowTroubleLevelId":0,"approverId":249},{"sourceId":1,"troubleLevelId":0,"sourceCategory":"1","responsibleLeaderName":"李鸿武","sourceProcessorName":"王红伟","responsibleDepartmentId":21,"processorId":"249","processTime":1556156272000,"taskId":13632,"responsibleMoney":12,"responsibleUserId":"783,782,781,780,580,4","mainId":13631,"rectifyDay":0,"acceptorId":" ","troublePlanId":4,"sourceScore":0,"correctNoticeNo":"201904250003","acceptReason":"1","sourceMoney":0,"isRectification":0,"sourceDescription":"未检查掘进面或未认真执行敲帮问顶","fatal":false,"troubleContent":"未检查掘进面或未认真执行敲帮问顶","acceptanceRuleOut":" ","troubleSubtaskDocList":[],"responsibleUserName":"陈攀,王俊,陈静,李洁,马锦耀,强欢欢","taskType":"8","solutionContent":"1","responsibleScore":12,"responsibleDepartmentName":"生产技术部","troubleLevel":"重大A级","solutionType":0,"processType":1,"responsibleLeaderId":2,"state":"4","sourceProcessorId":249,"entryUserId":0,"deletes":"4","nowTroubleLevelId":0,"approverId":0},{"sourceId":3,"troubleLevelId":0,"sourceCategory":"1","responsibleLeaderName":"李鸿武","sourceProcessorName":"王红伟","responsibleDepartmentId":21,"processorId":"249","processTime":1556519897000,"taskId":13749,"responsibleMoney":0,"responsibleUserId":"31","mainId":13748,"rectifyDay":0,"acceptorId":" ","troublePlanId":4,"sourceScore":0,"correctNoticeNo":"201904290001","acceptReason":"11","sourceMoney":0,"isRectification":0,"sourceDescription":"未选择在顶板状况好的地方吊挂、拆卸调校激光指向仪","fatal":false,"troubleContent":"11","acceptanceRuleOut":" ","troubleSubtaskDocList":[],"responsibleUserName":"传小军","taskType":"8","solutionContent":"跟班队长必须在现场指挥作业。","responsibleScore":0,"responsibleDepartmentName":"生产技术部","troubleLevel":"一般B级","solutionType":0,"processType":1,"responsibleLeaderId":2,"state":"5","sourceProcessorId":249,"approverName":"王红伟","entryUserId":0,"deletes":"0","nowTroubleLevelId":0,"approverId":249}]
             * pageSize : 3
             * dateFormat :
             * totalPage : 7
             * pageNo : 1
             * params : {}
             * resultMaps : []
             */

            private int totalRecord;
            private int pageSize;
            private String dateFormat;
            private int totalPage;
            private int pageNo;
            private ParamsBean params;
            private List<ResultsBean> results;
            private List<?> resultMaps;

            public int getTotalRecord() {
                return totalRecord;
            }

            public void setTotalRecord(int totalRecord) {
                this.totalRecord = totalRecord;
            }

            public int getPageSize() {
                return pageSize;
            }

            public void setPageSize(int pageSize) {
                this.pageSize = pageSize;
            }

            public String getDateFormat() {
                return dateFormat;
            }

            public void setDateFormat(String dateFormat) {
                this.dateFormat = dateFormat;
            }

            public int getTotalPage() {
                return totalPage;
            }

            public void setTotalPage(int totalPage) {
                this.totalPage = totalPage;
            }

            public int getPageNo() {
                return pageNo;
            }

            public void setPageNo(int pageNo) {
                this.pageNo = pageNo;
            }

            public ParamsBean getParams() {
                return params;
            }

            public void setParams(ParamsBean params) {
                this.params = params;
            }

            public List<ResultsBean> getResults() {
                return results;
            }

            public void setResults(List<ResultsBean> results) {
                this.results = results;
            }

            public List<?> getResultMaps() {
                return resultMaps;
            }

            public void setResultMaps(List<?> resultMaps) {
                this.resultMaps = resultMaps;
            }

            public static class ParamsBean {
            }

            public static class ResultsBean {
                /**
                 * sourceId : 2
                 * technicianName :
                 * troubleLevelId : 0
                 * sourceCategory : 1
                 * responsibleLeaderName : 李鸿武
                 * sourceProcessorName : 乔改生
                 * responsibleDepartmentId : 21
                 * processorId : 249
                 * processTime : 1556616877000
                 * taskId : 13769
                 * acceptorName : 张明明,张根虎
                 * responsibleMoney : 0
                 * responsibleUserId : ,30,
                 * technicianId : 0
                 * mainId : 13768
                 * rectifyDay : 0
                 * acceptorId : ,337,336,
                 * troublePlanId : 0
                 * sourceScore : 0
                 * acceptanceDepartmentsId :
                 * acceptReason : 有啥
                 * sourceMoney : 0
                 * isRectification : 0
                 * sourceDescription : 掘进工作面顶、帮状况差或顶板破碎、两帮片帮严重
                 * fatal : false
                 * troubleContent : 买的
                 * troubleSubtaskDocList : []
                 * responsibleUserName : 高金旗
                 * acceptanceDepartmentsName :
                 * taskType : 8
                 * solutionContent : 跟班队长随时对巷道顶板、巷帮进行检查，当发现顶板有离层、活矸、鳞皮以及巷帮有片帮煤时，需及时安排处理，当顶板离层严重或巷帮片帮严重时，必须组织人员进行加强支护。 111
                 * responsibleScore : 0
                 * responsibleDepartmentName : 生产技术部
                 * troubleLevel : 一般B级
                 * solutionType : 0
                 * processType : 1
                 * responsibleLeaderId : 2
                 * state : 5
                 * sourceProcessorId : 95
                 * approverName : 王红伟
                 * entryUserId : 0
                 * deletes : 0
                 * nowTroubleLevelId : 0
                 * approverId : 249
                 * correctNoticeNo : 201904250003
                 * acceptanceRuleOut :
                 */

                private int sourceId;
                private String technicianName;
                private int troubleLevelId;
                private String sourceCategory;
                private String responsibleLeaderName;
                private String sourceProcessorName;
                private int responsibleDepartmentId;
                private String processorId;
                private long processTime;
                private int taskId;
                private String acceptorName;
                private int responsibleMoney;
                private String responsibleUserId;
                private int technicianId;
                private int mainId;
                private int rectifyDay;
                private String acceptorId;
                private int troublePlanId;
                private int sourceScore;
                private String acceptanceDepartmentsId;
                private String acceptReason;
                private int sourceMoney;
                private int isRectification;
                private String sourceDescription;
                private boolean fatal;
                private String troubleContent;
                private String responsibleUserName;
                private String acceptanceDepartmentsName;
                private String taskType;
                private String solutionContent;
                private int responsibleScore;
                private String responsibleDepartmentName;
                private String troubleLevel;
                private int solutionType;
                private int processType;
                private int responsibleLeaderId;
                private String state;
                private int sourceProcessorId;
                private String approverName;
                private int entryUserId;
                private String deletes;
                private int nowTroubleLevelId;
                private int approverId;
                private String correctNoticeNo;
                private String acceptanceRuleOut;
                private List<?> troubleSubtaskDocList;

                public int getSourceId() {
                    return sourceId;
                }

                public void setSourceId(int sourceId) {
                    this.sourceId = sourceId;
                }

                public String getTechnicianName() {
                    return technicianName;
                }

                public void setTechnicianName(String technicianName) {
                    this.technicianName = technicianName;
                }

                public int getTroubleLevelId() {
                    return troubleLevelId;
                }

                public void setTroubleLevelId(int troubleLevelId) {
                    this.troubleLevelId = troubleLevelId;
                }

                public String getSourceCategory() {
                    return sourceCategory;
                }

                public void setSourceCategory(String sourceCategory) {
                    this.sourceCategory = sourceCategory;
                }

                public String getResponsibleLeaderName() {
                    return responsibleLeaderName;
                }

                public void setResponsibleLeaderName(String responsibleLeaderName) {
                    this.responsibleLeaderName = responsibleLeaderName;
                }

                public String getSourceProcessorName() {
                    return sourceProcessorName;
                }

                public void setSourceProcessorName(String sourceProcessorName) {
                    this.sourceProcessorName = sourceProcessorName;
                }

                public int getResponsibleDepartmentId() {
                    return responsibleDepartmentId;
                }

                public void setResponsibleDepartmentId(int responsibleDepartmentId) {
                    this.responsibleDepartmentId = responsibleDepartmentId;
                }

                public String getProcessorId() {
                    return processorId;
                }

                public void setProcessorId(String processorId) {
                    this.processorId = processorId;
                }

                public long getProcessTime() {
                    return processTime;
                }

                public void setProcessTime(long processTime) {
                    this.processTime = processTime;
                }

                public int getTaskId() {
                    return taskId;
                }

                public void setTaskId(int taskId) {
                    this.taskId = taskId;
                }

                public String getAcceptorName() {
                    return acceptorName;
                }

                public void setAcceptorName(String acceptorName) {
                    this.acceptorName = acceptorName;
                }

                public int getResponsibleMoney() {
                    return responsibleMoney;
                }

                public void setResponsibleMoney(int responsibleMoney) {
                    this.responsibleMoney = responsibleMoney;
                }

                public String getResponsibleUserId() {
                    return responsibleUserId;
                }

                public void setResponsibleUserId(String responsibleUserId) {
                    this.responsibleUserId = responsibleUserId;
                }

                public int getTechnicianId() {
                    return technicianId;
                }

                public void setTechnicianId(int technicianId) {
                    this.technicianId = technicianId;
                }

                public int getMainId() {
                    return mainId;
                }

                public void setMainId(int mainId) {
                    this.mainId = mainId;
                }

                public int getRectifyDay() {
                    return rectifyDay;
                }

                public void setRectifyDay(int rectifyDay) {
                    this.rectifyDay = rectifyDay;
                }

                public String getAcceptorId() {
                    return acceptorId;
                }

                public void setAcceptorId(String acceptorId) {
                    this.acceptorId = acceptorId;
                }

                public int getTroublePlanId() {
                    return troublePlanId;
                }

                public void setTroublePlanId(int troublePlanId) {
                    this.troublePlanId = troublePlanId;
                }

                public int getSourceScore() {
                    return sourceScore;
                }

                public void setSourceScore(int sourceScore) {
                    this.sourceScore = sourceScore;
                }

                public String getAcceptanceDepartmentsId() {
                    return acceptanceDepartmentsId;
                }

                public void setAcceptanceDepartmentsId(String acceptanceDepartmentsId) {
                    this.acceptanceDepartmentsId = acceptanceDepartmentsId;
                }

                public String getAcceptReason() {
                    return acceptReason;
                }

                public void setAcceptReason(String acceptReason) {
                    this.acceptReason = acceptReason;
                }

                public int getSourceMoney() {
                    return sourceMoney;
                }

                public void setSourceMoney(int sourceMoney) {
                    this.sourceMoney = sourceMoney;
                }

                public int getIsRectification() {
                    return isRectification;
                }

                public void setIsRectification(int isRectification) {
                    this.isRectification = isRectification;
                }

                public String getSourceDescription() {
                    return sourceDescription;
                }

                public void setSourceDescription(String sourceDescription) {
                    this.sourceDescription = sourceDescription;
                }

                public boolean isFatal() {
                    return fatal;
                }

                public void setFatal(boolean fatal) {
                    this.fatal = fatal;
                }

                public String getTroubleContent() {
                    return troubleContent;
                }

                public void setTroubleContent(String troubleContent) {
                    this.troubleContent = troubleContent;
                }

                public String getResponsibleUserName() {
                    return responsibleUserName;
                }

                public void setResponsibleUserName(String responsibleUserName) {
                    this.responsibleUserName = responsibleUserName;
                }

                public String getAcceptanceDepartmentsName() {
                    return acceptanceDepartmentsName;
                }

                public void setAcceptanceDepartmentsName(String acceptanceDepartmentsName) {
                    this.acceptanceDepartmentsName = acceptanceDepartmentsName;
                }

                public String getTaskType() {
                    return taskType;
                }

                public void setTaskType(String taskType) {
                    this.taskType = taskType;
                }

                public String getSolutionContent() {
                    return solutionContent;
                }

                public void setSolutionContent(String solutionContent) {
                    this.solutionContent = solutionContent;
                }

                public int getResponsibleScore() {
                    return responsibleScore;
                }

                public void setResponsibleScore(int responsibleScore) {
                    this.responsibleScore = responsibleScore;
                }

                public String getResponsibleDepartmentName() {
                    return responsibleDepartmentName;
                }

                public void setResponsibleDepartmentName(String responsibleDepartmentName) {
                    this.responsibleDepartmentName = responsibleDepartmentName;
                }

                public String getTroubleLevel() {
                    return troubleLevel;
                }

                public void setTroubleLevel(String troubleLevel) {
                    this.troubleLevel = troubleLevel;
                }

                public int getSolutionType() {
                    return solutionType;
                }

                public void setSolutionType(int solutionType) {
                    this.solutionType = solutionType;
                }

                public int getProcessType() {
                    return processType;
                }

                public void setProcessType(int processType) {
                    this.processType = processType;
                }

                public int getResponsibleLeaderId() {
                    return responsibleLeaderId;
                }

                public void setResponsibleLeaderId(int responsibleLeaderId) {
                    this.responsibleLeaderId = responsibleLeaderId;
                }

                public String getState() {
                    return state;
                }

                public void setState(String state) {
                    this.state = state;
                }

                public int getSourceProcessorId() {
                    return sourceProcessorId;
                }

                public void setSourceProcessorId(int sourceProcessorId) {
                    this.sourceProcessorId = sourceProcessorId;
                }

                public String getApproverName() {
                    return approverName;
                }

                public void setApproverName(String approverName) {
                    this.approverName = approverName;
                }

                public int getEntryUserId() {
                    return entryUserId;
                }

                public void setEntryUserId(int entryUserId) {
                    this.entryUserId = entryUserId;
                }

                public String getDeletes() {
                    return deletes;
                }

                public void setDeletes(String deletes) {
                    this.deletes = deletes;
                }

                public int getNowTroubleLevelId() {
                    return nowTroubleLevelId;
                }

                public void setNowTroubleLevelId(int nowTroubleLevelId) {
                    this.nowTroubleLevelId = nowTroubleLevelId;
                }

                public int getApproverId() {
                    return approverId;
                }

                public void setApproverId(int approverId) {
                    this.approverId = approverId;
                }

                public String getCorrectNoticeNo() {
                    return correctNoticeNo;
                }

                public void setCorrectNoticeNo(String correctNoticeNo) {
                    this.correctNoticeNo = correctNoticeNo;
                }

                public String getAcceptanceRuleOut() {
                    return acceptanceRuleOut;
                }

                public void setAcceptanceRuleOut(String acceptanceRuleOut) {
                    this.acceptanceRuleOut = acceptanceRuleOut;
                }

                public List<?> getTroubleSubtaskDocList() {
                    return troubleSubtaskDocList;
                }

                public void setTroubleSubtaskDocList(List<?> troubleSubtaskDocList) {
                    this.troubleSubtaskDocList = troubleSubtaskDocList;
                }
            }
        }
    }


//    /**
//     * msg : 成功
//     * code : 200
//     * resultMaps : [{"page":{"totalRecord":58,"results":[{"sourceId":1467,"technicianName":"孔德昊","sourceCategory":"1","responsibleLeaderName":"孔德昊","sourceProcessorName":"叶孝会","responsibleDepartmentId":1873,"processorId":"95","processTime":1547136000000,"taskId":4789,"acceptorName":"生产科","responsibleMoney":0,"responsibleUserId":"1435,1502,982,308,96,814,95","technicianId":95,"mainId":4788,"rectifyDay":0,"troublePlanId":9,"sourceScore":0,"acceptReason":"方案内容的","sourceMoney":0,"sourceDescription":"7转载机巷压力大，顶板下沉，安全出口高度、宽度达不到要求","fatal":false,"troubleContent":"行为1","troubleSubtaskDocList":[{"subtaskId":4789,"docUsage":0,"docId":4786},{"subtaskId":4789,"docUsage":0,"docId":4787},{"subtaskId":4789,"docUsage":4,"docId":4790},{"subtaskId":4789,"docUsage":1,"docId":4791}],"responsibleUserName":"孔德昊,贾钢,宋伟,姚立波,刘文平,叶孝会,杨超","taskType":"8","solutionContent":"验收几句","responsibleScore":0,"responsibleDepartmentName":"综采队","troubleLevel":"一般","solutionType":0,"processType":1,"responsibleLeaderId":95,"state":"5","sourceProcessorId":1435,"approverName":"孔德昊","deletes":"0","approverId":95},{"sourceId":2,"technicianName":"孔德昊","sourceCategory":"1","responsibleLeaderName":"孔德昊","sourceProcessorName":"孔德昊","responsibleDepartmentId":1873,"processorId":"95","processTime":1547136000000,"taskId":4727,"acceptorName":"生产科","responsibleMoney":0,"responsibleUserId":"1435,1502,982,308,96,814,95","technicianId":95,"mainId":4726,"rectifyDay":0,"troublePlanId":9,"sourceScore":0,"acceptReason":"uuuu","sourceMoney":0,"sourceDescription":"掘进工作面顶、帮状况差或顶板破碎、两帮片帮严重","fatal":false,"troubleContent":"红红火火恍恍惚惚","troubleSubtaskDocList":[{"subtaskId":4727,"docUsage":0,"docId":4724},{"subtaskId":4727,"docUsage":0,"docId":4725},{"subtaskId":4727,"docUsage":4,"docId":4728},{"subtaskId":4727,"docUsage":4,"docId":4729},{"subtaskId":4727,"docUsage":1,"docId":4730},{"subtaskId":4727,"docUsage":1,"docId":4731}],"responsibleUserName":"孔德昊,贾钢,宋伟,姚立波,刘文平,叶孝会,杨超","taskType":"8","solutionContent":"哦哦噢噢噢哦哦","responsibleScore":0,"responsibleDepartmentName":"综采队","troubleLevel":"一般","solutionType":0,"processType":1,"responsibleLeaderId":95,"state":"5","sourceProcessorId":95,"approverName":"孔德昊","deletes":"0","approverId":95},{"sourceId":2,"technicianName":"孔德昊","sourceCategory":"1","responsibleLeaderName":"孔德昊","sourceProcessorName":"孔德昊","responsibleDepartmentId":1873,"processorId":"95","processTime":1547049600000,"taskId":4614,"acceptorName":"生产科","responsibleMoney":0,"responsibleUserId":"1435,1502,982,308,96,814,95","technicianId":95,"mainId":4613,"rectifyDay":0,"troublePlanId":0,"sourceScore":0,"acceptReason":"到家了","sourceMoney":0,"sourceDescription":"掘进工作面顶、帮状况差或顶板破碎、两帮片帮严重","fatal":false,"troubleContent":"打你电话","troubleSubtaskDocList":[{"subtaskId":4614,"docUsage":0,"docId":4612},{"subtaskId":4614,"docUsage":4,"docId":4615},{"subtaskId":4614,"docUsage":1,"docId":4616}],"responsibleUserName":"孔德昊,贾钢,宋伟,姚立波,刘文平,叶孝会,杨超","taskType":"8","solutionContent":"鹅蛋","responsibleScore":0,"responsibleDepartmentName":"综采队","troubleLevel":"一般","solutionType":0,"processType":1,"responsibleLeaderId":95,"state":"5","sourceProcessorId":95,"approverName":"孔德昊","deletes":"0","approverId":95},{"sourceId":0,"technicianName":"孔德昊","sourceCategory":"2","responsibleLeaderName":"孔德昊","sourceProcessorName":"孔德昊","responsibleDepartmentId":1873,"processorId":"95","processTime":1547049600000,"taskId":4609,"acceptorName":"生产科","responsibleMoney":100,"responsibleUserId":"1435,1502,982,308,96,814,95","technicianId":95,"mainId":4608,"rectifyDay":0,"troublePlanId":9,"souutionType":0,"processType":1,"responsibleLeaderId":95,"state":"5","sourceProcessorId":95,"approverName":"孔德昊","deletes":"0","approverId":95},{"sourceId":5,"technicianName":"孔德昊","solutionTimeLimit":1547368655000,"sourceCategory":"1","responsibleLeaderName":"孔德昊","sourceProcessorName":"孔德昊","responsibleDepartmentId":1873,"processorId":"95","processTime":1547049600000,"taskId":4602,"acceptorName":"生产科","responsibleMoney":0,"responsibleUserId":"1435,1502,982,308,96,814,95","technicianId":95,"mainId":4601,"rectifyDay":3,"acceptorId":1868,"troublePlanId":0,"sourceScore":0,"correctNoticeNo":"201901100029","acceptReason":"回家结婚","sourceMoney":0,"sourceDescription":"掘进工作面施工时操作失误或使用工具不当","fatal":false,"troubleContent":"好几块火锅","troubleSubtaskDocList":[{"subtaskId":4602,"docUsage":0,"docId":4600},{"subtaskId":4602,"docUsage":5,"docId":4603},{"subtaskId":4602,"docUsage":5,"docId":4604},{"subtaskId":4602,"docUsage":4,"docId":4606}],"responsibleUserName":"孔德昊,贾钢,宋伟,姚立波,刘文平,叶孝会,杨超","taskType":"10","solutionContent":"共价化合物","solutionGoal":"打火机睡觉睡觉","responsibleScore":0,"responsibleDepartmentName":"综采队","troubleLevel":"一般","solutionType":0,"processType":1,"responsibleLeaderId":95,"state":"9","sourceProcessorId":95,"approverName":"孔德昊","deletes":"0","approverId":95},{"sourceId":2,"technicianName":"孔德昊","sourceCategory":"1","responsibleLeaderName":"孔德昊","sourceProcessorName":"孔德昊","responsibleDepartmentId":1873,"processorId":"95","processTime":1547049600000,"taskId":4590,"acceptorName":"生产科","responsibleMoney":0,"responsibleUserId":"1435,1502,982,308,96,814,95","technicianId":95,"mainId":4589,"rectifyDay":0,"troublePlanId":9,"sourceScore":0,"acceptReason":"返合租不着急看手机","sourceMoney":0,"sourceDescription":"掘进工作面顶、帮状况差或顶板破碎、两帮片帮严重","fatal":false,"troubleContent":"就会后悔","troubleSubtaskDocList":[{"subtaskId":4590,"docUsage":0,"docId":4586},{"subtaskId":4590,"docUsage":0,"docId":4587},{"subtaskId":4590,"docUsage":0,"docId":4588},{"subtaskId":4590,"docUsage":4,"docId":4591},{"subtaskId":4590,"docUsage":1,"docId":4592},{"subtaskId":4590,"docUsage":4,"docId":4593}],"responsibleUserName":"孔德昊,贾钢,宋伟,姚立波,刘文平,叶孝会,杨超","taskType":"8","solutionContent":"朱碧石可是你深V","responsibleScore":0,"responsibleDepartmentName":"综采队","troubleLevel":"一般","solutionType":0,"processType":1,"responsibleLeaderId":95,"state":"5","sourceProcessorId":95,"approverName":"孔德昊","deletes":"0","approverId":95}],"pageSize":6,"dateFormat":"","totalPage":10,"pageNo":1,"params":{},"resultMaps":[]}}]
//     */
//
//    private String msg;
//    private String code;
//    private List<ResultMapsBean> resultMaps;
//
//    public String getMsg() {
//        return msg;
//    }
//
//    public void setMsg(String msg) {
//        this.msg = msg;
//    }
//
//    public String getCode() {
//        return code;
//    }
//
//    public void setCode(String code) {
//        this.code = code;
//    }
//
//    public List<ResultMapsBean> getResultMaps() {
//        return resultMaps;
//    }
//
//    public void setResultMaps(List<ResultMapsBean> resultMaps) {
//        this.resultMaps = resultMaps;
//    }
//
//    public static class ResultMapsBean {
//        /**
//         * page : {"totalRecord":58,"results":[{"sourceId":1467,"technicianName":"孔德昊","sourceCategory":"1","responsibleLeaderName":"孔德昊","sourceProcessorName":"叶孝会","responsibleDepartmentId":1873,"processorId":"95","processTime":1547136000000,"taskId":4789,"acceptorName":"生产科","responsibleMoney":0,"responsibleUserId":"1435,1502,982,308,96,814,95","technicianId":95,"mainId":4788,"rectifyDay":0,"troublePlanId":9,"sourceScore":0,"acceptReason":"方案内容的","sourceMoney":0,"sourceDescription":"7转载机巷压力大，顶板下沉，安全出口高度、宽度达不到要求","fatal":false,"troubleContent":"行为1","troubleSubtaskDocList":[{"subtaskId":4789,"docUsage":0,"docId":4786},{"subtaskId":4789,"docUsage":0,"docId":4787},{"subtaskId":4789,"docUsage":4,"docId":4790},{"subtaskId":4789,"docUsage":1,"docId":4791}],"responsibleUserName":"孔德昊,贾钢,宋伟,姚立波,刘文平,叶孝会,杨超","taskType":"8","solutionContent":"验收几句","responsibleScore":0,"responsibleDepartmentName":"综采队","troubleLevel":"一般","solutionType":0,"processType":1,"responsibleLeaderId":95,"state":"5","sourceProcessorId":1435,"approverName":"孔德昊","deletes":"0","approverId":95,"souutionType":0,"solutionTimeLimit":1547368655000,"acceptorId":1868,"correctNoticeNo":"201901100029","solutionGoal":"打火机睡觉睡觉"},{"sourceId":2,"technicianName":"孔德昊","sourceCategory":"1","responsibleLeaderName":"孔德昊","sourceProcessorName":"孔德昊","responsibleDepartmentId":1873,"processorId":"95","processTime":1547136000000,"taskId":4727,"acceptorName":"生产科","responsibleMoney":0,"responsibleUserId":"1435,1502,982,308,96,814,95","technicianId":95,"mainId":4726,"rectifyDay":0,"troublePlanId":9,"sourceScore":0,"acceptReason":"uuuu","sourceMoney":0,"sourceDescription":"掘进工作面顶、帮状况差或顶板破碎、两帮片帮严重","fatal":false,"troubleContent":"红红火火恍恍惚惚","troubleSubtaskDocList":[{"subtaskId":4727,"docUsage":0,"docId":4724},{"subtaskId":4727,"docUsage":0,"docId":4725},{"subtaskId":4727,"docUsage":4,"docId":4728},{"subtaskId":4727,"docUsage":4,"docId":4729},{"subtaskId":4727,"docUsage":1,"docId":4730},{"subtaskId":4727,"docUsage":1,"docId":4731}],"responsibleUserName":"孔德昊,贾钢,宋伟,姚立波,刘文平,叶孝会,杨超","taskType":"8","solutionContent":"哦哦噢噢噢哦哦","responsibleScore":0,"responsibleDepartmentName":"综采队","troubleLevel":"一般","solutionType":0,"processType":1,"responsibleLeaderId":95,"state":"5","sourceProcessorId":95,"approverName":"孔德昊","deletes":"0","approverId":95},{"sourceId":2,"technicianName":"孔德昊","sourceCategory":"1","responsibleLeaderName":"孔德昊","sourceProcessorName":"孔德昊","responsibleDepartmentId":1873,"processorId":"95","processTime":1547049600000,"taskId":4614,"acceptorName":"生产科","responsibleMoney":0,"responsibleUserId":"1435,1502,982,308,96,814,95","technicianId":95,"mainId":4613,"rectifyDay":0,"troublePlanId":0,"sourceScore":0,"acceptReason":"到家了","sourceMoney":0,"sourceDescription":"掘进工作面顶、帮状况差或顶板破碎、两帮片帮严重","fatal":false,"troubleContent":"打你电话","troubleSubtaskDocList":[{"subtaskId":4614,"docUsage":0,"docId":4612},{"subtaskId":4614,"docUsage":4,"docId":4615},{"subtaskId":4614,"docUsage":1,"docId":4616}],"responsibleUserName":"孔德昊,贾钢,宋伟,姚立波,刘文平,叶孝会,杨超","taskType":"8","solutionContent":"鹅蛋","responsibleScore":0,"responsibleDepartmentName":"综采队","troubleLevel":"一般","solutionType":0,"processType":1,"responsibleLeaderId":95,"state":"5","sourceProcessorId":95,"approverName":"孔德昊","deletes":"0","approverId":95},{"sourceId":0,"technicianName":"孔德昊","sourceCategory":"2","responsibleLeaderName":"孔德昊","sourceProcessorName":"孔德昊","responsibleDepartmentId":1873,"processorId":"95","processTime":1547049600000,"taskId":4609,"acceptorName":"生产科","responsibleMoney":100,"responsibleUserId":"1435,1502,982,308,96,814,95","technicianId":95,"mainId":4608,"rectifyDay":0,"troublePlanId":9,"souutionType":0,"processType":1,"responsibleLeaderId":95,"state":"5","sourceProcessorId":95,"approverName":"孔德昊","deletes":"0","approverId":95},{"sourceId":5,"technicianName":"孔德昊","solutionTimeLimit":1547368655000,"sourceCategory":"1","responsibleLeaderName":"孔德昊","sourceProcessorName":"孔德昊","responsibleDepartmentId":1873,"processorId":"95","processTime":1547049600000,"taskId":4602,"acceptorName":"生产科","responsibleMoney":0,"responsibleUserId":"1435,1502,982,308,96,814,95","technicianId":95,"mainId":4601,"rectifyDay":3,"acceptorId":1868,"troublePlanId":0,"sourceScore":0,"correctNoticeNo":"201901100029","acceptReason":"回家结婚","sourceMoney":0,"sourceDescription":"掘进工作面施工时操作失误或使用工具不当","fatal":false,"troubleContent":"好几块火锅","troubleSubtaskDocList":[{"subtaskId":4602,"docUsage":0,"docId":4600},{"subtaskId":4602,"docUsage":5,"docId":4603},{"subtaskId":4602,"docUsage":5,"docId":4604},{"subtaskId":4602,"docUsage":4,"docId":4606}],"responsibleUserName":"孔德昊,贾钢,宋伟,姚立波,刘文平,叶孝会,杨超","taskType":"10","solutionContent":"共价化合物","solutionGoal":"打火机睡觉睡觉","responsibleScore":0,"responsibleDepartmentName":"综采队","troubleLevel":"一般","solutionType":0,"processType":1,"responsibleLeaderId":95,"state":"9","sourceProcessorId":95,"approverName":"孔德昊","deletes":"0","approverId":95},{"sourceId":2,"technicianName":"孔德昊","sourceCategory":"1","responsibleLeaderName":"孔德昊","sourceProcessorName":"孔德昊","responsibleDepartmentId":1873,"processorId":"95","processTime":1547049600000,"taskId":4590,"acceptorName":"生产科","responsibleMoney":0,"responsibleUserId":"1435,1502,982,308,96,814,95","technicianId":95,"mainId":4589,"rectifyDay":0,"troublePlanId":9,"sourceScore":0,"acceptReason":"返合租不着急看手机","sourceMoney":0,"sourceDescription":"掘进工作面顶、帮状况差或顶板破碎、两帮片帮严重","fatal":false,"troubleContent":"就会后悔","troubleSubtaskDocList":[{"subtaskId":4590,"docUsage":0,"docId":4586},{"subtaskId":4590,"docUsage":0,"docId":4587},{"subtaskId":4590,"docUsage":0,"docId":4588},{"subtaskId":4590,"docUsage":4,"docId":4591},{"subtaskId":4590,"docUsage":1,"docId":4592},{"subtaskId":4590,"docUsage":4,"docId":4593}],"responsibleUserName":"孔德昊,贾钢,宋伟,姚立波,刘文平,叶孝会,杨超","taskType":"8","solutionContent":"朱碧石可是你深V","responsibleScore":0,"responsibleDepartmentName":"综采队","troubleLevel":"一般","solutionType":0,"processType":1,"responsibleLeaderId":95,"state":"5","sourceProcessorId":95,"approverName":"孔德昊","deletes":"0","approverId":95}],"pageSize":6,"dateFormat":"","totalPage":10,"pageNo":1,"params":{},"resultMaps":[]}
//         */
//
//        private PageBean page;
//
//        public PageBean getPage() {
//            return page;
//        }
//
//        public void setPage(PageBean page) {
//            this.page = page;
//        }
//
//        public static class PageBean {
//            /**
//             * totalRecord : 58
//             * results : [{"sourceId":1467,"technicianName":"孔德昊","sourceCategory":"1","responsibleLeaderName":"孔德昊","sourceProcessorName":"叶孝会","responsibleDepartmentId":1873,"processorId":"95","processTime":1547136000000,"taskId":4789,"acceptorName":"生产科","responsibleMoney":0,"responsibleUserId":"1435,1502,982,308,96,814,95","technicianId":95,"mainId":4788,"rectifyDay":0,"troublePlanId":9,"sourceScore":0,"acceptReason":"方案内容的","sourceMoney":0,"sourceDescription":"7转载机巷压力大，顶板下沉，安全出口高度、宽度达不到要求","fatal":false,"troubleContent":"行为1","troubleSubtaskDocList":[{"subtaskId":4789,"docUsage":0,"docId":4786},{"subtaskId":4789,"docUsage":0,"docId":4787},{"subtaskId":4789,"docUsage":4,"docId":4790},{"subtaskId":4789,"docUsage":1,"docId":4791}],"responsibleUserName":"孔德昊,贾钢,宋伟,姚立波,刘文平,叶孝会,杨超","taskType":"8","solutionContent":"验收几句","responsibleScore":0,"responsibleDepartmentName":"综采队","troubleLevel":"一般","solutionType":0,"processType":1,"responsibleLeaderId":95,"state":"5","sourceProcessorId":1435,"approverName":"孔德昊","deletes":"0","approverId":95},{"sourceId":2,"technicianName":"孔德昊","sourceCategory":"1","responsibleLeaderName":"孔德昊","sourceProcessorName":"孔德昊","responsibleDepartmentId":1873,"processorId":"95","processTime":1547136000000,"taskId":4727,"acceptorName":"生产科","responsibleMoney":0,"responsibleUserId":"1435,1502,982,308,96,814,95","technicianId":95,"mainId":4726,"rectifyDay":0,"troublePlanId":9,"sourceScore":0,"acceptReason":"uuuu","sourceMoney":0,"sourceDescription":"掘进工作面顶、帮状况差或顶板破碎、两帮片帮严重","fatal":false,"troubleContent":"红红火火恍恍惚惚","troubleSubtaskDocList":[{"subtaskId":4727,"docUsage":0,"docId":4724},{"subtaskId":4727,"docUsage":0,"docId":4725},{"subtaskId":4727,"docUsage":4,"docId":4728},{"subtaskId":4727,"docUsage":4,"docId":4729},{"subtaskId":4727,"docUsage":1,"docId":4730},{"subtaskId":4727,"docUsage":1,"docId":4731}],"responsibleUserName":"孔德昊,贾钢,宋伟,姚立波,刘文平,叶孝会,杨超","taskType":"8","solutionContent":"哦哦噢噢噢哦哦","responsibleScore":0,"responsibleDepartmentName":"综采队","troubleLevel":"一般","solutionType":0,"processType":1,"responsibleLeaderId":95,"state":"5","sourceProcessorId":95,"approverName":"孔德昊","deletes":"0","approverId":95},{"sourceId":2,"technicianName":"孔德昊","sourceCategory":"1","responsibleLeaderName":"孔德昊","sourceProcessorName":"孔德昊","responsibleDepartmentId":1873,"processorId":"95","processTime":1547049600000,"taskId":4614,"acceptorName":"生产科","responsibleMoney":0,"responsibleUserId":"1435,1502,982,308,96,814,95","technicianId":95,"mainId":4613,"rectifyDay":0,"troublePlanId":0,"sourceScore":0,"acceptReason":"到家了","sourceMoney":0,"sourceDescription":"掘进工作面顶、帮状况差或顶板破碎、两帮片帮严重","fatal":false,"troubleContent":"打你电话","troubleSubtaskDocList":[{"subtaskId":4614,"docUsage":0,"docId":4612},{"subtaskId":4614,"docUsage":4,"docId":4615},{"subtaskId":4614,"docUsage":1,"docId":4616}],"responsibleUserName":"孔德昊,贾钢,宋伟,姚立波,刘文平,叶孝会,杨超","taskType":"8","solutionContent":"鹅蛋","responsibleScore":0,"responsibleDepartmentName":"综采队","troubleLevel":"一般","solutionType":0,"processType":1,"responsibleLeaderId":95,"state":"5","sourceProcessorId":95,"approverName":"孔德昊","deletes":"0","approverId":95},{"sourceId":0,"technicianName":"孔德昊","sourceCategory":"2","responsibleLeaderName":"孔德昊","sourceProcessorName":"孔德昊","responsibleDepartmentId":1873,"processorId":"95","processTime":1547049600000,"taskId":4609,"acceptorName":"生产科","responsibleMoney":100,"responsibleUserId":"1435,1502,982,308,96,814,95","technicianId":95,"mainId":4608,"rectifyDay":0,"troublePlanId":9,"souutionType":0,"processType":1,"responsibleLeaderId":95,"state":"5","sourceProcessorId":95,"approverName":"孔德昊","deletes":"0","approverId":95},{"sourceId":5,"technicianName":"孔德昊","solutionTimeLimit":1547368655000,"sourceCategory":"1","responsibleLeaderName":"孔德昊","sourceProcessorName":"孔德昊","responsibleDepartmentId":1873,"processorId":"95","processTime":1547049600000,"taskId":4602,"acceptorName":"生产科","responsibleMoney":0,"responsibleUserId":"1435,1502,982,308,96,814,95","technicianId":95,"mainId":4601,"rectifyDay":3,"acceptorId":1868,"troublePlanId":0,"sourceScore":0,"correctNoticeNo":"201901100029","acceptReason":"回家结婚","sourceMoney":0,"sourceDescription":"掘进工作面施工时操作失误或使用工具不当","fatal":false,"troubleContent":"好几块火锅","troubleSubtaskDocList":[{"subtaskId":4602,"docUsage":0,"docId":4600},{"subtaskId":4602,"docUsage":5,"docId":4603},{"subtaskId":4602,"docUsage":5,"docId":4604},{"subtaskId":4602,"docUsage":4,"docId":4606}],"responsibleUserName":"孔德昊,贾钢,宋伟,姚立波,刘文平,叶孝会,杨超","taskType":"10","solutionContent":"共价化合物","solutionGoal":"打火机睡觉睡觉","responsibleScore":0,"responsibleDepartmentName":"综采队","troubleLevel":"一般","solutionType":0,"processType":1,"responsibleLeaderId":95,"state":"9","sourceProcessorId":95,"approverName":"孔德昊","deletes":"0","approverId":95},{"sourceId":2,"technicianName":"孔德昊","sourceCategory":"1","responsibleLeaderName":"孔德昊","sourceProcessorName":"孔德昊","responsibleDepartmentId":1873,"processorId":"95","processTime":1547049600000,"taskId":4590,"acceptorName":"生产科","responsibleMoney":0,"responsibleUserId":"1435,1502,982,308,96,814,95","technicianId":95,"mainId":4589,"rectifyDay":0,"troublePlanId":9,"sourceScore":0,"acceptReason":"返合租不着急看手机","sourceMoney":0,"sourceDescription":"掘进工作面顶、帮状况差或顶板破碎、两帮片帮严重","fatal":false,"troubleContent":"就会后悔","troubleSubtaskDocList":[{"subtaskId":4590,"docUsage":0,"docId":4586},{"subtaskId":4590,"docUsage":0,"docId":4587},{"subtaskId":4590,"docUsage":0,"docId":4588},{"subtaskId":4590,"docUsage":4,"docId":4591},{"subtaskId":4590,"docUsage":1,"docId":4592},{"subtaskId":4590,"docUsage":4,"docId":4593}],"responsibleUserName":"孔德昊,贾钢,宋伟,姚立波,刘文平,叶孝会,杨超","taskType":"8","solutionContent":"朱碧石可是你深V","responsibleScore":0,"responsibleDepartmentName":"综采队","troubleLevel":"一般","solutionType":0,"processType":1,"responsibleLeaderId":95,"state":"5","sourceProcessorId":95,"approverName":"孔德昊","deletes":"0","approverId":95}]
//             * pageSize : 6
//             * dateFormat :
//             * totalPage : 10
//             * pageNo : 1
//             * params : {}
//             * resultMaps : []
//             */
//
//            private int totalRecord;
//            private int pageSize;
//            private String dateFormat;
//            private int totalPage;
//            private int pageNo;
//            private ParamsBean params;
//            private List<ResultsBean> results;
//            private List<?> resultMaps;
//
//            public int getTotalRecord() {
//                return totalRecord;
//            }
//
//            public void setTotalRecord(int totalRecord) {
//                this.totalRecord = totalRecord;
//            }
//
//            public int getPageSize() {
//                return pageSize;
//            }
//
//            public void setPageSize(int pageSize) {
//                this.pageSize = pageSize;
//            }
//
//            public String getDateFormat() {
//                return dateFormat;
//            }
//
//            public void setDateFormat(String dateFormat) {
//                this.dateFormat = dateFormat;
//            }
//
//            public int getTotalPage() {
//                return totalPage;
//            }
//
//            public void setTotalPage(int totalPage) {
//                this.totalPage = totalPage;
//            }
//
//            public int getPageNo() {
//                return pageNo;
//            }
//
//            public void setPageNo(int pageNo) {
//                this.pageNo = pageNo;
//            }
//
//            public ParamsBean getParams() {
//                return params;
//            }
//
//            public void setParams(ParamsBean params) {
//                this.params = params;
//            }
//
//            public List<ResultsBean> getResults() {
//                return results;
//            }
//
//            public void setResults(List<ResultsBean> results) {
//                this.results = results;
//            }
//
//            public List<?> getResultMaps() {
//                return resultMaps;
//            }
//
//            public void setResultMaps(List<?> resultMaps) {
//                this.resultMaps = resultMaps;
//            }
//
//            public static class ParamsBean {
//            }
//
//            public static class ResultsBean {
//                /**
//                 * sourceId : 1467
//                 * technicianName : 孔德昊
//                 * sourceCategory : 1
//                 * responsibleLeaderName : 孔德昊
//                 * sourceProcessorName : 叶孝会
//                 * responsibleDepartmentId : 1873
//                 * processorId : 95
//                 * processTime : 1547136000000
//                 * taskId : 4789
//                 * acceptorName : 生产科
//                 * responsibleMoney : 0
//                 * responsibleUserId : 1435,1502,982,308,96,814,95
//                 * technicianId : 95
//                 * mainId : 4788
//                 * rectifyDay : 0
//                 * troublePlanId : 9
//                 * sourceScore : 0
//                 * acceptReason : 方案内容的
//                 * sourceMoney : 0
//                 * sourceDescription : 7转载机巷压力大，顶板下沉，安全出口高度、宽度达不到要求
//                 * fatal : false
//                 * troubleContent : 行为1
//                 * troubleSubtaskDocList : [{"subtaskId":4789,"docUsage":0,"docId":4786},{"subtaskId":4789,"docUsage":0,"docId":4787},{"subtaskId":4789,"docUsage":4,"docId":4790},{"subtaskId":4789,"docUsage":1,"docId":4791}]
//                 * responsibleUserName : 孔德昊,贾钢,宋伟,姚立波,刘文平,叶孝会,杨超
//                 * taskType : 8
//                 * solutionContent : 验收几句
//                 * responsibleScore : 0
//                 * responsibleDepartmentName : 综采队
//                 * troubleLevel : 一般
//                 * solutionType : 0
//                 * processType : 1
//                 * responsibleLeaderId : 95
//                 * state : 5
//                 * sourceProcessorId : 1435
//                 * approverName : 孔德昊
//                 * deletes : 0
//                 * approverId : 95
//                 * souutionType : 0
//                 * solutionTimeLimit : 1547368655000
//                 * acceptorId : 1868
//                 * correctNoticeNo : 201901100029
//                 * solutionGoal : 打火机睡觉睡觉
//                 */
//
//                private int sourceId;
//                private String technicianName;
//                private String sourceCategory;
//                private String responsibleLeaderName;
//                private String sourceProcessorName;
//                private int responsibleDepartmentId;
//                private String processorId;
//                private long processTime;
//                private int taskId;
//                private String acceptorName;
//                private int responsibleMoney;
//                private String responsibleUserId;
//                private int technicianId;
//                private int mainId;
//                private int rectifyDay;
//                private int troublePlanId;
//                private int sourceScore;
//                private String acceptReason;
//                private int sourceMoney;
//                private String sourceDescription;
//                private boolean fatal;
//                private String troubleContent;
//                private String responsibleUserName;
//                private String taskType;
//                private String solutionContent;
//                private int responsibleScore;
//                private String responsibleDepartmentName;
//                private String troubleLevel;
//                private int solutionType;
//                private int processType;
//                private int responsibleLeaderId;
//                private String state;
//                private int sourceProcessorId;
//                private String approverName;
//                private String deletes;
//                private int approverId;
//                private int souutionType;
//                private long solutionTimeLimit;
//                private int acceptorId;
//                private String correctNoticeNo;
//                private String solutionGoal;
//                private List<TroubleSubtaskDocListBean> troubleSubtaskDocList;
//
//                public int getSourceId() {
//                    return sourceId;
//                }
//
//                public void setSourceId(int sourceId) {
//                    this.sourceId = sourceId;
//                }
//
//                public String getTechnicianName() {
//                    return technicianName;
//                }
//
//                public void setTechnicianName(String technicianName) {
//                    this.technicianName = technicianName;
//                }
//
//                public String getSourceCategory() {
//                    return sourceCategory;
//                }
//
//                public void setSourceCategory(String sourceCategory) {
//                    this.sourceCategory = sourceCategory;
//                }
//
//                public String getResponsibleLeaderName() {
//                    return responsibleLeaderName;
//                }
//
//                public void setResponsibleLeaderName(String responsibleLeaderName) {
//                    this.responsibleLeaderName = responsibleLeaderName;
//                }
//
//                public String getSourceProcessorName() {
//                    return sourceProcessorName;
//                }
//
//                public void setSourceProcessorName(String sourceProcessorName) {
//                    this.sourceProcessorName = sourceProcessorName;
//                }
//
//                public int getResponsibleDepartmentId() {
//                    return responsibleDepartmentId;
//                }
//
//                public void setResponsibleDepartmentId(int responsibleDepartmentId) {
//                    this.responsibleDepartmentId = responsibleDepartmentId;
//                }
//
//                public String getProcessorId() {
//                    return processorId;
//                }
//
//                public void setProcessorId(String processorId) {
//                    this.processorId = processorId;
//                }
//
//                public long getProcessTime() {
//                    return processTime;
//                }
//
//                public void setProcessTime(long processTime) {
//                    this.processTime = processTime;
//                }
//
//                public int getTaskId() {
//                    return taskId;
//                }
//
//                public void setTaskId(int taskId) {
//                    this.taskId = taskId;
//                }
//
//                public String getAcceptorName() {
//                    return acceptorName;
//                }
//
//                public void setAcceptorName(String acceptorName) {
//                    this.acceptorName = acceptorName;
//                }
//
//                public int getResponsibleMoney() {
//                    return responsibleMoney;
//                }
//
//                public void setResponsibleMoney(int responsibleMoney) {
//                    this.responsibleMoney = responsibleMoney;
//                }
//
//                public String getResponsibleUserId() {
//                    return responsibleUserId;
//                }
//
//                public void setResponsibleUserId(String responsibleUserId) {
//                    this.responsibleUserId = responsibleUserId;
//                }
//
//                public int getTechnicianId() {
//                    return technicianId;
//                }
//
//                public void setTechnicianId(int technicianId) {
//                    this.technicianId = technicianId;
//                }
//
//                public int getMainId() {
//                    return mainId;
//                }
//
//                public void setMainId(int mainId) {
//                    this.mainId = mainId;
//                }
//
//                public int getRectifyDay() {
//                    return rectifyDay;
//                }
//
//                public void setRectifyDay(int rectifyDay) {
//                    this.rectifyDay = rectifyDay;
//                }
//
//                public int getTroublePlanId() {
//                    return troublePlanId;
//                }
//
//                public void setTroublePlanId(int troublePlanId) {
//                    this.troublePlanId = troublePlanId;
//                }
//
//                public int getSourceScore() {
//                    return sourceScore;
//                }
//
//                public void setSourceScore(int sourceScore) {
//                    this.sourceScore = sourceScore;
//                }
//
//                public String getAcceptReason() {
//                    return acceptReason;
//                }
//
//                public void setAcceptReason(String acceptReason) {
//                    this.acceptReason = acceptReason;
//                }
//
//                public int getSourceMoney() {
//                    return sourceMoney;
//                }
//
//                public void setSourceMoney(int sourceMoney) {
//                    this.sourceMoney = sourceMoney;
//                }
//
//                public String getSourceDescription() {
//                    return sourceDescription;
//                }
//
//                public void setSourceDescription(String sourceDescription) {
//                    this.sourceDescription = sourceDescription;
//                }
//
//                public boolean isFatal() {
//                    return fatal;
//                }
//
//                public void setFatal(boolean fatal) {
//                    this.fatal = fatal;
//                }
//
//                public String getTroubleContent() {
//                    return troubleContent;
//                }
//
//                public void setTroubleContent(String troubleContent) {
//                    this.troubleContent = troubleContent;
//                }
//
//                public String getResponsibleUserName() {
//                    return responsibleUserName;
//                }
//
//                public void setResponsibleUserName(String responsibleUserName) {
//                    this.responsibleUserName = responsibleUserName;
//                }
//
//                public String getTaskType() {
//                    return taskType;
//                }
//
//                public void setTaskType(String taskType) {
//                    this.taskType = taskType;
//                }
//
//                public String getSolutionContent() {
//                    return solutionContent;
//                }
//
//                public void setSolutionContent(String solutionContent) {
//                    this.solutionContent = solutionContent;
//                }
//
//                public int getResponsibleScore() {
//                    return responsibleScore;
//                }
//
//                public void setResponsibleScore(int responsibleScore) {
//                    this.responsibleScore = responsibleScore;
//                }
//
//                public String getResponsibleDepartmentName() {
//                    return responsibleDepartmentName;
//                }
//
//                public void setResponsibleDepartmentName(String responsibleDepartmentName) {
//                    this.responsibleDepartmentName = responsibleDepartmentName;
//                }
//
//                public String getTroubleLevel() {
//                    return troubleLevel;
//                }
//
//                public void setTroubleLevel(String troubleLevel) {
//                    this.troubleLevel = troubleLevel;
//                }
//
//                public int getSolutionType() {
//                    return solutionType;
//                }
//
//                public void setSolutionType(int solutionType) {
//                    this.solutionType = solutionType;
//                }
//
//                public int getProcessType() {
//                    return processType;
//                }
//
//                public void setProcessType(int processType) {
//                    this.processType = processType;
//                }
//
//                public int getResponsibleLeaderId() {
//                    return responsibleLeaderId;
//                }
//
//                public void setResponsibleLeaderId(int responsibleLeaderId) {
//                    this.responsibleLeaderId = responsibleLeaderId;
//                }
//
//                public String getState() {
//                    return state;
//                }
//
//                public void setState(String state) {
//                    this.state = state;
//                }
//
//                public int getSourceProcessorId() {
//                    return sourceProcessorId;
//                }
//
//                public void setSourceProcessorId(int sourceProcessorId) {
//                    this.sourceProcessorId = sourceProcessorId;
//                }
//
//                public String getApproverName() {
//                    return approverName;
//                }
//
//                public void setApproverName(String approverName) {
//                    this.approverName = approverName;
//                }
//
//                public String getDeletes() {
//                    return deletes;
//                }
//
//                public void setDeletes(String deletes) {
//                    this.deletes = deletes;
//                }
//
//                public int getApproverId() {
//                    return approverId;
//                }
//
//                public void setApproverId(int approverId) {
//                    this.approverId = approverId;
//                }
//
//                public int getSouutionType() {
//                    return souutionType;
//                }
//
//                public void setSouutionType(int souutionType) {
//                    this.souutionType = souutionType;
//                }
//
//                public long getSolutionTimeLimit() {
//                    return solutionTimeLimit;
//                }
//
//                public void setSolutionTimeLimit(long solutionTimeLimit) {
//                    this.solutionTimeLimit = solutionTimeLimit;
//                }
//
//                public int getAcceptorId() {
//                    return acceptorId;
//                }
//
//                public void setAcceptorId(int acceptorId) {
//                    this.acceptorId = acceptorId;
//                }
//
//                public String getCorrectNoticeNo() {
//                    return correctNoticeNo;
//                }
//
//                public void setCorrectNoticeNo(String correctNoticeNo) {
//                    this.correctNoticeNo = correctNoticeNo;
//                }
//
//                public String getSolutionGoal() {
//                    return solutionGoal;
//                }
//
//                public void setSolutionGoal(String solutionGoal) {
//                    this.solutionGoal = solutionGoal;
//                }
//
//                public List<TroubleSubtaskDocListBean> getTroubleSubtaskDocList() {
//                    return troubleSubtaskDocList;
//                }
//
//                public void setTroubleSubtaskDocList(List<TroubleSubtaskDocListBean> troubleSubtaskDocList) {
//                    this.troubleSubtaskDocList = troubleSubtaskDocList;
//                }
//
//                public static class TroubleSubtaskDocListBean {
//                    /**
//                     * subtaskId : 4789
//                     * docUsage : 0
//                     * docId : 4786
//                     */
//
//                    private int subtaskId;
//                    private int docUsage;
//                    private int docId;
//
//                    public int getSubtaskId() {
//                        return subtaskId;
//                    }
//
//                    public void setSubtaskId(int subtaskId) {
//                        this.subtaskId = subtaskId;
//                    }
//
//                    public int getDocUsage() {
//                        return docUsage;
//                    }
//
//                    public void setDocUsage(int docUsage) {
//                        this.docUsage = docUsage;
//                    }
//
//                    public int getDocId() {
//                        return docId;
//                    }
//
//                    public void setDocId(int docId) {
//                        this.docId = docId;
//                    }
//                }
//            }
//        }
//    }
}
