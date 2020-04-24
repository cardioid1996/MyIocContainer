package com.springlearning.ioc;

public class BeanDefinition {

    private Object bean;

    private Class beanClass;

    private String className;  // bean的全限定类型名

    private PropertyValues propertyValues;


    public BeanDefinition(){
        this.propertyValues = new PropertyValues();
    }


    public Object getBean(){
        return this.bean;
    }


    public void setBean(Object bean){
        this.bean = bean;
    }


    public Class getBeanClass(){
        return this.beanClass;
    }


    public void setClassName(String className){
        this.className = className;
        try{
            this.beanClass = Class.forName(className);
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }


    public PropertyValues getPropertyValues(){
        return this.propertyValues;
    }


    public void setPropertyValues(PropertyValues propertyValues){
        this.propertyValues = propertyValues;
    }


}
