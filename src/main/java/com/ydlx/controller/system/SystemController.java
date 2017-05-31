package com.ydlx.controller.system;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by ydlx on 2017/5/30.
 */
@Controller
@RequestMapping(value="/system")
public class SystemController {


    @GetMapping(value="/user/index")
    @PreAuthorize("hasRole('BROWER')")
    public String userIndex(){
        return "/system/user/index";
    }


    @GetMapping(value="/role/index")
    @PreAuthorize("hasRole('BROWER')")
    public String roleIndex(){
        return "/system/role/index";
    }


    @GetMapping(value="/menu/index")
    @PreAuthorize("hasRole('BROWER')")
    public String menuIndex(){
        return "/system/menu/index";
    }


}
