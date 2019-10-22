package com.lingjun.colliery_android.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者: lihuan
 * 时间: 2018/12/24 13:50
 * 说明:
 */
public class BorrowInfoBean {

    /**
     * msg : 成功
     * code : 200
     * data : {"pageCount":1,"count":1,"pageSize":10,"pageNum":1}
     * resultMaps : [{"keys":"10;11;26","borrowState":"2","taskStateFlag":"已同意","returnTime":1546016009000,"returnDay":"3天","number":"yhpc_2018121900005","name":"无(现场治理)","keysName":"机电,运输,文献","editionTime":1545232522000,"id":51,"stdname":"无(现场治理)","taskId":3398,"fileList":[{"id":3311,"filename":"无(现场治理)","uri":"/pluploadDir/1545185714108.pdf","fileType":3,"personal":false,"ownerId":"","createdTime":1545232460000,"modifiedTime":1545232461000,"keywords":"","data":"","cacheUri":"/pluploadDir/1545185714108.swf","isSave":""}]}]
     */

    private String msg;
    private String code;
    private DataBean data;
    private ArrayList<ResultMapsBean> resultMaps;

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

    public ArrayList<ResultMapsBean> getResultMaps() {
        return resultMaps;
    }

    public void setResultMaps(ArrayList<ResultMapsBean> resultMaps) {
        this.resultMaps = resultMaps;
    }

    public static class DataBean {
        /**
         * pageCount : 1
         * count : 1
         * pageSize : 10
         * pageNum : 1
         */

        private int pageCount;
        private int count;
        private int pageSize;
        private int pageNum;

        public int getPageCount() {
            return pageCount;
        }

        public void setPageCount(int pageCount) {
            this.pageCount = pageCount;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public int getPageSize() {
            return pageSize;
        }

        public void setPageSize(int pageSize) {
            this.pageSize = pageSize;
        }

        public int getPageNum() {
            return pageNum;
        }

        public void setPageNum(int pageNum) {
            this.pageNum = pageNum;
        }
    }

    public static class ResultMapsBean {
        /**
         * keys : 10;11;26
         * borrowState : 2
         * taskStateFlag : 已同意
         * returnTime : 1546016009000
         * returnDay : 3天
         * number : yhpc_2018121900005
         * name : 无(现场治理)
         * keysName : 机电,运输,文献
         * editionTime : 1545232522000
         * id : 51
         * stdname : 无(现场治理)
         * taskId : 3398
         * fileList : [{"id":3311,"filename":"无(现场治理)","uri":"/pluploadDir/1545185714108.pdf","fileType":3,"personal":false,"ownerId":"","createdTime":1545232460000,"modifiedTime":1545232461000,"keywords":"","data":"","cacheUri":"/pluploadDir/1545185714108.swf","isSave":""}]
         */

        private String keys;
        private String borrowState;
        private String taskStateFlag; //借阅状态
        private long returnTime; //返还时间
        private String returnDay;
        private String number; //编号
        private String name; //资料名称
        private String keysName; //标签(清单列表)
        private long editionTime; //资料创建时间
        private int id; //资料id
        private String stdname; //规范
        private int taskId; //借阅id
        private int status; //借阅状态
        private String description; //借阅说明
        private int borrowDay; //借阅天数
        private String keysname; // 标签(详情)
        private long borrowTime;
        private long timestamp;
        private boolean isOpen = false; //本地字段，记录是否折叠内容

        public boolean isOpen() {
            return isOpen;
        }

        public void setOpen(boolean open) {
            isOpen = open;
        }

        private ArrayList<FileListBean> fileList;

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public int getBorrowDay() {
            return borrowDay;
        }

        public void setBorrowDay(int borrowDay) {
            this.borrowDay = borrowDay;
        }

        public String getKeysname() {
            return keysname;
        }

        public void setKeysname(String keysname) {
            this.keysname = keysname;
        }

        public long getBorrowTime() {
            return borrowTime;
        }

        public void setBorrowTime(long borrowTime) {
            this.borrowTime = borrowTime;
        }

        public long getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(long timestamp) {
            this.timestamp = timestamp;
        }

        public String getKeys() {
            return keys;
        }

        public void setKeys(String keys) {
            this.keys = keys;
        }

        public String getBorrowState() {
            return borrowState;
        }

        public void setBorrowState(String borrowState) {
            this.borrowState = borrowState;
        }

        public String getTaskStateFlag() {
            return taskStateFlag;
        }

        public void setTaskStateFlag(String taskStateFlag) {
            this.taskStateFlag = taskStateFlag;
        }

        public long getReturnTime() {
            return returnTime;
        }

        public void setReturnTime(long returnTime) {
            this.returnTime = returnTime;
        }

        public String getReturnDay() {
            return returnDay;
        }

        public void setReturnDay(String returnDay) {
            this.returnDay = returnDay;
        }

        public String getNumber() {
            return number;
        }

        public void setNumber(String number) {
            this.number = number;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getKeysName() {
            return keysName;
        }

        public void setKeysName(String keysName) {
            this.keysName = keysName;
        }

        public long getEditionTime() {
            return editionTime;
        }

        public void setEditionTime(long editionTime) {
            this.editionTime = editionTime;
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

        public ArrayList<FileListBean> getFileList() {
            return fileList;
        }

        public void setFileList(ArrayList<FileListBean> fileList) {
            this.fileList = fileList;
        }

        public static class FileListBean {
            /**
             * id : 3311
             * filename : 无(现场治理)
             * uri : /pluploadDir/1545185714108.pdf
             * fileType : 3
             * personal : false
             * ownerId :
             * createdTime : 1545232460000
             * modifiedTime : 1545232461000
             * keywords :
             * data :
             * cacheUri : /pluploadDir/1545185714108.swf
             * isSave :
             */

            private int id;
            private String filename;
            private String uri;
            private int fileType;
            private boolean personal;
            private String ownerId;
            private long createdTime;
            private long modifiedTime;
            private String keywords;
            private String data;
            private String cacheUri;
            private String isSave;

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

            public String getOwnerId() {
                return ownerId;
            }

            public void setOwnerId(String ownerId) {
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

            public String getKeywords() {
                return keywords;
            }

            public void setKeywords(String keywords) {
                this.keywords = keywords;
            }

            public String getData() {
                return data;
            }

            public void setData(String data) {
                this.data = data;
            }

            public String getCacheUri() {
                return cacheUri;
            }

            public void setCacheUri(String cacheUri) {
                this.cacheUri = cacheUri;
            }

            public String getIsSave() {
                return isSave;
            }

            public void setIsSave(String isSave) {
                this.isSave = isSave;
            }
        }
    }
}
