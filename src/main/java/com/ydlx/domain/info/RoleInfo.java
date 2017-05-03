package com.ydlx.domain.info;

import java.util.List;

/**
 * Created by ydlx on 2017/4/29.
 */
public class RoleInfo extends  BaseInfo{
    /**角色名*/
    private String roleName;

    /**角色代码*/
    private String roleCode;

    /***菜单列表*/
    private List<Integer> menuIds;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public List<Integer> getMenuIds() {
        return menuIds;
    }

    public void setMenuIds(List<Integer> menuIds) {
        this.menuIds = menuIds;
    }
}
