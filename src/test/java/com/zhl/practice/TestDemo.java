package com.zhl.practice;

import com.zhl.practice.domain.Person;
import com.zhl.practice.domain.S;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Holley
 * @Description 请输入一句话进行描述
 * @create 2018-07-25 16:32
 **/
public class TestDemo {

    public static void main(String[] args){
        List<Cat> list = new ArrayList<>();
        list.add(new Cat("1","1"));
        list.add(new Cat("2","2"));
        list.add(new Cat("3","3"));
        list.add(new Cat("4","4"));
        for(Cat c : list){
            System.out.println(c.getName());
            c.setName("aaa");

        }
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i).getName());
        }
        /* 输出结果如下：
        1
        2
        3
        4
        aaa
        aaa
        aaa
        aaa
         */
        List<String> list2 = new ArrayList<String>();
        list2.add("1");
        list2.add("2");
        list2.add("3");
        list2.add("4");
        for(String c : list2){
            System.out.println(c);
            c = "aaa";
        }
        System.out.println(list2);
        /* 输出结果如下：
        1
        2
        3
        4
        [1, 2, 3, 4]
         */
        List<Person> list3 = new ArrayList<Person>();
        list3.add(new Person("1","1"));
        list3.add(new Person("2","2"));
        list3.add(new Person("3","3"));
        list3.add(new Person("4","4"));
        for(Person c : list3){
            System.out.println(c.getName());
            c.setName("aaa");

        }
        System.out.println(list3.toString());
        /* 输出结果如下：
        1
        2
        3
        4
        [Person{name='aaa', sex='1'}, Person{name='aaa', sex='2'}, Person{name='aaa', sex='3'}, Person{name='aaa', sex='4'}]
         */
        /*List<Integer> list2 = new ArrayList<Integer>();
        list2.add(1);
        list2.add(2);
        list2.add(3);
        list2.add(4);
        for(Integer c : list2){
            System.out.println(c);
            c = 10;

        }
        System.out.println(list2);*/
        /* 输出结果如下：
        1
        2
        3
        4
        [1, 2, 3, 4]
         */

        System.out.println("abcd".substring(0,1)+"-----------");
        S.Core c= new S().new Core();
    }

    static class Cat{
        private String name;

        private String sex;

        public Cat(String name, String sex) {
            this.name = name;
            this.sex = sex;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }
    }
}
