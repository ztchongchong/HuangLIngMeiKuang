package com.lingjun.colliery_android.bean;

import java.util.List;

/**
 * 作者: zengtao
 * 时间: 2018/12/27  9:55.
 * 注释:
 */
public class WebViewBean {

    /**
     * msg : 成功
     * data : {"builtinrolelist":["SYSADMIN","SYSUSER","SYSTEM_USER","SYSTEM_DEPARTMENT","STDCHK_ADMIN","STDCHK_USER","STDCHK_HISTORY","STDCHK_ARCHIVE","STDCHK_PREDEFINE","STDCHK_USERMAN","STDCHK_END","STDFILE_ADMIN","STDFILE_USER","STDFILE_MAN","STDFILE_VERSION","TROUBLE_ADMIN","TROUBLE_USER","TROUBLE_MAN","TROUBLE_FATALMAN","TROUBLE_RANDOMCHECK","TROUBLE_CHECKHISTORY","TROUBLE_MANHISTORY","TROUBLE_ARCHIVE","TROUBLE_STDMAN","NOTICE_ADMIN","NOTICE_USER","NOTICE_END","DISOBEY_ADMIN","DISOBEY_USER","DISOBEY_END","RISKCONTROL_ADMIN","RISKCONTROL_USER","RISKCONTROL_PLAN","RISKCONTROL_RISK","RISKCONTROL_PREDEFINE","RISKCONTROL_IMPLEMENT","RISKCONTROL_HISTORY","RISKCONTROL_ARCHIVE","RISKCONTROL_SOURCE","RISKCONTROL_RECORD","RISKCONTROL_END","SYSTEM_AREA","ANALYSIS_ADMIN","ANALYSIS_USER","ANALYSIS_STDCHK_ALLCHECK","ANALYSIS_STDCHK_COUNT","ANALYSIS_STDCHK_SCORE","ANALYSIS_STDCHK_XIAOLV","ANALYSIS_STDCHK_RESULT","ANALYSIS_STDFILE_TYPE","ANALYSIS_STDFILE_ADD","ANALYSIS_STDFILE_DATE","ANALYSIS_TROUBLE_SOURCE","ANALYSIS_TROUBLE_GOVERN","ANALYSIS_TROUBLE_PROGRAMME","ANALYSIS_TROUBLE_DEPARTMENT","ANALYSIS_TROUBLE_DUIWU","ANALYSIS_RISKCONTROL_STANDARD","ANALYSIS_RISKCONTROL_DATE","ANALYSIS_RISKCONTROL_LIST","ANALYSIS_FXGK","ANALYSIS_MONITOR","ANALYSIS_END","STUDY_ADMIN","STUDY_USER","__END__"],"unitId":"25","CurrEmployeeno":"01080123"}
     * code : 200
     * resultMaps : []
     */

    private String msg;
    private DataBean data;
    private String code;
    private List<?> resultMaps;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<?> getResultMaps() {
        return resultMaps;
    }

    public void setResultMaps(List<?> resultMaps) {
        this.resultMaps = resultMaps;
    }

    public static class DataBean {
        /**
         * builtinrolelist : ["SYSADMIN","SYSUSER","SYSTEM_USER","SYSTEM_DEPARTMENT","STDCHK_ADMIN","STDCHK_USER","STDCHK_HISTORY","STDCHK_ARCHIVE","STDCHK_PREDEFINE","STDCHK_USERMAN","STDCHK_END","STDFILE_ADMIN","STDFILE_USER","STDFILE_MAN","STDFILE_VERSION","TROUBLE_ADMIN","TROUBLE_USER","TROUBLE_MAN","TROUBLE_FATALMAN","TROUBLE_RANDOMCHECK","TROUBLE_CHECKHISTORY","TROUBLE_MANHISTORY","TROUBLE_ARCHIVE","TROUBLE_STDMAN","NOTICE_ADMIN","NOTICE_USER","NOTICE_END","DISOBEY_ADMIN","DISOBEY_USER","DISOBEY_END","RISKCONTROL_ADMIN","RISKCONTROL_USER","RISKCONTROL_PLAN","RISKCONTROL_RISK","RISKCONTROL_PREDEFINE","RISKCONTROL_IMPLEMENT","RISKCONTROL_HISTORY","RISKCONTROL_ARCHIVE","RISKCONTROL_SOURCE","RISKCONTROL_RECORD","RISKCONTROL_END","SYSTEM_AREA","ANALYSIS_ADMIN","ANALYSIS_USER","ANALYSIS_STDCHK_ALLCHECK","ANALYSIS_STDCHK_COUNT","ANALYSIS_STDCHK_SCORE","ANALYSIS_STDCHK_XIAOLV","ANALYSIS_STDCHK_RESULT","ANALYSIS_STDFILE_TYPE","ANALYSIS_STDFILE_ADD","ANALYSIS_STDFILE_DATE","ANALYSIS_TROUBLE_SOURCE","ANALYSIS_TROUBLE_GOVERN","ANALYSIS_TROUBLE_PROGRAMME","ANALYSIS_TROUBLE_DEPARTMENT","ANALYSIS_TROUBLE_DUIWU","ANALYSIS_RISKCONTROL_STANDARD","ANALYSIS_RISKCONTROL_DATE","ANALYSIS_RISKCONTROL_LIST","ANALYSIS_FXGK","ANALYSIS_MONITOR","ANALYSIS_END","STUDY_ADMIN","STUDY_USER","__END__"]
         * unitId : 25
         * CurrEmployeeno : 01080123
         */

        private String unitId;
        private String CurrEmployeeno;
        private List<String> builtinrolelist;
        private String noUser;

        public String getNoUser() {
            return noUser;
        }

        public void setNoUser(String noUser) {
            this.noUser = noUser;
        }


        public String getUnitId() {
            return unitId;
        }

        public void setUnitId(String unitId) {
            this.unitId = unitId;
        }

        public String getCurrEmployeeno() {
            return CurrEmployeeno;
        }

        public void setCurrEmployeeno(String CurrEmployeeno) {
            this.CurrEmployeeno = CurrEmployeeno;
        }

        public List<String> getBuiltinrolelist() {
            return builtinrolelist;
        }

        public void setBuiltinrolelist(List<String> builtinrolelist) {
            this.builtinrolelist = builtinrolelist;
        }
    }
}
