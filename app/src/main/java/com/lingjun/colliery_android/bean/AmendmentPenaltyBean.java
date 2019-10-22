package com.lingjun.colliery_android.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者: zengtao
 * 时间: 2019/5/23  13:46.
 * 注释:
 */
public class AmendmentPenaltyBean {
    /**
     * msg : 成功
     * data : {"list":[{"slight":0,"number":1,"flags":0,"id":1,"remark":"轻微风险","name":"轻微","deleted":"0","enabled":"1"},{"slight":0,"number":2,"flags":0,"id":2,"remark":"","name":"一般","deleted":"0","enabled":"1"},{"slight":0,"number":3,"flags":0,"id":3,"remark":"","name":"重大","deleted":"0","enabled":"1"}],"taskclauselist":[{"number":1,"testScore":60,"penaltyLeaderMoney":0,"flags":0,"testState":0,"clauseDescription":"在炸药箱未上锁","clauseCategory":"1","penaltyScore":0,"testCount":0,"chapters":"&amp;middot;1","systask":{"state":"0","isRectification":0,"id":14202},"keys":"1","id":14202,"clauseId":1,"name":"帮教,停工","levelId":1,"levelName":"轻微","penaltyMoney":0,"taskId":14201},{"number":2,"testScore":60,"penaltyLeaderMoney":0,"flags":0,"testState":0,"clauseDescription":"放炮私自摘风筒","clauseCategory":"1","penaltyScore":0,"testCount":0,"systask":{"state":"0","isRectification":0,"id":14203},"id":14203,"clauseId":2,"name":"帮教,停工,参加培训帮","levelId":1,"levelName":"轻微","penaltyMoney":0,"taskId":14201},{"number":3,"testScore":60,"penaltyLeaderMoney":0,"flags":0,"testState":0,"clauseDescription":"井下睡觉","clauseCategory":"1","penaltyScore":0,"testCount":0,"systask":{"state":"0","isRectification":0,"id":14204},"id":14204,"clauseId":3,"name":"帮教,停工,参加培训帮","levelId":1,"levelName":"轻微","penaltyMoney":0,"taskId":14201},{"number":4,"testScore":60,"penaltyLeaderMoney":0,"flags":0,"testState":0,"clauseDescription":"隐患未按期整改","clauseCategory":"1","penaltyScore":0,"testCount":0,"systask":{"state":"0","isRectification":0,"id":14205},"id":14205,"clauseId":4,"name":"帮教,停工,参加培训帮","levelId":1,"levelName":"轻微","penaltyMoney":0,"taskId":14201},{"number":5,"testScore":60,"penaltyLeaderMoney":0,"flags":0,"testState":0,"clauseDescription":"用铁丝代替风管接头卡子","clauseCategory":"1","penaltyScore":0,"testCount":0,"systask":{"state":"0","isRectification":0,"id":14206},"id":14206,"clauseId":5,"name":"帮教,停工,参加培训帮","levelId":1,"levelName":"轻微","penaltyMoney":0,"taskId":14201},{"number":6,"testScore":60,"penaltyLeaderMoney":0,"flags":0,"testState":0,"clauseDescription":"未发出开机信号，随意点动皮带","clauseCategory":"1","penaltyScore":0,"testCount":0,"systask":{"state":"0","isRectification":0,"id":14207},"id":14207,"clauseId":6,"name":"帮教,停工,参加培训帮","levelId":1,"levelName":"轻微","penaltyMoney":0,"taskId":14201}]}
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
        private ArrayList<ListBean> list;
        private ArrayList<TaskclauselistBean> taskclauselist;

        public ArrayList<ListBean> getList() {
            return list;
        }

        public void setList(ArrayList<ListBean> list) {
            this.list = list;
        }

        public ArrayList<TaskclauselistBean> getTaskclauselist() {
            return taskclauselist;
        }

        public void setTaskclauselist(ArrayList<TaskclauselistBean> taskclauselist) {
            this.taskclauselist = taskclauselist;
        }

        public static class ListBean {
            /**
             * slight : 0
             * number : 1
             * flags : 0
             * id : 1
             * remark : 轻微风险
             * name : 轻微
             * deleted : 0
             * enabled : 1
             */

