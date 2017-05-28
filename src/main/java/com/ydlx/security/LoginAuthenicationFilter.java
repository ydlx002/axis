package com.ydlx.security;

import com.ydlx.constants.ResultType;
import com.ydlx.domain.vo.ResultVO;
import com.ydlx.security.support.ParameterRequestWrapper;
import com.ydlx.utils.ResponseUtil;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.lang3.StringUtils;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.crypto.Cipher;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.interfaces.RSAPrivateKey;

/**
 * Created by ydlx on 2017/5/8.
 */
public class LoginAuthenicationFilter extends UsernamePasswordAuthenticationFilter {


    private  static  final Logger logger = LoggerFactory.getLogger(LoginAuthenicationFilter.class);

    public LoginAuthenicationFilter() {
        super();
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        ParameterRequestWrapper requestWrapper = new ParameterRequestWrapper((HttpServletRequest)request);
        String loginAccount = request.getParameter("loginAccount");
        String password = request.getParameter("password");

        if("POST".equals(requestWrapper.getMethod()) && requestWrapper.getRequestURI().contains("/login")) {
            Cipher ci = null;
            try {
                ci = Cipher.getInstance("RSA", new BouncyCastleProvider());
                RSAPrivateKey rsaPrivateKey = (RSAPrivateKey)requestWrapper.getSession().getAttribute("prik");
                if(null == rsaPrivateKey){
                    ResponseUtil.responseOutWithJson(response, new ResultVO(ResultType.SESSIONTIMEOUT));
                    return;
                }
                ci.init(Cipher.DECRYPT_MODE, rsaPrivateKey);
                byte[] en_data = Hex.decodeHex(password.toCharArray());
                password = StringUtils.reverse(new String(ci.doFinal(en_data))); //反转字符串
            } catch (Exception e) {
                e.printStackTrace();
            }
            requestWrapper.addParameter("username", loginAccount);
            requestWrapper.addParameter("password", password);
            chain.doFilter(requestWrapper, response);
        }else{
            chain.doFilter(request,response);
        }


    }


    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
       return null;
    }
}
