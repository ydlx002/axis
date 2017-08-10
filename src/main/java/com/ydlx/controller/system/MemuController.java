package com.ydlx.controller.system;

import com.ydlx.constants.ResultType;
import com.ydlx.domain.info.MenuInfo;
import com.ydlx.domain.vo.ResultVO;
import com.ydlx.domain.vo.request.menu.MenuVO;
import com.ydlx.service.system.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by ydlx on 2017/6/4.
 */
@RestController
@RequestMapping(value="/system/menu")
public class MemuController {

    @Autowired
    private MenuService menuService;


    @RequestMapping(value="/getMenu")
    @PreAuthorize("hasRole('BROWER')")
    public List<MenuInfo> index(){
//        SecurityUserDetails userDetails = (SecurityUserDetails) SecurityContextHolder.getContext().getAuthentication() .getPrincipal();
//        List<RoleInfo> roleInfos = userDetails.getRoleInfos();
//        List<Integer> roleIds = new ArrayList<Integer>();
//        for(RoleInfo info : roleInfos){
//            roleIds.add(info.getId());
//        }
//        return  menuService.getMenuTreeByRoleIds(roleIds);
        return null;
    }

    /**新增菜单*/
    @PostMapping(value="/{parentId}/add")
    @PreAuthorize("hasRole('BROWER')")
    public ResultVO add(@PathVariable("parentId") Integer parentId, MenuVO menuVO){
        if(StringUtils.isEmpty(parentId)){
            return new ResultVO(ResultType.EMPTYPARENTID);
        }
        menuVO.setParentId(parentId);
        MenuInfo menuInfo = new MenuInfo();
        menuInfo.setName(menuVO.getMenuName());
        menuInfo.setUrl(menuVO.getUri());
        menuInfo.setParentId(parentId);
        menuInfo.setIcon(menuVO.getIcon());
        menuInfo.setLeaf(1);//叶子节点
        return menuService.addInfo(menuInfo);
    }
}
