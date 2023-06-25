package org.springframework.core.io;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * 默认资源加载器，选择使用那种资源加载类
 * @author WangChao
 * @date 2023/6/17 20:19
 */
public class DefaultResourceLoader implements ResourceLoader{
    public static final String CLASSPATH_URL_PREFIX = "classpath:";

    @Override
    public Resource getResource(String location) {
        if(location.startsWith(CLASSPATH_URL_PREFIX)){
            //classpath下的资源
            return new ClassPathResource(location.substring(CLASSPATH_URL_PREFIX.length()));
        }else{
            try {
                //尝试当成url来处理
                URL url = new URL(location);
                return new UrlResource(url);
            }catch (MalformedURLException e){
                //当成文件系统下的资源处理
                return new FileSystemResource(location);
            }
        }
    }
}
