package org.springframework.beans.factory.support;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 抽象创建bean的工厂
 * 不直接实现实现BeanFactory，而是实现他的子接口
 * @author WangChao
 * @version 1.0
 * @date 2023/6/14 12:13
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements ConfigurableBeanFactory {
    private final List<BeanPostProcessor> beanPostProcessors = new ArrayList<>();
    private final Map<String, Object> factoryBeanObjectCache = new HashMap<>();

    @Override
    public Object getBean(String beanName) throws BeansException {
        //如果已经存在该bean，则直接调用方法返回
        Object sharedInstance  = getSingleton(beanName);
        if(sharedInstance!=null){
            //如果是FactoryBean，从FactoryBean#getObject中创建bean
            return getObjectForBeanInstance(sharedInstance,beanName);
        }
        BeanDefinition beanDefinition = getBeanDefinition(beanName);
        Object bean = createBean(beanName, beanDefinition);
        return getObjectForBeanInstance(bean,beanName);
    }

    protected Object getObjectForBeanInstance(Object beanInstance,String beanName){
        Object object = beanInstance;
        if(beanInstance instanceof FactoryBean){
            FactoryBean factoryBean = (FactoryBean)beanInstance;
            try{
                if(factoryBean.isSingleton()){
                    //singleton作用域bean，从缓存中获取
                    object = this.factoryBeanObjectCache.get(beanName);
                    if(object==null){
                        object = factoryBean.getObject();
                        this.factoryBeanObjectCache.put(beanName,object);
                    }
                }else{
                    //prototype作用域bean，新创建bean
                    object = factoryBean.getObject();
                }
            }catch (Exception ex) {
                throw new BeansException("FactoryBean threw exception on object[" + beanName + "] creation", ex);
            }
        }
        return object;
    }

    @Override
    public <T> T getBean(String name, Class<T> requiredType) throws BeansException{
        return (T)getBean(name);
    }

    /**
     * 创建一个bean
     * @param beanName bean名称
     * @param beanDefinition
     * @return
     * @throws BeansException
     */
    protected abstract Object createBean(String beanName,BeanDefinition beanDefinition) throws BeansException;

    /**
     * 根据bean名称获取BeanDefinition
     * @param beanName
     * @return
     * @throws BeansException
     */
    protected abstract BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    @Override
    public void addBeanPostProcessor(BeanPostProcessor beanPostProcessor) {
        //有则覆盖
        this.beanPostProcessors.remove(beanPostProcessor);
        this.beanPostProcessors.add(beanPostProcessor);
    }

    public List<BeanPostProcessor> getBeanPostProcessors() {
        return this.beanPostProcessors;
    }
}
