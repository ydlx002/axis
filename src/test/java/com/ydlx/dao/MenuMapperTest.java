package com.ydlx.dao;

import com.ydlx.domain.info.MenuInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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
        List<MenuInfo> menuInfoList = menuMapper.getList("1,2,3,4");
       // Assert.assertEquals(new Integer(4), menuInfoList.size());
        System.out.print(menuInfoList.size());
    }

}