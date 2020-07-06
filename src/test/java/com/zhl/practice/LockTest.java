package com.zhl.practice;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Holley
 * @Description 公平锁与非公平锁的演示
 * @create 2019-05-16 10:16
 **/
public class LockTest {

    private static ReenTrantLock2 fairLock = new ReenTrantLock2(true);

    private static ReenTrantLock2 nonfairLock = new ReenTrantLock2(false);

    @Test
    public void fair(){
        testLock(fairLock);
    }

    @Test
    public void unfair(){
        testLock(nonfairLock);
    }

    private void testLock(ReenTrantLock2 lock){
        for(int i = 0; i<5;i++){
            Job job = new Job(lock);
            job.start();
        }
    }

    private static class Job extends Thread{

        private ReenTrantLock2 lock;

        public Job(ReenTrantLock2 lock){
            this.lock = lock;
        }

        @Override
        public void run() {
            lock.lock();
            System.out.println("当前线程：" + this.getName() + "等待线程：" + lock.getQueuedThreads().toString());
            lock.unlock();
            lock.lock();
            System.out.println("当前线程：" + this.getName() + "等待线程：" + lock.getQueuedThreads().toString());
            lock.unlock();
        }
    }
    private static class ReenTrantLock2 extends ReentrantLock{
        public ReenTrantLock2(Boolean flag){
            super(flag);
        }

        public Collection<Thread> getQueuedThreads(){
//            System.out.println(super.getQueuedThreads());
            List<Thread> list = new ArrayList<>(super.getQueuedThreads());
            return list;
        }
    }

}
