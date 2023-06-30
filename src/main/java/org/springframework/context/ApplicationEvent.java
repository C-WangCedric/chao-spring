package org.springframework.context;

import java.util.EventObject;

/**
 * 事件对象
 * @author WangChao
 * @version 1.0
 * @date 2023/6/28 15:29
 */
public abstract class ApplicationEvent extends EventObject {

    /**
     * Constructs a prototypical Event.
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public ApplicationEvent(Object source) {
        super(source);
    }
}
