package com.cc.service.config;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.cglib.core.ReflectUtils;

/**
 * @author : yangfuhui
 * @Project: coding
 * @Package com.cc.service.config
 * @Description: 异常
 * @date Date : 2020年05月19日 14:56
 */

public class ExceptionMapper implements MethodInterceptor {
    public ExceptionMapper() {
    }

    public Object invoke(MethodInvocation invocation) throws Throwable {
        try {
            return invocation.proceed();
        }  catch (Exception var7) {
            throw new Exception(var7);
        }
    }
}
