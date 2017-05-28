package com.ydlx.handler;

import com.ydlx.constants.ResultType;
import com.ydlx.domain.vo.ResultVO;
import com.ydlx.utils.ResponseUtil;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by ydlx on 2017/5/6.
 * 认证失败结果处理
 */
public class AuthnticationFailHandler implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request,HttpServletResponse response, AuthenticationException authException) throws IOException {
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Authentication Failed ex: " + authException.getMessage());
        ResponseUtil.responseOutWithJson(response,new ResultVO(ResultType.FAIL));
    }
}
