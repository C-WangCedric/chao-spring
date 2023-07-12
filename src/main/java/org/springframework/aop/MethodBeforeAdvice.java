package org.springframework.aop;

import org.aopalliance.aop.Advice;

import java.lang.reflect.Method;

/**
 * @author WangChao
 * @date 2023-07-12 21:25
 */
public interface MethodBeforeAdvice extends Advice {

    void before(Method method,Object[] args,Object target) throws Throwable;
}
