package com.lingjun.colliery_android.bean;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ztchongchong
 */
@NoArgsConstructor
@Data
public class
HiddenDangersHandleBean {


    /**
     * msg : 成功
     * code : 200
     * data : {"pageCount":0,"count":0,"pageSize":6,"pageNum":1}
     * resultMaps : [{"editSourceMoneyflag":true,"source_score":0,"source_money":0,"closeSourceAnyFlag":true,"delSourceAnyFlag":true,"task_id":15356,"trouble_content":"2407运顺抽放管路有积水","taskType":"9","createTime":1564045685000,"editSourceScoreflag":true,"correctNoticeNo":"5fb65fb6-5fb6-5fb6-5fb6","stateFlag":"验收中","isupgrad":0,"state":"6","mainId":15355,"source_description":"2407运顺抽放管路有积水"},{"editSourceMoneyflag":true,"source_score":0,"source_money":0,"closeSourceAnyFlag":true,"delSourceAnyFlag":true,"task_id":15354,"taskSource":1,"trouble_content":"灌浆站一台灭火器失效","taskType":"10","createTime":1564045523000,"editSourceScoreflag":true,"correctNoticeNo":"3ae33ae3-3ae3-3ae3-3ae3","stateFlag":"整改中","isupgrad":0,"state":"5","mainId":15353,"source_description":"灌浆站一台灭火器失效"},{"editSourceMoneyflag":true,"source_score":0,"source_money":0,"closeSourceAnyFlag":true,"delSourceAnyFlag":true,"task_id":15352,"taskSource":1,"trouble_content":"输送机检修通道无防止人员靠近的护栏或警示标志","taskType":"10","createTime":1564039799000,"editSourceScoreflag":true,"correctNoticeNo":"8ca28ca2-8ca2-8ca2-8ca2","stateFlag":"整改中","isupgrad":0,"state":"5","mainId":15351,"source_description":"输送机检修通道无防止人员靠近的护栏或警示标志"},{"editSourceMoneyflag":true,"source_score":0,"source_money":0,"closeSourceAnyFlag":true,"delSourceAnyFlag":true,"task_id":15350,"taskSource":1,"trouble_content":"一台旧语音通讯装置不完好","taskType":"10","createTime":1564039441000,"editSourceScoreflag":true,"correctNoticeNo":"4a7e4a7e-4a7e-4a7e-4a7e","stateFlag":"整改中","isupgrad":0,"state":"5","mainId":15349,"source_description":"一台旧语音通讯装置不完好"},{"editSourceMoneyflag":true,"source_score":0,"source_money":0,"closeSourceAnyFlag":true,"delSourceAnyFlag":true,"task_id":15347,"taskSource":1,"trouble_content":"2407运顺联巷平台处11.4KW，25KW绞车电源、负荷线吊挂乱","taskType":"10","createTime":1564037192000,"editSourceScoreflag":true,"correctNoticeNo":"d12ad12a-d12a-d12a-d12a","stateFlag":"整改中","isupgrad":0,"state":"5","mainId":15345,"source_description":"2407运顺联巷平台处11.4KW，25KW绞车电源、负荷线吊挂乱"},{"editSourceMoneyflag":true,"source_score":0,"source_money":0,"closeSourceAnyFlag":true,"delSourceAnyFlag":true,"task_id":15328,"trouble_content":"300米处水仓水泵处开关标志牌无整定值","taskType":"9","createTime":1564036700000,"editSourceScoreflag":true,"correctNoticeNo":"49984998-4998-4998-4998","stateFlag":"验收中","isupgrad":0,"state":"6","mainId":15327,"source_description":"300米处水仓水泵处开关标志牌无整定值"}]
     */

    private String msg;
    private String code;
    private DataBean data;
    private List<ResultMapsBean> resultMaps;

    @NoArgsConstructor
    @Data
    public static class DataBean {
        /**
         * pageCount : 0
         * count : 0
         * pageSize : 6
         * pageNum : 1
         */

        private int pageCount;
        private int count;
        private int pageSize;
        private int pageNum;
    }

    @NoArgsConstructor
    @Data
    public static class ResultMapsBean {
        /**
         * editSourceMoneyflag : true
         * source_score : 0
         * source_money : 0.0
         * closeSourceAnyFlag : true
         * delSourceAnyFlag : true
         * task_id : 15356
         * trouble_content : 2407运顺抽放管路有积水
         * taskType : 9
         * createTime : 1564045685000
         * editSourceScoreflag : true
         * correctNoticeNo : 5fb65fb6-5fb6-5fb6-5fb6
         * stateFlag : 验收中
         * isupgrad : 0
         * state : 6
         * mainId : 15355
         * source_description : 2407运顺抽放管路有积水
         * taskSource : 1
         */

        private boolean editSourceMoneyflag;
        private int source_score;
        private double source_money;
        private boolean closeSourceAnyFlag;
        private boolean delSourceAnyFlag;
        private int task_id;
        private String trouble_content;
        private String taskType;
        private long createTime;
        private boolean editSourceScoreflag;
        private String correctNoticeNo;
        private String stateFlag;
        private int isupgrad;
        private String state;
        private int mainId;
        private String source_description;
        private int taskSource;
    }
}
