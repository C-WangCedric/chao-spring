package org.springframework.context;

import java.util.EventListener;

/**
 * 当应用程序发布一个事件时，实现了ApplicationListener接口的类会被通知，并且可以对该事件做出响应。
 * onApplicationEvent方法的作用是处理应用程序事件。当一个事件被发布时，
 * Spring框架会遍历所有实现了ApplicationListener接口的类，并调用它们的onApplicationEven
 * @author WangChao
 * @version 1.0
 * @date 2023/6/28 15:33
 */
public interface ApplicationListener<E extends ApplicationEvent> extends EventListener {
    /**
     * 处理应用程序事件
     * @param event
     */
    void onApplicationEvent(E event);
}
