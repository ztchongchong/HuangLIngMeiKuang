package com.lingjun.colliery_android.bean;

import java.util.List;

/**
 * Created by shurrikann on 2018/12/12.
 */

public class ZeRenBean {

    /**
     * msg : 成功
     * code : 200
     * data : {"map":[{"id":0,"name":"孔德昊","picurl":null,"list":[{"id":1,"categoryname":"安全风险分级管控/工作机制/职责分工","serialno":"1.1.1(1)","standard":null,"demand":null,"score":0,"responsibleName":null,"cooperatorNames":null,"invited":null,"name":null},{"id":2,"categoryname":"安全风险分级管控/工作机制/职责分工","serialno":"1.1.1(2)","standard":null,"demand":null,"score":0,"responsibleName":null,"cooperatorNames":null,"invited":null,"name":null},{"id":3,"categoryname":"安全风险分级管控/工作机制/制度建设","serialno":"1.1.2(1)","standard":null,"demand":null,"score":0,"responsibleName":null,"cooperatorNames":null,"invited":null,"name":null},{"id":4,"categoryname":"安全风险分级管控/安全风险辨识评估/年度辨识评估","serialno":"1.2.1(1)","standard":null,"demand":null,"score":0,"responsibleName":null,"cooperatorNames":null,"invited":null,"name":null},{"id":5,"categoryname":"安全风险分级管控/安全风险辨识评估/专项辨识评估","serialno":"1.2.2(1)","standard":null,"demand":null,"score":0,"responsibleName":null,"cooperatorNames":null,"invited":null,"name":null},{"id":6,"categoryname":"安全风险分级管控/安全风险辨识评估/专项辨识评估","serialno":"1.2.2(2)","standard":null,"demand":null,"score":0,"responsibleName":null,"cooperatorNames":null,"invited":null,"name":null},{"id":7,"categoryname":"安全风险分级管控/安全风险辨识评估/专项辨识评估","serialno":"1.2.2(3)","standard":null,"demand":null,"score":0,"responsibleName":null,"cooperatorNames":null,"invited":null,"name":null},{"id":8,"categoryname":"安全风险分级管控/安全风险辨识评估/专项辨识评估","serialno":"1.2.2(4)","standard":null,"demand":null,"score":0,"responsibleName":null,"cooperatorNames":null,"invited":null,"name":null},{"id":9,"categoryname":"安全风险分级管控/安全风险管控/管控措施","serialno":"1.3.1(1)","standard":null,"demand":null,"score":0,"responsibleName":null,"cooperatorNames":null,"invited":null,"name":null},{"id":10,"categoryname":"安全风险分级管控/安全风险管控/管控措施","serialno":"1.3.1(2)","standard":null,"demand":null,"score":0,"responsibleName":null,"cooperatorNames":null,"invited":null,"name":null},{"id":11,"categoryname":"安全风险分级管控/安全风险管控/定期检查","serialno":"1.3.2(1)","standard":null,"demand":null,"score":0,"responsibleName":null,"cooperatorNames":null,"invited":null,"name":null},{"id":12,"categoryname":"安全风险分级管控/安全风险管控/定期检查","serialno":"1.3.2(2)","standard":null,"demand":null,"score":0,"responsibleName":null,"cooperatorNames":null,"invited":null,"name":null},{"id":13,"categoryname":"安全风险分级管控/安全风险管控/现场检查","serialno":"1.3.3(1)","standard":null,"demand":null,"score":0,"responsibleName":null,"cooperatorNames":null,"invited":null,"name":null},{"id":14,"categoryname":"安全风险分级管控/安全风险管控/公告警示","serialno":"1.3.4(1)","standard":null,"demand":null,"score":0,"responsibleName":null,"cooperatorNames":null,"invited":null,"name":null},{"id":15,"categoryname":"安全风险分级管控/保障措施/信息管理","serialno":"1.4.1(1)","standard":null,"demand":null,"score":0,"responsibleName":null,"cooperatorNames":null,"invited":null,"name":null},{"id":16,"categoryname":"安全风险分级管控/保障措施/教育培训","serialno":"1.4.2(1)","standard":null,"demand":null,"score":0,"responsibleName":null,"cooperatorNames":null,"invited":null,"name":null},{"id":17,"categoryname":"安全风险分级管控/保障措施/教育培训","serialno":"1.4.2(2)","standard":null,"demand":null,"score":0,"responsibleName":null,"cooperatorNames":null,"invited":null,"name":null}]}]}
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

    public static class DataBean {
        private List<MapBean> map;

        public List<MapBean> getMap() {
            return map;
        }

        public void setMap(List<MapBean> map) {
            this.map = map;
        }

        public static class MapBean {
            /**
             * id : 0
             * name : 孔德昊
             * picurl : null
             * list : [{"id":1,"categoryname":"安全风险分级管控/工作机制/职责分工","serialno":"1.1.1(1)","standard":null,"demand":null,"score":0,"responsibleName":null,"cooperatorNames":null,"invited":null,"name":null},{"id":2,"categoryname":"安全风险分级管控/工作机制/职责分工","serialno":"1.1.1(2)","standard":null,"demand":null,"score":0,"responsibleName":null,"cooperatorNames":null,"invited":null,"name":null},{"id":3,"categoryname":"安全风险分级管控/工作机制/制度建设","serialno":"1.1.2(1)","standard":null,"demand":null,"score":0,"responsibleName":null,"cooperatorNames":null,"invited":null,"name":null},{"id":4,"categoryname":"安全风险分级管控/安全风险辨识评估/年度辨识评估","serialno":"1.2.1(1)","standard":null,"demand":null,"score":0,"responsibleName":null,"cooperatorNames":null,"invited":null,"name":null},{"id":5,"categoryname":"安全风险分级管控/安全风险辨识评估/专项辨识评估","serialno":"1.2.2(1)","standard":null,"demand":null,"score":0,"responsibleName":null,"cooperatorNames":null,"invited":null,"name":null},{"id":6,"categoryname":"安全风险分级管控/安全风险辨识评估/专项辨识评估","serialno":"1.2.2(2)","standard":null,"demand":null,"score":0,"responsibleName":null,"cooperatorNames":null,"invited":null,"name":null},{"id":7,"categoryname":"安全风险分级管控/安全风险辨识评估/专项辨识评估","serialno":"1.2.2(3)","standard":null,"demand":null,"score":0,"responsibleName":null,"cooperatorNames":null,"invited":null,"name":null},{"id":8,"categoryname":"安全风险分级管控/安全风险辨识评估/专项辨识评估","serialno":"1.2.2(4)","standard":null,"demand":null,"score":0,"responsibleName":null,"cooperatorNames":null,"invited":null,"name":null},{"id":9,"categoryname":"安全风险分级管控/安全风险管控/管控措施","serialno":"1.3.1(1)","standard":null,"demand":null,"score":0,"responsibleName":null,"cooperatorNames":null,"invited":null,"name":null},{"id":10,"categoryname":"安全风险分级管控/安全风险管控/管控措施","serialno":"1.3.1(2)","standard":null,"demand":null,"score":0,"responsibleName":null,"cooperatorNames":null,"invited":null,"name":null},{"id":11,"categoryname":"安全风险分级管控/安全风险管控/定期检查","serialno":"1.3.2(1)","standard":null,"demand":null,"score":0,"responsibleName":null,"cooperatorNames":null,"invited":null,"name":null},{"id":12,"categoryname":"安全风险分级管控/安全风险管控/定期检查","serialno":"1.3.2(2)","standard":null,"demand":null,"score":0,"responsibleName":null,"cooperatorNames":null,"invited":null,"name":null},{"id":13,"categoryname":"安全风险分级管控/安全风险管控/现场检查","serialno":"1.3.3(1)","standard":null,"demand":null,"score":0,"responsibleName":null,"cooperatorNames":null,"invited":null,"name":null},{"id":14,"categoryname":"安全风险分级管控/安全风险管控/公告警示","serialno":"1.3.4(1)","standard":null,"demand":null,"score":0,"responsibleName":null,"cooperatorNames":null,"invited":null,"name":null},{"id":15,"categoryname":"安全风险分级管控/保障措施/信息管理","serialno":"1.4.1(1)","standard":null,"demand":null,"score":0,"responsibleName":null,"cooperatorNames":null,"invited":null,"name":null},{"id":16,"categoryname":"安全风险分级管控/保障措施/教育培训","serialno":"1.4.2(1)","standard":null,"demand":null,"score":0,"responsibleName":null,"cooperatorNames":null,"invited":null,"name":null},{"id":17,"categoryname":"安全风险分级管控/保障措施/教育培训","serialno":"1.4.2(2)","standard":null,"demand":null,"score":0,"responsibleName":null,"cooperatorNames":null,"invited":null,"name":null}]
             */

