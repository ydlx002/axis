package com.ydlx.controller;

import com.ydlx.domain.info.UserInfo;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ydlx on 2017/5/5.
 */
@RestController
public class HomeController {

    @RequestMapping(value = "/getUserInfo",method = RequestMethod.GET)
    @PreAuthorize("hasRole('USER')")
    public UserInfo getUserInfo(UserInfo user){
        UserInfo userInfo = new UserInfo();
        userInfo.setUserName("LIQIN");
        userInfo.setPassword("123");
        return userInfo;
    }


    @RequestMapping(value = "/getAuth",method = RequestMethod.GET)
    @PreAuthorize("hasRole('ADMIN')")
    public UserInfo getAuth(UserInfo user){
        UserInfo userInfo = new UserInfo();
        //userInfo.setUserName("LIQIN");
        userInfo.setPassword("123");
        return userInfo;
    }
}
