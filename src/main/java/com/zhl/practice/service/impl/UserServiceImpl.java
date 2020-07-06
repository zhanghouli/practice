package com.zhl.practice.service.impl;

import com.zhl.practice.domain.Person;
import com.zhl.practice.domain.Son;
import com.zhl.practice.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service(value = "userService")
public class UserServiceImpl implements UserService{
    @Override
    public Map<String, Object> getUserByid() {
        Person p = new Person();
        System.out.print(p.name);
        Son s = new Son();
        System.out.print(s.name);



        return null;
    }
}
