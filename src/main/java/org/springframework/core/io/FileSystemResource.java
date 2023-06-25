package org.springframework.core.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;

/**
 * 文件系统下的资源
 * @author WangChao
 * @date 2023/6/17 20:10
 */
public class FileSystemResource implements Resource{
    private final String path;

    public FileSystemResource(String path){
        this.path = path;
    }

    @Override
    public InputStream getInputStream() throws IOException {
        try{
            Path path = new File(this.path).toPath();
            return Files.newInputStream(path);
        }catch (NoSuchFileException ex){
            throw new FileNotFoundException(ex.toString());
        }
    }
}
