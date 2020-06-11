package com.spider.utils;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileInputStream;
import java.net.URI;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;

public class LoadResourceUtil {

    public  Properties getProperties(String fileName) {//获取resources下的properties文件
        Properties props = new Properties();
        try {
            URI resource = this.getClass().getClassLoader().getResource(fileName).toURI();
            File file = new File(resource);
            FileInputStream ips = new FileInputStream(file.getAbsoluteFile());
            if (ips == null) {
                throw new RuntimeException("配置文件不存在");
            }
            props.load(ips);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return props;
    }
}
