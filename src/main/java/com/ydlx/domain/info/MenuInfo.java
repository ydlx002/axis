package com.ydlx.domain.info;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ydlx on 2017/4/30.
 * 菜单信息类
 */
public class MenuInfo extends BaseInfo{

    private Integer id;

    /**父级菜单ID*/
    private Integer parentId;

    /**菜单名称*/
    private String name;

    /**是否为叶子*/
    private Integer leaf;

    /**图标*/
    private String icon;

    /**访问路径*/
    private String path;

    /**菜单级数*/
    private Integer level;

    /**url*/
    private String url;

    /**打开方式*/
    private String target;

    /***子菜单*/
    private List<MenuInfo> childMenuList = new ArrayList<MenuInfo>();


    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLeaf() {
        return leaf;
    }

    public void setLeaf(Integer leaf) {
        this.leaf = leaf;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public List<MenuInfo> getChildMenuList() {
        return childMenuList;
    }

    public void setChildMenuList(List<MenuInfo> childMenuList) {
        this.childMenuList = childMenuList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "MenuInfo{" +
                "parentId=" + parentId +
                ", name='" + name + '\'' +
                ", leaf=" + leaf +
                ", icon='" + icon + '\'' +
                ", path='" + path + '\'' +
                ", level=" + level +
                ", url='" + url + '\'' +
                ", target='" + target + '\'' +
                '}';
    }
}
