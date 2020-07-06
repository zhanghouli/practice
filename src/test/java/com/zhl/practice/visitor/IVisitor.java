package com.zhl.practice.visitor;

/**
 * @author Holley
 * @description 访问者接口
 * @create 2019-12-03 10:14
 **/
public interface IVisitor {

    void visit(CommonEmployee commonEmployee);

    void visit(Manager manager);
}
