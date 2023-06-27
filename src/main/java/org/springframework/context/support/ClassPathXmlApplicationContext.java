package org.springframework.context.support;

import org.springframework.beans.BeansException;

/**
 * @author WangChao
 * @version 1.0
 * @date 2023/6/27 9:44
 */
public class ClassPathXmlApplicationContext extends AbstractXmlApplicationContext{
    private String[] configurations;

    public ClassPathXmlApplicationContext(String configuration) throws BeansException{
        this(new String[]{configuration});
    }

    public ClassPathXmlApplicationContext(String[] configurations) throws BeansException{
        this.configurations = configurations;
        refresh();
    }

    @Override
    protected String[] getConfigurations() {
        return this.configurations;
    }
}
