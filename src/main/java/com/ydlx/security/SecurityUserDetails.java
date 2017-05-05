package com.ydlx.security;

import com.ydlx.domain.info.RoleInfo;
import com.ydlx.domain.info.UserInfo;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by ydlx on 2017/5/5.
 */
public class SecurityUserDetails extends UserInfo implements UserDetails {

    public SecurityUserDetails(UserInfo userInfo){
        this.setLoginAccount(userInfo.getLoginAccount())
                .setPassword(userInfo.getPassword())
                .setUserName(userInfo.getUserName())
                .setEmail(userInfo.getEmail())
                .setMobile(userInfo.getMobile())
                .setNickName(userInfo.getNickName())
                .setRoleInfos(userInfo.getRoleInfos())
                .setId(userInfo.getId());

    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        List<RoleInfo> roleInfos = this.getRoleInfos();

        if(roleInfos != null && roleInfos.size() >0)
        {
            for (RoleInfo roleInfo : roleInfos) {
                SimpleGrantedAuthority authority = new SimpleGrantedAuthority("ROLE_"+roleInfo.getRoleCode());
                authorities.add(authority);
            }
        }
        return authorities;
    }

    @Override
    public String getPassword() {
        return super.getPassword();
    }

    @Override
    public String getUsername() {
        return super.getLoginAccount();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
