package com.zhl.practice;

import com.zhl.practice.domain.Person;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author Holley
 * @description 请输入一句话进行描述
 * @create 2019-11-21 15:36
 **/
public class lambdaTest {

    public static void main(String []args){
        String[] data2 = "aa/bb*cc".split("/");

        List<Person> list = new ArrayList<>();
        Person p1 = new Person("1","1");
        Person p2 = new Person("2","2");
        Person p3 = new Person("2","2");
        list.add(p2);
        list.add(p1);
        list.add(p3);
        Map<String,List<Person>> mapVo = new HashMap<>();
        // 相同手机号和姓名的默认为同一个患者
        list.forEach(p -> {
            List<Person> tempList = null;
            if(mapVo.get(p.getName()) != null){
                tempList = mapVo.get(p.getName());
//                tempList = new ArrayList<>();
//                p.setName("3");
            }else{
                tempList = new ArrayList<>();
            }
            tempList.add(p);
            mapVo.put(p.getName(),tempList);
        });
        list.forEach(p -> System.out.println(p));
//        System.out.println(mapVo);


//        List<Person> listNew = list.stream().peek(l -> l.setName("d")).collect(Collectors.toList());
//        List<Person> listNew = list.stream().map(l -> {l.setName("d"); return l;}).collect(Collectors.toList());
        // 排序
        List<Person> listNew = list.stream().sorted((t1,t2)-> t1.getName().compareTo(t2.getName())).collect(Collectors.toList());
        System.out.println(listNew);

        // 生成10个随机数
        Random random = new Random();
        Supplier<Integer> data = random::nextInt;
        Stream.generate(data).limit(10).forEach(System.out::println);
        //Another way
//        IntStream.generate(() -> (int) (System.nanoTime() % 1000)).
//                limit(10).forEach(System.out::println);
//        Long aa = System.nanoTime();
//        System.out.println("aa = "+ aa + ";aa%100="+aa%1000);
//        Stream.iterate(0,n -> n+3).limit(10).forEach(x -> System.out.print(x+" "));

        List<Integer> integers = Arrays.asList(4,5,6,1,2,3,7,8,9,10);
        // 使用断言型接口过滤出偶数列表[4,6,8,8,10]
        List<Integer> evens = integers.stream().filter(i -> i % 2 == 0).collect(Collectors.toList());
        // 排序并且提取出前5个元素 [1,2,3,4,5]
        List<Integer> sortIIntegers = integers.stream().sorted().limit(5).collect(Collectors.toList());
        //
        List<Integer> squareList = integers.stream().map(i -> i*i).collect(Collectors.toList());



    }

}
