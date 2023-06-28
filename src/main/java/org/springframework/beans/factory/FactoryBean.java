package org.springframework.beans.factory;

/**
 * @author WangChao
 * @version 1.0
 * @date 2023/6/28 13:15
 */
public interface FactoryBean<T>{
    /**
     * 获取bean对象
     * @return
     * @throws Exception
     */
    T getObject() throws Exception;

    /**
     * 是否为单例
     * @return
     */
    boolean isSingleton();
}
