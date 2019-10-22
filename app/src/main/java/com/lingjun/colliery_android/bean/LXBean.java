package com.lingjun.colliery_android.bean;

import java.util.List;

/**
 * Created by shurrikann on 2018/12/17.
 */

public class LXBean {

    /**
     * msg : 成功
     * code : 200
     * data : null
     * resultMaps : [{"keyword":{"name":"台账","keyId":"29"}},{"keyword":{"name":"台账","keyId":"29"}}]
     */

    private String msg;
    private String code;
    private Object data;
    private List<ResultMapsBean> resultMaps;

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

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public List<ResultMapsBean> getResultMaps() {
        return resultMaps;
    }

    public void setResultMaps(List<ResultMapsBean> resultMaps) {
        this.resultMaps = resultMaps;
    }

    public static class ResultMapsBean {
        /**
         * keyword : {"name":"台账","keyId":"29"}
         */

        private KeywordBean keyword;
        boolean state;

        public boolean isState() {
            return state;
        }

        public void setState(boolean state) {
            this.state = state;
        }

        public KeywordBean getKeyword() {
            return keyword;
        }

        public void setKeyword(KeywordBean keyword) {
            this.keyword = keyword;
        }

        public static class KeywordBean {
            /**
             * name : 台账
             * keyId : 29
             */

            private String name;
            private String keyId;


            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getKeyId() {
                return keyId;
            }

            public void setKeyId(String keyId) {
                this.keyId = keyId;
            }
        }
    }
}
