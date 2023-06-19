package org.springframework.beans;

/**
 * @author WangChao
 * @version 1.0
 * @date 2023/6/14 12:25
 */
public class BeansException extends RuntimeException{
    public BeansException(String msg) {
        super(msg);
    }

    public BeansException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
