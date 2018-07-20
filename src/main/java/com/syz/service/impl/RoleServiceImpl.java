package com.syz.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.syz.dao.RoleMapper;
import com.syz.model.Role;
import com.syz.service.RoleService;


@Service(value = "roleService")
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleMapper roleMapper;

	@Override
	public int add(Role role) {

		return roleMapper.insert(role);
	}
	
	@Override
	public List<Role> findAll() {
		return roleMapper.findAll();
	}
}
