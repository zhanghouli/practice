package com.zhl.practice;

/**
 * @author Holley
 * @description 请输入一句话进行描述
 * @create 2020-01-07 16:56
 **/
public class StringTest {
        public static void main(String[] args){
//            String str1 = "和谐";
//            String str2 = "社会";
//            String str3 = "和谐社会";
//            String str4;
//            str4 = str1 + str2;
//            System.out.println(str3 == str4);
//            String str5 = (str1 + str2).intern();
//            System.out.println(str3 == str5);
            String code = "bjdl002";
            int index = code.indexOf("bjdl");
            System.out.println(index);
            System.out.println(code.substring(0, index));

            int[] aa = {1,2,3};
            int a = aa[0];
            int b = 20;
            aa[1] = b;
            System.out.println("a = " + a); // 1
            System.out.println("b = " + b); // 20
            System.out.println("aa[0] = " + aa[0]); // 1
            System.out.println("aa[1] = " + aa[1]); // 20
            aa[0] = 10;
            b = 200;
            System.out.println("a = " + a); // 1
            System.out.println("b = " + b); // 200
            System.out.println("aa[0] = " + aa[0]); // 10
            System.out.println("aa[1] = " + aa[1]); // 20
        }
}
