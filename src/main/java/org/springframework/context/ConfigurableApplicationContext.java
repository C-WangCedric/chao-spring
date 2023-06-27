package org.springframework.context;

import org.springframework.beans.BeansException;

/**
 * @author WangChao
 * @version 1.0
 * @date 2023/6/26 11:27
 */
public interface ConfigurableApplicationContext extends ApplicationContext{
    /**
     * 刷新容器
     * @throws BeansException
     */
    void refresh() throws BeansException;
}
