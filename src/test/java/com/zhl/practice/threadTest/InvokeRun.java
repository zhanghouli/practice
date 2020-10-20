package com.zhl.practice.threadTest;

/**
 * @author Holley
 * @description 请输入一句话进行描述
 * @create 2020-09-28 10:27
 **/
public class InvokeRun extends Thread{

    private int i;

    public void run(){
        for(;i<100;i++) {
            // 当前对象名
            System.out.println(this.getName() + "aaaa");
            // 当前线程名
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }

    public static void main(String[] args) {
        for (int i=0;i<100;i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
            if (i == 20) {
                new InvokeRun().run();
                new InvokeRun().run();
            }
        }
    }
}
