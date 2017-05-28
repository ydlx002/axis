package com.ydlx.handler;

import com.ydlx.constants.ResultType;
import com.ydlx.domain.vo.ResultVO;
import com.ydlx.security.SecurityUserDetails;
import com.ydlx.utils.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by ydlx on 2017/5/6.
 */
public class LoginSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    private static  final Logger logger = LoggerFactory.getLogger(LoginSuccessHandler.class);

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        SecurityUserDetails userDetails = (SecurityUserDetails)authentication.getPrincipal();
        //输出登录提示信息
        logger.info("用户 {} 登录，IP：{}",userDetails.getUsername(), getIpAddress(request));
        clearAuthenticationAttributes(request);
        //调用父类handle()方法转发或重定向到目标URL，然后调用clearAuthenticationAttributes()以删除任何剩余的会话数据。
        //super.onAuthenticationSuccess(request, response, authenticatin);
        //response.getWriter().print(new ResultVO (ResultType.SUCCESS));
        ResponseUtil.responseOutWithJson( response , new ResultVO(ResultType.SUCCESS));
    }

    public String getIpAddress(HttpServletRequest request){
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }
}
