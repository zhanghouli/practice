package com.zhl.practice;

import com.zhl.practice.domain.Person;
import com.zhl.practice.domain.Son;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Holley
 * @Description 请输入一句话进行描述
 * @create 2018-09-20 15:12
 **/
public class TT {

    public  static void main(String a[]){
        Son s = new Son();
        Field[] f=  s.getClass().getDeclaredFields();
        for (Field ff : f){
            System.out.println(ff.getName());
            if("a".equals(ff.getName())){
                System.out.println(ff.getType());
//                System.out.println(ff.getType().getName());
            }
        }
        StringBuffer sb = new StringBuffer();
        sb.append("aaaa");
        int i = 1;
        bb(sb,i);
        System.out.println(i);
        System.out.println(sb.toString());

        List<Person> oldList = new ArrayList<>();
        Person p = new Person("1","1");
        Person p2 = new Person("2","2");
        oldList.add(p);
        oldList.add(p2);
        List<Person> newList = new ArrayList<>();
//        newList.add(oldList.get(0));
//        newList.get(0).setName("3");
        Person p3 = oldList.get(0);
        p3.setName("4");
        System.out.println(oldList.get(0).getName());
    }
    public  static void bb(StringBuffer sb,int i){
        i = 10;
        sb.append("bbbb");
    }

}
