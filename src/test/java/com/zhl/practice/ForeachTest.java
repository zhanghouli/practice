package com.zhl.practice;

import org.assertj.core.util.Lists;

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
    }
}
