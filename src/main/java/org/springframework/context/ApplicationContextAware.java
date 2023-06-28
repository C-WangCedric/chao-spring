package org.springframework.context;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.Aware;

/**
 * @author WangChao
 * @version 1.0
 * @date 2023/6/28 9:57
 */
public interface ApplicationContextAware extends Aware {
    /**
     * 设置ApplicationContext
     * @param applicationContext
     * @throws BeansException
     */
    void setApplicationContext(ApplicationContext applicationContext) throws BeansException;
}
