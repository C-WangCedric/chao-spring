package org.springframework.beans.factory.support;

import org.springframework.beans.BeansException;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

/**
 * @author WangChao
 * @date 2023/6/18 8:56
 */
public abstract class AbstractBeanDefinitionReader implements BeanDefinitionReader {
    private final BeanDefinitionRegistry beanDefinitionRegistry;

    private ResourceLoader resourceLoader;

    public AbstractBeanDefinitionReader(BeanDefinitionRegistry beanDefinitionRegistry){
        this(beanDefinitionRegistry,new DefaultResourceLoader());
    }

    //外边传入BeanDefinitionRegistry该接口的具体实现类，初始化变量
    public AbstractBeanDefinitionReader(BeanDefinitionRegistry beanDefinitionRegistry,ResourceLoader resourceLoader){
        this.beanDefinitionRegistry = beanDefinitionRegistry;
        this.resourceLoader =resourceLoader;
    }

    public void setResourceLoader(ResourceLoader resourceLoader){
        this.resourceLoader = resourceLoader;
    }

    @Override
    public ResourceLoader getResourceLoader() {
        return resourceLoader;
    }

    @Override
    public BeanDefinitionRegistry getRegistry() {
        return beanDefinitionRegistry;
    }

    @Override
    public void loadBeanDefinition(String[] locations) throws BeansException {
        for(String location:locations){
            loadBeanDefinition(location);
        }
    }
}
