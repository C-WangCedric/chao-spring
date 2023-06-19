package org.springframework.beans.factory.support;

import org.springframework.beans.BeansException;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

/**
 * @author WangChao
 * @date 2023/6/18 8:50
 */
public interface BeanDefinitionReader {
    /**
     * 获取BeanDefinitionRegistry
     * @return
     */
    BeanDefinitionRegistry getRegistry();

    /**
     * 获取资源加载器
     * @return
     */
    ResourceLoader getResourceLoader();

    /**
     * 装配BeanDefinition
     * @param resource
     * @throws BeansException
     */
    void loadBeanDefinition(Resource resource) throws BeansException;

    void loadBeanDefinition(String location) throws BeansException;

    void loadBeanDefinition(String []locations) throws BeansException;
}
