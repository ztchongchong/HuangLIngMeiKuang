package com.lingjun.colliery_android.bean;

import java.io.Serializable;

/**
 * 作者: lihuan
 * 时间: 2018/11/20 17:53刚刚
 * 说明: 发达水电费
 */
public class ResponsibleRemarkBean implements Serializable{

    /**
     * score : 0
     * money : 0
     * remark :  3333333sssss333333
     * departmentId : 48
     * departmentName : 综采队
     * leaderId : 1326
     * leaderName : 郭高民
     * userId : 1326
     * userName : 郭高民
     */

    private String score;
    private String money;
    private String remark;
    private String departmentId;
    private String departmentName;
    private String leaderId;
    private String leaderName;
    private String userId;
    private String userName;

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getLeaderId() {
        return leaderId;
    }

    public void setLeaderId(String leaderId) {
        this.leaderId = leaderId;
    }

    public String getLeaderName() {
        return leaderName;
    }

    public void setLeaderName(String leaderName) {
        this.leaderName = leaderName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
