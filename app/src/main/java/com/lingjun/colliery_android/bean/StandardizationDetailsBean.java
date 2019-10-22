package com.lingjun.colliery_android.bean;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 作者: zengtao
 * 时间: 2019/8/23  14:47.
 * 注释:
 */
@NoArgsConstructor
@Data
public class StandardizationDetailsBean {

    /**
     * task : {"state":"8","tasktype":"1","modifytime":1566376643000,"description":"杨庆曾涛测试","title":"杨庆曾涛测试","isRectification":0,"createtime":1566376547000,"id":28905,"starttime":1566376547000,"creatorName":"王红伟","deleted":0,"creatorId":249,"isUpgrad":0,"taskSource":0,"endtime":1566376643000}
     * project : {"categoryId":144,"autosummary1":"[{'id':'1',  'name':'安全风险分级管控','score':'-1'},{'id':'16',  'name':'事故隐患排查治理','score':'-1'},{'id':'37',  'name':'通风','score':'-1'},{'id':'82',  'name':'地质灾害防治与测量','score':'-1'},{'id':'144',  'name':'采煤','score':'93.0'},{'id':'164',  'name':'掘进','score':'-1'},{'id':'187',  'name':'机电','score':'-1'},{'id':'222',  'name':'运输','score':'-1'},{'id':'244',  'name':'职业卫生','score':'-1'},{'id':'278',  'name':'安全培训和应急管理','score':'-1'},{'id':'301',  'name':'调度和地面设施','score':'-1'}]","approverName":"","starttime":1566376547000,"autoscore":93,"custom":1,"categoryName":"采煤","approverId":0,"finishtime":1566316800000,"taskId":28905}
     */

    private TaskBean task;
    private ProjectBean project;

    @NoArgsConstructor
    @Data
    public static class TaskBean {
        /**
         * state : 8
         * tasktype : 1
         * modifytime : 1566376643000
         * description : 杨庆曾涛测试
         * title : 杨庆曾涛测试
         * isRectification : 0
         * createtime : 1566376547000
         * id : 28905
         * starttime : 1566376547000
         * creatorName : 王红伟
         * deleted : 0
         * creatorId : 249
         * isUpgrad : 0
         * taskSource : 0
         * endtime : 1566376643000
         */

        private String state;
        private String tasktype;
        private long modifytime;
        private String description;
        private String title;
        private int isRectification;
        private long createtime;
        private int id;
        private long starttime;
        private String creatorName;
        private int deleted;
        private int creatorId;
        private int isUpgrad;
        private int taskSource;
        private long endtime;
    }

    @NoArgsConstructor
    @Data
    public static class ProjectBean {
        /**
         * categoryId : 144
         * autosummary1 : [{'id':'1',  'name':'安全风险分级管控','score':'-1'},{'id':'16',  'name':'事故隐患排查治理','score':'-1'},{'id':'37',  'name':'通风','score':'-1'},{'id':'82',  'name':'地质灾害防治与测量','score':'-1'},{'id':'144',  'name':'采煤','score':'93.0'},{'id':'164',  'name':'掘进','score':'-1'},{'id':'187',  'name':'机电','score':'-1'},{'id':'222',  'name':'运输','score':'-1'},{'id':'244',  'name':'职业卫生','score':'-1'},{'id':'278',  'name':'安全培训和应急管理','score':'-1'},{'id':'301',  'name':'调度和地面设施','score':'-1'}]
         * approverName :
         * starttime : 1566376547000
         * autoscore : 93
         * custom : 1
         * categoryName : 采煤
         * approverId : 0
         * finishtime : 1566316800000
         * taskId : 28905
         */

        private int categoryId;
        private String autosummary1;
        private String approverName;
        private long starttime;
        private int autoscore;
        private int custom;
        private String categoryName;
        private int approverId;
        private long finishtime;
        private int taskId;
    }
}
