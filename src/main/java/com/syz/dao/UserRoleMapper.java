package com.syz.dao;

import java.util.List;

import com.syz.model.UserRole;

public interface UserRoleMapper {
    int insert(UserRole record);

    int insertSelective(UserRole record);
    
    List<UserRole> findAll();
}