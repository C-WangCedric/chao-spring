package org.springframework.aop;

/**
 * 切点抽象
 * @author WangChao
 * @version 1.0
 * @date 2023/6/29 10:45
 */
public interface Pointcut {
    /**
     * 获取类匹配
     * @return
     */
    ClassFilter getClassFilter();

    /**
     * 获取方法匹配
     * @return
     */
    MethodMatcher getMethodMatcher();
}
