package com.zhl.practice.practice;


import com.zhl.practice.domain.S;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Holley
 * @description 请输入一句话进行描述
 * @create 2020-09-01 10:36
 **/
public class IteratorTest {


    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("a");list.add("b");list.add("c");
        List<String> deleteList = new ArrayList<>();
        for (String value:list) {
            if ("a".equals(value)) {
                deleteList.add(value);
            }
        }
        if (deleteList.size() > 0) {
            list.removeAll(deleteList);
            deleteList = null;
        }
        for (String value:list) {
            System.out.println(value);
        }
//        for (int i = 0;i<list.size();i++) {
//            String first = list.get(i);
//            System.out.println(first);
//            if ("a".equals(first)) {
//                list.remove(first);
//            }
//        }
//        for (Iterator<String> it = list.iterator();it.hasNext();){
//            String first = it.next();
//            if ("a".equals(first)) {
//                // 抛出ConcurrentModificationException异常
//                list.remove(first);
//            }
//            System.out.println(first);
//        }



    }

}