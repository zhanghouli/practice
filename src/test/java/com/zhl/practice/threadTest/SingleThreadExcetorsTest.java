package com.zhl.practice.threadTest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Holley
 * @description 请输入一句话进行描述
 * @create 2020-10-20 11:07
 **/
public class SingleThreadExcetorsTest {

    public static void main(String[] args) {
        /**
         * 单线程化的线程池
         */
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
        //shutdown 线程池状态会变为SHUTDOWN状态，此时线程池不会立即退出，直到添加到线程池中的任务都已经处理完成才会退出。
        // 而且不能再往线程池中添加新任务，否则会抛出RejectedExecutionException异常
//        singleThreadExecutor.shutdown();
        // shutdownNow会立刻变为STOP状态，并终止所有正在执行的线程（包括正在等待的线程任务）
        singleThreadExecutor.shutdownNow();
        System.out.println("on the main thread...");

    }

}
