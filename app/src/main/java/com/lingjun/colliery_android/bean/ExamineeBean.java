package com.lingjun.colliery_android.bean;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: ztcc
 * @Data： 2019/9/7 18:44
 * Describe:
 */
@NoArgsConstructor
@Data
public class ExamineeBean {

    /**
     * page : {"totalRecord":1,"pageSize":10,"dateFormat":"","totalPage":1,"pageNo":1,"params":{"isAdmin":"1","departmentId":"58"},"resultMaps":[{"id":64,"name":"陈淑敏"}]}
     */

    private PageBean page;

    @NoArgsConstructor
    @Data
    public static class PageBean {
        /**
         * totalRecord : 1
         * pageSize : 10
         * dateFormat :
         * totalPage : 1
         * pageNo : 1
         * params : {"isAdmin":"1","departmentId":"58"}
         * resultMaps : [{"id":64,"name":"陈淑敏"}]
         */

        private int totalRecord;
        private int pageSize;
        private String dateFormat;
        private int totalPage;
        private int pageNo;
        private ParamsBean params;
        private List<ResultMapsBean> resultMaps;

        @NoArgsConstructor
        @Data
        public static class ParamsBean {
            /**
             * isAdmin : 1
             * departmentId : 58
             */

            private String isAdmin;
            private String departmentId;
        }

        @NoArgsConstructor
        @Data
        public static class ResultMapsBean {
            /**
             * id : 64
             * name : 陈淑敏
             */

            private int id;
            private String name;
        }
    }
}
