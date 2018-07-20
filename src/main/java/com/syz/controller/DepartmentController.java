package com.syz.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.syz.model.Department;
import com.syz.service.DepartmentService;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping(value = "/department")
public class DepartmentController {
	
	private Logger logger = LoggerFactory.getLogger(DepartmentController.class);
	
	@Autowired
	private DepartmentService departmentService;

	@ApiOperation(value = "添加部门", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiImplicitParam(name = "department", value = "部门", required = true, dataType = "Department")
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public int add(@RequestBody Department department) {
		logger.debug("department:{}",department);
		return departmentService.add(department);
	}

	@ApiOperation(value = "获取所有部门", httpMethod = "GET")
	@RequestMapping(value = "/findAll", method = RequestMethod.GET)
	public List<Department> findAll() {
		return departmentService.findAll();
	}
	
}