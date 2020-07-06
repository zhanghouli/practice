package com.zhl.practice.memento;

import java.util.HashMap;

/**
 * @author Holley
 * @description 备忘录类
 * @create 2019-12-02 9:45
 **/
public class Memento {

    private HashMap<String,Object> map;

    public Memento(HashMap<String,Object> paramsMap){
        this.map = paramsMap;
    }

    public HashMap<String, Object> getMap() {
        return map;
    }

    public void setMap(HashMap<String, Object> map) {
        this.map = map;
    }
}
