package com.ydlx.domain.vo.request.user;

import com.ydlx.domain.vo.PageRequestVO;

/**
 * Created by ydlx on 2017/5/30.
 */
public class QueryUserVO extends PageRequestVO{

    /**登录账号*/
    private String loginAccount;

    /**用户姓名*/
    private String userName;

    /**用户昵称*/
    private String nickName;

    public String getLoginAccount() {
        return loginAccount;
    }

    public void setLoginAccount(String loginAccount) {
        this.loginAccount = loginAccount;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
}
