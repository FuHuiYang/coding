package com.cc.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (TUser)实体类
 *
 * @author makejava
 * @since 2020-05-19 11:09:30
 */
public class TUser implements Serializable {
    private static final long serialVersionUID = -95016698499177305L;
    /**
    * 用户id
    */
    private Integer fId;
    /**
    * 用户姓名
    */
    private String fName;
    /**
    * 用户注册时间
    */
    private Date fCreatetime;
    /**
    * 用户最后修改时间
    */
    private Date fModifytime;
    /**
    * 用户账号
    */
    private String fCode;
    /**
    * 用户密码
    */
    private String fPassword;


    public Integer getFId() {
        return fId;
    }

    public void setFId(Integer fId) {
        this.fId = fId;
    }

    public String getFName() {
        return fName;
    }

    public void setFName(String fName) {
        this.fName = fName;
    }

    public Date getFCreatetime() {
        return fCreatetime;
    }

    public void setFCreatetime(Date fCreatetime) {
        this.fCreatetime = fCreatetime;
    }

    public Date getFModifytime() {
        return fModifytime;
    }

    public void setFModifytime(Date fModifytime) {
        this.fModifytime = fModifytime;
    }

    public String getFCode() {
        return fCode;
    }

    public void setFCode(String fCode) {
        this.fCode = fCode;
    }

    public String getFPassword() {
        return fPassword;
    }

    public void setFPassword(String fPassword) {
        this.fPassword = fPassword;
    }

}