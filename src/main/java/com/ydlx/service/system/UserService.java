package com.ydlx.service.system;

/**
 * Created by ydlx on 2017/5/3.
 */
public interface UserService<UserInfo> extends BaseService<UserInfo>{

    /**
     * 根据用户登录账号获取用户信息
     * @param loginAccount
     * @return
     */
    UserInfo getUserByLoginAccount(String loginAccount);

}
