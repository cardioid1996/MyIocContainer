package com.springlearning.ioc.loader;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class ResourceURL implements Resource{
    private final URL url;

    public ResourceURL(URL url){
        this.url = url;
    }

    @Override
    public InputStream getInputStream() throws Exception{
        URLConnection urlConnection = url.openConnection();
        urlConnection.connect();
        return urlConnection.getInputStream();
    }
}
