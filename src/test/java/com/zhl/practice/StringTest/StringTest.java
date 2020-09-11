package com.zhl.practice.StringTest;

import org.assertj.core.util.Maps;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Holley
 * @description 请输入一句话进行描述
 * @create 2020-08-19 15:59
 **/
public class StringTest {

    public static void main(String[] args){
        String s = new String("1");
        s.intern();
        String s2 = "1";
        System.out.println(s == s2);

        String s3 = new String("1") + new String("1");
        s3.intern();
        String s4 = "11";
        System.out.println(s3 == s4);

        Map<Integer,Object> map = new HashMap<>(16);
        map.put(1,1);
        map.put(2,1);
        map.put(3,1);
        System.out.println(map.size());
    }
}
