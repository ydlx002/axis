package com.ydlx.domain.info;

/**
 * Created by ydlx on 2017/4/30.
 * 用户信息类
 */
public class UserInfo extends   BaseInfo{

    /**用户账号*/
    private String loginAccount;

    /**登录密码*/
    private String password;

    /**用户ID*/
    private String userId;

    /**用户昵称*/
    private String nickName;

    /**用户姓名*/
    private String fullName;

    /**邮箱*/
    private String email;

    /**手机号码*/
    private String mobile;

    /**备注*/
    private String remark;


    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserId() {
        return userId;
    }

    public UserInfo setUserId(String userId) {
        this.userId = userId;
        return this;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getLoginAccount() {
        return loginAccount;
    }

    public UserInfo setLoginAccount(String loginAccount) {
        this.loginAccount = loginAccount;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserInfo setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getMobile() {
        return mobile;
    }

    public UserInfo setMobile(String mobile) {
        this.mobile = mobile;
        return this;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "loginAccount='" + loginAccount + '\'' +
                ", password='" + password + '\'' +
                ", userId='" + userId + '\'' +
                ", nickName='" + nickName + '\'' +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", mobile='" + mobile + '\'' +
                ", remark='" + remark + '\'' +
                "} " + super.toString();
    }
}
