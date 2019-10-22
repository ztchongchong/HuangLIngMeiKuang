package com.lingjun.colliery_android.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by shurrikann on 2018/12/20.
 */

public class CheckFileBean implements Serializable {

    /**
     * msg : 成功
     * code : 200
     * data : {"page":{"pageNo":1,"pageSize":10,"totalRecord":1,"totalPage":1,"results":[{"id":42,"archiveId":3210,"version":1,"catalogId":30,"number":"1","name":"11111111111","stdname":"1111111","keys":"","timestamp":1545034103000,"state":2,"operatorId":95,"operatorname":"孔德昊","borrowStatus":0,"fileData":{"stdfileEditionDocumentList":[{"editionId":42,"contentId":3209,"sysFiles":{"id":3209,"filename":"timg (2).jpg","uri":null,"fileType":null,"personal":false,"ownerId":null,"createdTime":null,"modifiedTime":null,"keywords":null,"data":null,"cacheUri":null,"isSave":null},"down":false,"show":false,"send":false}]},"remark":null,"description":"111","hidden":0,"catalogName":null,"borrow":false}],"params":{"itemId":2,"catalogId":"","searchstr":"","endtime":"","starttime":"","brand":""},"resultMaps":[],"dateFormat":""}}
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

    public static class DataBean implements Serializable {
        /**
         * page : {"pageNo":1,"pageSize":10,"totalRecord":1,"totalPage":1,"results":[{"id":42,"archiveId":3210,"version":1,"catalogId":30,"number":"1","name":"11111111111","stdname":"1111111","keys":"","timestamp":1545034103000,"state":2,"operatorId":95,"operatorname":"孔德昊","borrowStatus":0,"fileData":{"stdfileEditionDocumentList":[{"editionId":42,"contentId":3209,"sysFiles":{"id":3209,"filename":"timg (2).jpg","uri":null,"fileType":null,"personal":false,"ownerId":null,"createdTime":null,"modifiedTime":null,"keywords":null,"data":null,"cacheUri":null,"isSave":null},"down":false,"show":false,"send":false}]},"remark":null,"description":"111","hidden":0,"catalogName":null,"borrow":false}],"params":{"itemId":2,"catalogId":"","searchstr":"","endtime":"","starttime":"","brand":""},"resultMaps":[],"dateFormat":""}
         */

        private PageBean page;

        public PageBean getPage() {
            return page;
        }

        public void setPage(PageBean page) {
            this.page = page;
        }

        public static class PageBean implements Serializable {
            /**
             * pageNo : 1
             * pageSize : 10
             * totalRecord : 1
             * totalPage : 1
             * results : [{"id":42,"archiveId":3210,"version":1,"catalogId":30,"number":"1","name":"11111111111","stdname":"1111111","keys":"","timestamp":1545034103000,"state":2,"operatorId":95,"operatorname":"孔德昊","borrowStatus":0,"fileData":{"stdfileEditionDocumentList":[{"editionId":42,"contentId":3209,"sysFiles":{"id":3209,"filename":"timg (2).jpg","uri":null,"fileType":null,"personal":false,"ownerId":null,"createdTime":null,"modifiedTime":null,"keywords":null,"data":null,"cacheUri":null,"isSave":null},"down":false,"show":false,"send":false}]},"remark":null,"description":"111","hidden":0,"catalogName":null,"borrow":false}]
             * params : {"itemId":2,"catalogId":"","searchstr":"","endtime":"","starttime":"","brand":""}
             * resultMaps : []
             * dateFormat :
             */

            private int pageNo;
            private int pageSize;
            private int totalRecord;
            private int totalPage;
            private ParamsBean params;
            private String dateFormat;
            private List<ResultsBean> results;
            private List<?> resultMaps;

            public int getPageNo() {
                return pageNo;
            }

            public void setPageNo(int pageNo) {
                this.pageNo = pageNo;
            }

            public int getPageSize() {
                return pageSize;
            }

            public void setPageSize(int pageSize) {
                this.pageSize = pageSize;
            }

            public int getTotalRecord() {
                return totalRecord;
            }

            public void setTotalRecord(int totalRecord) {
                this.totalRecord = totalRecord;
            }

            public int getTotalPage() {
                return totalPage;
            }

            public void setTotalPage(int totalPage) {
                this.totalPage = totalPage;
            }

            public ParamsBean getParams() {
                return params;
            }

            public void setParams(ParamsBean params) {
                this.params = params;
            }

            public String getDateFormat() {
                return dateFormat;
            }

            public void setDateFormat(String dateFormat) {
                this.dateFormat = dateFormat;
            }

            public List<ResultsBean> getResults() {
                return results;
            }

            public void setResults(List<ResultsBean> results) {
                this.results = results;
            }

