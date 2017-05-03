package com.ydlx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by ydlx on 2017/4/29.
 */
@Controller
public class LoginController {

    @RequestMapping(value = "/login")
    public String login(){
        return "login";
    }
}
