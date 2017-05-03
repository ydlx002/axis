package com.ydlx.domain.info;

import java.util.List;

/**
 * Created by ydlx on 2017/5/3.
 */
public class UserDetailInfo extends BaseInfo{
    /**用户信息*/
    private UserInfo userInfo;

    /**角色信息*/
    private List<RoleInfo> roleInfoList;

    /***菜单信息*/
    private List<MenuInfo> menuInfoList;

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public List<RoleInfo> getRoleInfoList() {
        return roleInfoList;
    }

    public void setRoleInfoList(List<RoleInfo> roleInfoList) {
        this.roleInfoList = roleInfoList;
    }

    public List<MenuInfo> getMenuInfoList() {
        return menuInfoList;
    }

    public void setMenuInfoList(List<MenuInfo> menuInfoList) {
        this.menuInfoList = menuInfoList;
    }
}
