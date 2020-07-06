package com.zhl.practice;

import java.util.Random;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author Holley
 * @Description 读写锁（可重入锁Lock,一个读锁可以有多个线程同时获取，同一写锁同一时间只能有一个线程获取，写锁可以降级为读锁（在释放该写锁之前获取读锁，然后释放写锁，称为锁降级））
 * @create 2019-05-27 14:54
 **/
public class ReadAndWriteLock {

    // 共享变量
    private Object data = null;

    private ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
    // 读取共享变量内容(加上锁之后在一个线程读取数据完成之前不管中间停顿多久其他读取线程都可以插入进来)
    public void getValue(){
        reentrantReadWriteLock.readLock().lock();
        System.out.println(Thread.currentThread().getName() + ":准备读取数据");
        try {
            Thread.sleep(new Random().nextInt(100)*10);
            System.out.println(Thread.currentThread().getName() + ":读取数据" + data);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            reentrantReadWriteLock.readLock().unlock();
        }
    }

    // 修改共享变量内容(加上锁之后在一个线程写入数据完成之前不管中间停顿多久都没有其他线程会插入进来)
    public void put(Object value){
        reentrantReadWriteLock.writeLock().lock();
        System.out.println(Thread.currentThread().getName() + ":准备修改数据");
        try {
            Thread.sleep(new Random().nextInt(1000)*10);
            data = value;
            System.out.println(Thread.currentThread().getName() + ":修改数据为：" + data);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            reentrantReadWriteLock.writeLock().unlock();
        }
    }

    public static void main(String[] args){
        final ReadAndWriteLock rwl = new ReadAndWriteLock();
        // 创建多个线程读取数据
        for(int i = 0;i < 5;i++){
            new Thread(() -> {
                while(true){
                    rwl.getValue();
                }
            }).start();
        }
        // 创建多个线程修改数据
        for(int i = 0;i < 5;i++){
            new Thread(() -> {
//                while(true){
                    rwl.put(new Random().nextInt(100));
//                }
            }).start();
        }
    }
}
