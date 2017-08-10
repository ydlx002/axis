package com.ydlx.controller.system;

import com.ydlx.domain.info.UserInfo;
import com.ydlx.domain.vo.PageResultVO;
import com.ydlx.domain.vo.UserVO;
import com.ydlx.domain.vo.request.user.QueryUserVO;
import com.ydlx.service.system.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ydlx on 2017/5/30.
 */
@RestController
@RequestMapping(value="/system/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/getList")
    @PreAuthorize("hasRole('BROWER')")
    public PageResultVO<UserVO> getList(QueryUserVO request){
        UserInfo info = new UserInfo();
        return userService.getUserList(request.getPage(), request.getRows(), info);
    }


}
