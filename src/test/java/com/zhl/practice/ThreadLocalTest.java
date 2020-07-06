package com.zhl.practice;

/**
 * @author Holley
 * @Description 请输入一句话进行描述
 * @create 2019-05-24 10:35
 **/
public class ThreadLocalTest {

    public static void main (String args[]){

        Thread t1 = new Thread(){
            @Override
            public void run() {
                MyThreadLocal.getInstance().setName("zhl");
                MyThreadLocal.getInstance().setAge(2);
                MyThreadLocal.getInstance().getMap().put("ceshi","haha");
                System.out.println(Thread.currentThread().getName() + ":zhl");
                new A().getThreadLocalDate();
            }
        };
        t1.start();
        Thread t2 = new Thread(){
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                }catch (Exception e){
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName());
                new A().getThreadLocalDate();
            }
        };

        t2.start();
    }

    static class A{
        public void getThreadLocalDate(){
            MyThreadLocal myThreadLocal = MyThreadLocal.getInstance();
            myThreadLocal.getMap().put("A","heihei");
            System.out.println(Thread.currentThread().getName() + myThreadLocal.getName());
            System.out.println(Thread.currentThread().getName() + myThreadLocal.getMap().keySet().toString());
        }
    }
}
