package com.ydlx.service.system.impl;

import com.ydlx.dao.UserMapper;
import com.ydlx.domain.info.UserInfo;
import com.ydlx.domain.vo.ResultVO;
import com.ydlx.service.system.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public ResultVO addInfo(UserInfo userInfo) {
        ResultVO resultVO = new ResultVO();
        return resultVO;
    }

    @Override
    public ResultVO updateInfo(UserInfo userInfo) {
        ResultVO resultVO = new ResultVO();
        return resultVO;
    }

    @Override
    public ResultVO deleteInfo(Integer id) {
        ResultVO resultVO = new ResultVO();
        return resultVO;
    }

    @Override
    public UserInfo getUserByLoginAccount(String loginAccount) {
        return userMapper.getByLoginAccount(loginAccount);
    }

    @Override
    public List<UserInfo> getUserList(int currentPage, int pageSize, UserInfo info) {
        currentPage = currentPage > 0 ? currentPage : 1;
        int start = pageSize * (currentPage-1);
        return userMapper.getListByPage(start, pageSize, info);
    }
}
