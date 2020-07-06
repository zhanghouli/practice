package com.zhl.practice.timer;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimerTask;

/**
 * @author Holley
 * @description 请输入一句话进行描述
 * @create 2020-04-13 11:53
 **/
public class RemindTask extends TimerTask {
    @Override
    public void run() {
        System.out.println(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));
        this.cancel();
    }
}
