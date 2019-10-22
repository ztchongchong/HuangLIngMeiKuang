package com.lingjun.colliery_android.bean;

import java.util.List;

/**
 * 选择责任单位(录入隐患)
 */

public class ResponsibilityBean {


    /**
     * msg : 成功
     * code : 200
     * data : {"rectificationPersonnelFlag":"1"}
     * resultMaps : [{"technicianInfo":{"name":""},"department_id":21,"processorInfo":{"name":"传小军"},"parent_id":1,"name":"生产技术部","leaderInfo":{"fileName":"2018","name":"李鸿武","id":3968,"uri":"/pluploadDir/1546523841417.pdf"},"processor_id":"31","leader_id":2},{"technicianInfo":{"name":""},"department_id":32,"processorInfo":{"name":"高政伟"},"parent_id":21,"name":"综合采煤队","leaderInfo":{"fileName":"58a3b4d63c1e5.jpg","name":"许保社","id":11870,"uri":"/pluploadDir/155357200747858a3b4d63c1e5.jpg"},"processor_id":"163","leader_id":13},{"technicianInfo":{"name":""},"department_id":320,"processorInfo":{"name":"赵晓海 "},"parent_id":21,"name":"综掘三队","leaderInfo":{"fileName":"58a3b4d63c1e5.jpg","name":"许保社","id":11870,"uri":"/pluploadDir/155357200747858a3b4d63c1e5.jpg"},"processor_id":"338","leader_id":13},{"technicianInfo":{"name":""},"department_id":577,"processorInfo":{"name":"杨联恒"},"parent_id":1,"name":"通风部","leaderInfo":{"fileName":"2018","name":"李鸿武","id":3968,"uri":"/pluploadDir/1546523841417.pdf"},"processor_id":"578","leader_id":2},{"technicianInfo":{"name":""},"department_id":582,"processorInfo":{"name":"杨云峰"},"parent_id":577,"name":"通维队","leaderInfo":{"name":"杨联恒"},"processor_id":"583","leader_id":578},{"technicianInfo":{"name":""},"department_id":339,"processorInfo":{"name":"王雷"},"parent_id":21,"name":"开拓一队","leaderInfo":{"fileName":"58a3b4d63c1e5.jpg","name":"许保社","id":11870,"uri":"/pluploadDir/155357200747858a3b4d63c1e5.jpg"},"processor_id":"340","leader_id":13},{"technicianInfo":{"name":""},"department_id":341,"processorInfo":{"name":"郑坤生"},"parent_id":21,"name":"开拓二队","leaderInfo":{"fileName":"58a3b4d63c1e5.jpg","name":"许保社","id":11870,"uri":"/pluploadDir/155357200747858a3b4d63c1e5.jpg"},"processor_id":"342","leader_id":13},{"technicianInfo":{"name":""},"department_id":343,"processorInfo":{"name":"张红建"},"parent_id":21,"name":"开拓三队","leaderInfo":{"fileName":"58a3b4d63c1e5.jpg","name":"许保社","id":11870,"uri":"/pluploadDir/155357200747858a3b4d63c1e5.jpg"},"processor_id":"344","leader_id":13},{"technicianInfo":{"name":""},"department_id":345,"processorInfo":{"name":"刘鹏"},"parent_id":21,"name":"储煤厂","leaderInfo":{"fileName":"58a3b4d63c1e5.jpg","name":"许保社","id":11870,"uri":"/pluploadDir/155357200747858a3b4d63c1e5.jpg"},"processor_id":"346","leader_id":13},{"technicianInfo":{"name":""},"department_id":364,"processorInfo":{"name":"王增望"},"parent_id":1,"name":"机电设备管理部","leaderInfo":{"fileName":"2018","name":"李鸿武","id":3968,"uri":"/pluploadDir/1546523841417.pdf"},"processor_id":"14","leader_id":2},{"technicianInfo":{"name":""},"department_id":374,"processorInfo":{"name":"刘振记"},"parent_id":364,"name":"机电队","leaderInfo":{"name":"王增望"},"processor_id":"15","leader_id":14},{"technicianInfo":{"name":""},"department_id":642,"processorInfo":{"name":"高军"},"parent_id":1,"name":"安全监察部","leaderInfo":{"fileName":"2018","name":"李鸿武","id":3968,"uri":"/pluploadDir/1546523841417.pdf"},"processor_id":"18","leader_id":2},{"technicianInfo":{"name":""},"department_id":665,"processorInfo":{"name":"宋瑞涛"},"parent_id":1,"name":"地测部","leaderInfo":{"fileName":"2018","name":"李鸿武","id":3968,"uri":"/pluploadDir/1546523841417.pdf"},"processor_id":"666","leader_id":2},{"technicianInfo":{"name":""},"department_id":672,"processorInfo":{"name":"李伟辉"},"parent_id":1,"name":"调度指挥中心","leaderInfo":{"fileName":"2018","name":"李鸿武","id":3968,"uri":"/pluploadDir/1546523841417.pdf"},"processor_id":"19","leader_id":2},{"technicianInfo":{"name":""},"department_id":166,"processorInfo":{"name":"于发根"},"parent_id":21,"name":"综掘一队","leaderInfo":{"fileName":"58a3b4d63c1e5.jpg","name":"许保社","id":11870,"uri":"/pluploadDir/155357200747858a3b4d63c1e5.jpg"},"processor_id":"167","leader_id":13},{"technicianInfo":{"name":""},"department_id":685,"processorInfo":{"name":"姚恒福"},"parent_id":1,"name":"党群工作部","leaderInfo":{"fileName":"2018","name":"李鸿武","id":3968,"uri":"/pluploadDir/1546523841417.pdf"},"processor_id":"686","leader_id":2},{"technicianInfo":{"name":""},"department_id":691,"processorInfo":{"name":"张文智"},"parent_id":1,"name":"工程规划管理部","leaderInfo":{"fileName":"2018","name":"李鸿武","id":3968,"uri":"/pluploadDir/1546523841417.pdf"},"processor_id":"692","leader_id":2},{"technicianInfo":{"name":""},"department_id":697,"processorInfo":{"name":"田滨涛"},"parent_id":1,"name":"经营办","leaderInfo":{"fileName":"2018","name":"李鸿武","id":3968,"uri":"/pluploadDir/1546523841417.pdf"},"processor_id":"20","leader_id":2},{"technicianInfo":{"name":""},"department_id":708,"processorInfo":{"name":"郑欣"},"parent_id":1,"name":"财务部","leaderInfo":{"fileName":"2018","name":"李鸿武","id":3968,"uri":"/pluploadDir/1546523841417.pdf"},"processor_id":"709","leader_id":2},{"technicianInfo":{"name":""},"department_id":715,"processorInfo":{"name":"王建洲"},"parent_id":1,"name":"物资供应公司","leaderInfo":{"fileName":"2018","name":"李鸿武","id":3968,"uri":"/pluploadDir/1546523841417.pdf"},"processor_id":"716","leader_id":2},{"technicianInfo":{"name":""},"department_id":471,"processorInfo":{"name":"张铜锁"},"parent_id":364,"name":"选运队","leaderInfo":{"name":"王增望"},"processor_id":"472","leader_id":14},{"technicianInfo":{"name":""},"department_id":740,"processorInfo":{"name":"李春晖"},"parent_id":1,"name":"运销公司","leaderInfo":{"fileName":"2018","name":"李鸿武","id":3968,"uri":"/pluploadDir/1546523841417.pdf"},"processor_id":"742","leader_id":2},{"technicianInfo":{"name":""},"department_id":245,"processorInfo":{"name":"张晓林"},"parent_id":21,"name":"综掘二队","leaderInfo":{"fileName":"58a3b4d63c1e5.jpg","name":"许保社","id":11870,"uri":"/pluploadDir/155357200747858a3b4d63c1e5.jpg"},"processor_id":"246","leader_id":13},{"technicianInfo":{"name":""},"department_id":773,"processorInfo":{"name":"张晓林"},"parent_id":1,"name":"实业公司","leaderInfo":{"fileName":"58a3b4d63c1e5.jpg","name":"许保社","id":11870,"uri":"/pluploadDir/155357200747858a3b4d63c1e5.jpg"},"processor_id":"246","leader_id":13}]
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

    public static class DataBean {
        /**
         * rectificationPersonnelFlag : 1
         */

