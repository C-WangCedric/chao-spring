package org.springframework.test.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.junit.Before;
import org.junit.Test;
import org.springframework.aop.*;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.aspectj.AspectJExpressionPointcutAdvisor;
import org.springframework.aop.framework.CglibAopProxy;
import org.springframework.aop.framework.JdkDynamicAopProxy;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.framework.adapter.MethodBeforeAdviceInterceptor;
import org.springframework.test.common.WorldServiceBeforeAdvice;
import org.springframework.test.common.WorldServiceInterceptor;
import org.springframework.test.service.WorldService;
import org.springframework.test.service.WorldServiceImpl;

/**
 * @author WangChao
 * @version 1.0
 * @date 2023/6/30 11:31
 */
public class DynamicProxyTest {
    private AdvisedSupport support = new AdvisedSupport();

    @Before
    public void setup(){
        WorldService worldService = new WorldServiceImpl();
        TargetSource targetSource = new TargetSource(worldService);
        MethodMatcher methodMatcher = new AspectJExpressionPointcut("execution(* org.springframework.test.service.WorldService.explode(..))").getMethodMatcher();

        support.setMethodMatcher(methodMatcher);
        support.setMethodInterceptor(new WorldServiceInterceptor());
        support.setTargetSource(targetSource);
    }

    @Test
    public void testJdkDynamicProxy() throws Exception {
        WorldService world = (WorldService)new JdkDynamicAopProxy(support).getProxy();
        /**
         * Do something before the earth explodes
         * The Earth is going to explode
         * Do something after the earth explodes
         */
        world.explode();
    }

    @Test
    public void testCglibAopProxy(){
        WorldService world = (WorldService)new CglibAopProxy(support).getProxy();
        world.explode();
    }

    @Test
    public void testProxyFactory(){
        // 使用JDK动态代理
        support.setProxyTargetClass(false);
        WorldService worldService1 = (WorldService)new ProxyFactory(support).getProxy();
        worldService1.explode();

        // 使用CGLIB动态代理
        support.setProxyTargetClass(true);
        WorldService worldService2 = (WorldService)new ProxyFactory(support).getProxy();
        worldService2.explode();
    }

    @Test
    public void testBeforeAdvice() throws Exception{
        //设置BeforeAdvice
        MethodBeforeAdvice beforeAdvice = new WorldServiceBeforeAdvice();
        MethodBeforeAdviceInterceptor methodBeforeAdviceInterceptor = new MethodBeforeAdviceInterceptor(beforeAdvice);
        // 定义拦截类，在代理方法执行时候处理一些操作
        support.setMethodInterceptor(methodBeforeAdviceInterceptor);

        WorldService proxy = (WorldService) new ProxyFactory(support).getProxy();
        proxy.explode();
    }

    @Test
    public void testAdvisor() throws Exception{
        WorldService worldService = new WorldServiceImpl();

        //Advisor是Pointcut和Advice的组合
        String expression = "execution(* org.springframework.test.service.WorldService.explode(..))";
        AspectJExpressionPointcutAdvisor pointcutAdvisor = new AspectJExpressionPointcutAdvisor();
        pointcutAdvisor.setExpression(expression);
        MethodBeforeAdviceInterceptor methodInterceptor = new MethodBeforeAdviceInterceptor(new WorldServiceBeforeAdvice());
        //注入方法拦截器
        pointcutAdvisor.setAdvice(methodInterceptor);

        //获取匹配到的类
        ClassFilter classFilter = pointcutAdvisor.getPointcut().getClassFilter();
        if(classFilter.matches(worldService.getClass())){
            AdvisedSupport advisedSupport = new AdvisedSupport();

            //对匹配到的类进行代理
            TargetSource targetSource = new TargetSource(worldService);
            advisedSupport.setTargetSource(targetSource);
            advisedSupport.setMethodInterceptor((MethodInterceptor) pointcutAdvisor.getAdvice());
            advisedSupport.setMethodMatcher(pointcutAdvisor.getPointcut().getMethodMatcher());
            advisedSupport.setProxyTargetClass(true);   //JDK or CGLIB

            WorldService proxy = (WorldService)new ProxyFactory(advisedSupport).getProxy();
            proxy.explode();
        }
    }
}
