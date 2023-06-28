package org.springframework.test.ioc.common;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.test.ioc.bean.Car;

/**
 * @author WangChao
 * @version 1.0
 * @date 2023/6/28 13:33
 */
public class CarFactoryBean implements FactoryBean<Car> {
    private String brand;

    @Override
    public Car getObject() throws Exception {
        Car car = new Car();
        car.setBrand(brand);
        return car;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }

    public void setBrand(String brand){
        this.brand = brand;
    }
}
