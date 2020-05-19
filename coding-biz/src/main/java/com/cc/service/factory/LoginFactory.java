package com.cc.service.factory;

import com.cc.service.login.LoginFacade;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * @author : yangfuhui
 * @Project: coding
 * @Package com.cc.service.factory
 * @Description: 登录工厂类
 * @date Date : 2020年05月19日 14:31
 */
public class LoginFactory {
    private Logger logger =LoggerFactory.getLogger(LoginFactory.class);
    private Map<String, LoginFacade> loginFacadeMap;

    public LoginFacade getLoginFacade(String loginType){

        LoginFacade facade = loginFacadeMap.get(loginType);
        if (facade == null) {
            logger.error("未找到登录方式");
        }
        return facade;
    }

    /**
     * 设置 loginFacadeMap
     *
     */
    public void setLoginFacadeMap(Map<String, LoginFacade> loginTypeFacadeMap) {
        this.loginFacadeMap = loginTypeFacadeMap;
    }


    public void initInvokeMethod() {
        Map<String, LoginFacade> capitalMap=new HashMap<>();
        Iterator<Map.Entry<String, LoginFacade>> mapLoginTypeIterator = loginFacadeMap.entrySet().iterator();
        while(mapLoginTypeIterator.hasNext()) {
            Map.Entry<String, LoginFacade> mapLoginType = mapLoginTypeIterator.next();
            String loginType = mapLoginType.getKey();
            if(StringUtils.isNotBlank(loginType)&&!Arrays.asList(loginType.split(",")).contains("parentChild")) {
                continue;
            }
            List<String> capitalNoList = Arrays.asList(loginType.split(","));
            for(String capitalNoNew:capitalNoList) {
                capitalMap.put(capitalNoNew, loginFacadeMap.get(loginType));
            }
        }
        loginFacadeMap.putAll(capitalMap);
    }
}
