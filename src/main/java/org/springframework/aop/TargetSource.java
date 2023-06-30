package org.springframework.aop;

/**
 * 被代理的目标对象
 * @author WangChao
 * @version 1.0
 * @date 2023/6/30 10:45
 */
public class TargetSource {
    private final Object target;

    public TargetSource(Object object){
        this.target = object;
    }

    //表示目标对象实现的接口数组
    public Class<?>[] getTargetClass(){
        return this.target.getClass().getInterfaces();
    }

    public Object getTarget(){
        return this.target;
    }
}
