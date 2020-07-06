package com.zhl.practice.visitor;

/**
 * @author Holley
 * @description 请输入一句话进行描述
 * @create 2019-12-03 10:16
 **/
public class Manager extends Employee{

    private String performance;

    public String getPerformance() {
        return performance;
    }

    public void setPerformance(String performance) {
        this.performance = performance;
    }

    @Override
    public void accept(IVisitor visitor) {
        visitor.visit(this);
    }
}
