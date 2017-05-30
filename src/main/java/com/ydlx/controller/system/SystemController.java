package com.ydlx.controller.system;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by ydlx on 2017/5/30.
 */
@Controller
public class SystemController {


    @GetMapping(value="/user/index")
    public String userIndex(){
        return "/system/user/index";
    }


    @GetMapping(value="/role/index")
    public String roleIndex(){
        return "/system/role/index";
    }


    @GetMapping(value="/menu/index")
    public String menuIndex(){
        return "/system/menu/index";
    }


}
