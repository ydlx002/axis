package com.ydlx.dao;

import com.ydlx.domain.info.MenuInfo;
import org.apache.ibatis.annotations.Mapper;

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
}
