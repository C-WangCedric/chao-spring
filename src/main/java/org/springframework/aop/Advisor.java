package org.springframework.aop;

import org.aopalliance.aop.Advice;

/**
 * @author WangChao
 * @date 2023-07-16 21:16
 */
public interface Advisor {
    Advice getAdvice();
}
