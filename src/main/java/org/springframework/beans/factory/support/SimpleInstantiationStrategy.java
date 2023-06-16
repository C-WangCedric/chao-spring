package org.springframework.beans.factory.support;

import org.springframework.beans.factory.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * @author WangChao
 * @version 1.0
 * @date 2023/6/15 10:46
 */
public class SimpleInstantiationStrategy implements InstantiationStrategy{
    /**
     * 简单的bean实例化策略，根据bean的无参构造函数实例化对象
     * @param beanDefinition
     * @return
     * @throws BeansException
     */
    @Override
    public Object instantiate(BeanDefinition beanDefinition) throws BeansException {
        Class beanClass = beanDefinition.getBeanClass();
        try{
            Constructor constructor = beanClass.getDeclaredConstructor();
            return constructor.newInstance();
        }catch(Exception e){
            throw new BeansException("Failed to instantiate [" + beanClass.getName() + "]", e);
        }
    }
}
