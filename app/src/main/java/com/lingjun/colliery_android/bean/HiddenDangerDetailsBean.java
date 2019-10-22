package com.lingjun.colliery_android.bean;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * 作者: lihuan
 * 时间: 2018/11/19 11:09
 * 说明: 隐患详情
 */
public class HiddenDangerDetailsBean implements Serializable {


    /**
     * msg : 成功
     * code : 200
     * data : {"subTaskList":{"taskId":4619,"mainId":4618,"number":111,"sourceProcessorId":95,"sourceProcessorName":"孔德昊","technicianName":"孔德昊","sourceId":2,"sourceCategory":"1","sourceDescription":"掘进工作面顶、帮状况差或顶板破碎、两帮片帮严重","sourceMoney":0,"sourceScore":0,"troubleContent":"鹅蛋","processType":1,"processorId":"95","processorName":"孔德昊","processorDepartmentId":1986,"processTime":1547049600000,"troubleLevel":"一般","responsibleMoney":0,"responsibleScore":0,"responsibleDepartmentId":1873,"responsibleDepartmentName":"综采队","responsibleUserId":"1435,1502,982,308,96,814,95","responsibleUserName":"孔德昊,贾钢,宋伟,姚立波,刘文平,叶孝会,杨超","responsibleLeaderId":95,"responsibleLeaderName":"孔德昊","responsibleRemark":"sdfs ","solutionGoal":"发啊姐姐","solutionTimeLimit":1547372228000,"solutionType":0,"solutionContent":"sdf ","solutionFunding":"2312","solutionPlan":"wer ","troublePlanId":0,"solutionChiefId":2,"solutionChiefName":"孔德昊","solutionChiefRemark":"s ","technicianId":95,"acceptorId":1868,"acceptorName":"生产科","approverName":"孔德昊","troublePlanName":"孔德昊","acceptReason":"wsfwsf","approverId":95,"approveRemark":"sfsfs ","correctNoticeNo":"201901100035","delayTime":1548325648000,"delayReason":"derhj","fatalReason":"fghfhfgh","fatalApproverId":95,"fatalApproverRemark":"sdfsv ","fatal":false,"startTime":1547116100000,"endTime":1547116103000,"redoReason":"ssdsdfsdf","closeReason":"dfsdfsfdsdf","deleteReason":"sdfsdfsfds","flags":"MQ==","technicianRemark":"孔德昊","troubleSubtaskDocList":[{"subtaskId":4619,"docId":4616,"docUsage":0,"number":"111"},{"subtaskId":4619,"docId":4616,"docUsage":1,"number":"111"},{"subtaskId":4619,"docId":4616,"docUsage":2,"number":"111"},{"subtaskId":4619,"docId":4616,"docUsage":3,"number":"111"},{"subtaskId":4619,"docId":4616,"docUsage":4,"number":"111"},{"subtaskId":4619,"docId":4616,"docUsage":5,"number":"111"}],"state":"5","deletes":"111","rectifyDay":3,"acceptanceDismiss":"1","fatalApproverName":"孔德昊","taskType":"9"},"zjfileList":[{"subtaskId":"111","docId":"111","docUsage":"111","number":"111","url":"/upload/1547112917793.jpg","fileId":4616,"swfUrl":"/upload/1547112917793.jpg","fileName":"1547112917793.jpg"}],"sysTask":{"id":4619,"title":"1.顶板无离层、无活矸、无鳞片，支护完好，空顶、空帮距符合作业规程规定。2.巷帮无裂缝。","tasktype":"9","description":"掘进工作面顶、帮状况差或顶板破碎、两帮片帮严重","createtime":1547113008000,"creatorId":95,"state":"5","modifytime":1547113028000,"priority":0,"deleted":0,"starttime":1547113008000,"endtime":1547113008000,"auth":"95","delaytime":1547113008000,"creatorName":"孔德昊","mainTaskId":4619},"listSubTaskimg":[{"subtaskId":4619,"docId":4166,"docUsage":1,"number":6,"url":"/upload/1547112917793.jpg","fileId":4616,"swfUrl":"/upload/1547112917793.jpg","fileName":"1547112917793.jpg"}],"maintask":{"taskId":4618,"location":"2313的完成的身份 高原红","clauseId":12,"clauseCategory":4,"clauseDescription":"1.顶板无离层、无活矸、无鳞片，支护完好，空顶、空帮距符合作业规程规定。2.巷帮无裂缝。","userId":95,"userName":"孔德昊","createTime":1547113008000,"state":"2","areaId":0,"areaName":"sdf"},"fafileList":[{"subtaskId":54,"docId":4611,"docUsage":4,"number":3,"url":"/upload/1547112917793.jpg","fileId":4616,"swfUrl":"/upload/1547112917793.jpg","fileName":"1547112917793.jpg"}],"jjfileList":[{"subtaskId":4619,"docId":46166,"docUsage":5,"number":9,"url":"/upload/1547112917793.jpg","fileId":4616,"swfUrl":"/upload/1547112917793.jpg","fileName":"1547112917793.jpg"}],"zgfileList":[{"subtaskId":4619,"docId":4166,"docUsage":6,"number":9,"url":"/upload/1547112917793.jpg","fileId":4616,"swfUrl":"/upload/1547112917793.jpg","fileName":"1547112917793.jpg"}],"ysfileList":[{"subtaskId":4619,"docId":6,"docUsage":9,"number":8,"url":"/upload/1547112917793.jpg","fileId":4616,"swfUrl":"/upload/1547112917793.jpg","fileName":"1547112917793.jpg"}],"url":"http://134.175.189.65:8888/safety/"}
     * resultMaps : []
     */

    private String msg;
    private String code;
    private DataBean data;
    private ArrayList<?> resultMaps;

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

    public ArrayList<?> getResultMaps() {
        return resultMaps;
    }