            private int slight;
            private int number;
            private int flags;
            private int id;
            private String remark;
            private String name;
            private String deleted;
            private String enabled;

            public int getSlight() {
                return slight;
            }

            public void setSlight(int slight) {
                this.slight = slight;
            }

            public int getNumber() {
                return number;
            }

            public void setNumber(int number) {
                this.number = number;
            }

            public int getFlags() {
                return flags;
            }

            public void setFlags(int flags) {
                this.flags = flags;
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

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getDeleted() {
                return deleted;
            }

            public void setDeleted(String deleted) {
                this.deleted = deleted;
            }

            public String getEnabled() {
                return enabled;
            }

            public void setEnabled(String enabled) {
                this.enabled = enabled;
            }
        }

        public static class TaskclauselistBean {
            /**
             * number : 1
             * testScore : 60
             * penaltyLeaderMoney : 0
             * flags : 0
             * testState : 0
             * clauseDescription : 在炸药箱未上锁
             * clauseCategory : 1
             * penaltyScore : 0
             * testCount : 0
             * chapters : &amp;middot;1
             * systask : {"state":"0","isRectification":0,"id":14202}
             * keys : 1
             * id : 14202
             * clauseId : 1
             * name : 帮教,停工
             * levelId : 1
             * levelName : 轻微
             * penaltyMoney : 0
             * taskId : 14201
             */

            private int number;
            private int testScore;
            private int penaltyLeaderMoney;
            private int flags;
            private int testState;
            private String clauseDescription;
            private String clauseCategory;
            private int penaltyScore;
            private int testCount;
            private String chapters;
            private SystaskBean systask;
            private String keys;
            private int id;
            private int clauseId;
            private String name;
            private int levelId;
            private String levelName;
            private int penaltyMoney;
            private int taskId;

            public int getNumber() {
                return number;
            }

            public void setNumber(int number) {
                this.number = number;
            }

            public int getTestScore() {
                return testScore;
            }

            public void setTestScore(int testScore) {
                this.testScore = testScore;
            }

            public int getPenaltyLeaderMoney() {
                return penaltyLeaderMoney;
            }

            public void setPenaltyLeaderMoney(int penaltyLeaderMoney) {
                this.penaltyLeaderMoney = penaltyLeaderMoney;
            }

            public int getFlags() {
                return flags;
            }

            public void setFlags(int flags) {
                this.flags = flags;
            }

            public int getTestState() {
                return testState;
            }

            public void setTestState(int testState) {
                this.testState = testState;
            }

            public String getClauseDescription() {
                return clauseDescription;
            }

            public void setClauseDescription(String clauseDescription) {
                this.clauseDescription = clauseDescription;
            }

            public String getClauseCategory() {
                return clauseCategory;
            }

            public void setClauseCategory(String clauseCategory) {
                this.clauseCategory = clauseCategory;
            }

            public int getPenaltyScore() {
                return penaltyScore;
            }

            public void setPenaltyScore(int penaltyScore) {
                this.penaltyScore = penaltyScore;
            }

            public int getTestCount() {
                return testCount;
            }

            public void setTestCount(int testCount) {
                this.testCount = testCount;
            }

            public String getChapters() {
                return chapters;
            }

            public void setChapters(String chapters) {
                this.chapters = chapters;
            }

            public SystaskBean getSystask() {
                return systask;
            }

            public void setSystask(SystaskBean systask) {
                this.systask = systask;
            }

            public String getKeys() {
                return keys;
            }

