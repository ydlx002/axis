package com.ydlx.utils;

import com.alibaba.fastjson.JSON;

import javax.servlet.ServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by ydlx on 2017/5/28.
 */
public class ResponseUtil {

    /**
     * 以json格式输出
     * @param response
     * @param responseObject
     */
    public static  void responseOutWithJson(ServletResponse response, Object responseObject) {
        //将实体对象转换为JSON Object转换
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        PrintWriter out = null;
        try {
            out = response.getWriter();
            out.append(JSON.toJSONString(responseObject));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }
}
