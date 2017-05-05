package com.ydlx.service.system.impl;

import com.ydlx.dao.UserMapper;
import com.ydlx.domain.info.UserInfo;
import com.ydlx.domain.vo.ResultVo;
import com.ydlx.service.system.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by ydlx on 2017/5/3.
 */
@Service
public class UserServiceImpl  implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserInfo getInfoById(Integer id) {
        return userMapper.getById(id);
    }

    @Override
    public ResultVo addInfo(UserInfo userInfo) {
        ResultVo resultVo = new ResultVo();
        return resultVo;
    }

    @Override
    public ResultVo updateInfo(UserInfo userInfo) {
        ResultVo resultVo = new ResultVo();
        return resultVo;
    }

    @Override
    public ResultVo deleteInfo(Integer id) {
        ResultVo resultVo = new ResultVo();
        return resultVo;
    }

    @Override
    public UserInfo getUserByLoginAccount(String loginAccount) {
        return userMapper.getByLoginAccount(loginAccount);
    }
}
