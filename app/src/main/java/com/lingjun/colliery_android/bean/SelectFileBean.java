package com.lingjun.colliery_android.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者: zengtao
 * 时间: 2019/3/4  9:51.
 * 注释:
 */
public class SelectFileBean {

    /**
     * msg : 成功
     * code : 200
     * data : null
     * resultMaps : [{"content_id":276,"privatefolder_id":1,"name":"diyicie ","privatefolderName":"这是我的文件夹","folderId":1,"fileList":[{"id":276,"filename":"timg.jpg","uri":"\\pluploadDir/1536652057087.jpg","fileType":3,"personal":false,"ownerId":null,"createdTime":1536652057000,"modifiedTime":1536652062000,"keywords":null,"data":null,"cacheUri":"/pluploadDir/1536652057087.swf","isSave":null}]}]
     */

    private String msg;
    private String code;
    private Object data;
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

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public ArrayList<ResultMapsBean> getResultMaps() {
        return resultMaps;
    }

    public void setResultMaps(ArrayList<ResultMapsBean> resultMaps) {
        this.resultMaps = resultMaps;
    }

    public static class ResultMapsBean {
        /**
         * content_id : 276
         * privatefolder_id : 1
         * name : diyicie
         * privatefolderName : 这是我的文件夹
         * folderId : 1
         * fileList : [{"id":276,"filename":"timg.jpg","uri":"\\pluploadDir/1536652057087.jpg","fileType":3,"personal":false,"ownerId":null,"createdTime":1536652057000,"modifiedTime":1536652062000,"keywords":null,"data":null,"cacheUri":"/pluploadDir/1536652057087.swf","isSave":null}]
         */

        private int content_id;
        private int privatefolder_id;
        private String name;
        private String privatefolderName;
        private int folderId;
        private ArrayList<FileListBean> fileList;

        public int getContent_id() {
            return content_id;
        }

        public void setContent_id(int content_id) {
            this.content_id = content_id;
        }

        public int getPrivatefolder_id() {
            return privatefolder_id;
        }

        public void setPrivatefolder_id(int privatefolder_id) {
            this.privatefolder_id = privatefolder_id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPrivatefolderName() {
            return privatefolderName;
        }

        public void setPrivatefolderName(String privatefolderName) {
            this.privatefolderName = privatefolderName;
        }

        public int getFolderId() {
            return folderId;
        }

        public void setFolderId(int folderId) {
            this.folderId = folderId;
        }

        public ArrayList<FileListBean> getFileList() {
            return fileList;
        }

        public void setFileList(ArrayList<FileListBean> fileList) {
            this.fileList = fileList;
        }

        public static class FileListBean {
            /**
             * id : 276
             * filename : timg.jpg
             * uri : \pluploadDir/1536652057087.jpg
             * fileType : 3
             * personal : false
             * ownerId : null
             * createdTime : 1536652057000
             * modifiedTime : 1536652062000
             * keywords : null
             * data : null
             * cacheUri : /pluploadDir/1536652057087.swf
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
            private String cacheUri;
            private Object isSave;
            private boolean isSelect;


            public boolean isSelect() {
                return isSelect;
            }

            public void setSelect(boolean select) {
                isSelect = select;
            }

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

            public String getCacheUri() {
                return cacheUri;
            }

            public void setCacheUri(String cacheUri) {
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
