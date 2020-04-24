package com.springlearning.ioc.beanFactory;

import com.springlearning.ioc.BeanDefinition;
import com.springlearning.ioc.BeanReference;
import com.springlearning.ioc.PropertyValue;

import java.lang.reflect.Field;

public class AutowireBeanFactory extends AbstractBeanFactory{

    /**
     * 根据bean的定义创建bean实例并注入属性
     * @param beanDefinition bean描述对象
     * @return bean实例
     * @throws InstantiationException, IllegalAccessException,
     */
    @Override
    protected Object doCreateBean(BeanDefinition beanDefinition) throws Exception{
        Object bean = beanDefinition.getBeanClass().newInstance();
        addPropertyValues(bean, beanDefinition);
        return bean;
    }


    /**
     * 给生成的bean实例注入属性
     * @param bean bean实例
     * @param beanDefinition bean实例对应的bean描述对象
     */
    protected void addPropertyValues(Object bean, BeanDefinition beanDefinition) throws Exception{
        for (PropertyValue pv : beanDefinition.getPropertyValues().getPropertyValues()){
            Field field = bean.getClass().getDeclaredField(pv.getName());
            field.setAccessible(true);
            Object value = pv.getValue();
            if (value instanceof BeanReference){
                BeanReference beanReference = (BeanReference)value;
                value = getBean(beanReference.getName());
            }
            field.set(bean, value);
        }
    }
}
