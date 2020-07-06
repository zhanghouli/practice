package com.zhl.practice.task;

import java.util.*;

/**
 * @author Holley
 * @Description 请输入一句话进行描述
 * @create 2018-08-31 10:45
 **/
public class TimerDemo {
        public static void main(String[] args) {
            TimerTask timerTask = new TimerTask() {
                @Override
                public void run() {
                    System.out.println("task  run:"+ new Date());
                }
            };
            Timer timer = new Timer();
            System.out.println(new Date());
            //安排指定的任务在指定的时间开始进行重复的固定延迟执行。这里是每3秒执行一次
            timer.schedule(timerTask,10000,3000);
            TimerTask timerTask2 = new TimerTask() {
                @Override
                public void run() {
                    System.out.println("task  run:"+ new Date());
                }
            };

            Runnable runnable = () -> {System.out.println();};

            List<String> list = new ArrayList();
            list.forEach(con -> System.out.println(con));
        }
}
