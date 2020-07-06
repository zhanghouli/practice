package com.zhl.practice.memento;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.stream.Stream;

/**
 * @author Holley
 * @description 请输入一句话进行描述
 * @create 2019-12-02 9:52
 **/
public class BeanUtils {

    // 把bean的所有属性及数值放入到HashMap中
    public static HashMap<String,Object> backupProp(Object bean){
        HashMap<String,Object> map = new HashMap<>();
        // 获取bean的描述
        try {
            BeanInfo beanInfo = Introspector.getBeanInfo(bean.getClass());
            // 获取属性描述
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            // 遍历所有属性
            Stream.of(propertyDescriptors).forEach(prop -> {
                // 属性名称
                String name = prop.getName();
                // 读取属性的方法
                Method method = prop.getReadMethod();
                // 读取属性的值
                try {
                    Object value = method.invoke(bean,new Object[]{});
                    if(!name.equalsIgnoreCase("class")){
                        map.put(name,value);
                    }
                }catch (IllegalAccessException e){
                    e.printStackTrace();
                }catch (InvocationTargetException e){
                    e.printStackTrace();
                }
            });
        } catch (IntrospectionException e) {
            e.printStackTrace();
        }
        return map;
    }
    // 恢复数据
    public static void restoreProp(Object bean,HashMap<String,Object> map){
        try {
//            bean.getClass().getDeclaredFields()
            BeanInfo beanInfo = Introspector.getBeanInfo(bean.getClass());
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            String name = null;
            Method method = null;
            Object value = null;
            for(PropertyDescriptor prop:propertyDescriptors) {
                name = prop.getName();
                if (map.get(name) != null) {
                    value = map.get(name);
                    method = prop.getWriteMethod();
                    method.invoke(bean, new Object[]{value});
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
