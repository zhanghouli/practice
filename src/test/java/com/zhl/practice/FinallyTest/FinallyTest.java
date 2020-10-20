package com.zhl.practice.FinallyTest;

/**
 * @author Holley
 * @description 请输入一句话进行描述
 * @create 2020-10-19 10:32
 **/
public class FinallyTest {

    public static void main(String[] args) {
        int a=test();
        System.out.println(a);
    }
    public static int test() {
        int count=5;
        try
        {
            //因为finally块中包含了return语句
            //则下面的return语句不会立即返回
//            return count+1;
            throw new RuntimeException("测试异常");
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("捕捉异常");
            count++;
        }
        finally {
            System.out.println("finally块被执行");
            return count+2;
        }
//        return count+2;
    }
}
