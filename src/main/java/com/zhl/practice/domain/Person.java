package com.zhl.practice.domain;


public class Person {

    public static int age = 20;

    public String name = "zhl";

    private int leila;

    public String sex;

    public String text;

    public void eat(){
        System.out.print(age);
    }

    public void drink(){
        System.out.println(text);
    }

    public Person() {
        this.drink();
    }

    public Person(String name, String sex) {
        this.name = name;
        this.sex = sex;
    }

    public static int getAge() {
        return age;
    }

    public static void setAge(int age) {
        Person.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", leila=" + leila +
                ", sex='" + sex + '\'' +
                '}';
    }
}
