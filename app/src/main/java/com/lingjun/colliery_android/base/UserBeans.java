package com.lingjun.colliery_android.base;

import com.blankj.utilcode.util.ToastUtils;
import com.lingjun.colliery_android.utils.SerializationUtils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.List;

/**
 * 作者: zengtao
 * 时间: 2019/5/17  14:58.
 * 注释:
 */
public class UserBeans implements Serializable {

    private static final String SPKey = "UserBean";
    private static final String DATAKey = "UserBeanDetails";
    /**
     * token : cff8e116-4c32-45bc-a658-c13d999d1c5e
     * errno : 0
     * message :
     * user : {"idcard":"","token":"4192ef46-2275-414e-b4b1-9eebbb6d4eac","pictureId":11868,"enabled":1,"external":0,"admin":0,"leaved":0,"employeeno":"01221137","id":249,"roleset":"//+87///////Af8D","pictureurl":"/pluploadDir/155356774982858a3b4d63c1e5.jpg","catagoryIds":"{\"riskcontrolGK\":\"1,2,3,4,5,6,7,8\",\"riskcontrolFX\":\"1,2,3,4,5,6,7,8\",\"stdchk\":\"all,1,16,37,82,144,164,187,222,244,278,301\"}","builtinrolelist":["SYSADMIN","SYSUSER","SYSTEM_USER","SYSTEM_DEPARTMENT","SYSTEM_DEPARTMENTUSER","STDCHK_ADMIN","STDCHK_USER","STDCHK_HISTORY","STDCHK_ARCHIVE","STDCHK_PREDEFINE","STDCHK_USERMAN","STDCHK_END","STDFILE_ADMIN","STDFILE_USER","STDFILE_MAN","STDFILE_VERSION","TROUBLE_ADMIN","TROUBLE_USER","TROUBLE_MANAGER","TROUBLE_FATALMAN","TROUBLE_RANDOMCHECK","TROUBLE_CHECKHISTORY","TROUBLE_MANHISTORY","TROUBLE_ARCHIVE","TROUBLE_STDMAN","NOTICE_ADMIN","NOTICE_USER","NOTICE_END","DISOBEY_ADMIN","DISOBEY_USER","DISOBEY_MANHISTORY","DISOBEY_ARCHIVE","DISOBEY_STDMAN","DISOBEY_MANAGER","DISOBEY_CLOSE","DISOBEY_END","RISKCONTROL_ADMIN","RISKCONTROL_USER","RISKCONTROL_PLAN","RISKCONTROL_RISK","RISKCONTROL_PREDEFINE","RISKCONTROL_IMPLEMENT","RISKCONTROL_HISTORY","RISKCONTROL_ARCHIVE","RISKCONTROL_SOURCE","RISKCONTROL_RECORD","RISKCONTROL_END","SYSTEM_AREA","ANALYSIS_ADMIN","ANALYSIS_USER","ANALYSIS_STDCHK_ALLCHECK","ANALYSIS_STDCHK_COUNT","ANALYSIS_STDCHK_SCORE","ANALYSIS_STDCHK_XIAOLV","ANALYSIS_STDCHK_RESULT","ANALYSIS_STDFILE_TYPE","ANALYSIS_STDFILE_ADD","ANALYSIS_STDFILE_DATE","ANALYSIS_TROUBLE_SOURCE","ANALYSIS_TROUBLE_GOVERN","ANALYSIS_TROUBLE_PROGRAMME","ANALYSIS_TROUBLE_DEPARTMENT","ANALYSIS_TROUBLE_DUIWU","ANALYSIS_DISOBEY_STANDARD","ANALYSIS_DISOBEY_DATE","ANALYSIS_DISOBEY_LIST","ANALYSIS_DISOBEY_DUIWU","ANALYSIS_DISOBEY_TUBIAO","ANALYSIS_DISOBEY_LEVEL","STUDY_END","SYSTEM_CONFIGORG","ANALYSIS_STDCHK_MAIN","ANALYSIS_STDFILE_MAIN","ANALYSIS_TROUBLE_MAIN","ANALYSIS_DISOBEY_MAIN","ANALYSIS_RISKCONTROL_MAIN","ANALYSIS_MONITORSCREEN_MAIN","ANALYSIS_BUREAU_MAIN","TROUBLE_PLAN"],"mobile":"","departmentnames":"安全监察部","signatureId":11867,"unitId":"25","registrationid":"100d85590968df53d3a","name":"王红伟","deleted":0,"sex":1}
     */

