package com.lingjun.colliery_android.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 作者: lihuan
 * 时间: 2018/12/21 9:51
 * 说明:
 */
public class DocumentInfoBean {
    /**
     * msg : 成功
     * code : 200
     * data : {"page":{"pageNo":1,"pageSize":6,"totalRecord":48,"totalPage":8,"results":[{"id":"","catalogId":"","number":"","name":"","stdname":"","keys":"","timestamp":"","state":0,"borrowStatus":0,"fileData":{"files":[{"sysFiles":{"id":3311,"filename":"","uri":"","fileType":0}}]},"editionKeysName":[{"id":"","name":""}]}]}}
     */

    private String msg;
    private String code;
    private DataBean data;

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

    public static class DataBean {
        /**
         * page : {"pageNo":1,"pageSize":6,"totalRecord":48,"totalPage":8,"results":[{"id":"","catalogId":"","number":"","name":"","stdname":"","keys":"","timestamp":"","state":0,"borrowStatus":0,"fileData":{"files":[{"sysFiles":{"id":3311,"filename":"","uri":"","fileType":0}}]},"editionKeysName":[{"id":"","name":""}]}]}
         */

        private PageBean page;

        public PageBean getPage() {
            return page;
        }

        public void setPage(PageBean page) {
            this.page = page;
        }

        public static class PageBean {
            /**
             * pageNo : 1
             * pageSize : 6
             * totalRecord : 48
             * totalPage : 8
             * results : [{"id":"","catalogId":"","number":"","name":"","stdname":"","keys":"","timestamp":"","state":0,"borrowStatus":0,"fileData":{"files":[{"sysFiles":{"id":3311,"filename":"","uri":"","fileType":0}}]},"editionKeysName":[{"id":"","name":""}]}]
             */

            private int pageNo;
            private int pageSize;
            private int totalRecord;
            private int totalPage;
            private ArrayList<ResultsBean> results;

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

            public ArrayList<ResultsBean> getResults() {
                return results;
            }

            public void setResults(ArrayList<ResultsBean> results) {
                this.results = results;
            }

            public static class ResultsBean implements Serializable{
                /**
                 * id :
                 * catalogId :
                 * number :
                 * name :
                 * stdname :
                 * keys :
                 * timestamp :
                 * state : 0
                 * borrowStatus : 0
                 * fileData : {"files":[{"sysFiles":{"id":3311,"filename":"","uri":"","fileType":0}}]}
                 * editionKeysName : [{"id":"","name":""}]
                 */

                private String id;
                private String catalogId;
                private String number;
                private String name;
                private String stdname;
                private String keys;
                private long timestamp;
                private int state;
                private int borrowStatus;
                private FileDataBean fileData;
                private List<EditionKeysNameBean> editionKeysName;
                private boolean isOpen = false;

                public boolean isOpen() {
                    return isOpen;
                }

                public void setOpen(boolean open) {
                    isOpen = open;
                }

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }

                public String getCatalogId() {
                    return catalogId;
                }

