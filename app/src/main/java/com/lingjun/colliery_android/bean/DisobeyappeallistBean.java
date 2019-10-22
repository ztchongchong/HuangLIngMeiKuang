package com.lingjun.colliery_android.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者: zengtao
 * 时间: 2019/5/23  9:13.
 * 注释: 申诉类型集合
 */
public class DisobeyappeallistBean {

    /**
     * msg : 成功
     * code : 200
     * data : {"list":[{"id":1,"name":"条款错误","number":1,"enabled":"1","deleted":"0","flags":0,"remark":""},{"id":2,"name":"触发过重","number":2,"enabled":"1","deleted":"0","flags":0,"remark":""}]}
     * resultMaps : []
     */

    private String msg;
    private String code;
    private DataBean data;
    private List<?> resultMaps;

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

    public List<?> getResultMaps() {
        return resultMaps;
    }

    public void setResultMaps(List<?> resultMaps) {
        this.resultMaps = resultMaps;
    }

    public static class DataBean {
        private ArrayList<ListBean> list;

        public ArrayList<ListBean> getList() {
            return list;
        }

        public void setList(ArrayList<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * id : 1
             * name : 条款错误
             * number : 1
             * enabled : 1
             * deleted : 0
             * flags : 0
             * remark :
             */

            private int id;
            private String name;
            private int number;
            private String enabled;
            private String deleted;
            private int flags;
            private String remark;

            public boolean isType() {
                return type;
            }

            public void setType(boolean type) {
                this.type = type;
            }

            private boolean type;

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

            public int getNumber() {
                return number;
            }

            public void setNumber(int number) {
                this.number = number;
            }

            public String getEnabled() {
                return enabled;
            }

            public void setEnabled(String enabled) {
                this.enabled = enabled;
            }

            public String getDeleted() {
                return deleted;
            }

            public void setDeleted(String deleted) {
                this.deleted = deleted;
            }

            public int getFlags() {
                return flags;
            }

            public void setFlags(int flags) {
                this.flags = flags;
            }

            public String getRemark() {
                return remark;
            }

            public void setRemark(String remark) {
                this.remark = remark;
            }
        }
    }
}
