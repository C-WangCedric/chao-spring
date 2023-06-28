package org.springframework.context;

/**
 * @author WangChao
 * @version 1.0
 * @date 2023/6/28 16:35
 */
public interface ApplicationEventPublisher {
    /**
     * 发布事件
     */
    void publishEvent(ApplicationEvent event);
}
