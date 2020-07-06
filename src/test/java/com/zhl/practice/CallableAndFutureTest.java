package com.zhl.practice;

import java.util.concurrent.*;

/**
 * @author Holley
 * @Description 线程池
 * @create 2019-05-27 11:20
 **/
public class CallableAndFutureTest {

    public static void main(String[] args){
        // 创建线程池(单线程)
//        ExecutorService executorService = Executors.newSingleThreadExecutor();
        // 具有固定条数线程的线程池
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        // 可变线程池，当线程数不够时，自动新增线程
//        ExecutorService executorService = Executors.newCachedThreadPool();
        // 无返回值的线程调用
//        executorService.execute(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("线程执行任务代码");
//            }
//        });
        //具有返回值的线程调用
        Future future = executorService.submit(
                new Callable<String>() {
                    @Override
                    public String call() {
                        try {
                            Thread.sleep(5000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        return "测试结果：aaa";
                    }
                }
        );
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                int i = 0;
                while (i < 6){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(System.currentTimeMillis());
                    i++;
                }
            }
        });
        try {
            // 获取线程返回结果会等待该线程执行完毕之后才会返回，此代码中将在5秒后打印出  线程返回值：测试结果：aaa
            System.out.println("线程返回值：" + future.get());
            // 强制在一秒钟后获取返回结果，如果获取不到此时会抛出异常java.util.concurrent.TimeoutException
//            System.out.println("线程返回值：" + future.get(1,TimeUnit.SECONDS));
        } catch (Exception e) {
            e.printStackTrace();
        }

//        completionService用于提交一组任务，其take方法返回已完成的一个Callable任务对应的Futrue对象
        ExecutorService executorService12 = Executors.newSingleThreadExecutor();
//        CompletionService是一个接口，只能通过他的实现类ExecutorCompletionService来创建实例化
        CompletionService<String> completionService = new ExecutorCompletionService(executorService12);
        // 提交十条任务
        for(int i = 1;i<10;i++) {
            // 只能定义成final型变量才能在下面重写的new Callable(){ call(){}}方法中调用
            final int taskId = i;
            completionService.submit(() -> {
                Thread.sleep(1000);
                System.out.println("任务id：" + taskId);
                return "结果"+taskId;
            });
        }
        try {
            for(int i = 1;i<10;i++) {
                // 每次只输出一个任务的返回值（无固定顺序）
                System.out.println(completionService.take().get());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
}
