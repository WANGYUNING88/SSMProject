package com.wang.ssmtest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wang.ssmtest.bean.Department;
import com.wang.ssmtest.dao.DepartmentMapper;

@Service
public class DepartmentService {
	
	@Autowired
	private DepartmentMapper departmentMapper;
	
	public List<Department> getDepts() {	
		return departmentMapper.selectByExample(null);
	}

}
