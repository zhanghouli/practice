package com.zhl.practice.threadTest;

import java.util.Set;

/**
 * @author Holley
 * @description 请输入一句话进行描述
 * @create 2020-09-27 15:05
 **/
public class ThreadCountTest {

    public static void main(String[] args){
        System.out.println("hello world!");
        ThreadGroup threadGroup = Thread.currentThread().getThreadGroup();
        ThreadGroup topGroup = threadGroup;
        while (threadGroup != null) {
            topGroup = threadGroup;
            threadGroup = threadGroup.getParent();
        }
        int size = topGroup.activeCount();
        Thread[] threads = new Thread[size];
        topGroup.enumerate(threads);
        for (Thread t:threads) {
            System.out.println("线程name:" + t.getName());
        }

//        System.out.println("-----------------第二种方法-------------");
//        int activeCount = Thread.activeCount();
//        System.out.println("活跃的线程数：" + activeCount);
//        Set<Thread> threadSet = Thread.getAllStackTraces().keySet();
//        for (Thread t:threadSet) {
//            System.out.println("线程name:" + t.getName());
//        }
    }
}
