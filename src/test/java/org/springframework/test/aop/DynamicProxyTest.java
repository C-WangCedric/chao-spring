package org.springframework.test.aop;

import org.junit.Before;
import org.junit.Test;
import org.springframework.aop.AdvisedSupport;
import org.springframework.aop.MethodMatcher;
import org.springframework.aop.TargetSource;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.framework.CglibAopProxy;
import org.springframework.aop.framework.JdkDynamicAopProxy;
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
}
