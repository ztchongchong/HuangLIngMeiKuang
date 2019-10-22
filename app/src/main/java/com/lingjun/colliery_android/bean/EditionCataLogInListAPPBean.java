package com.lingjun.colliery_android.bean;

import java.io.Serializable;
import java.util.List;

/**
 * 作者: zengtao
 * 时间: 2019/2/22  16:27.
 * 注释:
 */
public class EditionCataLogInListAPPBean implements Serializable {


    /**
     * msg : 成功
     * code : 200
     * data : {"resultStdfileEditionList":[{"id":135,"archiveId":8734,"version":28,"catalogId":40,"number":"333","name":"333","stdname":"3333","keys":"4;6;7;8;9","timestamp":1551145075000,"state":3,"operatorId":95,"operatorname":"孔德昊","borrowStatus":0,"fileData":{"fileList":[{"editionId":135,"contentId":8926,"sysFiles":{"id":8926,"filename":"1551080095100.png","uri":"/upload/1551080095100.png","fileType":3,"personal":false,"ownerId":null,"createdTime":1551080095000,"modifiedTime":1551080095000,"keywords":null,"data":null,"cacheUri":null,"isSave":null},"down":false,"show":false,"send":false},{"editionId":135,"contentId":8927,"sysFiles":{"id":8927,"filename":"1551080369140.png","uri":"/upload/1551080369140.png","fileType":3,"personal":false,"ownerId":null,"createdTime":1551080369000,"modifiedTime":1551080369000,"keywords":null,"data":null,"cacheUri":null,"isSave":null},"down":false,"show":false,"send":false}]},"editionKeysName":[{"id":4,"number":"01","groupId":null,"name":"工作类","remark":"","enabled":true,"selectName":null},{"id":6,"number":"0101","groupId":4,"name":"顶板","remark":"","enabled":true,"selectName":null},{"id":7,"number":"0102","groupId":4,"name":"通风","remark":"","enabled":true,"selectName":null},{"id":8,"number":"0103","groupId":4,"name":"瓦斯","remark":"","enabled":true,"selectName":null},{"id":9,"number":"0104","groupId":4,"name":"煤尘","remark":"","enabled":true,"selectName":null}],"remark":"膜摸","description":"","hidden":0,"catalogName":"2.1.1","borrow":false},{"id":85,"archiveId":8732,"version":1,"catalogId":40,"number":"111","name":"2222","stdname":"111","keys":"8;14;27","timestamp":1550832513000,"state":2,"operatorId":95,"operatorname":"孔德昊","borrowStatus":0,"fileData":{"fileList":[{"editionId":85,"contentId":8731,"sysFiles":{"id":8731,"filename":"RUNNING.txt","uri":"\\pluploadDir/1550832511371.txt","fileType":3,"personal":false,"ownerId":null,"createdTime":1550832511000,"modifiedTime":1550832511000,"keywords":null,"data":null,"cacheUri":null,"isSave":null},"down":false,"show":false,"send":false}]},"editionKeysName":[{"id":8,"number":"0103","groupId":4,"name":"瓦斯","remark":"","enabled":true,"selectName":null},{"id":14,"number":"0109","groupId":4,"name":"其他","remark":"","enabled":true,"selectName":null},{"id":27,"number":"0202","groupId":5,"name":"报表","remark":"","enabled":true,"selectName":null}],"remark":null,"description":"111","hidden":0,"catalogName":"2.1.1","borrow":false},{"id":84,"archiveId":8730,"version":1,"catalogId":40,"number":"111","name":"111","stdname":"11","keys":"9;14;26","timestamp":1550832403000,"state":2,"operatorId":95,"operatorname":"孔德昊","borrowStatus":0,"fileData":{"fileList":[]},"editionKeysName":[{"id":9,"number":"0104","groupId":4,"name":"煤尘","remark":"","enabled":true,"selectName":null},{"id":14,"number":"0109","groupId":4,"name":"其他","remark":"","enabled":true,"selectName":null},{"id":26,"number":"0201","groupId":5,"name":"文献","remark":"","enabled":true,"selectName":null}],"remark":null,"description":"111","hidden":0,"catalogName":"2.1.1","borrow":false}]}
     * resultMaps : [{"catalogName":"2.1.1"},{"catalogIdResult":40}]
     */

