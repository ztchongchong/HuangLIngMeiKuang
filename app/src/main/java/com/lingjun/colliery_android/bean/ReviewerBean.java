package com.lingjun.colliery_android.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nefa on 2018/11/17.
 */

public class ReviewerBean {

    /**
     * msg : 成功
     * code : 200
     * data : {"leadlist":[{"id":23,"username":null,"password":null,"employeeno":"01062397","name":"张建忠","mobile":null,"idcard":null,"sex":1,"external":0,"enabled":1,"leaved":0,"deleted":0,"contactinfo":null,"email":null,"admin":0,"sort":null,"remark":null,"pictureId":null,"roleset":"AACIAAI=","builtinrolelist":null,"pictureurl":null,"catagoryIds":null,"departmentnames":null},{"id":39,"username":null,"password":null,"employeeno":"01062394","name":"段玉喜","mobile":null,"idcard":null,"sex":1,"external":0,"enabled":1,"leaved":0,"deleted":0,"contactinfo":null,"email":null,"admin":0,"sort":null,"remark":null,"pictureId":null,"roleset":"AAAAAAI=","builtinrolelist":null,"pictureurl":null,"catagoryIds":null,"departmentnames":null},{"id":1326,"username":null,"password":null,"employeeno":"01062433","name":"郭高民","mobile":null,"idcard":null,"sex":1,"external":0,"enabled":1,"leaved":0,"deleted":0,"contactinfo":null,"email":null,"admin":0,"sort":null,"remark":null,"pictureId":1683,"roleset":"/ve8L99///9f","builtinrolelist":null,"pictureurl":null,"catagoryIds":"{\"riskcontrolGK\":\"1,2,3,4,5\",\"riskcontrolFX\":\"1,2,3,4,5\",\"stdchk\":\"all,1,16,37,82,144,164,187,222,244,278,301\"}","departmentnames":null}],"closeappeal":"1","url":"http://192.168.1.183:8888/safety/","extralist":[{"id":1,"name":"帮教","number":1,"enabled":"1","deleted":"0","flags":0,"remark":"帮教"},{"id":2,"name":"停工","number":2,"enabled":"1","deleted":"0","flags":0,"remark":"停工"},{"id":3,"name":"培训","number":3,"enabled":"1","deleted":"0","flags":0,"remark":"培训"}]}
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
        /**
         * leadlist : [{"id":23,"username":null,"password":null,"employeeno":"01062397","name":"张建忠","mobile":null,"idcard":null,"sex":1,"external":0,"enabled":1,"leaved":0,"deleted":0,"contactinfo":null,"email":null,"admin":0,"sort":null,"remark":null,"pictureId":null,"roleset":"AACIAAI=","builtinrolelist":null,"pictureurl":null,"catagoryIds":null,"departmentnames":null},{"id":39,"username":null,"password":null,"employeeno":"01062394","name":"段玉喜","mobile":null,"idcard":null,"sex":1,"external":0,"enabled":1,"leaved":0,"deleted":0,"contactinfo":null,"email":null,"admin":0,"sort":null,"remark":null,"pictureId":null,"roleset":"AAAAAAI=","builtinrolelist":null,"pictureurl":null,"catagoryIds":null,"departmentnames":null},{"id":1326,"username":null,"password":null,"employeeno":"01062433","name":"郭高民","mobile":null,"idcard":null,"sex":1,"external":0,"enabled":1,"leaved":0,"deleted":0,"contactinfo":null,"email":null,"admin":0,"sort":null,"remark":null,"pictureId":1683,"roleset":"/ve8L99///9f","builtinrolelist":null,"pictureurl":null,"catagoryIds":"{\"riskcontrolGK\":\"1,2,3,4,5\",\"riskcontrolFX\":\"1,2,3,4,5\",\"stdchk\":\"all,1,16,37,82,144,164,187,222,244,278,301\"}","departmentnames":null}]
         * closeappeal : 1
         * url : http://192.168.1.183:8888/safety/
         * extralist : [{"id":1,"name":"帮教","number":1,"enabled":"1","deleted":"0","flags":0,"remark":"帮教"},{"id":2,"name":"停工","number":2,"enabled":"1","deleted":"0","flags":0,"remark":"停工"},{"id":3,"name":"培训","number":3,"enabled":"1","deleted":"0","flags":0,"remark":"培训"}]
         */

        private String closeappeal;
        private String url;
        private ArrayList<LeadlistBean> leadlist;
        private ArrayList<ExtralistBean> extralist;

        public String getCloseappeal() {
            return closeappeal;
        }

