package com.wang.dao;

import com.wang.pojo.Department;
import com.wang.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Repository
public class EmployeeDao {
    //模拟数据库中的数据
    private static Map<Integer, Employee> map = null;
    //自增主键
    private static int initId = 1000;
    @Autowired
    private DepartmentDao departmentDao;

    static {
        map = new HashMap<>();
        map.put(1001,new Employee(1001,"AA","AA00AA742@qq.com",0,new Department(101,"教学部"),new Date()));
        map.put(1002,new Employee(1002,"BB","BB00BB742@qq.com",1,new Department(102,"市场部"),new Date()));
        map.put(1003,new Employee(1003,"CC","CC00CC742@qq.com",0,new Department(103,"销售部"),new Date()));
        map.put(1004,new Employee(1004,"DD","DD00DD742@qq.com",1,new Department(104,"人事部"),new Date()));
        map.put(1005,new Employee(1005,"EE","EE00EE742@qq.com",0,new Department(105,"技术部"),new Date()));
        map.put(1006,new Employee(1006,"FF","FF00FF742@qq.com",1,new Department(106,"运营部"),new Date()));
        map.put(1007,new Employee(1007,"GG","GG00GG742@qq.com",0,new Department(107,"政管部"),new Date()));
        initId = 1008;
    }

    //+
    public void save(Employee employee){
        if ((Object)employee.getId() == null || employee.getId() == 0){
            employee.setId(initId++);
        }else {
            this.delete(employee.getId());
        }
        employee.setDepartment(departmentDao.getDepartmentById(employee.getDepartment().getId()));
        map.put(employee.getId(),employee);
    }

    //获取全部员工
    public Collection<Employee> getEmployees(){
        return map.values();
    }

    //根据id获取
    public Employee getEmployeeById(int id){
        return map.get(id);
    }

    //根据id删除
    public Employee delete(int id){
        return map.remove(id);
    }
}
