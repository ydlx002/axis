package com.ydlx.service.system;

import java.util.List;
import java.util.Map;

/**
 * Created by ydlx on 2017/5/3.
 */
public interface MenuService<MenuInfo> extends  BaseService<MenuInfo> {

    /**
     * 获取菜单树
     * @param muneIds
     * @return
     */
    Map<Integer, MenuInfo> getMenuTree(List<Integer> muneIds);

    /**
     * 获取菜单树
     * @param roleIds
     * @return
     */
    List<MenuInfo> getMenuTreeByRoleIds(List<Integer> roleIds);


}
