package com.syz.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.syz.model.Role;
import com.syz.service.RoleService;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping(value = "/role")
public class RoleController {
	
	private Logger logger = LoggerFactory.getLogger(RoleController.class);
	
	@Autowired
	private RoleService roleService;

	@ApiOperation(value = "添加角色", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiImplicitParam(name = "role", value = "角色", required = true, dataType = "Role")
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public int add(@RequestBody Role role) {
		logger.debug("role:{}",role);
		return roleService.add(role);
	}

	@ApiOperation(value = "获取所有角色", httpMethod = "GET")
	@RequestMapping(value = "/findAll", method = RequestMethod.GET)
	public Object findAll() {
		return roleService.findAll();
	}
	
}