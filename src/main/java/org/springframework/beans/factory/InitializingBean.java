package org.springframework.beans.factory;

/**
 * @author WangChao
 * @version 1.0
 * @date 2023/6/27 14:45
 */
public interface InitializingBean {
    /**
     * 初始化之后执行的方法
     * @throws Exception
     */
    void afterPropertiesSet() throws Exception;
}
