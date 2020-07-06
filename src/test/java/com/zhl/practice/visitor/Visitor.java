package com.zhl.practice.visitor;

/**
 * @author Holley
 * @description 请输入一句话进行描述
 * @create 2019-12-03 10:20
 **/
public class Visitor implements IVisitor{
    @Override
    public void visit(CommonEmployee commonEmployee) {
        getCommonEmployeeInfo(commonEmployee);
    }

    @Override
    public void visit(Manager manager) {
        getManagerInfo(manager);
    }

    private String getBaseInfo(Employee employee){
        StringBuffer sb = new StringBuffer();
        sb.append("姓名:").append(employee.getName()).append(",性别:").append((employee.getSex() == Employee.MALE ? "男":"女"))
                .append(",薪水:").append(employee.getSalary());
        return sb.toString();
    }

    private String getCommonEmployeeInfo(CommonEmployee commonEmployee){
        return getBaseInfo(commonEmployee) + ",工作：" + commonEmployee.getJob();
    }

    private String getManagerInfo(Manager manager){
        return getBaseInfo(manager)+",业绩："+manager.getPerformance();
    }
}
