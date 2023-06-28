package org.springframework.test.ioc;

import cn.hutool.core.lang.Assert;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.ioc.bean.Car;

/**
 * @author WangChao
 * @version 1.0
 * @date 2023/6/28 11:09
 */
public class PrototypeBeanTest {
    @Test
    public void testPrototype() throws Exception {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:prototype-bean.xml");

        Car car1 = applicationContext.getBean("car", Car.class);
        Car car2 = applicationContext.getBean("car", Car.class);
        Assert.isFalse(car1==car2);
    }
}
