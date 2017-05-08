package com.ydlx.security;

import com.ydlx.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Collection;

/**
 * Created by ydlx on 2017/5/7.
 */
@Component
public class CustomAuthenicationProvider implements AuthenticationProvider{

    @Autowired
    private CustomUserDetailService customUserDetailService;


    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String loginAccount = authentication.getName();
        String password = (String) authentication.getCredentials();
        SecurityUserDetails userDetails = (SecurityUserDetails) customUserDetailService.loadUserByUsername(loginAccount);
        if(userDetails == null){
            throw new BadCredentialsException("Username not found.");
        }

        if(!MD5Util.passwordEncoder(password).equals(userDetails.getPassword())){
            throw new BadCredentialsException("Wrong password.");
        }

        Collection<? extends GrantedAuthority> authorities = userDetails.getAuthorities();
        return new UsernamePasswordAuthenticationToken(userDetails, password, authorities);
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
