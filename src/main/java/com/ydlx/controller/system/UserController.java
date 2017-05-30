package com.ydlx.controller.system;

import com.ydlx.dao.UserMapper;
import com.ydlx.domain.info.UserInfo;
import com.ydlx.domain.vo.PageResultVO;
import com.ydlx.domain.vo.UserInfoVO;
import com.ydlx.domain.vo.request.user.QueryUserVO;
import com.ydlx.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ydlx on 2017/5/30.
 */
@RestController
@RequestMapping(value="/user")
public class UserController {

    @Autowired
    private UserMapper userMapper;

    public PageResultVO<UserInfoVO> getUserList(QueryUserVO request){
        UserInfo info = new UserInfo();
        info.setLoginAccount(request.getLoginAccount());
        info.setNickName(request.getNickName());
        info.setUserName(request.getUserName());
        List<UserInfo> userInfos = userMapper.getListByPage(request.getCurrentPage(), request.getCurrentPage(), info);
        if(userInfos.size() > 0){
            List<UserInfoVO> list = new ArrayList<UserInfoVO>();
            for(UserInfo userInfo : userInfos){
                UserInfoVO vo = new UserInfoVO();
                vo.setCreateTime(DateUtil.toDateFormat(userInfo.getCreateTime()));
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
            return new PageResultVO(list, request.getCurrentPage(), request.getPageSize(), count);
        }
        return null;
    }


}
