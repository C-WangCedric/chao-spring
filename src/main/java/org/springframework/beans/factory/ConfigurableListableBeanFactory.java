package org.springframework.beans.factory;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;

/**
 * @author WangChao
 * @date 2023/6/18 8:40
 */
public interface ConfigurableListableBeanFactory extends ListableBeanFactory, AutowireCapableBeanFactory, ConfigurableBeanFactory {
    /**
     * 根据名称查找BeanDefinition
     * @param beanName
     * @return
     * @throws BeansException
     */
    BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    /**
     * 提前实例化所有的bean
     * @throws BeansException
     */
    void preInstantiateSingletons() throws BeansException;

    /**
     * 添加BeanPostProcessor
     * @param beanPostProcessor
     * @throws BeansException
     */
    @Override
    void addBeanPostProcessor(BeanPostProcessor beanPostProcessor) throws BeansException;
}
