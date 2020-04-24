package com.springlearning.ioc.test;

import com.springlearning.ioc.BeanDefinition;
import com.springlearning.ioc.PropertyValue;
import com.springlearning.ioc.PropertyValues;
import com.springlearning.ioc.beanFactory.AutowireBeanFactory;
import com.springlearning.ioc.beanFactory.BeanFactory;
import org.junit.Test;

public class BeanFactoryTest {

    private final String className = "";

    @Test
    public void test() throws Exception{
        BeanFactory beanFactory = new AutowireBeanFactory();
        BeanDefinition beanDefinition = new BeanDefinition();
        beanDefinition.setClassName(className);
        PropertyValues pvs = new PropertyValues();
        pvs.addPV(new PropertyValue("id",0));
        pvs.addPV(new PropertyValue("name","zhangsan"));
        beanDefinition.setPropertyValues(pvs);

        beanFactory.registerBeanDefinition();



    }
}
