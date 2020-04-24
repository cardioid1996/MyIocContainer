package com.springlearning.ioc;

import java.util.ArrayList;
import java.util.List;

public class PropertyValues {

    private final List<PropertyValue> propertyValues = new ArrayList<>();


    public PropertyValues(){ }

    public void addPV(PropertyValue pv){
        propertyValues.add(pv);
    }

    public List<PropertyValue> getPropertyValues(){
        return this.propertyValues;
    }



}
