package com.ydlx.service.system.impl;

import com.ydlx.dao.RoleMapper;
import com.ydlx.domain.info.RoleInfo;
import com.ydlx.domain.vo.ResultVo;
import com.ydlx.service.system.RoleService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by ydlx on 2017/5/3.
 */
public class RoleServiceImpl implements RoleService<RoleInfo>{

    @Autowired
    private RoleMapper roleMapper;


    @Override
    public RoleInfo getInfoById(Integer id) {
        return roleMapper.getById(id);
    }

    @Override
    public ResultVo addInfo(RoleInfo roleInfo) {
        ResultVo resultVo = new ResultVo();
        return resultVo;
    }

    @Override
    public ResultVo updateInfo(RoleInfo roleInfo) {
        ResultVo resultVo = new ResultVo();
        return resultVo;
    }

    @Override
    public ResultVo deleteInfo(Integer id) {
        ResultVo resultVo = new ResultVo();
        return resultVo;
    }
}
