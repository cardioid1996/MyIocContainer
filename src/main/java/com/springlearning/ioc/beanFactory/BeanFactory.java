package com.springlearning.ioc.beanFactory;


import com.springlearning.ioc.BeanDefinition;

/**
 * 定义IOC容器行为的接口
 */
public interface BeanFactory {

    void registerBeanDefinition(String name, BeanDefinition beanDefinition) throws Exception;

    Object getBean(String name) throws Exception;
}
