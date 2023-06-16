package org.springframework.test.ioc;

import org.junit.Test;
import org.springframework.test.ioc.bean.Person;
import org.springframework.beans.factory.PropertyValue;
import org.springframework.beans.factory.PropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;

/**
 * @author WangChao
 * @version 1.0
 * @date 2023/6/16 9:28
 */
public class PopulateBeanWithPropertyValuesTest {
    @Test
    public void testPopulateBeanWithPropertyValues() throws Exception{
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        PropertyValues propertyValues = new PropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("name","chao"));
        propertyValues.addPropertyValue(new PropertyValue("age",18));
        BeanDefinition beanDefinition = new BeanDefinition(Person.class, propertyValues);
        beanFactory.registerBeanDefinition("person",beanDefinition);

        Person person = (Person)beanFactory.getBean("person");
        System.out.println(person.toString());
    }
}
