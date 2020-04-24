package com.springlearning.ioc.beanDefinitionReader;

import com.springlearning.ioc.BeanDefinition;
import com.springlearning.ioc.loader.ResourceLoader;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractBeanDefinitionReader {


    private ResourceLoader resourceLoader;

    private Map<String, BeanDefinition> beanDefinitionMap;


    public AbstractBeanDefinitionReader(ResourceLoader resourceLoader){
        this.resourceLoader = resourceLoader;
        beanDefinitionMap = new HashMap<>();
    }


    public Map<String, BeanDefinition> getBeanDefinitionMap(){
        return this.beanDefinitionMap;
    }


    public ResourceLoader getResourceLoader(){
        return this.resourceLoader;
    }

}
