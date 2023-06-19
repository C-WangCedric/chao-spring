package org.springframework.test.ioc;

import cn.hutool.core.lang.Assert;
import org.junit.Test;
import org.springframework.beans.factory.config.BeanReference;
import org.springframework.test.ioc.bean.Person;
import org.springframework.test.ioc.bean.Car;
import org.springframework.beans.PropertyValue;
import org.springframework.beans.PropertyValues;
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

    /**
     * 为bean注入bean
     *
     * @throws Exception
     */
    @Test
    public void testPopulateBeanWithBean() throws Exception {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        //注册Car实例
        PropertyValues propertyValuesForCar = new PropertyValues();
        propertyValuesForCar.addPropertyValue(new PropertyValue("brand","porsche"));
        BeanDefinition carBeanDefinition = new BeanDefinition(Car.class, propertyValuesForCar);
        beanFactory.registerBeanDefinition("car",carBeanDefinition);

        //注册Person实例
        PropertyValues propertyValuesForPerson = new PropertyValues();
        propertyValuesForPerson.addPropertyValue(new PropertyValue("name", "derek"));
        propertyValuesForPerson.addPropertyValue(new PropertyValue("age", 18));
        //Person实例依赖Car实例
        propertyValuesForPerson.addPropertyValue(new PropertyValue("car",new BeanReference("car")));
        BeanDefinition beanDefinition = new BeanDefinition(Person.class, propertyValuesForPerson);
        beanFactory.registerBeanDefinition("person",beanDefinition);

        Person person = (Person) beanFactory.getBean("person");
        System.out.println(person);

        Assert.equals(person.getName(),"derek");
        Assert.equals(person.getAge(),18);
        Car car = person.getCar();
        Assert.notNull(car);
        Assert.equals(car.getBrand(),"porsche");
    }
}
