package com.lingjun.colliery_android.bean;

import java.util.List;

/**
 * 挂牌督办（录入隐患）
 */
public class SupervisionOfListingBean {

    /**
     * msg : 成功
     * code : 200
     * data : null
     * resultMaps : [{"taskType":"10","stateFlag":"已存储","processor_id":1326,"processorName":"郭高民","state":"9","process_time":1541161429000,"taskId":494,"source_description":"未检查掘进面或未认真执行敲帮问顶"},{"taskType":"10","stateFlag":"待存储","processor_id":1326,"processorName":"郭高民","state":"8","process_time":1541167529000,"taskId":517,"source_description":"未检查掘进面或未认真执行敲帮问顶"},{"taskType":"10","stateFlag":"已存储","processor_id":1334,"processorName":"贺升元","state":"9","process_time":1541208065000,"taskId":533,"source_description":"未选择在顶板状况好的地方吊挂、拆卸调校激光指向仪"},{"taskType":"10","stateFlag":"待存储","processor_id":1334,"processorName":"贺升元","state":"8","process_time":1541209154000,"taskId":539,"source_description":"掘进工作面顶、帮状况差或顶板破碎、两帮片帮严重"},{"taskType":"10","stateFlag":"整改中","processor_id":1326,"processorName":"郭高民","state":"5","process_time":1542247655000,"taskId":1124,"source_description":"顶、帮状况差或顶板破碎、两帮片帮严重"},{"taskType":"10","stateFlag":"整改中","processor_id":1326,"processorName":"郭高民","state":"5","process_time":1542251577000,"taskId":1136,"source_description":"掘进工作面施工时操作失误或使用工具不当"}]
     */

    private String msg;
    private String code;
    private Object data;
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

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public List<ResultMapsBean> getResultMaps() {
        return resultMaps;
    }

    public void setResultMaps(List<ResultMapsBean> resultMaps) {
        this.resultMaps = resultMaps;
    }

    public static class ResultMapsBean {
        /**
         * taskType : 10
         * stateFlag : 已存储
         * processor_id : 1326
         * processorName : 郭高民
         * state : 9
         * process_time : 1541161429000
         * taskId : 494
         * source_description : 未检查掘进面或未认真执行敲帮问顶
         */

        private String taskType;
        private String stateFlag;
        private int processor_id;
        private String processorName;
        private String state;
        private long process_time;
        private int taskId;
        private String source_description;

        public String getTaskType() {
            return taskType;
        }

        public void setTaskType(String taskType) {
            this.taskType = taskType;
        }

        public String getStateFlag() {
            return stateFlag;
        }

        public void setStateFlag(String stateFlag) {
            this.stateFlag = stateFlag;
        }

        public int getProcessor_id() {
            return processor_id;
        }

        public void setProcessor_id(int processor_id) {
            this.processor_id = processor_id;
        }

        public String getProcessorName() {
            return processorName;
        }

        public void setProcessorName(String processorName) {
            this.processorName = processorName;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public long getProcess_time() {
            return process_time;
        }

        public void setProcess_time(long process_time) {
            this.process_time = process_time;
        }

        public int getTaskId() {
            return taskId;
        }

        public void setTaskId(int taskId) {
            this.taskId = taskId;
        }

        public String getSource_description() {
            return source_description;
        }

        public void setSource_description(String source_description) {
            this.source_description = source_description;
        }
    }
}
