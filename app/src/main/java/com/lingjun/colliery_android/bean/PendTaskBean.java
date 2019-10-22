package com.lingjun.colliery_android.bean;

import java.util.List;

/**
 * Created by shurrikann on 2018/4/23.
 */

public class PendTaskBean {


    /**
     * msg : 成功
     * resultMaps : []
     * code : 200
     * data : {"creator":"孔德昊","createtime":1545042078000,"invitedcount":"","leaderrefusereason":false,"description":"","cooperatorcount":0,"itemcount":15,"title":"零分","zerocount":0,"mancount":2,"leaderagreereason":false,"responsiblecount":1,"finishtime":1545109200000,"h5url":"","leadercount":1}
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
        /**
         * creator : 孔德昊
         * createtime : 1545042078000
         * invitedcount :
         * leaderrefusereason : false
         * description :
         * cooperatorcount : 0
         * itemcount : 15
         * title : 零分
         * zerocount : 0
         * mancount : 2
         * leaderagreereason : false
         * responsiblecount : 1
         * finishtime : 1545109200000
         * h5url :
         * leadercount : 1
         */

        private String creator;
        private long createtime;
        private String invitedcount;
        private boolean leaderrefusereason;
        private String description;
        private int cooperatorcount;
        private int itemcount;
        private String title;
        private int zerocount;
        private int mancount;
        private boolean leaderagreereason;
        private int responsiblecount;
        private long finishtime;
        private String h5url;
        private int leadercount;

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

        public boolean isLeaderrefusereason() {
            return leaderrefusereason;
        }

        public void setLeaderrefusereason(boolean leaderrefusereason) {
            this.leaderrefusereason = leaderrefusereason;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public int getCooperatorcount() {
            return cooperatorcount;
        }

        public void setCooperatorcount(int cooperatorcount) {
            this.cooperatorcount = cooperatorcount;
        }

        public int getItemcount() {
            return itemcount;
        }

        public void setItemcount(int itemcount) {
            this.itemcount = itemcount;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getZerocount() {
            return zerocount;
        }

        public void setZerocount(int zerocount) {
            this.zerocount = zerocount;
        }

        public int getMancount() {
            return mancount;
        }

        public void setMancount(int mancount) {
            this.mancount = mancount;
        }

        public boolean isLeaderagreereason() {
            return leaderagreereason;
        }

        public void setLeaderagreereason(boolean leaderagreereason) {
            this.leaderagreereason = leaderagreereason;
        }

        public int getResponsiblecount() {
            return responsiblecount;
        }

        public void setResponsiblecount(int responsiblecount) {
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

        public int getLeadercount() {
            return leadercount;
        }

        public void setLeadercount(int leadercount) {
            this.leadercount = leadercount;
        }
    }
}
