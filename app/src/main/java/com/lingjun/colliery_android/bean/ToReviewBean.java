package com.lingjun.colliery_android.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by shurrikann on 2018/4/24.
 */

public class ToReviewBean implements Serializable{


    /**
     * msg : 成功
     * code : 200
     * data : {"summary":"","creator":"王红伟","createtime":1554882124000,"invitedcount":"","description":"","itemcount":405,"cooperatorcount":"36","title":"你是谁我是谁","readingopinions":false,"responsiblecount":"1","finishtime":1554825600000,"h5url":"","filecount":0,"autoscore":99.64,"categoryarray":[{"id":1,"categoryname":null,"serialno":null,"standard":null,"demand":null,"score":100,"responsibleName":null,"cooperatorNames":null,"invited":null,"name":"安全风险分级管控"},{"id":16,"categoryname":null,"serialno":null,"standard":null,"demand":null,"score":100,"responsibleName":null,"cooperatorNames":null,"invited":null,"name":"事故隐患排查治理"},{"id":37,"categoryname":null,"serialno":null,"standard":null,"demand":null,"score":100,"responsibleName":null,"cooperatorNames":null,"invited":null,"name":"通风"},{"id":82,"categoryname":null,"serialno":null,"standard":null,"demand":null,"score":100,"responsibleName":null,"cooperatorNames":null,"invited":null,"name":"地质灾害防治与测量"},{"id":144,"categoryname":null,"serialno":null,"standard":null,"demand":null,"score":100,"responsibleName":null,"cooperatorNames":null,"invited":null,"name":"采煤"},{"id":164,"categoryname":null,"serialno":null,"standard":null,"demand":null,"score":100,"responsibleName":null,"cooperatorNames":null,"invited":null,"name":"掘进"},{"id":187,"categoryname":null,"serialno":null,"standard":null,"demand":null,"score":100,"responsibleName":null,"cooperatorNames":null,"invited":null,"name":"机电"},{"id":222,"categoryname":null,"serialno":null,"standard":null,"demand":null,"score":100,"responsibleName":null,"cooperatorNames":null,"invited":null,"name":"运输"},{"id":244,"categoryname":null,"serialno":null,"standard":null,"demand":null,"score":100,"responsibleName":null,"cooperatorNames":null,"invited":null,"name":"职业卫生"},{"id":278,"categoryname":null,"serialno":null,"standard":null,"demand":null,"score":100,"responsibleName":null,"cooperatorNames":null,"invited":null,"name":"安全培训和应急管理"},{"id":301,"categoryname":null,"serialno":null,"standard":null,"demand":null,"score":94,"responsibleName":null,"cooperatorNames":null,"invited":null,"name":"调度和地面设施"}],"time":52000,"leadercount":1}
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

    public static class DataBean implements Serializable{
        /**
         * summary :
         * creator : 王红伟
         * createtime : 1554882124000
         * invitedcount :
         * description :
         * itemcount : 405
         * cooperatorcount : 36
         * title : 你是谁我是谁
         * readingopinions : false
         * responsiblecount : 1
         * finishtime : 1554825600000
         * h5url :
         * filecount : 0
         * autoscore : 99.64
         * categoryarray : [{"id":1,"categoryname":null,"serialno":null,"standard":null,"demand":null,"score":100,"responsibleName":null,"cooperatorNames":null,"invited":null,"name":"安全风险分级管控"},{"id":16,"categoryname":null,"serialno":null,"standard":null,"demand":null,"score":100,"responsibleName":null,"cooperatorNames":null,"invited":null,"name":"事故隐患排查治理"},{"id":37,"categoryname":null,"serialno":null,"standard":null,"demand":null,"score":100,"responsibleName":null,"cooperatorNames":null,"invited":null,"name":"通风"},{"id":82,"categoryname":null,"serialno":null,"standard":null,"demand":null,"score":100,"responsibleName":null,"cooperatorNames":null,"invited":null,"name":"地质灾害防治与测量"},{"id":144,"categoryname":null,"serialno":null,"standard":null,"demand":null,"score":100,"responsibleName":null,"cooperatorNames":null,"invited":null,"name":"采煤"},{"id":164,"categoryname":null,"serialno":null,"standard":null,"demand":null,"score":100,"responsibleName":null,"cooperatorNames":null,"invited":null,"name":"掘进"},{"id":187,"categoryname":null,"serialno":null,"standard":null,"demand":null,"score":100,"responsibleName":null,"cooperatorNames":null,"invited":null,"name":"机电"},{"id":222,"categoryname":null,"serialno":null,"standard":null,"demand":null,"score":100,"responsibleName":null,"cooperatorNames":null,"invited":null,"name":"运输"},{"id":244,"categoryname":null,"serialno":null,"standard":null,"demand":null,"score":100,"responsibleName":null,"cooperatorNames":null,"invited":null,"name":"职业卫生"},{"id":278,"categoryname":null,"serialno":null,"standard":null,"demand":null,"score":100,"responsibleName":null,"cooperatorNames":null,"invited":null,"name":"安全培训和应急管理"},{"id":301,"categoryname":null,"serialno":null,"standard":null,"demand":null,"score":94,"responsibleName":null,"cooperatorNames":null,"invited":null,"name":"调度和地面设施"}]
         * time : 52000
         * leadercount : 1
         */