        public void setCloseappeal(String closeappeal) {
            this.closeappeal = closeappeal;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public ArrayList<LeadlistBean> getLeadlist() {
            return leadlist;
        }

        public void setLeadlist(ArrayList<LeadlistBean> leadlist) {
            this.leadlist = leadlist;
        }

        public ArrayList<ExtralistBean> getExtralist() {
            return extralist;
        }

        public void setExtralist(ArrayList<ExtralistBean> extralist) {
            this.extralist = extralist;
        }

        public static class LeadlistBean {
            /**
             * id : 23
             * username : null
             * password : null
             * employeeno : 01062397
             * name : 张建忠
             * mobile : null
             * idcard : null
             * sex : 1
             * external : 0
             * enabled : 1
             * leaved : 0
             * deleted : 0
             * contactinfo : null
             * email : null
             * admin : 0
             * sort : null
             * remark : null
             * pictureId : null
             * roleset : AACIAAI=
             * builtinrolelist : null
             * pictureurl : null
             * catagoryIds : null
             * departmentnames : null
             */

            private int id;
            private Object username;
            private Object password;
            private String employeeno;
            private String name;
            private Object mobile;
            private Object idcard;
            private int sex;
            private int external;
            private int enabled;
            private int leaved;
            private int deleted;
            private Object contactinfo;
            private Object email;
            private int admin;
            private Object sort;
            private Object remark;
            private Object pictureId;
            private String roleset;
            private Object builtinrolelist;
            private Object pictureurl;
            private Object catagoryIds;
            private Object departmentnames;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public Object getUsername() {
                return username;
            }

            public void setUsername(Object username) {
                this.username = username;
            }

            public Object getPassword() {
                return password;
            }

            public void setPassword(Object password) {
                this.password = password;
            }

            public String getEmployeeno() {
                return employeeno;
            }

            public void setEmployeeno(String employeeno) {
                this.employeeno = employeeno;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public Object getMobile() {
                return mobile;
            }

            public void setMobile(Object mobile) {
                this.mobile = mobile;
            }

            public Object getIdcard() {
                return idcard;
            }

            public void setIdcard(Object idcard) {
                this.idcard = idcard;
            }

            public int getSex() {
                return sex;
            }

            public void setSex(int sex) {
                this.sex = sex;
            }

            public int getExternal() {
                return external;
            }

            public void setExternal(int external) {
                this.external = external;
            }

            public int getEnabled() {
                return enabled;
            }

            public void setEnabled(int enabled) {
                this.enabled = enabled;
            }

            public int getLeaved() {
                return leaved;
            }

            public void setLeaved(int leaved) {
                this.leaved = leaved;
            }

            public int getDeleted() {
                return deleted;
            }

            public void setDeleted(int deleted) {
                this.deleted = deleted;
            }

            public Object getContactinfo() {
                return contactinfo;
            }

            public void setContactinfo(Object contactinfo) {
                this.contactinfo = contactinfo;
            }

            public Object getEmail() {
                return email;
            }

            public void setEmail(Object email) {
                this.email = email;
            }

            public int getAdmin() {
                return admin;
            }

            public void setAdmin(int admin) {
                this.admin = admin;
            }

            public Object getSort() {
                return sort;
            }

            public void setSort(Object sort) {
                this.sort = sort;
            }

            public Object getRemark() {
                return remark;
            }

            public void setRemark(Object remark) {
                this.remark = remark;
            }

            public Object getPictureId() {
                return pictureId;
            }

            public void setPictureId(Object pictureId) {
                this.pictureId = pictureId;
            }

            public String getRoleset() {
                return roleset;
            }

            public void setRoleset(String roleset) {
                this.roleset = roleset;
            }

            public Object getBuiltinrolelist() {
                return builtinrolelist;
            }

            public void setBuiltinrolelist(Object builtinrolelist) {
                this.builtinrolelist = builtinrolelist;
            }

            public Object getPictureurl() {
                return pictureurl;
            }

            public void setPictureurl(Object pictureurl) {
                this.pictureurl = pictureurl;
            }

            public Object getCatagoryIds() {
                return catagoryIds;
            }

            public void setCatagoryIds(Object catagoryIds) {
                this.catagoryIds = catagoryIds;
            }

            public Object getDepartmentnames() {
                return departmentnames;
            }

            public void setDepartmentnames(Object departmentnames) {
                this.departmentnames = departmentnames;
            }
        }

        public static class ExtralistBean {
            /**
             * id : 1
             * name : 帮教
             * number : 1
             * enabled : 1
             * deleted : 0
             * flags : 0
             * remark : 帮教
             */

            private int id;
            private String name;
            private int number;
            private String enabled;
            private String deleted;
            private int flags;
            private String remark;

            public boolean isSelect() {
                return isSelect;
            }

            public void setSelect(boolean select) {
                isSelect = select;
            }

            private boolean isSelect;

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

            public int getNumber() {
                return number;
            }

            public void setNumber(int number) {
                this.number = number;
            }

            public String getEnabled() {
                return enabled;
            }

            public void setEnabled(String enabled) {
                this.enabled = enabled;
            }

            public String getDeleted() {
                return deleted;
            }

            public void setDeleted(String deleted) {
                this.deleted = deleted;
            }

            public int getFlags() {
                return flags;
            }

            public void setFlags(int flags) {
                this.flags = flags;
            }

            public String getRemark() {
                return remark;
            }

            public void setRemark(String remark) {
                this.remark = remark;
            }
        }
    }
}