            private int id;
            private String name;
            private Object picurl;
            private List<ListBean> list;
            boolean state;

            public boolean isState() {
                return state;
            }

            public void setState(boolean state) {
                this.state = state;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public Object getPicurl() {
                return picurl;
            }

            public void setPicurl(Object picurl) {
                this.picurl = picurl;
            }

            public List<ListBean> getList() {
                return list;
            }

            public void setList(List<ListBean> list) {
                this.list = list;
            }

            public static class ListBean {
                /**
                 * id : 1
                 * categoryname : 安全风险分级管控/工作机制/职责分工
                 * serialno : 1.1.1(1)
                 * standard : null
                 * demand : null
                 * score : 0
                 * responsibleName : null
                 * cooperatorNames : null
                 * invited : null
                 * name : null
                 */

                private int id;
                private String categoryname;
                private String serialno;
                private Object standard;
                private Object demand;
                private int score;
                private Object responsibleName;
                private Object cooperatorNames;
                private Object invited;
                private Object name;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getCategoryname() {
                    return categoryname;
                }

                public void setCategoryname(String categoryname) {
                    this.categoryname = categoryname;
                }

                public String getSerialno() {
                    return serialno;
                }

                public void setSerialno(String serialno) {
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

                public int getScore() {
                    return score;
                }

                public void setScore(int score) {
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

                public Object getName() {
                    return name;
                }

                public void setName(Object name) {
                    this.name = name;
                }
            }
        }
    }
}
