package org.springframework.beans.factory.support;

import org.springframework.beans.factory.config.BeanDefinition;

/**
 * BeanDefinition注册表接口
 * @author WangChao
 * @version 1.0
 * @date 2023/6/14 12:19
 */
public interface BeanDefinitionRegistry {
    /**
     * 向注册表中注BeanDefinition
     * @param beanName
     * @param beanDefinition
     */
    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);
}
