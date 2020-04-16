package com.wang.dao;

import com.wang.pojo.Department;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class DepartmentDao {
    //模拟数据库中的数据
    private static Map<Integer, Department> map = null;
    static {
        map = new HashMap<Integer, Department>();
        map.put(101,new Department(101,"教学部"));
        map.put(102,new Department(102,"市场部"));
        map.put(103,new Department(103,"销售部"));
        map.put(104,new Department(104,"人事部"));
        map.put(105,new Department(105,"技术部"));
        map.put(106,new Department(106,"运营部"));
        map.put(107,new Department(107,"政管部"));
    }

    //获取全部部门
    public Collection<Department> getDepartments(){
        return map.values();
    }
    //根据id获取
    public Department getDepartmentById(int id){
        return map.get(id);
    }
}
