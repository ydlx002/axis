package com.ydlx.dao;

import com.ydlx.domain.info.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by ydlx on 2017/4/29.
 */
@Mapper
public interface UserMapper {

        /**
         *  分页获取用户列表
         * @param start
         * @param pageSize
         * @param info
         * @return
         */
        List<UserInfo> getListByPage(@Param("start") int start, @Param("pageSize") int pageSize, UserInfo info);

        /***
         * 根据ID获取用户的信息
         * @param id
         * @return
         */
        UserInfo getById(Integer id);

        /***
         * 根据用户登录帐号获取用户信息
         * @param loginAccount
         * @return
         */
        UserInfo getByLoginAccount(@Param("loginAccount")String loginAccount);

        /**
         * 写入用户信息
         * @param userInfo
         * @return
         */
        boolean insert(UserInfo userInfo);

        /***
         * 更新用户信息
         * @param userInfo
         * @return
         */
        boolean update(UserInfo userInfo);

        /***
         * 删除用户信息
         * @param id
         * @return
         */
        boolean delete(@Param("id") Integer id);
}