    private String token;
    private int errno;
    private String message;
    private UserBean user;


    public static UserBeans getInstance() {
        return SerializationUtils.GetSerialize(SPKey, DATAKey, UserBeans.class);
    }

    public static void saveUserBean(UserBeans mUser) {
        SerializationUtils.SaveSerialize(SPKey, DATAKey, mUser);
    }

    public static void clearUserBean() {
        SerializationUtils.ClearSerialize(SPKey, DATAKey);
    }


    /**
     * 序列化对象
     */
    private static String serialize(UserBeans person) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        String serStr = null;
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(person);
            serStr = byteArrayOutputStream.toString("ISO-8859-1");
            serStr = URLEncoder.encode(serStr, "UTF-8");
            objectOutputStream.close();
            byteArrayOutputStream.close();
        } catch (Exception e) {
            ToastUtils.showShort("序列化错误!");
        }
        return serStr;
    }

    /**
     * 反序列化对象
     */
    private static UserBeans deSerialization(String str) {
        UserBeans person = null;
        try {
            String redStr = URLDecoder.decode(str, "UTF-8");
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(redStr.getBytes("ISO-8859-1"));
            ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
            person = (UserBeans) objectInputStream.readObject();
            objectInputStream.close();
            byteArrayInputStream.close();
        } catch (Exception e) {
            ToastUtils.showShort("反序列化错误!");
        }

        return person;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getErrno() {
        return errno;
    }

    public void setErrno(int errno) {
        this.errno = errno;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public UserBean getUser() {
        return user;
    }

    public void setUser(UserBean user) {
        this.user = user;
    }

    public static class UserBean implements Serializable {
        /**
         * idcard :
         * token : 4192ef46-2275-414e-b4b1-9eebbb6d4eac
         * pictureId : 11868
         * enabled : 1
         * external : 0
         * admin : 0
         * leaved : 0
         * employeeno : 01221137
         * id : 249
         * roleset : //+87///////Af8D
         * pictureurl : /pluploadDir/155356774982858a3b4d63c1e5.jpg
         * catagoryIds : {"riskcontrolGK":"1,2,3,4,5,6,7,8","riskcontrolFX":"1,2,3,4,5,6,7,8","stdchk":"all,1,16,37,82,144,164,187,222,244,278,301"}
         * builtinrolelist : ["SYSADMIN","SYSUSER","SYSTEM_USER","SYSTEM_DEPARTMENT","SYSTEM_DEPARTMENTUSER","STDCHK_ADMIN","STDCHK_USER","STDCHK_HISTORY","STDCHK_ARCHIVE","STDCHK_PREDEFINE","STDCHK_USERMAN","STDCHK_END","STDFILE_ADMIN","STDFILE_USER","STDFILE_MAN","STDFILE_VERSION","TROUBLE_ADMIN","TROUBLE_USER","TROUBLE_MANAGER","TROUBLE_FATALMAN","TROUBLE_RANDOMCHECK","TROUBLE_CHECKHISTORY","TROUBLE_MANHISTORY","TROUBLE_ARCHIVE","TROUBLE_STDMAN","NOTICE_ADMIN","NOTICE_USER","NOTICE_END","DISOBEY_ADMIN","DISOBEY_USER","DISOBEY_MANHISTORY","DISOBEY_ARCHIVE","DISOBEY_STDMAN","DISOBEY_MANAGER","DISOBEY_CLOSE","DISOBEY_END","RISKCONTROL_ADMIN","RISKCONTROL_USER","RISKCONTROL_PLAN","RISKCONTROL_RISK","RISKCONTROL_PREDEFINE","RISKCONTROL_IMPLEMENT","RISKCONTROL_HISTORY","RISKCONTROL_ARCHIVE","RISKCONTROL_SOURCE","RISKCONTROL_RECORD","RISKCONTROL_END","SYSTEM_AREA","ANALYSIS_ADMIN","ANALYSIS_USER","ANALYSIS_STDCHK_ALLCHECK","ANALYSIS_STDCHK_COUNT","ANALYSIS_STDCHK_SCORE","ANALYSIS_STDCHK_XIAOLV","ANALYSIS_STDCHK_RESULT","ANALYSIS_STDFILE_TYPE","ANALYSIS_STDFILE_ADD","ANALYSIS_STDFILE_DATE","ANALYSIS_TROUBLE_SOURCE","ANALYSIS_TROUBLE_GOVERN","ANALYSIS_TROUBLE_PROGRAMME","ANALYSIS_TROUBLE_DEPARTMENT","ANALYSIS_TROUBLE_DUIWU","ANALYSIS_DISOBEY_STANDARD","ANALYSIS_DISOBEY_DATE","ANALYSIS_DISOBEY_LIST","ANALYSIS_DISOBEY_DUIWU","ANALYSIS_DISOBEY_TUBIAO","ANALYSIS_DISOBEY_LEVEL","STUDY_END","SYSTEM_CONFIGORG","ANALYSIS_STDCHK_MAIN","ANALYSIS_STDFILE_MAIN","ANALYSIS_TROUBLE_MAIN","ANALYSIS_DISOBEY_MAIN","ANALYSIS_RISKCONTROL_MAIN","ANALYSIS_MONITORSCREEN_MAIN","ANALYSIS_BUREAU_MAIN","TROUBLE_PLAN"]
         * mobile :
         * departmentnames : 安全监察部
         * signatureId : 11867
         * unitId : 25
         * registrationid : 100d85590968df53d3a
         * name : 王红伟
         * deleted : 0
         * sex : 1
         */

        private String idcard;
        private String token;
        private int pictureId;
        private int enabled;
        private int external;
        private int admin;
        private int leaved;
        private String employeeno;
        private int id;
        private String roleset;
        private String pictureurl;
        private String catagoryIds;
        private String mobile;
        private String departmentnames;
        private int signatureId;
        private String unitId;
        private String registrationid;
        private String name;
        private int deleted;
        private int sex;
        private List<String> builtinrolelist;

        public String getIdcard() {
            return idcard;
        }

        public void setIdcard(String idcard) {
            this.idcard = idcard;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public int getPictureId() {
            return pictureId;
        }

        public void setPictureId(int pictureId) {
            this.pictureId = pictureId;
        }

        public int getEnabled() {
            return enabled;
        }

        public void setEnabled(int enabled) {
            this.enabled = enabled;
        }

        public int getExternal() {
            return external;
        }

        public void setExternal(int external) {
            this.external = external;
        }

        public int getAdmin() {
            return admin;
        }

        public void setAdmin(int admin) {
            this.admin = admin;
        }

        public int getLeaved() {
            return leaved;
        }

        public void setLeaved(int leaved) {
            this.leaved = leaved;
        }

        public String getEmployeeno() {
            return employeeno;
        }

        public void setEmployeeno(String employeeno) {
            this.employeeno = employeeno;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getRoleset() {
            return roleset;
        }

        public void setRoleset(String roleset) {
            this.roleset = roleset;
        }

        public String getPictureurl() {
            return pictureurl;
        }

        public void setPictureurl(String pictureurl) {
            this.pictureurl = pictureurl;
        }

        public String getCatagoryIds() {
            return catagoryIds;
        }

        public void setCatagoryIds(String catagoryIds) {
            this.catagoryIds = catagoryIds;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public String getDepartmentnames() {
            return departmentnames;
        }

        public void setDepartmentnames(String departmentnames) {
            this.departmentnames = departmentnames;
        }

        public int getSignatureId() {
            return signatureId;
        }

        public void setSignatureId(int signatureId) {
            this.signatureId = signatureId;
        }

        public String getUnitId() {
            return unitId;
        }

        public void setUnitId(String unitId) {
            this.unitId = unitId;
        }

        public String getRegistrationid() {
            return registrationid;
        }

        public void setRegistrationid(String registrationid) {
            this.registrationid = registrationid;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getDeleted() {
            return deleted;
        }

        public void setDeleted(int deleted) {
            this.deleted = deleted;
        }

        public int getSex() {
            return sex;
        }

        public void setSex(int sex) {
            this.sex = sex;
        }

        public List<String> getBuiltinrolelist() {
            return builtinrolelist;
        }

        public void setBuiltinrolelist(List<String> builtinrolelist) {
            this.builtinrolelist = builtinrolelist;
        }
    }
}
