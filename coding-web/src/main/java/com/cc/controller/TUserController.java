package com.cc.controller;

import com.cc.entity.TUser;
import com.cc.service.TUserService;
import com.cc.service.login.LoginFacade;
import com.cc.service.login.enmu.LoginType;
import com.cc.service.reponse.LoginProcessResponse;
import com.cc.service.request.LoginProcessRequest;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (TUser)表控制层
 *
 * @author makejava
 * @since 2020-05-19 11:13:22
 */
@RestController
@RequestMapping("tUser")
public class TUserController {
    /**
     * 服务对象
     */
    @Resource
    private TUserService tUserService;
    @Resource
    private LoginFacade loginFacade;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public TUser selectOne(Integer id) {
        return this.tUserService.queryById(id);
    }

    @GetMapping("login")
    public LoginProcessResponse login() {
        try {
            LoginProcessRequest loginProcessRequest =new LoginProcessRequest();
            loginProcessRequest.setPhone("112312");
            loginProcessRequest.setLoginType(LoginType.TXQQ_LOGIN.getLoginCode());
            this.loginFacade.login(loginProcessRequest);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new LoginProcessResponse();
    }

}