            public void setKeys(String keys) {
                this.keys = keys;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getClauseId() {
                return clauseId;
            }

            public void setClauseId(int clauseId) {
                this.clauseId = clauseId;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public int getLevelId() {
                return levelId;
            }

            public void setLevelId(int levelId) {
                this.levelId = levelId;
            }

            public String getLevelName() {
                return levelName;
            }

            public void setLevelName(String levelName) {
                this.levelName = levelName;
            }

            public int getPenaltyMoney() {
                return penaltyMoney;
            }

            public void setPenaltyMoney(int penaltyMoney) {
                this.penaltyMoney = penaltyMoney;
            }

            public int getTaskId() {
                return taskId;
            }

            public void setTaskId(int taskId) {
                this.taskId = taskId;
            }

            public static class SystaskBean {
                /**
                 * state : 0
                 * isRectification : 0
                 * id : 14202
                 */

                private String state;
                private int isRectification;
                private int id;

                public String getState() {
                    return state;
                }

                public void setState(String state) {
                    this.state = state;
                }

                public int getIsRectification() {
                    return isRectification;
                }

                public void setIsRectification(int isRectification) {
                    this.isRectification = isRectification;
                }

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }
            }
        }
    }


//    /**
//     * msg : 成功
//     * code : 200
//     * data : {"taskclauselist":[],"list":[{"id":1,"name":"轻微","number":1,"enabled":"1","deleted":"0","slight":0,"flags":0,"remark":"轻微风险"},{"id":2,"name":"一般","number":2,"enabled":"1","deleted":"0","slight":0,"flags":0,"remark":""},{"id":3,"name":"重大","number":3,"enabled":"1","deleted":"0","slight":0,"flags":0,"remark":""}]}
//     * resultMaps : []
//     */
//
//    private String msg;
//    private String code;
//    private DataBean data;
//    private List<?> resultMaps;
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
//    public DataBean getData() {
//        return data;
//    }
//
//    public void setData(DataBean data) {
//        this.data = data;
//    }
//
//    public List<?> getResultMaps() {
//        return resultMaps;
//    }
//
//    public void setResultMaps(List<?> resultMaps) {
//        this.resultMaps = resultMaps;
//    }
//
//    public static class DataBean {
//        private List<?> taskclauselist;
//        private List<ListBean> list;
//
//        public List<?> getTaskclauselist() {
//            return taskclauselist;
//        }
//
//        public void setTaskclauselist(List<?> taskclauselist) {
//            this.taskclauselist = taskclauselist;
//        }
//
//        public List<ListBean> getList() {
//            return list;
//        }
//
//        public void setList(List<ListBean> list) {
//            this.list = list;
//        }
//
//        public static class ListBean {
//            /**
//             * id : 1
//             * name : 轻微
//             * number : 1
//             * enabled : 1
//             * deleted : 0
//             * slight : 0
//             * flags : 0
//             * remark : 轻微风险
//             */
//
//            private int id;
//            private String name;
//            private int number;
//            private String enabled;
//            private String deleted;
//            private int slight;
//            private int flags;
//            private String remark;
//
//            public int getId() {
//                return id;
//            }
//
//            public void setId(int id) {
//                this.id = id;
//            }
//
//            public String getName() {
//                return name;
//            }
//
//            public void setName(String name) {
//                this.name = name;
//            }
//
//            public int getNumber() {
//                return number;
//            }
//
//            public void setNumber(int number) {
//                this.number = number;
//            }
//
//            public String getEnabled() {
//                return enabled;
//            }
//
//            public void setEnabled(String enabled) {
//                this.enabled = enabled;
//            }
//
//            public String getDeleted() {
//                return deleted;
//            }
//
//            public void setDeleted(String deleted) {
//                this.deleted = deleted;
//            }
//
//            public int getSlight() {
//                return slight;
//            }
//
//            public void setSlight(int slight) {
//                this.slight = slight;
//            }
//
//            public int getFlags() {
//                return flags;
//            }
//
//            public void setFlags(int flags) {
//                this.flags = flags;
//            }
//
//            public String getRemark() {
//                return remark;
//            }
//
//            public void setRemark(String remark) {
//                this.remark = remark;
//            }
//        }
//    }
}
