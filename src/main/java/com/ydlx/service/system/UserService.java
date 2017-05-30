package com.ydlx.service.system;

import com.ydlx.domain.info.UserInfo;

import java.util.List;

/**
 * 用户管理
 * Created by ydlx on 2017/5/3.
 */
public interface UserService extends BaseService<UserInfo>{

    /**
     * 根据用户登录账号获取用户信息
     * @param loginAccount
     * @return
     */
    UserInfo getUserByLoginAccount(String loginAccount);


    List<UserInfo> getUserList(int currentPage, int pageSize, UserInfo info);

}
