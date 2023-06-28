package org.springframework.test.ioc.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * @author WangChao
 * @version 1.0
 * @date 2023/6/16 9:27
 */
public class Person implements InitializingBean, DisposableBean {
    private String name;

    private int age;

    private Car car;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setCar(Car car){
        this.car = car;
    }

    public Car getCar(){
        return car;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +'\'' +
                ", car=" + car.getBrand() +
                '}';
    }

    public void customInitMethod() {
        System.out.println("I was born in the method named customInitMethod");
    }

    public void customDestroyMethod() {
        System.out.println("I died in the method named customDestroyMethod");
    }

    @Override
    public void afterPropertiesSet() throws BeansException {
        System.out.println("I was born in the method named afterPropertiesSet");
    }

    @Override
    public void destroy() throws BeansException {
        System.out.println("I died in the method named destroy");
    }
}
