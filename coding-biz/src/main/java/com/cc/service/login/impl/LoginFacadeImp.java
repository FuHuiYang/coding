package com.cc.service.login.impl;

import com.cc.service.factory.LoginFactory;
import com.cc.service.login.LoginFacade;
import com.cc.service.reponse.LoginProcessResponse;
import com.cc.service.request.LoginProcessRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author : yangfuhui
 * @Project: coding
 * @Package com.cc.service.login.impl
 * @Description: 登录
 * @date Date : 2020年05月19日 15:24
 */
@Service(value = "loginFacade")
public class LoginFacadeImp implements LoginFacade{


    @Autowired
    private LoginFactory loginFactory;

    public LoginProcessResponse login(LoginProcessRequest loginProcessRequest){

        return getImpl(loginProcessRequest.getLoginType()).login(loginProcessRequest);
    }
    private LoginFacade getImpl(String loginType){
            return loginFactory.getLoginFacade(loginType);
    }


}
