package com.ydlx.dao;

import com.ydlx.domain.info.UserInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by zhenhua.li on 2017/5/3.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {

    private static final Logger logger = LoggerFactory.getLogger(UserMapperTest.class);

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private MenuMapper menuMapper;

    @Autowired
    private RoleMapper roleMapper;


    @Test
    public void getByUserDetailId() throws Exception {
        //UserDetailInfo userDetailInfo = new UserDetailInfo();
        UserInfo userInfo = userMapper.getByLoginAccount("admin");

        logger.info(userInfo.getUserName() +","+ userInfo.getRoleInfos().size());
       // RoleInfo roleInfo = roleMapper.getById(userInfo.getRoleIds().get(0));

        //Assert.assertEquals(new String("管理员"), userInfo.getUserName());
    }


    @Test
    public void getById() throws Exception {
        UserInfo userInfo = userMapper.getById(1);
        Assert.assertEquals(new String("管理员"), userInfo.getUserName());
    }

}