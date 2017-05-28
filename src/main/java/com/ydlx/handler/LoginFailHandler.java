package com.ydlx.handler;

import com.ydlx.constants.ResultType;
import com.ydlx.domain.vo.ResultVO;
import com.ydlx.utils.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by ydlx on 2017/5/28.
 */
public class LoginFailHandler implements AuthenticationFailureHandler {

    private static  final Logger logger = LoggerFactory.getLogger(LoginFailHandler.class);

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException, ServletException {

//        logger.info("用户 {} 登出，IP：{}",userDetails.getUsername(), getIpAddress(httpServletRequest));
////        clearAuthenticationAttributes(request);
        //调用父类handle()方法转发或重定向到目标URL，然后调用clearAuthenticationAttributes()以删除任何剩余的会话数据。
        //super.onAuthenticationSuccess(request, response, authenticatin);
        ResponseUtil.responseOutWithJson( response , new ResultVO(ResultType.FAIL));
    }
}
