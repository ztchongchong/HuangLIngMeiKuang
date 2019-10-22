package com.lingjun.colliery_android.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * 隐患位置
 */
public class HiddenDangerPositionBean {


    /**
     * msg : 成功
     * code : 200
     * data : null
     * resultMaps : [{"locationhistory":[{"id":50,"location":"rrrrS","timestamp":1542333064000,"sysuserId":1326},{"id":49,"location":"111","timestamp":1542257581000,"sysuserId":1326},{"id":48,"location":"我 ","timestamp":1542253022000,"sysuserId":1326},{"id":47,"location":"11","timestamp":1542252877000,"sysuserId":1326},{"id":46,"location":"4","timestamp":1542252125000,"sysuserId":1326}]}]
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
        private ArrayList<LocationhistoryBean> locationhistory;

        public ArrayList<LocationhistoryBean> getLocationhistory() {
            return locationhistory;
        }

        public void setLocationhistory(ArrayList<LocationhistoryBean> locationhistory) {
            this.locationhistory = locationhistory;
        }

        public static class LocationhistoryBean {
            /**
             * id : 50
             * location : rrrrS
             * timestamp : 1542333064000
             * sysuserId : 1326
             */

            private int id;
            private String location;
            private long timestamp;
            private int sysuserId;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getLocation() {
                return location;
            }

            public void setLocation(String location) {
                this.location = location;
            }

            public long getTimestamp() {
                return timestamp;
            }

            public void setTimestamp(long timestamp) {
                this.timestamp = timestamp;
            }

            public int getSysuserId() {
                return sysuserId;
            }

            public void setSysuserId(int sysuserId) {
                this.sysuserId = sysuserId;
            }
        }
    }
}
