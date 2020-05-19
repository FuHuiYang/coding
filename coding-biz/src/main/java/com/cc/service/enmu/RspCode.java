package com.cc.service.enmu;

import com.cc.service.reponse.BaseResponse;

/**
 * @author : yangfuhui
 * @Project: coding
 * @Package com.cc.service
 * @Description: 返回信息码值
 * @date Date : 2020年05月19日 16:54
 */
public enum RspCode {
    //状态码
    SUCCESSFUL("00", "成功"),
    USER_NOT_FIND("0000000001", "用户不存在"),



    //网络异常


    //业务异常码
    USER_LOGIN_EXCEPTION("S001", "登录业务异常");

    private String code;
    private String message;

    RspCode(String code, String message) {
        this.code=code;
        this.message=message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
