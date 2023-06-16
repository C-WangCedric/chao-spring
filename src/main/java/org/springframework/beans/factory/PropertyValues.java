package org.springframework.beans.factory;

import java.util.ArrayList;
import java.util.List;

/**
 * @author WangChao
 * @version 1.0
 * @date 2023/6/15 11:05
 */
public class PropertyValues {
    private final List<PropertyValue> propertyValues = new ArrayList<>();

    public void addPropertyValue(PropertyValue value) {
        propertyValues.add(value);
    }

    public PropertyValue[] getPropertyValues(){
        return this.propertyValues.toArray(new PropertyValue[0]);
    }

    public PropertyValue getPropertyValue(String propertyName){
        int size = this.propertyValues.size();
        for(int i=0;i<size;i++){
            PropertyValue pv = this.propertyValues.get(i);
            if(pv.getName().equals(propertyName)){
                return pv;
            }
        }
        return null;
    }
}
