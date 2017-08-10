package com.ydlx.service.system.impl;

import com.ydlx.constants.ResultType;
import com.ydlx.dao.MenuMapper;
import com.ydlx.domain.info.MenuInfo;
import com.ydlx.domain.vo.ResultVO;
import com.ydlx.service.system.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ydlx on 2017/5/3.
 */
@Service
public class MenuServiceImpl implements MenuService<MenuInfo> {

    @Autowired
    private MenuMapper menuMapper;

    @Override
        public Map<Integer, MenuInfo> getMenuTree(List<Integer> menuIds) {
        List<MenuInfo> menuInfos = menuMapper.getList(menuIds);
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
    public List<MenuInfo> getMenuTreeByRoleIds(List<Integer> roleIds) {
        List<MenuInfo> menuInfos = menuMapper.getListByRoleId(roleIds);
        Map<Integer, MenuInfo> tree = new HashMap<Integer, MenuInfo>();
        List<MenuInfo> menuList = new ArrayList<MenuInfo>();
        for(MenuInfo menuInfo : menuInfos){
            if(null!=menuInfo){
                if(-1==menuInfo.getParentId())  //获取顶级节点
                    tree.put(menuInfo.getId(), menuInfo);
                else{
                    MenuInfo pMenuInfo = tree.get(menuInfo.getParentId());
                    pMenuInfo.getChildMenuList().add(menuInfo);
                    tree.put(menuInfo.getId(), menuInfo);
                }
                if(menuInfo.getLevel() == 1){
                    menuList.add(menuInfo);
                }
            }
        }
        return menuList;
    }


    @Override
    public MenuInfo getInfoById(Integer id) {
        return null;
    }

    @Override
    @Transactional
    public ResultVO addInfo(MenuInfo menuInfo) {
        MenuInfo info = new MenuInfo();
        info.setId(menuInfo.getParentId());
        info.setLeaf(0);//非叶子节点
        if(menuMapper.update(info)&&menuMapper.insert(menuInfo)){
            return new ResultVO(ResultType.SUCCESS);
        }
        return new ResultVO(ResultType.FAIL);
    }

    @Override
    public ResultVO updateInfo(MenuInfo menuInfo) {
        ResultVO resultVO = new ResultVO();
        return resultVO;
    }

    @Override
    public ResultVO deleteInfo(Integer id) {
        ResultVO resultVO = new ResultVO();
        return resultVO;
    }
}
