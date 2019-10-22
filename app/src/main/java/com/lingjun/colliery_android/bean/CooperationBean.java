package com.lingjun.colliery_android.bean;

import java.util.List;

/**
 * 作者: zengtao
 * 时间: 2019/4/12  15:11.
 * 注释:
 */
public class CooperationBean {

    /**
     * msg : 成功
     * code : 200
     * data : null
     * resultMaps : [{"departementName":"生产技术部","departementId":21,"leaderId":22},{"departementName":"综合采煤队","departementId":32,"leaderId":34},{"departementName":"综掘一队","departementId":166,"leaderId":167},{"departementName":"综掘二队","departementId":245,"leaderId":246},{"departementName":"综掘三队","departementId":320,"leaderId":322},{"departementName":"开拓一队","departementId":339,"leaderId":340},{"departementName":"开拓二队","departementId":341,"leaderId":342},{"departementName":"开拓三队","departementId":343,"leaderId":344},{"departementName":"储煤厂","departementId":345,"leaderId":346},{"departementName":"机电设备管理部","departementId":364,"leaderId":365},{"departementName":"选运队","departementId":471,"leaderId":472},{"departementName":"通风部","departementId":577,"leaderId":578},{"departementName":"通维队","departementId":582,"leaderId":583},{"departementName":"地测部","departementId":665,"leaderId":666},{"departementName":"调度指挥中心","departementId":672,"leaderId":674},{"departementName":"党群工作部","departementId":685,"leaderId":686},{"departementName":"工程规划管理部","departementId":691,"leaderId":692},{"departementName":"经营办","departementId":697,"leaderId":698},{"departementName":"财务部","departementId":708,"leaderId":709},{"departementName":"物资供应公司","departementId":715,"leaderId":716},{"departementName":"运销公司","departementId":740,"leaderId":741},{"departementName":"实业公司","departementId":773,"leaderId":774}]
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
        /**
         * departementName : 生产技术部
         * departementId : 21
         * leaderId : 22
         */

        private String departementName;
        private int departementId;
        private int leaderId;

        public String getDepartementName() {
            return departementName;
        }

        public void setDepartementName(String departementName) {
            this.departementName = departementName;
        }

        public int getDepartementId() {
            return departementId;
        }

        public void setDepartementId(int departementId) {
            this.departementId = departementId;
        }

        public int getLeaderId() {
            return leaderId;
        }

        public void setLeaderId(int leaderId) {
            this.leaderId = leaderId;
        }
    }
}
