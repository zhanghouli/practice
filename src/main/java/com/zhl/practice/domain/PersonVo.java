package com.zhl.practice.domain;


public class PersonVo {

    public PersonVo(String name, String sex) {
        this.name = name;
        this.sex = sex;
    }

    public PersonVo(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
    public String name;

    public String sex;

    private Integer age;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
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

    @Override
    public String toString() {
        return "PersonVo{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                '}';
    }
}
