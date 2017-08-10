package com.ydlx.domain.dto;

import java.io.Serializable;

/**
 * Created by ydlx on 2017/7/28.
 */
public class SysUserDTO implements Serializable{

    /**系统ID*/
    private String sysId;

    /**系统名字*/
    private String sysName;

    /**用户ID*/
    private String userId;

    /**用户类型ID*/
    private String userTypeId;

    /**0 禁用 1启用*/
    private int enable;

    public String getSysId() {
        return sysId;
    }

    public SysUserDTO setSysId(String sysId) {
        this.sysId = sysId;
        return this;
    }

    public String getUserId() {
        return userId;
    }

    public SysUserDTO setUserId(String userId) {
        this.userId = userId;
        return this;
    }

    public String getUserTypeId() {
        return userTypeId;
    }

    public SysUserDTO setUserTypeId(String userTypeId) {
        this.userTypeId = userTypeId;
        return  this;
    }

    public int getEnable() {
        return enable;
    }

    public SysUserDTO setEnable(int enable) {
        this.enable = enable;
        return this;
    }

    public String getSysName() {
        return sysName;
    }

    public SysUserDTO setSysName(String sysName) {
        this.sysName = sysName;
        return this;
    }

    @Override
    public String toString() {
        return "SysUserDTO{" +
                "sysId='" + sysId + '\'' +
                ", sysName='" + sysName + '\'' +
                ", userId='" + userId + '\'' +
                ", userTypeId=" + userTypeId +
                ", enable=" + enable +
                '}';
    }
}
