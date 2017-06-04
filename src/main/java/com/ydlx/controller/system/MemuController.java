package com.ydlx.controller.system;

import com.ydlx.domain.info.MenuInfo;
import com.ydlx.domain.info.RoleInfo;
import com.ydlx.security.SecurityUserDetails;
import com.ydlx.service.system.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ydlx on 2017/6/4.
 */
@RestController
@RequestMapping(value="/system/menu")
public class MemuController {

    @Autowired
    private MenuService menuService;

    @PreAuthorize("hasRole('BROWER')")
    @RequestMapping(value="/getMenu")
    public List<MenuInfo> index(){
        SecurityUserDetails userDetails = (SecurityUserDetails) SecurityContextHolder.getContext().getAuthentication() .getPrincipal();
        List<RoleInfo> roleInfos = userDetails.getRoleInfos();
        List<Integer> roleIds = new ArrayList<Integer>();
        for(RoleInfo info : roleInfos){
            roleIds.add(info.getId());
        }
        return  menuService.getMenuTreeByRoleIds(roleIds);
    }
}
