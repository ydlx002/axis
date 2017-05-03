package com.ydlx.controller;

import com.ydlx.domain.info.MenuInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ydlx on 2017/4/28.
 */
@Controller
public class IndexController {

    @RequestMapping(value="/index")
    public ModelAndView index(){
        List<MenuInfo> list = new ArrayList<MenuInfo>();
        MenuInfo info = new MenuInfo();
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("menuList", list);
        return mav;
    }
}
