package com.springlearning.ioc.beanDefinitionReader;

import com.springlearning.ioc.BeanDefinition;
import com.springlearning.ioc.BeanReference;
import com.springlearning.ioc.PropertyValue;
import com.springlearning.ioc.loader.ResourceLoader;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.InputStream;

public class XmlBeanDefinitionReader extends AbstractBeanDefinitionReader{

    public XmlBeanDefinitionReader(ResourceLoader resourceLoader){
        super(resourceLoader);
    }

    public void readXML(String location) throws Exception{
        InputStream inputStream = null;
        try {
            ResourceLoader resourceLoader = getResourceLoader();
            inputStream = resourceLoader.getResource(location).getInputStream();
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = documentBuilderFactory.newDocumentBuilder();
            Document doc = docBuilder.parse(inputStream);
            registerBeanDefinitions(doc);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            inputStream.close();
        }
    }


    private void registerBeanDefinitions(Document doc){
        Element root = doc.getDocumentElement();
        parseBeanDefinitions(root);
    }

    private void parseBeanDefinitions(Element root) {
        NodeList nl = root.getChildNodes();
        // 遍历子元素
        for (int i = 0; i < nl.getLength(); i++) {
            Node node = nl.item(i);
            if (node instanceof Element) {
                Element ele = (Element) node;
                // 解析给给定的节点，包括name，class，property， name， value，ref
                processBeanDefinition(ele);
            }
        }
    }


    private void processBeanDefinition(Element ele) {
        String name = ele.getAttribute("name");
        String className = ele.getAttribute("class");
        BeanDefinition beanDefinition = new BeanDefinition();
        beanDefinition.setClassName(className);
        addPropertyValues(ele, beanDefinition);
        getBeanDefinitionMap().put(name, beanDefinition);
    }


    private void addPropertyValues(Element ele, BeanDefinition beandefinition) {
        NodeList propertyNode = ele.getElementsByTagName("property");
        for (int i = 0; i < propertyNode.getLength(); i++) {
            Node node = propertyNode.item(i);
            if (node instanceof Element) {
                Element propertyEle = (Element) node;
                String name = propertyEle.getAttribute("name");
                String value = propertyEle.getAttribute("value");
                if (value != null && value.length() > 0) {
                    beandefinition.getPropertyValues().addPV(new PropertyValue(name, value));
                } else {
                    String ref = propertyEle.getAttribute("ref");
                    if (ref == null || ref.length() == 0) {
                        throw new IllegalArgumentException(
                                "Configuration problem: <property> element for property '"
                                        + name + "' must specify a ref or value");
                    }
                    BeanReference beanRef = new BeanReference(name);
                    beandefinition.getPropertyValues().addPV(new PropertyValue(name, beanRef));
                }
            }
        }
    }
}
