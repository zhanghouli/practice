package com.zhl.practice;

import sun.security.krb5.SCDynamicStoreConfig;

import java.util.Arrays;
import java.util.Scanner;
public class ScannerTest {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
//        int number;
//        System.out.println("请输入有多少堆苹果：");
//        do {
//            number = sc.nextInt();
//        }while(1>number || number>100000);
//
//        int[] aa = new int[number];
//        int bb;
//        System.out.println("请输入每堆苹果的个数：");
//        for(int i = 0;i<number;i++){
//            do {
//                bb = sc.nextInt();
//            }while(1>bb || bb>1000);
//            if(i>0){
//                aa[i] = bb + aa[i-1];
//            }else{
//                aa[i] = bb;
//            }
//        }
//        System.out.println("请输入多少次询问m：");
//        int m;do {
//            m = sc.nextInt();
//        }while(1>m || m>100000);
//        int[] q = new int[m];
//        System.out.println("请输入想查询的苹果数：");
//        for(int i = 0;i<m;i++){
//            q[i] = sc.nextInt();
//        }
//        for(int i = 0;i<m;i++){
//            for(int x = 1;x<number;x++) {
//                if(x == 1 && q[i]<=aa[x-1]){
//                    System.out.println("第"+(i+1)+"个查询是在第"+x+"堆");
//                }if(q[i] < aa[x] && q[i]>aa[x-1]){
//                    System.out.println("第"+(i+1)+"个查询是在第"+(x+1)+"堆");
//                }
//            }
//        }


//        Scanner sc=new Scanner(System.in);
        /*String s1,s2,s3;
        System.out.print("请输入第一个字符串：");
        s1=sc.next();
        System.out.print("请输入第二个字符串：");
        s2=sc.nextLine();
        System.out.print("请输入第三个字符串：");
        s3=sc.next();
        System.out.println("输入的字符串是："+s1+" a "+s2 + " b " +s3);*/
// 一个while就是一个测试用例
        while(sc.hasNext()){
            int n = sc.nextInt(); // 该测试用例后续接收的参数个数
            long[] array = new long[n];
            String[] arrayStr = new String[n];
            for(int i=0; i<n; i++){
                arrayStr[i] = sc.next();
            }
            for(int i=0; i<n; i++){
                array[i] = sc.nextLong();// 取下一个元素转换成long类型
            }

            System.out.println(Arrays.toString(array)+" "+ Arrays.toString(arrayStr));
        }
    }
}
