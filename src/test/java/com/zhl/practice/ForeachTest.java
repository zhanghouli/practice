package com.zhl.practice;

import com.zhl.practice.domain.Person;
import org.assertj.core.util.Lists;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Holley
 * @description 请输入一句话进行描述
 * @create 2020-07-06 10:49
 **/
public class ForeachTest {

    public static void main(String[] args) {
        List<String> stringList = Lists.newArrayList();
        stringList.add("测试");
        stringList.add("成功");
        for(String str:stringList){
            str = "修改数据";
            System.out.println(str);
        }
        for(String str:stringList){
            System.out.println(str);
        }
        List<Person> oldList = new ArrayList<>();
        Person p = new Person("1","1");
        Person p2 = new Person("2","2");
        oldList.add(p);
        oldList.add(p2);
        for(Person person:oldList) {
            System.out.println(person.getName());
            person.setName("测试");
        }
        for(Person person:oldList) {
            System.out.println(person.getName());
        }
    }
}
