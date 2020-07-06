package com.zhl.practice.factory;

import com.zhl.practice.domain.Person;

/**
 * @author Holley
 * @description 请输入一句话进行描述
 * @create 2019-11-26 11:08
 **/
public abstract class Factory {

    public abstract <T extends Person> T createPerson(Class<T> c);

    public abstract <T extends Person> T createPerson();

}
