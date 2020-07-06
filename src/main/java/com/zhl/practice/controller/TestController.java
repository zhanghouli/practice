package com.zhl.practice.controller;

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

}
