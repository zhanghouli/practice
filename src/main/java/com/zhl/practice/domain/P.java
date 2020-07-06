package com.zhl.practice.domain;


public class P {

    private Core c;

    protected class Core{
        public Core(){
            System.out.println("Fruit.Core()");
        }
    }

    protected P() {
        System.out.println("New Fruit()");
        c = new Core();
    }



}
