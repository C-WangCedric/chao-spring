package org.springframework.aop;

/**
 * @author WangChao
 * @version 1.0
 * @date 2023/6/29 10:46
 */
public interface ClassFilter {
    /**
     * 匹配类
     * @param clazz
     * @return
     */
    boolean matches(Class<?> clazz);
}
