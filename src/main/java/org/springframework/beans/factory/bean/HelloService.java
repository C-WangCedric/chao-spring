package org.springframework.beans.factory.bean;

/**
 * @author WangChao
 * @version 1.0
 * @date 2023/6/15 10:31
 */
public class HelloService {
    public String sayHello(){
        System.out.println("hello");
        return "hello";
    }
}
