package org.springframework.beans.factory.support;

import org.springframework.beans.factory.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;

/**
 * Bean的实例化策略
 * @author WangChao
 * @version 1.0
 * @date 2023/6/15 10:37
 */
public interface InstantiationStrategy {
    /**
     * 获取bean示例对象
     * @param beanDefinition
     * @return
     * @throws BeansException
     */
    Object instantiate(BeanDefinition beanDefinition) throws BeansException;
}
