package com.zhl.practice.PermissionsTest;

import com.zhl.practice.ProductB;

/**
 * @author Holley
 * @description 请输入一句话进行描述
 * @create 2019-12-20 11:08
 **/
public class Test {

    public static void main(String[] args){
//        ProductA a = new ProductA();
        ProductB a = new ProductB();
        // private 只有本类可以直接获取
//        System.out.println(a.name);
        // default 本类、同包下子类可以直接获取
//        System.out.println(a.number);
        // protected 本类、同包下无关类（在其它类中实例化本类或子类）、子类，可以直接获取
        System.out.println(a.price);
        // public
        System.out.println(a.note);
    }
}