                public void setCatalogId(String catalogId) {
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

                public List<EditionKeysNameBean> getEditionKeysName() {
                    return editionKeysName;
                }

                public void setEditionKeysName(List<EditionKeysNameBean> editionKeysName) {
                    this.editionKeysName = editionKeysName;
                }

                public static class FileDataBean implements Serializable{
                    private ArrayList<FilesBean> files;

                    public ArrayList<FilesBean> getFiles() {
                        return files;
                    }

                    public void setFiles(ArrayList<FilesBean> files) {
                        this.files = files;
                    }

                    public static class FilesBean implements Serializable{
                        /**
                         * sysFiles : {"id":3311,"filename":"","uri":"","fileType":0}
                         */

                        private SysFilesBean sysFiles;

                        public SysFilesBean getSysFiles() {
                            return sysFiles;
                        }

                        public void setSysFiles(SysFilesBean sysFiles) {
                            this.sysFiles = sysFiles;
                        }

                        public static class SysFilesBean implements Serializable{
                            /**
                             * id : 3311
                             * filename :
                             * uri :
                             * fileType : 0
                             */

                            private int id;
                            private String filename;
                            private String uri;
                            private int fileType;

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
                        }
                    }
                }

                public static class EditionKeysNameBean implements Serializable{
                    /**
                     * id :
                     * name :
                     */

                    private String id;
                    private String name;

                    public String getId() {
                        return id;
                    }

                    public void setId(String id) {
                        this.id = id;
                    }

                    public String getName() {
                        return name;
                    }

                    public void setName(String name) {
                        this.name = name;
                    }
                }
            }
        }
    }


//    /**
//     * msg : 成功
//     * code : 200
//     * data : {"page":{"pageNo":1,"pageSize":6,"totalRecord":48,"totalPage":8,"results":[{"id":51,"archiveId":"","version":"","catalogId":17,"number":"","name":"无(现场治理)","stdname":"","keys":"","timestamp":1545232522000,"state":2,"operatorId":"","operatorname":"","borrowStatus":2,"fileData":"","remark":"","description":"","hidden":0,"catalogName":"","borrow":false},{"id":50,"archiveId":null,"version":null,"catalogId":17,"number":null,"name":"无(现场治理)","stdname":null,"keys":"","timestamp":1545232516000,"state":2,"operatorId":null,"operatorname":null,"borrowStatus":2,"fileData":null,"remark":null,"description":null,"hidden":0,"catalogName":null,"borrow":false},{"id":49,"archiveId":null,"version":null,"catalogId":17,"number":null,"name":"无","stdname":null,"keys":"","timestamp":1545232476000,"state":2,"operatorId":null,"operatorname":null,"borrowStatus":2,"fileData":null,"remark":null,"description":null,"hidden":0,"catalogName":null,"borrow":false},{"id":48,"archiveId":null,"version":null,"catalogId":17,"number":null,"name":"无","stdname":null,"keys":"","timestamp":1545232471000,"state":2,"operatorId":null,"operatorname":null,"borrowStatus":2,"fileData":null,"remark":null,"description":null,"hidden":0,"catalogName":null,"borrow":false},{"id":47,"archiveId":null,"version":null,"catalogId":17,"number":null,"name":"1.顶板无离层、无活矸、无鳞片，支护完好，空顶、空帮距符合作业规程规定。2.巷帮无裂缝。","stdname":null,"keys":"","timestamp":1545232039000,"state":2,"operatorId":null,"operatorname":null,"borrowStatus":2,"fileData":null,"remark":null,"description":null,"hidden":0,"catalogName":null,"borrow":false},{"id":41,"archiveId":null,"version":null,"catalogId":17,"number":null,"name":"1.顶板无离层、无活矸、无鳞片，支护完好，空顶、空帮距符合作业规程规定。2.巷帮无裂缝。","stdname":null,"keys":"","timestamp":1545151011000,"state":2,"operatorId":null,"operatorname":null,"borrowStatus":2,"fileData":null,"remark":null,"description":null,"hidden":0,"catalogName":null,"borrow":false}],"params":{"question":"","filekeyList":[],"accreditVal":"","filekey":"","startTime":"","endTime":"","departmentList":"1869,1868,95","userId":95},"resultMaps":[],"dateFormat":""}}
//     * resultMaps : []
//     */
//
//    private String msg;
//    private String code;
//    private DataBean data;
//    private List<?> resultMaps;
//
//    public String getMsg() {
//        return msg;
//    }
//
//    public void setMsg(String msg) {
//        this.msg = msg;
//    }
//
//    public String getCode() {
//        return code;
//    }
//
//    public void setCode(String code) {
//        this.code = code;
//    }
//
//    public DataBean getData() {
//        return data;
//    }
//
//    public void setData(DataBean data) {
//        this.data = data;
//    }
//
//    public List<?> getResultMaps() {
//        return resultMaps;
//    }
//
//    public void setResultMaps(List<?> resultMaps) {
//        this.resultMaps = resultMaps;
//    }
//
//    public static class DataBean {
//        /**
//         * page : {"pageNo":1,"pageSize":6,"totalRecord":48,"totalPage":8,"results":[{"id":51,"archiveId":"","version":"","catalogId":17,"number":"","name":"无(现场治理)","stdname":"","keys":"","timestamp":1545232522000,"state":2,"operatorId":"","operatorname":"","borrowStatus":2,"fileData":"","remark":"","description":"","hidden":0,"catalogName":"","borrow":false},{"id":50,"archiveId":null,"version":null,"catalogId":17,"number":null,"name":"无(现场治理)","stdname":null,"keys":"","timestamp":1545232516000,"state":2,"operatorId":null,"operatorname":null,"borrowStatus":2,"fileData":null,"remark":null,"description":null,"hidden":0,"catalogName":null,"borrow":false},{"id":49,"archiveId":null,"version":null,"catalogId":17,"number":null,"name":"无","stdname":null,"keys":"","timestamp":1545232476000,"state":2,"operatorId":null,"operatorname":null,"borrowStatus":2,"fileData":null,"remark":null,"description":null,"hidden":0,"catalogName":null,"borrow":false},{"id":48,"archiveId":null,"version":null,"catalogId":17,"number":null,"name":"无","stdname":null,"keys":"","timestamp":1545232471000,"state":2,"operatorId":null,"operatorname":null,"borrowStatus":2,"fileData":null,"remark":null,"description":null,"hidden":0,"catalogName":null,"borrow":false},{"id":47,"archiveId":null,"version":null,"catalogId":17,"number":null,"name":"1.顶板无离层、无活矸、无鳞片，支护完好，空顶、空帮距符合作业规程规定。2.巷帮无裂缝。","stdname":null,"keys":"","timestamp":1545232039000,"state":2,"operatorId":null,"operatorname":null,"borrowStatus":2,"fileData":null,"remark":null,"description":null,"hidden":0,"catalogName":null,"borrow":false},{"id":41,"archiveId":null,"version":null,"catalogId":17,"number":null,"name":"1.顶板无离层、无活矸、无鳞片，支护完好，空顶、空帮距符合作业规程规定。2.巷帮无裂缝。","stdname":null,"keys":"","timestamp":1545151011000,"state":2,"operatorId":null,"operatorname":null,"borrowStatus":2,"fileData":null,"remark":null,"description":null,"hidden":0,"catalogName":null,"borrow":false}],"params":{"question":"","filekeyList":[],"accreditVal":"","filekey":"","startTime":"","endTime":"","departmentList":"1869,1868,95","userId":95},"resultMaps":[],"dateFormat":""}
//         */
//
//        private PageBean page;
//
//        public PageBean getPage() {
//            return page;
//        }
//
//        public void setPage(PageBean page) {
//            this.page = page;
//        }
//
//        public static class PageBean {
//            /**
//             * pageNo : 1
//             * pageSize : 6
//             * totalRecord : 48
//             * totalPage : 8
//             * results : [{"id":51,"archiveId":"","version":"","catalogId":17,"number":"","name":"无(现场治理)","stdname":"","keys":"","timestamp":1545232522000,"state":2,"operatorId":"","operatorname":"","borrowStatus":2,"fileData":"","remark":"","description":"","hidden":0,"catalogName":"","borrow":false},{"id":50,"archiveId":null,"version":null,"catalogId":17,"number":null,"name":"无(现场治理)","stdname":null,"keys":"","timestamp":1545232516000,"state":2,"operatorId":null,"operatorname":null,"borrowStatus":2,"fileData":null,"remark":null,"description":null,"hidden":0,"catalogName":null,"borrow":false},{"id":49,"archiveId":null,"version":null,"catalogId":17,"number":null,"name":"无","stdname":null,"keys":"","timestamp":1545232476000,"state":2,"operatorId":null,"operatorname":null,"borrowStatus":2,"fileData":null,"remark":null,"description":null,"hidden":0,"catalogName":null,"borrow":false},{"id":48,"archiveId":null,"version":null,"catalogId":17,"number":null,"name":"无","stdname":null,"keys":"","timestamp":1545232471000,"state":2,"operatorId":null,"operatorname":null,"borrowStatus":2,"fileData":null,"remark":null,"description":null,"hidden":0,"catalogName":null,"borrow":false},{"id":47,"archiveId":null,"version":null,"catalogId":17,"number":null,"name":"1.顶板无离层、无活矸、无鳞片，支护完好，空顶、空帮距符合作业规程规定。2.巷帮无裂缝。","stdname":null,"keys":"","timestamp":1545232039000,"state":2,"operatorId":null,"operatorname":null,"borrowStatus":2,"fileData":null,"remark":null,"description":null,"hidden":0,"catalogName":null,"borrow":false},{"id":41,"archiveId":null,"version":null,"catalogId":17,"number":null,"name":"1.顶板无离层、无活矸、无鳞片，支护完好，空顶、空帮距符合作业规程规定。2.巷帮无裂缝。","stdname":null,"keys":"","timestamp":1545151011000,"state":2,"operatorId":null,"operatorname":null,"borrowStatus":2,"fileData":null,"remark":null,"description":null,"hidden":0,"catalogName":null,"borrow":false}]
//             * params : {"question":"","filekeyList":[],"accreditVal":"","filekey":"","startTime":"","endTime":"","departmentList":"1869,1868,95","userId":95}
//             * resultMaps : []
//             * dateFormat :
//             */
//
//            private int pageNo;
//            private int pageSize;
//            private int totalRecord;
//            private int totalPage;
//            private ParamsBean params;
//            private String dateFormat;
//            private ArrayList<ResultsBean> results;
//            private List<?> resultMaps;
//
//            public int getPageNo() {
//                return pageNo;
//            }
//
//            public void setPageNo(int pageNo) {
//                this.pageNo = pageNo;
//            }
//
//            public int getPageSize() {
//                return pageSize;
//            }
//
//            public void setPageSize(int pageSize) {
//                this.pageSize = pageSize;
//            }
//
//            public int getTotalRecord() {
//                return totalRecord;
//            }
//
//            public void setTotalRecord(int totalRecord) {
//                this.totalRecord = totalRecord;
//            }
//
//            public int getTotalPage() {
//                return totalPage;
//            }
//
//            public void setTotalPage(int totalPage) {
//                this.totalPage = totalPage;
//            }
//
//            public ParamsBean getParams() {
//                return params;
//            }
//
//            public void setParams(ParamsBean params) {
//                this.params = params;
//            }
//
//            public String getDateFormat() {
//                return dateFormat;
//            }
//
//            public void setDateFormat(String dateFormat) {
//                this.dateFormat = dateFormat;
//            }
//
//            public ArrayList<ResultsBean> getResults() {
//                return results;
//            }
//
//            public void setResults(ArrayList<ResultsBean> results) {
//                this.results = results;
//            }
//
//            public List<?> getResultMaps() {
//                return resultMaps;
//            }
//
//            public void setResultMaps(List<?> resultMaps) {
//                this.resultMaps = resultMaps;
//            }
//
//            public static class ParamsBean {
//                /**
//                 * question :
//                 * filekeyList : []
//                 * accreditVal :
//                 * filekey :
//                 * startTime :
//                 * endTime :
//                 * departmentList : 1869,1868,95
//                 * userId : 95
//                 */
//
//                private String question;
//                private String accreditVal;
//                private String filekey;
//                private String startTime;
//                private String endTime;
//                private String departmentList;
//                private int userId;
//                private List<?> filekeyList;
//
//                public String getQuestion() {
//                    return question;
//                }
//
//                public void setQuestion(String question) {
//                    this.question = question;
//                }
//
//                public String getAccreditVal() {
//                    return accreditVal;
//                }
//
//                public void setAccreditVal(String accreditVal) {
//                    this.accreditVal = accreditVal;
//                }
//
//                public String getFilekey() {
//                    return filekey;
//                }
//
//                public void setFilekey(String filekey) {
//                    this.filekey = filekey;
//                }
//
//                public String getStartTime() {
//                    return startTime;
//                }
//
//                public void setStartTime(String startTime) {
//                    this.startTime = startTime;
//                }
//
//                public String getEndTime() {
//                    return endTime;
//                }
//
//                public void setEndTime(String endTime) {
//                    this.endTime = endTime;
//                }
//
//                public String getDepartmentList() {
//                    return departmentList;
//                }
//
//                public void setDepartmentList(String departmentList) {
//                    this.departmentList = departmentList;
//                }
//
//                public int getUserId() {
//                    return userId;
//                }
//
//                public void setUserId(int userId) {
//                    this.userId = userId;
//                }
//
//                public List<?> getFilekeyList() {
//                    return filekeyList;
//                }
//
//                public void setFilekeyList(List<?> filekeyList) {
//                    this.filekeyList = filekeyList;
//                }
//            }
//
//            public static class ResultsBean {
//                /**
//                 * id : 51
//                 * archiveId :
//                 * version :
//                 * catalogId : 17
//                 * number :
//                 * name : 无(现场治理)
//                 * stdname :
//                 * keys :
//                 * timestamp : 1545232522000
//                 * state : 2
//                 * operatorId :
//                 * operatorname :
//                 * borrowStatus : 2
//                 * fileData :
//                 * remark :
//                 * description :
//                 * hidden : 0
//                 * catalogName :
//                 * borrow : false
//                 */
//
//                private int id;
//                private String archiveId;
//                private String version;
//                private int catalogId;
//                private String number;
//                private String name;
//                private String stdname;
//                private String keys;
//                private long timestamp;
//                private int state;
//                private String operatorId;
//                private String operatorname;
//                private int borrowStatus;
//                private String fileData;
//                private String remark;
//                private String description;
//                private int hidden;
//                private String catalogName;
//                private boolean borrow;
//
//                public int getId() {
//                    return id;
//                }
//
//                public void setId(int id) {
//                    this.id = id;
//                }
//
//                public String getArchiveId() {
//                    return archiveId;
//                }
//
//                public void setArchiveId(String archiveId) {
//                    this.archiveId = archiveId;
//                }
//
//                public String getVersion() {
//                    return version;
//                }
//
//                public void setVersion(String version) {
//                    this.version = version;
//                }
//
//                public int getCatalogId() {
//                    return catalogId;
//                }
//
//                public void setCatalogId(int catalogId) {
//                    this.catalogId = catalogId;
//                }
//
//                public String getNumber() {
//                    return number;
//                }
//
//                public void setNumber(String number) {
//                    this.number = number;
//                }
//
//                public String getName() {
//                    return name;
//                }
//
//                public void setName(String name) {
//                    this.name = name;
//                }
//
//                public String getStdname() {
//                    return stdname;
//                }
//
//                public void setStdname(String stdname) {
//                    this.stdname = stdname;
//                }
//
//                public String getKeys() {
//                    return keys;
//                }
//
//                public void setKeys(String keys) {
//                    this.keys = keys;
//                }
//
//                public long getTimestamp() {
//                    return timestamp;
//                }
//
//                public void setTimestamp(long timestamp) {
//                    this.timestamp = timestamp;
//                }
//
//                public int getState() {
//                    return state;
//                }
//
//                public void setState(int state) {
//                    this.state = state;
//                }
//
//                public String getOperatorId() {
//                    return operatorId;
//                }
//
//                public void setOperatorId(String operatorId) {
//                    this.operatorId = operatorId;
//                }
//
//                public String getOperatorname() {
//                    return operatorname;
//                }
//
//                public void setOperatorname(String operatorname) {
//                    this.operatorname = operatorname;
//                }
//
//                public int getBorrowStatus() {
//                    return borrowStatus;
//                }
//
//                public void setBorrowStatus(int borrowStatus) {
//                    this.borrowStatus = borrowStatus;
//                }
//
//                public String getFileData() {
//                    return fileData;
//                }
//
//                public void setFileData(String fileData) {
//                    this.fileData = fileData;
//                }
//
//                public String getRemark() {
//                    return remark;
//                }
//
//                public void setRemark(String remark) {
//                    this.remark = remark;
//                }
//
//                public String getDescription() {
//                    return description;
//                }
//
//                public void setDescription(String description) {
//                    this.description = description;
//                }
//
//                public int getHidden() {
//                    return hidden;
//                }
//
//                public void setHidden(int hidden) {
//                    this.hidden = hidden;
//                }
//
//                public String getCatalogName() {
//                    return catalogName;
//                }
//
//                public void setCatalogName(String catalogName) {
//                    this.catalogName = catalogName;
//                }
//
//                public boolean isBorrow() {
//                    return borrow;
//                }
//
//                public void setBorrow(boolean borrow) {
//                    this.borrow = borrow;
//                }
//            }
//        }
//    }
}
