package com.ydlx.security;

import com.ydlx.handler.AuthnticationFailHandler;
import com.ydlx.handler.LoginFailHandler;
import com.ydlx.handler.LoginSuccessHandler;
import com.ydlx.handler.LogoutSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * Created by ydlx on 2017/5/5.
 */
@Configuration
@EnableWebSecurity
//用于@PreAuthorize的生效,基于方法的权限控制
@EnableGlobalMethodSecurity(prePostEnabled=true)
//覆盖默认的spring security提供的配置
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
public class SecurityConfiguation  extends WebSecurityConfigurerAdapter {

//    @Autowired
//    private CustomUserDetailService customUserDetailService;

    @Autowired
    private CustomAuthenicationProvider customAuthenicationProvider;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                //禁用CSRF保护
                .csrf().disable()
                .addFilterBefore(new LoginAuthenicationFilter(), UsernamePasswordAuthenticationFilter.class)
                .authorizeRequests()
                .antMatchers("/login","/getKey").permitAll()
                //任何访问都必须授权
                .anyRequest().authenticated()
                .and()
                .formLogin()
                //登陆成功后的处理，因为是API的形式所以不用跳转页面
                .successHandler(new LoginSuccessHandler())
                //登陆失败后的处理
                .failureHandler(new LoginFailHandler())
                .and()
                //登出后的处理
                .logout().logoutSuccessHandler(new LogoutSuccessHandler())
                .and()
                //认证不通过后的处理
                .exceptionHandling()
                .authenticationEntryPoint(new AuthnticationFailHandler())
                .and().httpBasic();
    }


    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/hplus/**","/js/**","/images/**","/css/**","/favicon.ico");
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //将验证过程交给自定义验证工具
        auth.authenticationProvider(customAuthenicationProvider);
       // auth.userDetailsService(customUserDetailService).passwordEncoder(passwordEncoder()) ;
    }


//    @Override
//    @Bean
//    public AuthenticationManager authenticationManagerBean() throws Exception {
//        return super.authenticationManagerBean();
//    }

//    @Bean
//    public PasswordEncoder passwordEncoder(){
//        //密码加密
//        return new BCryptPasswordEncoder(16);
//    }

}
