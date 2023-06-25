package org.springframework.beans.factory.config;

/**
 * 一个bean对另一个bean的引用
 * @author WangChao
 * @date 2023/06/17
 */
public class BeanReference {
    private final String beanName;


    public BeanReference(String beanName) {
        this.beanName = beanName;
    }

    public String getBeanName(){
        return beanName;
    }
}
