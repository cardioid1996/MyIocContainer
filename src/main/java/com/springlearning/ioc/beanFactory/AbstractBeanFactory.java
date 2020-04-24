package com.springlearning.ioc.beanFactory;

import com.springlearning.ioc.BeanDefinition;

import java.util.HashMap;

public abstract class AbstractBeanFactory implements BeanFactory{

    private HashMap<String, BeanDefinition> beanDefinitionMap = new HashMap<>();


    public void registerBeanDefinition (String name, BeanDefinition beanDefinition) throws Exception{
        Object bean = doCreateBean(beanDefinition);
        beanDefinition.setBean(bean);
        beanDefinitionMap.put(name, beanDefinition);
    }


    public Object getBean(String name) throws Exception{
        BeanDefinition beanDefinition = beanDefinitionMap.get(name);
        if (beanDefinition == null){
            throw new IllegalArgumentException("不存在名为"+name+"的bean");
        }
        Object bean = beanDefinition.getBean();
        if (bean == null){
            bean = doCreateBean(beanDefinition);
        }
        return bean;
    }


    abstract Object doCreateBean(BeanDefinition beanDefinition) throws Exception;

}
