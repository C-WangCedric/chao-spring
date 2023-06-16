package org.springframework.beans.factory;

/**
 * bean容器
 * @author WangChao
 * @version 1.0
 * @date 2023/6/14 11:15
 */
public interface BeanFactory {
    /**
     * 获取bean
     * @param beanName
     * @return
     */
    Object getBean(String beanName);
}
