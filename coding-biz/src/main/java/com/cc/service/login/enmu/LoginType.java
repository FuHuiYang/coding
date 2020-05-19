package com.cc.service.login.enmu;

/**
 * @author : yangfuhui
 * @Project: coding
 * @Package com.cc.service.login.enmu
 * @Description: 登录方式
 * @date Date : 2020年05月19日 14:01
 */
public enum LoginType {
    TXQQ_LOGIN("0001","TXQQ_LOGIN", "QQ登录"),
    WX_LOGIN("0002","WX_LOGIN", "微信登录"),
    PHONE_LOGIN("0003","PHONE_LOGIN", "QQ登录"),
    CODEANDPASSWARD_LOGIN("0004","CODEANDPASSWARD_LOGIN", "账号密码登录"),;

    private String loginCode;
    private String loginType;
    private String loginMsg;

    LoginType(String loginCode,String loginType, String loginMsg) {
        this.loginCode=loginCode;
        this.loginType=loginType;
        this.loginMsg=loginMsg;
    }

    public String getLoginType() {
        return loginType;
    }

    public String getLoginMsg() {
        return loginMsg;
    }

    public String getLoginCode() {
        return loginCode;
    }
}
