package com.ydlx.service.system;

import java.util.List;
import java.util.Map;

/**
 * Created by zhenhua.li on 2017/5/3.
 */
public interface MenuService<MenuInfo> extends  BaseService<MenuInfo> {

    /**
     * 获取菜单树
     * @param ids
     * @return
     */
    Map<Integer, MenuInfo> getMenuTree(List<Integer> ids);


}
