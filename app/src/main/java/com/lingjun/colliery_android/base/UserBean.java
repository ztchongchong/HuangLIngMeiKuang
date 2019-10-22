package com.lingjun.colliery_android.base;

import com.blankj.utilcode.util.ToastUtils;
import com.lingjun.colliery_android.bean.UpLoadImageBean;
import com.lingjun.colliery_android.utils.SerializationUtils;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;

/**
 * Created by nefa on 2018/5/23.
 */

public class UserBean implements Serializable {

    private static final String SPKey = "UserBean";
    private static final String DATAKey = "UserBeanDetails";


    private int errno;
    private String message;
    private String token;
    private UserBean.DataBean user;



    public static UserBean getInstance(){
        return SerializationUtils.GetSerialize(SPKey,DATAKey,UserBean.class);
    }

    public static void saveUserBean(UserBean mUser){
        SerializationUtils.SaveSerialize(SPKey,DATAKey,mUser);
    }

    public static void clearUserBean(){
        SerializationUtils.ClearSerialize(SPKey,DATAKey);
    }


    /**
     * 序列化对象
     */
    private static String serialize(UserBean person) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        String serStr = null;
        try{
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(person);
            serStr = byteArrayOutputStream.toString("ISO-8859-1");
            serStr = URLEncoder.encode(serStr, "UTF-8");
            objectOutputStream.close();
            byteArrayOutputStream.close();
        }catch (Exception e){
            ToastUtils.showShort("序列化错误!");
        }
        return serStr;
    }

    /**
     * 反序列化对象
     */
    private static UserBean deSerialization(String str){
        UserBean person = null;
        try {
            String redStr = URLDecoder.decode(str, "UTF-8");
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(redStr.getBytes("ISO-8859-1"));
            ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
            person = (UserBean) objectInputStream.readObject();
            objectInputStream.close();
            byteArrayInputStream.close();
        }catch (Exception e){
            ToastUtils.showShort("反序列化错误!");
        }

        return person;
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

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public DataBean getUser() {
        return user;
    }

    public void setUser(DataBean user) {
        this.user = user;
    }

    public static void saveUserBean(UpLoadImageBean userBean) {
    }


    public static class DataBean implements Serializable{
        /**
         * id : 95
         * username : null
         * password : null
         * employeeno : 01080123
         * name : 孔德昊
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
         * roleset : /ve8b99/Dgki
         * builtinrolelist : ["SYSUSER","SYSTEM_USER","SYSTEM_DEPARTMENT","SYSTEM_DEPARTMENTUSER","STDCHK_ADMIN","STDCHK_USER","STDCHK_HISTORY","STDCHK_ARCHIVE","STDCHK_PREDEFINE","STDCHK_USERMAN","STDFILE_ADMIN","STDFILE_USER","STDFILE_MAN","STDFILE_VERSION","TROUBLE_ADMIN","TROUBLE_USER","TROUBLE_MAN","TROUBLE_FATALMAN","TROUBLE_RANDOMCHECK","TROUBLE_CHECKHISTORY","TROUBLE_MANHISTORY","TROUBLE_ARCHIVE","TROUBLE_STDMAN","NOTICE_ADMIN","NOTICE_USER","DISOBEY_ADMIN","DISOBEY_USER","DISOBEY_MANHISTORY","DISOBEY_ARCHIVE","DISOBEY_STDMAN","RISKCONTROL_ADMIN","RISKCONTROL_USER","RISKCONTROL_PLAN","RISKCONTROL_RISK","RISKCONTROL_PREDEFINE","RISKCONTROL_IMPLEMENT","RISKCONTROL_HISTORY","RISKCONTROL_ARCHIVE","RISKCONTROL_SOURCE","ANALYSIS_ADMIN","ANALYSIS_USER","ANALYSIS_STDCHK_ALLCHECK","ANALYSIS_STDFILE_TYPE","ANALYSIS_TROUBLE_STANDARD","ANALYSIS_RISKCONTROL_STANDARD","ANALYSIS_MONITOR"]
         * pictureurl : null
         * catagoryIds : {"riskcontrolGK":"","riskcontrolFX":"","stdchk":"all,1,16,37"}
         * departmentnames : 安质科
         */

        private int id;
        private String username;
        private String password;
        private String employeeno;
        private String name;
        private String mobile;
        private String idcard;
        private int sex;
        private int external;
        private int enabled;
        private int leaved;
        private int deleted;
        private String contactinfo;
        private String email;
        private int admin;
        private String sort;
        private String remark;
        private String pictureId;
        private String roleset;
        private String pictureurl;
        private String catagoryIds;
        private String departmentnames;
        private String studyappurl;
        private String unitId;
        private ArrayList<String> builtinrolelist;

        public String getRegistrationid() {
            return registrationid;
        }

        public void setRegistrationid(String registrationid) {
            this.registrationid = registrationid;
        }

        private String registrationid;

        public String getStudyappurl() {
            return studyappurl;
        }

        public void setStudyappurl(String studyappurl) {
            this.studyappurl = studyappurl;
        }

        public String getUnitId() {
            return unitId;
        }

        public void setUnitId(String unitId) {
            this.unitId = unitId;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
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

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public String getIdcard() {
            return idcard;
        }

        public void setIdcard(String idcard) {
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

        public String getContactinfo() {
            return contactinfo;
        }

        public void setContactinfo(String contactinfo) {
            this.contactinfo = contactinfo;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public int getAdmin() {
            return admin;
        }

        public void setAdmin(int admin) {
            this.admin = admin;
        }

        public String getSort() {
            return sort;
        }

        public void setSort(String sort) {
            this.sort = sort;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        public String getPictureId() {
            return pictureId;
        }

        public void setPictureId(String pictureId) {
            this.pictureId = pictureId;
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

        public String getDepartmentnames() {
            return departmentnames;
        }

        public void setDepartmentnames(String departmentnames) {
            this.departmentnames = departmentnames;
        }

        public ArrayList<String> getBuiltinrolelist() {
            return builtinrolelist;
        }

        public void setBuiltinrolelist(ArrayList<String> builtinrolelist) {
            this.builtinrolelist = builtinrolelist;
        }
    }
}
