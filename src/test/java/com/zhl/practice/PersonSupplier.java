package com.zhl.practice;

import com.zhl.practice.domain.PersonVo;

import java.util.Random;
import java.util.function.Supplier;

/**
 * @author Holley
 * @description 请输入一句话进行描述
 * @create 2019-12-10 14:10
 **/
public class PersonSupplier implements Supplier<PersonVo> {
    private int index = 1;
    private Random random = new Random();
    @Override
    public PersonVo get() {
        return new PersonVo("peson"+(index++),random.nextInt(60));
    }
}
