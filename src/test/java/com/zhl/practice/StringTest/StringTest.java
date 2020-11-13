package com.zhl.practice.StringTest;

import org.assertj.core.util.Maps;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Holley
 * @description jdk1.8
 * @create 2020-08-19 15:59
 **/
public class StringTest {

    public static void main(String[] args){
        String s = new String("1");
        s.intern();
        String s2 = "1";
        // false
        System.out.println(s == s2);

        String s3 = new String("1") + new String("1");
        s3.intern();
        String s4 = "11";
        // true
        System.out.println(s3 == s4);

//        Map<Integer,Object> map = new HashMap<>(16);
//        map.put(1,1);
//        map.put(2,1);
//        map.put(3,1);
//        System.out.println(map.size());

        String a = "a";
        String b = "b";
        String c = a + b;
        String d = "ab";
        // false
        System.out.println(c == (a+b));
//        System.out.println(c == "ab");
        // false
        System.out.println(c == d);
        String e = "ac";
        String f = "c";
        String g = a + f;
        // false
        System.out.println(g == e);
    }
}
