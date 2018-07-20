package com.syz.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.syz.dao.DepartmentMapper;
import com.syz.model.Department;
import com.syz.service.DepartmentService;


@Service(value = "departmentService")
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentMapper departmentMapper;

	@Override
	public int add(Department department) {

		return departmentMapper.insert(department);
	}
	
	@Override
	public List<Department> findAll() {
		return departmentMapper.findAll();
	}
}
