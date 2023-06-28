package org.springframework.context.event;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @author WangChao
 * @version 1.0
 * @date 2023/6/28 15:46
 */
public class SimpleApplicationEventMulticaster extends AbstractApplicationEventMulticaster{
    public SimpleApplicationEventMulticaster(BeanFactory beanFactory){
        setBeanFactory(beanFactory);
    }

    @Override
    public void multicastEvent(ApplicationEvent event) {
        for(ApplicationListener<ApplicationEvent> applicationListener :applicationListeners){
            if(supportsEvent(applicationListener,event)){
                //调用处理事件的方法
                applicationListener.onApplicationEvent(event);
            }
        }
    }

    /**
     * 监听器是否对事件感兴趣
     * @param applicationListener
     * @param event
     * @return
     */
    protected boolean supportsEvent(ApplicationListener<ApplicationEvent> applicationListener,ApplicationEvent event){
        //获取对象所实现的第一个泛型接口类型
        Type type = applicationListener.getClass().getGenericInterfaces()[0];
        //获取到泛型接口的第一个实际类型参数
        Type actualTypeArgument = ((ParameterizedType) type).getActualTypeArguments()[0];
        String className = actualTypeArgument.getTypeName();
        Class<?> eventClass;
        try {
            eventClass = Class.forName(className);
        }catch (ClassNotFoundException e){
            throw new BeansException("wrong event class name: " + className);
        }
        //用于确定一个类是否可以从另一个类进行赋值，该事件的子类事件也能匹配上
        return eventClass.isAssignableFrom(event.getClass());
    }
}
