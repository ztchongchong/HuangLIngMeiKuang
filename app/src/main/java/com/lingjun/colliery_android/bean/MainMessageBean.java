package com.lingjun.colliery_android.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nefa on 2018/11/21.
 */

public class MainMessageBean {


    /**
     * msg : 成功
     * code : 200
     * data : {"pageCount":2,"count":16,"pageSize":10,"pageNum":1}
     * resultMaps : [{"read":false,"send_time":1542434197000,"deleted":0,"receiver_id":1326,"message_type":5,"task_id":1637,"id":203,"title":"重大隐患治理","content":"顶、帮状况差或顶板破碎、两帮片帮严重","sender_id":1326},{"read":false,"send_time":1542607200000,"deleted":0,"receiver_id":1326,"message_type":6,"task_id":1613,"id":218,"title":"整改超时","content":"未选择在顶板状况好的地方吊挂、拆卸调校激光指向仪","sender_id":1326},{"read":false,"send_time":1542607200000,"deleted":0,"receiver_id":1326,"message_type":6,"task_id":1617,"id":219,"title":"整改超时","content":"未认真执行敲帮问顶","sender_id":1326},{"read":false,"send_time":1542607201000,"deleted":0,"receiver_id":1326,"message_type":7,"task_id":1628,"id":220,"title":"挂牌督办","content":"顶、帮状况差或顶板破碎、两帮片帮严重","sender_id":1326},{"read":false,"send_time":1542610800000,"deleted":0,"receiver_id":1326,"message_type":6,"task_id":1641,"id":221,"title":"整改超时","content":"未认真执行敲帮问顶","sender_id":1326},{"read":false,"send_time":1542610800000,"deleted":0,"receiver_id":1326,"message_type":6,"task_id":1653,"id":222,"title":"整改超时","content":"未认真执行敲帮问顶","sender_id":1326},{"read":false,"send_time":1542612733000,"deleted":0,"receiver_id":1326,"message_type":13,"task_id":1732,"id":224,"title":"三违处罚通知","content":"<p>李向锋<\/p><br><p>有个三违处罚通知单。<a style=\"color: #2577b3;\"  href=\"javascript:void(0)\" onclick=\"window.location.href  = '../sysDisobey/mydisobey.html?id=1732';\">【查看】<\/a><br>请领导进行关注处理.<\/p>","sender_id":1326},{"read":false,"send_time":1542618000000,"deleted":0,"receiver_id":1326,"message_type":6,"task_id":1667,"id":225,"title":"整改超时","content":"未认真执行敲帮问顶","sender_id":1326},{"read":false,"send_time":1542697200000,"deleted":0,"receiver_id":1326,"message_type":7,"task_id":1650,"id":228,"title":"挂牌督办","content":"未认真执行敲帮问顶","sender_id":1326},{"read":false,"send_time":1542698755000,"deleted":0,"receiver_id":1326,"message_type":13,"task_id":1762,"id":229,"title":"三违处罚通知","content":"<p>郭高民:<\/p><br><p>你有个三违处罚通知单。<a style=\"color: #2577b3;\"  href=\"javascript:void(0)\" onclick=\"window.location.href  = '../sysDisobey/mydisobey.html?id=1762';\">【查看】<\/a><\/p>","sender_id":1326}]
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
         * pageCount : 2
         * count : 16
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
         * read : false
         * send_time : 1542434197000
         * deleted : 0
         * receiver_id : 1326
         * message_type : 5
         * task_id : 1637
         * id : 203
         * title : 重大隐患治理
         * content : 顶、帮状况差或顶板破碎、两帮片帮严重
         * sender_id : 1326
         */

        private boolean read;
        private long send_time;
        private int deleted;
        private int receiver_id;
        private int message_type;
        private int task_id;
        private int id;
        private String title;
        private String content;
        private int sender_id;

        public boolean isRead() {
            return read;
        }

        public void setRead(boolean read) {
            this.read = read;
        }

        public long getSend_time() {
            return send_time;
        }

        public void setSend_time(long send_time) {
            this.send_time = send_time;
        }

        public int getDeleted() {
            return deleted;
        }

        public void setDeleted(int deleted) {
            this.deleted = deleted;
        }

        public int getReceiver_id() {
            return receiver_id;
        }

        public void setReceiver_id(int receiver_id) {
            this.receiver_id = receiver_id;
        }

        public int getMessage_type() {
            return message_type;
        }

        public void setMessage_type(int message_type) {
            this.message_type = message_type;
        }

        public int getTask_id() {
            return task_id;
        }

        public void setTask_id(int task_id) {
            this.task_id = task_id;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public int getSender_id() {
            return sender_id;
        }

        public void setSender_id(int sender_id) {
            this.sender_id = sender_id;
        }
    }
}
