package com.lingjun.colliery_android.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nefa on 2018/11/16.
 */

public class UnsafeBehaviorBean {

    /**
     * msg : 成功
     * code : 200
     * data : {"tree":[{"children":[],"name":"不安全行为","index":"1","id":1},{"children":[],"name":"采煤","index":"2","id":2},{"children":[],"name":"掘进","index":"3","id":3},{"children":[],"name":"机电专业习惯性违章","index":"4","id":4},{"children":[],"name":"运输专业习惯性违章","index":"5","id":5},{"children":[],"name":"\u201c一通三防\u201d专业习惯性违章","index":"6","id":6}]}
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
        private ArrayList<TreeBean> tree;

        public ArrayList<TreeBean> getTree() {
            return tree;
        }

        public void setTree(ArrayList<TreeBean> tree) {
            this.tree = tree;
        }

        public static class TreeBean {
            /**
             * children : []
             * name : 不安全行为
             * index : 1
             * id : 1
             */

            private String name;
            private String index;
            private int id;
            private List<?> children;

            public boolean isType() {
                return type;
            }

            public void setType(boolean type) {
                this.type = type;
            }

            private boolean type=false;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getIndex() {
                return index;
            }

            public void setIndex(String index) {
                this.index = index;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public List<?> getChildren() {
                return children;
            }

            public void setChildren(List<?> children) {
                this.children = children;
            }
        }
    }
}
