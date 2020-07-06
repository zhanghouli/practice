package com.zhl.practice.MyInteceptor;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Holley
 * @Description 自定义MVC拦截器
 * @create 2018-09-28 11:38
 **/
public class DemoInterceptor extends HandlerInterceptorAdapter{

    /**
      * @Author holley
      * @Description 重写前置拦截
      * @Date 2018/9/28 11:40
      * @Param [request, response, handler]
      * @return boolean
      */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        long startTime = System.currentTimeMillis();
        request.setAttribute("startTime",startTime);
        return true;
    }

    /**
     * @Author holley
     * @Description 重写后置拦截
     * @Date 2018/9/28 11:40
     * @Param [request, response, handler]
     * @return boolean
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        long startTime = (Long)request.getAttribute("startTime");
        request.removeAttribute("startTime");
        long endTime = System.currentTimeMillis();
        System.out.println("本次请求处理时间为："+(endTime - startTime) + "ms");
    }
}
