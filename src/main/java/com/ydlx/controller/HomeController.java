package com.ydlx.controller;

import com.ydlx.domain.info.UserInfo;
import com.ydlx.service.system.MenuService;
import com.ydlx.service.system.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ydlx on 2017/5/5.
 */
@RestController
@RequestMapping(value="/home")
public class HomeController {

    @Autowired
    private UserService userService;

    @Autowired
    private MenuService menuService;

//    @RequestMapping(value="/getMenu")
//    @PreAuthorize("hasRole('ADMIN')")
//    public List<MenuInfo> getMenu(){
//        SecurityUserDetails userDetails = (SecurityUserDetails) SecurityContextHolder.getContext().getAuthentication() .getPrincipal();
//        List<RoleInfo> roleInfos = userDetails.getRoleInfos();
//        List<Integer> roleIds = new ArrayList<Integer>();
//        for(RoleInfo info : roleInfos){
//            roleIds.add(info.getId());
//        }
//        return  menuService.getMenuTreeByRoleIds(roleIds);
//    }

    @RequestMapping(value = "/getUserInfo",method = RequestMethod.GET)
    @PreAuthorize("hasRole('USER')")
    public UserInfo getUserInfo(UserInfo user){
        UserInfo userInfo = new UserInfo();
        userInfo.setLoginAccount("LIQIN");
       // userInfo.setPassword("123");
        return userInfo;
    }


    @RequestMapping(value = "/getAuth",method = RequestMethod.GET)
    @PreAuthorize("hasRole('ADMIN')")
    public UserInfo getAuth(UserInfo user){
        UserInfo userInfo = new UserInfo();
        //userInfo.setUserName("LIQIN");
        //userInfo.setPassword("123");
        return userInfo;
    }
}
