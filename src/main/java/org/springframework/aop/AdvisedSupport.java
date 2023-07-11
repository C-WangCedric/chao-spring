package org.springframework.aop;


import org.aopalliance.intercept.MethodInterceptor;

/**
 * @author WangChao
 * @version 1.0
 * @date 2023/6/30 10:49
 */
public class AdvisedSupport {
    //是否使用cglib代理
    private boolean proxyTargetClass = false;
    /**
     * 被代理对象
     */
    private TargetSource targetSource;
    /**
     * 方法拦截器是一种在方法调用前后进行额外逻辑处理的机制
     */
    private MethodInterceptor methodInterceptor;
    /**
     * 方法匹配
     */
    private MethodMatcher methodMatcher;

    public boolean isProxyTargetClass(){
        return proxyTargetClass;
    }

    public void setProxyTargetClass(boolean proxyTargetClass){
        this.proxyTargetClass = proxyTargetClass;
    }

    public TargetSource getTargetSource(){
        return this.targetSource;
    }

    public void setTargetSource(TargetSource targetSource){
        this.targetSource = targetSource;
    }

    public MethodInterceptor getMethodInterceptor(){
        return this.methodInterceptor;
    }

    public void setMethodInterceptor(MethodInterceptor methodInterceptor){
        this.methodInterceptor = methodInterceptor;
    }

    public MethodMatcher getMethodMatcher(){
        return this.methodMatcher;
    }

    public void setMethodMatcher(MethodMatcher methodMatcher){
        this.methodMatcher = methodMatcher;
    }
}
