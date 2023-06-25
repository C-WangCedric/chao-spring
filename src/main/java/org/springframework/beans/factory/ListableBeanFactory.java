package org.springframework.beans.factory;

import org.springframework.beans.BeansException;

import java.util.Map;

/**
 * 用于检索在 Spring 容器中注册的所有 Bean 的信息。
 * 它定义了一些方法，使您能够获取 Bean 的名称、类型、别名等信息。
 * @author WangChao
 * @date 2023/6/18 8:33
 */
public interface ListableBeanFactory extends BeanFactory{
    /**
     * 返回指定类型的所有实例
     * @param type
     * @param <T>
     * @return
     * @throws BeansException
     */
    <T> Map<String,T> getBeanOfType(Class<T> type) throws BeansException;

    /**
     * 返回定义的所有bean的名称
     * @return
     */
    String[] getBeanDefinitionNames();
}
