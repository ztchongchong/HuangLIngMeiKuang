package com.lingjun.colliery_android.bean;

import java.util.List;

/**
 * //隐患录入关键字搜索
 */
public class PopKeywordBean {

    /**
     * msg : 成功
     * code : 200
     * data : null
     * resultMaps : [{"sourceId":1,"score":0,"money":0,"sourceDesc":"未认真执行敲帮问顶","name":"无","keyId":1,"processor_id":1334},{"sourceId":2,"score":0,"money":0,"sourceDesc":"顶、帮状况差或顶板破碎、两帮片帮严重","name":"无","keyId":1,"processor_id":1334},{"sourceId":1010,"score":0,"money":0,"sourceDesc":"轨道铺道作业操作不当","name":"无","keyId":1,"processor_id":1334},{"sourceId":1011,"score":0,"money":0,"sourceDesc":"轨道铺设质量不合格","name":"无","keyId":1,"processor_id":1334},{"sourceId":1012,"score":0,"money":0,"sourceDesc":"轨道未垫平整，部分悬空","name":"无","keyId":1,"processor_id":1334},{"sourceId":1013,"score":0,"money":0,"sourceDesc":"轨道本身有弯曲,{"sourceId":1276,"sourceDesc":"传感器的调校任务中，人员选择需要调校的标准气样时，取放标准气瓶时未轻拿轻放"},{"sourceId":1277,"sourceDesc":"传感器的调校任务中，人员选择需要调校的标准气样时，标准气体的选择不准确"},{"sourceId":1278,"sourceDesc":"传感器的调校任务中，标准气瓶不完好"},{"sourceId":1279,"sourceDesc":"传感器的调校任务中，传感器调校时产生火花"},{"sourceId":1280,"sourceDesc":"传传感器的调校任务中，传感器调校完毕后，人员未贴标签即填写记录"}]
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
         * sourceId : 1
         * score : 0
         * money : 0
         * sourceDesc : 未认真执行敲帮问顶
         * name : 无-
         * keyId : 1
         * processor_id : 1334
         */

        private int sourceId;
        private int score;
        private int money;
        private String sourceDesc;
        private String name;
        private int keyId;
        private int processor_id;

        public int getSourceId() {
            return sourceId;
        }

        public void setSourceId(int sourceId) {
            this.sourceId = sourceId;
        }

        public int getScore() {
            return score;
        }

        public void setScore(int score) {
            this.score = score;
        }

        public int getMoney() {
            return money;
        }

        public void setMoney(int money) {
            this.money = money;
        }

        public String getSourceDesc() {
            return sourceDesc;
        }

        public void setSourceDesc(String sourceDesc) {
            this.sourceDesc = sourceDesc;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getKeyId() {
            return keyId;
        }

        public void setKeyId(int keyId) {
            this.keyId = keyId;
        }

        public int getProcessor_id() {
            return processor_id;
        }

        public void setProcessor_id(int processor_id) {
            this.processor_id = processor_id;
        }
    }
}
