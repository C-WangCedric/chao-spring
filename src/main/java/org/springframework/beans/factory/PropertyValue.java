package org.springframework.beans.factory;

/**
 * bean属性信息
 * @author WangChao
 * @version 1.0
 * @date 2023/6/15 11:02
 */
public class PropertyValue {
    private final String name;
    private final Object value;

    /**
     * 为bean注入属性
     * @param name
     * @param value
     */
    public PropertyValue(String name,Object value) {
        this.name = name;
        this.value = value;
    }

    public String getName(){
        return name;
    }

    public Object getValue(){
        return value;
    }
}
