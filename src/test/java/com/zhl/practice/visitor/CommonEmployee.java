package com.zhl.practice.visitor;

/**
 * @author Holley
 * @description 普通员工
 * @create 2019-12-03 10:13
 **/
public class CommonEmployee extends Employee{

    private String job;

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    @Override
    public void accept(IVisitor visitor) {
        visitor.visit(this);
    }
}
