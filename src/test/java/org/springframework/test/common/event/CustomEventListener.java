package org.springframework.test.common.event;

import org.springframework.context.ApplicationListener;

/**
 * @author WangChao
 * @version 1.0
 * @date 2023/6/28 16:40
 */
public class CustomEventListener implements ApplicationListener<CustomEvent> {
    @Override
    public void onApplicationEvent(CustomEvent event) {
        System.out.println(this.getClass().getName());
    }
}
