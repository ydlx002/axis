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

    /***角色id列表*/
    private List<Integer> roleIds;

    public String getLoginAccount() {
        return loginAccount;
    }

    public void setLoginAccount(String loginAccount) {
        this.loginAccount = loginAccount;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public List<Integer> getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(List<Integer> roleIds) {
        this.roleIds = roleIds;
    }
}
