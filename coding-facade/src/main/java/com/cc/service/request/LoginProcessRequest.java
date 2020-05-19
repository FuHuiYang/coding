package com.cc.service.request;

/**
 * @author : yangfuhui
 * @Project: coding
 * @Package com.cc.service.request
 * @Description: 登录入参
 * @date Date : 2020年05月19日 16:24
 */
public class LoginProcessRequest {
    /**
     * 用户id
     */
    private String userId;
    /**
     * 手机号
     */
    private String phone;
    /**
     * 登录方式
     */
    private String loginType;
    /**
     * 用户账号
     */
    private String userCode;
    /**
     * 用户密码
     */
    private String userPassward;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLoginType() {
        return loginType;
    }

    public void setLoginType(String loginType) {
        this.loginType = loginType;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getUserPassward() {
        return userPassward;
    }

    public void setUserPassward(String userPassward) {
        this.userPassward = userPassward;
    }
}
