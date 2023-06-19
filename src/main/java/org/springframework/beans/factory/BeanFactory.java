package org.springframework.beans.factory;

import org.springframework.beans.BeansException;

/**
 * bean容器
 * @author WangChao
 * @version 1.0
 * @date 2023/6/14 11:15
 */
public interface BeanFactory {
    /**
     * 获取bean
     * @param name
     * @return
     */
    Object getBean(String name) throws BeansException;

    /**
     * 根据名称和类型查找bean
     * @param name
     * @param requiredType
     * @param <T>
     * @return
     * @throws BeansException
     */
    <T> T getBean(String name,Class<T> requiredType) throws BeansException;
}
