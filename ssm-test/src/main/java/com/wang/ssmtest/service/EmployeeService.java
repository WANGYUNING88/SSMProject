package com.wang.ssmtest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wang.ssmtest.bean.Employee;
import com.wang.ssmtest.bean.EmployeeExample;
import com.wang.ssmtest.bean.EmployeeExample.Criteria;
import com.wang.ssmtest.dao.EmployeeMapper;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeMapper employeeMapper;

	/**
	 * 查询所有员工
	 * @return
	 */
	public List<Employee> getAll() {
		// TODO Auto-generated method stub
		return employeeMapper.selectByExampleWithDept(null);
	}
	/**
	 * 保存新增员工信息
	 * @param employee
	 */
	public void saveEmp(Employee employee) {
		employeeMapper.insertSelective(employee);
		
	}
	/**
	 * 检验用户名是否存在
	 * @param empName
	 * @return true 可用 false 不可用
	 */
	public boolean checkUser(String empName) {	
		EmployeeExample example = new EmployeeExample();
		Criteria createCriteria = example.createCriteria();
		createCriteria.andEmpNameEqualTo(empName);
		long countByExample = employeeMapper.countByExample(example);
		return countByExample == 0;
	}
	/**
	 * 查询员工
	 * @param id
	 * @return
	 */
	public Employee getEmp(Integer id) {
		Employee employee = employeeMapper.selectByPrimaryKey(id);
		return employee;
	}
	/**
	 * 员工更新
	 * @param employee
	 */
	public void updateEmp(Employee employee) {
		employeeMapper.updateByPrimaryKeySelective(employee);
	}
	/**
	 * 删除员工
	 * 单一操作
	 * @param id
	 */
	public void deleteEmp(Integer id) {
		employeeMapper.deleteByPrimaryKey(id);
	}
	/**
	 * 删除员工
	 * 批量操作
	 * @param idList
	 */
	public void deleteEmpBatch(List<Integer> idList) {
		EmployeeExample example = new EmployeeExample();
		Criteria criteria = example.createCriteria();
		//delete from xxx where id in();
		criteria.andEmpIdIn(idList);
		employeeMapper.deleteByExample(example);
	}

	

}
