package org.springframework.aop;

import java.lang.reflect.Method;

/**
 * @author WangChao
 * @version 1.0
 * @date 2023/6/29 10:45
 */
public interface MethodMatcher {
    /**
     * 方法匹配
     * @param method
     * @param targetClass
     * @return
     */
    boolean matches(Method method, Class<?> targetClass);
}
