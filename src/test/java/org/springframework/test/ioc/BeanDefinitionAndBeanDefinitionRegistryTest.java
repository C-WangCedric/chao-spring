package org.springframework.test.ioc;

import org.junit.Test;
import org.springframework.beans.factory.bean.HelloService;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;

/**
 * @author WangChao
 * @version 1.0
 * @date 2023/6/15 10:24
 */
public class BeanDefinitionAndBeanDefinitionRegistryTest {
    @Test
    public void testBeanDefinition() throws Exception{
//        DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();
//        BeanDefinition beanDefinition = new BeanDefinition(HelloService.class);
//        defaultListableBeanFactory.registerBeanDefinition("helloService",beanDefinition);
//
//        HelloService helloService = (HelloService)defaultListableBeanFactory.getBean("helloService");
//        helloService.sayHello();
    }
}
