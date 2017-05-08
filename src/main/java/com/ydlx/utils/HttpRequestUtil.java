package com.ydlx.utils;

import javax.servlet.ServletRequest;
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.Map;

/**
 * Created by zhenhua.li on 2017/5/8.
 */
public class HttpRequestUtil {

    private static Field requestField;
    private static Field parametersParsedField;
    private static Field coyoteRequestField;
    private static Field parametersField;
    private static Field hashTabArrField;


    static{
        try {
            Class clazz = Class.forName("org.apache.catalina.connector.RequestFacade");
            requestField = clazz.getDeclaredField("request");
            requestField.setAccessible(true);

            parametersParsedField = requestField.getType().getDeclaredField("parametersParsed");
            parametersParsedField.setAccessible(true);

            coyoteRequestField = requestField.getType().getDeclaredField("coyoteRequest");
            coyoteRequestField.setAccessible(true);

            parametersField = coyoteRequestField.getType().getDeclaredField("parameters");
            parametersField.setAccessible(true);

            hashTabArrField = parametersField.getType().getDeclaredField("paramHashStringArray");
            hashTabArrField.setAccessible(true);
        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    /***
     * 获取request请求参数
     * @param request
     * @return
     */
    public static  Map<String , String[]> getRequestMap(ServletRequest request) {
        try {
            Object innerRequest = requestField.get(request);
            parametersParsedField.setBoolean(innerRequest, true);
            Object coyoteRequestObject = coyoteRequestField.get(innerRequest);
            Object parameterObject = parametersField.get(coyoteRequestObject);
            return (Map<String,String[]>)hashTabArrField.get(parameterObject);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return Collections.emptyMap();
        }
    }
}
