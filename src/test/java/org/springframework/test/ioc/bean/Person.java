package org.springframework.test.ioc.bean;

/**
 * @author WangChao
 * @version 1.0
 * @date 2023/6/16 9:27
 */
public class Person {
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
}
