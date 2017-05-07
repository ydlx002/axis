package com.ydlx.domain.info;

import java.util.List;

/**
 * Created by ydlx on 2017/4/30.
 * 用户信息类
 */
public class UserInfo extends   BaseInfo{

    /**登录账号*/
    private String loginAccount;

    /**密码*/
    private  String password;

    /**邮箱*/
    private String email;

    /**用户名*/
    private String userName;

    /***手机号码*/
    private String mobile;

    /**用户昵称*/
    private String nickName;

    /**角色列表*/
    private List<RoleInfo> roleInfos;


    public String getLoginAccount() {
        return loginAccount;
    }

    public UserInfo setLoginAccount(String loginAccount) {
        this.loginAccount = loginAccount;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserInfo setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserInfo setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getUserName() {
        return userName;
    }

    public UserInfo setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public String getMobile() {
        return mobile;
    }

    public UserInfo setMobile(String mobile) {
        this.mobile = mobile;
        return this;
    }

    public String getNickName() {
        return nickName;
    }

    public UserInfo setNickName(String nickName) {
        this.nickName = nickName;
        return this;
    }

    public List<RoleInfo> getRoleInfos() {
        return roleInfos;
    }

    public UserInfo setRoleInfos(List<RoleInfo> roleInfos) {
        this.roleInfos = roleInfos;
        return this;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "loginAccount='" + loginAccount + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", userName='" + userName + '\'' +
                ", mobile='" + mobile + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
