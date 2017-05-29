package com.ydlx.controller;

import com.ydlx.constants.ResultType;
import com.ydlx.domain.vo.ResultVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ydlx on 2017/4/29.
 */
@Controller
public class LoginController {

    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);


    /**
     * 展示登录页面
     * @return
     */
    @GetMapping(value="/login")
    public String login(){
        return "/login";
    }

    /***
     * 获取RSA公钥系数和指数
     *  @param request
     * @return
     */
    @PostMapping(value="/getKey")
    public @ResponseBody ResultVO getKey(HttpServletRequest request){
        KeyPairGenerator keyPairGenerator = null;
        Map<String, Object> map = new HashMap<String, Object>();
        ResultVO resultVO = new ResultVO(ResultType.SUCCESS);
        try {
            keyPairGenerator = KeyPairGenerator.getInstance("RSA");
            keyPairGenerator.initialize(1024);
            KeyPair keyPair = keyPairGenerator.generateKeyPair();
            RSAPublicKey pubk = (RSAPublicKey) keyPair.getPublic();//生成公钥
            RSAPrivateKey prik= (RSAPrivateKey) keyPair.getPrivate();//生成私钥
            map.put("pubExponent", pubk.getPublicExponent().toString(16));//保存公钥指数
            map.put("pubModules", pubk.getModulus().toString(16));//保存公钥系数
            request.getSession().setAttribute("prik", prik); //将私钥存入session
            resultVO.setData(map);
        } catch (NoSuchAlgorithmException e) {
            resultVO.setResultVO(ResultType.FAIL);
            e.printStackTrace();
        }
        return resultVO;
    }
}
