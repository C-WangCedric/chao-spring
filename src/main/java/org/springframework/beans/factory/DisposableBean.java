package org.springframework.beans.factory;

/**
 * @author WangChao
 * @version 1.0
 * @date 2023/6/27 14:20
 */
public interface DisposableBean {
    /**
     * 销毁方法
     * @throws Exception
     */
    void destroy() throws Exception;
}
