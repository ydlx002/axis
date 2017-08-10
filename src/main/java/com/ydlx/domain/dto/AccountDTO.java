package com.ydlx.domain.dto;

import com.ydlx.domain.info.UserInfo;

/**
 * Created by ydlx on 2017/6/22.
 */
public class AccountDTO extends BaseDTO{

    /**用户ID*/
    private String userId;

    /**用户登录帐号*/
    private String loginAccount;

    /**帐号密码*/
    private String password;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

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

    @Override
    public String toString() {
        return "AccountDTO{" +
                "userId='" + userId + '\'' +
                ", loginAccount='" + loginAccount + '\'' +
                ", password='" + password + '\'' +
                "} " + super.toString();
    }

    public AccountDTO(){

    }

    public AccountDTO(UserInfo userInfo){
        super();
        this.setUserId(userInfo.getUserId());
        this.setLoginAccount(userInfo.getLoginAccount());
        this.setPassword(userInfo.getPassword());
        this.setOperatorId(userInfo.getOperatorId());
    }
}
