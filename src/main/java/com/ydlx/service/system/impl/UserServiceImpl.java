package com.ydlx.service.system.impl;

import com.ydlx.dao.UserMapper;
import com.ydlx.domain.info.UserInfo;
import com.ydlx.domain.vo.PageResultVO;
import com.ydlx.domain.vo.ResultVO;
import com.ydlx.domain.vo.UserInfoVO;
import com.ydlx.service.system.UserService;
import com.ydlx.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public PageResultVO<UserInfoVO> getUserList(int currentPage, int pageSize, UserInfo info) {
        PageResultVO<UserInfoVO> pageResultVO = new PageResultVO<UserInfoVO>();
        currentPage = currentPage > 0 ? currentPage : 1;
        int start = pageSize * (currentPage-1);
        List<UserInfo> userInfos = userMapper.getListByPage(start, pageSize, info);
        if(userInfos.size() > 0){
            List<UserInfoVO> list = new ArrayList<UserInfoVO>();
            for(UserInfo userInfo : userInfos){
                UserInfoVO vo = new UserInfoVO();
                vo.setCreateTime(DateUtil.toDateTimeFormat(userInfo.getCreateTime()));
                vo.setModifyTime(DateUtil.toDateTimeFormat(userInfo.getModifyTime()));
                vo.setOperator(userInfo.getOperator());
                vo.setUserName(userInfo.getUserName())
                        .setNickName(userInfo.getNickName())
                        .setEmail(userInfo.getEmail())
                        .setId(userInfo.getId())
                        .setLoginAccount(userInfo.getLoginAccount())
                        .setMobile(userInfo.getMobile());
                list.add(vo);
            }
            int count = userMapper.getTotalCount(info);
            return new PageResultVO(list, currentPage, pageSize, count);
        }
        return null;
    }
}
