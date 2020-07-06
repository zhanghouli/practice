package com.zhl.practice.visitor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Holley
 * @description 场景类
 * @create 2019-12-03 10:30
 **/
public class Client {

    private static List<Employee> dataList = new ArrayList<>();

    static {
        for(int i = 0;i < 10;i++){
            if(i%2 == 0) {
                CommonEmployee employee = new CommonEmployee();
                employee.setJob("测试员"+i);

                dataList.add(employee);
            }
        }
    }
}
