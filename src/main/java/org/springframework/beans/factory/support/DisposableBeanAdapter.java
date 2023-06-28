package org.springframework.beans.factory.support;

import cn.hutool.core.util.ClassUtil;
import cn.hutool.core.util.StrUtil;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Method;

/**
 * 具体的类用来存入map中
 * 具体的实现类，用来调用bean对象的destroy方法和销毁方法
 * @author WangChao
 * @version 1.0
 * @date 2023/6/27 15:05
 */
public class DisposableBeanAdapter implements DisposableBean {
    private final Object bean;

    private final String beanName;

    private final String destroyMethodName;

    public DisposableBeanAdapter(Object bean, String beanName, BeanDefinition beanDefinition) {
        this.bean = bean;
        this.beanName = beanName;
        this.destroyMethodName = beanDefinition.getDestroyMethodName();
    }

    @Override
    public void destroy() throws Exception{
        if(bean instanceof DisposableBean){
            ((DisposableBean) bean).destroy();
        }
        //避免同时继承自DisposableBean，且自定义方法与DisposableBean方法同名，销毁方法执行两次的情况
        boolean isDisposed = StrUtil.isNotEmpty(destroyMethodName)&&!(bean instanceof DisposableBean && "destroy".equals(this.destroyMethodName));
        if(isDisposed){
            //执行自定义的方法
            Method publicMethod = ClassUtil.getPublicMethod(bean.getClass(), destroyMethodName);
            if(publicMethod==null){
                throw new BeansException("Couldn't find a destroy method named '" + destroyMethodName + "' on bean with name '" + beanName + "'");
            }
            publicMethod.invoke(bean);
        }
    }
}
