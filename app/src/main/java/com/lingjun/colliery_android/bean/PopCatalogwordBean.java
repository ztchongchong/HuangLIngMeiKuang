package com.lingjun.colliery_android.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者: 黄泉买骨人(zengtao)
 * 时间: 2018/11/29  9:33.
 * 注释:隐患筛选目录
 */
public class PopCatalogwordBean {


    /**
     * msg : 成功
     * code : 200
     * data : {"treejson":[{"children":[{"children":[],"name":"通风1","id":10}],"name":"顶板","id":1},{"children":[],"name":"通风","id":2},{"children":[],"name":"瓦斯","id":3},{"children":[],"name":"煤尘","id":4},{"children":[],"name":"机电","id":5},{"children":[],"name":"运输","id":6},{"children":[],"name":"火灾","id":7},{"children":[],"name":"水灾","id":8},{"children":[],"name":"其他","id":9}]}
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
        private ArrayList<TreejsonBean> treejson;

        public ArrayList<TreejsonBean> getTreejson() {
            return treejson;
        }

        public void setTreejson(ArrayList<TreejsonBean> treejson) {
            this.treejson = treejson;
        }

        public static class TreejsonBean {
            /**
             * children : [{"children":[],"name":"通风1","id":10}]
             * name : 顶板
             * id : 1
             */

            private String name;
            private int id;
            private ArrayList<ChildrenBean> children;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public ArrayList<ChildrenBean> getChildren() {
                return children;
            }

            public void setChildren(ArrayList<ChildrenBean> children) {
                this.children = children;
            }

            public static class ChildrenBean {
                /**
                 * children : []
                 * name : 通风1
                 * id : 10
                 */

                private String name;
                private int id;
                private List<?> children;

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
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
}
