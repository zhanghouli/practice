package com.zhl.practice.task;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author Holley
 * @Description 请输入一句话进行描述
 * @create 2018-08-31 10:58
 **/
public class ScheduleExecutorService {
    public static void main(String[] args) {
        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
        // java8的Lambda表达式 参数：1、任务体(句柄必须是接口 ) 2、首次执行的延时时间
        //      3、任务执行间隔 4、间隔时间单位
        service.scheduleAtFixedRate(() -> System.out.println("task ScheduledExecutorService " + new Date()), 0, 3, TimeUnit.SECONDS);
    }
}
