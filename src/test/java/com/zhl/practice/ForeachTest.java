package com.zhl.practice;

import com.zhl.practice.domain.Person;
import org.assertj.core.util.Lists;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Holley
 * @description 测试foreach遍历时，是否能够改变数据
 * 结论：基本数据类型和字符串类型不能改变，对象的可以改变属性值
 * @create 2020-07-06 10:49
 **/
public class ForeachTest {

    public static void main(String[] args) {
        List<String> stringList = Lists.newArrayList();
//        stringList.add("测试");
//        stringList.add("成功");
        stringList.add(new String("原数据"));
        for(String str:stringList){
            str = "修改数据";
            System.out.println(str);
        }
        for(String str:stringList){
            System.out.println(str);
        }
        List<Person> oldList = new ArrayList<>();
        Person p = new Person("1","1");
        oldList.add(p);
        for(Person person:oldList) {
            System.out.println(person.getName());
            person.setName("测试");
        }
        for(Person person:oldList) {
            System.out.println(person.getName());
        }
        for(Person person:oldList) {
            person = new Person("2","2");
            System.out.println(person.getName());
        }
        for(Person person:oldList) {
            System.out.println(person.getName());
        }
    }
}
