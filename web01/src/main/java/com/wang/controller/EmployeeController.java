package com.wang.controller;

import com.wang.dao.DepartmentDao;
import com.wang.dao.EmployeeDao;
import com.wang.pojo.Department;
import com.wang.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller
public class EmployeeController {
    @Autowired
    private DepartmentDao departmentDao;
    @Autowired
    private EmployeeDao employeeDao;
    @RequestMapping("admin/employee/getAll")
    public String getAll(Model model){
        Collection<Employee> employees = employeeDao.getEmployees();
        System.out.println(employees.size());
        model.addAttribute("list",employees);
        return "list";
    }

    @GetMapping("admin/employee/emp")
    public String toAddPage(Model model){
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("departments",departments);
        return "add";
    }

    @PostMapping("admin/employee/emp")
    public String addEmployee(Model model,Employee employee){
        System.out.println(employee);
        employeeDao.save(employee);
        return "redirect:/admin/employee/getAll";
    }

    @GetMapping("admin/employee/emp/{id}")
    public String toUpdatePage(Model model,@PathVariable("id") int id){
        Employee employee = employeeDao.getEmployeeById(id);
        System.out.println(employee);
        model.addAttribute("employee",employee);
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("departments",departments);
        return "update";
    }

    @PostMapping("admin/employee/emp/{id}")
    public String updateEmployee(Employee employee,@PathVariable("id") int id){
        employeeDao.save(employee);
        return "redirect:/admin/employee/getAll";
    }

    @GetMapping ("admin/employee/emp/del/{id}")
    public String deleteEmployee(@PathVariable("id") int id){
        employeeDao.delete(id);
        return "redirect:/admin/employee/getAll";
    }

}
