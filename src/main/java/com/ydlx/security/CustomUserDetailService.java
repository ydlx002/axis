package com.ydlx.security;

import com.ydlx.domain.info.UserInfo;
import com.ydlx.service.system.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * Created by ydlx on 2017/5/5.
 */
@Component
public class CustomUserDetailService implements UserDetailsService {

    private static final Logger logger = LoggerFactory.getLogger(CustomUserDetailService.class);

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String loginAccount) throws UsernameNotFoundException {
        logger.info("登录账号{}",loginAccount);
        UserInfo userInfo = userService.getUserByLoginAccount(loginAccount);
        if(null == userInfo){
            throw new UsernameNotFoundException("loginAccount " + loginAccount + " not found");
        }

        SecurityUserDetails securityUserDetails = new SecurityUserDetails(userInfo);
        return securityUserDetails;
    }
}
