package com.zhl.practice;


import com.zhl.practice.domain.Person;
import com.zhl.practice.domain.PersonVo;
import org.apache.poi.ss.formula.functions.T;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author Holley
 * @Description 请输入一句话进行描述
 * @create 2019-06-15 16:18
 **/
public class ReflectTest {

    public static void main(String[] args) {
//        MySon my = new MySon(1,"zhl",null);
//        String sql = new ReflectTest().updateSomeField(my);
//        System.out.println(sql);

        List<PersonVo> list = new ArrayList<>();
        PersonVo p1 = new PersonVo("HH","1");
        PersonVo p2 = new PersonVo("BB","2");
        list.add(p1);list.add(p2);
        List<Person> list2 = reflectProduct(Person.class,list);
        list2.forEach(l->System.out.println(l.getName()));
    }

    public static <T> List<T> reflectProduct(Class<T> t,List<?> dataList){
        final List<T> list = new ArrayList<>();
        dataList.forEach(d->{
            list.add(reflectOne(t,d));
        });
        return list;
    }

    public static <T> T reflectOne(Class<T> t,Object data){
        final Field[] fields = data.getClass().getDeclaredFields();
        final List<T> list = new ArrayList<>();
        try {
            T p = t.newInstance();
            Stream.of(fields).forEach(field ->{
                try {
                    Object o = field.get(data);
                    Field f = t.getField(field.getName());
                    f.set(p,o);
                }catch (IllegalAccessException e){
                    e.printStackTrace();
                }catch (NoSuchFieldException e){
                    e.printStackTrace();
                }
            });
            return p;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public String updateSomeField(Object t){
        StringBuffer sb = new StringBuffer();
        Class t_class = t.getClass();
        String className = t_class.getSimpleName();
        System.out.println(className);
        sb.append("update ").append(getField(className)).append(" set modified = now()");
        String IdName = className.substring(0,1).toLowerCase() + className.substring(1) + "Id";
        Object IdValue = null;
        String methodName = null;
        String fieldName = null;
        StringBuffer fieldNameTemp = null;
        Method m = null;
        Field[] fields = t_class.getDeclaredFields();
        Object value = null;
        for(Field f:fields){
            fieldName = f.getName();
            System.out.println(fieldName);
            try {
                methodName = "get" + fieldName.substring(0,1).toUpperCase() + fieldName.substring(1);
                m = t_class.getMethod(methodName);
                value = m.invoke(t);
            }catch (Exception e){
                e.printStackTrace();
            }
            if(!fieldName.equals(IdName) && !fieldName.equals("Id")) {
                if(value != null && value != "") {
                    fieldNameTemp = new StringBuffer();
                    fieldNameTemp.append(getField(fieldName));
                    sb.append(", ").append(fieldNameTemp.toString()).append(" = #{").append(fieldName).append("}");
                }
            }else{
                IdValue = value;
            }
        }
        sb.append(" where ").append(getField(IdName)).append(" = ").append(IdValue);
        return sb.toString();
    }

    private static String getField(String fieldName){
        StringBuffer name = new StringBuffer();
        for (int i = 0; i < fieldName.length(); i++) {
            char temp = fieldName.charAt(i);
            if(i == 0 && (temp >= 65 && temp <= 90)){
                name.append((char)(temp + 32));
            }else {
                if (temp >= 65 && temp <= 90) {
                    name.append("_");
                    name.append((char) (temp + 32));
                } else {
                    name.append(temp);
                }
            }
        }
        return name.toString();
    }

}
