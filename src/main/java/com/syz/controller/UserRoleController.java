package com.syz.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.syz.model.UserRole;
import com.syz.service.UserRoleService;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping(value = "/userRole")
public class UserRoleController {
	
	private Logger logger = LoggerFactory.getLogger(UserRoleController.class);
	
	@Autowired
	private UserRoleService userRoleService;

	@ApiOperation(value = "添加用户角色", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiImplicitParam(name = "userRole", value = "用户角色", required = true, dataType = "UserRole")
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public int add(@RequestBody UserRole userRole) {
		logger.debug("userRole:{}",userRole);
		return userRoleService.add(userRole);
	}

	@ApiOperation(value = "获取所有用户角色", httpMethod = "GET")
	@RequestMapping(value = "/findAll", method = RequestMethod.GET)
	public Object findAll() {
		return userRoleService.findAll();
	}
	
}