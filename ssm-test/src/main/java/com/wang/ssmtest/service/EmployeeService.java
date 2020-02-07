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
	 * ��ѯ����Ա��
	 * @return
	 */
	public List<Employee> getAll() {
		// TODO Auto-generated method stub
		return employeeMapper.selectByExampleWithDept(null);
	}
	/**
	 * ��������Ա����Ϣ
	 * @param employee
	 */
	public void saveEmp(Employee employee) {
		employeeMapper.insertSelective(employee);
		
	}
	/**
	 * �����û����Ƿ����
	 * @param empName
	 * @return true ���� false ������
	 */
	public boolean checkUser(String empName) {	
		EmployeeExample example = new EmployeeExample();
		Criteria createCriteria = example.createCriteria();
		createCriteria.andEmpNameEqualTo(empName);
		long countByExample = employeeMapper.countByExample(example);
		return countByExample == 0;
	}
	/**
	 * ��ѯԱ��
	 * @param id
	 * @return
	 */
	public Employee getEmp(Integer id) {
		Employee employee = employeeMapper.selectByPrimaryKey(id);
		return employee;
	}
	/**
	 * Ա������
	 * @param employee
	 */
	public void updateEmp(Employee employee) {
		employeeMapper.updateByPrimaryKeySelective(employee);
	}
	/**
	 * ɾ��Ա��
	 * ��һ����
	 * @param id
	 */
	public void deleteEmp(Integer id) {
		employeeMapper.deleteByPrimaryKey(id);
	}
	/**
	 * ɾ��Ա��
	 * ��������
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
