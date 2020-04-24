package com.springlearning.ioc.loader;

import java.net.URL;

public class ResourceLoader {

    public ResourceURL getResource(String location){
        URL url = this.getClass().getClassLoader().getResource(location);
        return new ResourceURL(url);
    }
}
