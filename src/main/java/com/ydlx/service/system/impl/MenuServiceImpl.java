package com.ydlx.service.system.impl;

import com.ydlx.dao.MenuMapper;
import com.ydlx.domain.info.MenuInfo;
import com.ydlx.domain.vo.ResultVo;
import com.ydlx.service.system.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zhenhua.li on 2017/5/3.
 */
@Service
public class MenuServiceImpl implements MenuService<MenuInfo> {

    @Autowired
    private MenuMapper menuMapper;

    @Override
    public Map<Integer, MenuInfo> getMenuTree(List<Integer> ids) {
        List<MenuInfo> menuInfos = menuMapper.getList(ids);
        Map<Integer, MenuInfo> tree = new HashMap<Integer, MenuInfo>();
        for(int i=0, size = menuInfos.size(); i< size; i++){
            MenuInfo menuInfo = menuInfos.get(i);
            if(menuInfo.getParentId()==-1)  //获取顶级节点
                tree.put(menuInfo.getId(), menuInfo);
            else{
                MenuInfo pMenuInfo = tree.get(menuInfo.getParentId());
                pMenuInfo.getChildMenuList().add(menuInfo);
                tree.put(menuInfo.getId(), menuInfo);
            }
        }
        return tree;
    }

    @Override
    public MenuInfo getInfoById(Integer id) {
        return null;
    }

    @Override
    public ResultVo addInfo(MenuInfo menuInfo) {
        return null;
    }

    @Override
    public ResultVo updateInfo(MenuInfo menuInfo) {
        return null;
    }

    @Override
    public ResultVo deleteInfo(Integer id) {
        return null;
    }
}
