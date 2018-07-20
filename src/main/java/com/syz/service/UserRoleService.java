package com.syz.service;

import java.util.List;

import com.syz.model.UserRole;


public interface UserRoleService {

	int add(UserRole userRole);

	List<UserRole> findAll();
}