package com.springlearning.ioc.loader;

import java.io.IOException;
import java.io.InputStream;

public interface Resource {
    InputStream getInputStream() throws Exception;
}
