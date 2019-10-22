package com.lingjun.colliery_android.bean;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 作者: zengtao
 * 时间: 2019/8/22  16:59.
 * 注释:
 */
@NoArgsConstructor
@Data
public class StandardizationListBean {

    /**
     * page : {"totalRecord":25,"results":[{"state":"8","tasktype":"1","modifytime":1566376643000,"description":"杨庆曾涛测试","title":"杨庆曾涛测试","createtime":1566376547000,"id":28905,"starttime":1566376547000,"project":{"categoryId":144,"autosummary1":"[{'id':'1',  'name':'安全风险分级管控','score':'-1'},{'id':'16',  'name':'事故隐患排查治理','score':'-1'},{'id':'37',  'name':'通风','score':'-1'},{'id':'82',  'name':'地质灾害防治与测量','score':'-1'},{'id':'144',  'name':'采煤','score':'93.0'},{'id':'164',  'name':'掘进','score':'-1'},{'id':'187',  'name':'机电','score':'-1'},{'id':'222',  'name':'运输','score':'-1'},{'id':'244',  'name':'职业卫生','score':'-1'},{'id':'278',  'name':'安全培训和应急管理','score':'-1'},{'id':'301',  'name':'调度和地面设施','score':'-1'}]","starttime":1566376547000,"autoscore":93,"custom":1,"categoryName":"采煤","approverId":0,"finishtime":1566316800000,"taskId":28905},"deleted":0,"creatorId":249,"taskSource":0,"endtime":1566376643000,"cores":"0%"},{"state":"7","tasktype":"1","description":"zc1","title":"zc1","createtime":1566369345000,"id":28481,"starttime":1566369345000,"cores":"0%","project":{"starttime":1566369345000,"custom":0,"categoryName":"标准化检查","approverId":0,"finishtime":1566316800000,"taskId":28481},"deleted":0,"creatorId":249,"taskSource":0},{"state":"7","tasktype":"1","description":"杨庆是大法官","title":"杨庆是大法官","createtime":1566368871000,"id":28463,"starttime":1566368871000,"cores":"0%","project":{"categoryId":164,"starttime":1566368871000,"custom":1,"categoryName":"掘进","approverId":0,"finishtime":1566316800000,"taskId":28463},"deleted":0,"creatorId":249,"taskSource":0},{"state":"7","tasktype":"1","description":"zc","title":"zc","createtime":1566355524000,"id":28038,"starttime":1566355524000,"cores":"74%","project":{"autosummary1":"[{'id':'1',  'name':'安全风险分级管控','score':'100.0'},{'id':'16',  'name':'事故隐患排查治理','score':'100.0'},{'id':'37',  'name':'通风','score':'100.0'},{'id':'82',  'name':'地质灾害防治与测量','score':'100.0'},{'id':'144',  'name':'采煤','score':'100.0'},{'id':'164',  'name':'掘进','score':'100.0'},{'id':'187',  'name':'机电','score':'100.0'},{'id':'222',  'name':'运输','score':'100.0'},{'id':'244',  'name':'职业卫生','score':'98.0'},{'id':'278',  'name':'安全培训和应急管理','score':'99.0'},{'id':'301',  'name':'调度和地面设施','score':'99.0'}]","starttime":1566355524000,"autoscore":99.76,"custom":0,"categoryName":"标准化检查","approverId":0,"finishtime":1566316800000,"taskId":28038},"deleted":0,"creatorId":249,"taskSource":0},{"state":"7","tasktype":"1","description":"wangai标准化检查测试-检查说明111","title":"wangai标准化检查测试-项目标题111","createtime":1566352439000,"id":27632,"starttime":1566352439000,"cores":"0%","project":{"starttime":1566352439000,"custom":0,"categoryName":"标准化检查","approverId":0,"finishtime":1566316800000,"taskId":27632},"deleted":0,"creatorId":249,"taskSource":0}],"pageSize":5,"dateFormat":"","totalPage":5,"pageNo":1,"params":{"taskType":"1","status":"0","searchstr":"","checkstatus":"0","endTime":"","state":"1,2,3,4,5,6,7,8,9,10,11,12","startTime":"","checkflag":"0"},"resultMaps":[]}
     */

