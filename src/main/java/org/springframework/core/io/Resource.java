package org.springframework.core.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * 资源的抽象和访问接口
 * @author WangChao
 * @date 2023/6/17 19:53
 */
public interface Resource {
    InputStream getInputStream() throws IOException;
}
