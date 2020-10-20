package com.zhl.practice;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Holley
 * @description 请输入一句话进行描述
 * @create 2020-09-16 13:26
 **/
public class LongAndIntTest {

    public static void main(String[] args) {
        List<Long> list = new ArrayList<>();
        list.add(1L);
        int value = 1;
        // false
        System.out.println(list.contains(value));

    }
}
