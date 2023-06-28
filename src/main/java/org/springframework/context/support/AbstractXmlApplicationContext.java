package org.springframework.context.support;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * 该类只负责从xml中加载BeanDefinition
 * @author WangChao
 * @version 1.0
 * @date 2023/6/27 9:38
 */
public abstract class AbstractXmlApplicationContext extends AbstractRefreshableApplicationContext{
    @Override
    protected void loadBeanDefinitions(DefaultListableBeanFactory beanFactory){
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory,this);
        String[] configurations = getConfigurations();
        if(configurations!=null){
            beanDefinitionReader.loadBeanDefinition(configurations);
        }
    }

    /**
     * 获取配置路径
     * @return
     */
    protected abstract String[] getConfigurations();
}
