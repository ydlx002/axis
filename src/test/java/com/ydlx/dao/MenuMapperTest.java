package com.ydlx.dao;

import com.ydlx.domain.info.MenuInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ydlx on 2017/5/2.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MenuMapperTest {

    @Autowired
    private MenuMapper menuMapper;


    @Test
    public void getList() throws Exception {
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
        list.add(10);
        List<MenuInfo> menuInfoList = menuMapper.getList(list);
       //Assert.assertEquals(new Integer(10), menuInfoList.size());
        System.out.print(menuInfoList.size());
    }

}