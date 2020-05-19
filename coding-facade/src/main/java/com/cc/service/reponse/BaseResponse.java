package com.cc.service.reponse;

/**
 * @author : yangfuhui
 * @Project: coding
 * @Package com.cc.service.reponse
 * @Description: 基类
 * @date Date : 2020年05月19日 16:27
 */
public class BaseResponse {
    private String code;
    private String mesg;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMesg() {
        return mesg;
    }

    public void setMesg(String mesg) {
        this.mesg = mesg;
    }
}
