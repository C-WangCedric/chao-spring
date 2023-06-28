package org.springframework.context.event;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

/**
 * @author WangChao
 * @version 1.0
 * @date 2023/6/28 15:37
 */
public interface ApplicationEventMulticaster {
    /**
     * 添加监听器
     * @param listener
     */
    void addApplicationListener(ApplicationListener<?> listener);

    /**
     * 移除监听器
     * @param listener
     */
    void removeApplicationListener(ApplicationListener<?> listener);

    /**
     * multicastEvent()方法的作用是将事件传递给所有已注册的监听器。
     * 它会遍历所有已注册的监听器，并依次调用每个监听器的onApplicationEvent()方法，将事件对象作为参数传递给监听器。
     * 这样，每个监听器就有机会对事件做出响应，执行相应的业务逻辑。
     * @param event
     */
    void multicastEvent(ApplicationEvent event);
}
