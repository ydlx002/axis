package com.ydlx.dao;

import com.ydlx.domain.info.MenuInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by ydlx on 2017/4/29.
 */
@Mapper
public interface MenuMapper {

        /***
         * 根据ID获取菜单，ID以“，”分隔开
         * @param ids
         * @return
         */
        List<MenuInfo> getList(List<Integer> ids);

        /***
         * 根据角色ID获取菜单，ID以“，”分隔开
         * @param roleIds
         * @return
         */
        List<MenuInfo> getListByRoleId(List<Integer> roleIds);

        /***
         * 新增菜单
         * @param menuInfo
         * @return
         */
        boolean insert(MenuInfo menuInfo);

        /***
         * 更新菜单信息
         * @param menuInfo
         * @return
         */
        boolean update(MenuInfo menuInfo);

        /***
         * 删除菜单信息
         * @return
         */
        boolean delete(@Param("id") Integer id);
}
