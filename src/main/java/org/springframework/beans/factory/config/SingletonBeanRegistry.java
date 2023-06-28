package org.springframework.beans.factory.config;

/**
 * 单例注册表
 * @author WangChao
 * @version 1.0
 * @date 2023/6/14 12:09
 */
public interface SingletonBeanRegistry {
    /**
     * 获取单例bean对象
     * @param beanName
     * @return
     */
    Object getSingleton(String beanName);

    void addSingleton(String beanName,Object singletonObject);
}
