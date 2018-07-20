package com.syz.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.syz.model.User;
import com.syz.service.UserService;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * Created by Administrator on 2017/8/16.
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {
	
	private Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;

	@ApiOperation(value = "添加用户", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiImplicitParam(name = "user", value = "用户", required = true, dataType = "User")
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public int addUser(@RequestBody User user) {
		System.out.println("user:" + user);
		return userService.addUser(user);
	}

	@ApiOperation(value = "分页获取用户", httpMethod = "GET")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "pageNum", value = "分页的页码", required = true, dataType = "int",paramType="path"),
			@ApiImplicitParam(name = "pageSize", value = "每页文章数量", required = true, dataType = "int",paramType="path")
	})
	@RequestMapping(value = "/all/{pageNum}/{pageSize}", method = RequestMethod.GET)
	public Object findAllUser(@PathVariable("pageNum") int pageNum, @PathVariable("pageSize") int pageSize) {
		System.out.println("pageNum:" + pageNum + ",pageSize:" + pageSize);
		return userService.findAllUser(pageNum, pageSize);
	}
	@ApiOperation(value = "按名称查找用户", httpMethod = "POST")
	@ApiImplicitParam(name = "name", value = "名称", required = true, dataType = "String")
	@RequestMapping(value = "/findUserByName", method = RequestMethod.POST)
	public Object findUserByName(@RequestParam String name) {
		System.out.println("name:" + name);
		return userService.findUserByName(name);
	}
	
	@ApiOperation(value = "获取所有用户及角色", httpMethod = "GET")
	@RequestMapping(value = "/allUserAndRole", method = RequestMethod.GET)
	public List<User> selectAllUserAndRole() {
		return userService.selectAllUserAndRole();
	}
	
	@ApiOperation(value = "获取所有用户及部门", httpMethod = "GET")
	@RequestMapping(value = "/allUserAndDepartment", method = RequestMethod.GET)
	public List<User> selectAllUserAndDepartment() {
		return userService.selectAllUserAndDepartment();
	}
	
}