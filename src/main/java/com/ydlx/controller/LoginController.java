package com.ydlx.controller;

import com.ydlx.service.system.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

/**
 * Created by ydlx on 2017/4/29.
 */
@Controller
public class LoginController {

    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @GetMapping(value="/login")
    public ModelAndView login(HttpServletRequest request, ModelMap modelMap){
        ModelAndView mav = new ModelAndView("/login");
        KeyPairGenerator keyPairGenerator = null;
        try {
            keyPairGenerator = KeyPairGenerator.getInstance("RSA");
            keyPairGenerator.initialize(1024);
            KeyPair keyPair = keyPairGenerator.generateKeyPair();
            RSAPublicKey pubk = (RSAPublicKey) keyPair.getPublic();//生成公钥
            RSAPrivateKey prik= (RSAPrivateKey) keyPair.getPrivate();//生成私钥
            String publicKeyExponent = pubk.getPublicExponent().toString(16);//16进制
            String publicKeyModulus = pubk.getModulus().toString(16);//16进制
            modelMap.addAttribute("pubExponent", publicKeyExponent);//保存公钥指数
            modelMap.addAttribute("pubModules", publicKeyModulus);//保存公钥系数
            request.getSession().setAttribute("prik", prik); //将私钥存入session
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return mav;
    }

}
