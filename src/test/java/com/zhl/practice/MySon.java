package com.zhl.practice;

/**
 * @author Holley
 * @Description 请输入一句话进行描述
 * @create 2019-06-15 16:50
 **/
public class MySon {

    private Integer mySonId;

    private String name;

    private String sex;

    public MySon(Integer mySonId,String name, String sex) {
        super();
        this.mySonId = mySonId;
        this.name = name;
        this.sex = sex;
    }
    public MySon(){}


    public Integer getMySonId() {
        return mySonId;
    }

    public void setMySonId(Integer mySonId) {
        this.mySonId = mySonId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
