package com.ydlx.domain.dto;

import com.ydlx.domain.info.UserInfo;

/**
 * 用户信息
 * Created by ydlx on 2017/6/22.
 */
public class UserDTO extends BaseDTO{

    /**用户ID*/
    private String userId;

    /**系统账号*/
    private String loginAccount;

    /**用户姓名*/
    private String fullName;

    /**用户昵称*/
    private String nickName;

    /**用户邮箱*/
    private String email;

    /**联系电话*/
    private String mobile;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getLoginAccount() {
        return loginAccount;
    }

    public void setLoginAccount(String loginAccount) {
        this.loginAccount = loginAccount;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "userId='" + userId + '\'' +
                ", loginAccount='" + loginAccount + '\'' +
                ", fullName='" + fullName + '\'' +
                ", nickName='" + nickName + '\'' +
                ", email='" + email + '\'' +
                ", mobile='" + mobile + '\'' +
                "} " + super.toString();
    }

    public UserDTO(){

    }

    public UserDTO(UserInfo userInfo){
        super();
        this.setFullName(userInfo.getFullName());
        this.setEmail(userInfo.getEmail());
        this.setUserId(userInfo.getUserId());
        this.setMobile(userInfo.getMobile());
        this.setNickName(userInfo.getNickName());
        this.setOperatorId(userInfo.getOperatorId());
    }
}
