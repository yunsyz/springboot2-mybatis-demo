package com.syz.service;

import java.util.List;

import com.syz.model.Department;


public interface DepartmentService {

	int add(Department department);

	List<Department> findAll();
}