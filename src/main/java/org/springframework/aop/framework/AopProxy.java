package org.springframework.aop.framework;

/**
 * @author WangChao
 * @version 1.0
 * @date 2023/6/30 10:55
 */
public interface AopProxy {
    /**
     * 获取代理对象
     * @return
     */
    Object getProxy();
}
