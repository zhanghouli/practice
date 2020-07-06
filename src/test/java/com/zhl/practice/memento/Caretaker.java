package com.zhl.practice.memento;

import java.util.Map;

/**
 * @author Holley
 * @description 备忘录管理类（实现解耦）
 * @create 2019-12-02 12:26
 **/
public class Caretaker {
    public Caretaker(Map<String,Memento> map){
        this.mementoMap = map;
    }
    private Map<String,Memento> mementoMap;
    public Map<String, Memento> getMementoMap() {
        return mementoMap;
    }
    public void setMementoMap(Map<String, Memento> mementoMap) {
        this.mementoMap = mementoMap;
    }

    public Caretaker(Memento memento){
        this.memento = memento;
    }

    private Memento memento;

    public Memento getMemento() {
        return memento;
    }

    public void setMemento(Memento memento) {
        this.memento = memento;
    }
}
