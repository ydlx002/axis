package com.ydlx.domain.vo.request.menu;

import com.ydlx.domain.vo.BaseVO;

/**
 * Created by ydlx on 2017/6/14.
 */
public class MenuVO extends BaseVO{

    /**菜单名字*/
    private String menuName;

    /**URI*/
    private String uri;

    /**icon*/
    private String icon;

    /**菜单父节点*/
    private Integer parentId;

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    @Override
    public String toString() {
        return "MenuVO{" +
                "menuName='" + menuName + '\'' +
                ", uri='" + uri + '\'' +
                ", icon='" + icon + '\'' +
                ", parentId=" + parentId +
                '}';
    }
}
