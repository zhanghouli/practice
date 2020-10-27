package com.zhl.practice.sorttest;

/**
 * @author Holley
 * @description 请输入一句话进行描述
 * @create 2020-10-27 18:40
 **/
public class DataWrap implements Comparable<DataWrap> {
    int data;
    String flag;
    public DataWrap(int data, String flag)
    {
        this.data=data;
        this.flag=flag;
    }
    public String toString()
    {
        return data+flag;
    }
    //根据data实例变量来决定两个DataWrap的大小
    public int compareTo(DataWrap dw)
    {
        return this.data > dw.data ?1 :(this.data == dw.data ? 0 :-1);
    }
}