        private String summary;
        private String creator;
        private long createtime;
        private String invitedcount;
        private String description;
        private int itemcount;
        private String cooperatorcount;
        private String title;
        private boolean readingopinions;
        private String responsiblecount;
        private long finishtime;
        private String h5url;
        private int filecount;
        private double autoscore;
        private int time;
        private int leadercount;
        private List<CategoryarrayBean> categoryarray;

        public String getSummary() {
            return summary;
        }

        public void setSummary(String summary) {
            this.summary = summary;
        }

        public String getCreator() {
            return creator;
        }

        public void setCreator(String creator) {
            this.creator = creator;
        }

        public long getCreatetime() {
            return createtime;
        }

        public void setCreatetime(long createtime) {
            this.createtime = createtime;
        }

        public String getInvitedcount() {
            return invitedcount;
        }

        public void setInvitedcount(String invitedcount) {
            this.invitedcount = invitedcount;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public int getItemcount() {
            return itemcount;
        }

        public void setItemcount(int itemcount) {
            this.itemcount = itemcount;
        }

        public String getCooperatorcount() {
            return cooperatorcount;
        }

        public void setCooperatorcount(String cooperatorcount) {
            this.cooperatorcount = cooperatorcount;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public boolean isReadingopinions() {
            return readingopinions;
        }

        public void setReadingopinions(boolean readingopinions) {
            this.readingopinions = readingopinions;
        }

        public String getResponsiblecount() {
            return responsiblecount;
        }

        public void setResponsiblecount(String responsiblecount) {
            this.responsiblecount = responsiblecount;
        }

        public long getFinishtime() {
            return finishtime;
        }

        public void setFinishtime(long finishtime) {
            this.finishtime = finishtime;
        }

        public String getH5url() {
            return h5url;
        }

        public void setH5url(String h5url) {
            this.h5url = h5url;
        }

        public int getFilecount() {
            return filecount;
        }

        public void setFilecount(int filecount) {
            this.filecount = filecount;
        }

        public double getAutoscore() {
            return autoscore;
        }

        public void setAutoscore(double autoscore) {
            this.autoscore = autoscore;
        }

        public int getTime() {
            return time;
        }

        public void setTime(int time) {
            this.time = time;
        }

        public int getLeadercount() {
            return leadercount;
        }

        public void setLeadercount(int leadercount) {
            this.leadercount = leadercount;
        }

        public List<CategoryarrayBean> getCategoryarray() {
            return categoryarray;
        }

        public void setCategoryarray(List<CategoryarrayBean> categoryarray) {
            this.categoryarray = categoryarray;
        }

        public static class CategoryarrayBean implements Serializable{
            /**
             * id : 1
             * categoryname : null
             * serialno : null
             * standard : null
             * demand : null
             * score : 100.0
             * responsibleName : null
             * cooperatorNames : null
             * invited : null
             * name : 安全风险分级管控
             */

            private int id;
            private Object categoryname;
            private Object serialno;
            private Object standard;
            private Object demand;
            private double score;
            private Object responsibleName;
            private Object cooperatorNames;
            private Object invited;
            private String name;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public Object getCategoryname() {
                return categoryname;
            }

            public void setCategoryname(Object categoryname) {
                this.categoryname = categoryname;
            }

            public Object getSerialno() {
                return serialno;
            }

            public void setSerialno(Object serialno) {
                this.serialno = serialno;
            }

            public Object getStandard() {
                return standard;
            }

            public void setStandard(Object standard) {
                this.standard = standard;
            }

            public Object getDemand() {
                return demand;
            }

            public void setDemand(Object demand) {
                this.demand = demand;
            }

            public double getScore() {
                return score;
            }

            public void setScore(double score) {
                this.score = score;
            }

            public Object getResponsibleName() {
                return responsibleName;
            }

            public void setResponsibleName(Object responsibleName) {
                this.responsibleName = responsibleName;
            }

            public Object getCooperatorNames() {
                return cooperatorNames;
            }

            public void setCooperatorNames(Object cooperatorNames) {
                this.cooperatorNames = cooperatorNames;
            }

            public Object getInvited() {
                return invited;
            }

            public void setInvited(Object invited) {
                this.invited = invited;
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