    public void setResultMaps(ArrayList<?> resultMaps) {
        this.resultMaps = resultMaps;
    }

    public static class DataBean implements Serializable {
        /**
         * subTaskList : {"taskId":4619,"mainId":4618,"number":111,"sourceProcessorId":95,"sourceProcessorName":"孔德昊","technicianName":"孔德昊","sourceId":2,"sourceCategory":"1","sourceDescription":"掘进工作面顶、帮状况差或顶板破碎、两帮片帮严重","sourceMoney":0,"sourceScore":0,"troubleContent":"鹅蛋","processType":1,"processorId":"95","processorName":"孔德昊","processorDepartmentId":1986,"processTime":1547049600000,"troubleLevel":"一般","responsibleMoney":0,"responsibleScore":0,"responsibleDepartmentId":1873,"responsibleDepartmentName":"综采队","responsibleUserId":"1435,1502,982,308,96,814,95","responsibleUserName":"孔德昊,贾钢,宋伟,姚立波,刘文平,叶孝会,杨超","responsibleLeaderId":95,"responsibleLeaderName":"孔德昊","responsibleRemark":"sdfs ","solutionGoal":"发啊姐姐","solutionTimeLimit":1547372228000,"solutionType":0,"solutionContent":"sdf ","solutionFunding":"2312","solutionPlan":"wer ","troublePlanId":0,"solutionChiefId":2,"solutionChiefName":"孔德昊","solutionChiefRemark":"s ","technicianId":95,"acceptorId":1868,"acceptorName":"生产科","approverName":"孔德昊","troublePlanName":"孔德昊","acceptReason":"wsfwsf","approverId":95,"approveRemark":"sfsfs ","correctNoticeNo":"201901100035","delayTime":1548325648000,"delayReason":"derhj","fatalReason":"fghfhfgh","fatalApproverId":95,"fatalApproverRemark":"sdfsv ","fatal":false,"startTime":1547116100000,"endTime":1547116103000,"redoReason":"ssdsdfsdf","closeReason":"dfsdfsfdsdf","deleteReason":"sdfsdfsfds","flags":"MQ==","technicianRemark":"孔德昊","troubleSubtaskDocList":[{"subtaskId":4619,"docId":4616,"docUsage":0,"number":"111"},{"subtaskId":4619,"docId":4616,"docUsage":1,"number":"111"},{"subtaskId":4619,"docId":4616,"docUsage":2,"number":"111"},{"subtaskId":4619,"docId":4616,"docUsage":3,"number":"111"},{"subtaskId":4619,"docId":4616,"docUsage":4,"number":"111"},{"subtaskId":4619,"docId":4616,"docUsage":5,"number":"111"}],"state":"5","deletes":"111","rectifyDay":3,"acceptanceDismiss":"1","fatalApproverName":"孔德昊","taskType":"9"}
         * zjfileList : [{"subtaskId":"111","docId":"111","docUsage":"111","number":"111","url":"/upload/1547112917793.jpg","fileId":4616,"swfUrl":"/upload/1547112917793.jpg","fileName":"1547112917793.jpg"}]
         * sysTask : {"id":4619,"title":"1.顶板无离层、无活矸、无鳞片，支护完好，空顶、空帮距符合作业规程规定。2.巷帮无裂缝。","tasktype":"9","description":"掘进工作面顶、帮状况差或顶板破碎、两帮片帮严重","createtime":1547113008000,"creatorId":95,"state":"5","modifytime":1547113028000,"priority":0,"deleted":0,"starttime":1547113008000,"endtime":1547113008000,"auth":"95","delaytime":1547113008000,"creatorName":"孔德昊","mainTaskId":4619}
         * listSubTaskimg : [{"subtaskId":4619,"docId":4166,"docUsage":1,"number":6,"url":"/upload/1547112917793.jpg","fileId":4616,"swfUrl":"/upload/1547112917793.jpg","fileName":"1547112917793.jpg"}]
         * maintask : {"taskId":4618,"location":"2313的完成的身份 高原红","clauseId":12,"clauseCategory":4,"clauseDescription":"1.顶板无离层、无活矸、无鳞片，支护完好，空顶、空帮距符合作业规程规定。2.巷帮无裂缝。","userId":95,"userName":"孔德昊","createTime":1547113008000,"state":"2","areaId":0,"areaName":"sdf"}
         * fafileList : [{"subtaskId":54,"docId":4611,"docUsage":4,"number":3,"url":"/upload/1547112917793.jpg","fileId":4616,"swfUrl":"/upload/1547112917793.jpg","fileName":"1547112917793.jpg"}]
         * jjfileList : [{"subtaskId":4619,"docId":46166,"docUsage":5,"number":9,"url":"/upload/1547112917793.jpg","fileId":4616,"swfUrl":"/upload/1547112917793.jpg","fileName":"1547112917793.jpg"}]
         * zgfileList : [{"subtaskId":4619,"docId":4166,"docUsage":6,"number":9,"url":"/upload/1547112917793.jpg","fileId":4616,"swfUrl":"/upload/1547112917793.jpg","fileName":"1547112917793.jpg"}]
         * ysfileList : [{"subtaskId":4619,"docId":6,"docUsage":9,"number":8,"url":"/upload/1547112917793.jpg","fileId":4616,"swfUrl":"/upload/1547112917793.jpg","fileName":"1547112917793.jpg"}]
         * url : http://134.175.189.65:8888/safety/
         */

        private SubTaskListBean subTaskList;
        private SysTaskBean sysTask;
        private MaintaskBean maintask;
        private String url;
        private ArrayList<ZjfileListBean> zjfileList;
        private ArrayList<ListSubTaskimgBean> listSubTaskimg;
        private ArrayList<FafileListBean> fafileList;
        private ArrayList<JjfileListBean> jjfileList;
        private ArrayList<ZgfileListBean> zgfileList;
        private ArrayList<YsfileListBean> ysfileList;


