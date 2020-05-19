package com.cc.service.login;


import com.cc.service.reponse.LoginProcessResponse;
import com.cc.service.request.LoginProcessRequest;

/**
 * @author : yangfuhui
 * @Project: coding
 * @Package com.cc.service.login
 * @Description: 用户登录
 * @date Date : 2020年05月19日 13:49
 */
public interface LoginFacade {

    /**
     * 登录
     *
     */
    LoginProcessResponse login(LoginProcessRequest loginProcessRequest);
}
