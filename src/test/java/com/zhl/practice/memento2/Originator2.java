package com.zhl.practice.memento2;

/**
 * @author Holley
 * @description 发起人角色(阅读权限最小)
 * @create 2019-12-02 9:48
 **/
public class Originator2 {
    private String state;
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }
    // 创建一个备忘录
    public Memento createMemento(){
        return new Memento(this.state);
    }
    // 恢复一个备忘录
    public void restoreMemento(IMemento memento){
        this.state = ((Memento)memento).getState();
    }
    // 内置类
    private class Memento implements IMemento{
        private String state;
        private Memento(String state) {
            this.state = state;
        }
        private String getState() {
            return state;
        }
        private void setState(String state) {
            this.state = state;
        }
    }
}
