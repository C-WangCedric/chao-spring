package org.springframework.beans.factory.config;

/**
 * 单例注册表
 * @author WangChao
 * @version 1.0
 * @date 2023/6/14 12:09
 */
public interface SingletonBeanRegistry {
    Object getSingleton(String beanName);
}
