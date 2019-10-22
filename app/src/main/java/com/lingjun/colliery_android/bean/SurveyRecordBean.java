package com.lingjun.colliery_android.bean;

import java.util.List;

/**
 * 作者: zengtao
 * 时间: 2018/12/25  14:13.
 * 注释: 隐患排查
 */
public class SurveyRecordBean {

    /**
     * msg : 成功
     * code : 200
     * data : {"pageCount":25,"count":145,"pageSize":6,"pageNum":1}
     * resultMaps : [{"taskType":"6","create_time":1536754817000,"key_id":2,"stateFlag":"已处理","clause_description":"密闭、风门、风窗墙体周边按规定掏槽，墙体与煤岩接实，四周有不少于0.1m的裙边，周边及围岩不漏风","id":433,"state":"3","mainId":433},{"taskType":"6","create_time":1536755018000,"key_id":3,"stateFlag":"已处理","clause_description":"文明生产 图纸、资料、文件、牌板及工作场所清洁整齐、置物有序","id":438,"state":"3","mainId":438},{"taskType":"6","create_time":1536757075000,"key_id":3,"stateFlag":"已处理","clause_description":"文明生产 图纸、资料、文件、牌板及工作场所清洁整齐、置物有序","id":445,"state":"3","mainId":445},{"taskType":"6","create_time":1536763845000,"key_id":3,"stateFlag":"已处理","clause_description":"文明生产 图纸、资料、文件、牌板及工作场所清洁整齐、置物有序","id":481,"state":"3","mainId":481},{"taskType":"6","create_time":1536764267000,"key_id":3,"stateFlag":"已处理","clause_description":"文明生产 图纸、资料、文件、牌板及工作场所清洁整齐、置物有序","id":483,"state":"3","mainId":483},{"taskType":"6","create_time":1536766846000,"key_id":2,"stateFlag":"已处理","clause_description":"密闭、风门、风窗墙体周边按规定掏槽，墙体与煤岩接实，四周有不少于0.1m的裙边，周边及围岩不漏风","id":497,"state":"3","mainId":497}]
     */

    private String msg;
    private String code;
    private DataBean data;
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

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public List<ResultMapsBean> getResultMaps() {
        return resultMaps;
    }

    public void setResultMaps(List<ResultMapsBean> resultMaps) {
        this.resultMaps = resultMaps;
    }

    public static class DataBean {
        /**
         * pageCount : 25
         * count : 145
         * pageSize : 6
         * pageNum : 1
         */

        private int pageCount;
        private int count;
        private int pageSize;
        private int pageNum;

        public int getPageCount() {
            return pageCount;
        }

        public void setPageCount(int pageCount) {
            this.pageCount = pageCount;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public int getPageSize() {
            return pageSize;
        }

        public void setPageSize(int pageSize) {
            this.pageSize = pageSize;
        }

        public int getPageNum() {
            return pageNum;
        }

        public void setPageNum(int pageNum) {
            this.pageNum = pageNum;
        }
    }

    public static class ResultMapsBean {
        /**
         * taskType : 6
         * create_time : 1536754817000
         * key_id : 2
         * stateFlag : 已处理
         * clause_description : 密闭、风门、风窗墙体周边按规定掏槽，墙体与煤岩接实，四周有不少于0.1m的裙边，周边及围岩不漏风
         * id : 433
         * state : 3
         * mainId : 433
         */

        private String taskType;
        private long create_time;
        private int key_id;
        private String stateFlag;
        private String clause_description;
        private int id;
        private String state;
        private int mainId;

        public String getTaskType() {
            return taskType;
        }

        public void setTaskType(String taskType) {
            this.taskType = taskType;
        }

        public long getCreate_time() {
            return create_time;
        }

        public void setCreate_time(long create_time) {
            this.create_time = create_time;
        }

        public int getKey_id() {
            return key_id;
        }

        public void setKey_id(int key_id) {
            this.key_id = key_id;
        }

        public String getStateFlag() {
            return stateFlag;
        }

        public void setStateFlag(String stateFlag) {
            this.stateFlag = stateFlag;
        }

        public String getClause_description() {
            return clause_description;
        }

        public void setClause_description(String clause_description) {
            this.clause_description = clause_description;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public int getMainId() {
            return mainId;
        }

        public void setMainId(int mainId) {
            this.mainId = mainId;
        }
    }
}
