package com.ydlx.domain.vo;

/**
 * Created by ydlx on 2017/5/30.
 */
public class UserInfoVO extends BaseVO{

    /**id*/
    private Integer id;

    /**登录账号*/
    private String loginAccount;

    /**用户姓名*/
    private String userName;

    /**电子邮箱*/
    private String email;

    /**手机号码*/
    private String mobile;

    /**昵称*/
    private String nickName;

    public Integer getId() {
        return id;
    }

    public UserInfoVO setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getLoginAccount() {
        return loginAccount;
    }

    public UserInfoVO setLoginAccount(String loginAccount) {
        this.loginAccount = loginAccount;
        return this;
    }

    public String getUserName() {
        return userName;
    }

    public UserInfoVO setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserInfoVO setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getMobile() {
        return mobile;
    }

    public UserInfoVO setMobile(String mobile) {
        this.mobile = mobile;
        return this;
    }

    public String getNickName() {
        return nickName;
    }

    public UserInfoVO setNickName(String nickName) {
        this.nickName = nickName;
        return this;
    }

    @Override
    public String toString() {
        return "UserInfoVO{" +
                "id=" + id +
                ", loginAccount='" + loginAccount + '\'' +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", mobile='" + mobile + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