    private String msg;
    private String code;
    private DataBean data;
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

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public List<ResultMapsBean> getResultMaps() {
        return resultMaps;
    }

    public void setResultMaps(List<ResultMapsBean> resultMaps) {
        this.resultMaps = resultMaps;
    }

    public static class DataBean implements Serializable{
        private List<ResultStdfileEditionListBean> resultStdfileEditionList;

        public List<ResultStdfileEditionListBean> getResultStdfileEditionList() {
            return resultStdfileEditionList;
        }

        public void setResultStdfileEditionList(List<ResultStdfileEditionListBean> resultStdfileEditionList) {
            this.resultStdfileEditionList = resultStdfileEditionList;
        }

        public static class ResultStdfileEditionListBean implements Serializable {
            /**
             * id : 135
             * archiveId : 8734
             * version : 28
             * catalogId : 40
             * number : 333
             * name : 333
             * stdname : 3333
             * keys : 4;6;7;8;9
             * timestamp : 1551145075000
             * state : 3
             * operatorId : 95
             * operatorname : 孔德昊
             * borrowStatus : 0
             * fileData : {"fileList":[{"editionId":135,"contentId":8926,"sysFiles":{"id":8926,"filename":"1551080095100.png","uri":"/upload/1551080095100.png","fileType":3,"personal":false,"ownerId":null,"createdTime":1551080095000,"modifiedTime":1551080095000,"keywords":null,"data":null,"cacheUri":null,"isSave":null},"down":false,"show":false,"send":false},{"editionId":135,"contentId":8927,"sysFiles":{"id":8927,"filename":"1551080369140.png","uri":"/upload/1551080369140.png","fileType":3,"personal":false,"ownerId":null,"createdTime":1551080369000,"modifiedTime":1551080369000,"keywords":null,"data":null,"cacheUri":null,"isSave":null},"down":false,"show":false,"send":false}]}
             * editionKeysName : [{"id":4,"number":"01","groupId":null,"name":"工作类","remark":"","enabled":true,"selectName":null},{"id":6,"number":"0101","groupId":4,"name":"顶板","remark":"","enabled":true,"selectName":null},{"id":7,"number":"0102","groupId":4,"name":"通风","remark":"","enabled":true,"selectName":null},{"id":8,"number":"0103","groupId":4,"name":"瓦斯","remark":"","enabled":true,"selectName":null},{"id":9,"number":"0104","groupId":4,"name":"煤尘","remark":"","enabled":true,"selectName":null}]
             * remark : 膜摸
             * description :
             * hidden : 0
             * catalogName : 2.1.1
             * borrow : false
             */

            private int id;
            private int archiveId;
            private int version;
            private int catalogId;
            private String number;
            private String name;
            private String stdname;
            private String keys;
            private long timestamp;
            private int state;
            private int operatorId;
            private String operatorname;
            private int borrowStatus;
            private FileDataBean fileData;
            private String remark;
            private String description;
            private int hidden;
            private String catalogName;
            private boolean borrow;
            private List<EditionKeysNameBean> editionKeysName;
            private boolean states;

            public boolean isStates() {
                return states;
            }

