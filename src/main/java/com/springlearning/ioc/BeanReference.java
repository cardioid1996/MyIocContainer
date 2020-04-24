package com.springlearning.ioc;


/**
 * bean的引用
 */
public class BeanReference {

    private String name;

    private Object bean;

    public BeanReference(String name){
        this.name = name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public void setBean(Object bean){
        this.bean = bean;
    }

    public Object getBean(){
        return this.bean;
    }
}
