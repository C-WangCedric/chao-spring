package org.springframework.beans.factory;

import org.springframework.beans.BeansException;

/**
 * @author WangChao
 * @version 1.0
 * @date 2023/6/28 9:49
 */
public interface BeanFactoryAware extends Aware{
    /**
     * 设置所属BeanFactory
     *
     * @param beanFactory
     * @throws BeansException
     */
    void setBeanFactory(BeanFactory beanFactory) throws BeansException;
}
