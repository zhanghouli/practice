package com.zhl.practice.factory;

import com.zhl.practice.domain.Person;

/**
 * @author Holley
 * @description 请输入一句话进行描述
 * @create 2019-11-26 11:10
 **/
public class PersonFactory extends Factory {
    @Override
    public <T extends Person> T createPerson(Class<T> c) {
        Person p = null;
        try {
            p = (Person) Class.forName(c.getName()).newInstance();
        }catch (Exception e){
            e.printStackTrace();
        }
        return (T)p;
    }

    @Override
    public <T extends Person> T createPerson() {
        Person p = null;
        try {
            p = (Person) Class.forName("").newInstance();
        }catch (Exception e){
            e.printStackTrace();
        }
        return (T)p;
    }


}
