package com.zhl.practice.memento;

/**
 * @author Holley
 * @description 场景类
 * @create 2019-12-02 12:27
 **/
public class Client {
    public static void main(String[] args){
        Originator originator = new Originator();
        originator.setState1("1");
        originator.setState2("2");
        originator.setState3("3");
        System.out.println("修改之前："+originator.toString());
        // 创建一个备忘录
        Caretaker caretaker = new Caretaker(originator.createMemento());
        // 修改数据
        originator.setState1("4");
        originator.setState2("5");
        originator.setState3("6");
        System.out.println("修改之后："+originator.toString());
        // 恢复数据
        originator.restoreMemento(caretaker.getMemento());
        System.out.println("恢复之后："+originator.toString());
    }
}
