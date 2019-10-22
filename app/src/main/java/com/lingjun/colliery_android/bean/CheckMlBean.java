package com.lingjun.colliery_android.bean;

import java.util.List;

/**
 * Created by shurrikann on 2018/12/20.
 */

public class CheckMlBean {

    /**
     * msg : null
     * code : null
     * data : {"catalogList":[{"id":30,"name":"1.1.1","selectName":null,"number":"010101","parentId":3,"serialno":null,"remark":"","deleted":false,"source":"","children":null,"adminUsers":null,"archiveUsers":null,"dataSource":null,"standards":null,"catalogs":null}]}
     * resultMaps : []
     */

    private Object msg;
    private Object code;
    private DataBean data;
    private List<?> resultMaps;

    public Object getMsg() {
        return msg;
    }

    public void setMsg(Object msg) {
        this.msg = msg;
    }

    public Object getCode() {
        return code;
    }

    public void setCode(Object code) {
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
        private List<CatalogListBean> catalogList;

        public List<CatalogListBean> getCatalogList() {
            return catalogList;
        }

        public void setCatalogList(List<CatalogListBean> catalogList) {
            this.catalogList = catalogList;
        }

        public static class CatalogListBean {
            /**
             * id : 30
             * name : 1.1.1
             * selectName : null
             * number : 010101
             * parentId : 3
             * serialno : null
             * remark :
             * deleted : false
             * source :
             * children : null
             * adminUsers : null
             * archiveUsers : null
             * dataSource : null
             * standards : null
             * catalogs : null
             */

            private int id;
            private String name;
            private Object selectName;
            private String number;
            private int parentId;
            private Object serialno;
            private String remark;
            private boolean deleted;
            private String source;
            private Object children;
            private Object adminUsers;
            private Object archiveUsers;
            private Object dataSource;
            private Object standards;
            private Object catalogs;
            private boolean state;

            private boolean checktype;

            public boolean isChecktype() {
                return checktype;
            }

            public void setChecktype(boolean checktype) {
                this.checktype = checktype;
            }

            public boolean isState() {
                return state;
            }

            public void setState(boolean state) {
                this.state = state;
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

            public Object getSelectName() {
                return selectName;
            }

            public void setSelectName(Object selectName) {
                this.selectName = selectName;
            }

            public String getNumber() {
                return number;
            }

            public void setNumber(String number) {
                this.number = number;
            }

            public int getParentId() {
                return parentId;
            }

            public void setParentId(int parentId) {
                this.parentId = parentId;
            }

            public Object getSerialno() {
                return serialno;
            }

            public void setSerialno(Object serialno) {
                this.serialno = serialno;
            }

            public String getRemark() {
                return remark;
            }

            public void setRemark(String remark) {
                this.remark = remark;
            }

            public boolean isDeleted() {
                return deleted;
            }

            public void setDeleted(boolean deleted) {
                this.deleted = deleted;
            }

            public String getSource() {
                return source;
            }

            public void setSource(String source) {
                this.source = source;
            }

            public Object getChildren() {
                return children;
            }

            public void setChildren(Object children) {
                this.children = children;
            }

            public Object getAdminUsers() {
                return adminUsers;
            }

            public void setAdminUsers(Object adminUsers) {
                this.adminUsers = adminUsers;
            }

            public Object getArchiveUsers() {
                return archiveUsers;
            }

            public void setArchiveUsers(Object archiveUsers) {
                this.archiveUsers = archiveUsers;
            }

            public Object getDataSource() {
                return dataSource;
            }

            public void setDataSource(Object dataSource) {
                this.dataSource = dataSource;
            }

            public Object getStandards() {
                return standards;
            }

            public void setStandards(Object standards) {
                this.standards = standards;
            }

            public Object getCatalogs() {
                return catalogs;
            }

            public void setCatalogs(Object catalogs) {
                this.catalogs = catalogs;
            }
        }
    }
}
