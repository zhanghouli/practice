package com.zhl.practice.threadTest;

/**
 * @author Holley
 * @description 出现了线程安全问题
 * @create 2020-07-06 18:17
 **/
public class ThreadTest {

    private static double money = 60.0;

    public Double getMoney(){
        synchronized(this) {
            return this.money;
        }
    }

    public void setMoney(Double balance){
        synchronized(this) {
            this.money = balance;
        }
    }

    public static void main(String[] args){
        ThreadTest threadTest = new ThreadTest();
        Double balance = threadTest.getMoney();
        System.out.println("当前线程："+Thread.currentThread().getName()+";balance:"+balance);
        try {
            Thread.sleep(10);
        }catch (Exception e){
            e.printStackTrace();
        }
        Thread thread2 = new Thread(){
            @Override
            public void run(){
                Double balance = threadTest.getMoney();
                System.out.println("当前线程："+Thread.currentThread().getName()+";balance:"+balance);
                --balance;
                System.out.println("当前线程："+Thread.currentThread().getName()+";balance:"+balance);
                threadTest.setMoney(balance);
            }
        };
        thread2.start();
        try {
            thread2.join();
        }catch (Exception e){
            e.printStackTrace();
        }
        --balance;
        System.out.println("当前线程："+Thread.currentThread().getName()+";balance:"+balance);
        threadTest.setMoney(balance);

        System.out.println(money);
    }
}
