package com.zhl.practice.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.boot.env.YamlPropertySourceLoader;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Properties;

/**
 * @author Holley
 * @description 请输入一句话进行描述
 * @create 2020-03-19 19:05
 **/
@Component
public class PropertiesUtil {

    public static String active;

    /**
     * 当配置文件为properties类型时，此代码块可以加载配置文件
     * @return
     */
    static {
        try {
//            ClassPathResource resource = new ClassPathResource("application.properties");
//            Properties properties = PropertiesLoaderUtils.loadProperties(resource);
//            active = properties.getProperty("spring.profiles.active", "prod");
            YamlPropertiesFactoryBean yaml = new YamlPropertiesFactoryBean();
            yaml.setResources(new ClassPathResource("myApplication.yml"));
            Properties properties = yaml.getObject();
//            PropertySourcesPlaceholderConfigurer configurer = new PropertySourcesPlaceholderConfigurer();
//            configurer.setProperties(yaml.getObject());
            active = properties.getProperty("spring.profiles.active");
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getUriForOrderExport(){
        if(active.equals("dev")) {
            return active;
        }else{
            return "prod";
        }
    }

    @Value("${server.port}")
    private String active2;

    public String getActive2() {
        System.out.println(active2);
        return active2;
    }

    public void setActive2(String active2) {
        this.active2 = active2;
    }
}
