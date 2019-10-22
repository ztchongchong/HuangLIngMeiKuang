package com.lingjun.colliery_android.bean;

import java.util.List;

/**
 * HiddenDangerContentActivity
 */
public class HiddenDangerContentBean {

    /**
     * msg : 成功
     * code : 200
     * data : {"sourceCount":1280}
     * resultMaps : [{"sourceId":1,"clause":"1.当班硐长每班接班应检查工作面支护、空顶、空帮距。2.掘进机司机每班接班后必须协助硐长检查工作面迎头支护情况、顶板及两帮完好情况，认真执行敲帮问顶作业，确定工作面安全后方可掘进。3.当班安全员监督检查工作面顶帮状况。","score":0,"money":0,"key_id":1,"keyName":"无","description":"未认真执行敲帮问顶","processor_id":1334,"categoryName":"顶板","categoryId":1},{"sourceId":2,"clause":"1.顶板无离层、无活矸、无鳞片，支护完好，空顶、空帮距符合作业规程规定。2.巷帮无裂缝。","score":0,"money":0,"key_id":1,"keyName":"无","description":"顶、帮状况差或顶板破碎、两帮片帮严重","processor_id":1334,"categoryName":"顶板","categoryId":1},{"sourceId":3,"clause":"测绘工必须选择在无离层、无活矸、无磷片、支护完好的顶板下，吊挂、拆卸激光仪。","description":"未选择在顶板状况好的地方吊挂、拆卸调校激光指向仪","categoryName":"顶板","categoryId":1},{"sourceId":4,"clause":2.施工用的金属网裁剪时，应两人配合作业，动作协调一致。3.搬移材料时，两人合作步调一致，多人作业时，拉开距离，避免碰撞。","description":"掘进工作面施工时操作失误或使用工具不当","categoryName":"顶板""categoryId":9}]
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
         * sourceCount : 1280
         */

        private int sourceCount;

        public int getSourceCount() {
            return sourceCount;
        }

        public void setSourceCount(int sourceCount) {
            this.sourceCount = sourceCount;
        }
    }

    public static class ResultMapsBean {
        /**
         * sourceId : 1
         * clause : 1.当班硐长每班接班应检查工作面支护、空顶、空帮距。2.掘进机司机每班接班后必须协助硐长检查工作面迎头支护情况、顶板及两帮完好情况，认真执行敲帮问顶作业，确定工作面安全后方可掘进。3.当班安全员监督检查工作面顶帮状况。
         * score : 0
         * money : 0
         * key_id : 1
         * keyName : 无
         * description : 未认真执行敲帮问顶
         * processor_id : 1334
         * categoryName : 顶板
         * categoryId : 1
         */

        private int sourceId;
        private String clause;
        private int score;
        private int money;
        private int key_id;
        private String keyName;
        private String description;
        private int processor_id;
        private String categoryName;
        private int categoryId;

        public String getMeasures() {
            return measures;
        }

        public void setMeasures(String measures) {
            this.measures = measures;
        }

        private String measures;

        public String getConsequence() {
            return consequence;
        }

        public void setConsequence(String consequence) {
            this.consequence = consequence;
        }

        private String consequence;

        public int getSourceId() {
            return sourceId;
        }

        public void setSourceId(int sourceId) {
            this.sourceId = sourceId;
        }

        public String getClause() {
            return clause;
        }

        public void setClause(String clause) {
            this.clause = clause;
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

        public int getKey_id() {
            return key_id;
        }

        public void setKey_id(int key_id) {
            this.key_id = key_id;
        }

        public String getKeyName() {
            return keyName;
        }

        public void setKeyName(String keyName) {
            this.keyName = keyName;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public int getProcessor_id() {
            return processor_id;
        }

        public void setProcessor_id(int processor_id) {
            this.processor_id = processor_id;
        }

        public String getCategoryName() {
            return categoryName;
        }

        public void setCategoryName(String categoryName) {
            this.categoryName = categoryName;
        }

        public int getCategoryId() {
            return categoryId;
        }

        public void setCategoryId(int categoryId) {
            this.categoryId = categoryId;
        }
    }
}
