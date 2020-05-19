package com.cc.service.login.impl;

import com.cc.entity.TUser;
import com.cc.mapper.TUserDao;
import com.cc.service.enmu.RspCode;
import com.cc.service.login.LoginFacade;
import com.cc.service.reponse.LoginProcessResponse;
import com.cc.service.request.LoginProcessRequest;

import javax.annotation.Resource;

/**
 * @author : yangfuhui
 * @Project: coding
 * @Package com.cc.service.login.impl
 * @Description: 账号登录实现
 * @date Date : 2020年05月19日 16:44
 */
public class CodeLoginFacadeImp implements LoginFacade {
    @Resource
    private TUserDao tUserDao;
    @Override
    public LoginProcessResponse login(LoginProcessRequest loginProcessRequest) {
        LoginProcessResponse loginProcessResponse =new LoginProcessResponse();
        loginProcessResponse.setCode(RspCode.USER_NOT_FIND.getCode());
        try {
            TUser tUser = tUserDao.queryUserByCode(loginProcessRequest.getUserCode());
            if(null!=tUser&&loginProcessRequest.getUserPassward().equals(tUser.getFPassword())){
                loginProcessResponse.setCode(RspCode.SUCCESSFUL.getCode());
            }
        } catch (Exception e) {
            loginProcessResponse.setCode(RspCode.USER_LOGIN_EXCEPTION.getCode());
        }
        return loginProcessResponse;
    }
}
