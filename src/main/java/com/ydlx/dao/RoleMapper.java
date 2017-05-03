package com.ydlx.dao;

import com.ydlx.domain.info.RoleInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * Created by ydlx on 2017/4/29.
 */
@Mapper
public interface RoleMapper {

        @Select("SELECT * FROM t_s_role WHERE rolecode = #{roleCode}")
        RoleInfo findByRoleCode(@Param("roleCode") String roleCode);

        /***
         * 根据ID获取角色的信息
         * @param id
         * @return
         */
        RoleInfo getById(Integer id);
}