        private String rectificationPersonnelFlag;

        public String getRectificationPersonnelFlag() {
            return rectificationPersonnelFlag;
        }

        public void setRectificationPersonnelFlag(String rectificationPersonnelFlag) {
            this.rectificationPersonnelFlag = rectificationPersonnelFlag;
        }
    }

    public static class ResultMapsBean {
        /**
         * technicianInfo : {"name":""}
         * department_id : 21
         * processorInfo : {"name":"传小军"}
         * parent_id : 1
         * name : 生产技术部
         * leaderInfo : {"fileName":"2018","name":"李鸿武","id":3968,"uri":"/pluploadDir/1546523841417.pdf"}
         * processor_id : 31
         * leader_id : 2
         */

        private TechnicianInfoBean technicianInfo;
        private int department_id;
        private ProcessorInfoBean processorInfo;
        private int parent_id;
        private String name;
        private LeaderInfoBean leaderInfo;
        private String processor_id;
        private int leader_id;

        public int getResponsibleLeaderId() {
            return responsibleLeaderId;
        }

        public void setResponsibleLeaderId(int responsibleLeaderId) {
            this.responsibleLeaderId = responsibleLeaderId;
        }

        private int responsibleLeaderId;//责任人id

        public ResponsibleLeaderinfo getResponsibleLeaderinfo() {
            return responsibleLeaderinfo;
        }

        public void setResponsibleLeaderinfo(ResponsibleLeaderinfo responsibleLeaderinfo) {
            this.responsibleLeaderinfo = responsibleLeaderinfo;
        }

        private ResponsibleLeaderinfo responsibleLeaderinfo;



        public int getTechnician_id() {
            return technician_id;
        }

        public void setTechnician_id(int technician_id) {
            this.technician_id = technician_id;
        }

        private int technician_id;

        public TechnicianInfoBean getTechnicianInfo() {
            return technicianInfo;
        }

        public void setTechnicianInfo(TechnicianInfoBean technicianInfo) {
            this.technicianInfo = technicianInfo;
        }

        public int getDepartment_id() {
            return department_id;
        }

        public void setDepartment_id(int department_id) {
            this.department_id = department_id;
        }

        public ProcessorInfoBean getProcessorInfo() {
            return processorInfo;
        }

        public void setProcessorInfo(ProcessorInfoBean processorInfo) {
            this.processorInfo = processorInfo;
        }

        public int getParent_id() {
            return parent_id;
        }

        public void setParent_id(int parent_id) {
            this.parent_id = parent_id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public LeaderInfoBean getLeaderInfo() {
            return leaderInfo;
        }

        public void setLeaderInfo(LeaderInfoBean leaderInfo) {
            this.leaderInfo = leaderInfo;
        }

        public String getProcessor_id() {
            return processor_id;
        }

        public void setProcessor_id(String processor_id) {
            this.processor_id = processor_id;
        }

        public int getLeader_id() {
            return leader_id;
        }

        public void setLeader_id(int leader_id) {
            this.leader_id = leader_id;
        }

        public static class TechnicianInfoBean {
            /**
             * name :
             */

            private String name;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }

        public static class ProcessorInfoBean {
            /**
             * name : 传小军
             */

            private String name;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }

        public static class ResponsibleLeaderinfo {
            /**
             * name : 传小军
             */

            private String name;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }

        public static class LeaderInfoBean {
            /**
             * fileName : 2018
             * name : 李鸿武
             * id : 3968
             * uri : /pluploadDir/1546523841417.pdf
             */

            private String fileName;
            private String name;
            private int id;
            private String uri;

            public String getFileName() {
                return fileName;
            }

            public void setFileName(String fileName) {
                this.fileName = fileName;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getUri() {
                return uri;
            }

            public void setUri(String uri) {
                this.uri = uri;
            }
        }
    }
}
