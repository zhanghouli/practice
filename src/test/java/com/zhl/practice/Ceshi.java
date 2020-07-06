package com.zhl.practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Holley
 * @Description 请输入一句话进行描述
 * @create 2019-09-25 10:53
 **/
public class Ceshi {

    public static void main(String []args) throws Exception {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int n = Integer.parseInt(br.readLine().trim());
//        System.out.println(n);
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 10; i++) {
            final int index = i;
            singleThreadExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    Thread.currentThread().setName("Thread i = " + index);
                    System.out.println(Thread.currentThread().getName() + " index = " + index);
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        System.out.println("ssss");
                    }
                }
            });
        }
        singleThreadExecutor.shutdown();
        System.out.println("on the main thread...");
    }

}
