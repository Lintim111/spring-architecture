package com.lintim111.spring.architecture.spring.boot.starter.sms.using.test;

import org.springframework.core.io.UrlResource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.net.URL;
import java.util.*;

public class SPITest {
    public static final String FACTORIES_RESOURCE_LOCATION = "META-INF/spring.factories";

    public static void main(String[] args) throws IOException {
        List<Class> factoryClass = new ArrayList<>();

        factoryClass.add(org.springframework.boot.autoconfigure.EnableAutoConfiguration.class);
        factoryClass.add(org.springframework.context.ApplicationContextInitializer.class);
        factoryClass.add(org.springframework.context.ApplicationListener.class);
        factoryClass.add(org.springframework.boot.autoconfigure.AutoConfigurationImportListener.class);
        factoryClass.add(org.springframework.boot.autoconfigure.AutoConfigurationImportFilter.class);

        Map<String, HashMap<String, List<String>>> result = new HashMap<>();
        for (Class factory : factoryClass) {
            result.put(factory.getName(), loadFactoryNames(factory, Thread.currentThread().getContextClassLoader()));
        }

        for (String key : result.keySet()) {
            System.out.println(key + ": ");
            HashMap<String, List<String>> map = result.get(key);
            for (String jarName : map.keySet()) {
                System.out.println("  " + jarName + ": ");
                for (String value : map.get(jarName)) {
                    System.out.println("    " + value + "; ");
                }
            }
        }
    }

    public static HashMap<String, List<String>> loadFactoryNames(Class<?> factoryClass, ClassLoader classLoader) throws IOException {
        String factoryClassName = factoryClass.getName();
        // 取得资源文件的URL
        Enumeration<URL> urls = (classLoader != null ? classLoader.getResources(FACTORIES_RESOURCE_LOCATION) : ClassLoader.getSystemResources(FACTORIES_RESOURCE_LOCATION));
        HashMap<String, List<String>> result = new HashMap<>();
        // 遍历所有的URL
        while (urls.hasMoreElements()) {
            URL url = urls.nextElement();
            // 根据资源文件URL解析properties文件，得到对应的一组@Configuration类
            Properties properties = PropertiesLoaderUtils.loadProperties(new UrlResource(url));
            String factoryClassNames = properties.getProperty(factoryClassName);
            // 组装数据，并返回
            if (factoryClassNames != null && !factoryClassNames.isEmpty()) {
                result.put(url.getFile(), Arrays.asList(StringUtils.commaDelimitedListToStringArray(factoryClassNames)));
            }
        }
        return result;
    }
}
