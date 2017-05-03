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

        /***
         * 根据ID获取角色的信息
         * @param id
         * @return
         */
        RoleInfo getById(Integer id);

        /***
         * 新增角色
         * @param roleInfo
         * @return
         */
        boolean insert(RoleInfo roleInfo);

        /***
         * 更新角色信息
         * @param roleInfo
         * @return
         */
        boolean update(RoleInfo roleInfo);

        /***
         * 删除角色信息
         * @return
         */
        boolean delete(@Param("id") Integer id);




        @Select("SELECT * FROM t_s_role WHERE rolecode = #{roleCode}")
        RoleInfo findByRoleCode(@Param("roleCode") String roleCode);
}
