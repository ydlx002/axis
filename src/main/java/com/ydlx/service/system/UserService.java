package com.ydlx.service.system;

import com.ydlx.domain.dto.UserDTO;
import com.ydlx.domain.info.UserInfo;
import com.ydlx.domain.vo.PageResultVO;
import com.ydlx.domain.vo.ResultVO;
import com.ydlx.domain.vo.UserVO;

/**
 * 用户管理服务接口层
 * 1. 账号/用户的增删改查，保证事务一致性
 * Created by ydlx on 2017/5/3.
 */
public interface UserService{

    /**
     * 根据用户登录账号获取用户信息
     * @param loginAccount 用户登录帐号
     * @return
     */
    UserInfo getUserByLoginAccount(String loginAccount);


    /**
     * 分页获取用户详细信息
     * @param currentPage 当前页码
     * @param pageSize 每页行数
     * @param info 用户查询条件
     * @return
     */
    PageResultVO<UserVO> getUserList(int currentPage, int pageSize, UserInfo info);


    /**
     * 新增用户
     * @param userInfo 用户信息
     * @param sysId 系统ID
     * @param userTypeId 用户类型
     * @return
     */
    ResultVO addUserInfo(UserInfo userInfo, String sysId, String userTypeId);


    /**
     * 删除用户
     * @param userId
     * @return
     */
    ResultVO deleteUserInfo(String userId);

    /***
     * 将用户从系统中移除，而非删除
     * @param userId
     * @param sysId
     * @return
     */
    ResultVO removeUserInfo(String userId, String sysId);

    /**
     * 更新用户信息
     * @param dto
     * @return
     */
    ResultVO updateUserInfo(UserDTO dto);

    /**
     * 修改用户密码
     * @param userId 用户ID
     * @param password 帐户密码
     * @return
     */
    ResultVO modifyPassword(String userId, String password);

}
