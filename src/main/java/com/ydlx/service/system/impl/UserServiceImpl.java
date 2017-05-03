package com.ydlx.service.system.impl;

import com.ydlx.dao.UserMapper;
import com.ydlx.domain.info.UserInfo;
import com.ydlx.domain.vo.ResultVo;
import com.ydlx.service.system.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by zhenhua.li on 2017/5/3.
 */
@Service
public class UserServiceImpl  implements UserService<UserInfo> {

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserInfo getInfoById(Integer id) {
        return null;
    }

    @Override
    public ResultVo addInfo(UserInfo userInfo) {
        return null;
    }

    @Override
    public ResultVo updateInfo(UserInfo userInfo) {
        return null;
    }

    @Override
    public ResultVo deleteInfo(Integer id) {
        return null;
    }
}
