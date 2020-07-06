package com.zhl.practice.timer;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;

/**
 * @author Holley
 * @description 请输入一句话进行描述
 * @create 2020-04-13 11:46
 **/
public class TimerTest {

    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        /**
            * 指定触发的时间
         */
         calendar.set(Calendar.DAY_OF_MONTH,13);//设置日期为13号
         calendar.set(Calendar.MONTH, 3);//设置日期为4月份(月份是从0开始计算)
         calendar.set(Calendar.HOUR_OF_DAY, 13); //设置15点的时候触发
         calendar.set(Calendar.MINUTE, 31); //设置56分钟的时候触发
         calendar.set(Calendar.SECOND, 1); //设置第一秒的时候触发
         Date time = calendar.getTime();
         Timer timer = new Timer();
         timer.schedule(new RemindTask(), time);
    }
}
