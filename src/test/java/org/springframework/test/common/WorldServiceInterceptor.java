package org.springframework.test.common;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * @author WangChao
 * @version 1.0
 * @date 2023/6/30 13:38
 */
public class WorldServiceInterceptor implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        System.out.println("Do something before the earth explodes");
        //执行被代理的方法
        Object proceed = invocation.proceed();
        System.out.println("Do something after the earth explodes");
        return proceed;
    }
}
