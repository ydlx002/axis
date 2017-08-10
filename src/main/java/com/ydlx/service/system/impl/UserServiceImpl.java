package com.ydlx.service.system.impl;

import com.ydlx.constants.ResultType;
import com.ydlx.dao.SysUserMapper;
import com.ydlx.dao.UserMapper;
import com.ydlx.domain.dto.AccountDTO;
import com.ydlx.domain.dto.CondictionDTO;
import com.ydlx.domain.dto.SysUserDTO;
import com.ydlx.domain.dto.UserDTO;
import com.ydlx.domain.info.UserInfo;
import com.ydlx.domain.vo.PageResultVO;
import com.ydlx.domain.vo.ResultVO;
import com.ydlx.domain.vo.UserVO;
import com.ydlx.service.system.UserService;
import com.ydlx.utils.MD5Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by ydlx on 2017/5/3.
 */
@Service
public class UserServiceImpl  implements UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Resource
    private UserMapper userMapper;

    @Resource
    private SysUserMapper sysUserMapper;


    /**根据登录帐号获取用户信息*/
    @Override
    public UserInfo getUserByLoginAccount(String loginAccount) {
        List<UserInfo> list = userMapper.getInfoList(new UserInfo().setLoginAccount(loginAccount));
        return list.size()>0 ? list.get(0) : null;
    }

    @Override
    public PageResultVO<UserVO> getUserList(int currentPage, int pageSize, UserInfo info) {
        PageResultVO<UserVO> pageResultVO = new PageResultVO<UserVO>();
        currentPage = currentPage > 0 ? currentPage : 1;
        int start = pageSize * (currentPage-1);
        CondictionDTO condictionDTO = new CondictionDTO().setStart(start).setPageSize(pageSize).setDto(info);
        List<UserInfo> userInfos = userMapper.getListByPage(condictionDTO);
        if(userInfos.size() > 0){
            List<UserVO> list = new ArrayList<UserVO>();
            for(UserInfo userInfo : userInfos){
                UserVO vo = new UserVO();
                vo.setFullName(userInfo.getFullName());
                vo.setUserId(userInfo.getUserId());
                vo.setEmail(userInfo.getEmail());
                vo.setLoginAccount(userInfo.getLoginAccount());
                vo.setMobile(userInfo.getMobile());
                vo.setNickName(userInfo.getNickName());
                vo.setCreateTime(userInfo.getCreateTime());
                vo.setModifyTime(userInfo.getUpdateTime());
                vo.setOperator(userInfo.getOperator());
                list.add(vo);
            }
            int count = userMapper.getTotalCount(condictionDTO);
            return new PageResultVO(list, currentPage, pageSize, count);
        }
        return pageResultVO;
    }

    @Override
    public ResultVO addUserInfo(UserInfo userInfo, String sysId, String userTypeId) {
        //1. 查询账号是否已经注册
        if(userMapper.getInfoList(new UserInfo().setLoginAccount(userInfo.getLoginAccount())).size() > 0){
            return new ResultVO(ResultType.ACCOUNTEXISTS);
        }
        //2. 校验账号下手机号是否已经存在
        if(userMapper.getInfoList(new UserInfo().setMobile(userInfo.getMobile())).size() > 0){
            return new ResultVO(ResultType.MOBILEXISTS);
        }
        //3. 校验账号下邮箱是否已经存在
        if(userMapper.getInfoList(new UserInfo().setMobile(userInfo.getMobile())).size() > 0){
            return new ResultVO(ResultType.MOBILEXISTS);
        }
        //4. 账号和用户信息入库
        String userId = UUID.randomUUID().toString().replace("-","").trim();
        userInfo.setUserId(userId);
        userInfo.setPassword(MD5Util.passwordEncoder(userInfo.getPassword()));
        if(userMapper.insertUser(new UserDTO(userInfo)) && userMapper.insertAccount(new AccountDTO(userInfo))){
            if(!StringUtils.isEmpty(sysId)&&!StringUtils.isEmpty(userTypeId)){
                SysUserDTO sysUserDTO = new SysUserDTO();
                sysUserDTO.setUserId(userId);
                sysUserDTO.setEnable(1);
                sysUserDTO.setUserTypeId(userTypeId);
                //把当前用户归档到指定系统中
                sysUserMapper.insertSysUser(sysUserDTO);
            }
            return new ResultVO(ResultType.SUCCESS);
        }
        return new ResultVO(ResultType.FAIL);
    }

    @Override
    public ResultVO deleteUserInfo(String userId) {
        List<SysUserDTO> list = sysUserMapper.selectList(new SysUserDTO().setUserId(userId).setEnable(1));
        if(list.size() > 0){
            return new ResultVO(ResultType.EFFECTIVEACCOUNT);
        }
        if(userMapper.deleteAccount(userId) && userMapper.deleteUser(userId)){
            return new ResultVO(ResultType.SUCCESS);
        }
        return new ResultVO(ResultType.FAIL);
    }

    @Override
    public ResultVO removeUserInfo(String userId, String sysId) {
        if(sysUserMapper.delete(sysId,userId)){
            return new ResultVO(ResultType.SUCCESS);
        }
        return new ResultVO(ResultType.FAIL);
    }

    @Override
    public ResultVO updateUserInfo(UserDTO dto) {
        if(userMapper.updateUser(dto)){
            return new ResultVO(ResultType.SUCCESS);
        }
        return new ResultVO(ResultType.FAIL);
    }

    @Override
    public ResultVO modifyPassword(String userId, String password) {
        if(userMapper.updatePassword(userId,MD5Util.passwordEncoder(password))){
            return new ResultVO(ResultType.SUCCESS);
        }
        return new ResultVO(ResultType.FAIL);
    }

}
