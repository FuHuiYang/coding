package com.cc.service.login.impl;

import com.cc.service.login.LoginFacade;
import com.cc.service.reponse.LoginProcessResponse;
import com.cc.service.request.LoginProcessRequest;
import org.springframework.stereotype.Service;

/**
 * @author : yangfuhui
 * @Project: coding
 * @Package com.cc.service.login.impl
 * @Description: 微信登录实现
 * @date Date : 2020年05月19日 14:07
 */
@Service("WXLoginServiceImp")
public class WXLoginFacadeImp implements LoginFacade {
    @Override
    public LoginProcessResponse login(LoginProcessRequest loginProcessRequest) {
        System.out.println("WX================");
        return new LoginProcessResponse();
    }
}
