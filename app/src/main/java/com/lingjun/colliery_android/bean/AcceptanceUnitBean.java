package com.lingjun.colliery_android.bean;

import java.io.Serializable;
import java.util.List;

/**
 * 作者: zengtao
 * 时间: 2019/4/28  9:37.
 * 注释:
 */
public class AcceptanceUnitBean implements Serializable {

    /**
     * msg : 成功
     * data : {"resultMap":[{"parentname":"无上级","id":1,"name":"综合管理部","parentId":0,"deleted":0,"level":0},{"parentname":"综合管理部","id":773,"name":"实业公司","parentId":1,"deleted":0,"level":1},{"parentname":"综合管理部","id":21,"name":"生产技术部","parentId":1,"deleted":0,"level":1},{"parentname":"生产技术部","id":32,"name":"综合采煤队","parentId":21,"deleted":0,"level":2},{"parentname":"生产技术部","id":320,"name":"综掘三队","parentId":21,"deleted":0,"level":2},{"parentname":"综合管理部","id":577,"name":"通风部","parentId":1,"deleted":0,"level":1},{"parentname":"通风部","id":582,"name":"通维队","parentId":577,"deleted":0,"level":2},{"parentname":"生产技术部","id":339,"name":"开拓一队","parentId":21,"deleted":0,"level":2},{"parentname":"生产技术部","id":341,"name":"开拓二队","parentId":21,"deleted":0,"level":2},{"parentname":"生产技术部","id":343,"name":"开拓三队","parentId":21,"deleted":0,"level":2},{"parentname":"生产技术部","id":345,"name":"储煤厂","parentId":21,"deleted":0,"level":2},{"parentname":"综合管理部","id":364,"name":"机电设备管理部","parentId":1,"deleted":0,"level":1},{"parentname":"机电设备管理部","id":374,"name":"机电队","parentId":364,"deleted":0,"level":2},{"parentname":"综合管理部","id":642,"name":"安全监察部","parentId":1,"deleted":0,"level":1},{"parentname":"综合管理部","id":665,"name":"地测部","parentId":1,"deleted":0,"level":1},{"parentname":"综合管理部","id":672,"name":"调度指挥中心","parentId":1,"deleted":0,"level":1},{"parentname":"生产技术部","id":166,"name":"综掘一队","parentId":21,"deleted":0,"level":2},{"parentname":"综合管理部","id":685,"name":"党群工作部","parentId":1,"deleted":0,"level":1},{"parentname":"综合管理部","id":691,"name":"工程规划管理部","parentId":1,"deleted":0,"level":1},{"parentname":"综合管理部","id":697,"name":"经营办","parentId":1,"deleted":0,"level":1},{"parentname":"综合管理部","id":708,"name":"财务部","parentId":1,"deleted":0,"level":1},{"parentname":"综合管理部","id":715,"name":"物资供应公司","parentId":1,"deleted":0,"level":1},{"parentname":"机电设备管理部","id":471,"name":"选运队","parentId":364,"deleted":0,"level":2},{"parentname":"综合管理部","id":740,"name":"运销公司","parentId":1,"deleted":0,"level":1},{"parentname":"生产技术部","id":245,"name":"综掘二队","parentId":21,"deleted":0,"level":2},{"deptno":"0001","parentname":"无上级","id":788,"remark":"矿领导","fullDeptno":"01","name":"矿领导","parentId":0,"deleted":0,"level":1}]}
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

    public static class DataBean implements Serializable {
        private List<ResultMapBean> resultMap;

        public List<ResultMapBean> getResultMap() {
            return resultMap;
        }

        public void setResultMap(List<ResultMapBean> resultMap) {
            this.resultMap = resultMap;
        }

        public static class ResultMapBean implements Serializable {
            /**
             * parentname : 无上级
             * id : 1
             * name : 综合管理部
             * parentId : 0
             * deleted : 0
             * level : 0
             * deptno : 0001
             * remark : 矿领导
             * fullDeptno : 01
             */

            private String parentname;
            private int id;
            private String name;
            private int parentId;
            private int deleted;
            private int level;
            private String deptno;
            private String remark;
            private String fullDeptno;

            public boolean isType() {
                return type;
            }

            public void setType(boolean type) {
                this.type = type;
            }

            private boolean type = false;

            public String getParentname() {
                return parentname;
            }

            public void setParentname(String parentname) {
                this.parentname = parentname;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public int getParentId() {
                return parentId;
            }

            public void setParentId(int parentId) {
                this.parentId = parentId;
            }

            public int getDeleted() {
                return deleted;
            }

            public void setDeleted(int deleted) {
                this.deleted = deleted;
            }

            public int getLevel() {
                return level;
            }

            public void setLevel(int level) {
                this.level = level;
            }

            public String getDeptno() {
                return deptno;
            }

            public void setDeptno(String deptno) {
                this.deptno = deptno;
            }

            public String getRemark() {
                return remark;
            }

            public void setRemark(String remark) {
                this.remark = remark;
            }

            public String getFullDeptno() {
                return fullDeptno;
            }

            public void setFullDeptno(String fullDeptno) {
                this.fullDeptno = fullDeptno;
            }
        }
    }
}