        public int getCurrUserIdcard() {
            return currUserIdcard;
        }

        public void setCurrUserIdcard(int currUserIdcard) {
            this.currUserIdcard = currUserIdcard;
        }

        private int currUserIdcard;

        public String getCollaborativeUnitsSwitch() {
            return collaborativeUnitsSwitch;
        }

        public void setCollaborativeUnitsSwitch(String collaborativeUnitsSwitch) {
            this.collaborativeUnitsSwitch = collaborativeUnitsSwitch;
        }

        private String collaborativeUnitsSwitch;

        public SubTaskListBean getSubTaskList() {
            return subTaskList;
        }

        public void setSubTaskList(SubTaskListBean subTaskList) {
            this.subTaskList = subTaskList;
        }

        public SysTaskBean getSysTask() {
            return sysTask;
        }

        public void setSysTask(SysTaskBean sysTask) {
            this.sysTask = sysTask;
        }

        public MaintaskBean getMaintask() {
            return maintask;
        }

        public void setMaintask(MaintaskBean maintask) {
            this.maintask = maintask;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public ArrayList<ZjfileListBean> getZjfileList() {
            return zjfileList;
        }

        public void setZjfileList(ArrayList<ZjfileListBean> zjfileList) {
            this.zjfileList = zjfileList;
        }

        public ArrayList<ListSubTaskimgBean> getListSubTaskimg() {
            return listSubTaskimg;
        }

        public void setListSubTaskimg(ArrayList<ListSubTaskimgBean> listSubTaskimg) {
            this.listSubTaskimg = listSubTaskimg;
        }

        public ArrayList<FafileListBean> getFafileList() {
            return fafileList;
        }

        public void setFafileList(ArrayList<FafileListBean> fafileList) {
            this.fafileList = fafileList;
        }

        public ArrayList<JjfileListBean> getJjfileList() {
            return jjfileList;
        }

        public void setJjfileList(ArrayList<JjfileListBean> jjfileList) {
            this.jjfileList = jjfileList;
        }

        public ArrayList<ZgfileListBean> getZgfileList() {
            return zgfileList;
        }

        public void setZgfileList(ArrayList<ZgfileListBean> zgfileList) {
            this.zgfileList = zgfileList;
        }

        public ArrayList<YsfileListBean> getYsfileList() {
            return ysfileList;
        }

        public void setYsfileList(ArrayList<YsfileListBean> ysfileList) {
            this.ysfileList = ysfileList;
        }

        public static class SubTaskListBean implements Serializable {
            /**
             * taskId : 4619
             * mainId : 4618
             * number : 111
             * sourceProcessorId : 95
             * sourceProcessorName : 孔德昊
             * technicianName : 孔德昊
             * sourceId : 2
             * sourceCategory : 1
             * sourceDescription : 掘进工作面顶、帮状况差或顶板破碎、两帮片帮严重
             * sourceMoney : 0
             * sourceScore : 0
             * troubleContent : 鹅蛋
             * processType : 1
             * processorId : 95
             * processorName : 孔德昊
             * processorDepartmentId : 1986
             * processTime : 1547049600000
             * troubleLevel : 一般
             * responsibleMoney : 0
             * responsibleScore : 0
             * responsibleDepartmentId : 1873
             * responsibleDepartmentName : 综采队
             * responsibleUserId : 1435,1502,982,308,96,814,95
             * responsibleUserName : 孔德昊,贾钢,宋伟,姚立波,刘文平,叶孝会,杨超
             * responsibleLeaderId : 95
             * responsibleLeaderName : 孔德昊
             * responsibleRemark : sdfs
             * solutionGoal : 发啊姐姐
             * solutionTimeLimit : 1547372228000
             * solutionType : 0
             * solutionContent : sdf
             * solutionFunding : 2312
             * solutionPlan : wer
             * troublePlanId : 0
             * solutionChiefId : 2
             * solutionChiefName : 孔德昊
             * solutionChiefRemark : s
             * technicianId : 95
             * acceptorId : 1868
             * acceptorName : 生产科
             * approverName : 孔德昊
             * troublePlanName : 孔德昊
             * acceptReason : wsfwsf
             * approverId : 95
             * approveRemark : sfsfs
             * correctNoticeNo : 201901100035
             * delayTime : 1548325648000
             * delayReason : derhj
             * fatalReason : fghfhfgh
             * fatalApproverId : 95
             * fatalApproverRemark : sdfsv
             * fatal : false
             * startTime : 1547116100000
             * endTime : 1547116103000
             * redoReason : ssdsdfsdf
             * closeReason : dfsdfsfdsdf
             * deleteReason : sdfsdfsfds
             * flags : MQ==
             * technicianRemark : 孔德昊
             * troubleSubtaskDocList : [{"subtaskId":4619,"docId":4616,"docUsage":0,"number":"111"},{"subtaskId":4619,"docId":4616,"docUsage":1,"number":"111"},{"subtaskId":4619,"docId":4616,"docUsage":2,"number":"111"},{"subtaskId":4619,"docId":4616,"docUsage":3,"number":"111"},{"subtaskId":4619,"docId":4616,"docUsage":4,"number":"111"},{"subtaskId":4619,"docId":4616,"docUsage":5,"number":"111"}]
             * state : 5
             * deletes : 111
             * rectifyDay : 3
             * acceptanceDismiss : 1
             * fatalApproverName : 孔德昊
             * taskType : 9
             */

            private int taskId;
            private int mainId;
            private int number;
            private int sourceProcessorId;
            private String sourceProcessorName;
            private String technicianName;
            private int sourceId;
            private String sourceCategory;
            private String sourceDescription;
            private int sourceMoney;
            private int sourceScore;
            private String troubleContent;
            private int processType;
            private String processorId;
            private String processorName;
            private int processorDepartmentId;
            private long processTime;
            private String troubleLevel;
            private int responsibleMoney;
            private int responsibleScore;
            private int responsibleDepartmentId;
            private String responsibleDepartmentName;
            private String responsibleUserId;
            private String responsibleUserName;
            private int responsibleLeaderId;
            private String responsibleLeaderName;
            private String responsibleRemark;
            private String solutionGoal;
            private long solutionTimeLimit;
            private int solutionType;
            private String solutionContent;
            private String solutionFunding;
            private String solutionPlan;
            private int troublePlanId;
            private int solutionChiefId;
            private String solutionChiefName;
            private String solutionChiefRemark;
            private int technicianId;
            private String acceptorId;
            private String acceptorName;
            private String approverName;
            private String troublePlanName;
            private String acceptReason;
            private int approverId;
            private String approveRemark;
            private String correctNoticeNo;
            private long delayTime;
            private String delayReason;
            private String fatalReason;
            private int fatalApproverId;
            private String fatalApproverRemark;
            private boolean fatal;
            private long startTime;
            private long endTime;
            private String redoReason;
            private String closeReason;
            private String deleteReason;
            private String flags;
            private String technicianRemark;
            private String state;
            private String deletes;
            private int rectifyDay;
            private String acceptanceDismiss;
            private String fatalApproverName;
            private String taskType;
            private ArrayList<TroubleSubtaskDocListBean> troubleSubtaskDocList;
            private String solutionResponsibleUserName;
            private int solutionResponsibleUserId;
            private String solutionAcceptorName;
            private int solutionAcceptorId;

            private String acceptanceDepartmentsName;
            private String acceptanceDepartmentsId;
            private String acceptanceUserFlag;
            private String acceptanceRuleOut;

            private int stdchkProjectId;
            private int stdchkItemId;
            private String checkProfessional;

            public int getStdchkProjectId() {
                return stdchkProjectId;
            }

            public void setStdchkProjectId(int stdchkProjectId) {
                this.stdchkProjectId = stdchkProjectId;
            }

            public int getStdchkItemId() {
                return stdchkItemId;
            }

            public void setStdchkItemId(int stdchkItemId) {
                this.stdchkItemId = stdchkItemId;
            }

            public String getCheckProfessional() {
                return checkProfessional;
            }

            public void setCheckProfessional(String checkProfessional) {
                this.checkProfessional = checkProfessional;
            }

            public String getResponsiblePersonLeadership() {
                return responsiblePersonLeadership;
            }

            public void setResponsiblePersonLeadership(String responsiblePersonLeadership) {
                this.responsiblePersonLeadership = responsiblePersonLeadership;
            }

            public int getResponsiblePersonLeadershipId() {
                return responsiblePersonLeadershipId;
            }

            public void setResponsiblePersonLeadershipId(int responsiblePersonLeadershipId) {
                this.responsiblePersonLeadershipId = responsiblePersonLeadershipId;
            }

            public int getHazardDivisions() {
                return hazardDivisions;
            }

            public void setHazardDivisions(int hazardDivisions) {
                this.hazardDivisions = hazardDivisions;
            }

            private String responsiblePersonLeadership;
            private int responsiblePersonLeadershipId;
            private int hazardDivisions;

            private int troubleLevelId;   //隐患等级

            public int getTroubleLevelId() {
                return troubleLevelId;
            }

            public void setTroubleLevelId(int troubleLevelId) {
                this.troubleLevelId = troubleLevelId;
            }

            public int getNowTroubleLevelId() {
                return nowTroubleLevelId;
            }

            public void setNowTroubleLevelId(int nowTroubleLevelId) {
                this.nowTroubleLevelId = nowTroubleLevelId;
            }

            private int nowTroubleLevelId; //隐患当前等级


            public String getAcceptanceDepartmentsName() {
                return acceptanceDepartmentsName;
            }

            public void setAcceptanceDepartmentsName(String acceptanceDepartmentsName) {
                this.acceptanceDepartmentsName = acceptanceDepartmentsName;
            }

            public String getAcceptanceDepartmentsId() {
                return acceptanceDepartmentsId;
            }

            public void setAcceptanceDepartmentsId(String acceptanceDepartmentsId) {
                this.acceptanceDepartmentsId = acceptanceDepartmentsId;
            }

            public String getAcceptanceUserFlag() {
                return acceptanceUserFlag;
            }

            public void setAcceptanceUserFlag(String acceptanceUserFlag) {
                this.acceptanceUserFlag = acceptanceUserFlag;
            }

            public String getAcceptanceRuleOut() {
                return acceptanceRuleOut;
            }

            public void setAcceptanceRuleOut(String acceptanceRuleOut) {
                this.acceptanceRuleOut = acceptanceRuleOut;
            }

            public String getCollaborativeUnits() {
                return collaborativeUnits;
            }

            public void setCollaborativeUnits(String collaborativeUnits) {
                this.collaborativeUnits = collaborativeUnits;
            }

            private String collaborativeUnits;

            public String getCollaborative_units_id() {
                return collaborative_units_id;
            }

            public void setCollaborative_units_id(String collaborative_units_id) {
                this.collaborative_units_id = collaborative_units_id;
            }

            private String collaborative_units_id;

            public String getCollaborative_units_leader() {
                return collaborative_units_leader;
            }

            public void setCollaborative_units_leader(String collaborative_units_leader) {
                this.collaborative_units_leader = collaborative_units_leader;
            }

            private String collaborative_units_leader;

            public String getCollaboeative_units_rectification_flag() {
                return collaboeative_units_rectification_flag;
            }

            public void setCollaboeative_units_rectification_flag(String collaboeative_units_rectification_flag) {
                this.collaboeative_units_rectification_flag = collaboeative_units_rectification_flag;
            }

            private String collaboeative_units_rectification_flag;

            public String getIs_rectification() {
                return is_rectification;
            }

            public void setIs_rectification(String is_rectification) {
                this.is_rectification = is_rectification;
            }

            private String is_rectification;


            public String getSolutionResponsibleUserName() {
                return solutionResponsibleUserName;
            }

            public void setSolutionResponsibleUserName(String solutionResponsibleUserName) {
                this.solutionResponsibleUserName = solutionResponsibleUserName;
            }


            public int getSolutionResponsibleUserId() {
                return solutionResponsibleUserId;
            }

            public void setSolutionResponsibleUserId(int solutionResponsibleUserId) {
                this.solutionResponsibleUserId = solutionResponsibleUserId;
            }


            public String getSolutionAcceptorName() {
                return solutionAcceptorName;
            }

            public void setSolutionAcceptorName(String solutionAcceptorName) {
                this.solutionAcceptorName = solutionAcceptorName;
            }


            public int getSolutionAcceptorId() {
                return solutionAcceptorId;
            }

            public void setSolutionAcceptorId(int solutionAcceptorId) {
                this.solutionAcceptorId = solutionAcceptorId;
            }


            public int getTaskId() {
                return taskId;
            }

            public void setTaskId(int taskId) {
                this.taskId = taskId;
            }

            public int getMainId() {
                return mainId;
            }

            public void setMainId(int mainId) {
                this.mainId = mainId;
            }

            public int getNumber() {
                return number;
            }

            public void setNumber(int number) {
                this.number = number;
            }

            public int getSourceProcessorId() {
                return sourceProcessorId;
            }

            public void setSourceProcessorId(int sourceProcessorId) {
                this.sourceProcessorId = sourceProcessorId;
            }

            public String getSourceProcessorName() {
                return sourceProcessorName;
            }

            public void setSourceProcessorName(String sourceProcessorName) {
                this.sourceProcessorName = sourceProcessorName;
            }

            public String getTechnicianName() {
                return technicianName;
            }

            public void setTechnicianName(String technicianName) {
                this.technicianName = technicianName;
            }

            public int getSourceId() {
                return sourceId;
            }

            public void setSourceId(int sourceId) {
                this.sourceId = sourceId;
            }

            public String getSourceCategory() {
                return sourceCategory;
            }

            public void setSourceCategory(String sourceCategory) {
                this.sourceCategory = sourceCategory;
            }

            public String getSourceDescription() {
                return sourceDescription;
            }

            public void setSourceDescription(String sourceDescription) {
                this.sourceDescription = sourceDescription;
            }

            public int getSourceMoney() {
                return sourceMoney;
            }

            public void setSourceMoney(int sourceMoney) {
                this.sourceMoney = sourceMoney;
            }

            public int getSourceScore() {
                return sourceScore;
            }

            public void setSourceScore(int sourceScore) {
                this.sourceScore = sourceScore;
            }

            public String getTroubleContent() {
                return troubleContent;
            }

            public void setTroubleContent(String troubleContent) {
                this.troubleContent = troubleContent;
            }

            public int getProcessType() {
                return processType;
            }

            public void setProcessType(int processType) {
                this.processType = processType;
            }

            public String getProcessorId() {
                return processorId;
            }

            public void setProcessorId(String processorId) {
                this.processorId = processorId;
            }

            public String getProcessorName() {
                return processorName;
            }

            public void setProcessorName(String processorName) {
                this.processorName = processorName;
            }

            public int getProcessorDepartmentId() {
                return processorDepartmentId;
            }

            public void setProcessorDepartmentId(int processorDepartmentId) {
                this.processorDepartmentId = processorDepartmentId;
            }

            public long getProcessTime() {
                return processTime;
            }

            public void setProcessTime(long processTime) {
                this.processTime = processTime;
            }

            public String getTroubleLevel() {
                return troubleLevel;
            }

            public void setTroubleLevel(String troubleLevel) {
                this.troubleLevel = troubleLevel;
            }

            public int getResponsibleMoney() {
                return responsibleMoney;
            }

            public void setResponsibleMoney(int responsibleMoney) {
                this.responsibleMoney = responsibleMoney;
            }

            public int getResponsibleScore() {
                return responsibleScore;
            }

            public void setResponsibleScore(int responsibleScore) {
                this.responsibleScore = responsibleScore;
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

            public String getResponsibleUserId() {
                return responsibleUserId;
            }

            public void setResponsibleUserId(String responsibleUserId) {
                this.responsibleUserId = responsibleUserId;
            }

            public String getResponsibleUserName() {
                return responsibleUserName;
            }

            public void setResponsibleUserName(String responsibleUserName) {
                this.responsibleUserName = responsibleUserName;
            }

            public int getResponsibleLeaderId() {
                return responsibleLeaderId;
            }

            public void setResponsibleLeaderId(int responsibleLeaderId) {
                this.responsibleLeaderId = responsibleLeaderId;
            }

            public String getResponsibleLeaderName() {
                return responsibleLeaderName;
            }

            public void setResponsibleLeaderName(String responsibleLeaderName) {
                this.responsibleLeaderName = responsibleLeaderName;
            }

            public String getResponsibleRemark() {
                return responsibleRemark;
            }

            public void setResponsibleRemark(String responsibleRemark) {
                this.responsibleRemark = responsibleRemark;
            }

            public String getSolutionGoal() {
                return solutionGoal;
            }

            public void setSolutionGoal(String solutionGoal) {
                this.solutionGoal = solutionGoal;
            }

            public long getSolutionTimeLimit() {
                return solutionTimeLimit;
            }

            public void setSolutionTimeLimit(long solutionTimeLimit) {
                this.solutionTimeLimit = solutionTimeLimit;
            }

            public int getSolutionType() {
                return solutionType;
            }

            public void setSolutionType(int solutionType) {
                this.solutionType = solutionType;
            }

            public String getSolutionContent() {
                return solutionContent;
            }

            public void setSolutionContent(String solutionContent) {
                this.solutionContent = solutionContent;
            }

            public String getSolutionFunding() {
                return solutionFunding;
            }

            public void setSolutionFunding(String solutionFunding) {
                this.solutionFunding = solutionFunding;
            }

            public String getSolutionPlan() {
                return solutionPlan;
            }

            public void setSolutionPlan(String solutionPlan) {
                this.solutionPlan = solutionPlan;
            }

            public int getTroublePlanId() {
                return troublePlanId;
            }

            public void setTroublePlanId(int troublePlanId) {
                this.troublePlanId = troublePlanId;
            }

            public int getSolutionChiefId() {
                return solutionChiefId;
            }

            public void setSolutionChiefId(int solutionChiefId) {
                this.solutionChiefId = solutionChiefId;
            }

            public String getSolutionChiefName() {
                return solutionChiefName;
            }

            public void setSolutionChiefName(String solutionChiefName) {
                this.solutionChiefName = solutionChiefName;
            }

            public String getSolutionChiefRemark() {
                return solutionChiefRemark;
            }

            public void setSolutionChiefRemark(String solutionChiefRemark) {
                this.solutionChiefRemark = solutionChiefRemark;
            }

            public int getTechnicianId() {
                return technicianId;
            }

            public void setTechnicianId(int technicianId) {
                this.technicianId = technicianId;
            }

            public String getAcceptorId() {
                return acceptorId;
            }

            public void setAcceptorId(String acceptorId) {
                this.acceptorId = acceptorId;
            }

            public String getAcceptorName() {
                return acceptorName;
            }

            public void setAcceptorName(String acceptorName) {
                this.acceptorName = acceptorName;
            }

            public String getApproverName() {
                return approverName;
            }

            public void setApproverName(String approverName) {
                this.approverName = approverName;
            }

            public String getTroublePlanName() {
                return troublePlanName;
            }

            public void setTroublePlanName(String troublePlanName) {
                this.troublePlanName = troublePlanName;
            }

            public String getAcceptReason() {
                return acceptReason;
            }

            public void setAcceptReason(String acceptReason) {
                this.acceptReason = acceptReason;
            }

            public int getApproverId() {
                return approverId;
            }

            public void setApproverId(int approverId) {
                this.approverId = approverId;
            }

            public String getApproveRemark() {
                return approveRemark;
            }

            public void setApproveRemark(String approveRemark) {
                this.approveRemark = approveRemark;
            }

            public String getCorrectNoticeNo() {
                return correctNoticeNo;
            }

            public void setCorrectNoticeNo(String correctNoticeNo) {
                this.correctNoticeNo = correctNoticeNo;
            }

            public long getDelayTime() {
                return delayTime;
            }

            public void setDelayTime(long delayTime) {
                this.delayTime = delayTime;
            }

            public String getDelayReason() {
                return delayReason;
            }

            public void setDelayReason(String delayReason) {
                this.delayReason = delayReason;
            }

            public String getFatalReason() {
                return fatalReason;
            }

            public void setFatalReason(String fatalReason) {
                this.fatalReason = fatalReason;
            }

            public int getFatalApproverId() {
                return fatalApproverId;
            }

            public void setFatalApproverId(int fatalApproverId) {
                this.fatalApproverId = fatalApproverId;
            }

            public String getFatalApproverRemark() {
                return fatalApproverRemark;
            }

            public void setFatalApproverRemark(String fatalApproverRemark) {
                this.fatalApproverRemark = fatalApproverRemark;
            }

            public boolean isFatal() {
                return fatal;
            }

            public void setFatal(boolean fatal) {
                this.fatal = fatal;
            }

            public long getStartTime() {
                return startTime;
            }

            public void setStartTime(long startTime) {
                this.startTime = startTime;
            }

            public long getEndTime() {
                return endTime;
            }

            public void setEndTime(long endTime) {
                this.endTime = endTime;
            }

            public String getRedoReason() {
                return redoReason;
            }

            public void setRedoReason(String redoReason) {
                this.redoReason = redoReason;
            }

            public String getCloseReason() {
                return closeReason;
            }

            public void setCloseReason(String closeReason) {
                this.closeReason = closeReason;
            }

            public String getDeleteReason() {
                return deleteReason;
            }

            public void setDeleteReason(String deleteReason) {
                this.deleteReason = deleteReason;
            }

            public String getFlags() {
                return flags;
            }

            public void setFlags(String flags) {
                this.flags = flags;
            }

            public String getTechnicianRemark() {
                return technicianRemark;
            }

            public void setTechnicianRemark(String technicianRemark) {
                this.technicianRemark = technicianRemark;
            }

            public String getState() {
                return state;
            }

            public void setState(String state) {
                this.state = state;
            }

            public String getDeletes() {
                return deletes;
            }

            public void setDeletes(String deletes) {
                this.deletes = deletes;
            }

            public int getRectifyDay() {
                return rectifyDay;
            }

            public void setRectifyDay(int rectifyDay) {
                this.rectifyDay = rectifyDay;
            }

            public String getAcceptanceDismiss() {
                return acceptanceDismiss;
            }

            public void setAcceptanceDismiss(String acceptanceDismiss) {
                this.acceptanceDismiss = acceptanceDismiss;
            }

            public String getFatalApproverName() {
                return fatalApproverName;
            }

            public void setFatalApproverName(String fatalApproverName) {
                this.fatalApproverName = fatalApproverName;
            }

            public String getTaskType() {
                return taskType;
            }

            public void setTaskType(String taskType) {
                this.taskType = taskType;
            }

            public ArrayList<TroubleSubtaskDocListBean> getTroubleSubtaskDocList() {
                return troubleSubtaskDocList;
            }

            public void setTroubleSubtaskDocList(ArrayList<TroubleSubtaskDocListBean> troubleSubtaskDocList) {
                this.troubleSubtaskDocList = troubleSubtaskDocList;
            }

            public static class TroubleSubtaskDocListBean implements Serializable {
                /**
                 * subtaskId : 4619
                 * docId : 4616
                 * docUsage : 0
                 * number : 111
                 */

                private int subtaskId;
                private int docId;
                private int docUsage;
                private String number;

                public int getSubtaskId() {
                    return subtaskId;
                }

                public void setSubtaskId(int subtaskId) {
                    this.subtaskId = subtaskId;
                }

                public int getDocId() {
                    return docId;
                }

                public void setDocId(int docId) {
                    this.docId = docId;
                }

                public int getDocUsage() {
                    return docUsage;
                }

                public void setDocUsage(int docUsage) {
                    this.docUsage = docUsage;
                }

                public String getNumber() {
                    return number;
                }

                public void setNumber(String number) {
                    this.number = number;
                }
            }
        }

        public static class SysTaskBean implements Serializable {
            /**
             * id : 4619
             * title : 1.顶板无离层、无活矸、无鳞片，支护完好，空顶、空帮距符合作业规程规定。2.巷帮无裂缝。
             * tasktype : 9
             * description : 掘进工作面顶、帮状况差或顶板破碎、两帮片帮严重
             * createtime : 1547113008000
             * creatorId : 95
             * state : 5
             * modifytime : 1547113028000
             * priority : 0
             * deleted : 0
             * starttime : 1547113008000
             * endtime : 1547113008000
             * auth : 95
             * delaytime : 1547113008000
             * creatorName : 孔德昊
             * mainTaskId : 4619
             */

            private int id;
            private String title;
            private String tasktype;
            private String description;
            private long createtime;
            private int creatorId;
            private String state;
            private long modifytime;
            private int priority;
            private int deleted;
            private long starttime;
            private long endtime;
            private String auth;
            private long delaytime;
            private String creatorName;
            private int mainTaskId;

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

            public int getPriority() {
                return priority;
            }

            public void setPriority(int priority) {
                this.priority = priority;
            }

            public int getDeleted() {
                return deleted;
            }

            public void setDeleted(int deleted) {
                this.deleted = deleted;
            }

            public long getStarttime() {
                return starttime;
            }

            public void setStarttime(long starttime) {
                this.starttime = starttime;
            }

            public long getEndtime() {
                return endtime;
            }

            public void setEndtime(long endtime) {
                this.endtime = endtime;
            }

            public String getAuth() {
                return auth;
            }

            public void setAuth(String auth) {
                this.auth = auth;
            }

            public long getDelaytime() {
                return delaytime;
            }

            public void setDelaytime(long delaytime) {
                this.delaytime = delaytime;
            }

            public String getCreatorName() {
                return creatorName;
            }

            public void setCreatorName(String creatorName) {
                this.creatorName = creatorName;
            }

            public int getMainTaskId() {
                return mainTaskId;
            }

            public void setMainTaskId(int mainTaskId) {
                this.mainTaskId = mainTaskId;
            }
        }

        public static class MaintaskBean implements Serializable {
            /**
             * taskId : 4618
             * location : 2313的完成的身份 高原红
             * clauseId : 12
             * clauseCategory : 4
             * clauseDescription : 1.顶板无离层、无活矸、无鳞片，支护完好，空顶、空帮距符合作业规程规定。2.巷帮无裂缝。
             * userId : 95
             * userName : 孔德昊
             * createTime : 1547113008000
             * state : 2
             * areaId : 0
             * areaName : sdf
             */

            private int taskId;
            private String location;
            private int clauseId;
            private int clauseCategory;
            private String clauseDescription;
            private int userId;
            private String userName;
            private long createTime;
            private String state;
            private int areaId;
            private String areaName;
            private String clauseConsequence;

            public String getClauseConsequence() {
                return clauseConsequence;
            }

            public void setClauseConsequence(String clauseConsequence) {
                this.clauseConsequence = clauseConsequence;
            }

            public String getClauseMeasures() {
                return clauseMeasures;
            }

            public void setClauseMeasures(String clauseMeasures) {
                this.clauseMeasures = clauseMeasures;
            }

            private String clauseMeasures;

            public int getTaskId() {
                return taskId;
            }

            public void setTaskId(int taskId) {
                this.taskId = taskId;
            }

            public String getLocation() {
                return location;
            }

            public void setLocation(String location) {
                this.location = location;
            }

            public int getClauseId() {
                return clauseId;
            }

            public void setClauseId(int clauseId) {
                this.clauseId = clauseId;
            }

            public int getClauseCategory() {
                return clauseCategory;
            }

            public void setClauseCategory(int clauseCategory) {
                this.clauseCategory = clauseCategory;
            }

            public String getClauseDescription() {
                return clauseDescription;
            }

            public void setClauseDescription(String clauseDescription) {
                this.clauseDescription = clauseDescription;
            }

            public int getUserId() {
                return userId;
            }

            public void setUserId(int userId) {
                this.userId = userId;
            }

            public String getUserName() {
                return userName;
            }

            public void setUserName(String userName) {
                this.userName = userName;
            }

            public long getCreateTime() {
                return createTime;
            }

            public void setCreateTime(long createTime) {
                this.createTime = createTime;
            }

            public String getState() {
                return state;
            }

            public void setState(String state) {
                this.state = state;
            }

            public int getAreaId() {
                return areaId;
            }

            public void setAreaId(int areaId) {
                this.areaId = areaId;
            }

            public String getAreaName() {
                return areaName;
            }

            public void setAreaName(String areaName) {
                this.areaName = areaName;
            }
        }

        public static class ZjfileListBean implements Serializable {
            /**
             * subtaskId : 111
             * docId : 111
             * docUsage : 111
             * number : 111
             * url : /upload/1547112917793.jpg
             * fileId : 4616
             * swfUrl : /upload/1547112917793.jpg
             * fileName : 1547112917793.jpg
             */

            private String subtaskId;
            private String docId;
            private String docUsage;
            private String number;
            private String url;
            private int fileId;
            private String swfUrl;
            private String fileName;

            public String getSubtaskId() {
                return subtaskId;
            }

            public void setSubtaskId(String subtaskId) {
                this.subtaskId = subtaskId;
            }

            public String getDocId() {
                return docId;
            }

            public void setDocId(String docId) {
                this.docId = docId;
            }

            public String getDocUsage() {
                return docUsage;
            }

            public void setDocUsage(String docUsage) {
                this.docUsage = docUsage;
            }

            public String getNumber() {
                return number;
            }

            public void setNumber(String number) {
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
        }

        public static class ListSubTaskimgBean implements Serializable {
            /**
             * subtaskId : 4619
             * docId : 4166
             * docUsage : 1
             * number : 6
             * url : /upload/1547112917793.jpg
             * fileId : 4616
             * swfUrl : /upload/1547112917793.jpg
             * fileName : 1547112917793.jpg
             */

            private int subtaskId;
            private int docId;
            private int docUsage;
            private int number;
            private String url;
            private int fileId;
            private String swfUrl;
            private String fileName;

            public int getSubtaskId() {
                return subtaskId;
            }

            public void setSubtaskId(int subtaskId) {
                this.subtaskId = subtaskId;
            }

            public int getDocId() {
                return docId;
            }

            public void setDocId(int docId) {
                this.docId = docId;
            }

            public int getDocUsage() {
                return docUsage;
            }

            public void setDocUsage(int docUsage) {
                this.docUsage = docUsage;
            }

            public int getNumber() {
                return number;
            }

            public void setNumber(int number) {
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
        }

        public static class FafileListBean implements Serializable {
            /**
             * subtaskId : 54
             * docId : 4611
             * docUsage : 4
             * number : 3
             * url : /upload/1547112917793.jpg
             * fileId : 4616
             * swfUrl : /upload/1547112917793.jpg
             * fileName : 1547112917793.jpg
             */

            private int subtaskId;
            private int docId;
            private int docUsage;
            private int number;
            private String url;
            private int fileId;
            private String swfUrl;
            private String fileName;

            public int getSubtaskId() {
                return subtaskId;
            }

            public void setSubtaskId(int subtaskId) {
                this.subtaskId = subtaskId;
            }

            public int getDocId() {
                return docId;
            }

            public void setDocId(int docId) {
                this.docId = docId;
            }

            public int getDocUsage() {
                return docUsage;
            }

            public void setDocUsage(int docUsage) {
                this.docUsage = docUsage;
            }

            public int getNumber() {
                return number;
            }

            public void setNumber(int number) {
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
        }

        public static class JjfileListBean implements Serializable {
            /**
             * subtaskId : 4619
             * docId : 46166
             * docUsage : 5
             * number : 9
             * url : /upload/1547112917793.jpg
             * fileId : 4616
             * swfUrl : /upload/1547112917793.jpg
             * fileName : 1547112917793.jpg
             */

            private int subtaskId;
            private int docId;
            private int docUsage;
            private int number;
            private String url;
            private int fileId;
            private String swfUrl;
            private String fileName;

            public int getSubtaskId() {
                return subtaskId;
            }

            public void setSubtaskId(int subtaskId) {
                this.subtaskId = subtaskId;
            }

            public int getDocId() {
                return docId;
            }

            public void setDocId(int docId) {
                this.docId = docId;
            }

            public int getDocUsage() {
                return docUsage;
            }

            public void setDocUsage(int docUsage) {
                this.docUsage = docUsage;
            }

            public int getNumber() {
                return number;
            }

            public void setNumber(int number) {
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
        }

        public static class ZgfileListBean implements Serializable {
            /**
             * subtaskId : 4619
             * docId : 4166
             * docUsage : 6
             * number : 9
             * url : /upload/1547112917793.jpg
             * fileId : 4616
             * swfUrl : /upload/1547112917793.jpg
             * fileName : 1547112917793.jpg
             */

            private int subtaskId;
            private int docId;
            private int docUsage;
            private int number;
            private String url;
            private int fileId;
            private String swfUrl;
            private String fileName;

            public int getSubtaskId() {
                return subtaskId;
            }

            public void setSubtaskId(int subtaskId) {
                this.subtaskId = subtaskId;
            }

            public int getDocId() {
                return docId;
            }

            public void setDocId(int docId) {
                this.docId = docId;
            }

            public int getDocUsage() {
                return docUsage;
            }

            public void setDocUsage(int docUsage) {
                this.docUsage = docUsage;
            }

            public int getNumber() {
                return number;
            }

            public void setNumber(int number) {
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
        }

        public static class YsfileListBean implements Serializable {
            /**
             * subtaskId : 4619
             * docId : 6
             * docUsage : 9
             * number : 8
             * url : /upload/1547112917793.jpg
             * fileId : 4616
             * swfUrl : /upload/1547112917793.jpg
             * fileName : 1547112917793.jpg
             */

            private int subtaskId;
            private int docId;
            private int docUsage;
            private int number;
            private String url;
            private int fileId;
            private String swfUrl;
            private String fileName;

            public int getSubtaskId() {
                return subtaskId;
            }

            public void setSubtaskId(int subtaskId) {
                this.subtaskId = subtaskId;
            }

            public int getDocId() {
                return docId;
            }

            public void setDocId(int docId) {
                this.docId = docId;
            }

            public int getDocUsage() {
                return docUsage;
            }

            public void setDocUsage(int docUsage) {
                this.docUsage = docUsage;
            }

            public int getNumber() {
                return number;
            }

            public void setNumber(int number) {
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
        }
    }
}
