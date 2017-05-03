package com.ydlx.service.system.impl;

import com.ydlx.dao.RoleMapper;
import com.ydlx.domain.info.RoleInfo;
import com.ydlx.domain.vo.ResultVo;
import com.ydlx.service.system.RoleService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by zhenhua.li on 2017/5/3.
 */
public class RoleServiceImpl implements RoleService<RoleInfo>{

    @Autowired
    private RoleMapper roleMapper;


    @Override
    public RoleInfo getInfoById(Integer id) {
        return null;
    }

    @Override
    public ResultVo addInfo(RoleInfo roleInfo) {
        return null;
    }

    @Override
    public ResultVo updateInfo(RoleInfo roleInfo) {
        return null;
    }

    @Override
    public ResultVo deleteInfo(Integer id) {
        return null;
    }
}
