package com.zhl.practice;


import com.zhl.practice.domain.PersonVo;
import org.assertj.core.util.Lists;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.jayway.jsonpath.Filter.filter;

/**
 * @author Holley
 * @description stream
 * @create 2019-12-05 19:44
 **/
public class StreamsTest {

    public static void main(String[] args){
        try {
            /*BufferedReader br = new BufferedReader(new FileReader("C:\\files\\mybatis_debug.log"));

            br.lines().
                    flatMap(line -> {
                        System.out.println("执行前："+line);
                        return Stream.of(line.split(" "));
                    }).forEach(w->{System.out.println(w);});
//            List<String> words = br.lines().
//                    flatMap(line -> {
//                        System.out.println(line);
//                        return Stream.of(line.split(" "));
//                    }).
//                    filter(word -> word.length() > 0).
//                    map(String::toLowerCase).
//                    distinct().
//                    sorted().
//                    collect(Collectors.toList());
            br.close();*/
//            words.forEach(w -> System.out.println(w));
        }catch (Exception e){
            e.printStackTrace();
        }
        List<String> list = Arrays.asList("a","b","c");
//        List<String> listNew = list.stream().map(l -> l = "d").collect(Collectors.toList());
        List<String> listNew = list.stream().peek(l -> {
            if (l.equals("b")){
                l = "d";
            }
        }).collect(Collectors.toList());
        // 基础类型的变量是不会改变的
        listNew.stream().forEach(l -> System.out.println(l));
        // 按年龄进行分组
//        Map<Integer,List<PersonVo>> map = Stream.generate(new PersonSupplier()).limit(100).collect(Collectors.groupingBy(PersonVo::getAge));
//        Iterator it = map.entrySet().iterator();
//        while (it.hasNext()){
//            Map.Entry<Integer,List<PersonVo>> entry = (Map.Entry<Integer,List<PersonVo>>)it.next();
//            System.out.println("age = " + entry.getKey() + ",values = " + entry.getValue());
//        }
        // 按未成年和已成年进行分组
        Map<Boolean,List<PersonVo>> mapT = Stream.generate(new PersonSupplier()).limit(10).collect(Collectors.partitioningBy(aa -> aa.getAge() < 18));
        Iterator it = mapT.entrySet().iterator();
        while (it.hasNext()){
            Map.Entry<Integer,List<PersonVo>> entry = (Map.Entry<Integer,List<PersonVo>>)it.next();
            System.out.println("key = " + entry.getKey() + ",values = " + entry.getValue());
        }

    }

}