    private PageBean page;

    @NoArgsConstructor
    @Data
    public static class PageBean {
        /**
         * totalRecord : 25
         * results : [{"state":"8","tasktype":"1","modifytime":1566376643000,"description":"杨庆曾涛测试","title":"杨庆曾涛测试","createtime":1566376547000,"id":28905,"starttime":1566376547000,"project":{"categoryId":144,"autosummary1":"[{'id':'1',  'name':'安全风险分级管控','score':'-1'},{'id':'16',  'name':'事故隐患排查治理','score':'-1'},{'id':'37',  'name':'通风','score':'-1'},{'id':'82',  'name':'地质灾害防治与测量','score':'-1'},{'id':'144',  'name':'采煤','score':'93.0'},{'id':'164',  'name':'掘进','score':'-1'},{'id':'187',  'name':'机电','score':'-1'},{'id':'222',  'name':'运输','score':'-1'},{'id':'244',  'name':'职业卫生','score':'-1'},{'id':'278',  'name':'安全培训和应急管理','score':'-1'},{'id':'301',  'name':'调度和地面设施','score':'-1'}]","starttime":1566376547000,"autoscore":93,"custom":1,"categoryName":"采煤","approverId":0,"finishtime":1566316800000,"taskId":28905},"deleted":0,"creatorId":249,"taskSource":0,"endtime":1566376643000},{"state":"7","tasktype":"1","description":"zc1","title":"zc1","createtime":1566369345000,"id":28481,"starttime":1566369345000,"cores":"0%","project":{"starttime":1566369345000,"custom":0,"categoryName":"标准化检查","approverId":0,"finishtime":1566316800000,"taskId":28481},"deleted":0,"creatorId":249,"taskSource":0},{"state":"7","tasktype":"1","description":"杨庆是大法官","title":"杨庆是大法官","createtime":1566368871000,"id":28463,"starttime":1566368871000,"cores":"0%","project":{"categoryId":164,"starttime":1566368871000,"custom":1,"categoryName":"掘进","approverId":0,"finishtime":1566316800000,"taskId":28463},"deleted":0,"creatorId":249,"taskSource":0},{"state":"7","tasktype":"1","description":"zc","title":"zc","createtime":1566355524000,"id":28038,"starttime":1566355524000,"cores":"74%","project":{"autosummary1":"[{'id':'1',  'name':'安全风险分级管控','score':'100.0'},{'id':'16',  'name':'事故隐患排查治理','score':'100.0'},{'id':'37',  'name':'通风','score':'100.0'},{'id':'82',  'name':'地质灾害防治与测量','score':'100.0'},{'id':'144',  'name':'采煤','score':'100.0'},{'id':'164',  'name':'掘进','score':'100.0'},{'id':'187',  'name':'机电','score':'100.0'},{'id':'222',  'name':'运输','score':'100.0'},{'id':'244',  'name':'职业卫生','score':'98.0'},{'id':'278',  'name':'安全培训和应急管理','score':'99.0'},{'id':'301',  'name':'调度和地面设施','score':'99.0'}]","starttime":1566355524000,"autoscore":99.76,"custom":0,"categoryName":"标准化检查","approverId":0,"finishtime":1566316800000,"taskId":28038},"deleted":0,"creatorId":249,"taskSource":0},{"state":"7","tasktype":"1","description":"wangai标准化检查测试-检查说明111","title":"wangai标准化检查测试-项目标题111","createtime":1566352439000,"id":27632,"starttime":1566352439000,"cores":"0%","project":{"starttime":1566352439000,"custom":0,"categoryName":"标准化检查","approverId":0,"finishtime":1566316800000,"taskId":27632},"deleted":0,"creatorId":249,"taskSource":0}]
         * pageSize : 5
         * dateFormat :
         * totalPage : 5
         * pageNo : 1
         * params : {"taskType":"1","status":"0","searchstr":"","checkstatus":"0","endTime":"","state":"1,2,3,4,5,6,7,8,9,10,11,12","startTime":"","checkflag":"0"}
         * resultMaps : []
         */

