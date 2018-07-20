package com.syz.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.syz.dao.UserRoleMapper;
import com.syz.model.UserRole;
import com.syz.service.UserRoleService;


@Service(value = "userRoleService")
public class UserRoleServiceImpl implements UserRoleService {

	@Autowired
	private UserRoleMapper userRoleMapper;

	@Override
	public int add(UserRole userRole) {
		return userRoleMapper.insert(userRole);
	}
	
	@Override
	public List<UserRole> findAll() {
		return userRoleMapper.findAll();
	}
}
