package com.zhl.practice.controller;

import com.zhl.practice.util.PropertiesUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Holley
 * @Description 请输入一句话进行描述
 * @create 2018-09-28 10:09
 **/
@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private PropertiesUtil propertiesUtil;
    /**
     * 可以加载
     */
    @Value("${server.port}")
    private String port;
    /**
      * @Author holley
      * @Description 映射不同路径到相同方法，produces用来设置当回内容的类型
      * @Date 2019/5/27 11:17
      * @Param [request]
      * @return java.lang.String
      */
    @RequestMapping(value = {"/name1","/name2"},produces = {"application/json;charset=UTF-8"})
    public String test(HttpServletRequest request){

        return "url:" + request.getRequestURL().toString();
    }

    /**
     * @author holley
     * @description 测试加载配置文件内容
     */
    @GetMapping("/active")
    public String exporteByTaskIdNew() {
        /**
         * 在类中直接使用Properties.load读取配置文件的参数
         */
        return PropertiesUtil.getUriForOrderExport();
        /**
         * 创建实例来调用时，无法加载配置文件
         */
//        return new PropertiesUtil().getActive2();
        /**
         * 注入propertiesUtil的bean时可以加载
         */
//        return propertiesUtil.getActive2();
//        return port;
    }
}