            public List<?> getResultMaps() {
                return resultMaps;
            }

            public void setResultMaps(List<?> resultMaps) {
                this.resultMaps = resultMaps;
            }

            public static class ParamsBean implements Serializable {
                /**
                 * itemId : 2
                 * catalogId :
                 * searchstr :
                 * endtime :
                 * starttime :
                 * brand :
                 */

                private int itemId;
                private String catalogId;
                private String searchstr;
                private String endtime;
                private String starttime;
                private String brand;

                public int getItemId() {
                    return itemId;
                }

                public void setItemId(int itemId) {
                    this.itemId = itemId;
                }

                public String getCatalogId() {
                    return catalogId;
                }

                public void setCatalogId(String catalogId) {
                    this.catalogId = catalogId;
                }

                public String getSearchstr() {
                    return searchstr;
                }

                public void setSearchstr(String searchstr) {
                    this.searchstr = searchstr;
                }

                public String getEndtime() {
                    return endtime;
                }

                public void setEndtime(String endtime) {
                    this.endtime = endtime;
                }

                public String getStarttime() {
                    return starttime;
                }

                public void setStarttime(String starttime) {
                    this.starttime = starttime;
                }

                public String getBrand() {
                    return brand;
                }

                public void setBrand(String brand) {
                    this.brand = brand;
                }
            }

            public static class ResultsBean implements Serializable {
                /**
                 * id : 42
                 * archiveId : 3210
                 * version : 1
                 * catalogId : 30
                 * number : 1
                 * name : 11111111111
                 * stdname : 1111111
                 * keys :
                 * timestamp : 1545034103000
                 * state : 2
                 * operatorId : 95
                 * operatorname : 孔德昊
                 * borrowStatus : 0
                 * fileData : {"stdfileEditionDocumentList":[{"editionId":42,"contentId":3209,"sysFiles":{"id":3209,"filename":"timg (2).jpg","uri":null,"fileType":null,"personal":false,"ownerId":null,"createdTime":null,"modifiedTime":null,"keywords":null,"data":null,"cacheUri":null,"isSave":null},"down":false,"show":false,"send":false}]}
                 * remark : null
                 * description : 111
                 * hidden : 0
                 * catalogName : null
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
                private Object remark;
                private String description;
                private int hidden;
                private Object catalogName;
                private boolean borrow;
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

                public Object getRemark() {
                    return remark;
                }

                public void setRemark(Object remark) {
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

                public Object getCatalogName() {
                    return catalogName;
                }

                public void setCatalogName(Object catalogName) {
                    this.catalogName = catalogName;
                }

                public boolean isBorrow() {
                    return borrow;
                }

                public void setBorrow(boolean borrow) {
                    this.borrow = borrow;
                }

                public static class FileDataBean implements Serializable {
                    private List<StdfileEditionDocumentListBean> stdfileEditionDocumentList;

                    public List<StdfileEditionDocumentListBean> getStdfileEditionDocumentList() {
                        return stdfileEditionDocumentList;
                    }

                    public void setStdfileEditionDocumentList(List<StdfileEditionDocumentListBean> stdfileEditionDocumentList) {
                        this.stdfileEditionDocumentList = stdfileEditionDocumentList;
                    }

                    public static class StdfileEditionDocumentListBean implements Serializable {
                        /**
                         * editionId : 42
                         * contentId : 3209
                         * sysFiles : {"id":3209,"filename":"timg (2).jpg","uri":null,"fileType":null,"personal":false,"ownerId":null,"createdTime":null,"modifiedTime":null,"keywords":null,"data":null,"cacheUri":null,"isSave":null}
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
                             * id : 3209
                             * filename : timg (2).jpg
                             * uri : null
                             * fileType : null
                             * personal : false
                             * ownerId : null
                             * createdTime : null
                             * modifiedTime : null
                             * keywords : null
                             * data : null
                             * cacheUri : null
                             * isSave : null
                             */

                            private int id;
                            private String filename;
                            private Object uri;
                            private Object fileType;
                            private boolean personal;
                            private Object ownerId;
                            private Object createdTime;
                            private Object modifiedTime;
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

                            public Object getUri() {
                                return uri;
                            }

                            public void setUri(Object uri) {
                                this.uri = uri;
                            }

                            public Object getFileType() {
                                return fileType;
                            }

                            public void setFileType(Object fileType) {
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

                            public Object getCreatedTime() {
                                return createdTime;
                            }

                            public void setCreatedTime(Object createdTime) {
                                this.createdTime = createdTime;
                            }

                            public Object getModifiedTime() {
                                return modifiedTime;
                            }

                            public void setModifiedTime(Object modifiedTime) {
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
            }
        }
    }
}
