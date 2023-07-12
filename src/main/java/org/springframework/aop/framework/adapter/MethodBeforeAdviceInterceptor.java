package org.springframework.aop.framework.adapter;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.MethodBeforeAdvice;

/**
 * 定义MethodBeforeAdviceInterceptor拦截器
 * 在执行被代理方法之前，先执行BeforeAdvice的方法。
 * @author WangChao
 * @date 2023-07-12 21:27
 */
public class MethodBeforeAdviceInterceptor implements MethodInterceptor {

    private MethodBeforeAdvice methodBeforeAdvice;

    public MethodBeforeAdviceInterceptor(MethodBeforeAdvice methodBeforeAdvice){
        this.methodBeforeAdvice = methodBeforeAdvice;
    }

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        //在执行被代理方法之前，先执行before advice操作
        this.methodBeforeAdvice.before(invocation.getMethod(),invocation.getArguments(),invocation.getThis());
        // 执行方法
        return invocation.proceed();
    }
}
