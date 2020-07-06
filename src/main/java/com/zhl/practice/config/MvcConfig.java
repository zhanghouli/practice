package com.zhl.practice.config;

import com.zhl.practice.MyInteceptor.DemoInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 * @author Holley
 * @Description 如果访问的静态文件不是以下路径则会被拦截
 * @create 2018-09-28 11:05
 **/
@Configuration
@EnableWebMvc
public class MvcConfig extends WebMvcConfigurerAdapter {

    /**
      * @Author holley
      * @Description 设置MVC的视图解析
      * @Date 2018/9/28 11:29
      * @Param []
      * @return org.springframework.web.servlet.view.InternalResourceViewResolver
      */
    @Bean
    public InternalResourceViewResolver viewResolver(){
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/classes/views");
        viewResolver.setSuffix(".jsp");
        viewResolver.setViewClass(JstlView.class);
        return viewResolver;
    }

    /**
      * @Author holley
      * @Description 设置静态资源文件的映射
      * @Date 2018/9/28 11:34
      * @Param [registry]
      * @return void
      */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // addResourceHandler 设置对外暴露的访问路径 ，addResourceLocations 设置的是文件放置的目录
        registry.addResourceHandler("/test/**")
                .addResourceLocations("classpath:/tset/");
    }

    /**
      * @Author holley
      * @Description java配置bean
      * @Date 2018/9/28 11:49
      * @Param []
      * @return com.zhl.practice.MyInteceptor.DemoInterceptor
      */
    @Bean
    public DemoInterceptor demoInterceptor(){
        return new DemoInterceptor();
    }

    /**
      * @Author holley
      * @Description 设置拦截器(调用自定义拦截器)
      * @Date 2018/9/28 11:35
      * @Param [registry]
      * @return void
      */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(demoInterceptor());
    }
}
