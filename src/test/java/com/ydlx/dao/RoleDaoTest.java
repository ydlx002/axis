package com.ydlx.dao;

import com.ydlx.domain.info.RoleInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by ydlx on 2017/4/29.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RoleDaoTest {
    @Autowired
    private RoleDao roleDao;

    @Test
    public void findByRoleCode() throws Exception {
        RoleInfo roleInfo = roleDao.findByRoleCode("home");
        Assert.assertEquals(new String("home"), roleInfo.getRoleCode());
    }

}