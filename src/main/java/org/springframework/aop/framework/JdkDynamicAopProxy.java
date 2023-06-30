package org.springframework.aop.framework;

import org.aopalliance.intercept.MethodInterceptor;
import org.springframework.aop.AdvisedSupport;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author WangChao
 * @version 1.0
 * @date 2023/6/30 10:55
 */
public class JdkDynamicAopProxy implements AopProxy, InvocationHandler {
    private final AdvisedSupport advised;
    public JdkDynamicAopProxy(AdvisedSupport advised){
        this.advised = advised;
    }

    /**
     * 被代理的对象(该对象)有方法被调用时，会触发该方法
     * @return
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //判读被代理的对象中执行的方法，是不是我们规定匹配的方法
        if(advised.getMethodMatcher().matches(method,advised.getTargetSource().getTarget().getClass())){
            //代理方法
            MethodInterceptor methodInterceptor = advised.getMethodInterceptor();
            return methodInterceptor.invoke(new ReflectiveMethodInvocation(advised.getTargetSource().getTarget(),method,args));
        }
        //如果执行的不是代理方法，直接执行，不做增强
        return method.invoke(advised.getTargetSource().getTarget(), args);
    }

    /**
     * 返回代理对象
     * @return
     */
    @Override
    public Object getProxy() {
        //ClassLoader loader,
        //Class<?>[] interfaces,
        //InvocationHandler h 传入这个类
        return Proxy.newProxyInstance(getClass().getClassLoader(),advised.getTargetSource().getTargetClass(),this);
    }
}
