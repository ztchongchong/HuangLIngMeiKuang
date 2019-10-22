package com.lingjun.colliery_android.bean;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: ztcc
 * @Data： 2019/9/7 15:34
 * Describe: 班部
 */
@NoArgsConstructor
@Data
public class TeamBean {

    private List<ListBean> list;

    @NoArgsConstructor
    @Data
    public static class ListBean {
        /**
         * parentname : 无上级
         * remark :
         * fullDeptno : 0
         * parentId : 0
         * deptno : 000
         * id : 502
         * name : 双龙矿
         * deleted : 0
         * roleset : Ag==
         * level : 1
         */

        private String parentname;
        private String remark;
        private String fullDeptno;
        private int parentId;
        private String deptno;
        private int id;
        private String name;
        private int deleted;
        private String roleset;
        private int level;
    }
}