        private int totalRecord;
        private int pageSize;
        private String dateFormat;
        private int totalPage;
        private int pageNo;
        private ParamsBean params;
        private ArrayList<ResultsBean> results;
        private List<?> resultMaps;

        @NoArgsConstructor
        @Data
        public static class ParamsBean {
            /**
             * taskType : 1
             * status : 0
             * searchstr :
             * checkstatus : 0
             * endTime :
             * state : 1,2,3,4,5,6,7,8,9,10,11,12
             * startTime :
             * checkflag : 0
             */

            private String taskType;
            private String status;
            private String searchstr;
            private String checkstatus;
            private String endTime;
            private String state;
            private String startTime;
            private String checkflag;
        }

        @NoArgsConstructor
        @Data
        public static class ResultsBean {
            /**
             * state : 8
             * tasktype : 1
             * modifytime : 1566376643000
             * description : 杨庆曾涛测试
             * title : 杨庆曾涛测试
             * createtime : 1566376547000
             * id : 28905
             * starttime : 1566376547000
             * project : {"categoryId":144,"autosummary1":"[{'id':'1',  'name':'安全风险分级管控','score':'-1'},{'id':'16',  'name':'事故隐患排查治理','score':'-1'},{'id':'37',  'name':'通风','score':'-1'},{'id':'82',  'name':'地质灾害防治与测量','score':'-1'},{'id':'144',  'name':'采煤','score':'93.0'},{'id':'164',  'name':'掘进','score':'-1'},{'id':'187',  'name':'机电','score':'-1'},{'id':'222',  'name':'运输','score':'-1'},{'id':'244',  'name':'职业卫生','score':'-1'},{'id':'278',  'name':'安全培训和应急管理','score':'-1'},{'id':'301',  'name':'调度和地面设施','score':'-1'}]","starttime":1566376547000,"autoscore":93,"custom":1,"categoryName":"采煤","approverId":0,"finishtime":1566316800000,"taskId":28905}
             * deleted : 0
             * creatorId : 249
             * taskSource : 0
             * endtime : 1566376643000
             * cores : 0%
             */

            private String state;
            private String tasktype;
            private long modifytime;
            private String description;
            private String title;
            private long createtime;
            private int id;
            private long starttime;
            private ProjectBean project;
            private int deleted;
            private int creatorId;
            private int taskSource;
            private long endtime;
            private String cores;

            @NoArgsConstructor
            @Data
            public static class ProjectBean {
                /**
                 * categoryId : 144
                 * autosummary1 : [{'id':'1',  'name':'安全风险分级管控','score':'-1'},{'id':'16',  'name':'事故隐患排查治理','score':'-1'},{'id':'37',  'name':'通风','score':'-1'},{'id':'82',  'name':'地质灾害防治与测量','score':'-1'},{'id':'144',  'name':'采煤','score':'93.0'},{'id':'164',  'name':'掘进','score':'-1'},{'id':'187',  'name':'机电','score':'-1'},{'id':'222',  'name':'运输','score':'-1'},{'id':'244',  'name':'职业卫生','score':'-1'},{'id':'278',  'name':'安全培训和应急管理','score':'-1'},{'id':'301',  'name':'调度和地面设施','score':'-1'}]
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
                private long starttime;
                private int autoscore;
                private int custom;
                private String categoryName;
                private int approverId;
                private long finishtime;
                private int taskId;
            }
        }
    }
}
