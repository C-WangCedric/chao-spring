package org.springframework.aop.framework;

import org.springframework.aop.AdvisedSupport;

/**
 * @author WangChao
 * @date 2023-07-11 21:38
 */
public class ProxyFactory {
    private AdvisedSupport advisedSupport;

    public ProxyFactory(AdvisedSupport advisedSupport){
        this.advisedSupport = advisedSupport;
    }

    public Object getProxy(){
        return createAopProxy().getProxy();
    }

    private AopProxy createAopProxy(){
        if(advisedSupport.isProxyTargetClass()){
            return new CglibAopProxy(advisedSupport);
        }
        return new JdkDynamicAopProxy(advisedSupport);
    }
}
