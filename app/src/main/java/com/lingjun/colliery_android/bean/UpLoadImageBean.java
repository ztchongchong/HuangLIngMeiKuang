package com.lingjun.colliery_android.bean;

import java.util.List;

/**
 * Created by nefa on 2018/11/17.
 */

public class UpLoadImageBean {


    /**
     * msg : 上传成功
     * code : 200
     * data : null
     * resultMaps : [{"fileName":"1542435542760.jpeg","url":"http://127.0.0.1:8080/safety/upload/1542435542760.jpeg","fileId":1642,"status":true}]
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
         * fileName : 1542435542760.jpeg
         * url : http://127.0.0.1:8080/safety/upload/1542435542760.jpeg
         * fileId : 1642
         * status : true
         */

        private String fileName;
        private String url;
        private int fileId;
        private boolean status;

        public int getCurCode() {
            return curCode;
        }

        public void setCurCode(int curCode) {
            this.curCode = curCode;
        }

        private int curCode;

        public String getFileName() {
            return fileName;
        }

        public void setFileName(String fileName) {
            this.fileName = fileName;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public int getFileId() {
            return fileId;
        }

        public void setFileId(int fileId) {
            this.fileId = fileId;
        }

        public boolean isStatus() {
            return status;
        }

        public void setStatus(boolean status) {
            this.status = status;
        }
    }
}
