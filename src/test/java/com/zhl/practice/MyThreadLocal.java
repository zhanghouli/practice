package com.zhl.practice;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Holley
 * @Description 单例模式
 * @create 2019-05-24 10:46
 **/
public class MyThreadLocal {

        private MyThreadLocal(){}

        private static ThreadLocal<MyThreadLocal> threadLocal = new ThreadLocal<>();

        private static MyThreadLocal instance;
        // 如果不加锁会出现数据错乱的现象
        public static synchronized MyThreadLocal getInstance(){
            instance = threadLocal.get();
            if(instance == null){
                instance = new MyThreadLocal();
                threadLocal.set(instance);
            }
            return instance;
        }

        // 不管是引用类型变量还是基本类型变量，在多线程中，只要不是静态修饰符修饰的变量，每个线程的变量值都是独自拥有的（加锁正确流程下）
        private Map<String,Object> map = new HashMap<>();

        private String name = "holley";

        private int age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

    public Map<String, Object> getMap() {
        return map;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }
}
