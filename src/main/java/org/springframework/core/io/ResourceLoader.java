package org.springframework.core.io;

/**
 * 资源加载器接口
 * @author WangChao
 * @date 2023/6/17 20:18
 */
public interface ResourceLoader {
    Resource getResource(String location);
}
