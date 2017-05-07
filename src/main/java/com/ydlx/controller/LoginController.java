package com.ydlx.controller;

import com.ydlx.constants.ResultEnum;
import com.ydlx.domain.dto.ReturnDTO;
import com.ydlx.service.system.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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
            modelMap.addAttribute("pubexponent", publicKeyExponent);//保存公钥指数
            modelMap.addAttribute("pubmodules", publicKeyModulus);//保存公钥系数
            request.getSession().setAttribute("prik", prik); //将私钥存入session
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return mav;
    }

    /***
     * 处理登录请求
     * @param request
     * @param loginAccount
     * @param password
     * @param verificationCode
     * @return
     * @throws Exception
    */
    @PostMapping(value="/login")
    @ResponseBody
    public ReturnDTO login(HttpServletRequest request, String username, String password ) throws Exception{
//        Cipher ci = Cipher.getInstance("RSA", new BouncyCastleProvider());
//        ci.init(Cipher.DECRYPT_MODE, (RSAPrivateKey)request.getSession().getAttribute("prik"));
//        byte[] en_data = Hex.decodeHex(password.toCharArray());
//        password = StringUtils.reverse(new String(ci.doFinal(en_data))); //反转字符串
//
//        UserInfo userInfo = userService.getUserByLoginAccount(username);
//        if(null != userInfo &&userInfo.getPassword().equals(MD5Util.passwordEncoder(password))){
//            Authentication authentication = new UsernamePasswordAuthenticationToken(userInfo, MD5Util.passwordEncoder(userInfo.getPassword()));
//            Authentication result = authenticationManager.authenticate(authentication);
//            SecurityContextHolder.getContext().setAuthentication(result);
//           return new ReturnDTO(ResultEnum.SUCCESS);
//        }
       return new ReturnDTO(ResultEnum.SUCCESS);
    }
}
