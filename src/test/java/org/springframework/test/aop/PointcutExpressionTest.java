package org.springframework.test.aop;

import cn.hutool.core.lang.Assert;
import org.junit.Test;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.test.service.HelloService;

import java.lang.reflect.Method;

/**
 * @author WangChao
 * @version 1.0
 * @date 2023/6/29 11:45
 */
public class PointcutExpressionTest {
    @Test
    public void testPointcutExpression() throws Exception {
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut("execution(* org.springframework.test.service.HelloService.*(..))");
        Class<HelloService> clazz = HelloService.class;
        Method method = clazz.getDeclaredMethod("sayHello");

        //匹配类和方法
        Assert.isTrue(pointcut.matches(clazz));
        Assert.isTrue(pointcut.matches(method, clazz));
    }
}
