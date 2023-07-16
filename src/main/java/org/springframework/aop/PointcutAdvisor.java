package org.springframework.aop;

/**
 * @author WangChao
 * @date 2023-07-16 21:16
 */
public interface PointcutAdvisor extends Advisor{
    Pointcut getPointcut();
}