            public void setStates(boolean states) {
                this.states = states;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getArchiveId() {
                return archiveId;
            }

            public void setArchiveId(int archiveId) {
                this.archiveId = archiveId;
            }

            public int getVersion() {
                return version;
            }

            public void setVersion(int version) {
                this.version = version;
            }

            public int getCatalogId() {
                return catalogId;
            }

            public void setCatalogId(int catalogId) {
                this.catalogId = catalogId;
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

            public String getStdname() {
                return stdname;
            }

            public void setStdname(String stdname) {
                this.stdname = stdname;
            }

            public String getKeys() {
                return keys;
            }

            public void setKeys(String keys) {
                this.keys = keys;
            }

            public long getTimestamp() {
                return timestamp;
            }

            public void setTimestamp(long timestamp) {
                this.timestamp = timestamp;
            }

            public int getState() {
                return state;
            }

            public void setState(int state) {
                this.state = state;
            }

            public int getOperatorId() {
                return operatorId;
            }

            public void setOperatorId(int operatorId) {
                this.operatorId = operatorId;
            }

            public String getOperatorname() {
                return operatorname;
            }

            public void setOperatorname(String operatorname) {
                this.operatorname = operatorname;
            }

            public int getBorrowStatus() {
                return borrowStatus;
            }

            public void setBorrowStatus(int borrowStatus) {
                this.borrowStatus = borrowStatus;
            }

            public FileDataBean getFileData() {
                return fileData;
            }

            public void setFileData(FileDataBean fileData) {
                this.fileData = fileData;
            }

            public String getRemark() {
                return remark;
            }

            public void setRemark(String remark) {
                this.remark = remark;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public int getHidden() {
                return hidden;
            }

            public void setHidden(int hidden) {
                this.hidden = hidden;
            }

            public String getCatalogName() {
                return catalogName;
            }

            public void setCatalogName(String catalogName) {
                this.catalogName = catalogName;
            }

            public boolean isBorrow() {
                return borrow;
            }

            public void setBorrow(boolean borrow) {
                this.borrow = borrow;
            }

            public List<EditionKeysNameBean> getEditionKeysName() {
                return editionKeysName;
            }

            public void setEditionKeysName(List<EditionKeysNameBean> editionKeysName) {
                this.editionKeysName = editionKeysName;
            }

            public static class FileDataBean implements Serializable{
                private List<FileListBean> fileList;

                public List<FileListBean> getFileList() {
                    return fileList;
                }

                public void setFileList(List<FileListBean> fileList) {
                    this.fileList = fileList;
                }

                public static class FileListBean implements Serializable {
                    /**
                     * editionId : 135
                     * contentId : 8926
                     * sysFiles : {"id":8926,"filename":"1551080095100.png","uri":"/upload/1551080095100.png","fileType":3,"personal":false,"ownerId":null,"createdTime":1551080095000,"modifiedTime":1551080095000,"keywords":null,"data":null,"cacheUri":null,"isSave":null}
                     * down : false
                     * show : false
                     * send : false
                     */

                    private int editionId;
                    private int contentId;
                    private SysFilesBean sysFiles;
                    private boolean down;
                    private boolean show;
                    private boolean send;

                    public int getEditionId() {
                        return editionId;
                    }

                    public void setEditionId(int editionId) {
                        this.editionId = editionId;
                    }

                    public int getContentId() {
                        return contentId;
                    }

                    public void setContentId(int contentId) {
                        this.contentId = contentId;
                    }

                    public SysFilesBean getSysFiles() {
                        return sysFiles;
                    }

                    public void setSysFiles(SysFilesBean sysFiles) {
                        this.sysFiles = sysFiles;
                    }

                    public boolean isDown() {
                        return down;
                    }

                    public void setDown(boolean down) {
                        this.down = down;
                    }

                    public boolean isShow() {
                        return show;
                    }

                    public void setShow(boolean show) {
                        this.show = show;
                    }

                    public boolean isSend() {
                        return send;
                    }

                    public void setSend(boolean send) {
                        this.send = send;
                    }

                    public static class SysFilesBean implements Serializable {
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

            public static class EditionKeysNameBean implements Serializable {
                /**
                 * id : 4
                 * number : 01
                 * groupId : null
                 * name : 工作类
                 * remark :
                 * enabled : true
                 * selectName : null
                 */

                private int id;
                private String number;
                private Object groupId;
                private String name;
                private String remark;
                private boolean enabled;
                private Object selectName;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getNumber() {
                    return number;
                }

                public void setNumber(String number) {
                    this.number = number;
                }

                public Object getGroupId() {
                    return groupId;
                }

                public void setGroupId(Object groupId) {
                    this.groupId = groupId;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getRemark() {
                    return remark;
                }

                public void setRemark(String remark) {
                    this.remark = remark;
                }

                public boolean isEnabled() {
                    return enabled;
                }

                public void setEnabled(boolean enabled) {
                    this.enabled = enabled;
                }

                public Object getSelectName() {
                    return selectName;
                }

                public void setSelectName(Object selectName) {
                    this.selectName = selectName;
                }
            }
        }
    }

    public static class ResultMapsBean implements Serializable {
        /**
         * catalogName : 2.1.1
         * catalogIdResult : 40
         */

        private String catalogName;
        private int catalogIdResult;

        public String getCatalogName() {
            return catalogName;
        }

        public void setCatalogName(String catalogName) {
            this.catalogName = catalogName;
        }

        public int getCatalogIdResult() {
            return catalogIdResult;
        }

        public void setCatalogIdResult(int catalogIdResult) {
            this.catalogIdResult = catalogIdResult;
        }
    }
}
