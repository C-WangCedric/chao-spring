package org.springframework.core.io;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * URL下的资源
 * @author WangChao
 * @date 2023/6/17 20:14
 */
public class UrlResource implements Resource {
    private final URL url;

    public UrlResource(URL url){
        this.url = url;
    }

    @Override
    public InputStream getInputStream() throws IOException {
        URLConnection urlConnection = this.url.openConnection();
        try{
            return urlConnection.getInputStream();
        }catch (IOException ex) {
            throw ex;
        }
    }
}
