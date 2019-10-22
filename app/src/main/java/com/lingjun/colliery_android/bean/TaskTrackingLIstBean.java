package com.lingjun.colliery_android.bean;

import java.util.List;

/**
 * 作者: zengtao
 * 时间: 2019/2/26  16:38.
 * 注释:
 */
public class TaskTrackingLIstBean {

    /**
     * msg : 成功
     * code : 200
     * data : null
     * resultMaps : [{"keys":"4;6;7;8;9","description":"354","keysname":"工作类,顶板,通风,瓦斯,煤尘","borrowDay":0,"number":"333","borrowTime":1551166777000,"name":"333","state":"1","id":135,"stdname":"3333","taskId":8939,"fileList":[{"id":8926,"filename":"1551080095100.png","uri":"/upload/1551080095100.png","fileType":3,"personal":false,"ownerId":null,"createdTime":1551080095000,"modifiedTime":1551080095000,"keywords":null,"data":null,"cacheUri":null,"isSave":null},{"id":8927,"filename":"1551080369140.png","uri":"/upload/1551080369140.png","fileType":3,"personal":false,"ownerId":null,"createdTime":1551080369000,"modifiedTime":1551080369000,"keywords":null,"data":null,"cacheUri":null,"isSave":null}],"timestamp":1551145075000}]
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
         * keys : 4;6;7;8;9
         * description : 354
         * keysname : 工作类,顶板,通风,瓦斯,煤尘
         * borrowDay : 0
         * number : 333
         * borrowTime : 1551166777000
         * name : 333
         * state : 1
         * id : 135
         * stdname : 3333
         * taskId : 8939
         * fileList : [{"id":8926,"filename":"1551080095100.png","uri":"/upload/1551080095100.png","fileType":3,"personal":false,"ownerId":null,"createdTime":1551080095000,"modifiedTime":1551080095000,"keywords":null,"data":null,"cacheUri":null,"isSave":null},{"id":8927,"filename":"1551080369140.png","uri":"/upload/1551080369140.png","fileType":3,"personal":false,"ownerId":null,"createdTime":1551080369000,"modifiedTime":1551080369000,"keywords":null,"data":null,"cacheUri":null,"isSave":null}]
         * timestamp : 1551145075000
         */

        private String keys;
        private String description;
        private String keysname;
        private int borrowDay;
        private String number;
        private long borrowTime;
        private String name;
        private String state;
        private int id;
        private String stdname;
        private int taskId;
        private long timestamp;
        private List<FileListBean> fileList;

        public String getKeys() {
            return keys;
        }

        public void setKeys(String keys) {
            this.keys = keys;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getKeysname() {
            return keysname;
        }

        public void setKeysname(String keysname) {
            this.keysname = keysname;
        }

        public int getBorrowDay() {
            return borrowDay;
        }

        public void setBorrowDay(int borrowDay) {
            this.borrowDay = borrowDay;
        }

        public String getNumber() {
            return number;
        }

        public void setNumber(String number) {
            this.number = number;
        }

        public long getBorrowTime() {
            return borrowTime;
        }

        public void setBorrowTime(long borrowTime) {
            this.borrowTime = borrowTime;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getStdname() {
            return stdname;
        }

        public void setStdname(String stdname) {
            this.stdname = stdname;
        }

        public int getTaskId() {
            return taskId;
        }

        public void setTaskId(int taskId) {
            this.taskId = taskId;
        }

        public long getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(long timestamp) {
            this.timestamp = timestamp;
        }

        public List<FileListBean> getFileList() {
            return fileList;
        }

        public void setFileList(List<FileListBean> fileList) {
            this.fileList = fileList;
        }

        public static class FileListBean {
            /**
             * id : 8926
             * filename : 1551080095100.png
             * uri : /upload/1551080095100.png
             * fileType : 3
             * personal : false
             * ownerId : null
             * createdTime : 1551080095000
             * modifiedTime : 1551080095000
             * keywords : null
             * data : null
             * cacheUri : null
             * isSave : null
             */

            private int id;
            private String filename;
            private String uri;
            private int fileType;
            private boolean personal;
            private Object ownerId;
            private long createdTime;
            private long modifiedTime;
            private Object keywords;
            private Object data;
            private Object cacheUri;
            private Object isSave;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getFilename() {
                return filename;
            }

            public void setFilename(String filename) {
                this.filename = filename;
            }

            public String getUri() {
                return uri;
            }

            public void setUri(String uri) {
                this.uri = uri;
            }

            public int getFileType() {
                return fileType;
            }

            public void setFileType(int fileType) {
                this.fileType = fileType;
            }

            public boolean isPersonal() {
                return personal;
            }

            public void setPersonal(boolean personal) {
                this.personal = personal;
            }

            public Object getOwnerId() {
                return ownerId;
            }

            public void setOwnerId(Object ownerId) {
                this.ownerId = ownerId;
            }

            public long getCreatedTime() {
                return createdTime;
            }

            public void setCreatedTime(long createdTime) {
                this.createdTime = createdTime;
            }

            public long getModifiedTime() {
                return modifiedTime;
            }

            public void setModifiedTime(long modifiedTime) {
                this.modifiedTime = modifiedTime;
            }

            public Object getKeywords() {
                return keywords;
            }

            public void setKeywords(Object keywords) {
                this.keywords = keywords;
            }

            public Object getData() {
                return data;
            }

            public void setData(Object data) {
                this.data = data;
            }

            public Object getCacheUri() {
                return cacheUri;
            }

            public void setCacheUri(Object cacheUri) {
                this.cacheUri = cacheUri;
            }

            public Object getIsSave() {
                return isSave;
            }

            public void setIsSave(Object isSave) {
                this.isSave = isSave;
            }
        }
    }
}
