package org.springframework.test.ioc.common.event;

import org.springframework.context.ApplicationEvent;

/**
 * @author WangChao
 * @version 1.0
 * @date 2023/6/28 16:40
 */
public class CustomEvent extends ApplicationEvent {
    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public CustomEvent(Object source) {
        super(source);
    }
}
