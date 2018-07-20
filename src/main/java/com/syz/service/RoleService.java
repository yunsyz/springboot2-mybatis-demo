package com.syz.service;

import java.util.List;

import com.syz.model.Role;


public interface RoleService {

	int add(Role role);

	List<Role> findAll();
}